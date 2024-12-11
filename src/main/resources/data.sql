INSERT INTO `user` (reg_date,
                    udt_date,
                    email,
                    nick,
                    os,
                    password,
                    role,
                    user_id,
                    uuid)
VALUES (NOW(),
        NOW(),
        'user1@example.com',
        'nickname1',
        'ios',
        'hashed_password_123',
        'DEFAULT',
        'user1',
        'uuid_generated_string_123'),
       (NOW(),
        NOW(),
        'user2@example.com',
        'nickname2',
        'ios',
        'hashed_password_12',
        'DEFAULT',
        'user2',
        'uuid_generated_string_13');
SELECT * FROM user;

INSERT INTO appointments (penalty, win_condition)
VALUES ('밥사기', '아침일찍일어나기');

INSERT INTO user_appointment (user_idx, appointment_idx, `status`, is_host, result_status)
VALUES (1, 1, 'CLOSE', true, true),
       (2, 1, 'CLOSE', false, false);