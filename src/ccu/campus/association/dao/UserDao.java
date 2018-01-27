package ccu.campus.association.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ccu.campus.association.pojo.User;
@Repository
public class UserDao {
	// @Autowired�����Զ���ȡspring�����Ķ���
		@Autowired
		private HibernateTemplate hibernateTemplate; // �����������һ��Ҫ�������е�������һ��

		// ����hibernateTemplate����
		public HibernateTemplate getHibernateTemplate() {
			return this.hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

		public void addUser(User User) {
			User.setCreateTime(new Date());
			HibernateTemplate template = this.getHibernateTemplate();
			template.save(User);
		}

		public void updateUser(User User) {
			this.getHibernateTemplate().update(User);
		}

		public User queryUser(String id) {
			String hql = "from User where id = ?";
			List<User> vList = this.getHibernateTemplate().find(hql, id);
			if (vList != null && vList.size() > 0) {
				return vList.get(0);
			}
			return null;
		}
		public List<User> queryUserList(String keyword) {
			String hql = "from User where keyword = ?";
			List<User> vList = this.getHibernateTemplate().find(hql, keyword);
			if (vList != null && vList.size() > 0) {
				return vList;
			}
			return null;
		}
		public void deleteUserById(User User) {
			//User User = queryUser(id);
		
			this.getHibernateTemplate().delete(User);
		}
}
