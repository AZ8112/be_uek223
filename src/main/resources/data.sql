--USERS

-- you can user gen_random_uuid () to generate random IDs, use this only to generate testdata


insert into users (id, email,first_name,last_name, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James','Bond', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6' ), -- Password: 1234
('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler','Durden', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6') -- Password: 1234
 ON CONFLICT DO NOTHING;


--ROLES
INSERT INTO role(id, name)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DEACTIVATE'),
('242ff7f7-7e6d-41eb-b52a-59b2e12c5189', 'READ_BLOGPOST'),
('cc9c3170-b2dc-4701-806a-998b74f23650', 'CREATE_BLOGPOST'),
('38296949-7a94-4827-9af5-6d381fd1a507', 'UPDATE_BLOGPOST'),
('a60481f1-8413-4789-9340-572827a140e5', 'DELETE_BLOGPOST'),
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'),
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02')
 ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', '2ebf301e-6c61-4076-98e3-2a38b31daf86'),
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
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'a60481f1-8413-4789-9340-572827a140e5'),
 ON CONFLICT DO NOTHING;