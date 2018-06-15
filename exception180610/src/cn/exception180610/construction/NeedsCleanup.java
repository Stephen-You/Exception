package cn.exception180610.construction;

public class NeedsCleanup {
	private static long counter = 1;
	private final long id = counter++;
	public void dispose() {
		System.out.println("NeedsCleanup " + id + " disposed");
	}
}
