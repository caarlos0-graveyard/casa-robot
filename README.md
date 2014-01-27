ContaAzul Space Agency Robot
==========

## api

Contains the Robot API (rotation, movimentation, position validation, et al)

## rest

Contains the REST interface for the given `api`. It will respond to the following
endpoints:

- `POST /{artifactId}/mars/{commands}`
    This will move the Robot from 00N to some position and return it.
    
    Possible erros are `RobotOutOfBounds` and `InvalidRobotCommand`.
    

