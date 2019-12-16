package com.example.pigsinapenteam2;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SinglePlayerPlayScreen extends PlayScreen {
  //==== Instance Variables =====

  //Game State

  //Players
  public BotPlayer player2;

  //Final Variables
  public final int PLAYERTWOINT = 2;
  //Booleans




  private Player currentPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    this.isMultiplayer = false;

   boardSizeSetter();
   scoreBoardDefaulter();
   startGameButtonsGone();

    //===== Game Buttons Layout ======
    gameButtons = findViewById(R.id.gameButtons); //this'll need to go after the sizes are all made
    //===== Players in game =======
    player2 = new EasyBotPlayer(height,width);
    currentPlayer = player1;
    playerHasMoved = false;
    //===== Current Chosen 'Fence' Button =======
    currentButton = null;
    //===== Board State & Game State ======
    BoardState boardState = new BoardState(width,height);
    gameState = new GameState(boardState, player1, player2,0);
    //===== Full Screen =====
    ScreenLogic.fullScreen(this);
    totalScore = (width * height) ;
  }


  /**
   * Confirms the current chosen fence button and processes the move in the backend.
   * @param v
   */
  public void onClickConfirmationButton(View v) {
    currentButton.setClickable(false);
    currentButton = null;
    playerHasMoved = true;
    confirmButton.setVisibility(View.GONE);
    confirmAction(cellX, cellY, isHorizontal);
  }

  public void confirmAction(int cellX, int cellY, boolean isHorizontal){

    while(true) {

      int tempScore = gameState.player1Points;
      gameState = player1.doMove(gameState, cellX, cellY, PLAYERONEINT, isHorizontal);
      gameState.runBoardCheck();
      updateScore();

    if (gameState.player1Points + gameState.player2Points == totalScore) {
      endGame();
      return;
    }

      this.updateScore();
      if (gameState.player1Points + gameState.player2Points == totalScore) {
        endGame();
        return;
      }//if

      if(tempScore == gameState.player1Points){

        break;

      }//if

      else{

        return;

      }
    }//while loop

    while (true) {
      int tempScorePlayer2 = gameState.player2Points;
      if (true) {
        gameState = player2.doMove(gameState);
        String id = gameState.botLastMove.getButtonName();
        gameState.runBoardCheck();
        updateScore();
        gameState.runBoardCheck();
        int resID = this.getResources().getIdentifier(id, "id", this.getPackageName());
        Button AIButton = findViewById(resID);
        AIButton.setBackgroundColor(getResources().getColor(R.color.fences));
        AIButton.setVisibility(View.VISIBLE);
        AIButton.setClickable(false);
      }//if statement

      if (gameState.player1Points + gameState.player2Points == totalScore) {
        endGame();
        return;
      }//if

      if(tempScorePlayer2 == gameState.player2Points){
        break;
      }//if statement
    }//while loop

  }
}//singlePlayerPlayScreen