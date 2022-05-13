# finite-state-machine-robot

## How to execute

./mvnw spring-boot:run

## Usage examples

- `curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM`

Expected output: (2, 0, S)

- `curl -s --request POST http://localhost:8080/rest/mars/MML`

Expected output: (0, 2, W)

- `curl -s --request POST http://localhost:8080/rest/mars/AAA`

Expected output: 400 Bad Request

- `curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM`

Expected output: 400 Bad Request
