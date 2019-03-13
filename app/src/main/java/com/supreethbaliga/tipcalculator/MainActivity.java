package com.supreethbaliga.tipcalculator;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.AmtTextView)
    EditText AmtTextView;
    @BindView(R.id.tipPercentTextView)
    TextView tipPercentTextView;
    @BindView(R.id.tipAmtTextView)
    TextView tipAmtTextView;
    @BindView(R.id.billTotalTextView)
    TextView billTotalTextView;

    float percentage = 0;
    float tipTotalAmount = 0;
    float billAmtTotal = 0;
    float initialBillAmt = 0;

    float DefaultTipPercent = 0;
    float TipPercent1 = 3;
    float TipPercent2 = 5;
    float TipPercent3 = 7;
    float TipPercent4 = 10;
    float TipPercent5 = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTipValues();
    }

    private void setTipValues() {
        tipPercentTextView.setText(getString(R.string.tipPercent, percentage));
        tipAmtTextView.setText(getString(R.string.tipAmt, tipTotalAmount));
        billTotalTextView.setText(getString(R.string.rupees, billAmtTotal));
    }


    private void calculateFinalBill() {
        if (AmtTextView.getText().toString().equals("") || AmtTextView.getText().toString().equals(".")) {
            initialBillAmt = 0;
        } else {
            initialBillAmt = Float.valueOf(AmtTextView.getText().toString());
        }
        tipTotalAmount = (initialBillAmt * percentage) / 100;
        billAmtTotal = initialBillAmt + tipTotalAmount;
    }

    @OnClick({R.id.serviceRatingIcon1, R.id.serviceRatingIcon2, R.id.serviceRatingIcon3, R.id.serviceRatingIcon5, R.id.serviceRatingIcon4, R.id.serviceRatingIcon6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.serviceRatingIcon1:
                percentage = DefaultTipPercent;
                break;
            case R.id.serviceRatingIcon2:
                percentage = TipPercent1;
                break;
            case R.id.serviceRatingIcon3:
                percentage = TipPercent2;
                break;
            case R.id.serviceRatingIcon4:
                percentage = TipPercent3;
                break;
            case R.id.serviceRatingIcon5:
                percentage = TipPercent4;
                break;
            case R.id.serviceRatingIcon6:
                percentage = TipPercent5;
                break;
        }
        calculateFinalBill();
        setTipValues();
    }

    @OnTextChanged(R.id.AmtTextView)
    public void onTextChanged() {
        calculateFinalBill();
        setTipValues();
    }
}
