# Trabalho-Estrutura-de-Dados
Trabalho de Estruturas de Dados da produção de um gerenciador de processos. Grupo: Arthur Bandeira Miranda Monte, Amanda Passos Ribeiro.
Este projeto implementa um escalonador de processos em Java utilizando listas duplamente encadeadas circulares desenvolvidas manualmente, sem uso de coleções prontas como ArrayList ou LinkedList. O objetivo do trabalho foi simular um sistema de escalonamento por prioridades, atendendo às regras de round-robin, anti-inanição e bloqueio por recurso de entrada e saída.

O funcionamento se baseia em três filas principais de processos, correspondentes às prioridades alta, média e baixa, além de uma fila de bloqueados. A cada ciclo de CPU o escalonador primeiro desbloqueia, se houver, um processo da fila de bloqueados, devolvendo-o para sua fila de origem. Em seguida, aplica-se a regra de seleção: normalmente são atendidos processos da fila de prioridade alta, depois média e por fim baixa. Para evitar inanição, após cinco execuções consecutivas da fila de alta prioridade o escalonador força a execução de um processo da fila de média prioridade, ou da baixa caso a média esteja vazia. A execução de um processo corresponde à redução de um ciclo em seu contador de ciclos necessários. Se ainda houver ciclos restantes, ele retorna ao final de sua fila de prioridade; caso contrário, é finalizado e removido. Se o processo solicitar recurso de disco, ele é imediatamente movido para a fila de bloqueados e não consome CPU naquele ciclo, sendo desbloqueado no início de ciclos futuros.

O código foi estruturado em classes separadas. A classe Processo modela os atributos exigidos no enunciado (id, nome, prioridade, ciclos e recurso necessário). A classe No representa cada nó da lista, contendo o processo e ponteiros para anterior e próximo. A classe ListaEncadeadaDuplaCiclica implementa a lista circular, com operações de inserção no final e remoção no início em tempo constante. A classe Scheduler contém as quatro filas e a lógica de escalonamento, com controle do contador de alta prioridade para a regra de anti-inanição, além do tratamento de bloqueio e desbloqueio. Por fim, a classe Main faz a leitura do arquivo de entrada no formato CSV e executa o laço principal, imprimindo no console os estados e eventos de cada ciclo.

O arquivo de entrada deve estar no formato CSV, com cada linha representando um processo, no padrão id;nome;prioridade;ciclos;recurso(opcional). O recurso pode ser deixado em branco ou definido como DISCO. Por exemplo:

1;Editor;1;5;DISCO  
2;Compilador;1;3;  
3;Navegador;2;4;  
4;Player;3;6;  


O programa lê esse arquivo, monta as filas iniciais e executa os ciclos até que todas as filas estejam vazias.

A compilação pode ser feita no terminal com javac src/*.java, e a execução é realizada com java -cp src Main processos.csv, considerando que o arquivo de entrada esteja na raiz do projeto. No IntelliJ IDEA também é possível rodar configurando o argumento de programa como o caminho do arquivo CSV.

Durante os testes, o escalonador foi submetido a arquivos de grande porte, incluindo um com 100.000 processos. O tempo total de execução deste caso foi de 3.66 segundos, demonstrando a eficiência da estrutura escolhida. Esse desempenho é explicado pela complexidade das operações: inserção, remoção e execução de um ciclo acontecem em tempo constante O(1), enquanto a leitura inicial do arquivo é O(n), proporcional ao número de processos. Assim, o tempo total cresce linearmente com a quantidade de processos.

A implementação do mecanismo de anti-inanição garante que processos de menor prioridade não fiquem indefinidamente sem execução, enquanto o bloqueio e desbloqueio por recurso de disco simulam de forma realista situações de espera por I/O. O principal gargalo identificado está na impressão do estado das filas a cada ciclo, que pode gerar um volume muito grande de logs quando se usa arquivos extensos, sendo recomendado limitar ou espaçar essas impressões em testes de carga.

Em conclusão, o trabalho atende aos requisitos propostos: utilização de listas próprias, escalonamento por prioridade com round-robin, tratamento de bloqueio e desbloqueio, entrada por arquivo externo, saída no console, implementação de anti-inanição e análise de complexidade. Além disso, os testes de desempenho comprovaram que a solução é escalável e capaz de lidar com dezenas de milhares de processos em poucos segundos.
