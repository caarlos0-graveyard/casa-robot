ContaAzul Space Agency Robot
==========

Describing the modules:

### api

Contains the Robot API (rotation, movimentation, position validation, et al)

To get test coverage run `mvn cobertura:cobertura` then check the results in
`api/target/site/cobertura/index.html`.

### rest

Contains the REST interface for the given `api`. It will respond to the
following endpoints:

##### `POST /{artifactId}/mars/{commands}`

This will move the Robot from 00N to some position and return it.

For example, the request

```bash
curl -X POST http://localhost:8080/rest/mars/MML
```

Will return `02W` as result.

Possible erros are `RobotOutOfBounds` and `InvalidRobotCommand`.

### web

A (really) simple Angular.js WebApp to give commands to the Robot. The app
endpoint is [/web](http://localhost:8080/web).

> only works if the `rest` path wasn't changed.

### ear

A package that contains both `rest` and `web` modules, just to make things
easier.
