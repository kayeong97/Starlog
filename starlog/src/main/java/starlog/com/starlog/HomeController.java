package starlog.com.starlog;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import starlog.com.starlog.domain.DailyRecord;
import starlog.com.starlog.domain.Goal;
import starlog.com.starlog.domain.Mood;
import starlog.com.starlog.domain.StarlogUser;
import starlog.com.starlog.domain.UserRole;
import starlog.com.starlog.service.ConstellationService;
import starlog.com.starlog.service.DailyRecordService;
import starlog.com.starlog.service.GoalService;
import starlog.com.starlog.service.RoutineService;
import starlog.com.starlog.service.UserService;

@Controller
public class HomeController {

	private final UserService userService;
	private final GoalService goalService;
	private final DailyRecordService dailyRecordService;
	private final ConstellationService constellationService;
	private final RoutineService routineService;

	public HomeController(UserService userService, GoalService goalService, DailyRecordService dailyRecordService,
			ConstellationService constellationService, RoutineService routineService) {
		this.userService = userService;
		this.goalService = goalService;
		this.dailyRecordService = dailyRecordService;
		this.constellationService = constellationService;
		this.routineService = routineService;
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(
			@RequestParam String email,
			@RequestParam String nickname,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
			HttpSession session,
			Model model
	) {
		try {
			StarlogUser user = userService.register(email, nickname, username, password, birthDate);
			session.setAttribute("loginUserId", user.getId());
			return "redirect:/dashboard";
		} catch (IllegalArgumentException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "signup";
		}
	}

	@PostMapping("/login")
	public String login(
			@RequestParam String username,
			@RequestParam String password,
			HttpSession session,
			Model model
	) {
		Optional<StarlogUser> user = userService.login(username, password);
		if (user.isEmpty()) {
			model.addAttribute("errorMessage", "아이디 또는 비밀번호를 확인해주세요.");
			return "login";
		}
		session.setAttribute("loginUserId", user.get().getId());
		return "redirect:/dashboard";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		StarlogUser user = requireUser(session);
		if (user == null) {
			return "redirect:/login";
		}
		fillUserModel(model, user);
		model.addAttribute("goals", goalService.recentGoals(user.getId()));
		model.addAttribute("recordCount", dailyRecordService.countByUser(user.getId()));

		Object starEarned = session.getAttribute("starEarned");
		if (starEarned != null) {
			model.addAttribute("starEarned", starEarned);
			session.removeAttribute("starEarned");
		}
		return "dashboard";
	}

	@GetMapping("/goals")
	public String goals(
			@RequestParam(required = false) Long editId,
			HttpSession session,
			Model model
	) {
		StarlogUser user = requireUser(session);
		if (user == null) {
			return "redirect:/login";
		}
		fillUserModel(model, user);
		model.addAttribute("goals", goalService.findAllByUser(user.getId()));
		model.addAttribute("editGoalRoutines", List.of());
		if (editId != null) {
			goalService.findById(editId, user.getId()).ifPresent(g -> {
				model.addAttribute("editGoal", g);
				model.addAttribute("editGoalRoutines", routineService.findByGoal(g.getId()));
			});
		}
		return "goals";
	}

	@PostMapping("/goals")
	public String createGoal(
			@RequestParam String title,
			@RequestParam String category,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate targetDate,
			@RequestParam(required = false, defaultValue = "") String description,
			@RequestParam(required = false) List<String> routineNames,
			HttpSession session,
			Model model
	) {
		Optional<StarlogUser> user = currentUser(session);
		if (user.isEmpty()) {
			return "redirect:/login";
		}
		try {
			Goal goal = goalService.create(user.get(), title, category, targetDate, description);
			routineService.replaceGoalRoutines(user.get().getId(), goal.getId(), routineNames);
			return "redirect:/goals";
		} catch (RuntimeException ex) {
			model.addAttribute("errorMessage", "목표를 저장하지 못했습니다: " + ex.getMessage());
			fillUserModel(model, user.get());
			model.addAttribute("goals", goalService.findAllByUser(user.get().getId()));
			model.addAttribute("editGoalRoutines", List.of());
			return "goals";
		}
	}

	@PostMapping("/goals/{id}")
	public String updateGoal(
			@PathVariable Long id,
			@RequestParam String title,
			@RequestParam String category,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate targetDate,
			@RequestParam(required = false, defaultValue = "") String description,
			@RequestParam(required = false) List<String> routineNames,
			HttpSession session,
			Model model
	) {
		Optional<StarlogUser> user = currentUser(session);
		if (user.isEmpty()) {
			return "redirect:/login";
		}
		try {
			Goal goal = goalService.update(id, user.get().getId(), title, category, targetDate, description);
			routineService.replaceGoalRoutines(user.get().getId(), goal.getId(), routineNames);
			goalService.recalculateAllForUser(user.get().getId());
			return "redirect:/goals";
		} catch (RuntimeException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			fillUserModel(model, user.get());
			model.addAttribute("goals", goalService.findAllByUser(user.get().getId()));
			goalService.findById(id, user.get().getId()).ifPresent(g -> {
				model.addAttribute("editGoal", g);
				model.addAttribute("editGoalRoutines", routineService.findByGoal(g.getId()));
			});
			return "goals";
		}
	}

	@GetMapping("/map")
	public String map(HttpSession session, Model model) {
		StarlogUser user = requireUser(session);
		if (user == null) {
			return "redirect:/login";
		}
		LocalDate today = LocalDate.now();
		fillUserModel(model, user);

		String monthLabel = today.getYear() + "년 " + today.getMonthValue() + "월";
		model.addAttribute("monthLabel", monthLabel);
		model.addAttribute("monthRecordCount", dailyRecordService.countByUserAndMonth(user.getId(), today));

		List<DailyRecord> records = dailyRecordService.recordsInMonth(user.getId(), today);
		model.addAttribute("records", records);

		LocalDate firstDay = today.withDayOfMonth(1);
		int leadingBlanks = firstDay.getDayOfWeek().getValue() % 7;
		int daysInMonth = today.lengthOfMonth();

		Set<Integer> recordedDays = new HashSet<>();
		for (DailyRecord r : records) {
			recordedDays.add(r.getRecordDate().getDayOfMonth());
		}

		List<Integer> calendarCells = new ArrayList<>();
		for (int i = 0; i < leadingBlanks; i++) {
			calendarCells.add(null);
		}
		for (int d = 1; d <= daysInMonth; d++) {
			calendarCells.add(d);
		}

		model.addAttribute("calendarCells", calendarCells);
		model.addAttribute("recordedDays", recordedDays);
		model.addAttribute("todayDay", today.getDayOfMonth());

		return "map";
	}

	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {
		StarlogUser user = requireUser(session);
		if (user == null) {
			return "redirect:/login";
		}
		fillUserModel(model, user);
		model.addAttribute("recordCount", dailyRecordService.countByUser(user.getId()));
		model.addAttribute("recentRecords", dailyRecordService.recentRecords(user.getId()));
		return "profile";
	}

	@GetMapping("/record")
	public String record(HttpSession session, Model model) {
		StarlogUser user = requireUser(session);
		if (user == null) {
			return "redirect:/login";
		}
		fillUserModel(model, user);
		model.addAttribute("routines", routineService.findActiveByUser(user.getId()));
		model.addAttribute("today", LocalDate.now().toString());
		return "record";
	}

	@PostMapping("/record")
	public String createRecord(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate recordDate,
			@RequestParam String content,
			@RequestParam Mood mood,
			@RequestParam(required = false) List<Long> routineIds,
			HttpSession session,
			Model model
	) {
		Optional<StarlogUser> user = currentUser(session);
		if (user.isEmpty()) {
			return "redirect:/login";
		}
		try {
			DailyRecord record = dailyRecordService.create(user.get(),
					recordDate == null ? LocalDate.now() : recordDate, content, mood);
			routineService.saveChecks(record, routineIds);
			goalService.recalculateAllForUser(user.get().getId());
			session.setAttribute("starEarned", 1);
			return "redirect:/dashboard";
		} catch (IllegalArgumentException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			fillUserModel(model, user.get());
			model.addAttribute("routines", routineService.findActiveByUser(user.get().getId()));
			model.addAttribute("today", LocalDate.now().toString());
			return "record";
		}
	}

	@GetMapping("/admin")
	public String admin(HttpSession session, Model model) {
		StarlogUser user = requireUser(session);
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != UserRole.ADMIN) {
			return "redirect:/dashboard";
		}
		fillUserModel(model, user);
		model.addAttribute("allUsers", userService.findAll());
		model.addAttribute("totalUsers", userService.count());
		model.addAttribute("totalRecords", dailyRecordService.countAll());
		return "admin";
	}

	private void fillUserModel(Model model, StarlogUser user) {
		model.addAttribute("user", user);
		model.addAttribute("constellation", constellationService.progress(user.getStarCount(), user.getBirthDate()));
	}

	private StarlogUser requireUser(HttpSession session) {
		return currentUser(session).orElse(null);
	}

	private Optional<StarlogUser> currentUser(HttpSession session) {
		Object userId = session.getAttribute("loginUserId");
		if (!(userId instanceof Long id)) {
			return Optional.empty();
		}
		return userService.findById(id);
	}
}
