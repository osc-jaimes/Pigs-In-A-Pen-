package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class SinglePlayerSetupScreen extends AppCompatActivity {

  Spinner gameBoardSizeSpinner;
  Spinner difficultySpinner;
  public static int boardSize;
  public static int gameDifficulty;
  protected String sizeText;
  protected String difficulty;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_setup_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);


    gameBoardSizeSpinner = findViewById(R.id.board_size_drop_down);
    difficultySpinner = findViewById(R.id.board_size_drop_down_difficulty);
  }

  public void pressStartGameButton(View V){
    sizeText = gameBoardSizeSpinner.getSelectedItem().toString();
    if(sizeText.equals("Small")){
      boardSize = 0;
    }
    else if(sizeText.equals("Medium")){
      boardSize = 1;
    }
    else if(sizeText.equals("Large")){
      boardSize = 2;
    }


    Intent goToSinglePlayerPlayScreen = new Intent(getApplicationContext(), SinglePlayerPlayScreen.class);
    startActivity(goToSinglePlayerPlayScreen);
  }

  public void onClickEasy(View v){
    gameDifficulty = 0;
  }

  public void onClickMedium(View v){
    gameDifficulty = 1;
  }

  public void onClickHard(View v){
    gameDifficulty = 2;
  }

}
