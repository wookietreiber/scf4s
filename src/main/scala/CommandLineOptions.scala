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

/** Provides convenient ''command line option'' parsing for an application.
  *
  * {{{
  * object MyApp extends App with CommandLineOptions {
  *   override def name = "MyApp"
  *   override def description = "do awesome stuff"
  * }
  * }}}
  */
trait CommandLineOptions {
  self: App =>

  /** Returns the name of the application. */
  def name: String

  /** Returns the description of the application. */
  def description: String

  /** Returns the usage text of the application. */
  protected[scf4s] def usage: String =
    """|Usage:
       |  %s [OPTION...] - %s
    """ format (name, description) stripMargin

}
