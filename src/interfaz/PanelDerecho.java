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
	
	
	
	
	public PanelDerecho() {
		_panelDerecho.setBackground(Color.WHITE);
		_panelDerecho.setBounds(550, 0, 250, 562);
		_panelDerecho.setLayout(null);
		cargarBotones();
		cargarLeyenda();
		mouseOver();
		
	}
	
	public JPanel getJPanel(){
		return _panelDerecho;
	}
	private void cargarBotones(){
		_botones = new ArrayList<>();
		_botones.add(new JButton("Agregar nodo"));
		_botones.add(new JButton("Borrar nodo"));
		_botones.add(new JButton("Agregar union"));
		_botones.add(new JButton("Borrar union"));
		_botones.add(new JButton("Distancia A y B"));
		_botones.add(new JButton("Camino Min"));
		int distanciaY = 40;
		for (JButton jButton : _botones) {
			jButton.setBounds(62, distanciaY, 120, 25);
			_panelDerecho.add(jButton);
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
	
	private void cargarLeyenda(){
		_leyenda = new JTextArea();
		_leyenda.setBackground(Color.LIGHT_GRAY);
		_leyenda.setBounds(20, 300, 210, 50);
//		_leyenda.setFont(new Font("Arial", 5, 12));
		_leyenda.setLineWrap(true);
		_panelDerecho.add(_leyenda);
	}

}
