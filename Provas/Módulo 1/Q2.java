/* 

Questão 2:

Considerando o código a seguir:

if (x) {

    System.out.println(1);

}

else if (y) {

    System.out.println(1);

}

else if (z) {

    System.out.println(1);

}

else {

    System.out.println(2);

}

Podemos afirmar que:

1. Sempre é exibida uma e apenas uma mensagem.
2. Basta que uma das variáveis x, y ou z seja falsa para ser exibida a mensagem "2".
3. Se y e z forem falsos, vai depender do valor de x para ser exibida a mensagem "1" ou "2".

Resposta: Apenas 1 e 3 são verdadeiras.

*/

public class Q2 {

    public static void main(String[] args) {

        boolean x = true, y = true, z = true;

        for (int i = 1; i <= 8; i++) {

            switch (i) {

                case 1:

                    x = true;
                    y = true;
                    z = true;
                    break;

                case 2:

                    x = true;
                    y = true;
                    z = false;
                    break;

                case 3:

                    x = true;
                    y = false;
                    z = true;
                    break;

                case 4:

                    x = true;
                    y = false;
                    z = false;
                    break;

                case 5:

                    x = false;
                    y = false;
                    z = false;
                    break;

                case 6:

                    x = false;
                    y = false;
                    z = true;
                    break;

                case 7:

                    x = false;
                    y = true;
                    z = false;
                    break;

                case 8:

                    x = false;
                    y = true;
                    z = true;
                    break;

            }

            System.out.print("x: " + x + " | y: " + y + " | z: " + z + " | Mensagem: ");

            if (x) {

                System.out.println(1);

            }
            
            else if (y) {

                System.out.println(1);

            }
            
            else if (z) {

                System.out.println(1);

            }
            
            else {

                System.out.println(2);

            }

        }

    }
    
}