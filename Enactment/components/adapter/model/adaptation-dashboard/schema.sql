DROP TABLE IF EXISTS public.enactments;
DROP TABLE IF EXISTS public.actions;
DROP TABLE IF EXISTS public.adaptations;

CREATE TABLE adaptations (
	fc_id text NOT NULL,
	name text NOT NULL,
	computation_timestamp timestamp NOT NULL,
	rank real NOT NULL,
	model_system int NOT NULL,
	PRIMARY KEY (fc_id)
);

CREATE TABLE actions (
	fc_id text NOT NULL,
	action_id text NOT NULL,
	name text NOT NULL,
	description text NOT NULL,
	enabled boolean NOT NULL,
	PRIMARY KEY (fc_id,action_id),
	FOREIGN KEY (fc_id) REFERENCES adaptations(fc_id)
);

CREATE TABLE enactments (
	fc_id text NOT NULL,
	enactment_request_time timestamp NOT NULL,
	enactment_completion_time time NOT NULL,
	result boolean NOT NULL,
	PRIMARY KEY (fc_id),
	FOREIGN KEY (fc_id) REFERENCES adaptations(fc_id)
);	
