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

@WebServlet(name = "InsertarUsuarioServlet", value = "/insertarUsuario")
public class InsertarUsuarioServlet extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String password = req.getParameter("password");
        Usuario usuario = new Usuario(nombre, password);

        String mensaje = usuarioService.insertarUsuario(usuario);
        req.setAttribute("mensaje", mensaje);

        RequestDispatcher dispatcher = req.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(req, resp);
    }
}
