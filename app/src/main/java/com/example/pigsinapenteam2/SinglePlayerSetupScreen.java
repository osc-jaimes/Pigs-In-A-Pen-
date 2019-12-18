package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class SinglePlayerSetupScreen extends AppCompatActivity {

  Spinner gameBoardSizeSpinner;
  Spinner difficultySpinner;
  public static int boardSize;
  public static int gameDifficulty;
  public static int boardType;
  protected String sizeText;
  protected String boardLayout;

  Button easyDif;
  Button mediumDif;
  Button hardDif;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_setup_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);

    easyDif = findViewById(R.id.easyDif);
    mediumDif = findViewById(R.id.mediumDif);
    hardDif = findViewById(R.id.hardDif);

    gameBoardSizeSpinner = findViewById(R.id.board_size_drop_down);
    difficultySpinner = findViewById(R.id.board_size_drop_down_difficulty);
  }

  public void pressStartGameButton(View V){
    sizeText = gameBoardSizeSpinner.getSelectedItem().toString();
    boardLayout = difficultySpinner.getSelectedItem().toString();
    if(sizeText.equals("Small")){
      boardSize = 0;
    }
    else if(sizeText.equals("Medium")){
      boardSize = 1;
    }
    else if(sizeText.equals("Large")){
      boardSize = 2;
    }

    if(boardLayout.equals("Normal")){
      boardType = 0;
    }
    else if(boardLayout.equals("Walls")){
      boardType = 1;
    }
    else if(boardLayout.equals("Garden")){
      boardType = 2;
    }
    else if(boardLayout.equals("Hill")){
      boardType = 3;
    }


    Intent goToSinglePlayerPlayScreen = new Intent(getApplicationContext(), SinglePlayerPlayScreen.class);
    startActivity(goToSinglePlayerPlayScreen);
  }

  public void onClickEasy(View v){
    gameDifficulty = 0;
    easyDif.setBackgroundColor(getResources().getColor(R.color.buttonColor));
    mediumDif.setBackgroundColor(getResources().getColor(R.color.dropdown));
    hardDif.setBackgroundColor(getResources().getColor(R.color.dropdown));
  }

  public void onClickMedium(View v){
    gameDifficulty = 1;
    easyDif.setBackgroundColor(getResources().getColor(R.color.dropdown));
    mediumDif.setBackgroundColor(getResources().getColor(R.color.buttonColor));
    hardDif.setBackgroundColor(getResources().getColor(R.color.dropdown));
  }

  public void onClickHard(View v){
    gameDifficulty = 2;
    easyDif.setBackgroundColor(getResources().getColor(R.color.dropdown));
    mediumDif.setBackgroundColor(getResources().getColor(R.color.dropdown));
    hardDif.setBackgroundColor(getResources().getColor(R.color.buttonColor));
  }
  public void onResume(){
    super.onResume();
    ScreenLogic.fullScreen(this);
  }

}
