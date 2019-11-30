package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SinglePlayerPlayScreen extends AppCompatActivity {
  //Instance Variables + instantiations
  GameState gameState;
  public final int WIDTH = 4;
  public final int HEIGHT = 3;
  HumanPlayer player1;
  BotPlayer player2;
  Button confirmButton;
  int cellX;
  int cellY;
  boolean playerHasMoved;
  boolean isHorizontal;
  Button currentButton;
  boolean confirmedAction;


  private Player currentPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    this.confirmButton = findViewById(R.id.confirmButtonPlayer1);
    //setting confirm button to not exist for now
    confirmButton.setVisibility(View.GONE);
    this.player1 = new HumanPlayer();
    this.player2 = new EasyBotPlayer();
    this.currentPlayer = player1;
    this.playerHasMoved = false;
    this.currentButton = null;
    BoardState boardState = new BoardState(WIDTH,HEIGHT);
    this.gameState = new GameState(boardState, this.player1, this.player2,0);

    this.getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
  }

  public void buttonClicked(View V){
    if(this.currentButton == null){
      int buttonId = V.getId();
      Button currentButton = findViewById(buttonId);
      this.currentButton = currentButton;
      this.confirmButton.setVisibility(View.VISIBLE);
      currentButton.setBackgroundColor(getResources().getColor(R.color.fences));
    } else{
      this.changeChoice(V);
    }


  }

  /**
   * Changes the fence selection from currentButton to button V.
   * @param V the button that is pressed
   */
  public void changeChoice(View V){
    int buttonId = V.getId();
    Button buttonClicked = findViewById(buttonId);
    this.currentButton.setBackgroundColor(getResources().getColor(R.color.transparent));
    buttonClicked.setBackgroundColor(getResources().getColor(R.color.fences));
    this.currentButton = buttonClicked;
  }

  public void onClickVertical1(View v){
    buttonClicked(v);
    cellX = 0;
    cellY = 0;
    isHorizontal = false;
  }

  public void onClickVertical2(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 0;
    isHorizontal = false;
  }

  public void onClickVertical3(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 0;
    isHorizontal = false;
  }

  public void onClickVertical4(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 1;
    isHorizontal = false;
  }

  public void onClickVertical5(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 1;
    isHorizontal = false;
  }

  public void onClickVertical6(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 1;
    isHorizontal = false;
  }

  public void onClickVertical7(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 2;
    isHorizontal = false;
  }

  public void onClickVertical8(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 2;
    isHorizontal = false;
  }
  public void onClickVertical9(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 2;
    isHorizontal = false;
  }
  public void onClickVertical10(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 3;
    isHorizontal = false;
  }
  public void onClickVertical11(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 3;
    isHorizontal = false;
  }
  public void onClickVertical12(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 3;
    isHorizontal = false;
  }
  public void onClickHorizontal1(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 0;
    isHorizontal = true;
  }
  public void onClickHorizontal2(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 0;
    isHorizontal = true;
  }
  public void onClickHorizontal3(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 0;
    isHorizontal = true;
  }
  public void onClickHorizontal4(View v) {
    this.buttonClicked(v);
    cellX = 3;
    cellY = 0;
    isHorizontal = true;
  }
  public void onClickHorizontal5(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 1;
    isHorizontal = true;
  }
  public void onClickHorizontal6(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 1;
    isHorizontal = true;
  }
  public void onClickHorizontal7(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 1;
    isHorizontal = true;
  }
  public void onClickHorizontal8(View v) {
    this.buttonClicked(v);
    cellX = 3;
    cellY = 1;
    isHorizontal = true;
  }
  public void onClickHorizontal9(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 2;
    isHorizontal = true;
  }
  public void onClickHorizontal10(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 2;
    isHorizontal = true;
  }
  public void onClickHorizontal11(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 2;
    isHorizontal = true;
  }
  public void onClickHorizontal12(View v) {
    this.buttonClicked(v);
    cellX = 3;
    cellY = 2;
    isHorizontal = true;
  }

  public void onClickConfirmationButton(View v) {
    this.currentButton = null;
    this.playerHasMoved = true;
    this.confirmButton.setVisibility(View.GONE);
    this.confirmAction(this.cellX, this.cellY, this.isHorizontal);
  }

  public void confirmAction(int cellX, int cellY, boolean isHorizontal){
    int currentScore = gameState.player1Points;
    player1.doMove(gameState, cellX, cellY, isHorizontal);
    //just placed a fence, no pen closed
    if(gameState.player1Points == currentScore){
      int botCurrentPoints = gameState.player2Points;
      do{
        this.gameState = player2.doMove(this.gameState);
      }while(botCurrentPoints < gameState.player2Points);
    }
  }
}