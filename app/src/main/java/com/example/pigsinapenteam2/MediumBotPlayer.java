package com.example.pigsinapenteam2;

import java.util.LinkedList;

public class MediumBotPlayer extends BotPlayer {
  ChainFinder chainFinder;
  LinkedList<WallCoordinate> possibleMoves;
  LinkedList<WallCoordinate> possibleCaptures;

  public void MediumBotPlayer() {
    super.BotPlayer();
    chainFinder = new ChainFinder(0,0);
    possibleMoves = new LinkedList<WallCoordinate>();
    possibleCaptures = new LinkedList<WallCoordinate>();
  }

  public void MediumBotPlayer(int height, int width) {
    super.BotPlayer(height, width, 1);
    chainFinder = new ChainFinder(height, width);
    possibleCaptures = new LinkedList<WallCoordinate>();
    possibleMoves = new LinkedList<WallCoordinate>();
  }

  @Override
  public GameState doMove(GameState inputState) {


    //horizontal walls: (during this loop do per-cell checks)
    //for 0 to height-1:
    // for 0 to width:
    //    -run stuff on left wall version
    //    -run stuff on right wall version
    //vertical walls:
    //for 0 to width-1:
    // for 0 to height:
    //    -run stuff on top wall version
    //    -run stuff on bottom wall version

    return super.doMove(inputState);
  }
}
