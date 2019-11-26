package com.example.pigsinapenteam2;

import java.util.LinkedList;
import java.util.Random;

/**
 * EasyBotPlayer: (easy mode) plays so you don't have to.
 */
public class EasyBotPlayer extends BotPlayer {
  private int boardHeight;
  private int boardWidth;

  private LinkedList<WallCoordinate> possibleMoves;
  private LinkedList<WallCoordinate> possibleCaptures;

  public void EasyBotPlayer(int height, int width) {
    super.BotPlayer(height,width,0);
    boardHeight = height;
    boardWidth = width;
    possibleMoves = new LinkedList<WallCoordinate>();
    possibleCaptures = new LinkedList<WallCoordinate>();
  }

  @Override
  public GameState doMove(GameState inputGameState) {
    BoardState state = inputGameState.boardState;
    WallCoordinate moveToDo;

    fillPossibleCapturesAndMoves(state);
    moveToDo = chooseRandomMove();

    possibleCaptures.clear();
    possibleMoves.clear();

    if (moveToDo.isTop()) {
      state.setTopWallState(moveToDo.x, moveToDo.y, 2);
    } else if (moveToDo.isLeft()) {
      state.setLeftWallState(moveToDo.x, moveToDo.y, 2);
    } else if (moveToDo.isBottom()) {
      state.setBottomWallState(moveToDo.x, moveToDo.y, 2);
    } else if (moveToDo.isRight()) {
      state.setRightWallState(moveToDo.x, moveToDo.y, 2);
    }

    //inputGameState.boardState = state;
    return inputGameState;
  }

  private WallCoordinate chooseRandomMove() {
    Random random = new Random();
    if (possibleCaptures.size() == 0) {
      return possibleMoves.get(random.nextInt(possibleMoves.size()));
    } else {
      return possibleCaptures.get(random.nextInt(possibleCaptures.size()))
    }
  }

  private void fillPossibleCapturesAndMoves(BoardState state) {
    WallCoordinate currentWall = new WallCoordinate();

    for (int yIndex = 0; yIndex < boardHeight; yIndex++) {
      for (int xIndex = 0; xIndex < boardWidth; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall.x = xIndex;
          currentWall.y = yIndex;
          currentWall.setWallPosition(wallIndex);

          if (super.isWallLegal(state, currentWall)) {
            possibleMoves.add(currentWall);
            if (super.isWallACapture(state, currentWall)) {
              possibleCaptures.add(currentWall);
            }
          }
        }
      }
    }
  }
}
