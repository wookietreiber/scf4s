package scalax.scf4s

import org.specs2._

class CommandLineOptionSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "A 'CommandLineOption' should"                                              ^
    "have a 'name'"                                               ! e1      ^t^
      "that matches [a-z]{2,}(?:-[a-z]{2,})*"                     ! e2        ^
      "that failes some counter examples"                         ! e3     ^bt^
    "have an optional 'short' name"                               ! e4      ^t^
      "that matches [a-zA-Z] and nothing else"                    ! e5     ^bt^
    "have a 'description'"                                        ! e6      ^t^
      "that is non-empty"                                         ! e7     ^bt^
    "have an optional 'example'"                                  ! e8      ^t^
      "that is non-empty"                                         ! e9     ^bt^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def e1 = opt.name must beAnInstanceOf[String]
  def e2 = foreach(Seq("foo","foo-bar","foo-bar-baz")) { name =>
    CommandLineOption(name, "desc") must not(throwAn[IllegalArgumentException])
  }
  def e3 = foreach(Seq("","a","-foo","foo-","foo--bar")) { name =>
    CommandLineOption(name, "desc") must throwAn[IllegalArgumentException] {
      CommandLineOption.errorMessageName
    }
  }
  def e4 = opt.short must beAnInstanceOf[Option[Char]]
  def e5 = foreach(Seq(' ','-','_','#')) { short =>
    CommandLineOption("name", "desc", Some(short)) must throwAn[IllegalArgumentException] {
      CommandLineOption.errorMessageShort
    }
  }
  def e6 = opt.description must beAnInstanceOf[String]
  def e7 = CommandLineOption("name", "") must throwAn[IllegalArgumentException] {
    CommandLineOption.errorMessageDescription
  }
  def e8 = opt.example must beAnInstanceOf[Option[String]]
  def e9 = CommandLineOption("name", "desc", example = Some("")) must throwAn[IllegalArgumentException] {
    CommandLineOption.errorMessageExample
  }

  // -----------------------------------------------------------------------
  // utility functions
  // -----------------------------------------------------------------------

  def opt = CommandLineOption("depth", "recursion depth", Some('d'), Some("N"))

}
