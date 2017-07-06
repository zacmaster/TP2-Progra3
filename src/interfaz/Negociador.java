package interfaz;

import java.util.ArrayList;

import datos.GrafoJSON;
import negocio.Grafo;
import negocio.Nodo;

public class Negociador {
	private static Negociador _instancia;
	private GrafoJSON _grafoJSON;
	private Grafo _grafo;
	private final String ARCHIVO = "grafo.json";
	
	private Negociador(){
		cargarDatos();
	}
	
	static{
		_instancia = new Negociador();
	}
	
	public static Negociador getInstancia(){
		return _instancia;
	}
	
	public void agregarNodo(String nombre, double latitud, double longitud){
		_grafo.agregarNodo(new Nodo(nombre,latitud,longitud));
	}
	
	public void eliminarNodo(String nombre){
		if(nombre != "")_grafo.eliminarNodo(nombre);
	}
	public void agregarArista(String nodo1, String nodo2, boolean peaje){
		Nodo n1 = _grafo.buscarNodoPorNombre(nodo1);
		Nodo n2 = _grafo.buscarNodoPorNombre(nodo2);
		_grafo.agregarArista(n1, n2, peaje);
	}
	
	public void eliminarArista(String nodo1, String nodo2){
		Nodo n1 = _grafo.buscarNodoPorNombre(nodo1);
		Nodo n2 = _grafo.buscarNodoPorNombre(nodo2);
		_grafo.eliminarArista(n1, n2);
	}
	
	public void guardar(){
		_grafoJSON.escribirArchivo(ARCHIVO, _grafo);
	}
	public double distancia(String nodo1, String nodo2){
		Nodo n1 = _grafo.buscarNodoPorNombre(nodo1);
		Nodo n2 = _grafo.buscarNodoPorNombre(nodo2);
		return _grafo.distanciaNodos(n1, n2);
	}
	public String[] nodosEnTexto(){
		ArrayList<Nodo> nodos = _grafo.get_nodos();
		String[] arrayNodos = new String[nodos.size()];
		for (int i = 0; i < nodos.size(); i++) {
			arrayNodos[i] = nodos.get(i).getNombre();
		}
		return arrayNodos;
	}
	
	public String[] peajes(){
		int cantidad = _grafo.cantidadDePeajes();
		if(cantidad > 0){
			String[] peajes = new String[cantidad+1];
			for (int i = 0; i < cantidad+1; i++) {
				peajes[i] = String.valueOf(i);
			}
			return peajes;
		}
		return new String[] {"0"};
	}
	
	
	
	
	
	private void cargarDatos(){
		_grafoJSON = new GrafoJSON();
		_grafoJSON.leerArchivo(ARCHIVO);
		_grafo = _grafoJSON.getGrafo();
	}

}
