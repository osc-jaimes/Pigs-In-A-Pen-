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

  //edit by benjamin
  private int botMark;

  public MediumBotPlayer() {
    super();
    possibleMovesNoConcede = new LinkedList<>();
    possibleCaptures = new LinkedList<>();
    boardHeight = 0;
    boardWidth = 0;
    botMark = 2;
  }

  public MediumBotPlayer(int height, int width) {
    super(height, width);
    possibleCaptures = new LinkedList<>();
    possibleMovesNoConcede = new LinkedList<>();
    boardHeight = height;
    boardWidth = width;
    botMark = 2;
  }

  @Override
  public GameState doMove(GameState inputState) {
    BoardState state = inputState.getBoardState();
    chainFinder = new ChainFinder(state);

    //get legal moves (without conceding a point)
    //get possible captures
    fillPossibleMovesNoConcedeAndCaptures(state);

    boolean isEndgame = (possibleMovesNoConcede.size() == 0) && (possibleCaptures.size() == 0);
    if (isEndgame) {
      chainFinder.findChains();
    }

    WallCoordinate moveToDo;
    //make move decision
    if (possibleCaptures.size() == 0) {
      if (possibleMovesNoConcede.size() == 0) {
        LinkedList<Chain> chains = chainFinder.getChains();
        Chain smallestChain = chains.getFirst();
        moveToDo = smallestChain.head;
      } else {
        Random random = new Random();
        moveToDo = possibleMovesNoConcede.get(random.nextInt(possibleMovesNoConcede.size()));
      }
    } else {
      Random random = new Random();
      moveToDo = possibleCaptures.get(random.nextInt(possibleCaptures.size()));
    }

    possibleCaptures.clear();
    possibleMovesNoConcede.clear();

    int[] coordsOfMove = moveToDo.getIndexForm();
    state.setWallAi(coordsOfMove[0], coordsOfMove[1], coordsOfMove[2]);
    inputState.currentBoardState = state;
    inputState.botLastMove = moveToDo;

    //edit by Benjamin
    inputState.currentBoardCheck.boardChecker(botMark);

    return inputState;
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
