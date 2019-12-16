package com.example.pigsinapenteam2;

import java.util.Random;

public class GreedyElseRandom extends Strategy {
  public GreedyElseRandom() {}

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
