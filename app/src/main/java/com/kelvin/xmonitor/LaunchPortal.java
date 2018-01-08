package com.kelvin.xmonitor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;

public class LaunchPortal extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_VEDIO_CAPTURE = 101;
    private File file;
    public static final String fileName = "RecordVideo. ";
    Button prepareButton;
    Button recordButton;
    Button playbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_portal);
        prepareButton = (Button) findViewById(R.id.prepare);
        recordButton = (Button) findViewById(R.id.record);
        playbackButton = (Button) findViewById(R.id.playback);
        prepareButton.setOnClickListener(this);
        recordButton.setOnClickListener(this);
        playbackButton.setOnClickListener(this);
        file = new File(Environment.getExternalStorageDirectory(),fileName);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_VEDIO_CAPTURE && resultCode == Activity.RESULT_OK){
            String path = data.getData().toString();
            TextView output = (TextView) findViewById(R.id.file);
            output.setText(path);
        }
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.prepare :
               Intent intent = new Intent(this,VideoRecorder.class);
               startActivity(intent);
               break;
           case R.id.record :
               Intent intent1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
               intent1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
               intent1.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,0);
               startActivityForResult(intent1,REQUEST_VEDIO_CAPTURE);
               break;
           case R.id.playback :
               Intent intent2 = new Intent(this, VideoPlayer.class);
               startActivity(intent2);
               break;
       }


    }
}
