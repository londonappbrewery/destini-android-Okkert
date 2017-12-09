package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStateIndex;

    private int[] mStory = new int[]{
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };

    private int[] mTopIndex = new int[]{
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };

    private int[] mBottomIndex = new int[]{
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStateIndex = 0;


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Consequences
                if (mStateIndex == 0 ){
                    mStateIndex = 2;
                } else if (mStateIndex == 1) {
                    mStateIndex = 2;
                } else if (mStateIndex == 2 ) {
                    mStateIndex = 5;
                } else {
                    endStory();
                }

                updateViews();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Consequences
                if (mStateIndex == 0 ){
                    mStateIndex = 1;
                } else if (mStateIndex == 1) {
                    mStateIndex = 3;
                } else if (mStateIndex == 2 ) {
                    mStateIndex = 4;
                } else {
                    endStory();
                }

                updateViews();

            }
        });

    }

    public void updateViews() {
        if (mStateIndex < 3) {
            mStoryTextView.setText(mStory[mStateIndex]);
            mButtonTop.setText(mTopIndex[mStateIndex]);
            mButtonBottom.setText(mBottomIndex[mStateIndex]);
        } else {
            mStoryTextView.setText(mStory[mStateIndex]);
            mButtonTop.setText(R.string.End_Ans);
            mButtonBottom.setVisibility(View.GONE);
            Toast.makeText(this,"End.",Toast.LENGTH_LONG).show();
        }
    }

    public void endStory(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("You have reached The End. Thank you for playing!.");
        alert.setCancelable(false);
        alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alert.show();
    }

}
