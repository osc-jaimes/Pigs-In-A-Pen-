package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class SinglePlayerSetupScreen extends AppCompatActivity {

  Spinner gameBoardSizeSpinner;
  public static int boardSize;
  protected String sizeText;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_setup_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    this.getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


    gameBoardSizeSpinner = findViewById(R.id.board_size_drop_down);
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
}
