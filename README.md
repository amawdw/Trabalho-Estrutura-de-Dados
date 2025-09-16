# Trabalho-Estrutura-de-Dados
Trabalho de Estruturas de Dados da produção de um gerenciador de processos. Grupo: Arthur Bandeira Miranda Monte, Amanda Passos Ribeiro.
Este projeto implementa um escalonador de processos em Java. Para utilizar o código é necessário primeiro compilar os arquivos. Isso pode ser feito abrindo o terminal na pasta do projeto e executando o comando javac src/*.java. Após a compilação, a execução é feita com o comando java -cp src Main <arquivo.csv>, em que <arquivo.csv> representa o arquivo de entrada contendo os processos.

O arquivo de entrada deve ser um arquivo CSV, com os campos separados por ponto e vírgula. Cada linha deve seguir exatamente o formato id;nome;prioridade;ciclos;recurso(opcional). O campo id é um número inteiro único, o campo nome corresponde ao nome do processo, o campo prioridade deve ser preenchido com 1 para processos de alta prioridade, 2 para processos de prioridade média ou 3 para processos de prioridade baixa, e o campo ciclos é um número inteiro que indica quantos ciclos de CPU o processo precisa para terminar. O último campo, recurso, é opcional e pode ser deixado em branco ou preenchido com a palavra DISCO.

Um exemplo válido de arquivo é:

1;Editor;1;5;DISCO
2;Compilador;1;3;
3;Navegador;2;4;
4;Player;3;6;


Se o arquivo estiver salvo na raiz do projeto com o nome processos.csv, basta executar o comando java -cp src Main processos.csv para iniciar a simulação. Caso o arquivo possua outro nome, como processos_10000.csv ou processos_100000.csv, esse nome deve ser informado no lugar de processos.csv.

No IntelliJ IDEA também é possível executar o programa configurando o argumento de entrada. Para isso, deve-se colocar o arquivo CSV na raiz do projeto, acessar o menu Run → Edit Configurations…, e no campo Program arguments escrever o nome do arquivo, como por exemplo processos.csv. Feito isso, basta executar o projeto para que os resultados sejam exibidos no console.
