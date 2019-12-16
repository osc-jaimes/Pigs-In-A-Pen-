package com.example.pigsinapenteam2;

import java.util.Random;

public class GreedyElseNeutral extends Strategy {
  public GreedyElseNeutral() {}

  public WallCoordinate chooseMove(BoardFlags flags, SimplifiedBoard board) {
    WallCoordinate moveToDo;
    Random random = new Random();

    if (flags.doCapturesExist) {
      moveToDo = board.captures.get(random.nextInt(board.captures.size()));
    } else {
      moveToDo = board.neutralMoves.get(random.nextInt(board.neutralMoves.size()));
    }

    return moveToDo;
  }
}
