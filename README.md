# RSA-Encryption-Scheme
## Applied Cryptography

A Java programme that show the implementation of RSA encryption scheme with key size of 1024 bits. Basically, this programme will show how encryption and decryption are performed between the sender and the receiver. The plaintext should be a meaningful message.

### This programme performed as follows:
1. Generate two distinct 512-bit probable primes p and q.
2. Calculate the product of these two primes N = pq.
3. Calculate the Euler totient function phi(N) or (N).
4. Use an encryption exponent e = 65537 and ensure that it is relatively prime to phi(N). If it is not, go back to Step 1 and generate new values for p and q.
5. Compute the value for the decryption exponent d, which is the multiplicative inverse of e (mod phi(N)).

