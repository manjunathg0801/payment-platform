CREATE TABLE payments
(
    id BIGSERIAL PRIMARY KEY,

    payment_id VARCHAR(100) NOT NULL UNIQUE,

    transaction_reference VARCHAR(100) NOT NULL UNIQUE,

    customer_id VARCHAR(100) NOT NULL,

    payment_amount NUMERIC(19,2) NOT NULL,

    currency VARCHAR(10) NOT NULL,

    from_account VARCHAR(50) NOT NULL,

    to_account VARCHAR(50) NOT NULL,

    from_bank VARCHAR(100) NOT NULL,

    to_bank VARCHAR(100) NOT NULL,

    payment_method VARCHAR(30),

    transaction_type VARCHAR(30),

    payment_status VARCHAR(30) NOT NULL,

    payment_date TIMESTAMP,

    response_code VARCHAR(20),

    response_message VARCHAR(255),

    channel VARCHAR(30),

    idempotency_key VARCHAR(100),

    retry_count INTEGER DEFAULT 0,

    created_date TIMESTAMP,

    created_by VARCHAR(100),

    updated_date TIMESTAMP,

    updated_by VARCHAR(100)
);