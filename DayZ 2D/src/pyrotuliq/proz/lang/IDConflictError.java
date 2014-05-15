package pyrotuliq.proz.lang;

public class IDConflictError extends Error {
	public IDConflictError() {
		super();
	}
	
	public IDConflictError(String reason) {
		super(reason);
	}
}
