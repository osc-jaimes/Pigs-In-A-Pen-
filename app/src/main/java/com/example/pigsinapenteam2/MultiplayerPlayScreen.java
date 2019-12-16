/**
 * Class for the multi-player play screen.
 * Controls button clicks on fences as well as logic for controlling the current turns.
 */
package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Oscar Jaimes
 */
public class MultiplayerPlayScreen extends PlayScreen {

  public Button currentButton;
  public Button confirmButtonPlayer1;
  public Button confirmButtonPlayer2;

  public int cellX;
  public int cellY;
  public int totalScore;

  public final int HEIGHT = 2;
  public final int WIDTH = 3;
  public final int PLAYERONEINT = 1;
  public final int PLAYERTWOINT = 2;

  public HumanPlayer player1;
  public HumanPlayer player2;

  private Player currentPlayer;

  public GameState gameState;
  public BoardState boardState;

  public View pauseMenuLayout;
  public View gameButtons;

  TextView player1ScoreBoard;
  TextView player2ScoreBoard;



  private boolean isHorizontal;
  private boolean playerHasMoved;






  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);

    this.isMultiplayer = true;
    this.confirmButtonPlayer1 = findViewById(R.id.confirmButtonPlayer1);
    this.confirmButtonPlayer2 = findViewById(R.id.confirmButtonPlayer2);
    this.confirmButtonPlayer2.setVisibility(View.GONE);
    this.pauseMenuLayout = findViewById(R.id.pauseMenuLayout);
    this.gameButtons = findViewById(R.id.gameButtons);

    this.player1ScoreBoard = findViewById(R.id.player1Score);
    this.player2ScoreBoard = findViewById(R.id.player2Score);



    this.pauseMenuLayout.setVisibility(View.GONE);
    confirmButtonPlayer1.setVisibility(View.VISIBLE);

    this.player1 = new HumanPlayer();
    this.player2 = new HumanPlayer();

    this.currentPlayer = this.player1;

    this.playerHasMoved = false;

    this.currentPlayer = this.player1;

    BoardState boardState = new BoardState(WIDTH,HEIGHT);
    this.gameState = new GameState(boardState, this.player1, this.player2,0);
    this.gameState.player1Points = 0;
    this.gameState.player2Points = 0;
    this.totalScore = 6;
  }



  /**
   * Highlights the fence button last clicked and displays the confirm button.
   * @param V the button that is pressed.
   */
  public void buttonClicked(View V){

    try {
      if (this.currentButton == null) {
        int buttonId = V.getId();
        Button currentButton = findViewById(buttonId);
        this.currentButton = currentButton;
        //this.confirmButtonPlayer1.setVisibility(View.VISIBLE);
        currentButton.setBackgroundColor(getResources().getColor(R.color.fences));
      } else {
        //if there already is a fence button chosen
        this.changeChoice(V);
      }
    }catch(Exception e){
      return;
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

  /**
   * Highlights the vertical fence button at position 0,0
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical1(View v){
    buttonClicked(v);
    cellX = 0;
    cellY = 0;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 0,1
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical2(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 1;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 0,2
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical3(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 2;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 0,3
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical4(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 3;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 1,0
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical5(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 0;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 1,1
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical6(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 1;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 1,2
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical7(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 2;
    isHorizontal = false;
  }

  /**
   * Highlights the vertical fence button at position 1,3
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical8(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 3;
    isHorizontal = false;
  }

  /**
   * Highlights the horizontal fence button at position 0,0
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal1(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 0;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 0,1
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal2(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 1;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 0,2
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal3(View v) {
    this.buttonClicked(v);
    cellX = 0;
    cellY = 2;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 1,0
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal4(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 0;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 1,1
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal5(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 1;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 1,2
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal6(View v) {
    this.buttonClicked(v);
    cellX = 1;
    cellY = 2;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 2,0
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal7(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 0;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 2,1
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal8(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 1;
    isHorizontal = true;
  }

  /**
   * Highlights the horizontal fence button at position 2,2
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickHorizontal9(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 2;
    isHorizontal = true;
  }

  /**
   * On click method to pause the game
   * @param v the button that is being pressed
   */
  public void onClickPause(View v){
    pauseMenuLayout.setVisibility(View.VISIBLE);
    gameButtons.setVisibility(View.GONE);
    //Blur background -- TODO when mvp is done
  }

  /**
   * Method for the resume button being clicked
   * @param v the button that is clicked
   */
  public void resumeButton(View v){
    gameButtons.setVisibility(View.VISIBLE);
    pauseMenuLayout.setVisibility(View.GONE);
  }

  /**
   * Method that goes to the main menu when the menu button is clicked in the pause menu.
   * @param v the button that is clicked
   */
  public void pauseToMainMenu(View v){
    Intent goToMainMenu = new Intent(getApplicationContext(), MainScreen.class);
    startActivity(goToMainMenu);
  }

  /**
   * Restarts the current game
   * @param v the button that is clicked
   */
  public void restartButton(View v){
    this.recreate();
  }



  /**
   * Confirms the current chosen fence button and processes the move in the backend.
   * @param v the confirmation button pressed
   */
  public void onClickConfirmationButton(View v) throws InterruptedException {
    try {
      this.currentButton.setClickable(false);
      this.currentButton = null;
      this.playerHasMoved = true;
      this.confirmAction(this.cellX, this.cellY, this.isHorizontal);

      if (this.currentPlayer == this.player1) {
        this.confirmButtonPlayer1.setVisibility(View.VISIBLE);
        this.confirmButtonPlayer2.setVisibility(View.GONE);
      } else {
        this.confirmButtonPlayer2.setVisibility(View.VISIBLE);
        this.confirmButtonPlayer1.setVisibility(View.GONE);
      }
      if (this.gameState.player1Points + this.gameState.player2Points == this.totalScore) {
        endGame();
      }
    }catch(Exception e){
      return;
    }

  }

  /**
   * Confrims the action of the player and sends respective x and y values of fence clicked to doMove().
   * @param cellX - the x position of the fence clicked
   * @param cellY - the y position of the fence clicked
   * @param isHorizontal - If the fence clicked is horizontal
   */
  public void confirmAction(int cellX, int cellY, boolean isHorizontal) throws InterruptedException{

    if(this.currentPlayer == this.player1) {
      System.out.println("Player 1 Points: " + this.gameState.player1Points);
      int tempScore = this.gameState.player1Points;
      this.gameState = player1.doMove(this.gameState, cellX, cellY, PLAYERONEINT, isHorizontal);
      this.gameState.runBoardCheck();
      this.updateScore();
      if(this.gameState.player1Points > tempScore){
        this.currentPlayer = this.player1;
        this.confirmButtonPlayer2.setVisibility(View.GONE);
        this.confirmButtonPlayer1.setVisibility(View.GONE);
        return;
      }
      this.currentPlayer = this.player2;
      this.confirmButtonPlayer1.setVisibility(View.GONE);
      this.confirmButtonPlayer2.setVisibility(View.VISIBLE);

    }else{
      System.out.println("Player 2 Points: " + this.gameState.player2Points);
      int tempScore = this.gameState.player2Points;
      this.gameState = player2.doMove(this.gameState, cellX, cellY, PLAYERTWOINT, isHorizontal);
      this.gameState.runBoardCheck();
      this.updateScore();
      if(this.gameState.player2Points > tempScore){
        this.currentPlayer = this.player2;
        this.confirmButtonPlayer1.setVisibility(View.GONE);
        this.confirmButtonPlayer2.setVisibility(View.GONE);
        return;
      }
      this.currentPlayer = this.player1;
      this.confirmButtonPlayer2.setVisibility(View.GONE);
      this.confirmButtonPlayer1.setVisibility(View.VISIBLE);

    }
  }


  public void updateScore() {
    player1ScoreBoard.setText("" + this.gameState.player1Points);
    player2ScoreBoard.setText("" + this.gameState.player2Points);
  }
}
