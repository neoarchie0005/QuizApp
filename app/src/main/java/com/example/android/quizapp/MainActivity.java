package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Variable names for checkBoxes, radioButtons and editText.
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    RadioButton rb5;
    RadioButton rb6;
    RadioButton rb7;
    RadioButton rb8;
    RadioButton rb9;
    RadioButton rb10;
    RadioButton rb11;
    RadioButton rb12;

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;

    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;

    LinearLayout ll3;

    EditText et1Answer;

    ExpandableListView expLV;

    Button submitButton;
    Button resetButton;

    int questionOne;
    int questionTwo;
    int questionThree;
    int questionFour;
    int questionFive;
    int questionSix;
    int totalMarks;
    String remark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is a call on the submit button.
        submitButton = findViewById(R.id.submit_button);

        //This is called to reset the quiz.
        resetButton = findViewById(R.id.reset_button);

        //This is a call to identify radioGroup rg1.
        rg1 = findViewById(R.id.rg1_radio_group);
        //This is a call to identify buttons within radioGroup one.
        rb1 = findViewById(R.id.radio_button_one);
        rb2 = findViewById(R.id.radio_button_two);
        rb3 = findViewById(R.id.radio_button_three);
        rb4 = findViewById(R.id.radio_button_four);

        //This is a call to identify radioGroup rg2.
        rg2 = findViewById(R.id.rg2_radio_group);
        //This is a call to identify buttons within radioGroup two.
        rb5 = findViewById(R.id.radio_button_five);
        rb6 = findViewById(R.id.radio_button_six);
        rb7 = findViewById(R.id.radio_button_seven);
        rb8 = findViewById(R.id.radio_button_eight);

        //This is a call to identify radioGroup rg3.
        rg3 = findViewById(R.id.rg3_radio_group);
        //This is a call to identify buttons within radioGroup three.
        rb9 = findViewById(R.id.radio_button_nine);
        rb10 = findViewById(R.id.radio_button_ten);
        rb11 = findViewById(R.id.radio_button_eleven);
        rb12 = findViewById(R.id.radio_button_twelve);

        //This is a call to identify various checkBoxes.
        cb1 = findViewById(R.id.checkbox_one);
        cb2 = findViewById(R.id.checkbox_two);
        cb3 = findViewById(R.id.checkbox_three);
        cb4 = findViewById(R.id.checkbox_four);

        //This is a call to identify linear_layout three.
        ll3 = findViewById(R.id.linear_layout_three_container);

        //This is a call to identify question_five_edit_text.
        et1Answer = findViewById(R.id.question_five_edit_text);

        // get the listview
        expLV = findViewById(R.id.exp_list_view_1);





        //Button click method to show the buttons that have been checked or clicked and submit.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This shows correct answer choice for question one and allocates a mark.
                questionOne = 0;
                if (rb3.isChecked()) {
                    questionOne = 4;
                } else {
                    questionOne = 0;
                }

                //This shows correct answer choice for question two and allocates a mark.
                questionTwo = 0;
                if (rb8.isChecked()) {
                    questionTwo = 4;
                } else {
                    questionTwo = 0;
                }

                //This shows correct answer choice for question three and allocates a mark.
                questionThree = 0;
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked()) {
                    questionThree = 4;
                }
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    questionThree = 0;
                }

                //This shows correct answer choice for question four and allocates a mark.
                questionFour = 0;
                if (rb11.isChecked()) {
                    questionFour = 4;
                } else {
                    questionFour = 0;
                }

                questionFive = 0;
                if (et1Answer.getText().toString().equalsIgnoreCase("Bethlehem")) {
                    questionFive = 4;
                } else {
                    questionFive = 0;
                }

                questionSix = 0;


                //This calculates the total marks scored.
                totalMarks = 0;
                if (rb3.isChecked()) {
                    totalMarks += 4;
                }
                if (rb8.isChecked()) {
                    totalMarks += 4;
                }
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()) {
                    totalMarks += 4;
                }
                if (rb11.isChecked()) {
                    totalMarks += 4;
                }
                if (et1Answer.getText().toString().equalsIgnoreCase("Bethlehem")) {
                    totalMarks += 4;
                }

                remark = "";
                if (rb3.isChecked() && rb8.isChecked() && cb1.isChecked() && cb2.isChecked() &&
                        cb3.isChecked() && rb11.isChecked() &&
                        et1Answer.getText().toString().equalsIgnoreCase("Bethlehem")) {
                    remark = ", Excellently done!";
                } else {
                    remark = ", You can do better.";
                }
                if (!rb3.isChecked() && !rb8.isChecked() && !cb1.isChecked() && !cb2.isChecked() &&
                        !cb3.isChecked() && !rb11.isChecked() &&
                        !et1Answer.getText().toString().equalsIgnoreCase("Bethlehem")) {
                    remark = "";
                }


                //This call triggers the reset button all the answers.
                resetButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rg1.clearCheck();
                        rg2.clearCheck();

                        cb1.setChecked(false);
                        cb2.setChecked(false);
                        cb3.setChecked(false);
                        cb4.setChecked(false);

                        rg3.clearCheck();

                        et1Answer.setText("");
                    }
                });

                //This Toast displays the right answers for the questions and the marks obtained.
                Toast.makeText(MainActivity.this, "RESULTS: 4 points for each " +
                        "correct answer." +
                        "\n\n Question1: " + questionOne +
                        "\n\n Question2: " + questionTwo +
                        "\n\n Question3: " + questionThree +
                        "\n\n Question4: " + questionFour +
                        "\n\n Question5: " + questionFive +
                        "\n\n Total Score: " + totalMarks + remark, Toast.LENGTH_LONG).show();

            }
        });


    }
}
