package me.m1key.approximation.utils

import org.specs.runner.JUnit4
import org.specs.runner._
import org.specs._

class JHalfwayUtilSpec extends JUnit4(HalfwayUtilSpec)

object HalfwayUtilSpec extends Specification {
	
	"HalfwayUtil" should {
		
		"propertly calculate halfway between 0 and 2" in {
			val halfway = HalfwayUtil.halfway(0, 2)
			halfway mustEqual 1
		}
		
		"propertly calculate halfway between 2 and 0" in {
			val halfway = HalfwayUtil.halfway(2, 0)
			halfway mustEqual 1
		}
		
		"propertly calculate halfway between 0 and 1" in {
			val halfway = HalfwayUtil.halfway(0, 1)
			halfway mustEqual 0.5
		}
		
		"propertly calculate halfway between 1 and 0" in {
			val halfway = HalfwayUtil.halfway(1, 0)
			halfway mustEqual 0.5
		}
		
		"propertly calculate halfway between -1 and 1" in {
			val halfway = HalfwayUtil.halfway(-1, 1)
			halfway mustEqual 0
		}
		
		"propertly calculate halfway between 1 and -1" in {
			val halfway = HalfwayUtil.halfway(1, -1)
			halfway mustEqual 0
		}
		
		"propertly calculate halfway between -3 and 1" in {
			val halfway = HalfwayUtil.halfway(-3, 1)
			halfway mustEqual -1
		}
		
		"propertly calculate halfway between 1 and -3" in {
			val halfway = HalfwayUtil.halfway(1, -3)
			halfway mustEqual -1
		}
		
		"propertly calculate halfway between 1 and 1" in {
			val halfway = HalfwayUtil.halfway(1, 1)
			halfway mustEqual 1
		}
		
		"propertly calculate halfway between 0.25 and 0.75" in {
			val halfway = HalfwayUtil.halfway(0.25, 0.75)
			halfway mustEqual 0.5
		}
		
	}

}
