Drop TABLE comment;
Drop TABLE video_like;
Drop TABLE video;
Drop TABLE subscribe;
Drop TABLE channel;
Drop TABLE member;



SELECT * FROM comment;
SELECT * FROM video_like;
SELECT * FROM video;
SELECT * FROM subscribe;
SELECT * FROM channel;
SELECT * FROM member;




-- 회원
CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(60),
    email VARCHAR(50),
    phone VARCHAR(13)
);

-- 채널
CREATE TABLE channel(
	channel_code INT PRIMARY KEY AUTO_INCREMENT,
    channel_img VARCHAR(100),
    channel_name VARCHAR(50),
    id VARCHAR(20),
    FOREIGN KEY (id) REFERENCES member(id)
);

-- 동영상
CREATE TABLE video(
	video_code INT PRIMARY KEY AUTO_INCREMENT,
    video_url VARCHAR(100),
    video_img VARCHAR(100),
    video_title VARCHAR(80),
    video_count INT DEFAULT 0,
    video_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    video_desc TEXT,
    channel_code INT,
    FOREIGN KEY (channel_code) REFERENCES channel(channel_code)
);

-- 댓글  
CREATE TABLE comment(
	comment_code INT PRIMARY KEY AUTO_INCREMENT,
    comment_text TEXT,
    comment_date DATETIME DEFAULT   CURRENT_TIMESTAMP,
    id VARCHAR(20),
    video_code INT,
    parent_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (video_code) REFERENCES video(video_code)
);

-- 구독 
CREATE TABLE subscribe(
	sub_code INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20),
    channel_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (channel_code) REFERENCES channel(channel_code)
);

-- 좋아요
CREATE TABLE video_like(
	like_code INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20),
    video_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (video_code) REFERENCES video(video_code)
);

INSERT INTO member VALUES('akmu','akmu','akmu','akmu');


INSERT INTO channel(channel_img, channel_name, id)
VALUES('http://192.168.10.51:8082/channel/akmu.jpg','AKMU', 'akmu');

INSERT INTO channel(channel_img, channel_name, id)
VALUES('http://192.168.10.51:8082/channel/dingo.jpg','딩고 뮤직', 'akmu');

SELECT * FROM channel;


INSERT INTO video(video_url, video_img, video_title, video_desc, channel_code)
VALUES('http://192.168.10.51:8082/video/AKMU1.mp4',
		'http://192.168.10.51:8082/thumbnail/akmu.webp ',
		'AKMU - 후라이의 꿈 LIVE CLIP (FESTIVAL ver.) ',
        'More about AKMU ','2');

INSERT INTO video(video_url, video_img, video_title, video_desc, channel_code)
VALUES('http://192.168.10.51:8082/video/day6.mp4',
		'http://192.168.10.51:8082/thumbnail/day6.webp ',
		'DAY6의 킬링보이스를 라이브로! ',
        '데이식스의 쇼에 오신걸 환영합니다 ','3
bank');
        
        
SELECT * FROM video;
        
        
SELECT * FROM video JOIN channel USING(channel_code);

SELECT * FROM video WHERE video_code = 2;

