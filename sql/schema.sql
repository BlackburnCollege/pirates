/**
 * Author:  lucas.burdell
 * Created: Mar 21, 2017
 */

DROP TABLE TEST;

CREATE TABLE TEST
    (
        TNAME VARCHAR(64) NOT NULL,
        TTEXT VARCHAR(200),
        TVALUE INTEGER NOT NULL
    );


ALTER TABLE TEST
    ADD CONSTRAINT TEST_PK Primary Key (
            TNAME,
            TVALUE
        );

