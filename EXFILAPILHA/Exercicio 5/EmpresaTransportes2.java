package EX5;
import javax.swing.JOptionPane;
import java.util.Stack;

public class EmpresaTransportes2 {

    private static final int NUMERO_DE_PILHAS = 5;
    private static final int LIMITE_PILHA = 10;
    private static Stack<Produto>[] pilhasDeProdutos = new Stack[NUMERO_DE_PILHAS];

    public static void main(String[] args) {
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            pilhasDeProdutos[i] = new Stack<>();
        }

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

            mostrarPilhas();
        } while (opcao != 0);
    }

    private static int selecionarPilha() {
        int pilha = -1;
        do {
            pilha = Integer.parseInt(JOptionPane.showInputDialog("Selecione a pilha (1 a 5):")) - 1;
            if (pilha < 0 || pilha >= NUMERO_DE_PILHAS) {
                JOptionPane.showMessageDialog(null, "Pilha inválida! Por favor, selecione um número entre 1 e 5.");
            }
        } while (pilha < 0 || pilha >= NUMERO_DE_PILHAS);
        return pilha;
    }

    public static void adicionarProduto() {
        int pilhaSelecionada = selecionarPilha();

        if (pilhasDeProdutos[pilhaSelecionada].size() >= LIMITE_PILHA) {
            JOptionPane.showMessageDialog(null, "A pilha " + (pilhaSelecionada + 1) + " está cheia! Não é possível adicionar mais produtos no momento.");
            return;
        }

        try {
            int codProduto = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite o código do produto:"));
            String descricao = JOptionPane.showInputDialog("Digite uma breve descrição do produto:");
            String dataEntrada = JOptionPane.showInputDialog("Digite a data de entrada (dd/mm/aaaa):");
            String ufOrigem = JOptionPane.showInputDialog("Digite a UF de origem:");
            String ufDestino = JOptionPane.showInputDialog("Digite a UF de destino:");

            Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
            pilhasDeProdutos[pilhaSelecionada].push(produto);
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso à pilha " + (pilhaSelecionada + 1) + "!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do produto inválido! Por favor, insira um número válido.");
        }
    }

    public static void retirarProduto() {
        int pilhaSelecionada = selecionarPilha();

        if (pilhasDeProdutos[pilhaSelecionada].isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha " + (pilhaSelecionada + 1) + " está vazia! Não há produtos para retirar no momento.");
        } else {
            Produto produto = pilhasDeProdutos[pilhaSelecionada].pop();
            JOptionPane.showMessageDialog(null, "Produto retirado da pilha " + (pilhaSelecionada + 1) + ": " + produto);
        }
    }

    public static void mostrarPilhas() {
        StringBuilder estadoDasPilhas = new StringBuilder("Estado atual das pilhas:\n");
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            estadoDasPilhas.append("Pilha ").append(i + 1).append(":\n");
            if (pilhasDeProdutos[i].isEmpty()) {
                estadoDasPilhas.append("  [Vazia]\n");
            } else {
                for (Produto produto : pilhasDeProdutos[i]) {
                    estadoDasPilhas.append("  ").append(produto).append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, estadoDasPilhas.toString());
    }
}