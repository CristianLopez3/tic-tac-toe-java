package com.game;

import java.util.List;
import java.util.Map;

public class Constants {

    public static final String USER = "User";
    public static final String CPU = "CPU";

    public static final List<List<Integer>> WINNING_COMBOS = List.of(
            List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9), // rows
            List.of(1, 4, 7), List.of(2, 5, 8), List.of(3, 6, 9), // columns
            List.of(1, 5, 9), List.of(3, 5, 7) // diagonals
    );

    public static final Map<Integer, int[]> POSITIONS = Map.of(
            1, new int[]{0, 0}, 2, new int[]{0, 2}, 3, new int[]{0, 4},
            4, new int[]{2, 0}, 5, new int[]{2, 2}, 6, new int[]{2, 4},
            7, new int[]{4, 0}, 8, new int[]{4, 2}, 9, new int[]{4, 4}
    );

}
