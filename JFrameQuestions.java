
public class JFrameQuestions extends Question{//inherits from question
private String question, answer;
private int questionNum;

	public JFrameQuestions(int points, int questionNum) {
		super(points);//calling question constructor
		this.questionNum = questionNum;
		assignQuestion();
	}
	public void assignQuestion() {
		if(questionNum == 0) {
			//assign question and question answer here
			question = "True/False: JFrame is a container object.";
			answer = "True";
		}else if(questionNum==1) {
			question = "Fill in the blank: Create a frame object with the name frame.\n JFrame frame = new _______();";
			answer = "JFrame";
		}else if(questionNum==2) {
			question = "Fill in the blank: Given the frame object, \"frame\", invoke a method that would make the frame visible.\nframe.setVisible(____);";
			answer = "true";
		}else if(questionNum==3) {
			question = "Fill in the blank: Given the frame object, \"frame\", complete the method that would center the location of the frame.\n frame.setLocationRelativeTo(____);";
			answer = "null";
		}else if(questionNum==4) {
			question = "Fill in the blank: Given the frame object, \"frame\", complete the method that would make the frame close upon clicking the \"close\" button of the frame\nframe.set______CloseOperation(WindowConstants.EXIT_ON_CLOSE);";
			answer = "Default";
		}
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}

}
