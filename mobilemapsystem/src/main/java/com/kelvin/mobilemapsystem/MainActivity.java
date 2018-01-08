package com.kelvin.mobilemapsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    private static final int MENU_NEW = Menu.FIRST + 1;
    private static final int MENU_CON = MENU_NEW + 1;
    private static final int MENU_SETTING = MENU_CON + 1;
    private static final int MENU_HELPS = MENU_SETTING + 1;
    private static final int MENU_EXIT = MENU_HELPS + 1;
    public static final String TAG = "MobileMapSystem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        render_tracks();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG,"OncreateOptionMenu");
        super.onCreateOptionsMenu(menu);
        menu.add(0,MENU_NEW,0,R.string.menu_new).setIcon().setAlphabeticShortcut("N");
    }
}
