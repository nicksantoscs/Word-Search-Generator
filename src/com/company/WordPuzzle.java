/**
 * Nicholas Santos, December 5th 2019
 */
package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class WordPuzzle {

    private char[][] crossword;
    private String[] words;
    private int rows = 0;
    private int columns = 0;

    public WordPuzzle() {
        rows = getRowsAndCols("rows");
        columns = getRowsAndCols("columns");
        crossword = new char[rows][columns];
        words = new String[rows];
        for (int i = 0; i < rows; i++) {
            words[i] = getWord();
        }
        fillPuzzle();
        returnWords();
    }

    /**
     * This method will read the word input by the user and detect any possible errors.
     *
     * @return word that user inputs (and tells user if there is an error plus what the error is).
     */
    public String getWord() {
        Scanner wordString = new Scanner(System.in);

        String word;
        do {
            System.out.printf("Please input a word between 0 and %d letters: ", columns);
            word = wordString.nextLine().trim().toUpperCase();

            if (word.length() <= 1) {
                System.out.printf("%s does not contain minimum number of letters, word must be greater than 1 characters%n", word);
            }
            /**
             Statement handles the error for the user's word being too small.
             */

            if (word.contains(" ")) {
                System.out.printf("Your word cannot contain a space%n");
            }
            /**
             Statement handles the error for the user's word containing a space.
             */

            if (word.length() > columns) {
                System.out.printf("%s exceeds the maximum number of letters, word must be <%d characters%n", word, columns);
            }
            /**
             Statement handles the error for the user's word being too long.
             */

        } while (word.length() <= 1 || word.contains(" ") || word.length() > columns);
        return word;
    }

    /**
     * This method will fill the puzzle board with random letters based on an integer input by the user.
     * Generates random number and adds 65 to get the ASCII code for the capital alphabet.
     */

    public void fillPuzzle() {
        SecureRandom random = new SecureRandom();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                crossword[y][x] = (char) (random.nextInt(25) + 65);
            }
        }
    }

    /**
     * This method will prompt the user to enter a dimension and validate that it is between 2-15
     */

    public int getRowsAndCols(String typeOfData) {
        Scanner impt = new Scanner(System.in);
        String input = "";
        int inputNum = 0;

        int rowNum = 0;

        do {
            System.out.printf("Enter number of %s: ", typeOfData);
            rowNum = impt.nextInt();

            //Here I attempted to do a try catch so that the system would recognize if the user puts a letter/word in while it asks for the number of rows and columns.
            //I couldn't understand why it wouldn't work after numerous attempts, I think it has to do with the SDK not recognizing input.parseInt. I decided to comment out the try catch section so that the rest of the program works
            //If for some reason it IS my IntelliJ messing up then please remove the comments as a test.
            //I didn't know how else to try it but I thought at least this way you'd see that I tried it. Thanks again.

            /**try {
                input = impt.next();
                inputNum = input.parseInt(input);
            }
            catch (NumberFormatException e)‏{
                System.out.println("Only integers are allowed");
            }
        */
            if (rowNum < 2 || rowNum > 15) {
                System.out.printf("Number of rows is not between 2 and 15, re-enter: ");
            }


        } while (rowNum < 2 || rowNum > 15);
        return rowNum;
    }

    /**
     * This method will return the number rows and columns that the user inputs
     */
    public String returnPuzzle() {
        String wordGame = "";
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                wordGame += crossword[j][i] + "  ";
            }
            wordGame += "\n";
        }
        return wordGame;
    }

    /**
     * This is the method that returns the words that the user inputs inside the puzzle
     */
    public void returnWords() {
        int randomNum;
        SecureRandom random = new SecureRandom();
        for (int j = 0; j < rows; j++) {
            randomNum = random.nextInt(columns - words[j].length() + 1);
            for (int i = 0; i < columns; i++) {
                if (i < (words[j].length() + randomNum) && i >= randomNum)
                    crossword[j][i] = words[j].charAt(i - randomNum);
            }
        }
    }
    /** This is the method that lists the words that the user inputs after the puzzle is made*/
    public String wordList()   {
        String listOfWords = "";
        for (int i = 0; i < rows; i++) {
            listOfWords += words[i] + "\n";
        }
        return listOfWords;
    }
}
