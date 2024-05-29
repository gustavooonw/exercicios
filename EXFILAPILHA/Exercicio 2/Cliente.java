package EX2;

public class Cliente {
    int senha;
    String nome;
    int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getIdade(int anoAtual) {
        return anoAtual - this.anoNascimento;
    }

    @Override
    public String toString() {
        return "Senha: " + senha + ", Nome: " + nome + ", Ano de Nascimento: " + anoNascimento;
    }
}
