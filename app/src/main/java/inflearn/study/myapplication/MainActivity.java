package inflearn.study.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = etId.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){//회원등록에 성공한 경우
                                String userID = jsonObject.getString("userID");
                                Toast.makeText(getApplicationContext(),"로그인에 성공했습니다",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                                intent.putExtra("id",userID);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"로그인에 실패했습니다",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setLayout() {
        etId = (EditText) findViewById(R.id.etId);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }
}