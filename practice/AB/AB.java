public class AB {
    public String createString(int N, int K) {
        char[] result = new char[N];
        int countA = 2;
        int posFixB = N - 1;
        int posMovB = N - 4;

    	if (N < 2 || N > 50)
            return "";

        if (K < 0 || K > (N-(N%2)) * (N+(N%2)) / 4)
            return "";

        if (K <= 2)
            countA = K;

        for (int i = 2; i < K; i++) {
            if (posFixB == (posMovB + 1)) {
                if ( countA == (N - posFixB) ) {
                    countA++;
                } else {
                    posFixB--;
                }

                posMovB = posFixB - countA;
            } else {
                posMovB++;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (i >= posFixB || i == posMovB) {
                result[i] = 'B';
            } else {
                if (countA > 0)
                    result[i] = 'A';
                else
                    result[i] = 'B';
                countA --;
            }
        }

        return new String(result);
    }

    /* Tests */
    public int getK(String input) {
        int K = 0;

        for (int i = 0; i < input.length(); i++) {
            char check = input.charAt(i);
            if ( check == 'A' ) {
                for (int j = i + 1; j < input.length(); j++) {
                    if ( input.charAt(j) == 'B' )
                        K++;
                }
            }
        }

        return K;
    }

    public String getString(int N, int posFixB, int posMovB, int countA) {
        char[] result = new char[N];

        for (int i = N - 1; i >= 0; i--) {
            if (i >= posFixB || i == posMovB) {
                result[i] = 'B';
            } else {
                if (countA > 0)
                    result[i] = 'A';
                else
                    result[i] = 'B';
                countA --;
            }
        }

        return new String(result);
    }

	public static void main(String[] args) {
		AB ab = new AB();

        for (int i = 2 ; i < 51 ; i++) {
            for (int j = 0; j < (i-(i%2))*(i+(i%2))/4; j++) {
                String result = "OK";
                if (ab.getK(ab.createString(i, j)) != j) {
                    result = "FALSE";
                }

                System.out.println("createString(" + i + ", " + j + ") = " + result);
            }
        }

	}

}
