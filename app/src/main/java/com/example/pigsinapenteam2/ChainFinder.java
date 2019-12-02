package com.example.pigsinapenteam2;

import java.util.LinkedList;

/**
 * ChainFinder: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class ChainFinder {
  private final int boardHeight;
  private  final int boardWidth;
  private boolean[] isCellAChainLinkArray;
  private int[][] cellAdjacencyList;
  private LinkedList<Chain> chains;
  private WallCoordinate[][] adjacentOpenWallByIndex;
  private boolean[] visited;
  

  public ChainFinder() {
    boardWidth = 0;
    boardHeight = 0;
    isCellAChainLinkArray = new boolean[boardWidth * boardHeight];
    cellAdjacencyList = new int[boardHeight * boardWidth][4];
    chains = new LinkedList<>();
    adjacentOpenWallByIndex = new WallCoordinate[boardHeight * boardWidth][4];
    boolean[] visited = new boolean[boardWidth * boardHeight];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }
  }

  public ChainFinder(int height, int width) {
    boardWidth = width;
    boardHeight = height;
    isCellAChainLinkArray = new boolean[boardWidth *boardHeight];
    cellAdjacencyList = new int[boardHeight * boardWidth][4];
    chains = new LinkedList<>();
    adjacentOpenWallByIndex = new WallCoordinate[boardHeight * boardWidth][4];
    boolean[] visited = new boolean[boardWidth * boardHeight];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }
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

      //this is -1 if the wall's an edge
      indexOfAdjacentCell = coordsToIndex(oppositeWallCoord.x, oppositeWallCoord.y);

      if (currentWallCoord.getStateOfThisWall(state) == 0) {
        cellAdjacencyList[indexOfCurrentCell][cellDegree] = indexOfAdjacentCell;
        cellDegree += 1;
        adjacentOpenWallByIndex[indexOfCurrentCell][cellDegree] = currentWallCoord;
      }
    }
    if (cellDegree == 2){
      isCellAChainLinkArray[indexOfCurrentCell] = true;
    } else {
      isCellAChainLinkArray[indexOfCurrentCell] = false;
    }
  }

  public void findChains() {
    Chain currentChain;
    WallCoordinate chainHead;
    WallCoordinate chainTail;

    for (int currentCellIndex = 0;
         currentCellIndex < cellAdjacencyList.length;
         currentCellIndex++) {
      if (!visited[currentCellIndex] && isCellAChainLink(currentCellIndex)) {
        visited[currentCellIndex] = true;
        chainHead = adjacentOpenWallByIndex[currentCellIndex][0];
        chainTail = adjacentOpenWallByIndex[currentCellIndex][1];
        currentChain = new Chain(chainHead, chainTail);

        //follow the chain down: head
        currentChain = followChainHead(currentChain, currentCellIndex);

        //follow the chain down: tail
        currentChain = followChainTail(currentChain, currentCellIndex);
        chains.add(currentChain);
      }
    }

    sortChains();
  }

  private Chain followChainHead(Chain chain, int headCellIndex) {
    WallCoordinate chainHead;
    int newCellIndex = cellAdjacencyList[headCellIndex][0];
    while (isCellAChainLink(newCellIndex) && !visited[newCellIndex]) {
      visited[newCellIndex] = true;
      if (cellAdjacencyList[newCellIndex][0] != headCellIndex) {
        chainHead = adjacentOpenWallByIndex[newCellIndex][0];
        chain.addCellHead(chainHead);
        newCellIndex = cellAdjacencyList[newCellIndex][0];
      } else {
        chainHead = adjacentOpenWallByIndex[newCellIndex][1];
        chain.addCellHead(chainHead);
        newCellIndex = cellAdjacencyList[newCellIndex][1];
      }
    }
    return chain;
  }

  private Chain followChainTail(Chain chain, int tailCellIndex) {
    WallCoordinate chainTail;
    int newCellIndex = cellAdjacencyList[tailCellIndex][1];
    while (isCellAChainLink(newCellIndex) && !visited[newCellIndex]) {
      visited[newCellIndex] = true;
      if (cellAdjacencyList[newCellIndex][0] != tailCellIndex) {
        chainTail = adjacentOpenWallByIndex[newCellIndex][0];
        chain.addCellHead(chainTail);
        newCellIndex = cellAdjacencyList[newCellIndex][0];
      } else {
        chainTail = adjacentOpenWallByIndex[newCellIndex][1];
        chain.addCellHead(chainTail);
        newCellIndex = cellAdjacencyList[newCellIndex][1];
      }
    }
    return chain;
  }

  private void sortChains() {
    //implements insertion sort
    Chain keyChain;
    Chain iChain;
    int iValue;
    int key;
    int i;
    if (chains.size() > 1) {
      for (int j = 1; j < chains.size(); j++) {
        keyChain = chains.get(j);
        key = keyChain.length;
        i = j - 1;
        iChain = chains.get(i);
        iValue = iChain.length;
        while ((i >= 0) && (iValue > key)) {
          chains.set(i + 1, iChain);
          i = i - 1;
          if (i >= 0) {
            iChain = chains.get(i);
            iValue = iChain.length;
          }
        }
        chains.set(i + 1, keyChain);
      }
    }
  }

  public LinkedList<Chain> getChains() {
    return chains;
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

  private boolean isCellAChainLink(int x, int y) {
    return isCellAChainLinkArray[coordsToIndex(x,y)];
  }

  private boolean isCellAChainLink(int index) {
    return isCellAChainLinkArray[index];
  }
}
