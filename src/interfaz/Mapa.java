package interfaz;

import java.awt.Point;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;


public class Mapa{
	JMapViewer  _mapa;
	ArrayList<MapMarkerDot> _marcadores = new ArrayList<>();
	public Mapa(){
		_mapa = new JMapViewer();
		_mapa.setCenter(new Point(1075, 650));
		_mapa.setBounds(0,0,601,562);
		//El mapa apunta a Buenos Aires
		_mapa.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);
		_mapa.setLayout(null);
		
	}
	public void agregarNodo(String nombre, double latitud, double longitud){
		
		Coordinate coordenada = new Coordinate(latitud, longitud);
		MapMarkerDot marca = new MapMarkerDot(nombre,coordenada);
		_mapa.addMapMarker(marca);
		_marcadores.add(marca);
	}
	
	public void eliminarNodo(String nombre){
		int indice = 0;
		for (MapMarkerDot mapMarkerDot : _marcadores) {
			if(mapMarkerDot.getName().equals(nombre)){
				System.out.println("equals");
				_mapa.removeMapMarker(mapMarkerDot);
				_marcadores.indexOf(mapMarkerDot);
			}
		}
		_marcadores.remove(indice);
	}
	
	public JMapViewer getMap(){
		return _mapa;
		
	}

}
