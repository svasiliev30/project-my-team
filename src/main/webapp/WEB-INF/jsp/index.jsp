<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">

<html lang="en">
  <head>
    <meta charset="UTF-8">
       <title>PhotoShow</title>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
   </head>
   <body>
       <header>
           <nav class="navbar navbar-expand-md navbar-light bg-light">
               <a class="navbar-brand" href="/login">Вход</a>
           </nav>
       </header>
       <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
 			<ol class="carousel-indicators">

                <li data-target="#carouselExampleIndicators" data-slide-to=0 class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to=1></li>
                <li data-target="#carouselExampleIndicators" data-slide-to=2></li>
                <li data-target="#carouselExampleIndicators" data-slide-to=3></li>
                <li data-target="#carouselExampleIndicators" data-slide-to=4></li>
           </ol>

           <div class="carousel-inner bg-dark" style="height:850px">

    <div class="carousel-item text-center h-100 active" style="background:url('https://toptenzilla.com/wp-content/uploads/2018/09/get-cash-fast.jpeg') center center; background-size:auto; background-repeat: no-repeat;"></div>
    <div class="carousel-item text-center h-100" style="background:url('https://mykaleidoscope.ru/uploads/posts/2021-11/1636798964_14-mykaleidoscope-ru-p-obraz-budushchego-devushka-krasivo-foto-15.jpg') center center; background-size:auto; background-repeat: no-repeat;"></div>
    <div class="carousel-item text-center h-100" style="background:url('https://s1.1zoom.ru/b5050/7/Money_Coins_Roubles_buy_463894_1920x1200.jpg') center center; background-size:auto; background-repeat: no-repeat;"></div>
    <div class="carousel-item text-center h-100" style="background:url('https://www.anypics.ru/download.php?file=201211/2560x1600/anypics.ru-26216.jpg') center center; background-size:auto; background-repeat: no-repeat;"></div>
    <div class="carousel-item text-center h-100" style="background:url('https://images.wallpaperscraft.ru/image/single/nyu-york_noch_neboskreby_vid_sverhu_svet_63673_1920x1080.jpg') center center; background-size:auto; background-repeat: no-repeat;"></div>


           </div>

           <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
               <span class="carousel-control-prev-icon" aria-hidden="true"></span>
               <span class="sr-only">Previous</span>
           </a>
           <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
               <span class="carousel-control-next-icon" aria-hidden="true"></span>
               <span class="sr-only">Next</span>
           </a>

       </div>
       <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
   </body>
</html>
