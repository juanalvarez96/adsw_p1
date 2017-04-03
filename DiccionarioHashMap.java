package es.upm.dit.adsw.ej1;

import java.util.HashMap;

public class DiccionarioHashMap implements Diccionario {
	private final HashMap<String, String> map;

	public DiccionarioHashMap() {
		map = new HashMap<>();
	}

	/**
	 * Mete un valor nuevo. Si ya existe uno con misma clave, reemplaza el
	 * valor.
	 *
	 * @param clave
	 * @param valor
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 * @throws RuntimeException
	 *             Si no cabe la clave.
	 */
	@Override
	public void put(String clave, String valor)
			throws IllegalArgumentException, RuntimeException {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		
		map.put(clave, valor);
		

	}

	/**
	 * Saca el valor asociado a la clave.
	 *
	 * @param clave
	 * @return null si no está la clave.
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	@Override
	public String get(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();

		return map.get(clave);
	}

	/**
	 * Elimina el objeto asociado a la clave, si está.
	 *
	 * @param clave
	 * @return devuelve el valor asociado si estaba la clave; devuelve null si
	 *         no está la clave
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	@Override
	public String remove(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		return map.remove(clave);

	}

	/**
	 * @return número de elementos almacenados.
	 */
	@Override
	public int size() {
		return map.size();

	}

	/**
	 * Elimina todas las claves.
	 */
	@Override
	public void clear() {
		map.clear();

	}

}
