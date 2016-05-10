package demo.somkiat.workshopespresso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    private TextView greetingView;
    private Button stateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        greetingView = (TextView) findViewById(R.id.greeting);
        stateButton = (Button) findViewById(R.id.state_button);
    }

    public void greet(View view) {
        greetingView.setText(R.string.hello);
        stateButton.setEnabled(true);
    }

    public void update(View view) {
        stateButton.setEnabled(!stateButton.isEnabled());
        greetingView.setText("");
    }
}
