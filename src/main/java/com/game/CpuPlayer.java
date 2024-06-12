package com.game;

public class CpuPlayer extends Player {

        public CpuPlayer(String name) {
            super(name);
        }

        public int makeMove() {
            return (int) (Math.random() * 9) + 1;
        }
}
