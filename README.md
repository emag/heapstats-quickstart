# heapstats-quickstart

## Usage

### nontrouble

~~~
$ curl "localhost:8080/heapstats-quickstart-nontrouble/echo?message=foo"
~~~

### memleak

~~~
$ curl -X POST --dump-header /tmp/headers "localhost:8080/heapstats-quickstart-memleak/increasing-session"
$ curl -X POST -b /tmp/headers "localhost:8080/heapstats-quickstart-memleak/increasing-session"
~~~

### deadlock

~~~
$ curl -X POST "localhost:8080/heapstats-quickstart-deadlock/run"
~~~
