import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;


public class wordlegui extends JPanel
{
    static Label l1 = new Label("");
    static Label l2 = new Label("");
    static TextField t1 = new TextField();
    static Button b1 = new Button("Guess!");
    
    static int[] guess = {1,1,1,2,2};
    static int[] row1ans = {0,0,0,0,0};
    static int[] row2ans = {0,0,0,0,0};
    static int[] row3ans = {0,0,0,0,0};
    static int[] row4ans = {0,0,0,0,0};
    static int[] row5ans = {0,0,0,0,0};
    static int row = 1;
    public static void main(String[]args){
        wordlegui gui = new wordlegui();
        JFrame frame = new JFrame("Wordle");
        Scanner sc = new Scanner(System.in);
        
        //begin
        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(b1);
        frame.setSize(1000,1000);
        frame.add(gui);
        frame.setVisible(true);
        
        //guess 1
        int x = sc.nextInt();
        row1ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        //guess 2
        x = sc.nextInt();
        row2ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        //guess 3
        x = sc.nextInt();
        row3ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        //guess 4
        x = sc.nextInt();
        row4ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        //guess 5
        x = sc.nextInt();
        row5ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void paint (Graphics g){
        //change colors of correct squares
        l1.setBounds(350,10,500,50);
        l1.setText("Make A Guess");
        l1.setFont(new Font("Serif", Font.PLAIN, 50));
        
        t1.setBounds(400,700,200,25);
        
        b1.setBounds(475,725,50,50);
        
        l2.setBounds(475,10,500,50);
        l2.setText("Please Type A 5 Letter Word");
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        
        nextRow(row1ans, g);
        row = row + 1;
        nextRow(row2ans, g);
        row = row + 1;
        nextRow(row3ans, g);
        row = row + 1;
        nextRow(row4ans, g);
        row = row + 1;
        nextRow(row5ans, g);
        row = 1;
    }
    public static void nextRow(int[] letters, Graphics g){
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
    
    public static int[] remap(int[] guess){
        int[] ans = {0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            ans[i] = guess[i];
        }
        return ans;
    }
}
