package com.example.pigsinapenteam2;

import java.util.LinkedList;

public class SimplifiedBoard {
  public LinkedList<Chain> chains;
  public LinkedList<WallCoordinate> legalMoves;
  public LinkedList<WallCoordinate> captures;
  public LinkedList<WallCoordinate> safeMoves;
  public int height;
  public int width;

  public SimplifiedBoard() {
    chains = new LinkedList<>();
    legalMoves = new LinkedList<>();
    captures = new LinkedList<>();
    safeMoves = new LinkedList<>();
    height = 0;
    width = 0;
  }

  public SimplifiedBoard(BoardState board) {
    height = board.getHeight();
    width = board.getWidth();

    ChainFinder chainFinder = new ChainFinder(board);
    chainFinder.findChains();
    chains = chainFinder.getChains();

    /*
    WallCoordinate currentWall;

    for (int yIndex = 0; yIndex < height; yIndex++) {
      for (int xIndex = 0; xIndex < width; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall = new WallCoordinate(xIndex, yIndex, wallIndex, height, width);

          if (super.isWallLegal(state, currentWall)) {
            if (super.isWallACapture(state, currentWall)) {
              possibleCaptures.add(currentWall);
            } else if (!super.willWallConcedePoint(state, currentWall)) {
              possibleMovesNoConcedeNoCapture.add(currentWall);
            }
          }
        }
      }
    }*/

    legalMoves = new LinkedList<>();
    captures = new LinkedList<>();
    safeMoves = new LinkedList<>();
  }
}
