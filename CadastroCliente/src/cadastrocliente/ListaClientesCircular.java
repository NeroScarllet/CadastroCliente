package cadastrocliente;

/**
 * Classe de estrutura de dados em lista circular
 *
 *
 * @author Kayky Ribeiro Lima
 */
public class ListaClientesCircular {

    private Cliente cabeca;
    private Cliente cauda;

    public ListaClientesCircular() {
        this.cabeca = null;
        this.cauda = null;
    }

    /**
     * Adiciona o objeto no final da lista
     *
     * @param nome
     * @param cpf
     * @param telefone
     */
    public void adicionaNoFim(String nome, int cpf, int telefone) {
        Cliente novo = new Cliente(nome, cpf, telefone);
        if (this.cabeca == null) {
            this.cabeca = novo;
            this.cauda = novo;
        } else {
            Cliente temp = this.cauda;
            temp.setProximo(novo);
            this.cauda = novo;
        }
        this.cauda.setProximo(this.cabeca);
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
            Cliente anterior = this.cauda;
            Cliente proximo = this.cabeca;

            while (proximo != proximo && proximo.getCpf() != cpf) {
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
        while (posicao.getCpf() != cpf && posicao != posicao) {
            posicao = posicao.getProximo();
        }
        if (posicao != null && posicao.getCpf() == cpf) {
            return posicao.getDados();
        } else {
            throw new Exception();
        }
    }
}
