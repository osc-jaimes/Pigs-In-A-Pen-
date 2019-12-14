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
      this.width = 3;
      this.height = 2;
      //this.gameButtons = findViewById(R.id.smallGameButtons); //smallButtons

    } else if (SinglePlayerSetupScreen.boardSize == 1) {

      this.width = 4;
      this.height = 3;
      //this.gameButtons = findViewById(R.id.mediumGameButtons); //mediumButtons
    } else if (SinglePlayerSetupScreen.boardSize == 2) {
      this.width = 5;
      this.height = 4;
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
    this.confirmButton = findViewById(R.id.confirmButtonPlayer1);
    confirmButton.setVisibility(View.GONE);
    //===== Pause Button ========
    this.pauseMenuLayout = findViewById(R.id.pauseMenuLayout);
    this.pauseMenuLayout.setVisibility(View.GONE);
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
    if(this.currentButton == null){
      int buttonId = V.getId();
      Button currentButton = findViewById(buttonId);
      this.currentButton = currentButton;
      this.confirmButton.setVisibility(View.VISIBLE);
      currentButton.setBackgroundColor(getResources().getColor(R.color.fences));
    } else{
      //if there already is a fence button chosen
      this.changeChoice(V);
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
    this.currentButton = buttonClicked;
  }

}
