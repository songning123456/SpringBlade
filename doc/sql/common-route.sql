CREATE TABLE IF NOT EXISTS common_route
(
    id    INT UNSIGNED AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL default '' COMMENT '标题',
    text  longtext     NOT NULL COMMENT '简介',
    img   VARCHAR(50)  NOT NULL default '' COMMENT '图片路径',
    path  VARCHAR(100) NOT NULL default '' COMMENT '跳转路由',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into common_route(title, text, img, path)
VALUES ('名称1', '此处为内容简介，文案可根据功能自定义描述添加修改，点击进入查看实际信息。', '/img/wel/wel-one.png', ''),
       ('名称2', '此处为内容简介，文案可根据功能自定义描述添加修改，点击进入查看实际信息。', '/img/wel/wel-two.png', ''),
       ('名称3', '此处为内容简介，文案可根据功能自定义描述添加修改，点击进入查看实际信息。', '/img/wel/wel-three.png', ''),
       ('名称4', '此处为内容简介，文案可根据功能自定义描述添加修改，点击进入查看实际信息。', '/img/wel/wel-four.png', ''),
       ('名称5', '此处为内容简介，文案可根据功能自定义描述添加修改，点击进入查看实际信息。', '/img/wel/wel-five.png', ''),
       ('名称6', '此处为内容简介，文案可根据功能自定义描述添加修改，点击进入查看实际信息。', '/img/wel/wel-six.png', '')
