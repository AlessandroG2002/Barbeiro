// Aqui são onde vários clientes são gerados

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GeradorCliente extends Thread {
    Barbearia barbearia;

    public GeradorCliente(Barbearia barbearia)
    {
        this.barbearia = barbearia;
    }

    public void run()
    {
        while(true)
        {
            Cliente cliente = new Cliente(barbearia);
            cliente.setHorario(new Date());
            Thread threadCliente = new Thread(cliente);
            cliente.setName("C-"+threadCliente.threadId());
            threadCliente.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10)); // Esperar certo tempo até gerar outro cliente.
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
        
}