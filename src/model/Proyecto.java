// Importaciones

	package model;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
	import javax.swing.JOptionPane;
	import com.csvreader.CsvWriter;
	import procesamiento.Plataforma;

// Clase principal	

	public class Proyecto
	{
		
		// Atributos

			private String nombre;
			private String descripcion;
			private String fechaInicial;
			private static String fechaFinal;
			private int iD;
			private static ArrayList<String> tiposActividades;
			private static ArrayList<Participante> participantes = new ArrayList<Participante>();
			private static ArrayList<Actividad> actividades = new ArrayList<Actividad>();
			private ArrayList<Tarea> WBS = new ArrayList<Tarea>();

		// Constructor	
		
			public Proyecto
				(
					String nombre,
					String descripcion,
					String fechaInicial,
					String fechaFinal,
					int iD
				)
					{

						this.nombre = nombre;
						this.descripcion = descripcion;
						this.fechaInicial = fechaInicial;
						this.iD = iD;
						tiposActividades = new ArrayList<String>();
						participantes = new ArrayList<Participante>();
						WBS = new ArrayList<Tarea>();

						
					}

		// Función para crear la carpeta del proyecto en la carpeta
		// data/Proyectos

			public static void crearArchivoProyecto(String nombreProyecto) throws IOException 
			{	
				String carpetaUbicacion = "./././data/Proyectos/" + nombreProyecto;
				File carpeta = new File(carpetaUbicacion);
				carpeta.mkdirs();
			}
		
		// Getter para los participantes del proyecto	
		
			public static ArrayList<Participante> getParticipantes()
				{
					return participantes;
				}			

		// Getter para el atributo nombre

			public String getNombre()
				{
					return nombre;
				}

		// Getter para el atributo iD
		
			public int getId()
			{
				return iD;
			}

		// Getter para el atributo descripcion
		
			public String getDescripcion()
				{
					return descripcion;
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

		// Getter para el atributo actividades
		
			public ArrayList<Actividad> getActividades()
			{
				return actividades;
			}

		// Getter para el atributo actividades
		
			public ArrayList<Tarea> getWBS()
				{
					return WBS;
				}
		
		// Getter para el atributo tiposActividad

			public static ArrayList<String> getTiposActividad()
			{
				return tiposActividades;
			}
		
		// Setter para la fecha final del proyecto
		
			public static void setFechaFinal(String fechaFinall)
			{
				fechaFinal = fechaFinall;
			}
		
		// Metodo para cargar los participantes del proyecto en el atributo
		// participantes

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
							
							// Se lee la primera linea del archivo que nombra
							// las columnas	
							
								lector.readLine();

							// Se while para recorrer todas las lineas del
							// archivo

								while (((linea = lector.readLine()) != null) && (linea != ""))
									{

										// Se dividen las columnas de la linea leida

											partes = linea.split(";");

										// Se crea una variable para guardar si el participante
										// de la linea leida es el dueño del proyecto

											boolean isDuenio;

											if(partes[2] == "true")
												{
													isDuenio = true;
												}
											else
												{
													isDuenio = false;
												}

										// Se obtiene el ArrayList de participantes del proyecto
										// que se esté trabajando
										
											ArrayList<Participante> participantes = Plataforma.getProyectoActual().getParticipantes();
										
										// Se crea el nuevo particiante con la información leida
										// en la linea

											Participante participante = new Participante(partes[0], partes[1], isDuenio);
										
										// Se añade el participante creado al ArrayList de
										// participantes del proyecto

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

		// Metodo para cargar las actividades del proyecto

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

							// Se crea un while para leer todas las lineas del
							// archivo

								while (((linea = lector.readLine()) != null) && (linea != ""))
									{
										// Se dividen las columnas de la linea
										// leida

											partes = linea.split(";");
									
										// Se extrae el autor de la actividad

											String autor = partes[9];

										// Se llama al ArrayList de participantes
										// del proyecto que se esté manejando	
										
											ArrayList<Participante> participantes = Plataforma.getProyectoActual().getParticipantes();

										// Se crea un for para buscar en el
										// ArrayList de participantes al
										// participante autor de la actividad de
										// la linea leida

											for (Participante participante : participantes) 
												{ 

													// Si se encuentra el
													// participante

														if (participante.getNombre().equals(autor))
															{

																// Se crea la nueva
																// actividad con la
																// información leida
																// en la linea

																	Actividad actividad = new Actividad(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6], Long.parseLong(partes[7]), Boolean.parseBoolean(partes[8]), participante, Integer.parseInt(partes[10]));

																// Se anexa el tipo de actividad 
																// al ArrayList de tipos de actividad
																// en caso de que no se encuentre

																	if (!(tiposActividades.contains(partes[2])))
																		{
																			tiposActividades.add(partes[2]);
																		}
																
																// Se extrae el ArrayList
																// de actividades del
																// participante encontrado

																	ArrayList<Actividad> actividades = participante.getActividades();
																
																// Se añade la nueva
																// actividad creada al 
																// ArrayList de actividades
																// del participante	

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

		// Metodo para crear un nuevo proyecto
		
			public static void crearProyecto(String nombre, String descripcion, String fechaInicial, String fechaFinal, int iD) throws IOException
				{

					// Se obtiene el iD para el proyecto y se crea y guarda
					// un nuevo iD para algún nuevo proyecto más adelante
					
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

						// Se obtiene la ruta donde de se encuentra el csv de
						// proyectos

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

											salidaCSV.endRecord(); // Deja de escribir en el archivo
										
										}
									
									salidaCSV.close(); // Cierra el archivo
								
								} 
								catch(IOException e) 
									{
										e.printStackTrace();
									}

				}
			
		// Metodo para agregar un participante al proyecto

			public static void anadirParticiante(String nombre, String correo, boolean isDuenio)
				{

					// Se crea el nuevo participante con la informacion recibida

						Participante participante = new Participante(nombre, correo, isDuenio);

					// Se extrae la lista del participantes del proyecto que
					// se esté manejando actualmente	

						ArrayList<Participante> participantes = Plataforma.getProyectoActual().getParticipantes();
					
					// Se añade el nuevo participante creado a la lista de 
					// participantes

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
								
									CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
								
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
													System.out.println(iDsActividades);

												}

											salidaCSV.write(iDsActividades);
										
											// Deja de escribir en el archivo

												salidaCSV.endRecord();
							
										}

									salidaCSV.close(); // Cierra el archivo

							
							} 
							catch(IOException e) 
								{
									e.printStackTrace();
								}   

				}
		
		// Metodo para añadir una nueva actividad al proyecto
		
			public static void anadirActividad(String titulo, String descripcion, String tipo, String fechaInicial, String fechaFinal, String horaInicial, String horaFinal, String tiempoRealizacion, String isTiempoReal, String autor)
					{

						// Se crea una variable para saber si existe el tipo de actividad ingresado

							boolean existeTipoActividad = tiposActividades.contains(tipo);

						// Se crea una variable para saber si existe un participante con el nombre del
						// autor ingresado para esta nueva actividad

							boolean existeParticipante = false;

						// Se crea un for para recorrer todo el ArrayList de paticipates del proycto actual

							for (Participante participante : Plataforma.getProyectoActual().getParticipantes())
									{

										// Si el participante seleccionado en el momento tiene el mismo nombre del
										// autor de la actividad

											if (participante.getNombre().equals(autor))
												{

													existeParticipante = true;
													
													// Se obtiene el ArrayList de activisdades del participante
													// seleccionado y se le añade la nueva activiad con la
													// informacion recibida en la funcion
													
														participante.getActividades().add(new Actividad(titulo, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal, Long.parseLong(tiempoRealizacion), Boolean.parseBoolean(isTiempoReal), participante, Plataforma.getIdActividad()));
														int iD = Plataforma.getIdActividad();
														Plataforma.getProyectoActual().getActividades().add(new Actividad(titulo, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal, Long.parseLong(tiempoRealizacion), Boolean.parseBoolean(isTiempoReal), participante, iD));
														
													// Se aumenta en 1 el iD de actividades y se carga de nuevo en 
													// la variable iDActividad

														Plataforma.modificarIdActividad(Plataforma.getRutaIdActividades());
														Plataforma.cargarIdActividad(Plataforma.getRutaIdActividades());

													// Se rompe el recorrido para que no siga buscando el participante

														break;

												}

									}

						// Si se encuentra un participante con el nombre del autor ingresado			

							if (existeParticipante && existeTipoActividad)
								{

									// Se añaden todas las actividades al archivo de actividades

										String salidaArchivo = Plataforma.getRutaActividades();
										boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
									
									// Si existe un archivo llamado asi lo borra

										if(existe) 
										{

											File archivoUsuarios = new File(salidaArchivo);
											archivoUsuarios.delete();

										}
									
									try 
									{

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
										for(Actividad actividad : Plataforma.getProyectoActual().getActividades())
											{
												
												salidaCSV.write(actividad.getTitulo());
												salidaCSV.write(actividad.getDescripcion());
												salidaCSV.write(actividad.getTipo());
												salidaCSV.write(actividad.getFechaFinal());
												salidaCSV.write(actividad.getFechaFinal());
												salidaCSV.write(actividad.getHoraInicial());
												salidaCSV.write(actividad.getHoraFinal());
												salidaCSV.write(Long.toString(actividad.getTiempoRelizacion()));
												salidaCSV.write(Boolean.toString(actividad.getIsTiempoReal()));
												salidaCSV.write(actividad.getAutor().getNombre());
												salidaCSV.write(Integer.toString(actividad.getId()));

												
												salidaCSV.endRecord(); // Deja de escribir en el archivo

											}
										
										salidaCSV.close(); // Cierra el archivo

										Plataforma.actualizarParticipantes(Plataforma.getRutaParticipantes());
										
									} 
									catch(IOException e) 
										{
											e.printStackTrace();
										}

								} 
	
						// Si no se encuentra un participante con el nombre del autor ingresado
						
							else
								{

									System.out.println("\nNo se ha encontrado un participante con el nombre de autor ingresado o no se ha encontrada o el tipo de actividad ingresado no existe.");

								}

					}
	
		// Metodo para añadir un nuevo tipo de actividad al proyecto

			public static void anadirTipoActividad(String tipoActividad)
				{
					
					// Consigue el proyecto que se esté manejando actualmente,
					// extrae el ArrayList donde se encuentran los tipos de actividad 
					// y le añade el tipo de actividad recibido en la funcion

						Plataforma.getProyectoActual().getTiposActividad().add(tipoActividad);

				}

		// Metodo para generar un reporte del proyecto

			public static void generarReporte()
				{

					// Verifica si existe un archivo de reporte

						String salidaArchivo = Plataforma.getRutaReporte();
						boolean existe = new File(salidaArchivo).exists(); 
						
					// Si existe un archivo llamado asi lo borra

						if(existe) 
							{
								File archivoUsuarios = new File(salidaArchivo);
								archivoUsuarios.delete();
							}
						
						try 
							{

								// Crea el archivo
								
									CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
							
								// Datos para identificar las columnas

									salidaCSV.write("Nombre");
									salidaCSV.write("Cantidad de actividades");

									for (String tipo : tiposActividades)
										{
											salidaCSV.write("Cantidad de actividades de tipo " + tipo);
										}

									salidaCSV.write("Tiempo total invertido");
									salidaCSV.write("Tiempo promedio por actividad");
							
								salidaCSV.endRecord(); // Deja de escribir en el archivo
							
								// Recorremos la lista y lo insertamos en el archivo
								for(Participante participante : Plataforma.getProyectoActual().getParticipantes())
									{

										Map<String, String> conteo = new HashMap<>();
										int tiempoTotal = 0;
									
										salidaCSV.write(participante.getNombre());
										salidaCSV.write(Integer.toString(participante.getActividades().size()));

										for (String tipo : tiposActividades)
											{
												if (!(conteo.containsKey(tipo)))
													{
														conteo.put(tipo, "0");
													}
												for (Actividad actividad : participante.getActividades())
													{
														tiempoTotal = (int) (tiempoTotal + actividad.getTiempoRelizacion());
														if (actividad.getTipo().equals(tipo))
															{
																conteo.put(actividad.getTipo(), Integer.toString(Integer.parseInt(conteo.get(actividad.getTipo())) + 1));
															}
													}
											}

										
										salidaCSV.write(participante.getNombre());
										salidaCSV.write(Integer.toString(participante.getActividades().size()));

										for (String tipo : tiposActividades)
											{
												salidaCSV.write(conteo.get(tipo));
											}

										salidaCSV.write(Integer.toString(tiempoTotal));
										salidaCSV.write(Double.toString(tiempoTotal / participante.getActividades().size()));
									
										salidaCSV.endRecord(); // Deja de escribir en el archivo

									}
							
								salidaCSV.close(); // Cierra el archivo
							
							} 
							catch(IOException e) 
								{
									e.printStackTrace();
								}

				}

		// Metodo para añadir una tarea al proyecto

				public void anadirTarea
				(

					String nombre,
					String descripcion,
					String tipo,
					String fechaInicial,
					String fechaFinal,
					String horaInicial,
					String horaFinal

				)

					{

						// Se llama el iD de tarea disponible
							
							int iD = Plataforma.getIdTarea();
						
						// Se añade la tarea a la WBS

							WBS.add(new Tarea(iD, nombre, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal));

						// Se crea un nuevo iD y guarda para la proxima tarea

							Plataforma.modificarIdTarea(Plataforma.getRutaIdTareas());
							Plataforma.cargarIdTarea(Plataforma.getRutaIdTareas());

						// Se añaden todas las actividades al archivo de actividades

								String salidaArchivo = Plataforma.getRutaTareas();
								boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
								
								// Si existe un archivo llamado asi lo borra

									if(existe) 
									{

										File archivoUsuarios = new File(salidaArchivo);
										archivoUsuarios.delete();

									}
								
								try 
								{

									// Crea el archivo
										
										CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
									
									// Datos para identificar las columnas

										salidaCSV.write("iD");
										salidaCSV.write("nombre");
										salidaCSV.write("descripcion");
										salidaCSV.write("tipo");
										salidaCSV.write("autores");
										salidaCSV.write("fechaInicial");
										salidaCSV.write("fechaFinal");
										salidaCSV.write("horaInicial");
										salidaCSV.write("horaFinal");
										salidaCSV.write("actividades");
										salidaCSV.write("subTareas");
									
									salidaCSV.endRecord(); // Deja de escribir en el archivo
									
									// Recorremos la lista y lo insertamos en el archivo
									for(Tarea tarea : Plataforma.getProyectoActual().getWBS())
										{
											
											salidaCSV.write(Integer.toString(tarea.getId()));
											salidaCSV.write(tarea.getNombre());
											salidaCSV.write(tarea.getDescripcion());
											salidaCSV.write(tarea.getTipo());

											String autores = "";
											for (Participante autor : tarea.getAutores())
												{
													autores = autores + autor.getNombre() + ".";
												}
											salidaCSV.write(autores);

											salidaCSV.write(tarea.getFechaFinal());
											salidaCSV.write(tarea.getFechaFinal());
											salidaCSV.write(tarea.getHoraInicial());
											salidaCSV.write(tarea.getHoraFinal());

											String actividades = ""; 

											salidaCSV.write(actividades);
											salidaCSV.write(tarea);

											
											salidaCSV.endRecord(); // Deja de escribir en el archivo

										}
									
									salidaCSV.close(); // Cierra el archivo

									Plataforma.actualizarParticipantes(Plataforma.getRutaParticipantes());
									
								} 
								catch(IOException e) 
									{
										e.printStackTrace();
									}

					}

	}