CREATE TABLE customer
(
    id      VARCHAR(15) PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(500) NOT NULL
);

CREATE TABLE contact
(
    contact     VARCHAR(15) PRIMARY KEY,
    customer_id VARCHAR(15) NOT NULL,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id)
);


/*Done up to here*/


CREATE TABLE item
(
    code  VARCHAR(50) PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    stock INT          NOT NULL,
    price DECIMAL
);


CREATE TABLE "user"
(
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(200) NOT NULL,
    name     VARCHAR(200) NOT NULL
);

CREATE TABLE "order"
(
    id          VARCHAR(10) PRIMARY KEY,
    date        DATE         NOT NULL,
    customer_id VARCHAR(15)  NOT NULL,
    username    VARCHAR(100) NOT NULL,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES "user" (username)
);

CREATE TABLE order_item
(
    price     DECIMAL     NOT NULL,
    discount  INT         NOT NULL,
    order_id  VARCHAR(10) NOT NULL,
    item_code VARCHAR(50) NOT NULL,
    CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES "order"(id),
    CONSTRAINT fk_item_code FOREIGN KEY (item_code) REFERENCES item(code),
    CONSTRAINT primary_key PRIMARY KEY (order_id,item_code)
)
