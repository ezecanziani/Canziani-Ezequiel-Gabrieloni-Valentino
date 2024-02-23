package com.backend.parcial.impl;

import com.backend.parcial.entity.Odontologo;
import dbconnection.H2Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2OdontologoDAO implements OdontologoDAO {
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS odontologos (" +
            "matricula INT PRIMARY KEY, " +
            "nombre VARCHAR(255), " +
            "apellido VARCHAR(255))";

    private static final String INSERT_SQL = "INSERT INTO odontologos (matricula, nombre, apellido) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM odontologos";

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        try (Connection connection = H2Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setInt(1, odontologo.getMatricula());
            statement.setString(2, odontologo.getNombre());
            statement.setString(3, odontologo.getApellido());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarOdotologo(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> listarOdontologos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try (Connection connection = H2Connection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next()) {
                int matricula = resultSet.getInt("matricula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                odontologos.add(new Odontologo(matricula, nombre, apellido));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }

    static {
        try (Connection connection = H2Connection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}