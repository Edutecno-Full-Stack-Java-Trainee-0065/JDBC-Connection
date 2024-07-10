package com.example.jdbc1.servtlet;

import com.example.jdbc1.model.Usuario;
import com.example.jdbc1.service.UsuarioService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListarUsuariosServlet", value = "/listarUsuarios")
public class ListarUsuariosServlet extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher dispatcher = request.getRequestDispatcher("listaUsuarios.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
