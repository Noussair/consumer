SET DEFINE OFF;
SET SERVEROUTPUT ON SIZE UNLIMITED;

BEGIN
  -- your DELETE/INSERT statements …

  COMMIT; -- only if everything succeeded
  DBMS_OUTPUT.PUT_LINE('Script exécuté avec succès');

EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('ÉCHEC: ' || SQLERRM);
    DBMS_OUTPUT.PUT_LINE(DBMS_UTILITY.FORMAT_ERROR_BACKTRACE); -- shows line number
    RAISE; -- rethrow so the client sees the ORA- error
END;
/
