package interfaz;

import java.awt.EventQueue;
import javax.swing.*;
public class DialogoEliminarNodo extends JFrame{
	private static final long serialVersionUID = 1L;
	private String[] _nodos;
	public DialogoEliminarNodo(String[] nodos) {
		super("Eliminar nodo");
		_nodos = nodos;
		iniciar();
	}
	private void iniciar(){
		
		setBounds(500, 100, 290, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel jLabel = new JLabel("Seleccione el nodo a eliminar");
		jLabel.setBounds(56, 10, 200, 20);
		getContentPane().add(jLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>(_nodos);
		comboBox.setBounds(30, 50, 220, 20);
		getContentPane().add(comboBox);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(30, 100, 100, 20);
		getContentPane().add(botonEliminar);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(150, 100, 100, 20);
		getContentPane().add(botonCancelar);
		
		setResizable(false);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] nodos = {"1","2","3","4"};
					DialogoEliminarNodo d = new DialogoEliminarNodo(nodos);
					d.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
