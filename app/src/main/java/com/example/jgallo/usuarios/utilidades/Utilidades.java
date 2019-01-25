package com.example.jgallo.usuarios.utilidades;

public class Utilidades {

    public static final String T_USUARIOS = "usuarios";
    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_TELEFONO = "telefono";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ T_USUARIOS +" ("+C_ID+" INTEGER, "+C_NOMBRE+" TEXT, "+C_TELEFONO+" TEXT)";
}
