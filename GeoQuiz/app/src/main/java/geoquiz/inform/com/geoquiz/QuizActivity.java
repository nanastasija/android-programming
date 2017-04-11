package geoquiz.inform.com.geoquiz;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends Activity {

    public static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    int poeni=0;

    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        //try {
            mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

            //Log.i("QuizAnastasija","oCreate"+", mcutrrent = "+mCurrentIndex);


            mTrueButton = (Button) findViewById(R.id.true_button);
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(true);
                    mFalseButton.setClickable(false);
                    mTrueButton.setClickable(false);
                }
            });
            mFalseButton = (Button) findViewById(R.id.false_button);
            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(false);
                    mTrueButton.setClickable(false);
                    mFalseButton.setClickable(false);

                }
            });
            mNextButton = (Button) findViewById(R.id.next_button);
            mNextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                    updateQuestion();
                    mFalseButton.setClickable(true);
                    mTrueButton.setClickable(true);
                }
            });

            updateQuestion();
        //}
            // catch (Exception e) {
          //  String msg = e.getMessage();
            //e.printStackTrace();
        // }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        //Log.i("QuizAnastasija","updateQuestion"+", mcutrrent = "+mCurrentIndex);
        mQuestionTextView.setText(question);

    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(mQuestionTextView.getText().toString().equals(getResources().getString(mQuestionBank[0].getTextResId())))
        {
            poeni=0;
        }

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            poeni++;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();

        String s1=mQuestionTextView.getText().toString();
        String s2= getResources().getString(mQuestionBank[5].getTextResId());
        if(mQuestionTextView.getText().toString().equals(getResources().getString(mQuestionBank[5].getTextResId())))
            Toast.makeText(QuizActivity.this, ""+poeni , Toast.LENGTH_SHORT).show();
    }
}
