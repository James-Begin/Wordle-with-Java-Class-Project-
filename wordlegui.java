//import
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date; 


public class wordlegui extends JPanel 
{   // create label for text "Make a Guess"
    static Label l1  = new Label("");
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
    
    // create list to store the guess answers
    static int[] guessCheck = {1,1,1,2,2};
    
    // store previous answers of if the guesses are correct
    static int[] row1ans = {0,0,0,0,0};
    static int[] row2ans = {0,0,0,0,0};
    static int[] row3ans = {0,0,0,0,0};
    static int[] row4ans = {0,0,0,0,0};
    static int[] row5ans = {0,0,0,0,0};
    
    // show the previous guesses
    static String[] preguess = {"","","","",""};
    
    // placeholder text for adding labels
    static String placeText = "";
    
    // create variable for what row to draw boxes at
    static int row = 1;
    
    // create variable to store the guess
    static String guess;
    
    static wordlegui gui = new wordlegui();
    static JFrame frame = new JFrame("Wordle");
    
    static boolean nextGuess = false;
    
    static String answerWord;
    
    public static void creation(String Word){
        
        answerWord = Word;
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
        // implement button code
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                buttonGuessAction(evt);
            }
        });
        // set frame size and make it visible
        frame.setSize(1000,1000);
        frame.add(gui);
        frame.setVisible(true);
        // wait for guess one
        while(nextGuess == false){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        row1ans = guess(1,row1ans);
        nextGuess = false;
        while(nextGuess == false){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        row2ans = guess(2,row2ans);
        nextGuess = false;
        while(nextGuess == false){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        row3ans = guess(3,row3ans);
        nextGuess = false;
        while(nextGuess == false){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        row4ans = guess(4,row4ans);
        nextGuess = false;
        while(nextGuess == false){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        row5ans = guess(5,row5ans);
        nextGuess = false;
    }
    
    public void paint (Graphics g){
        wordlelogic logic = new wordlelogic();
        
        // add label for make a guess
        placeText = "Make A Guess";
        l1.setForeground(Color.BLUE);
        addlabel(l1,placeText,350,10,500,50,50);
        
        // add label for the previous answers list
        placeText="Previous Guess:";
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
        
        preGuess();
    }    
    
    public static void buttonGuessAction(ActionEvent evt){
        guess = t1.getText();
        System.out.print(guess);
        if(guess.length() > 5 | guess.length() < 5){
            frame.add(l2);
            // add label for please guess a five letter word
            placeText = "Please Guess a Five Letter Word!!!";
            l2.setForeground(Color.RED);
            addlabel(l2,placeText,375,800,500,50,20);
        } else{
            frame.remove(l2);
            guessCheck = wordlelogic.check(wordlelogic.split(answerWord),wordlelogic.split(guess));
            nextGuess = true;
        }
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
            // draw the box
            g.fillRect((250+i),(100*row),90,90);
        }
    }
    // add the previous guesses
    public static void preGuess(){
        // set label colors as red
        l4.setForeground(Color.RED);
        l5.setForeground(Color.RED);
        l6.setForeground(Color.RED);
        l7.setForeground(Color.RED);
        l8.setForeground(Color.RED);
        
        // add the previous guesses
        placeText=preguess[0];
        addlabel(l4,placeText,10,230,150,20,20);
        
        placeText=preguess[1];
        addlabel(l5,placeText,10,260,150,20,20);
        
        placeText=preguess[2];
        addlabel(l6,placeText,10,290,150,20,20);
        
        placeText=preguess[3];
        addlabel(l7,placeText,10,320,150,20,20);
        
        placeText=preguess[4];
        addlabel(l8,placeText,10,350,150,20,20);
    }
    
    // logic for next guess
    public static int[] 
    guess(int guessnum, int[] rowans){
        rowans = remap(guessCheck);
        preguess[guessnum-1] = guess;
        frame.add(gui);
        SwingUtilities.updateComponentTreeUI(frame);
        return rowans;
    }
    // take the guess and store it in the answer log
    public static int[] remap(int[] guess){
        int[] ans = {0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            ans[i] = guess[i];
        }
        return ans;
    }
    // method for adding labels
    public static void addlabel(Label l, String text, int x, int y, int sizex, int sizey, int fontsize){
        l.setBounds(x,y,sizex,sizey);
        l.setText(text);
        l.setFont(new Font("Serif", Font.PLAIN, fontsize));
    }
}
