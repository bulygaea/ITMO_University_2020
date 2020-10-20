import static java.lang.Math.*;

public class Main {
	public static void main(String[] args) {
		long[] d = new long[7];
		int k = 7;
		for (int i = 0; i < 7; ++i) {
			d[i] = k;
			k += 2;
		}

		float[] x = new float[16];
		for (int i = 0; i < 16; ++i) {
			x[i] = (float) (random() * 18.0 - 15.0);
		}

		double[][] p = new double[7][16];
		for (int i = 0; i < 7; ++i) {
			for (int j = 0; j < 16; ++j) {
				if (d[i] == 15) {
					p[i][j] = 2 * pow(2/(0.25 + pow(x[j], (3-x[j])/2)), 2);
				} else if ((d[i] == 7) | (d[i] == 9) | (d[i] == 13)) {
					p[i][j] = pow(1./2 + asin(pow((x[j]-6)/18, 2)), 3);
				} else {
					p[i][j] = asin(sin(sin(atan(cos(x[j])))));
				}
				printMessage(p[i][j]);
			}
			System.out.println();
		}
	}

	public static void printMessage(double msg) {
		if ((msg < 0) || (msg >= 10.0)) {
			System.out.printf("  %.4f|", msg);
		} else if (msg >= 0) {
			System.out.printf("   %.4f|", msg);
		} else {
			System.out.printf("      %.4f|", msg);
		}

	}
}
