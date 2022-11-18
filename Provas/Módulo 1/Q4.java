/*

Questão 4:

O seguinte código exibiu os valor 1, 2, 3, 4 e 5.

for (int i = 0; i < a.length; i++) {

   System.out.println(a[i]);

}

Indique o código que exibirá os valores 5, 4, 3, 2 e 1.

Respsota: for (int i = a.length - 1; i >= 0; i--) { ... }

*/

public class Q4 {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};

        for (int i = 0; i < a.length; i++) {


            if (i != 4) {

                System.out.print(a[i] + ", ");

            }
            
            else {

                System.out.println(a[i]);

            }
         
        }

        for (int i = a.length - 1; i >= 0; i--) {


            if (i != 0) {

                System.out.print(a[i] + ", ");

            }
            
            else {

                System.out.println(a[i]);

            }
         
        }
        
    }
    
}