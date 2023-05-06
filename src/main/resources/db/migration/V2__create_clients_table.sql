CREATE TABLE IF NOT EXISTS clients
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(20)  NOT NULL
);

INSERT INTO clients VALUES
                        (1, 'Vassily Petrov', 'vpetrov@jr.com', '+7 (191) 322-22-33)'),
                        (2, 'Pjotr Vasechkin', 'pvasechkin@jr.com', '+7 (191) 223-33-22)');