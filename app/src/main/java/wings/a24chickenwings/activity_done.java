package wings.a24chickenwings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class activity_done extends AppCompatActivity {
    Database databaseConnect;
    TextView name, email, phoneNo, homeAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        databaseConnect = new Database(this);
        name = findViewById(R.id.name);
        email = findViewById(R.id.emailAdd);
        phoneNo = findViewById(R.id.contactNo);
        homeAdd = findViewById(R.id.homeAdd);

        name.setText("Name: " + activity_login.name);
        email.setText("Email Address: " + activity_login.emailAdd);
        phoneNo.setText("Phone No: " + activity_login.phoneNo);
        homeAdd.setText("Home Address: " + activity_login.address);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    activity_family.familyPrice=0;
                    activity_singles.singlesPrice=0;
                    activity_sides.sidesPrice=0;
                    delete();
                    Intent openAct = new Intent(getApplicationContext(), activity_step1.class);
                    openAct.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(openAct);
                    //Toast.makeText(getApplicationContext(), "Order has been processed. Expect a call within 10 mins.", Toast.LENGTH_SHORT).show();

                }
            }
        };
        timer.start();
    }
    public void delete(){
        databaseConnect.delete();
    }
}
