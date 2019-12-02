package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Oscar Jaimes
 */
public class MultiplayerPlayScreen extends AppCompatActivity {

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

  private boolean isHorizontal;
  private boolean playerHasMoved;






  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_play_screen);
    this.confirmButtonPlayer1 = findViewById(R.id.confirmButtonPlayer1);
    this.confirmButtonPlayer2 = findViewById(R.id.confirmButtonPlayer2);

    this.player1 = new HumanPlayer();
    this.player2 = new HumanPlayer();

    this.currentPlayer = this.player1;

    this.playerHasMoved = false;
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
      this.confirmButtonPlayer1.setVisibility(View.VISIBLE);
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

  public void onClickPause(View v){
    pauseMenuLayout.setVisibility(View.VISIBLE);
    gameButtons.setVisibility(View.GONE);
    //Blur background -- TODO when mvp is done
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
   * Confirms the current chosen fence button and processes the move in the backend.
   * @param v
   */
  public void onClickConfirmationButton(View v) {
    this.currentButton.setClickable(false);
    this.currentButton = null;
    this.playerHasMoved = true;
    this.confirmButtonPlayer1.setVisibility(View.GONE);
    this.confirmAction(this.cellX, this.cellY, this.isHorizontal);
    //this.updateScore();
    if(gameState.player1Points + gameState.player2Points == totalScore){
      //endGame();
    }
    System.out.println(this.gameState.currentBoardState);
  }

  public void confirmAction(int cellX, int cellY, boolean isHorizontal){

    int currentScore = this.gameState.player1Points;

    int lastPlayer1Score = gameState.player1Points;
    this.gameState = player1.doMove(this.gameState, cellX, cellY, isHorizontal);

    cellCheckAndUpdate(cellX, cellY, PLAYERONEINT);

    this.gameState.runBoardCheck();

    if(true){
      System.out.println("BOARD STATE BEFORE DO MOVE: ");
      System.out.println(this.gameState.currentBoardState);
      this.gameState = player2.doMove(this.gameState);
      String id = this.gameState.botLastMove.getButtonName();
      System.out.println(id);
      int resID = this.getResources().getIdentifier(id, "id", this.getPackageName());
      Button AIButton = findViewById(resID);
      AIButton.setBackgroundColor(getResources().getColor(R.color.fences));
      AIButton.setVisibility(View.VISIBLE);
      AIButton.setClickable(false);
    }

  }



  private void cellCheckAndUpdate(int cellX,int cellY, int playerInt){

    int checkedCellX = cellXCheck(cellX);
    int checkedCellY = cellYCheck(cellY);

    if(this.gameState.currentBoardState.isComplete(checkedCellX, checkedCellY)){

      this.gameState.currentBoardState.setCellState(checkedCellX, checkedCellY, playerInt);

    }//if statement
  }//cellCheckAndUpdate

  private int cellXCheck(int cellX){

    if(cellX >= HEIGHT){

      return cellX - 1;

    }//if statement

    else{

      return cellX;

    }//else statement
  }//cellXCheck

  private int cellYCheck(int cellY){

    if(cellY >= WIDTH){

      return cellY - 1;

    }//if statement

    else{

      return cellY;

    }//else statement
  }//cellYCheck


}
