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

  /**
   * BotPlayer(int,int) -> void:
   *    constructor.
   *
   * @param length
   * @param width
   */
  public void BotPlayer(int length, int width) {
    //option: make input arg just GameState? BoardState?
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
