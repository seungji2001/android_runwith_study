package inflearn.study.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MateActivity extends Fragment {

    private View view;
    private TextView textView;
    private Button btnSendMsg;

    public MateActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mate,container,false);
        btnSendMsg = view.findViewById(R.id.btnSendMsg);
        textView = view.findViewById(R.id.id);
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        textView.setText(id);

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                FragmentTransaction tr = getActivity().getSupportFragmentManager().beginTransaction();
                JoinActivity joinActivity = new JoinActivity();
                tr.replace(R.id.frameLayout, joinActivity);
                tr.commit();
            }
        });

        return view;
    }
}