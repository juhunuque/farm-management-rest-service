CREATE TABLE user (
  id BIGINT PRIMARY KEY NOT NULL,
  created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  name VARCHAR(50) NOT NULL,
  specialization VARCHAR(50) NOT NULL
);

CREATE TABLE field (
  id BIGINT PRIMARY KEY NOT NULL,
  created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  name VARCHAR(50) NOT NULL,
  crop_type VARCHAR(50) NOT NULL,
  latitude DECIMAL(10, 8) NOT NULL,
  longitude DECIMAL(11,8) NOT NULL
);

CREATE TABLE field_condition (
  id BIGINT PRIMARY KEY NOT NULL,
  created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  temperature INTEGER NOT  NULL,
  cloudiness_information VARCHAR(50) NOT NULL,
  vegetation_information INTEGER NOT NULL
);

CREATE TABLE field_user (
  id BIGINT PRIMARY KEY NOT NULL,
  field_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL
);

CREATE TABLE field_condition_field (
  id BIGINT PRIMARY KEY NOT NULL,
  field_id BIGINT NOT NULL,
  field_condition_id BIGINT NOT NULL
);

CREATE TABLE hibernate_sequence (
  next_val bigint(20) DEFAULT NULL
);

ALTER TABLE field_user ADD FOREIGN KEY (field_id) REFERENCES field (id);
ALTER TABLE field_user ADD FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE field_condition_field ADD FOREIGN KEY (field_id) REFERENCES field (id);
ALTER TABLE field_condition_field ADD FOREIGN KEY (field_condition_id) REFERENCES field_condition (id);

INSERT INTO user(id, name, specialization) VALUES(1, 'Julio', 'SPECIALISATION1');
INSERT INTO user(id, name, specialization) VALUES(2, 'Carlos', 'SPECIALISATION2');
INSERT INTO user(id, name, specialization) VALUES(3, 'Jose', 'SPECIALISATION3');
INSERT INTO user(id, name, specialization) VALUES(4, 'David', 'SPECIALISATION1');
INSERT INTO user(id, name, specialization) VALUES(5, 'Adam', 'SPECIALISATION2');
INSERT INTO user(id, name, specialization) VALUES(6, 'Esteban', 'SPECIALISATION3');

INSERT INTO field(id, name, crop_type, latitude, longitude) VALUES(7, 'Costa Rica', 'CROPTYPECATEGORY1', 9.9271753, -84.0376110);
INSERT INTO field(id, name, crop_type, latitude, longitude) VALUES(8, 'Finland', 'CROPTYPECATEGORY2', 60.1698301, 24.9388703);
INSERT INTO field(id, name, crop_type, latitude, longitude) VALUES(9, 'Colombia', 'CROPTYPECATEGORY3', 4.670611, -74.081211);
INSERT INTO field(id, name, crop_type, latitude, longitude) VALUES(10, 'Germany', 'CROPTYPECATEGORY1', 52.519561, 13.419401);
INSERT INTO field(id, name, crop_type, latitude, longitude) VALUES(11, 'United States', 'CROPTYPECATEGORY2', 40.017962, -105.264243);
INSERT INTO field(id, name, crop_type, latitude, longitude) VALUES(12, 'Panama', 'CROPTYPECATEGORY3', 9.047553, -79.430118);

INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(13, 22, 'Cloud Dummy 1', 50);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(14, 21, 'Cloud Dummy 2', 40);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(15, 20, 'Cloud Dummy 3', 30);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(16, 23, 'Cloud Dummy 4', 20);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(17, 24, 'Cloud Dummy 5', 60);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(18, 25, 'Cloud Dummy 6', 70);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(19, 26, 'Cloud Dummy 7', 80);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(20, 27, 'Cloud Dummy 8', 90);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(21, 18, 'Cloud Dummy 9', 55);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(22, 17, 'Cloud Dummy 9', 45);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(23, 16, 'Cloud Dummy 10', 35);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(24, 15, 'Cloud Dummy 11', 25);
INSERT INTO field_condition(id, temperature, cloudiness_information, vegetation_information) VALUES(25, 14, 'Cloud Dummy 12', 15);

INSERT INTO field_user(id, field_id, user_id) VALUES(26, 7, 1);
INSERT INTO field_user(id, field_id, user_id) VALUES(27, 7, 2);
INSERT INTO field_user(id, field_id, user_id) VALUES(28, 8, 3);
INSERT INTO field_user(id, field_id, user_id) VALUES(29, 8, 4);
INSERT INTO field_user(id, field_id, user_id) VALUES(30, 9, 5);
INSERT INTO field_user(id, field_id, user_id) VALUES(31, 9, 6);
INSERT INTO field_user(id, field_id, user_id) VALUES(32, 10, 1);
INSERT INTO field_user(id, field_id, user_id) VALUES(33, 10, 2);
INSERT INTO field_user(id, field_id, user_id) VALUES(34, 11, 3);
INSERT INTO field_user(id, field_id, user_id) VALUES(35, 11, 4);
INSERT INTO field_user(id, field_id, user_id) VALUES(36, 12, 5);
INSERT INTO field_user(id, field_id, user_id) VALUES(37, 12, 6);

INSERT INTO field_condition_field(id, field_id, field_condition_id) VALUES(38, 7, 13);
INSERT INTO field_condition_field(id, field_id, field_condition_id) VALUES(39, 8, 14);
INSERT INTO field_condition_field(id, field_id, field_condition_id) VALUES(40, 9, 15);
INSERT INTO field_condition_field(id, field_id, field_condition_id) VALUES(41, 10, 16);
INSERT INTO field_condition_field(id, field_id, field_condition_id) VALUES(42, 11, 17);
INSERT INTO field_condition_field(id, field_id, field_condition_id) VALUES(43, 12, 18);

INSERT INTO hibernate_sequence(next_val) VALUES(44);
