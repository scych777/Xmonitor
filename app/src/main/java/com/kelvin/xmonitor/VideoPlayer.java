package com.kelvin.xmonitor;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

/**
 * Created by kelvin young on 08/12/2017.
 */
public class VideoPlayer extends Activity implements View.OnClickListener{
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_page);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse(Environment.getExternalStorageState() + "/sdcard/" + LaunchPortal.fileName);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri,"video/*");
        startActivity(i);

    }
}
