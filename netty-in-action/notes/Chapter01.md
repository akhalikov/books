### Channels

A **Channel** is a basic construct of NIO. It represents an open connection to an entity 
such as a hardware device, a file, a network socket, or a program component that is capable 
of performing one or more distinct I/O operations, for example reading or writing5.

For now, think of a Channel as "open" or "closed", "connected" or "disconnected" and as a
vehicle for incoming and outgoing data.

### Callbacks

A callback is simply a method, a reference to which has been provided to another method, so
that the latter can call the former at some appropriate time. 
This technique is used in a broad range of programming situations and is one of the most 
common ways to notify an interested party that an operation has completed.