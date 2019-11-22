package com.company;

import java.util.Scanner;

public class WordPuzzle {

    private char[][] crossword;
    private String wordlist;

    public void getWord() {
        int rows = getRows();
        int columns = getColumns();
    }

    //Gets number of rows
    public int getRows(String typeOfData) {
        Scanner row = new Scanner(System.in);

        int rowNum = 0;

        do {
            System.out.printf("Enter number of %s: ", typeOfData);
            rowNum = row.nextInt();
            if (rowNum < 2 || rowNum > 15) {
                System.out.printf("Number of rows is not between 2 and 15, re-enter: ");
            }
        } while (rowNum < 2 || rowNum > 15);
        return rowNum;
    }

    //JW edit to remove
    //Gets number of columns
    public int getColumns() {
        Scanner columns = new Scanner(System.in);

        int colNum = 0;

            do {
            System.out.printf("Enter number of columns: ");
            colNum = columns.nextInt();
            if (colNum < 2 || colNum > 15) {
                System.out.printf("Number of columns is not between 2 and 15, re-enter: ");
            }
        } while (colNum < 2 || colNum > 15);
        return colNum;
    }
}
