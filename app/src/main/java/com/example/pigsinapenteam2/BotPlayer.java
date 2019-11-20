package com.example.pigsinapenteam2;

/**
 * BotPlayer: plays the game, so you don't have to
 *
 * doMove(GameState) -> GameState:
 *    Sets the location of the wall the bot wishes to play at to 2.
 *    Returns the new GameState.
 *
 * captureCheck() -> void:
 *     Runs a number of internal checks and searches //TODO
 *
 * linkScan() -> void:
 *     Runs a search for "chains" or "links," i.e. finds sections
 *     of the grid that are connected and can be captured pretty much
 *     all at once. Stores data in various places //TODO
 */
public class BotPlayer extends Player {
  private int[][] cellLinks;
  private int[][] chains;
  private boolean[] isLink;
  private boolean[] isVisited;
  private int boardWidth;
  private int boardHeight;
  private int numBoardCells;
  private boolean isEndgame;

  /**
   * BotPlayer(int,int) -> void:
   *    constructor.
   *
   * @param height
   * @param width
   */
  public void BotPlayer(int height, int width) {
    //option: make input arg just GameState? BoardState?
    boardWidth = width;
    boardHeight = height;
    numBoardCells = width * height;
    isEndgame = false;
    cellLinks = new int[numBoardCells][2];
    chains = new int[numBoardCells / 2][5];
    isLink = new boolean[numBoardCells];
    isVisited = new boolean[numBoardCells];

    //initialize isLink, isVisited to all false
    for (int i = 0; i < numBoardCells; i++) {
      isLink[i] = false;
      isVisited[i] = false;
    }

    //initialize cellLinks to all 0
    for (int i = 0; i < numBoardCells; i++) {
      for (int j = 0; j < 2; j++) {
        cellLinks[i][j] = 0;
      }
    }

    //initialize chains to all 0
    for (int i = 0; i < (numBoardCells / 2); i++) {
      for (int j = 0; j < 5; j++) {
        chains[i][j] = 0;
      }
    }
  }

  /**
   * doMove(GameState) -> GameState:
   *    Sets the location of the wall the bot wishes to play at to 2.
   *    Returns the new GameState.
   *
   * @param inputState
   * @return
   */
  public GameState doMove(GameState inputState) {
    return inputState;
  }

  /**
   * CaptureCheck() -> void:
   *     Runs a number of internal checks and searches
   *     (sets internal variables) //TODO
   */
  private void captureCheck() {

  }

  /**
   * linkScan() -> void:
   *     Runs a search for "chains" or "links," i.e. finds sections
   *     of the grid that are connected and can be captured pretty much
   *     all at once. Stores data in various internal vars //TODO
   */
  private void linkScan() {

  }



}
