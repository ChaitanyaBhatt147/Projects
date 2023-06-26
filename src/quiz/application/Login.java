package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JButton rules,back;
    JTextField tfname;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/25703.jpg"));
        Image oImage = i1.getImage();
        Image sImage = oImage.getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(sImage);
        JLabel image = new JLabel(i2);
        image.setBounds(0, -10, 600, 500);
        add(image);

        JLabel heading = new JLabel("Java Minds");
        heading.setBounds(780, 75, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(247,64,25));
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(825, 160, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(247,64,25));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(745, 220, 300, 30);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        rules = new JButton("Rules");
        rules.setBounds(745, 300, 100, 30);
        rules.setBackground(new Color(247,64,25));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(945, 300, 100, 30);
        back.setBackground(new Color(247,64,25));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(200, 200);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
        
    }

        
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Welcome(name);
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }
        
}
