package inflearn.study.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MeActivity extends Fragment {

    private TextView textView;
    private View view;
    private Button button_helper;
    public MeActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_me,container,false);
        textView = view.findViewById(R.id.id);
        button_helper = view.findViewById(R.id.button_helper);

        Bundle bundle = getArguments();

        String id = bundle.getString("id");
        textView.setText(id);

        return view;
    }
}