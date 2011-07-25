package me.m1key.approximation.methods

import me.m1key.approximation.utils._

/**
  * The bisecting intervals method.
  */
class BisectingIntervalsMethod extends Method {
	
	def approximate(x: Double, satisfies: Function2[Double, Double, Boolean] = SatisfactionFunctions.untilEquals): Double = {
		require(x >= 0, "x cannot be negative and it is: " + x)
		if (x == 0) {
			return 0
		}
		if (x == 1) {
			return 1
		}
		
		if (x < 1) {
			var potential = 1.0
			var power = 1.0
			var latestTooBig = 1.0;
			while(!satisfies(x, potential)) {
				power = potential * potential
				if (power > x) {
					latestTooBig = potential
					potential = HalfwayUtil.halfway(potential, x)
				} else if (power < x) {
					potential = HalfwayUtil.halfway(potential, latestTooBig)
				}
			}
			return potential
		} else {
			var potential = 1.0
			var power = 1.0
			var latestTooBig = x;
			while(!satisfies(x, potential)) {
				power = potential * potential
				if (power > x) {
					latestTooBig = potential
					potential = HalfwayUtil.halfway(potential, 1)
				} else if (power < x) {
					potential = HalfwayUtil.halfway(potential, latestTooBig)
				}
			}
			return potential
		}
	}

}
