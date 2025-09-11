public class No {
  private No proximo;
  private No anterior;
  private Processo processos;

    public No(Processo processos) {
        this.proximo = null;
        this.anterior = null;
        this.processos = processos;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Processo getProcessos() {
        return processos;
    }

    public void setProcessos(Processo processos) {
        this.processos = processos;
    }
}
