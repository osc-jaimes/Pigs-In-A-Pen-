package com.example.pigsinapenteam2;

public class ChainMapCell {
  private boolean visited;
  private boolean isDegreeTwo;
  private int degree;
  private boolean[] isNeighborConnected;
  private int x;
  private int y;

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

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isChainSegment() {
    return isDegreeTwo;
  }

  public boolean isVisited() {
    return visited;
  }

  public void visit() {
    visited = true;
  }

  public boolean isConnectedToNeighbor(int neighborDirection) {
    return isNeighborConnected[neighborDirection];
  }

  public String toString() {
    String outputString = "";
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
