package model;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Actividad
{
	private String titulo;
	private String descripcion;
	private String tipo;
	private String fechaInicial;
	private String fechaFinal;
	private static String horaInicial;
	private static String horaFinal;
	private static long tiempoRealizacion;
	private boolean isTiempoReal;
	private Participante autor;
	private int iD;
	
	public Actividad(String titulo, String descripcion, String tipo, String fechaInicial, String fechaFinal, 
			String horaInicial, String horaFinal, long tiempoRealizacion, boolean isTiempoReal, 
			Participante autor, int iD)
	{
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.tiempoRealizacion = tiempoRealizacion;
		this.isTiempoReal = isTiempoReal;
		this.autor = autor;
		this.iD = iD;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public long getTiempoRelizacion() {
		return tiempoRealizacion;
	}

	public boolean getIsTiempoReal() {
		return isTiempoReal;
	}

	public Participante getAutor() {
		return this.autor;
	}

	public int getId() {
		return this.iD;
	}


}