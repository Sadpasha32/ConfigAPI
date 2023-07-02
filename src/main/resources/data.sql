INSERT INTO config (params,configUUID,created_at) VALUES('some parameters','637efbdc-18f6-11ee-be56-0242ac120002',to_date('07 01 2023','DD MM YYYY'))
INSERT INTO config (params,configUUID,created_at) VALUES('some parameters','742f4414-18f6-11ee-be56-0242ac120002',to_date('10 10 2022','DD MM YYYY'))
INSERT INTO config (params,configUUID,created_at) VALUES('some parameters','7781873a-18f6-11ee-be56-0242ac120002',to_date('05 04 2023','DD MM YYYY'))
INSERT INTO config (params,configUUID,created_at) VALUES('some parameters','7af6d078-18f6-11ee-be56-0242ac120002',to_date('04 05 2023','DD MM YYYY'))
INSERT INTO config (params,configUUID,created_at) VALUES('some parameters','7f2939ba-18f6-11ee-be56-0242ac120002',to_date('01 01 2024','DD MM YYYY'))

INSERT INTO status (status_name) VALUES('RUNNING')
INSERT INTO status (status_name) VALUES('COMPLETE')
INSERT INTO status (status_name) VALUES('ERROR')

INSERT INTO calculation (configID,statusID) VALUES(1,1)
INSERT INTO calculation (configID,statusID) VALUES(2,2)
INSERT INTO calculation (configID,statusID) VALUES(3,2)
INSERT INTO calculation (configID,statusID) VALUES(4,3)