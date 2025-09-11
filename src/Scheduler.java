public class Scheduler {
    private ListaEncadeadaDuplaCiclica alta = new ListaEncadeadaDuplaCiclica();
    private ListaEncadeadaDuplaCiclica media = new ListaEncadeadaDuplaCiclica();
    private ListaEncadeadaDuplaCiclica baixa = new ListaEncadeadaDuplaCiclica();
    private ListaEncadeadaDuplaCiclica bloqueados = new ListaEncadeadaDuplaCiclica();

    private int contadorAlta = 0;

    public void adicionarProcesso(Processo p) {
        if (p.getPrioridade() == 1) alta.addFinal(p);
        else if (p.getPrioridade() == 2) media.addFinal(p);
        else baixa.addFinal(p);
    }

    public boolean temTrabalho() {
        return !(alta.isVazia() && media.isVazia() && baixa.isVazia() && bloqueados.isVazia());
    }
    public void executarCicloDeCPU() {
        Processo desbloq = bloqueados.removeInicio();
        if (desbloq != null) adicionarProcesso(desbloq);

        Processo atual = null;

        if (contadorAlta >= 5) {
            if (!media.isVazia()) {
                atual = media.removeInicio();
            } else if (!baixa.isVazia()) {
                atual = baixa.removeInicio();
            }
            contadorAlta = 0;
        }

        if (atual == null) {
            if (!alta.isVazia()) { atual = alta.removeInicio(); contadorAlta++; }
            else if (!media.isVazia()) { atual = media.removeInicio(); contadorAlta = 0; }
            else if (!baixa.isVazia()) { atual = baixa.removeInicio(); contadorAlta = 0; }
        }

        if (atual == null) return;

        if ("DISCO".equalsIgnoreCase(atual.getRecursonescessario())) {
            atual.setRecursonescessario(null);
            bloqueados.addFinal(atual);
            System.out.println("[BLOQUEIO] " + atual.getNome() + " foi para bloqueados.");
            return;
        }

        atual.setCiclosnescessarios(atual.getCiclosnescessarios()- 1);
        System.out.println("[EXEC] " + atual.getNome() + " (restam " + atual.getCiclosnescessarios() + ")");

        if (atual.getCiclosnescessarios() > 0) {
            adicionarProcesso(atual);
        } else {
            System.out.println("[FIM] " + atual.getNome() + " terminou.");
        }
    }

}
