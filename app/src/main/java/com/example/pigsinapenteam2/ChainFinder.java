package com.example.pigsinapenteam2;

import java.util.LinkedList;

/**
 * ChainFinder: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class ChainFinder {
  private LinkedList<Chain> chains;
  private ChainMap chainMap;
  private final int NUMBER_OF_DIRECTIONS = 4;
  

  public ChainFinder() {
    chains = new LinkedList<>();
    chainMap = new ChainMap();
  }

  public ChainFinder(BoardState state) {
    chains = new LinkedList<>();
    chainMap = new ChainMap(state);
  }

  public void findChains() {
    ChainMapCell currentCell;
    Chain currentChain;
    WallCoordinate[] connections;

    for (int y = 0; y < chainMap.boardHeight; y++) {
      for (int x = 0; x < chainMap.boardWidth; x++) {

        currentCell = chainMap.getCellXY(x,y);

        if (!currentCell.isVisited() && currentCell.isChainSegment()) {
          currentCell.visit();

          connections = getConnectionsOfCell(currentCell);
          assert (connections.length == 2): "chain segment is not a chain segment!";
          currentChain = new Chain(connections[0], connections[1]);

          growChainHead(currentChain);
          growChainHead(currentChain);

          setChainHeadOpenOrClosed(currentChain);
          setChainTailOpenOrClosed(currentChain);

          chains.add(currentChain);
        }
      }
    }
    sortChains();
  }

  private void growChainHead(Chain chain) {
    int[] previousCell = new int[2];
    int[] currentCell = new int[2];
    previousCell[0] = chain.head.x;
    previousCell[1] = chain.head.y;

    WallCoordinate newCellWall = chain.head.getOtherSideCoordinate();
    currentCell[0] = newCellWall.x;
    currentCell[1] = newCellWall.y;

    growChainHeadRecursive(chain, currentCell, previousCell);
  }

  private void growChainTail(Chain chain) {
    int[] previousCell = new int[2];
    int[] currentCell = new int[2];
    previousCell[0] = chain.tail.x;
    previousCell[1] = chain.tail.y;

    WallCoordinate newCellWall = chain.tail.getOtherSideCoordinate();
    currentCell[0] = newCellWall.x;
    currentCell[1] = newCellWall.y;

    growChainTailRecursive(chain, currentCell, previousCell);
  }

  private void growChainHeadRecursive(Chain toGrow, int[] currentCellCoords,
                                      int[] previousCellCoords) {

    if (!chainMap.isCellOnBoard(currentCellCoords[0],currentCellCoords[1])) {
      return;
    } else {
      ChainMapCell currentCell = chainMap.getCellXY(currentCellCoords[0],currentCellCoords[1]);

      if (!currentCell.isVisited() && currentCell.isChainSegment()) {
        currentCell.visit();
        WallCoordinate[] connections = getConnectionsOfCell(currentCell);

        WallCoordinate possibleNewCellWall;
        for (int i = 0; i < connections.length; i++) {
          possibleNewCellWall = connections[i].getOtherSideCoordinate();

          if ((possibleNewCellWall.x != previousCellCoords[0])
              || (possibleNewCellWall.y != previousCellCoords[1])) {

            toGrow.addCellHead(connections[i]);
            previousCellCoords[0] = currentCellCoords[0];
            previousCellCoords[1] = currentCellCoords[1];
            currentCellCoords[0] = possibleNewCellWall.x;
            currentCellCoords[1] = possibleNewCellWall.y;

            growChainHeadRecursive(toGrow,currentCellCoords,previousCellCoords);
            return;
          }
        }

      } else {
        return;
      }
    }
  }

  private void growChainTailRecursive(Chain toGrow, int[] currentCellCoords,
                                      int[] previousCellCoords) {
    if (!chainMap.isCellOnBoard(currentCellCoords[0],currentCellCoords[1])) {
      return;
    } else {
      ChainMapCell currentCell = chainMap.getCellXY(currentCellCoords[0],currentCellCoords[1]);

      if (!currentCell.isVisited() && currentCell.isChainSegment()) {
        currentCell.visit();
        WallCoordinate[] connections = getConnectionsOfCell(currentCell);

        WallCoordinate possibleNewCellWall;
        for (int i = 0; i < connections.length; i++) {
          possibleNewCellWall = connections[i].getOtherSideCoordinate();

          if ((possibleNewCellWall.x != previousCellCoords[0])
              || (possibleNewCellWall.y != previousCellCoords[1])) {

            toGrow.addCellTail(connections[i]);
            previousCellCoords[0] = currentCellCoords[0];
            previousCellCoords[1] = currentCellCoords[1];
            currentCellCoords[0] = possibleNewCellWall.x;
            currentCellCoords[1] = possibleNewCellWall.y;

            growChainTailRecursive(toGrow,currentCellCoords,previousCellCoords);
            return;
          }
        }

      } else {
        return;
      }
    }
  }

  private void setChainHeadOpenOrClosed(Chain chain) {
    WallCoordinate headWall = chain.head.getOtherSideCoordinate();
    if (chainMap.isCellOnBoard(headWall.x,headWall.y)) {
      ChainMapCell headCell = chainMap.getCellXY(headWall.x, headWall.y);
      int headDegree = headCell.getDegree();
      assert (headDegree != 2) : "should not set head open/closed when chain is not grown!";
      boolean headOpen = (headDegree > 2);
      chain.setHeadOpen(headOpen);
    } else {
      chain.setHeadOpen(true);
    }
  }

  private void setChainTailOpenOrClosed(Chain chain) {
    WallCoordinate tailWall = chain.tail.getOtherSideCoordinate();
    if (chainMap.isCellOnBoard(tailWall.x,tailWall.y)) {
      ChainMapCell tailCell = chainMap.getCellXY(tailWall.x, tailWall.y);
      int tailDegree = tailCell.getDegree();
      assert (tailDegree != 2): "should not set tail open/closed when chain is not grown!";
      boolean tailOpen = (tailDegree > 2);
      chain.setTailOpen(tailOpen);
    } else {
      chain.setTailOpen(true);
    }
  }

  /**
   * sortChains(): uses insertion sort to sort chains in ascending order by length.
   */
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

  private WallCoordinate[] getConnectionsOfCell(ChainMapCell cell) {
    WallCoordinate[] connections = new WallCoordinate[cell.getDegree()];

    int currentConnectionIndex = 0;
    int x = cell.getX();
    int y = cell.getY();

    for (int direction = 0; direction < NUMBER_OF_DIRECTIONS; direction++) {
      if (cell.isConnectedToNeighbor(direction)) {
        connections[currentConnectionIndex] = chainMap.getCoordOfCellWall(x,y,direction);
        currentConnectionIndex += 1;
      }
    }

    return connections;
  }

  public LinkedList<Chain> getChains() {
    return chains;
  }
}
