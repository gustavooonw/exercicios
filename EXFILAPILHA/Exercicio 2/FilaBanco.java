package EX2;

import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;



public class FilaBanco{

    private static Queue<Cliente> filaPrioritaria = new LinkedList<>();
    private static Queue<Cliente> filaNormal = new LinkedList<>();
    private static int contadorPrioritariosAtendidos = 0;
    private static int senhaAtual = 1;
    private static final int ANO_ATUAL = 2024;

    public static void main(String[] args) {
        int opcao = -1;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Adicionar cliente\n"
                    + "2 - Chamar cliente\n"
                    + "0 - Sair"));

            if (opcao == 1) {
                executaOpcao01();
            } else if (opcao == 2) {
                executaOpcao02();
            }

        } while (opcao != 0);
    }

    public static void executaOpcao01() {
        try {
            String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
            int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do cliente:"));

            Cliente cliente = new Cliente(senhaAtual++, nome, anoNascimento);
            if (cliente.getIdade(ANO_ATUAL) > 65) {
                filaPrioritaria.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente " + nome + " adicionado à fila prioritária.");
            } else {
                filaNormal.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente " + nome + " adicionado à fila normal.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano de nascimento inválido! Por favor, insira um número.");
        }
    }

    public static void executaOpcao02() {
        if (contadorPrioritariosAtendidos < 2 && !filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.poll();
            JOptionPane.showMessageDialog(null, "Atendendo cliente prioritário: " + cliente);
            contadorPrioritariosAtendidos++;
        } else if (!filaNormal.isEmpty()) {
            Cliente cliente = filaNormal.poll();
            JOptionPane.showMessageDialog(null, "Atendendo cliente normal: " + cliente);
            contadorPrioritariosAtendidos = 0; // reset counter after a normal client is attended
        } else if (!filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.poll();
            JOptionPane.showMessageDialog(null, "Atendendo cliente prioritário: " + cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Não há clientes na fila.");
        }
    }
}