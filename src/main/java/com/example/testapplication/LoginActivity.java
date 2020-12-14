package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView courseText;
    EditText user,pass;
    Button login;
    ArrayList<Student> studentList = new ArrayList<Student>();
    public static String studentName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fillData();
        //initialize components
        user=findViewById(R.id.userName);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.loginBtn);

        login.setOnClickListener(this);
    }
    public void fillData(){
        studentList.add(new Student(123456,"Sruthi Sudar","sruthisudar","123456"));
    }
    @Override
    public void onClick(View view) {
        String verify = verifyLogin(user.getText().toString(),pass.getText().toString());
        if (verify.isEmpty())
            Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
        else
        {
            studentName=verify;
            //navigate to the MainActivity
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }

    }

    private String verifyLogin(String username, String password) {
        for(int i=0;i<studentList.size();i++)
            if(username.equals(studentList.get(i).getUserName()))
                if(password.equals(studentList.get(i).getPassword()))
                    return studentList.get(i).getName();
        return "";
    }

}
