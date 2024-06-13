package com.game.tictactoe.interfaces;

import java.util.List;

public interface Playable {

    void move(int position);
    List<Integer> getPositions();

}