--USERS

-- you can user gen_random_uuid () to generate random IDs, use this only to generate testdata


insert into users (id, email,first_name,last_name, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James','Bond', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6' ), -- Password: 1234
('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler','Durden', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'), -- Password: 1234
('fa442c12-54fd-4cd0-ace9-2a7da5799114', 'user2@example.com', 'Weyo','Aller', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6') -- Password: 1234
ON CONFLICT DO NOTHING;

-- === Tyler Durden (user@example.com) ==============================
INSERT INTO blogpost (id, title, text, category, author, created_at) VALUES
('11111111-aaaa-4bbb-cccc-000000000001',
'Revolutionary Ideas',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae viverra nulla.',
'HISTORY',
'0d8fa44c-54fd-4cd0-ace9-2a7da57992de',
'2025-09-20 09:15:00'),

('11111111-aaaa-4bbb-cccc-000000000002',
'Soap Factory Insights',
'Suspendisse potenti. Nullam pharetra at dui non varius.',
'LIFESTYLE',
'0d8fa44c-54fd-4cd0-ace9-2a7da57992de',
'2025-09-20 11:40:00'),

('11111111-aaaa-4bbb-cccc-000000000003',
'Fight Club Rules',
'Curabitur nec ipsum vitae nulla volutpat tempor at at ipsum.',
'SPORT',
'0d8fa44c-54fd-4cd0-ace9-2a7da57992de',
'2025-09-21 14:05:00'),

('11111111-aaaa-4bbb-cccc-000000000004',
'Modern Identity Crisis',
'Fusce posuere, sapien sit amet malesuada facilisis, est metus interdum erat.',
'SPORT',
'0d8fa44c-54fd-4cd0-ace9-2a7da57992de',
'2025-09-22 16:20:00'),

('11111111-aaaa-4bbb-cccc-000000000005',
'Minimalism Lifestyle',
'Ut blandit, sapien nec tempor tincidunt, mi erat congue est, ac pulvinar purus mi non sapien.',
'OTHER',
'0d8fa44c-54fd-4cd0-ace9-2a7da57992de',
'2025-09-23 08:00:00'),

('11111111-aaaa-4bbb-cccc-000000000006',
'Project Mayhem Plans',
'Integer vitae lacinia nunc, sit amet vulputate massa.',
'ENTERTAINMENT',
'0d8fa44c-54fd-4cd0-ace9-2a7da57992de',
'2025-09-24 18:45:00')
ON CONFLICT DO NOTHING;

-- === Weyo Aller (user2@example.com) ===============================
INSERT INTO blogpost (id, title, text, category, author, created_at) VALUES
('22222222-bbbb-4ccc-dddd-000000000001',
'Cooking with Passion',
'Vestibulum finibus, purus sit amet bibendum feugiat, magna augue tincidunt urna.',
'ADVICE',
'fa442c12-54fd-4cd0-ace9-2a7da5799114',
'2025-09-18 12:30:00'),

('22222222-bbbb-4ccc-dddd-000000000002',
'Traveling the Alps',
'Donec sodales neque sit amet magna tincidunt, sed tristique risus vestibulum.',
'SPORT',
'fa442c12-54fd-4cd0-ace9-2a7da5799114',
'2025-09-19 15:10:00'),

('22222222-bbbb-4ccc-dddd-000000000003',
'Photography Hacks',
'Mauris convallis felis eu suscipit dapibus. Integer in fermentum nulla.',
'FOOD',
'fa442c12-54fd-4cd0-ace9-2a7da5799114',
'2025-09-20 19:25:00'),

('22222222-bbbb-4ccc-dddd-000000000004',
'Tech Innovations 2025',
'Cras luctus mi et tincidunt rhoncus. Ut vel ipsum eu nunc bibendum facilisis.',
'TECHNOLOGY',
'fa442c12-54fd-4cd0-ace9-2a7da5799114',
'2025-09-21 09:00:00'),

('22222222-bbbb-4ccc-dddd-000000000005',
'Fitness Routine Basics',
'Aliquam et eros sit amet lorem aliquet ullamcorper. Curabitur posuere urna id purus cursus.',
'SPORT',
'fa442c12-54fd-4cd0-ace9-2a7da5799114',
'2025-09-22 17:40:00'),

('22222222-bbbb-4ccc-dddd-000000000006',
'Mindfulness Practice',
'Sed porttitor enim sit amet massa tincidunt, a semper sapien vulputate.',
'TRAVEL',
'fa442c12-54fd-4cd0-ace9-2a7da5799114',
'2025-09-23 13:55:00')
ON CONFLICT DO NOTHING;

-- === James Bond (admin@example.com) ===============================
INSERT INTO blogpost (id, title, text, category, author, created_at) VALUES
('33333333-cccc-4ddd-eeee-000000000001',
'Espionage in Modern Era',
'Pellentesque habitant morbi tristique senectus et netus et malesuada fames.',
'LIFESTYLE',
'ba804cb9-fa14-42a5-afaf-be488742fc54',
'2025-09-19 10:30:00'),

('33333333-cccc-4ddd-eeee-000000000002',
'Martini Recipes',
'Praesent vel mauris non metus faucibus bibendum sed sit amet orci.',
'FOOD',
'ba804cb9-fa14-42a5-afaf-be488742fc54',
'2025-09-20 18:20:00'),

('33333333-cccc-4ddd-eeee-000000000003',
'Spy Gadgets 2025',
'Nam sed sapien at ligula aliquam ullamcorper. Sed eget orci nec urna egestas malesuada.',
'TECHNOLOGY',
'ba804cb9-fa14-42a5-afaf-be488742fc54',
'2025-09-21 12:45:00'),

('33333333-cccc-4ddd-eeee-000000000004',
'Undercover Operations',
'Curabitur vitae purus efficitur, egestas arcu nec, dictum nunc.',
'BUSINESS',
'ba804cb9-fa14-42a5-afaf-be488742fc54',
'2025-09-22 14:00:00'),

('33333333-cccc-4ddd-eeee-000000000005',
'Casino Royale Tactics',
'Integer eu risus eget lorem congue sagittis eget sit amet justo.',
'EDUCATION',
'ba804cb9-fa14-42a5-afaf-be488742fc54',
'2025-09-23 20:15:00'),

('33333333-cccc-4ddd-eeee-000000000006',
'Luxury Cars Overview',
'Aenean dignissim, nibh vel faucibus interdum, magna orci bibendum elit.',
'SPORT',
'ba804cb9-fa14-42a5-afaf-be488742fc54',
'2025-09-24 08:50:00')
ON CONFLICT DO NOTHING;


--ROLES
INSERT INTO role(id, name)
VALUES
('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DELETE'),
('242ff7f7-7e6d-41eb-b52a-59b2e12c5189', 'BLOGPOST_READ'),
('cc9c3170-b2dc-4701-806a-998b74f23650', 'BLOGPOST_CREATE'),
('38296949-7a94-4827-9af5-6d381fd1a507', 'BLOGPOST_UPDATE'),
('a60481f1-8413-4789-9340-572827a140e5', 'BLOGPOST_DELETE')
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02'),
       ('fa442c12-54fd-4cd0-ace9-2a7da5799114', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02'),
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02')
 ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES
('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '21c942db-a275-43f8-bdd6-d048c21bf5ab'),
-- Blogpost authorities for admin
('ab505c92-7280-49fd-a7de-258e618df074', '242ff7f7-7e6d-41eb-b52a-59b2e12c5189'),
('ab505c92-7280-49fd-a7de-258e618df074', 'cc9c3170-b2dc-4701-806a-998b74f23650'),
('ab505c92-7280-49fd-a7de-258e618df074', '38296949-7a94-4827-9af5-6d381fd1a507'),
('ab505c92-7280-49fd-a7de-258e618df074', 'a60481f1-8413-4789-9340-572827a140e5'),
-- Blogpost authorities for user
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '242ff7f7-7e6d-41eb-b52a-59b2e12c5189'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'cc9c3170-b2dc-4701-806a-998b74f23650'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '38296949-7a94-4827-9af5-6d381fd1a507'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'a60481f1-8413-4789-9340-572827a140e5')
 ON CONFLICT DO NOTHING;