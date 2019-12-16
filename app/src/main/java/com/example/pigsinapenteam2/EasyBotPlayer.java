package com.example.pigsinapenteam2;

import java.util.LinkedList;
import java.util.Random;

/**
 * EasyBotPlayer: (easy mode) plays so you don't have to.
 */
public class EasyBotPlayer extends BotPlayer {
  private int boardHeight;
  private int boardWidth;
  private LinkedList<WallCoordinate> possibleCaptures;
  private LinkedList<WallCoordinate> possibleMoves;

  Strategy strategy;

  //edit by Benjamin
  private final int BOT_MARK = 2;


  public EasyBotPlayer(int height, int width) {
    super(height,width);
    boardHeight = height;
    boardWidth = width;
    possibleMoves = new LinkedList<>();
    possibleCaptures = new LinkedList<>();

    strategy = new GreedyElseRandom();
  }

  @Override
  public GameState doMove(GameState inputGameState) {
    /*
    BoardState state = inputGameState.currentBoardState;
    WallCoordinate moveToDo;

    fillPossibleCapturesAndMoves(state);
    moveToDo = chooseRandomMove();
    inputGameState.botLastMove = moveToDo;

    possibleCaptures.clear();
    possibleMoves.clear();

    int[] coordsOfMove = moveToDo.getIndexForm();
    state.setWallAi(coordsOfMove[0], coordsOfMove[1], coordsOfMove[2]);

    //TEST THIS: do we need this line? (yes)
    inputGameState.currentBoardState = state;

    //edit by Benjamin
    inputGameState.currentBoardCheck.boardChecker(BOT_MARK);

    return inputGameState;
     */

    //new and improved version
    BoardState oldBoard = inputGameState.currentBoardState;
    SimplifiedBoard simpleBoard = new SimplifiedBoard(oldBoard);
    BoardFlags flags = new BoardFlags(simpleBoard);

    WallCoordinate moveToDo = strategy.chooseMove(flags, simpleBoard);
    BoardState newBoard = super.applyMove(moveToDo, oldBoard);
    inputGameState.currentBoardState = newBoard;

    inputGameState.currentBoardCheck.boardChecker(BOT_MARK);

    return inputGameState;
  }

  private WallCoordinate chooseRandomMove() {
    Random random = new Random();
    if (possibleCaptures.size() == 0) {
      return possibleMoves.get(random.nextInt(possibleMoves.size()));
    } else {
      return possibleCaptures.get(random.nextInt(possibleCaptures.size()));
    }
  }

  private void fillPossibleCapturesAndMoves(BoardState state) {
    WallCoordinate currentWall;

    for (int yIndex = 0; yIndex < boardHeight; yIndex++) {
      for (int xIndex = 0; xIndex < boardWidth; xIndex++) {
        for (int wallIndex = 0; wallIndex < 4; wallIndex++) {
          currentWall = new WallCoordinate(xIndex, yIndex, wallIndex, boardHeight, boardWidth);

          //might be having object-related problems

          if (super.isWallLegal(state, currentWall)) {
            possibleMoves.add(currentWall);
            if (super.isWallACapture(state, currentWall)) {
              possibleCaptures.add(currentWall);
            }
          }
        }
      }
    }
  }
}
