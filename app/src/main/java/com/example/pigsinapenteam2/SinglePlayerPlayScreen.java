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
import android.view.View;

public class SinglePlayerPlayScreen extends AppCompatActivity {
  //Instance Variables + instantiations
  GameState gameState;
  HumanPlayer player1;
  View confirmButton = findViewById(R.id.confirmButton);
  boolean confirmButtonPressed;
  //

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    //setting confirm button to not exist for now
    confirmButton.setVisibility(View.GONE);
  }
  public void onClickHorizontal1(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 0, 0, true);
    }
  }

  public void buttonClicked(View V){
    int buttonId = V.getId();
    Button theButton = findViewById(buttonId);
    theButton.setBackgroundColor(getResources().getColor(R.color.fences));

  }
  public void onClickHorizontal2(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 0, 1, true);
    }
  }
  public void onClickHorizontal3(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 0, 2, true);
    }
  }
  public void onClickHorizontal14(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 0, 3, true);
    }
  }
  public void onClickHorizontal5(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 1, 0, true);
    }
  }
  public void onClickHorizontal16(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 1, 1, true);
    }
  }
  public void onClickHorizontal7(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 1, 2, true);
    }
  }
  public void onClickHorizontal8(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 1, 3, true);
    }
  }
  public void onClickHorizontal9(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 0, 0, true);
    }
  }
  public void onClickVertical1(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 1, 0, false);
    }
  }
  public void onClickVertical2(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 2, 0, false);
    }
  }
  public void onClickVertical3(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 3, 0, false);
    }
  }
  public void onClickVertical4(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 0, 1, false);
    }
  }
  public void onClickVertical5(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 1, 1, false);
    }
  }
  public void onClickVertical6(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 2, 1, false);
    }
  }
  public void onClickVertical8(View v){
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      confirmButtonPressed = false;
    }
    if(confirmButtonPressed = true){
      player1.doMove(gameState, 3, 1, false);
    }
  }






  }






  public void onClickConfirmationButton(View v) {
    confirmButtonPressed = true;
    onClickHorizontal1(v);
  }
}