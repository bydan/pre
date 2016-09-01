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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.SriConstantesFunciones;
import com.bydan.erp.contabilidad.util.SriParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SriParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.Sri;
import com.bydan.erp.contabilidad.business.logic.SriLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.cartera.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class SriLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SriLogic.class);
	
	protected SriDataAccess sriDataAccess; 	
	protected Sri sri;
	protected List<Sri> sris;
	protected Object sriObject;	
	protected List<Object> srisObject;
	
	public static ClassValidator<Sri> sriValidator = new ClassValidator<Sri>(Sri.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SriLogicAdditional sriLogicAdditional=null;
	
	public SriLogicAdditional getSriLogicAdditional() {
		return this.sriLogicAdditional;
	}
	
	public void setSriLogicAdditional(SriLogicAdditional sriLogicAdditional) {
		try {
			this.sriLogicAdditional=sriLogicAdditional;
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
	
	
	
	
	public  SriLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.sriDataAccess = new SriDataAccess();
			
			this.sris= new ArrayList<Sri>();
			this.sri= new Sri();
			
			this.sriObject=new Object();
			this.srisObject=new ArrayList<Object>();
				
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
			
			this.sriDataAccess.setConnexionType(this.connexionType);
			this.sriDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SriLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.sriDataAccess = new SriDataAccess();
			this.sris= new ArrayList<Sri>();
			this.sri= new Sri();
			this.sriObject=new Object();
			this.srisObject=new ArrayList<Object>();
			
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
			
			this.sriDataAccess.setConnexionType(this.connexionType);
			this.sriDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Sri getSri() throws Exception {	
		SriLogicAdditional.checkSriToGet(sri,this.datosCliente,this.arrDatoGeneral);
		SriLogicAdditional.updateSriToGet(sri,this.arrDatoGeneral);
		
		return sri;
	}
		
	public void setSri(Sri newSri) {
		this.sri = newSri;
	}
	
	public SriDataAccess getSriDataAccess() {
		return sriDataAccess;
	}
	
	public void setSriDataAccess(SriDataAccess newsriDataAccess) {
		this.sriDataAccess = newsriDataAccess;
	}
	
	public List<Sri> getSris() throws Exception {		
		this.quitarSrisNulos();
		
		SriLogicAdditional.checkSriToGets(sris,this.datosCliente,this.arrDatoGeneral);
		
		for (Sri sriLocal: sris ) {
			SriLogicAdditional.updateSriToGet(sriLocal,this.arrDatoGeneral);
		}
		
		return sris;
	}
	
	public void setSris(List<Sri> newSris) {
		this.sris = newSris;
	}
	
	public Object getSriObject() {	
		this.sriObject=this.sriDataAccess.getEntityObject();
		return this.sriObject;
	}
		
	public void setSriObject(Object newSriObject) {
		this.sriObject = newSriObject;
	}
	
	public List<Object> getSrisObject() {		
		this.srisObject=this.sriDataAccess.getEntitiesObject();
		return this.srisObject;
	}
		
	public void setSrisObject(List<Object> newSrisObject) {
		this.srisObject = newSrisObject;
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
		
		if(this.sriDataAccess!=null) {
			this.sriDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			sriDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			sriDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		sri = new  Sri();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			sri=sriDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
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
		sri = new  Sri();
		  		  
        try {
			
			sri=sriDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		sri = new  Sri();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			sri=sriDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
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
		sri = new  Sri();
		  		  
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
		sri = new  Sri();
		  		  
        try {
			
			sri=sriDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		sri = new  Sri();
		  		  
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
		sri = new  Sri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =sriDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sri = new  Sri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=sriDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		sri = new  Sri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =sriDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sri = new  Sri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=sriDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		sri = new  Sri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =sriDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sri = new  Sri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=sriDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sris = new  ArrayList<Sri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
		sris = new  ArrayList<Sri>();
		  		  
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
		sris = new  ArrayList<Sri>();
		  		  
        try {			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		sris = new  ArrayList<Sri>();
		  		  
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
		sris = new  ArrayList<Sri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
		sris = new  ArrayList<Sri>();
		  		  
        try {
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
		sris = new  ArrayList<Sri>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
		sris = new  ArrayList<Sri>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		sri = new  Sri();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sri=sriDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSri(sri);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
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
		sri = new  Sri();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sri=sriDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSri(sri);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sris = new  ArrayList<Sri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
		sris = new  ArrayList<Sri>();
		  		  
        try {
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSrisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		sris = new  ArrayList<Sri>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getTodosSrisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
	
	public  void  getTodosSris(String sFinalQuery,Pagination pagination)throws Exception {
		sris = new  ArrayList<Sri>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSri(sris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSri(Sri sri) throws Exception {
		Boolean estaValidado=false;
		
		if(sri.getIsNew() || sri.getIsChanged()) { 
			this.invalidValues = sriValidator.getInvalidValues(sri);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(sri);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSri(List<Sri> Sris) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Sri sriLocal:sris) {				
			estaValidadoObjeto=this.validarGuardarSri(sriLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSri(List<Sri> Sris) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSri(sris)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSri(Sri Sri) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSri(sri)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Sri sri) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+sri.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SriConstantesFunciones.getSriLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"sri","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SriConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SriConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSriWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-saveSriWithConnection");connexion.begin();			
			
			SriLogicAdditional.checkSriToSave(this.sri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SriLogicAdditional.updateSriToSave(this.sri,this.arrDatoGeneral);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.sri,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSri();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSri(this.sri)) {
				SriDataAccess.save(this.sri, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.sri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SriLogicAdditional.checkSriToSaveAfter(this.sri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSri();
			
			connexion.commit();			
			
			if(this.sri.getIsDeleted()) {
				this.sri=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSri()throws Exception {	
		try {	
			
			SriLogicAdditional.checkSriToSave(this.sri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SriLogicAdditional.updateSriToSave(this.sri,this.arrDatoGeneral);
			
			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.sri,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSri(this.sri)) {			
				SriDataAccess.save(this.sri, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.sri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SriLogicAdditional.checkSriToSaveAfter(this.sri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.sri.getIsDeleted()) {
				this.sri=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSrisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-saveSrisWithConnection");connexion.begin();			
			
			SriLogicAdditional.checkSriToSaves(sris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSris();
			
			Boolean validadoTodosSri=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Sri sriLocal:sris) {		
				if(sriLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SriLogicAdditional.updateSriToSave(sriLocal,this.arrDatoGeneral);
	        	
				SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),sriLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSri(sriLocal)) {
					SriDataAccess.save(sriLocal, connexion);				
				} else {
					validadoTodosSri=false;
				}
			}
			
			if(!validadoTodosSri) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SriLogicAdditional.checkSriToSavesAfter(sris,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSris();
			
			connexion.commit();		
			
			this.quitarSrisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSris()throws Exception {				
		 try {	
			SriLogicAdditional.checkSriToSaves(sris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSri=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Sri sriLocal:sris) {				
				if(sriLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SriLogicAdditional.updateSriToSave(sriLocal,this.arrDatoGeneral);
	        	
				SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),sriLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSri(sriLocal)) {				
					SriDataAccess.save(sriLocal, connexion);				
				} else {
					validadoTodosSri=false;
				}
			}
			
			if(!validadoTodosSri) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SriLogicAdditional.checkSriToSavesAfter(sris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSrisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriParameterReturnGeneral procesarAccionSris(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Sri> sris,SriParameterReturnGeneral sriParameterGeneral)throws Exception {
		 try {	
			SriParameterReturnGeneral sriReturnGeneral=new SriParameterReturnGeneral();
	
			SriLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sris,sriParameterGeneral,sriReturnGeneral);
			
			return sriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriParameterReturnGeneral procesarAccionSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Sri> sris,SriParameterReturnGeneral sriParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-procesarAccionSrisWithConnection");connexion.begin();			
			
			SriParameterReturnGeneral sriReturnGeneral=new SriParameterReturnGeneral();
	
			SriLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sris,sriParameterGeneral,sriReturnGeneral);
			
			this.connexion.commit();
			
			return sriReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SriParameterReturnGeneral procesarEventosSris(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Sri> sris,Sri sri,SriParameterReturnGeneral sriParameterGeneral,Boolean isEsNuevoSri,ArrayList<Classe> clases)throws Exception {
		 try {	
			SriParameterReturnGeneral sriReturnGeneral=new SriParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				sriReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SriLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,sris,sri,sriParameterGeneral,sriReturnGeneral,isEsNuevoSri,clases);
			
			return sriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SriParameterReturnGeneral procesarEventosSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Sri> sris,Sri sri,SriParameterReturnGeneral sriParameterGeneral,Boolean isEsNuevoSri,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-procesarEventosSrisWithConnection");connexion.begin();			
			
			SriParameterReturnGeneral sriReturnGeneral=new SriParameterReturnGeneral();
	
			sriReturnGeneral.setSri(sri);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				sriReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SriLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,sris,sri,sriParameterGeneral,sriReturnGeneral,isEsNuevoSri,clases);
			
			this.connexion.commit();
			
			return sriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SriParameterReturnGeneral procesarImportacionSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SriParameterReturnGeneral sriParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-procesarImportacionSrisWithConnection");connexion.begin();			
			
			SriParameterReturnGeneral sriReturnGeneral=new SriParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.sris=new ArrayList<Sri>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.sri=new Sri();
				
				
				if(conColumnasBase) {this.sri.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.sri.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.sri.setruc(arrColumnas[iColumn++]);
				this.sri.setrazon_social(arrColumnas[iColumn++]);
				this.sri.setes_rise(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.sri.setnumero_serie(arrColumnas[iColumn++]);
				this.sri.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.sri.setnumero_secuencial(arrColumnas[iColumn++]);
				this.sri.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.sri.setfecha_registro_contable(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.sri.setfecha_caducidad(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.sri.setbienes_tar12(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setbienes_tar0(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setservicios_tar12(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setservicios_tar0(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setmonto_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setbase_impo_tar12(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setbase_impo_tar0(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setmonto_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setmonto_iva_bien(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setmonto_iva_servicio(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setretencion_iva_bien(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setretencion_iva_servicio(Double.parseDouble(arrColumnas[iColumn++]));
				this.sri.setcon_devolucion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.sris.add(this.sri);
			}
			
			this.saveSris();
			
			this.connexion.commit();
			
			sriReturnGeneral.setConRetornoEstaProcesado(true);
			sriReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return sriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSrisEliminados() throws Exception {				
		
		List<Sri> srisAux= new ArrayList<Sri>();
		
		for(Sri sri:sris) {
			if(!sri.getIsDeleted()) {
				srisAux.add(sri);
			}
		}
		
		sris=srisAux;
	}
	
	public void quitarSrisNulos() throws Exception {				
		
		List<Sri> srisAux= new ArrayList<Sri>();
		
		for(Sri sri : this.sris) {
			if(sri==null) {
				srisAux.add(sri);
			}
		}
		
		//this.sris=srisAux;
		
		this.sris.removeAll(srisAux);
	}
	
	public void getSetVersionRowSriWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(sri.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((sri.getIsDeleted() || (sri.getIsChanged()&&!sri.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=sriDataAccess.getSetVersionRowSri(connexion,sri.getId());
				
				if(!sri.getVersionRow().equals(timestamp)) {	
					sri.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				sri.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSri()throws Exception {	
		
		if(sri.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((sri.getIsDeleted() || (sri.getIsChanged()&&!sri.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=sriDataAccess.getSetVersionRowSri(connexion,sri.getId());
			
			try {							
				if(!sri.getVersionRow().equals(timestamp)) {	
					sri.setVersionRow(timestamp);
				}
				
				sri.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSrisWithConnection()throws Exception {	
		if(sris!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Sri sriAux:sris) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(sriAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(sriAux.getIsDeleted() || (sriAux.getIsChanged()&&!sriAux.getIsNew())) {
						
						timestamp=sriDataAccess.getSetVersionRowSri(connexion,sriAux.getId());
						
						if(!sri.getVersionRow().equals(timestamp)) {	
							sriAux.setVersionRow(timestamp);
						}
								
						sriAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSris()throws Exception {	
		if(sris!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Sri sriAux:sris) {
					if(sriAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(sriAux.getIsDeleted() || (sriAux.getIsChanged()&&!sriAux.getIsNew())) {
						
						timestamp=sriDataAccess.getSetVersionRowSri(connexion,sriAux.getId());
						
						if(!sriAux.getVersionRow().equals(timestamp)) {	
							sriAux.setVersionRow(timestamp);
						}
						
													
						sriAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SriParameterReturnGeneral cargarCombosLoteForeignKeySriWithConnection(String finalQueryGlobalAsientoContable,String finalQueryGlobalTransaccionConta,String finalQueryGlobalCliente,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTributario,String finalQueryGlobalTipoIva,String finalQueryGlobalTipoRetencionIvaBien,String finalQueryGlobalTipoRetencionIvaServicio,String finalQueryGlobalTipoMovimiento) throws Exception {
		SriParameterReturnGeneral  sriReturnGeneral =new SriParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-cargarCombosLoteForeignKeySriWithConnection");connexion.begin();
			
			sriReturnGeneral =new SriParameterReturnGeneral();
			
			

			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			sriReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TransaccionConta> transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
			TransaccionContaLogic transaccioncontaLogic=new TransaccionContaLogic();
			transaccioncontaLogic.setConnexion(this.connexion);
			transaccioncontaLogic.getTransaccionContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionConta.equals("NONE")) {
				transaccioncontaLogic.getTodosTransaccionContas(finalQueryGlobalTransaccionConta,new Pagination());
				transaccioncontasForeignKey=transaccioncontaLogic.getTransaccionContas();
			}

			sriReturnGeneral.settransaccioncontasForeignKey(transaccioncontasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			sriReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			sriReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			sriReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			sriReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);


			List<TipoRetencionIva> tiporetencionivabiensForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivabienLogic=new TipoRetencionIvaLogic();
			tiporetencionivabienLogic.setConnexion(this.connexion);
			tiporetencionivabienLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaBien.equals("NONE")) {
				tiporetencionivabienLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIvaBien,new Pagination());
				tiporetencionivabiensForeignKey=tiporetencionivabienLogic.getTipoRetencionIvas();
			}

			sriReturnGeneral.settiporetencionivabiensForeignKey(tiporetencionivabiensForeignKey);


			List<TipoRetencionIva> tiporetencionivaserviciosForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaservicioLogic=new TipoRetencionIvaLogic();
			tiporetencionivaservicioLogic.setConnexion(this.connexion);
			tiporetencionivaservicioLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaServicio.equals("NONE")) {
				tiporetencionivaservicioLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIvaServicio,new Pagination());
				tiporetencionivaserviciosForeignKey=tiporetencionivaservicioLogic.getTipoRetencionIvas();
			}

			sriReturnGeneral.settiporetencionivaserviciosForeignKey(tiporetencionivaserviciosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			sriReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return sriReturnGeneral;
	}
	
	public SriParameterReturnGeneral cargarCombosLoteForeignKeySri(String finalQueryGlobalAsientoContable,String finalQueryGlobalTransaccionConta,String finalQueryGlobalCliente,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTributario,String finalQueryGlobalTipoIva,String finalQueryGlobalTipoRetencionIvaBien,String finalQueryGlobalTipoRetencionIvaServicio,String finalQueryGlobalTipoMovimiento) throws Exception {
		SriParameterReturnGeneral  sriReturnGeneral =new SriParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			sriReturnGeneral =new SriParameterReturnGeneral();
			
			

			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			sriReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TransaccionConta> transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
			TransaccionContaLogic transaccioncontaLogic=new TransaccionContaLogic();
			transaccioncontaLogic.setConnexion(this.connexion);
			transaccioncontaLogic.getTransaccionContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionConta.equals("NONE")) {
				transaccioncontaLogic.getTodosTransaccionContas(finalQueryGlobalTransaccionConta,new Pagination());
				transaccioncontasForeignKey=transaccioncontaLogic.getTransaccionContas();
			}

			sriReturnGeneral.settransaccioncontasForeignKey(transaccioncontasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			sriReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			sriReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			sriReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			sriReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);


			List<TipoRetencionIva> tiporetencionivabiensForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivabienLogic=new TipoRetencionIvaLogic();
			tiporetencionivabienLogic.setConnexion(this.connexion);
			tiporetencionivabienLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaBien.equals("NONE")) {
				tiporetencionivabienLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIvaBien,new Pagination());
				tiporetencionivabiensForeignKey=tiporetencionivabienLogic.getTipoRetencionIvas();
			}

			sriReturnGeneral.settiporetencionivabiensForeignKey(tiporetencionivabiensForeignKey);


			List<TipoRetencionIva> tiporetencionivaserviciosForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaservicioLogic=new TipoRetencionIvaLogic();
			tiporetencionivaservicioLogic.setConnexion(this.connexion);
			tiporetencionivaservicioLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaServicio.equals("NONE")) {
				tiporetencionivaservicioLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIvaServicio,new Pagination());
				tiporetencionivaserviciosForeignKey=tiporetencionivaservicioLogic.getTipoRetencionIvas();
			}

			sriReturnGeneral.settiporetencionivaserviciosForeignKey(tiporetencionivaserviciosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			sriReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return sriReturnGeneral;
	}
	
	
	public void deepLoad(Sri sri,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SriLogicAdditional.updateSriToGet(sri,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sri.setAsientoContable(sriDataAccess.getAsientoContable(connexion,sri));
		sri.setTransaccionConta(sriDataAccess.getTransaccionConta(connexion,sri));
		sri.setCliente(sriDataAccess.getCliente(connexion,sri));
		sri.setTipoComprobante(sriDataAccess.getTipoComprobante(connexion,sri));
		sri.setTipoTributario(sriDataAccess.getTipoTributario(connexion,sri));
		sri.setTipoIva(sriDataAccess.getTipoIva(connexion,sri));
		sri.setTipoRetencionIvaBien(sriDataAccess.getTipoRetencionIvaBien(connexion,sri));
		sri.setTipoRetencionIvaServicio(sriDataAccess.getTipoRetencionIvaServicio(connexion,sri));
		sri.setTipoMovimiento(sriDataAccess.getTipoMovimiento(connexion,sri));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				sri.setAsientoContable(sriDataAccess.getAsientoContable(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				sri.setTransaccionConta(sriDataAccess.getTransaccionConta(connexion,sri));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				sri.setCliente(sriDataAccess.getCliente(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				sri.setTipoComprobante(sriDataAccess.getTipoComprobante(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				sri.setTipoTributario(sriDataAccess.getTipoTributario(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				sri.setTipoIva(sriDataAccess.getTipoIva(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				sri.setTipoRetencionIvaBien(sriDataAccess.getTipoRetencionIvaBien(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				sri.setTipoRetencionIvaServicio(sriDataAccess.getTipoRetencionIvaServicio(connexion,sri));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				sri.setTipoMovimiento(sriDataAccess.getTipoMovimiento(connexion,sri));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setAsientoContable(sriDataAccess.getAsientoContable(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTransaccionConta(sriDataAccess.getTransaccionConta(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setCliente(sriDataAccess.getCliente(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoComprobante(sriDataAccess.getTipoComprobante(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoTributario(sriDataAccess.getTipoTributario(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoIva(sriDataAccess.getTipoIva(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoRetencionIvaBien(sriDataAccess.getTipoRetencionIvaBien(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoRetencionIvaServicio(sriDataAccess.getTipoRetencionIvaServicio(connexion,sri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoMovimiento(sriDataAccess.getTipoMovimiento(connexion,sri));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sri.setAsientoContable(sriDataAccess.getAsientoContable(connexion,sri));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(sri.getAsientoContable(),isDeep,deepLoadType,clases);
				
		sri.setTransaccionConta(sriDataAccess.getTransaccionConta(connexion,sri));
		TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
		transaccioncontaLogic.deepLoad(sri.getTransaccionConta(),isDeep,deepLoadType,clases);
				
		sri.setCliente(sriDataAccess.getCliente(connexion,sri));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(sri.getCliente(),isDeep,deepLoadType,clases);
				
		sri.setTipoComprobante(sriDataAccess.getTipoComprobante(connexion,sri));
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(sri.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		sri.setTipoTributario(sriDataAccess.getTipoTributario(connexion,sri));
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(sri.getTipoTributario(),isDeep,deepLoadType,clases);
				
		sri.setTipoIva(sriDataAccess.getTipoIva(connexion,sri));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(sri.getTipoIva(),isDeep,deepLoadType,clases);
				
		sri.setTipoRetencionIvaBien(sriDataAccess.getTipoRetencionIvaBien(connexion,sri));
		TipoRetencionIvaLogic tiporetencionivabienLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivabienLogic.deepLoad(sri.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);
				
		sri.setTipoRetencionIvaServicio(sriDataAccess.getTipoRetencionIvaServicio(connexion,sri));
		TipoRetencionIvaLogic tiporetencionivaservicioLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaservicioLogic.deepLoad(sri.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);
				
		sri.setTipoMovimiento(sriDataAccess.getTipoMovimiento(connexion,sri));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(sri.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				sri.setAsientoContable(sriDataAccess.getAsientoContable(connexion,sri));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(sri.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				sri.setTransaccionConta(sriDataAccess.getTransaccionConta(connexion,sri));
				TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
				transaccioncontaLogic.deepLoad(sri.getTransaccionConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				sri.setCliente(sriDataAccess.getCliente(connexion,sri));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(sri.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				sri.setTipoComprobante(sriDataAccess.getTipoComprobante(connexion,sri));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(sri.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				sri.setTipoTributario(sriDataAccess.getTipoTributario(connexion,sri));
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepLoad(sri.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				sri.setTipoIva(sriDataAccess.getTipoIva(connexion,sri));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(sri.getTipoIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				sri.setTipoRetencionIvaBien(sriDataAccess.getTipoRetencionIvaBien(connexion,sri));
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepLoad(sri.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				sri.setTipoRetencionIvaServicio(sriDataAccess.getTipoRetencionIvaServicio(connexion,sri));
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepLoad(sri.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				sri.setTipoMovimiento(sriDataAccess.getTipoMovimiento(connexion,sri));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(sri.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setAsientoContable(sriDataAccess.getAsientoContable(connexion,sri));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(sri.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTransaccionConta(sriDataAccess.getTransaccionConta(connexion,sri));
			TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
			transaccioncontaLogic.deepLoad(sri.getTransaccionConta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setCliente(sriDataAccess.getCliente(connexion,sri));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(sri.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoComprobante(sriDataAccess.getTipoComprobante(connexion,sri));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(sri.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoTributario(sriDataAccess.getTipoTributario(connexion,sri));
			TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
			tipotributarioLogic.deepLoad(sri.getTipoTributario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoIva(sriDataAccess.getTipoIva(connexion,sri));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(sri.getTipoIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoRetencionIvaBien(sriDataAccess.getTipoRetencionIvaBien(connexion,sri));
			TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
			tiporetencionivaLogic.deepLoad(sri.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoRetencionIvaServicio(sriDataAccess.getTipoRetencionIvaServicio(connexion,sri));
			TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
			tiporetencionivaLogic.deepLoad(sri.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sri.setTipoMovimiento(sriDataAccess.getTipoMovimiento(connexion,sri));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(sri.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Sri sri,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SriLogicAdditional.updateSriToSave(sri,this.arrDatoGeneral);
			
SriDataAccess.save(sri, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AsientoContableDataAccess.save(sri.getAsientoContable(),connexion);

		TransaccionContaDataAccess.save(sri.getTransaccionConta(),connexion);

		ClienteDataAccess.save(sri.getCliente(),connexion);

		TipoComprobanteDataAccess.save(sri.getTipoComprobante(),connexion);

		TipoTributarioDataAccess.save(sri.getTipoTributario(),connexion);

		TipoIvaDataAccess.save(sri.getTipoIva(),connexion);

		TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaBien(),connexion);

		TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaServicio(),connexion);

		TipoMovimientoDataAccess.save(sri.getTipoMovimiento(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(sri.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				TransaccionContaDataAccess.save(sri.getTransaccionConta(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(sri.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(sri.getTipoComprobante(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(sri.getTipoTributario(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(sri.getTipoIva(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaBien(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(sri.getTipoMovimiento(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AsientoContableDataAccess.save(sri.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(sri.getAsientoContable(),isDeep,deepLoadType,clases);
				

		TransaccionContaDataAccess.save(sri.getTransaccionConta(),connexion);
		TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
		transaccioncontaLogic.deepLoad(sri.getTransaccionConta(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(sri.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(sri.getCliente(),isDeep,deepLoadType,clases);
				

		TipoComprobanteDataAccess.save(sri.getTipoComprobante(),connexion);
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(sri.getTipoComprobante(),isDeep,deepLoadType,clases);
				

		TipoTributarioDataAccess.save(sri.getTipoTributario(),connexion);
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(sri.getTipoTributario(),isDeep,deepLoadType,clases);
				

		TipoIvaDataAccess.save(sri.getTipoIva(),connexion);
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(sri.getTipoIva(),isDeep,deepLoadType,clases);
				

		TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaBien(),connexion);
		TipoRetencionIvaLogic tiporetencionivabienLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivabienLogic.deepLoad(sri.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);
				

		TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaServicio(),connexion);
		TipoRetencionIvaLogic tiporetencionivaservicioLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaservicioLogic.deepLoad(sri.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(sri.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(sri.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(sri.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(sri.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				TransaccionContaDataAccess.save(sri.getTransaccionConta(),connexion);
				TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
				transaccioncontaLogic.deepSave(sri.getTransaccionConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(sri.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(sri.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(sri.getTipoComprobante(),connexion);
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepSave(sri.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(sri.getTipoTributario(),connexion);
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepSave(sri.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(sri.getTipoIva(),connexion);
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepSave(sri.getTipoIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaBien(),connexion);
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepSave(sri.getTipoRetencionIvaBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(sri.getTipoRetencionIvaServicio(),connexion);
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepSave(sri.getTipoRetencionIvaServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(sri.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(sri.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Sri.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(sri,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(sri);
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
			this.deepLoad(this.sri,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Sri.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(sris!=null) {
				for(Sri sri:sris) {
					this.deepLoad(sri,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(sris);
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
			if(sris!=null) {
				for(Sri sri:sris) {
					this.deepLoad(sri,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(sris);
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
			this.getNewConnexionToDeep(Sri.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(sri,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Sri.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(sris!=null) {
				for(Sri sri:sris) {
					this.deepSave(sri,isDeep,deepLoadType,clases);
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
			if(sris!=null) {
				for(Sri sri:sris) {
					this.deepSave(sri,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSrisFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,SriConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,SriConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,SriConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,SriConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTipoComprobanteWithConnection(String sFinalQuery,Pagination pagination,Long tipo_comprobante)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,tipo_comprobante,SriConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTipoComprobante(String sFinalQuery,Pagination pagination,Long tipo_comprobante)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,tipo_comprobante,SriConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTipoIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,SriConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTipoIva(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,SriConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,SriConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,SriConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTipoRetencionIvaBienWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_bien,SriConstantesFunciones.IDTIPORETENCIONIVABIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaBien);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTipoRetencionIvaBien(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_bien,SriConstantesFunciones.IDTIPORETENCIONIVABIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaBien);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTipoRetencionIvaServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_servicio,SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaServicio);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTipoRetencionIvaServicio(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_servicio,SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaServicio);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTipoTributarioWithConnection(String sFinalQuery,Pagination pagination,Long tipo_tributario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,tipo_tributario,SriConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTipoTributario(String sFinalQuery,Pagination pagination,Long tipo_tributario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,tipo_tributario,SriConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSrisFK_IdTransaccionContaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_conta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_conta,SriConstantesFunciones.IDTRANSACCIONCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionConta);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSrisFK_IdTransaccionConta(String sFinalQuery,Pagination pagination,Long id_transaccion_conta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_conta,SriConstantesFunciones.IDTRANSACCIONCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionConta);

			SriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(this.sris);
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
			if(SriConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SriDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Sri sri,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SriConstantesFunciones.ISCONAUDITORIA) {
				if(sri.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SriDataAccess.TABLENAME, sri.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SriConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SriLogic.registrarAuditoriaDetallesSri(connexion,sri,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(sri.getIsDeleted()) {
					/*if(!sri.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SriDataAccess.TABLENAME, sri.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SriLogic.registrarAuditoriaDetallesSri(connexion,sri,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SriDataAccess.TABLENAME, sri.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(sri.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SriDataAccess.TABLENAME, sri.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SriConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SriLogic.registrarAuditoriaDetallesSri(connexion,sri,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSri(Connexion connexion,Sri sri)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(sri.getIsNew()||!sri.getid_asiento_contable().equals(sri.getSriOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_asiento_contable().toString();
				}
				if(sri.getid_asiento_contable()!=null)
				{
					strValorNuevo=sri.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getid_transaccion_conta().equals(sri.getSriOriginal().getid_transaccion_conta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_transaccion_conta()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_transaccion_conta().toString();
				}
				if(sri.getid_transaccion_conta()!=null)
				{
					strValorNuevo=sri.getid_transaccion_conta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTRANSACCIONCONTA,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getruc().equals(sri.getSriOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getruc()!=null)
				{
					strValorActual=sri.getSriOriginal().getruc();
				}
				if(sri.getruc()!=null)
				{
					strValorNuevo=sri.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getid_cliente().equals(sri.getSriOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_cliente()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_cliente().toString();
				}
				if(sri.getid_cliente()!=null)
				{
					strValorNuevo=sri.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getrazon_social().equals(sri.getSriOriginal().getrazon_social()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getrazon_social()!=null)
				{
					strValorActual=sri.getSriOriginal().getrazon_social();
				}
				if(sri.getrazon_social()!=null)
				{
					strValorNuevo=sri.getrazon_social() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.RAZONSOCIAL,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.gettipo_comprobante().equals(sri.getSriOriginal().gettipo_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().gettipo_comprobante()!=null)
				{
					strValorActual=sri.getSriOriginal().gettipo_comprobante().toString();
				}
				if(sri.gettipo_comprobante()!=null)
				{
					strValorNuevo=sri.gettipo_comprobante().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTIPOCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getes_rise().equals(sri.getSriOriginal().getes_rise()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getes_rise()!=null)
				{
					strValorActual=sri.getSriOriginal().getes_rise().toString();
				}
				if(sri.getes_rise()!=null)
				{
					strValorNuevo=sri.getes_rise().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.ESRISE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getnumero_serie().equals(sri.getSriOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getnumero_serie()!=null)
				{
					strValorActual=sri.getSriOriginal().getnumero_serie();
				}
				if(sri.getnumero_serie()!=null)
				{
					strValorNuevo=sri.getnumero_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getnumero_autorizacion().equals(sri.getSriOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=sri.getSriOriginal().getnumero_autorizacion();
				}
				if(sri.getnumero_autorizacion()!=null)
				{
					strValorNuevo=sri.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getnumero_secuencial().equals(sri.getSriOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=sri.getSriOriginal().getnumero_secuencial();
				}
				if(sri.getnumero_secuencial()!=null)
				{
					strValorNuevo=sri.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getfecha_emision().equals(sri.getSriOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getfecha_emision()!=null)
				{
					strValorActual=sri.getSriOriginal().getfecha_emision().toString();
				}
				if(sri.getfecha_emision()!=null)
				{
					strValorNuevo=sri.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getfecha_registro_contable().equals(sri.getSriOriginal().getfecha_registro_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getfecha_registro_contable()!=null)
				{
					strValorActual=sri.getSriOriginal().getfecha_registro_contable().toString();
				}
				if(sri.getfecha_registro_contable()!=null)
				{
					strValorNuevo=sri.getfecha_registro_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.FECHAREGISTROCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getfecha_caducidad().equals(sri.getSriOriginal().getfecha_caducidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getfecha_caducidad()!=null)
				{
					strValorActual=sri.getSriOriginal().getfecha_caducidad().toString();
				}
				if(sri.getfecha_caducidad()!=null)
				{
					strValorNuevo=sri.getfecha_caducidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.FECHACADUCIDAD,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.gettipo_tributario().equals(sri.getSriOriginal().gettipo_tributario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().gettipo_tributario()!=null)
				{
					strValorActual=sri.getSriOriginal().gettipo_tributario().toString();
				}
				if(sri.gettipo_tributario()!=null)
				{
					strValorNuevo=sri.gettipo_tributario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTIPOTRIBUTARIO,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getbienes_tar12().equals(sri.getSriOriginal().getbienes_tar12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getbienes_tar12()!=null)
				{
					strValorActual=sri.getSriOriginal().getbienes_tar12().toString();
				}
				if(sri.getbienes_tar12()!=null)
				{
					strValorNuevo=sri.getbienes_tar12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.BIENESTAR12,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getbienes_tar0().equals(sri.getSriOriginal().getbienes_tar0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getbienes_tar0()!=null)
				{
					strValorActual=sri.getSriOriginal().getbienes_tar0().toString();
				}
				if(sri.getbienes_tar0()!=null)
				{
					strValorNuevo=sri.getbienes_tar0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.BIENESTAR0,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getid_tipo_iva().equals(sri.getSriOriginal().getid_tipo_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_tipo_iva()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_tipo_iva().toString();
				}
				if(sri.getid_tipo_iva()!=null)
				{
					strValorNuevo=sri.getid_tipo_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTIPOIVA,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getservicios_tar12().equals(sri.getSriOriginal().getservicios_tar12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getservicios_tar12()!=null)
				{
					strValorActual=sri.getSriOriginal().getservicios_tar12().toString();
				}
				if(sri.getservicios_tar12()!=null)
				{
					strValorNuevo=sri.getservicios_tar12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.SERVICIOSTAR12,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getservicios_tar0().equals(sri.getSriOriginal().getservicios_tar0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getservicios_tar0()!=null)
				{
					strValorActual=sri.getSriOriginal().getservicios_tar0().toString();
				}
				if(sri.getservicios_tar0()!=null)
				{
					strValorNuevo=sri.getservicios_tar0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.SERVICIOSTAR0,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getmonto_iva().equals(sri.getSriOriginal().getmonto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getmonto_iva()!=null)
				{
					strValorActual=sri.getSriOriginal().getmonto_iva().toString();
				}
				if(sri.getmonto_iva()!=null)
				{
					strValorNuevo=sri.getmonto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.MONTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getbase_impo_tar12().equals(sri.getSriOriginal().getbase_impo_tar12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getbase_impo_tar12()!=null)
				{
					strValorActual=sri.getSriOriginal().getbase_impo_tar12().toString();
				}
				if(sri.getbase_impo_tar12()!=null)
				{
					strValorNuevo=sri.getbase_impo_tar12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.BASEIMPOTAR12,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getbase_impo_tar0().equals(sri.getSriOriginal().getbase_impo_tar0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getbase_impo_tar0()!=null)
				{
					strValorActual=sri.getSriOriginal().getbase_impo_tar0().toString();
				}
				if(sri.getbase_impo_tar0()!=null)
				{
					strValorNuevo=sri.getbase_impo_tar0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.BASEIMPOTAR0,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getmonto_ice().equals(sri.getSriOriginal().getmonto_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getmonto_ice()!=null)
				{
					strValorActual=sri.getSriOriginal().getmonto_ice().toString();
				}
				if(sri.getmonto_ice()!=null)
				{
					strValorNuevo=sri.getmonto_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.MONTOICE,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getmonto_iva_bien().equals(sri.getSriOriginal().getmonto_iva_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getmonto_iva_bien()!=null)
				{
					strValorActual=sri.getSriOriginal().getmonto_iva_bien().toString();
				}
				if(sri.getmonto_iva_bien()!=null)
				{
					strValorNuevo=sri.getmonto_iva_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.MONTOIVABIEN,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getmonto_iva_servicio().equals(sri.getSriOriginal().getmonto_iva_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getmonto_iva_servicio()!=null)
				{
					strValorActual=sri.getSriOriginal().getmonto_iva_servicio().toString();
				}
				if(sri.getmonto_iva_servicio()!=null)
				{
					strValorNuevo=sri.getmonto_iva_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.MONTOIVASERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getid_tipo_retencion_iva_bien().equals(sri.getSriOriginal().getid_tipo_retencion_iva_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_tipo_retencion_iva_bien()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_tipo_retencion_iva_bien().toString();
				}
				if(sri.getid_tipo_retencion_iva_bien()!=null)
				{
					strValorNuevo=sri.getid_tipo_retencion_iva_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTIPORETENCIONIVABIEN,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getid_tipo_retencion_iva_servicio().equals(sri.getSriOriginal().getid_tipo_retencion_iva_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_tipo_retencion_iva_servicio()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_tipo_retencion_iva_servicio().toString();
				}
				if(sri.getid_tipo_retencion_iva_servicio()!=null)
				{
					strValorNuevo=sri.getid_tipo_retencion_iva_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getretencion_iva_bien().equals(sri.getSriOriginal().getretencion_iva_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getretencion_iva_bien()!=null)
				{
					strValorActual=sri.getSriOriginal().getretencion_iva_bien().toString();
				}
				if(sri.getretencion_iva_bien()!=null)
				{
					strValorNuevo=sri.getretencion_iva_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.RETENCIONIVABIEN,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getretencion_iva_servicio().equals(sri.getSriOriginal().getretencion_iva_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getretencion_iva_servicio()!=null)
				{
					strValorActual=sri.getSriOriginal().getretencion_iva_servicio().toString();
				}
				if(sri.getretencion_iva_servicio()!=null)
				{
					strValorNuevo=sri.getretencion_iva_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.RETENCIONIVASERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getcon_devolucion().equals(sri.getSriOriginal().getcon_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getcon_devolucion()!=null)
				{
					strValorActual=sri.getSriOriginal().getcon_devolucion().toString();
				}
				if(sri.getcon_devolucion()!=null)
				{
					strValorNuevo=sri.getcon_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.CONDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(sri.getIsNew()||!sri.getid_tipo_movimiento().equals(sri.getSriOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sri.getSriOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=sri.getSriOriginal().getid_tipo_movimiento().toString();
				}
				if(sri.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=sri.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SriConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSriRelacionesWithConnection(Sri sri) throws Exception {

		if(!sri.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSriRelacionesBase(sri,true);
		}
	}

	public void saveSriRelaciones(Sri sri)throws Exception {

		if(!sri.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSriRelacionesBase(sri,false);
		}
	}

	public void saveSriRelacionesBase(Sri sri,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Sri-saveRelacionesWithConnection");}
	

			this.setSri(sri);

			if(SriLogicAdditional.validarSaveRelaciones(sri,this)) {

				SriLogicAdditional.updateRelacionesToSave(sri,this);

				if((sri.getIsNew()||sri.getIsChanged())&&!sri.getIsDeleted()) {
					this.saveSri();
					this.saveSriRelacionesDetalles();

				} else if(sri.getIsDeleted()) {
					this.saveSriRelacionesDetalles();
					this.saveSri();
				}

				SriLogicAdditional.updateRelacionesToSaveAfter(sri,this);

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
	
	
	private void saveSriRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SriConstantesFunciones.getClassesForeignKeysOfSri(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SriConstantesFunciones.getClassesRelationshipsOfSri(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
