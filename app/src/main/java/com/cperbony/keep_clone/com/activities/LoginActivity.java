package com.cperbony.keep_clone.com.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.cperbony.keep_clone.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @BindView(R.id.edtEmailLogin)
    EditText editEmailLogin;

    @BindView(R.id.edtPasswordLogin)
    EditText editPasswordLogin;

//    @BindView(R.id.action_go_to_register)
//    TextView actionGoToRegister;

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        this.firebaseAuth = FirebaseAuth.getInstance();

        awesomeValidation.addValidation(this, R.id.edtEmailLogin, Patterns.EMAIL_ADDRESS, R.string.error_valid_email);
        awesomeValidation.addValidation(this, R.id.edtPasswordLogin, ".{4, 16}", R.string.error_password);

    }

    @OnClick(R.id.action_go_to_register)
    public void onGoToRegister(View view) {
        Intent registerActivity = new Intent(getApplicationContext(), RegisterUserActivity.class);
        startActivity(registerActivity);
    }

}
