package com.krivic.petagramt43;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FormActivity extends AppCompatActivity {


    TextInputEditText text_input_name;
    TextInputEditText text_input_email;
    TextInputEditText text_input_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void onClickSendButton(View view){

        text_input_name = (TextInputEditText) findViewById(R.id.text_input_name);
        String theName = text_input_name.getText().toString();

        text_input_email = (TextInputEditText) findViewById(R.id.text_input_email);
        String theEmail = text_input_email.getText().toString();

        text_input_message = (TextInputEditText) findViewById(R.id.text_input_message);
        String theMessage = text_input_message.getText().toString();




    }

}
