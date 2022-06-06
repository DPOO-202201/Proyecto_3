package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import procesamiento.Plataforma;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener {
	
	boolean continuar = true;
	boolean seleccion = false;
	
	private JLabel lblTitulo;
	
	public VentanaPrincipal() {
		setSize(200,120);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setResizable(false);
		setLocationRelativeTo( null );
		setTitle("Manejador de proyectos");
		setLayout( new BorderLayout( ) );
		
		lblTitulo = new JLabel ("Manejador de proyectos", SwingConstants.CENTER);
		add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel();
		
		//Creacion btn crear proyecto
		JButton btnCrearProyecto = new JButton("Crear Proyecto"); //creacion
		btnCrearProyecto.setBounds(60, 60, 60, 60); //limites
		btnCrearProyecto.addActionListener(this); //para que pueda detectar si lo seleccionan
		btnCrearProyecto.setActionCommand("CREAR"); //Que es lo que hara cuando lo selecciones
		
		JButton btnCargarProyecto = new JButton("Cargar Proyecto");
		btnCargarProyecto.setBounds(60, 60, 60, 60);
		btnCargarProyecto.addActionListener(this); //para que pueda detectar si lo seleccionan
		btnCargarProyecto.setActionCommand("CARGAR"); //Que es lo que hara cuando lo selecciones
		
		panelBotones.add(btnCrearProyecto);
		panelBotones.add(btnCargarProyecto);
		
		add(panelBotones); //aniadio botones a la interfaz
	}
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("CREAR")) {
			new VentanaCrearProyecto().setVisible(true); //Crear la ventana de los datos del proyecto y mostarla
		}
		if(comando.equals("CARGAR")) {
			Boolean ingresando = true; //Mientras se intente ingresar a un proyecto
			//Boolean ingresado = false;
			//Boolean ventanaCreada = false;
			while (ingresando) {
				String tempNombreProyecto = JOptionPane.showInputDialog(null,"Digite el nombre del proyecto a cargar:"); //input
				
				try { //Si no ha cancelado el proceso
					
					if (tempNombreProyecto.equals("")) { //Si no escribio un nombre
						JOptionPane.showMessageDialog(null,"Debe digitar un nombre.");
					}
					
					else {
						Plataforma.cargarProyecto(tempNombreProyecto); // Se carga toda la informacion del proyecto

						if (Plataforma.getProyectoActual() == null) {
							JOptionPane.showMessageDialog(null,"El proyecto no se ha encontrado");
						}
						else {
							//setVisible(false);
							ingresando = false;
							new VentanaAdministrarProyecto().setVisible(true);
							//ventanaCreada = true;
						}
					}
				}
				catch (Exception e1) { //Si cancela el procedimiento
					ingresando = false;
					JOptionPane.showMessageDialog(null,"Ha cancelado la carga del proyecto");
				}
			}			
		}		
	}
	
	public static void main (String[] args)
    {
        VentanaPrincipal  ventana = new  VentanaPrincipal( );
        
		Plataforma.cargarIdActividad(Plataforma.getRutaIdActividades());
		Plataforma.cargarIdProyecto(Plataforma.getRutaIdProyectos());
		Plataforma.cargarProyectos(Plataforma.getRutaProyectos());
        
        ventana.setVisible( true );
    }
}