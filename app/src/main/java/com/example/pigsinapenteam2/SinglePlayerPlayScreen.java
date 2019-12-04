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
  public final int HEIGHT = 2;
  public final int PLAYERONEINT = 1;
  public final int PLAYERTWOINT = 2;

  //Buttons
  public Button confirmButton;
  public Button currentButton;

  //Views (Relative Views)
  public View pauseMenuLayout;
  public View gameButtons;

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
   * Confirms the current chosen fence button and processes the move in the backend.
   * @param v
   */
  public void onClickConfirmationButton(View v) {
    this.currentButton.setClickable(false);
    this.currentButton = null;
    this.playerHasMoved = true;
    this.confirmButton.setVisibility(View.GONE);
    this.confirmAction(this.cellX, this.cellY, this.isHorizontal);
    this.updateScore();
    if(gameState.player1Points + gameState.player2Points == totalScore){
      //endGame();
    }
    System.out.println(this.gameState.currentBoardState);
  }

  public void confirmAction(int cellX, int cellY, boolean isHorizontal){

    this.gameState = player1.doMove(this.gameState, cellX, cellY, isHorizontal);

    cellCheckAndUpdate(cellX, cellY, PLAYERONEINT);

    this.gameState.runBoardCheck();

    if(true){

      System.out.println("BOARD STATE BEFORE DO MOVE: ");
      System.out.println(this.gameState.currentBoardState);

     this.gameState = player2.doMove(this.gameState);


     String id = this.gameState.botLastMove.getButtonName();
     System.out.println(id);

     botButtonChecker(id);
     this.gameState.runBoardCheck();

     int resID = this.getResources().getIdentifier(id, "id", this.getPackageName());
     Button AIButton = findViewById(resID);



     AIButton.setBackgroundColor(getResources().getColor(R.color.fences));
     AIButton.setVisibility(View.VISIBLE);
     AIButton.setClickable(false);
    }

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



  public void updateScore() {
    TextView tv = (TextView) findViewById(R.id.player1Score);
    tv.setText("" + this.gameState.player1Points);
  }
//NEEDS SCREENS - menu options.
  /**public void endGame(){
      if(gameState.player2Points > gameState.player1Points){
        Intent goToLoseScreen = new Intent(getApplicationContext(), LoseScreen.class);
        startActivity(goToLoseScreen);
      }
      Intent goToWinScreen = new Intent(getApplicationContext(), VictoryScreen.class);
      startActivity(goToWinScreen);
    }
    public void onClickPause(View v){
    pauseMenu.setVisibility(View.VISIBLE);
    //Blur background -- TODO when mvp is done
    }
    public void resumeButton(View v){
    pauseButton.setVisibility(View.GONE);
    }
    public void restartButton(View v){
    this.recreate();
    //Not sure if this works. If not, use startActivity.
    }
    public void mainMenuButton(View v){
    Intent goToMainMenu = new Intent(getApplicationContext(), MainScreen.class);
    startActivity(goToMainMenu);
    }*/


  private void cellCheckAndUpdate(int cellX,int cellY, int playerInt){

    System.out.println("hit cellCheckAndUpdate");

    int checkedCellX = cellXCheck(cellX);
    int checkedCellY = cellYCheck(cellY);

    if(this.gameState.currentBoardState.isComplete(checkedCellX, checkedCellY)){

      this.gameState.currentBoardState.setCellState(checkedCellX, checkedCellY, playerInt);

    }//if statement

    else if(checkedCellX > 0){

      if(this.gameState.currentBoardState.isComplete(checkedCellX -1, checkedCellY)){

        this.gameState.currentBoardState.setCellState(checkedCellX -1,checkedCellY, playerInt);

      }//if
    }//else if

    else if(checkedCellY  > 0){

      if(this.gameState.currentBoardState.isComplete(checkedCellX, checkedCellY - 1)){

        this.gameState.currentBoardState.setCellState(checkedCellX, checkedCellY -1, playerInt);

      }//if
    }//else if
    else{
      System.out.println("isComplete was false");
    }
  }//cellCheckAndUpdate

  private int cellXCheck(int cellX){

    if(cellX >= HEIGHT){

      System.out.println("cellX was greater or equal to Height");
      System.out.println(cellX);
      return cellX - 1;

    }//if statement

    else{

      return cellX;

    }//else statement
  }//cellXCheck

  private int cellYCheck(int cellY){

    if(cellY >= WIDTH){

      System.out.println("cellY was greater or equal to Width");
      System.out.println(cellY);
      return cellY - 1;

    }//if statement

    else{

      return cellY;

    }//else statement
  }//cellYCheck

  public void botButtonChecker(String buttonName){


    int cellX;
    int cellY;

    switch (buttonName){

      case "v0":
        cellX = 0;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY,PLAYERTWOINT);
        break;

      case "v1":
        cellX = 0;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "v2":
        cellX = 0;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "v3":
        cellX = 0;
        cellY = 3;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "v4":
        cellX = 1;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "v5":
        cellX = 1;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "v6":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "v7":
        cellX = 1;
        cellY = 3;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h0":
        cellX = 0;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h1":
        cellX = 0;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h2":
        cellX = 0;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h3":
        cellX = 0;
        cellY = 3;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h4":
        cellX = 1;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h5":
        cellX = 1;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h6":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;

      case "h7":
        cellX = 1;
        cellY = 3;

        cellCheckAndUpdate(cellX, cellY, PLAYERTWOINT);
        break;
    }
  }//botButtonChecker
}//singlePlayerPlayScreen