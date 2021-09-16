package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSetup extends AppCompatActivity {
    private EditText player1;
    private EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1=findViewById(R.id.player1Name);
        player2=findViewById(R.id.player2Name);
    }
    public void submitButtonClick(View view){
        String player1Name=player1.getText().toString();
        String player2Name=player2.getText().toString();

        if(TextUtils.isEmpty(player1.getText()) && TextUtils.isEmpty(player2.getText())){
            Toast.makeText(this,"Enter the name of Player 1 and Player 2",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(player1.getText())){
            Toast.makeText(this,"Enter the name of Player 1",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(player2.getText())){
            Toast.makeText(this,"Enter the name of Player 2",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(this,GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[]{player1Name,player2Name});
            startActivity(intent);
        }

    }
}