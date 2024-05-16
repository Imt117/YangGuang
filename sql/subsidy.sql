CREATE TABLE subsidy_project (
                                 project_id       BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '项目ID',
                                 project_name     VARCHAR(100) NOT NULL                COMMENT '项目名称',
                                 description      TEXT                                COMMENT '项目描述',
                                 PRIMARY KEY (project_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='补贴项目表';

CREATE TABLE subsidy_project_process (
                                         process_id       BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '流程ID',
                                         project_id       BIGINT(20)   NOT NULL                COMMENT '项目ID',
                                         step_name        VARCHAR(100) NOT NULL                COMMENT '流程步骤名称',
                                         step_order       INT          NOT NULL                COMMENT '流程步骤顺序',
                                         PRIMARY KEY (process_id),
                                         FOREIGN KEY (project_id) REFERENCES subsidy_project(project_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='补贴项目流程表';

CREATE TABLE subsidy_application (
                                     application_id     BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '申请ID',
                                     applicant_user_id  BIGINT(20)    NOT NULL                COMMENT '申请人员ID',
                                     project_id         BIGINT(20)    NOT NULL                COMMENT '项目ID',
                                     application_status VARCHAR(20)   NOT NULL                COMMENT '申请状态',
                                     applicant_name     VARCHAR(64)   NOT NULL                COMMENT '申请人姓名',
                                     applicant_id_no    VARCHAR(18)   NOT NULL                COMMENT '身份证号码',
                                     applicant_gender   CHAR(1)       NOT NULL                COMMENT '性别（0男 1女 2未知）',
                                     applicant_type     VARCHAR(50)   NOT NULL                COMMENT '人员类别',
                                     uploaded_files     VARCHAR(1000)                         COMMENT '上传材料',
                                     application_date   DATETIME      NOT NULL                COMMENT '申请日期',
                                     PRIMARY KEY (application_id),
                                     FOREIGN KEY (applicant_user_id) REFERENCES sys_user(user_id),
                                     FOREIGN KEY (project_id) REFERENCES subsidy_project(project_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='补贴申请表';

CREATE TABLE subsidy_application_status (
                                            status_id          BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '状态ID',
                                            application_id     BIGINT(20)    NOT NULL                COMMENT '申请ID',
                                            process_id         BIGINT(20)    NOT NULL                COMMENT '流程ID',
                                            status             VARCHAR(20)   NOT NULL                COMMENT '状态',
                                            start_time         DATETIME      NOT NULL                COMMENT '开始时间',
                                            end_time           DATETIME                              COMMENT '结束时间',
                                            PRIMARY KEY (status_id),
                                            FOREIGN KEY (application_id) REFERENCES subsidy_application(application_id),
                                            FOREIGN KEY (process_id) REFERENCES subsidy_project_process(process_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='补贴申请状态表';

CREATE TABLE subsidy_approval (
                                  approval_id        BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '审批ID',
                                  application_id     BIGINT(20)    NOT NULL                COMMENT '申请ID',
                                  approver_user_id   BIGINT(20)    NOT NULL                COMMENT '审批人员ID',
                                  approval_status    VARCHAR(20)   NOT NULL                COMMENT '审批状态（待审批、通过、拒绝）',
                                  approval_comments  TEXT                                  COMMENT '审批意见',
                                  approval_date      DATETIME      NOT NULL                COMMENT '审批时间',
                                  PRIMARY KEY (approval_id),
                                  FOREIGN KEY (application_id) REFERENCES subsidy_application(application_id),
                                  FOREIGN KEY (approver_user_id) REFERENCES sys_user(user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='补贴审批表';

CREATE TABLE subsidy_publicity (
                                   publicity_id       BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '公示ID',
                                   project_id         BIGINT(20)    NOT NULL                COMMENT '项目ID',
                                   start_time         DATETIME      NOT NULL                COMMENT '公示开始时间',
                                   end_time           DATETIME                              COMMENT '公示结束时间',
                                   uploaded_files     VARCHAR(1000)                         COMMENT '公示期间上传文件',
                                   PRIMARY KEY (publicity_id),
                                   FOREIGN KEY (project_id) REFERENCES subsidy_project(project_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='补贴公示期表';

