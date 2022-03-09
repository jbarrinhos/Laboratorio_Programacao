# Laboratorio_programacao

Exercício 1

Considere que se pretende desenvolver uma aplicação para registo de navios num porto marítimo. Um navio é genericamente caracterizado pela seguinte informação:

    Identificador do Navio (String),
    nome (String),
    ano de construção (Date) e
    comprimento (float).

Um navio porta-contentores é um navio com atributo adicional, o número máximo de contentores (int).
Um navio petroleiro é um navio com atributo adicional capacidade de carga (float), em toneladas.

Codifique as classes Navio, PortaContentores e Petroleiro, que representam respetivamente um navio qualquer, um navio porta-contentores e um navio petroleiro, incluindo construtores, métodos de acesso (getters) e mutação (setters).

    Escreva a função main() para testar a classe ContaBancária. Crie uma conta, efetue depósitos e levantamentos e imprima no ecrã a informação da conta sempre que atualiza o saldo.

Exercício 2

Implemente uma classe Porto (apenas os atributos e construtor) para armazenar a informação sobre a atracagem de navios (use o tipo de coleção que considerar mais apropriado).

A classe deve incluir métodos para (nota: pode adicionar métodos às classes anteriores se necessário):

• Adicionar um novo navio sem permitir a duplicação da Identificador do Navio;
• Devolver a quantidade máxima total de contentores de todos os navios porta-contentores atracados no porto;
• Devolver a capacidade total de carga de todos os navios porta-contentores e petroleiros atracados no porto, sabendo que um contentor tem capacidade para 10 toneladas;

Exercicio 3

    Escreva as instruções necessárias, no método main(...), para criar um Porto com um navio petroleiro e um navio porta contentores (utilize qualquer valor para os parâmetros com um tipo de dados válido). Utilize o método para adicionar um novo navio. Valide que não é possível repetir a matrícula de navio, num mesmo porto.
