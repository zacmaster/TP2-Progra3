package negocio;

public class Nodo 
{
	String _nombre;
	double _latitud;
	double _longitud;
	
	public Nodo(String nombre, double latitud, double longitud)
	{
		_latitud = latitud;
		_longitud = longitud;
		_nombre = nombre;
	}
	
	@Override
	public boolean equals(Object objeto){
		if(objeto == null) return false;
		if(!(objeto instanceof Nodo)) return false;
		Nodo  nodo = (Nodo) objeto;
		return (_nombre.equals(nodo._nombre) &&
				_longitud == nodo._longitud &&
				_latitud == nodo._latitud);
		
	}
	public String getNombre(){
		return _nombre;
	}
	public double getLatitud(){
		return _latitud;
	}
	public double getLongitud(){
		return _longitud;
	}


}
