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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        setTheStage();
    }

    private void setTheStage() {

        //SINGLE PLAYER
        //3x3 box section

        SharedPreferences sp = getSharedPreferences("ttts3", Context.MODE_PRIVATE);

        int p1wi = sp.getInt("player1wins", 0);
        int p2wi = sp.getInt("computerwins", 0);

        int p1di = sp.getInt("player1draws", 0);
        int p2di = sp.getInt("computerdraws", 0);

        int p1li = sp.getInt("player1losses", 0);
        int p2li = sp.getInt("computerlosses", 0);

        String p1w = p1wi+"";
        String p2w = p2wi+"";

        String p1d = p1di+"";
        String p2d = p2di+"";

        String p1l = p1li+"";
        String p2l = p2li+"";

        TextView tv = (TextView)findViewById(R.id.sthreewinsp1);//w1);
        tv.setText(p1w);

        tv = (TextView)findViewById(R.id.sthreewinsp2);//w2);
        tv.setText(p2w);

        tv = (TextView)findViewById(R.id.sthreedrawsp1);//d1);
        tv.setText(p1d);

        tv = (TextView)findViewById(R.id.sthreedrawsp2);//d2);
        tv.setText(p2d);

        tv = (TextView)findViewById(R.id.sthreelossesp1);//l1);
        tv.setText(p1l);

        tv = (TextView)findViewById(R.id.sthreelossesp2);//l2);
        tv.setText(p2l);



        //SINGLE LAYER
        //4X4 BOX SECTION

        sp = getSharedPreferences("ttts4", Context.MODE_PRIVATE);

        p1wi = sp.getInt("player1wins", 0);
        p2wi = sp.getInt("computerwins", 0);

        p1di = sp.getInt("player1draws", 0);
        p2di = sp.getInt("computerdraws", 0);

        p1li = sp.getInt("player1losses", 0);
        p2li = sp.getInt("computerlosses", 0);

        p1w = p1wi+"";
        p2w = p2wi+"";
        p1d = p1di+"";
        p2d = p2di+"";

        p1l = p1li+"";
        p2l = p2li+"";



        //SINGLE LAYER
        //5x5 BOX SECTION

        sp = getSharedPreferences("ttts5", Context.MODE_PRIVATE);

        p1wi = sp.getInt("player1wins", 0);
        p2wi = sp.getInt("computerwins", 0);

        p1di = sp.getInt("player1draws", 0);
        p2di = sp.getInt("computerdraws", 0);

        p1li = sp.getInt("player1losses", 0);
        p2li = sp.getInt("computerlosses", 0);

        p1w = p1wi+"";
        p2w = p2wi+"";
        p1d = p1di+"";
        p2d = p2di+"";

        p1l = p1li+"";
        p2l = p2li+"";

        tv = (TextView)findViewById(R.id.sfivewinsp1);//w1);
        tv.setText(p1w);

        tv = (TextView)findViewById(R.id.sfivewinsp2);//w2);
        tv.setText(p2w);

        tv = (TextView)findViewById(R.id.sfivedrawsp1);//d1);
        tv.setText(p1d);

        tv = (TextView)findViewById(R.id.sfivedrawsp2);//d2);
        tv.setText(p2d);

        tv = (TextView)findViewById(R.id.sfivelossesp1);//l1);
        tv.setText(p1l);

        tv = (TextView)findViewById(R.id.sfivelossesp2);//l2);
        tv.setText(p2l);


        //MULTIPLAYER
        //3x3 BOX SECTION

        sp = getSharedPreferences("tttm3", Context.MODE_PRIVATE);

        p1wi = sp.getInt("player1wins", 0);
        p2wi = sp.getInt("player2wins", 0);

        p1di = sp.getInt("player1draws", 0);
        p2di = sp.getInt("player2draws", 0);

        p1li = sp.getInt("player1losses", 0);
        p2li = sp.getInt("player2losses", 0);

        p1w = p1wi+"";
        p2w = p2wi+"";
        p1d = p1di+"";
        p2d = p2di+"";

        p1l = p1li+"";
        p2l = p2li+"";

        tv = (TextView)findViewById(R.id.mthreewinsp1);
        tv.setText(p1w);

        tv = (TextView)findViewById(R.id.mthreewinsp2);
        tv.setText(p2w);

        tv = (TextView)findViewById(R.id.mthreedrawsp1);
        tv.setText(p1d);

        tv = (TextView)findViewById(R.id.mthreedrawsp2);
        tv.setText(p2d);

        tv = (TextView)findViewById(R.id.mthreelossesp1);
        tv.setText(p1l);

        tv = (TextView)findViewById(R.id.mthreelossesp2);
        tv.setText(p2l);


        //MULTIPLAYER
        //4x4 BOX SECTION

        sp = getSharedPreferences("tttm4", Context.MODE_PRIVATE);

        p1wi = sp.getInt("player1wins", 0);
        p2wi = sp.getInt("player2wins", 0);

        p1di = sp.getInt("player1draws", 0);
        p2di = sp.getInt("player2draws", 0);

        p1li = sp.getInt("player1losses", 0);
        p2li = sp.getInt("player2losses", 0);

        p1w = p1wi+"";
        p2w = p2wi+"";
        p1d = p1di+"";
        p2d = p2di+"";

        p1l = p1li+"";
        p2l = p2li+"";



        //MULTIPLAYER
        //5x5 BOX SECTION

        sp = getSharedPreferences("tttm5", Context.MODE_PRIVATE);

        p1wi = sp.getInt("player1wins", 0);
        p2wi = sp.getInt("player2wins", 0);

        p1di = sp.getInt("player1draws", 0);
        p2di = sp.getInt("player2draws", 0);

        p1li = sp.getInt("player1losses", 0);
        p2li = sp.getInt("player2losses", 0);

        p1w = p1wi+"";
        p2w = p2wi+"";
        p1d = p1di+"";
        p2d = p2di+"";

        p1l = p1li+"";
        p2l = p2li+"";

        tv = (TextView)findViewById(R.id.mfivewinsp1);
        tv.setText(p1w);

        tv = (TextView)findViewById(R.id.mfivewinsp2);
        tv.setText(p2w);

        tv = (TextView)findViewById(R.id.mfivedrawsp1);
        tv.setText(p1d);

        tv = (TextView)findViewById(R.id.mfivedrawsp2);
        tv.setText(p2d);

        tv = (TextView)findViewById(R.id.mfivelossesp1);
        tv.setText(p1l);

        tv = (TextView)findViewById(R.id.mfivelossesp2);
        tv.setText(p2l);
    }
}
