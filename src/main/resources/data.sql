DROP TABLE IF EXISTS geolocation;


CREATE TABLE geolocation (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      ip_from BIGINT NOT NULL,
      ip_to BIGINT NOT NULL,
      country_code VARCHAR(3) NOT NULL,
      country VARCHAR(50) NOT NULL,
      region VARCHAR(50) NOT NULL,
      city VARCHAR(50),
      latitude numeric(10,4),
      longitude numeric(10,4),
      time_zone timestamp
);

ALTER TABLE geolocation
    ADD CONSTRAINT geolocation_unique UNIQUE(ip_from, ip_to, country_code, country, region, city, latitude, longitude);
