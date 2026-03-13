-- Audience (3 записи)
INSERT INTO Audience (room_name, university_building, amount_of_seats) VALUES
('A101', 1, 60),
('B205', 2, 45),
('C312', 3, 80);

-- RoomType (3 записи)
INSERT INTO RoomType (room_type_name) VALUES
('Lecture'),
('Seminar'),
('Laboratory');

-- Audience_RoomType (3 связи)
INSERT INTO Audience_RoomType (room_type_id, audience_id) VALUES
(1, 1),  -- A101 = Lecture
(2, 2),  -- B205 = Seminar
(3, 3);  -- C312 = Laboratory

-- Professor (3 записи)
INSERT INTO Professor (first_name, last_name, email, phone_number) VALUES
('Иван', 'Петров', 'petrov@uni.md', '+3731234567'),
('Мария', 'Сидорова', 'sidorova@uni.md', '+3737654321'),
('Алексей', 'Иванов', 'ivanov@uni.md', '+37311223344');

-- Faculty (3 записи)
INSERT INTO Faculty (faculty_name) VALUES
('Факультет информатики'),
('Факультет математики'),
('Факультет физики');

-- Specialization (3 записи)
INSERT INTO Specialization (spec_name, faculty_id, years_of_study) VALUES
('Программная инженерия', 1, 4),
('Прикладная математика', 2, 4),
('Информатика', 1, 4);

-- Discipline (3 записи)
INSERT INTO Discipline (
    discipline_name, study_semester, required_room_type, credits, spec_id,
    contact_study_hours, independent_study_hours, course_hours, seminar_hours, laboratories_hours
) VALUES
('Алгоритмы и структуры данных', 4, 1, 6.0, 1, 60, 90, 40, 10, 10),
('Базы данных', 5, 3, 5.0, 1, 48, 72, 0, 16, 32),
('Операционные системы', 6, 1, 4.5, 1, 36, 54, 24, 8, 4);

-- Students_Group (3 записи)
INSERT INTO Students_Group (group_name, professor_inspector, spec_id) VALUES
('ИТ-41', 1, 1),
('ИТ-42', 2, 1),
('МАТ-41', 3, 2);

-- Student (3 записи)
INSERT INTO Student (students_group_id, first_name, last_name, email) VALUES
(1, 'Виктор', 'Анисимов', 'victor@uni.md'),
(1, 'Анна', 'Кузнецова', 'anna@uni.md'),
(2, 'Дмитрий', 'Смирнов', 'dmitry@uni.md');

-- Group_Elder_student (3 связи)
INSERT INTO Group_Elder_student (students_group_id, student_id) VALUES
(1, 1),  -- Виктор - староста ИТ-41
(2, 3),  -- Дмитрий - староста ИТ-42
(3, 1);  -- Виктор - староста МАТ-41 (второй группе)

-- Professor_Discipline (3 связи)
INSERT INTO Professor_Discipline (professor_id, discipline_id) VALUES
(1, 1),  -- Петров ведет Алгоритмы
(2, 2),  -- Сидорова ведет Базы данных
(3, 3);  -- Иванов ведет Операционные системы
