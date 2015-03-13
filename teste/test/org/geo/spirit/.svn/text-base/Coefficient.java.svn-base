package test.org.geo.spirit;

import static test.org.geo.spirit.Calc.FabricaConfigurada.pow;

final class Coefficient {

	/*
	 * for example: abstracting pow of math function, in ME ou SE static
	 * abstract class CalcFactory { private static CalcFactory single; protected
	 * CalcFactory() { if(single ==null) single = new J2SECalc();// for example
	 * } public static CalcFactory single() { return single; }
	 * 
	 * abstract double pow(double base, double expoente); } static class
	 * CalcJ2SE extends CalcFactory { double pow(double base, double expoente) {
	 * return pow(base, expoente); } } static class CalcJ2ME extends CalcFactory
	 * { double pow(double base, double expoente) {
	 * 
	 * return for....; } }
	 * 
	 * used CalcFactory math= CalcFactory.single(); mat.pow(1,2);
	 */

	private Coefficient() {
	}

	// wow 1 3 4 2 45 64.. magical numbers; Calcs normally can not be method,
	// are functions.
	// Functions are statics.

	final static double aCoeff(double eccentricityOne) {
		return (1 + 3 / 4 * pow(eccentricityOne, 2) + 45 / 64
				* pow(eccentricityOne, 4) + 175 / 256 * pow(eccentricityOne, 6)
				+ 11025 / 16384 * pow(eccentricityOne, 8) + 43656 / 65536 * pow(
				eccentricityOne, 10));
	}

	// wow 3 4 2 15 16.. magical numbers
	final static double bCoeff(double eccentricityOne) {
		return (3 / 4 * pow(eccentricityOne, 2) + 15 / 16
				* pow(eccentricityOne, 4) + 525 / 512 * pow(eccentricityOne, 6)
				+ 2205 / 2048 * pow(eccentricityOne, 8) + 72765 / 65536 * pow(
				eccentricityOne, 10));
	}

	// wow 15 64 4 105.. magical numbers
	final static double cCoeff(double eccentricityOne) {
		return (15 / 64 * pow(eccentricityOne, 4) + 105 / 256
				* pow(eccentricityOne, 6) + 2205 / 4096
				* pow(eccentricityOne, 8) + 10395 / 16384 * pow(
				eccentricityOne, 10));
	}

	// wow 1 3 4 2 45 64.. magical numbers
	final static double dCoeff(double eccentricityOne) {
		return (35 / 512 * pow(eccentricityOne, 6) + 315 / 2048
				* pow(eccentricityOne, 8) + 31185 / 131072 * pow(
				eccentricityOne, 10));
	}// wow 315 16384.. magical numbers

	final static double eCoeff(double eccentricityOne) {
		return (315 / 16384 * pow(eccentricityOne, 8) + 3465 / 65536 * Math
				.pow(eccentricityOne, 10));
	}

	// wow 639 131072.. magical numbers
	final static double fCoeff(double eccentricityOne) {
		return (639 / 131072 * pow(eccentricityOne, 10));
	}

	// to be magical numbers, better write names for numbers
	// and to example the performance better is to declared
	// static type varName= 639/131072, but warning operators precedence.
	final static double sCoeff(double majorAxis, double lat,
			double eccentricityOne, double aCoeff, double bCoeff,
			double cCoeff, double dCoeff, double eCoeff, double fCoeff) {
		return ((majorAxis) * (1 - pow(eccentricityOne, 2)) * (aCoeff
				* (lat * Math.PI / 180) - 1 / 2 * bCoeff
				* Math.sin(2 * Math.toRadians(lat)) + 1 / 4 * cCoeff
				* Math.sin(4 * Math.toRadians(lat)) - 1 / 6 * dCoeff
				* Math.sin(6 * Math.toRadians(lat)) + 1 / 8 * eCoeff
				* Math.sin(8 * Math.toRadians(lat)) - 1 / 10 * fCoeff
				* Math.sin(10 * Math.toRadians(lat))));
	}

	final static double i(double sCoeff) {
		return IConstants.K0 * sCoeff;
	}

	final static double iIP2(double n, double lat, double p) {
		return (n * Math.sin(Math.toRadians(lat))
				* Math.cos(Math.toRadians(lat))
				* pow(IConstants.SIN_ONE_SECOND, 2) / 2
				* pow(IConstants.K0 * 10, 8) * pow(p, 2));
	}

	final static double iIP4(double n, double lat, double eccentricityTwo,
			double p) {
		return (pow(IConstants.SIN_ONE_SECOND, 4) * n
				* Math.sin(Math.toRadians(lat))
				* pow(Math.cos(Math.toRadians(lat)), 3) / 24)
				* (5 - (pow(Math.tan(Math.toRadians(lat)), 2)) + 9
						* pow(eccentricityTwo, 2)
						* pow(Math.cos(Math.toRadians(lat)), 2) + 4
						* pow(eccentricityTwo, 4)
						* pow(Math.cos(Math.toRadians(lat)), 4))
				* IConstants.K0 * pow(10, 16) * pow(p, 4);
	}

	final static double iVP(double n, double lat, double p) {
		return (n * Math.cos(Math.toRadians(lat)) * IConstants.SIN_ONE_SECOND
				* IConstants.K0 * pow(10, 4))
				* p;
	}

	final static double VP3(double n, double lat, double p,
			double eccentricityTwo) {
		return (pow(IConstants.SIN_ONE_SECOND, 3) * n
				* pow(Math.cos(Math.toRadians(lat)), 3) / 6)
				* (1 - (pow(Math.tan(Math.toRadians(lat)), 2) + pow(
						eccentricityTwo, 2)
						* pow(Math.cos(Math.toRadians(lat)), 2))
						* IConstants.K0) * pow(10, 12) * pow(p, 3);
	}

	final static double a6P6(double n, double lat, double eccentricityTwo,
			double p) {
		return ((pow(IConstants.SIN_ONE_SECOND, 6) * n
				* Math.sin(Math.toRadians(lat))
				* pow(Math.cos(Math.toRadians(lat)), 5) / 720)
				* (61 - 58 * pow(Math.tan(Math.toRadians(lat)), 2)
						+ pow(Math.tan(Math.toRadians(lat)), 4) + 270
						* pow(eccentricityTwo, 2)
						* pow(Math.cos(Math.toRadians(lat)), 2) - 330
						* pow(eccentricityTwo, 2)
						* pow(Math.sin(Math.toRadians(lat)), 2) * IConstants.K0) * pow(
				10, 24)) * pow(p, 6);
	}

	final static double b5P5(double n, double lat, double eccentricityTwo,
			double p) {
		return (pow(IConstants.SIN_ONE_SECOND, 5) * n
				* pow(Math.cos(Math.toRadians(lat)), 5) / 120)
				* (5 - 18 * pow(Math.tan(Math.toRadians(lat)), 2)
						+ pow(Math.tan(Math.toRadians(lat)), 4) + 14
						* pow(eccentricityTwo, 2)
						* pow(Math.cos(Math.toRadians(lat)), 2) - 58
						* pow(eccentricityTwo, 2)
						* pow(Math.sin(Math.toRadians(lat)), 2))
				* IConstants.K0 * pow(10, 20) * pow(p, 5);
	}

}
