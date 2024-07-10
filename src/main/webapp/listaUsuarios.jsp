<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jdbc1.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Usuarios</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header text-center">
          <h2>Lista de Usuarios</h2>
        </div>
        <div class="card-body">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>ID</th>
              <th>Nombre</th>
              <th>Password</th>
            </tr>
            </thead>
            <tbody>
            <%
              List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
              if (usuarios != null && !usuarios.isEmpty() ) {
                for (Usuario usuario : usuarios) {
            %>
            <tr>
              <td><%= usuario.getId() %></td>
              <td><%= usuario.getNombre() %></td>
              <td><%= usuario.getPassword() %></td>
            </tr>
            <%
                }
              }
            %>
            </tbody>
          </table>
          <a href="index.jsp" class="btn btn-primary w-100">Volver</a>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
