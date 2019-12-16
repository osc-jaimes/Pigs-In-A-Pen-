package com.example.pigsinapenteam2;

import java.util.LinkedList;

public class SimplifiedBoard {
  public LinkedList<Chain> chains;
  public LinkedList<WallCoordinate> legalMoves;
  public LinkedList<WallCoordinate> captures;
  public LinkedList<WallCoordinate> neutralMoves;
  public int height;
  public int width;

  private final int NO_WALL = 0;
  private final int WALL_PRESENT = 1;

  public SimplifiedBoard() {
    chains = new LinkedList<>();
    legalMoves = new LinkedList<>();
    captures = new LinkedList<>();
    neutralMoves = new LinkedList<>();
    height = 0;
    width = 0;
  }

  public SimplifiedBoard(BoardState board) {
    height = board.getHeight();
    width = board.getWidth();

    ChainFinder chainFinder = new ChainFinder(board);
    chainFinder.findChains();
    chains = chainFinder.getChains();

    legalMoves = new LinkedList<>(); // you can move here
    captures = new LinkedList<>();   // point gained by moving here
    neutralMoves = new LinkedList<>();  // no one gets a point from this move

    WallCoordinate currentWall;

    for (int yIndex = 0; yIndex < height; yIndex++) {
      for (int xIndex = 0; xIndex < width; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall = new WallCoordinate(xIndex, yIndex, wallIndex, height, width);

          if (isWallLegal(board, currentWall)) {
            legalMoves.add(currentWall);
            if (isWallACapture(board, currentWall)) {
              captures.add(currentWall);
            } else if (!willWallConcedePoint(board, currentWall)) {
              neutralMoves.add(currentWall);
            }
          }
        }
      }
    }
  }

  /**
   * willWallConcedePointOneSided(BoardState, WallCoordinate) -> boolean:
   *    states whether placing at this location will give opponent an
   *    opportunity to gain a point, relative to one side.
   * @param state: current state of the board
   * @param coords: location of the wall
   * @return
   */
  private boolean willWallConcedePointOneSided(BoardState state, WallCoordinate coords) {
    int cellDegree = 0;
    int xCoord = coords.x;
    int yCoord = coords.y;
    int wallpos = coords.getWallPosition();
    WallCoordinate wallToCheck = new WallCoordinate(xCoord,yCoord,wallpos,
        state.getHeight(), state.getWidth());

    for (int currentWallPos = 0; currentWallPos < 4; currentWallPos++) {
      wallToCheck.setWallPosition(currentWallPos);
      if (wallToCheck.getStateOfThisWall(state) == NO_WALL) {
        cellDegree += 1;
      }
    }

    if (cellDegree == 2) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * willWallConcedePoint(BoardState, WallCoordinate) -> boolean:
   *    states whether placing at this location will give opponent an
   *    opportunity to gain a point.
   * @param state: current state of the board
   * @param coords: location of the wall
   * @return
   */
  protected boolean willWallConcedePoint(BoardState state, WallCoordinate coords) {
    WallCoordinate otherSide = coords.getOtherSideCoordinate();
    boolean willConcede;

    willConcede = willWallConcedePointOneSided(state, coords);
    willConcede = willConcede || willWallConcedePointOneSided(state, otherSide);

    return willConcede;
  }

  /**
   * isWallLegal(BoardState, WallCoordinate) -> boolean:
   *    states whether taking the wall is a legal play.
   * @param state: current state of the board.
   * @param coords: location of the wall.
   * @return
   */
  protected boolean isWallLegal(BoardState state, WallCoordinate coords) {
    int wallState = coords.getStateOfThisWall(state);

    return (wallState == NO_WALL);
  }

  /**
   * isWallACapture(BoardState, WallCoordinate) -> boolean:
   *    states whether taking the wall will give you a point.
   * @param state: current state of the board.
   * @param coords: location of the wall.
   * @return
   */
  protected boolean isWallACapture(BoardState state, WallCoordinate coords) {
    int numWalls = 0;
    int xCoord = coords.x;
    int yCoord = coords.y;

    for (int i = 0; i < 4; i++) {
      if (state.getWallAi(xCoord,yCoord,i) == WALL_PRESENT) {
        numWalls += 1;
      }
    }

    //if the cell can be captured in one move:
    if (numWalls == 3) {
      return true;
    } else {
      return false;
    }
  }
}
