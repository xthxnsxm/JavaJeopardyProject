
public class JLabelQuestions extends Question{//inherits from question
private String question, answer;
private int questionNum;

	public JLabelQuestions(int points, int questionNum) {
		super(points);//calling question constructor
		this.questionNum = questionNum;
		assignQuestion();
	}
	public void assignQuestion() {
		if(questionNum == 0) {
			question = "Fill in the blank:  A JLabel is a _______ that simply displays text or images, or both text and images and can be added to a JPanel.";
			answer = "Component";
		}else if(questionNum==1) {
			question = "True or False: A JLabel by default is not transparent.";
			answer = "False";
		}else if(questionNum==2) {
			question = "Fill in the blank: Given the JLabel object, “label”, invoke a method to return the text displayed in the label\r\n"
					+ "\r\n"
					+ "label._______();\r\n"
					+ "";
			answer = "getText()";
		}else if(questionNum==3) {
			question = "True or False: A JLabel can only display text.";
			answer = "False";
		}else if(questionNum==4) {
			question = "Fill in the blank: Given the JLabel object, “label”, invoke a method to set the text displayed in the label\r\n"
					+ "\r\n"
					+ "label._______(“I love computer science!”);\r\n"
					+ "";
			answer = "setText";
		}
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setBackOfCard() {
		
	}

}
