USE login_app;

CREATE TABLE logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    user_id BIGINT NOT NULL,
    related_todo_id BIGINT NULL,

    type ENUM('DONE','NOTE') NOT NULL DEFAULT 'DONE',

    message VARCHAR(500) NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    INDEX idx_logs_user_created (user_id, created_at),

    CONSTRAINT fk_logs_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_logs_todo
        FOREIGN KEY (related_todo_id)
        REFERENCES todos(id)
        ON DELETE SET NULL
) ENGINE=InnoDB;