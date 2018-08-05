package ua.kvelinskyi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"ua.kvelinskyi.service.impl", "ua.kvelinskyi.repository"})
@EntityScan(basePackages = {"ua.kvelinskyi.entity"})
@EnableTransactionManagement
public class RepositoryConfiguration {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsService() {
        // UserDetailsServiceRetrieves implementation which retrieves the
        // user details (username, password, enabled flag, and authorities) from a database using JDBC queries.
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
        jdbcDao.setUsersByUsernameQuery("select login as username, password, enabled from users where login=?");
        jdbcDao.setAuthoritiesByUsernameQuery("select b.login as username, a.authority from role a join users b on a.username=b.role where b.login=?"
                );
        return jdbcDao;
    }

}
