CREATE TABLE events (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description VARCHAR(1000),
                        location VARCHAR(255) NOT NULL,
                        capacity INT NOT NULL,
                        available_slots INT NOT NULL,
                        event_date DATETIME NOT NULL,
                        status VARCHAR(50),
                        version BIGINT,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        CONSTRAINT uk_event_title_location_date UNIQUE (title, location, event_date)
);
