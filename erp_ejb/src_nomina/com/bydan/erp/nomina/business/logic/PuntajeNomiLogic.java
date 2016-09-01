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
import com.bydan.erp.nomina.util.PuntajeNomiConstantesFunciones;
import com.bydan.erp.nomina.util.PuntajeNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PuntajeNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.PuntajeNomi;
import com.bydan.erp.nomina.business.logic.PuntajeNomiLogicAdditional;
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
public class PuntajeNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PuntajeNomiLogic.class);
	
	protected PuntajeNomiDataAccess puntajenomiDataAccess; 	
	protected PuntajeNomi puntajenomi;
	protected List<PuntajeNomi> puntajenomis;
	protected Object puntajenomiObject;	
	protected List<Object> puntajenomisObject;
	
	public static ClassValidator<PuntajeNomi> puntajenomiValidator = new ClassValidator<PuntajeNomi>(PuntajeNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PuntajeNomiLogicAdditional puntajenomiLogicAdditional=null;
	
	public PuntajeNomiLogicAdditional getPuntajeNomiLogicAdditional() {
		return this.puntajenomiLogicAdditional;
	}
	
	public void setPuntajeNomiLogicAdditional(PuntajeNomiLogicAdditional puntajenomiLogicAdditional) {
		try {
			this.puntajenomiLogicAdditional=puntajenomiLogicAdditional;
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
	
	
	
	
	public  PuntajeNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.puntajenomiDataAccess = new PuntajeNomiDataAccess();
			
			this.puntajenomis= new ArrayList<PuntajeNomi>();
			this.puntajenomi= new PuntajeNomi();
			
			this.puntajenomiObject=new Object();
			this.puntajenomisObject=new ArrayList<Object>();
				
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
			
			this.puntajenomiDataAccess.setConnexionType(this.connexionType);
			this.puntajenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PuntajeNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.puntajenomiDataAccess = new PuntajeNomiDataAccess();
			this.puntajenomis= new ArrayList<PuntajeNomi>();
			this.puntajenomi= new PuntajeNomi();
			this.puntajenomiObject=new Object();
			this.puntajenomisObject=new ArrayList<Object>();
			
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
			
			this.puntajenomiDataAccess.setConnexionType(this.connexionType);
			this.puntajenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PuntajeNomi getPuntajeNomi() throws Exception {	
		PuntajeNomiLogicAdditional.checkPuntajeNomiToGet(puntajenomi,this.datosCliente,this.arrDatoGeneral);
		PuntajeNomiLogicAdditional.updatePuntajeNomiToGet(puntajenomi,this.arrDatoGeneral);
		
		return puntajenomi;
	}
		
	public void setPuntajeNomi(PuntajeNomi newPuntajeNomi) {
		this.puntajenomi = newPuntajeNomi;
	}
	
	public PuntajeNomiDataAccess getPuntajeNomiDataAccess() {
		return puntajenomiDataAccess;
	}
	
	public void setPuntajeNomiDataAccess(PuntajeNomiDataAccess newpuntajenomiDataAccess) {
		this.puntajenomiDataAccess = newpuntajenomiDataAccess;
	}
	
	public List<PuntajeNomi> getPuntajeNomis() throws Exception {		
		this.quitarPuntajeNomisNulos();
		
		PuntajeNomiLogicAdditional.checkPuntajeNomiToGets(puntajenomis,this.datosCliente,this.arrDatoGeneral);
		
		for (PuntajeNomi puntajenomiLocal: puntajenomis ) {
			PuntajeNomiLogicAdditional.updatePuntajeNomiToGet(puntajenomiLocal,this.arrDatoGeneral);
		}
		
		return puntajenomis;
	}
	
	public void setPuntajeNomis(List<PuntajeNomi> newPuntajeNomis) {
		this.puntajenomis = newPuntajeNomis;
	}
	
	public Object getPuntajeNomiObject() {	
		this.puntajenomiObject=this.puntajenomiDataAccess.getEntityObject();
		return this.puntajenomiObject;
	}
		
	public void setPuntajeNomiObject(Object newPuntajeNomiObject) {
		this.puntajenomiObject = newPuntajeNomiObject;
	}
	
	public List<Object> getPuntajeNomisObject() {		
		this.puntajenomisObject=this.puntajenomiDataAccess.getEntitiesObject();
		return this.puntajenomisObject;
	}
		
	public void setPuntajeNomisObject(List<Object> newPuntajeNomisObject) {
		this.puntajenomisObject = newPuntajeNomisObject;
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
		
		if(this.puntajenomiDataAccess!=null) {
			this.puntajenomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			puntajenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			puntajenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		puntajenomi = new  PuntajeNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			puntajenomi=puntajenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puntajenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
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
		puntajenomi = new  PuntajeNomi();
		  		  
        try {
			
			puntajenomi=puntajenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puntajenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		puntajenomi = new  PuntajeNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			puntajenomi=puntajenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puntajenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
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
		puntajenomi = new  PuntajeNomi();
		  		  
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
		puntajenomi = new  PuntajeNomi();
		  		  
        try {
			
			puntajenomi=puntajenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puntajenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		puntajenomi = new  PuntajeNomi();
		  		  
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
		puntajenomi = new  PuntajeNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =puntajenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		puntajenomi = new  PuntajeNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=puntajenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		puntajenomi = new  PuntajeNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =puntajenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		puntajenomi = new  PuntajeNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=puntajenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		puntajenomi = new  PuntajeNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =puntajenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		puntajenomi = new  PuntajeNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=puntajenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		puntajenomis = new  ArrayList<PuntajeNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
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
		puntajenomis = new  ArrayList<PuntajeNomi>();
		  		  
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
		puntajenomis = new  ArrayList<PuntajeNomi>();
		  		  
        try {			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		puntajenomis = new  ArrayList<PuntajeNomi>();
		  		  
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
		puntajenomis = new  ArrayList<PuntajeNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
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
		puntajenomis = new  ArrayList<PuntajeNomi>();
		  		  
        try {
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
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
		puntajenomis = new  ArrayList<PuntajeNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
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
		puntajenomis = new  ArrayList<PuntajeNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		puntajenomi = new  PuntajeNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomi=puntajenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
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
		puntajenomi = new  PuntajeNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomi=puntajenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuntajeNomi(puntajenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosPuntajeNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		puntajenomis = new  ArrayList<PuntajeNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-getTodosPuntajeNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
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
	
	public  void  getTodosPuntajeNomis(String sFinalQuery,Pagination pagination)throws Exception {
		puntajenomis = new  ArrayList<PuntajeNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puntajenomis=puntajenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPuntajeNomi(puntajenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPuntajeNomi(PuntajeNomi puntajenomi) throws Exception {
		Boolean estaValidado=false;
		
		if(puntajenomi.getIsNew() || puntajenomi.getIsChanged()) { 
			this.invalidValues = puntajenomiValidator.getInvalidValues(puntajenomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(puntajenomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPuntajeNomi(List<PuntajeNomi> PuntajeNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PuntajeNomi puntajenomiLocal:puntajenomis) {				
			estaValidadoObjeto=this.validarGuardarPuntajeNomi(puntajenomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPuntajeNomi(List<PuntajeNomi> PuntajeNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPuntajeNomi(puntajenomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPuntajeNomi(PuntajeNomi PuntajeNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPuntajeNomi(puntajenomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PuntajeNomi puntajenomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+puntajenomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PuntajeNomiConstantesFunciones.getPuntajeNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"puntajenomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PuntajeNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PuntajeNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePuntajeNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-savePuntajeNomiWithConnection");connexion.begin();			
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSave(this.puntajenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PuntajeNomiLogicAdditional.updatePuntajeNomiToSave(this.puntajenomi,this.arrDatoGeneral);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.puntajenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPuntajeNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPuntajeNomi(this.puntajenomi)) {
				PuntajeNomiDataAccess.save(this.puntajenomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.puntajenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSaveAfter(this.puntajenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPuntajeNomi();
			
			connexion.commit();			
			
			if(this.puntajenomi.getIsDeleted()) {
				this.puntajenomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePuntajeNomi()throws Exception {	
		try {	
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSave(this.puntajenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PuntajeNomiLogicAdditional.updatePuntajeNomiToSave(this.puntajenomi,this.arrDatoGeneral);
			
			PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.puntajenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPuntajeNomi(this.puntajenomi)) {			
				PuntajeNomiDataAccess.save(this.puntajenomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.puntajenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSaveAfter(this.puntajenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.puntajenomi.getIsDeleted()) {
				this.puntajenomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePuntajeNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-savePuntajeNomisWithConnection");connexion.begin();			
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSaves(puntajenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPuntajeNomis();
			
			Boolean validadoTodosPuntajeNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PuntajeNomi puntajenomiLocal:puntajenomis) {		
				if(puntajenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PuntajeNomiLogicAdditional.updatePuntajeNomiToSave(puntajenomiLocal,this.arrDatoGeneral);
	        	
				PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),puntajenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPuntajeNomi(puntajenomiLocal)) {
					PuntajeNomiDataAccess.save(puntajenomiLocal, connexion);				
				} else {
					validadoTodosPuntajeNomi=false;
				}
			}
			
			if(!validadoTodosPuntajeNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSavesAfter(puntajenomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPuntajeNomis();
			
			connexion.commit();		
			
			this.quitarPuntajeNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePuntajeNomis()throws Exception {				
		 try {	
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSaves(puntajenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPuntajeNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PuntajeNomi puntajenomiLocal:puntajenomis) {				
				if(puntajenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PuntajeNomiLogicAdditional.updatePuntajeNomiToSave(puntajenomiLocal,this.arrDatoGeneral);
	        	
				PuntajeNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),puntajenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPuntajeNomi(puntajenomiLocal)) {				
					PuntajeNomiDataAccess.save(puntajenomiLocal, connexion);				
				} else {
					validadoTodosPuntajeNomi=false;
				}
			}
			
			if(!validadoTodosPuntajeNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PuntajeNomiLogicAdditional.checkPuntajeNomiToSavesAfter(puntajenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPuntajeNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PuntajeNomiParameterReturnGeneral procesarAccionPuntajeNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PuntajeNomi> puntajenomis,PuntajeNomiParameterReturnGeneral puntajenomiParameterGeneral)throws Exception {
		 try {	
			PuntajeNomiParameterReturnGeneral puntajenomiReturnGeneral=new PuntajeNomiParameterReturnGeneral();
	
			PuntajeNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,puntajenomis,puntajenomiParameterGeneral,puntajenomiReturnGeneral);
			
			return puntajenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PuntajeNomiParameterReturnGeneral procesarAccionPuntajeNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PuntajeNomi> puntajenomis,PuntajeNomiParameterReturnGeneral puntajenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-procesarAccionPuntajeNomisWithConnection");connexion.begin();			
			
			PuntajeNomiParameterReturnGeneral puntajenomiReturnGeneral=new PuntajeNomiParameterReturnGeneral();
	
			PuntajeNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,puntajenomis,puntajenomiParameterGeneral,puntajenomiReturnGeneral);
			
			this.connexion.commit();
			
			return puntajenomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PuntajeNomiParameterReturnGeneral procesarEventosPuntajeNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PuntajeNomi> puntajenomis,PuntajeNomi puntajenomi,PuntajeNomiParameterReturnGeneral puntajenomiParameterGeneral,Boolean isEsNuevoPuntajeNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			PuntajeNomiParameterReturnGeneral puntajenomiReturnGeneral=new PuntajeNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				puntajenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PuntajeNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,puntajenomis,puntajenomi,puntajenomiParameterGeneral,puntajenomiReturnGeneral,isEsNuevoPuntajeNomi,clases);
			
			return puntajenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PuntajeNomiParameterReturnGeneral procesarEventosPuntajeNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PuntajeNomi> puntajenomis,PuntajeNomi puntajenomi,PuntajeNomiParameterReturnGeneral puntajenomiParameterGeneral,Boolean isEsNuevoPuntajeNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-procesarEventosPuntajeNomisWithConnection");connexion.begin();			
			
			PuntajeNomiParameterReturnGeneral puntajenomiReturnGeneral=new PuntajeNomiParameterReturnGeneral();
	
			puntajenomiReturnGeneral.setPuntajeNomi(puntajenomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				puntajenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PuntajeNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,puntajenomis,puntajenomi,puntajenomiParameterGeneral,puntajenomiReturnGeneral,isEsNuevoPuntajeNomi,clases);
			
			this.connexion.commit();
			
			return puntajenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PuntajeNomiParameterReturnGeneral procesarImportacionPuntajeNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PuntajeNomiParameterReturnGeneral puntajenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-procesarImportacionPuntajeNomisWithConnection");connexion.begin();			
			
			PuntajeNomiParameterReturnGeneral puntajenomiReturnGeneral=new PuntajeNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.puntajenomis=new ArrayList<PuntajeNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.puntajenomi=new PuntajeNomi();
				
				
				if(conColumnasBase) {this.puntajenomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.puntajenomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.puntajenomi.setnombre(arrColumnas[iColumn++]);
				
				this.puntajenomis.add(this.puntajenomi);
			}
			
			this.savePuntajeNomis();
			
			this.connexion.commit();
			
			puntajenomiReturnGeneral.setConRetornoEstaProcesado(true);
			puntajenomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return puntajenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPuntajeNomisEliminados() throws Exception {				
		
		List<PuntajeNomi> puntajenomisAux= new ArrayList<PuntajeNomi>();
		
		for(PuntajeNomi puntajenomi:puntajenomis) {
			if(!puntajenomi.getIsDeleted()) {
				puntajenomisAux.add(puntajenomi);
			}
		}
		
		puntajenomis=puntajenomisAux;
	}
	
	public void quitarPuntajeNomisNulos() throws Exception {				
		
		List<PuntajeNomi> puntajenomisAux= new ArrayList<PuntajeNomi>();
		
		for(PuntajeNomi puntajenomi : this.puntajenomis) {
			if(puntajenomi==null) {
				puntajenomisAux.add(puntajenomi);
			}
		}
		
		//this.puntajenomis=puntajenomisAux;
		
		this.puntajenomis.removeAll(puntajenomisAux);
	}
	
	public void getSetVersionRowPuntajeNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(puntajenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((puntajenomi.getIsDeleted() || (puntajenomi.getIsChanged()&&!puntajenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=puntajenomiDataAccess.getSetVersionRowPuntajeNomi(connexion,puntajenomi.getId());
				
				if(!puntajenomi.getVersionRow().equals(timestamp)) {	
					puntajenomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				puntajenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPuntajeNomi()throws Exception {	
		
		if(puntajenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((puntajenomi.getIsDeleted() || (puntajenomi.getIsChanged()&&!puntajenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=puntajenomiDataAccess.getSetVersionRowPuntajeNomi(connexion,puntajenomi.getId());
			
			try {							
				if(!puntajenomi.getVersionRow().equals(timestamp)) {	
					puntajenomi.setVersionRow(timestamp);
				}
				
				puntajenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPuntajeNomisWithConnection()throws Exception {	
		if(puntajenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PuntajeNomi puntajenomiAux:puntajenomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(puntajenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(puntajenomiAux.getIsDeleted() || (puntajenomiAux.getIsChanged()&&!puntajenomiAux.getIsNew())) {
						
						timestamp=puntajenomiDataAccess.getSetVersionRowPuntajeNomi(connexion,puntajenomiAux.getId());
						
						if(!puntajenomi.getVersionRow().equals(timestamp)) {	
							puntajenomiAux.setVersionRow(timestamp);
						}
								
						puntajenomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPuntajeNomis()throws Exception {	
		if(puntajenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PuntajeNomi puntajenomiAux:puntajenomis) {
					if(puntajenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(puntajenomiAux.getIsDeleted() || (puntajenomiAux.getIsChanged()&&!puntajenomiAux.getIsNew())) {
						
						timestamp=puntajenomiDataAccess.getSetVersionRowPuntajeNomi(connexion,puntajenomiAux.getId());
						
						if(!puntajenomiAux.getVersionRow().equals(timestamp)) {	
							puntajenomiAux.setVersionRow(timestamp);
						}
						
													
						puntajenomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyPuntajeNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PuntajeNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPuntajeNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormatoNomi.class));
											
			

			formatonomiLogic.setConnexion(this.getConnexion());
			formatonomiLogic.setDatosCliente(this.datosCliente);
			formatonomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PuntajeNomi puntajenomi:this.puntajenomis) {
				

				classes=new ArrayList<Classe>();
				classes=FormatoNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomiLogic.setFormatoNomis(puntajenomi.formatonomis);
				formatonomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(PuntajeNomi puntajenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PuntajeNomiLogicAdditional.updatePuntajeNomiToGet(puntajenomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		puntajenomi.setFormatoNomis(puntajenomiDataAccess.getFormatoNomis(connexion,puntajenomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puntajenomi.setFormatoNomis(puntajenomiDataAccess.getFormatoNomis(connexion,puntajenomi));

				if(this.isConDeep) {
					FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(this.connexion);
					formatonomiLogic.setFormatoNomis(puntajenomi.getFormatoNomis());
					ArrayList<Classe> classesLocal=FormatoNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(formatonomiLogic.getFormatoNomis());
					puntajenomi.setFormatoNomis(formatonomiLogic.getFormatoNomis());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomi.class));
			puntajenomi.setFormatoNomis(puntajenomiDataAccess.getFormatoNomis(connexion,puntajenomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		puntajenomi.setFormatoNomis(puntajenomiDataAccess.getFormatoNomis(connexion,puntajenomi));

		for(FormatoNomi formatonomi:puntajenomi.getFormatoNomis()) {
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomiLogic.deepLoad(formatonomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puntajenomi.setFormatoNomis(puntajenomiDataAccess.getFormatoNomis(connexion,puntajenomi));

				for(FormatoNomi formatonomi:puntajenomi.getFormatoNomis()) {
					FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
					formatonomiLogic.deepLoad(formatonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomi.class));
			puntajenomi.setFormatoNomis(puntajenomiDataAccess.getFormatoNomis(connexion,puntajenomi));

			for(FormatoNomi formatonomi:puntajenomi.getFormatoNomis()) {
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepLoad(formatonomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PuntajeNomi puntajenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PuntajeNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(puntajenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(puntajenomi);
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
			this.deepLoad(this.puntajenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(this.puntajenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PuntajeNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(puntajenomis!=null) {
				for(PuntajeNomi puntajenomi:puntajenomis) {
					this.deepLoad(puntajenomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(puntajenomis);
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
			if(puntajenomis!=null) {
				for(PuntajeNomi puntajenomi:puntajenomis) {
					this.deepLoad(puntajenomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PuntajeNomiConstantesFunciones.refrescarForeignKeysDescripcionesPuntajeNomi(puntajenomis);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PuntajeNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PuntajeNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PuntajeNomi puntajenomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PuntajeNomiConstantesFunciones.ISCONAUDITORIA) {
				if(puntajenomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PuntajeNomiDataAccess.TABLENAME, puntajenomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PuntajeNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PuntajeNomiLogic.registrarAuditoriaDetallesPuntajeNomi(connexion,puntajenomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(puntajenomi.getIsDeleted()) {
					/*if(!puntajenomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PuntajeNomiDataAccess.TABLENAME, puntajenomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PuntajeNomiLogic.registrarAuditoriaDetallesPuntajeNomi(connexion,puntajenomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PuntajeNomiDataAccess.TABLENAME, puntajenomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(puntajenomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PuntajeNomiDataAccess.TABLENAME, puntajenomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PuntajeNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PuntajeNomiLogic.registrarAuditoriaDetallesPuntajeNomi(connexion,puntajenomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPuntajeNomi(Connexion connexion,PuntajeNomi puntajenomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(puntajenomi.getIsNew()||!puntajenomi.getnombre().equals(puntajenomi.getPuntajeNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(puntajenomi.getPuntajeNomiOriginal().getnombre()!=null)
				{
					strValorActual=puntajenomi.getPuntajeNomiOriginal().getnombre();
				}
				if(puntajenomi.getnombre()!=null)
				{
					strValorNuevo=puntajenomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PuntajeNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPuntajeNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PuntajeNomiConstantesFunciones.getClassesForeignKeysOfPuntajeNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuntajeNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PuntajeNomiConstantesFunciones.getClassesRelationshipsOfPuntajeNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
