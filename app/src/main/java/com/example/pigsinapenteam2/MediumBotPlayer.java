package com.example.pigsinapenteam2;

public class MediumBotPlayer extends BotPlayer {
  private Strategy strategy;

  //edit by benjamin
  private final int BOT_MARK = 2;

  public MediumBotPlayer() {
    strategy = new GreedyElseNeutral();
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
