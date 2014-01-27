ContaAzul Space Agency Robot
==========

## api

Contains the Robot API (rotation, movimentation, position validation, et al)

## rest

Contains the REST interface for the given `api`. It will respond to the
following endpoints:

#### `POST /{artifactId}/mars/{commands}`

This will move the Robot from 00N to some position and return it.

For example, the request

```bash
curl -X POST http://localhost:8080/rest/mars/MML
```

Will return `02W` as result.

Possible erros are `RobotOutOfBounds` and `InvalidRobotCommand`.
    

