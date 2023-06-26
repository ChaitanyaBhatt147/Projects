package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    
    String[][] questions = new String[10][5];
    String[][] currectAnswer = new String[10][2];
    String[][] userAnswer = new String[10][1];
    JLabel qno,question;
    ButtonGroup groupOption;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,submit,lifeline;
    public static int timer =20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String userName;
    
    Quiz(String userName){
        
        this.userName = userName;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/R.jpeg"));
        Image oImage = i1.getImage();
        Image sImage = oImage.getScaledInstance(1340, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(sImage);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1340,400);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(60, 435, 50, 30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qno);
        
        question = new JLabel();
        question.setBounds(120, 435, 800, 30);
        question.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(question);
        
        
/*  ==========================================================================================================================*/  
//Questions
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
//        Answers
        currectAnswer[0][1] = "JDB";
        currectAnswer[1][1] = "int";
        currectAnswer[2][1] = "java.util package";
        currectAnswer[3][1] = "Marker Interface";
        currectAnswer[4][1] = "Heap memory";
        currectAnswer[5][1] = "Remote interface";
        currectAnswer[6][1] = "import";
        currectAnswer[7][1] = "Java Archive";
        currectAnswer[8][1] = "java.lang.StringBuilder";
        currectAnswer[9][1] = "Bytecode is executed by JVM";
/*    ==========================================================================================================================*/

        opt1 = new JRadioButton();
        opt1.setBounds(100,505,805,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(100,545,805,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(100,585,805,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(100,625,805,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
        
        groupOption = new ButtonGroup();
        groupOption.add(opt1);
        groupOption.add(opt2);
        groupOption.add(opt3);
        groupOption.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(600,700,120,30);
        next.setBackground(new Color(247,64,25));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(100,700,120,30);
        lifeline.setBackground(new Color(247,64,25));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100,700,120,30);
        submit.setBackground(new Color(247,64,25));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);

        setBounds(100,20,1340,830);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    
    public void start(int count){
        qno.setText(" "+(count + 1)+".");
        question.setText(questions[count][0]);
        
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupOption.clearSelection();
    }
    
    public void paint (Graphics g){
        super.paint(g);
        
        String time ="Time Left " + timer +" seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD,25));
        
        if(timer > 0){
            g.drawString(time,950 , 455);
        }
        else{
            g.drawString("Times up!!",950 , 455);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 20;
        }else if(timer < 0){
            timer = 20;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            if(count == 9){
                if(groupOption.getSelection() == null){
                    userAnswer[count][0]="";
                }else{
                    userAnswer[count][0] = groupOption.getSelection().getActionCommand();
                }
                
                for(int i =0;i<userAnswer.length;i++){
                    if (userAnswer[i][0].equals(currectAnswer[i][1])){
                        score +=10;
                    }
                }
                setVisible(false);
                new Score(userName,score);
                
            }else{ 
                if(groupOption.getSelection() == null){
                    userAnswer[count][0]="";
                }else{
                    userAnswer[count][0] = groupOption.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
            
        }
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if(groupOption.getSelection() == null){
                userAnswer[count][0] = "";
            }else{
                userAnswer[count][0] = groupOption.getSelection().getActionCommand();
            }
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
            
        }else if(ae.getSource() == lifeline){
            
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else{
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }else{
            ans_given = 1;
            
            if(groupOption.getSelection() == null){
                userAnswer[count][0]="";
            }else{
                userAnswer[count][0] = groupOption.getSelection().getActionCommand();
            }

            for(int i =0;i<userAnswer.length;i++){
                if (userAnswer[i][0].equals(currectAnswer[i][1])){
                    score +=10;
                }
            }
            setVisible(false);
            new Score(userName,score);
        }
        
    }
    
    public static void main(String[] arg){
        new Quiz("User");
    }
    
}
