package scalax.scf4s

import org.specs2._

class CommandLineOptionSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "The Command Line Option Trait"                                             ^
    "should be mixed in with the 'App' trait" ! e1                            ^
    "should have access to 'args'"            ! e2                            ^
    "should provide a 'name' for the 'App'"   ! e3                            ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def e1 = app must beAnInstanceOf[App with CommandLineOptions]

  def e2 = {
    val args = Array("foo","bar","baz")
    val a = app
    a.main(args)
    a.arguments === args
  }

  def e3 = app.name must beAnInstanceOf[String]

  // -----------------------------------------------------------------------
  // utility functions
  // -----------------------------------------------------------------------

  def app = new App with CommandLineOptions {
    def arguments = args
    override def name = "MyApp"
  }

}
