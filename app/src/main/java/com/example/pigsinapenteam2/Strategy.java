package com.example.pigsinapenteam2;

/**
 *  Strategy: chooses a move from the board.
 *    This is the parent class for actual strategy classes.
 *
 *  chooseMove(BoardFlags, SimplifiedBoard) -> WallCoordinate:
 *    Default move: returns an empty WallCoordinate Object.
 */
public class Strategy {
  /**
   * Strategy():
   *   default constructor.
   */
  public Strategy() { }

  /**
   * chooseMove(BoardFlags, SimplifiedBoard) -> WallCoordinate:
   *    Default move: returns an empty WallCoordinate Object.
   *
   * @param flags: important qualities of the board.
   * @param board: simplified view of the board's state.
   * @return: the move to do.
   */
  public WallCoordinate chooseMove(BoardFlags flags, SimplifiedBoard board) {
    WallCoordinate defaultMove = new WallCoordinate();
    return defaultMove;
  }
}
