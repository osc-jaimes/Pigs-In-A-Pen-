/**
 * Class for the multi-player play screen.
 * Controls button clicks on fences as well as logic for controlling the current turns.
 */
package com.example.pigsinapenteam2;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Oscar Jaimes
 */
public class MultiplayerPlayScreen extends PlayScreen {

  public Button confirmButtonPlayer1;
  public Button confirmButtonPlayer2;
  public HumanPlayer player2 = new HumanPlayer();

  private Player currentPlayer;

  public BoardState boardState;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);
    boardSizeSetter();

    scoreBoardDefaulter();
    isMultiplayer = true;
    confirmButtonPlayer1 = findViewById(R.id.confirmButtonPlayer1);
    confirmButtonPlayer2 = findViewById(R.id.confirmButtonPlayer2);
    confirmButtonPlayer2.setVisibility(View.GONE);
    this.pauseMenuLayout = findViewById(R.id.pauseMenuLayout);
    gameButtons.setVisibility(View.VISIBLE);

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
        confirmButtonPlayer1.setVisibility(View.VISIBLE);
        confirmButtonPlayer2.setVisibility(View.GONE);
      } else {
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
    if (MultiplayerSetupScreen.boardSize == 0) {
      width = 3;
      height = 2;
      this.gameButtons = findViewById(R.id.smallGameButtons); //smallButtons

    } else if (MultiplayerSetupScreen.boardSize == 1) {

      width = 4;
      height = 3;
      this.gameButtons = findViewById(R.id.mediumGameButtons); //mediumButtons
    } else if (MultiplayerSetupScreen.boardSize == 2) {
      width = 5;
      height = 4;
      //this.gameButtons = findViewById(R.id.largeGameButtons); //largeButtons
    }
  }
}
