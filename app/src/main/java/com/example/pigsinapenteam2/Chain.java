package com.example.pigsinapenteam2;

public class Chain {
  public int length;
  public WallCoordinate head;
  public WallCoordinate tail;
  private boolean isHeadOpen;
  private boolean isTailOpen;
  //a tail or head would be "closed" if you can place a wall there
  //   and immediately get a point.

  public Chain() {
    length = 0;
    head = new WallCoordinate();
    tail = new WallCoordinate();
    isHeadOpen = true;
    isTailOpen = true;
  }

  public Chain(WallCoordinate chainHead, WallCoordinate chainTail) {
    length = 1;
    head = chainHead;
    tail = chainTail;
    isHeadOpen = true;
    isTailOpen = true;
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
    isTailOpen = tailIsOpen;
  }

  public void setHeadOpen(boolean headIsOpen) {
    isHeadOpen = headIsOpen;
  }

  public boolean getHeadOpen() {
    return isHeadOpen;
  }

  public boolean getTailOpen() {
    return isTailOpen;
  }

  public int pointValue() {
    int pointsReceived = length;
    if (!isHeadOpen) {
      pointsReceived += 1;
    }
    if (!isTailOpen) {
      pointsReceived += 1;
    }
    return pointsReceived;
  }

  public Chain copy() {
    Chain copyChain = new Chain(head,tail);
    while (copyChain.length > length) {
      copyChain.addCellHead(head);
    }
    copyChain.setHeadOpen(isHeadOpen);
    copyChain.setTailOpen(isTailOpen);

    return copyChain;
  }

  public String toString() {
    String outputString = "";
    outputString += "[" + head.x + " " + head.y;
    outputString += " : " + length + " : ";
    outputString += tail.x + " " + tail.y + "]";
    return outputString;
  }
}

