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
import com.adityaputra.lsp_olshop.adapter.HapusShowProdukAdapter;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiService;
import com.adityaputra.lsp_olshop.model.ProdukModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HapusFragment extends Fragment {


    private RecyclerView RVItem;
    private HapusShowProdukAdapter hapusShowProdukAdapter;
    private ArrayList<ProdukModel> produkModel;

    public HapusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hapus, container, false);
        initView(view);

        produkModel = new ArrayList<>();

        ApiService apiService = ApiConfig.getApiService();
        apiService.ambilData().enqueue(new Callback<ArrayList<ProdukModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProdukModel>> call, Response<ArrayList<ProdukModel>> response) {
                if (response.isSuccessful()) {
                    produkModel.clear();
                    produkModel = response.body();
                    hapusShowProdukAdapter = new HapusShowProdukAdapter(getActivity(), produkModel);
                    RVItem.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    RVItem.setAdapter(hapusShowProdukAdapter);
                    hapusShowProdukAdapter.notifyDataSetChanged();
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
