package com.game.tictactoe.model;

import com.game.tictactoe.interfaces.Displayable;

import static com.game.tictactoe.util.Constants.POSITIONS;

public class Board implements Displayable {
    private char[][] board = {
            {' ', '|', ' ', '|', ' '},
            {'-', '*', '-', '*', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '*', '-', '*', '-'},
            {' ', '|', ' ', '|', ' '}
    };

    public char[][] getBoard() {
        return board;
    }

    @Override
    public void displayGameBoard() {
        System.out.println();
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void updateBoard(int position, char symbol) {
        int[] coordinates = POSITIONS.get(position);
        board[coordinates[0]][coordinates[1]] = symbol;
        displayGameBoard();
    }

}