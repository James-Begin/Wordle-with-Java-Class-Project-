import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class wordletest {
    public static void main(String[] args) {
        String[] wordlist = {"cheek", "apple", "heart", "knead", "smell"};
        int word = (int)(Math.random() * 5);
        String autoword = "apple";
        //convert chosen string to an arraylist for comparison
        //split whenever there is no space
        String[] splitString = autoword.split("");
        
        print(splitString);
        Scanner sc = new Scanner(System.in);
        System.out.println("guess a word");
        String guess = sc.nextLine();
        if (guess.length() == 5) {
            print(split(guess));
        }
        
        String[] chosen = split(autoword);
        System.out.println(chosen[0]);
        String[] guessnew = split(guess);
        System.out.println(guessnew[0]);
        if (chosen[0] == guessnew[0]) {
            System.out.println("green");
        }
        System.out.println("\n");
        // print(check(chosen, guessnew));
    }
    public static void print(String[] words) {
        for (int i = 0; i < words.length;i++) {
            System.out.print(words[i] + " ");
        }
    }
    public static String[] split(String word) {
        String[] splitString = word.split("");
        return splitString;
    }
    public static String[] check(String[] autoword, String[] guess) {
        String[] ans = new String[autoword.length];
        for (int i = 0; i < autoword.length; i++) {
            
            if (autoword[i] == guess[i]) {
                System.out.print(autoword[i] + " " + guess[i]);
                ans[i] = "green";
            }
            for (int k = 0; k < autoword.length; k++) {
                if (guess[i] == autoword[k] && i != k) {
                    ans[i] = "yellow";
                }
            }
            if (ans[i] == "") {
                ans[i] = "grey";
            }
        }
        return ans;
    }
}
