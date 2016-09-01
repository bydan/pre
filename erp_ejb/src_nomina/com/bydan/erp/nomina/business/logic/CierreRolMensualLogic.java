/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.CierreRolMensualConstantesFunciones;
import com.bydan.erp.nomina.util.CierreRolMensualParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CierreRolMensualParameterGeneral;
import com.bydan.erp.nomina.business.entity.CierreRolMensual;
import com.bydan.erp.nomina.business.logic.CierreRolMensualLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CierreRolMensualLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CierreRolMensualLogic.class);
	
	protected CierreRolMensualDataAccess cierrerolmensualDataAccess; 	
	protected CierreRolMensual cierrerolmensual;
	protected List<CierreRolMensual> cierrerolmensuals;
	protected Object cierrerolmensualObject;	
	protected List<Object> cierrerolmensualsObject;
	
	public static ClassValidator<CierreRolMensual> cierrerolmensualValidator = new ClassValidator<CierreRolMensual>(CierreRolMensual.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CierreRolMensualLogicAdditional cierrerolmensualLogicAdditional=null;
	
	public CierreRolMensualLogicAdditional getCierreRolMensualLogicAdditional() {
		return this.cierrerolmensualLogicAdditional;
	}
	
	public void setCierreRolMensualLogicAdditional(CierreRolMensualLogicAdditional cierrerolmensualLogicAdditional) {
		try {
			this.cierrerolmensualLogicAdditional=cierrerolmensualLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  CierreRolMensualLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cierrerolmensualDataAccess = new CierreRolMensualDataAccess();
			
			this.cierrerolmensuals= new ArrayList<CierreRolMensual>();
			this.cierrerolmensual= new CierreRolMensual();
			
			this.cierrerolmensualObject=new Object();
			this.cierrerolmensualsObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.cierrerolmensualDataAccess.setConnexionType(this.connexionType);
			this.cierrerolmensualDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CierreRolMensualLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cierrerolmensualDataAccess = new CierreRolMensualDataAccess();
			this.cierrerolmensuals= new ArrayList<CierreRolMensual>();
			this.cierrerolmensual= new CierreRolMensual();
			this.cierrerolmensualObject=new Object();
			this.cierrerolmensualsObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.cierrerolmensualDataAccess.setConnexionType(this.connexionType);
			this.cierrerolmensualDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CierreRolMensual getCierreRolMensual() throws Exception {	
		CierreRolMensualLogicAdditional.checkCierreRolMensualToGet(cierrerolmensual,this.datosCliente,this.arrDatoGeneral);
		CierreRolMensualLogicAdditional.updateCierreRolMensualToGet(cierrerolmensual,this.arrDatoGeneral);
		
		return cierrerolmensual;
	}
		
	public void setCierreRolMensual(CierreRolMensual newCierreRolMensual) {
		this.cierrerolmensual = newCierreRolMensual;
	}
	
	public CierreRolMensualDataAccess getCierreRolMensualDataAccess() {
		return cierrerolmensualDataAccess;
	}
	
	public void setCierreRolMensualDataAccess(CierreRolMensualDataAccess newcierrerolmensualDataAccess) {
		this.cierrerolmensualDataAccess = newcierrerolmensualDataAccess;
	}
	
	public List<CierreRolMensual> getCierreRolMensuals() throws Exception {		
		this.quitarCierreRolMensualsNulos();
		
		CierreRolMensualLogicAdditional.checkCierreRolMensualToGets(cierrerolmensuals,this.datosCliente,this.arrDatoGeneral);
		
		for (CierreRolMensual cierrerolmensualLocal: cierrerolmensuals ) {
			CierreRolMensualLogicAdditional.updateCierreRolMensualToGet(cierrerolmensualLocal,this.arrDatoGeneral);
		}
		
		return cierrerolmensuals;
	}
	
	public void setCierreRolMensuals(List<CierreRolMensual> newCierreRolMensuals) {
		this.cierrerolmensuals = newCierreRolMensuals;
	}
	
	public Object getCierreRolMensualObject() {	
		this.cierrerolmensualObject=this.cierrerolmensualDataAccess.getEntityObject();
		return this.cierrerolmensualObject;
	}
		
	public void setCierreRolMensualObject(Object newCierreRolMensualObject) {
		this.cierrerolmensualObject = newCierreRolMensualObject;
	}
	
	public List<Object> getCierreRolMensualsObject() {		
		this.cierrerolmensualsObject=this.cierrerolmensualDataAccess.getEntitiesObject();
		return this.cierrerolmensualsObject;
	}
		
	public void setCierreRolMensualsObject(List<Object> newCierreRolMensualsObject) {
		this.cierrerolmensualsObject = newCierreRolMensualsObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.cierrerolmensualDataAccess!=null) {
			this.cierrerolmensualDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cierrerolmensualDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			cierrerolmensualDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cierrerolmensual=cierrerolmensualDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cierrerolmensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  		  
        try {
			
			cierrerolmensual=cierrerolmensualDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cierrerolmensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cierrerolmensual=cierrerolmensualDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cierrerolmensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  		  
        try {
			
			cierrerolmensual=cierrerolmensualDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cierrerolmensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cierrerolmensualDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cierrerolmensualDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cierrerolmensualDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cierrerolmensualDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cierrerolmensualDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cierrerolmensual = new  CierreRolMensual();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cierrerolmensualDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cierrerolmensual = new  CierreRolMensual();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensual=cierrerolmensualDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensual);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cierrerolmensual = new  CierreRolMensual();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensual=cierrerolmensualDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensual);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		  		  
        try {
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCierreRolMensualsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getTodosCierreRolMensualsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosCierreRolMensuals(String sFinalQuery,Pagination pagination)throws Exception {
		cierrerolmensuals = new  ArrayList<CierreRolMensual>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCierreRolMensual(cierrerolmensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCierreRolMensual(CierreRolMensual cierrerolmensual) throws Exception {
		Boolean estaValidado=false;
		
		if(cierrerolmensual.getIsNew() || cierrerolmensual.getIsChanged()) { 
			this.invalidValues = cierrerolmensualValidator.getInvalidValues(cierrerolmensual);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cierrerolmensual);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCierreRolMensual(List<CierreRolMensual> CierreRolMensuals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CierreRolMensual cierrerolmensualLocal:cierrerolmensuals) {				
			estaValidadoObjeto=this.validarGuardarCierreRolMensual(cierrerolmensualLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCierreRolMensual(List<CierreRolMensual> CierreRolMensuals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCierreRolMensual(cierrerolmensuals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCierreRolMensual(CierreRolMensual CierreRolMensual) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCierreRolMensual(cierrerolmensual)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CierreRolMensual cierrerolmensual) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cierrerolmensual.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CierreRolMensualConstantesFunciones.getCierreRolMensualLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cierrerolmensual","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CierreRolMensualConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CierreRolMensualConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCierreRolMensualWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-saveCierreRolMensualWithConnection");connexion.begin();			
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSave(this.cierrerolmensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CierreRolMensualLogicAdditional.updateCierreRolMensualToSave(this.cierrerolmensual,this.arrDatoGeneral);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cierrerolmensual,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCierreRolMensual();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCierreRolMensual(this.cierrerolmensual)) {
				CierreRolMensualDataAccess.save(this.cierrerolmensual, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cierrerolmensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSaveAfter(this.cierrerolmensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCierreRolMensual();
			
			connexion.commit();			
			
			if(this.cierrerolmensual.getIsDeleted()) {
				this.cierrerolmensual=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCierreRolMensual()throws Exception {	
		try {	
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSave(this.cierrerolmensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CierreRolMensualLogicAdditional.updateCierreRolMensualToSave(this.cierrerolmensual,this.arrDatoGeneral);
			
			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cierrerolmensual,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCierreRolMensual(this.cierrerolmensual)) {			
				CierreRolMensualDataAccess.save(this.cierrerolmensual, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cierrerolmensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSaveAfter(this.cierrerolmensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cierrerolmensual.getIsDeleted()) {
				this.cierrerolmensual=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCierreRolMensualsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-saveCierreRolMensualsWithConnection");connexion.begin();			
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSaves(cierrerolmensuals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCierreRolMensuals();
			
			Boolean validadoTodosCierreRolMensual=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CierreRolMensual cierrerolmensualLocal:cierrerolmensuals) {		
				if(cierrerolmensualLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CierreRolMensualLogicAdditional.updateCierreRolMensualToSave(cierrerolmensualLocal,this.arrDatoGeneral);
	        	
				CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cierrerolmensualLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCierreRolMensual(cierrerolmensualLocal)) {
					CierreRolMensualDataAccess.save(cierrerolmensualLocal, connexion);				
				} else {
					validadoTodosCierreRolMensual=false;
				}
			}
			
			if(!validadoTodosCierreRolMensual) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSavesAfter(cierrerolmensuals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCierreRolMensuals();
			
			connexion.commit();		
			
			this.quitarCierreRolMensualsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCierreRolMensuals()throws Exception {				
		 try {	
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSaves(cierrerolmensuals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCierreRolMensual=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CierreRolMensual cierrerolmensualLocal:cierrerolmensuals) {				
				if(cierrerolmensualLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CierreRolMensualLogicAdditional.updateCierreRolMensualToSave(cierrerolmensualLocal,this.arrDatoGeneral);
	        	
				CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cierrerolmensualLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCierreRolMensual(cierrerolmensualLocal)) {				
					CierreRolMensualDataAccess.save(cierrerolmensualLocal, connexion);				
				} else {
					validadoTodosCierreRolMensual=false;
				}
			}
			
			if(!validadoTodosCierreRolMensual) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CierreRolMensualLogicAdditional.checkCierreRolMensualToSavesAfter(cierrerolmensuals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCierreRolMensualsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CierreRolMensualParameterReturnGeneral procesarAccionCierreRolMensuals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CierreRolMensual> cierrerolmensuals,CierreRolMensualParameterReturnGeneral cierrerolmensualParameterGeneral)throws Exception {
		 try {	
			CierreRolMensualParameterReturnGeneral cierrerolmensualReturnGeneral=new CierreRolMensualParameterReturnGeneral();
	
			CierreRolMensualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cierrerolmensuals,cierrerolmensualParameterGeneral,cierrerolmensualReturnGeneral);
			
			return cierrerolmensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CierreRolMensualParameterReturnGeneral procesarAccionCierreRolMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CierreRolMensual> cierrerolmensuals,CierreRolMensualParameterReturnGeneral cierrerolmensualParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-procesarAccionCierreRolMensualsWithConnection");connexion.begin();			
			
			CierreRolMensualParameterReturnGeneral cierrerolmensualReturnGeneral=new CierreRolMensualParameterReturnGeneral();
	
			CierreRolMensualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cierrerolmensuals,cierrerolmensualParameterGeneral,cierrerolmensualReturnGeneral);
			
			this.connexion.commit();
			
			return cierrerolmensualReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CierreRolMensualParameterReturnGeneral procesarEventosCierreRolMensuals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CierreRolMensual> cierrerolmensuals,CierreRolMensual cierrerolmensual,CierreRolMensualParameterReturnGeneral cierrerolmensualParameterGeneral,Boolean isEsNuevoCierreRolMensual,ArrayList<Classe> clases)throws Exception {
		 try {	
			CierreRolMensualParameterReturnGeneral cierrerolmensualReturnGeneral=new CierreRolMensualParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cierrerolmensualReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CierreRolMensualLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cierrerolmensuals,cierrerolmensual,cierrerolmensualParameterGeneral,cierrerolmensualReturnGeneral,isEsNuevoCierreRolMensual,clases);
			
			return cierrerolmensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CierreRolMensualParameterReturnGeneral procesarEventosCierreRolMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CierreRolMensual> cierrerolmensuals,CierreRolMensual cierrerolmensual,CierreRolMensualParameterReturnGeneral cierrerolmensualParameterGeneral,Boolean isEsNuevoCierreRolMensual,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-procesarEventosCierreRolMensualsWithConnection");connexion.begin();			
			
			CierreRolMensualParameterReturnGeneral cierrerolmensualReturnGeneral=new CierreRolMensualParameterReturnGeneral();
	
			cierrerolmensualReturnGeneral.setCierreRolMensual(cierrerolmensual);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cierrerolmensualReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CierreRolMensualLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cierrerolmensuals,cierrerolmensual,cierrerolmensualParameterGeneral,cierrerolmensualReturnGeneral,isEsNuevoCierreRolMensual,clases);
			
			this.connexion.commit();
			
			return cierrerolmensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CierreRolMensualParameterReturnGeneral procesarImportacionCierreRolMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CierreRolMensualParameterReturnGeneral cierrerolmensualParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-procesarImportacionCierreRolMensualsWithConnection");connexion.begin();			
			
			CierreRolMensualParameterReturnGeneral cierrerolmensualReturnGeneral=new CierreRolMensualParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cierrerolmensuals=new ArrayList<CierreRolMensual>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cierrerolmensual=new CierreRolMensual();
				
				
				if(conColumnasBase) {this.cierrerolmensual.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cierrerolmensual.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cierrerolmensual.setporcentaje(Integer.parseInt(arrColumnas[iColumn++]));
				this.cierrerolmensual.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.cierrerolmensuals.add(this.cierrerolmensual);
			}
			
			this.saveCierreRolMensuals();
			
			this.connexion.commit();
			
			cierrerolmensualReturnGeneral.setConRetornoEstaProcesado(true);
			cierrerolmensualReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cierrerolmensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCierreRolMensualsEliminados() throws Exception {				
		
		List<CierreRolMensual> cierrerolmensualsAux= new ArrayList<CierreRolMensual>();
		
		for(CierreRolMensual cierrerolmensual:cierrerolmensuals) {
			if(!cierrerolmensual.getIsDeleted()) {
				cierrerolmensualsAux.add(cierrerolmensual);
			}
		}
		
		cierrerolmensuals=cierrerolmensualsAux;
	}
	
	public void quitarCierreRolMensualsNulos() throws Exception {				
		
		List<CierreRolMensual> cierrerolmensualsAux= new ArrayList<CierreRolMensual>();
		
		for(CierreRolMensual cierrerolmensual : this.cierrerolmensuals) {
			if(cierrerolmensual==null) {
				cierrerolmensualsAux.add(cierrerolmensual);
			}
		}
		
		//this.cierrerolmensuals=cierrerolmensualsAux;
		
		this.cierrerolmensuals.removeAll(cierrerolmensualsAux);
	}
	
	public void getSetVersionRowCierreRolMensualWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cierrerolmensual.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cierrerolmensual.getIsDeleted() || (cierrerolmensual.getIsChanged()&&!cierrerolmensual.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cierrerolmensualDataAccess.getSetVersionRowCierreRolMensual(connexion,cierrerolmensual.getId());
				
				if(!cierrerolmensual.getVersionRow().equals(timestamp)) {	
					cierrerolmensual.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cierrerolmensual.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCierreRolMensual()throws Exception {	
		
		if(cierrerolmensual.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cierrerolmensual.getIsDeleted() || (cierrerolmensual.getIsChanged()&&!cierrerolmensual.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cierrerolmensualDataAccess.getSetVersionRowCierreRolMensual(connexion,cierrerolmensual.getId());
			
			try {							
				if(!cierrerolmensual.getVersionRow().equals(timestamp)) {	
					cierrerolmensual.setVersionRow(timestamp);
				}
				
				cierrerolmensual.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCierreRolMensualsWithConnection()throws Exception {	
		if(cierrerolmensuals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CierreRolMensual cierrerolmensualAux:cierrerolmensuals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cierrerolmensualAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cierrerolmensualAux.getIsDeleted() || (cierrerolmensualAux.getIsChanged()&&!cierrerolmensualAux.getIsNew())) {
						
						timestamp=cierrerolmensualDataAccess.getSetVersionRowCierreRolMensual(connexion,cierrerolmensualAux.getId());
						
						if(!cierrerolmensual.getVersionRow().equals(timestamp)) {	
							cierrerolmensualAux.setVersionRow(timestamp);
						}
								
						cierrerolmensualAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCierreRolMensuals()throws Exception {	
		if(cierrerolmensuals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CierreRolMensual cierrerolmensualAux:cierrerolmensuals) {
					if(cierrerolmensualAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cierrerolmensualAux.getIsDeleted() || (cierrerolmensualAux.getIsChanged()&&!cierrerolmensualAux.getIsNew())) {
						
						timestamp=cierrerolmensualDataAccess.getSetVersionRowCierreRolMensual(connexion,cierrerolmensualAux.getId());
						
						if(!cierrerolmensualAux.getVersionRow().equals(timestamp)) {	
							cierrerolmensualAux.setVersionRow(timestamp);
						}
						
													
						cierrerolmensualAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CierreRolMensualParameterReturnGeneral cargarCombosLoteForeignKeyCierreRolMensualWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEstadoEmpleado,String finalQueryGlobalAsientoContable) throws Exception {
		CierreRolMensualParameterReturnGeneral  cierrerolmensualReturnGeneral =new CierreRolMensualParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-cargarCombosLoteForeignKeyCierreRolMensualWithConnection");connexion.begin();
			
			cierrerolmensualReturnGeneral =new CierreRolMensualParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cierrerolmensualReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cierrerolmensualReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			cierrerolmensualReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			cierrerolmensualReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			cierrerolmensualReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<EstadoEmpleado> estadoempleadosForeignKey=new ArrayList<EstadoEmpleado>();
			EstadoEmpleadoLogic estadoempleadoLogic=new EstadoEmpleadoLogic();
			estadoempleadoLogic.setConnexion(this.connexion);
			estadoempleadoLogic.getEstadoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoEmpleado.equals("NONE")) {
				estadoempleadoLogic.getTodosEstadoEmpleados(finalQueryGlobalEstadoEmpleado,new Pagination());
				estadoempleadosForeignKey=estadoempleadoLogic.getEstadoEmpleados();
			}

			cierrerolmensualReturnGeneral.setestadoempleadosForeignKey(estadoempleadosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			cierrerolmensualReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cierrerolmensualReturnGeneral;
	}
	
	public CierreRolMensualParameterReturnGeneral cargarCombosLoteForeignKeyCierreRolMensual(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEstadoEmpleado,String finalQueryGlobalAsientoContable) throws Exception {
		CierreRolMensualParameterReturnGeneral  cierrerolmensualReturnGeneral =new CierreRolMensualParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cierrerolmensualReturnGeneral =new CierreRolMensualParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cierrerolmensualReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cierrerolmensualReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			cierrerolmensualReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			cierrerolmensualReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			cierrerolmensualReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<EstadoEmpleado> estadoempleadosForeignKey=new ArrayList<EstadoEmpleado>();
			EstadoEmpleadoLogic estadoempleadoLogic=new EstadoEmpleadoLogic();
			estadoempleadoLogic.setConnexion(this.connexion);
			estadoempleadoLogic.getEstadoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoEmpleado.equals("NONE")) {
				estadoempleadoLogic.getTodosEstadoEmpleados(finalQueryGlobalEstadoEmpleado,new Pagination());
				estadoempleadosForeignKey=estadoempleadoLogic.getEstadoEmpleados();
			}

			cierrerolmensualReturnGeneral.setestadoempleadosForeignKey(estadoempleadosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			cierrerolmensualReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cierrerolmensualReturnGeneral;
	}
	
	
	public void deepLoad(CierreRolMensual cierrerolmensual,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CierreRolMensualLogicAdditional.updateCierreRolMensualToGet(cierrerolmensual,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cierrerolmensual.setEmpresa(cierrerolmensualDataAccess.getEmpresa(connexion,cierrerolmensual));
		cierrerolmensual.setSucursal(cierrerolmensualDataAccess.getSucursal(connexion,cierrerolmensual));
		cierrerolmensual.setEjercicio(cierrerolmensualDataAccess.getEjercicio(connexion,cierrerolmensual));
		cierrerolmensual.setEmpleado(cierrerolmensualDataAccess.getEmpleado(connexion,cierrerolmensual));
		cierrerolmensual.setEstructura(cierrerolmensualDataAccess.getEstructura(connexion,cierrerolmensual));
		cierrerolmensual.setEstadoEmpleado(cierrerolmensualDataAccess.getEstadoEmpleado(connexion,cierrerolmensual));
		cierrerolmensual.setAsientoContable(cierrerolmensualDataAccess.getAsientoContable(connexion,cierrerolmensual));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cierrerolmensual.setEmpresa(cierrerolmensualDataAccess.getEmpresa(connexion,cierrerolmensual));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cierrerolmensual.setSucursal(cierrerolmensualDataAccess.getSucursal(connexion,cierrerolmensual));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				cierrerolmensual.setEjercicio(cierrerolmensualDataAccess.getEjercicio(connexion,cierrerolmensual));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				cierrerolmensual.setEmpleado(cierrerolmensualDataAccess.getEmpleado(connexion,cierrerolmensual));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				cierrerolmensual.setEstructura(cierrerolmensualDataAccess.getEstructura(connexion,cierrerolmensual));
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				cierrerolmensual.setEstadoEmpleado(cierrerolmensualDataAccess.getEstadoEmpleado(connexion,cierrerolmensual));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				cierrerolmensual.setAsientoContable(cierrerolmensualDataAccess.getAsientoContable(connexion,cierrerolmensual));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEmpresa(cierrerolmensualDataAccess.getEmpresa(connexion,cierrerolmensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setSucursal(cierrerolmensualDataAccess.getSucursal(connexion,cierrerolmensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEjercicio(cierrerolmensualDataAccess.getEjercicio(connexion,cierrerolmensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEmpleado(cierrerolmensualDataAccess.getEmpleado(connexion,cierrerolmensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEstructura(cierrerolmensualDataAccess.getEstructura(connexion,cierrerolmensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEstadoEmpleado(cierrerolmensualDataAccess.getEstadoEmpleado(connexion,cierrerolmensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setAsientoContable(cierrerolmensualDataAccess.getAsientoContable(connexion,cierrerolmensual));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cierrerolmensual.setEmpresa(cierrerolmensualDataAccess.getEmpresa(connexion,cierrerolmensual));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cierrerolmensual.getEmpresa(),isDeep,deepLoadType,clases);
				
		cierrerolmensual.setSucursal(cierrerolmensualDataAccess.getSucursal(connexion,cierrerolmensual));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cierrerolmensual.getSucursal(),isDeep,deepLoadType,clases);
				
		cierrerolmensual.setEjercicio(cierrerolmensualDataAccess.getEjercicio(connexion,cierrerolmensual));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(cierrerolmensual.getEjercicio(),isDeep,deepLoadType,clases);
				
		cierrerolmensual.setEmpleado(cierrerolmensualDataAccess.getEmpleado(connexion,cierrerolmensual));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(cierrerolmensual.getEmpleado(),isDeep,deepLoadType,clases);
				
		cierrerolmensual.setEstructura(cierrerolmensualDataAccess.getEstructura(connexion,cierrerolmensual));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(cierrerolmensual.getEstructura(),isDeep,deepLoadType,clases);
				
		cierrerolmensual.setEstadoEmpleado(cierrerolmensualDataAccess.getEstadoEmpleado(connexion,cierrerolmensual));
		EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
		estadoempleadoLogic.deepLoad(cierrerolmensual.getEstadoEmpleado(),isDeep,deepLoadType,clases);
				
		cierrerolmensual.setAsientoContable(cierrerolmensualDataAccess.getAsientoContable(connexion,cierrerolmensual));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(cierrerolmensual.getAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cierrerolmensual.setEmpresa(cierrerolmensualDataAccess.getEmpresa(connexion,cierrerolmensual));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cierrerolmensual.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cierrerolmensual.setSucursal(cierrerolmensualDataAccess.getSucursal(connexion,cierrerolmensual));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cierrerolmensual.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				cierrerolmensual.setEjercicio(cierrerolmensualDataAccess.getEjercicio(connexion,cierrerolmensual));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(cierrerolmensual.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				cierrerolmensual.setEmpleado(cierrerolmensualDataAccess.getEmpleado(connexion,cierrerolmensual));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(cierrerolmensual.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				cierrerolmensual.setEstructura(cierrerolmensualDataAccess.getEstructura(connexion,cierrerolmensual));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(cierrerolmensual.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				cierrerolmensual.setEstadoEmpleado(cierrerolmensualDataAccess.getEstadoEmpleado(connexion,cierrerolmensual));
				EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
				estadoempleadoLogic.deepLoad(cierrerolmensual.getEstadoEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				cierrerolmensual.setAsientoContable(cierrerolmensualDataAccess.getAsientoContable(connexion,cierrerolmensual));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(cierrerolmensual.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEmpresa(cierrerolmensualDataAccess.getEmpresa(connexion,cierrerolmensual));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cierrerolmensual.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setSucursal(cierrerolmensualDataAccess.getSucursal(connexion,cierrerolmensual));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cierrerolmensual.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEjercicio(cierrerolmensualDataAccess.getEjercicio(connexion,cierrerolmensual));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(cierrerolmensual.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEmpleado(cierrerolmensualDataAccess.getEmpleado(connexion,cierrerolmensual));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(cierrerolmensual.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEstructura(cierrerolmensualDataAccess.getEstructura(connexion,cierrerolmensual));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(cierrerolmensual.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setEstadoEmpleado(cierrerolmensualDataAccess.getEstadoEmpleado(connexion,cierrerolmensual));
			EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
			estadoempleadoLogic.deepLoad(cierrerolmensual.getEstadoEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cierrerolmensual.setAsientoContable(cierrerolmensualDataAccess.getAsientoContable(connexion,cierrerolmensual));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(cierrerolmensual.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CierreRolMensual cierrerolmensual,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CierreRolMensualLogicAdditional.updateCierreRolMensualToSave(cierrerolmensual,this.arrDatoGeneral);
			
CierreRolMensualDataAccess.save(cierrerolmensual, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cierrerolmensual.getEmpresa(),connexion);

		SucursalDataAccess.save(cierrerolmensual.getSucursal(),connexion);

		EjercicioDataAccess.save(cierrerolmensual.getEjercicio(),connexion);

		EmpleadoDataAccess.save(cierrerolmensual.getEmpleado(),connexion);

		EstructuraDataAccess.save(cierrerolmensual.getEstructura(),connexion);

		EstadoEmpleadoDataAccess.save(cierrerolmensual.getEstadoEmpleado(),connexion);

		AsientoContableDataAccess.save(cierrerolmensual.getAsientoContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cierrerolmensual.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cierrerolmensual.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(cierrerolmensual.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(cierrerolmensual.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(cierrerolmensual.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				EstadoEmpleadoDataAccess.save(cierrerolmensual.getEstadoEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(cierrerolmensual.getAsientoContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cierrerolmensual.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cierrerolmensual.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cierrerolmensual.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cierrerolmensual.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(cierrerolmensual.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(cierrerolmensual.getEjercicio(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(cierrerolmensual.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(cierrerolmensual.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(cierrerolmensual.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(cierrerolmensual.getEstructura(),isDeep,deepLoadType,clases);
				

		EstadoEmpleadoDataAccess.save(cierrerolmensual.getEstadoEmpleado(),connexion);
		EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
		estadoempleadoLogic.deepLoad(cierrerolmensual.getEstadoEmpleado(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(cierrerolmensual.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(cierrerolmensual.getAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cierrerolmensual.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cierrerolmensual.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cierrerolmensual.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cierrerolmensual.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(cierrerolmensual.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(cierrerolmensual.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(cierrerolmensual.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(cierrerolmensual.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(cierrerolmensual.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(cierrerolmensual.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				EstadoEmpleadoDataAccess.save(cierrerolmensual.getEstadoEmpleado(),connexion);
				EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
				estadoempleadoLogic.deepSave(cierrerolmensual.getEstadoEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(cierrerolmensual.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(cierrerolmensual.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CierreRolMensual.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(cierrerolmensual);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.cierrerolmensual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CierreRolMensual.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cierrerolmensuals!=null) {
				for(CierreRolMensual cierrerolmensual:cierrerolmensuals) {
					this.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(cierrerolmensuals);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(cierrerolmensuals!=null) {
				for(CierreRolMensual cierrerolmensual:cierrerolmensuals) {
					this.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(cierrerolmensuals);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(CierreRolMensual.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(CierreRolMensual.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cierrerolmensuals!=null) {
				for(CierreRolMensual cierrerolmensual:cierrerolmensuals) {
					this.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(cierrerolmensuals!=null) {
				for(CierreRolMensual cierrerolmensual:cierrerolmensuals) {
					this.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCierreRolMensualsFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCierreRolMensualsFK_IdCierreRolMensualWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,CierreRolMensualConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCierreRolMensual","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdCierreRolMensual(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,CierreRolMensualConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCierreRolMensual","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCierreRolMensualsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CierreRolMensualConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CierreRolMensualConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCierreRolMensualsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CierreRolMensualConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CierreRolMensualConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCierreRolMensualsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CierreRolMensualConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CierreRolMensualConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCierreRolMensualsFK_IdEstadoEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_empleado,CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoEmpleado);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdEstadoEmpleado(String sFinalQuery,Pagination pagination,Long id_estado_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_empleado,CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoEmpleado);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCierreRolMensualsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CierreRolMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CierreRolMensualConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCierreRolMensualsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CierreRolMensualConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CierreRolMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(this.cierrerolmensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CierreRolMensualConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CierreRolMensualDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CierreRolMensual cierrerolmensual,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CierreRolMensualConstantesFunciones.ISCONAUDITORIA) {
				if(cierrerolmensual.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CierreRolMensualDataAccess.TABLENAME, cierrerolmensual.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CierreRolMensualConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CierreRolMensualLogic.registrarAuditoriaDetallesCierreRolMensual(connexion,cierrerolmensual,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cierrerolmensual.getIsDeleted()) {
					/*if(!cierrerolmensual.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CierreRolMensualDataAccess.TABLENAME, cierrerolmensual.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CierreRolMensualLogic.registrarAuditoriaDetallesCierreRolMensual(connexion,cierrerolmensual,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CierreRolMensualDataAccess.TABLENAME, cierrerolmensual.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cierrerolmensual.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CierreRolMensualDataAccess.TABLENAME, cierrerolmensual.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CierreRolMensualConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CierreRolMensualLogic.registrarAuditoriaDetallesCierreRolMensual(connexion,cierrerolmensual,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCierreRolMensual(Connexion connexion,CierreRolMensual cierrerolmensual)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_empresa().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_empresa()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_empresa().toString();
				}
				if(cierrerolmensual.getid_empresa()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_sucursal().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_sucursal()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_sucursal().toString();
				}
				if(cierrerolmensual.getid_sucursal()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_ejercicio().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_ejercicio()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_ejercicio().toString();
				}
				if(cierrerolmensual.getid_ejercicio()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_empleado().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_empleado()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_empleado().toString();
				}
				if(cierrerolmensual.getid_empleado()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_estructura().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_estructura()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_estructura().toString();
				}
				if(cierrerolmensual.getid_estructura()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_estado_empleado().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_estado_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_estado_empleado()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_estado_empleado().toString();
				}
				if(cierrerolmensual.getid_estado_empleado()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_estado_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getid_asiento_contable().equals(cierrerolmensual.getCierreRolMensualOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getid_asiento_contable().toString();
				}
				if(cierrerolmensual.getid_asiento_contable()!=null)
				{
					strValorNuevo=cierrerolmensual.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getporcentaje().equals(cierrerolmensual.getCierreRolMensualOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getporcentaje()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getporcentaje().toString();
				}
				if(cierrerolmensual.getporcentaje()!=null)
				{
					strValorNuevo=cierrerolmensual.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(cierrerolmensual.getIsNew()||!cierrerolmensual.getfecha().equals(cierrerolmensual.getCierreRolMensualOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cierrerolmensual.getCierreRolMensualOriginal().getfecha()!=null)
				{
					strValorActual=cierrerolmensual.getCierreRolMensualOriginal().getfecha().toString();
				}
				if(cierrerolmensual.getfecha()!=null)
				{
					strValorNuevo=cierrerolmensual.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CierreRolMensualConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCierreRolMensualRelacionesWithConnection(CierreRolMensual cierrerolmensual) throws Exception {

		if(!cierrerolmensual.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCierreRolMensualRelacionesBase(cierrerolmensual,true);
		}
	}

	public void saveCierreRolMensualRelaciones(CierreRolMensual cierrerolmensual)throws Exception {

		if(!cierrerolmensual.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCierreRolMensualRelacionesBase(cierrerolmensual,false);
		}
	}

	public void saveCierreRolMensualRelacionesBase(CierreRolMensual cierrerolmensual,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CierreRolMensual-saveRelacionesWithConnection");}
	

			this.setCierreRolMensual(cierrerolmensual);

			if(CierreRolMensualLogicAdditional.validarSaveRelaciones(cierrerolmensual,this)) {

				CierreRolMensualLogicAdditional.updateRelacionesToSave(cierrerolmensual,this);

				if((cierrerolmensual.getIsNew()||cierrerolmensual.getIsChanged())&&!cierrerolmensual.getIsDeleted()) {
					this.saveCierreRolMensual();
					this.saveCierreRolMensualRelacionesDetalles();

				} else if(cierrerolmensual.getIsDeleted()) {
					this.saveCierreRolMensualRelacionesDetalles();
					this.saveCierreRolMensual();
				}

				CierreRolMensualLogicAdditional.updateRelacionesToSaveAfter(cierrerolmensual,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCierreRolMensualRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCierreRolMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CierreRolMensualConstantesFunciones.getClassesForeignKeysOfCierreRolMensual(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCierreRolMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CierreRolMensualConstantesFunciones.getClassesRelationshipsOfCierreRolMensual(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
