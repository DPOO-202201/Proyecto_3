// Importaciones

	package consola;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import model.Proyecto;
	import procesamiento.Plataforma;

// Clase principal

	public class Aplicacion
	{
		
		// Ejecuta la aplicación

			public void ejecutarAplicacion() throws IOException
			{

				// Se definen variables para manejar la ejecución de la
				// aplicación

					boolean continuar = true;
					boolean seleccion = false;

				// Se crea un while para seguir ejecutando la aplicación
				// mientras que el usuario no decida salir

					while (continuar)
					{

						// Se declara una variable para guardar las opciones
						// seleccionadas por el usuario de la aplicacion

							int opcion_seleccionada;

						// Si el ususario ya cargó un proyecto, se le mostrarán
						// las opciones que puede realizar con el proyecto
						// que se encuentra cargado

							if (seleccion)
							{

								// Se muestra el menú de opciones para el proyecto
									
									mostrarMenuProyecto();
								
								// Se le pide al ususario que seleccione una opción
								
									opcion_seleccionada = Integer.parseInt(Plataforma.input("\nPor favor seleccione una opcion"));

								// Se ejecuta la funcionalidad que el ususario haya seleccionado

									if (opcion_seleccionada == 1)
									{

										// Se le pide la información necesaria al usuario para crear al nuevo
										// particpante

										String nombre = Plataforma.input("Digite el nombre del participante que desea agregar");
										String correo = Plataforma.input("Digite el correo del participante que desea agregar");

										// Se añade el nuevo participante al proyecto

											Proyecto.anadirParticiante(nombre, correo, false);
										
									
									}

									if (opcion_seleccionada == 2)
									{

										// Se le pide la información necesaria al usuario para crear al nuevo
										// particpante

											String titulo = Plataforma.input("Digite un titulo la actividad");
											String descripcion = Plataforma.input("Digite un descripcion para la actividad");
											String tipo = Plataforma.input("Digite el tipo de actividad a la que pertenece esta actividad");
											String fechaInicial = Plataforma.input("Digite la fecha en la que incio la actividad con el formato DD/MM/AA");
											String fechaFinal = Plataforma.input("Digite la fecha en la que finalizo la actividad con el formato DD/MM/AA");
											String horaInicial = Plataforma.input("Digite la hora en la que incio la actividad con el formato HH/MM");
											String horaFinal = Plataforma.input("Digite la hora en la que finalizo la actividad con el formato HH/MM");
											String tiempoRealizacion = "0";
											String isTiempoReal = "false";
											String autor = Plataforma.input("Digite el nombre de la persona que realizo la actvidad");

										// Se añade la actividad al proyeto

											Proyecto.anadirActividad(titulo, descripcion, tipo, fechaInicial, fechaFinal, horaInicial, horaFinal, tiempoRealizacion, isTiempoReal, autor);

										System.out.println(Plataforma.getProyectoActual().getActividades().get(1).getTitulo());
									
									}

									if (opcion_seleccionada == 3)
									{
										
										// Se le pide la fecha al usuario

											String fechaFinal = Plataforma.input("Digite la fecha en la que finalizo la actividad con el formato DD/MM/AA");

										// Se asigna la fecha final	
										
											Proyecto.setFechaFinal(fechaFinal);
									
									}

									if (opcion_seleccionada == 4)
									{

										// Se le pide el tipo de actividad al usuario

											String tipoActividad = Plataforma.input("Digite el nombre para el nuevo tipo de actividad");
										
										// Se añade el nuevo tipo de actividad al ArrayList donde se encuentran
										// los tipos de actividad del proyecto										

											Proyecto.anadirTipoActividad(tipoActividad);	
									
									}

									if (opcion_seleccionada == 0)
									{
										System.out.println("\n"+"Saliendo del proyecto..."+"\n");
										seleccion = false;	
									}
								
							}
						
						// Si el ususario no ha cargado ningún proyecto, se le muestra las opciones
						// que tiene en este caso	

							else
							{
								
								// Se muestra el menú de las opciones

									mostrarMenuApp();
								
								// Se guarda la opción seleccionada	

									opcion_seleccionada = Integer.parseInt(Plataforma.input("\nPor favor seleccione una opcion"));

								// Se ejecuta la funcionalidad que el ususario haya seleccionado

								if (opcion_seleccionada == 1)
								{

									// Se declaran las variables necesarias

										String fechaFinal = "None";
										int iD = 0;

									// Se le pide al usuario la informacion para crear el proyecto

										String nombre = Plataforma.input("Digite el nombre del proyecto");
										String descripcion = Plataforma.input("Digite una descripcion para el proyecto");
										String fechaInicial = Plataforma.input("Digite la fecha en la que inicia el proyecto con el formato DD/MM/AA");
									
										// Se le da la opción al ususario de agregar o no la fecha final
										// para el proyecto. En caso de que no la desee agregar, se crea
										// el proyecto con fechaFinal = "None"

											System.out.println("\n¿Desea agregar ahora o después la fecha de finalizacion del proyecto?\n1. Ahora\n2. Después\n");
											String opcion = Plataforma.input("Digite el digito de la opción que desea");
											if (opcion.equals("1"))
												{
													fechaFinal = Plataforma.input("Digite la fecha en la que finaliza el proyecto con el formato DD/MM/AA");
													Proyecto.setFechaFinal(fechaFinal);
												}
											else
												{
													Proyecto.setFechaFinal("00/00/00");
												}
									
									Proyecto.crearProyecto(nombre, descripcion, fechaInicial, fechaFinal, iD);
									//System.out.println(Plataforma.getProyectos().get(1).getNombre());
								
								}

								if (opcion_seleccionada == 2)
								{

									// Se le pide al usuario el nombre del proyecto que desea cargar

										String nombreProyecto = Plataforma.input("Digite el nombre del proyecto que desea cargar");
									
									// Se carga toda la informacion del proyecto

										Plataforma.cargarProyecto(nombreProyecto);

										if (Plataforma.getProyectoActual() == null)
											{
												System.out.println("El proyecto no se ha encontrado");
											}
										else
											{
												seleccion = true;
											}

									System.out.println(Plataforma.getProyectoActual().getActividades().get(0).getDescripcion());


								}

								if (opcion_seleccionada == 0)
									{

										continuar = false;
									
									}

							}
								
					}

			}

		// Muestra al ususario el menú de opciones que tiene cuando ya
		// ha cargado un proyecto

			public void mostrarMenuProyecto()
			{

				System.out.println("\nOpciones de la aplicacion:\n");
				System.out.println("1. Agregar un nuevo participante al proyecto");
				System.out.println("2. Registrar una nueva actividad");
				System.out.println("3. Agregar una fecha final al proyecto");
				System.out.println("4. Agregar un tipo de actividad al proyecto");
				System.out.println("0. Guardar y salir del proyecto");

			}

		// Muestra al ususario el menú de opciones que tiene cuando no
		// ha cargado un proyecto
		
			public void mostrarMenuApp() 
			{

				System.out.println("\n"+" --- Menú principal --- "+"\n");
				System.out.println("1. Crear un nuevo proyecto");
				System.out.println("2. Cargar un proyecto");
				System.out.println("0. Salir");
				
			}

		// Función main

			public static void main(String[] args) throws IOException
			{

				Aplicacion aplicacion = new Aplicacion();

				Plataforma.cargarIdActividad(Plataforma.getRutaIdActividades());
				Plataforma.cargarIdProyecto(Plataforma.getRutaIdProyectos());

				Plataforma.cargarProyectos(Plataforma.getRutaProyectos());
				System.out.println(Plataforma.getProyectos().get(0).getNombre());

				aplicacion.ejecutarAplicacion();

			}

	}