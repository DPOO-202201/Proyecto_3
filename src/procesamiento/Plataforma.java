// Importaciones

	package procesamiento;
	import java.util.ArrayList;
	import javax.swing.JOptionPane;
	import com.csvreader.CsvWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.BufferedReader;
	import model.Participante;
	import model.Proyecto;

// Clase principal	

	public class Plataforma
	{

		// Se crea esta variable para guardar la ruta del archivo donde se
		// guarda el iD de los proyectos
			
			private static String rutaIdProyectos = "./././data/iDs/iDProyecto.csv";

		// Se crea esta variable para guardar la ruta del archivo donde se
		// guarda el iD de los proyectos
			
			private static String rutaIdActividades = "./././data/iDs/iDActividad.csv";

		// Se crea esta variable para guardar la ruta del archivo donde se
		// guardan los proyectos
			
			private static String rutaProyectos = "./././data/proyectos.csv";

		// Se crea el iDProyecto para asiganrsele a cada proyecto nuevo creado,
		// este se actualiza cada que se crea un nuevo proyecto y cada que se
		// inicia la aplicación para asignarle a esta variable el numero de iD
		// por el que se quedo en la última ejecuón.
			
			private static int iDProyecto;

		// Se crea el iDActividad para asiganrsele a cada actividad nueva creada,
		// este se actualiza cada que se crea una nueva actividad y cada que se
		// inicia la aplicación para asignarle a esta variable el numero de iD
		// por el que se quedo en la última ejecuón.
			
			private static int iDActividad;

		// Se crea el pryectoActual para guardar el proyecto que se esté
		// manejando en el momento en caso de que se haya seleccionado uno
			
			private static Proyecto proyectoActual = null;

		// Se crea un AraryList de Proyecto para guardar y cargar todos los
		// proyectos de la aplicación una vez se incia la aplicación
			
			private static ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();

		// Getter para la variable iDProyecto decalarada en la linea 26

			public static int getIdProyecto()
				{

					return iDProyecto;

				}

		// Getter para la variable iDProyecto decalarada en la linea 26

			public static String getRutaActividades()
			{

				return "./././data/Proyectos/" + Plataforma.getProyectoActual().getNombre() + "/actividades.csv";

			}	

		// Getter para la variable iDProyecto decalarada en la linea 26

		public static String getRutaParticipantes()
		{

			return "./././data/Proyectos/" + Plataforma.getProyectoActual().getNombre() + "/participantes.csv";

		}	
	
		// Getter para la variable rutaIdProyectos decalarada en la linea 26

			public static String getRutaIdProyectos()
			{

				return rutaIdProyectos;

			}

		// Getter para la variable iDActividad decalarada en la linea 26

			public static int getIdActividad()
				{

					return iDActividad;

				}

		// Getter para la variable rutaiDActividades decalarada en la linea 26

			public static String getRutaIdActividades()
				{

					return rutaIdActividades;

				}

		// Getter para la variable proyectoActual decalarada en la linea 26

			public static Proyecto getProyectoActual()
			{

				return proyectoActual;

			}

		// Getter para la variable rutaProyectos decalarada en la linea 26

			public static String getRutaProyectos()
			{

				return rutaProyectos;

			}

		// Getter para la variable proyectos decalarada en la linea 41

			public static ArrayList<Proyecto> getProyectos()
			{

				return proyectos;

			}

		// Se carga toda la informacion de un proyecto dado su nombre
		
			public static void cargarProyecto(String nombreProyecto)
				{
		
					// Se recorre el ArrayList de proyectos declarado en la linea
					// 46 para buscar el proyecto por el nombre

						for(Proyecto proyecto : proyectos)
							{
			
								// Se comparan los nombres de todos los proyectos con el ingresado

									if (proyecto.getNombre().equals(nombreProyecto))
										{

											// Si encuentra el proyecto, se le asigna el proyecto
											// a la variable declarada en la linea 41
											
												proyectoActual = proyecto;

											// Se buscan los archivos de participantes y actividades del proyecto

												String rutaParticipantes = "./././data/Proyectos/" + proyectoActual.getNombre() + "/participantes.csv";
												String rutaActividades = "./././data/Proyectos/" + proyectoActual.getNombre() + "/actividades.csv";

											// Se carga la informacion de los archivos encontrados
				
												Proyecto.cargarParticipantes(rutaParticipantes);
												Proyecto.cargarActividades(rutaActividades);

											// Se rompe el ciclo para dejar de buscar

												break;
				
										}
							
							}

				}
		
		// Se cargan y guardan todos los proyectos existentes en la aplicación en el 
		// AraryList de Proyecto declarado en la linea 25, que vienen del archivo
		// data/proyectos.csv
		
			public static void cargarProyectos(String rutaArchivo)
				{
					
					// Se crean variables necesarias para la carga del archivo
					// data/proyectos.csv

						BufferedReader lector;
						String linea;
						String partes[];
			
					// Se crea un try por si no se encuentra el archivo en la ruta

						try
							{

								//Se lee el archivo y su primera linea

									lector = new BufferedReader(new FileReader(rutaArchivo));
									lector.readLine();

								// Se crea un ciclo para leer todas las lineas del archivo	
				
									while ((linea = lector.readLine()) != (null))
										{

											// Se separa la información por los ";" que hay
											// en la linea leida y se convierte en una lista.
											// El elemento 0 es el nombre del proyecto,
											// el 1 es su descripción, el 2 es su fecha incial,
											// el 3 es su fecha final y el 4 es su iD

												
												partes = linea.split(",");

											// Se crea un nuevo proyecto	

												Proyecto proyecto = new Proyecto(partes[0], partes[1], partes[2], partes[3], Integer.parseInt(partes[4]));
											
											// Se guarda el proyecto en el AraryList de Proyecto 
											// declarado en la linea 25	
											
												proyectos.add(proyecto);

										}
									
									// Una vez finalizada la lectura del archivo, se limpian 
									// las variables declaradas en las lineas 53, 54 y 55
									
										lector.close();
										linea = null;
										partes = null;
				
							} catch (Exception e)
								{
									JOptionPane.showMessageDialog(null, e);
								}
				}
		
		// Funcion para añadir un participante en el proyecto que se encuentre cargado
		// en el momento

			public static void crearParticipante(String nombre, String correo, boolean isDuenio)
			{

				Participante nuevoParticipante = new Participante(nombre, correo, isDuenio);
			
			}
		
		//Funcion para cargar el contador de IDs, el numero que se encuentre en data/iD.csv
		
			public static void cargarIdProyecto(String rutaArchivo)
			{

					// Se crean variables necesarias para la carga del archivo
					// data/proyectos.csv

						BufferedReader lector;
						String linea;
						String partes[];
			
					// Se crea un try por si no se encuentra el archivo en la ruta

						try
							{

								//Se lee el archivo y su primera linea

									lector = new BufferedReader(new FileReader(rutaArchivo));
									linea = lector.readLine();

								// Se guarda el iD en la variable declarada en la linea 20
												
									partes = linea.split("");
									iDProyecto = Integer.parseInt(partes[0]);

									
								// Una vez finalizada la lectura del archivo, se limpian 
								// las variables declaradas en las lineas 53, 54 y 55
									
									lector.close();
									linea = null;
									partes = null;
				
							} catch (Exception e)
								{
									JOptionPane.showMessageDialog(null, e);
								}
				}

		// Función para aumentar en 1 el iD guardado en data/iD.csv

			public static void modificarIdProyecto(String rutaArchivo) 
			{
				
				// Verifica que ya exista el archivo donde se guarda
				// el iD

					boolean existe = new File(rutaArchivo).exists();
					
				// Si existe un archivo llamado asi lo borra

					if(existe) {

						File archivo = new File(rutaArchivo);
						archivo.delete();
					
					}

				// Se crea un try por si rutaArchivo no es valida	
					
					try {

						// Crea el archivo
						
							CsvWriter salidaCSV = new CsvWriter(new FileWriter(rutaArchivo, true), ',');
						
						// Escribe el nuevo iD en el archivo

							salidaCSV.write(Integer.toString(iDProyecto + 1));
							salidaCSV.endRecord();
						
						// Cierra el archivo

							salidaCSV.close();
						
					} catch(IOException e) {
						e.printStackTrace();
					} 

			}
		
		//Funcion para cargar el contador de IDs, el numero que se encuentre en data/iD.csv
		
			public static void cargarIdActividad(String rutaArchivo)
			{

					// Se crean variables necesarias para la carga del archivo
					// data/proyectos.csv

						BufferedReader lector;
						String linea;
						String partes[];
			
					// Se crea un try por si no se encuentra el archivo en la ruta

						try
							{

								//Se lee el archivo y su primera linea

									lector = new BufferedReader(new FileReader(rutaArchivo));
									linea = lector.readLine();

								// Se guarda el iD en la variable declarada en la linea 20
												
									partes = linea.split("");
									iDActividad = Integer.parseInt(partes[0]);

									
								// Una vez finalizada la lectura del archivo, se limpian 
								// las variables declaradas en las lineas 53, 54 y 55
									
									lector.close();
									linea = null;
									partes = null;
				
							} catch (Exception e)
								{
									JOptionPane.showMessageDialog(null, e);
								}
				}

		// Función para aumentar en 1 el iD guardado en data/iD.csv

			public static void modificarIdActividad(String rutaArchivo) 
			{
				
				// Verifica que ya exista el archivo donde se guarda
				// el iD

					boolean existe = new File(rutaArchivo).exists();
					
				// Si existe un archivo llamado asi lo borra

					if(existe) {

						File archivo = new File(rutaArchivo);
						archivo.delete();
					
					}

				// Se crea un try por si rutaArchivo no es valida	
					
					try {

						// Crea el archivo
						
							CsvWriter salidaCSV = new CsvWriter(new FileWriter(rutaArchivo, true), ',');
						
						// Escribe el nuevo iD en el archivo

							salidaCSV.write(Integer.toString(iDActividad + 1));
							salidaCSV.endRecord();
						
						// Cierra el archivo

							salidaCSV.close();
						
					} catch(IOException e) {
						e.printStackTrace();
					} 

			}			

		// Setter para la fecha final del proyecto que se esté manejando
		// el el momentos
		
			public static void setFechaFinalProyectoActual(String fechaFinall)
			{

				proyectoActual.setFechaFinal(fechaFinall);

			}

		// Funcion para poder leer informacion de la consola

			public static String input(String mensaje)
			{

				try
				{
					System.out.print(mensaje + ": ");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					return reader.readLine();
				}
				catch (IOException e)
				{
					System.out.println("Error leyendo de la consola");
					e.printStackTrace();
				}
				return null;

			}
		
	}

