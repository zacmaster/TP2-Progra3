package negocio;

public class Arista {
	boolean _tienePeaje;
	Nodo _nodo1;
	Nodo _nodo2;
	
	Arista(Nodo nodo1, Nodo nodo2, boolean tienePeaje){
		this._nodo1 = nodo1;
		this._nodo2 = nodo2;
		this._tienePeaje = tienePeaje;
	}
	
	boolean losConecta(Nodo nodo1, Nodo nodo2){
		return	(_nodo1.equals(nodo1) && _nodo2.equals(nodo2)||
				(_nodo1.equals(nodo2) && _nodo2.equals(nodo1)));
	}
	
	double distancia(){
			return Coordenada.distancia(_nodo1._latitud, _nodo1._longitud, _nodo2._latitud, _nodo2._longitud);
	}
	@Override
	public boolean equals(Object objeto){
		if(objeto == null) return false;
//		if(objeto == this) return false;
		if(!(objeto instanceof Arista)) return false;
		Arista  arista = (Arista) objeto;
		return (_nodo1.equals(arista._nodo1) && _nodo2.equals(arista._nodo2))
				|| (_nodo2.equals(arista._nodo1) && _nodo1.equals(arista._nodo2));
		
	}
	
	
	

}
