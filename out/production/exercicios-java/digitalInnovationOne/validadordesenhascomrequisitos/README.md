# Validador de Senhas com Requisitos

## Enunciado

"Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro, e pediram a sua ajuda. Sua task é fazer o código que valide as senhas que são cadastradas, para isso você deve atentar aos requisitos a seguir:

- A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
- A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
- Além disso, a senha pode ter de 6 a 32 caracteres."

## Entrada

A entrada contém vários casos de teste e termina com final de arquivo. Cada linha tem uma string S, correspondente a senha que é inserida pelo usuário no momento do cadastro.

## Saída

A saída contém uma linha, que pode ser “Senha valida.”, caso a senha tenha cada item dos requisitos solicitados anteriormente, ou “Senha invalida.”, se um ou mais requisitos não forem atendidos.

| Exemplo de entrada | Exemplo de saída |
| ------ | ------ |
| Digital Innovation One
| AbcdEfgh99
| DigitalInnovationOne123
| Digital Innovation One 123
| Aass9
| Aassd9
| DIO123456
| Ano2020
| Digita!123 |  |

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
