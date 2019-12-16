package com.example.pigsinapenteam2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayScreen extends AppCompatActivity {

  //Game State
  public GameState gameState;

  //players
  public HumanPlayer player1 = new HumanPlayer();

  public final int PLAYERONEINT = 1;

  //Buttons
  public Button confirmButton;
  public Button currentButton;

  //Views
  public View pauseMenuLayout;
  public View gameButtons;
  public View smallGameButtons; //for when sizes are in - also need normal + large
  TextView player1ScoreBoard;
  TextView player2ScoreBoard;

  //Ints
  public int cellX;
  public int cellY;
  public int totalScore;
  public int width;
  public int height;

  //Bools
  public boolean playerHasMoved;
  public boolean isHorizontal;
  public static boolean isMultiplayer;

  public void boardSizeSetter() {
    if (SinglePlayerSetupScreen.boardSize == 0) {
      width = 3;
      height = 2;
      //this.gameButtons = findViewById(R.id.smallGameButtons); //smallButtons

    } else if (SinglePlayerSetupScreen.boardSize == 1) {

      width = 4;
      height = 3;
      //this.gameButtons = findViewById(R.id.mediumGameButtons); //mediumButtons
    } else if (SinglePlayerSetupScreen.boardSize == 2) {
      width = 5;
      height = 4;
      //this.gameButtons = findViewById(R.id.largeGameButtons); //largeButtons
    }
  }
  public void scoreBoardDefaulter(){
    player1ScoreBoard = findViewById(R.id.player1Score);
    player1ScoreBoard.setText("0");
    player2ScoreBoard = findViewById(R.id.player2Score);
    player2ScoreBoard.setText("0");
  }

  public void startGameButtonsGone(){
    //===== Confirm Button ===========
    confirmButton = findViewById(R.id.confirmButtonPlayer1);
    confirmButton.setVisibility(View.GONE);
    //===== Pause Button ========
    pauseMenuLayout = findViewById(R.id.pauseMenuLayout);
    pauseMenuLayout.setVisibility(View.GONE);
  }

  public void onClickPause(View v){
    pauseMenuLayout.setVisibility(View.VISIBLE);
    gameButtons.setVisibility(View.GONE);
  }

  public void resumeButton(View v){
    gameButtons.setVisibility(View.VISIBLE);
    pauseMenuLayout.setVisibility(View.GONE);
  }

  public void pauseToMainMenu(View v){
    Intent goToMainMenu = new Intent(getApplicationContext(), MainScreen.class);
    startActivity(goToMainMenu);
  }
  public void restartButton(View v){
    this.recreate();
  }

  /**
   * Highlights the fence button last clicked and displays the confirm button.
   * @param V the button that is pressed.
   */
  public void buttonClicked(View V){
    if(currentButton == null){
      int buttonId = V.getId();
      Button currentButton = findViewById(buttonId);
      this.currentButton = currentButton;
      confirmButton.setVisibility(View.VISIBLE);
      currentButton.setBackgroundColor(getResources().getColor(R.color.fences));
    } else{
      //if there already is a fence button chosen
      changeChoice(V);
    }


  }

  /**
   * Changes the fence selection from currentButton to button V.
   * @param V the button that is pressed.
   */
  public void changeChoice(View V){
    int buttonId = V.getId();
    Button buttonClicked = findViewById(buttonId);
    this.currentButton.setBackgroundColor(getResources().getColor(R.color.transparent));
    buttonClicked.setBackgroundColor(getResources().getColor(R.color.fences));
    currentButton = buttonClicked;
  }

  public void updateScore() {
    player1ScoreBoard.setText("" + gameState.player1Points);
    player2ScoreBoard.setText("" + this.gameState.player2Points);
  }
  public void endGame(){
    Intent goToWinScreen = new Intent(getApplicationContext(), VictoryScreen.class);
    if(gameState.player2Points > gameState.player1Points){
      goToWinScreen.putExtra("playerWhoWon", 1);
    }
    else if(gameState.player1Points > gameState.player2Points){
      goToWinScreen.putExtra("playerWhoWon", 0);
    }
    else if(gameState.player1Points == gameState.player2Points){
      goToWinScreen.putExtra("playerWhoWon", 2);
    }
    startActivity(goToWinScreen);
  }
}
