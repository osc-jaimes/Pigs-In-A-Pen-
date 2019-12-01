package com.example.pigsinapenteam2;

import java.util.LinkedList;

public class MediumBotPlayer extends BotPlayer {
  private ChainFinder chainFinder;
  private LinkedList<WallCoordinate> possibleMovesNoConcede;
  private LinkedList<WallCoordinate> possibleCaptures;
  private boolean isEndgame;
  private int boardHeight;
  private int boardWidth;

  public MediumBotPlayer() {
    super();
    chainFinder = new ChainFinder(0,0);
    possibleMovesNoConcede = new LinkedList<>();
    possibleCaptures = new LinkedList<>();
    boardHeight = 0;
    boardWidth = 0;
  }

  public MediumBotPlayer(int height, int width) {
    super(height, width, 1);
    chainFinder = new ChainFinder(height, width);
    possibleCaptures = new LinkedList<>();
    possibleMovesNoConcede = new LinkedList<>();
    boardHeight = height;
    boardWidth = width;
  }

  @Override
  public GameState doMove(GameState inputState) {
    BoardState state = inputState.getBoardState();

    //get legal moves (without conceding a point)
    //get possible captures
    fillPossibleCapturesAndMovesNoConcede(state);

    //if endgame:
    if (possibleMovesNoConcede.size() == 0) {
      //find links
      chainFinder.findLinks(state);
      //find chains
      chainFinder.findChains();
    }

    //make move decision
    //TODO

    return super.doMove(inputState);
  }

  private void fillPossibleCapturesAndMovesNoConcede(BoardState state) {
    WallCoordinate currentWall = new WallCoordinate();

    for (int yIndex = 0; yIndex < boardHeight; yIndex++) {
      for (int xIndex = 0; xIndex < boardWidth; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall.x = xIndex;
          currentWall.y = yIndex;
          currentWall.setWallPosition(wallIndex);

          if (super.isWallLegal(state, currentWall)) {
            if (!super.willWallConcedePoint(state, currentWall)) {
              possibleMovesNoConcede.add(currentWall);
              if (super.isWallACapture(state, currentWall)) {
                possibleCaptures.add(currentWall);
              }
            }
          }
        }
      }
    }
  }
}
