import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPrimeNumbers {
	//define method to check if number is prime 
		public static boolean checkIfPrime(int num) {
			boolean check = false;
			
			//check if number is not prime
			if (num<=1) {
				return false;// number is not prime	
			}
			
			//loop to check if number is prime
			for (int i=2; i<=num/2; ++i) {
				if(num%i==0) {
					check = true;//number is prime
					break;
					}
				}
			
			if (!check) {
				return true;//number is prime
			}
			else {
				return false;//number is not prime 
			}
		}
		
		/**define method to display product of prime numbers
		 * declare exception using "throws"
		  */
		public static int primeNumbersProduct (int num1, int num2) throws PrimeNumberException {
			int num_product = 0;
			
			//check if first number is prime
			if (!checkIfPrime(num1)) {
				//throw exception if number is not prime
				throw new PrimeNumberException("Entered number " + num1 +" is not a prime number");
			}
			//check if first number is prime
			if (!checkIfPrime(num2)) {
				//throw exception if number is not prime
				throw new PrimeNumberException("Entered number " + num2 +" is not a prime number");
					}
			//calculate product of numbers
			num_product = num1*num2;
			//return the result
			return num_product;
			
		}
		
		//main method
		public static void main (String [] args) {
			
			//call method using two prime numbers
			int num1 = 29;
			int num2 = 3;
			try {
				System.out.println("The product of two prime numbers " + num1 + " and " +num2 +
						", equals to " + primeNumbersProduct(num1, num2));
			}
			// catch exception 
			catch (PrimeNumberException ex) {
				Logger.getLogger(TestPrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			//call method using one prime and one non-prime numbers
			int num3 = 11;
			int num4 = 24;
			try {
				System.out.println("The product of two prime numbers: " + num3 + "and" +num4 +
						"is: " + primeNumbersProduct(num3, num4));
				}
			// catch exception 
			catch (PrimeNumberException ex) {
				Logger.getLogger(TestPrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
					}
			
			//call method using two non-prime numbers
			int num5 = 4;
			int num6 = 32;
			try {
				System.out.println("The product of two prime numbers: " + num5 + "and" +num6 +
						"is: " + primeNumbersProduct(num5, num6));
				}
			// catch exception 
			catch (PrimeNumberException ex) {
				Logger.getLogger(TestPrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
				}
		}

}
