package com.adityaputra.lsp_olshop.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiService;

public class ProfilFragment extends Fragment {
    private Button btnLogout;

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        initView(view);

        btnLogout.setOnClickListener(view1 -> {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LSP", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("SHARED_LOGIN", "");
            editor.apply();
        });


        return view;
    }

    private void initView(View view) {
        btnLogout = view.findViewById(R.id.btn_logout);
    }
}