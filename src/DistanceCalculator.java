public class DistanceCalculator
{
	private static final int SQUARE = 2;

	public double calculate(Customer from, Customer to)
	{
		double yLength = from.getHeight() - to.getHeight();
		double xLength = from.getWidth() - to.getWidth();
		
		double squareX = Math.pow(xLength, SQUARE);
		double squareY = Math.pow(yLength, SQUARE);

		double result = Math.sqrt(squareX+squareY);
		
		return result;
	}
}
