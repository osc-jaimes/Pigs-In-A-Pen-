package com.example.pigsinapenteam2;

public class ChainMap {
  private ChainMapCell[][] cells;
  private int boardHeight;
  private int boardWidth;

  private final int NUMBER_OF_DIRECTIONS = 4;

  public ChainMap() {
    cells = new ChainMapCell[0][0];
    boardHeight = 0;
    boardWidth = 0;
  }

  public ChainMap(BoardState board) {
    boardWidth = board.getWidth();
    boardHeight = board.getHeight();
    cells = new ChainMapCell[boardWidth][boardHeight];

    for (int y = 0; y < boardHeight; y++) {
      for (int x = 0; x < boardWidth; x++) {

        boolean[] neighborConnected = new boolean[NUMBER_OF_DIRECTIONS];
        for (int direction = 0; direction < NUMBER_OF_DIRECTIONS; direction++) {
          neighborConnected[direction] = (board.getWallAi(x,y,direction) == 0);
        }
        ChainMapCell cell = new ChainMapCell(neighborConnected,x,y);
        cells[x][y] = cell;

      }
    }
  }

  public ChainMapCell getCellXY(int x, int y) {
    return cells[x][y];
  }

  public boolean isCellOnBoard(int x, int y) {
    boolean xCoordValid = ((0 <= x) && (x < boardWidth));
    boolean yCoordValid = ((0 <= y) && (y < boardHeight));
    return (xCoordValid && yCoordValid);
  }

  public boolean isCellOnBoard(ChainMapCell cell) {
    return isCellOnBoard(cell.getX(), cell.getY());
  }
}
