package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DbConfig2 {
	@Configuration
	@Profile("dev")
	static class DbDevConfig {
		@Bean(destroyMethod = "close")
		public DataSource dataSource(){
			System.out.println("DEV!!!!");
			DataSource ds = new DataSource();

			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			ds.setUsername("springdb");
			ds.setPassword("aA123456");

			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setTimeBetweenEvictionRunsMillis(3000);
			ds.setMinEvictableIdleTimeMillis(60000);

			return ds;
		}

		@Bean
		public JdbcTemplate jdbcTemplate(){
			return new JdbcTemplate(dataSource());
		}

		@Bean
		public PlatformTransactionManager transactionManager(){
			DataSourceTransactionManager tm = new DataSourceTransactionManager();
			tm.setDataSource(dataSource());

			return tm;
		}
	}

	@Configuration
	@Profile("real")
	static class DbRealConfig {
		@Bean(destroyMethod = "close")
		public DataSource dataSource(){
			System.out.println("REAL!!!!");
			DataSource ds = new DataSource();

			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			ds.setUsername("springdb");
			ds.setPassword("aA123456");

			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setTimeBetweenEvictionRunsMillis(3000);
			ds.setMinEvictableIdleTimeMillis(60000);

			return ds;
		}

		@Bean
		public JdbcTemplate jdbcTemplate(){
			return new JdbcTemplate(dataSource());
		}

		@Bean
		public PlatformTransactionManager transactionManager(){
			DataSourceTransactionManager tm = new DataSourceTransactionManager();
			tm.setDataSource(dataSource());

			return tm;
		}
	}
}
