USE `wallethub`;
DROP function IF EXISTS `camel_case`;
not
DELIMITER $$
USE `wallethub`$$
CREATE FUNCTION `camel_case` (str varchar(255))
RETURNS VARCHAR(255)
BEGIN

	DECLARE i INT;
	DECLARE length INT;	
    DECLARE c CHAR(1);

	SET i = 0;
    SET str	= LOWER(str);    
	SET length	= CHAR_LENGTH(str);	

	WHILE (i < length) DO
    
		SET c = MID(str, i, 1);        
        IF (c = ' ' OR i = 0) THEN
				
			SET str = CONCAT( LEFT(str, i), UPPER( MID(str, i+1, 1) ), RIGHT(str, length - i - 1));
            
		END IF;
        
		SET i = i + 1;
        
	END WHILE;

	RETURN str;
END$$

DELIMITER ;
