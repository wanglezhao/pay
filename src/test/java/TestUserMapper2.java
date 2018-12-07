
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.guweibit.pay.entity.AlipayOrderInformation;
import com.guweibit.pay.mapper.AlipayMapper;


public class TestUserMapper2 {
	
	private AbstractApplicationContext ac;
	private AlipayMapper ia;
	
	@Before
	public void doBefore() {
		ac = new ClassPathXmlApplicationContext(
			"spring-dao.xml");
		ia = ac.getBean(
			"alipayMapper", AlipayMapper.class);
	}
	
	@After
	public void doAfter() {
		ac.close();
	}
	

	@Test
	public void insert1() {
		AlipayOrderInformation ali=new AlipayOrderInformation( 1235659524595.2, "这是第一个", "50.00", "嗯，第一个");
		Integer i= ia.insert(ali);
		System.out.println("i=" + i);
		
	}
	
	@Test
	public void updata() {
		Integer i= ia.updata("1185.00", 1);
		System.out.println("i=" + i);
		
	}
}
