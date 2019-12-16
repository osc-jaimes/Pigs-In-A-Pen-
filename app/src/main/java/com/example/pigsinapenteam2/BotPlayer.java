package com.example.pigsinapenteam2;


/**
 * BotPlayer: plays the game, so you don't have to.
 *    superclass for the actual bots. Contains common functions.
 *
 * doMove(GameState) -> GameState:
 *    returns the input unchanged.
 *
 * getHasMoved() -> boolean:
 *    implemented for consistency with the human player.
 *
 * isWallACapture(BoardState, WallCoordinate) -> boolean:
 *    states whether taking the wall will give you a point.
 *
 * isWallLegal(BoardState, WallCoordinate) -> boolean:
 *    states whether taking the wall is a legal play.
 *
 * willWallConcedePoint(BoardState, WallCoordinate) -> boolean:
 *    states whether placing at this location will give opponent an
 *    opportunity to gain a point.
 *
 * willWallConcedePointOneSided(BoardState, WallCoordinate) -> boolean:
 *    states whether placing at this location will give opponent an
 *    opportunity to gain a point, relative to one side.
 */
public class BotPlayer extends Player {
  private final int NO_WALL = 0;
  private final int WALL_PRESENT = 1;

  /**
   * default constructor.
   */
  public BotPlayer() {}

  /**
   * BotPlayer(int,int):
   *    constructor.
   *
   * @param height: height of the board
   * @param width: width of the board
   */
  public BotPlayer(int height, int width) {}

  /**
   * doMove(GameState) -> GameState:
   *    Sets the location of the wall the bot wishes to play at to 2.
   *    Returns the new GameState.
   *
   * @param inputState: initial GameState
   * @return: new GameState
   */
  public GameState doMove(GameState inputState) {
    return inputState;
  }

  /**
   * getHasMoved() -> boolean:
   *    implemented for consistency with the human player.
   * @return whether the BotPlayer is ready to have doMove called. (always true)
   */
  public boolean getHasMoved() {
    return true;
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

  protected BoardState applyMove(WallCoordinate moveToDo, BoardState board) {
    int[] coordsOfMove = moveToDo.getIndexForm();
    board.setWallAi(coordsOfMove[0], coordsOfMove[1], coordsOfMove[2]);
    return board;
  }
}

