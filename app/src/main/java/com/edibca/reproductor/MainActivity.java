package com.edibca.reproductor;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private String TAG = "com.video.videoplayer";
    private String path;
    private VideoView videoView;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
    }
    public void loadView()
    {
        path="android.resource://"+getPackageName()+"/"+R.raw.ateroesclerosis;
        videoView = (VideoView) findViewById(R.id.reproductor);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        ///videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(path));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Duration = " + videoView.getDuration(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onclickcontrolvideo(View v)
    {
        switch (v.getId())
        {
            case R.id.button:
                Toast.makeText(getApplicationContext(),"boton 1",Toast.LENGTH_LONG).show();
                break;

            case R.id.button2:
                Toast.makeText(getApplicationContext(),"boton 2",Toast.LENGTH_LONG).show();
                break;

        }

        //videoView.start();
    }
}
