import java.math.BigInteger; 


public class gcd{  
	public static int gcdi(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcdi(q, p % q);
    }

	public static void main(String[] args){  
	// create 2 BigInteger objects  
	BigInteger big1= new BigInteger("89798763754892653453379597352537489494736234563880");    
	BigInteger big2= new BigInteger("12345678910111213141516171819202122232425262728610");    
	// get the gcd value of BigInteger big1,big2  
	
	BigInteger  bigVal= big1.gcd(big2);    
	String str="GCD of  "+big1+ " and " +big2+" is "+ bigVal;  
	System.out.println(str);     
	  
	}   
}  