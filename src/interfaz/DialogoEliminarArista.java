package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogoEliminarArista extends JDialog{
	private static final long serialVersionUID = 1L;
	private static DialogoEliminarArista _instancia;
	private String[] _nodos;
	private ArrayList<JButton> _botones = new ArrayList<>();
	private ArrayList<JLabel> _etiquetas = new ArrayList<>();
	private ArrayList<JComboBox<String>> _comboBoxes = new ArrayList<>();
	
	
	private DialogoEliminarArista(){
	}
	static{
		_instancia = new DialogoEliminarArista();
		_instancia.setTitle("Eliminar ruta");
	}
	public static DialogoEliminarArista getInstancia(){
		_instancia.iniciar();
		return _instancia;
	}
	private void iniciar() {
		setBounds(500, 100, 400, 180);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		cargarBotones();
		cargarEtiquetas();
		mouseClicked();
	}
	private void mouseClicked() {
		_botones.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				dispose();
			}
		});
	}
	
	private void cargarEtiquetas() {
		String[] opciones = {"Ciudad origen:", "Ciudad destino:"};
		int posicionX = 20;
		for (int i = 0; i < 2; i++) {
			_etiquetas.add(new JLabel(opciones[i]));
			_etiquetas.get(i).setBounds(posicionX, 10,100,20);
			getContentPane().add(_etiquetas.get(i));
			posicionX += 200;
		}
	}
	private void cargarBotones() {
		String[] opciones = {"Eliminar", "Cancelar"};
		int posicionX = 80;
		for (int i = 0; i < 2; i++) {
			_botones.add(new JButton(opciones[i]));
			_botones.get(i).setBounds(posicionX, 100,100,20);
			getContentPane().add(_botones.get(i));
			posicionX += 120;
		}
	}
	private void cargarComboBoxes() {
		int posicionX = 20;
		for (int i = 0; i < 2; i++) {
			_comboBoxes.add(new JComboBox<String>(new  DefaultComboBoxModel<>(_nodos)));
			_comboBoxes.get(i).setBounds(posicionX, 50, 150, 20);
			getContentPane().add(_comboBoxes.get(i));
			posicionX += 200;
		}
	}
	public void cargarNodos(String[] nodos) {
		_nodos = nodos;
		cargarComboBoxes();
	}
	void limpiar(){
		if(_nodos.length > 0){
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(_nodos);
			_comboBoxes.get(0).setModel(model);
			_comboBoxes.get(1).setModel(model);
			_comboBoxes.get(0).setSelectedIndex(0);
			_comboBoxes.get(1).setSelectedIndex(0);
		}
	}
	public String getPrimerNodo(){
		return _comboBoxes.get(0).getSelectedItem().toString();
	}
	public String getSegundoNodo(){
		return _comboBoxes.get(1).getSelectedItem().toString();
	}
	public void agregarConfirmacion(MouseListener mouseListener){
		_botones.get(0).addMouseListener(mouseListener);
	}
}
