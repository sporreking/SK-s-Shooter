package sk.client;

public final class Time {
	
	private static final long startTimeNano = System.nanoTime();
	private static final long startTimeMilli = System.currentTimeMillis();
	
	private static long previousTime = getMilliTime();
	private static float delta = 0;
	
	private static double deltaStack = 0;
	private static int fpsCounter = 0;
	private static int fps = 0;
	
	public static final long getNanoTime() {
		return System.nanoTime() - startTimeNano;
	}
	
	public static final long getMilliTime() {
		return System.currentTimeMillis() - startTimeMilli;
	}
	
	public static final void update() {
		long currentTime = getMilliTime();
		delta = currentTime - previousTime;
//		delta /= 1000000;
		previousTime = currentTime;
		
		deltaStack += getDelta();
		fpsCounter++;
		if(deltaStack >= 1000) {
			fps = fpsCounter;
			deltaStack = 0;
			fpsCounter = 0;
		}
	}
	
	public static final float getDelta() {
		return delta;
	}
	
	public static final int getFPS() {
		return fps;
	}
}