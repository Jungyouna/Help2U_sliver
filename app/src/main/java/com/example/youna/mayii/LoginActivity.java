package com.example.youna.mayii;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private Button button5;
    private EditText p_phoneNumber;
    private EditText codeNumber;
    private int dataCnt;
    private DatabaseReference testFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        p_phoneNumber = (EditText)findViewById(R.id.p_phoneNumber);
        codeNumber = (EditText)findViewById(R.id.editText);
        testFirebase = FirebaseDatabase.getInstance().getReference();
        dataCnt=0;
        Log.d("으랑ㅁ니ㅏ널ㄴ미ㅏ","ㅇㅁ러ㅏㅣ파ㅣㅓㅍㄷ");
        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCode(codeNumber.getText().toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert_ex = new AlertDialog.Builder(this);
        alert_ex.setMessage("헬프투유를 종료하시겠습니까?");

        alert_ex.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alert_ex.setNegativeButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alert = alert_ex.create();
        alert.show();
    }


    public void checkCode(final String abc){
        testFirebase.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataCnt=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Log.d("[Test]", "ValueEventListener : " + snapshot.getValue());

                    if(snapshot.child("이메일").getValue()==null) {
                        dataCnt=1;
                        return;
                    }
                    String test2 =snapshot.child("회원 코드").getValue().toString();

                    if(test2.equals(abc)==true) {
                        Intent intent = new Intent(LoginActivity.this, SilverActivity.class);
                        intent.putExtra("name", p_phoneNumber.getText().toString()).putExtra("dataCode",test2);
                        startActivity(intent);
                        dataCnt=0;
                        break;
                    }
                    dataCnt++;
                }
                if(dataCnt!=0)
                    Toast.makeText(getApplicationContext(), "존재하지 않는 회원코드입니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
