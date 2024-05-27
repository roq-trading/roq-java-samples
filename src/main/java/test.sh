#!/usr/bin/env bash

PREFIX="gdb --args"
PREFIX=""

# XXX FIXME -cp $CONDA_PREFIX/share/java/roq.jar ???

$PREFIX java \
  -Djava.library.path=$CONDA_PREFIX/lib \
  -jar roq-samples.jar \
  $@
