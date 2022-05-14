# finite-state-machine-robot

A simple finite state machine implemented to move an imaginary robot through a 5x5 grid space:
<div>
  
|---|---|---|---|---|
|---|---|---|---|---|
|---|---|---|---|---|
|---|---|---|---|---|
|---|---|---|---|---|
|:^:|---|---|---|---|

^^^^^

start position (0, 0) poiting north.

  ```shell
        N
        ^
        |
  W <- :^: -> E (each orientation define a state of the robot and each state has its own "movement method")
        |
        v
        S
  ```

## How to execute

`./mvnw spring-boot:run`

## Usage examples

- `curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM`

Expected output: (2, 0, S)

- `curl -s --request POST http://localhost:8080/rest/mars/MML`

Expected output: (0, 2, W)

- `curl -s --request POST http://localhost:8080/rest/mars/AAA`

Expected output: 400 Bad Request

- `curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM`

Expected output: 400 Bad Request

## Author

Hello! I'm Icaro Pablo, I'd be happy if you could provide me any feedback about this repository's code, structure or anything that could make me a better Java programmer. You can contact me following the links in [my github page](https://www.github.com/IcaroPablo) :)

## License

This code is licensed under the MIT License, see the [LICENSE](/LICENSE) file for details.
