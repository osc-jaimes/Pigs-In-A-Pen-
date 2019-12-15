package com.example.pigsinapenteam2;

import java.util.LinkedList;
import java.util.Random;

public class HardBotPlayer extends BotPlayer {
  private ChainFinder chainFinder;
  private LinkedList<WallCoordinate> possibleMovesNoConcedeNoCapture;
  private LinkedList<WallCoordinate> possibleCaptures;
  private boolean isEndgame;
  private int boardHeight;
  private int boardWidth;

  //edit by benjamin
  private int botMark;

  public HardBotPlayer() {
    super();
    possibleMovesNoConcedeNoCapture = new LinkedList<>();
    possibleCaptures = new LinkedList<>();
    boardHeight = 0;
    boardWidth = 0;
    botMark = 2;
  }

  public HardBotPlayer(int height, int width) {
    super(height, width);
    possibleCaptures = new LinkedList<>();
    possibleMovesNoConcedeNoCapture = new LinkedList<>();
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

    if (!isEndgame) {
      //CHANGE THIS CONDITION TO:
      // (every move gives someone a point): DONE
      isEndgame = (possibleMovesNoConcedeNoCapture.size() == 0);
    }

    boolean smallFirstChain = false;
    boolean firstChainOpenTailDirection = false;
    boolean firstChainOpenHeadDirection = false;
    WallCoordinate firstChainHead = new WallCoordinate();
    WallCoordinate firstChainTail = new WallCoordinate();

    boolean shouldDoGambit = false;

    if (isEndgame) {
      chainFinder.findChains();
      LinkedList<Chain> chains = chainFinder.getChains();
      if (chains.size() > 0) {
        Chain firstChain = chains.getFirst();
        smallFirstChain = (firstChain.length == 1);
        boolean chainHeadOpen = firstChain.getHeadOpen();
        boolean chainTailOpen = firstChain.getTailOpen();
        firstChainOpenHeadDirection = (chainHeadOpen && !chainTailOpen);
        firstChainOpenTailDirection = (chainTailOpen && !chainHeadOpen);
        firstChainHead = firstChain.head;
        firstChainTail = firstChain.tail;

        int yourExpectedPoints = 0;
        int theirExpectedPoints = 0;
        for (int i = 0; i < chains.size(); i++) {
          if (i % 2 == 0) {
            yourExpectedPoints += chains.get(i).pointValue();
          } else if (i % 2 == 1) {
            theirExpectedPoints += chains.get(i).pointValue();
          } else {
            assert (false) : "ALGEBRA ERROR.";
          }
        }
        shouldDoGambit = (yourExpectedPoints < theirExpectedPoints);
      }
    }

    WallCoordinate moveToDo;
    //make move decision

    boolean canDoGambit = smallFirstChain &&
        (firstChainOpenHeadDirection || firstChainOpenTailDirection);


    if (canDoGambit && shouldDoGambit) {
      if (firstChainOpenHeadDirection) {
        moveToDo = firstChainHead;
      } else if (firstChainOpenTailDirection) {
        moveToDo = firstChainTail;
      } else {
        assert (false) : "LOGIC ERROR.";
        moveToDo = new WallCoordinate();
      }
    } else {
      if (possibleCaptures.size() == 0) {
        if (possibleMovesNoConcedeNoCapture.size() == 0) {
          LinkedList<Chain> chains = chainFinder.getChains();
          Chain smallestChain = chains.getFirst();
          moveToDo = smallestChain.head;
        } else {
          Random random = new Random();
          moveToDo = possibleMovesNoConcedeNoCapture.get(random.nextInt(possibleMovesNoConcedeNoCapture.size()));
        }
      } else {
        Random random = new Random();
        moveToDo = possibleCaptures.get(random.nextInt(possibleCaptures.size()));
      }
    }

    possibleCaptures.clear();
    possibleMovesNoConcedeNoCapture.clear();

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
          currentWall = new WallCoordinate(xIndex, yIndex, wallIndex, boardHeight, boardWidth);

          if (super.isWallLegal(state, currentWall)) {
            if (super.isWallACapture(state, currentWall)) {
              possibleCaptures.add(currentWall);
            } else if (!super.willWallConcedePoint(state, currentWall)) {
              possibleMovesNoConcedeNoCapture.add(currentWall);
            }
          }
        }
      }
    }
  }
}
