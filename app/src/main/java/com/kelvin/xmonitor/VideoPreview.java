package com.kelvin.xmonitor;

import android.content.Context;
import android.media.MediaRecorder;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by admin on 08/12/2017.
 */
public class VideoPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private MediaRecorder recorder;

    public VideoPreview(Context context, MediaRecorder recorder){
        super(context);
        this.recorder = recorder;
        holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public Surface getSurface(){
        return holder.getSurface();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        recorder.setOutputFile("/sdcard/" + LaunchPortal.fileName);
        recorder.setPreviewDisplay(holder.getSurface());
        try{
            recorder.prepare();
        }catch (Exception e){
            e.printStackTrace();
            recorder.release();
            recorder = null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if(recorder != null){
            recorder.release();
            recorder = null;
        }
    }
}
