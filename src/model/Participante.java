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

		}