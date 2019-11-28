package com.example.pigsinapenteam2;

public class Chain {
  int length;
  WallCoordinate head;
  WallCoordinate tail;
  boolean isHeadOpen;
  boolean isTailOpen;
  boolean isHeadSet;
  boolean isTailSet;
  //a tail or head would be "closed" if you can place a wall there
  //   and immediately get a point.

  public void Chain() {
    length = 0;
    head = new WallCoordinate();
    tail = new WallCoordinate();
    isHeadOpen = true;
    isTailOpen = true;
    isHeadSet = false;
    isTailSet = false;
  }

  public void Chain(WallCoordinate chainHead, WallCoordinate chainTail) {
    length = 1;
    head = chainHead;
    tail = chainTail;
    isTailOpen = true;
    isHeadOpen = true;
    isTailSet = false;
    isHeadSet = false;
  }
}
