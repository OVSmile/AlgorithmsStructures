import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        HashMap<String, String> hashMap1 = new HashMap<>(4);
        String oldValue = hashMap1.put("+79116481387", "Tom");
        oldValue = hashMap1.put("+79117513166", "Bob");
        oldValue = hashMap1.put("+79214657834", "Jim");
        oldValue = hashMap1.put("+79814626378", "Pit");
        oldValue = hashMap1.put("+79814646713", "Rob");
        oldValue = hashMap1.put("+79158562886", "Tom");
        oldValue = hashMap1.put("+79321356879", "Tor");
        oldValue = hashMap1.put("+79455468564", "Nek");
        oldValue = hashMap1.put("+79544658484", "Man");
        oldValue = hashMap1.put("+79138522453", "Mod");
        oldValue = hashMap1.put("+79436528981", "Lol");

        System.out.println(hashMap1);
        System.out.println();

//        for (HashMap.Entity e : hashMap1) {
//            System.out.println(e.key + " " + e.value);
//        }
        

//        String res1 = hashMap1.get("+79544658484");
//        String res2 = hashMap1.get("+79544658482");
//
//        String res3 = hashMap1.remove("+79436528981");
//        String res4 = hashMap1.remove("+79138522453");
//        String res5 = hashMap1.remove("+79138522453");


    }
}