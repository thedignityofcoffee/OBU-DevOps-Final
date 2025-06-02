# Week 11 Deployment

## Defination

- Software deployment refers to the process of delivering completed software to its users or to a production environment
    - Put simply, it means making software available to users
- "Users" are not necessarily "end users": could be other programmers or technicians in a different company or division
- This may also not mean giving copies of the software to users
- Multiple different methods of deployment exist, with different advantages and tradeoffs

## Practice

omitted

## Server deployment issues

### Downtime

- Server will become unavailable while deployment is in progress
- If all servers are updated at the same time, the entire site/app will become unavailable for hours – this might not be acceptable
- Also, if anything goes wrong with the deployment, everything will be broken and have to be rolled back, meaning even more downtime

### Solving downtime

Blue-Green deployment<br>

- There are two production servers that are as identical as possible. The Blue server is live, handling all production traffic, while the Green server is idle.
- When a new version of the application needs to be released, deploy it to Green, which is currently idle. Once the new deployment is thoroughly tested on the Green server, switch the traffic from Blue to Green, and Blue becomes idle.
- If issues are detected in the new version after the traffic switch, simply switch the traffic back to Blue for immediate rollback.

Rolling deployment<br>

- Deploy new versions to servers gradually, spaced over time
- Servers that are not being updated currently can handle incoming requests, meaning performance loss but not complete downtime
- Problem: old and new versions will coexist during the process
- Problem: deployment will eventually become total, giving the same problem if the new version breaks something

Partial deployment<br>
- Deploy new version, but only to some servers
- Different from rolling deployment in that the timescale is longer and some users are intended to continue using the older version
- Can determine which version is used by random choice of server or by particular usernames, regions, server areas, etc
- Can solve the “broken version” problem, as the users on the new version will test it while the old version continues existing
- Not appropriate for some updates, such as security fixes

### The co-existence problem

- Old and new versions coexisting can be a significant problem, especially when servers depend on each other
- Especially the case when backend servers are being upgraded or database formats are changing
  - Does the new program know how to deal with the old database server?
  - Does the new database server know how to deal with the old program?
  - Can the old and new database servers synchronize with each other?

### Deployment strategies for servers

- Convergence approach.
    - As with desktops, update only the parts of the system that need to be updated.
    - Quicker, and allows individual servers to be customized more easily, but also allows them to drift out of sync with others.

- Immutable infrastructure approach.
    - Simply wipe the whole server and install everything, including the OS, from scratch.
    - Not viable for desktop deployments, but viable for servers that have no other function other than being servers.
    - Can be slower, but ensures there is no drift.
    - Servers holding data must be able to recover that data from elsewhere, or have a snapshot as part of the installed image.

### Continuous Deployment (CD)

- An agile DevOps technique for reducing the load of deployment
- Based on the principle that any undeployed code is a liability
    - It might break when deployed
    - The more code is deployed at once, the more difficult it can be to find what is wrong if it does
- Therefore, deploy every change as soon as possible, or even immediately when committed
    - Requires strong backup and security support
    - "If it hurts, do it more often."<br>

<br>

- Common continuous deployment practices:
    - Automated testing
    - Integration and delivery pipeline
    - Production-like staging
    - Monitoring and feedback
    - Rollback mechanisms
    - Incremental deployment


### Containerization

A technique where a program and all its requirements (in terms of libraries, interpreters, support files) are packed into a single image.  

- Image typically does not include the entire OS (unlike a virtual machine). The OS kernel (the lowest level of the OS) is taken from the installed OS.
- Apart from this, the program cannot access anything outside the container.
- Has been experimented with on multiple platforms and contexts for use in deployment, and also security.

### Docker

A popular containerization system  

- Based on Linux, but has support in Windows
- Program is compiled as normal, but rather than running on the development machine, it is built into a container image which is then run
- The container image is also automatically built based on a Dockerfile which tells Docker how the program and its components must be set up
- Docker can start from scratch, or adapt an existing image
- This is intended to be used for starting from standard images with support for particular programming environments, not to change the previous container into which a program was built

### Containerization benefits

- Docker's containerization can allow server programs to be quickly deployed across multiple machines without risk of conflict or drift on those machines, and manage connections between them
- It can also support role‐based configuration management: where the container that runs on a machine is not fixed to what machine it is, but can vary according to what the system needs

> [!TIP]
> 🔗 [Practice](week-11-practices.md)

