package com.example.smsbomber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity  {
    private ListView lstNames;
    private ArrayList<ContactModel> Acontacts = new ArrayList<ContactModel>();;

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        // Find the list view
        this.lstNames = (ListView) findViewById(R.id.listView);

        // Read and show the contacts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            final List<String> contacts = getContactNames();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
            lstNames.setAdapter(adapter);
            lstNames.setOnItemLongClickListener(
                    new AdapterView.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
//                            String selected =((TextView)item.findViewById(R.id.name)).getText().toString();
                               String name = Acontacts.get(pos).getName();
                                String number = Acontacts.get(pos).getNumber();
     //                       Toast.makeText(MainActivity.this,selected.toString(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getBaseContext(), SettingsActivity.class);
                            intent.putExtra("name", name);
                            intent.putExtra("number", number);
                            startActivity(intent);
                            return true;
                        }

                    });
        }
    }

    /**
     * Show the contacts in the ListView.
     */
    private void showContacts() {
        // Check the SDK version and whether the permission is already granted or not.

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            Log.i(grantResults[0]+" ","jsp");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                showContacts();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Read the name of all the contacts.
     *
     * @return a list of names.
     */
    private List<String> getContactNames() {
        List<String> contacts = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");

        if (cursor.moveToFirst()) {

            do {
                // Get the contacts name
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                ContactModel contactModel = new ContactModel();
                contactModel.setName(name);
                contactModel.setNumber(phoneNumber);
                int nb_messages = countSms(contactModel.getNumber());
                contactModel.setNbSms(nb_messages);
                Acontacts.add(contactModel);
                contacts.add(name + nb_messages);
            } while (cursor.moveToNext());
        }
        // Close the curosor
        cursor.close();

        return contacts;
    }

    private int countSms(String numberPhone) {
        int nbSms = 0;
        int result = ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_SMS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    String numberPhoneSms = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                    if(numberPhone.equals(numberPhoneSms)) {
                        nbSms++;
                    }
                } while (cursor.moveToNext());
            }
        } else {
            //nothing
        }
        return nbSms;
    }



}

