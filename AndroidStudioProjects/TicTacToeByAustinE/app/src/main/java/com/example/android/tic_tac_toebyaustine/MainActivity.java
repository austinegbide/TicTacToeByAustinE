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

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * MainActivy class
 */
public class MainActivity extends AppCompatActivity {

    Button onePlayer, twoPlayers, threeByThreeOne, fiveByFiveOne,threeByThreeTwo, fiveByFiveTwo, about;


//    Button onePlayer = (Button) findViewById(R.id.onePlayerBtn);
//    Button twoPlayers = (Button) findViewById(R.id.twoPlayersBtn);
//    Button threeByThreeOne = (Button) findViewById(R.id.threeByThreeOneBtn);
//    Button fiveByFiveOne = (Button) findViewById(R.id.fiveByFiveOneBtn);
//    Button threeByThreeTwo = (Button) findViewById(R.id.threeByThreeTwoBtn);
//    Button fiveByFiveTwo = (Button) findViewById(R.id.fiveByFiveTwoBtn);
//    Button about = (Button) findViewById(R.id.about_btn);

    boolean singleSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onePlayer = (Button)findViewById(R.id.onePlayerBtn);
        twoPlayers = (Button)findViewById(R.id.twoPlayersBtn);
        threeByThreeOne = (Button)findViewById(R.id.threeByThreeOneBtn);
        fiveByFiveOne = (Button)findViewById(R.id.fiveByFiveOneBtn);
        threeByThreeTwo = (Button)findViewById(R.id.threeByThreeTwoBtn);
        fiveByFiveTwo = (Button)findViewById(R.id.fiveByFiveTwoBtn);
        about = (Button)findViewById(R.id.about_btn);


        threeByThreeOne.setVisibility(View.VISIBLE);
        fiveByFiveOne.setVisibility(View.VISIBLE);
        threeByThreeTwo.setVisibility(View.INVISIBLE);
        fiveByFiveTwo.setVisibility(View.INVISIBLE);
        twoPlayers.setAlpha((float) 0.3);


        onePlayer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onePlayer.setAlpha((float) 1);
                        twoPlayers.setAlpha((float) 0.3);
                        singleSelected = true;
                        onePlayer.setVisibility(View.VISIBLE);
                        threeByThreeOne.setVisibility(View.VISIBLE);
                        fiveByFiveOne.setVisibility(View.VISIBLE);
                        threeByThreeTwo.setVisibility(View.INVISIBLE);
                        fiveByFiveTwo.setVisibility(View.INVISIBLE);
                    }
                }
        );


        twoPlayers.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        twoPlayers.setAlpha((float) 1);
                        onePlayer.setAlpha((float) 0.3);
                        singleSelected = false;
                        twoPlayers.setVisibility(View.VISIBLE);
                        threeByThreeOne.setVisibility(View.INVISIBLE);
                        fiveByFiveOne.setVisibility(View.INVISIBLE);
                        threeByThreeTwo.setVisibility(View.VISIBLE);
                        fiveByFiveTwo.setVisibility(View.VISIBLE);
                    }
                }
        );

        about.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, About.class);
                        startActivity(intent);
                    }
                }
        );

    }

    //launch the activities
    public void mplay_3x3(View v) {
        Intent intent = new Intent(this, ThreeMultiActivity.class);
        startActivity(intent);
    }


    public void mplay_5x5(View v) {
        Intent intent = new Intent(this, FiveMultiActivity.class);
        startActivity(intent);
    }

    public void splay_3x3(View v) {
        Intent intent = new Intent(this, ThreeSingleActivity.class);
        startActivity(intent);
    }

    public void splay_5x5(View v) {
        Intent intent = new Intent(this, FiveSingleActivity.class);
        startActivity(intent);
    }

    public void scoreboard(View v) {
        Intent intent = new Intent(this, ScoreBoardActivity.class);
        startActivity(intent);

        /*SharedPreferences sp = getSharedPreferences("dded", this.MODE_PRIVATE);
        SharedPreferences.Editor storage = sp.edit();

        int vp = sp.getInt("one two", 0);
        vp++;
        storage.putInt("one two",56);
        storage.apply();


        int r = sp.getInt("one two",0);
        Toast.makeText(this, ""+r, Toast.LENGTH_SHORT).show();*/
    }

    public void exit_click(View v) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

        dlgAlert.setMessage("Do you really want to exit");
        dlgAlert.setTitle("Exit");

        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
        dlgAlert.create().show();

        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
    }


}
