import java.util.concurrent.Semaphore;

// Na barbearia há um barbeiro, uma cadeira de barbeiro e n cadeiras para eventuais clientes esperarem a vez. 
// Quando não há clientes, o barbeiro senta-se na cadeira de barbeiro e cai no sono. 
// Quando chega um cliente, ele precisa acordar o barbeiro. 
// Se outros clientes chegarem enquanto o barbeiro estiver cortando o cabelo de um cliente, 
// eles se sentarão (se houver cadeiras vazias) ou sairão da barbearia (se todas as cadeiras estiverem ocupadas).

public class Principal {
    public static void main(String[] args) {
        Barbearia barbearia = new Barbearia();

        Barbeiro barbeiro = new Barbeiro(barbearia);
        GeradorCliente geradorCliente = new GeradorCliente(barbearia);

        Thread threadBarbeiro = new Thread(barbeiro);
        Thread threadGeradorCliente = new Thread(geradorCliente);

        threadBarbeiro.start();
        threadGeradorCliente.start();
    }
}