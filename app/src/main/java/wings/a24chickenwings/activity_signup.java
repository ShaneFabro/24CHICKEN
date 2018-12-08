package wings.a24chickenwings;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_signup extends AppCompatActivity {
    Button signUp;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText txtName, txtEmail, txtPass, txtPhone, txtAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        openHelper = new Database(this);
        txtName = findViewById(R.id.name);
        txtEmail = findViewById(R.id.email);
        txtPass = findViewById(R.id.pass);
        txtPhone = findViewById(R.id.phone);
        txtAdd = findViewById(R.id.home);
        signUp = findViewById(R.id.finishSignUp);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String name = txtName.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPass.getText().toString();
                String phone = txtPhone.getText().toString();
                String add = txtAdd.getText().toString();
                addAccount(name, pass, email, phone, add);
                Toast.makeText(getApplicationContext(), "You now have an account. Sign in now.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    public void addAccount(String name, String pass, String email, String phone, String add){
        ContentValues data = new ContentValues();
        data.put(Database.COL_2, name);
        data.put(Database.COL_3, pass);
        data.put(Database.COL_4, email);
        data.put(Database.COL_5, phone);
        data.put(Database.COL_6, add);
        long id = db.insert(Database.TABLE_NAME, null, data);
    }
}
