package com.example.pigsinapenteam2;

import java.util.LinkedList;

/**
 * ChainFinder: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class ChainFinder {
  int boardHeight;
  int boardWidth;
  boolean[][] isCellAChainLinkArray;
  int[][] cellAdjacencyList;

  public ChainFinder() {
    boardWidth = 0;
    boardHeight = 0;
    isCellAChainLinkArray = new boolean[boardWidth][boardHeight];
    cellAdjacencyList = new int[boardHeight * boardWidth][4];
  }

  public ChainFinder(int height, int width) {
    boardWidth = width;
    boardHeight = height;
    isCellAChainLinkArray = new boolean[boardWidth][boardHeight];
    cellAdjacencyList = new int[boardHeight * boardWidth][4];
  }

  public void findLinks(BoardState state) {
    //loop through all cells
    for (int yCoord = 0; yCoord < boardHeight; yCoord++) {
      for (int xCoord = 0; xCoord < boardWidth; xCoord++) {
        findLinksOfOneCell(state, xCoord, yCoord);
      }
    }
  }

  private void findLinksOfOneCell(BoardState state, int xCoord, int yCoord) {
    int cellDegree = 0;
    int indexOfCurrentCell = coordsToIndex(xCoord,yCoord);
    int indexOfAdjacentCell;
    WallCoordinate currentWallCoord;
    currentWallCoord = new WallCoordinate(0, 0, 0, boardHeight, boardWidth);
    WallCoordinate oppositeWallCoord;

    for (int wallPosition = 0; wallPosition < 4; wallPosition++) {

      currentWallCoord.x = xCoord;
      currentWallCoord.y = yCoord;
      currentWallCoord.setWallPosition(wallPosition);
      oppositeWallCoord = currentWallCoord.getOtherSideCoordinate();
      indexOfAdjacentCell = coordsToIndex(oppositeWallCoord.x, oppositeWallCoord.y);

      if (state.getWallAi(xCoord, yCoord, wallPosition) == 0) {
        cellAdjacencyList[indexOfCurrentCell][cellDegree] = indexOfAdjacentCell;
        cellDegree += 1;
      }
    }
    if (cellDegree == 2){
      setIsCellChainLinkXY(true, xCoord, yCoord);
    }
  }

  public void findChains() {
    //TODO
    //just remember the chains, don't return
  }

  private int coordsToIndex(int xCoord, int yCoord) {
    if (xCoord >= boardWidth) {
      return -1;
    } else if (yCoord >= boardHeight) {
      return -1;
    } else {
      return (yCoord * boardWidth + xCoord);
    }
  }

  private int[] indexToCoords(int index) {
    int[] coords = new int[2];
    coords[0] = index % boardWidth;
    coords[1] = index / boardWidth;
    return coords;
  }

  private void setIsCellChainLinkXY(boolean isChainLink, int xCoord, int yCoord) {
    isCellAChainLinkArray[xCoord][yCoord] = isChainLink;
  }

  private boolean isCellChainLinkXY(int xCoord, int yCoord) {
    return isCellAChainLinkArray[xCoord][yCoord];
  }

}
