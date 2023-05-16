package cadastrocliente;

/**
 * Classe que representa o cliente que será cadastrado
 *
 * @author Kayky Ribeiro Lima
 */
public class Cliente {

    private String nome;
    private int cpf;
    private int telefone;
    private Cliente proximo;

    /**
     * Retorna o próximo elemento da lista
     *
     * @return
     */
    public Cliente getProximo() {
        return this.proximo;
    }

    /**
     * Define o próximo elemento da lista
     *
     * @param proximo
     */
    public void setProximo(Cliente proximo) {
        this.proximo = proximo;
    }

    public Cliente() {
    }

    /**
     * Retorna o nome do cliente
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o CPF do cliente
     *
     * @return
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * Retorna o telefone do cliente
     *
     * @return
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Retorna todos os dados do cliente de forma organizada
     *
     * @return
     */
    public String getDados() {
        String dados = "CPF: " + this.getCpf() + "\n" + "Nome: " + this.getNome()
                + "\n" + "Telefone: " + this.getTelefone();
        return dados;
    }

    public Cliente(String nome, int cpf, int telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.proximo = null;
    }
}
