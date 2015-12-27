<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="Template tag" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Andia - Responsive Agency Template</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/animate.css">
    <link rel="stylesheet" href="/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="/resources/css/form-elements.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/media-queries.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="/resources//ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/resources/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/resources/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/resources/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top menu -->
<nav class="navbar" role="navigation">
    <div id="user" role="${user.role}"/>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
            </a>

        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="/"><i class="fa fa-home"></i><br>Home</a>
                </li>
                <li>
                    <a href="portfolio.html"><i class="fa fa-camera"></i><br>Portfolio</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-comments"></i><br>Blog</a>
                </li>
                <li>
                    <a href="services.html"><i class="fa fa-tasks"></i><br>Services</a>
                </li>
                <li>
                    <a href="about.html"><i class="fa fa-user"></i><br>About</a>
                </li>
                <li>
                    <a href="contact.html"><i class="fa fa-envelope"></i><br>Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<jsp:doBody/>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-sm-3 footer-box wow fadeInUp">
                <h4>About Us</h4>
                <div class="footer-box-text">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et.
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et.
                    </p>
                    <p><a href="about.html">Read more...</a></p>
                </div>
            </div>
            <div class="col-sm-3 footer-box wow fadeInDown">
                <h4>Email Updates</h4>
                <div class="footer-box-text footer-box-text-subscribe">
                    <p>Enter your email and you'll be one of the first to get new updates:</p>
                    <form role="form" action="/resources/subscribe.php" method="post">
                        <div class="form-group">
                            <label class="sr-only" for="subscribe-email">Email address</label>
                            <input type="text" name="email" placeholder="Email..." class="subscribe-email" id="subscribe-email">
                        </div>
                        <button type="submit" class="btn">Subscribe</button>
                    </form>
                    <p class="success-message"></p>
                    <p class="error-message"></p>
                </div>
            </div>
            <div class="col-sm-3 footer-box wow fadeInUp">
                <h4>Flickr Photos</h4>
                <div class="footer-box-text flickr-feed"></div>
            </div>
            <div class="col-sm-3 footer-box wow fadeInDown">
                <h4>Contact Us</h4>
                <div class="footer-box-text footer-box-text-contact">
                    <p><i class="fa fa-map-marker"></i> Address: Via Principe Amedeo 9, 10100, Torino, TO, Italy</p>
                    <p><i class="fa fa-phone"></i> Phone: 0039 333 12 68 347</p>
                    <p><i class="fa fa-user"></i> Skype: Andia_Agency</p>
                    <p><i class="fa fa-envelope"></i> Email: <a href="">contact@andia.co.uk</a></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 wow fadeIn">
                <div class="footer-border"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-7 footer-copyright wow fadeIn">
                <p>Copyright 2012 Andia - All rights reserved. Template by <a href="http://azmind.com">Azmind</a>.</p>
            </div>
            <div class="col-sm-5 footer-social wow fadeIn">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-dribbble"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-pinterest"></i></a>
            </div>
        </div>
    </div>
</footer>

<jsp:include page="/WEB-INF/tags/loginPop-up.jsp"/>


<!-- Javascript -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/bootstrap-hover-dropdown.min.js"></script>
<script src="/resources/js/jquery.backstretch.min.js"></script>
<!--<script src="/resources/js/wow.min.js"></script>  тут дергает нужно что-то придумать-->
<!--<script src="/resources/js/retina-1.1.0.min.js"></script>-->
<script src="/resources/js/jquery.magnific-popup.min.js"></script>
<script src="/resources/js/jflickrfeed.min.js"></script>
<script src="/resources/js/masonry.pkgd.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="/resources/js/jquery.ui.map.min.js"></script>
<script src="/resources/js/scripts.js"></script>

<script src="/resources/js/custom_js/util/user/user_util.js"></script>
<script src="/resources/js/custom_js/active/login_modal.js"></script>

</body>
</html>