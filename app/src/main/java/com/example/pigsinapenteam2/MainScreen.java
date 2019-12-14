package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    ScreenLogic.fullScreen(this);
  }

  public void pressSinglePlayerButton(View v){
    Intent goToSinglePlayerScreen = new Intent(getApplicationContext(), SinglePlayerSetupScreen.class);
    startActivity(goToSinglePlayerScreen);
  }

  public void pressMultiPlayerButton(View v){
    Intent goToMultiPlayerScreen = new Intent(getApplicationContext(), MultiplayerSetupScreen.class);
    startActivity(goToMultiPlayerScreen);
  }

  public void quickPlay(View V){
    Intent quickPlay = new Intent(getApplicationContext(), SinglePlayerPlayScreen.class);
    startActivity(quickPlay);
  }

  public void instructions(View V){
    Intent instructions = new Intent(getApplicationContext(), InstructionsScreen.class);
    startActivity(instructions);
  }
}
