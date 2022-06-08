// Importaciones

	package model;

// Clase principal

public class Actividad
	{

		// Atributos

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

		// Constructor
		
			public Actividad
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

		// Getter para el atributo titulo

			public String getTitulo() 
				{
					return this.titulo;
				}

		// Getter para el atributo descripcion

			public String getDescripcion()
				{
					return this.descripcion;
				}

		// Getter para el atributo tipo	

			public String getTipo()
				{
					return tipo;
				}

		// Getter para el atributo fechaInicial

			public String getFechaInicial() 
				{
					return fechaInicial;
				}

		// Getter para el atributo fechaFinal

			public String getFechaFinal()
				{
					return fechaFinal;
				}

		// Getter para el atributo horaInicial

			public String getHoraInicial()
				{
					return horaInicial;
				}

		// Getter para el atributo horaFinal

			public String getHoraFinal()
				{
					return horaFinal;
				}

		// Getter para el atributo tiempoRealizacion

			public long getTiempoRelizacion()
				{
					return tiempoRealizacion;
				}

		// Getter para el atributo isTiempoReal

			public boolean getIsTiempoReal() 
				{
					return isTiempoReal;
				}

		// Getter para el atributo autor

			public Participante getAutor()
			{
				return this.autor;
			}

		// Getter para el atributo iD

			public int getId() 
			{
				return this.iD;
			}

	}