INSERT INTO user(id, created_timestamp, updated_timestamp, name, specialization) VALUES(1, CURRENT_DATE(), CURRENT_DATE(), 'Julio', 'SPECIALISATION1');
INSERT INTO user(id, created_timestamp, updated_timestamp, name, specialization) VALUES(2, CURRENT_DATE(), CURRENT_DATE(), 'Carlos', 'SPECIALISATION2');
INSERT INTO user(id, created_timestamp, updated_timestamp, name, specialization) VALUES(3, CURRENT_DATE(), CURRENT_DATE(), 'Jose', 'SPECIALISATION3');
INSERT INTO user(id, created_timestamp, updated_timestamp, name, specialization) VALUES(4, CURRENT_DATE(), CURRENT_DATE(), 'David', 'SPECIALISATION1');
INSERT INTO user(id, created_timestamp, updated_timestamp, name, specialization) VALUES(5, CURRENT_DATE(), CURRENT_DATE(), 'Adam', 'SPECIALISATION2');
INSERT INTO user(id, created_timestamp, updated_timestamp, name, specialization) VALUES(6, CURRENT_DATE(), CURRENT_DATE(), 'Esteban', 'SPECIALISATION3');

INSERT INTO field(id, created_timestamp, updated_timestamp, name, crop_type, latitude, longitude) VALUES(7, CURRENT_DATE(), CURRENT_DATE(), 'Costa Rica', 'CROPTYPECATEGORY1', 9.9271753, -84.0376110);
INSERT INTO field(id, created_timestamp, updated_timestamp, name, crop_type, latitude, longitude) VALUES(8, CURRENT_DATE(), CURRENT_DATE(), 'Finland', 'CROPTYPECATEGORY2', 60.1698301, 24.9388703);
INSERT INTO field(id, created_timestamp, updated_timestamp, name, crop_type, latitude, longitude) VALUES(9, CURRENT_DATE(), CURRENT_DATE(), 'Colombia', 'CROPTYPECATEGORY3', 4.670611, -74.081211);
INSERT INTO field(id, created_timestamp, updated_timestamp, name, crop_type, latitude, longitude) VALUES(10, CURRENT_DATE(), CURRENT_DATE(), 'Germany', 'CROPTYPECATEGORY1', 52.519561, 13.419401);
INSERT INTO field(id, created_timestamp, updated_timestamp, name, crop_type, latitude, longitude) VALUES(11, CURRENT_DATE(), CURRENT_DATE(), 'United States', 'CROPTYPECATEGORY2', 40.017962, -105.264243);
INSERT INTO field(id, created_timestamp, updated_timestamp, name, crop_type, latitude, longitude) VALUES(12, CURRENT_DATE(), CURRENT_DATE(), 'Panama', 'CROPTYPECATEGORY3', 9.047553, -79.430118);

INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(13, CURRENT_DATE(), CURRENT_DATE(), 22, 'Cloud Dummy 1', 50);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(14, CURRENT_DATE(), CURRENT_DATE(), 21, 'Cloud Dummy 2', 40);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(15, CURRENT_DATE(), CURRENT_DATE(), 20, 'Cloud Dummy 3', 30);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(16, CURRENT_DATE(), CURRENT_DATE(), 23, 'Cloud Dummy 4', 20);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(17, CURRENT_DATE(), CURRENT_DATE(), 24, 'Cloud Dummy 5', 60);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(18, CURRENT_DATE(), CURRENT_DATE(), 25, 'Cloud Dummy 6', 70);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(19, CURRENT_DATE(), CURRENT_DATE(), 26, 'Cloud Dummy 7', 80);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(20, CURRENT_DATE(), CURRENT_DATE(), 27, 'Cloud Dummy 8', 90);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(21, CURRENT_DATE(), CURRENT_DATE(), 18, 'Cloud Dummy 9', 55);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(22, CURRENT_DATE(), CURRENT_DATE(), 17, 'Cloud Dummy 9', 45);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(23, CURRENT_DATE(), CURRENT_DATE(), 16, 'Cloud Dummy 10', 35);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(24, CURRENT_DATE(), CURRENT_DATE(), 15, 'Cloud Dummy 11', 25);
INSERT INTO field_condition(id, created_timestamp, updated_timestamp, temperature, cloudiness_information, vegetation_information) VALUES(25, CURRENT_DATE(), CURRENT_DATE(), 14, 'Cloud Dummy 12', 15);

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