package model;

import java.util.ArrayList;

public class Tarea {

    // Atributos

        int iD;
        String nombre;
        String descripcion;
        String tipo;
        ArrayList<Participante> autores = new ArrayList<Participante>();
        String fechaInicial;
        String fechaFinal;
        String horaInicial;
        String horaFinal;
        ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        ArrayList<Tarea> subTareas = new ArrayList<Tarea>();

    // Constructor

        public Tarea
            (
                int iD,
                String nombre,
                String descripcion,
                String tipo,
                String fechaInicial,
                String fechaFinal,
                String horaInicial,
                String horaFinal
            )
                {
                    
                    this.nombre = nombre;
                    this.descripcion = descripcion;
                    this.tipo = tipo;
                    this.autores = new ArrayList<Participante>();
                    this.fechaInicial = fechaInicial;
                    this.fechaFinal = fechaFinal;
                    this.horaInicial = horaInicial;
                    this.horaFinal = horaFinal;
                    this.actividades = new ArrayList<Actividad>();
                    this.subTareas = new ArrayList<Tarea>();

                }
  
    // Metodos

        // Metodo para obtener el atributo iD

            public int getId()
                {
                    return iD;
                }

        // Metodo para obtener el atributo nombre

            public String getNombre()
                {
                    return nombre;
                }

        // Metodo para obtener el atributo descripcion

            public String getDescripcion()
                {
                    return descripcion;
                }

        // Metodo para obtener el atributo tipo

            public String getTipo()
                {
                    return tipo;
                }

        // Metodo para obtener el atributo autores

            public ArrayList<Participante> getAutores()
                {
                    return autores;
                }

        // Metodo para obtener el atributo fechaInicial

            public String getFechaInicial()
                {
                    return fechaInicial;
                }

        // Metodo para obtener el atributo fechaFinal

            public String getFechaFinal()
                {
                    return fechaFinal;
                }

        // Metodo para obtener el atributo horaInicial

            public String getHoraInicial()
                {
                    return horaInicial;
                }

        // Metodo para obtener el atributo horaFinal

            public String getHoraFinal()
                {
                    return horaFinal;
                }

        // Metodo para obtener el atributo actividades

            public ArrayList<Actividad> getActividades()
                {
                    return actividades;
                }

        // Metodo para obtener el atributo subTareas

            public ArrayList<Tarea> getSubTareas()
                {
                    return subTareas;
                }

        // Metodo para añadir una subtarea a la tarea

            public void anadirSubTarea
                (

                    int iD,
                    String nombre,
                    String descripcion,
                    String tipo,
                    String fechaInicial,
                    String fechaFinal,
                    String horaInicial,
                    String horaFinal
                )
                    {
                        subTareas.add(new Tarea(iD, nombre, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal));
                    }

        // Metodo para añadir una actividad a la tarea

            public void anadirActividad
            (

                String titulo, 
                String descripcion,
                String tipo,
                String fechaInicial,
                String fechaFinal, 
                String horaInicial,
                String horaFinal,
                long tiempoRealizacion,
                boolean isTiempoReal, 
                Participante autor,
                int iD

            )
                {
                    actividades.add(new Actividad(titulo, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal, tiempoRealizacion, isTiempoReal, autor, iD));
                }
                
}
