public class Player {
	private int score;
	private int right;
	private int wrong;

	Player() {
		this.score = 0;
		this.right = 0;
		this.wrong = 0;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getRight() {
		return this.right;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}

	public int getWrong() {
		return this.wrong;
	}

	public String toString() {
		return "Player : Score ---> " + this.score + " , RightAnswers: " + right + " WrongAnswers: " + (-1 * wrong);
	}
}