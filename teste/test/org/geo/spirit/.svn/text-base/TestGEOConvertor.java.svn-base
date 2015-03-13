/*	Douglas Hiura Longo
 *	douglashiura@gmail.com
 *	java.inf.usfc.br/dh
 *	Santa Catarina, 22 de Setembro de 2010, 19:50
 */
package test.org.geo.spirit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGEOConvertor implements IConstants {
	@Test
	public void testGeoToUTM() {
		assertEquals("7577904.467869655N, 261928.92436282506E",
				new GEOConvertor().geoToUTM(21.88684199, 47.30414058,
						Datum.SAD69, 45));
		assertEquals("7577912.807043435N, 261929.7858704625E",
				new GEOConvertor().geoToUTM(21.88684199, 47.30414058,
						Datum.WGS84, 45));
	}

	@Test
	public void testDecToDMS() {
		assertEquals("21" + DEGREE + "53" + MINUTE + "92,631164E11" + SECOND,
				new GEOConvertor().decToDMS(21.88684199));
	}

	@Test
	public void testDMStoDec() {
		assertEquals(new Double(21.90888888888889d), new Double(
				new GEOConvertor().dmsToDEC(215392.631)));
	}

}
