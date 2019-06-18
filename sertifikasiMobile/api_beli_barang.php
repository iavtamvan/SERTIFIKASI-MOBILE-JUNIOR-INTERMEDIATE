<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 5/5/2019
 * Time: 10:01 PM
 */
include 'config.php';


if ($_POST) {


    $id_barang= $_POST['id_barang'];
    $bacaStok = mysqli_query($db, "Select * from barang WHERE id_barang='$id_barang'");
    $ambilStok = mysqli_fetch_assoc($bacaStok);

    $dapatkanStok = $ambilStok['stok_barang'];
    $stokKurang1 = $dapatkanStok - 1;
    $sql = mysqli_query($db, "UPDATE barang SET stok_barang='$stokKurang1' WHERE id_barang='$id_barang' ");
//    $hasilStok = mysqli_fetch_assoc($sql);

    $bacaStokKurang1 = mysqli_query($db, "Select * from barang WHERE id_barang='$id_barang'");
    $ambilStokKurang1 = mysqli_fetch_assoc($bacaStokKurang1);

    if ($sql){
        $response["error"] = false;
        $response["error_msg"] = "Berhasil";
        $response["error_msg_stok"] = $ambilStokKurang1['stok_barang'];
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
