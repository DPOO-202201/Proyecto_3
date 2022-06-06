// Importaciones

	package model;
	import java.util.ArrayList;
	import java.util.Dictionary;
	import java.util.HashMap;
	import java.util.Map;

import procesamiento.Plataforma;

// Clase principal

	public class Participante
		{

			// Atributos

				private String nombre;
				private String correo;
				private boolean isDuenio;
				private ArrayList<Actividad> actividadesRealizadas;

			// Constructor
			
				public Participante
					(
							String nombre,
							String correo,
							boolean isDuenio
					) 
						{

							this.nombre = nombre;
							this.correo = correo;
							this.isDuenio = isDuenio;
							this.actividadesRealizadas = new ArrayList<Actividad>();

						}

			// Getter para el atributo nombre
			
				public String getNombre()
					{
						return this.nombre;
					}

			// Getter para el atributo correo

				public String getCorreo()
					{
						return this.correo;
					}

			// Getter para el atributo isDuenio

				public boolean getIsDuenio()
					{
						return this.isDuenio;
					}

			// Getter para el atributo actividades

				public ArrayList<Actividad> getActividades()
					{
						return this.actividadesRealizadas;
					}				
		
			// Metodo para generar un reporte del participante

				// public static Map<String, String> generarReporte()
				// 	{

				// 		// Se crea el Map donde se guardara la informacion del
				// 		// reporte

				// 			Map<String, String> info = new HashMap<>();

				// 		// Se crean los valores que se usarán para el reporte

				// 			int tiempoTotal = 0;

				// 		// Se recorre cada activiad del participante y se calcula la
				// 		// suma del tiempo de realizacion de todas sus actividades

				// 			for (Actividad actividad : actividadesRealizadas)
				// 				{
				// 					tiempoTotal = (int) (tiempoTotal + actividad.getTiempoRelizacion());
				// 				}

				// 		// Se añaden todos los tipos de actividad existentes en el
				// 		// proyecto como llaves del Map y con valor en 0 para
				// 		// despues calcular la cantidad de actividades por tipo de
				// 		// actividad

				// 			for (String tipo : Plataforma.getProyectoActual().getTiposActividad())
				// 					{

				// 						if (!(info.containsKey(tipo)))
				// 							{
				// 								info.put(tipo, "0");
				// 							}

				// 					}

				// 		// Se insertan al Map todos los datos recogidos

				// 			// Se calcula el tiempo invertido del participante en cada tipo
				// 			// de actividad

				// 				for (Actividad actividad : actividadesRealizadas)
				// 					{
										
				// 						info.put(actividad.getTipo(), Integer.toString(Integer.parseInt(info.get(actividad.getTipo())) + 1));

				// 					}

				// 			info.put("tiempoTotal", Integer.toString(tiempoTotal));
				// 			info.put("tiempoPromedio", Integer.toString(tiempoTotal / actividadesRealizadas.size()));
				// 			info.put("cantidadActividades", Integer.toString(actividadesRealizadas.size()));
				// 			info.put("nombre", nombre);


				// 		return info;

				// 	}

		}