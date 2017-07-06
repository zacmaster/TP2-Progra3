package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.Chequear;


public class DialogoAgregarNodo extends JDialog{
	private static DialogoAgregarNodo _instancia;
	private static final long serialVersionUID = 1L;
	private String _nombreNodo;
	private double _latitud;
	private double _longitud;
	private ArrayList<JLabel> _etiquetas = new ArrayList<>();
	private ArrayList<JTextField> _textoInput = new ArrayList<>();
	private ArrayList<JButton> _botones = new ArrayList<>();
	
	
	private  DialogoAgregarNodo(){
		iniciar();
	}
	static{
		_instancia = new DialogoAgregarNodo();
	}
	public static DialogoAgregarNodo getInstancia(){
		return _instancia;
	}
	
	private void iniciar(){
		setTitle("Agregar Nodo");
		setBounds(500, 100, 300, 250);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		_botones.get(1)
		.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				if(arg0.getButton() == MouseEvent.BUTTON1){
						dispose();
						limpiarDatos();
				}
			}
		});
	}
	

	boolean seCargaronBienLosDatos() {
		String s = _textoInput.get(0).getText();
		String s1 = _textoInput.get(1).getText();
		String s2 = _textoInput.get(2).getText();
		
		boolean bien =	(Chequear.queSeaDouble(s1) || Chequear.queSeaInt(s1)) &&
						(Chequear.queSeaDouble(s2) || Chequear.queSeaInt(s2)) &&
						Chequear.nombreValido(s);
		return	bien;
	}

	public void agregarConfirmacion(MouseListener mouseListener){
		_botones.get(0).addMouseListener(mouseListener);
	}
	
	public void limpiarDatos() {
		for (JTextField jTextField : _textoInput) {
			jTextField.setText("");
		}
	}

	public String get_nombreNodo() {
		return _nombreNodo;
	}

	public double get_latitud() {
		return _latitud;
	}

	public double get_longitud() {
		return _longitud;
	}
	void mensajeError(){
		_instancia.setAlwaysOnTop(false);
		JOptionPane.showMessageDialog(new JFrame(), "Por favor revisa los datos ingresados.");
		
	}
}

