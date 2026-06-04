package starlog.com.starlog.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ConstellationService {

	private static final List<ConstellationView> ZODIAC = List.of(
			new ConstellationView("양자리", List.of(point(14, 56), point(32, 42), point(48, 40), point(66, 30), point(82, 20))),
			new ConstellationView("황소자리", List.of(point(12, 28), point(28, 40), point(44, 48), point(60, 42), point(78, 30), point(52, 66))),
			new ConstellationView("쌍둥이자리", List.of(point(28, 18), point(34, 38), point(30, 60), point(24, 78), point(62, 18), point(58, 40), point(64, 62), point(70, 80))),
			new ConstellationView("게자리", List.of(point(22, 48), point(40, 32), point(58, 38), point(72, 56), point(48, 68))),
			new ConstellationView("사자자리", List.of(point(16, 64), point(34, 44), point(46, 24), point(62, 20), point(76, 34), point(68, 58), point(44, 70))),
			new ConstellationView("처녀자리", List.of(point(12, 30), point(30, 42), point(48, 36), point(64, 50), point(82, 46), point(54, 68), point(34, 78))),
			new ConstellationView("천칭자리", List.of(point(20, 62), point(36, 38), point(50, 28), point(66, 38), point(80, 62), point(36, 68), point(66, 68))),
			new ConstellationView("전갈자리", List.of(point(16, 20), point(30, 34), point(42, 50), point(54, 62), point(70, 72), point(84, 62), point(76, 48))),
			new ConstellationView("사수자리", List.of(point(18, 68), point(36, 54), point(54, 42), point(72, 26), point(64, 48), point(78, 54), point(44, 72))),
			new ConstellationView("염소자리", List.of(point(14, 40), point(32, 58), point(52, 64), point(74, 52), point(84, 28), point(58, 36))),
			new ConstellationView("물병자리", List.of(point(12, 34), point(28, 44), point(44, 34), point(60, 44), point(76, 34), point(24, 66), point(42, 76), point(60, 66))),
			new ConstellationView("물고기자리", List.of(point(20, 26), point(34, 40), point(48, 54), point(62, 40), point(78, 26), point(48, 74)))
	);

	public ConstellationProgress progress(int starCount, LocalDate birthDate) {
		ConstellationView view = birthDate == null
				? ZODIAC.get(Math.floorMod(starCount, ZODIAC.size()))
				: ZODIAC.get(zodiacIndex(birthDate));
		int n = view.points().size();
		int filled;
		if (n == 0) {
			filled = 0;
		} else {
			int remainder = starCount % n;
			filled = (remainder == 0 && starCount > 0) ? n : remainder;
		}
		int percent = n == 0 ? 0 : (int) Math.round((filled * 100.0) / n);
		return new ConstellationProgress(view.name(), view.points(), filled, percent);
	}

	private static StarPoint point(int x, int y) {
		return new StarPoint(x, y);
	}

	private static int zodiacIndex(LocalDate date) {
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return 0;
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return 1;
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) return 2;
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) return 3;
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return 4;
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return 5;
		if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return 6;
		if ((month == 10 && day >= 23) || (month == 11 && day <= 22)) return 7;
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) return 8;
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return 9;
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return 10;
		return 11;
	}

	public record StarPoint(int x, int y) {
	}

	public record ConstellationView(String name, List<StarPoint> points) {
	}

	public record ConstellationProgress(String name, List<StarPoint> points, int filledCount, int percent) {
	}
}
