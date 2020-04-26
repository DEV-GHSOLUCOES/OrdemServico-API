package br.com.gh.os.domain.excepetion;

public class NegocioExcepetion extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public NegocioExcepetion(String message) {
		super(message);
	}

}
