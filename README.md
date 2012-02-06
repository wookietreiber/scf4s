Simple Configuration Facade for Scala
=====================================

This project is supposed to be to configuration what [slf4s][1] is to logging.


Styles
------

- INI
- JSON
- XML


Locators
--------

- [XDG][2]
- based on environment variable (like `AKKA_HOME`)


Ideas
-----

- provide an [sbt][3] plugin to write configuration file(s) to default
  location(s)


[1]: https://github.com/weiglewilczek/slf4s
[2]: http://standards.freedesktop.org/basedir-spec/basedir-spec-latest.html
[3]: https://github.com/harrah/xsbt

