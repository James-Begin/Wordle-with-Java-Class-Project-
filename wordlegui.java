//import
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;


public class wordlegui extends JPanel 
{   // create label for text "Make a Guess"
    static Label l1 = new Label("");
    // create label for text "Please guess a 5 letter word"
    static Label l2 = new Label("");
    // make text field to input guess
    static TextField t1 = new TextField();
    // make button to submit guess
    static Button b1 = new Button("Guess!");
    
    // create list for if the guesses are correct or not
    static int[] guess = {1,1,1,2,2};
    
    // store previous answers of if the guesses are correct
    static int[] row1ans = {0,0,0,0,0};
    static int[] row2ans = {0,0,0,0,0};
    static int[] row3ans = {0,0,0,0,0};
    static int[] row4ans = {0,0,0,0,0};
    static int[] row5ans = {0,0,0,0,0};
    
    static String[] row1guess = {"g","","","",""};
    static String[] row2guess = {"","","","",""};
    static String[] row3guess = {"","","","",""};
    static String[] row4guess = {"","","","",""};
    static String[] row5guess = {"","","","",""};
    
    // create variable for what row to run at
    static int row = 1;
    
    public static void main(String[]args){
        
        wordlegui gui = new wordlegui();
        JFrame frame = new JFrame("Wordle");
        Scanner sc = new Scanner(System.in);
        
        // add all elements to frame
        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(b1);
        
        // set frame size and make it visible
        frame.setSize(1000,1000);
        frame.add(gui);
        frame.setVisible(true);
        
        // wait for guess one
        int x = sc.nextInt();
        row1ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        // wait for guess two
        x = sc.nextInt();
        row2ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        // wait for guess three
        x = sc.nextInt();
        row3ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        // wait for guess four
        x = sc.nextInt();
        row4ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        
        // wait for final guess
        x = sc.nextInt();
        row5ans = remap(guess);
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void paint (Graphics g){
        // add label for make a guess
        l1.setBounds(350,10,500,50);
        l1.setText("Make A Guess");
        l1.setFont(new Font("Serif", Font.PLAIN, 50));
        l1.setForeground(Color.BLUE);
        
        // add label for please guess a five letter word
        l2.setBounds(375,800,500,50);
        l2.setText("Please Guess a Five Letter Word!!!");
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        l2.setForeground(Color.RED);
        
        // add text box for user to input guess
        t1.setBounds(400,700,200,25);
        
        // add guess button
        b1.setBounds(475,725,50,50);
        
        // remake all the previous boxes with the stored answers and guesses.
        // at the start all of the answers are stored as 0 and all boxes
        // are gray.
        nextRow(row1guess, row1ans, g);
        row = row + 1;
        nextRow(row2guess, row2ans, g);
        row = row + 1;
        nextRow(row3guess, row3ans, g);
        row = row + 1;
        nextRow(row4guess, row4ans, g);
        row = row + 1;
        nextRow(row5guess, row5ans, g);
        row = 1;
    }
    public static void nextRow(String[] guess, int[] letters, Graphics g){
        // this block will create the answer squares with the correct 
        // information
        for(int i = 0; i<=400; i=i+100){
            
            
            if(letters[i/100] == 2){
                // if the letter is in the right spot and the right letter
                // make the box green
                g.setColor(Color.green);
            } else if(letters[i/100] == 1){
                // if the letter is correct but in the wrong spot
                // make the box yellow
                g.setColor(Color.yellow);
            } else{
                // if neither is correct, keep the box gray
                g.setColor(Color.gray);
            }
            
            // add the box
            g.fillRect((250+i),(100*row),90,90);
            
        }
        
    }
    
    public static int[] remap(int[] guess){
        
        // take the guess and store it in the answer log
        int[] ans = {0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            ans[i] = guess[i];
        }
        return ans;
    }
}
