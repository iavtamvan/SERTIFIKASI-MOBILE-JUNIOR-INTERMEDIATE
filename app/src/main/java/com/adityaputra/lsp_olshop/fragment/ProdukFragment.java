package com.adityaputra.lsp_olshop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.adapter.MenampilkanProdukAdapter;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiSevice;
import com.adityaputra.lsp_olshop.model.ProdukModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdukFragment extends Fragment {


    private RecyclerView RVItem;
    private MenampilkanProdukAdapter menampilkanProdukAdapter;
    private ArrayList<ProdukModel>  produkModel;

    public ProdukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produk, container, false);
        initView(view);
        produkModel = new ArrayList<>();

        ApiSevice apiSevice = ApiConfig.getApiService();
        apiSevice.ambilData().enqueue(new Callback<ArrayList<ProdukModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProdukModel>> call, Response<ArrayList<ProdukModel>> response) {
                if (response.isSuccessful()) {
                    produkModel  = response.body();
                    menampilkanProdukAdapter = new MenampilkanProdukAdapter(getActivity(), produkModel);
                    RVItem.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    RVItem.setAdapter(menampilkanProdukAdapter);
                    menampilkanProdukAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ProdukModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    private void initView(View view) {
        RVItem = view.findViewById(R.id.RVItem);
    }
}
