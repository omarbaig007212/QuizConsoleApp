import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class QuestionService {
	
	// Constants (Questions, Options, Answers)
	private static String Questions[] = { "Number of primitive data types in Java are?",
			"What is the size of float and double in java?",
			"Automatic type conversion is possible in which of the possible cases?", "Select the valid statement",
			"Which component is used to compile, debug and execute the java programs?" };

	private static String Options[][] = { { "6", "5", "8", "9" },
			{ "32 and 64", "32 and 32", "64 and 64", "64 and 32" },
			{ "Byte to int", "int to long", "Long to int", "Short to int" },
			{ "char []ch=new char[5]", "char []ch=new char(5)", "char []ch=new char()", "char []ch=new char[]" }, 
			{"JRE", "JIT","JDK","JVM"}};
	private static int Answers[] = { 3, 3, 2, 2, 3 };
	
	// Array of Question class object.
	private static Question[] questions;

	// Default Constructor.
	QuestionService() {
	}

	// Parametrized Constructor.
	QuestionService(int numberOfQuestion) {
		questions = new Question[numberOfQuestion];
		int index[] = generateRandomIndexes(numberOfQuestion);
		for (int i = 0; i < questions.length; i++) {
			int newIndex = index[i];
			questions[i] = new Question(Questions[newIndex], Options[newIndex].length);
			for (int j = 0; j < Options[newIndex].length; j++) {
				questions[i].setOptions(Options[newIndex][j], (j + 1));
			}
			questions[i].setAnswer(Answers[newIndex]);
		}
	}

	// Random index generator for Questions array.
	public int[] generateRandomIndexes(int len) {
		int index[] = new int[len];
		for (int i = 0; i < len; i++) {
			index[i] = i;
		}
		Random random = new Random();
		for (int i = len - 1; i > 0; i--) {
			int randomIndex = (random.nextInt(i + 1));
			int temp = index[randomIndex];
			index[randomIndex] = index[i];
			index[i] = temp;
		}
		System.out.println(Arrays.toString(index));
		return index;
	}

	public static void admin(int numberOfQuestions) {
		questions = new Question[numberOfQuestions];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < questions.length; i++) {
			System.out.println("-------------------- Question" + (i + 1) + " --------------------");
			System.out.println("Enter your question? ");
			String question = sc.nextLine();
			System.out.println("Enter the number you options you want to provide? ");
			int optionNumber = Integer.parseInt(sc.nextLine());
			questions[i] = new Question(question, optionNumber);
			for (int j = 0; j < optionNumber; j++) {
				System.out.print("Enter option " + (j + 1) + " : ");
				String option = sc.nextLine();
				System.out.println("Option : " + option);
				questions[i].setOptions(option, (j + 1));
			}
			System.out.println("Enter the correct option for question, (1 - " + optionNumber + ") . ");
			int answer = Integer.parseInt(sc.nextLine());
			questions[i].setAnswer(answer);
		}
	}

	public static void play() {
		Player player = new Player();
		int rightAnswer = 0;
		int wrongAnswer = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------WELCOME--------------------------");
		System.out.println("Your Current Score is : " + player.getScore());
		for (int i = 0; i < questions.length; i++) {
			System.out.println("-------------------- Question" + (i + 1) + " --------------------");
			System.out.println(questions[i].getQuestion());
			System.out.print("-------------------- Options --------------------\n");
			String[] currOptions = questions[i].getOptions();
			for (int j = 0; j < currOptions.length; j++) {
				System.out.println("[" + (j + 1) + ".]   " + currOptions[j] + " ");
			}
			System.out.println("Do you want to skip: y/n");
			char skip = ' ';
			while (!(skip == 'N' || skip == 'n' || skip == 'y' || skip == 'Y')) {
				skip = sc.next().charAt(0);
			}
			if (skip == 'N' || skip == 'n') {
				System.out.println("Enter your option (1 - " + currOptions.length + " )");
				int currAnswer = sc.nextInt();
				boolean isMatch = currAnswer == questions[i].getAnswer();
				if (isMatch) {
					System.out.println("Correct Answer! ");
					rightAnswer++;
				} else {
					System.out.println(
							"Wrong Answer! , the correct answer is: " + currOptions[questions[i].getAnswer() - 1]);
					wrongAnswer--;
				}
			}
			System.out.println("Your Current Score is : " + (rightAnswer + wrongAnswer));
		}
		player.setRight(rightAnswer);
		player.setWrong(wrongAnswer);
		player.setScore((rightAnswer + wrongAnswer));
		System.out.println("----------Your Results---------");
		System.out.println(player);
	}
}
