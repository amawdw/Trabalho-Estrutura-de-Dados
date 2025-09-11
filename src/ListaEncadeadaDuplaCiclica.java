public class ListaEncadeadaDuplaCiclica {
    private No cabeca;
    private No cauda;
    private int tamanho;

    public void addFinal(Processo p) {
        No novo = new No(p);
        if (cabeca == null) {
            cabeca = cauda = novo;
            novo.setProximo(novo);
            novo.setAnterior(novo);
        } else {
            novo.setAnterior(cauda);
            novo.setProximo(cabeca);
            cauda.setProximo(novo);
            cabeca.setAnterior(novo);
            cauda = novo;
        }
        tamanho++;
    }

    public boolean isVazia() { return cabeca == null; }
    public int tamanho() { return tamanho; }

    public Processo removeInicio() {
        if (cabeca == null) return null;
        No removido = cabeca;
        if (cabeca == cauda) { // um elemento só
            cabeca = cauda = null;
        } else {
            cabeca = cabeca.getProximo();
            cabeca.setAnterior(cauda);
            cauda.setProximo(cabeca);
        }
        tamanho--;
        return removido.getProcessos();
    }

    public Processo peekInicio() {
        return (cabeca == null) ? null : cabeca.getProcessos();
    }
}



