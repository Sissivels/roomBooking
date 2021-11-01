package tablas;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class H512 {

    public static String encrypter(String input){

        try{
            MessageDigest message_digest_1 = MessageDigest.getInstance("SHA-512");

            // digest returns a string of array byte

            byte[] message_digest_2 = message_digest_1.digest(input.getBytes());

            //converts byte array into signum (-1,0 or 1)
            BigInteger big_int = new BigInteger(1,message_digest_2);
            //convert to hex :
            String hash_text = big_int.toString(16);

            // fill with 0 to reach 32 bits:
            while (hash_text.length() < 32){
                hash_text = "0" + hash_text;
            }
            return hash_text;

        }catch(NoSuchAlgorithmException e ){
            throw new RuntimeException(e);

        }

    }




}
