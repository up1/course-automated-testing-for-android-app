package demo.somkiat.workshopespresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hello(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        startActivity(intent);
    }

    public void toolbarTitle(View view) {
        Intent intent = new Intent(this, ToolbarActivity.class);
        startActivity(intent);
    }

    public void listview(View view) {
        Intent intent = new Intent(this, NumberListviewActivity.class);
        startActivity(intent);
    }


    public void rotateScreen(View view) {
        Intent intent = new Intent(this, RotateScreenActivity.class);
        startActivity(intent);
    }
}
