package interfaz;

//import java.awt.Color;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class Capa1 extends Layer{
	ArrayList<MapMarkerDot> _marcadores = new ArrayList<>();
	public Capa1(String name) {
		super(name);
	}
	
	public void cargarMarcadores(MapMarkerDot marcador){
		_marcadores.add(marcador);
		super.add(_marcadores.get(0));
	}
	

}
