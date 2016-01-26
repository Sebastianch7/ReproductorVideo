package com.edibca.reproductor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;
    private int tiempo;
    private static boolean validacion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(validacion)
        {
            General.sUrl = "android.resource://"+getPackageName()+"/"+R.raw.video;
            General.iSegundos = 0;
            validacion = false;
        }
        loadView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadView();
    }

    public void loadView()
    {

        videoView = (VideoView) findViewById(R.id.reproductor);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(General.sUrl));
        videoView.seekTo(General.iSegundos);
        General.iSegundos=0;
        //videoView.start();
    }

    public void ampliar(View view)
    {
        General.iSegundos = videoView.getCurrentPosition();
        Intent ampliacion = new Intent(this,FullscreenActivity.class);
        startActivity(ampliacion);
    }
}
