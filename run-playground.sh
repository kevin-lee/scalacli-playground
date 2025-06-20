#!/bin/bash

echo "Start..."

set -eux

# Run with the current directory as project to pick up project.scala
scala-cli run . --main-class play -- "$@"
