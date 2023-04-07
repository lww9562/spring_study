package exam03.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppCtx {
	@Bean
	public DataSource dataSource(){
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		DataSource ds = new DataSource();

		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl(url);
		ds.setUsername("scott");					//계정 설정
		ds.setPassword("tiger");

		ds.setInitialSize(2);						//초기 커넥션 개수
		ds.setMaxActive(10);					//커넥션풀에서 가져올 수 있는 최대 커넥션 개수
		ds.setTestWhileIdle(true);					//서버가 유휴상태일 때 체크
		ds.setTimeBetweenEvictionRunsMillis(3000);	//체크 주기
		ds.setMinEvictableIdleTimeMillis(60000);	//60초 이후 연결 객체 재생성

		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());

		return jdbcTemplate;
	}

	@Bean
	public TestDao testDao(){
		return new TestDao();
	}
}