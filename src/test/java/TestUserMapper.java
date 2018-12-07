import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.guweibit.pay.entity.Commodity;
import com.guweibit.pay.mapper.CommodityMapper;
public class TestUserMapper {
	
	private AbstractApplicationContext ac;
	private CommodityMapper commodityMapper;
	
	@Before
	public void doBefore() {
		ac = new ClassPathXmlApplicationContext(
			"spring-dao.xml");
		commodityMapper = ac.getBean(
			"commodityMapper", CommodityMapper.class);
	}
	
	@After
	public void doAfter() {
		ac.close();
	}
	

	@Test
	public void getCommodityByName() {
		String name = "旺仔牛奶";
		Commodity commodity = commodityMapper.getCommodityByName(name);
		System.out.println("commodity=" + commodity);
		
	}
	
	
}
