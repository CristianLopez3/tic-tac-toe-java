package com.game;

import java.util.*;

enum Player {
    USER, CPU
}

public class Main {
    private static final List<List<Integer>> WINNING_COMBOS = List.of(
            List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9), // rows
            List.of(1, 4, 7), List.of(2, 5, 8), List.of(3, 6, 9), // columns
            List.of(1, 5, 9), List.of(3, 5, 7) // diagonals
    );

    private static final Map<Integer, int[]> POSITIONS = Map.of(
            1, new int[]{0, 0}, 2, new int[]{0, 2}, 3, new int[]{0, 4},
            4, new int[]{2, 0}, 5, new int[]{2, 2}, 6, new int[]{2, 4},
            7, new int[]{4, 0}, 8, new int[]{4, 2}, 9, new int[]{4, 4}
    );

    private static List<Integer> playerPositions = new ArrayList<>();
    private static List<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            char[][] board = {
                    {' ', '|', ' ', '|', ' '},
                    {'-', '*', '-', '*', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '*', '-', '*', '-'},
                    {' ', '|', ' ', '|', ' '}
            };
            displayGameBoard(board);

            while (true) {
                int playerPosition = getPlayerPosition(input);
                changePlacement(playerPosition, board, Player.USER);

                String result = checkWinner();
                if (!result.isEmpty()) {
                    System.out.println(result);
                    break;
                }

                int cpuPosition = getCPUPosition();
                changePlacement(cpuPosition, board, Player.CPU);

                displayGameBoard(board);
            }
        }
    }

    private static int getPlayerPosition(Scanner input) {
        int position;
        do {
            System.out.print("Enter your placement (1-9): ");
            position = input.nextInt();
        } while (playerPositions.contains(position) || cpuPositions.contains(position));
        return position;
    }

    private static int getCPUPosition() {
        Random random = new Random();
        int position;
        do {
            position = random.nextInt(9) + 1;
        } while (playerPositions.contains(position) || cpuPositions.contains(position));
        return position;
    }

    private static void changePlacement(int position, char[][] board, Player player) {
        char symbol = player == Player.USER ? 'X' : 'O';
        int[] coordinates = POSITIONS.get(position);
        board[coordinates[0]][coordinates[1]] = symbol;

        if (player == Player.USER) {
            playerPositions.add(position);
        } else {
            cpuPositions.add(position);
        }
    }

    public static void displayGameBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static String checkWinner() {
        for (List<Integer> combo : WINNING_COMBOS) {
            if (playerPositions.containsAll(combo)) {
                return "Congratulations, you have won!";
            } else if (cpuPositions.containsAll(combo)) {
                return "CPU has won!";
            }
        }
        if (playerPositions.size() + cpuPositions.size() == 9) {
            return "CAT!";
        }
        return "";
    }
}