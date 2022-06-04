// Importaciones

	package model;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import javax.swing.JOptionPane;

	import com.csvreader.CsvWriter;

import procesamiento.Plataforma;

// Clase principal	

	public class Proyecto
	{
		
		// Se crean los atributos de Proyecto

			private String nombre;
			private String descripcion;
			private String fechaInicial;
			private static String fechaFinal;
			private int iD;
			private static ArrayList<String> tiposActividades;
			private static ArrayList<Participante> participantes = new ArrayList<Participante>();
			private static ArrayList<Actividad> actividades = new ArrayList<Actividad>();

		// Se crea el contructor para Proyecto	
		
			public Proyecto(String nombre, String descripcion, String fechaInicial, String fechaFinal, int iD)
			{

				this.nombre = nombre;
				this.descripcion = descripcion;
				this.fechaInicial = fechaInicial;
				this.iD = iD;
				tiposActividades = new ArrayList<String>();
				participantes = new ArrayList<Participante>();
				
			}

		// Función para crear la carpeta y los archivos del proyecto 
		// en la carpeta data

			public static void crearArchivoProyecto(String nombreProyecto) throws IOException 
			{
				
				// Crea la carpeta del proyecto

					String carpetaUbicacion = "./././data/Proyectos/" + nombreProyecto;
					File carpeta = new File(carpetaUbicacion);
					carpeta.mkdirs();

				// Crea el archivo de actividades del proyecto

					String actividadesUbicacion = "./././data/Proyectos/" + nombreProyecto + "/actividades.csv";
					File actividades = new File(actividadesUbicacion);
					actividades.createNewFile();

					// Crea el encabezado de las columnas del proyecto	

						// Verfica que el archivo ya exista

							String salidaArchivo = actividadesUbicacion;
							boolean existe = new File(salidaArchivo).exists(); 
						
						// Si ya existe el archivo, lo borra

							if(existe)
								{

									File archivoUsuarios = new File(salidaArchivo);
									archivoUsuarios.delete();
								
								}

						// Se crea un try por si la ruta del archivo no es valida
						
							try {

								// Crea el archivo

									CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
								
								// Datos para identificar las columnas

									salidaCSV.write("titulo");
									salidaCSV.write("descripcion");
									salidaCSV.write("tipo");
									salidaCSV.write("fechaInicial");
									salidaCSV.write("fechaFinal");
									salidaCSV.write("horaInicial");
									salidaCSV.write("horaFinal");
									salidaCSV.write("tiempoRealizacion");
									salidaCSV.write("isTiempoReal");
									salidaCSV.write("autor");
									salidaCSV.write("iD");

								// Deja de escribir en el archivo
								
									salidaCSV.endRecord();
								
								// Cierra el archivo

									salidaCSV.close(); 
								
							} catch(IOException e) {
								e.printStackTrace();
							}   

				// Crea el archivo de participantes del proyecto

					String participantesUbicacion = "./././data/Proyectos/" + nombreProyecto + "/participantes.csv";
					File participantes = new File(participantesUbicacion);
					participantes.createNewFile();

					// Crea el encabezado de las columnas del proyecto	

						// Verfica que el archivo ya exista

							salidaArchivo = participantesUbicacion;
							existe = new File(salidaArchivo).exists(); 
					
						// Si ya existe el archivo, lo borra

							if(existe)
								{

									File archivoUsuarios = new File(salidaArchivo);
									archivoUsuarios.delete();
								
								}

						// Se crea un try por si la ruta del archivo no es valida
					
							try {

								// Crea el archivo

									CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
								
								// Datos para identificar las columnas

									salidaCSV.write("nombre");
									salidaCSV.write("correo");
									salidaCSV.write("isDuenio");
									salidaCSV.write("actividadesRealizadas");

								// Deja de escribir en el archivo
								
									salidaCSV.endRecord();
								
								// Cierra el archivo

									salidaCSV.close(); 
								
							} catch(IOException e) {
								e.printStackTrace();
							}


				
			}
		
		// Setter para la fecha final del proyecto
		
		public static void setFechaFinal(String fechaFinall)
		{

			fechaFinal = fechaFinall;

		}
		
		// Getter para los participantes del proyecto	
		
			public static ArrayList<Participante> getParticipantes()
			{

				return participantes;

			}			

		// Getter para el nombre del proyecto

			public String getNombre()
			{

				return nombre;
			
			}

		// Getter para el iD del proyecto
		
			public int getId()
			{

				return iD;
		
			}

		// Getter para el iD del proyecto
		
			public String getDescripcion()
			{

				return descripcion;
		
			}

		// Getter para el iD del proyecto
		
			public String getFechaInicial()
				{

					return fechaInicial;
			
				}

		// Getter para el iD del proyecto
		
			public String getFechaFinal()
				{

					return fechaFinal;
			
				}

		// Getter para el iD del proyecto
		
		public ArrayList<Actividad> getActividades()
		{

			return actividades;
	
		}
		
		// Funcion para cargar los participantes del proyecto

			public static void cargarParticipantes(String rutaArchivo)
			{

				// Se crean variables necesarias para la carga del archivo
				// de participantes de un proyecto

					BufferedReader lector;
					String linea;
					String partes[];

				// Se crea un try en caso de que la ruta no se correcta

					try
						{

							// Se lee el archivo
							
								lector = new BufferedReader(new FileReader(rutaArchivo));
							
							// Se lee la primera linea del archivo que nombra las columnas	
							
								lector.readLine();

							// Se while para recorrer todas las lineas del archivo

								while ((linea = lector.readLine()) != null)
									{

										// Se dividen las columnas de la linea leida

											partes = linea.split(";");

										// Se crea una variable para guardar si el participante
										// de la linea leida es el dueño del proyecto

											boolean isDuenio;

											if(partes[2] == "True")
												{
													isDuenio = true;
												}
											else
												{
													isDuenio = false;
												}

										// Se obtiene el ArrayList de participantes del proyecto que se
										// esté trabajando
										
											ArrayList<Participante> participantes = Plataforma.getProyectoActual().getParticipantes();
										
										// Se crea el nuevo particiante con la información leida en la linea

											Participante participante = new Participante(partes[0], partes[1], isDuenio);
										
										// Se añade el participante creado al ArrayList de participantes
										// del proyecto

											
											participantes.add(participante);

									}

							// Se limpian las variables declaradas en el incio de la función
								
								lector.close();
								linea = null;
								partes = null;

						} catch (Exception e)
							{
								JOptionPane.showMessageDialog(null, e);
							}

			}

		// Funcion para cargar las actividades del proyecto

			public static void cargarActividades(String rutaArchivo)
			{
				
				// Se crean variables necesarias para la carga del archivo
				// de actividades de un proyecto

					BufferedReader lector;
					String linea;
					String partes[];

				// Se crea un try en caso de que la ruta no se correcta
				
					try
						{
						
							// Se lee el archivo en la ruta dada

								lector = new BufferedReader(new FileReader(rutaArchivo));
							
							// Se lee la primera linea del archivo para descartar
							// la fila que nombra las columnas

								lector.readLine();

							// Se crea un while para leer todas las lineas del archivo

								while ((linea = lector.readLine()) != null)
									{
										// Se dividen las columnas de la linea leida

											partes = linea.split(";");
									
										// Se extrae el autor de la actividad

											String autor = partes[9];

										// Se llama al ArrayList de participantes del proyecto
										// que se esté manejando	
										
											ArrayList<Participante> participantes = Plataforma.getProyectoActual().getParticipantes();

										// Se crea un for para buscar en el ArrayList de participantes
										// al participante autor de la actividad de la linea leida

											for (Participante participante : participantes) 
												{ 

													// Si se encuentra el participante

														if (participante.getNombre().equals(autor))
															{

																// Se crea la nueva actividad con la información
																// leida en la linea

																	Actividad actividad = new Actividad(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6], Long.parseLong(partes[7]), Boolean.parseBoolean(partes[8]), participante, Integer.parseInt(partes[10]));
																
																// Se extrae el ArrayList de actividades del
																// participante encontrado

																	ArrayList<Actividad> actividades = participante.getActividades();
																
																// Se añade la nueva actividad creada al 
																// ArrayList de actividades del participante	

																	actividades.add(actividad);
																	Plataforma.getProyectoActual().getActividades().add(actividad);

															}

												}

									}

							// Se limpian las variables declaradas al inicio de la función	
								
								lector.close();
								linea = null;
								partes = null;

						} catch (Exception e)
							{

								JOptionPane.showMessageDialog(null, e);
							
							}

			}

		// Funcion para crear un nuevo proyecto
		
			public static void crearProyecto(String nombre, String descripcion, String fechaInicial, String fechaFinal, int iD) throws IOException
				{

					// Se obtiene el iD para el proyecto y se crea y guarda un nuevo
					// iD para algún nuevo proyecto más adelante
					
						iD = Plataforma.getIdProyecto();
						Plataforma.modificarIdProyecto(Plataforma.getRutaIdProyectos());
						Plataforma.cargarIdProyecto(Plataforma.getRutaIdProyectos());

					// Se crea el nuevo proyecto con la información recolectada

						Proyecto proyecto = new Proyecto(nombre, descripcion, fechaInicial, fechaFinal, iD);

					// Se guarda el nuevo proyecto en el ArrayList de proyectos

						Plataforma.getProyectos().add(proyecto);

					// Se crea la carpeta del proyecto y sus archivos

						Proyecto.crearArchivoProyecto(nombre);

					// Se añade el proyecto al csv de proyectos	

						// Se obtiene la ruta donde de se encuentra el csv de proyectos

							String salidaArchivo = Plataforma.getRutaProyectos();

						// Verifica si el archivo ya existe

							boolean existe = new File(salidaArchivo).exists();
					
						// Si existe un archivo llamado asi, lo borra

							if(existe)
								{

									File archivoUsuarios = new File(salidaArchivo);
									archivoUsuarios.delete();
								
								}

						// Se crea un try por si no se encuentra la ruta dada
					
							try 
								{
								
								// Crea el archivo
								
									CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
								
								// Datos para identificar las columnas

									salidaCSV.write("nombre");
									salidaCSV.write("descripcion");
									salidaCSV.write("fechaInicial");
									salidaCSV.write("fechaFinal");
									salidaCSV.write("iD");

								// Deja de escribir en el archivo

									salidaCSV.endRecord();
								
								// Recorremos la lista y lo insertamos en el archivo
								
									for(Proyecto proyectoSelec : Plataforma.getProyectos()) 
									{

										salidaCSV.write(proyectoSelec.getNombre());
										salidaCSV.write(proyectoSelec.getDescripcion());
										salidaCSV.write(proyectoSelec.getFechaInicial());
										salidaCSV.write(proyectoSelec.getFechaFinal());
										salidaCSV.write(Integer.toString(proyectoSelec.getId()));
									
										// Deja de escribir en el archivo

											salidaCSV.endRecord(); 
									
									}
								
								salidaCSV.close(); // Cierra el archivo
								
							} catch(IOException e) {
								e.printStackTrace();
							}

				}
			
		// Función para agregar un participante al proyecto

			public static void anadirParticiante(String nombre, String correo, boolean isDuenio)
				{

					// Se crea el nuevo participante con la informacion recibida

						Participante participante = new Participante(nombre, correo, isDuenio);

					// Se extrae la lista del participantes del proyecto que se esté
					// manejando actualmente	

						ArrayList<Participante> participantes = Plataforma.getProyectoActual().getParticipantes();
					
					// Se añade el nuevo participante creado a la lista de participantes

						participantes.add(participante);

					// Actualiza el archivo de participantes con los nuevos elementos de la
					// lista de participantes

						// Verifica si existe el archivo

							String salidaArchivo = Plataforma.getRutaParticipantes();
							boolean existe = new File(salidaArchivo).exists();
					
						// Si existe un archivo llamado asi, lo borra

						if(existe)
						{
							File archivoUsuarios = new File(salidaArchivo);
							archivoUsuarios.delete();
						}

						// Se crea un try en caso de que la ruta no sea valida
					
						try 
							{

							// Crea el archivo
								CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
							
							// Datos para identificar las columnas

								salidaCSV.write("nombre");
								salidaCSV.write("correo");
								salidaCSV.write("isDuenio");
								salidaCSV.write("actividadesRealizadas");
							
							// Deja de escribir en el archivo

								salidaCSV.endRecord();
							
							// Se recorre la lista y se inserta la informacion en el archivo

							for (Participante participanteSelec : participantes) 
								{
									
									salidaCSV.write(participanteSelec.getNombre());
									salidaCSV.write(participanteSelec.getCorreo());
									salidaCSV.write(Boolean.toString(participanteSelec.getIsDuenio()));
									String iDsActividades = "";

									ArrayList<Actividad> actividadesRealizada = participanteSelec.getActividades();

									for (Actividad actividad : actividadesRealizada)
										{

											iDsActividades = iDsActividades + actividad.getId() + ".";

										}

									salidaCSV.write(iDsActividades);
								
									// Deja de escribir en el archivo

										salidaCSV.endRecord();
						
							}
							
							salidaCSV.close(); // Cierra el archivo
							
						} catch(IOException e) {
							e.printStackTrace();
						}   

				}

		// Getter para el ArrayList de tipos de actividades del proyecto

			public static ArrayList<String> getTiposActividad()
				{

					return tiposActividades;

				}

		// Función para añadir un nuevo tipo de actividad al proyecto

			public static void anadirTipoActividad(String tipoActividad)
				{
					
					// Consigue el proyecto que se esté manejando actualmente,
					// extrae el ArrayList donde se encuentran los tipos de actividad 
					// y le añade el tipo de actividad recibido en la funcion

						Plataforma.getProyectoActual().getTiposActividad().add(tipoActividad);

				}
				
		// Función para añadir una nueva actividad al proyecto
		
			public static void anadirActividad(String titulo, String descripcion, String tipo, String fechaInicial, String fechaFinal, String horaInicial, String horaFinal, String tiempoRealizacion, String isTiempoReal, String autor)
					{

						// Se crea un for para recorrer todo el ArrayList de paticipates del proycto actual
						for (Participante participante : Plataforma.getProyectoActual().getParticipantes())
								{

									// Si el participante seleccionado en el momento tiene el mismo nombre del
									// autor de la actividad

										if (participante.getNombre().equals(autor))
											{
												
												// Se obtiene el ArrayList de activisdades del participante
												// seleccionado y se le añade la nueva activiad con la
												// informacion recibida en la funcion
												
													participante.getActividades().add(new Actividad(titulo, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal, Long.parseLong(tiempoRealizacion), Boolean.parseBoolean(isTiempoReal), participante, Plataforma.getIdActividad()));
													Plataforma.getProyectoActual().getActividades().add(new Actividad(titulo, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal, Long.parseLong(tiempoRealizacion), Boolean.parseBoolean(isTiempoReal), participante, Plataforma.getIdActividad()));
													
												// Se aumenta en 1 el iD de actividades y se carga de nuevo en 
												// la variable iDActividad

													Plataforma.modificarIdActividad(Plataforma.getRutaIdActividades());
													Plataforma.cargarIdActividad(Plataforma.getRutaIdActividades());

												// Se rompe el recorrido para que no siga buscando el participante

													break;

											}

								}

						// Se añaden todas las actividades al archivo de actividades

							String salidaArchivo = Plataforma.getRutaActividades();
							boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
							
							// Si existe un archivo llamado asi lo borra
							if(existe) {
								File archivoUsuarios = new File(salidaArchivo);
								archivoUsuarios.delete();
							}
							
							try {
								// Crea el archivo
								CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
								
								// Datos para identificar las columnas
								salidaCSV.write("titulo");
								salidaCSV.write("descripcion");
								salidaCSV.write("tipo");
								salidaCSV.write("fechaInicial");
								salidaCSV.write("fechaFinal");
								salidaCSV.write("horaInicial");
								salidaCSV.write("horaFinal");
								salidaCSV.write("tiempoRealizacion");
								salidaCSV.write("isTiempoReal");
								salidaCSV.write("autor");
								salidaCSV.write("iD");
								
								salidaCSV.endRecord(); // Deja de escribir en el archivo
								
								// Recorremos la lista y lo insertamos en el archivo
								for(Actividad actividad : Plataforma.getProyectoActual().getActividades()) {
									salidaCSV.write(actividad.getTitulo());
									salidaCSV.write(actividad.getDescripcion());
									salidaCSV.write(actividad.getTipo());
									salidaCSV.write(actividad.getFechaFinal());
									salidaCSV.write(actividad.getFechaFinal());
									salidaCSV.write(Long.toString(actividad.getTiempoRelizacion()));
									salidaCSV.write(Boolean.toString(actividad.getIsTiempoReal()));
									salidaCSV.write(actividad.getAutor().getNombre());
									salidaCSV.write(Integer.toString(actividad.getId()));

									
									salidaCSV.endRecord(); // Deja de escribir en el archivo
								}
								
								salidaCSV.close(); // Cierra el archivo
								
							} catch(IOException e) {
								e.printStackTrace();
							}   

					}
				
	
	}