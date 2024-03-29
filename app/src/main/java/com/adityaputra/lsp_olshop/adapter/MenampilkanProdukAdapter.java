package com.adityaputra.lsp_olshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adityaputra.lsp_olshop.activity.DetailActivity;
import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.model.ProdukModel;
import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MenampilkanProdukAdapter extends RecyclerView.Adapter<MenampilkanProdukAdapter.ProdukViewHolder> {

    private Context context;
    private ArrayList<ProdukModel> list = new ArrayList<>();

    public MenampilkanProdukAdapter(Context context, ArrayList<ProdukModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MenampilkanProdukAdapter.ProdukViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ProdukViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MenampilkanProdukAdapter.ProdukViewHolder produkViewHolder, int i) {
        produkViewHolder.nama.setText(list.get(i).getNamaBarang());

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        produkViewHolder.harga.setText(formatRupiah.format(list.get(i).getHargaBarang()));
        Glide.with(context).load(list.get(i).getImageBarang()).into(produkViewHolder.gambar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProdukViewHolder extends RecyclerView.ViewHolder {
        TextView nama, harga;
        ImageView gambar;

        public ProdukViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.TVNama);
            harga = itemView.findViewById(R.id.TVHarga);
            gambar = itemView.findViewById(R.id.IVProduk);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ID_BARANG", list.get(getAdapterPosition()).getIdBarang());
                intent.putExtra("NAMA_BARANG", list.get(getAdapterPosition()).getNamaBarang());
                intent.putExtra("IMAGE_BARANG", list.get(getAdapterPosition()).getImageBarang());
                intent.putExtra("DESKRIPSI_BARANG", list.get(getAdapterPosition()).getDeskripsiBarang());
                intent.putExtra("HARGA_BARANG", String.valueOf(list.get(getAdapterPosition()).getHargaBarang()));
                intent.putExtra("STOK_BARANG", list.get(getAdapterPosition()).getStokBarang());
                intent.putExtra("ALAMAT", list.get(getAdapterPosition()).getAlamat());
                context.startActivity(intent);
            });
        }
    }
}