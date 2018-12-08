package wings.a24chickenwings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_family extends AppCompatActivity {

    ImageButton item1, item2, item3;
    Database databaseConnect;
    String item;
    static double familyPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        databaseConnect = new Database(this);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P350 - 6 PIECES ORIGINAL";
                familyPrice += 350;
                AddOrder(item);
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P350 - 6 PIECES GARLIC";
                familyPrice += 350;
                AddOrder(item);
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P350 - 6 PIECES BARBECUE";
                familyPrice += 350;
                AddOrder(item);
            }
        });
    }
    public void AddOrder(String newEntry) {
        databaseConnect.addData(newEntry);
        Intent openAct = new Intent(getApplicationContext(), activity_sides.class);
        startActivity(openAct);
    }
}
