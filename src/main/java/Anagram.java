import java.util.HashMap;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        char[] charArrayA = a.toLowerCase().toCharArray();
        char[] charArrayB = b.toLowerCase().toCharArray();
        HashMap<Character, Integer> hashMapA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashMapB = new HashMap<Character, Integer>();

        if(a.length() > b.length() || b.length() > a.length()){
            return false;
        }
        //for A
        for(int i=0; i < a.length(); i++){
            char charInstanceA = charArrayA[i];
            int occurance = 0;

            if(hashMapA.containsKey(charInstanceA)){
                continue;
            }else{
                occurance++;
                hashMapA.put(charInstanceA,occurance);
            }

            //check to see if it exists multiple times then update occurance
            for(int x=i+1; x < a.length(); x++){
                if(charInstanceA == charArrayA[x]){
                    occurance++;
                    hashMapA.replace(charInstanceA,occurance);
                }
            }
        }

        // for B
        for(int i=0; i < b.length(); i++){
            char charInstanceB = charArrayB[i];
            int occurance = 0;

            if(hashMapB.containsKey(charInstanceB)){
                continue;
            }else{
                occurance++;
                hashMapB.put(charInstanceB,occurance);
            }

            //check to see if it exists multiple times then update occurance
            for(int x=i+1; x < b.length(); x++){
                if(charInstanceB == charArrayB[x]){
                    occurance++;
                    hashMapB.replace(charInstanceB,occurance);
                }
            }
        }

        return hashMapA.equals(hashMapB);
    }

    public static void main(String[] args) {
        boolean ret = isAnagram(args[0], args[1]);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}