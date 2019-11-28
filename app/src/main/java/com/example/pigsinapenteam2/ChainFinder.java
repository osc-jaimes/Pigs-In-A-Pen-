package com.example.pigsinapenteam2;

/**
 * ChainFinder: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class ChainFinder {
  int boardHeight;
  int boardWidth;
  boolean[][] IsCellAChainLink;

  public void ChainFinder() {
    boardWidth = 0;
    boardHeight = 0;
    IsCellAChainLink = new boolean[boardWidth][boardHeight];
  }

  public void ChainFinder(int height, int width) {
    boardWidth = width;
    boardHeight = height;
    IsCellAChainLink = new boolean[boardWidth][boardHeight];
  }
}
