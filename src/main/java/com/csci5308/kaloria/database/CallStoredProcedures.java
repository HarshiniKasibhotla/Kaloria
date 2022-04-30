package com.csci5308.kaloria.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.*;

public class CallStoredProcedures {

    private String storedProcedureName;
    private Connection connection;
    private CallableStatement statement;

    public CallStoredProcedures(String storedProcedureName) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement();
    }

    private void createStatement() throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "}");
    }

    private void openConnection() throws SQLException {
        connection = ConnectionManager.getDBConnection();
    }

    public void cleanup() {
        try {
            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setParameter(int paramIndex, String value) throws SQLException {
        statement.setString(paramIndex, value);
    }

    public void setParameter(int paramIndex, Timestamp value) throws SQLException {
        statement.setTimestamp(paramIndex, value);
    }

    public void setParameter(int paramIndex, Boolean value) throws SQLException {
        statement.setBoolean(paramIndex, value);
    }

    public void registerOutputParameterString(int paramIndex) throws SQLException {
        statement.registerOutParameter(paramIndex, java.sql.Types.VARCHAR);
    }

    public void setParameter(int paramIndex, long value) throws SQLException {
        statement.setLong(paramIndex, value);
    }

    public void setInt(int paramIndex, int value) {
        try {
            statement.setInt(paramIndex, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBlob(int paramIndex, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            statement.setBlob(paramIndex, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDate(int paramIndex, Date value) throws SQLException {
        statement.setDate(paramIndex, value);
    }

    public void setTimestamp(int paramIndex, Timestamp value) throws SQLException {
        statement.setTimestamp(paramIndex, value);
    }

    public void registerOutputParameterLong(int paramIndex) throws SQLException {
        statement.registerOutParameter(paramIndex, java.sql.Types.BIGINT);
    }

    public ResultSet executeWithResults() throws SQLException {
        if (statement.execute()) {
            return statement.getResultSet();
        }
        return null;
    }

    public boolean execute() throws SQLException {
        return statement.execute();
    }

}
