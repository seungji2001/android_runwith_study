package inflearn.study.myapplication.Controller;

import android.util.Log;

import inflearn.study.myapplication.Model.User;
import inflearn.study.myapplication.RegisterActivity;
import inflearn.study.myapplication.View.ILoginView;

public class LoginController implements ILoginController{
    ILoginView loginView;

    public LoginController(ILoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public boolean OnLogin(String email, String password, String userName, int userAge) {
        User user = new User(email,password,userName,userAge);

        int logincode = user.isValid();

        if(logincode == 0){
            loginView.OnLoginError("Please Enter id");
            return false;
        }else if(logincode == 1){
            loginView.OnLoginError("Id should be more the 6 characters");
            return false;
        }else if (logincode == 2){
            loginView.OnLoginError("Please enter a password");
            return false;
        }else if (logincode == 3){
            loginView.OnLoginError("Password should be more the 6 characters");
            return false;
        }else if(logincode == 4) {
            loginView.OnLoginError("Please enter an user name");
            return false;
        }else if (logincode == 5) {
            loginView.OnLoginError("Please enter an user age");
            return false;
        }else{
                loginView.OnLoginSuccess("success");
                return true;
            }
        }
    }
