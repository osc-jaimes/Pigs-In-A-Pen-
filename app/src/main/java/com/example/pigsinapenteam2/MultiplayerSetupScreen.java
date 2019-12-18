/**
 * Jared Boonstra + Osccar Jaimes
 *
 * MultiplayerSetupScreen
 *
 * Does the stuff that sets the settings for the multiplayer game to run off of.
 */
package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MultiplayerSetupScreen extends AppCompatActivity {

  Spinner gameBoardSizeSpinner;
  public static int boardSize;
  protected String sizeText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_setup_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);

    gameBoardSizeSpinner = findViewById(R.id.board_size_drop_down);
  }

  /**
   * Starts the game with the respective choices made in the setup screen.
   * @param V the button to press to start the game.
   */
  public void playGame(View V){
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

    Intent goToPlayScreen = new Intent(getApplicationContext(), MultiplayerPlayScreen.class);
    startActivity(goToPlayScreen);
  }
}
