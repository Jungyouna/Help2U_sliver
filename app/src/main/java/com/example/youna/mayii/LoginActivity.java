package com.example.youna.mayii;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button5;
    private EditText p_phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        p_phoneNumber = (EditText)findViewById(R.id.p_phoneNumber);

        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SilverActivity.class);
                intent.putExtra("name", p_phoneNumber.getText().toString());
                startActivity(intent);
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
}
