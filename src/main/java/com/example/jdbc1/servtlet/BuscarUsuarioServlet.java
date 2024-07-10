package com.example.jdbc1.servtlet;

import com.example.jdbc1.model.Usuario;
import com.example.jdbc1.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BuscarUsuarioServlet", value = "/buscarUsuario")
public class BuscarUsuarioServlet extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        Usuario usuario = null;
        String mensaje = null;

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                usuario = usuarioService.buscarUsuarioPorID(id);
                if (usuario == null) {
                    mensaje = "No se encontró un usuario con el ID proporcionado.";
                }
            } catch (NumberFormatException e) {
                mensaje = "El ID debe ser un número entero.";
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            mensaje = "Por favor, ingrese un ID válido.";
        }

        request.setAttribute("usuario", usuario);
        request.setAttribute("mensaje", mensaje);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultadoBusqueda.jsp");
        requestDispatcher.forward(request, response);
    }
}
