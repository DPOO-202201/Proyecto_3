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
public class VentanaAdministrarActividades extends JFrame implements ActionListener{
	 private JLabel lblTitulo,lblAutor,lblActividad,lblDescripcion,lblTipoActividad,lblFecha,lblHora;
	 private JTextField tfDescripcion, tfTipoActividad, tfFecha, tfHora;
	 private JButton btnGuardar,btnRegistrar,btnCronometrar;
	 private JComboBox<String> cbAutor,cbActividad;
	 private JPanel pAutor, pActividad, pDescripcion, pTipoActividad, pFecha, pHora, pBotones;
	 
	 public VentanaAdministrarActividades() {
		 setTitle("Administrar actividades");
		 setSize(500,800);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 
		 setLayout(new GridLayout(9,1));
		 
		 lblTitulo = new JLabel("Administrar actividades", SwingConstants.CENTER);
		 add(lblTitulo);
		 
		 pAutor = new JPanel();
		 pAutor.setLayout(new GridLayout(1,1));
		 lblAutor = new JLabel("Autor", SwingConstants.CENTER);
		 pAutor.add(lblAutor);
		 cbAutor = new JComboBox<String>();
		 //TODO Ciclo para añadir todos los participantes
		 pAutor.add(cbAutor);
		 add(pAutor);
		 
		 pActividad = new JPanel();
		 pActividad.setLayout(new GridLayout(1,1));
		 lblActividad = new JLabel("Actividad", SwingConstants.CENTER);
		 pActividad.add(lblActividad);
		 cbActividad= new JComboBox<String>();
		 //TODO Ciclo para añadir todas las actividades del participante
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
		 
		 pHora = new JPanel();
		 pHora.setLayout(new GridLayout(1,1));
		 lblHora = new JLabel("Hora finalizacion", SwingConstants.CENTER);
		 pHora.add(lblHora);
		 tfHora = new JTextField();
		 pHora.add(tfHora);
		 add(pHora);
		 
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
		 btnCronometrar = new JButton("Cronometrar actividad");
		 btnCronometrar.addActionListener(this);
		 btnCronometrar.setActionCommand("CRONOMETAR");
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
	
			}
	 }
}