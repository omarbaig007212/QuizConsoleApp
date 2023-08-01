import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// create a quiz (5 question)
		// create 5 questions from user
		// QuestionService : create, get, delete,
		// Array - String

		// Roles (Done)
		// Negative marking (Done)
		// realtime score (Done)
		// play again (different question) (Done)
		// skip question (Done)
		// set timer

		System.out.println("--------------------QUIZ------------------");
		Scanner sc = new Scanner(System.in);
		QuestionService service = new QuestionService(5);

		while (true) {
			System.out.println("1. Admin\n2. Player");
			int option = sc.nextInt();
			if (option == 1) {
				service.admin(5);
			} else if (option == 2) {
				service.play();
			}

			System.out.println("------------------------------------------");
			char skip = ' ';
			while (!(skip == 'N' || skip == 'n' || skip == 'y' || skip == 'Y')) {
				System.out.println("Play Again? Y/N");
				skip = sc.next().charAt(0);
			}
			if (skip == 'n' || skip == 'N') {
				break;
			}
		}
		System.out.println("-------Thank You!----------");
	}
}