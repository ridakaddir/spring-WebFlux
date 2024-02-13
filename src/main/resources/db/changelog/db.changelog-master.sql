--liquibase formatted sql

--precondition onFail:MARK_RAN onError:MART_RAN
--changeset author:1
-- precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'campaigns';
CREATE TABLE campaigns (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    target_audience VARCHAR(255) NOT NULL,
    budget DECIMAL(10, 2) NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    status boolean NOT NULL DEFAULT TRUE

);