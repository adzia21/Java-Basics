package com.swiacka.basics;

import java.util.Scanner;

public class TicTacToe {
    private static int count = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}

        };
        printBoard(board);
        userTurn(board);
    }

    private static int checkDiagonal(char[][] board) {
        if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')) {
            count = 3;
            System.out.println("X wins!");
            return count;
        }
        if ((board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
            count = -3;
            System.out.println("O wins!");
            return count;
        }
        return count;
    }

    private static int checkRows(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'O') {
                    count += 1;
                }
                if (board[j][i] == 'X') {
                    count -= 1;
                }
            }
            if (count == 3) {
                System.out.println("O wins!");
                return count;
            }
            if (count == -3) {
                System.out.println("X wins!");
                return count;
            }
            count = 0;
        }

        return count;
    }
    
    private static int checkColumns(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'O') {
                    count += 1;
                }
                if (board[i][j] == 'X') {
                    count -= 1;
                }
            }
            if (count == 3) {
                System.out.println("O wins!");
                return count;
            }
            if (count == -3) {
                System.out.println("X wins!");
                return count;
            }
            count = 0;
        }
        return count;
    }

    private static void userTurn(char[][] board) {
        char oX;
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                oX = 'X';
            } else {
                oX = 'O';
            }
            System.out.println("Turn: " + oX);
            int[] userChoice = askUserAboutCoordinates(board);
            board[userChoice[0]][userChoice[1]] = oX;
            printBoard(board);
            if (checkColumns(board) == 3 || checkRows(board) == 3 || checkColumns(board) == -3 || checkRows(board) == -3 || checkDiagonal(board) == 3 || checkDiagonal(board) == -3) {
                break;
            }
        }


    }

    public static int[] askUserAboutCoordinates(char[][] board) {

        int[] spot = new int[2];

        while (true) {
            System.out.print("Pick the row and a column number: ");
            for (int i = 0; i < spot.length; i++) {
                spot[i] = scanner.nextInt();
            }
            if (board[spot[0]][spot[1]] == '_') {
                return spot;
            } else {
                System.out.println("Try again! ");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("\n");
        for (char[] chars : board) {
            System.out.print("\t");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.print("\n");
        }
        System.out.println("\n\n");
    }
}
