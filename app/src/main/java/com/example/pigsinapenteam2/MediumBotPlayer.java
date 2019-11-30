package com.example.pigsinapenteam2;

import java.util.LinkedList;

public class MediumBotPlayer extends BotPlayer {
  private ChainFinder chainFinder;
  private LinkedList<WallCoordinate> possibleMoves;
  private LinkedList<WallCoordinate> possibleCaptures;
  private boolean isEndgame;

  public MediumBotPlayer() {
    super();
    chainFinder = new ChainFinder(0,0);
    possibleMoves = new LinkedList<>();
    possibleCaptures = new LinkedList<>();
  }

  public MediumBotPlayer(int height, int width) {
    super(height, width, 1);
    chainFinder = new ChainFinder(height, width);
    possibleCaptures = new LinkedList<>();
    possibleMoves = new LinkedList<>();
  }

  @Override
  public GameState doMove(GameState inputState) {
    BoardState state = inputState.boardState;

    //get links
    chainFinder.findLinks();

    //get legal moves (without conceding a point)
    //get possible captures

    //if endgame:
    chainFinder.findChains();


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
