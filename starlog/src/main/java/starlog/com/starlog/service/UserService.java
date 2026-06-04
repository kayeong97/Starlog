package starlog.com.starlog.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starlog.com.starlog.domain.StarlogUser;
import starlog.com.starlog.repository.StarlogUserRepository;

@Service
public class UserService {

	private final StarlogUserRepository userRepository;
	private final PasswordHashService passwordHashService;

	public UserService(StarlogUserRepository userRepository, PasswordHashService passwordHashService) {
		this.userRepository = userRepository;
		this.passwordHashService = passwordHashService;
	}

	@Transactional
	public StarlogUser register(String email, String nickname, String username, String password, LocalDate birthDate) {
		if (userRepository.existsByEmail(email)) {
			throw new IllegalArgumentException("이미 가입된 이메일입니다.");
		}
		if (userRepository.existsByUsername(username)) {
			throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
		}
		return userRepository.save(new StarlogUser(email, nickname, username, passwordHashService.hash(password), birthDate));
	}

	@Transactional(readOnly = true)
	public Optional<StarlogUser> login(String username, String password) {
		return userRepository.findByUsername(username)
				.filter(user -> passwordHashService.matches(password, user.getPasswordHash()));
	}

	@Transactional(readOnly = true)
	public Optional<StarlogUser> findById(Long id) {
		return userRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<StarlogUser> findAll() {
		return userRepository.findAll();
	}

	public long count() {
		return userRepository.count();
	}
}
