# Wordle-with-Java-Class-Project-

## Description
Similar to the popular 'Wordle' game created by British programmer Josh Wardle, the game chooses a random 5 letter word, and the user has 6 chances to guess it. After each guess, letters included in the word and in the same position are outlined green, while letters only included in the word are outline yellow.

The original game can be found at [Wordle](https://www.nytimes.com/games/wordle/index.html)


## Process
Pseudo steps of how the game will work:

1. Choose a random word from an imported list of English 5 letter words.
2. Initialize 5x6 grid to display user's guesses
3. Prompt the user to enter a 5 letter word
4. Check if the user's word is in list of english words
5. If the word is valid display it on the grid
6. Iterate through the letters of the given word, if the letter matches in the same space, color the square green, if the letter is in a different space, colour the square yellow, otherwise, leave grey.
7. Repeat steps 3 to 6 for the next 5 rows, if the user guesses the correct word, display a message, if they don't guess the word, ask if they want to restart or exit
