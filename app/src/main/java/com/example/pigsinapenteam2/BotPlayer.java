package com.example.pigsinapenteam2;


import java.util.LinkedList;

/**
 * BotPlayer: plays the game, so you don't have to
 *
 * doMove(GameState) -> GameState:
 *    Sets the location of the wall the bot wishes to play at to 2.
 *    Returns the new GameState.
 */
public class BotPlayer extends Player {
  private int boardWidth;
  private int boardHeight;
  private int numBoardCells;
  private int difficulty;
  protected LinkedList<WallCoordinate> possibleCaptures;

  /**
   * default constructor.
   */
  public BotPlayer() {
    boardWidth = 0;
    boardHeight = 0;
    numBoardCells = 0;
    difficulty = 0;
    possibleCaptures = new LinkedList<>();
  }

  /**
   * BotPlayer(int,int) -> void:
   *    constructor.
   *
   * @param height
   * @param width
   * @param botDifficulty: 0 for easy, 1 normal, 2 hard.
   */
  public BotPlayer(int height, int width, int botDifficulty) {
    //option: make input arg just GameState? BoardState?
    boardWidth = width;
    boardHeight = height;
    numBoardCells = width * height;
    difficulty = botDifficulty;
    possibleCaptures = new LinkedList<>();
  }

  /**
   * doMove(GameState) -> GameState:
   *    Sets the location of the wall the bot wishes to play at to 2.
   *    Returns the new GameState.
   *
   * @param inputState
   * @return: new GameState
   */
  public GameState doMove(GameState inputState) {
    return inputState;
  }

  public boolean getHasMoved() {
    return true;
  }

  protected boolean isWallACapture(BoardState state, WallCoordinate coords) {
    //IMPORTANT NOTE: only checks one cell. MAKE SEPARATE COORD OBJECT for the other
    //side of the wall!
    boolean allAreWalls = true;
    int xCoord = coords.x;
    int yCoord = coords.y;
    int wallpos = coords.getWallPosition();
    if (!coords.isTop()) {
      if (state.getWallAi(xCoord, yCoord, 0) == 0) {
        allAreWalls = false;
      }
    } else if (!coords.isRight()) {
      if (state.getWallAi(xCoord, yCoord, 1) == 0) {
        allAreWalls = false;
      }
    } else if (!coords.isBottom()) {
      if (state.getWallAi(xCoord, yCoord, 2) == 0) {
        allAreWalls = false;
      }
    } else if (!coords.isLeft()) {
      if (state.getWallAi(xCoord, yCoord, 3) == 0) {
        allAreWalls = false;
      }
    }

    return allAreWalls;
  }


  protected boolean isWallLegal(BoardState state, WallCoordinate coords) {
    int wallState = -1;

    if (coords.isTop()) {
      wallState = state.getWallAi(coords.x, coords.y,0);
    } else if (coords.isRight()) {
      wallState = state.getWallAi(coords.x, coords.y, 1);
    } else if (coords.isBottom()) {
      wallState = state.getWallAi(coords.x, coords.y, 2);
    } else if (coords.isLeft()) {
      wallState = state.getWallAi(coords.x, coords.y, 3);
    }

    return (wallState == 0);
  }

  protected boolean willWallConcedePoint(BoardState state, WallCoordinate coords) {
    int cellDegree = 0;
    int cellX = coords.x;
    int cellY = coords.y;

    //will be checking a pair of cells, now correcting so
    //the first cell has lower coords
    if (coords.isTop()) {
      cellY -= 1;
    } else if (coords.isLeft()) {
      cellX -= 1;
    }

    //check first cell
    for (int wallPos = 0; wallPos < 4; wallPos++) {
      if (state.getWallAi(cellX, cellY, wallPos) == 0) {
        cellDegree += 1;
      }
    }

    //if this will give other player a point get outa here
    if (cellDegree == 2) {
      return true;
    }

    //get second cell coords
    if (coords.isHorizontal()) {
      cellX += 1;
    } else { //if vertical
      cellY += 1;
    }

    //check second cell
    cellDegree = 0;
    for (int wallPos = 0; wallPos < 4; wallPos++) {
      if (state.getWallAi(cellX, cellY, wallPos) == 0) {
        cellDegree += 1;
      }
    }

    //last check
    if (cellDegree == 2) {
      return true;
    } else {
      return false;
    }
  }
}

