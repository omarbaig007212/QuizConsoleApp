public class Question extends Object {
	private static int count = 1;
	private int id;
	private String question;
	private String[] options;
	private int answer;

	public Question(String question) {
		this.id = count++;
		this.options = new String[5];
		this.question = question;
	}

	public Question(String question, int optionsNumber) {
		this.id = count++;
		this.question = question;
		this.options = new String[optionsNumber];
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int setOptions(String option, int index) {
		if (index > 0 && index <= options.length) {
			options[--index] = option;
			return 1;
		} else {
			System.out.println("Please set options's index between 1 and " + options.length);
			return -1;
		}
	}

	public String[] getOptions() {
		return options;
	}

	public int setAnswer(int answer) {
		if (answer > 0 && answer <= options.length) {
			this.answer = answer;
			return 1;
		} else {
			System.out.println("Please set answer between 1 and " + options.length);
			return -1;
		}
	}

	public int getAnswer() {
		return this.answer;
	}

	public String toString() {
		return "Question{ " + question + " id = " + id + " Options: [ " + options[0] + " , " + options[1] + " , "
				+ options[2] + " , " + options[3] + "], answer='" + answer + '\'' + '}';
	}

}
