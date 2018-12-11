package com.example.hp.finalproject.UserLogIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.finalproject.MainActivity.MainActivity;
import com.example.hp.finalproject.R;


public class SignInFragment extends Fragment {
    private static final String TAG = "SignInFragment" ;

    EditText username_signin , password_signin ;
    CheckBox checkin ;
    Button signin_btn ;
    SharedPreferences preferences ;
    String PREFS_NAME = "signup.prefs" ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signin_fragment,container ,false);

        username_signin = view.findViewById(R.id.username_signin);
        password_signin = view.findViewById(R.id.password_signin);
        checkin = view.findViewById(R.id.checkin);
        signin_btn = view.findViewById(R.id.signin_btn);
        preferences = this.getActivity().getSharedPreferences(PREFS_NAME , Context.MODE_PRIVATE) ;



        return view ;
    }
}
