package es.upm.dit.adsw.ej1;

public class DiccionarioLineal implements Diccionario {
	private final CV[] datos;
	private int nDatos;

	public DiccionarioLineal(int max) {
		this.nDatos = 0;
		this.datos = new CV[max];
	}

	/**
	 * M�todo para obtener el n�mero de objetos en el array que no son null.
	 */
	private void refreshNdatos() {
		int contador = 0;
		for (int i = 0; i < datos.length; i++)
			if (datos[i] != null)
				contador++;
		nDatos = contador;

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
		boolean ind = false;
		CV object = new CV(clave, valor);
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] != null) {
				if (datos[i].getClave() == clave) {
					datos[i].setValor(valor);
					ind = true;
					return;

				}
			}
		}
		refreshNdatos();
		if (!ind) {
			if (nDatos == datos.length)
				throw new RuntimeException();
		}

		for (int i = 0; i < datos.length; i++) {
			if (datos[i] == null) {
				datos[i] = object;
				break;
			}
		}
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
	public String get(String clave) throws IllegalArgumentException {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		refreshNdatos();
		if (nDatos == 0)
			return null;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] != null) {
				if (datos[i].getClave().equals(clave))
					return datos[i].getValor();

			}
		}

		return null;
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
	public String remove(String clave) throws IllegalArgumentException {
		String s = null;
		if (clave == null)
			throw new IllegalArgumentException();
		if (clave.length() == 0)
			throw new IllegalArgumentException();
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] != null) {
				if (datos[i].getClave().equals(clave)) {
					s = datos[i].getValor();
					datos[i] = null;

				}
			}

		}

		
		return s;
	}

	/**
	 * @return número de elementos almacenados.
	 */
	@Override
	public int size() {
		refreshNdatos();
		return nDatos;
	}

	/**
	 * Elimina todas las claves.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < datos.length; i++)
			datos[i] = null;
	}

}
