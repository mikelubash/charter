
DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions (
     id integer not null,
        customerId integer not null,
        amount integer not null,
        createdAt timestamp not null,
        primary key(id)
);