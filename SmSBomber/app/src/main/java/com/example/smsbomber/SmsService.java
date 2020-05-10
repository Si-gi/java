package com.example.smsbomber;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;



public class SmsService extends Service {

    private ReceiverSMS mSMSreceiver;
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    private boolean active;
    private int countSMSReceived;

    @Override
    public void onCreate()
    {
        super.onCreate();
        //SMS event receiver
        mSMSreceiver = new ReceiverSMS();
        IntentFilter filter = new IntentFilter(SMS_RECEIVED);
        registerReceiver(mSMSreceiver, filter);
    }

    public void onDestroy() {

        unregisterReceiver(mSMSreceiver);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class ReceiverSMS extends BroadcastReceiver {
        public ReceiverSMS(){

            final Handler handler = new Handler();
            final int delay = 1000;

            handler.postDelayed(new Runnable(){
                public void run(){
                    //Simple test to check if service and receiver is working
                    handler.postDelayed(this, delay);
                }
            }, delay);
        }
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("SMSReceiver","An sms have been received");
            //TODO when ça marchera
            //Get list smsType
            //foreach smsType
            //If smsType.getWR == leSMSRecu.getBody
            //  send svms to leSmsRecu.getExpediteur body = smsType.getBody
            //That's all !
            if(active) SmsService.this.countSMSReceived++;
            String num = "07070707";
            //sendSMS(num,"salut ça va ?");
        }
        /*private void sendSMS(String phoneNumber, String message) {
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
    */}
}