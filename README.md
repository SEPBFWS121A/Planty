# Planty

## Pipelines

Backend: [![Test, build and deploy](https://github.com/SEPBFWS121A/Planty/actions/workflows/main.yml/badge.svg)](https://github.com/SEPBFWS121A/Planty/actions/workflows/main.yml)

Frontend: [![Test, build and deploy](https://github.com/SEPBFWS121A/Planty/actions/workflows/frontend.yml/badge.svg)](https://github.com/SEPBFWS121A/Planty/actions/workflows/frontend.yml)

## Start Backend and Frontend

- Start docker
- run ./startDev.sh in backend and in frontend folder

## Running unit tests frontend

- Go into frontend directory
- Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running integration tests frontend

- Go into frontend directory
- Run `npm mocha`to execute integration tests via mocha

## Running System tests frontend

- Start backend and frontend
- Go into frontend directory
- Run `npx cypress open`to execure system tests via cypress
