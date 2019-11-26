package com.example.pigsinapenteam2;

import Player;

/**
 * BotPlayer: plays the game, so you don't have to
 *
 * doMove(GameState) -> GameState:
 *    Sets the location of the wall the bot wishes to play at to 2.
 *    Returns the new GameState.
 *
 * captureCheck(BoardState) -> boolean:
 *     Runs a number of internal checks and searches //TODO
 *
 * linkScan() -> void:
 *     Runs a search for "chains" or "links," i.e. finds sections
 *     of the grid that are connected and can be captured pretty much
 *     all at once. Stores data in various places //TODO
 */
public class BotPlayer extends Player {
  private int boardWidth;
  private int boardHeight;
  private int numBoardCells;
  private int difficulty;

  /**
   * default constructor.
   */
  public void BotPlayer() {
    boardWidth = 0;
    boardHeight = 0;
    numBoardCells = 0;
    difficulty = 0;
  }

  /**
   * BotPlayer(int,int) -> void:
   *    constructor.
   *
   * @param height
   * @param width
   * @param botDifficulty: 0 for easy, 1 normal, 2 hard.
   */
  public void BotPlayer(int height, int width, int botDifficulty) {
    //option: make input arg just GameState? BoardState?
    boardWidth = width;
    boardHeight = height;
    numBoardCells = width * height;
    difficulty = botDifficulty;
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



}

