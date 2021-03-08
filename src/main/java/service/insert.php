<?php
include("config.php");
$result=mysqli_query($mysqli, "SELECT* from record ORDER by ClassYear DESC");
?>

<!DOCTYPE html>
<html>
<head>
        <title></title>
</head>
<body>
    <form action ="function.php" method="POST">
        Teacher Name<input type = "text" name = "teacherName"><br>
        Name<input type = "text" name = "name"><br>
        ClassYear<input type = "text" name = "classYear"><br>
        Recommendation<input type = "text" name = "recommendation"><br>
        Why<input type = "text" name = "why"><br>
        <input type = "submit" name = "submit">
    </form>
    <table border = "2">//gives actual table
        <tr>//gives heading
<th>Teacher Name</th>
<th>Name</th>
<th>ClassYear</th>
<th>Recommendation</th>
<th>Why</th>
        </tr>
<?php
while($res=mysqli_fetch_array($result))//shows table
{
echo '<tr>';
echo '<td>'.$res['teacherName'].'</td>';
echo '<td>'.$res['name'].'</td>';
echo '<td>'.$res['classYear'].'</td>';
echo '<td>'.$res['recommendation'].'</td>';
echo '<td>'.$res['why'].'</td>';
echo '</tr>';
}
?>
    </table>
</body>
</html>