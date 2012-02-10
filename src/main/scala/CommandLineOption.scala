/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                           *
 *  Copyright 2012 Christian Krause. All rights reserved.                    *
 *                                                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                           *
 *  Redistribution and use in source and binary forms, with or without       *
 *  modification, are permitted provided that the following conditions       *
 *  are met:                                                                 *
 *                                                                           *
 *    1. Redistributions of source code must retain the above copyright      *
 *       notice, this list of conditions and the following disclaimer.       *
 *                                                                           *
 *    2. Redistributions in binary form must reproduce the above             *
 *       copyright notice, this list of conditions and the following         *
 *       disclaimer in the documentation and/or other materials              *
 *       provided with the distribution.                                     *
 *                                                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                           *
 *  THIS SOFTWARE IS PROVIDED BY CHRISTIAN KRAUSE ''AS IS'' AND ANY          *
 *  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE        *
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR       *
 *  PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL CHRISTIAN KRAUSE OR            *
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,    *
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,      *
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR       *
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF   *
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING     *
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS       *
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.             *
 *                                                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                           *
 *  The views and conclusions contained in the software and documentation    *
 *  are those of the authors and should not be interpreted as representing   *
 *  official policies, either expressed or implied, of Christian Krause.     *
 *                                                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package scalax.scf4s

object CommandLineOption {
  private[scf4s] lazy val nameRegex = """[a-z]{2,}(?:-[a-z]{2,})*""".r
  private[scf4s] lazy val shortRegex = """[a-zA-Z]""".r

  private[scf4s] lazy val errorMessageName =
    "The 'name' must be a '-' separated sequence of lowercase words each of at least length 2."
  private[scf4s] lazy val errorMessageShort =
    "The 'short' name must be a letter."
  private[scf4s] lazy val errorMessageDescription =
    "The 'description' may not be empty."
  private[scf4s] lazy val errorMessageExample =
    "The 'example' may not be empty."
}

import CommandLineOption._

/** Represents a command line option.
  *
  * {{{
  * scala> val opt = CommandLineOption("depth",Some('d'),"recursion depth",Some("N"))
  * opt: scalax.scf4s.CommandLineOption = CommandLineOption(depth,Some(d),recursion depth,Some(N))
  * }}}
  *
  * @param name Returns the name that is used in long arguments, as in `--name`.
  *             It must be a '-' separated sequence of lowercase words each of
  *             at least length 2 or in other words: match the regex
  *             `"""[a-z]{2,}(?:-[a-z]{2,})*"""`.
  *
  * @param short Optionally returns the name that is used in short arguments, as
  *              in `-n`.
  *
  * @param description Returns the description of this option. It should explain
  *                    what this option does.
  *
  * @param example Optionally returns the example for the argument.
  */
case class CommandLineOption (
    name: String,
    short: Option[Char],
    description: String,
    example: Option[String]
  ) {

  require(name match {
    case nameRegex() => true
    case _           => false
  }, errorMessageName)

  require(short map { _ toString match {
    case shortRegex() => true
    case _            => false
  }} getOrElse true, errorMessageShort)

  require(description nonEmpty, errorMessageDescription)

  require(example map { _ nonEmpty } getOrElse true, errorMessageExample)

}
