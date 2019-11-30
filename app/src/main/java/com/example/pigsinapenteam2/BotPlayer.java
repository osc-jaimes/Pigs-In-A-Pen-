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


  protected boolean isWallLegal(BoardState state, WallCoordinate coords) {
    int wallState = -1;

    if (coords.isTop()) {
      wallState = state.getTopWallState(coords.x, coords.y);
    } else if (coords.isRight()) {
      wallState = state.getRightWallState(coords.x, coords.y);
    } else if (coords.isBottom()) {
      wallState = state.getBottomWallState(coords.x, coords.y);
    } else if (coords.isLeft()) {
      wallState = state.getLeftWallState(coords.x, coords.y);
    }

    return (wallState == 0);
  }
}

