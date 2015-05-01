package sk.client.debug;

public final class Debug {
	
	public static final void log(Object o) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		
		System.out.println("[" + ste.getFileName().split("\\.")[0] + ":"
				+ ste.getLineNumber() + "] " + o.toString());
	}
	
	public static final void log(Object... o) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < o.length; i++) {
			sb.append(o[i].toString());
			if(i < o.length - 1)
				sb.append("\t");
		}
		
		log(sb.toString());
	}
	
	public static final void log() {
		
	}
}