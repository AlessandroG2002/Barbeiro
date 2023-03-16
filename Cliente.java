// Nós vamos ter a classe Cliente e Barbeiro separadas, onde respectivamente, uma é responsável por fazer o serviço e outra por esperar o serviço.
// Ao chamar o run de cliente, ele automáticamente irá iniciar a função irFazerCorte que faz com que o cliente vá a barbearia.

import java.util.Date;

public class Cliente extends Thread {
    private String nome;
    private Date horario;

    Barbearia barbearia;

    public Cliente(Barbearia barbearia)
    {
        this.barbearia = barbearia;
    }
    
    public String getNome() {
        return nome;
    }

    public Date getHorario() {
        return horario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void run()
    {
        irFazerCorte();
    }

    private synchronized void irFazerCorte()
    {
        barbearia.adicionarCliente(this);
    }
}
