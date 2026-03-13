class  MyMathClass {
    static int greatestDivisor (int a){
        for (int i = a-1; i>=1; i-- ){
            if (a%i == 0){
                return i;
            }
        }
    return 1;
    }

    static int smallestDivisor (int a){
        for (int i=2; i <= a; i++){
            if (a%i == 0){
                return i;
            }
        }
        return a;
    }

    static void exercice3 (){
        int[] counts = new int[10001];
        counts[0]=0;
        int max_i= 0;
        int max_num=0;
        for (int i=1; i<=10000; i++){
            int res =0;
            for (int j=1; j<=i; j++){
                if (i%j == 0){
                    res+=1;
                }
            if (max_num < res ) {
                max_num =res; 
                max_i=i;
            }
            counts[i]=res;
            }
        }
    System.out.println("Among integers between 1 and 10000,");
    System.out.println("The maximum number of divisors was " + max_num);
    System.out.println("Numbers with that many divisors include:");
    int j = 0;
    for (int i : counts){
        if (i == max_num){
            System.out.println("" + j);
        }
        j++;
    }
    }

    public static void main (String [] args){
    int a = 4659;
    int b = MyMathClass.greatestDivisor(a);
    int c = MyMathClass.smallestDivisor(4659);
    //System.out.println(b);
    //System.out.println(c);
    exercice3();
}

}




