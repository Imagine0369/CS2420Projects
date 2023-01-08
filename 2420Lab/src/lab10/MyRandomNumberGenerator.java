package lab10;

public class MyRandomNumberGenerator implements RandomNumberGenerator {
	private int increment;
	private int multiplier;
	private int modulus;
	private int next;
	private int seed;
	
	
	public MyRandomNumberGenerator() {
		modulus = (2^16 + 1);
		multiplier = 75;
		increment = 74;
		next = 0;
	}
	
	@Override
	public int nextInt(int max) {
		// TODO Auto-generated method stub
		next = (((multiplier*next) + increment) % modulus);
		return (int)(next % max);
	}

	@Override
	public void setSeed(long seed) {
		next = (int)seed;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConstants(long const1, long const2) {
		
		// TODO Auto-generated method stub
		
	}

}
