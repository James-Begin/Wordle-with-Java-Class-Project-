import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class wordlegui extends JPanel
{
    int[] letters = {2,2,1,1,0};
    static int row = 1;
    boolean runonce = false;
    public static void main(String[]args){
        wordlegui gui = new wordlegui();
        JFrame frame = new JFrame("Wordle");
        frame.setSize(1000,1000);
        frame.add(gui);
        frame.setVisible(true);
    }
    public void paint (Graphics g){
        if(runonce = false){
            //runonce = true;
            for(int i = 0; i<=400; i=i+100){
                //choose color the squares
                g.setColor(Color.gray);
                //create wordle squares
                g.fillRect(250,(100+i),90,90);
                g.fillRect(350,(100+i),90,90);
                g.fillRect(450,(100+i),90,90);
                g.fillRect(550,(100+i),90,90);
                g.fillRect(650,(100+i),90,90);
            }
        }
        
        //change colors of correct squares
        for(int i = 0; i<=400; i=i+100){
            if(letters[i/100] == 2){
                g.setColor(Color.green);
            } else if(letters[i/100] == 1){
                g.setColor(Color.yellow);
            } else{
                g.setColor(Color.gray);
            }
            g.fillRect((250+i),(100*row),90,90);
        }
    }
}
