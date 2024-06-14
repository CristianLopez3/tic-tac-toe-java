package com.game.tictactoe.model;

import com.game.tictactoe.exception.InvalidMoveException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    List<Integer> EXPECTED_POSITIONS = List.of(1, 2, 3);


    @Test
    @DisplayName("Test Human Player")
    void testHumanPlayer() {
        Player player = new HumanPlayer("Player 1");
        player.move(1);
        player.move(2);
        player.move(3);

        assertEquals("Player 1", player.getName(),
                "Player name should be Player 1");

        assertEquals(EXPECTED_POSITIONS, player.getPositions(),
                "Player positions should be [1, 2, 3]");

        assertThrows(InvalidMoveException.class, () -> {
                    player.move(1);
                }, "Should throw InvalidMoveException");
    }

    @Test
    @DisplayName("Test CPU Player")
    void testCpuPlayer() {
        Player cpu = new ComputerPlayer("CPU");
        cpu.move(1);
        cpu.move(2);
        cpu.move(3);

        assertEquals("CPU", cpu.getName(),
                "Player name should be CPU");

        assertEquals(EXPECTED_POSITIONS, cpu.getPositions(),
                "Player positions should be [1, 2, 3]");

        assertThrows(InvalidMoveException.class, () -> {
                    cpu.move(1);
                }, "Should throw InvalidMoveException");

    }
}