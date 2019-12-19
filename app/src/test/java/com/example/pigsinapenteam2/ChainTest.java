package com.example.pigsinapenteam2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChainTest {

  @Test
  public void addCellHead() {
    WallCoordinate wall1 = new WallCoordinate();
    WallCoordinate wall2 = new WallCoordinate();
    Chain myChain = new Chain(wall1,wall2);
    myChain.addCellHead(wall1);
    assertEquals(2,myChain.length);
  }
}