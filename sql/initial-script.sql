CREATE TABLE events_detail(
   id serial PRIMARY KEY,
   event_type VARCHAR (50) NOT NULL,
   event_type VARCHAR (50) NOT NULL
);


insert into events_detail (id, event_type, event_desc) values (1, 'login', 'Macts Login Event');

CREATE TABLE audit_logs(
   id serial PRIMARY KEY,
   user_id VARCHAR (20),
   system_id VARCHAR (20),
   event_id integer,
   event_datetime timestamptz,
   event_parameters VARCHAR(50),
   event_status VARCHAR(20),
   created_by VARCHAR(20),
   created_datetime timestamptz,
   CONSTRAINT event_type_event_id_fkey FOREIGN KEY (event_id)
      REFERENCES events_detail (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);