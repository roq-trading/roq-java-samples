#!/usr/bin/env bash

PREFIX="gdb --args"
PREFIX=""

# XXX FIXME -cp $CONDA_PREFIX/share/java/roq.jar ???

$PREFIX java \
  -Djava.library.path=$CONDA_PREFIX/lib \
  -cp $CONDA_PREFIX/share/java/roq.jar:roq-samples.jar \
  com.roq.samples.Main \
  $@
