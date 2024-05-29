package EX5;

public class Produto {
    int codProduto;
    String descricao;
    String dataEntrada;
    String ufOrigem;
    String ufDestino;

    public Produto(int codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Código: " + codProduto + ", Descrição: " + descricao + ", Data de Entrada: " + dataEntrada +
                ", UF Origem: " + ufOrigem + ", UF Destino: " + ufDestino;
    }
}
