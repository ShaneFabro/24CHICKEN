package wings.a24chickenwings;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wings.a24chickenwings.R;
import wings.a24chickenwings.activity_login;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openAct = new Intent(getApplicationContext(), activity_login.class);
                    startActivity(openAct);
                    finish();
                }
            }
        };
        timer.start();
    }
}
