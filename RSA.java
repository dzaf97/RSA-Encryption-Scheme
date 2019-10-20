import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
	private BigInteger n, d, e, euler;
	private int bitlen = 1024;

	public RSA() {}
	
	public RSA(int bits) {
		do {
			bitlen = bits;
			// Generate two distinct 512-bit probable primes p and q
		    SecureRandom r = new SecureRandom();
		    BigInteger p = new BigInteger(bitlen / 2, 100, r);
		    BigInteger q = new BigInteger(bitlen / 2, 100, r);
		    
			// Calculate the product of these two primes N = pq
		    n = p.multiply(q);
		    
			// Calculate the Euler totient function phi(N)
		    euler = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		    e = new BigInteger("65537");
		    }while(e.gcd(euler).intValue() > 1); // Check if n is relatively prime to Euler totient
		d = e.modInverse(euler);
	}
	
	// Encrypt the given plaintext message.
	public BigInteger encrypt(BigInteger message) {
		return message.modPow(e, n);
		}

	// Decrypt the given ciphertext message.
	public BigInteger decrypt(BigInteger message) {
		return message.modPow(d, n);
	  }

	public BigInteger getE() {
		return e;
		}
  
  	public BigInteger getD() {
    	return d;
  }

public static void main(String[] args) {
	}
}
