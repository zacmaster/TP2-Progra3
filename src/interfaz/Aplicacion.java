package interfaz;

import java.awt.EventQueue;
//import javax.swing.JFrame;

public class Aplicacion {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana ventana = new Ventana();
					ventana._frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
