public class AlphabeticalSort {

    public static String getSmallestAndLargest(String s, int k) {
        //we should be able to use lists
        String[] tempArray = new String[s.length()];
        int arrayIndex = 0;

        for(int i=0; i <= s.length()-k; i++){
            tempArray[arrayIndex] = s.substring(i,i+k);
            arrayIndex++;
        }

        //ew
        String[] substrings = new String[arrayIndex];
        System.arraycopy(tempArray,0,substrings,0,arrayIndex);

        //bubble sort
        for(int i=0; i < substrings.length-1; i++){
            for (int j = 0; j < substrings.length-i-1; j++){
                if(canPushThroughArray(substrings[j],substrings[j+1],0,k)){
                    String temp = substrings[j];
                    substrings[j] = substrings[j+1];
                    substrings[j+1] = temp;
                }
            }
        }
        return substrings[0] + "\n" + substrings[arrayIndex-1];
    }
    //handle when substrings have same character recursively
    static private boolean canPushThroughArray(String first, String second, int charIndex, int size){
        if(charIndex == size) {
            return false;
        }
        if(first.charAt(charIndex) > second.charAt(charIndex)){
                return true;
        }else if(first.charAt(charIndex) == second.charAt(charIndex)){
                charIndex++;
                canPushThroughArray(first,second,charIndex,size);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "welcometojava";
        int k = 3;

        System.out.println(getSmallestAndLargest(s, k));
        }
    }
