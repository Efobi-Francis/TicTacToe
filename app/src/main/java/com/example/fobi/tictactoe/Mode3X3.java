package com.example.fobi.tictactoe;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mode3X3 extends AppCompatActivity {

    OptionSingle optSingle = new OptionSingle();

    private Button[][] buttons= new Button[3][3];
    private boolean player1Turn=true;
    private int roundcount;

    private int playerpoints;
    private int phonepoints;

    TextView textviewPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode3x3);

        textviewPlayer=findViewById(R.id.plyscore);
        textviewPlayer.setText(String.format("%s: ",optSingle.user));

        Button backOpt=findViewById(R.id.back_opt);
        backOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_opt=new Intent(Mode3X3.this,OptionSingle.class);
                back_to_opt.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_to_opt);
            }
        });

    }

}
