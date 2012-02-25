Simple Configuration Facade for Scala
=====================================

This project is supposed to be to configuration what [slf4s][1] is to logging.


Styles
------

- [HOCON (Human-Optimized Config Object Notation)][9]
- simple key-value pairs aka [INI][4] with sections
- [JSON][5]
- [XML][6]
- [YAML][7]
- [Simple Declarative Language (SDL)][8]


Locators
--------

- based on the [XDG Base Directory Specification][2]
- based on an environment variable (like `AKKA_HOME`)


Full Integration with Command Line Arguments
--------------------------------------------

- parse command line arguments
- generate formatted help text(s)
- generate man page(s)


[SBT][3] Integration
--------------------

- install default / reference configuration file(s) (based on the used
  `Locator`)
- install manpage(s)


[1]: https://github.com/weiglewilczek/slf4s
[2]: http://standards.freedesktop.org/basedir-spec/basedir-spec-latest.html
[3]: https://github.com/harrah/xsbt
[4]: http://en.wikipedia.org/wiki/INI_file
[5]: http://en.wikipedia.org/wiki/JSON
[6]: http://en.wikipedia.org/wiki/XML
[7]: http://en.wikipedia.org/wiki/YAML
[8]: http://en.wikipedia.org/wiki/Simple_Declarative_Language
[9]: https://github.com/typesafehub/config/blob/master/HOCON.md

