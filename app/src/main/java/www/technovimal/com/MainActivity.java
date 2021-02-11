package www.technovimal.com;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.tos.retrofitokhttpcaching.R;

import www.technovimal.com.activity.SecondActivity;
/**
 * Created by vimalcvs on 10/01/2021.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton buttonPanel1 = findViewById(R.id.buttonPanel1);
        buttonPanel1.setOnClickListener(v -> {
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("ApiId", "list?page=2&limit=10");
            startActivity(i);
        });

        AppCompatButton buttonPanel2 = findViewById(R.id.buttonPanel2);
        buttonPanel2.setOnClickListener(v -> {
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("ApiId", "list?page=2&limit=50");
            startActivity(i);
        });

        AppCompatButton buttonPanel3 = findViewById(R.id.buttonPanel3);
        buttonPanel3.setOnClickListener(v -> {
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("ApiId", "list?page=2&limit=100");
            startActivity(i);
        });

    }
}