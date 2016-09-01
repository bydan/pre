package com.bydan.framework.erp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConstantesCommon {
	public static EntityManagerFactory JPAENTITYMANAGERFACTORY= Persistence.createEntityManagerFactory(ConstantesCommon.SJPAPERSISTENCEUNITNAME);
	public  static String SJPAPERSISTENCEUNITNAME="PersistenceUnitSeguridad";//"PersistenceUnitAuditoria";//"PersistenceUnitSeguridad";
}
