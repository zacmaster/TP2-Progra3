package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogoDistancia extends JFrame{
	private static final long serialVersionUID = 1L;
	private static DialogoDistancia _instancia;
	private String[] _nodos;
	private ArrayList<JButton> _botones = new ArrayList<>();
	private ArrayList<JLabel> _etiquetas = new ArrayList<>();
	private ArrayList<JComboBox<String>> _comboBoxes = new ArrayList<>();
	
	private DialogoDistancia(){
		super("Calcular distancia");
	}
	static{
		_instancia = new DialogoDistancia();
	}
	public static DialogoDistancia getInstancia(String[] nodos){
		_instancia.cargarNodos(nodos);
		_instancia.iniciar();
		return _instancia;
	}
	private void iniciar() {
		setBounds(500, 100, 400, 180);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		cargarComboBoxes();
		cargarBotones();
		cargarEtiquetas();
		mouseClicked();
	}
	private void mouseClicked() {
		for (int i = 0; i < _botones.size(); i++) {
			int index = i;
			accionesMouse(i, index);
		}
	}
	private void accionesMouse(int i, int index) {
		_botones.get(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				if(index == 0){ //Calcular
					
				}
				if(index == 1){ //Cancelar
					dispose();
				}
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
		String[] opciones = {"Calcular", "Cancelar"};
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
			_comboBoxes.add(new JComboBox<String>(_nodos));
			_comboBoxes.get(i).setBounds(posicionX, 50, 150, 20);
			getContentPane().add(_comboBoxes.get(i));
			posicionX += 200;
		}
	}
	private void cargarNodos(String[] nodos) {
		_nodos = nodos;
		
	}
}
