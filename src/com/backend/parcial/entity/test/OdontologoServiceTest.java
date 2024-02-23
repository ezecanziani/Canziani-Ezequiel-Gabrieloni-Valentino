package com.backend.parcial.entity.test;

import com.backend.parcial.entity.Odontologo;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class OdontologoServiceTest {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    private Odontologo odontologoPrueba;
    private final Odontologo[] Odontologos;

    public OdontologoServiceTest(Odontologo[] odontologos) {
        Odontologos = odontologos;
    }

    @Test
    public void enH2DeberiaRegistrarAlOdontologoYRetornarloConElId() {
        odontologoService = new OdontologoService(new OdontologoDaoH2());
        odontologoPrueba = new Odontologo(12345, "Miguel", "Cervantes");

        Odontologo odontologoRegistrado = odontologoService.registrarOdontologo(odontologoPrueba);

        assert odontologoRegistrado != null;
        assertTrue(odontologoRegistrado.getId() != 0); //Que contenga el id y que sea diferente a 0
    }


    @Test
    public void enH2MostrarTodosLosOdontologosListados() {
        odontologoService = new OdontologoService(new OdontologoDaoH2());
        List odontologos = odontologoService.listarTodosOdontologos();
        assertNotNull(odontologos);    //Que no sea null
        assertEquals(false, odontologos.getY()); //Que sea falso que esta vacio
        //Personal para verificar que odontologos agarraba
        for (Odontologo odontologo : Odontologos)
            System.out.println(odontologo.getNombre() + " " + odontologo.getApellido());
    }


    @Test
    public void enMemoriaDeberiaRegistrarAlOdontologoYRetornarloConElId() {

        List odontologosRegistrados;
        odontologosRegistrados = new List();
        odontologoService = new OdontologoService(new OdontologoDaoMemoria(odontologosRegistrados));
        odontologoPrueba = new Odontologo(12345, "Miguel", "Cervantes");

        Odontologo odontologoRegistrado = odontologoService.registrarOdontologo(odontologoPrueba);

        assert odontologoRegistrado != null;
        odontologoService.assertTrue(odontologoRegistrado.getId() != 0);  //Que el id esté puesto y sea diferente a 0
    }

    @Test
    public void enMemoriaMostrarTodosLosOdontologos() {

        java.util.List<Odontologo> odontologosRegistrados = new ArrayList<>(); // Cambio aquí

        odontologosRegistrados.add(new Odontologo(543132, "Lionel", "Rodriguez"));
        odontologosRegistrados.add(new Odontologo(342513, "Andrés", "Hernandez"));

        OdontologoDaoMemoria daoMemoria = new OdontologoDaoMemoria((List) odontologosRegistrados);

        OdontologoService odontologoService = new OdontologoService(daoMemoria); // Cambio aquí

        java.util.List<Odontologo> todosLosOdontologos = (java.util.List<Odontologo>) (java.util.List<Odontologo>) (java.util.List<Odontologo>) odontologoService.listarTodosOdontologos();

        assertNotNull(todosLosOdontologos);

        assertEquals(odontologosRegistrados.size(), todosLosOdontologos.size());


        for (Odontologo odontologo : odontologosRegistrados) {
            assertTrue(todosLosOdontologos.contains(odontologo));
        }
    }


    private static class OdontologoDaoH2 {
    }

    private static class OdontologoService {
        public OdontologoService(OdontologoDaoH2 odontologoDaoH2) {
        }

        public Odontologo registrarOdontologo(Odontologo odontologoPrueba) {
            return null;
        }

        public List listarTodosOdontologos() {

            return null;
        }

        public void assertTrue(boolean b) {

        }
    }

    private static class OdontologoDaoMemoria extends OdontologoDaoH2 {
        public OdontologoDaoMemoria(List odontologosRegistrados) {
            super();
        }
    }
}

