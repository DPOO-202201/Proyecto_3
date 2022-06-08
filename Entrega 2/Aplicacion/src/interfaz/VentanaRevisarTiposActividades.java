package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaRevisarTiposActividades extends JFrame implements ActionListener{
	private JLabel lblTitulo;
	private JPanel pTipos,pBotones;
	private JButton btnModificar, btnCrear;
	private JList lstTiposActividad;
	
	public VentanaRevisarTiposActividades() {
		setTitle("Tipos de actividades");
		setSize(900,900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //cerrar solo la ventana, no toda la aplicacion
		setLocationRelativeTo(null);
		
		lblTitulo = new JLabel("Tipos de actividades", SwingConstants.CENTER); //label ocn el titulo, puesto en el centro en la aprte de arriba del jframe
		add(lblTitulo,BorderLayout.NORTH);
		
		pTipos = new JPanel(); //nuevo panel que tendra todos los tipos existentes en varios Jlabels
		//TODO Ciclo para agregar todos los tipos de actividades
		add(pTipos,BorderLayout.WEST);
		
		pBotones = new JPanel(); //nuevo panel para los botones
		pBotones.setLayout(new GridLayout(1,1));
		
		/*
		btnModificar = new JButton("Modificar tipos de actividad"); //Boton para modificar tipos, con comanti y listener
		btnModificar.addActionListener(this); //listener
		btnModificar.setActionCommand("MODIFICAR"); //comando
		pBotones.add(btnModificar); //anaidir a panel botones
		*/
		btnCrear = new JButton("Crear tipo de actividad"); //boton para crear tipos, funciona igual que el anterior
		btnCrear.addActionListener(this);
		btnModificar.setActionCommand("CREAR");
		pBotones.add(btnCrear);
		
		add(pBotones,BorderLayout.EAST);//aniadir botones a jframe
	}
	
	public void actionPerformed( ActionEvent e ) {
        String comando = e.getActionCommand( );
        
        if(comando.equals( "MODIFICAR" )) //Si el usuario quiere modificar los tipos de actividad
        {
            
        }
        else if(comando.equals( "CREAR" )) //Si el usuario quiere crear un nuevo tipo de actividad
        {
        	String nuevoTipoActividad = JOptionPane.showInputDialog(null, "Digite la nueva actividad que quiere crear.", "Crear tipo de actividad", 3);
        	//TODO Funcion para crear la nueva actividad
        }        
    }
}