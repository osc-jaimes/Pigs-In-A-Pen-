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
 */
public class BotPlayer extends Player {
  private final int NO_WALL = 0;
  private final int WALL_PRESENT = 1;

  /**
   * default constructor.
   */
  public BotPlayer() {}

  /**
   * doMove(GameState) -> GameState:
   *    Sets the location of the wall the bot wishes to play at to 2.
   *    Returns the new GameState.
   *
   * @param inputState: initial GameState
   * @return: new GameState
   */
  public GameState doMove(GameState inputState) { return inputState; }

  /**
   * getHasMoved() -> boolean:
   *    implemented for consistency with the human player.
   * @return whether the BotPlayer is ready to have doMove called. (always true)
   */
  public boolean getHasMoved() {
    return true;
  }

  protected BoardState applyMove(WallCoordinate moveToDo, BoardState board) {
    int[] coordsOfMove = moveToDo.getIndexForm();
    board.setWallAi(coordsOfMove[0], coordsOfMove[1], coordsOfMove[2]);
    return board;
  }
}

