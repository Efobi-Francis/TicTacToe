package com.example.fobi.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MultiMode3X3 extends AppCompatActivity implements View.OnClickListener {

    private OptionMulti optMulti=new OptionMulti();

    private Button[][] buttons= new Button[3][3];
    private boolean player1Turn=true;
    private int roundcount;

     int player1points;
     int player2points;

    TextView textViewPlayer1;
    TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_mode3x3);

        textViewPlayer1= findViewById(R.id.ply_score);
        textViewPlayer1.setText(String.format("%s: ",optMulti.user1));

        textViewPlayer2 = findViewById(R.id.phn_score);
        textViewPlayer2.setText(optMulti.user2 + ": ");

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID,"id", getPackageName());
                buttons[i][j]=findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button backOpt=findViewById(R.id.backopt);
        backOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_opt=new Intent(MultiMode3X3.this,OptionMulti.class);
                back_to_opt.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_to_opt);
            }
        });

        Button butReset=findViewById(R.id.reset);
        butReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!((Button)view).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button)view).setText("X");
        }else {
            ((Button)view).setText("O");
        }

        roundcount++;

        if (checkForWin()){
            if (player1Turn){
                player1Wins();
            }else{
                player2Wins();
            }
        }else if (roundcount==9){
            draw();
        }else{
            player1Turn=!player1Turn;
        }
    }

    private boolean checkForWin(){
        String[][] field=new String[3][3];

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                field[i][j]=buttons[i][j].getText().toString();
            }
        }

        for (int i=0; i<3; i++){
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")){
                return true;
            }
        }

        for (int i=0; i<3; i++){
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][1].equals("")){
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")){
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")){
            return true;
        }
        return false;
    }

    private void player1Wins(){
        player1points++;
        Toast.makeText(this,"Player 1 Wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins(){
        player2points++;
        Toast.makeText(this,"Player 2 Wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw(){
        Toast.makeText(this,"Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText(){

    }

    private void resetBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                buttons[i][j].setText("");
            }
        }
        roundcount=0;
        player1Turn=true;
    }
}
