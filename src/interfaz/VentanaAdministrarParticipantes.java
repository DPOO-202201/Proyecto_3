package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaAdministrarParticipantes extends JFrame implements ActionListener{
	
	private JLabel lblTitulo, lblParticipante, lblNombre, lblCorreo, lblPropietario, lblDuenio;
	private JComboBox<String> cbParticipantes;
	private JTextField tfNombre,tfCorreo;
	private JButton btnGuardar, btnRegistrar;
	
	public VentanaAdministrarParticipantes() {
		setTitle("Administrar participantes");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo( null );
		setLayout(new GridLayout(4,0));
		
		lblTitulo = new JLabel("Administrar participantes", SwingConstants.CENTER);
		add(lblTitulo);
		
		JPanel panelParticipante = new JPanel();
		panelParticipante.setLayout(new GridLayout(4,1));
		
		lblParticipante = new JLabel("Participante", SwingConstants.CENTER);
		cbParticipantes = new JComboBox<String>();
		//TODO Espacio para añadir todos los participantes en combobox a traves de un ciclo
		panelParticipante.add(lblParticipante);
		panelParticipante.add(cbParticipantes);
		
		lblNombre = new JLabel("Nombre", SwingConstants.CENTER);
		tfNombre = new JTextField();
		panelParticipante.add(lblNombre);
		panelParticipante.add(tfNombre);
		
		lblCorreo = new JLabel("Correo", SwingConstants.CENTER);
		tfCorreo = new JTextField();
		panelParticipante.add(lblCorreo);
		panelParticipante.add(tfCorreo);
		
		lblPropietario = new JLabel("Propietario?", SwingConstants.CENTER);
		lblDuenio = new JLabel("No", SwingConstants.CENTER);
		//TODO Condicional para false o true si es duenio o no
		panelParticipante.add(lblPropietario);
		panelParticipante.add(lblDuenio);
		
		add(panelParticipante);
		
		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("GUARDAR");
		
		add(btnGuardar);
		
		JPanel panelAniadirParticipante = new JPanel();
		panelAniadirParticipante.setBorder(new TitledBorder("Añadir Participante"));
		
		btnRegistrar = new JButton("Registrar participante");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("REGISTRAR");
		
		panelAniadirParticipante.add(btnRegistrar);
		
		add(panelAniadirParticipante);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("GUARDAR")) {
			//TODO Guardar Cambios
			JOptionPane.showMessageDialog(null, "Se han guardado los cambios", "Guardar cambios", 1);
		}
		
		else if(comando.equals("REGISTRAR")) {
			new VentanaAniadirParticipantes().setVisible(true);
		}
	}
}