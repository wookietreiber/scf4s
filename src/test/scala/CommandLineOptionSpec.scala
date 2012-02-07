package scalax.scf4s

import org.specs2._

class CommandLineOptionSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "The Command Line Option Trait should"                                      ^
    "be mixed in with the 'App' trait"      ! e1                              ^
    "have access to 'args'"                 ! e2                              ^
    "provide a 'name' for the 'App'"        ! e3                              ^
    "provide a 'description' for the 'App'" ! e4                              ^
    "provide a 'usage' text"                ! e5                              ^
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

  def e4 = app.description must beAnInstanceOf[String]

  def e5 = app.usage must startWith("Usage:")

  // -----------------------------------------------------------------------
  // utility functions
  // -----------------------------------------------------------------------

  def app = new App with CommandLineOptions {
    def arguments = args
    override def name = "MyApp"
    override def description = "do awesome stuff"
  }

}
