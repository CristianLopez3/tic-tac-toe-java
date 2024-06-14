package com.game.tictactoe.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    char[][] EXPECTED_BOARD = {
            {' ', '|', ' ', '|', ' '},
            {'-', '*', '-', '*', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '*', '-', '*', '-'},
            {' ', '|', ' ', '|', ' '}
    };

    @Test
    @DisplayName("should return the board")
    void getBoard(){
        Board board = new Board();
        assertArrayEquals(EXPECTED_BOARD, board.getBoard());
    }

}