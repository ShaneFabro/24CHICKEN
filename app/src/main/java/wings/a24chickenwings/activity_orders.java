package wings.a24chickenwings;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;



public class activity_orders extends AppCompatActivity {

    Database databaseConnect;
    TextView grandTotal, totalPrice;
    Button place, add;
    private ListView mListView;
    double totalPriceNo = activity_sides.sidesPrice + activity_singles.singlesPrice + activity_family.familyPrice;
    double grandTotalNo = totalPriceNo + 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        mListView = (ListView) findViewById(R.id.items);
        databaseConnect = new Database(this);
        place = findViewById(R.id.place);
        add = findViewById(R.id.add);
        totalPrice = findViewById(R.id.totalPrice);
        grandTotal = findViewById(R.id.grandTotal);

        totalPrice.setText("TOTAL PRICE: P"+Double.toString(totalPriceNo));
        grandTotal.setText(Double.toString(grandTotalNo));
        populateListView();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAct = new Intent(getApplicationContext(), activity_step1.class);
                startActivity(openAct);
            }
        });
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAct = new Intent(getApplicationContext(), activity_done.class);
                startActivity(openAct);
            }
        });
    }
    private void populateListView() {
        Cursor data = databaseConnect.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

    }



}