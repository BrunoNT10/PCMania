public class Cliente {
    String nome;
    long cpf;
    Computador[] computadores = new Computador[5];

    float calculaTotalCompra() {
        float valorTotalCompra = 0;
        for (int i = 0; i < 5; i++) {
            if (computadores[i] != null) {
                valorTotalCompra += computadores[i].preco;
            }
        }
        return valorTotalCompra;
    }
}
