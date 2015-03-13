/*	Douglas Hiura Longo
 *	douglashiura@gmail.com
 *	java.inf.ufsc.br/dh
 *	Santa Catarina, 22 de Setembro de 2010, 19:50
 */
package test.org.geoconvertor;

import static org.junit.Assert.assertEquals;

import org.geoconvertor.me.AbstractCoefficient;
import org.junit.Ignore;
import org.junit.Test;

public class TesteFuncaoExp {
	@Test
	public void doisElevadoNaTerceira() {
		assertEquals(new Double(8),
				new Double(AbstractCoefficient.getPow(2, 3)));
	}

	@Test
	public void testExp() {
		assertEquals(new Double(2.82429536481E11), new Double(
				AbstractCoefficient.getPow(27, 8)));
	}

	@Ignore("Não implementado ainda")
	@Test
	public void baseZeroExpoenteZero() {
		assertEquals(new Double(Double.NaN),
				new Double(AbstractCoefficient.getPow(0, 0)));
	}

	@Test
	public void baseZeroExpoenteNegativo() {

		assertEquals(new Double(0),
				new Double(AbstractCoefficient.getPow(0, -1)));
	}

	@Ignore("Não implementado ainda")
	@Test
	public void baseNegativoExpoenteZero() {
		assertEquals(new Double(Double.NEGATIVE_INFINITY/*-1.0 / 0.0*/),
				new Double(AbstractCoefficient.getPow(-1, 0)));
	}

	@Test
	public void baseZeroExpoenteUm() {
		assertEquals(new Double(0),
				new Double(AbstractCoefficient.getPow(0, 1)));
	}

	@Ignore("Não implementado ainda")
	@Test
	public void baseUmExpoenteZero() {
		assertEquals(new Double(Double.POSITIVE_INFINITY), new Double(
				AbstractCoefficient.getPow(1, 0)));
	}

	@Test
	public void baseZeroExpoenteBig() {
		assertEquals(new Double(0.0),
				new Double(AbstractCoefficient.getPow(0, 99)));
	}

	@Ignore("Não implementado ainda")
	@Test
	public void baseBigExpoenteZero() {
		assertEquals(new Double(1),
				new Double(AbstractCoefficient.getPow(99, 0)));
	}

	// todos zeros up
	// agora todos uns esquecendo zeros
	@Test
	public void baseUmExpoenteUm() {
		assertEquals(new Double(1),
				new Double(AbstractCoefficient.getPow(1, 1)));
	}

	@Test
	public void baseUmExpoenteNegativo() {
		assertEquals(new Double(1),
				new Double(AbstractCoefficient.getPow(1, -1)));
	}

	@Test
	public void baseNegativaExpoenteUm() {
		assertEquals(new Double(-1),
				new Double(AbstractCoefficient.getPow(-1, 1)));
	}

	@Test
	public void baseUmExpoenteBig() {
		assertEquals(new Double(1),
				new Double(AbstractCoefficient.getPow(1, 99)));
	}

	@Test
	public void baseBigExpoenteUm() {
		assertEquals(new Double(99),
				new Double(AbstractCoefficient.getPow(99, 1)));
	}

	// negativo esquecendo 1 e zeros

	@Test
	public void baseNegativoExpoenteNegativo() {
		assertEquals(new Double(-1),
				new Double(AbstractCoefficient.getPow(-1, -1)));
	}

	@Test
	public void baseNegativoExpoenteBig() {
		assertEquals(new Double(-1),
				new Double(AbstractCoefficient.getPow(-1, 99)));
	}

	@Ignore("Não implementado ainda")
	@Test
	public void baseBigExpoenteNegativo() {
		assertEquals(new Double(0.010101010101010102), new Double(
				AbstractCoefficient.getPow(99, -1)));
	}

	// big esquecendo zeros,um e negativos

	@Test
	public void baseBigExpoenteBig() {
		assertEquals(new Double(3.6972963764972654E197), new Double(
				AbstractCoefficient.getPow(99, 99)));
	}

	@Ignore("Não implementado ainda")
	@Test
	public void baseBig_ExpoenteBig_() {
		assertEquals(new Double(-2.704679036164736E-198), new Double(
				AbstractCoefficient.getPow(-99, -99)));
	}
}
