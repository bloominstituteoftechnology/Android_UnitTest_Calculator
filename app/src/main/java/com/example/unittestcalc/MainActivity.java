package com.example.unittestcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	Calculator calculator;
	TextView tvInput;
	TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		calculator = new Calculator();
		tvInput = findViewById(R.id.tv_input);
		tvResult = findViewById(R.id.tv_result);
		
		final Button button0 = findViewById(R.id.btn_0);
		button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button0.getText().toString());
			}
		});
		
		final Button button1 = findViewById(R.id.btn_1);
		button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button1.getText().toString());
			}
		});
		
		final Button button2 = findViewById(R.id.btn_2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button2.getText().toString());
			}
		});
		
		final Button button3 = findViewById(R.id.btn_3);
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button3.getText().toString());
			}
		});
		
		final Button button4 = findViewById(R.id.btn_4);
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button4.getText().toString());
			}
		});
		
		final Button button5 = findViewById(R.id.btn_5);
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button5.getText().toString());
			}
		});
		
		final Button button6 = findViewById(R.id.btn_6);
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button6.getText().toString());
			}
		});
		
		final Button button7 = findViewById(R.id.btn_7);
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button7.getText().toString());
			}
		});
		
		final Button button8 = findViewById(R.id.btn_8);
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button8.getText().toString());
			}
		});
		
		final Button button9 = findViewById(R.id.btn_9);
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(button9.getText().toString());
			}
		});
		
		final Button buttonPlus = findViewById(R.id.btn_plus);
		buttonPlus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonPlus.getText().toString());
			}
		});
		final Button buttonMinus = findViewById(R.id.btn_minus);
		buttonMinus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonMinus.getText().toString());
			}
		});
		final Button buttonDivide = findViewById(R.id.btn_divide);
		buttonDivide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonDivide.getText().toString());
			}
		});
		final Button buttonTimes = findViewById(R.id.btn_times);
		buttonTimes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonTimes.getText().toString());
			}
		});
		final Button buttonSqrt = findViewById(R.id.btn_sqrt);
		buttonSqrt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonSqrt.getText().toString());
			}
		});
		final Button buttonPower = findViewById(R.id.btn_power);
		buttonPower.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonPower.getText().toString());
			}
		});
		
		final Button buttonEquals = findViewById(R.id.btn_equal);
		buttonEquals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonEquals.getText().toString());
			}
		});
		
		final Button buttonDelete = findViewById(R.id.btn_del);
		buttonDelete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendInput(buttonDelete.getText().toString().toLowerCase());
			}
		});
	}
	
	
	public void sendInput(String input){
	calculator.addSymbol(input);
	tvInput.setText(calculator.getDisplayText());
	if(input.equals("=")){
		tvResult.setText(calculator.getResult());
	}
	}
}
