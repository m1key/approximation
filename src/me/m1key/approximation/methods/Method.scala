package me.m1key.approximation.methods

import me.m1key.approximation.utils.SatisfactionFunctions

trait Method {
	
	def approximate(x: Double, satisfies: Function2[Double, Double, Boolean] = SatisfactionFunctions.untilEquals): Double

}
