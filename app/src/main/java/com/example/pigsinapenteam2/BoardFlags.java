package com.example.pigsinapenteam2;

import java.util.LinkedList;

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

      boolean currentHeadOpen;
      boolean currentTailOpen;
      LinkedList<Chain> unmarkedChains = new LinkedList<>();
      for (int i = 0; i < simpleBoard.chains.size(); i++) {
        unmarkedChains.add(simpleBoard.chains.get(i).copy());
      }

      for (int i = 0; i < unmarkedChains.size(); i++) {
        currentHeadOpen = unmarkedChains.get(i).getHeadOpen();
        currentTailOpen = unmarkedChains.get(i).getTailOpen();
        if (!currentHeadOpen || !currentTailOpen) {
          yourExpectedPoints += unmarkedChains.get(i).pointValue();
          unmarkedChains.remove(i);
        }
      }

      for (int i = 0; i < unmarkedChains.size(); i++) {
        if (i % 2 == 0) {
          theirExpectedPoints += unmarkedChains.get(i).pointValue();
        } else {
          yourExpectedPoints += unmarkedChains.get(i).pointValue();
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
