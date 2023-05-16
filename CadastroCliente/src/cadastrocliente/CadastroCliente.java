package cadastrocliente;

import javax.swing.JOptionPane;

/**
 * Classe principal do projeto
 *
 * @author Kayky Ribeiro Lima
 */
public class CadastroCliente {

    public static void main(String[] args) {
        int escolha = 1;
        ListaClientesEncadeada lista = new ListaClientesEncadeada();
        ListaClientesCircular lista2 = new ListaClientesCircular();
        while (escolha != 0) {
            String pane = JOptionPane.showInputDialog(null, """
                                                             <0> Sair
                                                             <1> Cadastrar cliente do tipo 1 (Lista Encadeada)
                                                             <2> Cadastrar cliente do tipo 2 (Lista Circular)
                                                             <3> Consultar cliente
                                                             <4> Remover cliente""");
            escolha = Integer.parseInt(pane);
            switch (escolha) {
                case 1 -> {
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
                    String cpfS = JOptionPane.showInputDialog(null, "Digite o CPF do cliente");
                    int cpf = Integer.parseInt(cpfS);
                    String telefoneS = JOptionPane.showInputDialog(null, "Digite o telefone de contato do cliente");
                    int telefone = Integer.parseInt(telefoneS);
                    lista.adicionaNoFim(nome, cpf, telefone);
                }
                case 2 -> {
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
                    String cpfS = JOptionPane.showInputDialog(null, "Digite o CPF do cliente");
                    int cpf = Integer.parseInt(cpfS);
                    String telefoneS = JOptionPane.showInputDialog(null, "Digite o telefone de contato do cliente");
                    int telefone = Integer.parseInt(telefoneS);
                    lista2.adicionaNoFim(nome, cpf, telefone);
                }
                case 3 -> {
                    pane = JOptionPane.showInputDialog(null, "Digite o CPF do cliente a ser consultado");
                    int cpfC = Integer.parseInt(pane);

                    try {
                        JOptionPane.showMessageDialog(null, lista.procuraCliente(cpfC));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, """
                                                            Não existe nenhum cliente do tipo 1 cadastrado com este CPF
                                                            
                                                            Realizando consulta de cliente tipo 2...""");
                        try {
                            JOptionPane.showMessageDialog(null, lista2.procuraCliente(cpfC));
                        } catch (Exception ex2) {
                            JOptionPane.showMessageDialog(null, "Não existe nenhum cliente do tipo 2 cadastrado com este CPF");
                        }
                    }
                }
                case 4 -> {
                    pane = JOptionPane.showInputDialog(null, "Digite o CPF do cliente a ser removido");
                    int cpfC = Integer.parseInt(pane);
                    lista.remove(cpfC);
                    lista2.remove(cpfC);
                }

            }
        }

    }
}
