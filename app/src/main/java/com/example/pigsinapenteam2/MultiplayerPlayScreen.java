/**
 * Class for the multi-player play screen.
 * Controls button clicks on fences as well as logic for controlling the current turns.
 */
package com.example.pigsinapenteam2;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Oscar Jaimes
 * edited by Jared Boonstra
 */
public class MultiplayerPlayScreen extends PlayScreen {

  public Button confirmButtonPlayer1;
  public Button confirmButtonPlayer2;
  public HumanPlayer player2 = new HumanPlayer();

  private Player currentPlayer;

  public BoardState boardState;

  ImageView playerOnePic;
  ImageView playerTwoPic;


  private int boardSize;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);
    playerOnePic = findViewById(R.id.player1);
    playerTwoPic = findViewById(R.id.player2);

    boardSizeSetter();
    characterSetter();

    gameButtons.setVisibility(View.VISIBLE);

    scoreBoardDefaulter();
    isMultiplayer = true;
    confirmButtonPlayer1 = findViewById(R.id.confirmButtonPlayer1);
    confirmButtonPlayer2 = findViewById(R.id.confirmButtonPlayer2);
    confirmButtonPlayer2.setVisibility(View.GONE);
    this.pauseMenuLayout = findViewById(R.id.pauseMenuLayout);
    rightIndicator = findViewById(R.id.RightIndicator);
    leftIndicator = findViewById(R.id.LeftIndicator);
    rightIndicator.setVisibility(View.GONE);

    pauseMenuLayout.setVisibility(View.GONE);
    confirmButtonPlayer1.setVisibility(View.VISIBLE);


    currentPlayer = player1;

    playerHasMoved = false;


    boardState = new BoardState(width, height);
    gameState = new GameState(boardState, player1, player2, 0);
    totalScore = (width * height);
  }


  /**
   * Highlights the fence button last clicked and displays the confirm button.
   *
   * @param V the button that is pressed.
   */
  public void buttonClicked(View V) {

    try {
      if (currentButton == null) {
        int buttonId = V.getId();
        Button currentButton = findViewById(buttonId);
        this.currentButton = currentButton;
        //this.confirmButtonPlayer1.setVisibility(View.VISIBLE);
        currentButton.setBackgroundColor(getResources().getColor(R.color.fences));
      } else {
        //if there already is a fence button chosen
        changeChoice(V);
      }
    } catch (Exception e) {
      return;
    }


  }

  /**
   * Changes the fence selection from currentButton to button V.
   *
   * @param V the button that is pressed.
   */
  public void changeChoice(View V) {
    int buttonId = V.getId();
    Button buttonClicked = findViewById(buttonId);
    currentButton.setBackgroundColor(getResources().getColor(R.color.transparent));
    buttonClicked.setBackgroundColor(getResources().getColor(R.color.fences));
    currentButton = buttonClicked;
  }

  /**
   * Confirms the current chosen fence button and processes the move in the backend.
   *
   * @param v the confirmation button pressed
   */
  public void onClickConfirmationButton(View v) throws InterruptedException {
    try {
      currentButton.setClickable(false);
      currentButton = null;
      playerHasMoved = true;
      confirmAction(cellX, cellY, isHorizontal);

      if (currentPlayer == player1) {
        rightIndicator.setVisibility(View.GONE);
        leftIndicator.setVisibility(View.VISIBLE);
        confirmButtonPlayer1.setVisibility(View.VISIBLE);
        confirmButtonPlayer2.setVisibility(View.GONE);
      } else {
        leftIndicator.setVisibility(View.GONE);
        rightIndicator.setVisibility(View.VISIBLE);
        confirmButtonPlayer2.setVisibility(View.VISIBLE);
        confirmButtonPlayer1.setVisibility(View.GONE);
      }
      if (gameState.player1Points + gameState.player2Points == totalScore) {
        endGame();
      }
    } catch (Exception e) {
      return;
    }

  }

  /**
   * Confrims the action of the player and sends respective x and y values of fence clicked to doMove().
   *
   * @param cellX        - the x position of the fence clicked
   * @param cellY        - the y position of the fence clicked
   * @param isHorizontal - If the fence clicked is horizontal
   */
  public void confirmAction(int cellX, int cellY, boolean isHorizontal) throws InterruptedException {
    if (currentPlayer == player1) {
      int tempScore = gameState.player1Points;
      gameState = player1.doMove(gameState, cellX, cellY, PLAYERONEINT, isHorizontal);
      updateClaimedCells(gameState.currentBoardState,boardSize);
      gameState.currentBoardCheck.scoreCheck();
      gameState.runBoardCheck();
      updateScore();
      if (gameState.player1Points > tempScore) {
        currentPlayer = player1;
        confirmButtonPlayer2.setVisibility(View.GONE);
        confirmButtonPlayer1.setVisibility(View.GONE);
        return;
      }
      currentPlayer = player2;
      confirmButtonPlayer1.setVisibility(View.GONE);
      confirmButtonPlayer2.setVisibility(View.VISIBLE);

    } else {
      int tempScore = gameState.player2Points;
      gameState = player2.doMove(gameState, cellX, cellY, PLAYERTWOINT, isHorizontal);
      updateClaimedCells(gameState.currentBoardState,boardSize);
      gameState.currentBoardCheck.scoreCheck();
      gameState.runBoardCheck();
      updateScore();
      if (gameState.player2Points > tempScore) {
        currentPlayer = player2;
        confirmButtonPlayer1.setVisibility(View.GONE);
        confirmButtonPlayer2.setVisibility(View.GONE);
        return;
      }
      currentPlayer = player1;
      confirmButtonPlayer2.setVisibility(View.GONE);
      confirmButtonPlayer1.setVisibility(View.VISIBLE);

    }

  }

  public void boardSizeSetter() {
    boardSize = MultiplayerSetupScreen.boardSize;
    if (boardSize == 0) {
      width = 3;
      height = 2;
      this.gameButtons = findViewById(R.id.smallGameButtons); //smallButtons

    } else if (boardSize == 1) {

      width = 4;
      height = 3;
      this.gameButtons = findViewById(R.id.mediumGameButtons); //mediumButtons
    } else if (boardSize == 2) {
      width = 5;
      height = 4;
      this.gameButtons = findViewById(R.id.largeGameButtons); //largeButtons
    }
  }

  public void characterSetter(){
    if(MultiplayerSetupScreen.player1Animal.equals("dog")){
      playerOnePic.setImageResource(R.drawable.dog);
    } else if(MultiplayerSetupScreen.player1Animal.equals("cat")){
      playerOnePic.setImageResource(R.drawable.cat);
    } else if(MultiplayerSetupScreen.player1Animal.equals("cow")){
      playerOnePic.setImageResource(R.drawable.cow);
    } else if(MultiplayerSetupScreen.player1Animal.equals("pig")){
      playerOnePic.setImageResource(R.drawable.pig);
    }else{
      playerOnePic.setImageResource(R.drawable.pig);
    }

    if(MultiplayerSetupScreen.player2Animal.equals("rooster")){
      playerTwoPic.setImageResource(R.drawable.rooster);
    } else if(MultiplayerSetupScreen.player2Animal.equals("horse")){
      playerTwoPic.setImageResource(R.drawable.horse);
    } else if(MultiplayerSetupScreen.player2Animal.equals("sheep")){
      playerTwoPic.setImageResource(R.drawable.sheep);
    } else if(MultiplayerSetupScreen.player2Animal.equals("pig")){
      playerTwoPic.setImageResource(R.drawable.pig);
    }
  }
  public void onResume(){
    super.onResume();
    ScreenLogic.fullScreen(this);
  }
}
