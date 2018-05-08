package com.example.kornchrismas.mvc;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imvAnimal;
    private RadioGroup radAnswer;
    private String strAnswer;
    private MyAlertDialog objMyAlert;
    private Question objQuestion;
    private MyAlertDialog objMyAlertDialog;
    private int intTime = 1;
    private MediaPlayer objMediaPlayerButton,objMediaPlayerRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialWidget();

        objQuestion = new Question();
        objQuestion.setOnQuestionChangeListener(new Question.OnQuestionChangeListener() {
            @Override
            public void onQuestionChangeListener(Question question) {
                switch (question.getIntQuestion()) {
                    case 1:
                        imvAnimal.setImageResource(R.drawable.cow);
                        break;
                    case 2:
                        imvAnimal.setImageResource(R.drawable.horse);
                        break;
                    case 3:
                        imvAnimal.setImageResource(R.drawable.pig);
                        break;
                    case 4:
                        imvAnimal.setImageResource(R.drawable.sheep);
                        break;
                    default:
                        break;
                }
            }
        });

        radAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
                    case R.id.radCow:
                        strAnswer = "Cow";
                        break;
                    case R.id.radHorse:
                        strAnswer = "Horse";
                        break;
                    case R.id.radPig:
                        strAnswer = "Pig";
                        break;
                    case R.id.radSheep:
                        strAnswer = "Sheep";
                        break;
                    default:
                        strAnswer = null;
                        break;
                }
                soundRadioButton();
                //ToaseMassage();
            }
        });
    }

    private void soundRadioButton() {
        objMediaPlayerRadioButton = MediaPlayer.create(getBaseContext(), R.raw.bee);
        objMediaPlayerRadioButton.start();
    }

    /*private void ToaseMassage() {
        Toast.makeText(MainActivity.this,"Are You Sure Your Answer is ") + strAnswer, 5000).show();
    }*/

    private void initialWidget() {
        imvAnimal = (ImageView) findViewById(R.id.imvAnimal);
        radAnswer = (RadioGroup) findViewById(R.id.radAnswer);
    }

    public void ClickAnswer(View view) {
        checkChooseAnswer();
    }

    private void checkChooseAnswer() {
        if (strAnswer != null) {
            Log.d("masterUNG", "strAnswer = " + strAnswer);
        }
        else {
            Log.d("masterUNG", "Please Choose Something");
            objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.NoChooseEveryThing(MainActivity.this);
        }
    }

    private void soundButton() {
        objMediaPlayerButton = MediaPlayer.create(getBaseContext(), R.raw.soundbt);
        objMediaPlayerButton.start();
    }

    private void sentValueToQuestion() {
        if (intTime == 4) {
            intTime = 0;
        }
        intTime++;

        objQuestion.setIntQuestion(intTime);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}
