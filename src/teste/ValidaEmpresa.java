package teste;

import model.Empresa;
import service.EmpresaService;

/**
 * Valida as informa��es para cadastrar uma nova empresa
 *
 * @author Maicon Souza
 *
 */
public class ValidaEmpresa {

    /**
     * @param username
     * @param cnpj
     * @param senha
     * @return
     */
    public static boolean validacao(String username, String cnpj, String senha) {
        return (usernameDisponivel(username) && validaSenha(senha, username) && validaCnpj(cnpj));
    }

    /**
     * @param username
     * @return
     */
    public static boolean usernameDisponivel(String username) {
        EmpresaService es = new EmpresaService();
        Empresa empresa = es.carregar(username);
        return empresa == null;
    }

    /**
     * Verifica se a senha possui ao menos uma letra e um numero
     *
     * @param senha
     * @return true, caso a senha tiver ao menos uma letra e um numero
     */
    public static boolean letrasENumeros(String senha) {
        char array[] = senha.toCharArray(); // transforma a String em um array de char
        boolean existeNumero = false, existeLetra = false;

        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i]))
                existeNumero = true; // verifica se o char é um numero
            if (!Character.isDigit(array[i]))
                existeLetra = true; // verifica se o char é uma letra
        }
        return (existeNumero && existeLetra);
    }

    /**
     * Verifica se existe o nome de Empresa na senha
     *
     * @param senha
     * @param username
     * @return true, caso nao exista nome de Empresa na senha
     */
    public static boolean usernameNaSenha(String senha, String username) {
        return !senha.contains(username);
    }

    /**
     * Verifica se a senha atende o requisito de tamanho minimo permitido
     *
     * @param senha
     * @return true, caso a senha seja valida
     */
    public static boolean tamanhoMinimo(String senha) {
        return (senha.length() >= 8);
    }

    /**
     * Verifica se um cpf e "valido"
     *
     * @param cpf
     * @return true, caso o cpf seja valido
     */
    public static boolean validaCnpj(String cnpj) {
        return (cnpj.length() == 14);
    }

    /**
     * Conjunto de validacoes para a senha
     *
     * @param senha
     * @param username
     * @return true, caso todas as validacoes sejam bem sucedidas
     */
    public static boolean validaSenha(String senha, String username) {
        return letrasENumeros(senha) && usernameNaSenha(senha, username) && tamanhoMinimo(senha);
    }

}
