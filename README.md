# Chaos Testing Demo
This is an example project prepared for demonstrating Chaos Engineering experiment on a Spring boot application using Chaos Monkey and Chaos Toolkit

## REST endpoints
- `/player/all` - Return list of players and their rankings from a database
- `/actuator/chaosmonkey` - Chaos Monkey for Spring Boot


## Chaos Experiments
Set virtual environment in python and install `chaostoolkit-spring`
```
python3 -m venv ~/.venvs/chaostk
source  ~/.venvs/chaostk/bin/activate
pip install chaostoolkit
pip install chaostoolkit-spring
```
Run the experiment:
`chaos run experiments.json`

