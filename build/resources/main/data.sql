TRUNCATE TABLE member;
INSERT INTO member(username, password, name, remark)
VALUES
    ('skku_student1','test1','학생1','테스트 학생'),
    ('skku_student2','test2','학생2','테스트 학생');

SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE board;
INSERT INTO board(id, title, remark)
VALUES
    (1,'자유게시판','이 게시판은 자유게시판입니다. 매너와 규칙 지켜주세요'),
    (2,'질문과 답변','이곳은 질문과 답변 게시판입니다. 매너와 규칙을 지켜주세요');

TRUNCATE TABLE post;
INSERT INTO post(board_id, title, contents)
VALUES
    (1, '스프링을 열심히 공부하고 싶습니다.','왜이래 잘 안풀릴까요.'),
    (1, '저랑 스터디하실분?','혼자 공부하려니 너무 힘듭니다. 좀 알려주세요!');

SET FOREIGN_KEY_CHECKS=1;