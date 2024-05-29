package EX3;
import javax.swing.JOptionPane;
import java.util.Stack;

public class Livraria {

    private static Stack<Livro> pilhaDeLivros = new Stack<>();

    public static void main(String[] args) {
        int opcao = -1;
        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                        + "1 - Adicionar livro\n"
                        + "2 - Listar livros\n"
                        + "3 - Retirar livro\n"
                        + "0 - Sair"));

                switch (opcao) {
                    case 1:
                        adicionarLivro();
                        break;
                    case 2:
                        listarLivros();
                        break;
                    case 3:
                        retirarLivro();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número.");
            }
        } while (opcao != 0);
    }

    public static void adicionarLivro() {
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        String autor = JOptionPane.showInputDialog("Digite o autor do livro:");

        if (titulo != null && !titulo.trim().isEmpty() && autor != null && !autor.trim().isEmpty()) {
            Livro livro = new Livro(titulo, autor);
            pilhaDeLivros.push(livro);
            JOptionPane.showMessageDialog(null, "Livro adicionado à pilha.");
        } else {
            JOptionPane.showMessageDialog(null, "Título ou autor inválido!");
        }
    }

    public static void listarLivros() {
        if (pilhaDeLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de livros está vazia.");
        } else {
            StringBuilder listaDeLivros = new StringBuilder("Livros na pilha:\n");
            for (Livro livro : pilhaDeLivros) {
                listaDeLivros.append(livro).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaDeLivros.toString());
        }
    }

    public static void retirarLivro() {
        if (pilhaDeLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de livros está vazia.");
        } else {
            Livro livro = pilhaDeLivros.pop();
            JOptionPane.showMessageDialog(null, "Livro removido da pilha: " + livro);
        }
    }
}