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

  public void addHead(WallCoordinate newHeadCoords) {
    length += 1;
    head = newHeadCoords;
  }

  public void addTail(WallCoordinate newTailCoords) {
    length += 1;
    tail = newTailCoords;
  }

  public void setTailOpen(boolean tailOpen) {
    isTailSet = true;
    isTailOpen = tailOpen;
  }

  public void setHeadOpen(boolean headOpen) {
    isHeadSet = true;
    isHeadOpen = headOpen;
  }

  public boolean getHeadOpen() throws ChainEndOpenFlagUnsetException {
    if (!isHeadSet) {
      throw new ChainEndOpenFlagUnsetException("Head flag not yet set.");
    } else {
      return isHeadOpen;
    }
  }

  public boolean getTailOpen() throws ChainEndOpenFlagUnsetException {
    if (!isTailSet) {
      throw new ChainEndOpenFlagUnsetException("Tail flag not yet set.");
    } else {
      return isTailOpen;
    }
  }

  private class ChainEndOpenFlagUnsetException extends Exception {
    public ChainEndOpenFlagUnsetException(String message){
      super(message);
    }
    public ChainEndOpenFlagUnsetException(){}
  }
}

