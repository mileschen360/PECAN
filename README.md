[![Build Status](https://travis-ci.org/mileschen360/PECAN.svg?branch=master)](https://travis-ci.org/mileschen360/PECAN)

# PECAN: benchmarks for *P*rogramming *E*ventual *C*onsistency *AN*omaly

PECAN is a benchmark set for programming eventual consistent systems, such as Riak and Cassandra. These benchmarks are extracted from real usage scenarios of eventual consistent systems.

## Directory structure

All benchmarks are located in bechmarks folder.

## Requirement

   Gradle build system will take care of all the dependency. But to run some of the benchmarks that actually talk to a Riak cluster, you need to have a Riak cluster running on `127.0.0.1:8098`. The quickest way is to run the docker image from basho, which can be found at https://hub.docker.com/r/basho/riak-kv/

## List of Benchmarks

### Distributed Counter

An eventual consistent distributed counter can be implemented by CRDTs, such as GCounter and PNCounter

### Unique Poll

### Quick Vote

### Micro Blog

### Instant Poll

### Concert Admission

### Bank Account

### Chat Room

### Shopping Cart


### Inventory System

### Product Review