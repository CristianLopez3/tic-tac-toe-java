package com.game;

public class Game {

    private Player player;
    private Player cpu;


    public void setUpPlayers(){
        player = new Player(Constants.USER);
        cpu = new Player(Constants.CPU);
    }




}
