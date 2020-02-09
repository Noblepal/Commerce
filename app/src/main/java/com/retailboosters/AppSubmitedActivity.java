package com.retailboosters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class AppSubmitedActivity extends Activity implements View.OnClickListener {

    private TextView mBuyAgainTextView,mLoanStatusTextView,mReSchduleTextView,mTraHistoryTextView,mLoanHistoryTextView,mAccountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_app_submitted);


        mBuyAgainTextView = (TextView)findViewById(R.id.buyAgainTextView);
        mLoanStatusTextView = (TextView)findViewById(R.id.loanStatusTv);
        mReSchduleTextView = (TextView)findViewById(R.id.reSchduleTv);
        mTraHistoryTextView = (TextView)findViewById(R.id.TraHistoryTv);
        mLoanHistoryTextView = (TextView)findViewById(R.id.loanHistoryTv);
        mAccountTextView= (TextView)findViewById(R.id.accountTv);

        mBuyAgainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AppSubmitedActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mLoanStatusTextView.setOnClickListener(this);
        mReSchduleTextView.setOnClickListener(this);
        mTraHistoryTextView.setOnClickListener(this);
        mLoanHistoryTextView.setOnClickListener(this);
        mAccountTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = 0;
        switch (v.getId()){

            case R.id.loanStatusTv :
                id = 1;
                break;

            case R.id.reSchduleTv :
                id = 2;
                break;
            case R.id.TraHistoryTv :
                id = 3;
                break;
            case R.id.loanHistoryTv :
                id = 1;
                break;
            case R.id.accountTv :
                id = 4;
                break;

        }

        Intent intent = new Intent(AppSubmitedActivity.this,HomeActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
        finish();
    }
}
