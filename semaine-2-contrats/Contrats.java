class Contrats {
    public static void randomFail(){
        double a = Math.random();
        if (a >= 0.5){
            throw new IllegalStateException("Erreur !");
        }
    }

    
    public static void main(String[] args){
        for (int i = 0; i<1; i--){
            randomFail();
        }
        
    }
}

/*
class Contrats {

    // La méthode de base (1 chance sur 2 de planter)
    public static void randomFail() {
        if (Math.random() < 0.5) {
            throw new IllegalStateException("Erreur dans randomFail !");
        }
    }

    // La nouvelle méthode demandée (Partie 2)
    public static void doubleFail() {
        randomFail(); // Appelle la première méthode
        
        // Puis a elle-même une chance sur deux de planter
        if (Math.random() < 0.5) {
            throw new IllegalStateException("Erreur dans doubleFail !");
        }
    }

    public static void main(String[] args) {
        // Pour la partie 2, on utilise une boucle infinie
        while (true) {
            doubleFail();
        }
    }
}

*/