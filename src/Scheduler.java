public class Scheduler {
    private ListaEncadeadaDuplaCiclica alta = new ListaEncadeadaDuplaCiclica();
    private ListaEncadeadaDuplaCiclica media = new ListaEncadeadaDuplaCiclica();
    private ListaEncadeadaDuplaCiclica baixa = new ListaEncadeadaDuplaCiclica();
    private ListaEncadeadaDuplaCiclica bloqueados = new ListaEncadeadaDuplaCiclica();

    private int contadorAlta = 0; // para a regra de 5

    public void adicionarProcesso(Processo p) {
        if (p.getPrioridade() == 1) alta.addFinal(p);
        else if (p.getPrioridade() == 2) media.addFinal(p);
        else baixa.addFinal(p);
    }

    public boolean temTrabalho() {
        return !(alta.isVazia() && media.isVazia() && baixa.isVazia() && bloqueados.isVazia());
    }
    }
