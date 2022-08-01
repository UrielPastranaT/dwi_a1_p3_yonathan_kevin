<%-- 
    Document   : mostrar
    Created on : 6/07/2022, 05:40:29 PM
    Author     : Yonathan Uriel Pastrana Tepectzin y Kevin Ulises Garcia Camacho
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.Alumno"%>
<%@page import="dao.DAOAlumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
        <!-- <link rel="stylesheet" href="css/estilos.css"> -->
        <link href="recursos/bootstrap/css/theme.css" rel="stylesheet"/>
        <link rel="stylesheet" href="recursos/css/style.css" type="text/css" />
        <script
            src="https://kit.fontawesome.com/ac778e692e.js"
            crossorigin="anonymous">
        </script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700,100' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Raleway:300,700,900,500' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/typicons/2.0.7/typicons.min.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./recursos/assets/css/pushy.css">
        <link rel="stylesheet" href="./recursos/assets/css/masonry.css">
        <link rel="stylesheet" href="./recursos/assets/css/animate.css">
        <link rel="stylesheet" href="./recursos/assets/css/magnific-popup.css">
        <link rel="stylesheet" href="./recursos/assets/css/odometer-theme-default.css">
        <script>
            window.odometerOptions = {
                selector: '.odometer',
                format: '(,ddd)',
                duration: 13000,
                theme: 'default'
            };
        </script>

        <title>Lista de alumnos</title>

    </head>
    <body>

        <nav class="pushy pushy-left">
            <ul class="list-unstyled">
                <li><a href="SAlumnos">Inicio</a></li>     
                <li><a href="SAlumnos">Alumnos</a></li>
            </ul>
        </nav>

        <div class="site-overlay"></div>

        <header id="home">
            <div class="container-fluid">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-xs-10">
                            <a href="#" class="thumbnail logo">
                            </a>
                        </div>
                        <div class="col-md-1 col-md-offset-8 col-xs-2 text-center">
                            <div class="menu-btn"><span class="hamburger">&#9776;</span></div>
                        </div>
                    </div>
                    <div class="jumbotron">
                        <h1><small></small></br>
                            <strong>Lista de alumnos
                            </strong></h1>
                        <p><a  href="SAlumnos?accion=nuevo"  class="btn btn-lg btn-danger" role="button">Nuevo</a></p>
                    </div>
                </div>
            </div>
        </header>

        <div>
        </div>
        <div>
            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">MATRICULA</th>
                        <th scope="col">ALUMNO</th>
                        <th scope="col">DDI</th>
                        <th scope="col">DWI</th>
                        <th scope="col">ECBD</th>
                        <th scope="col">PROM</th>
                        <th colspan = "2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        DAOAlumno daoAlumno = new DAOAlumno();
                        ArrayList<Alumno> listAlumnos = daoAlumno.mostrar();
                        Alumno alumno = null;
                        for (int i = 0; i < listAlumnos.size(); i++) {
                            alumno = listAlumnos.get(i);
                    %>

                    <tr>
                        <td><%= alumno.getMatricula()%></td>
                        <td><%= alumno.getNombre()%> <%= alumno.getApellidoPaterno()%> <%=alumno.getApellidoMaterno()%></td>
                        <td><%= alumno.getDdi()%></td>
                        <td><%= alumno.getDwi()%></td>
                        <td><%= alumno.getEcbd()%></td>
                        <td><%= alumno.getProm()%></td>
                        <td><a href="SAlumnos?accion=editar&matricula=<%= alumno.getMatricula()%>">Editar</a></td>
                        <td><a href="SAlumnos?accion=eliminar&matricula=<%= alumno.getMatricula()%>">Eliminar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <h3>UT Chilapa</h3>
                        <p>© Derechos reservados © UT Chilapa<a target="_blank" href=""></a></p>
                    </div>
                    <div class="col-md-4">
                        <p class="text-right social"><i class="typcn typcn-social-facebook-circular"></i><i class="typcn typcn-social-twitter-circular"></i></p>
                    </div>
                </div>
            </div>
        </footer>

        <script src="recursos/assets/js/jquery.min.js"></script>
        <script src="recursos/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.0.4/js/bootstrap-scrollspy.js"></script>
        <script src="recursos/assets/js/ie10-viewport-bug-workaround.js"></script>
        <script src="http://masonry.desandro.com/masonry.pkgd.js"></script>
        <script src="recursos/assets/js/masonry.js"></script>
        <script src="recursos/assets/js/pushy.min.js"></script>
        <script src="recursos/assets/js/jquery.magnific-popup.min.js"></script>
        <script src="recursos/assets/js/wow.min.js"></script>
        <script src="recursos/assets/js/scripts.js"></script>
        <script src="recursos/assets/js/odometer.js"></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"
        ></script> 

    </body>
</html>