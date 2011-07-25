package me.m1key.approximation.methods

import me.m1key.approximation.utils._
import org.specs.runner.JUnit4
import org.specs.runner._
import org.specs._

class JBisectingIntervalsMethodSpec extends JUnit4(BisectingIntervalsMethodSpec)

object BisectingIntervalsMethodSpec extends Specification {
	val bisectingIntervalsMethod = new BisectingIntervalsMethod()
	
	"The bisecting intervals method with untilInRange(0.1)" should {
		
		"properly approximate square root of 4" in {
			(bisectingIntervalsMethod.approximate(4, SatisfactionFunctions.untilInRange(0.1)) <= 2.1 )mustBe true
		}
		
		"properly approximate square root of 9" in {
			(bisectingIntervalsMethod.approximate(9, SatisfactionFunctions.untilInRange(0.1)) <= 3.1 )mustBe true
		}
		
		"properly approximate square root of 0" in {
			(bisectingIntervalsMethod.approximate(0, SatisfactionFunctions.untilInRange(0.1)) <= 0.1 )mustBe true
		}
		
		"properly approximate square root of 1" in {
			(bisectingIntervalsMethod.approximate(1, SatisfactionFunctions.untilInRange(0.1)) <= 1.1 )mustBe true
		}
		
	}
	
	"The bisecting intervals method with untilInRange(0.001)" should {
		
		"properly approximate square root of 4" in {
			(bisectingIntervalsMethod.approximate(1, SatisfactionFunctions.untilInRange(0.01)) <= 4.01 )mustBe true
		}
		
		"properly approximate square root of 9" in {
			(bisectingIntervalsMethod.approximate(9, SatisfactionFunctions.untilInRange(0.01)) <= 3.01 )mustBe true
		}
		
		"properly approximate square root of 0" in {
			(bisectingIntervalsMethod.approximate(0, SatisfactionFunctions.untilInRange(0.01)) <= 0.01 )mustBe true
		}
		
		"properly approximate square root of 1" in {
			(bisectingIntervalsMethod.approximate(1, SatisfactionFunctions.untilInRange(0.01)) <= 1.01 )mustBe true
		}
		
		"properly approximate square root of 5" in {
			(bisectingIntervalsMethod.approximate(5, SatisfactionFunctions.untilInRange(0.01)) <= 2.24 )mustBe true
		}
	}
	
	"The bisecting intervals method with untilEquals" should {
		
		"properly approximate square root of 4" in {
			bisectingIntervalsMethod.approximate(1, SatisfactionFunctions.untilEquals) mustEqual 1
		}
		
		"properly approximate square root of 9" in {
			bisectingIntervalsMethod.approximate(9, SatisfactionFunctions.untilEquals) mustEqual 3
		}
		
		"properly approximate square root of 0" in {
			bisectingIntervalsMethod.approximate(0, SatisfactionFunctions.untilEquals) mustEqual 0
		}
		
		"properly approximate square root of 1" in {
			bisectingIntervalsMethod.approximate(1, SatisfactionFunctions.untilEquals) mustEqual 1
		}
		
		"properly approximate square root of 5" in {
			bisectingIntervalsMethod.approximate(121, SatisfactionFunctions.untilEquals) mustEqual 11
		}
	}

}
