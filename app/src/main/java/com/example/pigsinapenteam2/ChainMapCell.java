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
}
