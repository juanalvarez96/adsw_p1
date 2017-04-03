package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiccionarioTest1 {
	private Diccionario diccionario;
	private Diccionario diccionario2;

	/**
	 * Creo los objetos diccionario y dicionario2.
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		diccionario = new DiccionarioLineal(5);
		diccionario2 = new DiccionarioHashMap();

	}

	/**
	 * Comprobamos que el método put realiza correctamente su función. Con los
	 * objetos introducimos, usamos el método remove. Observamos que si
	 * removemos un objeto en el array, este desaparece.
	 */
	@Test
	public void test01() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals("valor", diccionario.remove("78"));
		assertEquals(null, diccionario.remove("78"));
	}

	/**
	 * Observamos que cuando metemos dos objetos con la misma clave, el valor
	 * será el del segundo.
	 */
	@Test
	public void test02() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals("holaloco", diccionario.remove("34"));
	}

	/**
	 * Observamos que el método get funciona correctamente. Cuando metemos un
	 * objeto con valor null y lo llamamos con get, nos devuelven el null.
	 */
	@Test
	public void test03() {

		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.get("13"));
	}

	/**
	 * Comprobamos que la excepción IllegalArgumentException funciona
	 * debidamente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test04() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.get(""));
	}

	/**
	 * comprobamos que la excepción IllegalArgumentException funciona
	 * correctamente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test05() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.get(null));
	}

	/**
	 * Comprobamos que se lanza una excepción cuando el objeto introducido es un
	 * null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.remove(null));
	}

	/**
	 * Comprobamos que se lanza excepción cuando el argumento está vacío.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test07() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.remove(""));
	}

	/**
	 * Comprobamos que cuando queremos borrar un objeto que no existe en el
	 * array recibimos un null.
	 */
	@Test
	public void test08() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.remove("ksljd´l"));
	}

	/**
	 * Comprobamos que cuando queremos borrar un objeto con el valor
	 * actualizado, este se actualiza correctamente.
	 */
	@Test
	public void test09() {
		diccionario.put("1", "kjskd");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", null);
		assertEquals(null, diccionario.remove("13"));
	}

	/**
	 * Comprobamos que el método size nos devuelve el numero de objetos no nulos
	 * en el array, y que cuenta correctamente aquellos objetos cuyo valor se
	 * actualiza.
	 */
	@Test
	public void test10() {
		assertEquals(0, diccionario.size());
		diccionario.put("1", "kjskd");
		assertEquals(1, diccionario.size());
		diccionario.put("78", "valor");
		assertEquals(2, diccionario.size());
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("34", "holaloco");
		diccionario.put("13", "khkjsa");
		assertEquals(4, diccionario.size());
	}

	/**
	 * Comprobamos que el metodo get de la clase DiccioanrioHashMap devuelve los
	 * valores correctamente, actualiza aquellos valores que se repiten y
	 * devuelve null cuando no se encuentra el objeto buscado.
	 */
	@Test
	public void test11() {
		diccionario2.put("1", "valor");
		diccionario2.put("78", "valor");
		diccionario2.put("34", "holacaracola");
		diccionario2.put("13", "juanito");
		diccionario2.put("34", "holaloco");
		diccionario2.put("13", null);
		assertEquals("holaloco", diccionario2.get("34"));
		assertEquals(null, diccionario2.get("13"));
		assertEquals(null, diccionario2.get("dhf"));
	}

	/**
	 * Comprobamos que el método remove de la clase DiccionarioHashMap elimina
	 * los valores correctamente, actualiza aquellos objetos que se repiten y
	 * devuelve null cuando no se encuentra el objeto que se quiere borrar.
	 */
	@Test
	public void test12() {
		diccionario2.put("1", "valor");
		diccionario2.put("78", "valor");
		diccionario2.put("34", "holacaracola");
		diccionario2.put("13", "juanito");
		diccionario2.put("34", "holaloco");
		diccionario2.put("13", null);
		assertEquals("holaloco", diccionario2.remove("34"));
		assertEquals("valor", diccionario2.remove("78"));
		assertEquals(null, diccionario2.remove("kudhf"));
	}

	/**
	 * Comprobamos que el método size de la clase DiccioanrioHashMap funciona
	 * correctamente cuando se repiten algunos objetos.
	 */
	@Test
	public void test13() {
		diccionario2.put("1", "valor");
		diccionario2.put("78", "valor");
		diccionario2.put("34", "holacaracola");
		diccionario2.put("13", "juanito");
		diccionario2.put("34", "holaloco");
		diccionario2.put("13", null);
		assertEquals(4, diccionario2.size());
	}

	/**
	 * Comprobamos que el método clear elimina todos los objetos que se
	 * encuentran en el mapa.
	 */
	@Test
	public void test14() {
		diccionario2.put("1", "valor");
		diccionario2.put("78", "valor");
		diccionario2.put("34", "holacaracola");
		diccionario2.put("13", "juanito");
		diccionario2.put("34", "holaloco");
		diccionario2.put("13", null);
		diccionario2.clear();
		assertEquals(0, diccionario2.size());
	}

	/**
	 * Comprobamos que se lanza excepción cuando los argumentos no son
	 * correctos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test15() {
		assertEquals(null, diccionario2.remove(""));
		assertEquals(null, diccionario2.remove(null));
	}

	/**
	 * Comprobamos que se lanza excepción cuando los argumentos no son
	 * correctos.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void test16() {
		diccionario.put(null, "valor");
		diccionario.put("", "valor");
	}

	/**
	 * Comprobamos que se lanza excepción cuando los argumentos metidos en el
	 * mapa no son correctos
	 */

	@Test(expected = IllegalArgumentException.class)
	public void test17() {
		diccionario2.put(null, "js");
		diccionario2.put("", "valor");
	}

	/**
	 * Test sirve para comprobar que se ejecuta la excepcion RuntimeException.
	 */
	@Test(expected = RuntimeException.class)
	public void test18() {
		diccionario.put("1", "valor");
		diccionario.put("78", "valor");
		diccionario.put("34", "holacaracola");
		diccionario.put("13", "juanito");
		diccionario.put("37", "holaloco");
		diccionario.put("14", null);
	}

	/**
	 * Comprobamos que para un caso genérico el método size funciona
	 * correctamente.
	 */
	@Test
	public void test19() {
		diccionario.put("1", "valor");
		diccionario.put("78", "valor");
		assertEquals(2, diccionario.size());

	}

}
