#DB 생성
DROP DATABASE IF EXISTS project1;
CREATE DATABASE project1;
USE project1;

#게시물 테이블 생성
CREATE TABLE article (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '번호',
regDate DATETIME NOT NULL COMMENT '작성날짜',
updateDate DATETIME NOT NULL COMMENT '수정날짜',
boardId INT(10) UNSIGNED NOT NULL COMMENT '게시판번호',
memberId INT(10) UNSIGNED NOT NULL COMMENT '회원번호',
title CHAR(100) NOT NULL COMMENT '제목',
`body` TEXT NOT NULL COMMENT '내용',
blindStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '블라인드여부',
blindDate DATETIME COMMENT '블라인드 날짜',
delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '삭제여부',
delDate DATETIME COMMENT '삭제 날짜',
hitCount INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '조회수',
repliesCount INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '댓글 수',
likeCount INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '좋아요 수',
dislikeCount INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '싫어요 수'
);

#테스트 게시물 생성
#1번 회원이 1번 게시판에
INSERT INTO article 
SET 
regDate = NOW(),
updateDate = NOW(),
boardId = 1,
memberId = 1,
title = '제목1',
`body` = '본문1';

INSERT INTO article 
SET 
regDate = NOW(),
updateDate = NOW(),
boardId = 1,
memberId = 1,
title = '제목2',
`body` = '본문2';

INSERT INTO article 
SET 
regDate = NOW(),
updateDate = NOW(),
boardId = 1,
memberId = 1,
title = '제목3',
`body` = '본문3';

#2번 회원이 1번 게시판에
INSERT INTO article 
SET 
regDate = NOW(),
updateDate = NOW(),
boardId = 1,
memberId = 2,
title = '제목12',
`body` = '본문12';

#2번 회원이 2번 게시판에
INSERT INTO article 
SET 
regDate = NOW(),
updateDate = NOW(),
boardId = 2,
memberId = 2,
title = '제목21',
`body` = '본문21';
