package com.example.android.codecrusher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    CheckBox q1_a1; //question 1 answer 1
    CheckBox q1_a2;
    CheckBox q1_a3;

    RadioButton selectedButton;

    EditText q3_a;

    EditText q4_a;

    TextView scoreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1_a1 = (CheckBox) findViewById(R.id.q1_a1);
        q1_a2 = (CheckBox) findViewById(R.id.q1_a2);
        q1_a3 = (CheckBox) findViewById(R.id.q1_a3);

        selectedButton = (RadioButton) findViewById(R.id.q2_a1);

        q3_a = (EditText) findViewById(R.id.q3_a);

        q4_a = (EditText) findViewById(R.id.q4_a);
        scoreTxt = (TextView) findViewById(R.id.scoreTxt);
    }

    public void selectRadioButton(View v) {
        selectedButton = (RadioButton) findViewById(v.getId());
    }
    public void submitScore(View v){
        score = checkQuestion1() + checkQuestion2() + checkQuestion3() + checkQuestion4();
        displayScore();
    }

    private void displayScore () {
        scoreTxt.setText("Your Final Score is: "+score+"/4");
    }

    private int checkQuestion1() {
        if (q1_a1.isChecked() && q1_a2.isChecked() && !q1_a3.isChecked())
            return 1;
        return 0;
    }

    private int checkQuestion2() {
        if (selectedButton.getId() == R.id.q2_a2)
            return 1;
        return 0;
    }
    private int checkQuestion3() {
        if(q3_a.getText().toString().equals("TextView"))
            return 1;
        return 0;
    }

    private int checkQuestion4() {
        if (q4_a.getText().toString().replace(" ","").equals("intjaxTax;"))
            return 1;
        return 0;
    }
}
