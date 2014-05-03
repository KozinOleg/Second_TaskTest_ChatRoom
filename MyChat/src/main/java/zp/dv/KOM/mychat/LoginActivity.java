package zp.dv.KOM.mychat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity implements OnClickListener {
    private final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final String PASSWORD_PATTERN = "([A-Za-z0-9-\\-\\_]{6,}$)";

    public static String loginName = "userDefault";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.buttonLogin);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etLogin = (EditText) findViewById(R.id.etLogin);
        EditText etPass = (EditText) findViewById(R.id.etPassword);

//        if (!validator(EMAIL_PATTERN, etLogin.getText().toString())) {
//            Toast.makeText(LoginActivity.this,
//                    "Login bad",
//                    Toast.LENGTH_LONG).show();
//        } else if (!validator(PASSWORD_PATTERN, etPass.getText().toString())) {
//            Toast.makeText(LoginActivity.this,
//                    "Password Bad",
//                    Toast.LENGTH_LONG).show();
//        } else {
//            loginName = etLogin.getText().toString();
//            startActivity(new Intent(LoginActivity.this,
//                    ChatRoom.class));
//        }
///////////////////////////////////////////////////////////
        loginName = etLogin.getText().toString();
        startActivity(new Intent(LoginActivity.this,
                ChatRoom.class));
//////////////////////////////////////////////////////////
    }

    private boolean validator(String patternStr, String str) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}


