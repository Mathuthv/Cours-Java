public class Capitalize {

    static void printCapitalized(String s){
        if (s == null) { throw new IllegalArgumentException("Chaîne Vide !");

        }
        char[] tab = new char[s.length()];
        for (int i=0; i< s.length(); i++){
            tab[i] = s.charAt(i);
        }
        String b = String.valueOf(s.charAt(0));
        int i = 1;
        while (i<s.length()){
            if (s.charAt(i) == ' '){
                String c = String.valueOf(s.charAt(i));
                b = b+c;
                i++;
                c = String.valueOf(s.charAt(i));
                b = b+(c.toUpperCase());
                i++;
            }
            String d = String.valueOf(s.charAt(i));
            b = b+d;
            i++;
        }
        System.out.println(b);

    }

    static void printCapitalized_1(String s){
        if (s == null) { throw new IllegalArgumentException("Chaine vide !");}
        String j = "";
        for (int i=0; i<s.length(); i++){
            if (i == 0){
                if (Character.isLetter(s.charAt(i))){
                char a = Character.toUpperCase(s.charAt(i));
                j = j + String.valueOf(a);
                }
                else{j= j + String.valueOf(s.charAt(i));}
            }
            else if (!(Character.isLetter(s.charAt(i-1)))  && Character.isLetter(s.charAt(i))){
                char a = Character.toUpperCase(s.charAt(i));
                j = j + String.valueOf(a);
            }
            else{ j= j + String.valueOf(s.charAt(i));}   
        }
        System.out.println(j); 
    }

    public static void main(String[] args) {
        printCapitalized_1(" Now is the time to act!");
    }

}