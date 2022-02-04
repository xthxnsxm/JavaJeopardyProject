import javax.swing.*;
import javax.swing.border.*;

public class QuestionButton extends JButton{//my custom button which has my question object
private Question question;

	QuestionButton(int points, int row, int column){
		super();//calls button constructor 
		assignQuestion(row,column,points);//assigning questions based off row and column
		setIcon(question.getBackOfCard());//setting icon 
		setBorder(new EmptyBorder(0,0,0,0));//removing border
	}

	public Question getQuestion() {//returns the question object that each questionbutton has
		return question;
	}
	public void assignQuestion(int row, int column,int points) {
		if(column==0) {//first column is jframe questions
			question = new JFrameQuestions(points,row);
		}else if(column==1) {//second column is jpanel questions
			question = new JPanelQuestions(points,row);
		}else if(column==2) {//third column is jlabel questions
			question = new JLabelQuestions(points,row);
		}else if(column==3) {//fourth column is jbutton questions
			question = new JButtonQuestions(points,row);
		}else if(column==4) {//fifth column is layout questions
			question = new LayoutQuestions(points,row);
		}
	}
}
