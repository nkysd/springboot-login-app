USE login_app;

CREATE TABLE todos (
    id BIGINT AUTO_INCREMENT,
    user_id BIGINT NOT NULL,

    title VARCHAR(255) NOT NULL,
    status ENUM('ACTIVE','DONE') NOT NULL DEFAULT 'ACTIVE',

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    done_at DATETIME NULL,

    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    INDEX idx_todos_user_created (user_id, created_at),
    INDEX idx_todos_user_status (user_id, status),

    CONSTRAINT fk_todos_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;
