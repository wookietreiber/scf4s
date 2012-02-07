package scalax.scf4s

import org.specs2._

class CommandLineOptionSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "The 'CommandLineOptions' trait should"                                     ^
    "be mixed in with the 'App' trait"                            ! e1        ^
    "have access to 'args'"                                       ! e2        ^
    "provide a 'name' for the 'App'"                              ! e3        ^
    "provide a 'description' for the 'App'"                       ! e4        ^
    "provide a 'usage' text"                                      ! e5      ^t^
      "that contains 'name'"                                      ! e6        ^
      "that contains 'description'"                               ! e7        ^
                                                                         endbr^
  "A 'CommandLineOption' should"                                              ^
    "have a 'name'"                                               ! f1      ^t^
      "that matches [a-z]{2,}(?:-[a-z]{2,})*"                     ! f2        ^
      "that failes some counter examples"                         ! f3        ^
    "have an optional 'short' name"                               ! f4      ^t^
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
  def e6 = app.usage must contain(app.name)
  def e7 = app.usage must contain(app.description)

  def f1 = opt.name must beAnInstanceOf[String]
  def f2 = foreach(Seq("foo","foo-bar","foo-bar-baz")) { name =>
    CommandLineOption(name) must not(throwAn[IllegalArgumentException])
  }
  def f3 = foreach(Seq("","a","-foo","foo-","foo--bar")) { name =>
    CommandLineOption(name) must throwAn[IllegalArgumentException]
  }
  def f4 = opt.short must beAnInstanceOf[Option[Char]]

  // -----------------------------------------------------------------------
  // utility functions
  // -----------------------------------------------------------------------

  def app = new App with CommandLineOptions {
    def arguments = args
    override def name = "MyApp"
    override def description = "do awesome stuff"
  }

  def opt = CommandLineOption("foo", Some('f'))

}
