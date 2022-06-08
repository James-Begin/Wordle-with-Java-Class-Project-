import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class wordlemain
{
    public static void main(String[]args){
        System.out.print('\f');
        //create instance of wordlegui and wordlelogic
        wordlegui gui = new wordlegui();
        
        
        int rand = (int)(Math.random() * importWordList().size()) + 1;
        String Chosen = importWordList().get(rand);
        wordlegui.creation(Chosen);
    }
    public static ArrayList<String> importWordList() {
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
