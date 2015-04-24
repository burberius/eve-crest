eve-crest
=========

Library for the Eve Online CREST API

Implemented Endpoints
---------------------
* Item types - "/types/"
* Market Prices - "/market/prices/"


Unit Tests
----------
The default unit tests are offline against some data downloaded from the API.
The online tests also download the data and replace the old ones.
Online tests can be executed with:

mvn clean test -Donline=true

ToDo
----
* Add rest of calls
* Get Description for ItemTypes

Documentation
-------------
* https://wiki.eveonline.com/en/wiki/CREST_Getting_Started
