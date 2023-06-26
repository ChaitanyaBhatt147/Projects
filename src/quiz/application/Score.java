package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    
        Score(String userName,int score){

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
            Image oImage = i1.getImage();
            Image sImage = oImage.getScaledInstance(500, 400, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(sImage);
            JLabel image = new JLabel(i2);
            image.setBounds(0,175,500,400);
            add(image);

            JLabel heading = new JLabel("ThankYoy "+userName +" for playing Java Minds");
            heading.setBounds(75,30,700,30);
            heading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
            heading.setForeground(new Color(247,64,25));
            add(heading);

            JLabel lblScore = new JLabel("Your Score is: "+score);
            lblScore.setBounds(575,200,300,30);
            lblScore.setFont(new Font("Viner Hand ITC",Font.BOLD,24));
    //        lblScore.setForeground(new Color(247,64,25));
            add(lblScore);

            JButton playAgain = new JButton("Play Again");
            playAgain.setBounds(600,350,120,30);
            playAgain.setBackground(new Color(247,64,25));
            playAgain.setForeground(Color.white);
            playAgain.addActionListener(this);
            add(playAgain);

            setBounds(315,125,900,650);
            getContentPane().setBackground(Color.white);
            setLayout(null);
            setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Login();
    }   

        public static void main(String[] arg){
            new Score("User",0);
        }

}
