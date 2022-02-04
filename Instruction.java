
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class Instruction extends JFrame implements ActionListener{
	JLabel text,background,john, ethan;
	JButton back;
	JPanel panel;
	JTextArea area;
	JScrollPane scroll;
	public Instruction() {
		
		addWindowListener(new WindowAdapter() {//detects when user clicks x
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like you quit?","",JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
        ImageIcon j = new ImageIcon(getClass().getResource("/john.jpg"));
        Image image1 = j.getImage(); // make an Image object from the ImageIcon object
        Image newImage1 = image1.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // transform it
        j = new ImageIcon(newImage1);
        
        ImageIcon e = new ImageIcon(getClass().getResource("/ethan.png"));
        Image image2 = e.getImage(); // make an Image object from the ImageIcon object
        Image newImage2 = image2.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // transform it
        e = new ImageIcon(newImage2);
        
        ImageIcon img3 = new ImageIcon(getClass().getResource("/background.jpg"));
        Image image3 = img3.getImage(); // make an Image object from the ImageIcon object
        Image newImage3 = image3.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH); // transform it
        img3 = new ImageIcon(newImage3);
        background = new JLabel();
        background.setIcon(img3);
        add(background);
        background.setLayout(new FlowLayout());
        
        back = new JButton("Back");
        back.addActionListener(this);
        
        area = new JTextArea();
        area.setText("-Instructions-\n"
        		+ "-Click Play\n"
        		+ "-Click on the value of question you want!\n"
        		+ "-Answer with proper grammar\n"
        		+ "-Win or lose points based off of the value of question!\n"
        		+ "Made by John Luc and Ethan Sum");
        scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        area.setFont(new Font("Arial", Font.BOLD, 25));
		area.setForeground(Color.BLACK);
        background.add(scroll);
        background.add(back);
        john = new JLabel(j);
        ethan = new JLabel(e);
        background.add(john);
        background.add(ethan);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(background);
        setContentPane(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//goes back to main menu when back button is pressed
		MainMenu frame = new MainMenu();
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setVisible(false);
	}
}
