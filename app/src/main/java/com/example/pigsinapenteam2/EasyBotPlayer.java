package com.example.pigsinapenteam2;

/**
 * EasyBotPlayer: (easy mode) plays so you don't have to.
 */
public class EasyBotPlayer extends BotPlayer {
  Strategy strategy;

  //edit by Benjamin
  private final int BOT_MARK = 2;


  public EasyBotPlayer() {
    strategy = new GreedyElseRandom();
  }

  @Override
  public GameState doMove(GameState inputGameState) {
    //new and improved version
    BoardState oldBoard = inputGameState.currentBoardState;
    SimplifiedBoard simpleBoard = new SimplifiedBoard(oldBoard);
    BoardFlags flags = new BoardFlags(simpleBoard);

    WallCoordinate moveToDo = strategy.chooseMove(flags, simpleBoard);
    BoardState newBoard = super.applyMove(moveToDo, oldBoard);
    inputGameState.currentBoardState = newBoard;

    inputGameState.botLastMove = moveToDo;
    inputGameState.currentBoardCheck.boardChecker(BOT_MARK);

    return inputGameState;
  }
}
