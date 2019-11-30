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
    cellAdjacencyList = new int[boardWidth * boardHeight][2];
  }

  public ChainFinder(int height, int width) {
    boardWidth = width;
    boardHeight = height;
    isCellAChainLinkArray = new boolean[boardWidth][boardHeight];
    cellAdjacencyList = new int[boardWidth * boardHeight][2];
  }

  public void findLinks(BoardState state) {
    //TODO
    int cellDegree;
    int adjacencyIndex;
    int indexOfCurrentCell;
    int indexOfAdjacentCell;
    WallCoordinate currentWallCoord;
    WallCoordinate oppositeWallCoord;

    //loop through all cells
    for (int yCoord = 0; yCoord < boardHeight; yCoord++) {
      for (int xCoord = 0; xCoord < boardWidth; xCoord++) {

        //at a particular cell:
        cellDegree = 0;
        //look at all 4 walls
        indexOfCurrentCell = coordsToIndex(xCoord,yCoord);
        for (int wallPosition = 0; wallPosition < 4; wallPosition++) {
          currentWallCoord = new WallCoordinate(xCoord, yCoord, wallPosition,
                                                boardHeight, boardWidth);
          oppositeWallCoord = currentWallCoord.getOtherSideCoordinate();

          indexOfAdjacentCell = coordsToIndex(oppositeWallCoord.x, oppositeWallCoord.y);
          if (state.getWallAi(xCoord, yCoord, wallPosition) == 0) {
            adjacencyIndex = cellDegree % 2;


            //if wall open, it and the adjacent one are "connected"
            if (oppositeWallCoord.isValidCell()) {
              cellAdjacencyList[indexOfCurrentCell][adjacencyIndex] = indexOfAdjacentCell;
            } else {
              cellAdjacencyList[indexOfCurrentCell][adjacencyIndex] = -1;
            }


            cellDegree += 1;

          }

        }
        if (cellDegree < 2) {
          setIsCellChainLinkXY(false, xCoord, yCoord);
          cellAdjacencyList[indexOfCurrentCell][0] = 0;
          cellAdjacencyList[indexOfCurrentCell][1] = 0;
        } else if (cellDegree == 2){
          setIsCellChainLinkXY(true, xCoord, yCoord);
        } else {
          setIsCellChainLinkXY(false, xCoord, yCoord);
          cellAdjacencyList[indexOfCurrentCell][0] = 0;
          cellAdjacencyList[indexOfCurrentCell][1] = 0;
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

  private void setIsCellChainLinkXY(boolean isChainLink, int xCoord, int yCoord) {
    isCellAChainLinkArray[xCoord][yCoord] = isChainLink;
  }

  private boolean isCellChainLinkXY(int xCoord, int yCoord) {
    return isCellAChainLinkArray[xCoord][yCoord];
  }

}
