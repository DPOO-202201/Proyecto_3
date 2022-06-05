package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaAniadirParticipantes extends JFrame implements ActionListener{
	private JLabel lblTitulo, lblNombre, lblCorreo;
	private JTextField tfNombre,tfCorreo;
	private JButton btnRegistrar;
	
	public VentanaAniadirParticipantes() {
		setTitle("Aniadir participante");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo( null );
		setLayout(new GridLayout(3,0));
		
		lblTitulo = new JLabel("Añadir participante", SwingConstants.CENTER);
		add(lblTitulo);
		
		JPanel panelParticipante = new JPanel();
		panelParticipante.setLayout(new GridLayout(3,1));
		
		lblNombre = new JLabel("Nombre", SwingConstants.CENTER);
		tfNombre = new JTextField();
		panelParticipante.add(lblNombre);
		panelParticipante.add(tfNombre);
		
		lblCorreo = new JLabel("Correo", SwingConstants.CENTER);
		tfCorreo = new JTextField();
		panelParticipante.add(lblCorreo);
		panelParticipante.add(tfCorreo);
		
		add(panelParticipante);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("REGISTRAR");
		
		add(btnRegistrar);
	}
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("REGISTRAR")) {
			//TODO Guardar Cambios
			JOptionPane.showMessageDialog(null, "Registrado exitosamente", "Guardar cambios", 1);
			JOptionPane.showMessageDialog(null, "No se pudo registrar", "Guardar cambios", 0);
		}
	}
}