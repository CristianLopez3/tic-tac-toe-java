package com.game.tictactoe;

import java.util.List;
import java.util.Map;

public class Constants {

    public static final String USER = "User";
    public static final char USER_SYMBOL = 'X';

    public static final String CPU = "CPU";
    public static final char CPU_SYMBOL = 'O';

    public static final List<List<Integer>> WINNING_COMBOS = List.of(
            List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9), // rows
            List.of(1, 4, 7), List.of(2, 5, 8), List.of(3, 6, 9), // columns
            List.of(1, 5, 9), List.of(3, 5, 7) // diagonals
    );

    public static final Map<Integer, int[]> POSITIONS = Map.of(
            1, new int[]{0, 0},
            2, new int[]{0, 2},
            3, new int[]{0, 4},

            4, new int[]{2, 0},
            5, new int[]{2, 2},
            6, new int[]{2, 4},

            7, new int[]{4, 0},
            8, new int[]{4, 2},
            9, new int[]{4, 4}
    );

    public static final String RULES = """
            WELCOME TO TIC-TAC-TOE! 🥳
            RULES:
                1. The game is played on a grid that's 3 squares by 3 squares.
                2. You are ❌, your friend (or the computer in this case) is ⭕. Players take turns putting their marks in empty squares.
                3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.
                4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.
                5. To make a move, enter a number from 1 to 9 to place your mark in the corresponding square.
            Have fun playing! 🫨
            """;

    public static final String POSITION_TAKEN_MESSAGE = "👮 Position already taken 👮";

    public static final String SECTION_DELIMITER = """
            -----------------------------------------
            -----------------------------------------
            """;


}
