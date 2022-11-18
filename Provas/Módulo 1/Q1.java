/*

Questão 1:

Considerando que todas as variáveis são inteiros com o valor 10, qual o valor de x ao final da execução do código abaixo:

x += x;
x += y;
x /= y;
++x;
x++;

Resposta: 5

*/

public class Q1 {

    public static void main(String[] args) {

        int x = 10, y = 10;

        x += x;
        x += y;
        x /= y;
        ++x;
        x++;

        System.out.println(x);

    }
    
}