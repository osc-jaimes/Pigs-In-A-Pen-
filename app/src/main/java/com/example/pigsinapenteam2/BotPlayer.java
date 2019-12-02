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
    int numWalls = 0;
    int xCoord = coords.x;
    int yCoord = coords.y;

    for (int i = 0; i < 4; i++) {
      if (state.getWallAi(xCoord,yCoord,i) == 1) {
        numWalls += 1;
      }
    }

    if (numWalls == 3) {
      return true;
    } else {
      return false;
    }
  }


  protected boolean isWallLegal(BoardState state, WallCoordinate coords) {
    int wallState = coords.getStateOfThisWall(state);

    return (wallState == 0);
  }

  protected boolean willWallConcedePoint(BoardState state, WallCoordinate coords) {
    int cellDegree = 0;
    int xCoord = coords.x;
    int yCoord = coords.y;
    int wallpos = coords.getWallPosition();
    WallCoordinate wallToCheck = new WallCoordinate(xCoord,yCoord,wallpos,
                                                    state.getHeight(), state.getWidth());

    for (int currentWallPos = 0; currentWallPos < 4; currentWallPos++) {
      wallToCheck.setWallPosition(currentWallPos);
      if (wallToCheck.getStateOfThisWall(state) == 0) {
        cellDegree += 1;
      }
    }

    if (cellDegree == 2) {
      return true;
    }

    wallToCheck = coords.getOtherSideCoordinate();
    cellDegree = 0;
    for (int currentWallPos = 0; currentWallPos < 4; currentWallPos++) {
      wallToCheck.setWallPosition(currentWallPos);
      if (wallToCheck.getStateOfThisWall(state) == 0) {
        cellDegree += 1;
      }
    }

    if (cellDegree == 2) {
      return true;
    }

    return false;
  }
}

