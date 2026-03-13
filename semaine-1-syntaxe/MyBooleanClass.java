class MyBooleanClass{
    static Boolean xor (boolean a, boolean b) {
        if ((a&&b == true)||((!a)&&(!b) == true)){
            return false;
        }
    return true;
    }
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        System.out.println(MyBooleanClass.xor(a,b));   
    }

}
/*
class MyBooleanClass{
    static Boolean xor (boolean a, boolean b) {
        if ((a && b) || (!a && !b)){
            return false;
        }
    return true;
    }

static boolean xor(boolean a, boolean b) {
        return a != b; 
    }

*/

