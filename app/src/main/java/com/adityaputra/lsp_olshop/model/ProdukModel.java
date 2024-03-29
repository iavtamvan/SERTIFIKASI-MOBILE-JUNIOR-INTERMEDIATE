package com.adityaputra.lsp_olshop.model;

import com.google.gson.annotations.SerializedName;

public class ProdukModel {

    @SerializedName("id_barang")
    private String idBarang;

    @SerializedName("nama_barang")
    private String namaBarang;

    @SerializedName("harga_barang")
    private double hargaBarang;

    @SerializedName("deskripsi_barang")
    private String deskripsiBarang;

    @SerializedName("image_barang")
    private String imageBarang;

    @SerializedName("stok_barang")
    private String stokBarang;

    @SerializedName("alamat")
    private String alamat;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setHargaBarang(double        hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void setDeskripsiBarang(String deskripsiBarang) {
        this.deskripsiBarang = deskripsiBarang;
    }

    public String getDeskripsiBarang() {
        return deskripsiBarang;
    }

    public void setImageBarang(String imageBarang) {
        this.imageBarang = imageBarang;
    }

    public String getImageBarang() {
        return imageBarang;
    }

    public void setStokBarang(String stokBarang) {
        this.stokBarang = stokBarang;
    }

    public String getStokBarang() {
        return stokBarang;
    }
}