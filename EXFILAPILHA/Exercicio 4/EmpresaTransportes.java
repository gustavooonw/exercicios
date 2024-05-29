package EX4;

import javax.swing.JOptionPane;
import java.util.Stack;


public class EmpresaTransportes {

    private static Stack<Produto> pilhaDeProdutos = new Stack<>();
    private static final int LIMITE_PILHA = 10;

    public static void main(String[] args) {
        int opcao = -1;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Bem-vindo ao sistema de controle de produtos!\n"
                    + "Selecione uma opção:\n"
                    + "1 - Adicionar um novo produto\n"
                    + "2 - Retirar um produto\n"
                    + "0 - Sair"));

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    retirarProduto();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema! Até a próxima.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma das opções disponíveis.");
            }

            mostrarPilha();
        } while (opcao != 0);
    }

    public static void adicionarProduto() {
        if (pilhaDeProdutos.size() >= LIMITE_PILHA) {
            JOptionPane.showMessageDialog(null, "A pilha está cheia! Não é possível adicionar mais produtos no momento.");
            return;
        }

        try {
            int codProduto = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite o código do produto:"));
            String descricao = JOptionPane.showInputDialog("Digite uma breve descrição do produto:");
            String dataEntrada = JOptionPane.showInputDialog("Digite a data de entrada (dd/mm/aaaa):");
            String ufOrigem = JOptionPane.showInputDialog("Digite a UF de origem:");
            String ufDestino = JOptionPane.showInputDialog("Digite a UF de destino:");

            Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
            pilhaDeProdutos.push(produto);
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do produto inválido! Por favor, insira um número válido.");
        }
    }

    public static void retirarProduto() {
        if (pilhaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha está vazia! Não há produtos para retirar no momento.");
        } else {
            Produto produto = pilhaDeProdutos.pop();
            JOptionPane.showMessageDialog(null, "Produto retirado: " + produto);
        }
    }

    public static void mostrarPilha() {
        if (pilhaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha está vazia.");
        } else {
            StringBuilder listaDeProdutos = new StringBuilder("Produtos atualmente na pilha:\n");
            for (Produto produto : pilhaDeProdutos) {
                listaDeProdutos.append(produto).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaDeProdutos.toString());
        }
    }
}