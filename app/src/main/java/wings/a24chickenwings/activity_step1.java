package wings.a24chickenwings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_step1 extends AppCompatActivity {
    ImageButton family, singles;
    Button yourBag, delete;
    Database databaseConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        databaseConnect = new Database(this);
        family = findViewById(R.id.family);
        singles = findViewById(R.id.singles);
        yourBag = findViewById(R.id.yourBag);
        delete = findViewById(R.id.delete);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct = new Intent(getApplicationContext(), activity_family.class);
                startActivity(nextAct);
            }
        });
        singles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct = new Intent(getApplicationContext(), activity_singles.class);
                startActivity(nextAct);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Toast.makeText(getApplicationContext(), "Items in bag has been deleted", Toast.LENGTH_LONG).show();
                activity_family.familyPrice=0;
                activity_singles.singlesPrice=0;
                activity_sides.sidesPrice=0;
            }
        });
        yourBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct = new Intent(getApplicationContext(), activity_orders.class);
                startActivity(nextAct);
            }
        });
    }
    public void delete(){
        databaseConnect.delete();
    }
}
