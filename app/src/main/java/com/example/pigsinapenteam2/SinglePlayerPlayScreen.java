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
import android.widget.ImageView;

public class SinglePlayerPlayScreen extends PlayScreen {


  //Players
  public BotPlayer player2;
  private Player currentPlayer;
  private int boardSize;
  private int boardType;
  ImageView playerOnePicture;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    isMultiplayer = false;
    boardSize = SinglePlayerSetupScreen.boardSize;
    boardType = SinglePlayerSetupScreen.boardType;
    playerOnePicture = findViewById(R.id.player1);

   boardSizeSetter();
   difficultySetter();
   scoreBoardDefaulter();
   layoutSetter();
   animalSetter();
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
    boardState = new BoardState(width,height);
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

  public void animalSetter(){
    if(SinglePlayerSetupScreen.animal.equals("dog")){
      playerOnePicture.setImageResource(R.drawable.dog);
    }else if(SinglePlayerSetupScreen.animal.equals("cat")){
      playerOnePicture.setImageResource(R.drawable.cat);
    }else if(SinglePlayerSetupScreen.animal.equals("cow")){
      playerOnePicture.setImageResource(R.drawable.cow);
    }else if(SinglePlayerSetupScreen.animal.equals("pig")){
      playerOnePicture.setImageResource(R.drawable.pig);
    }
  }

  public void layoutSetter(){
    if(SinglePlayerSetupScreen.boardSize == 0){
      if(SinglePlayerSetupScreen.boardType == 1){
        return;
      } else if(SinglePlayerSetupScreen.boardType == 2){
        ImageView garden1 = findViewById(R.id.garden1);
        garden1.setVisibility(View.VISIBLE);
        ImageView garden2 = findViewById(R.id.garden2);
        garden2.setVisibility(View.VISIBLE);

        Button garden1Top = findViewById(R.id.h2);
        garden1Top.setClickable(false);
        garden1Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden1Right = findViewById(R.id.v3);
        garden1Right.setClickable(false);
        garden1Right.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden2Top = findViewById(R.id.h6);
        garden2Top.setClickable(false);
        garden2Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden2Right = findViewById(R.id.v4);
        garden2Right.setClickable(false);
        garden2Right.setBackgroundColor(getResources().getColor(R.color.fences));


      }//small gardens
      else if(SinglePlayerSetupScreen.boardType == 3){

      }//hill map small
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