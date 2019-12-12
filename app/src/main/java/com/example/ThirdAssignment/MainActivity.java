package com.example.ThirdAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wbv.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText UserName;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        String username = UserName.getText().toString();
        String password =Password.getText().toString();
        if(username.equals("softwarica") && password.equals("coventry"))
        {
            Intent i = new Intent(this, home.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"invalid login",Toast.LENGTH_SHORT).show();
        }
    }
}
