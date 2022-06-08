enum Status {
	OPEN, WIP, REVIEW, FIX, CLOSED;
}

class StandardSwitchDemo {

	public static void printNumberOfLetters() {
		int numberOfLetters = -1;

		Status status = Status.CLOSED;

		if (status == null) {
			System.out.println("Status null!");
		} else {
			switch (status) {
			case WIP:
			case FIX:
				numberOfLetters = 3;
				break;

			case OPEN:
				numberOfLetters = 4;
				break;

			case CLOSED:
			case REVIEW:
				numberOfLetters = 6;
				break;

			default:
				throw new IllegalStateException("Invalid status: " + status);
			}
		}
		System.out.println(numberOfLetters);
	}

}

class PatternMatchingSwitchDemo {

	@SuppressWarnings("preview")
	public static void printNumberOfLetters(String status) {

		switch (status) { // switch expression
		case null -> System.out.println("Status null!");
		case "WIP", "FIX" -> System.out.println(3); // arrow case labels
		case "OPEN" -> System.out.println(4);
		case "CLOSED", "REVIEW" -> System.out.println(6);

		default -> throw new IllegalStateException("Invalid status: " + status);
		}
	}

}

public class SwitchPatternMatching {
	public static void main(String[] args) {
		System.out.println("Demonstrating standard switch-case:: ");
		StandardSwitchDemo.printNumberOfLetters();
		System.out.println();

		System.out.println(
				"Demonstrating modern switch-case with switch expression, arrow case labels, and pattern matching:: ");
		PatternMatchingSwitchDemo.printNumberOfLetters(null);
		System.out.println();
	}
}