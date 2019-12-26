package exception;

import java.sql.SQLException;

public class DBException extends Exception {
    public DBException(String message) {
        super(new SQLException(message));
    }
}
