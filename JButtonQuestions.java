
public class JButtonQuestions extends Question{//inherits from question class
private String question, answer;
private int questionNum;

	public JButtonQuestions(int points, int questionNum) {
		super(points);//calling question constructor
		this.questionNum = questionNum;
		assignQuestion();//assign question
	}
	public void assignQuestion() {
		if(questionNum == 0) {
			question = "True/False: Buttons require ActionListeners to provide functionality.";
			answer = "True";
		}else if(questionNum==1) {
			question = "Fill in the blank: \n_______ button = new _______();";
			answer = "JButton";
		}else if(questionNum==2) {
			question = "What method extracts the command string from an event object?";
			answer = "getActionCommand";
		}else if(questionNum==3) {
			question = "True/False: This is a lambda function.\n  redButton.addActionListener( a -> {// register an anonymous function as a listener for redButton.\r\n"
					+ "	  getContentPane().setBackground( Color.red ); \r\n"
					+ "  }); ";
			answer = "True";
		}else if(questionNum==4) {
			question = "What interface must a button listener implement?";
			answer = "ActionListener";
		}
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}

}

