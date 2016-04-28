package kr.pe.burt.android.lib.faimageview.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import kr.pe.burt.android.lib.faimageview.FAImageView;

/**
 * Created by burt on 2016. 4. 28..
 */
public class SplashActivity extends AppCompatActivity {

    FAImageView faImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        faImageView = (FAImageView)findViewById(R.id.faimageview);
        faImageView.setInterval(1000);
        faImageView.setLoop(false);
        faImageView.setRestoreFirstFrameWhenFinishAnimation(false);
        faImageView.addImageFrame(R.drawable.number01);
        faImageView.addImageFrame(R.drawable.number02);
        faImageView.addImageFrame(R.drawable.number03);

        faImageView.setOnStartAnimationListener(new FAImageView.OnStartAnimationListener() {
            @Override
            public void onStartAnimation() {
                Log.v("FAImageView", "Animation started");
            }
        });

        faImageView.setOnFinishAnimationListener(new FAImageView.OnFinishAnimationListener() {
            @Override
            public void onFinishAnimation(boolean isLoopAnimation) {
                if(isLoopAnimation) {
                    Log.v("FAImageView", "Finish an animation cycle");
                } else {
                    Log.v("FAImageView", "Animation Finished");
                }
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        faImageView.setOnFrameChangedListener(new FAImageView.OnFrameChangedListener() {
            @Override
            public void onFrameChanged(int index) {
                Log.v("FAImageView", String.format("frame has changed %d", index));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        faImageView.startAnimation();
    }

}
