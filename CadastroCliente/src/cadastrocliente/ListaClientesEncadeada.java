package cadastrocliente;

/**
 * Classe de estrutura de dados em lista encadeada
 *
 * @author Kayky Ribeiro Lima
 */
public class ListaClientesEncadeada {

    private Cliente cabeca;

    public ListaClientesEncadeada() {
        this.cabeca = null;
    }

    /**
     * Adiciona objeto no final da lista
     *
     * @param nome
     * @param cpf
     * @param telefone
     */
    public void adicionaNoFim(String nome, int cpf, int telefone) {
        Cliente novo = new Cliente(nome, cpf, telefone);
        if (this.cabeca == null) {
            this.cabeca = novo;
        } else {
            Cliente ultimo = cabeca;
            while (ultimo.getProximo() != null) {
                ultimo = ultimo.getProximo();
            }
            ultimo.setProximo(novo);
        }
    }

    /**
     * Remove o objeto que contêm o parâmetro passado
     *
     * @param cpf
     */
    public void remove(int cpf) {
        if (this.cabeca != null && this.cabeca.getCpf() == cpf) {
            this.cabeca = this.cabeca.getProximo();
        } else {
            Cliente anterior = null;
            Cliente proximo = this.cabeca;

            while (proximo != null && proximo.getCpf() != cpf) {
                anterior = proximo;
                proximo = proximo.getProximo();
            }
            if (proximo != null) {
                anterior.setProximo(proximo.getProximo());
            }
        }
    }

    /**
     * Procura o cliente com base em seu CPF
     *
     * @param cpf
     * @return
     * @throws Exception
     */
    public String procuraCliente(int cpf) throws Exception {
        Cliente posicao = this.cabeca;
        while (posicao.getCpf() != cpf && posicao.getProximo() != null) {
            posicao = posicao.getProximo();
        }
        if (posicao != null && posicao.getCpf() == cpf) {
            return posicao.getDados();
        } else {
            throw new Exception();
        }
    }
}
