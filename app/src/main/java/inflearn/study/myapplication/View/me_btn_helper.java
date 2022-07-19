package inflearn.study.myapplication.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import inflearn.study.myapplication.JoinActivity;
import inflearn.study.myapplication.R;

public class me_btn_helper extends Fragment {

    private View view;
    private Button testPopUp;

    public me_btn_helper(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_regist,container,false);
        testPopUp = view.findViewById(R.id.testPopUp);

        testPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JoinActivity joinActivity = new JoinActivity();
                joinActivity.show(getFragmentManager(),"myFragment");

            }
        });
        return view;
    }
}