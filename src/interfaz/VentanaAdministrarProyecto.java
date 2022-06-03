package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaAdministrarProyecto extends JFrame implements ActionListener
{
	private JLabel lblTitulo, lblNombre, lblDescripcion, lblFechaInicial, lblFechaFinal, lblID, lblIDProyecto, lblMovimiento;
	private JTextField tfNombre, tfDescripcion, tfFechaInicial, tfFechaFinal;
	private JButton btnGuardar, btnParticipantes, btnTiposActividades, btnActividades, btnReporte;
	
	public VentanaAdministrarProyecto() {
		setTitle("Administrar proyecto");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cerrar solo ventana
		setLocationRelativeTo( null );
		
		setLayout(new GridLayout(4,0));
		
		lblTitulo = new JLabel("Administrar proyecto", SwingConstants.CENTER); //texto centrado
		add(lblTitulo);
		
		JPanel panelPropiedades = new JPanel(); //panel que tendra datos y matriz
		panelPropiedades.setLayout(new GridLayout(1,2));
		
		JPanel panelDatos = new JPanel(); //panel que tendra objetos relacionados con los datos del proyecto
		panelDatos.setLayout(new GridLayout(5,2));
		
		lblNombre = new JLabel("Nombre", SwingConstants.CENTER); //label y textfield del nombre
		tfNombre = new JTextField();
		panelDatos.add(lblNombre);
		panelDatos.add(tfNombre);
		
		lblDescripcion = new JLabel("Descripcion", SwingConstants.CENTER); //label y textfield de la descripcion
		tfDescripcion = new JTextField();
		panelDatos.add(lblDescripcion);
		panelDatos.add(tfDescripcion);
		
		lblFechaInicial = new JLabel("Fecha inicial", SwingConstants.CENTER); //label y textfield de la fecha inicial
		tfFechaInicial = new JTextField();
		panelDatos.add(lblFechaInicial);
		panelDatos.add(tfFechaInicial);
		
		lblFechaFinal = new JLabel("Fecha final", SwingConstants.CENTER); //label y textfield de la fecha final
		tfFechaFinal = new JTextField();
		panelDatos.add(lblFechaFinal);
		panelDatos.add(tfFechaFinal);
		
		lblID = new JLabel("ID", SwingConstants.CENTER); //labels del id
		lblIDProyecto = new JLabel("0"); //TODO Aqui va el id del proyecto
		panelDatos.add(lblID);
		panelDatos.add(lblIDProyecto);
		
		panelPropiedades.add(panelDatos);
		
		JPanel panelMovimiento = new JPanel(); //Panel que tendra la matriz de actividad
		panelMovimiento.setLayout(new GridLayout(2,0));
		lblMovimiento = new JLabel("Movimiento del proyecto", SwingConstants.CENTER);
		panelMovimiento.add(lblMovimiento);
		panelMovimiento.add(new JLabel("Movimiento del proyecto", SwingConstants.CENTER));//TODO Agregar matriz de actividad
		
		panelPropiedades.add(panelMovimiento);
		
		add(panelPropiedades);
		
		btnGuardar = new JButton("Guardar"); //propiedades para el boton de guardar cambios
		btnGuardar.addActionListener(this); //aniadir actionlistener a el boton para asignar comando
		btnGuardar.setActionCommand("GUARDAR"); //el comando que se asignara
		add(btnGuardar);
		
		JPanel panelBotones = new JPanel(); //Panel que tendra los botones relacionados con manejar participantes, actividades, tipos de actividades y reporte
		panelBotones.setLayout(new GridLayout(1,4));
		panelBotones.setBorder(new TitledBorder("Opciones")); //Dividir grupo del resto de objetos con un borde con titulo
				
		btnParticipantes = new JButton("Mostrar participantes"); //parecido a boton guardar pero acciona ventana para mostrar participantes
		btnParticipantes.addActionListener(this);
		btnParticipantes.setActionCommand("PARTICIPANTES");
		panelBotones.add(btnParticipantes);
		
		btnTiposActividades = new JButton("Mostrar tipos de actividades"); //acciona la ventana de tipos de actividades
		btnTiposActividades.addActionListener(this);
		btnTiposActividades.setActionCommand("TIPOS");
		panelBotones.add(btnTiposActividades);
		
		btnActividades = new JButton("Mostrar actividades"); //acciona la ventana de las actividades
		btnActividades.addActionListener(this);
		btnActividades.setActionCommand("ACTIVIDADES");
		panelBotones.add(btnActividades);
		
		btnReporte = new JButton("Generar reporte"); //acciona el procedimiento de generar un reporte
		btnReporte.addActionListener(this);
		btnReporte.setActionCommand("REPORTE");
		panelBotones.add(btnReporte);
		
		add(panelBotones); //añade el grupo de botones a la ventana
	}
	
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			if(comando.equals("GUARDAR")) { //si el usuario quiere guardar
				
			}
			
			if(comando.equals("PARTICIPANTES")) { //si el usuario quiere ver los datos de los participantes
				new VentanaAdministrarParticipantes().setVisible(true);
			}
			
			if(comando.equals("TIPOS")) { //si el usuario quiere ver el menu de tipos de actividades
				new VentanaRevisarTiposActividades().setVisible(true);
			}
			
			if(comando.equals("ACTIVIDADES")) { //si el usuario quiere ver el menu de actividades
				new VentanaAdministrarActividades().setVisible(true);
			}
			
			if(comando.equals("REPORTE")) { //si el usuario quiere generar un reporte
				
			}
	}

}