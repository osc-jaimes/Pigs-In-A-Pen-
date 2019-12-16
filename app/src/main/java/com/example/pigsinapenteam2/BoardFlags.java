package com.example.pigsinapenteam2;

public class BoardFlags {
  public boolean doCapturesExist;
  public boolean doNeutralMovesExist;
  public boolean doChainsExist;
  public boolean isEndgame;
  public boolean isFirstChainSizeOne;
  public boolean mayDoGambitHeadDirection;
  public boolean mayDoGambitTailDirection;
  public boolean canDoGambit;
  public boolean shouldDoGambit;

  public BoardFlags() {
    doCapturesExist = false;
    doNeutralMovesExist = false;
    doChainsExist = false;
    isEndgame = false;
    isFirstChainSizeOne = false;
    mayDoGambitHeadDirection = false;
    mayDoGambitTailDirection = false;
    canDoGambit = false;
    shouldDoGambit = false;
  }

  public BoardFlags(SimplifiedBoard simpleBoard) {

  }
}
