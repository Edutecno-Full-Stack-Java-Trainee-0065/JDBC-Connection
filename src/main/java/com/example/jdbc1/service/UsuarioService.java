package com.example.jdbc1.service;

import com.example.jdbc1.database.DatabaseConnection;
import com.example.jdbc1.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    public String insertarUsuario(Usuario usuario) {
        String mensaje;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO usuarios (nombre, password) VALUES (?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getNombre());
                statement.setString(2, usuario.getPassword());
                int filasInsertadas = statement.executeUpdate();

                if (filasInsertadas > 0) {
                    mensaje = "Usuario insertado correctamente";
                } else {
                    mensaje = "Error al insertar usuario, en la capa de service";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error de conexion a la base de datos: " + e.getMessage();

        }
        return mensaje;
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM usuarios";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String password = resultSet.getString("password");

                    Usuario usuario = new Usuario(id, nombre, password);
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error de conexion a la base de datos: " + e.getMessage());
        }
        return usuarios;
    }

    public Usuario buscarUsuarioPorID(int usuarioID) throws SQLException {
        Usuario usuario = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, nombre, password FROM usuarios WHERE id = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, usuarioID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String password = resultSet.getString("password");

                        usuario = new Usuario(usuarioID, nombre, password);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error de conexion a la base de datos: " + e.getMessage());
        }
        return usuario;
    }
}
