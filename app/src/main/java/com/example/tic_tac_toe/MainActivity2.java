package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private ImageButton btn1, btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 ;
    private TextView title, role, p1Score, p2Score;
    private ImageView line1, line2;
    private final SelectedBtn[] playField = new SelectedBtn[10];
    private final int[] emptySpaces = new int[8]; // to store the empty btns on play field
    private int nbrPlays = 0;
    private boolean isPlayerTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button resetBtn;
        //defining the variables
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);
        resetBtn = findViewById(R.id.reset);
        title = findViewById(R.id.title);
        role = findViewById(R.id.state);
        p1Score = findViewById(R.id.player1Score);
        p2Score = findViewById(R.id.player2Score);
        line1 = findViewById(R.id.pLine1);
        line2 = findViewById(R.id.pLine2);

        animate(line1,R.drawable.animated_line2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn1) ) {
                    select(btn1, 1);
                    animate(btn1);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn2)) {
                    select(btn2, 2);
                    animate(btn2);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn3)) {
                    select(btn3, 3);
                    animate(btn3);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn4)) {
                    select(btn4, 4);
                    animate(btn4);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn5)) {
                    select(btn5, 5);
                    animate(btn5);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn6)) {
                    select(btn6, 6);
                    animate(btn6);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn7)) {
                    select(btn7, 7);
                    animate(btn7);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn8)) {
                    select(btn8, 8);
                    animate(btn8);
                    disableAll(true);
                    aiPlays();

                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(btn9)) {
                    select(btn9, 9);
                    animate(btn9);
                    disableAll(true);
                    aiPlays();
                } else
                    Toast.makeText(MainActivity2.this, "please select an empty place!", Toast.LENGTH_SHORT).show();
                gameOver();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                isPlayerTurn =true;
                animate(line1,R.drawable.animated_line2);
                line2.setBackgroundResource(R.drawable.empty);
                role.setText("Click somewhere to start.");
                Arrays.fill(playField, null);
                Arrays.fill(emptySpaces,0);
                nbrPlays = 0;

            }
        });
    }
    //  **********************Functions***************************

    //sets the value for the buttons
    public void select (ImageButton btn , int pos){
        if(isPlayerTurn){
            btn.setBackgroundResource(R.drawable.animated_x);
            isPlayerTurn = !isPlayerTurn;
            btn.setTag("x");
            animate(line2,R.drawable.animated_line);
            line1.setBackgroundResource(R.drawable.empty);
            role.setText("it's O's turn");
        }
        else{
            btn.setBackgroundResource(R.drawable.animated_o);
            isPlayerTurn = !isPlayerTurn;
            btn.setTag("o");
            animate(line1,R.drawable.animated_line2);
            line2.setBackgroundResource(R.drawable.empty);
            role.setText("it's X's turn");
        }
        playField[pos] = new SelectedBtn(pos,btn.getTag().toString());
        nbrPlays++;
        //if(playField[played] != null)
        //Toast.makeText(this, "hi :" + playField[played].getTag(), Toast.LENGTH_SHORT).show();
    }

    //resets buttons
    public void resetBtn(ImageButton btn){
        btn.setBackgroundResource(R.drawable.empty);
        btn.setTag(null);
    }
    public void resetAll(){
        resetBtn(btn1);
        resetBtn(btn2);
        resetBtn(btn3);
        resetBtn(btn4);
        resetBtn(btn5);
        resetBtn(btn6);
        resetBtn(btn7);
        resetBtn(btn8);
        resetBtn(btn9);
        disableAll(false);
    }

    //animation of the svg
    public void animate(ImageButton btn){
        AnimatedVectorDrawable avd = (AnimatedVectorDrawable ) btn.getBackground();
        avd.start();
    }
    public void animate(ImageButton b1,ImageButton b2,ImageButton b3){
        animate(b1);
        animate(b2);
        animate(b3);
    }
    public void animate(ImageView v, int id){
        v.setBackgroundResource(id);
        AnimatedVectorDrawable avd = (AnimatedVectorDrawable ) v.getBackground();
        avd.start();
    }

    //checks if a button is empty
    public boolean isEmpty(ImageButton btn){
        return btn.getTag() == null;
    }

    //game logic
    public boolean is_win(ImageButton b1, ImageButton b2, ImageButton b3){
        return (b1.getTag() != null && b2.getTag() != null && b3.getTag() != null) && (b1.getTag()==b2.getTag() && b2.getTag()==b3.getTag());
    }

    public Winner gameStatus(){
        Winner winner =new Winner();
        if(is_win(btn1,btn2,btn3)){
            winner.setPos(1);
            winner.setWon(true);
            winner.setSymbol(btn1.getTag().toString());
        }
        else if(is_win(btn4,btn5,btn6)){
            winner.setPos(2);
            winner.setWon(true);
            winner.setSymbol(btn4.getTag().toString());
        }
        else if(is_win(btn7,btn8,btn9)){
            winner.setPos(3);
            winner.setWon(true);
            winner.setSymbol(btn7.getTag().toString());
        }
        else if(is_win(btn1,btn4,btn7)){
            winner.setPos(4);
            winner.setWon(true);
            winner.setSymbol(btn1.getTag().toString());
        }
        else if(is_win(btn2,btn5,btn8)) {
            winner.setPos(5);
            winner.setWon(true);
            winner.setSymbol(btn2.getTag().toString());
        }
        else if(is_win(btn9,btn6,btn3)){
            winner.setPos(6);
            winner.setWon(true);
            winner.setSymbol(btn9.getTag().toString());
        }
        else if(is_win(btn3,btn5,btn7)) {
            winner.setPos(7);
            winner.setWon(true);
            winner.setSymbol(btn7.getTag().toString());
        }
        else if(is_win(btn9,btn5,btn1)){
            winner.setPos(8);
            winner.setWon(true);
            winner.setSymbol(btn1.getTag().toString());
        }
        else{
            winner.setWon(false);
        }

        return winner;

    }

    public boolean isGameDraw() {
        return isEmpty(btn1) && isEmpty(btn2) && isEmpty(btn3) && isEmpty(btn4) && isEmpty(btn5) && isEmpty(btn6) && isEmpty(btn7) &&
                isEmpty(btn8) && isEmpty(btn9);
    }

    public void gameOver(){
        if( gameStatus().isWon() && nbrPlays < 10) {
            disableAll(true);
            role.setText("Congratulations " + gameStatus().getSymbol().toUpperCase() + " won the game!");
            //Toast.makeText(MainActivity.this, "game is won", Toast.LENGTH_SHORT).show();
            congrats(gameStatus().getPos());
            if(gameStatus().getSymbol().equals("x")){
                updateScore(p1Score);
                animate(line1,R.drawable.animated_line2);
                line2.setBackgroundResource(R.drawable.empty);
            }else{
                updateScore(p2Score);
                animate(line2,R.drawable.animated_line);
                line1.setBackgroundResource(R.drawable.empty);
            }
        }else if(nbrPlays == 9){
            role.setText("GameOver! It's a draw");
        }

    }
    // as the name indicates
    public void updateScore(TextView t) {
        String actualScore = (String) t.getText();
        int temp = Integer.parseInt(actualScore);
        temp++;
        t.setText(String.valueOf(temp));
    }

    //animating the winner
    public void congrats(int pos){
        switch (pos){
            case 1:
                animate(btn1,btn2,btn3);
                break;
            case 2:
                animate(btn4, btn5, btn6);
                break;
            case 3:
                animate(btn7, btn8, btn9);
                break;
            case 4:
                animate(btn1, btn4, btn7);
                break;
            case 5:
                animate(btn2, btn5, btn8);
                break;
            case 6:
                animate(btn3, btn6, btn9);
                break;
            case 7:
                animate(btn7, btn5, btn3);
                break;
            case 8:
                animate(btn9, btn5, btn1);
                break;
            default:
                role.setText("It's a draw! Try again.");
                break;
        }
    }

    //disabling all the buttons except the play again
    public void disableAll(boolean bool) {
        btn1.setEnabled(!bool);
        btn2.setEnabled(!bool);
        btn3.setEnabled(!bool);
        btn4.setEnabled(!bool);
        btn5.setEnabled(!bool);
        btn6.setEnabled(!bool);
        btn7.setEnabled(!bool);
        btn8.setEnabled(!bool);
        btn9.setEnabled(!bool);
    }

    //Ai
    public void aiPlays(){

        final int[] j = {0};
        final int[] randomNum = new int[1];
        final Handler handler = new Handler();
        if(playField != null && !gameStatus().isWon() && nbrPlays < 9) { //the game isn't done play
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms

                    for (int i = 1; i < playField.length; i++) {

                        if (playField[i] == null) { // if a button is empty
                            emptySpaces[j[0]] = i;     // store its index in emptySpaces
                            j[0]++;// increment so that the data isn't capped
                        }
                    }

                    //debug
                    Log.d(TAG, "\naiPlays: the empty spaces/***********/\n");
                    for (int i = 0; i < j[0]; i++) {
                        Log.d(TAG, "aiPlays  empty:" + emptySpaces[i] + "\t");
                    }

                    randomNum[0] = ThreadLocalRandom.current().nextInt(1, j[0]);//chose a  random number

                    //debug
                    Log.d(TAG, "aiPlays: //////// this is the rand number :" + randomNum[0] + "\tthis is the the rand index on the play field :" + emptySpaces[randomNum[0]]);

                    aiSelectBtn(emptySpaces[randomNum[0]]);

                    //debug
                    for (int i = 1; i < playField.length; i++) {
                        Log.d(TAG, "aiPlays: played " + i + " : " + playField[i]);
                    }
                    gameOver();

                    disableAll(false);
                }

            }, 1000);
        }


    }
    public void aiSelectBtn(int pos){
        switch (pos){
            case 1: {
                select(btn1, 1);
                animate(btn1);
                break;
            }
            case 2: {
                select(btn2, 2);
                animate(btn2);
                break;
            }
            case 3: {
                select(btn3, 3);
                animate(btn3);
                break;
            }
            case 4: {
                select(btn4, 4);
                animate(btn4);
                break;
            }
            case 5: {
                select(btn5, 5);
                animate(btn5);
                break;
            }
            case 6: {
                select(btn6, 6);
                animate(btn6);
                break;
            }
            case 7: {
                select(btn7, 7);
                animate(btn7);
                break;
            }
            case 8: {
                select(btn8, 8);
                animate(btn8);
                break;
            }
            case 9: {
                select(btn9, 9);
                animate(btn9);
                break;
            }
            default:
                Toast.makeText(this, "Unexpected Error occured!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}