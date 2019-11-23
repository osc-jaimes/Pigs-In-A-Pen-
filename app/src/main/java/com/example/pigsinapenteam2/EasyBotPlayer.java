package com.example.pigsinapenteam2;

import java.util.LinkedList;

/**
 * EasyBotPlayer: (easy mode) plays so you don't have to.
 */
public class EasyBotPlayer extends BotPlayer {
  private int boardHeight;
  private int boardWidth;

  private LinkedList<WallCoordinate> possibleMoves;
  private LinkedList<WallCoordinate> possibleCaptures;

  public void EasyBotPlayer(int height, int width) {
    boardHeight = height;
    boardWidth = width;
    possibleMoves = new LinkedList<WallCoordinate>();
    possibleCaptures = new LinkedList<WallCoordinate>();
  }

  @Override
  public GameState doMove(GameState inputGameState) {
    WallCoordinate currentWall = new WallCoordinate();
    BoardState state = inputGameState.boardState;

    for (int yIndex = 0; yIndex < boardHeight; yIndex++) {
      for (int xIndex = 0; xIndex < boardWidth; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall.x = xIndex;
          currentWall.y = yIndex;
          currentWall.setWallPosition(wallIndex);

          if (isWallLegal(state, currentWall)) {
            possibleMoves.add(currentWall);
            if (isWallACapture(state, currentWall)) {
              possibleCaptures.add(currentWall);
            }
          }
        }
      }
    }

  }

  private boolean isWallACapture(BoardState state, WallCoordinate coords) {
    //IMPORTANT NOTE: only checks one cell. MAKE SEPARATE COORD OBJECT for the other
    //side of the wall!
    boolean allAreWalls = true;
    if (!coords.isTop()) {
      if (state.getTopWallState(coords.x, coords.y) == 0) {
        allAreWalls = false;
      }
    } else if (!coords.isRight()) {
      if (state.getRightWallState(coords.x, coords.y) == 0) {
        allAreWalls = false;
      }
    } else if (!coords.isBottom()) {
      if (state.getBottomWallState(coords.x, coords.y) == 0) {
        allAreWalls = false;
      }
    } else if (!coords.isLeft()) {
      if (state.getLeftWallState(coords.x, coords.y) == 0) {
        allAreWalls = false;
      }
    }

    return allAreWalls;
  }

  private boolean isWallLegal(BoardState state, WallCoordinate coords) {
    int wallState = -1;

    if (coords.isTop()) {
      wallState = state.getTopWallState(coords.x, coords.y);
    } else if (coords.isRight()) {
      wallState = state.getRightWallState(coords.x, coords.y);
    } else if (coords.isBottom()) {
      wallState = state.getBottomWallState(coords.x, coords.y);
    } else if (coords.isLeft()) {
      WallCoordinate = state.getLeftWallState(coords.x, coords.y);
    }

    return (wallState == 0);
  }
}
