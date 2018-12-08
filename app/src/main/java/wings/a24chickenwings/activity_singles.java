package wings.a24chickenwings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_singles extends AppCompatActivity {
    ImageButton item1, item2;
    Database databaseConnect;
    String item;
    static double singlesPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singles);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        databaseConnect = new Database(this);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P150 - CARBONARA";
                singlesPrice += 150;
                AddOrder(item);
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "P150 - 2PCS WINGS AND FRIES";
                singlesPrice += 150;
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
