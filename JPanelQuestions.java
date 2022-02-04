
public class JPanelQuestions extends Question{//inherits from question
private String question, answer;
private int questionNum;

	public JPanelQuestions(int points, int questionNum) {
		super(points);//calling question constructor
		this.questionNum = questionNum;
		assignQuestion();
	}
	public void assignQuestion() {
		if(questionNum == 0) {
			question = "True/False: JPanels can hold components.";
			answer = "True";
		}else if(questionNum==1) {
			question = "True/False: JPanels can't hold other container objects.";
			answer = "False";
		}else if(questionNum==2) {
			question = "Fill in the bank: Given the JPanel object \"panel\", complete the method that would put the button object, \"button\", into the panel\npanel.___(button);";
			answer = "add";
		}else if(questionNum==3) {
			question = "What is the default layout manager for a JPanel?";
			answer = "FlowLayout";
		}else if(questionNum==4) {
			question = "Fill in the blank: Create a JPanel object with the name \"panel\"\n_____ panel = new ______();";
			answer = "JPanel";
		}
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}

}
