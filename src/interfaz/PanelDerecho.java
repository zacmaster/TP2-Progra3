package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
			"Borrar ruta","Distancia A y B","Camino Min","Guardar"};
	
	Negociador _negociador;
	
	private DialogoAgregarNodo _dialogoAgregarNodo = DialogoAgregarNodo.getInstancia();
	private DialogoEliminarNodo _dialogoEliminarNodo = DialogoEliminarNodo.getInstancia();
	private DialogoAgregarArista _dialogoAgregarArista = DialogoAgregarArista.getInstancia();
	private DialogoEliminarArista _dialogoEliminarArista = DialogoEliminarArista.getInstancia();
	private DialogoDistancia _dialogoDistancia;
	private DialogoCaminoMinimo _dialogoCaminoMinimo;
	
	
	
	public PanelDerecho(Negociador _negociador) {
		this._negociador = _negociador;
		_panelDerecho.setBackground(Color.WHITE);
		_panelDerecho.setBounds(550, 0, 250, 562);
		_panelDerecho.setLayout(null);
		cargarBotones();
		cargarLeyenda();
		mouseOver();
		mouseClicked();
		confirmaciones();
		
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
		"Calcula el camino minimo,\nsegun cantidad de peajes deseada.",
		"Guarda los cambios realizados"
		};

		int indice = 0;
		for (JButton jButton : _botones) {
			String leyenda = texto[indice];
			accionesMouseOver(jButton, leyenda);
			indice++;
		}
	}

	private void accionesMouseOver(JButton jButton, String leyenda) {
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				_leyenda.setText(leyenda);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				_leyenda.setText("");
			}
			
		});
	}
	
	private void mouseClicked(){
		int indice = 0;
		for (JButton jButton : _botones) {
			int i = indice;
			accionesMouseClicked(jButton, i);
		indice++;
		}
	}

	private void accionesMouseClicked(JButton jButton, int i) {
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogoAgregarNodo(i);
				dialogoEliminarNodo(i);
				dialogoAgregarArista(i);
				dialogoEliminarArista(i);
				dialogoDistancia(i);
				dialogoCaminoMinimo(i);
				guardar(i);
			}
		});
	}
	
	
	protected void guardar(int i) {
		if(i == 6)_negociador.guardar();
	}

	private void dialogoCaminoMinimo(int i) {
		if(i == 5){
			_dialogoCaminoMinimo = DialogoCaminoMinimo.getInstancia(_negociador.nodosEnTexto(),_negociador.peajes());
			_dialogoCaminoMinimo.setVisible(true);
		}
	}

	private void dialogoDistancia(int i) {
		if(i == 4){
			_dialogoDistancia = DialogoDistancia.getInstancia(_negociador.nodosEnTexto());
			_dialogoDistancia.setVisible(true);
		}
		
	}

	private void dialogoEliminarArista(int i) {
		if(i == 3){
			_dialogoEliminarArista = DialogoEliminarArista.getInstancia();
			_dialogoEliminarArista.cargarNodos(_negociador.nodosEnTexto());
			_dialogoEliminarArista.setVisible(true);
		}
	}

	private void dialogoAgregarArista(int i) {
		if(i == 2){
			_dialogoAgregarArista.cargarNodos(_negociador.nodosEnTexto());
			_dialogoAgregarArista.setVisible(true);
		}
	}

	private void dialogoEliminarNodo(int i) {
		if(i == 1){
			_dialogoEliminarNodo.cargarNodos(_negociador.nodosEnTexto());
			_dialogoEliminarNodo.setVisible(true);
		}
	}

	private void dialogoAgregarNodo(int i){
		if(i == 0){
			if(!_dialogoAgregarNodo.isVisible())
				_dialogoAgregarNodo.setVisible(true);
				_dialogoAgregarNodo.setAlwaysOnTop(true);
		}
	}

	private void agregarNodoConfirmacion() {
		_dialogoAgregarNodo.agregarConfirmacion(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					if(_dialogoAgregarNodo.seCargaronBienLosDatos()){
						
						agregarNodo();
						_dialogoAgregarNodo.setVisible(false);
						_dialogoAgregarNodo.limpiarDatos();
					}
					else{
						_dialogoAgregarNodo.mensajeError();
					}
				}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
		});
	}
	private void confirmaciones(){
		agregarNodoConfirmacion();
		agregarAristaConfirmacion();
		borrarNodoConfirmacion();
		borrarAristaConfirmacion();
	}
	private void agregarAristaConfirmacion() {
		_dialogoAgregarArista.agregarConfirmacion(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
						agregarArista();
						_dialogoAgregarArista.limpiar();
						_dialogoAgregarArista.setVisible(false);
				}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
		});
	}
	private void borrarNodoConfirmacion() {
		_dialogoEliminarNodo.agregarConfirmacion(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1 && _negociador.nodosEnTexto().length > 0){
					_negociador.eliminarNodo(_dialogoEliminarNodo.getElementoSeleccionado());
					_dialogoEliminarNodo.setVisible(false);
					_dialogoEliminarNodo.limpiar();
				}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
		});
	}
	private void borrarAristaConfirmacion() {
		_dialogoEliminarArista.agregarConfirmacion(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1 && _negociador.nodosEnTexto().length > 0){
					_negociador.eliminarArista(_dialogoEliminarArista.getPrimerNodo(), _dialogoEliminarArista.getSegundoNodo());
					_dialogoEliminarArista.setVisible(false);
					_dialogoEliminarArista.limpiar();
				}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
		});
	}

	private void agregarNodo() {
		_negociador.agregarNodo(_dialogoAgregarNodo.get_nombreNodo(),
				_dialogoAgregarNodo.get_latitud(),
				_dialogoAgregarNodo.get_longitud());
	}
	private void agregarArista(){
		_negociador.agregarArista(_dialogoAgregarArista.getNodo1(),
				_dialogoAgregarArista.getNodo2(),
				_dialogoAgregarArista.getPeaje());
	}
			
	

	private void cargarLeyenda(){
		_leyenda = new JTextArea();
		_leyenda.setBackground(Color.LIGHT_GRAY);
		_leyenda.setBounds(20, 330, 210, 50);
		_leyenda.setLineWrap(true);
		_panelDerecho.add(_leyenda);
	}

}
