package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SinglePlayerScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_screen);
  }

  public void pressStartGameButton(View V){
    Intent goToSinglePlayerPlayScreen = new Intent(getApplicationContext(), SinglePlayerPlayScreen.class);
    startActivity(goToSinglePlayerPlayScreen);
  }
}
