package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputMoney;
    private EditText inputInfo;
    private Button BtnOK;
    private CheckBox CardBox;
    private CheckBox PhoneBox;
    private CheckBox CashBox;
    private String mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        inputMoney = findViewById(R.id.inputMoney);
        inputInfo = findViewById(R.id.info);
        BtnOK = findViewById(R.id.buttonOK);
        CardBox = findViewById(R.id.checkBoxCard);
        PhoneBox = findViewById(R.id.checkBoxPhone);
        CashBox = findViewById(R.id.checkBoxCash);
        CardBox.setOnCheckedChangeListener(checkedChangeListener);
        PhoneBox.setOnCheckedChangeListener(checkedChangeListener);
        CashBox.setOnCheckedChangeListener(checkedChangeListener);
        BtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.choose + inputMoney.getText().toString() + R.string.path + mInfo, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void resetCheckBoxes() {
        CardBox.setChecked(false);
        PhoneBox.setChecked(false);
        CashBox.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.checkBoxCard:
                        resetCheckBoxes();
                        CardBox.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        mInfo = getString(R.string.card) ;
                        break;
                    case R.id.checkBoxPhone:
                        resetCheckBoxes();
                        PhoneBox.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        mInfo = getString(R.string.phone);
                        break;
                    case R.id.checkBoxCash:
                        resetCheckBoxes();
                        CashBox.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mInfo = getString(R.string.cash);
                        break;
                    default:
                }
            }
        }

    };

}