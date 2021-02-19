package com.example.tp2_style;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{ Button b1, b2 , b3, b4, b5, b6 , b7; EditText t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        t1 = (EditText)findViewById(R.id.t1); b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this); }
        private void SendNotification() {
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        b.setAutoCancel(true) .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
               // .setSmallIcon(R.drawable.web)
                .setTicker("Formation Android")
                .setContentTitle("Notification")
                .setContentText("bonjour mes collegues je suis heureux d'etre avec vous :).")
                .setContentInfo("INFO");
        NotificationManager nm = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
        nm.notify(1, b.build()); }
        @Override public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.b4 : SendNotification(); break;
            case R.id.b5: AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setMessage("Message");
            adb.setPositiveButton("OK", new DialogInterface.OnClickListener()
            { @Override public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this,"clic sur OK",Toast.LENGTH_LONG).show();
            } });
            AlertDialog alert= adb.create();
            alert.show(); break;
            case R.id.b6: adb = new AlertDialog.Builder(this);
            adb.setMessage("Message");
            adb.setPositiveButton("OUI", new DialogInterface.OnClickListener()
            {
                @Override public void onClick(DialogInterface arg0, int arg1)
                { Toast.makeText(MainActivity.this,"clic sur OK",Toast.LENGTH_LONG).show();
                } });
            adb.setNegativeButton("NON", new DialogInterface.OnClickListener()
            {
                @Override public void onClick(DialogInterface arg0, int arg1)
                {
                    finish();
                } });
            alert= adb.create();
            alert.show();
            break;
            case R.id.b7: adb = new AlertDialog.Builder(this);
            adb.setMessage("Message"); adb.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                @Override public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(MainActivity.this,"clic sur OK",Toast.LENGTH_LONG).show(); } });
            adb.setNegativeButton("NON", new DialogInterface.OnClickListener()
            { @Override public void
            onClick(DialogInterface arg0, int arg1) { finish(); } });
            adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener()
            { @Override public void onClick(DialogInterface arg0, int arg1)
            { finish(); } }); alert= adb.create(); alert.show(); break;
            case R.id.b1 : Toast.makeText(getApplicationContext()," Message durée limitée",Toast.LENGTH_LONG).show(); break;
            case R.id.b2 : Toast.makeText(getApplicationContext(),
        " Message durée limitée",Toast.LENGTH_SHORT).show(); break;
        case R.id.b3 :
            final Toast msg= Toast.makeText(getApplicationContext()," Message durée limitée",Toast.LENGTH_LONG);
            msg.show(); Handler hd = new Handler();
            hd.postDelayed(new Runnable() {
                @Override public void run() { msg.cancel(); } } , Integer.parseInt(t1.getText().toString())*1000);
            break;
        }
    }
}

