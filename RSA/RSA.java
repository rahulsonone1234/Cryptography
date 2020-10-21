import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.*;
public class RSA
{
      BigInteger pValue;
      BigInteger qValue;
      BigInteger N;
      BigInteger PHI;
      BigInteger e;
      BigInteger d;
      int maxLength = 1024;
      Random R;
 
    public RSA()
    {
        R = new Random();
        pValue= BigInteger.probablePrime(maxLength, R);
        qValue = BigInteger.probablePrime(maxLength, R);
        N = pValue.multiply(qValue);
       PHI = pValue.subtract(BigInteger.ONE).multiply(  qValue.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(maxLength / 2, R);
        while (PHI.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(PHI) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(PHI);
    }
 
    public RSA(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
 
    public static void main (String [] arguments) throws IOException
    {
        RSA rsa = new RSA();
        DataInputStream input = new DataInputStream(System.in);
        String inputString;
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plain text:");
        inputString = sc.next();
        System.out.println("The encrypted message: " + inputString);
         System.out.println("P:"+ rsa.pValue + '\n'); 
       
         System.out.println("Q:"+ rsa.qValue + '\n');
         System.out.println("N:"+ rsa.N + '\n');
System.out.println("E:"+ rsa.e + '\n');
        System.out.println("The message in bytes is:: "
                + bToS(inputString.getBytes()));
        
        byte[] cipher = rsa.encryptMessage(inputString.getBytes());
        	
        byte[] plain = rsa.decryptMessage(cipher);
        System.out.println("The decrypted message: " + bToS(plain));
        System.out.println("Again, the plain text: " + new String(plain));
    }
 
    private static String bToS(byte[] cipher)
    {
        String temp = "";
        for (byte b : cipher)
        {
            temp += Byte.toString(b);
        }
        return temp;
    }
 
   	
    public byte[] encryptMessage(byte[] message)
    {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
 
    
    public byte[] decryptMessage(byte[] message)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}