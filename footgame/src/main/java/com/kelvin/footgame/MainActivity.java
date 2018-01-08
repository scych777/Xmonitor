package com.kelvin.footgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    View current;
    GameView gv;
    WelcomeView welcome;
    LoadingView lv;

    int keyState = 0;
    PlayerMoveThread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
