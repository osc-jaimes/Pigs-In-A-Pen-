package com.example.pigsinapenteam2;

import GameState;

/**
 * EasyBotPlayer: (easy mode) plays so you don't have to.
 */
public class EasyBotPlayer extends BotPlayer {
  private int boardHeight;
  private int boardWidth;

  private int[][][][] possibleMoves;
  private int[][][][] possibleCaptures;

  public void EasyBotPlayer(int height, int width) {
    boardHeight = height;
    boardWidth = width;
  }

  @Override
  public GameState doMove(GameState inputState) {
    return super.doMove(inputState);
    //go through grid
    //if capture opportunity, add to possibleCaptures
    //if legal move, add to possibleMoves

  }

  private boolean isWallACapture(int xCoord, int yCoord, boolean isVertical) {

  }

  private boolean isWallLegal(int xCoord, int yCoord, boolean isVertical) {

  }
}
