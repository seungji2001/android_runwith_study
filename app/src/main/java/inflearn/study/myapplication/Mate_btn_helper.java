package inflearn.study.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Mate_btn_helper extends Fragment {

    private View view;
    private Button button;

    public Mate_btn_helper(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mate_btn_helper,container,false);
        button = view.findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                FragmentTransaction tr = getActivity().getSupportFragmentManager().beginTransaction();
                MateActivity mateActivity = new MateActivity();
                tr.replace(R.id.frameLayout, mateActivity);
                tr.commit();
            }
        });

        return view;
    }
}