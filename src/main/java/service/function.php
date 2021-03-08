
 <?php

 include("config.php");
    if(isset($_POST['submit']))
    {
    $teacherName=$_POST['teacherName'];
    $name=$_POST['name'];
    $classYear=$_POST['classYear'];
    $recommendation=$_POST['recommendation'];
    $why=$_POST['why'];

    $result=mysqli_query($mysqli, "INSERT into record values('', '$teacherName', '$name', '$classYear', '$recommendation', '$why')");

    if($result)//keeps you at home page
    {
    header("location:insert.php");
    }
    else
    {
    echo "Failed";
    }
    }
    ?>

    //link:https://www.youtube.com/watch?v=qJLQkge0Kcg