import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame implements ActionListener{
QuestionButton[][] arr;
Player player;
JLabel points, background,title,timer;
JPanel panel1,panel2,panel3,panel4,panel5,hud,panelTop,panelLeft,panelBottom,panel;
JButton exit;
	public GameFrame() {
		addWindowListener(new WindowAdapter() {//detects when user clicks x
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like you quit?","",JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		arr = new QuestionButton[5][5];//making 2d array for buttons
	//instantiating panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		
		hud = new JPanel();
		panelTop = new JPanel();
		
		panelLeft = new JPanel();
		panelBottom = new JPanel();
		panel = new JPanel();
	//letting the background show
		panelTop.setOpaque(false);
		panelBottom.setOpaque(false);
		panelLeft.setOpaque(false);
		panelBottom.setOpaque(false);
		panelTop.setOpaque(false);
		panel.setOpaque(false);
	//title picture
		title = new JLabel(new ImageIcon(getClass().getResource("jeopardy.png")));
	//layouts for panels
		panelBottom.setLayout(new BoxLayout(panelBottom,BoxLayout.X_AXIS));	
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
		panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
		panel5.setLayout(new BoxLayout(panel5,BoxLayout.Y_AXIS));
		
		panelBottom.add(panelLeft);
		panel.add(panelBottom);
		player = new Player();
		timer = player.getCounter();
		points = new JLabel("Points: " + player.getPoints());
		points.setFont(new Font("Arial", Font.BOLD, 50));
		points.setForeground(Color.WHITE);
		
		
	//subtitle of each category
		panel1.add(new JLabel("JFrame"));
		panel2.add(new JLabel("JPanel"));
		panel3.add(new JLabel("JLabel"));
		panel4.add(new JLabel("JButton"));
		panel5.add(new JLabel("Layout"));
		
		//filling the 2d array with QuestionButton objects 
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[i].length;j++) {
				arr[i][j] = new QuestionButton((i+1) * 100, i,j);
				arr[i][j].addActionListener(this);
				arr[i][j].setActionCommand("" + (i*5 + j));//button labeling
			}
		}
		//filling buttons into panels
		for(int i = 0; i < 5;i++) {
			panel1.add(arr[i][0]);
			panel2.add(arr[i][1]);
			panel3.add(arr[i][2]);
			panel4.add(arr[i][3]);
			panel5.add(arr[i][4]);
		}
		
		panelLeft.add(panel1);
		panelLeft.add(panel2);
		panelLeft.add(panel3);
		panelLeft.add(panel4);
		panelLeft.add(panel5);
		
		exit = new JButton();
        ImageIcon exitIcon = new ImageIcon(getClass().getResource("/exitIcon.png"));
        Image image5 = exitIcon.getImage(); // make an Image object from the ImageIcon object
        Image newImage5 = image5.getScaledInstance(300, 120, Image.SCALE_SMOOTH); // transform it
        exitIcon = new ImageIcon(newImage5);
        exit = new JButton(exitIcon);
        exit.addActionListener(this);
        exit.setPreferredSize(new Dimension(440,120));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        
        ImageIcon img2 = new ImageIcon(getClass().getResource("/background.jpg"));
        Image image2 = img2.getImage(); // make an Image object from the ImageIcon object
        Image newImage2 = image2.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH); // transform it
        img2 = new ImageIcon(newImage2);
        background = new JLabel();
        background.setIcon(img2);
        add(background);
        background.setLayout(new FlowLayout());
        
        hud = new JPanel();
        hud.setLayout(new BoxLayout(hud,BoxLayout.Y_AXIS));
        title.setAlignmentX(CENTER_ALIGNMENT);
        points.setAlignmentX(CENTER_ALIGNMENT);
        timer.setAlignmentX(CENTER_ALIGNMENT);
        exit.setAlignmentX(CENTER_ALIGNMENT);
        hud.add(title);
        hud.add(panel);
        hud.add(points);
        hud.add(timer);
        hud.add(exit);
        hud.setOpaque(false);
        background.add(hud);
	}
	public void endGame() {//when game ends it will provide a breakdown of time and score
		JOptionPane.showMessageDialog(null, "Congratulations! You finished the game with a score of " + player.getPoints() + " in " + player.getSeconds() +" seconds.", "Thank you for playing!",JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {//exit button
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like you quit?","",JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}else {//any question button
			int row = Integer.parseInt(e.getActionCommand())/5;//determines which row the question is in
			int column = (Integer.parseInt(e.getActionCommand())%5);//determines which column the question is in

	        String x = JOptionPane.showInputDialog(arr[row][column].getQuestion().getQuestion());//asks question
	        try {
	            if(x.equals(arr[row][column].getQuestion().getAnswer())) {//if answer is correct
	            	player.setPoints(player.getPoints()+arr[row][column].getQuestion().getPoints());//add points
	            	points.setText("Points: "+player.getPoints());//updating label
	            }else {//if answer is wrong
	            	player.setPoints(player.getPoints()-arr[row][column].getQuestion().getPoints());//subtracting points
	            	if(player.getPoints()<0) {//makes sure the points don't go below zero
	            		player.setPoints(0);
	            	}
	            	points.setText("Points: "+player.getPoints());//update label
	            }
	            arr[row][column].setEnabled(false);//disable button
	        }
	        catch(Exception err) {//if the answer is null
	        	player.setPoints(player.getPoints()-arr[row][column].getQuestion().getPoints());//subtract points
	        	if(player.getPoints()<0) {
	        		player.setPoints(0);
	        	}
	        	points.setText("Points: "+player.getPoints());
	        	arr[row][column].setEnabled(false);
	        }
	        arr[row][column].getQuestion().answered();//updates number of answered questions
	        if(arr[row][column].getQuestion().getAnswered()==25) {//if answered questions equal 25
	        	endGame();
	        }
		}


	}

}