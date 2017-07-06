package interfaz;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
	import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PanelDerecho extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel _panelDerecho = new JPanel();
	private ArrayList<JButton> _botones;
	private JTextArea _leyenda;
	private String[] _textoBotones =	{"Agregar nodo","Borrar nodo","Agregar ruta",
			"Borrar ruta","Distancia A y B","Camino Min"};
	private DialogoAgregarNodo _dialogoAgregarNodo;
	private DialogoEliminarNodo _dialogoEliminarNodo;
	private DialogoAgregarArista _dialogoAgregarArista;
	private DialogoEliminarArista _dialogoEliminarArista;
	private DialogoDistancia _dialogoDistancia;
	private DialogoCaminoMinimo _dialogoCaminoMinimo;
	
	
	
	
	public PanelDerecho() {
		_panelDerecho.setBackground(Color.WHITE);
		_panelDerecho.setBounds(550, 0, 250, 562);
		_panelDerecho.setLayout(null);
		cargarBotones();
		cargarLeyenda();
		mouseOver();
		mouseClicked();
		
	}
	
	public JPanel getJPanel(){
		return _panelDerecho;
	}
	
	private void cargarBotones(){
		_botones = new ArrayList<>();
		int distanciaY = 40;
		for (int i = 0; i < _textoBotones.length; i++) {
			_botones.add(new JButton(_textoBotones[i]));
			_botones.get(i).setBounds(62, distanciaY, 120, 25);
			_panelDerecho.add(_botones.get(i));
			distanciaY += 40;
		}
	}
	 
	
	private void mouseOver(){
		String[] texto = 
		{"Agrega un nodo al mapa ingresando\ncoordenadas.",
		"Borra un nodo del mapa.",
		"Agrega una union entre dos nodos.",
		"Borra la union entre dos nodos.",
		"Indica la distancia entre dos nodos.",
		"Calcula el camino minimo,\nsegun cantidad de peajes deseada."
		};

		int indice = 0;
		for (JButton jButton : _botones) {
			String leyenda = texto[indice];
			jButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					_leyenda.setText(leyenda);
				}
			});
			jButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					_leyenda.setText("");
				}
			});
			indice++;
		}
	}
	
	private void mouseClicked(){
		int indice = 0;
		for (JButton jButton : _botones) {
			int i = indice;
			jButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dialogoAgregarNodo(i);
					dialogoEliminarNodo(i);
					dialogoAgregarArista(i);
					dialogoEliminarArista(i);
					dialogoDistancia(i);
					dialogoCaminoMinimo(i);
				}
			});
		indice++;
		}
	}
	
	
	private void dialogoCaminoMinimo(int i) {
		String[] s = {"1","2","4"};
		if(i == 5){
			_dialogoCaminoMinimo = DialogoCaminoMinimo.getInstancia(s);
			_dialogoCaminoMinimo.setVisible(true);
		}
	}

	private void dialogoDistancia(int i) {
		String[] s = {"1","2","4"};
		if(i == 4){
			_dialogoDistancia = DialogoDistancia.getInstancia(s);
			_dialogoDistancia.setVisible(true);
		}
		
	}

	private void dialogoEliminarArista(int i) {
		String[] s = {"1","2","4"};
		if(i == 3){
			_dialogoEliminarArista = DialogoEliminarArista.getInstancia(s);
			_dialogoEliminarArista.setVisible(true);
		}
	}

	private void dialogoAgregarArista(int i) {
		String[] s = {"1","2","4"};
		if(i == 2){
			_dialogoAgregarArista = DialogoAgregarArista.getInstancia(s);
			_dialogoAgregarArista.setVisible(true);
		}
	}

	private void dialogoEliminarNodo(int i) {
		String[] s = {"1","2","3"};//Revisar
		if(i == 1){
			_dialogoEliminarNodo = DialogoEliminarNodo.getInstancia(s);
			_dialogoEliminarNodo.setVisible(true);
		}
	}

	private void dialogoAgregarNodo(int i){
		if(i == 0){
			_dialogoAgregarNodo = DialogoAgregarNodo.getInstancia();
			_dialogoAgregarNodo.setVisible(true);
			_dialogoAgregarNodo.limpiarDatos();
		}
	}
			
	
	private void cargarLeyenda(){
		_leyenda = new JTextArea();
		_leyenda.setBackground(Color.LIGHT_GRAY);
		_leyenda.setBounds(20, 300, 210, 50);
		_leyenda.setLineWrap(true);
		_panelDerecho.add(_leyenda);
	}

}
