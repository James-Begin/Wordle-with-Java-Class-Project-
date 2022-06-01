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
    // create label for previous guesses text
    static Label l3 = new Label("");
    // create labels for previous guesses
    static Label l4 = new Label("");
    static Label l5 = new Label("");
    static Label l6 = new Label("");
    static Label l7 = new Label("");
    static Label l8 = new Label("");
    
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
    
    static String[] preguess = {"","","","",""};
    
    static String placeText = "";
    
    // create variable for what row to run at
    static int row = 1;
    
    static wordlegui gui = new wordlegui();
    static JFrame frame = new JFrame("Wordle");
    static Scanner sc = new Scanner(System.in);
    public static void main(String[]args){
       // add all elements to frame
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(t1);
        frame.add(b1);
        
        // set frame size and make it visible
        frame.setSize(1000,1000);
        frame.add(gui);
        frame.setVisible(true);
        
        // wait for guess one
        int x = sc.nextInt();
        row1ans = guess(1,row1ans);
        
        // wait for guess two
        x = sc.nextInt();
        row2ans = guess(2,row2ans);
        
        // wait for guess three
        x = sc.nextInt();
        row3ans = guess(3,row3ans);
        
        // wait for guess four
        x = sc.nextInt();
        row4ans = guess(4,row4ans);
        
        // wait for final guess
        x = sc.nextInt();
        row5ans = guess(5,row5ans);
    }
    public static void addlabel(Label l, String text, int x, int y, int sizex, int sizey, int fontsize){
        l.setBounds(x,y,sizex,sizey);
        l.setText(text);
        l.setFont(new Font("Serif", Font.PLAIN, fontsize));
    }
    public void paint (Graphics g){
        // add label for make a guess
        placeText = "Make A Guess";
        addlabel(l1,placeText,350,10,500,50,50);
        l1.setForeground(Color.BLUE);
        
        // add label for please guess a five letter word
        placeText = "Please Guess a Five Letter Word!!!";
        addlabel(l2,placeText,375,800,500,50,20);
        l2.setForeground(Color.RED);
        
        l3.setBounds(10,200,200,25);
        placeText="Previous Guess:";
        l3.setFont(new Font("Serif", Font.PLAIN, 30));
        l3.setForeground(Color.GREEN);
        addlabel(l3,placeText,10,200,200,25,30);
        // add text box for user to input guess
        t1.setBounds(400,700,200,25);
        
        // add guess button
        b1.setBounds(475,725,50,50);
        
        // remake all the previous boxes with the stored answers and guesses.
        // at the start all of the answers are stored as 0 and all boxes
        // are gray.
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
        
        l4.setBounds(10,230,150,15);
        l4.setText(preguess[0]);
        l4.setFont(new Font("Serif", Font.PLAIN, 20));
        l4.setForeground(Color.RED);
        
        l5.setBounds(10,250,150,15);
        l5.setText(preguess[1]);
        l5.setFont(new Font("Serif", Font.PLAIN, 20));
        l5.setForeground(Color.RED);
        
        l6.setBounds(10,270,150,15);
        l6.setText(preguess[2]);
        l6.setFont(new Font("Serif", Font.PLAIN, 20));
        l6.setForeground(Color.RED);
        
        l7.setBounds(10,290,150,15);
        l7.setText(preguess[3]);
        l7.setFont(new Font("Serif", Font.PLAIN, 20));
        l7.setForeground(Color.RED);
        
        l8.setBounds(10,310,150,15);
        l8.setText(preguess[4]);
        l8.setFont(new Font("Serif", Font.PLAIN, 20));
        l8.setForeground(Color.RED);
        
    }
    
    public static int[] guess(int guessnum, int[] rowans){
        rowans = remap(guess);
        preguess[guessnum-1] = "WWWWW";
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        return rowans;
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
