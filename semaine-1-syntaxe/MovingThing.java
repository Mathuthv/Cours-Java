class MovingThing {
    static double currentSpeed; 
    static double totalLength;

    static void move(double time){
        totalLength += (time * currentSpeed);
    }
    public static void main(String[] args) {
        MovingThing.currentSpeed = 10;
        MovingThing.move(50);
        System.out.println(MovingThing.totalLength);  
    }
}

/*
class MovingThing {
    // Variables privées : invisibles depuis l'extérieur [cite: 538, 539]
    private static double currentSpeed; 
    private static double totalLength;

    // "Setter" pour modifier la vitesse [cite: 540]
    static void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    // "Getter" pour lire la vitesse
    static double getCurrentSpeed() {
        return currentSpeed;
    }

    // "Getter" pour lire la distance (mais pas de "Setter" pour la modifier !)
    static double getTotalLength() {
        return totalLength;
    }

    // La méthode move reste la seule façon de faire augmenter totalLength [cite: 548, 549]
    static void move(double time) {
        totalLength += (time * currentSpeed);
    }
}

class Main {
    public static void main(String[] args) {
        // On ne peut plus faire MovingThing.currentSpeed = 10; -> Erreur
        MovingThing.setCurrentSpeed(10); 
        
        MovingThing.move(50);
        
        // On utilise le getter pour afficher le résultat
        System.out.println("Distance : " + MovingThing.getTotalLength()); 
    }
}
*/
