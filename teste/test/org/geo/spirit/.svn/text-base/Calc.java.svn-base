package test.org.geo.spirit;

public interface Calc {
	double pow(double base, double expoente);

	 class FabricaConfigurada {
		private static Calc calc;
		private static boolean me = false;
		static {
			calc = me ? new CalcJ2me() : new CalcJ2se();
		}
		public static double pow(double a, double b) {
			return calc.pow(a, b);
		}
	}
}
