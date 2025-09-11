import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scheduler s = new Scheduler();

        try (BufferedReader br = new BufferedReader(new FileReader("processos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue; // ignora vazio ou comentário
                String[] t = line.split(";");
                int id = Integer.parseInt(t[0].trim());
                String nome = t[1].trim();
                int prioridade = Integer.parseInt(t[2].trim());
                int ciclos = Integer.parseInt(t[3].trim());
                String recurso = (t.length > 4 && !t[4].trim().isEmpty()) ? t[4].trim() : null;

                Processo p = new Processo(id, nome, prioridade, ciclos, recurso);
                s.adicionarProcesso(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }


        int ciclo = 1;
        while (s.temTrabalho()) {
            System.out.println("===== CICLO " + (ciclo++) + " =====");
            s.executarCicloDeCPU();
        }
    }
}