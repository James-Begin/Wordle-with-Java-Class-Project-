import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class wordlemain
{
    public static void main(String[]args){
        System.out.print('\f');
        //create instance of wordlegui
        wordlegui gui = new wordlegui();
        
        //choose a random word from the list of 5 letter words
        int rand = (int)(Math.random() * importWordList().size()) + 1;
        String Chosen = importWordList().get(rand);
        
        //Call the creation method in wordle gui with the chosen word
        //This starts the game, and initializes all the gui elements.
        wordlegui.creation(Chosen);
    }
    public static ArrayList<String> importWordList() {
        //Scan the text file containing the 5 letter words
        //Store the words in an Arraylist and return it
        //We use an arraylist instead of an Array as it has a dynamic size
        //The dynamic size makes it easier as we do not know the length of the text file
        ArrayList<String> wordlist = new ArrayList<String>();
        try {
            File myObj = new File("5Lwords.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                wordlist.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();        
        }
        
        return wordlist;
    }
}
