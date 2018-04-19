/*
 * Copyright 2017 Derskeal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.tic_tac_toebyaustine;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class handles the example.android.tic_tac_toebyaustine box size 5 single player
 */
public class FiveMultiActivity extends AppCompatActivity {

    private boolean valtouse = true;
    private int taptimes = 0;
    private String[] asv = new String[26]; //asv - all squares value
    private boolean gamewon = false;
    private boolean gamedrawn = false;

    private String[] player = {"","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_grid);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                reset_game();
            }
        });

        avatar_select();

        /*TextView v = (TextView) findViewById(R.id.player_turn_id);
        v.setText("Player 1"); */
    }


    /** Sets the player symbol for the first player */
    private void avatar_select() {
        //Toast.makeText(this, "chai", Toast.LENGTH_SHORT).show();
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setMessage("Please select your Player Symbol")
                .setTitle("Player 1");

        builder.setPositiveButton("X", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //set the player symbol to X
                /*playsym = "X";
                defplaysym = "X";*/
                player[1] = "X";
                player[2] = "O";
                valtouse = true;
                /*TextView v = (TextView) findViewById(R.id.player_turn_id);
                v.setText("X");*/
            }
        });

        builder.setNegativeButton("O", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //set the player symbol to O
                /*playsym = "O";
                defplaysym = "O";*/
                player[1] = "O";
                player[2] = "X";
                valtouse = false;
                /*TextView v = (TextView) findViewById(R.id.player_turn_id);
                v.setText("O");*/
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FiveMultiActivity.this, "Player Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }


    //Rules:
    /*
    *
     *
     * 4 player symbols in a row, column, or diagonal.
    */



    public void cell_clicked(View vv) {
        SharedPreferences sharedPref = getSharedPreferences( "tttm5", Context.MODE_PRIVATE);
        SharedPreferences.Editor storage = sharedPref.edit();

        if (gamewon) {

        } else if (taptimes == 25 && !gamewon) {
            Toast.makeText(this, "Game Over. It's a draw", Toast.LENGTH_SHORT).show();
        }

        else {

            //check if the cell is filled
        /*
        * if filled, do nothing
        * if empty, fill it with the appropriate player symbol and,
        *
        *
        * check if there is a winner
        *
        *
        * */

            TextView v = (TextView) vv;

            if (taptimes < 25 && TextUtils.isEmpty(v.getText().toString())) {
                String playsym;
                if (valtouse) {
                    playsym = player[1];
                    //playsym = "X";
                } else {
                    playsym = player[2];
                    //playsym = "O";
                }

                int tag = Integer.parseInt(v.getTag().toString());
                asv[tag] = playsym;

                v.setText(playsym);
                valtouse = !valtouse;

                /*TextView pti = (TextView) findViewById(R.id.player_turn_id);
                String pt = valtouse ? "X" : "O";
                pti.setText(pt);*/
                taptimes++;



            } else if (taptimes >= 25) {
                //Toast.makeText(this, "Game Over. It's a draw", Toast.LENGTH_SHORT).show();

            }

            else {
                Toast.makeText(this, "Already played cell", Toast.LENGTH_SHORT).show();
            }

            TextView pti = (TextView) findViewById(R.id.player_turn_id);
            if(!gamedrawn) {
                String pt = valtouse ? "Player 1" : "Player 2";
                pti.setText(pt); //this guy sets the player turn
            } else {
                String pt = "Game Over";
                pti.setText(pt);
            }

            //Array e =
            //Object e = new Object();
            int[][] wi = {
                    {1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    { 11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25},
                    {1, 6, 11, 16, 21},
                    {2, 7, 12, 17, 22},
                    {3, 8, 13, 18, 23},
                    {4, 9, 14, 19, 24},
                    {5, 10, 15, 20, 25},
                    {1, 7, 13, 19, 25},
                    {5, 9, 13, 17, 21},
            };


            for (int[] i : wi) {
                int a, b, c, d, e;
                a = i[0];
                b = i[1];
                c = i[2];
                d = i[3];
                e = i[4];

                if (!TextUtils.isEmpty(asv[a]) && asv[a] == asv[b] && asv[a] == asv[c] && asv[a] == asv[d] && asv[a] == asv[e]) {

                    String p = asv[a] == player[1] ? "Player 1" : "Player 2";
                    String winner = "Winner: " + p;


                    //String winner = "Winner: " + asv[a];

                    String pp = p == "Player 1" ? "player1" : "player2";
                    String op = p == "Player 1" ? "player2" : "player1";

                    int vp = sharedPref.getInt(pp+"wins", 0);
                    int vpl = sharedPref.getInt(op+"losses", 0);
                    vp++;
                    vpl++;


                    storage.putInt(pp+"wins",vp);
                    storage.putInt(op+"losses",vpl);
                    storage.apply();


                    Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                    gamewon = true;

                    TextView win = (TextView)findViewById(R.id.winner_status);
                    win.setText(winner);

                    break;
                }

                /*if (!TextUtils.isEmpty(asv[a]) && asv[a] != asv[b] && asv[a] != asv[c]) {

                }*/

            }

            if (taptimes == 25 && !gamewon) {
                Toast.makeText(this, "Game Over. It's a draw", Toast.LENGTH_SHORT).show();
                gamedrawn = true;

                int vp1 = sharedPref.getInt("player1draws", 0);
                int vp2 = sharedPref.getInt("player2draws", 0);
                vp1++;
                vp2++;
                storage.putInt("player1draws",vp1);
                storage.putInt("player2draws",vp2);
                storage.apply();

                String pt = "Game Over";
                pti.setText(pt);
            }


        }
    }

    private void reset_game() {

        //reset all dependent variables

        gamewon = false;
        TextView win = (TextView)findViewById(R.id.winner_status);
        win.setText("");
        taptimes = 0;
        gamedrawn = false;

        valtouse = true;
        TextView pti = (TextView) findViewById(R.id.player_turn_id);
        String pt = valtouse ? "Player 1" : "Player 2";
        pti.setText(pt);

        asv = new String[26];

        TextView tv = (TextView) findViewById(R.id.c1);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c2);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c3);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c4);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c5);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c6);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c7);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c8);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c9);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c10);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c11);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c12);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c13);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c14);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c15);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c16);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c17);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c18);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c19);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c20);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c21);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c22);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c23);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c24);
        tv.setText("");

        tv = (TextView) findViewById(R.id.c25);
        tv.setText("");



    }


}
