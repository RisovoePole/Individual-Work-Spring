BEGIN;

-- 1. BUILDING
INSERT INTO building (building_name, address) VALUES
('Central корпус', 'ул. Пушкина 10'),
('Корпус информатики', 'ул. Студенческая 5'),
('Лабораторный корпус', 'ул. Университетская 1');

-- 2. AUDIENCE
INSERT INTO audience (room_name, building_id, amount_of_seats) VALUES
('A101', 1, 120),
('B205', 2, 40),
('L301', 3, 25);

-- 3. ROOMTYPE
INSERT INTO roomtype (room_type_name) VALUES
('Lecture'),
('Seminar'),
('Laboratory');

-- 4. AUDIENCE_ROOMTYPE
INSERT INTO audience_roomtype (room_type_id, audience_id) VALUES
(1, 1),
(2, 2),
(3, 3);

-- 5. PAIRTIMEBORDERS
INSERT INTO pairtimeborders (pair_start, pair_end) VALUES
('08:00', '09:30'),
('09:45', '11:15'),
('11:30', '13:00');

-- 6. TIMESLOT
INSERT INTO timeslot (day_of_week, pair_number) VALUES
(1, 1), -- Monday, 1st pair
(1, 2),
(2, 1);

-- 7. FACULTY
INSERT INTO faculty (faculty_name) VALUES
('Computer Science'),
('Mathematics'),
('Physics');

-- 8. SPECIALIZATION
INSERT INTO specialization (spec_name, faculty_id, years_of_study) VALUES
('Software Engineering', 1, 4),
('Applied Mathematics', 2, 4),
('Theoretical Physics', 3, 4);

-- 9. SUBGROUP
INSERT INTO subgroup (subgroup_name) VALUES
('A'),
('B'),
('C');

-- 10. STUDENTS_GROUP
INSERT INTO students_group (group_name, spec_id, students_count) VALUES
('SE-221', 1, 28),
('AM-221', 2, 24),
('TP-221', 3, 20);

-- 11. STUDENTS_GROUP_SUBGROUP
INSERT INTO students_group_subgroup (students_group_id, subgroup_id) VALUES
(1, 1),
(1, 2),
(2, 3);

-- 12. PROFESSOR
INSERT INTO professor (first_name, last_name, email, phone_number) VALUES
('Ion', 'Popescu', 'ion.popescu@usm.md', '+37360000001'),
('Maria', 'Ionescu', 'maria.ionescu@usm.md', '+37360000002'),
('Victor', 'Rusu', 'victor.rusu@usm.md', '+37360000003');

-- 13. DISCIPLINE
INSERT INTO discipline (
    discipline_name,
    study_semester,
    required_room_type,
    credits,
    spec_id,
    contact_hours,
    independent_hours,
    course_hours,
    seminar_hours,
    lab_hours
) VALUES
('Java Programming', 4, 3, 6, 1, 90, 60, 30, 15, 45),
('Discrete Mathematics', 2, 2, 5, 2, 75, 45, 45, 30, 0),
('Quantum Mechanics', 6, 1, 6, 3, 90, 60, 60, 30, 0);

-- 14. PROFESSOR_DISCIPLINE
INSERT INTO professor_discipline (professor_id, discipline_id) VALUES
(1, 1),
(2, 2),
(3, 3);

-- 15. GA_RUN
INSERT INTO ga_run (students_group_id, weeks_in_cycle) VALUES
(1, 16),
(2, 16),
(3, 16);

-- 16. GA_GENERATION
INSERT INTO ga_generation (ga_run_id, generation_number) VALUES
(1, 1),
(1, 2),
(2, 1);

-- 17. CHROMOSOME
INSERT INTO chromosome (ga_generation_id, fitness_score) VALUES
(1, 87.5),
(2, 91.2),
(3, 78.0);

-- 18. CHROMOSOME_DISCIPLINE
INSERT INTO chromosome_discipline (chromosome_id, position, discipline_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3);

-- 19. SCHEDULE
INSERT INTO schedule (
    chromosome_id,
    week_number,
    time_slot_id,
    audience_id,
    discipline_id,
    professor_id
) VALUES
(1, 1, 1, 3, 1, 1),
(2, 1, 2, 2, 2, 2),
(3, 1, 3, 1, 3, 3);

-- 20. SCHEDULE_CONSTRAINT
INSERT INTO schedule_constraint (
    ga_run_id,
    constraint_type_id,
    kind,
    soft_priority,
    professor_id,
    parameters
) VALUES
(
    1,
    1,
    'soft',
    5,
    1,
    '{"time":"18:00"}'
),
(
    1,
    4,
    'hard',
    NULL,
    2,
    '{}'
),
(
    2,
    6,
    'soft',
    3,
    NULL,
    '{"max_windows":1}'
);

COMMIT;