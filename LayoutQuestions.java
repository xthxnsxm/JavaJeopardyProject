
public class LayoutQuestions extends Question{//inherits from question class
private String question, answer;
private int questionNum;

	public LayoutQuestions(int points, int questionNum) {
		super(points);//calling question constructor
		this.questionNum = questionNum;
		assignQuestion();
	}
	public void assignQuestion() {
		if(questionNum == 0) {
			question = "True/False: Layouts are objects";
			answer = "True";
		}else if(questionNum==1) {
			question = "Fill in the blank: Complete a method that would apply a new FlowLayout to the object\nobject._________(new FlowLayout());";
			answer = "setLayout";
		}else if(questionNum==2) {
			question = "What is the name of the layout that stacks components on top of each other or in a row?";
			answer = "BoxLayout";
		}else if(questionNum==3) {
			question = "Fill in the blank: Complete the method that would stack components on top of each other.\npanel.setLayout(new BoxLayout(panel,_____.____))";
			answer = "BoxLayout.Y_AXIS";
		}else if(questionNum==4) {
			question = "The layout that divides the rectangle into 5 parts (North, South, West, East, and Center) is called?";
			answer = "BorderLayout";
		}
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}

}
