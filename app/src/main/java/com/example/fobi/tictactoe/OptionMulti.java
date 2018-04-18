package com.example.fobi.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OptionMulti extends AppCompatActivity {
     static String user1,user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_multi);

        final RadioButton mode3x3=findViewById(R.id.rad_3);
        final RadioButton mode5x5=findViewById(R.id.rad_4);

        Button back=findViewById(R.id.backmenu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_home=new Intent(OptionMulti.this,MenuScreen.class);
                back_to_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_to_home);
            }
        });

        final Button play=findViewById(R.id.playgame);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup grp_2 = findViewById(R.id.rgrp2);
                RadioButton maker_2 = findViewById(grp_2.getCheckedRadioButtonId());

                if (maker_2==mode3x3){

                    EditText username1=findViewById(R.id.username_1);
                    user1=username1.getText().toString();

                    EditText username2=findViewById(R.id.username_2);
                    user2=username2.getText().toString();

                    Intent play1 = new Intent(OptionMulti.this,MultiMode3X3.class);
                    startActivity(play1);
                }else if (maker_2==mode5x5){

                    EditText username1=findViewById(R.id.username_1);
                    user1=username1.getText().toString();

                    EditText username2=findViewById(R.id.username_2);
                    user2=username2.getText().toString();

                    Intent play1 = new Intent(OptionMulti.this,MultiMode5X5.class);
                    startActivity(play1);
                }else {
                    Toast.makeText(OptionMulti.this, "Select Difficulty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
