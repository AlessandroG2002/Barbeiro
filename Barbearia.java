import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Barbearia {
    int numCadeiras = 3;
    List<Cliente> listaCliente = new LinkedList<Cliente>();

    public void fazerCorte()
    {
        Cliente clienteAtual;
        System.out.println("Barbeiro esperando...");

        synchronized (listaCliente)
        {
            while(listaCliente.size() == 0)
            {
                System.out.println("Barbeiro aguardando clientes, foi dormir.");
                try
                {
                    listaCliente.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Barbeiro viu cliente esperando e acordou!");
            clienteAtual = (Cliente)((LinkedList<Cliente>)listaCliente).poll(); // Retira o primeiro elemento da lista de clientes e atribui a variável cliente atual.
        }

        long duracaoDoCorte = 0;

        try
        {
            System.out.println("Realizando o corte do cliente "+clienteAtual.getName()+".");
            duracaoDoCorte = (long)(Math.random()*10); // Define uma duração aleatória como duração do corte.
            TimeUnit.SECONDS.sleep(duracaoDoCorte);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }

        System.out.println("Barbeiro completou o corte do cliente "+clienteAtual.getName()+" em "+ duracaoDoCorte +" segundos.");
        System.out.println("------------------");
    }

    public void adicionarCliente(Cliente cliente)
    {
        System.out.println("Cliente: "+cliente.getName()+" entrou na barbearia as "+cliente.getHorario()+".");
        System.out.println("---");

        synchronized (listaCliente)
        {
            if(listaCliente.size() == numCadeiras)
            {
                System.out.println("Nenhuma cadeira disponível para o cliente "+cliente.getName()+".");
                System.out.println("Cliente "+cliente.getName()+" sai da barbearia.");
                return;
            }

            ((LinkedList<Cliente>)listaCliente).offer(cliente); // Adiciona o cliente atual como o último da lista de clientes.
            System.out.println("Cliente "+cliente.getName()+" se sentou em uma cadeira.");

            if(listaCliente.size() < numCadeiras)
            {
                listaCliente.notify();
            }
        }
    }
}
