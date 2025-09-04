public class ListaEncadeadaDuplaCiclica {
    private No cabeca;
    private No cauda;
    private int tamanho;

    public void addFinalLista(String processo){
        No novoNO = new No(processo);
        if(cabeca==null){
            cabeca = novoNO;
            cauda = novoNO;
            cabeca.getProximo() = cabeca;
            cabeca.getAnterior() = cabeca;

        }else{
            novoNO.getAnterior() = cauda;
            novoNO.getProximo() = cabeca;
            cauda.getProximo() = novoNO;
            cabeca.getAnterior() = novoNO;
            cauda = novoNO;
        }
        tamanho++ cauda = novoNO;
    }
}


