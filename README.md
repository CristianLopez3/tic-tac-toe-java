# TIC TAC TOE WITH JAVA

Hi there, this is a tic-tac-toe game made in shell with java, the idea of the project is:

* Implement Object-Oriented Programming

* Implement SOLID Principles

* Understand a little bit more about Exceptions

* Dockerize the project

### Execute the project with docker: 🐋

```shell
docker build -t tictactoe .
docker run -it --rm tictactoe
```

### Package and file organization: 

```
    com.game.tricki
    ├── exception
    │   └── InvalidMoveException.java
    ├── model
    │   ├── Player.java
    │   ├── HumanPlayer.java
    │   ├── ComputerPlayer.java
    │   └── Board.java
    ├── interface
    │   ├── Playable.java
    │   └── Displayable.java
    ├── util
    │   └── Constants.java
    └── Game.java
    |-- Main.java
```