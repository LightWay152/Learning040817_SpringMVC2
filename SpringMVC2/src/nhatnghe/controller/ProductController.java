package nhatnghe.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import eshop.entity.EShopV10;
import eshop.entity.Product;

@Controller
@RequestMapping("product")
public class ProductController {
	@RequestMapping("list")
	public String index(ModelMap model){
		String hql = "FROM Product";
		
		Session session = EShopV10.openSession();
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		
		model.addAttribute("list", list);
		return "product/list";
	}
}
