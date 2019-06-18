<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 5/5/2019
 * Time: 10:01 PM
 */
include 'config.php';


if ($_POST) {

    $nama_barang = $_POST['nama_barang'];
    $image_barang = $_POST['image_barang'];
    $deskripsi_barang = $_POST['deskripsi_barang'];
    $harga_barang = $_POST['harga_barang'];
    $stok_barang = $_POST['stok_barang'];


    $sql = "INSERT INTO barang
(nama_barang, image_barang, deskripsi_barang, harga_barang, stok_barang)
VALUE ('$nama_barang', '$image_barang', '$deskripsi_barang', '$harga_barang', '$stok_barang')";

    $query = mysqli_query($db, $sql);
    if ($query){
        $response["error"] = false;
        $response["error_msg"] = "Berhasil";
        echo json_encode($response);
    } else{
        $response["error"] = false;
        $response["error_msg"] = "Gagal Mengirim";
        echo json_encode($response);
    }

}
else{
    $response["error"] = true;
    $response["error_msg"] = "404";

    echo json_encode($response);
}
?>