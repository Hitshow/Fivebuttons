package com.example.fivebuttons;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    LinearLayout ll ;
    Random rnd;

    /**
     * @author hadar ohana
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.ll);
        rnd = new Random();
    }

    public void message(View view) {adb = new AlertDialog.Builder(this);
        adb.setTitle("Only message");
        adb.setMessage("Hello");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method shows text message  when you click the button
     */
    public void icon(View view) {adb = new AlertDialog.Builder(this);
        adb.setTitle("Picture and a message");
        adb.setIcon(R.drawable.itachi);
        adb.setMessage("Hello");
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void icon_massege_button(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Picture message and a button");
        adb.setMessage("Hello");
        adb.setIcon(R.drawable.itachi);
        adb.setNegativeButton("cencel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();

    }

    /**
     *The method shows text message and picture when you click the button
     */
    public void color(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("message and two buttons");
        adb.setMessage("Do you want to change your background?");
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method shows text message and picture and a button tho random change the background when you click the button
     */
    public void randomcolor(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text and 2 buttons");
        adb.setMessage("random background?");
        adb.setPositiveButton("random color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        adb.setNeutralButton("defualt", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNegativeButton("cencel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.credit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent si=new Intent(this,credit.class);
        startActivity(si);
        return true;

    }
}
