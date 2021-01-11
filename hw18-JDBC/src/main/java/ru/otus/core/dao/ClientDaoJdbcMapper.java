package ru.otus.core.dao;

import ru.otus.core.model.Client;
import ru.otus.core.sessionmanager.SessionManager;
import ru.otus.jdbc.DbExecutorImpl;
import ru.otus.jdbc.mapper.JdbcMapperImpl;
import ru.otus.jdbc.sessionmanager.SessionManagerJdbc;
import java.sql.SQLException;
import java.util.Optional;

public class ClientDaoJdbcMapper implements ClientDao{
    SessionManagerJdbc sessionManager;
    DbExecutorImpl<Client> dbExecutor;
    JdbcMapperImpl<Client> jdbcMapperClient;

    public ClientDaoJdbcMapper(SessionManagerJdbc sessionManager, DbExecutorImpl<Client> dbExecutor, JdbcMapperImpl<Client> jdbcMapperClient) {
        this.sessionManager = sessionManager;
        this.dbExecutor = dbExecutor;
        this.jdbcMapperClient = jdbcMapperClient;
    }

    @Override
    public Optional<Client> findById(long id) {
        jdbcMapperClient.findById(id, Client.class);
        System.out.println(jdbcMapperClient.getSQL());
        return Optional.empty();
    }

    @Override
    public long insert(Client client) {
        jdbcMapperClient.insert(client);
        System.out.println(jdbcMapperClient.getSQL());
        try {
            return  dbExecutor.executeInsert(sessionManager.getCurrentSession().getConnection(), jdbcMapperClient.getSQL(), jdbcMapperClient.getParam());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public SessionManager getSessionManager() {
        return sessionManager;
    }
}
