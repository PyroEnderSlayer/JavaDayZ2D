package pyrotuliq.proz.internal;

public class IDConflictError extends Error {
	private static final long serialVersionUID = -2095581618591019720L;

	public IDConflictError() {
		super();
	}
	
	public IDConflictError(String reason) {
		super(reason);
	}
}
