insert into user_tb(username, password, email, created_at)
values ('ssar', '$2a$10$tWaDeUiiOVPM.VZCirDTvOwxy3Hxddgup.tQsAFkMfbogSuQTSRKW', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('cos', '$2a$10$tWaDeUiiOVPM.VZCirDTvOwxy3Hxddgup.tQsAFkMfbogSuQTSRKW', 'cos@nate.com', now());

insert into board_tb(title, content, user_id, created_at)
values ('제목1', '내용1', 1, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목2', '내용2', 1, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목3', '내용3', 1, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목4', '내용4', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('title5', '내용5', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('title6', '내용6', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('title7', '내용7', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('title8', '내용8', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('title9', '내용9', 2, now());

insert into reply_tb(comment, board_id, user_id, created_at)
values ('댓글1', 1, 1, now());
insert into reply_tb(comment, board_id, user_id, created_at)
values ('댓글2', 4, 1, now());
insert into reply_tb(comment, board_id, user_id, created_at)
values ('댓글3', 4, 1, now());
insert into reply_tb(comment, board_id, user_id, created_at)
values ('댓글4', 4, 2, now());

insert into love_tb(board_id, user_id, created_at)
values (9, 1, now());
insert into love_tb(board_id, user_id, created_at)
values (9, 2, now());
insert into love_tb(board_id, user_id, created_at)
values (8, 1, now());
