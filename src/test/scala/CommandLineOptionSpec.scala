package scalax.scf4s

import org.specs2._

class CommandLineOptionSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "The Command Line Option Trait"                                             ^
    "should be mixed in with the 'App' trait" ! e1                            ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def e1 = app must beAnInstanceOf[App with CommandLineOptions]

  // -----------------------------------------------------------------------
  // utility functions
  // -----------------------------------------------------------------------

  def app = new App with CommandLineOptions

}
