/*

Questão 3:

Observando o método a seguir e as frases abaixo, podemos afirmar que:

public static boolean f(int x,int y) {

   if (x > y) return true;
   if (x < y) return true;
   if (x > 10) return false;
   return true;

}

1. Se a função retornar false, y é maior que 10
2. Se a função retornar true, x é maior que y
3. Se x e y forem iguais, a função retorna false

Respsota: Apenas 1 é verdadeira.

*/

public class Q3 {

    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {

            switch (i) {

                case 1:

                    System.out.print("x = 11 | y = 10 | x > y | Retorno: ");
                    System.out.println(f(11, 10));
                    break;

                case 2:

                    System.out.print("x = 11 | y = 12 | x < y | Retorno: ");
                    System.out.println(f(11, 12));
                    break;

                case 3:

                    System.out.print("x = 11 | y = 11 | x = y, x > 10 | Retorno: ");
                    System.out.println(f(11, 11));
                    break;

                case 4:

                    System.out.print("x = 10 | y = 10 | x = y | Retorno: ");
                    System.out.println(f(10, 10));
                    break;

            }

        }

    }

    public static boolean f(int x,int y) {

        if (x > y) return true;
        if (x < y) return true;
        if (x > 10) return false;
        return true;
     
    }
    
}