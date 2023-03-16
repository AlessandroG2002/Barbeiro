// Nós vamos ter a classe Cliente e Barbeiro separadas, onde respectivamente, uma é responsável por fazer o serviço e outra por esperar o serviço.

public class Barbeiro extends Thread {
    Barbearia barbearia;

    public Barbeiro(Barbearia barbearia)
    {
        this.barbearia = barbearia;
    }
    public void run()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }

        System.out.println("Barbeiro iniciou o expediente.");
        while(true)
        {
            barbearia.fazerCorte();
        }
    }
}
