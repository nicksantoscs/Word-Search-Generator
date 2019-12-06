/**
 * Nicholas Santos, December 5th 2019
 */
package com.company;

public class Assignment2 {

public static void main (String[] args) {

    //Asks the user for all inputs
    WordPuzzle puzzle = new WordPuzzle();
    //Prints the grid for the puzzle based on numbers inputted by the user
    System.out.println(puzzle.returnPuzzle());
    //Prints the words to the puzzle depending on what the user inputs.
    System.out.println(puzzle.wordList());
}
}

