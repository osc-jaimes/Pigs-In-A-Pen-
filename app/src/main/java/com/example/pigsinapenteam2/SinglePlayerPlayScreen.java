/**
 * Jared Boonstra - 1572694
 *
 * SinglePlayerPlayScreen.java
 *
 * Sets up the board and calls functions from PlayScreen and this class to play the game.
 */
package com.example.pigsinapenteam2;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SinglePlayerPlayScreen extends PlayScreen {


  //Players
  public BotPlayer player2;
  private Player currentPlayer;
  private int boardSize;
  private int boardType;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    isMultiplayer = false;
    boardSize = SinglePlayerSetupScreen.boardSize;
    boardType = SinglePlayerSetupScreen.boardType;


   boardSizeSetter();
   difficultySetter();
   scoreBoardDefaulter();
   startGameButtonsGone();

    //===== Game Buttons Layout ======
    gameButtons.setVisibility(View.VISIBLE);
    //===== Players in game =======
    //player2 = new EasyBotPlayer();
    currentPlayer = player1;
    playerHasMoved = false;
    //===== Current Chosen 'Fence' Button =======
    currentButton = null;
    //===== Board State & Game State ======
    BoardState boardState = new BoardState(width,height);
    BoardType boardLayout = new BoardType(boardState,boardType, boardSize);
    gameState = new GameState(boardState, player1, player2,0);
    //===== Full Screen =====
    ScreenLogic.fullScreen(this);
    totalScore = (width * height);
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
        String id = gameState.botLastMove.getButtonName(SinglePlayerSetupScreen.boardSize);
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

  /**
   * boardSizeSetter
   *
   * Sets the correct board size on the screen to play
   */
  public void boardSizeSetter() {
    if (SinglePlayerSetupScreen.boardSize == 0) {
      width = 3;
      height = 2;
      this.gameButtons = findViewById(R.id.smallGameButtons); //smallButtons

    } else if (SinglePlayerSetupScreen.boardSize == 1) {

      width = 4;
      height = 3;
      this.gameButtons = findViewById(R.id.mediumGameButtons); //mediumButtons
    } else if (SinglePlayerSetupScreen.boardSize == 2) {
      width = 5;
      height = 4;
      this.gameButtons = findViewById(R.id.largeGameButtons); //largeButtons
    }
  }

  public void difficultySetter(){
    if(SinglePlayerSetupScreen.gameDifficulty == 0){
      this.player2 = new EasyBotPlayer();
    } else if(SinglePlayerSetupScreen.gameDifficulty == 1){
      this.player2 = new MediumBotPlayer();
    } else{
      this.player2 = new HardBotPlayer();
    }
  }





  public void residentSleeper(){
    try {
      Thread.sleep(1000);
    }catch (InterruptedException e){
      return;
    }
  }
}//singlePlayerPlayScreen