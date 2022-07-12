package inflearn.study.myapplication.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser{

    private String id;
    private String password;
    private String userName;
    private int userAge;

    public User(String id, String password, String userName, int userAge){
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.userAge = userAge;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public Integer getUserAge() {
        return userAge;
    }

    @Override
    public int isValid() {
        if(TextUtils.isEmpty((getId()))){
            return 0;
        }else if(getId().length()<=6) {
            return 1;
        }else if(TextUtils.isEmpty((getPassword()))){
            return 2;
        }else if(getPassword().length()<=6){
            return 3;
        }else if(getUserName().isEmpty()){
            return 4;
        }else if(getUserName().isEmpty()){
            return 5;
        }else{
            return -1;
        }
    }
}
