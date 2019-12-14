package com.example.pigsinapenteam2;

public class ChainMapCell {
  private boolean visited;
  private boolean isDegreeTwo;
  private int degree;
  private boolean[] isNeighborConnected;

  public ChainMapCell(){
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
    outputString += "is chain: " + isChainSegment() + "\n";
    outputString += "visited: " + visited + "\n";
    outputString += "neighbors: ";
    for (int i = 0; i < isNeighborConnected.length; i++) {
      outputString += isNeighborConnected[i] + " ";
    }
    outputString += "\n";
    outputString += "degree: " + degree + "\n";

    return outputString;
  }
}
