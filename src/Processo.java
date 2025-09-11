public class Processo {
    private int id;
    private String nome;
    private int prioridade;
    private String recursonescessario;

    public Processo(int id, String nome, int prioridade, String recursonescessario) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.recursonescessario = recursonescessario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getRecursonescessario() {
        return recursonescessario;
    }

    public void setRecursonescessario(String recursonescessario) {
        this.recursonescessario = recursonescessario;
    }
}
