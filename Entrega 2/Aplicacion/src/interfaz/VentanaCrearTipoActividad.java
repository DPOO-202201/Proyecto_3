package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaCrearTipoActividad extends JFrame{

	private JLabel titulo;
	private JPanel panelCrear;
	private JButton btnCrearTipo;
	private JTextField txtFieldTipo;
	
	public VentanaCrearTipoActividad() {
		
		setTitle("Crear tipo de actividad");
		setSize(500,250);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        titulo = new JLabel("Crear tipo de actividad",SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        add(titulo,BorderLayout.NORTH);
        
        panelCrear = new JPanel();
        panelCrear.setLayout(new GridLayout(6,3));
        add(panelCrear,BorderLayout.CENTER);
        
        txtFieldTipo = new JTextField();
        
        btnCrearTipo = new JButton("CREAR");
        
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        
        panelCrear.add(new JLabel("Nombre del nuevo tipo:"));
        panelCrear.add(txtFieldTipo);
        panelCrear.add(new JLabel("		"));
        
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(btnCrearTipo);
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        panelCrear.add(new JLabel("		"));
        
	}
	
	public static void main(String[] args) {
		
		VentanaCrearTipoActividad ventana = new VentanaCrearTipoActividad();
		ventana.setVisible(true);
		
	}

}
