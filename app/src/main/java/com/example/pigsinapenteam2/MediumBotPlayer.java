package com.example.pigsinapenteam2;

import java.util.LinkedList;
import java.util.Random;

public class MediumBotPlayer extends BotPlayer {
  private ChainFinder chainFinder;
  private LinkedList<WallCoordinate> possibleMovesNoConcede;
  private LinkedList<WallCoordinate> possibleCaptures;
  private boolean isEndgame;
  private int boardHeight;
  private int boardWidth;

  public MediumBotPlayer() {
    super();
    possibleMovesNoConcede = new LinkedList<>();
    possibleCaptures = new LinkedList<>();
    boardHeight = 0;
    boardWidth = 0;
  }

  public MediumBotPlayer(int height, int width) {
    super(height, width, 1);
    possibleCaptures = new LinkedList<>();
    possibleMovesNoConcede = new LinkedList<>();
    boardHeight = height;
    boardWidth = width;
  }

  @Override
  public GameState doMove(GameState inputState) {
    BoardState state = inputState.getBoardState();
    chainFinder = new ChainFinder(boardHeight, boardWidth);

    //get legal moves (without conceding a point)
    //get possible captures
    fillPossibleMovesNoConcedeAndCaptures(state);

    //if endgame:
    if ((possibleMovesNoConcede.size() == 0) && (possibleCaptures.size() == 0)) {
      //find links
      chainFinder.findLinks(state);
      //find chains
      chainFinder.findChains();
    }

    WallCoordinate moveToDo;

    //make move decision


    if (possibleCaptures.size() == 0) {
      if (possibleMovesNoConcede.size() == 0) {
        LinkedList<Chain> chains = chainFinder.getChains();
        Chain smallestChain = chains.getFirst();
        moveToDo = smallestChain.head;
        System.out.println(1);
        System.out.println(moveToDo);
      } else {
        Random random = new Random();
        moveToDo = possibleMovesNoConcede.get(random.nextInt(possibleMovesNoConcede.size()));
        System.out.println(2);
      }
    } else {
      Random random = new Random();
      moveToDo = possibleCaptures.get(random.nextInt(possibleCaptures.size()));
      System.out.println(3);
    }

    possibleCaptures.clear();
    possibleMovesNoConcede.clear();

    int[] coordsOfMove = moveToDo.getIndexForm();
    state.setWallAi(coordsOfMove[0], coordsOfMove[1], coordsOfMove[2]);
    inputState.currentBoardState = state;
    inputState.botLastMove = moveToDo;

    return super.doMove(inputState);
  }

  private void fillPossibleMovesNoConcedeAndCaptures(BoardState state) {
    WallCoordinate currentWall;

    for (int yIndex = 0; yIndex < boardHeight; yIndex++) {
      for (int xIndex = 0; xIndex < boardWidth; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall = new WallCoordinate(xIndex,yIndex,wallIndex,boardHeight,boardWidth);

          if (super.isWallLegal(state, currentWall)) {
            if (!super.willWallConcedePoint(state, currentWall)) {
              possibleMovesNoConcede.add(currentWall);
            }
            if (super.isWallACapture(state, currentWall)) {
                possibleCaptures.add(currentWall);
            }
          }
        }
      }
    }
  }
}
