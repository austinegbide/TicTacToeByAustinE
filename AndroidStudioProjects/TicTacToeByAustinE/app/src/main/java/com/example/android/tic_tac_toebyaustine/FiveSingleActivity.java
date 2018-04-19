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
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * This class handles the example.android.tic_tac_toebyaustine box size 5 single player
 */

public class FiveSingleActivity extends AppCompatActivity {

    private boolean valtouse = true;
    private int taptimes = 0;

    private String[] asv = new String[26]; //asv - all squares value
    private boolean gamewon = false;

    //the above two perform the same function as the below, therefore:
    private String defplaysym;

    private int r1;
    private boolean player_played;

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
    }

    //Rules:
    /*
    *
     *
     * 4 player symbols in a row, column, or diagonal.
    */


    private void avatar_select() {
        //Toast.makeText(this, "chai", Toast.LENGTH_SHORT).show();
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setMessage("Please select your Player Symbol")
                .setTitle("Player");

        builder.setPositiveButton("X", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //set the player symbol to X
                //player = "X";
                //playsym = "X";
                defplaysym = "X";
                valtouse = true;
                /*TextView v = (TextView) findViewById(R.id.player_turn_id);
                v.setText("");*/
            }
        });

        builder.setNegativeButton("O", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //set the player symbol to O
                // player = "O";
                //playsym = "O";
                defplaysym = "O";
                valtouse = false;
                /*TextView v = (TextView) findViewById(R.id.player_turn_id);
                v.setText("O");*/
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FiveSingleActivity.this, "Player Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void cell_clicked(View v) {
        cell_clicked2(v);

        TextView k = (TextView)findViewById(R.id.player_turn_id);
        if(!gamewon && taptimes < 25) {
            k.setText(R.string.comp_play_status);
        } else if (gamewon && taptimes >= 25) {
            k.setText(R.string.game_over);
        } else if (!gamewon && taptimes >= 25) {
            /*Toast.makeText(this, "Gamez Ova", Toast.LENGTH_SHORT).show();
            k.setText("Game Over");*/
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                ai_play();
            }
        }, 1000);

    }


    private void cell_clicked2(View vv) {

        SharedPreferences sharedPref = getSharedPreferences( "ttts5", Context.MODE_PRIVATE);
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
            TextView pti = (TextView) findViewById(R.id.player_turn_id);

            if (taptimes < 25 && TextUtils.isEmpty(v.getText().toString())) {
                String playsym;
                if (valtouse) {
                    playsym = "X";
                } else {
                    playsym = "O";
                }

                int tag = Integer.parseInt(v.getTag().toString());
                asv[tag] = playsym;

                v.setText(playsym);
                valtouse = !valtouse;

                //TextView pti = (TextView) findViewById(R.id.player_turn_id);
                String pt = valtouse ? "Player 1" : "Computer";
                pti.setText(pt);
                taptimes++;

            } else if (taptimes >= 16) {
                Toast.makeText(this, "Game Over. It's a draw", Toast.LENGTH_SHORT).show();
            }

            else {
                Toast.makeText(this, "Already played cell", Toast.LENGTH_SHORT).show();
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

                    String p = asv[a] == defplaysym ? "Player 1" : "Computer";
                    String winner = "Winner: " + p;

                    Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                    gamewon = true;

                    TextView win = (TextView)findViewById(R.id.winner_status);
                    win.setText(winner);

                    pti.setText(R.string.game_over);

                    String pp = p == "Player 1" ? "player1" : "computer";
                    String op = p == "Player 1" ? "computer" : "player1";

                    int vp = sharedPref.getInt(pp+"wins", 0);
                    int vpl = sharedPref.getInt(op+"losses", 0);
                    vp++;
                    vpl++;


                    storage.putInt(pp+"wins",vp);
                    storage.putInt(op+"losses",vpl);
                    storage.apply();



                    break;
                }

                /*if (!TextUtils.isEmpty(asv[a]) && asv[a] != asv[b] && asv[a] != asv[c]) {

                }*/

            }

            if (!gamewon && taptimes >= 16) {
                //Toast.makeText(this, "Gamez Ova", Toast.LENGTH_SHORT).show();
                //TextView k = (TextView)findViewById(R.id.player_turn_id);
                pti.setText(R.string.game_over);

                int vp1 = sharedPref.getInt("player1draws", 0);
                int vp2 = sharedPref.getInt("computerdraws", 0);
                vp1++;
                vp2++;
                storage.putInt("player1draws",vp1);
                storage.putInt("computerdraws",vp2);
                storage.apply();
            }

            /*if (taptimes == 16 && !gamewon) {
                Toast.makeText(this, "Game Over. It's a draw", Toast.LENGTH_SHORT).show();
            }*/


        }
    }

    private void reset_game() {
        gamewon = false;
        TextView win = (TextView)findViewById(R.id.winner_status);
        win.setText("");
        taptimes = 0;



        valtouse = true;
        TextView pti = (TextView) findViewById(R.id.player_turn_id);
        String pt = valtouse ? "Player 1" : "Computer";
        pti.setText(pt);

        asv = new String[26];


        int[] allcells = get_cells_in_array();

        for (int c :
                allcells) {
            try {
                TextView tv = (TextView) findViewById(c);
                tv.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private int[] get_cells_in_array() {

        int c1 = R.id.c1;
        int c2 = R.id.c2;
        int c3 = R.id.c3;
        int c4 = R.id.c4;
        int c5 = R.id.c5;
        int c6 = R.id.c6;
        int c7 = R.id.c7;
        int c8 = R.id.c8;
        int c9 = R.id.c9;
        int c10 = R.id.c10;
        int c11 = R.id.c11;
        int c12 = R.id.c12;
        int c13 = R.id.c13;
        int c14 = R.id.c14;
        int c15 = R.id.c15;
        int c16 = R.id.c16;
        int c17 = R.id.c17;
        int c18 = R.id.c18;
        int c19 = R.id.c19;
        int c20 = R.id.c20;
        int c21 = R.id.c21;
        int c22 = R.id.c22;
        int c23 = R.id.c23;
        int c24 = R.id.c24;
        int c25 = R.id.c25;


        return new int[] {0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25};
    }

    private void ai_play() {

        int[] cs = get_cells_in_array();


        Random rand = new Random();


        boolean akpos = false;
        while (!akpos) {
            r1 = rand.nextInt(25);
            if (r1 != 0 && TextUtils.isEmpty(asv[r1])) {
                akpos = true;
            } else if(!TextUtils.isEmpty(asv[1]) && !TextUtils.isEmpty(asv[2]) && !TextUtils.isEmpty(asv[3]) && !TextUtils.isEmpty(asv[4])
                    && !TextUtils.isEmpty(asv[5]) && !TextUtils.isEmpty(asv[6]) && !TextUtils.isEmpty(asv[7]) && !TextUtils.isEmpty(asv[8])
                    && !TextUtils.isEmpty(asv[9]) && !TextUtils.isEmpty(asv[10]) && !TextUtils.isEmpty(asv[11]) && !TextUtils.isEmpty(asv[12])
                    && !TextUtils.isEmpty(asv[13]) && !TextUtils.isEmpty(asv[14]) && !TextUtils.isEmpty(asv[15]) && !TextUtils.isEmpty(asv[16])
                    && !TextUtils.isEmpty(asv[17]) && !TextUtils.isEmpty(asv[18]) && !TextUtils.isEmpty(asv[19]) && !TextUtils.isEmpty(asv[20])
                    && !TextUtils.isEmpty(asv[21]) && !TextUtils.isEmpty(asv[22]) && !TextUtils.isEmpty(asv[23]) && !TextUtils.isEmpty(asv[24])
                    && !TextUtils.isEmpty(asv[25]) )

            {
                break;
            }
        }

        try {
            player_played = false;

            TextView v = (TextView) findViewById(cs[r1]);
            //v.performClick();
            cell_clicked2(v);
        } catch (Exception e) {
            //Toast.makeText(ThreeSingleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

}
