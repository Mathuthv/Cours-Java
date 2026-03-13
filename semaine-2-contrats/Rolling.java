//package src.main.java;

public class Rolling {
    
    public static int getRandom(int min, int max) {

        if (max < min) {
            throw new IllegalArgumentException("Le max doit être >= min.");
        }

		int range = (max - min) + 1;
     	int random = (int) ((range * Math.random()) + min);
		return random;
	}

    public static int rolling_random(int a){
    int rep = 0;
    
    /*if (a!=2 && a!=3 && a!=4 && a!=5 && a!=6 && a!=7 && a!=8 && a!=9 && a!=10 && a!=11 && a!=12){
        throw new IllegalArgumentException("Erreur ! Valeur Incorrecte !");
    }*/

    if (a<2 || a>12){
        throw new IllegalArgumentException("Erreur ! Valeur Incorrecte !");
    }

    int res = 0;
    while(res != a){
        int d1 = getRandom(1,6);
        int d2 = getRandom(1,6);
        res = d1 + d2;
        rep++;
    }
    return rep;
    }

    public static double average(int a){
        if (a<2 || a>12){
        throw new IllegalArgumentException("Erreur ! Valeur Incorrecte !");
        }
        double succes = 0d;
        for (int i=1; i<=10000; i++){
            int res = rolling_random(a);
            if (res == a){ succes++;}
        }
        return succes/10000;
    }

    public static void main(String[] args) {
        System.out.println(rolling_random(6));
        System.out.println(rolling_random(2));
        System.out.println(average(4));
    
    }
}
