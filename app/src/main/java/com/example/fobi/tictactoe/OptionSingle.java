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

public class OptionSingle extends AppCompatActivity {
    static String user;
    String player_maker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_single);

        final RadioButton playMaker_x =findViewById(R.id.rad1);
        final RadioButton playMaker_o =findViewById(R.id.rad2);
        final RadioButton mode3x3=findViewById(R.id.rad3);
        final RadioButton mode5x5=findViewById(R.id.rad4);

        Button back=findViewById(R.id.back_menu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_home=new Intent(OptionSingle.this,MenuScreen.class);
                back_to_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_to_home);
            }
        });

        final Button play=findViewById(R.id.play_game);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup grp = findViewById(R.id.rgrp);
                RadioButton maker = findViewById(grp.getCheckedRadioButtonId());

                RadioGroup grp_2 = findViewById(R.id.rgrp_2);
                RadioButton maker_2 = findViewById(grp_2.getCheckedRadioButtonId());

                if ((maker==playMaker_x)&&(maker_2==mode3x3)){

                    EditText username=findViewById(R.id.user_name);
                    user=username.getText().toString();

                    player_maker=maker.getResources().getString(R.string.player_x_maker);

                    Intent play1 = new Intent(OptionSingle.this,Mode3X3.class);
                    startActivity(play1);
                }else if((maker==playMaker_o)&&(maker_2==mode3x3)){

                    EditText username=findViewById(R.id.user_name);
                    user=username.getText().toString();

                    player_maker=maker.getResources().getString(R.string.player_o_maker);

                    Intent play1 = new Intent(OptionSingle.this,Mode3X3.class);
                    startActivity(play1);
                }else if ((maker==playMaker_x)&&(maker_2==mode5x5)){

                    EditText username=findViewById(R.id.user_name);
                    user=username.getText().toString();

                    player_maker=maker.getResources().getString(R.string.player_x_maker);

                    Intent play1 = new Intent(OptionSingle.this,Mode5X5.class);
                    startActivity(play1);
                }else if ((maker==playMaker_o)&&(maker_2==mode5x5)){

                    EditText username=findViewById(R.id.user_name);
                    user=username.getText().toString();

                    player_maker=maker.getResources().getString(R.string.player_o_maker);

                    Intent play1 = new Intent(OptionSingle.this,Mode5X5.class);
                    startActivity(play1);
                }else {
                    Toast.makeText(OptionSingle.this, "Choose a sign and Difficulty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
