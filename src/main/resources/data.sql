DROP TABLE IF EXISTS geolocation;


CREATE TABLE geolocation (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      ip_from BIGINT NOT NULL,
      ip_to BIGINT NOT NULL,
      country_code VARCHAR(3) unique NOT NULL,
      country VARCHAR(50) NOT NULL,
      region VARCHAR(50) NOT NULL,
      city VARCHAR(50),
      latitude numeric(10,4),
      longitude numeric(10,4),
      time_zone timestamp
);
