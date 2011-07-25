package me.m1key.approximation

import scala.collection.mutable.{Set => MSet} // Import a mutable Set and let it be called MSet
import me.m1key.approximation.methods._
import me.m1key.approximation.utils._

/**
  * www.m1key.me
  * Scala 2.8 Showcase (version 1)
  */
object Launcher {
	
	def main(args: Array[String]) = {
		println("Launching Approximation...")
		
		def negative(x: Double) = x < 0
		def equalsNumber(equalTo: Double)(x: Double) = equalTo == x
		
		val data = Set(1.0, 0.0, 1.0/4, 9.0, 16.0, 10000.0, -1.0) // Immutable
		val dataOnlyPositive = data filterNot negative
		println(dataOnlyPositive)
		assert(dataOnlyPositive subsetOf data)
		assert(!(data subsetOf dataOnlyPositive))
		assert(dataOnlyPositive exists equalsNumber(9.0))
		
		def equalsNine(x: Double) = equalsNumber(9.0)(x)
		assert(!equalsNine(12))
		assert(equalsNine(9))
		
		var mutableSet = scala.collection.mutable.Set(5.0)
		mutableSet += 6.0
		mutableSet -= 6.0
		println(mutableSet)
		println(mutableSet.getClass())
		
		val someMore = MSet(4.0, 20.0, 25.0, -1.0)
		someMore += 36.0
		val someMoreImmutable = Set(4.0, -1.0, 20.0, 25.0, 36.0)
		assert(someMore == someMoreImmutable)

		someMore -= -1.0
		someMore -= 7.0 // Nothing happens
		val dataToProcess = dataOnlyPositive ++ someMore
		println(dataToProcess)
		
		// The bisecting intervals method.
		
		println("The bisecting intervals method.")
		
		val bisectingIntervalsMethod = new BisectingIntervalsMethod()
		dataToProcess map {
			case (x: Double) => printf("Calculating square root for %f.\n", x)
				printf("Using the untilInRange(0.1) condition: %.3f\n",
						bisectingIntervalsMethod.approximate(x, SatisfactionFunctions.untilInRange(0.1)))
				printf("Using the untilInRange(0.01) condition: %.3f\n",
						bisectingIntervalsMethod.approximate(x, SatisfactionFunctions.untilInRange(0.01)))
				printf("Using the untilInRange(0.0001)) condition: %.3f\n",
						bisectingIntervalsMethod.approximate(x, SatisfactionFunctions.untilInRange(0.0001)))
		}
		
		// The Babylonian method.
		
		println("Done.")
	}

}
