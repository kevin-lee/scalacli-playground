# Scala CLI Playground

A simple playground project for experimenting with Scala 3 and various libraries using Scala CLI.

## Overview

This project provides a ready-to-use environment for experimenting with Scala 3 and popular libraries like Cats, Cats Effect, JSoup, Laika, and more. It's designed to help you quickly test code snippets and explore library features without setting up a full-scale project.

## Project Structure

- `playground.scala` - A simple Scala file for basic experiments
- `playgroundLibs.scala` - A more comprehensive file with examples of various libraries
- `project.scala` - Contains all Scala CLI directives and dependencies
- `run-playground.sh` - Script to run the basic playground
- `run-playgroundLibs.sh` - Script to run the playground with libraries
- `setup-ide.sh` - Script to set up IDE support
- `clean.sh` - Script to clean temporary files

## Dependencies

The project includes the following libraries:

- Scala 3.7.1
- Cats Core 2.13.0
- Cats Effect 3.6.1
- JSoup 1.20.1
- Laika Core 1.3.2
- Refined4s Core 1.1.0
- Various Extras libraries (scala-io, string, cats, render)

## Getting Started

### Prerequisites

- [Scala CLI](https://scala-cli.virtuslab.org/) installed on your system

OR

- Install [Scala CLI](https://first-day.kevinly.dev/docs/dev-env/scala#scala-cli) with [SdkMan!](https://first-day.kevinly.dev/docs/dev-env/sdkman#installation).

### Setup

1. Clone this repository
2. Set up IDE support (optional):
   ```bash
   ./setup-ide.sh
   ```

### Running Examples

To run the basic playground:
```bash
./run-playground.sh
```

To run the playground with library examples:
```bash
./run-playgroundLibs.sh
```

## Examples Included

The `playgroundLibs.scala` file includes examples of:

- **Cats** - Functional programming abstractions
- **Cats Effect** - Effect system for Scala
- **Refined4s** - Type refinements for more type safety
- **JSoup** - HTML parsing
- **Laika** - Markdown parsing
- **Extras** - Various utility libraries including colored console output

## Development

This project uses Scala CLI for development. The `project.scala` file centralizes all dependencies and compiler settings.

To add new dependencies, modify the `project.scala` file with the appropriate `using dep` directives.

## Cleaning Up

To clean temporary files:
```bash
./clean.sh
```
