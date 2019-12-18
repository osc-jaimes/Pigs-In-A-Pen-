package com.example.pigsinapenteam2;

import java.util.Random;

/**
 *  GreedyElseRandom: chooses a move from the board.
 *    Captures if possible, otherwise goes randomly.
 *
 *  chooseMove(BoardFlags, SimplifiedBoard) -> WallCoordinate:
 *    Chooses a move to do, based on the algorithm.
 */
public class GreedyElseRandom extends Strategy {

  /**
   * GreedyElseRandom():
   *   default constructor.
   */
  public GreedyElseRandom() {}

  /**
   * chooseMove(BoardFlags, SimplifiedBoard) -> WallCoordinate:
   *    Chooses a move to do, based on the algorithm.
   *
   * @param flags: important qualities of the board.
   * @param board: simplified view of the board's state.
   * @return: the move to do.
   */
  public WallCoordinate chooseMove(BoardFlags flags, SimplifiedBoard board) {
    WallCoordinate moveToDo;
    Random random = new Random();

    if (flags.doCapturesExist) {
      moveToDo = board.captures.get(random.nextInt(board.captures.size()));
    } else {
      moveToDo = board.legalMoves.get(random.nextInt(board.legalMoves.size()));
    }

    return moveToDo;
  }
}
