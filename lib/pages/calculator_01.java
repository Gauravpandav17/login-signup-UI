package gaurav.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class calculator_01 {

    JFrame frame;
    JLabel label;
    Font font;
    JTextField name;
    JButton button[];
    double first = 0.0;
    double second = 0.0;
    double ans = 0.0;
    double A=0.0;

    calculator_01() {

        button = new JButton[100];
        for (int i = 0; i < 19; i++) 
        {
            button[i] = new JButton();
        }

        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(320, 565);
        frame.setLayout(null);

        label = new JLabel();
        label.setBounds(0, 100, 1000, 60);
        frame.add(label);

        font = new Font(Font.MONOSPACED, font.BOLD, 20);
        label.setFont(font);

        name = new JTextField();
        name.setBounds(10, 70, 200, 30);
        frame.add(name);

//          button = new JButton("AC");
//          frame.add(button);
//          button.setBounds(5, 150, 70, 70);
//          
//          button = new JButton("EARSE");
//          frame.add(button);
//          button.setBounds(80, 150, 70, 70);
//          
//          button = new JButton("%");
//          frame.add(button);
//          button.setBounds(155, 150, 70, 70);
//
//          button = new JButton("/");
//          frame.add(button);
//          button.setBounds(230, 150, 70, 70);
//
//          button = new JButton("7");
//          frame.add(button);
//          button.setBounds(5, 225, 70, 70);
//      
//          button = new JButton("8");
//          frame.add(button);
//          button.setBounds(80, 225, 70, 70);
//
//          button = new JButton("9");
//          frame.add(button);
//          button.setBounds(155, 225, 70, 70);
//
//          button = new JButton("*");
//          frame.add(button);
//          button.setBounds(230, 225, 70, 70);
//          
//          button = new JButton("4");
//          frame.add(button);
//          button.setBounds(5, 300, 70, 70);
//
//          button = new JButton("5");
//          frame.add(button);
//          button.setBounds(80, 300, 70, 70);
//
//          button = new JButton("6");
//          frame.add(button);
//          button.setBounds(155, 300, 70, 70);
//
//          button = new JButton("-");
//          frame.add(button);
//          button.setBounds(230, 300, 70, 70);
//
//          button = new JButton("1");
//          frame.add(button);
//          button.setBounds(5, 375, 70, 70);
//
//          button = new JButton("2");
//          frame.add(button);
//          button.setBounds(80, 375, 70, 70);
//          
//          button = new JButton("3");
//          frame.add(button);
//          button.setBounds(155, 375, 70, 70);
//          
//          button = new JButton("+");
//          frame.add(button);
//          button.setBounds(230, 375, 70, 70);
//          
//          button = new JButton("0");
//          frame.add(button);
//          button.setBounds(5, 450, 144, 70);
//                    
//          button = new JButton(".");
//          frame.add(button);
//          button.setBounds(155, 450, 70, 70);
//          
//          button = new JButton("=");
//          frame.add(button);
//          button.setBounds(230, 450, 70, 70);
//          
        set(0, 5, 150, 70, 70, "AC");
        set(1, 80, 150, 70, 70, "EARSE");
        set(2, 155, 150, 70, 70, "%");
        set(3, 230, 150, 70, 70, "/");
        set(4, 5, 225, 70, 70, "7");
        set(5, 80, 225, 70, 70, "8");
        set(6, 155, 225, 70, 70, "9");
        set(7, 230, 225, 70, 70, "*");
        set(8, 5, 300, 70, 70, "4");
        set(9, 80, 300, 70, 70, "5");
        set(10, 155, 300, 70, 70, "6");
        set(11, 230, 300, 70, 70, "-");
        set(12, 5, 375, 70, 70, "1");
        set(13, 80, 375, 70, 70, "2");
        set(14, 155, 375, 70, 70, "3");
        set(15, 230, 375, 70, 70, "+");
        set(16, 5, 450, 144, 70, "0");
        set(17, 155, 450, 70, 70, ".");
        set(18, 230, 450, 70, 70, "=");

    }

    public static void main(String[] args) {

        calculator_01 A = new calculator_01();
    }

    private void set(int i, int x, int y, int w, int h, String s) 
    {
        button[i].setBounds(x, y, w, h);
        button[i].setText(s);
        frame.add(button[i]);
        
       

        button[i].addActionListener((ActionEvent ae) -> {
            
            if (s.equals("AC")) 
            {
                label.setText("");
                A=0.0;
                first=0.0;
                second=0.0;
            } 
            else if (s.equals("EARSE")) 
            {
                label.setText(label.getText().substring(0, label.getText().length() - 1));
            }
            else if(s.equals("0"))
            {       
                if(label.getText().isEmpty())
                {
                    label.setText("0");                
                }   
                else if(label.getText().length()>=2 || !label.getText().startsWith(s))
                {
                    label.setText(label.getText().concat(s));
                }
            }     
            else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%"))
            {
                process(s);
            }
            else if(s.equals("="))
            {
                answer();        
            }
            else if (s.equals(".")) 
            {
                if (label.getText().isEmpty()) 
                {
                    label.setText("0.");
                } 
                else if (label.getText().contains(s)) 
                {
                    
                } 
                else 
                {
                    label.setText(label.getText().concat(s));
                }
            }
            
            else 
            {
                label.setText(label.getText().concat(s));
            }
        });
    }
    private void process(String s) 
    {   
        A=first;
        
        first = Double.parseDouble(label.getText());
        label.setText("");
        
        if(MyClass.plus)
        {
            first=A+first;
        }
        else if(MyClass.minus)
        {
            first=A-first;
        }
        
        
        if(s.equals("+"))
            {
                MyClass.plus=true;
            }
            else if(s.equals("-"))
            {
                MyClass.minus=true;
            }
            else if(s.equals("*"))
            {
                MyClass.maltiple=true;
            }
            else if(s.equals("/"))
            {
                MyClass.division=true;
            }
            else if(s.equals("%"))
             {
                 ans=first/100;
                 label.setText(""+ans);
             }
  
    }
    
    private void reset(){
        
        MyClass.plus=MyClass.minus=MyClass.maltiple=MyClass.division=false;
    }
    
    private void answer() 
    {
        second = Double.parseDouble(label.getText());
        
       if(MyClass.plus)
       {
           ans=first+second;
       }
       else if(MyClass.minus)
       {
           ans=first-second;
       }
       else if(MyClass.maltiple)
       {
           ans=first*second;
       }
       else if(MyClass.division)
       {
           ans=first/second;
       }
       label.setText(""+ans);
       reset();
    }
}
class MyClass
{
    static boolean plus = false;
    static boolean minus = false;
    static boolean maltiple = false; 
    static boolean division = false;
}
   