/*

Questão 5:

O seguinte código exibiu o valor 10.

int acumulador = 0;

for(int i = 0; i < a.length; i++) {

   acumulador += a[i];
   i++;

}

System.out.println(acumulador);

Indique qual das opções contem os valores do array a:

Respsota: {2, 4, 6, 0, 2}

*/

public class Q5 {

    public static void main(String[] args) {

        int acumulador = 0;
        int[] a = {2, 4, 6, 0, 2};

        for(int i = 0; i < a.length; i++) {

            acumulador += a[i];
            i++;
         
        }
         
        System.out.println(acumulador);

    }
    
}