package com.supreethbaliga.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.AmtTextView)
    EditText AmtTextView;
    @BindView(R.id.serviceRatingIcon1)
    ImageView serviceRatingIcon1;
    @BindView(R.id.serviceRatingIcon2)
    ImageView serviceRatingIcon2;
    @BindView(R.id.serviceRatingIcon3)
    ImageView serviceRatingIcon3;
    @BindView(R.id.serviceRatingIcon5)
    ImageView serviceRatingIcon5;
    @BindView(R.id.serviceRatingIcon4)
    ImageView serviceRatingIcon4;
    @BindView(R.id.serviceRatingIcon6)
    ImageView serviceRatingIcon6;
    @BindView(R.id.tipPercentTextView)
    TextView tipPercentTextView;
    @BindView(R.id.tipAmtTextView)
    TextView tipAmtTextView;
    @BindView(R.id.billTotalTextView)
    TextView billTotalTextView;

    float percentage = 0;
    float tipTotalAmount = 0;
    float billAmtTotal = 0;
    float initialBillAmt=0;

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
        tipPercentTextView.setText(getString(R.string.tipPercent) + percentage+getString(R.string.PercentSymbol));
        tipAmtTextView.setText(getString(R.string.tipAmt) + tipTotalAmount);
        billTotalTextView.setText(getString(R.string.rupees) + billAmtTotal);
    }

    @OnClick({R.id.serviceRatingIcon1, R.id.serviceRatingIcon2, R.id.serviceRatingIcon3, R.id.serviceRatingIcon5, R.id.serviceRatingIcon4, R.id.serviceRatingIcon6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.serviceRatingIcon1:
                percentage = DefaultTipPercent;
                serviceRatingIcon1.setBackgroundColor(getResources().getColor(R.color.iconOnClick));
                break;
            case R.id.serviceRatingIcon2:
                percentage = TipPercent1;
                serviceRatingIcon2.setBackgroundColor(getResources().getColor(R.color.iconOnClick));
                break;
            case R.id.serviceRatingIcon3:
                percentage = TipPercent2;
                serviceRatingIcon3.setBackgroundColor(getResources().getColor(R.color.iconOnClick));
                break;
            case R.id.serviceRatingIcon4:
                percentage = TipPercent3;
                serviceRatingIcon4.setBackgroundColor(getResources().getColor(R.color.iconOnClick));
                break;
            case R.id.serviceRatingIcon5:
                percentage = TipPercent4;
                serviceRatingIcon5.setBackgroundColor(getResources().getColor(R.color.iconOnClick));
                break;
            case R.id.serviceRatingIcon6:
                percentage = TipPercent5;
                serviceRatingIcon6.setBackgroundColor(getResources().getColor(R.color.iconOnClick));
                break;
        }
        calculateFinalBill();
        setTipValues();
        setOriginalButtonColor();
    }

    @OnTextChanged(R.id.AmtTextView)
    public void onTextChanged() {
        calculateFinalBill();
        setTipValues();
    }

    private void calculateFinalBill()
    {
        if(AmtTextView.getText().toString().equals("") || AmtTextView.getText().toString().equals("."))
        {
            initialBillAmt=0;
        }
        else {
            initialBillAmt=Float.valueOf(AmtTextView.getText().toString());
        }
        tipTotalAmount=(initialBillAmt*percentage)/100;
        billAmtTotal=initialBillAmt+tipTotalAmount;
    }

    private void setOriginalButtonColor()
    {
        serviceRatingIcon1.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        serviceRatingIcon2.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        serviceRatingIcon3.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        serviceRatingIcon4.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        serviceRatingIcon5.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        serviceRatingIcon6.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
    }
}
