public class No {
  private No proximo;
  private No anterior;
  private String processos;

    public No(No proximo, No anterior, String processos) {
        this.proximo = null;
        this.anterior = null;
        this.processos = processos;
    }
    private No cabeça;
    private No cauda;
    private int tamanho;

}
