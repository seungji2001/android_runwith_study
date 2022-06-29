package inflearn.study.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //사용자가 입력한 id 와 pw 가져오기
                String id = etId.getText().toString();
                //String pw = etPw.getText().toString();

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    private void setLayout() {
        etId = (EditText) findViewById(R.id.etId);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}