package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SinglePlayerPlayScreen extends AppCompatActivity {
//Instance Variables + instantiations
  GameState gameState;
  HumanPlayer player1;
  View confirmButton = findViewById(R.id.confirmButton);
  //

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_player_play_screen);
    //setting confirm button to not exist for now
    confirmButton.setVisibility(View.GONE);
  }

  /**
   * onClick
   *
   * On user click, the button will first light up, and on click of confirm button the set move will pass on
   * @param v The view on where the buttons reside
   */
  public void onClick(View v) {
    if (!player1.getHasMoved()) {
      confirmButton.setVisibility(View.VISIBLE);
      if (v.findViewById(R.id.confirmButton)){
        switch (v.findViewById()) {
          case (R.id.H1):
            player1.doMove(gameState, 0, 0, true);
            break;
          case (R.id.H2):
            player1.doMove(gameState, 0, 1, true);
            break;
          case (R.id.H3):
            player1.doMove(gameState, 0, 2, true);
            break;
          case (R.id.H4):
            player1.doMove(gameState, 0, 3, true);
            break;
          case (R.id.H5):
            player1.doMove(gameState, 1, 0, true);
            break;
          case (R.id.H6):
            player1.doMove(gameState, 1, 1, true);
            break;
          case (R.id.H7):
            player1.doMove(gameState, 1, 2, true);
            break;
          case (R.id.H8):
            player1.doMove(gameState, 1, 3, true);
            break;
          case (R.id.H9):
            player1.doMove(gameState, 1, 4, true);
            break;
          case (R.id.V1):
            player1.doMove(gameState, 0, 0, false);
            break;
          case (R.id.V2):
            player1.doMove(gameState, 1, 0, false);
            break;
          case (R.id.V3):
            player1.doMove(gameState, 2, 0, false);
            break;
          case (R.id.V4):
            player1.doMove(gameState, 3, 0, false);
            break;
          case (R.id.V5):
            player1.doMove(gameState, 0, 1, false);
            break;
          case (R.id.V6):
            player1.doMove(gameState, 1, 1, false);
            break;
          case (R.id.V7):
            player1.doMove(gameState, 2, 1, false);
            break;
          case (R.id.V8):
            player1.doMove(gameState, 3, 1, false);
            break;
        }
      }
    }
  }
}
