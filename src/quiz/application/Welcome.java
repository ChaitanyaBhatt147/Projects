package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener{
    
    JButton start,back;
    String name;
    Welcome(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+name +" to Java Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(247,64,25));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(30, 70, 700, 400);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Answer all questions: All questions in the quiz are compulsory. Make sure to provide an answer for each question." + "<br><br>" +
                "2. Time limit: There is a time limit for completing the quiz. Finish answering all questions within the given time frame." + "<br><br>" +
                "3. No cheating: Do not use any external resources or assistance while taking the quiz. The purpose is to test your knowledge and understanding." + "<br><br>" +
                "4. Single choice answers: Most questions will have multiple-choice options. Select the most appropriate answer by marking only one option." + "<br><br>" +
                "5. Read carefully: Read each question and all the available options carefully before selecting your answer. Pay attention to details and avoid rushing." + "<br><br>" +
                "6. Submitting answers: Once you have answered all the questions, submit your quiz by clicking the submit button. Note that you may not be able to make changes after submission." + "<br><br>" +
                "7. Honor system: Please adhere to the honor system and refrain from sharing answers or discussing the quiz questions with others until the quiz period is over." + "<br><br>" +
                "8. Enjoy and have fun: Remember, the quiz is an opportunity to test your knowledge and learn. Approach it with a positive attitude and enjoy the experience!" + "<br><br>" +
            "<html>"
        );

        add(rules);
        
        start = new JButton("Start");
        start.setBounds(500, 525, 100, 30);
        start.setBackground(new Color(247,64,25));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        back = new JButton("Back");
        back.setBounds(300, 525, 100, 30);
        back.setBackground(new Color(247,64,25));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900,650);
        setLocation(315, 125);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()== start){
            setVisible(false);
            new Quiz(name);
        }else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Welcome("User");
    }

}
