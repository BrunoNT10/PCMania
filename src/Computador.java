import java.util.Scanner;

public class Computador {
    String marca;
    float preco;
    HardwareBasico[] hardware = new HardwareBasico[5];
    MemoriaUSB memoriaUSB;
    SistemaOperacional sistemaOperacional;

    void mostraPCConfigs() {
        System.out.println("***************************");
        System.out.println("Marca: " + marca);
        System.out.println("Preco: R$" + preco);
        String unidade;

        for (int i=0; i<5; i++) {
            if (hardware[i] == null) {
                break;
            }
            if (i==0) {
                unidade = "Mhz";
            }
            else {
                if (hardware[i].capacidade >= 1000) {
                    unidade = "Tb";
                }
                else {
                    unidade = "Gb";
                }
            }
            if (unidade.equals("Tb")) {
                System.out.println(hardware[i].nome + " - " + hardware[i].capacidade/1000 + " " + unidade);
            }
            else{
                System.out.println(hardware[i].nome + " - " + hardware[i].capacidade + " " + unidade);
            }
        }
        System.out.println("Sistema Operacional: " + sistemaOperacional.nome +  " (" + sistemaOperacional.tipo + " bits)");

        if (memoriaUSB.capacidade >= 1000) {
            unidade = "Tb";
        }
        else {
            unidade = "Gb";
        };

        if (unidade.equals("Tb")) {
            System.out.println("Acompanha: " + memoriaUSB.nome +  " de " + memoriaUSB.capacidade/1000 + unidade);
        }
        else {
            System.out.println("Acompanha: " + memoriaUSB.nome +  " de " + memoriaUSB.capacidade + unidade);
        }
    }

    void addMemoriaUsb(MemoriaUSB musb) {
        memoriaUSB = musb;
    }

    void addSistemaOperacional(SistemaOperacional sOperacional) {
        sistemaOperacional = sOperacional;
    }

    void addHardwareBasico(HardwareBasico hardwareBasico) {
        for(int i=0; i<5; i++) {
            if (hardware[i] == null) {
                hardware[i] = hardwareBasico;
                break;
            }
        }
    }
}
