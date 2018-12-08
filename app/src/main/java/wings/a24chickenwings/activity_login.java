package wings.a24chickenwings;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
public class activity_login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button signUp, signIn;
    EditText txtEmail, txtPass;
    static String name, emailAdd, phoneNo, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp = findViewById(R.id.signup);
        signIn = findViewById(R.id.signin);
        txtEmail = findViewById(R.id.email);
        txtPass = findViewById(R.id.pass);
        openHelper=new Database(this);
        db = openHelper.getReadableDatabase();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAct = new Intent(getApplicationContext(), activity_signup.class);
                startActivity(openAct);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String pass = txtPass.getText().toString();

                String TableName = Database.TABLE_NAME;
                String EmailAddress = Database.COL_4;
                String Pass = Database.COL_3;
                cursor = db.rawQuery("SELECT *FROM " + TableName + " WHERE " + EmailAddress + "=? AND " + Pass + "=?", new String[]{email, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        name = cursor.getString(cursor.getColumnIndex("Name"));
                        emailAdd = cursor.getString(cursor.getColumnIndex("Email_Address"));
                        phoneNo = cursor.getString(cursor.getColumnIndex("Phone"));
                        address = cursor.getString(cursor.getColumnIndex("Address"));
                        Intent nextAct = new Intent(getApplicationContext(), activity_step1.class);
                        startActivity(nextAct);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "User cannot be found.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
