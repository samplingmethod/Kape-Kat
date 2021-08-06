package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Button;
import android.widget.VideoView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {


    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;

    @ViewById()
    Button btnLoginLanding;

    @ViewById(R.id.videoView)
    VideoView videoBG;

    @ViewById()
    Button btnRegisterLanding;



    @AfterViews
    public void init(){

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.coffeecup);
        videoBG.setVideoURI(uri);
        videoBG.start();

        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer = mp;
                mMediaPlayer.setLooping(true);
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });

    }


    @Override
    protected void onPause(){
        super.onPause();
        mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        videoBG.start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }



    @Click(R.id.btnLoginLanding)
    public void btnLoginLanding()
    {
        Login_.intent(this).start();
    }

    @Click(R.id.btnRegisterLanding)
    public void btnRegisterLanding()
    {
        Register_.intent(this).start();
    }



}