package com.game;

import java.util.*;

import static com.game.Constants.POSITIONS;
import static com.game.Constants.WINNING_COMBOS;

public class Main {

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