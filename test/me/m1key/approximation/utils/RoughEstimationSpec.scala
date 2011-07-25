package me.m1key.approximation.utils

import org.specs.runner.JUnit4
import org.specs.runner._
import org.specs._

class JRoughEstimationSpec extends JUnit4(RoughEstimationSpec)

/**
 * @see http://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Rough_estimation
 */
object RoughEstimationSpec extends Specification {
	
	"The rough estimation method" should {
		
		"properly calculate the value for 4" in {
			// S = 4, D = 1
			// D is even, D = 2n + 1, n = 0
			// sqrt(S) == +- 2 * 10 ^ 0 = 2
			RoughEstimation.calculateRoughEstimation(4) mustEqual 2
		}
		
		"properly calculate the value for 10" in {
			// S = 10, D = 2
			// D is even, D = 2n + 2, n = 0
			// sqrt(S) == +- 6 * 10 ^ 0 = 6
			RoughEstimation.calculateRoughEstimation(10) mustEqual 6
		}
		
		"properly calculate the value for 11" in {
			// S = 11, D = 2
			// D is even, D = 2n + 2, n = 0
			// sqrt(S) == +- 6 * 10 ^ 0 = 6
			RoughEstimation.calculateRoughEstimation(11) mustEqual 6
		}
		
		"properly calculate the value for 100" in {
			// S = 100, D = 3
			// D is odd, D = 2n + 1, n = 1
			// sqrt(S) == +- 2 * 10 ^ 1 = 20
			RoughEstimation.calculateRoughEstimation(100) mustEqual 20
		}
		
	}
	
	"The rough estimation from digits" should {
		
		"properly calculate the value for 1" in {
			RoughEstimation.calculateRoughEstimationFromDigits(1) mustEqual 2
		}
		
		"properly calculate the value for 2" in {
			RoughEstimation.calculateRoughEstimationFromDigits(2) mustEqual 6
		}
		
		"properly calculate the value for 3" in {
			RoughEstimation.calculateRoughEstimationFromDigits(3) mustEqual 20
		}
		
		"properly calculate the value for 4" in {
			RoughEstimation.calculateRoughEstimationFromDigits(4) mustEqual 60
		}
		
		"properly calculate the value for 10" in {
			RoughEstimation.calculateRoughEstimationFromDigits(5) mustEqual 200
		}
		
	}
	
	"The helper method digitsIn" should {
		
		"return a valid number of digits for 913" in {
			RoughEstimation.digitsIn(913) mustEqual 3
		}
		
		"return a valid number of digits for 10" in {
			RoughEstimation.digitsIn(10) mustEqual 2
		}
		
		"return a valid number of digits for 1" in {
			RoughEstimation.digitsIn(1) mustEqual 1
		}
		
		"return a valid number of digits for 0" in {
			RoughEstimation.digitsIn(0) mustEqual 1
		}
		
	}
	
	"The helper method isEven" should {
		
		"identify 100 as an even number" in {
			RoughEstimation.isEven(100) mustEqual true
		}
		
		"identify 0 as an even number" in {
			RoughEstimation.isEven(0) mustEqual true
		}
		
		"identify 2 as an even number" in {
			RoughEstimation.isEven(2) mustEqual true
		}
		
		"identify -2 as an even number" in {
			RoughEstimation.isEven(-2) mustEqual true
		}
		
		"identify 101 as a non-even number" in {
			RoughEstimation.isEven(101) mustEqual false
		}
		
		"identify 1 as a non-even number" in {
			RoughEstimation.isEven(1) mustEqual false
		}
		
		"identify 101 as a non-even number" in {
			RoughEstimation.isEven(-101) mustEqual false
		}
		
	}
	
	"The helper method isOdd" should {
		
		"identify 100 as a non-odd number" in {
			RoughEstimation.isOdd(100) mustEqual false
		}
		
		"identify 0 as a non-odd number" in {
			RoughEstimation.isOdd(0) mustEqual false
		}
		
		"identify 2 as a non-odd number" in {
			RoughEstimation.isOdd(2) mustEqual false
		}
		
		"identify -2 as a non-odd number" in {
			RoughEstimation.isOdd(-2) mustEqual false
		}
		
		"identify 101 as an odd" in {
			RoughEstimation.isOdd(101) mustEqual true
		}
		
		"identify 1 as an odd number" in {
			RoughEstimation.isOdd(1) mustEqual true
		}
		
		"identify 101 as an odd number" in {
			RoughEstimation.isOdd(-101) mustEqual true
		}
		
	}

}
