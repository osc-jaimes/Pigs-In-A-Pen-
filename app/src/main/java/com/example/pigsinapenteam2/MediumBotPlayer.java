package com.example.pigsinapenteam2;

public class MediumBotPlayer extends BotPlayer {

  public void MediumBotPlayer(int height, int width) {
    super.BotPlayer(height, width, 1);
  }

  @Override
  public GameState doMove(GameState inputState) {
    return super.doMove(inputState);

    //horizontal walls: (during this loop do per-cell checks)
    //for 0 to height-1:
    // for 0 to width:
    //    -run stuff on left wall version
    //    -run stuff on right wall version
    //vertical walls:
    //for 0 to width-1:
    // for 0 to height:
    //    -run stuff on top wall version
    //    -run stuff on bottom wall version
  }
}
