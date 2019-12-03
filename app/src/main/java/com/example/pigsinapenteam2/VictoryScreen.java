/**
 * Jared Boonstra - 1572694
 *
 * VictoryScreen.java
 *
 * This be the class of the screen that shows when someone wins
 * Public methods:
 * menuButton: void
 *  When the menu button is pressed on the related .xml file, the activity changes to the main menu
 *
 * restartButton: void
 *  When the restart button is pressed on the related .xml file, the game restarts
 */
package com.example.pigsinapenteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VictoryScreen extends AppCompatActivity {
  protected Bundle extras;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_victory_screen);
    this.extras = getIntent().getExtras();
    fillInWinner();
  }

  public void menuButton(View v){
    Intent goToMainMenu = new Intent(getApplicationContext(), MainScreen.class);
    startActivity(goToMainMenu);
  }

  public void restartButton(View v){
    Intent goToGameStart = new Intent(getApplicationContext(), SinglePlayerPlayScreen.class);
    startActivity(goToGameStart);
  }

  /**
   * fillInWinner
   *
   * Takes the winner of the game in int form and changes the text view to represent who won
   */
  private void fillInWinner(){
    TextView playerText = findViewById(R.id.playerWhoWon);
    int playerWhoWon = extras.getInt("playerWhoWon");
    if(playerWhoWon == 0){
      playerText.setText("Player 1");
    }
    playerText.setText("Player 2");
  }
}
