# roq-java-samples

Example projects demonstrating how to use Roq's Java bindings.


## Operating Systems

* Linux (x86-64, AArch64)
* macOS (Arm64, x86-64)


## Installing

If you just want to install the project.

### Stable Channel

```bash
conda install -y --channel https://roq-trading.com/conda/stable roq-java-samples
```

### Unstable Channel

```bash
conda install -y --channel https://roq-trading.com/conda/unstable roq-java-samples
```


## Prerequisites

If you want to build from source.

Install Roq's Java bindings

| Channel  | Command                                                                      |
| -------- | :--------------------------------------------------------------------------: |
| stable   | `conda install -y --channel https://roq-trading.com/conda/stable roq-java`   |
| unstable | `conda install -y --channel https://roq-trading.com/conda/unstable roq-java` |
```

### Third-party

```bash
conda install -y openjdk
```


## Building

If you want to build from source.

```bash
cmake . && make -j4 && make install
```


## Using

```bash
java \
  -Djava.library.path=$CONDA_PREFIX/lib \
  -classpath $CONDA_PREFIX/share/java/roq.jar:$CONDA_PREFIX/share/java/roq-samples.jar \
  com.roq.samples.Main \
  $HOME/run/deribit.sock
```

## License

The project is released under the terms of the BSD 3-Clause license.


## Links

* [Roq GmbH](https://roq-trading.com/)
* [Documentation](https://roq-trading.com/docs/)
* [Contact us](mailto:info@roq-trading.com)
