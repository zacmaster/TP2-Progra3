package interfaz;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana {
	JFrame _frame;
	public Ventana(){
		initialize();
	}
	private void initialize() {
		_frame = new JFrame();
		_frame.setBounds(100, 100, 800, 600);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		_frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(102, 204, 255));
		leftPanel.setBounds(0, 0, 550, 562);
		_frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		PanelDerecho pd = new PanelDerecho();
		
		_frame.getContentPane().add(pd.getJPanel());
		
		
		
		Mapa mapa = new Mapa();
		leftPanel.add(mapa.getMap());
		
		
		
	}
}