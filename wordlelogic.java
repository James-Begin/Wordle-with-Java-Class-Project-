//Author: James B & Koby S
//Date: May 31, 2022
//Computer Science culminating project

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class wordlelogic {
    //split function uses the .split() String method to split a string into a String array 
    //where each index is a seperate letter in the string
    //In this case, we split when there is no space character as every input is a single word
    public static String[] split(String word) {
        String[] splitString = word.split("");
        return splitString;
    }
    
    //This function compares the two given strings and checks whether a letter should be green, yellow, or grey
    public static int[] check(String[] autoword, String[] guess) {
        int[] ans = new int[autoword.length];
        
        //iterate through the words and compare
        for (int i = 0; i < autoword.length; i++) {
            //if both letters are the same, the colour for this space is green
            if (autoword[i].equals(guess[i])) {
                ans[i] = 2;
                continue;
            //if the letter is not in the same position, but elsewhere in the auto generated word, this space becomes yellow.
            } else if (letter_In_String(autoword, guess, i)) {
                ans[i] = 1;
            //if nothing matches, this space is grey
            } else {
                ans[i] = 0;
            }
            
            
        }
        return ans;
    }
    //this function checks whether a certain letter is in the auto generated word.
    //It iterates through the word and compares each letter to the given letter in the user's guess. 
    //If the letter is found and is not in the same position as the given letter from the user's guess, return true. Otherwise, false.
    public static boolean letter_In_String(String[] autoword, String[] guess, int i) {
        for (int k = 0; k < autoword.length; k++) {
                if (guess[i].equals(autoword[k]) && i != k) {
                    return true;
                }
        }
        return false;
    }
    
    //whenever the user enters a guess, we have to check if it is a valid word in the list
    public static boolean isValidWord(String guessWord) {
        wordlemain main = new wordlemain();
        ArrayList<String> wordList = main.importWordList(); 
        
        if (wordList.contains(guessWord)) {
            
            return true;
        }
        
        return false;
    }
}
