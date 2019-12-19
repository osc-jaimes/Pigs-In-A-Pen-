package com.example.pigsinapenteam2;

/**
 *  EasyBotPlayer: plays the game at easy difficulty.
 *    Uses the 'Greedy Else Random' algorithm (see GreedyElseRandom)
 *
 *  doMove(GameState) -> GameState:
 *    picks the move to do and applies it.
 */
public class EasyBotPlayer extends BotPlayer {
  Strategy strategy;

  //edit by Benjamin
  private final int BOT_MARK = 2;


  /**
   * EasyBotPlayer():
   *    constructor.
   */
  public EasyBotPlayer() {
    strategy = new GreedyElseRandom();
  }

  /**
   * doMove(GameState) -> GameState:
   *    picks the move to do and applies it.
   *
   * @param inputGameState: staring game state.
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

    return super.doMove(inputGameState);
  }
}
