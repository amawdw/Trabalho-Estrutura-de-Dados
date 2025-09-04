public class No {
  private No proximo;
  private No anterior;
  private String processos;

    public No(No proximo, No anterior, String processos) {
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

    public String getProcessos() {
        return processos;
    }

    public void setProcessos(String processos) {
        this.processos = processos;
    }

}
