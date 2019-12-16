package com.example.pigsinapenteam2;

/**
 *  HardBotPlayer: plays the game at hard difficulty.
 *    Uses the 'Greedy Else Neutral With Gambit' algorithm
 *    (see GreedyElseNeutralWithGambit)
 *
 *  doMove(GameState) -> GameState:
 *    picks the move to do and applies it.
 */
public class HardBotPlayer extends BotPlayer {
  private Strategy strategy;

  //edit by benjamin
  private final int BOT_MARK = 2;

  /**
   * HardBotPlayer():
   *    constructor.
   */
  public HardBotPlayer() {
    strategy = new GreedyElseNeutralWithGambit();
  }

  /**
   * doMove(GameState) -> GameState:
   *    picks the move to do and applies it.
   *
   * @param inputGameState: starting game state.
   * @return: new game state.
   */
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
