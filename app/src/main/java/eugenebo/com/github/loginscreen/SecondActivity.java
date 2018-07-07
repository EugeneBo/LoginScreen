package eugenebo.com.github.loginscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_second);

        TextView emailTextView = findViewById(R.id.email_textView);
        TextView passTextView = findViewById(R.id.pass_textView);

        Bundle bundle = getIntent().getExtras();

        String username = "Hello " + bundle.getString("email_key","username@wmail.com");
        String pass = "It's " + bundle.getString("pass_key","you_password_here");

        emailTextView.setText(username);
        passTextView.setText(pass);

    }


}