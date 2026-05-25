#!/usr/bin/env bash
set -euo pipefail

for lab in Lab*/; do
  echo "Compiling ${lab}"
  mkdir -p "${lab}out"
  javac -encoding UTF-8 -d "${lab}out" "${lab}"src/*.java
done

echo "All labs compiled successfully."
