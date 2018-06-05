package com.example.youna.mayii;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SilverActivity extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter;
    Button btnONOFF;
    ImageView imageView4;
    EditText phoneNumber, help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silver);
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        help = (EditText)findViewById(R.id.help);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNumber = phoneNumber.getText().toString();
                String inputHelp = help.getText().toString();
                if(inputNumber.length()>0 && inputHelp.length()>0) {
                    //sendSMS(inputNumber, inputHelp); Toast.makeText(getBaseContext(), inputNumber+"\n"+inputHelp, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getBaseContext(), "전화번호와 메시지를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }});
    }
    /*private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }*/
}
