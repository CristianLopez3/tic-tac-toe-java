package com.game.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.ComputerPlayer;
import com.game.tictactoe.model.HumanPlayer;
import com.game.tictactoe.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static com.game.tictactoe.Constants.POSITIONS;


public class PlayerBoardIntegrationTest {

    @Test
    @DisplayName("Should test player move updates board and checks winner")
    public void testPlayerMoveUpdatesBoard() {
        Player humanPlayer = new HumanPlayer("Human Player");
        Player computerPlayer = new HumanPlayer("Cpu Player");
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(humanPlayer, computerPlayer, board, scanner);

        int[] positions = {1, 2, 3};

        for (int position : positions) {
            humanPlayer.move(position);
            board.updateBoard(position, 'X');
        }

        for (int position : positions) {
            int[] coordinates = POSITIONS.get(position);
            assertEquals('X', board.getBoard()[coordinates[0]][coordinates[1]],
                    "Board should be updated with 'X' at position " + position);
        }

        assertTrue(game.checkWinner(), "Game should be over");
    }
}