package interfaz;

import java.awt.Color;
import java.awt.Point;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import negocio.Grafo;
import negocio.Nodo;

public class Mapa{
	JMapViewerTree _treemapa = new JMapViewerTree("");
	JMapViewer  _mapa;
	Capa1 _capa1 = new Capa1("Capa");;
	Grafo _grafo;
	public Mapa(){
		_mapa = new JMapViewer();
		_mapa.setCenter(new Point(1075, 650));
		_mapa.setBounds(0,0,601,562);
		//El mapa apunta a Buenos Aires
		_mapa.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);
		_mapa.setLayout(null);
		
	}
	public void iniciar(){
		_grafo = new Grafo(new Nodo("Buenos Aires",-34.6083,-58.3712){});
		_capa1.cargarMarcadores(new MapMarkerDot(Color.yellow, -34.6083, -58.3712));
		_treemapa.addLayer(_capa1);
		_mapa.add(_treemapa);
	}
	public JMapViewer getMap(){
		return _mapa;
		
	}

}