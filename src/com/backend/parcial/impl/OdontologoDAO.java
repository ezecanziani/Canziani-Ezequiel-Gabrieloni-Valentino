package com.backend.parcial.impl;

import com.backend.parcial.entity.Odontologo;

import java.util.List;

public interface OdontologoDAO {
    void guardarOdontologo(Odontologo odontologo);

    void guardarOdotologo(Odontologo odontologo);

    List<Odontologo> listarOdontologos();
}
