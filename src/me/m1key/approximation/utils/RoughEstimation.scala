package me.m1key.approximation.utils

/**
  * Rough estimation.
  * http://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Rough_estimation
  */
object RoughEstimation {
	
	def calculateRoughEstimation(x: Double): Int = {
		if (x < 1) {
			0
		}
		calculateRoughEstimationFromDigits(digitsIn(x))
	}
	
	/**
	 * Calculates the rough estimation for the number of digits.
	 */
	private[utils] def calculateRoughEstimationFromDigits(digitsCount: Int): Int = {
		if (isOdd(digitsCount)) {
			val n = (digitsCount - 1) / 2
			2 * (Math.pow(10, n)).intValue
		} else {
			val n = (digitsCount - 2) / 2
			6 * (Math.pow(10, n)).intValue
		}
	}
	
	/**
	 * Returns true if the number is odd.
	 */
	private[utils] def isOdd(x : Int) = !isEven(x)

	/**
	 * Returns true if the number is even.
	 */
	private[utils] def isEven(x: Int) = x % 2 == 0
	
	/**
	 * Returns the number of digits in a number.
	 */
	private[utils] def digitsIn(x: Double): Int = {
		if (x == 0) return 1
		1 + (Math.log(x) / Math.log(10)).intValue
	}
}
