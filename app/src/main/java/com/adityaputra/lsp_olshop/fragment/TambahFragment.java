package com.adityaputra.lsp_olshop.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiSevice;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Objects;

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
    private ImageView ivPhoto;
    private Button btnKirim;
    private Button btnCekUrl;

    public TambahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah, container, false);
        initView(view);

        btnKirim.setOnClickListener(v -> {
            ApiSevice apiSevice = ApiConfig.getApiService();
            apiSevice.tambahData(edtNamaBarang.getText().toString().trim(), edtImageBarang.getText().toString().trim(),
                    edtNDeskripsiBarang.getText().toString().trim(), edtHargaBarang.getText().toString().trim(),
                    edtStokBarang.getText().toString().trim())
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
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
                        }
                    });
        });

        /*TODO Add listener and function to check and show the result of image url*/
        btnCekUrl.setOnClickListener(v -> {
            //TODO Check url image is empty or not
            if (edtImageBarang.getText().toString().isEmpty()) {
                edtImageBarang.setError("Silahkan masukkan url gambar");
                edtImageBarang.requestFocus();
            } else {
                Glide.with(Objects.requireNonNull(getActivity()))
                        .load(edtImageBarang.getText().toString())
                        .addListener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                Toast.makeText(getActivity(), "Url Tidak Valid", Toast.LENGTH_SHORT).show();
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .into(ivPhoto);
            }
        });



        return view;
    }

    private void initView(View view) {
        edtNamaBarang = view.findViewById(R.id.edt_nama_barang);
        edtImageBarang = view.findViewById(R.id.edt_url_gambar);
        edtNDeskripsiBarang = view.findViewById(R.id.edt_deskripsi_barang);
        edtHargaBarang = view.findViewById(R.id.edt_harga_barang);
        edtStokBarang = view.findViewById(R.id.edt_stok_barang);
        ivPhoto = view.findViewById(R.id.iv_photo);
        btnKirim = view.findViewById(R.id.btn_kirim);
        btnCekUrl = view.findViewById(R.id.btn_cek_url);
    }
}
