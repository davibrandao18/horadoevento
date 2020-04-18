package teste;

public class Teste {

	public boolean verificaLetrasENumeros(String senha) {
		char array [] = senha.toCharArray(); // transformando a String em um array de char
		boolean existeNumero = false;
		boolean existeLetra = false;
		
		for (int i = 0; i < array.length; i++) {
			// verifica se char é um numero:
			if (Character.isDigit(array[i])) {
				existeNumero = true;
			}
			// verifica se char NÃO é um numero
			if (! Character.isDigit(array[i])) {
				existeLetra = true;
			}
		}
		
		return (existeNumero && existeLetra);
	}
}