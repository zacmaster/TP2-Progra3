package interfaz;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana {
	JFrame _frame;
	JPanel _panelIzquierdo = new JPanel();
	private Negociador _negociador = Negociador.getInstancia();
	PanelDerecho _panelDerecho = new PanelDerecho(_negociador);
	public Ventana(){
		initialize();
	}
	private void initialize() {
		_frame = new JFrame();
		_frame.setBounds(100, 100, 800, 600);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		_frame.getContentPane().setLayout(null);
		
		_panelIzquierdo.setBackground(new Color(102, 204, 255));
		_panelIzquierdo.setBounds(0, 0, 550, 562);
		_frame.getContentPane().add(_panelIzquierdo);
		_panelIzquierdo.setLayout(null);
		
		
		_frame.getContentPane().add(_panelDerecho.getJPanel());
		
		setPanelIzquierdo(_negociador.get_mapa());
		
		
		
		
		
	}
	public void setPanelIzquierdo(Mapa mapa){
		_panelIzquierdo.add(mapa.getMap());
	}
}