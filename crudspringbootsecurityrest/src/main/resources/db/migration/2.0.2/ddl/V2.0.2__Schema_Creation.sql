CREATE TABLE EMPLOYEE (
	empd_id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	emp_name varchar(255),
	emp_last_name varchar(255),
	emp_active varchar(255),
);

create sequence employee_sequence start with 1 increment by 1;