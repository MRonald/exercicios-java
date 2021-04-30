# Entrevista embaraçosa

## Enunciado

"A nutricionista Juliana Alcantra é uma excelente profissional de sua área. Em determinado dia, ela foi entrevistada ao vivo para um jornal da cidade. No entanto, ficou um pouco nervosa na hora, e diante da situação, sua fala ficou um pouco distorcida, repetindo o final de cada palavra após dizer a mesma. Para que isso não aconteça novamente, ela precisa da sua ajuda para escrever um programa que omita a parte repetida, de modo que as palavras sejam pronunciadas como deveriam ser.

Escreva um programa que, dada uma palavra errada, a mesma seja corrigida."

## Entrada

Haverá diversos casos de teste. Cada caso de teste é formado por uma palavra, de, no máximo, 30 caracteres, dita da forma errada. A entrada termina com fim de arquivo.

## Saída

Para cada caso de teste, escreva a palavra devidamente corrigida. Analise os exemplos para verificar o padrão, de modo a consertar todos os casos.

| Exemplo de entrada | Exemplo de saída |
| ------ | ------ |
| barrilarril | barril |
| ratoato | rato |
| solar | solar |
| coliseueu | coliseu |
| astroastro | astro |
| a | a |
| testetetete | testete |
|  | testetete |
| testandoando | testando |
| puxapuxaa | puxapuxa |
| puxaquepuxa | puxaquepuxa |
| agorasimassim | agorasimassim |
| agorassimassim | agorassim |
| masoquemasoqu | masoquemasoqu |
| abcdefghijklmnopqrstuvwxyzabcd | abcdefghijklmnopqrstuvwxyzabcd |
| abcdefghijklmnopqrstuvwxyzwxyz | abcdefghijklmnopqrstuvwxyz |
| bb | b |
| bbb | bb |
| bab | bab |
| baba | ba |
| aaaaaaaaaa | aaaaa |
|  | aaaaaa |
|  | aaaaaaa |
|  | aaaaaaaa |
|  | aaaaaaaaa |

## Entendendo a saída

O enunciado da questão não foi bem elaborado, por isso esse foi um dos desafios mais difíceis de concluir. Na verdade, o que se espera é que você consiga percorrer toda a palavra dividindo-a em duas partes (parteInicial e parteFinal por exemplo) e caso a parteInicial termine com a parteFinal, remova a repetição e mostre a palavra modificada. Caso não haja repetições a palavra original deve ser impressa. Exemplos:

- sanduicheiche -> parteInicial = 'sanduiche', parteFinal = 'iche'. Como 'sanduiche' termina em 'iche', imprimimos a parteInicial, que é 'sanduiche'.
- barrilarril -> parteInicial = 'barril', parteFinal = 'arril'. Como 'barril' termina em 'arril', imprimimos a parteInicial, que é 'barril'.
- sol -> Não há como dividir 'sol' de tal forma que a parteInicial termine com a parteFinal. Imprimimos 'sol'.

É importante ressaltar que uma palavra pode ser dividida de mais de uma forma, e cada uma delas deve ser impressa. Exemplos:

- testetetete
    1. parteInicial = 'testete', parteFinal = 'tete'. Como 'testete' termina em 'tete', imprimimos 'testete'
    1. parteInicial = 'testetete', parteFinal = 'te'. Como 'testetete' termina em 'te', imprimimos 'testetete'
- aaaaa
    1. parteInicial = 'aaa', parteFinal = 'aa'. Como 'aaa' termina em 'aa', imprimimos 'aaa'
    1. parteInicial = 'aaaa', parteFinal = 'a'. Como 'aaaa' termina em 'a', imprimimos 'aaaa'

Nestes casos em que uma palavra gera mais de uma saída, deve-se imprimir em ordem crescente de tamanho. Nos exemplos acima, 'aaa' vem antes de 'aaaa' e 'testete' vem antes de 'testetete'.

### JDK Version
Open JDK 11
