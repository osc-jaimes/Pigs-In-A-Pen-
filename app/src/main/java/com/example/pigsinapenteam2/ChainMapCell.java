package com.example.pigsinapenteam2;

/**
 *  ChainMapCell: cell making up the ChainMap.
 *    Holds information about connections on the board and about the process
 *    of chain finding.
 *
 *  By Luke Rostad, 2019
 *
 *  getX() -> int:
 *    returns the x coordinate of this cell.
 *  getY() -> int:
 *    returns the y coordinate of this cell.
 *  getDegree() -> int:
 *    returns the degree (the number of connected cells) of this cell.
 *  isChainSegment() -> boolean:
 *    returns true if this cell has degree two.
 *  isVisited() -> boolean:
 *    returns whether the chainfinding algorithm has reached this cell yet.
 *  visit():
 *    sets visited to true.
 *  isConnectedToNeighbor(int) -> boolean:
 *    returns true if the neighboring cell in the input direction is connected to this cell.
 *  getNeighborCoords(int) -> int[]:
 *    returns an integer array holding the x,y coordinates of the neighboring cell in the
 *    input direction.
 *  toString() -> String:
 *    returns a string representation of this object.
 */
public class ChainMapCell {
  private boolean visited;
  private boolean isDegreeTwo;
  private int degree;
  private boolean[] isNeighborConnected;
  private int x;
  private int y;

  /**
   * ChainMapCell():
   *    default constructor.
   */
  public ChainMapCell(){
    x = 0;
    y = 0;
    visited = false;
    degree = 0;
    isNeighborConnected = new boolean[4];
    for (int i = 0; i < isNeighborConnected.length; i++) {
      isNeighborConnected[i] = false;
    }
    isDegreeTwo = false;
  }

  /**
   * ChainMapCell(boolean[]):
   *    constructor; Sets coordinates to 0,0.
   * @param neighborConnected: boolean array holding whether the neighbor in direction
   *                         [index] is connected to this one.
   */
  public ChainMapCell(boolean[] neighborConnected) {
    assert (neighborConnected.length == 4);
    x = 0;
    y = 0;
    visited = false;
    isNeighborConnected = neighborConnected;

    degree = 0;
    for (int i = 0; i < isNeighborConnected.length; i++) {
      if (isNeighborConnected[i]) {
        degree += 1;
      }
    }

    if (degree == 2) {
       isDegreeTwo = true;
    }
  }

  /**
   * ChainMapCell(boolean[]):
   *    constructor.
   * @param neighborConnected: boolean array holding whether the neighbor in direction
   *                         [index] is connected to this one.
   * @param xCoord: x coordinate of the cell on the board.
   * @param yCoord: y coordinate of the cell on the board.
   */
  public ChainMapCell(boolean[] neighborConnected, int xCoord, int yCoord) {
    assert (neighborConnected.length == 4);
    x = xCoord;
    y = yCoord;
    visited = false;
    isNeighborConnected = neighborConnected;

    degree = 0;
    for (int i = 0; i < isNeighborConnected.length; i++) {
      if (isNeighborConnected[i]) {
        degree += 1;
      }
    }

    if (degree == 2) {
      isDegreeTwo = true;
    }
  }

  /**
   * getX() -> int:
   *    returns the x coordinate of this cell.
   *
   * @return: this cell's x coordinate.
   */
  public int getX() {
    return x;
  }

  /**
   * getY() -> int:
   *    returns the y coordinate of this cell.
   *
   * @return: this cell's y coordinate.
   */
  public int getY() {
    return y;
  }

  /**
   * getDegree() -> int:
   *    returns the degree (the number of connected cells) of this cell.
   *
   * @return: the the number of connected cells.
   */
  public int getDegree() {
    return degree;
  }

  /**
   * isChainSegment() -> boolean:
   *    returns true if this cell has degree two.
   *
   * @return: whether the degree is two.
   */
  public boolean isChainSegment() {
    return isDegreeTwo;
  }

  /**
   * isVisited() -> boolean:
   *    returns whether the chainfinding algorithm has reached this cell yet.
   *
   * @return: whether this cell has been visited yet.
   */
  public boolean isVisited() {
    return visited;
  }

  /**
   * visit():
   *    sets visited to true.
   */
  public void visit() {
    visited = true;
  }

  /**
   * isConnectedToNeighbor(int) -> boolean:
   *    returns true if the neighboring cell in the input direction is connected to this cell.
   * @param neighborDirection: direction of neighbor: 0 up, 1 right, 2 down, 3 left.
   * @return: whether said neighbor is connected to this cell.
   */
  public boolean isConnectedToNeighbor(int neighborDirection) {
    return isNeighborConnected[neighborDirection];
  }

  /**
   * getNeighborCoords(int) -> int[]:
   *    returns an integer array holding the x,y coordinates of the neighboring cell in the
   *    input direction.
   *
   * @param direction: direction of neighbor: 0 up, 1 right, 2 down, 3 left.
   * @return: x,y coordinates of neighbor cell.
   */
  public int[] getNeighborCoords(int direction) {
    int[] neighborCoords = new int[2];
    switch (direction){
      case 0:
        neighborCoords[0] = x;
        neighborCoords[1] = y - 1;
        break;
      case 1:
        neighborCoords[0] = x + 1;
        neighborCoords[1] = y;
        break;
      case 2:
        neighborCoords[0] = x;
        neighborCoords[1] = y + 1;
        break;
      case 3:
        neighborCoords[0] = x - 1;
        neighborCoords[1] = y;
        break;
      default:
        assert (false) : "direction is INVALID";
    }
    return neighborCoords;
  }

  /**
   * toString() -> String:
   *    returns a string representation of this object.
   *
   * @return: string representation.
   */
  public String toString() {
    String outputString = "";
    outputString += "x: " + x + "\n";
    outputString += "y: " + y + "\n";
    outputString += "is part of a chain: " + isChainSegment() + "\n";
    outputString += "visited: " + visited + "\n";
    outputString += "neighbors: ";
    for (int i = 0; i < isNeighborConnected.length; i++) {
      outputString += isNeighborConnected[i] + " ";
    }
    outputString += "\n";
    outputString += "degree: " + degree;

    return outputString;
  }
}
