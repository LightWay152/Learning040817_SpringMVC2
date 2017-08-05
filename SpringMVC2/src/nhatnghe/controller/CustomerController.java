package nhatnghe.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eshop.entity.Customer;
import eshop.entity.EShopV10;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@RequestMapping("index")
	public String index(ModelMap model){
		model.addAttribute("list", getCustomerList());
		return "customer";
	}
	
	private List<Customer> getCustomerList() {
		String hql = "FROM Customer";
		Session session = EShopV10.openSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	@RequestMapping("insert")
	public String insert(ModelMap model, Customer user) {
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
			model.addAttribute("mess", "Insert successfully");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("mess", "Insert failed");
		}
		model.addAttribute("list", getCustomerList());
		return "customer";
	}

	@RequestMapping("edit/{id}")
	public String edit(ModelMap model, @PathVariable("id") String id) {
		Session session = EShopV10.openSession();
		Customer user = (Customer) session.get(Customer.class, id);
		model.addAttribute("user", user);
		model.addAttribute("list", getCustomerList());
		return "customer";
	}

	@RequestMapping("delete")
	public String delete(ModelMap model, Customer user) {
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(user);
			t.commit();
			model.addAttribute("mess", "Delete success");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("mess", "Delete failer");
		}

		model.addAttribute("list", getCustomerList());
		return "customer";
	}

	@RequestMapping("update")
	public String update(ModelMap model, Customer user) {
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);
			t.commit();
			model.addAttribute("mess", "Update success");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("mess", "Update failer");
		}

		model.addAttribute("list", getCustomerList());
		return "customer";
	}

	
}
