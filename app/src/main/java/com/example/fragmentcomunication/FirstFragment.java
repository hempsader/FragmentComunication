package com.example.fragmentcomunication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {
    private TextView retrieveData;
    private EditText setMessage;
    private Button buttonSend;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.first_fragment,container,false);
        retrieveData = v.findViewById(R.id.textView_message_first);
        setMessage = v.findViewById(R.id.editText_first_fragment);
        buttonSend = v.findViewById(R.id.button);

        final SharedViewModel viewModelSend = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setMessage.getText().toString().trim().length() > 0)
                {
                    viewModelSend.setData(setMessage.getText().toString());
                }
            }
        });

        return v;
    }
}
