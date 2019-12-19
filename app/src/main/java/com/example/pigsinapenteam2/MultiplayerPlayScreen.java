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
  private int boardType;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);
    playerOnePic = findViewById(R.id.player1);
    playerTwoPic = findViewById(R.id.player2);
    boardType = MultiplayerSetupScreen.boardType;


    boardSizeSetter();
    layoutSetter();
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
    BoardType boardLayout = new BoardType(boardState,boardType,boardSize);
    gameState = new GameState(boardState, player1, player2, 0);
    totalScore = totalScoreCalculator();
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
      System.out.println("the Total Score is: " + totalScore);
      System.out.println("playerOne + playerTwo is: "+ gameState.player1Points + gameState.player2Points);
      if (gameState.player1Points + gameState.player2Points == totalScore) {
        endGame();
        return;
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
  public void confirmAction(int cellX, int cellY, boolean isHorizontal) {
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

      if (gameState.player1Points + gameState.player2Points == totalScore) {
        endGame();
      }
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
    }else if(MultiplayerSetupScreen.player1Animal.isEmpty()){
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
    } else if(MultiplayerSetupScreen.player2Animal.isEmpty()){
      playerTwoPic.setImageResource(R.drawable.sheep);
    }
  }
  public void onResume(){
    super.onResume();
    ScreenLogic.fullScreen(this);
  }

  /**
   * LayoutSetter
   *
   * sets the map for the game from garden, as well as other maps
   */
  public void layoutSetter(){
    if(MultiplayerSetupScreen.boardSize == 0){
      if(MultiplayerSetupScreen.boardType == 1){
        return;
      } else if(MultiplayerSetupScreen.boardType == 2){
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

        Button garden3Top = findViewById(R.id.v2);
        garden3Top.setClickable(false);
        garden3Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden3right = findViewById(R.id.v5);
        garden3right.setClickable(false);
        garden3right.setBackgroundColor(getResources().getColor(R.color.fences));

        Button h5 = findViewById(R.id.h5);
        h5.setClickable(false);
        h5.setBackgroundColor(getResources().getColor(R.color.fences));

        Button h3 = findViewById(R.id.h3);
        h3.setClickable(false);
        h3.setBackgroundColor(getResources().getColor(R.color.fences));


      }//small gardens
      else if(MultiplayerSetupScreen.boardType == 3){
        ImageView hill1 = findViewById(R.id.hill1);
        hill1.setVisibility(View.VISIBLE);
        ImageView hill2 = findViewById(R.id.hill2);
        hill2.setVisibility(View.VISIBLE);

        Button hill1Top = findViewById(R.id.h1);
        hill1Top.setClickable(false);
        hill1Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button hill2Top = findViewById(R.id.h4);
        hill2Top.setClickable(false);
        hill2Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button hill3Top = findViewById(R.id.h7);
        hill3Top.setClickable(false);
        hill3Top.setBackgroundColor(getResources().getColor(R.color.fences));
      }//hill map small
    }//map size small
    else if(MultiplayerSetupScreen.boardSize == 1){
      if(boardType == 1){
        return;
      }//if statement

      else if(boardType == 2) {
        ImageView garden3 = findViewById(R.id.garden3);
        garden3.setVisibility(View.VISIBLE);
        ImageView garden4 = findViewById(R.id.garden4);
        garden4.setVisibility(View.VISIBLE);
        ImageView garden5 = findViewById(R.id.garden5);
        garden5.setVisibility(View.VISIBLE);
        ImageView garden6 = findViewById(R.id.garden6);
        garden6.setVisibility(View.VISIBLE);

        Button garden1Top = findViewById(R.id.h12);
        garden1Top.setClickable(false);
        garden1Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden1Right = findViewById(R.id.v12);
        garden1Right.setClickable(false);
        garden1Right.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden2Top = findViewById(R.id.h16);
        garden2Top.setClickable(false);
        garden2Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden2Right = findViewById(R.id.v13);
        garden2Right.setClickable(false);
        garden2Right.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden3Top = findViewById(R.id.h17);
        garden3Top.setClickable(false);
        garden3Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden3right = findViewById(R.id.v17);
        garden3right.setClickable(false);
        garden3right.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden4Top = findViewById(R.id.h21);
        garden4Top.setClickable(false);
        garden4Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button v18 = findViewById(R.id.v18);
        v18.setClickable(false);
        v18.setBackgroundColor(getResources().getColor(R.color.fences));

        Button v11 = findViewById(R.id.v11);
        v11.setClickable(false);
        v11.setBackgroundColor(getResources().getColor(R.color.fences));

        Button v14 = findViewById(R.id.v14);
        v14.setClickable(false);
        v14.setBackgroundColor(getResources().getColor(R.color.fences));

        Button v16 = findViewById(R.id.v16);
        v16.setClickable(false);
        v16.setBackgroundColor(getResources().getColor(R.color.fences));

        Button v19 = findViewById(R.id.v19);
        v19.setClickable(false);
        v19.setBackgroundColor(getResources().getColor(R.color.fences));

        Button h13 = findViewById(R.id.h13);
        h13.setClickable(false);
        h13.setBackgroundColor(getResources().getColor(R.color.fences));

        Button h20 = findViewById(R.id.h20);
        h20.setClickable(false);
        h20.setBackgroundColor(getResources().getColor(R.color.fences));

      }//medium garden map


      else if(SinglePlayerSetupScreen.boardType == 3) {
        ImageView hill3 = findViewById(R.id.hill3);
        hill3.setVisibility(View.VISIBLE);
        ImageView hill4 = findViewById(R.id.hill4);
        hill4.setVisibility(View.VISIBLE);

        Button hill3Top = findViewById(R.id.v15);
        hill3Top.setClickable(false);
        hill3Top.setBackgroundColor(getResources().getColor(R.color.fences));


      }//medium hill map
    }//else if medium
    else{
      if(boardType == 1){
        return;
      }//if statement

      else if(MultiplayerSetupScreen.boardType == 2) {
        ImageView garden7 = findViewById(R.id.garden7);
        garden7.setVisibility(View.VISIBLE);
        ImageView garden8 = findViewById(R.id.garden8);
        garden8.setVisibility(View.VISIBLE);
        ImageView garden9 = findViewById(R.id.garden9);
        garden9.setVisibility(View.VISIBLE);
        ImageView garden10 = findViewById(R.id.garden10);
        garden10.setVisibility(View.VISIBLE);
        ImageView garden11 = findViewById(R.id.garden11);
        garden11.setVisibility(View.VISIBLE);
        ImageView garden12 = findViewById(R.id.garden12);
        garden12.setVisibility(View.VISIBLE);




        Button garden1Top = findViewById(R.id.h28);
        garden1Top.setClickable(false);
        garden1Top.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden2Top = findViewById(R.id.h29);
        garden2Top.setClickable(false);
        garden2Top.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden3Top = findViewById(R.id.h34);
        garden3Top.setClickable(false);
        garden3Top.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden4Top = findViewById(R.id.h40);
        garden4Top.setClickable(false);
        garden4Top.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden5Top = findViewById(R.id.h45);
        garden5Top.setClickable(false);
        garden5Top.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden6Top = findViewById(R.id.h46);
        garden6Top.setClickable(false);
        garden6Top.setBackgroundColor(getResources().getColor(R.color.fences));

        Button garden1Right = findViewById(R.id.v27);
        garden1Right.setClickable(false);
        garden1Right.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden2Right = findViewById(R.id.v28);
        garden2Right.setClickable(false);
        garden2Right.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden3Right = findViewById(R.id.v34);
        garden3Right.setClickable(false);
        garden3Right.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden4Right = findViewById(R.id.v35);
        garden4Right.setClickable(false);
        garden4Right.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden5Right = findViewById(R.id.v41);
        garden5Right.setClickable(false);
        garden5Right.setBackgroundColor(getResources().getColor(R.color.fences));
        Button garden6Right = findViewById(R.id.v42);
        garden6Right.setClickable(false);
        garden6Right.setBackgroundColor(getResources().getColor(R.color.fences));

        Button v26 = findViewById(R.id.v26);
        v26.setClickable(false);
        v26.setBackgroundColor(getResources().getColor(R.color.fences));
        Button v33 = findViewById(R.id.v33);
        v33.setClickable(false);
        v33.setBackgroundColor(getResources().getColor(R.color.fences));
        Button v36 = findViewById(R.id.v36);
        v36.setClickable(false);
        v36.setBackgroundColor(getResources().getColor(R.color.fences));
        Button v43 = findViewById(R.id.v43);
        v43.setClickable(false);
        v43.setBackgroundColor(getResources().getColor(R.color.fences));

        Button h33 = findViewById(R.id.h33);
        h33.setClickable(false);
        h33.setBackgroundColor(getResources().getColor(R.color.fences));
        Button h35 = findViewById(R.id.h35);
        h35.setClickable(false);
        h35.setBackgroundColor(getResources().getColor(R.color.fences));
        Button h39 = findViewById(R.id.h39);
        h39.setClickable(false);
        h39.setBackgroundColor(getResources().getColor(R.color.fences));
        Button h41 = findViewById(R.id.h41);
        h41.setClickable(false);
        h41.setBackgroundColor(getResources().getColor(R.color.fences));


      }//garden large board
      else if(MultiplayerSetupScreen.boardType == 3) {
        ImageView hill5 = findViewById(R.id.hill5);
        hill5.setVisibility(View.VISIBLE);
        ImageView hill6 = findViewById(R.id.hill6);
        hill6.setVisibility(View.VISIBLE);

        Button hill3Top = findViewById(R.id.h37);
        hill3Top.setClickable(false);
        hill3Top.setBackgroundColor(getResources().getColor(R.color.fences));


      }//medium hill map
    }//large map
  }//layoutSetter
}
