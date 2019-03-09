package com.example.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button bName,bAcc,bBal,bHide;
    TextView tName,tAcc,tBal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bName=(Button)findViewById(R.id.shwName);
        bAcc=(Button)findViewById(R.id.shwAcc);
        bBal=(Button)findViewById(R.id.shwBal);
        bHide=(Button)findViewById(R.id.hide);

        tName=(TextView)findViewById(R.id.txtName);
        tBal=(TextView)findViewById(R.id.txtBal);
        tAcc=(TextView)findViewById(R.id.txtAcc);


        bName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText("Arunesh");
            }
        });

        bAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_alert_demo2,null);
                final EditText user = (EditText)view.findViewById(R.id.username);
                final EditText pswd = (EditText)view.findViewById(R.id.pswd);

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("You need to login first!").setView(view).setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String u=user.getText().toString();
                        String p=pswd.getText().toString();

                        if(u.equals("Arunesh")&&p.equals("NewPassword1629&"))
                            tAcc.setText("19994");
                    }
                }).setNegativeButton("Cancel",null);

                AlertDialog alert=builder.create();
                alert.show();
            }
        });

        bBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_alert_demo2,null);
                final EditText user=(EditText)view.findViewById(R.id.username);
                final EditText pswd=(EditText)view.findViewById(R.id.pswd);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("You need to login first!").setView(view).setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String u=user.getText().toString();
                        String p=pswd.getText().toString();

                        if(u.equals("Arunesh")&&p.equals("NewPassword1629&"))
                            tBal.setText("Rs 200000");

                    }
                }).setNegativeButton("Cancel",null);

                AlertDialog alert= builder.create();
                alert.show();
            }
        });

        bHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tName.setText("Name");
                tAcc.setText("Acc Number");
                tBal.setText("Balance");
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit").setMessage("Really want to exit?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        }).setNegativeButton("Cancel",null).setCancelable(false);

        AlertDialog alert=builder.create();
        alert.show();
    }
}
