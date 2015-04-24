eve-crest
=========

Library for the Eve Online CREST API

Implemented Endpoints
---------------------
* Item types - "/types/"
* Market Prices - "/market/prices/"
* Industry Systems Cost Index - "/industry/systems/"
* Industry Facilities - "/industry/facilities/"

Unit Tests
----------
The default unit tests are offline against some data downloaded from the API.
The online tests are disabled by default and can be executed with:

mvn clean test -Donline=true

ToDo
----
* Get Description for ItemTypes
* SolarSystems - "/solarsystems/XXXXX/"
* Add rest of calls

Documentation
-------------
* https://wiki.eveonline.com/en/wiki/CREST_Getting_Started
