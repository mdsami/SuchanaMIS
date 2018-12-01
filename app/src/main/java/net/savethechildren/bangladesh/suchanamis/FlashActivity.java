package net.savethechildren.bangladesh.suchanamis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FlashActivity extends AppCompatActivity {
    private ImageView splashIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        //splash icon
        splashIcon = (ImageView) findViewById(R.id.splash_icon);
        //animation icon at splash screen
        Animation fadeicon = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.fade_in);

        splashIcon.setAnimation(fadeicon);

        fadeicon.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //TODO: Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //TODO: Auto-generated method stub
                Intent intent = new Intent(FlashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //TODO: Auto-generated method stub
            }
        });
    }
}
