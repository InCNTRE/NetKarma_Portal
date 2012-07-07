-- ------------------------------------------------------------------
-- AlterDB script to create a stored procedure to add synchronization 
-- based on the object being added to the Karma DB. This adds 
-- support for multi-service, single-DB model to Karma. 
--
-- Revision:
--          Apr. 07, 2011
--
-- Deployment syntax: mysql -u <username> -p <database> < karma_alter_db_stored_procs001.sql
--
-- Parameters:
--
-- 	lockOp		: Lock Operation, 1 = acquire, 0 = release 
-- 	lockTimeOut	: Lock Time-out
-- 	p_entity_id	: Unique identifier of the object, to create the lock
-- 	status		: Output status of the lock operation
--
-- Authors:
--			Beth Plale (plale@cs.indiana.edu)  
--			Scott Jensen (scjensen@indiana.edu)  
--			Devarshi Ghoshal (dghoshal@indiana.edu)
-- ------------------------------------------------------------------
DROP PROCEDURE IF EXISTS PR_OBJECT_LOCK;

DELIMITER |

CREATE PROCEDURE PR_OBJECT_LOCK
(IN lockOp INTEGER, IN lockTimeOut INTEGER, 
IN p_object_id VARCHAR(375), OUT status INTEGER)
object_lock: BEGIN
DECLARE lockPrefix VARCHAR(6) DEFAULT "karma.";
DECLARE lockName VARCHAR(255) DEFAULT "";
SET status = 0;
SET lockName = CONCAT(lockPrefix,RIGHT(p_object_id,100)); 
IF lockOp = 1 THEN -- acquire lock
IF lockTimeOut < 1 THEN
SET lockTimeOut = 1;
END IF;
SELECT GET_LOCK(lockName,lockTimeOut) INTO status;
ELSE -- release lock
SELECT RELEASE_LOCK(lockName) INTO status;
END IF;
END object_lock
|

DELIMITER ;