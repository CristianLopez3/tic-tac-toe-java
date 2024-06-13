package com.game.tictactoe;

import com.game.tictactoe.exception.InvalidMoveException;
import com.game.tictactoe.interfaces.Displayable;
import com.game.tictactoe.interfaces.Playable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.game.tictactoe.util.Constants.*;

public class Game {
    private Playable player;
    private Playable cpu;
    private Displayable board;
    private Scanner input;

    public Game(Playable player, Playable cpu, Displayable board, Scanner input) {
        this.player = player;
        this.cpu = cpu;
        this.board = board;
        this.input = input;
    }

    public void startGame() {
        System.out.println(SECTION_DELIMITER);

        showRules();
        board.displayGameBoard();

        while(true) {
            playerMove();
            if (checkWinner()) {
                input.close();
                break;
            }
            cpuMove();
            if (checkWinner()) {
                input.close();
                break;
            }
        }

        System.out.println(SECTION_DELIMITER);
    }

    public void playerMove(){
        try {
            System.out.print("✏️ Enter your placement (1-9): ");
            int position = input.nextInt();

            if(player.getPositions().contains(position) || cpu.getPositions().contains(position)){
                throw new InvalidMoveException(POSITION_TAKEN_MESSAGE);
            } else {
                whiteSpace();
                player.move(position);

                System.out.printf("👨‍💻  %s chose position %d%n", USER, position);

                board.updateBoard(position, USER_SYMBOL);
                whiteSpace();
            }
        } catch(InvalidMoveException e){
            System.out.println(e.getMessage());
        }  catch (InputMismatchException | NullPointerException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 9.");
            input.nextLine();
            playerMove();
        }

    }

    public void cpuMove(){
        try {
            Random random = new Random();
            int position = random.nextInt(9) + 1;
            if(cpu.getPositions().contains(position) || player.getPositions().contains(position)){
                throw new InvalidMoveException("Position already taken, choose a new position: ");
            } else {
                whiteSpace();
                cpu.move(position);

                System.out.printf("🤖 %s chose position %d%n", CPU, position);

                board.updateBoard(position, CPU_SYMBOL);
                whiteSpace();
            }
        } catch (InvalidMoveException e) {
            cpuMove();
        }
    }

    public boolean checkWinner(){
        for(List<Integer> combo: WINNING_COMBOS){
            if(player.getPositions().containsAll(combo)){
                System.out.println("\uD83C\uDF89 \uD83C\uDF89 Congratulations! You won! \uD83C\uDF89 \uD83C\uDF89");
                return true;
            } else if(cpu.getPositions().containsAll(combo)){
                System.out.println("🤖 CPU wins! 🤖 ");
                return true;
            } else if(player.getPositions().size() + cpu.getPositions().size() == POSITIONS.size()){
                System.out.println("It's a draw!");
                return true;
            }
        }
        return false;
    }


    private void showRules(){
        System.out.println(RULES);
    }


    private void whiteSpace(){
        System.out.println();
    }




}