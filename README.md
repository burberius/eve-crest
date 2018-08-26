DEPRECATED
==========
CCP switched of the XML and CREST API on May 8th, 2018. Therefore this library is useless from that day on.

See: https://developers.eveonline.com/blog/article/important-information-on-the-future-of-the-eve-api

eve-crest
=========

Library for the Eve Online CREST API

[![Build Status](http://didge.my-wan.de/jenkins/job/GitHub%20eve-crest/badge/icon)](http://didge.my-wan.de/jenkins/job/GitHub%20eve-crest/)
[![SonarQube Coverage](https://img.shields.io/sonar/http/sonar.qatools.ru/ru.yandex.qatools.allure:allure-core/coverage.svg)](http://didge.my-wan.de/sonar/api/resources?resource=1&depth=0&metrics=coverage&includetrends=true)

Implemented Endpoints
---------------------
* Status - "/"
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
