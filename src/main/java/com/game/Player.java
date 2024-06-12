package com.game;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private List<Integer> positions = new ArrayList<>();
    private  String name;


    public Player(String name) {
        this.name = name;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public void setPosition(int index, int value) {
        positions.set(index, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
