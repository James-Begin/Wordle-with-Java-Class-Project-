import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class wordletest {
    public static void main(String[] args) {
        //Initialize the wordlist, containing only 5-letter words
        String[] wordlist = {"cheek", "apple", "heart", "knead", "smell"};
        //Choose a random word from the wordlist by choosing a random index within the word list 
        // and choosing the word assigned to that index
        int word = (int)(Math.random() * wordlist.length);
        String autoword = wordlist[word];
        
        
        //convert chosen string to an arraylist in order to compare each letter and to print it in the GUI
        //use the split function to split when there is no space character in the string, then print it
        String[] splitString = autoword.split("");
        print(splitString);
        
        //Initialize the word the user guesses
        String guess = "";
        
        //initialize a scanner and ask the user for an input. If
        Scanner sc = new Scanner(System.in);
        while (guess.length() != 5) {
            System.out.println("guess a word");
            guess = sc.nextLine();
        }
        
        
        String[] chosen = split(autoword);
        
        String[] guessnew = split(guess);
        print(guessnew);
        

        
        System.out.println("\n");
        printInt(check(chosen, guessnew));
    }
    public static void print(String[] words) {
    
        for (int i = 0; i < words.length;i++) {
            System.out.print(words[i] + " ");
            }
        
        
    }
    public static void printInt(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
    //split function uses the .split() String method to split a string into a String array 
    //where each index is a seperate letter in the string
    //In this case, we split when there is no space character as every input is a single word
    public static String[] split(String word) {
        String[] splitString = word.split("");
        return splitString;
    }
    public static int[] check(String[] autoword, String[] guess) {
        int[] ans = new int[autoword.length];
        
        for (int i = 0; i < autoword.length; i++) {
            
            if (autoword[i].equals(guess[i])) {
                
                ans[i] = 2;
                continue;
            } else if (letter_In_String(autoword, guess, i)) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            
            
        }
        return ans;
    }
    public static boolean letter_In_String(String[] autoword, String[] guess, int i) {
        for (int k = 0; k < autoword.length; k++) {
                if (guess[i].equals(autoword[k]) && i != k) {
                    return true;
                    
                }
                
        }
        return false;
    }
}
