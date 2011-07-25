package me.m1key.approximation.utils

import org.specs.runner.JUnit4
import org.specs.runner._
import org.specs._

class JSastisfactionUtilsSpec extends JUnit4(SastisfactionUtilsSpec)

object SastisfactionUtilsSpec extends Specification {
	
	"The untilEquals method" should {
		
		"confirm that 2 * 2 equals 4" in {
			SatisfactionFunctions.untilEquals(4, 2) mustEqual true
		}
		
		"confirm that 0 * 0 equals 0" in {
			SatisfactionFunctions.untilEquals(0, 0) mustEqual true
		}
		
		"confirm that 9 * 9 equals 81" in {
			SatisfactionFunctions.untilEquals(81, 9) mustEqual true
		}
		
	}
	
	"The untilInRange method" should {
		
		"confirm that 2 * 2 equals 4" in {
			SatisfactionFunctions.untilInRange(0)(4, 2) mustEqual true
		}
		
		"confirm that 0 * 0 equals 0" in {
			SatisfactionFunctions.untilInRange(0)(0, 0) mustEqual true
		}
		
		"confirm that 9 * 9 equals 81" in {
			SatisfactionFunctions.untilInRange(0)(81, 9) mustEqual true
		}
		
		"confirm that 3 * 3 equals 8, range 1" in {
			SatisfactionFunctions.untilInRange(1)(8, 3) mustEqual true
		}
		
		"confirm that 0 * 0 equals 1, range 1" in {
			SatisfactionFunctions.untilInRange(1)(0, 1) mustEqual true
		}
		
		"confirm that 9 * 9 equals 79, range 1" in {
			// In other words, it will cover everything from 8*8 to 10*10
			SatisfactionFunctions.untilInRange(1)(79, 9) mustEqual true
		}
		
	}

}
