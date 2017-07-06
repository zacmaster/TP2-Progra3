package interfaz;

import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogoAgregarArista extends JDialog{
	private static final long serialVersionUID = 1L;
	private static DialogoAgregarArista _instancia;
	private String[] _nodos;
	private ArrayList<JButton> _botones = new ArrayList<>();
	private ArrayList<JLabel> _etiquetas = new ArrayList<>();
	private  Checkbox _boxPeaje = new Checkbox("Con Peaje", false);
	private ArrayList<JComboBox<String>> _comboBoxes = new ArrayList<>();
	
	private DialogoAgregarArista(){
	}
	
	static{
		_instancia = new DialogoAgregarArista();
		_instancia.setTitle("Agregar ruta");
	}
	public static DialogoAgregarArista getInstancia(){
		_instancia.iniciar();
		return _instancia;
	}
	private void iniciar() {
		setBounds(500, 100, 500, 180);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		cargarBotones();
		cargarEtiquetas();
		mouseClicked();
		cargarBoxPeaje();
	}
	private void cargarBoxPeaje() {
		_boxPeaje.setBounds(380, 50, 97, 23);
		getContentPane().add(_boxPeaje);
	}
	private void cargarEtiquetas() {
		String[] opciones = {"Ciudad origen:", "Ciudad destino:"};
		int posicionX = 20;
		for (int i = 0; i < 2; i++) {
			_etiquetas.add(new JLabel(opciones[i]));
			_etiquetas.get(i).setBounds(posicionX, 10,100,20);
			getContentPane().add(_etiquetas.get(i));
			posicionX += 180;
		}
	}
	private void cargarBotones() {
		String[] opciones = {"Agregar", "Cancelar"};
		int posicionX = 110;
		for (int i = 0; i < 2; i++) {
			_botones.add(new JButton(opciones[i]));
			_botones.get(i).setBounds(posicionX, 100,100,20);
			getContentPane().add(_botones.get(i));
			posicionX += 120;
		}
	}
	public void cargarNodos(String[] nodos) {
		_nodos = nodos;
		cargarComboBoxes();
	}
	private void cargarComboBoxes(){
		int posicionX = 20;
		for (int i = 0; i < 2; i++) {
			_comboBoxes.add(new JComboBox<String>(_nodos));
			_comboBoxes.get(i).setBounds(posicionX, 50, 150, 20);
			getContentPane().add(_comboBoxes.get(i));
			posicionX += 180;
		}
	}
	
	private void mouseClicked(){
		_botones.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				dispose();
			}
		});
	}
	public void agregarConfirmacion(MouseListener mouseListener){
		_botones.get(0).addMouseListener(mouseListener);
	}
	public String getNodo1(){
		return _comboBoxes.get(0).getSelectedItem().toString();
		
	}
	public String getNodo2(){
		return _comboBoxes.get(1).getSelectedItem().toString();
		
	}
	public boolean getPeaje(){
		return _boxPeaje.getState();
	}
	public void limpiar(){
		_comboBoxes.get(0).setSelectedIndex(0);
		_comboBoxes.get(1).setSelectedIndex(0);
		_boxPeaje.setState(false);
	}
	
}
