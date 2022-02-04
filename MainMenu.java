import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener{//main menu
	
    JButton play, instruction, exit;
    JLabel logo,background,playButton;
    JPanel buttons,logoPanel,contentPane;
    Graphics g;
    GameFrame frame;
    Instruction iframe;
    public MainMenu(){
		addWindowListener(new WindowAdapter() {//detects when user clicks x
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like you quit?","",JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		frame = new GameFrame();
		frame.setSize(1000,800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		iframe = new Instruction();
		iframe.setResizable(false);
		iframe.setSize(800,600);
		iframe.setLocationRelativeTo(null);
		iframe.setVisible(false);
		iframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
        ImageIcon playIcon = new ImageIcon(getClass().getResource("/playIcon3.png"));
        Image image3 = playIcon.getImage(); // make an Image object from the ImageIcon object
        Image newImage3 = image3.getScaledInstance(500, 200, Image.SCALE_SMOOTH); // transform it
        playIcon = new ImageIcon(newImage3);

        ImageIcon instructionIcon = new ImageIcon(getClass().getResource("/instructionIcon3.png"));
        Image image4 = instructionIcon.getImage(); // make an Image object from the ImageIcon object
        Image newImage4 = image4.getScaledInstance(500, 200, Image.SCALE_SMOOTH); // transform it
        instructionIcon = new ImageIcon(newImage4);

        ImageIcon exitIcon = new ImageIcon(getClass().getResource("/exitIcon.png"));
        Image image5 = exitIcon.getImage(); // make an Image object from the ImageIcon object
        Image newImage5 = image5.getScaledInstance(500, 200, Image.SCALE_SMOOTH); // transform it
        exitIcon = new ImageIcon(newImage5);

        play = new JButton(playIcon);
        play.setPreferredSize(new Dimension(440,120));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.addActionListener(this);
        
        instruction = new JButton(instructionIcon);
        instruction.setOpaque(false);
        instruction.setContentAreaFilled(false);
        instruction.setBorderPainted(false);
        instruction.setPreferredSize(new Dimension(440,120));
        instruction.addActionListener(this);
        
        exit = new JButton(exitIcon);
        exit.setPreferredSize(new Dimension(440,120));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(this);

        buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.Y_AXIS));
        buttons.add(play);
        buttons.add(instruction);
        buttons.add(exit);

        ImageIcon img = new ImageIcon(getClass().getResource("/jeopardy.png"));
        Image image = img.getImage(); // make an Image object from the ImageIcon object
        Image newImage = image.getScaledInstance(500, 200, Image.SCALE_SMOOTH); // transform it
        img = new ImageIcon(newImage);
        logo = new JLabel();
        logo.setIcon(img);
        logoPanel = new JPanel();
        logoPanel.add(logo);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/background.jpg"));
        Image image2 = img2.getImage(); // make an Image object from the ImageIcon object
        Image newImage2 = image2.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH); // transform it
        img2 = new ImageIcon(newImage2);
        background = new JLabel();
        background.setIcon(img2);
        add(background);
        background.setLayout(new FlowLayout());


        background.add(logo);
        background.add(play);
        background.add(instruction);
        background.add(exit);

        //frame properties
        setResizable(false);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		//exit button
		if(e.getSource().equals(exit)) {
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like you quit?","",JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		//instruction button
		else if(e.getSource().equals(instruction)) {
			iframe.setVisible(true);
			setVisible(false);
		}
		//play button
		else if(e.getSource().equals(play)) {
			frame.setVisible(true);
			setVisible(false);
		}
	}

}