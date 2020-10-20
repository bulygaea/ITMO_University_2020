public class Main
{
	public static void main (String[]args)
	{
		long[] d = new long[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		double[] x = new double[20];
		byte i, j;
		for (i = 0; i < 20; i++) {
			x[i] = (double)(Math.random() * 18) - 4;
		}
		double[][] b = new double[9][20];
		for (i = 0; i < 8; i++)
		{
			for (j = 0; j < 19; j++)
			{
				if (d[i] == 3)
				{
					b[i][j] = Math.asin(Math.sin(Math.cos(Math.cos(x[j]))));
				}
				if ((d[i] == 5) || (d[i] == 13) || (d[i] == 17) || (d[i] == 19))
				{
					b[i][j] = Math.log(Math.pow(Math.tan(Math.log(Math.exp(x[j]))),2));
				}
				else
				{
					b[i][j] = Math.cos(Math.tan(Math.cos(Math.atan((x[j]+5.0)/18.0))));
				}
				System.out.printf ("%.4f ", b[i][j]);
			}
		}
	}
}
