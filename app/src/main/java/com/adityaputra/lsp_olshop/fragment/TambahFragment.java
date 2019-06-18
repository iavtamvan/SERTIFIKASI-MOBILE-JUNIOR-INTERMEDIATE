package com.adityaputra.lsp_olshop.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.MainActivity;
import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiSevice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahFragment extends Fragment {


    private EditText edtNamaBarang;
    private EditText edtImageBarang;
    private EditText edtNDeskripsiBarang;
    private EditText edtHargaBarang;
    private EditText edtStokBarang;
    private Button btnKirim;

    public TambahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah, container, false);
        initView(view);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiSevice apiSevice = ApiConfig.getApiService();
                apiSevice.tambahData(edtNamaBarang.getText().toString().trim(), edtImageBarang.getText().toString().trim(),
                        edtNDeskripsiBarang.getText().toString().trim(), edtHargaBarang.getText().toString().trim(),
                        edtStokBarang.getText().toString().trim())
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(getActivity(), "Sukses Tambah", Toast.LENGTH_SHORT).show();
                                    edtNamaBarang.setText("");
                                    edtImageBarang.setText("");
                                    edtNDeskripsiBarang.setText("");
                                    edtHargaBarang.setText("");
                                    edtStokBarang.setText("");
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        return view;
    }

    private void initView(View view) {
        edtNamaBarang = view.findViewById(R.id.edtNamaBarang);
        edtImageBarang = view.findViewById(R.id.edtImageBarang);
        edtNDeskripsiBarang = view.findViewById(R.id.edtNDeskripsiBarang);
        edtHargaBarang = view.findViewById(R.id.edtHargaBarang);
        edtStokBarang = view.findViewById(R.id.edtStokBarang);
        btnKirim = view.findViewById(R.id.btnKirim);
    }
}
