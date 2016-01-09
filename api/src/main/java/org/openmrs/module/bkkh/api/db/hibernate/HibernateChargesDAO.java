package org.openmrs.module.bkkh.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.module.bkkh.Charges;
import org.openmrs.module.bkkh.api.db.ChargesDAO;

import java.util.List;

/**
 * Created by USER on 01/12/2015.
 */
public class HibernateChargesDAO implements ChargesDAO {

    protected final Log log = LogFactory.getLog(this.getClass());

    private SessionFactory sessionFactory;

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCharges(Charges charges) {
        sessionFactory.getCurrentSession().saveOrUpdate(charges);
    }

    @SuppressWarnings("unchecked")
    public List<Charges> getChargesByPatient(Patient patient) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Charges.class, "costs");
        if (patient != null) {
            criteria.add(Restrictions.eq("costs.patient", patient));
        }
        return (List<Charges>)criteria.list();
    }

    @SuppressWarnings("unchecked")
    public Charges getLastCharges(Patient patient) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Charges.class);
        criteria.addOrder(Order.desc("date"));
        criteria.setMaxResults(1);
        List<Charges> chargesList = criteria.list();
        return chargesList.size() > 0 ? chargesList.get(0) : null;
    }

	@Override
	public Charges getCharges(long chargesId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Charges.class);
		criteria.add(Restrictions.eq("id", chargesId));
		return (Charges) criteria.list().get(0);
	}
}
