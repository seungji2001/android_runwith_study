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

import inflearn.study.myapplication.Controller.ILoginController;
import inflearn.study.myapplication.Controller.LoginController;
import inflearn.study.myapplication.View.ILoginView;

public class RegisterActivity extends AppCompatActivity implements ILoginView {

    private EditText et_id,et_pass,et_name,et_age;
    private Button btn_register;


    ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 시작시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginController = new LoginController(this);

        //아이디값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        //회원가입 버튼 클릭시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Edit text에 현재 입력 되어있는 값을 get가져온다
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());

                boolean check = loginController.OnLogin(userID.trim(),userPass.trim(),userName.trim(),userAge);

                Response.Listener<String> responseListener = response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if(success && check){//회원등록에 성공한 경우
                            Toast.makeText(getApplicationContext(),"회원 등록에 성공했습니다",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"회원 등록에 실패했습니다",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                };

                //서버로 volley 이용하여 요청을 함.
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

    }

    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}