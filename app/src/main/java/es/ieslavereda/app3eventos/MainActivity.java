package es.ieslavereda.app3eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView testOnKey, testOnFocus2;
    EditText testOnFocus;
    Button testOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testOnKey = findViewById(R.id.testOnKey);
        testOnFocus = findViewById(R.id.testOnFocus);
        testOnFocus2 = findViewById(R.id.testOnFocus2);
        testOnClick = findViewById(R.id.testOnClick);

        testOnFocus.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_ENTER)
                    testOnKey.setText(testOnFocus.getText().toString());
                return false;
            }
        });

        testOnFocus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    testOnFocus2.setText("Edit text focus - SI");
                } else
                    testOnFocus2.setText("Edit text focus - NO");
            }
        });

        testOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Reseteando APP", Toast.LENGTH_LONG).show();

                testOnKey.setText("Escribe en la EditView1 y presiona ENTER");
                testOnFocus.setText("");
                testOnFocus2.setText("Edit text focus");
            }
        });
    }
}