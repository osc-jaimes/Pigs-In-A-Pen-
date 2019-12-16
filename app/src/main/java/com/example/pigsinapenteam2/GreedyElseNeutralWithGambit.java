package com.example.pigsinapenteam2;

public class GreedyElseNeutralWithGambit extends GreedyElseNeutral {
  public GreedyElseNeutralWithGambit() {}

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
