package geoquiz.inform.com.geoquiz;

/**
 * Created by Anastasija on 04-Apr-17.
 */

public class Question {
    private boolean mAnswerTrue;
    private int mTextResId;
public Question( int textResId, boolean answerTrue)
{
    mAnswerTrue=answerTrue;
    mTextResId=textResId;
}
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
