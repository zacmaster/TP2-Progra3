package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class DialogoEliminarNodo extends JDialog{
	private static DialogoEliminarNodo _instancia;
	private static final long serialVersionUID = 1L;
	private String[] _nodos;
	private JComboBox<String> _comboBox = new JComboBox<>();
	private ArrayList<JButton> _botones = new ArrayList<>();
	
	
	private DialogoEliminarNodo() {
	}
	
	static{
		_instancia = new DialogoEliminarNodo();
		_instancia.setTitle("Eliminar nodo");
	}
	public static DialogoEliminarNodo getInstancia(){
		_instancia.iniciar();
		return _instancia;
	}
	
	private void iniciar(){
		
		setBounds(500, 100, 290, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel jLabel = new JLabel("Seleccione el nodo a eliminar");
		jLabel.setBounds(56, 10, 200, 20);
		getContentPane().add(jLabel);
		
		cargarBotones();
		mouseClicked();
		
		setResizable(false);
	}

	private void cargarComboBox() {
		_comboBox.setModel(new DefaultComboBoxModel<String>(_nodos));

		_comboBox.setBounds(30, 50, 220, 20);
		getContentPane().add(_comboBox);
	}
	private void cargarBotones(){
		String[] opciones = {"Eliminar", "Cancelar"};
		int posicionX = 30;
		for (int i = 0; i < 2; i++) {
			_botones.add(new JButton(opciones[i]));
			_botones.get(i).setBounds(posicionX, 100,100,20);
			getContentPane().add(_botones.get(i));
			posicionX += 120;
		}
	}
	
	public void cargarNodos(String[] nodos){
		_nodos = nodos;
		cargarComboBox();
		
	}
	private void mouseClicked(){
		_botones.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
					dispose();
					limpiar();
				}
		});
		
	}

	public void agregarConfirmacion(MouseListener mouseListener){
		_botones.get(0).addMouseListener(mouseListener);
	}
	
	void limpiar() {
		if(_nodos.length > 0){
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(_nodos);
			_comboBox.setModel(model);
			_comboBox.setSelectedIndex(0);
		}
	}
	public String getElementoSeleccionado(){
		return _comboBox.getSelectedItem().toString();
	}
}
