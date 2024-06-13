package com.game;

import com.game.tictactoe.*;
import com.game.tictactoe.interfaces.Displayable;
import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.ComputerPlayer;
import com.game.tictactoe.model.HumanPlayer;
import com.game.tictactoe.model.Player;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        START_GAME();
    }

    private static void START_GAME() {
        Player player = new HumanPlayer("Player");
        Player computer = new ComputerPlayer("CPU");
        Scanner input = new Scanner(System.in);
        Displayable board = new Board();

        Game game = new Game(player, computer, board, input);
        game.startGame();
    }


}