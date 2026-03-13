create table Audience(
audience_id serial primary key,
room_name varchar(10) unique,
university_building int not null,
amount_of_seats int not null
);

create table RoomType(
room_type_id serial primary key,
room_type_name varchar not null
);

create table Audience_RoomType(
room_type_id int,
audience_id int,

primary key (room_type_id, audience_id),
foreign key (room_type_id) references RoomType(room_type_id),
foreign key (audience_id) references Audience(audience_id)
);

create table Professor(
professor_id serial primary key,
first_name varchar not null,
last_name varchar not null,
email varchar not null,
phone_number varchar not null
);

create table Faculty(
faculty_id serial primary key,
faculty_name varchar not null unique
);

create table Specialization(
spec_id serial primary key,
spec_name varchar not null,
faculty_id int not null,
years_of_study int not null,
foreign key(faculty_id) references Faculty(faculty_id)
);

create table Discipline(
discipline_id serial primary key,
discipline_name varchar(40) not null,
study_semester int not null,
required_room_type int,
credits float,
spec_id int not null,

contact_study_hours float,
independent_study_hours float,
course_hours float,
seminar_hours float,
laboratories_hours float,

foreign key (spec_id) references specialization(spec_id),
foreign key (required_room_type) references RoomType(room_type_id),
unique(discipline_name, study_semester, spec_id)
);

create table Students_Group(
students_group_id serial primary key,
group_name varchar(10) not null unique,
professor_inspector int,
spec_id int not null,
FOREIGN KEY (spec_id) REFERENCES specialization(spec_id),
foreign key (professor_inspector) references Professor(professor_id)
);

create table Student(
student_id serial primary key,
students_group_id int,
first_name varchar not null,
last_name varchar not null,
email varchar,

foreign key (students_group_id) references Students_Group(students_group_id)
);

create table Group_Elder_student(
students_group_id int,
student_id int,

primary key (students_group_id, student_id),
foreign key (students_group_id) references Students_Group(students_group_id),
foreign key (student_id) references Student(student_id)
);

create table Professor_Discipline(
professor_id int,
discipline_id int,

primary key (professor_id, discipline_id),
foreign key (professor_id) references Professor(professor_id),
foreign key (discipline_id) references Discipline(discipline_id)
);