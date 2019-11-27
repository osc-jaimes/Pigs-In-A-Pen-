package com.example.pigsinapenteam2;

/**
 * Chains: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class Chains {
  int boardHeight;
  int boardWidth;
  boolean[][] IsCellAChainLink;

  public void Chains() {
    boardWidth = 0;
    boardHeight = 0;
    IsCellAChainLink = new boolean[boardWidth][boardHeight];
  }
}
