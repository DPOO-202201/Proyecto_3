package model;

import java.util.ArrayList;

public class Tarea {

    // Atributos

        int iD;
        String nombre;
        String descripcion;
        String tipo;
        ArrayList<Participante> autores =new ArrayList<Participante>();
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

        public void anadirTarea
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
