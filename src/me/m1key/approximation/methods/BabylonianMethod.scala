package me.m1key.approximation.methods

import me.m1key.approximation.utils._

class BabylonianMethod extends Method {
	
	def approximate(x: Double, satisfies: Function2[Double, Double, Boolean] = SatisfactionFunctions.untilEquals): Double = {
		require(x >= 0, "x cannot be negative and it is: " + x)
		// TODO
		return 0
	}

}
