package com.example.pigsinapenteam2;

/**
 *  HardBotPlayer: plays the game at hard difficulty.
 *    If the smallest chain is of size two and it would benefit from doing so,
 *    it gives the chain away to the player in order to take the chains the player
 *    normally would take otherwise. If this is not possible, do the same as
 *    Medium-difficulty bot.
 *
 *  doMove(GameState) -> GameState:
 *    picks the move to do and applies it.
 */
public class HardBotPlayer extends BotPlayer {
  private Strategy strategy;

  //edit by benjamin
  private final int BOT_MARK = 2;

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
