package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaCronometrarActividad extends JFrame implements ActionListener{
	 private JLabel lblTitulo,lblAutor,lblActividad,lblDescripcion,lblTipoActividad,lblFecha,lblTiempo;
	 private JTextField tfDescripcion, tfTipoActividad, tfFecha, tfTiempo;
	 private JButton btnGuardar,btnRegistrar,btnCronometrar;
	 private JComboBox<String> cbAutor,cbActividad;
	 private JPanel pAutor, pActividad, pDescripcion, pTipoActividad, pFecha, pTiempo, pBotones;
	 
	 public VentanaCronometrarActividad() {
		 setTitle("Cronometrar actividad");
		 setSize(500,800);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 
		 setLayout(new GridLayout(9,1));
		 
		 lblTitulo = new JLabel("Cronometrar actividad", SwingConstants.CENTER);
		 add(lblTitulo);
		 
		 pAutor = new JPanel();
		 pAutor.setLayout(new GridLayout(1,1));
		 lblAutor = new JLabel("Autor", SwingConstants.CENTER);
		 pAutor.add(lblAutor);
		 cbAutor = new JComboBox<String>();
		 //TODO Ciclo para a�adir todos los participantes
		 pAutor.add(cbAutor);
		 add(pAutor);
		 
		 pActividad = new JPanel();
		 pActividad.setLayout(new GridLayout(1,1));
		 lblActividad = new JLabel("Actividad", SwingConstants.CENTER);
		 pActividad.add(lblActividad);
		 cbActividad= new JComboBox<String>();
		 //TODO Ciclo para a�adir todas las actividades del participante
		 pActividad.add(cbActividad);
		 add(pActividad);
		 
		 pDescripcion = new JPanel();
		 pDescripcion.setLayout(new GridLayout(1,1));
		 lblDescripcion = new JLabel("Descripcion", SwingConstants.CENTER);
		 pDescripcion.add(lblDescripcion);
		 tfDescripcion = new JTextField();
		 pDescripcion.add(tfDescripcion);
		 add(pDescripcion);
		 
		 pTipoActividad = new JPanel();
		 pTipoActividad.setLayout(new GridLayout(1,1));
		 lblTipoActividad = new JLabel("Tipo de actividad", SwingConstants.CENTER);
		 pTipoActividad.add(lblTipoActividad);
		 tfTipoActividad= new JTextField();
		 pTipoActividad.add(tfTipoActividad);
		 add(pTipoActividad);
		 
		 pFecha = new JPanel();
		 pFecha.setLayout(new GridLayout(1,1));
		 lblFecha= new JLabel("Fecha", SwingConstants.CENTER);
		 pFecha.add(lblFecha);
		 tfFecha= new JTextField();
		 pFecha.add(tfFecha);
		 add(pFecha);
		 
		 pTiempo = new JPanel();
		 pTiempo.setLayout(new GridLayout(1,1));
		 lblTiempo = new JLabel("Tiempo", SwingConstants.CENTER);
		 pTiempo.add(lblTiempo);
		 tfTiempo = new JTextField();
		 pTiempo.add(tfTiempo);
		 add(pTiempo);
		 
		 btnGuardar = new JButton("Guardar cambios");
		 btnGuardar.addActionListener(this);
		 btnGuardar.setActionCommand("GUARDAR");
		 add(btnGuardar);
		 
		 pBotones = new JPanel();
		 pBotones.setLayout(new GridLayout(1,1));
		 pBotones.setBorder(new TitledBorder("Crear actividades"));
		 btnRegistrar= new JButton("Registrar actividad");
		 btnRegistrar.addActionListener(this);
		 btnRegistrar.setActionCommand("REGISTRAR");
		 
		 btnCronometrar = new JButton("Iniciar cronometro");
		 btnCronometrar.addActionListener(this);
		 btnCronometrar.setActionCommand("CRONOMETAR");
		 
		 btnCronometrar = new JButton("Detener cronometro");
		 btnCronometrar.addActionListener(this);
		 btnCronometrar.setActionCommand("PARAR");
		 
		 pBotones.add(btnRegistrar);
		 pBotones.add(btnCronometrar);
		 add(pBotones); 
	 }
	 
	 public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			if(comando.equals("GUARDAR")) {
				
			}
			
			if(comando.equals("REGISTRAR")) {
				
			}

			if(comando.equals("CRONOMETRAR")) {
				new VentanaCronometrarActividad().setVisible(true);
			}
	 }
}