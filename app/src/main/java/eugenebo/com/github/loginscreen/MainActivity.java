package eugenebo.com.github.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final String EMAIL_KEY = "email_key";
    private static final String PASS_KEY = "pass_key";

    private EditText emailTextView;
    private EditText passTextView;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextView = findViewById(R.id.text_email);
        passTextView = findViewById(R.id.text_pass);
        loginButton = findViewById(R.id.button_login);

        loginButton.setEnabled(false);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailTextView.getText().toString();
                String pass = passTextView.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra(EMAIL_KEY, email).putExtra(PASS_KEY, pass);

                startActivity(intent);
            }
        });

        emailTextView.addTextChangedListener(new AfterTextChangedListener() {
            @Override
            public void afterTextChanged(Editable s) {
                userInputValidation();
            }
        });

        passTextView.addTextChangedListener(new AfterTextChangedListener() {
            @Override
            public void afterTextChanged(Editable s) {
                userInputValidation();
            }
        });

    }

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    private boolean isValidPass(String pass) {
        return pass.length() >= 6;
    }

    private void userInputValidation() {
        String email = emailTextView.getText().toString();
        String pass = passTextView.getText().toString();
        loginButton.setEnabled(isValidEmail(email) && isValidPass(pass));

    }


}