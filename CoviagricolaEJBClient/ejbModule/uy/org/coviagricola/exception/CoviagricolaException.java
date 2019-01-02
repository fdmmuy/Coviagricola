package uy.org.coviagricola.exception;

public class CoviagricolaException extends Exception{

		private static final long serialVersionUID = 1L;

		public CoviagricolaException() {
			super();
		}

		public CoviagricolaException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public CoviagricolaException(String message, Throwable cause) {
			super(message, cause);
		}

		public CoviagricolaException(String message) {
			super(message);
		}

		public CoviagricolaException(Throwable cause) {
			super(cause);
		}
		
		
	
	

}
