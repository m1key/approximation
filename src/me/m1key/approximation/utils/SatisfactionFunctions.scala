package me.m1key.approximation.utils

/**
  * Functions used as conditions for approximating alghorithms.
  */
object SatisfactionFunctions {
	
	/**
	 * Rather dangerous due to limitations of computer precision.
	 */
	def untilEquals(x: Double, potential: Double) : Boolean = {
		x == (potential * potential)
	}
	
	/**
	 * Allows for certain precision to be specified.
	 */
	def untilInRange(range: Double)(x: Double, potential: Double) : Boolean = {
		(x <= (potential + range) * (potential + range)) &&
			x >= ((potential - range) * (potential - range))
	}

}
