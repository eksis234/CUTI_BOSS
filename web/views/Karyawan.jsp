<%-- 
    Document   : LihatKaryawan
    Created on : Oct 16, 2018, 5:06:49 PM
    Author     : Lenovo
--%>

<%@page import="models.*"%>
<%@page import="java.util.List"%>
<%@page import="controller.GeneralController"%>
<%@page import="controller.InterfaceController"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<!doctype html>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cuti Boss</title>
        <meta name="description" content="Sufee Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="apple-icon.png">
        <link rel="shortcut icon" href="metro.ico">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
        <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
        <link rel="stylesheet" href="assets/scss/style.css">

        <!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'> -->

        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

    </head>
    <body>
        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand hidden" href="index.jsp"><img src="images/metrodata.png" alt="Logo"></a>
                    <br><a class="navbar-brand" href="index.jsp"><img src="images/mii.jpg" alt="Logo"></a> 
                </div>

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="index.jsp"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                        </li>
                        <h3 class="menu-title">UI elements</h3><!-- /.menu-title -->
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Components</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-puzzle-piece"></i><a href="ui-buttons.html">Buttons</a></li>
                                <li><i class="fa fa-id-badge"></i><a href="ui-badges.html">Badges</a></li>
                                <li><i class="fa fa-bars"></i><a href="ui-tabs.html">Tabs</a></li>
                                <li><i class="fa fa-share-square-o"></i><a href="ui-social-buttons.html">Social Buttons</a></li>
                                <li><i class="fa fa-id-card-o"></i><a href="ui-cards.html">Cards</a></li>
                                <li><i class="fa fa-exclamation-triangle"></i><a href="ui-alerts.html">Alerts</a></li>
                                <li><i class="fa fa-spinner"></i><a href="ui-progressbar.html">Progress Bars</a></li>
                                <li><i class="fa fa-fire"></i><a href="ui-modals.html">Modals</a></li>
                                <li><i class="fa fa-book"></i><a href="ui-switches.html">Switches</a></li>
                                <li><i class="fa fa-th"></i><a href="ui-grids.html">Grids</a></li>
                                <li><i class="fa fa-file-word-o"></i><a href="ui-typgraphy.html">Typography</a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Tables</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-table"></i><a href="tables-basic.html">Basic Table</a></li>
                                <li><i class="fa fa-table"></i><a href="tables-data.html">Data Table</a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Forms</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-th"></i><a href="forms-basic.html">Basic Form</a></li>
                                <li><i class="menu-icon fa fa-th"></i><a href="forms-advanced.html">Advanced Form</a></li>
                            </ul>
                        </li>

                        <h3 class="menu-title">Icons</h3><!-- /.menu-title -->

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Icons</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-fort-awesome"></i><a href="font-fontawesome.html">Font Awesome</a></li>
                                <li><i class="menu-icon ti-themify-logo"></i><a href="font-themify.html">Themefy Icons</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="widgets.html"> <i class="menu-icon ti-email"></i>Widgets </a>
                        </li>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Charts</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-line-chart"></i><a href="charts-chartjs.html">Chart JS</a></li>
                                <li><i class="menu-icon fa fa-area-chart"></i><a href="charts-flot.html">Flot Chart</a></li>
                                <li><i class="menu-icon fa fa-pie-chart"></i><a href="charts-peity.html">Peity Chart</a></li>
                            </ul>
                        </li>

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-area-chart"></i>Maps</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-map-o"></i><a href="maps-gmap.html">Google Maps</a></li>
                                <li><i class="menu-icon fa fa-street-view"></i><a href="maps-vector.html">Vector Maps</a></li>
                            </ul>
                        </li>
                        <h3 class="menu-title">Extras</h3><!-- /.menu-title -->
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Pages</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-sign-in"></i><a href="page-login.html">Login</a></li>
                                <li><i class="menu-icon fa fa-sign-in"></i><a href="page-register.html">Register</a></li>
                                <li><i class="menu-icon fa fa-paper-plane"></i><a href="pages-forget.html">Forget Pass</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel">

            <!-- Header-->
            <header id="header" class="header">

                <div class="header-menu">

                    <div class="col-sm-7">
                        <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                        <div class="header-left">
                            <button class="search-trigger"><i class="fa fa-search"></i></button>
                            <div class="form-inline">
                                <form class="search-form">
                                    <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                    <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                                </form>
                            </div>

                            <div class="dropdown for-notification">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-bell"></i>
                                    <span class="count bg-danger">5</span>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="notification">
                                    <p class="red">You have 3 Notification</p>
                                    <a class="dropdown-item media bg-flat-color-1" href="#">
                                        <i class="fa fa-check"></i>
                                        <p>Server #1 overloaded.</p>
                                    </a>
                                    <a class="dropdown-item media bg-flat-color-4" href="#">
                                        <i class="fa fa-info"></i>
                                        <p>Server #2 overloaded.</p>
                                    </a>
                                    <a class="dropdown-item media bg-flat-color-5" href="#">
                                        <i class="fa fa-warning"></i>
                                        <p>Server #3 overloaded.</p>
                                    </a>
                                </div>
                            </div>

                            <div class="dropdown for-message">
                                <button class="btn btn-secondary dropdown-toggle" type="button"
                                        id="message"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="ti-email"></i>
                                    <span class="count bg-primary">9</span>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="message">
                                    <p class="red">You have 4 Mails</p>
                                    <a class="dropdown-item media bg-flat-color-1" href="#">
                                        <span class="photo media-left"><img alt="avatar" src="images/avatar/1.jpg"></span>
                                        <span class="message media-body">
                                            <span class="name float-left">Jonathan Smith</span>
                                            <span class="time float-right">Just now</span>
                                            <p>Hello, this is an example msg</p>
                                        </span>
                                    </a>
                                    <a class="dropdown-item media bg-flat-color-4" href="#">
                                        <span class="photo media-left"><img alt="avatar" src="images/avatar/2.jpg"></span>
                                        <span class="message media-body">
                                            <span class="name float-left">Jack Sanders</span>
                                            <span class="time float-right">5 minutes ago</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur</p>
                                        </span>
                                    </a>
                                    <a class="dropdown-item media bg-flat-color-5" href="#">
                                        <span class="photo media-left"><img alt="avatar" src="images/avatar/3.jpg"></span>
                                        <span class="message media-body">
                                            <span class="name float-left">Cheryl Wheeler</span>
                                            <span class="time float-right">10 minutes ago</span>
                                            <p>Hello, this is an example msg</p>
                                        </span>
                                    </a>
                                    <a class="dropdown-item media bg-flat-color-3" href="#">
                                        <span class="photo media-left"><img alt="avatar" src="images/avatar/4.jpg"></span>
                                        <span class="message media-body">
                                            <span class="name float-left">Rachel Santos</span>
                                            <span class="time float-right">15 minutes ago</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur</p>
                                        </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-5">
                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                            </a>

                            <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="#"><i class="fa fa- user"></i>My Profile</a>

                                <a class="nav-link" href="#"><i class="fa fa- user"></i>Notifications <span class="count">13</span></a>

                                <a class="nav-link" href="#"><i class="fa fa -cog"></i>Settings</a>

                                <a class="nav-link" href="#"><i class="fa fa-power -off"></i>Logout</a>
                            </div>
                        </div>

                        <div class="language-select dropdown" id="language-select">
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown"  id="language" aria-haspopup="true" aria-expanded="true">
                                <i class="flag-icon flag-icon-us"></i>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="language" >
                                <div class="dropdown-item">
                                    <span class="flag-icon flag-icon-fr"></span>
                                </div>
                                <div class="dropdown-item">
                                    <i class="flag-icon flag-icon-es"></i>
                                </div>
                                <div class="dropdown-item">
                                    <i class="flag-icon flag-icon-us"></i>
                                </div>
                                <div class="dropdown-item">
                                    <i class="flag-icon flag-icon-it"></i>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </header><!-- /header -->
            <!-- Header-->

            <div class="breadcrumbs">
                <div class="col-sm-4">
                    <div class="page-header float-left">
                        <div class="page-title">
                            <h1>Dashboard</h1>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="page-header float-right">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li><a href="#">Dashboard</a></li>
                                <li><a href="#">Table</a></li>
                                <li class="active">Data table</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content mt-3">
                <div class="animated fadeIn">
                    <div class="row">

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Data Table Karyawan  &nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#inputModal">Input</button>
                                    </strong>
                                </div>
                                <div class="card-body">
                                    <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID Karyawan</th>
                                                <th>Nama Karyawan</th>
                                                <th>No.Hp Karyawan</th>
                                                <th>Email Karyawan</th>
                                                <th>Awal Kerja</th>
                                                <th>Id Department</th>
                                                <th>Id Manager</th>
                                                <th>Aksi</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% List<Karyawan> datas = (List<Karyawan>) session.getAttribute("DataKaryawan");
                                                int i = 0;
                                                for (Karyawan karyawan : datas) {%>
                                            <tr>
                                                <td><%= karyawan.getIdKaryawan()%></td>
                                                <td><%= karyawan.getNamaKaryawan()%></td>
                                                <td><%= karyawan.getNoTlpKaryawan()%></td>
                                                <td><%= karyawan.getEmailKaryawan()%></td>
                                                <td><%= karyawan.getAwalGabung()%></td>
                                                <td><%= karyawan.getIdDepartemen().getNamaDepartemen()%></td>
                                                <td><%= karyawan.getIdManager()%></td>
                                                <td><div class="fa-hover col-lg-3 col-md-6"><a href="Karyawan.jsp?id=<%= karyawan.getIdKaryawan()%>" data-toggle="modal" 
                                                                                               data-val="<%= karyawan.getIdKaryawan() + "," + karyawan.getNamaKaryawan() + "," + karyawan.getNoTlpKaryawan()
                                                                                                      + "," + karyawan.getEmailKaryawan() + "," + karyawan.getAwalGabung() + "," + karyawan.getIdDepartemen().getIdDepartemen()
                                                                                                      + "," + karyawan.getIdManager() + "," + karyawan.getKataSandi() + "," + karyawan.getSisaCuti() + "," + karyawan.getBanyakCuti()
                                                                                                      + "," + karyawan.getStatus() + "," + karyawan.getIdRole().getIdRole() %>"
                                                                                               data-target="#updateModal"><i class="fa fa-edit"></i></a></div>
                                                    <div class="fa-hover col-lg-3 col-md-6"><a href="deleteKaryawan?id=<%= karyawan.getIdKaryawan()%>"><i class="fa fa-trash-o"></i></a></div>
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>
                </div><!-- .animated -->
            </div><!-- .content -->
            <!-- modal tambah karyawan -->
            <div class="modal fade" id="inputModal" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="mediumModalLabel">Medium Modal</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Basic Form</strong> Elements
                                    </div>
                                    <div class="card-body card-block">
                                        <form class="form-horizontal" action="simpanKaryawan" method="POST">
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">ID Karyawan</label></div>
                                                <div class="col-12 col-md-9"><input type="text" name="id" id="text-input" placeholder="ID Karyawan" value="" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nama</label></div>
                                                <div class="col-12 col-md-9"><input type="text" name="nama" id="text-input" placeholder="Nama Lengkap" value="" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nomor Telepon</label></div>
                                                <div class="col-12 col-md-9"><input type="text" name="telp" id="text-input" placeholder="No Hp" value="" class="form-control"><small class="form-text text-muted">This is a help number</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Email</label></div>
                                                <div class="col-12 col-md-9"><input type="email" name="mail" id="email-input" placeholder="Email aktif" value="" class="form-control"><small class="help-block form-text">Please enter your ngemail</small></div>
                                            </div>            
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Tanggal Gabung</label></div>
                                                <div class="col-12 col-md-9"><input type="text" name="tgl" id="email-input" placeholder="Awal Masuk Kerja" value="" class="form-control"><small class="help-block form-text">Please enter your ngemail</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">ID Departemen</label></div>
                                                <div class="col-12 col-md-9"><select name="dept">
                                                        <% List<Departemen> dept = (List<Departemen>) session.getAttribute("DataDepartemen");
                                                            for (Departemen dep : dept) {%>
                                                        <option value=<%= dep.getIdDepartemen() %>><%= dep.getIdDepartemen()+" - "+dep.getNamaDepartemen() %> </option> <% }%>
                                                    </select>&nbsp;&nbsp;&nbsp;&nbsp;Please enter your email</div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">ID Manager</label></div>
                                                <div class="col-12 col-md-9"><input type="text" name="man" id="email-input" placeholder="Id Managernya" value="" class="form-control"><small class="help-block form-text">Please enter your ngemail</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Sisa Cuti</label></div>
                                                <div class="col-12 col-md-9"><input type="text" name="sisa" id="email-input" placeholder="12" value="" class="form-control"><small class="help-block form-text">Please enter your ngemail</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Banyak cuti</label></div>
                                                <div class="col-12 col-md-9"><input type="text" id="email-input" name="banyak" placeholder="12" value="" class="form-control"><small class="help-block form-text">Please enter your ngemail</small></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="file-input" class=" form-control-label">File input photo</label></div>
                                                <div class="col-12 col-md-9"><input type="file" id="file-input" name="photo" value="" class="form-control-file"></div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="file-input" class=" form-control-label">Status Karyawan</label></div>
                                                <div class="col-12 col-md-9"><select name="status">
                                                     <option value="Aktif">Aktif</option>
                                                     <option value="Tidak Aktif">Tidak Aktif</option>
                                                    </select>&nbsp;&nbsp;&nbsp;&nbsp;Pilih Status</div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="file-input" class=" form-control-label">Role Karyawan</label></div>
                                                <div class="col-12 col-md-9"><select name="role">
                                                     <option value="ROLE0001">ROLE0001 - Admin</option>
                                                     <option value="ROLE0002">ROLE0002 - Manager</option>
                                                     <option value="ROLE0003">ROLE0003 - Karyawan</option>
                                                    </select>&nbsp;&nbsp;&nbsp;&nbsp;Pilih Role</div>
                                            </div>
                                            <div class="card-footer">
                                                <button type="submit" class="btn btn-success btn-sm">
                                                    <i class="fa fa-dot-circle-o"></i> Submit
                                                </button>
                                                <button type="reset" class="btn btn-danger btn-sm">
                                                    <i class="fa fa-ban"></i> Reset
                                                </button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
            <!-- modal Update karyawan -->
            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <form name="aisyah" method="post" action="simpanKaryawan">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="mediumModalLabel">Detail Karyawan</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="card">
                                    <div class="card-header"><strong>Edit Data Karyawan</strong><small></small></div>
                                    <div class="card-body card-block">
                                        <div class="form-group"><label for="nilai1" class=" form-control-label">ID Karyawan</label><input type="text" name="id" id="nilai1" value="" class="form-control"></div>
                                        <div class="form-group"><label for="nilai2" class=" form-control-label">Nama Karyawan</label><input type="text" name="nama" id="nilai2" value="" class="form-control"></div>
                                        <div class="form-group"><label for="nilai3" class=" form-control-label">nomor telepon</label><input type="text" name="telp" id="nilai3" value="" class="form-control"></div>
                                        <div class="form-group"><label for="nilai4" class=" form-control-label">email karyawan</label><input type="text" name="mail" id="nilai4" value="" class="form-control"></div>
                                        <div class="form-group"><label for="nilai5" class=" form-control-label">awal gabung</label><input type="date" name="tgl" id="nilai5" value="" class="form-control"></div>
                                        <div class="form-group"><label for="nilai6" class=" form-control-label">id departemen</label><input type="text" name="dept" id="nilai6" class="form-control"></div>
                                        <div class="form-group"><label for="nilai7" class=" form-control-label">id manager</label><input type="text" name="man" id="nilai7" class="form-control"></div>
                                        <div class="form-group"><label for="nilai8" class=" form-control-label">Password</label><input type="text" name="pass" id="nilai8" class="form-control"></div>
                                        <div class="form-group"><label for="nilai9" class=" form-control-label">sisa cuti</label><input type="text" name="sisa" id="nilai9" class="form-control"></div>
                                        <div class="form-group"><label for="nilai10" class=" form-control-label">banyak cuti</label><input type="text" name="banyak" id="nilai10" class="form-control"></div>
                                        <div class="form-group"><label for="nilai11" class=" form-control-label">status</label><input type="text" name="status" id="nilai11" class="form-control"></div>
                                        <div class="form-group"><label for="nilai12" class=" form-control-label">id role</label><input type="text" name="role" id="nilai12" class="form-control"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-primary" onclick="{
                                            document.aisyah.submit();
                                        }">Confirm</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div><!-- /#right-panel -->

        <!-- Right Panel -->


        <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>


        <script src="assets/js/lib/data-table/datatables.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/jszip.min.js"></script>
        <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
        <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
        <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
        <script src="assets/js/lib/data-table/datatables-init.js"></script>


        <script type="text/javascript">
                                    $(document).ready(function () {
                                        $('#bootstrap-data-table-export').DataTable();
                                    });
                                    $('#updateModal').on('show.bs.modal', function (event) {
                                        var myVal = $(event.relatedTarget).data('val');
                                        var a = myVal.split(",");
                                        $(this).find('input[id="nilai1"]').val(a[0]);
                                        $(this).find('input[id="nilai2"]').val(a[1]);
                                        $(this).find('input[id="nilai3"]').val(a[2]);
                                        $(this).find('input[id="nilai4"]').val(a[3]);
                                        $(this).find('input[id="nilai5"]').val(a[4]);
                                        $(this).find('input[id="nilai6"]').val(a[5]);
                                        $(this).find('input[id="nilai7"]').val(a[6]);
                                        $(this).find('input[id="nilai8"]').val(a[7]);
                                        $(this).find('input[id="nilai9"]').val(a[8]);
                                        $(this).find('input[id="nilai10"]').val(a[9]);
                                        $(this).find('input[id="nilai11"]').val(a[10]);
                                        $(this).find('input[id="nilai12"]').val(a[11]);
                                    });
        </script>


    </body>
</html>
