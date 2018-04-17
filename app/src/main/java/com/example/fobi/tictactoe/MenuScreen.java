package com.example.fobi.tictactoe;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuScreen extends AppCompatActivity implements View.OnClickListener{

    Button butn1,butn2,butn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        butn1 = findViewById(R.id.but1);
        butn2 = findViewById(R.id.but2);
        butn3 = findViewById(R.id.but3);

        butn1.setOnClickListener(this);
        butn2.setOnClickListener(this);
        butn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but1 :
                Intent single= new Intent(MenuScreen.this,OptionSingle.class);
                startActivity(single);

                break;

            case R.id.but2 :
                Intent multi= new Intent(MenuScreen.this,OptionMulti.class);
                startActivity(multi);

                break;

            case R.id.but3 :
                //initializing score view dialog
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MenuScreen.this);
                final View mView = getLayoutInflater().inflate(R.layout.credit_layout, null);

                mBuilder.setView(mView);
                AlertDialog dialog= mBuilder.create();
                dialog.show();

                break;
        }
    }
}
