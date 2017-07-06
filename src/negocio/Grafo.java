package negocio;

import java.util.ArrayList;

public class Grafo {
	ArrayList<Nodo> _nodos;
	ArrayList<Arista> _aristas;
	
	public Grafo(Nodo nodo){
		_nodos = new ArrayList<>();
		_aristas = new ArrayList<>();
		_nodos.add(nodo);
	}
	
	public void agregarNodo(Nodo nodo){
		if(!_nodos.contains(nodo))_nodos.add(nodo);
	}
	
	public void agregarArista(Nodo nodo1, Nodo nodo2, boolean peaje){
		if(!_nodos.contains(nodo1) || !_nodos.contains(nodo2))
		throw new IllegalArgumentException("Nodos inexistentes");
			
		Arista arista = new Arista(nodo1, nodo2, peaje);
		if(!existeArista(arista))_aristas.add(arista);
	}
	
	public void eliminarNodo(String nodo){
		Nodo n = buscarNodoPorNombre(nodo);
		for (Nodo nodoVecino : vecinosDeNodo(n)) {
			eliminarArista(n, nodoVecino);
		}
		_nodos.remove(_nodos.indexOf(n));
	}
	
	
	public int cantidadVecinos(Nodo n){
		return vecinosDeNodo(n).size();
	}
	
	
	public void eliminarArista(Nodo n1, Nodo n2){
		int indiceArista = -1;
		for (Arista arista : _aristas) {
			if(arista.losConecta(n1, n2)){
				indiceArista = _aristas.indexOf(arista);
			}
		}
		if(indiceArista != -1)_aristas.remove(indiceArista);
	}
	
	
	public double distanciaNodos(Nodo nodo1, Nodo nodo2){
		double distancia = Double.MAX_VALUE;
		
		for (Arista arista : _aristas) {
			if(arista.losConecta(nodo1, nodo2)){
				distancia = arista.distancia();
			}
		}
		return distancia;
	}
	
	
	public boolean estanConectados(Nodo nodo1, Nodo nodo2){
		return existeArista(new Arista(nodo1, nodo2, false));
	}
	
	
	public ArrayList<Nodo> vecinosDeNodo(Nodo n){
		ArrayList<Nodo> nodos = new ArrayList<>();
		for (Arista arista : _aristas) {
			if(arista._nodo1.equals(n)){
				nodos.add(arista._nodo2);
			}
			else if(arista._nodo2.equals(n)){
				nodos.add(arista._nodo1);
			}
		}
		return nodos;
	}
	
	private boolean existeArista(Arista a){
		boolean existe = false;
		for (Arista arista : _aristas) {
			if(arista.equals(a))existe = true;
		}
		return existe;
	}
	
	public Nodo buscarNodoPorNombre(String nombre){
		Nodo  nodoNuevo = null;
		for (Nodo nodo : _nodos) {
			if(nodo._nombre == nombre){
				nodoNuevo = nodo;
			}
		}
		if(nodoNuevo == null) throw new IllegalArgumentException();
		return nodoNuevo;
	}

	
	public ArrayList<Nodo> get_nodos() {
		return _nodos;
	}
	public ArrayList<Arista> get_aristas() {
		return _aristas;
	}
	public int cantidadDePeajes(){
		int contador = 0;
		for (Arista arista : _aristas) {
			if(arista._tienePeaje)contador++;
		}
		return contador;
	}

	
	
}
