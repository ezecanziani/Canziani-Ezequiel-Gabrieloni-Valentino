package com.backend.parcial.impl;

import com.backend.parcial.entity.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOdontologoDAO implements OdontologoDAO {
    private List<Odontologo> odontologos;

    public ArrayListOdontologoDAO() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        odontologos.add(odontologo);
        System.out.println("Odontólogo guardado en ArrayList: " + odontologo);
    }

    @Override
    public void guardarOdotologo(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> listarOdontologos() {
        System.out.println("Listado de odontólogos desde ArrayList:");
        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo);
        }
        return odontologos;
    }
}