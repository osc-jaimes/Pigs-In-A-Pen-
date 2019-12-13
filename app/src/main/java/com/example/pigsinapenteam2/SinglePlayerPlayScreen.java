package com.example.pigsinapenteam2;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SinglePlayerPlayScreen extends AppCompatActivity {
  //==== Instance Variables =====

  //Game State
  public GameState gameState;

  //Players
  public HumanPlayer player1;
  public BotPlayer player2;

  //Final Variables
  public final int WIDTH = 3;
  public final int HEIGHT = 3;
  public final int PLAYERONEINT = 1;
  public final int PLAYERTWOINT = 2;

  //Buttons
  public Button confirmButton;
  public Button currentButton;

  //Views (Relative Views)
  public View pauseMenuLayout;
  public View gameButtons;
  TextView player1ScoreBoard;
  TextView player2ScoreBoard;

  //Ints
  public int cellX;
  public int cellY;
  public int totalScore;

  //Booleans
  public boolean playerHasMoved;
  public boolean isHorizontal;




  private Player currentPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    player1ScoreBoard = findViewById(R.id.player1Score);
    player1ScoreBoard.setText("0");
    player2ScoreBoard = findViewById(R.id.player2Score);
    player2ScoreBoard.setText("0");
    //===== Confirm Button ===========
    this.confirmButton = findViewById(R.id.confirmButtonPlayer1);
    confirmButton.setVisibility(View.GONE);
    //===== Pause Button ========
    this.pauseMenuLayout = findViewById(R.id.pauseMenuLayout);
    this.pauseMenuLayout.setVisibility(View.GONE);
    //===== Game Buttons Layout ======
    this.gameButtons = findViewById(R.id.gameButtons);
    //===== Players in game =======
    this.player1 = new HumanPlayer();
    this.player2 = new EasyBotPlayer(HEIGHT,WIDTH);
    this.currentPlayer = player1;
    this.playerHasMoved = false;
    //===== Current Chosen 'Fence' Button =======
    this.currentButton = null;
    //===== Board State & Game State ======
    BoardState boardState = new BoardState(WIDTH,HEIGHT);
    this.gameState = new GameState(boardState, this.player1, this.player2,0);
    //===== Full Screen =====
    ScreenLogic.fullScreen(this);
    this.totalScore = (WIDTH * HEIGHT) ;
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
   * Highlights the vertical fence button at position 1,3
   * and updates instance variables needed for backend logic
   * @param v
   */
  public void onClickVertical9(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 0;
    isHorizontal = false;
  }

  public void onClickVertical10(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 1;
    isHorizontal = false;
  }

  public void onClickVertical11(View v) {
    this.buttonClicked(v);
    cellX = 2;
    cellY = 2;
    isHorizontal = false;
  }

  public void onClickVertical12(View v) {
    this.buttonClicked(v);
    cellX = 2;
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

  public void onClickHorizontal10(View v) {
    this.buttonClicked(v);
    cellX = 3;
    cellY = 0;
    isHorizontal = true;
  }

  public void onClickHorizontal11(View v) {
    this.buttonClicked(v);
    cellX = 3;
    cellY = 1;
    isHorizontal = true;
  }

  public void onClickHorizontal12(View v) {
    this.buttonClicked(v);
    cellX = 3;
    cellY = 2;
    isHorizontal = true;
  }


  /**
   * Confirms the current chosen fence button and processes the move in the backend.
   * @param v
   */
  public void onClickConfirmationButton(View v) {
    System.out.println("Player 1: " + gameState.player1Points + ": " + gameState.player2Points);
    System.out.println(this.gameState.currentBoardState);
    this.currentButton.setClickable(false);
    this.currentButton = null;
    this.playerHasMoved = true;
    this.confirmButton.setVisibility(View.GONE);
    this.confirmAction(this.cellX, this.cellY, this.isHorizontal);
  }

  public void confirmAction(int cellX, int cellY, boolean isHorizontal){

    while(true) {

      int tempScore = this.gameState.player1Points;

      this.gameState = player1.doMove(this.gameState, cellX, cellY, PLAYERONEINT, isHorizontal);
      System.out.println(this.gameState.currentBoardState);

      System.out.println("playerOne Score is: " + gameState.player1Points);
      System.out.println("BOARD STATE BEFORE BoardCheck: ");
      System.out.println(this.gameState.currentBoardState);

      this.gameState.runBoardCheck();

    this.updateScore();
    if (gameState.player1Points + gameState.player2Points == totalScore) {
      endGame();
      return;
    }
      this.updateScore();
      if (gameState.player1Points + gameState.player2Points == totalScore) {
        endGame();
        return;
      }//if

      if(tempScore == this.gameState.player1Points){

        break;

      }//if

      else{

        return;

      }
    }//while loop

    while (true) {
      int tempScorePlayer2 = this.gameState.player2Points;
      if (true) {
        this.gameState = player2.doMove(this.gameState);


        String id = this.gameState.botLastMove.getButtonName();


      System.out.println("BOARD STATE BEFORE AI do MOVE: ");
      System.out.println(this.gameState.currentBoardState);
     this.gameState.runBoardCheck();
      this.updateScore();



        System.out.println("BOARD STATE BEFORE AI do MOVE: ");
        System.out.println(this.gameState.currentBoardState);
        this.gameState.runBoardCheck();

        System.out.println("AI score is: " + this.gameState.player2Points);
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

      if(tempScorePlayer2 == this.gameState.player2Points){
        break;
      }//if statement
    }//while loop

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



  public void updateScore() {
    player1ScoreBoard.setText("" + this.gameState.player1Points);
    player2ScoreBoard.setText("" + this.gameState.player2Points);
  }

}//singlePlayerPlayScreen