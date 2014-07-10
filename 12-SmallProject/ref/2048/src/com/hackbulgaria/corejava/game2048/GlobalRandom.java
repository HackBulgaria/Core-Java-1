package com.hackbulgaria.corejava.game2048;
public enum GlobalRandom implements Random {
	INSTANCE;

	private final java.util.Random random = new java.util.Random(12345);

	@Override
	public int nextInt(int n) {
		return random.nextInt(n);
	}

	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}

}
