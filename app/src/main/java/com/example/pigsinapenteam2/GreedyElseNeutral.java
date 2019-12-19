package com.example.pigsinapenteam2;

import java.util.Random;

/**
 *  GreedyElseNeutral: chooses a move from the board.
 *    Captures if possible, else avoids giving you a point.
 *    If must give the player a point, gives the player the smallest 'Chain'.
 *
 *  By Luke Rostad, 2019
 *
 *  chooseMove(BoardFlags, SimplifiedBoard) -> WallCoordinate:
 *    Chooses a move to do, based on the algorithm.
 */
public class GreedyElseNeutral extends Strategy {

  /**
   * GreedyElseNeutral():
   *   default constructor.
   */
  public GreedyElseNeutral() {}

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
      if (!flags.isEndgame) {
        moveToDo = board.neutralMoves.get(random.nextInt(board.neutralMoves.size()));
      } else {
        moveToDo = board.chains.getFirst().head;
      }
    }

    return moveToDo;
  }
}
