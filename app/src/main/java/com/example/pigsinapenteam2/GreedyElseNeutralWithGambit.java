package com.example.pigsinapenteam2;

/**
 *  GreedyElseNeutralWithGambit: chooses a move from the board.
 *    If the smallest chain is of size two and it would benefit from doing so,
 *    it gives the chain away to the player in order to take the chains the player
 *    normally would take otherwise. If this is not possible, do the same as
 *    GreedyElseNeutral.
 *
 *  chooseMove(BoardFlags, SimplifiedBoard) -> WallCoordinate:
 *    Chooses a move to do, based on the algorithm.
 */
public class GreedyElseNeutralWithGambit extends GreedyElseNeutral {
  /**
   * GreedyElseNeutralWithGambit():
   *   default constructor.
   */
  public GreedyElseNeutralWithGambit() {}

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

    if (flags.isEndgame && flags.shouldDoGambit && flags.couldDoGambit) {
      Chain firstChain = board.chains.getFirst();
      if (flags.mayDoGambitHeadDirection) {
        moveToDo = firstChain.head;
      } else if (flags.mayDoGambitTailDirection) {
        moveToDo = firstChain.tail;
      } else {
        assert (false) : "LOGIC ERROR.";
        moveToDo = new WallCoordinate();
      }
    } else {
      moveToDo = super.chooseMove(flags,board);
    }

    return moveToDo;
  }
}
