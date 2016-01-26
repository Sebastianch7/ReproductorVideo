package com.edibca.reproductor;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class FullscreenActivity extends AppCompatActivity {
    private String TAG = "com.video.videoplayer";
    private String path;
    private VideoView segundo;
    private MediaController mediaController;
    private String tiempo;
    public String direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        loadView();
    }
    public void loadView()
    {
        segundo = (VideoView) findViewById(R.id.segundo);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(segundo);
        segundo.setMediaController(mediaController);
        segundo.setVideoURI(Uri.parse(General.sUrl));
        segundo.seekTo(General.iSegundos);
        General.iSegundos=0;
        segundo.start();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            General.iSegundos = segundo.getCurrentPosition();
            Toast.makeText(this,""+General.iSegundos,Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
