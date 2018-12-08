package wings.a24chickenwings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_sides extends AppCompatActivity {
    Database databaseConnect;
    ImageButton item1, item2, item3;
    String item;
    Button skip;
    static double sidesPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        skip = findViewById(R.id.skip);
        databaseConnect = new Database(this);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P199 - FRIES";
                sidesPrice += 199;
                AddOrder(item);
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P49 - CUP OF RICE";
                sidesPrice += 49;
                AddOrder(item);

            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P79 - 1.5L COKE";
                sidesPrice += 79;
                AddOrder(item);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAct = new Intent(getApplicationContext(), activity_orders.class);
                startActivity(openAct);
            }
        });
    }
    public void AddOrder(String newEntry) {
        databaseConnect.addData(newEntry);
        Intent openAct = new Intent(getApplicationContext(), activity_orders.class);
        startActivity(openAct);
    }
}
