package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SinglePlayerPlayScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
  }

  public void buttonClicked(View V){
    int buttonId = V.getId();
    Button theButton = findViewById(buttonId);
    theButton.setBackgroundColor(getResources().getColor(R.color.fences));

  }






  }





