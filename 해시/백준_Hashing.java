import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_Hashing {
    final static int r = 31, M = 1234567891;
    static ArrayList<Character> alphabetList;

    public static void main(String[] args) throws IOException {
        alphabetList = new ArrayList<>();
        alphabetList.add('0');
        char input = 'a';
        for(int i = 0; i<26; i++)
            alphabetList.add((char)(input+i));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String hashValue = br.readLine();
        long result = makeHash(hashValue,L);

        System.out.print(result);
        br.close();
    }

    static long makeHash(String in,long len){
        long output = 0;
        for(int i = 0; i<len; i++){
            output += (long) alphabetList.indexOf(in.charAt(i)) * Math.pow(31,i);
        }
        return output % M;
    }
}
