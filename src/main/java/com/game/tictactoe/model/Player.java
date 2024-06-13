package com.game.tictactoe.model;

import com.game.tictactoe.exception.InvalidMoveException;
import com.game.tictactoe.interfaces.Playable;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Playable {
    private List<Integer> positions = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }


    @Override
    public List<Integer> getPositions() {
        return positions;
    }

    @Override
    public void move(int position) {
        if (positions.contains(position)) {
            throw new InvalidMoveException("Position already taken");
        }
        positions.add(position);
    }

    public String getName() {
        return name;
    }

}
