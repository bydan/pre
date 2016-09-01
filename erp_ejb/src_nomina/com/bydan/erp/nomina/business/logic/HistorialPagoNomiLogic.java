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
import com.bydan.erp.nomina.util.HistorialPagoNomiConstantesFunciones;
import com.bydan.erp.nomina.util.HistorialPagoNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HistorialPagoNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.HistorialPagoNomi;
import com.bydan.erp.nomina.business.logic.HistorialPagoNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class HistorialPagoNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HistorialPagoNomiLogic.class);
	
	protected HistorialPagoNomiDataAccess historialpagonomiDataAccess; 	
	protected HistorialPagoNomi historialpagonomi;
	protected List<HistorialPagoNomi> historialpagonomis;
	protected Object historialpagonomiObject;	
	protected List<Object> historialpagonomisObject;
	
	public static ClassValidator<HistorialPagoNomi> historialpagonomiValidator = new ClassValidator<HistorialPagoNomi>(HistorialPagoNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HistorialPagoNomiLogicAdditional historialpagonomiLogicAdditional=null;
	
	public HistorialPagoNomiLogicAdditional getHistorialPagoNomiLogicAdditional() {
		return this.historialpagonomiLogicAdditional;
	}
	
	public void setHistorialPagoNomiLogicAdditional(HistorialPagoNomiLogicAdditional historialpagonomiLogicAdditional) {
		try {
			this.historialpagonomiLogicAdditional=historialpagonomiLogicAdditional;
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
	
	
	
	
	public  HistorialPagoNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.historialpagonomiDataAccess = new HistorialPagoNomiDataAccess();
			
			this.historialpagonomis= new ArrayList<HistorialPagoNomi>();
			this.historialpagonomi= new HistorialPagoNomi();
			
			this.historialpagonomiObject=new Object();
			this.historialpagonomisObject=new ArrayList<Object>();
				
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
			
			this.historialpagonomiDataAccess.setConnexionType(this.connexionType);
			this.historialpagonomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HistorialPagoNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.historialpagonomiDataAccess = new HistorialPagoNomiDataAccess();
			this.historialpagonomis= new ArrayList<HistorialPagoNomi>();
			this.historialpagonomi= new HistorialPagoNomi();
			this.historialpagonomiObject=new Object();
			this.historialpagonomisObject=new ArrayList<Object>();
			
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
			
			this.historialpagonomiDataAccess.setConnexionType(this.connexionType);
			this.historialpagonomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HistorialPagoNomi getHistorialPagoNomi() throws Exception {	
		HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToGet(historialpagonomi,this.datosCliente,this.arrDatoGeneral);
		HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToGet(historialpagonomi,this.arrDatoGeneral);
		
		return historialpagonomi;
	}
		
	public void setHistorialPagoNomi(HistorialPagoNomi newHistorialPagoNomi) {
		this.historialpagonomi = newHistorialPagoNomi;
	}
	
	public HistorialPagoNomiDataAccess getHistorialPagoNomiDataAccess() {
		return historialpagonomiDataAccess;
	}
	
	public void setHistorialPagoNomiDataAccess(HistorialPagoNomiDataAccess newhistorialpagonomiDataAccess) {
		this.historialpagonomiDataAccess = newhistorialpagonomiDataAccess;
	}
	
	public List<HistorialPagoNomi> getHistorialPagoNomis() throws Exception {		
		this.quitarHistorialPagoNomisNulos();
		
		HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToGets(historialpagonomis,this.datosCliente,this.arrDatoGeneral);
		
		for (HistorialPagoNomi historialpagonomiLocal: historialpagonomis ) {
			HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToGet(historialpagonomiLocal,this.arrDatoGeneral);
		}
		
		return historialpagonomis;
	}
	
	public void setHistorialPagoNomis(List<HistorialPagoNomi> newHistorialPagoNomis) {
		this.historialpagonomis = newHistorialPagoNomis;
	}
	
	public Object getHistorialPagoNomiObject() {	
		this.historialpagonomiObject=this.historialpagonomiDataAccess.getEntityObject();
		return this.historialpagonomiObject;
	}
		
	public void setHistorialPagoNomiObject(Object newHistorialPagoNomiObject) {
		this.historialpagonomiObject = newHistorialPagoNomiObject;
	}
	
	public List<Object> getHistorialPagoNomisObject() {		
		this.historialpagonomisObject=this.historialpagonomiDataAccess.getEntitiesObject();
		return this.historialpagonomisObject;
	}
		
	public void setHistorialPagoNomisObject(List<Object> newHistorialPagoNomisObject) {
		this.historialpagonomisObject = newHistorialPagoNomisObject;
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
		
		if(this.historialpagonomiDataAccess!=null) {
			this.historialpagonomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			historialpagonomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			historialpagonomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		historialpagonomi = new  HistorialPagoNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialpagonomi=historialpagonomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
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
		historialpagonomi = new  HistorialPagoNomi();
		  		  
        try {
			
			historialpagonomi=historialpagonomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		historialpagonomi = new  HistorialPagoNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialpagonomi=historialpagonomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
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
		historialpagonomi = new  HistorialPagoNomi();
		  		  
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
		historialpagonomi = new  HistorialPagoNomi();
		  		  
        try {
			
			historialpagonomi=historialpagonomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		historialpagonomi = new  HistorialPagoNomi();
		  		  
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
		historialpagonomi = new  HistorialPagoNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =historialpagonomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialpagonomi = new  HistorialPagoNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=historialpagonomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialpagonomi = new  HistorialPagoNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =historialpagonomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialpagonomi = new  HistorialPagoNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=historialpagonomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialpagonomi = new  HistorialPagoNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =historialpagonomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialpagonomi = new  HistorialPagoNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=historialpagonomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
        try {			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
        try {
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		historialpagonomi = new  HistorialPagoNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomi=historialpagonomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
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
		historialpagonomi = new  HistorialPagoNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomi=historialpagonomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		  		  
        try {
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHistorialPagoNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getTodosHistorialPagoNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
	
	public  void  getTodosHistorialPagoNomis(String sFinalQuery,Pagination pagination)throws Exception {
		historialpagonomis = new  ArrayList<HistorialPagoNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialPagoNomi(historialpagonomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHistorialPagoNomi(HistorialPagoNomi historialpagonomi) throws Exception {
		Boolean estaValidado=false;
		
		if(historialpagonomi.getIsNew() || historialpagonomi.getIsChanged()) { 
			this.invalidValues = historialpagonomiValidator.getInvalidValues(historialpagonomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(historialpagonomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHistorialPagoNomi(List<HistorialPagoNomi> HistorialPagoNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(HistorialPagoNomi historialpagonomiLocal:historialpagonomis) {				
			estaValidadoObjeto=this.validarGuardarHistorialPagoNomi(historialpagonomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHistorialPagoNomi(List<HistorialPagoNomi> HistorialPagoNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialPagoNomi(historialpagonomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHistorialPagoNomi(HistorialPagoNomi HistorialPagoNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialPagoNomi(historialpagonomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(HistorialPagoNomi historialpagonomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+historialpagonomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HistorialPagoNomiConstantesFunciones.getHistorialPagoNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"historialpagonomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HistorialPagoNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HistorialPagoNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHistorialPagoNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-saveHistorialPagoNomiWithConnection");connexion.begin();			
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSave(this.historialpagonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToSave(this.historialpagonomi,this.arrDatoGeneral);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialpagonomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHistorialPagoNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialPagoNomi(this.historialpagonomi)) {
				HistorialPagoNomiDataAccess.save(this.historialpagonomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.historialpagonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSaveAfter(this.historialpagonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialPagoNomi();
			
			connexion.commit();			
			
			if(this.historialpagonomi.getIsDeleted()) {
				this.historialpagonomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHistorialPagoNomi()throws Exception {	
		try {	
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSave(this.historialpagonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToSave(this.historialpagonomi,this.arrDatoGeneral);
			
			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialpagonomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialPagoNomi(this.historialpagonomi)) {			
				HistorialPagoNomiDataAccess.save(this.historialpagonomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.historialpagonomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSaveAfter(this.historialpagonomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.historialpagonomi.getIsDeleted()) {
				this.historialpagonomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHistorialPagoNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-saveHistorialPagoNomisWithConnection");connexion.begin();			
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSaves(historialpagonomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHistorialPagoNomis();
			
			Boolean validadoTodosHistorialPagoNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialPagoNomi historialpagonomiLocal:historialpagonomis) {		
				if(historialpagonomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToSave(historialpagonomiLocal,this.arrDatoGeneral);
	        	
				HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialpagonomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialPagoNomi(historialpagonomiLocal)) {
					HistorialPagoNomiDataAccess.save(historialpagonomiLocal, connexion);				
				} else {
					validadoTodosHistorialPagoNomi=false;
				}
			}
			
			if(!validadoTodosHistorialPagoNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSavesAfter(historialpagonomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialPagoNomis();
			
			connexion.commit();		
			
			this.quitarHistorialPagoNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHistorialPagoNomis()throws Exception {				
		 try {	
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSaves(historialpagonomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHistorialPagoNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialPagoNomi historialpagonomiLocal:historialpagonomis) {				
				if(historialpagonomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToSave(historialpagonomiLocal,this.arrDatoGeneral);
	        	
				HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialpagonomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialPagoNomi(historialpagonomiLocal)) {				
					HistorialPagoNomiDataAccess.save(historialpagonomiLocal, connexion);				
				} else {
					validadoTodosHistorialPagoNomi=false;
				}
			}
			
			if(!validadoTodosHistorialPagoNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialPagoNomiLogicAdditional.checkHistorialPagoNomiToSavesAfter(historialpagonomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHistorialPagoNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialPagoNomiParameterReturnGeneral procesarAccionHistorialPagoNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomiParameterReturnGeneral historialpagonomiParameterGeneral)throws Exception {
		 try {	
			HistorialPagoNomiParameterReturnGeneral historialpagonomiReturnGeneral=new HistorialPagoNomiParameterReturnGeneral();
	
			HistorialPagoNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialpagonomis,historialpagonomiParameterGeneral,historialpagonomiReturnGeneral);
			
			return historialpagonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialPagoNomiParameterReturnGeneral procesarAccionHistorialPagoNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomiParameterReturnGeneral historialpagonomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-procesarAccionHistorialPagoNomisWithConnection");connexion.begin();			
			
			HistorialPagoNomiParameterReturnGeneral historialpagonomiReturnGeneral=new HistorialPagoNomiParameterReturnGeneral();
	
			HistorialPagoNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialpagonomis,historialpagonomiParameterGeneral,historialpagonomiReturnGeneral);
			
			this.connexion.commit();
			
			return historialpagonomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialPagoNomiParameterReturnGeneral procesarEventosHistorialPagoNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomi historialpagonomi,HistorialPagoNomiParameterReturnGeneral historialpagonomiParameterGeneral,Boolean isEsNuevoHistorialPagoNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			HistorialPagoNomiParameterReturnGeneral historialpagonomiReturnGeneral=new HistorialPagoNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialpagonomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialPagoNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialpagonomis,historialpagonomi,historialpagonomiParameterGeneral,historialpagonomiReturnGeneral,isEsNuevoHistorialPagoNomi,clases);
			
			return historialpagonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HistorialPagoNomiParameterReturnGeneral procesarEventosHistorialPagoNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomi historialpagonomi,HistorialPagoNomiParameterReturnGeneral historialpagonomiParameterGeneral,Boolean isEsNuevoHistorialPagoNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-procesarEventosHistorialPagoNomisWithConnection");connexion.begin();			
			
			HistorialPagoNomiParameterReturnGeneral historialpagonomiReturnGeneral=new HistorialPagoNomiParameterReturnGeneral();
	
			historialpagonomiReturnGeneral.setHistorialPagoNomi(historialpagonomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialpagonomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialPagoNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialpagonomis,historialpagonomi,historialpagonomiParameterGeneral,historialpagonomiReturnGeneral,isEsNuevoHistorialPagoNomi,clases);
			
			this.connexion.commit();
			
			return historialpagonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialPagoNomiParameterReturnGeneral procesarImportacionHistorialPagoNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HistorialPagoNomiParameterReturnGeneral historialpagonomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-procesarImportacionHistorialPagoNomisWithConnection");connexion.begin();			
			
			HistorialPagoNomiParameterReturnGeneral historialpagonomiReturnGeneral=new HistorialPagoNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.historialpagonomis=new ArrayList<HistorialPagoNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.historialpagonomi=new HistorialPagoNomi();
				
				
				if(conColumnasBase) {this.historialpagonomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.historialpagonomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.historialpagonomi.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.historialpagonomi.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.historialpagonomi.setfecha_liquidacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.historialpagonomis.add(this.historialpagonomi);
			}
			
			this.saveHistorialPagoNomis();
			
			this.connexion.commit();
			
			historialpagonomiReturnGeneral.setConRetornoEstaProcesado(true);
			historialpagonomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return historialpagonomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHistorialPagoNomisEliminados() throws Exception {				
		
		List<HistorialPagoNomi> historialpagonomisAux= new ArrayList<HistorialPagoNomi>();
		
		for(HistorialPagoNomi historialpagonomi:historialpagonomis) {
			if(!historialpagonomi.getIsDeleted()) {
				historialpagonomisAux.add(historialpagonomi);
			}
		}
		
		historialpagonomis=historialpagonomisAux;
	}
	
	public void quitarHistorialPagoNomisNulos() throws Exception {				
		
		List<HistorialPagoNomi> historialpagonomisAux= new ArrayList<HistorialPagoNomi>();
		
		for(HistorialPagoNomi historialpagonomi : this.historialpagonomis) {
			if(historialpagonomi==null) {
				historialpagonomisAux.add(historialpagonomi);
			}
		}
		
		//this.historialpagonomis=historialpagonomisAux;
		
		this.historialpagonomis.removeAll(historialpagonomisAux);
	}
	
	public void getSetVersionRowHistorialPagoNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(historialpagonomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((historialpagonomi.getIsDeleted() || (historialpagonomi.getIsChanged()&&!historialpagonomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=historialpagonomiDataAccess.getSetVersionRowHistorialPagoNomi(connexion,historialpagonomi.getId());
				
				if(!historialpagonomi.getVersionRow().equals(timestamp)) {	
					historialpagonomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				historialpagonomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHistorialPagoNomi()throws Exception {	
		
		if(historialpagonomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((historialpagonomi.getIsDeleted() || (historialpagonomi.getIsChanged()&&!historialpagonomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=historialpagonomiDataAccess.getSetVersionRowHistorialPagoNomi(connexion,historialpagonomi.getId());
			
			try {							
				if(!historialpagonomi.getVersionRow().equals(timestamp)) {	
					historialpagonomi.setVersionRow(timestamp);
				}
				
				historialpagonomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHistorialPagoNomisWithConnection()throws Exception {	
		if(historialpagonomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(HistorialPagoNomi historialpagonomiAux:historialpagonomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(historialpagonomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialpagonomiAux.getIsDeleted() || (historialpagonomiAux.getIsChanged()&&!historialpagonomiAux.getIsNew())) {
						
						timestamp=historialpagonomiDataAccess.getSetVersionRowHistorialPagoNomi(connexion,historialpagonomiAux.getId());
						
						if(!historialpagonomi.getVersionRow().equals(timestamp)) {	
							historialpagonomiAux.setVersionRow(timestamp);
						}
								
						historialpagonomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHistorialPagoNomis()throws Exception {	
		if(historialpagonomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(HistorialPagoNomi historialpagonomiAux:historialpagonomis) {
					if(historialpagonomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialpagonomiAux.getIsDeleted() || (historialpagonomiAux.getIsChanged()&&!historialpagonomiAux.getIsNew())) {
						
						timestamp=historialpagonomiDataAccess.getSetVersionRowHistorialPagoNomi(connexion,historialpagonomiAux.getId());
						
						if(!historialpagonomiAux.getVersionRow().equals(timestamp)) {	
							historialpagonomiAux.setVersionRow(timestamp);
						}
						
													
						historialpagonomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HistorialPagoNomiParameterReturnGeneral cargarCombosLoteForeignKeyHistorialPagoNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea,String finalQueryGlobalMes) throws Exception {
		HistorialPagoNomiParameterReturnGeneral  historialpagonomiReturnGeneral =new HistorialPagoNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyHistorialPagoNomiWithConnection");connexion.begin();
			
			historialpagonomiReturnGeneral =new HistorialPagoNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialpagonomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			historialpagonomiReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			historialpagonomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			historialpagonomiReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			historialpagonomiReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return historialpagonomiReturnGeneral;
	}
	
	public HistorialPagoNomiParameterReturnGeneral cargarCombosLoteForeignKeyHistorialPagoNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea,String finalQueryGlobalMes) throws Exception {
		HistorialPagoNomiParameterReturnGeneral  historialpagonomiReturnGeneral =new HistorialPagoNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			historialpagonomiReturnGeneral =new HistorialPagoNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialpagonomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			historialpagonomiReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			historialpagonomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			historialpagonomiReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			historialpagonomiReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return historialpagonomiReturnGeneral;
	}
	
	
	public void deepLoad(HistorialPagoNomi historialpagonomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToGet(historialpagonomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialpagonomi.setEmpresa(historialpagonomiDataAccess.getEmpresa(connexion,historialpagonomi));
		historialpagonomi.setEstructura(historialpagonomiDataAccess.getEstructura(connexion,historialpagonomi));
		historialpagonomi.setEmpleado(historialpagonomiDataAccess.getEmpleado(connexion,historialpagonomi));
		historialpagonomi.setRubroEmplea(historialpagonomiDataAccess.getRubroEmplea(connexion,historialpagonomi));
		historialpagonomi.setMes(historialpagonomiDataAccess.getMes(connexion,historialpagonomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialpagonomi.setEmpresa(historialpagonomiDataAccess.getEmpresa(connexion,historialpagonomi));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				historialpagonomi.setEstructura(historialpagonomiDataAccess.getEstructura(connexion,historialpagonomi));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				historialpagonomi.setEmpleado(historialpagonomiDataAccess.getEmpleado(connexion,historialpagonomi));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				historialpagonomi.setRubroEmplea(historialpagonomiDataAccess.getRubroEmplea(connexion,historialpagonomi));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				historialpagonomi.setMes(historialpagonomiDataAccess.getMes(connexion,historialpagonomi));
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
			historialpagonomi.setEmpresa(historialpagonomiDataAccess.getEmpresa(connexion,historialpagonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setEstructura(historialpagonomiDataAccess.getEstructura(connexion,historialpagonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setEmpleado(historialpagonomiDataAccess.getEmpleado(connexion,historialpagonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setRubroEmplea(historialpagonomiDataAccess.getRubroEmplea(connexion,historialpagonomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setMes(historialpagonomiDataAccess.getMes(connexion,historialpagonomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialpagonomi.setEmpresa(historialpagonomiDataAccess.getEmpresa(connexion,historialpagonomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialpagonomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		historialpagonomi.setEstructura(historialpagonomiDataAccess.getEstructura(connexion,historialpagonomi));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(historialpagonomi.getEstructura(),isDeep,deepLoadType,clases);
				
		historialpagonomi.setEmpleado(historialpagonomiDataAccess.getEmpleado(connexion,historialpagonomi));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(historialpagonomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		historialpagonomi.setRubroEmplea(historialpagonomiDataAccess.getRubroEmplea(connexion,historialpagonomi));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(historialpagonomi.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		historialpagonomi.setMes(historialpagonomiDataAccess.getMes(connexion,historialpagonomi));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(historialpagonomi.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialpagonomi.setEmpresa(historialpagonomiDataAccess.getEmpresa(connexion,historialpagonomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(historialpagonomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				historialpagonomi.setEstructura(historialpagonomiDataAccess.getEstructura(connexion,historialpagonomi));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(historialpagonomi.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				historialpagonomi.setEmpleado(historialpagonomiDataAccess.getEmpleado(connexion,historialpagonomi));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(historialpagonomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				historialpagonomi.setRubroEmplea(historialpagonomiDataAccess.getRubroEmplea(connexion,historialpagonomi));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(historialpagonomi.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				historialpagonomi.setMes(historialpagonomiDataAccess.getMes(connexion,historialpagonomi));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(historialpagonomi.getMes(),isDeep,deepLoadType,clases);				
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
			historialpagonomi.setEmpresa(historialpagonomiDataAccess.getEmpresa(connexion,historialpagonomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(historialpagonomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setEstructura(historialpagonomiDataAccess.getEstructura(connexion,historialpagonomi));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(historialpagonomi.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setEmpleado(historialpagonomiDataAccess.getEmpleado(connexion,historialpagonomi));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(historialpagonomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setRubroEmplea(historialpagonomiDataAccess.getRubroEmplea(connexion,historialpagonomi));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(historialpagonomi.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagonomi.setMes(historialpagonomiDataAccess.getMes(connexion,historialpagonomi));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(historialpagonomi.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(HistorialPagoNomi historialpagonomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HistorialPagoNomiLogicAdditional.updateHistorialPagoNomiToSave(historialpagonomi,this.arrDatoGeneral);
			
HistorialPagoNomiDataAccess.save(historialpagonomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(historialpagonomi.getEmpresa(),connexion);

		EstructuraDataAccess.save(historialpagonomi.getEstructura(),connexion);

		EmpleadoDataAccess.save(historialpagonomi.getEmpleado(),connexion);

		RubroEmpleaDataAccess.save(historialpagonomi.getRubroEmplea(),connexion);

		MesDataAccess.save(historialpagonomi.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialpagonomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(historialpagonomi.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(historialpagonomi.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(historialpagonomi.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(historialpagonomi.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(historialpagonomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialpagonomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(historialpagonomi.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(historialpagonomi.getEstructura(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(historialpagonomi.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(historialpagonomi.getEmpleado(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(historialpagonomi.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(historialpagonomi.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(historialpagonomi.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(historialpagonomi.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialpagonomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(historialpagonomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(historialpagonomi.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(historialpagonomi.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(historialpagonomi.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(historialpagonomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(historialpagonomi.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(historialpagonomi.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(historialpagonomi.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(historialpagonomi.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(HistorialPagoNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(historialpagonomi);
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
			this.deepLoad(this.historialpagonomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(HistorialPagoNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(historialpagonomis!=null) {
				for(HistorialPagoNomi historialpagonomi:historialpagonomis) {
					this.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(historialpagonomis);
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
			if(historialpagonomis!=null) {
				for(HistorialPagoNomi historialpagonomi:historialpagonomis) {
					this.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(historialpagonomis);
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
			this.getNewConnexionToDeep(HistorialPagoNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(historialpagonomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(HistorialPagoNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(historialpagonomis!=null) {
				for(HistorialPagoNomi historialpagonomi:historialpagonomis) {
					this.deepSave(historialpagonomi,isDeep,deepLoadType,clases);
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
			if(historialpagonomis!=null) {
				for(HistorialPagoNomi historialpagonomi:historialpagonomis) {
					this.deepSave(historialpagonomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHistorialPagoNomisFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,HistorialPagoNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoNomisFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,HistorialPagoNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialPagoNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialPagoNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoNomisFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,HistorialPagoNomiConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoNomisFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,HistorialPagoNomiConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoNomisFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,HistorialPagoNomiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoNomisFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,HistorialPagoNomiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoNomisFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoNomisFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			HistorialPagoNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(this.historialpagonomis);
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
			if(HistorialPagoNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,HistorialPagoNomi historialpagonomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HistorialPagoNomiConstantesFunciones.ISCONAUDITORIA) {
				if(historialpagonomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoNomiDataAccess.TABLENAME, historialpagonomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialPagoNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialPagoNomiLogic.registrarAuditoriaDetallesHistorialPagoNomi(connexion,historialpagonomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(historialpagonomi.getIsDeleted()) {
					/*if(!historialpagonomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HistorialPagoNomiDataAccess.TABLENAME, historialpagonomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HistorialPagoNomiLogic.registrarAuditoriaDetallesHistorialPagoNomi(connexion,historialpagonomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoNomiDataAccess.TABLENAME, historialpagonomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(historialpagonomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoNomiDataAccess.TABLENAME, historialpagonomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialPagoNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialPagoNomiLogic.registrarAuditoriaDetallesHistorialPagoNomi(connexion,historialpagonomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHistorialPagoNomi(Connexion connexion,HistorialPagoNomi historialpagonomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getid_empresa().equals(historialpagonomi.getHistorialPagoNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getid_empresa().toString();
				}
				if(historialpagonomi.getid_empresa()!=null)
				{
					strValorNuevo=historialpagonomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getid_estructura().equals(historialpagonomi.getHistorialPagoNomiOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getid_estructura()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getid_estructura().toString();
				}
				if(historialpagonomi.getid_estructura()!=null)
				{
					strValorNuevo=historialpagonomi.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getid_empleado().equals(historialpagonomi.getHistorialPagoNomiOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getid_empleado()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getid_empleado().toString();
				}
				if(historialpagonomi.getid_empleado()!=null)
				{
					strValorNuevo=historialpagonomi.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getid_rubro_emplea().equals(historialpagonomi.getHistorialPagoNomiOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getid_rubro_emplea().toString();
				}
				if(historialpagonomi.getid_rubro_emplea()!=null)
				{
					strValorNuevo=historialpagonomi.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getid_mes().equals(historialpagonomi.getHistorialPagoNomiOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getid_mes()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getid_mes().toString();
				}
				if(historialpagonomi.getid_mes()!=null)
				{
					strValorNuevo=historialpagonomi.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getvalor().equals(historialpagonomi.getHistorialPagoNomiOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getvalor()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getvalor().toString();
				}
				if(historialpagonomi.getvalor()!=null)
				{
					strValorNuevo=historialpagonomi.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getfecha().equals(historialpagonomi.getHistorialPagoNomiOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getfecha()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getfecha().toString();
				}
				if(historialpagonomi.getfecha()!=null)
				{
					strValorNuevo=historialpagonomi.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(historialpagonomi.getIsNew()||!historialpagonomi.getfecha_liquidacion().equals(historialpagonomi.getHistorialPagoNomiOriginal().getfecha_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagonomi.getHistorialPagoNomiOriginal().getfecha_liquidacion()!=null)
				{
					strValorActual=historialpagonomi.getHistorialPagoNomiOriginal().getfecha_liquidacion().toString();
				}
				if(historialpagonomi.getfecha_liquidacion()!=null)
				{
					strValorNuevo=historialpagonomi.getfecha_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHistorialPagoNomiRelacionesWithConnection(HistorialPagoNomi historialpagonomi) throws Exception {

		if(!historialpagonomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialPagoNomiRelacionesBase(historialpagonomi,true);
		}
	}

	public void saveHistorialPagoNomiRelaciones(HistorialPagoNomi historialpagonomi)throws Exception {

		if(!historialpagonomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialPagoNomiRelacionesBase(historialpagonomi,false);
		}
	}

	public void saveHistorialPagoNomiRelacionesBase(HistorialPagoNomi historialpagonomi,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("HistorialPagoNomi-saveRelacionesWithConnection");}
	

			this.setHistorialPagoNomi(historialpagonomi);

			if(HistorialPagoNomiLogicAdditional.validarSaveRelaciones(historialpagonomi,this)) {

				HistorialPagoNomiLogicAdditional.updateRelacionesToSave(historialpagonomi,this);

				if((historialpagonomi.getIsNew()||historialpagonomi.getIsChanged())&&!historialpagonomi.getIsDeleted()) {
					this.saveHistorialPagoNomi();
					this.saveHistorialPagoNomiRelacionesDetalles();

				} else if(historialpagonomi.getIsDeleted()) {
					this.saveHistorialPagoNomiRelacionesDetalles();
					this.saveHistorialPagoNomi();
				}

				HistorialPagoNomiLogicAdditional.updateRelacionesToSaveAfter(historialpagonomi,this);

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
	
	
	private void saveHistorialPagoNomiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialPagoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialPagoNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialPagoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialPagoNomiConstantesFunciones.getClassesRelationshipsOfHistorialPagoNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
