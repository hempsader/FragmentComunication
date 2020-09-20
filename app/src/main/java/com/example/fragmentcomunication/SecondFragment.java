package com.example.fragmentcomunication;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class SecondFragment extends Fragment {
    private TextView retrieveData;
    private EditText setMessage;
    private Button buttonSend;
    private View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.second_fragment,container,false);
        retrieveData = v.findViewById(R.id.textView_recieve);
        setMessage = v.findViewById(R.id.editText_second_fragment);
        buttonSend = v.findViewById(R.id.button_send_second);

        final SharedViewModel viewModelRecieve = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModelRecieve.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                retrieveData.setText(s);
            }
        });
        return v;
    }




}
