# WorkDistributor

A few simple microservices to demonstrate doing work asynchronously.

The Boss constantly generates work and, depending on the time, sends different work to different workers. The Serf, Lackey and Dogsbody must do the work the Boss sends.

"Work" is sent via named events over the CDI event bus. Workers will only consume events named with their name.


### What's the point?
Message Brokers have typically been used to solve similar problems to this. It's important to avoid tight coupling when modelling business processes using services which should not have any knowledge of the overall process.
To make sure that the process can continue if a service is unavailable for any length of time, a JMS message could be sent to a queue and then consumed when the relevant service is available.

Rather than having to worry about setting up a highly available message broker cluster, Payara's CDI event bus can solve the same problem in a highly available way with as little as zero configuration.
