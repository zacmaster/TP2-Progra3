package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class DialogoEliminarNodo extends JFrame{
	private static DialogoEliminarNodo _instancia;
	private static final long serialVersionUID = 1L;
	private String[] _nodos;
	private ArrayList<JButton> _botones = new ArrayList<>();
	
	
	private DialogoEliminarNodo() {
		super("Eliminar nodo");
	}
	
	static{
		_instancia = new DialogoEliminarNodo();
	}
	public static DialogoEliminarNodo getInstancia(String[] nodos){
		_instancia.cargarNodos(nodos);
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
		
		JComboBox<String> comboBox = new JComboBox<String>(_nodos);
		comboBox.setBounds(30, 50, 220, 20);
		getContentPane().add(comboBox);
		
		cargarBotones();
		mouseClicked();
		
		
		setResizable(false);
	}
	private void cargarNodos(String[] nodos){
		_nodos = nodos;
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
	
	private void mouseClicked(){
		for (int i = 0; i < _botones.size(); i++) {
			int index = i;
			accionesMouse(i, index);
		}
	}

	private void accionesMouse(int i, int index) {
		_botones.get(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				if(index == 0){ //Eliminar
					
				}
				if(index == 1){ //Cancelar
					dispose();
				}
			}
			
		});
	}
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					String[] nodos = {"1","2","3","4"};
//					DialogoEliminarNodo d = DialogoEliminarNodo.getInstancia(nodos);
//					d.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}
}
