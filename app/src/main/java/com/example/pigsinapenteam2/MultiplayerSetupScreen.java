package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MultiplayerSetupScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer_setup_screen);
  }

  /**
   * Starts the game with the respective choices made in the setup screen.
   * @param V the button to press to start the game.
   */
  public void playGame(View V){
    Intent goToPlayScreen = new Intent(getApplicationContext(), MultiplayerPlayScreen.class);
    startActivity(goToPlayScreen);
  }
}
