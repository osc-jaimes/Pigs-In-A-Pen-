package com.example.pigsinapenteam2;

public class Chain {
  public int length;
  public WallCoordinate head;
  public WallCoordinate tail;
  private boolean isHeadOpen;
  private boolean isTailOpen;
  private boolean isHeadSet;
  private boolean isTailSet;
  //a tail or head would be "closed" if you can place a wall there
  //   and immediately get a point.

  public Chain() {
    length = 0;
    head = new WallCoordinate();
    tail = new WallCoordinate();
    isHeadOpen = true;
    isTailOpen = true;
    isHeadSet = false;
    isTailSet = false;
  }

  public Chain(WallCoordinate chainHead, WallCoordinate chainTail) {
    length = 1;
    head = chainHead;
    tail = chainTail;
    isTailOpen = true;
    isHeadOpen = true;
    isTailSet = false;
    isHeadSet = false;
    if (chainHead == null) {
      throw new NullPointerException("Head cannot be initially null.");
    }
    if (chainTail == null) {
      throw new NullPointerException("Tail cannot be initially null.");
    }
  }

  public void addCellHead(WallCoordinate newHeadCoords) {
    if (newHeadCoords == null) {
      throw new NullPointerException("New head cannot be null.");
    }
    length += 1;
    head = newHeadCoords;
  }

  public void addCellTail(WallCoordinate newTailCoords) {
    if (newTailCoords == null) {
      throw new NullPointerException("New tail cannot be null.");
    }
    length += 1;
    tail = newTailCoords;
  }

  public void setTailOpen(boolean tailIsOpen) {
    isTailSet = true;
    isTailOpen = tailIsOpen;
  }

  public void setHeadOpen(boolean headIsOpen) {
    isHeadSet = true;
    isHeadOpen = headIsOpen;
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

  public String toString() {
    String outputString = "";
    outputString += "length: " + length + "\n";
    outputString += "head: " + head + "\n";
    outputString += "tail: " + tail + "\n";
    return outputString;
  }

  private class ChainEndOpenFlagUnsetException extends Exception {
    public ChainEndOpenFlagUnsetException(String message){
      super(message);
    }
    public ChainEndOpenFlagUnsetException(){}
  }
}

