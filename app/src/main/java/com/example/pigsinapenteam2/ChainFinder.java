package com.example.pigsinapenteam2;

import java.util.LinkedList;

/**
 * ChainFinder: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class ChainFinder {
  int boardHeight;
  int boardWidth;
  boolean[][] IsCellAChainLink;
  int[][] cellAdjacencyList;

  public ChainFinder() {
    boardWidth = 0;
    boardHeight = 0;
    IsCellAChainLink = new boolean[boardWidth][boardHeight];
    cellAdjacencyList = new int[boardWidth * boardHeight][2];
  }

  public ChainFinder(int height, int width) {
    boardWidth = width;
    boardHeight = height;
    IsCellAChainLink = new boolean[boardWidth][boardHeight];
    cellAdjacencyList = new int[boardWidth * boardHeight][2];
  }

  public void findLinks(BoardState state) {
    //TODO
    //loop through
    int cellDegree;
    for (int yCoord = 0; yCoord < boardHeight; yCoord++) {
      for (int xCoord = 0; xCoord < boardWidth; xCoord++) {
        cellDegree = 0;
        for (int wallPosition = 0; wallPosition < 4; wallPosition++) {
          if (state.getWallAi(xCoord, yCoord, wallPosition) == 0) {
            cellDegree += 1;
          }

        }
      }
    }
  }

  public void findChains() {
    //TODO
    //just remember the chains, don't return
  }

  private int coordsToIndex(int xCoord, int yCoord) {
    return (yCoord * boardWidth + xCoord);
  }

  private int[] indexToCoords(int index) {
    int[] coords = new int[2];
    coords[0] = index % boardWidth;
    coords[1] = index / boardWidth;
    return coords;
  }


}
