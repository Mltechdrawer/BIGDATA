# ACID

ACID is a set of four essential properties that guarantee reliable, consistent, and safe transactions in a database system.

## Atomicity

A transaction must be treated as a single, indivisible unit: either all its operations are completed, or none are.
If something fails, the entire transaction is rolled back.

## Consistency

A transaction must take the database from one valid state to another valid state, following all defined rules, constraints, and data integrity requirements.

## Isolation

Concurrent transactions must not interfere with each other.
Each transaction should behave as if it were the only one running, even when many occur simultaneously.

## Durability

Once a transaction is committed, its results are permanent, even in the event of system crashes or power failures.