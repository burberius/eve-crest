eve-crest
=========

Library for the Eve Online CREST API

Unit Tests
----------
The default unit tests are offline against some data downloaded from the API.
The online tests also download the data and replace the old ones.
Online tests can be executed with:

mvn clean test -Donline=true

ToDo
----
* Add rest of calls
