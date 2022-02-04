import java.awt.Image;
import javax.swing.ImageIcon;
public abstract class Question {//abstract question class
	

	private int worth;
	private static int numOfQuestionsAnswered = 0;
	ImageIcon backOfCard;
	public Question(int points) {
		worth = points;
		backOfCard = new ImageIcon(getClass().getResource(this.worth + ".jpg"));//gets picture of jeopardy card
		Image image = backOfCard.getImage();
		Image newImage = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);//controls size of button
		backOfCard = new ImageIcon(newImage);
	
	}
	public int getPoints() {
		return worth; //returns worth of question
	}
	
	public int getAnswered() {
		return numOfQuestionsAnswered;//returns how many questions have been answered
	}
	public void answered() {
		numOfQuestionsAnswered++;//increases the number of questions answered
	}
	public ImageIcon getBackOfCard() {
		return backOfCard;
	}
	//abstract methods
	abstract String getAnswer();
	abstract String getQuestion();

}
