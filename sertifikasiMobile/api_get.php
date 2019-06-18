<?php
/**
 * Created by PhpStorm.
 * User: User
 * Date: 6/18/2019
 * Time: 11:33 PM
 */

include 'config.php';

$sql = mysqli_query($db, "Select * from barang");
$arrayJson = array();

while($data = mysqli_fetch_assoc($sql)){
$arrayJson[] = $data;
}
$response = $arrayJson;
echo json_encode($response);

?>
