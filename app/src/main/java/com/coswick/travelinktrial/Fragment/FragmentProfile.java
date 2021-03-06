package com.coswick.travelinktrial.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.coswick.travelinktrial.login.LogIn;
import com.coswick.travelinktrial.R;
import com.coswick.travelinktrial.login.SharedPrefManager;

public class FragmentProfile extends Fragment {
    View view;
    SharedPrefManager sp;
    TextView nama, email;
    Button btnlogout;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_profile,container,false);
        sp = new SharedPrefManager(getContext());
        nama = (TextView) view.findViewById(R.id.txt_nama);
        email = (TextView) view.findViewById(R.id.txt_email);
        btnlogout = (Button) view.findViewById(R.id.btn_Logout);

        nama.setText("" + sp.getKeyNama());
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LogIn.class);
                startActivity(intent);
                sp.saveSPBolean(SharedPrefManager.SP_SUDAH_LOGIN, false);

                //		preferenceHelper.setLogin(false);
            }
        });

        //Collapsing Toolbar
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar_profile);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

}

