insert into usr (id, username, password, active)
values (1, 'admin', '$2a$08$5zBMTwFlnIqAjKeT0/rGweuqIvSMwAMEIVoKCG0J7vSgIxcbvrBAy', true);
insert into user_role(user_id, roles)
values (1, 'USER'),
       (1, 'ADMIN')
