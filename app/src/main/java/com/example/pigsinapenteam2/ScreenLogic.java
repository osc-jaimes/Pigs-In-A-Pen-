package com.example.pigsinapenteam2;

import android.app.Activity;
import android.view.View;

/**
 * @author Oscar Jaimes
 */
public class ScreenLogic {

  /**
   * Make the current activity full screen and hide all phone action bars.
   * @param currentActivity - the activity to make full screen.
   */
  public static void fullScreen(Activity currentActivity){
    currentActivity.getWindow().getDecorView().setSystemUiVisibility(
      View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

  }
}
