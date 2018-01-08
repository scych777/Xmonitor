package com.kelvin.xmonitor;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by admin on 08/12/2017.
 */
public class VideoRecorder extends Activity{
    private MediaRecorder recorder;
    private VideoPreview preview;
    boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recorder = new MediaRecorder();
        recorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);

        preview = new VideoPreview(this,recorder);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(preview);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        menu.add(0,0,0,getString(R.string.startrecording));
        menu.add(1,1,0,getString(R.string.stoprecording));
        menu.setGroupVisible(0,false);
        menu.setGroupVisible(1,false);
        if(isRecording == false){
            menu.setGroupVisible(0, true);
        }else{
            menu.setGroupVisible(1,true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0 :
                recorder.start();
                isRecording = true;
                break;
            case 1 :
                recorder.stop();
                recorder.release();
                recorder = null;
                isRecording = false;
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
