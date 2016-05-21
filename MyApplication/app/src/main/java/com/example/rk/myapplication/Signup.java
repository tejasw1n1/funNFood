package com.example.rk.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    Button btnSignIn;

    EditText UserName, UserEmail, UserMobileNo, UserAddress, UserPwd, UserConPwd;
    Context context = this;
    UserDBHelper userDBHelper;
    SQLiteDatabase sqLiteDatabase;

    public void ADDInformation(View view){
        UserName = (EditText)findViewById(R.id.editUsernme);
        String name = UserName.getText().toString();
        if(name.equals("")){
            Toast.makeText(Signup.this, "Please fill the field...", Toast.LENGTH_SHORT).show();
        }

        UserEmail = (EditText)findViewById(R.id.editEmail);
        String email = UserEmail.getText().toString();

        UserMobileNo = (EditText)findViewById(R.id.editConNum);
        String mob = UserMobileNo.getText().toString();

        UserAddress = (EditText)findViewById(R.id.etAddress);
        String add = UserAddress.getText().toString();

        UserPwd = (EditText)findViewById(R.id.etpwd);
        String pwd = UserPwd.getText().toString();

        UserConPwd = (EditText)findViewById(R.id.etConfirmPwd);
        String conpwd = UserConPwd.getText().toString();

        if(!pwd.equals(conpwd)){
            Toast.makeText(Signup.this, "Password don't match...", Toast.LENGTH_SHORT).show();
        }

        else{
            userDBHelper = new UserDBHelper(context);
            sqLiteDatabase = userDBHelper.getWritableDatabase();
            userDBHelper.AddInformation(name, email, mob, add, pwd, conpwd, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
            userDBHelper.close();

            startActivity(new Intent(Signup.this, LoginActivity.class));
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignIn = (Button) findViewById(R.id.buttonSignIn);
    }
}
