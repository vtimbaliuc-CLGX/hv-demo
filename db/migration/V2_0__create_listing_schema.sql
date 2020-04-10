CREATE TABLE IF NOT EXISTS listing (
id uuid NOT NULL PRIMARY KEY,
city varchar(20),
postal_code varchar(20),
street_name varchar(20),
street_number varchar(20),
agent_id uuid REFERENCES agent(id)
);