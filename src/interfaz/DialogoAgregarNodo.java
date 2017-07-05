package interfaz;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DialogoAgregarNodo extends JFrame{
	private static DialogoAgregarNodo _instancia;
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String _nombreNodo;
	@SuppressWarnings("unused")
	private double _latitud;
	@SuppressWarnings("unused")
	private double _longitud;
	private ArrayList<JLabel> _etiquetas = new ArrayList<>();
	private ArrayList<JTextField> _textoInput = new ArrayList<>();
	private ArrayList<JButton> _botones = new ArrayList<>();
	
	
	private  DialogoAgregarNodo(){
		super("Agregar nodo");
		iniciar();
	}
	static{
		_instancia = new DialogoAgregarNodo();
	}
	public static DialogoAgregarNodo getInstancia(){
		return _instancia;
	}
	
	private void iniciar(){
		setBounds(500, 200, 300, 250);
		getContentPane().setLayout(null);
		
		cargarEtiquetas();
		cargarInputText();
		cargarBotones();
		mouseClicked();

	}
	private void cargarEtiquetas() {
		String[] nombres = {"Nombre:", "Latitud:","Longitud"};
		int posicionY = 20;
		for (int i = 0; i < nombres.length; i++) {
			_etiquetas.add(new JLabel(nombres[i]));
			_etiquetas.get(i).setBounds(60,posicionY,100,20);
			getContentPane().add(_etiquetas.get(i));
			posicionY += 40;
		}
	}
	private void cargarInputText() {
		int posicionY = 20;
		for (int i = 0; i < 3; i++) {
			_textoInput.add(new JTextField());
			_textoInput.get(i).setBounds(130,posicionY,100,20);
			getContentPane().add(_textoInput.get(i));
			posicionY += 40;
		}
	}
	
	private void cargarBotones(){
		String[] opciones = {"Aceptar", "Cancelar"};
		int posicionX = 25;
		for (int i = 0; i < 2; i++) {
			_botones.add(new JButton(opciones[i]));
			_botones.get(i).setBounds(posicionX, 160,100,20);
			getContentPane().add(_botones.get(i));
			posicionX += 130;
		}
	}
	
	private void mouseClicked(){
		_botones.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(seCargaronBienLosDatos()){
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "Por favor revisa los datos ingresados.");
				}
			}
		});
		
		_botones.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
	}
	

	private boolean seCargaronBienLosDatos() {
		String s = _textoInput.get(0).getText();
		String s1 = _textoInput.get(1).getText();
		String s2 = _textoInput.get(2).getText();
		
		boolean bien =	(Chequear.queSeaDouble(s1) || Chequear.queSeaInt(s1)) &&
						(Chequear.queSeaDouble(s2) || Chequear.queSeaInt(s2)) &&
						Chequear.nombreValido(s);
		return	bien;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoAgregarNodo d = new DialogoAgregarNodo();
					d.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public void limpiarDatos() {
		for (JTextField jTextField : _textoInput) {
			jTextField.setText("");
		}
	}
}
