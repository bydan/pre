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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.CargaFamiliarConstantesFunciones;
import com.bydan.erp.cartera.util.CargaFamiliarParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CargaFamiliarParameterGeneral;
import com.bydan.erp.cartera.business.entity.CargaFamiliar;
import com.bydan.erp.cartera.business.logic.CargaFamiliarLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class CargaFamiliarLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CargaFamiliarLogic.class);
	
	protected CargaFamiliarDataAccess cargafamiliarDataAccess; 	
	protected CargaFamiliar cargafamiliar;
	protected List<CargaFamiliar> cargafamiliars;
	protected Object cargafamiliarObject;	
	protected List<Object> cargafamiliarsObject;
	
	public static ClassValidator<CargaFamiliar> cargafamiliarValidator = new ClassValidator<CargaFamiliar>(CargaFamiliar.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CargaFamiliarLogicAdditional cargafamiliarLogicAdditional=null;
	
	public CargaFamiliarLogicAdditional getCargaFamiliarLogicAdditional() {
		return this.cargafamiliarLogicAdditional;
	}
	
	public void setCargaFamiliarLogicAdditional(CargaFamiliarLogicAdditional cargafamiliarLogicAdditional) {
		try {
			this.cargafamiliarLogicAdditional=cargafamiliarLogicAdditional;
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
	
	
	
	
	public  CargaFamiliarLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cargafamiliarDataAccess = new CargaFamiliarDataAccess();
			
			this.cargafamiliars= new ArrayList<CargaFamiliar>();
			this.cargafamiliar= new CargaFamiliar();
			
			this.cargafamiliarObject=new Object();
			this.cargafamiliarsObject=new ArrayList<Object>();
				
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
			
			this.cargafamiliarDataAccess.setConnexionType(this.connexionType);
			this.cargafamiliarDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CargaFamiliarLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cargafamiliarDataAccess = new CargaFamiliarDataAccess();
			this.cargafamiliars= new ArrayList<CargaFamiliar>();
			this.cargafamiliar= new CargaFamiliar();
			this.cargafamiliarObject=new Object();
			this.cargafamiliarsObject=new ArrayList<Object>();
			
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
			
			this.cargafamiliarDataAccess.setConnexionType(this.connexionType);
			this.cargafamiliarDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CargaFamiliar getCargaFamiliar() throws Exception {	
		CargaFamiliarLogicAdditional.checkCargaFamiliarToGet(cargafamiliar,this.datosCliente,this.arrDatoGeneral);
		CargaFamiliarLogicAdditional.updateCargaFamiliarToGet(cargafamiliar,this.arrDatoGeneral);
		
		return cargafamiliar;
	}
		
	public void setCargaFamiliar(CargaFamiliar newCargaFamiliar) {
		this.cargafamiliar = newCargaFamiliar;
	}
	
	public CargaFamiliarDataAccess getCargaFamiliarDataAccess() {
		return cargafamiliarDataAccess;
	}
	
	public void setCargaFamiliarDataAccess(CargaFamiliarDataAccess newcargafamiliarDataAccess) {
		this.cargafamiliarDataAccess = newcargafamiliarDataAccess;
	}
	
	public List<CargaFamiliar> getCargaFamiliars() throws Exception {		
		this.quitarCargaFamiliarsNulos();
		
		CargaFamiliarLogicAdditional.checkCargaFamiliarToGets(cargafamiliars,this.datosCliente,this.arrDatoGeneral);
		
		for (CargaFamiliar cargafamiliarLocal: cargafamiliars ) {
			CargaFamiliarLogicAdditional.updateCargaFamiliarToGet(cargafamiliarLocal,this.arrDatoGeneral);
		}
		
		return cargafamiliars;
	}
	
	public void setCargaFamiliars(List<CargaFamiliar> newCargaFamiliars) {
		this.cargafamiliars = newCargaFamiliars;
	}
	
	public Object getCargaFamiliarObject() {	
		this.cargafamiliarObject=this.cargafamiliarDataAccess.getEntityObject();
		return this.cargafamiliarObject;
	}
		
	public void setCargaFamiliarObject(Object newCargaFamiliarObject) {
		this.cargafamiliarObject = newCargaFamiliarObject;
	}
	
	public List<Object> getCargaFamiliarsObject() {		
		this.cargafamiliarsObject=this.cargafamiliarDataAccess.getEntitiesObject();
		return this.cargafamiliarsObject;
	}
		
	public void setCargaFamiliarsObject(List<Object> newCargaFamiliarsObject) {
		this.cargafamiliarsObject = newCargaFamiliarsObject;
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
		
		if(this.cargafamiliarDataAccess!=null) {
			this.cargafamiliarDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cargafamiliarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cargafamiliarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cargafamiliar = new  CargaFamiliar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargafamiliar=cargafamiliarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
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
		cargafamiliar = new  CargaFamiliar();
		  		  
        try {
			
			cargafamiliar=cargafamiliarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cargafamiliar = new  CargaFamiliar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargafamiliar=cargafamiliarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
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
		cargafamiliar = new  CargaFamiliar();
		  		  
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
		cargafamiliar = new  CargaFamiliar();
		  		  
        try {
			
			cargafamiliar=cargafamiliarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cargafamiliar = new  CargaFamiliar();
		  		  
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
		cargafamiliar = new  CargaFamiliar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cargafamiliarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargafamiliar = new  CargaFamiliar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cargafamiliarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargafamiliar = new  CargaFamiliar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cargafamiliarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargafamiliar = new  CargaFamiliar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cargafamiliarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargafamiliar = new  CargaFamiliar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cargafamiliarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargafamiliar = new  CargaFamiliar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cargafamiliarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
        try {			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
        try {
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cargafamiliar = new  CargaFamiliar();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar=cargafamiliarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
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
		cargafamiliar = new  CargaFamiliar();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar=cargafamiliarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		  		  
        try {
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCargaFamiliarsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getTodosCargaFamiliarsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
	
	public  void  getTodosCargaFamiliars(String sFinalQuery,Pagination pagination)throws Exception {
		cargafamiliars = new  ArrayList<CargaFamiliar>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargaFamiliar(cargafamiliars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCargaFamiliar(CargaFamiliar cargafamiliar) throws Exception {
		Boolean estaValidado=false;
		
		if(cargafamiliar.getIsNew() || cargafamiliar.getIsChanged()) { 
			this.invalidValues = cargafamiliarValidator.getInvalidValues(cargafamiliar);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cargafamiliar);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCargaFamiliar(List<CargaFamiliar> CargaFamiliars) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CargaFamiliar cargafamiliarLocal:cargafamiliars) {				
			estaValidadoObjeto=this.validarGuardarCargaFamiliar(cargafamiliarLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCargaFamiliar(List<CargaFamiliar> CargaFamiliars) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargaFamiliar(cargafamiliars)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCargaFamiliar(CargaFamiliar CargaFamiliar) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargaFamiliar(cargafamiliar)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CargaFamiliar cargafamiliar) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cargafamiliar.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CargaFamiliarConstantesFunciones.getCargaFamiliarLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cargafamiliar","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CargaFamiliarConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CargaFamiliarConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCargaFamiliarWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-saveCargaFamiliarWithConnection");connexion.begin();			
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSave(this.cargafamiliar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargaFamiliarLogicAdditional.updateCargaFamiliarToSave(this.cargafamiliar,this.arrDatoGeneral);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargafamiliar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCargaFamiliar();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargaFamiliar(this.cargafamiliar)) {
				CargaFamiliarDataAccess.save(this.cargafamiliar, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cargafamiliar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSaveAfter(this.cargafamiliar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargaFamiliar();
			
			connexion.commit();			
			
			if(this.cargafamiliar.getIsDeleted()) {
				this.cargafamiliar=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCargaFamiliar()throws Exception {	
		try {	
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSave(this.cargafamiliar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargaFamiliarLogicAdditional.updateCargaFamiliarToSave(this.cargafamiliar,this.arrDatoGeneral);
			
			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargafamiliar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargaFamiliar(this.cargafamiliar)) {			
				CargaFamiliarDataAccess.save(this.cargafamiliar, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cargafamiliar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSaveAfter(this.cargafamiliar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cargafamiliar.getIsDeleted()) {
				this.cargafamiliar=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCargaFamiliarsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-saveCargaFamiliarsWithConnection");connexion.begin();			
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSaves(cargafamiliars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCargaFamiliars();
			
			Boolean validadoTodosCargaFamiliar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CargaFamiliar cargafamiliarLocal:cargafamiliars) {		
				if(cargafamiliarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargaFamiliarLogicAdditional.updateCargaFamiliarToSave(cargafamiliarLocal,this.arrDatoGeneral);
	        	
				CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargafamiliarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargaFamiliar(cargafamiliarLocal)) {
					CargaFamiliarDataAccess.save(cargafamiliarLocal, connexion);				
				} else {
					validadoTodosCargaFamiliar=false;
				}
			}
			
			if(!validadoTodosCargaFamiliar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSavesAfter(cargafamiliars,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargaFamiliars();
			
			connexion.commit();		
			
			this.quitarCargaFamiliarsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCargaFamiliars()throws Exception {				
		 try {	
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSaves(cargafamiliars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCargaFamiliar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CargaFamiliar cargafamiliarLocal:cargafamiliars) {				
				if(cargafamiliarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargaFamiliarLogicAdditional.updateCargaFamiliarToSave(cargafamiliarLocal,this.arrDatoGeneral);
	        	
				CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargafamiliarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargaFamiliar(cargafamiliarLocal)) {				
					CargaFamiliarDataAccess.save(cargafamiliarLocal, connexion);				
				} else {
					validadoTodosCargaFamiliar=false;
				}
			}
			
			if(!validadoTodosCargaFamiliar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargaFamiliarLogicAdditional.checkCargaFamiliarToSavesAfter(cargafamiliars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCargaFamiliarsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargaFamiliarParameterReturnGeneral procesarAccionCargaFamiliars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CargaFamiliar> cargafamiliars,CargaFamiliarParameterReturnGeneral cargafamiliarParameterGeneral)throws Exception {
		 try {	
			CargaFamiliarParameterReturnGeneral cargafamiliarReturnGeneral=new CargaFamiliarParameterReturnGeneral();
	
			CargaFamiliarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargafamiliars,cargafamiliarParameterGeneral,cargafamiliarReturnGeneral);
			
			return cargafamiliarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargaFamiliarParameterReturnGeneral procesarAccionCargaFamiliarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CargaFamiliar> cargafamiliars,CargaFamiliarParameterReturnGeneral cargafamiliarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-procesarAccionCargaFamiliarsWithConnection");connexion.begin();			
			
			CargaFamiliarParameterReturnGeneral cargafamiliarReturnGeneral=new CargaFamiliarParameterReturnGeneral();
	
			CargaFamiliarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargafamiliars,cargafamiliarParameterGeneral,cargafamiliarReturnGeneral);
			
			this.connexion.commit();
			
			return cargafamiliarReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargaFamiliarParameterReturnGeneral procesarEventosCargaFamiliars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CargaFamiliar> cargafamiliars,CargaFamiliar cargafamiliar,CargaFamiliarParameterReturnGeneral cargafamiliarParameterGeneral,Boolean isEsNuevoCargaFamiliar,ArrayList<Classe> clases)throws Exception {
		 try {	
			CargaFamiliarParameterReturnGeneral cargafamiliarReturnGeneral=new CargaFamiliarParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargafamiliarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargaFamiliarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargafamiliars,cargafamiliar,cargafamiliarParameterGeneral,cargafamiliarReturnGeneral,isEsNuevoCargaFamiliar,clases);
			
			return cargafamiliarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CargaFamiliarParameterReturnGeneral procesarEventosCargaFamiliarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CargaFamiliar> cargafamiliars,CargaFamiliar cargafamiliar,CargaFamiliarParameterReturnGeneral cargafamiliarParameterGeneral,Boolean isEsNuevoCargaFamiliar,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-procesarEventosCargaFamiliarsWithConnection");connexion.begin();			
			
			CargaFamiliarParameterReturnGeneral cargafamiliarReturnGeneral=new CargaFamiliarParameterReturnGeneral();
	
			cargafamiliarReturnGeneral.setCargaFamiliar(cargafamiliar);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargafamiliarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargaFamiliarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargafamiliars,cargafamiliar,cargafamiliarParameterGeneral,cargafamiliarReturnGeneral,isEsNuevoCargaFamiliar,clases);
			
			this.connexion.commit();
			
			return cargafamiliarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargaFamiliarParameterReturnGeneral procesarImportacionCargaFamiliarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CargaFamiliarParameterReturnGeneral cargafamiliarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-procesarImportacionCargaFamiliarsWithConnection");connexion.begin();			
			
			CargaFamiliarParameterReturnGeneral cargafamiliarReturnGeneral=new CargaFamiliarParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cargafamiliars=new ArrayList<CargaFamiliar>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cargafamiliar=new CargaFamiliar();
				
				
				if(conColumnasBase) {this.cargafamiliar.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cargafamiliar.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cargafamiliar.setcedula(arrColumnas[iColumn++]);
				this.cargafamiliar.setapellido(arrColumnas[iColumn++]);
				this.cargafamiliar.setnombre(arrColumnas[iColumn++]);
			this.cargafamiliar.setdireccion(arrColumnas[iColumn++]);
				this.cargafamiliar.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.cargafamiliar.setvalor_cupo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.cargafamiliars.add(this.cargafamiliar);
			}
			
			this.saveCargaFamiliars();
			
			this.connexion.commit();
			
			cargafamiliarReturnGeneral.setConRetornoEstaProcesado(true);
			cargafamiliarReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cargafamiliarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCargaFamiliarsEliminados() throws Exception {				
		
		List<CargaFamiliar> cargafamiliarsAux= new ArrayList<CargaFamiliar>();
		
		for(CargaFamiliar cargafamiliar:cargafamiliars) {
			if(!cargafamiliar.getIsDeleted()) {
				cargafamiliarsAux.add(cargafamiliar);
			}
		}
		
		cargafamiliars=cargafamiliarsAux;
	}
	
	public void quitarCargaFamiliarsNulos() throws Exception {				
		
		List<CargaFamiliar> cargafamiliarsAux= new ArrayList<CargaFamiliar>();
		
		for(CargaFamiliar cargafamiliar : this.cargafamiliars) {
			if(cargafamiliar==null) {
				cargafamiliarsAux.add(cargafamiliar);
			}
		}
		
		//this.cargafamiliars=cargafamiliarsAux;
		
		this.cargafamiliars.removeAll(cargafamiliarsAux);
	}
	
	public void getSetVersionRowCargaFamiliarWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cargafamiliar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cargafamiliar.getIsDeleted() || (cargafamiliar.getIsChanged()&&!cargafamiliar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cargafamiliarDataAccess.getSetVersionRowCargaFamiliar(connexion,cargafamiliar.getId());
				
				if(!cargafamiliar.getVersionRow().equals(timestamp)) {	
					cargafamiliar.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cargafamiliar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCargaFamiliar()throws Exception {	
		
		if(cargafamiliar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cargafamiliar.getIsDeleted() || (cargafamiliar.getIsChanged()&&!cargafamiliar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cargafamiliarDataAccess.getSetVersionRowCargaFamiliar(connexion,cargafamiliar.getId());
			
			try {							
				if(!cargafamiliar.getVersionRow().equals(timestamp)) {	
					cargafamiliar.setVersionRow(timestamp);
				}
				
				cargafamiliar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCargaFamiliarsWithConnection()throws Exception {	
		if(cargafamiliars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CargaFamiliar cargafamiliarAux:cargafamiliars) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cargafamiliarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargafamiliarAux.getIsDeleted() || (cargafamiliarAux.getIsChanged()&&!cargafamiliarAux.getIsNew())) {
						
						timestamp=cargafamiliarDataAccess.getSetVersionRowCargaFamiliar(connexion,cargafamiliarAux.getId());
						
						if(!cargafamiliar.getVersionRow().equals(timestamp)) {	
							cargafamiliarAux.setVersionRow(timestamp);
						}
								
						cargafamiliarAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCargaFamiliars()throws Exception {	
		if(cargafamiliars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CargaFamiliar cargafamiliarAux:cargafamiliars) {
					if(cargafamiliarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargafamiliarAux.getIsDeleted() || (cargafamiliarAux.getIsChanged()&&!cargafamiliarAux.getIsNew())) {
						
						timestamp=cargafamiliarDataAccess.getSetVersionRowCargaFamiliar(connexion,cargafamiliarAux.getId());
						
						if(!cargafamiliarAux.getVersionRow().equals(timestamp)) {	
							cargafamiliarAux.setVersionRow(timestamp);
						}
						
													
						cargafamiliarAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CargaFamiliarParameterReturnGeneral cargarCombosLoteForeignKeyCargaFamiliarWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoCargaFami,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil) throws Exception {
		CargaFamiliarParameterReturnGeneral  cargafamiliarReturnGeneral =new CargaFamiliarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-cargarCombosLoteForeignKeyCargaFamiliarWithConnection");connexion.begin();
			
			cargafamiliarReturnGeneral =new CargaFamiliarParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargafamiliarReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cargafamiliarReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoCargaFami> tipocargafamisForeignKey=new ArrayList<TipoCargaFami>();
			TipoCargaFamiLogic tipocargafamiLogic=new TipoCargaFamiLogic();
			tipocargafamiLogic.setConnexion(this.connexion);
			tipocargafamiLogic.getTipoCargaFamiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargaFami.equals("NONE")) {
				tipocargafamiLogic.getTodosTipoCargaFamis(finalQueryGlobalTipoCargaFami,new Pagination());
				tipocargafamisForeignKey=tipocargafamiLogic.getTipoCargaFamis();
			}

			cargafamiliarReturnGeneral.settipocargafamisForeignKey(tipocargafamisForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			cargafamiliarReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			cargafamiliarReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cargafamiliarReturnGeneral;
	}
	
	public CargaFamiliarParameterReturnGeneral cargarCombosLoteForeignKeyCargaFamiliar(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoCargaFami,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil) throws Exception {
		CargaFamiliarParameterReturnGeneral  cargafamiliarReturnGeneral =new CargaFamiliarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cargafamiliarReturnGeneral =new CargaFamiliarParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargafamiliarReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cargafamiliarReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoCargaFami> tipocargafamisForeignKey=new ArrayList<TipoCargaFami>();
			TipoCargaFamiLogic tipocargafamiLogic=new TipoCargaFamiLogic();
			tipocargafamiLogic.setConnexion(this.connexion);
			tipocargafamiLogic.getTipoCargaFamiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargaFami.equals("NONE")) {
				tipocargafamiLogic.getTodosTipoCargaFamis(finalQueryGlobalTipoCargaFami,new Pagination());
				tipocargafamisForeignKey=tipocargafamiLogic.getTipoCargaFamis();
			}

			cargafamiliarReturnGeneral.settipocargafamisForeignKey(tipocargafamisForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			cargafamiliarReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			cargafamiliarReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cargafamiliarReturnGeneral;
	}
	
	
	public void deepLoad(CargaFamiliar cargafamiliar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CargaFamiliarLogicAdditional.updateCargaFamiliarToGet(cargafamiliar,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargafamiliar.setEmpresa(cargafamiliarDataAccess.getEmpresa(connexion,cargafamiliar));
		cargafamiliar.setCliente(cargafamiliarDataAccess.getCliente(connexion,cargafamiliar));
		cargafamiliar.setTipoCargaFami(cargafamiliarDataAccess.getTipoCargaFami(connexion,cargafamiliar));
		cargafamiliar.setTipoGenero(cargafamiliarDataAccess.getTipoGenero(connexion,cargafamiliar));
		cargafamiliar.setEstadoCivil(cargafamiliarDataAccess.getEstadoCivil(connexion,cargafamiliar));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargafamiliar.setEmpresa(cargafamiliarDataAccess.getEmpresa(connexion,cargafamiliar));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cargafamiliar.setCliente(cargafamiliarDataAccess.getCliente(connexion,cargafamiliar));
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				cargafamiliar.setTipoCargaFami(cargafamiliarDataAccess.getTipoCargaFami(connexion,cargafamiliar));
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				cargafamiliar.setTipoGenero(cargafamiliarDataAccess.getTipoGenero(connexion,cargafamiliar));
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				cargafamiliar.setEstadoCivil(cargafamiliarDataAccess.getEstadoCivil(connexion,cargafamiliar));
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
			cargafamiliar.setEmpresa(cargafamiliarDataAccess.getEmpresa(connexion,cargafamiliar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setCliente(cargafamiliarDataAccess.getCliente(connexion,cargafamiliar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargaFami.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setTipoCargaFami(cargafamiliarDataAccess.getTipoCargaFami(connexion,cargafamiliar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setTipoGenero(cargafamiliarDataAccess.getTipoGenero(connexion,cargafamiliar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setEstadoCivil(cargafamiliarDataAccess.getEstadoCivil(connexion,cargafamiliar));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargafamiliar.setEmpresa(cargafamiliarDataAccess.getEmpresa(connexion,cargafamiliar));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargafamiliar.getEmpresa(),isDeep,deepLoadType,clases);
				
		cargafamiliar.setCliente(cargafamiliarDataAccess.getCliente(connexion,cargafamiliar));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cargafamiliar.getCliente(),isDeep,deepLoadType,clases);
				
		cargafamiliar.setTipoCargaFami(cargafamiliarDataAccess.getTipoCargaFami(connexion,cargafamiliar));
		TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
		tipocargafamiLogic.deepLoad(cargafamiliar.getTipoCargaFami(),isDeep,deepLoadType,clases);
				
		cargafamiliar.setTipoGenero(cargafamiliarDataAccess.getTipoGenero(connexion,cargafamiliar));
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(cargafamiliar.getTipoGenero(),isDeep,deepLoadType,clases);
				
		cargafamiliar.setEstadoCivil(cargafamiliarDataAccess.getEstadoCivil(connexion,cargafamiliar));
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(cargafamiliar.getEstadoCivil(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargafamiliar.setEmpresa(cargafamiliarDataAccess.getEmpresa(connexion,cargafamiliar));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cargafamiliar.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cargafamiliar.setCliente(cargafamiliarDataAccess.getCliente(connexion,cargafamiliar));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cargafamiliar.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				cargafamiliar.setTipoCargaFami(cargafamiliarDataAccess.getTipoCargaFami(connexion,cargafamiliar));
				TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
				tipocargafamiLogic.deepLoad(cargafamiliar.getTipoCargaFami(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				cargafamiliar.setTipoGenero(cargafamiliarDataAccess.getTipoGenero(connexion,cargafamiliar));
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepLoad(cargafamiliar.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				cargafamiliar.setEstadoCivil(cargafamiliarDataAccess.getEstadoCivil(connexion,cargafamiliar));
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepLoad(cargafamiliar.getEstadoCivil(),isDeep,deepLoadType,clases);				
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
			cargafamiliar.setEmpresa(cargafamiliarDataAccess.getEmpresa(connexion,cargafamiliar));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cargafamiliar.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setCliente(cargafamiliarDataAccess.getCliente(connexion,cargafamiliar));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cargafamiliar.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargaFami.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setTipoCargaFami(cargafamiliarDataAccess.getTipoCargaFami(connexion,cargafamiliar));
			TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
			tipocargafamiLogic.deepLoad(cargafamiliar.getTipoCargaFami(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setTipoGenero(cargafamiliarDataAccess.getTipoGenero(connexion,cargafamiliar));
			TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
			tipogeneroLogic.deepLoad(cargafamiliar.getTipoGenero(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar.setEstadoCivil(cargafamiliarDataAccess.getEstadoCivil(connexion,cargafamiliar));
			EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
			estadocivilLogic.deepLoad(cargafamiliar.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CargaFamiliar cargafamiliar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CargaFamiliarLogicAdditional.updateCargaFamiliarToSave(cargafamiliar,this.arrDatoGeneral);
			
CargaFamiliarDataAccess.save(cargafamiliar, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargafamiliar.getEmpresa(),connexion);

		ClienteDataAccess.save(cargafamiliar.getCliente(),connexion);

		TipoCargaFamiDataAccess.save(cargafamiliar.getTipoCargaFami(),connexion);

		TipoGeneroDataAccess.save(cargafamiliar.getTipoGenero(),connexion);

		EstadoCivilDataAccess.save(cargafamiliar.getEstadoCivil(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargafamiliar.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cargafamiliar.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				TipoCargaFamiDataAccess.save(cargafamiliar.getTipoCargaFami(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(cargafamiliar.getTipoGenero(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(cargafamiliar.getEstadoCivil(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargafamiliar.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargafamiliar.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(cargafamiliar.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cargafamiliar.getCliente(),isDeep,deepLoadType,clases);
				

		TipoCargaFamiDataAccess.save(cargafamiliar.getTipoCargaFami(),connexion);
		TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
		tipocargafamiLogic.deepLoad(cargafamiliar.getTipoCargaFami(),isDeep,deepLoadType,clases);
				

		TipoGeneroDataAccess.save(cargafamiliar.getTipoGenero(),connexion);
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(cargafamiliar.getTipoGenero(),isDeep,deepLoadType,clases);
				

		EstadoCivilDataAccess.save(cargafamiliar.getEstadoCivil(),connexion);
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(cargafamiliar.getEstadoCivil(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargafamiliar.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cargafamiliar.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cargafamiliar.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(cargafamiliar.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				TipoCargaFamiDataAccess.save(cargafamiliar.getTipoCargaFami(),connexion);
				TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
				tipocargafamiLogic.deepSave(cargafamiliar.getTipoCargaFami(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(cargafamiliar.getTipoGenero(),connexion);
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepSave(cargafamiliar.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(cargafamiliar.getEstadoCivil(),connexion);
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepSave(cargafamiliar.getEstadoCivil(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CargaFamiliar.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliar);
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
			this.deepLoad(this.cargafamiliar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CargaFamiliar.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cargafamiliars!=null) {
				for(CargaFamiliar cargafamiliar:cargafamiliars) {
					this.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliars);
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
			if(cargafamiliars!=null) {
				for(CargaFamiliar cargafamiliar:cargafamiliars) {
					this.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliars);
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
			this.getNewConnexionToDeep(CargaFamiliar.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cargafamiliar,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CargaFamiliar.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cargafamiliars!=null) {
				for(CargaFamiliar cargafamiliar:cargafamiliars) {
					this.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
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
			if(cargafamiliars!=null) {
				for(CargaFamiliar cargafamiliar:cargafamiliars) {
					this.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCargaFamiliarsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CargaFamiliarConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliarsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CargaFamiliarConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliarsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargaFamiliarConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliarsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargaFamiliarConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliarsFK_IdEstadoCivilWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,CargaFamiliarConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliarsFK_IdEstadoCivil(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,CargaFamiliarConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliarsFK_IdTipoCargaFamiWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_carga_fami)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargaFami= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargaFami.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_carga_fami,CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargaFami);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCargaFami","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliarsFK_IdTipoCargaFami(String sFinalQuery,Pagination pagination,Long id_tipo_carga_fami)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargaFami= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargaFami.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_carga_fami,CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargaFami);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCargaFami","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliarsFK_IdTipoGeneroWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,CargaFamiliarConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliarsFK_IdTipoGenero(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,CargaFamiliarConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			CargaFamiliarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(this.cargafamiliars);
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
			if(CargaFamiliarConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliarDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CargaFamiliar cargafamiliar,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CargaFamiliarConstantesFunciones.ISCONAUDITORIA) {
				if(cargafamiliar.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliarDataAccess.TABLENAME, cargafamiliar.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargaFamiliarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargaFamiliarLogic.registrarAuditoriaDetallesCargaFamiliar(connexion,cargafamiliar,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cargafamiliar.getIsDeleted()) {
					/*if(!cargafamiliar.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CargaFamiliarDataAccess.TABLENAME, cargafamiliar.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CargaFamiliarLogic.registrarAuditoriaDetallesCargaFamiliar(connexion,cargafamiliar,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliarDataAccess.TABLENAME, cargafamiliar.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cargafamiliar.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliarDataAccess.TABLENAME, cargafamiliar.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargaFamiliarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargaFamiliarLogic.registrarAuditoriaDetallesCargaFamiliar(connexion,cargafamiliar,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCargaFamiliar(Connexion connexion,CargaFamiliar cargafamiliar)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getid_empresa().equals(cargafamiliar.getCargaFamiliarOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getid_empresa()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getid_empresa().toString();
				}
				if(cargafamiliar.getid_empresa()!=null)
				{
					strValorNuevo=cargafamiliar.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getid_cliente().equals(cargafamiliar.getCargaFamiliarOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getid_cliente()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getid_cliente().toString();
				}
				if(cargafamiliar.getid_cliente()!=null)
				{
					strValorNuevo=cargafamiliar.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getid_tipo_carga_fami().equals(cargafamiliar.getCargaFamiliarOriginal().getid_tipo_carga_fami()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getid_tipo_carga_fami()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getid_tipo_carga_fami().toString();
				}
				if(cargafamiliar.getid_tipo_carga_fami()!=null)
				{
					strValorNuevo=cargafamiliar.getid_tipo_carga_fami().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getid_tipo_genero().equals(cargafamiliar.getCargaFamiliarOriginal().getid_tipo_genero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getid_tipo_genero()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getid_tipo_genero().toString();
				}
				if(cargafamiliar.getid_tipo_genero()!=null)
				{
					strValorNuevo=cargafamiliar.getid_tipo_genero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.IDTIPOGENERO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getid_estado_civil().equals(cargafamiliar.getCargaFamiliarOriginal().getid_estado_civil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getid_estado_civil()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getid_estado_civil().toString();
				}
				if(cargafamiliar.getid_estado_civil()!=null)
				{
					strValorNuevo=cargafamiliar.getid_estado_civil().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.IDESTADOCIVIL,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getcedula().equals(cargafamiliar.getCargaFamiliarOriginal().getcedula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getcedula()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getcedula();
				}
				if(cargafamiliar.getcedula()!=null)
				{
					strValorNuevo=cargafamiliar.getcedula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.CEDULA,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getapellido().equals(cargafamiliar.getCargaFamiliarOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getapellido()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getapellido();
				}
				if(cargafamiliar.getapellido()!=null)
				{
					strValorNuevo=cargafamiliar.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getnombre().equals(cargafamiliar.getCargaFamiliarOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getnombre()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getnombre();
				}
				if(cargafamiliar.getnombre()!=null)
				{
					strValorNuevo=cargafamiliar.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getdireccion().equals(cargafamiliar.getCargaFamiliarOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getdireccion()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getdireccion();
				}
				if(cargafamiliar.getdireccion()!=null)
				{
					strValorNuevo=cargafamiliar.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getfecha_nacimiento().equals(cargafamiliar.getCargaFamiliarOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getfecha_nacimiento().toString();
				}
				if(cargafamiliar.getfecha_nacimiento()!=null)
				{
					strValorNuevo=cargafamiliar.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar.getIsNew()||!cargafamiliar.getvalor_cupo().equals(cargafamiliar.getCargaFamiliarOriginal().getvalor_cupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar.getCargaFamiliarOriginal().getvalor_cupo()!=null)
				{
					strValorActual=cargafamiliar.getCargaFamiliarOriginal().getvalor_cupo().toString();
				}
				if(cargafamiliar.getvalor_cupo()!=null)
				{
					strValorNuevo=cargafamiliar.getvalor_cupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliarConstantesFunciones.VALORCUPO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCargaFamiliarRelacionesWithConnection(CargaFamiliar cargafamiliar) throws Exception {

		if(!cargafamiliar.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargaFamiliarRelacionesBase(cargafamiliar,true);
		}
	}

	public void saveCargaFamiliarRelaciones(CargaFamiliar cargafamiliar)throws Exception {

		if(!cargafamiliar.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargaFamiliarRelacionesBase(cargafamiliar,false);
		}
	}

	public void saveCargaFamiliarRelacionesBase(CargaFamiliar cargafamiliar,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CargaFamiliar-saveRelacionesWithConnection");}
	

			this.setCargaFamiliar(cargafamiliar);

			if(CargaFamiliarLogicAdditional.validarSaveRelaciones(cargafamiliar,this)) {

				CargaFamiliarLogicAdditional.updateRelacionesToSave(cargafamiliar,this);

				if((cargafamiliar.getIsNew()||cargafamiliar.getIsChanged())&&!cargafamiliar.getIsDeleted()) {
					this.saveCargaFamiliar();
					this.saveCargaFamiliarRelacionesDetalles();

				} else if(cargafamiliar.getIsDeleted()) {
					this.saveCargaFamiliarRelacionesDetalles();
					this.saveCargaFamiliar();
				}

				CargaFamiliarLogicAdditional.updateRelacionesToSaveAfter(cargafamiliar,this);

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
	
	
	private void saveCargaFamiliarRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCargaFamiliar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargaFamiliar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargaFamiliarConstantesFunciones.getClassesRelationshipsOfCargaFamiliar(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
