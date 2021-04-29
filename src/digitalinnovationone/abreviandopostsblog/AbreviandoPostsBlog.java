package digitalinnovationone.abreviandopostsblog;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AbreviandoPostsBlog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if(st.countTokens() > 0) {
            //Cria um map auxiliar
            Map<String, Long> mapAuxiliar = new HashMap<>();
            //Cria a lista
            List<String> frase = new ArrayList<>();

            //Cria variável de controle
            var controle = 0;
            //Enquanto o controle for igual a ZERO, continua executando
            while (controle == 0) {
                //Preenche a lista
                while (st.hasMoreTokens()) {
                    frase.add(st.nextToken());
                }
                //Testa se o primeiro elemento não é PONTO
                if (!frase.get(0).equals(".")) {
                    String palavraAtual = "";
                    String letraInicial = "";
                    Integer tamanhoDaPalavra = 0;
                    Long numeroDeRepeticoes = 0L;
                    //Para cada elemento da lista, faz:
                    for (int i = 0; i < frase.size(); i++) {
                        //Pega a palavra na lista se tiver mais que 2 caracteres
                        if (frase.get(i).length() > 2) {
                            palavraAtual = frase.get(i);
                            tamanhoDaPalavra = frase.get(i).length();
                            //Verifica quantas vezes ela se repete
                            var palavraAtualAux = palavraAtual;
                            letraInicial = palavraAtualAux.substring(0, 1);
                            numeroDeRepeticoes = frase.stream().filter(x -> x.matches(palavraAtualAux)).count();
                            //Verifica se a palavra atual economiza mais letras do que a que inicia com a mesma letra dentro do map
                            var letraInicialAux = letraInicial;
                            //Armazena a palavra que tem a mesma inicial no mapAuxiliar
                            var palavraGravada = mapAuxiliar.entrySet().stream().filter(x -> x.getKey().startsWith(letraInicialAux)).collect(Collectors.toList());
                            //Se existir uma palavra com a mesma inicial no mapAuxiliar, coloca abreviação na lista
                            if (palavraGravada.isEmpty()) {
                                //Substitui com a inicial, seguida de ponto, em todas as ocorrências na lista
                                abreviarPalavras(numeroDeRepeticoes, frase, palavraAtual, letraInicial);
                            }
                            //Armazena a palavra atual e a quantidade de repetições
                            mapAuxiliar.put(palavraAtual, numeroDeRepeticoes);
                            if (!palavraGravada.isEmpty()) {
                                var tamanho = palavraGravada.get(0).getKey().length();
                                var repeticoes = palavraGravada.get(0).getValue();
                                var economiaPalavraGravada = (tamanho * repeticoes) - (repeticoes * 2);
                                //Compara com a palavra atual
                                int economiaPalavraAtual = (tamanhoDaPalavra * numeroDeRepeticoes.intValue()) - (numeroDeRepeticoes.intValue() * 2);
                                if (economiaPalavraAtual > economiaPalavraGravada) {
                                    //Restaura a palavra original em todos os registros na lista
                                    for (int j = 0; j < repeticoes; j++) {
                                        frase.set(frase.indexOf(letraInicial + "."), palavraGravada.get(0).getKey());
                                    }
                                    //Remove a palavra gravada do mapAuxiliar
                                    mapAuxiliar.remove(palavraGravada.get(0).getKey());
                                    //Armazena a palavra atual e a quantidade de repetições
                                    mapAuxiliar.put(palavraAtual, numeroDeRepeticoes);
                                    //Substitui com a inicial, seguida de ponto, em todas as ocorrências na lista
                                    abreviarPalavras(numeroDeRepeticoes, frase, palavraAtual, letraInicial);
                                } else if (economiaPalavraAtual < economiaPalavraGravada || economiaPalavraAtual == economiaPalavraGravada) {
                                    mapAuxiliar.remove(palavraAtual);
                                }
                                //Esvazia a lista "palavraGravada"
                                palavraGravada.clear();
                            }
                        }
                    }
                    //Imprime a frase abreviada
                    System.out.println(frase.stream().map(x -> x.concat(" ")).collect(Collectors.joining()));
                    //Imprime a quantidade de palavras abreviadas
                    System.out.println(mapAuxiliar.size());
                    //Imprime a tabela com o número de vezes que a palavra se repetiu
                    mapAuxiliar.keySet().stream().map(x -> x.substring(0, 1).concat(". = ").concat(x)).sorted().forEach(System.out::println);
                    //Esvazia a lista
                    frase.clear();
                    //Esvazia o map
                    mapAuxiliar.clear();
                    //Espera o usuário digitar uma nova frase ou o PONTO pra encerrar o processamento
                    st = new StringTokenizer(br.readLine());
                } else if(frase.get(0).equals(".")){
                    controle = 1;
                }
            }
        }
    }

    public static void abreviarPalavras(Long numeroDeRepeticoes, List<String> frase, String palavraAtual, String letraInicial){
        for (int i = 0; i < numeroDeRepeticoes; i++) {
            var indice = frase.indexOf(palavraAtual);
            frase.set(indice, letraInicial + ".");
        }
    }
}