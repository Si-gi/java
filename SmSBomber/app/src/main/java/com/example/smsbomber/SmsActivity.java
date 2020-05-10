package com.example.smsbomber;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SmsActivity extends AppCompatActivity {
    private static final String SMS_RECEIVED ="android.provider.Telephony.SMS_RECEIVED";
    private String txtMessage = "salut";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ReceiverSMS  mSMSreceiver = new ReceiverSMS();
        setContentView(R.layout.sms_activity);
        Button btnSendSMS = (Button) findViewById(R.id.contactBtn);
        TextView Tcontact = findViewById(R.id.contact);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        final String number = intent.getStringExtra("number");

        Tcontact.setText(name+number);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNo = number;
                //String message = txtMessage.getText().toString();
                sendSMS(phoneNo, txtMessage);

            }
        });
    }

    private class ReceiverSMS extends BroadcastReceiver {
        // à chaque SMS reçu
        public void onReceive(Context context, Intent intent) {
            // Action à entreprendre
            Toast.makeText(SmsActivity.this,"You received a message", Toast.LENGTH_SHORT).show();

        }}

    private void sendSMS(String phoneNumber, String message) {
        for(int i=0; i<=10; i++ ) {
            PendingIntent pi = PendingIntent.getActivity(this, 0,
                    new Intent(this, SmsActivity.class), 0);
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message, pi, null);
        }
    }
    public void HandleSmsActivity(View view) {
        Intent intent = new Intent(SmsActivity.this,SmsActivity.class);
        startActivity(intent);
    }

    public void HandleContactsActivity(View view) {
        Intent intent = new Intent(SmsActivity.this,MainActivity.class);
        startActivity(intent);
    }

}
