package com.said.oubella.americanfootballscores;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TEAM_A_SCORE = "teamAScore";
    private static final String TEAM_B_SCORE = "teamBScore";

    private int aTeamScore = 0;
    private int bTeamScore = 0;

    private TextView aTeamDisplay;
    private TextView bTeamDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aTeamDisplay = findViewById(R.id.a_score);
        bTeamDisplay = findViewById(R.id.b_score);

        restoreState(savedInstanceState);

        findViewById(R.id.a_touchdown).setOnClickListener(this);
        findViewById(R.id.a_field_goal).setOnClickListener(this);
        findViewById(R.id.a_award_points).setOnClickListener(this);
        findViewById(R.id.a_extra_point).setOnClickListener(this);

        findViewById(R.id.b_touchdown).setOnClickListener(this);
        findViewById(R.id.b_field_goal).setOnClickListener(this);
        findViewById(R.id.b_award_points).setOnClickListener(this);
        findViewById(R.id.b_extra_point).setOnClickListener(this);

        findViewById(R.id.reset).setOnClickListener(this);
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Restore state "Teams scores"
            aTeamScore = savedInstanceState.getInt(TEAM_A_SCORE);
            bTeamScore = savedInstanceState.getInt(TEAM_B_SCORE);
            aTeamDisplay.setText(String.valueOf(aTeamScore));
            bTeamDisplay.setText(String.valueOf(bTeamScore));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a_touchdown: increaseAndDisplayTeamAScore(6); break;
            case R.id.a_field_goal: increaseAndDisplayTeamAScore(3); break;
            case R.id.a_award_points: increaseAndDisplayTeamAScore(2); break;
            case R.id.a_extra_point: increaseAndDisplayTeamAScore(1); break;
            case R.id.b_touchdown: increaseAndDisplayTeamBScore(6); break;
            case R.id.b_field_goal: increaseAndDisplayTeamBScore(3); break;
            case R.id.b_award_points: increaseAndDisplayTeamBScore(2); break;
            case R.id.b_extra_point: increaseAndDisplayTeamBScore(1); break;
            case R.id.reset: resetAndDisplayScores(); break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Saving state in case of configuration change or process death
        outState.putInt(TEAM_A_SCORE, aTeamScore);
        outState.putInt(TEAM_B_SCORE, bTeamScore);
    }

    private void resetAndDisplayScores() {
        if (aTeamScore != 0) aTeamDisplay.setText(String.valueOf(aTeamScore = 0));
        if (bTeamScore != 0) bTeamDisplay.setText(String.valueOf(bTeamScore = 0));
    }

    private void increaseAndDisplayTeamAScore(int amount) {
        aTeamDisplay.setText(String.valueOf(aTeamScore += amount));
    }

    private void increaseAndDisplayTeamBScore(int amount) {
        bTeamDisplay.setText(String.valueOf(bTeamScore += amount));
    }
}
