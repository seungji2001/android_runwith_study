package inflearn.study.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuActivity extends Fragment {

    private TextView textView;
    private View view;

    public MenuActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_menu,container,false);
        textView = view.findViewById(R.id.id);

        Bundle bundle = getArguments();

        String id = bundle.getString("id");
        textView.setText(id);

        return view;
    }
}