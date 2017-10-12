[![Build Status](https://travis-ci.org/mileschen360/BenchMe.svg?branch=master)](https://travis-ci.org/mileschen360/BenchMe)

# PECAN: benchmarks for *P*rogramming *E*ventual *C*onsistency *AN*omaly

PECAN is a benchmark set for programming eventual consistency systems, such as Riak and Cassandra. These benchmarks are extracted from real usage scenarios.

## Directory structure

All benchmarks are located in bechmarks folder.

## Requirement

   Gradle build system will take care of all the dependency. But to actually run some of the benchmarks that actually talk to a Riak cluster, you need to have a Riak cluster running on `127.0.0.1:8089`. The quickest way is to run the docker image from basho, which can be find at https://hub.docker.com/r/basho/riak-kv/

## List of Benchmarks

### Distributed Counter

A eventual consistent distributed counter can be implemented by CRDTs, such as GCounter and PNCounter

### Unique Poll

### Quick Vote

### Micro Blog

### Instant Poll

### Concert Admission

### Bank Account


### Shopping Cart


### Inventory System

### Product Review