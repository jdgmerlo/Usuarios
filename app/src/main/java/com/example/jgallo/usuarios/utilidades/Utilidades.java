package com.example.jgallo.usuarios.utilidades;

public class Utilidades {

    //USUARIOS
    public static final String T_USUARIOS = "usuarios";
    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_TELEFONO = "telefono";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ T_USUARIOS +" ("+C_ID+" INTEGER, "+C_NOMBRE+" TEXT, "+C_TELEFONO+" TEXT)";


    //MASCOTAS
    public static final String T_MASCOTA = "mascota";
    public static final String C_ID_MASCOTA = "id_mascota";
    public static final String C_NOMBRE_MASCOTA = "nombre_mascota";
    public static final String C_RAZA_MASCOTA = "raza_mascota";
    public static final String C_ID_DUENIO = "id_duenio";

    public static final String CREAR_TABLA_MASCOTA = "CREATE TABLE " +
            ""+T_MASCOTA+" ("+C_ID_MASCOTA+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +C_NOMBRE_MASCOTA+" TEXT, "+C_RAZA_MASCOTA+" TEXT, "+C_ID_DUENIO+" INTEGER)";


}
