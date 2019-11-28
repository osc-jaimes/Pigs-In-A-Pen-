package com.example.pigsinapenteam2;

public class Chain {
  int length;
  WallCoordinate head;
  WallCoordinate tail;
  boolean isHeadOpen;
  boolean isTailOpen;
  //a tail or head would be "closed" if you can place a wall there
  //   and immediately get a point.

  public void Chain() {
    length = 0;
    head = new WallCoordinate();
    tail = new WallCoordinate();
    isHeadOpen = true;
    isTailOpen = true;
  }
}
