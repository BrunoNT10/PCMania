import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        float matricula = 2064;
        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente();

        System.out.println("***************************");
        System.out.println("******** PCMania **********");
        System.out.println("***************************");

        System.out.print("Insira seu nome: ");
        cliente.nome = entrada.nextLine();
        System.out.print("Insira seu CPF: ");
        cliente.cpf = Long.parseLong(entrada.nextLine());

        Computador[] computadores = new Computador[3];

        String marcas[] = {"Apple", "Samsung", "Dell"};
        float precos[] = {matricula, matricula + 1234, matricula + 5678};

        String nomeHardware[][] = {
            {"Pentium Core i3", "Memória RAM", "HD"},
            {"Pentium Core i5", "Memória RAM", "HD"},
            {"Pentium Core i7", "Memória RAM", "HD"},
        };

        float capacidadeHardware[][] = {
            {2200, 8, 500},
            {3370, 16, 1000},
            {4500, 32, 2000},
        };

        String nomeSistemaOperacional[] = {"Linux Ubuntu", "Windows 8", "Windows 10"};
        int tipoSistemaOperacional[] = {32, 64, 64};

        String nomeMemoriaUsb[] = {"Pen-drive", "Pen-drive", "HD Externo"};
        int capacidadeMemoriaUsb[] = {16, 32, 1000};

        for (int i=0; i<3; i++) {
            computadores[i] = new Computador();
            computadores[i].marca = marcas[i];
            computadores[i].preco = precos[i];

            for (int j = 0; j < 3; j++) {
                HardwareBasico hardware = new HardwareBasico();
                hardware.nome = nomeHardware[i][j];
                hardware.capacidade = capacidadeHardware[i][j];
                computadores[i].addHardwareBasico(hardware);
            }

            SistemaOperacional sistemaOperacional = new SistemaOperacional();
            sistemaOperacional.nome = nomeSistemaOperacional[i];
            sistemaOperacional.tipo = tipoSistemaOperacional[i];
            computadores[i].addSistemaOperacional(sistemaOperacional);

            MemoriaUSB memoriaUSB = new MemoriaUSB();
            memoriaUSB.nome = nomeMemoriaUsb[i];
            memoriaUSB.capacidade = capacidadeMemoriaUsb[i];
            computadores[i].addMemoriaUsb(memoriaUSB);
        }

        for (int i=0; i<3; i++) {
            System.out.println("***************************");
            System.out.println("Promoção " + (i+1));
            computadores[i].mostraPCConfigs();
        }

        while (true) {
            System.out.println("Qual computador de qual promoção deseja comprar? ");
            System.out.println("1 - Promoção 1");
            System.out.println("2 - Promoção 2");
            System.out.println("3 - Promoção 3");
            System.out.println("0 - Finalizar compra");
            System.out.print("Digite sua escolha: ");
            int opcao = entrada.nextInt();
            if (opcao > 3 || opcao < 0) {
                System.out.println("Insira um dos valores válidos.");
                continue;
            }
            if (opcao != 0) {
                for(int k=0; k<5; k++) {
                    if (cliente.computadores[k] == null) {
                        cliente.computadores[k] = computadores[opcao - 1];
                        break;
                    }
                }
            }
            else {
                System.out.println("Compra finalizada com sucesso!");
                break;
            }
        }

        System.out.println("***************************");
        System.out.println("PCs adquiridos");
        for(int l=0; l<5; l++) {
            if (cliente.computadores[l] != null) {
                cliente.computadores[l].mostraPCConfigs();
            }
            else {
                break;
            }
        }

        float valorTotalCompra = cliente.calculaTotalCompra();

        System.out.println("***************************");
        System.out.println("Preço total em compras: R$" + valorTotalCompra);
        System.out.println("***************************");
        System.out.println("Obrigado por comprar na PCMania! Volte sempre!");
    }
}