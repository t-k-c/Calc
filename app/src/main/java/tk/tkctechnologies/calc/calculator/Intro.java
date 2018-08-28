package tk.tkctechnologies.calc.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ImageView imageView  = (ImageView) findViewById(R.id.image);
        imageView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.animator));
/*        Intent it;
        if ((it = getIntent()) != null) {
            Toast.makeText(this, "Message" + it.getStringExtra("content"), Toast.LENGTH_SHORT).show();
        }*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    startActivity(new Intent(Intro.this, MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
