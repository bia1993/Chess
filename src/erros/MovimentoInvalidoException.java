package erros;

@SuppressWarnings("serial")
public class MovimentoInvalidoException extends Exception {
	public MovimentoInvalidoException()
	{
		super("Movimento inválido!");
	}
}
