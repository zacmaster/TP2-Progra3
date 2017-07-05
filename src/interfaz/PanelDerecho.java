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
	private String[] _textoBotones =	{"Agregar nodo","Borrar nodo","Agregar union",
			"Borrar union","Distancia A y B","Camino Min"};
	private DialogoAgregarNodo _dialogoAgregarNodo;
	
	
	
	
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
				}
			});
		indice++;
		}
	}
	
	
	private void dialogoEliminarArista(int i) {
		
	}

	private void dialogoAgregarArista(int i) {
		
	}

	private void dialogoEliminarNodo(int i) {
		
	}

	private void dialogoAgregarNodo(int i){
		if(i == 0){
				_dialogoAgregarNodo = DialogoAgregarNodo.getInstancia();
				_dialogoAgregarNodo.setVisible(true);
			}
			_dialogoAgregarNodo.limpiarDatos();
		}
			
	
	private void cargarLeyenda(){
		_leyenda = new JTextArea();
		_leyenda.setBackground(Color.LIGHT_GRAY);
		_leyenda.setBounds(20, 300, 210, 50);
		_leyenda.setLineWrap(true);
		_panelDerecho.add(_leyenda);
	}

}