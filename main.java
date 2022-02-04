import javax.swing.WindowConstants;

public class main{//main method

	public static void main(String[] args) {
		MainMenu frame = new MainMenu();//game starts off with main menu
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
}
