package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_screen);
  }

  public void pressSinglePlayerButton(View v){
    Intent goToSinglePlayerScreen = new Intent(getApplicationContext(), SinglePlayerScreen.class);
    startActivity(goToSinglePlayerScreen);
  }

  public void pressMultiPlayerButton(View v){
    Intent goToMultiPlayerScreen = new Intent(getApplicationContext(), MultiPlayerScreen.class);
    startActivity(goToMultiPlayerScreen);
  }
}
