package com.example.pigsinapenteam2;

public class BoardFlags {
  public boolean doCapturesExist;
  public boolean doNeutralMovesExist;
  public boolean doChainsExist;
  public boolean isEndgame;
  public boolean isFirstChainSizeOne;
  public boolean mayDoGambitHeadDirection;
  public boolean mayDoGambitTailDirection;
  public boolean couldDoGambit;
  public boolean shouldDoGambit;

  public BoardFlags() {
    doCapturesExist = false;
    doNeutralMovesExist = false;
    doChainsExist = false;
    isEndgame = false;
    isFirstChainSizeOne = false;
    mayDoGambitHeadDirection = false;
    mayDoGambitTailDirection = false;
    couldDoGambit = false;
    shouldDoGambit = false;
  }

  public BoardFlags(SimplifiedBoard simpleBoard) {
    doCapturesExist = (simpleBoard.captures.size() != 0);
    doNeutralMovesExist = (simpleBoard.neutralMoves.size() != 0);
    doChainsExist = (simpleBoard.chains.size() != 0);
    isEndgame = !doNeutralMovesExist;

    if (doChainsExist) {
      Chain firstChain = simpleBoard.chains.getFirst();
      isFirstChainSizeOne = (firstChain.length == 1);
      boolean chainHeadOpen = firstChain.getHeadOpen();
      boolean chainTailOpen = firstChain.getTailOpen();
      mayDoGambitHeadDirection = (chainHeadOpen && !chainTailOpen);
      mayDoGambitTailDirection = (chainTailOpen && !chainHeadOpen);

      int yourExpectedPoints = 0;
      int theirExpectedPoints = 0;
      for (int i = 0; i < simpleBoard.chains.size(); i++) {
        if (i % 2 == 0) {
          yourExpectedPoints += simpleBoard.chains.get(i).pointValue();
        } else {
          theirExpectedPoints += simpleBoard.chains.get(i).pointValue();
        }
      }

      couldDoGambit = (isFirstChainSizeOne &&
          (mayDoGambitTailDirection || mayDoGambitHeadDirection));
      shouldDoGambit = (yourExpectedPoints < theirExpectedPoints);

    } else {
      isFirstChainSizeOne = false;
      mayDoGambitTailDirection = false;
      mayDoGambitTailDirection = false;
      couldDoGambit = false;
      shouldDoGambit = false;
    }

  }
}
