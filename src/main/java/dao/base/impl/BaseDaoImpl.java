package dao.base.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import dao.base.BaseDao;

/**
 * 
 * @author zuan
 *
 * @param <T>
 */

public abstract class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

}
