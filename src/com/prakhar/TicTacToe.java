package com.prakhar;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <board[row].length ; col++) {
                board[row][col] = ' '; // initialize the board to empty first
            }
        }

        char player = 'X' ; //initially the player starts with x
        boolean gameOver = false; // initially the game is not over
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.print(" Player " + player + " enter: ");//you have to enter the positions
            int row = sc.nextInt();
            int col = sc.nextInt();

            //check if the particular position is full or empty
            if(board[row][col] == ' '){
                board[row][col] = player ;//place the element

                gameOver = haveWon(board , player);
                if(gameOver){
                    System.out.println(" Player " + player + " has won ");
                }else{
                    if(player == 'X'){
                        player ='O';
                    }else{
                        player ='X';
                    }
                }
            }else{
                System.out.println("Invalid move, Try again!" );
            }
        }
        printBoard(board);

    }


    private static boolean haveWon(char[][] board, char player) {
        //check for rows
        for (int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player ){
                return true;
            }
        }

        //check for columns
        for (int col = 0; col < board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player ){
                return true;
            }
        }

        //check diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <board[row].length ; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
