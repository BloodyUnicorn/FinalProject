package com.example.hp.finalproject.UserLogIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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

public class SignUpFragment extends Fragment {
    private static final String TAG = "SignUpFragment" ;

    EditText username_signup , email_signup , password_signup , password_signup_repeat ;
    CheckBox checkup ;
    Button signup_btn ;

    SharedPreferences preferences ;
    String PREFS_NAME = "signup.prefs" ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment,container ,false);

        username_signup = view.findViewById(R.id.username_signup);
        email_signup = view.findViewById(R.id.email_signup);
        password_signup = view.findViewById(R.id.password_signup);
        password_signup_repeat = view.findViewById(R.id.password_signup_repeat);
        checkup = view.findViewById(R.id.checkup);
        signup_btn = view.findViewById(R.id.signup_btn);



        preferences = this.getActivity().getSharedPreferences(PREFS_NAME , Context.MODE_PRIVATE) ;

        if (preferences.getString("logged" , "").toString().equals("logged"))
        {

            Intent i = new Intent(getActivity(), MainActivity.class);
            i.putExtra("Username", preferences.getString("user", "")).toString();
            i.putExtra("Email", preferences.getString("mail", "")).toString();
            i.putExtra("Password", preferences.getString("pass", "")).toString();
            i.putExtra("Check", true);
            startActivity(i);
        }




        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = password_signup.getText().toString() ;
                String password_repeat = password_signup_repeat.getText().toString() ;
                ///////
                if (!username_signup.getText().toString().equals("") && (!email_signup.getText().toString().equals("")&&(!password_signup.getText().toString().equals("")) ) ) {

                    if (password.equals(password_repeat)) {

                    if (checkup.isChecked())

                    {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("user", username_signup.getText().toString());
                        editor.putString("mail", email_signup.getText().toString());
                        editor.putString("pass", password_signup.getText().toString());
                        editor.putString("logged", "logged");
                        editor.apply();
                    }

                    Intent i = new Intent(getActivity(), MainActivity.class);
                    i.putExtra("Username", username_signup.getText().toString());
                    i.putExtra("Email", email_signup.getText().toString());
                    i.putExtra("Password", password_signup.getText().toString());
                    i.putExtra("Check", checkup.isChecked());
                    startActivity(i);
                }
                else {
                        Toast.makeText(getActivity() , "گذرواژه ها مطابقت ندارند", Toast.LENGTH_SHORT).show() ;

                    }
                }

                else
                {

                    Toast.makeText(getActivity() , "لطفا بخش های لازم را پر کنید", Toast.LENGTH_SHORT).show() ;
                }

                ////////
            }

        });

        return view ;
    }
}