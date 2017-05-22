DROP TABLE public.adaptations;

CREATE TABLE adaptations (
	adaptation_id bigint NOT NULL,
	name text NOT NULL UNIQUE,
	feature_id text NOT NULL,
	enabled boolean NOT NULL,
	description text NOT NULL,
	computation_timestamp timestamp NOT NULL,
	rank real NOT NULL,
	enacted boolean NOT NULL,
	enacted_timestamp timestamp,
	result boolean default false, 
	enacted_time time
);

ALTER TABLE ONLY adaptations
    ADD CONSTRAINT adaptations_primary_key PRIMARY KEY (adaptation_id);
	
