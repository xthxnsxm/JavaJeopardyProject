import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Player{//player class 
private int points;
private int second;
private Timer timer;
private JLabel counter;
	public Player() {
		points = 0;//player starts with 0 points
    	second = 0;
    	counter = new JLabel("Time: ");
    	counter.setFont(new Font("Arial", Font.BOLD, 50));
    	counter.setForeground(Color.white);
    	startTimer();
    	timer.start();
	}
	public int getPoints() {
		return points;
	}
	public int getSeconds() {
		return second;
	}
	public JLabel getCounter() {//returns the updated label for timer
		return counter;
	}
	
	public void setPoints(int newPoints) {
		points = newPoints;
	}
    public void startTimer() {//timer
    	timer = new Timer(1000,new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			second++;
    			counter.setText("Time: "+second);
    		}
    	});
    }
}
