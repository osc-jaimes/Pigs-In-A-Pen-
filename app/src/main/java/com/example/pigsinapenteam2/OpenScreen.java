package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpenScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_open_screen);
  }

  public void pressStartButton(View V){
    Intent goToMainScreen = new Intent(getApplicationContext(), MainScreen.class);
    startActivity(goToMainScreen);
  }
}
