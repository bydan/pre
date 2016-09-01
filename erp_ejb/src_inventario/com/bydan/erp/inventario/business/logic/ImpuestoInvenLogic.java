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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.ImpuestoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.ImpuestoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ImpuestoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.ImpuestoInven;
import com.bydan.erp.inventario.business.logic.ImpuestoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ImpuestoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ImpuestoInvenLogic.class);
	
	protected ImpuestoInvenDataAccess impuestoinvenDataAccess; 	
	protected ImpuestoInven impuestoinven;
	protected List<ImpuestoInven> impuestoinvens;
	protected Object impuestoinvenObject;	
	protected List<Object> impuestoinvensObject;
	
	public static ClassValidator<ImpuestoInven> impuestoinvenValidator = new ClassValidator<ImpuestoInven>(ImpuestoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ImpuestoInvenLogicAdditional impuestoinvenLogicAdditional=null;
	
	public ImpuestoInvenLogicAdditional getImpuestoInvenLogicAdditional() {
		return this.impuestoinvenLogicAdditional;
	}
	
	public void setImpuestoInvenLogicAdditional(ImpuestoInvenLogicAdditional impuestoinvenLogicAdditional) {
		try {
			this.impuestoinvenLogicAdditional=impuestoinvenLogicAdditional;
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
	
	
	
	
	public  ImpuestoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.impuestoinvenDataAccess = new ImpuestoInvenDataAccess();
			
			this.impuestoinvens= new ArrayList<ImpuestoInven>();
			this.impuestoinven= new ImpuestoInven();
			
			this.impuestoinvenObject=new Object();
			this.impuestoinvensObject=new ArrayList<Object>();
				
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
			
			this.impuestoinvenDataAccess.setConnexionType(this.connexionType);
			this.impuestoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ImpuestoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.impuestoinvenDataAccess = new ImpuestoInvenDataAccess();
			this.impuestoinvens= new ArrayList<ImpuestoInven>();
			this.impuestoinven= new ImpuestoInven();
			this.impuestoinvenObject=new Object();
			this.impuestoinvensObject=new ArrayList<Object>();
			
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
			
			this.impuestoinvenDataAccess.setConnexionType(this.connexionType);
			this.impuestoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ImpuestoInven getImpuestoInven() throws Exception {	
		ImpuestoInvenLogicAdditional.checkImpuestoInvenToGet(impuestoinven,this.datosCliente,this.arrDatoGeneral);
		ImpuestoInvenLogicAdditional.updateImpuestoInvenToGet(impuestoinven,this.arrDatoGeneral);
		
		return impuestoinven;
	}
		
	public void setImpuestoInven(ImpuestoInven newImpuestoInven) {
		this.impuestoinven = newImpuestoInven;
	}
	
	public ImpuestoInvenDataAccess getImpuestoInvenDataAccess() {
		return impuestoinvenDataAccess;
	}
	
	public void setImpuestoInvenDataAccess(ImpuestoInvenDataAccess newimpuestoinvenDataAccess) {
		this.impuestoinvenDataAccess = newimpuestoinvenDataAccess;
	}
	
	public List<ImpuestoInven> getImpuestoInvens() throws Exception {		
		this.quitarImpuestoInvensNulos();
		
		ImpuestoInvenLogicAdditional.checkImpuestoInvenToGets(impuestoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (ImpuestoInven impuestoinvenLocal: impuestoinvens ) {
			ImpuestoInvenLogicAdditional.updateImpuestoInvenToGet(impuestoinvenLocal,this.arrDatoGeneral);
		}
		
		return impuestoinvens;
	}
	
	public void setImpuestoInvens(List<ImpuestoInven> newImpuestoInvens) {
		this.impuestoinvens = newImpuestoInvens;
	}
	
	public Object getImpuestoInvenObject() {	
		this.impuestoinvenObject=this.impuestoinvenDataAccess.getEntityObject();
		return this.impuestoinvenObject;
	}
		
	public void setImpuestoInvenObject(Object newImpuestoInvenObject) {
		this.impuestoinvenObject = newImpuestoInvenObject;
	}
	
	public List<Object> getImpuestoInvensObject() {		
		this.impuestoinvensObject=this.impuestoinvenDataAccess.getEntitiesObject();
		return this.impuestoinvensObject;
	}
		
	public void setImpuestoInvensObject(List<Object> newImpuestoInvensObject) {
		this.impuestoinvensObject = newImpuestoInvensObject;
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
		
		if(this.impuestoinvenDataAccess!=null) {
			this.impuestoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			impuestoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			impuestoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		impuestoinven = new  ImpuestoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			impuestoinven=impuestoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
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
		impuestoinven = new  ImpuestoInven();
		  		  
        try {
			
			impuestoinven=impuestoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		impuestoinven = new  ImpuestoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			impuestoinven=impuestoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
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
		impuestoinven = new  ImpuestoInven();
		  		  
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
		impuestoinven = new  ImpuestoInven();
		  		  
        try {
			
			impuestoinven=impuestoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		impuestoinven = new  ImpuestoInven();
		  		  
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
		impuestoinven = new  ImpuestoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =impuestoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		impuestoinven = new  ImpuestoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=impuestoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		impuestoinven = new  ImpuestoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =impuestoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		impuestoinven = new  ImpuestoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=impuestoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		impuestoinven = new  ImpuestoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =impuestoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		impuestoinven = new  ImpuestoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=impuestoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
        try {			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
        try {
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		impuestoinven = new  ImpuestoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinven=impuestoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
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
		impuestoinven = new  ImpuestoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinven=impuestoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
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
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		  		  
        try {
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosImpuestoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getTodosImpuestoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
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
	
	public  void  getTodosImpuestoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		impuestoinvens = new  ArrayList<ImpuestoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarImpuestoInven(impuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarImpuestoInven(ImpuestoInven impuestoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(impuestoinven.getIsNew() || impuestoinven.getIsChanged()) { 
			this.invalidValues = impuestoinvenValidator.getInvalidValues(impuestoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(impuestoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarImpuestoInven(List<ImpuestoInven> ImpuestoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ImpuestoInven impuestoinvenLocal:impuestoinvens) {				
			estaValidadoObjeto=this.validarGuardarImpuestoInven(impuestoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarImpuestoInven(List<ImpuestoInven> ImpuestoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarImpuestoInven(impuestoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarImpuestoInven(ImpuestoInven ImpuestoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarImpuestoInven(impuestoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ImpuestoInven impuestoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+impuestoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ImpuestoInvenConstantesFunciones.getImpuestoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"impuestoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ImpuestoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ImpuestoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveImpuestoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-saveImpuestoInvenWithConnection");connexion.begin();			
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSave(this.impuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ImpuestoInvenLogicAdditional.updateImpuestoInvenToSave(this.impuestoinven,this.arrDatoGeneral);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.impuestoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowImpuestoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarImpuestoInven(this.impuestoinven)) {
				ImpuestoInvenDataAccess.save(this.impuestoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSaveAfter(this.impuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowImpuestoInven();
			
			connexion.commit();			
			
			if(this.impuestoinven.getIsDeleted()) {
				this.impuestoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveImpuestoInven()throws Exception {	
		try {	
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSave(this.impuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ImpuestoInvenLogicAdditional.updateImpuestoInvenToSave(this.impuestoinven,this.arrDatoGeneral);
			
			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.impuestoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarImpuestoInven(this.impuestoinven)) {			
				ImpuestoInvenDataAccess.save(this.impuestoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSaveAfter(this.impuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.impuestoinven.getIsDeleted()) {
				this.impuestoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveImpuestoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-saveImpuestoInvensWithConnection");connexion.begin();			
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSaves(impuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowImpuestoInvens();
			
			Boolean validadoTodosImpuestoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ImpuestoInven impuestoinvenLocal:impuestoinvens) {		
				if(impuestoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ImpuestoInvenLogicAdditional.updateImpuestoInvenToSave(impuestoinvenLocal,this.arrDatoGeneral);
	        	
				ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),impuestoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarImpuestoInven(impuestoinvenLocal)) {
					ImpuestoInvenDataAccess.save(impuestoinvenLocal, connexion);				
				} else {
					validadoTodosImpuestoInven=false;
				}
			}
			
			if(!validadoTodosImpuestoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSavesAfter(impuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowImpuestoInvens();
			
			connexion.commit();		
			
			this.quitarImpuestoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveImpuestoInvens()throws Exception {				
		 try {	
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSaves(impuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosImpuestoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ImpuestoInven impuestoinvenLocal:impuestoinvens) {				
				if(impuestoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ImpuestoInvenLogicAdditional.updateImpuestoInvenToSave(impuestoinvenLocal,this.arrDatoGeneral);
	        	
				ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),impuestoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarImpuestoInven(impuestoinvenLocal)) {				
					ImpuestoInvenDataAccess.save(impuestoinvenLocal, connexion);				
				} else {
					validadoTodosImpuestoInven=false;
				}
			}
			
			if(!validadoTodosImpuestoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ImpuestoInvenLogicAdditional.checkImpuestoInvenToSavesAfter(impuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarImpuestoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ImpuestoInvenParameterReturnGeneral procesarAccionImpuestoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ImpuestoInven> impuestoinvens,ImpuestoInvenParameterReturnGeneral impuestoinvenParameterGeneral)throws Exception {
		 try {	
			ImpuestoInvenParameterReturnGeneral impuestoinvenReturnGeneral=new ImpuestoInvenParameterReturnGeneral();
	
			ImpuestoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,impuestoinvens,impuestoinvenParameterGeneral,impuestoinvenReturnGeneral);
			
			return impuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ImpuestoInvenParameterReturnGeneral procesarAccionImpuestoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ImpuestoInven> impuestoinvens,ImpuestoInvenParameterReturnGeneral impuestoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-procesarAccionImpuestoInvensWithConnection");connexion.begin();			
			
			ImpuestoInvenParameterReturnGeneral impuestoinvenReturnGeneral=new ImpuestoInvenParameterReturnGeneral();
	
			ImpuestoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,impuestoinvens,impuestoinvenParameterGeneral,impuestoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return impuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ImpuestoInvenParameterReturnGeneral procesarEventosImpuestoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ImpuestoInven> impuestoinvens,ImpuestoInven impuestoinven,ImpuestoInvenParameterReturnGeneral impuestoinvenParameterGeneral,Boolean isEsNuevoImpuestoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			ImpuestoInvenParameterReturnGeneral impuestoinvenReturnGeneral=new ImpuestoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				impuestoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ImpuestoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,impuestoinvens,impuestoinven,impuestoinvenParameterGeneral,impuestoinvenReturnGeneral,isEsNuevoImpuestoInven,clases);
			
			return impuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ImpuestoInvenParameterReturnGeneral procesarEventosImpuestoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ImpuestoInven> impuestoinvens,ImpuestoInven impuestoinven,ImpuestoInvenParameterReturnGeneral impuestoinvenParameterGeneral,Boolean isEsNuevoImpuestoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-procesarEventosImpuestoInvensWithConnection");connexion.begin();			
			
			ImpuestoInvenParameterReturnGeneral impuestoinvenReturnGeneral=new ImpuestoInvenParameterReturnGeneral();
	
			impuestoinvenReturnGeneral.setImpuestoInven(impuestoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				impuestoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ImpuestoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,impuestoinvens,impuestoinven,impuestoinvenParameterGeneral,impuestoinvenReturnGeneral,isEsNuevoImpuestoInven,clases);
			
			this.connexion.commit();
			
			return impuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ImpuestoInvenParameterReturnGeneral procesarImportacionImpuestoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ImpuestoInvenParameterReturnGeneral impuestoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-procesarImportacionImpuestoInvensWithConnection");connexion.begin();			
			
			ImpuestoInvenParameterReturnGeneral impuestoinvenReturnGeneral=new ImpuestoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.impuestoinvens=new ArrayList<ImpuestoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.impuestoinven=new ImpuestoInven();
				
				
				if(conColumnasBase) {this.impuestoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.impuestoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.impuestoinven.setnombre(arrColumnas[iColumn++]);
				
				this.impuestoinvens.add(this.impuestoinven);
			}
			
			this.saveImpuestoInvens();
			
			this.connexion.commit();
			
			impuestoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			impuestoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return impuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarImpuestoInvensEliminados() throws Exception {				
		
		List<ImpuestoInven> impuestoinvensAux= new ArrayList<ImpuestoInven>();
		
		for(ImpuestoInven impuestoinven:impuestoinvens) {
			if(!impuestoinven.getIsDeleted()) {
				impuestoinvensAux.add(impuestoinven);
			}
		}
		
		impuestoinvens=impuestoinvensAux;
	}
	
	public void quitarImpuestoInvensNulos() throws Exception {				
		
		List<ImpuestoInven> impuestoinvensAux= new ArrayList<ImpuestoInven>();
		
		for(ImpuestoInven impuestoinven : this.impuestoinvens) {
			if(impuestoinven==null) {
				impuestoinvensAux.add(impuestoinven);
			}
		}
		
		//this.impuestoinvens=impuestoinvensAux;
		
		this.impuestoinvens.removeAll(impuestoinvensAux);
	}
	
	public void getSetVersionRowImpuestoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(impuestoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((impuestoinven.getIsDeleted() || (impuestoinven.getIsChanged()&&!impuestoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=impuestoinvenDataAccess.getSetVersionRowImpuestoInven(connexion,impuestoinven.getId());
				
				if(!impuestoinven.getVersionRow().equals(timestamp)) {	
					impuestoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				impuestoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowImpuestoInven()throws Exception {	
		
		if(impuestoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((impuestoinven.getIsDeleted() || (impuestoinven.getIsChanged()&&!impuestoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=impuestoinvenDataAccess.getSetVersionRowImpuestoInven(connexion,impuestoinven.getId());
			
			try {							
				if(!impuestoinven.getVersionRow().equals(timestamp)) {	
					impuestoinven.setVersionRow(timestamp);
				}
				
				impuestoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowImpuestoInvensWithConnection()throws Exception {	
		if(impuestoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ImpuestoInven impuestoinvenAux:impuestoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(impuestoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(impuestoinvenAux.getIsDeleted() || (impuestoinvenAux.getIsChanged()&&!impuestoinvenAux.getIsNew())) {
						
						timestamp=impuestoinvenDataAccess.getSetVersionRowImpuestoInven(connexion,impuestoinvenAux.getId());
						
						if(!impuestoinven.getVersionRow().equals(timestamp)) {	
							impuestoinvenAux.setVersionRow(timestamp);
						}
								
						impuestoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowImpuestoInvens()throws Exception {	
		if(impuestoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ImpuestoInven impuestoinvenAux:impuestoinvens) {
					if(impuestoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(impuestoinvenAux.getIsDeleted() || (impuestoinvenAux.getIsChanged()&&!impuestoinvenAux.getIsNew())) {
						
						timestamp=impuestoinvenDataAccess.getSetVersionRowImpuestoInven(connexion,impuestoinvenAux.getId());
						
						if(!impuestoinvenAux.getVersionRow().equals(timestamp)) {	
							impuestoinvenAux.setVersionRow(timestamp);
						}
						
													
						impuestoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ImpuestoInvenParameterReturnGeneral cargarCombosLoteForeignKeyImpuestoInvenWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ImpuestoInvenParameterReturnGeneral  impuestoinvenReturnGeneral =new ImpuestoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyImpuestoInvenWithConnection");connexion.begin();
			
			impuestoinvenReturnGeneral =new ImpuestoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			impuestoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return impuestoinvenReturnGeneral;
	}
	
	public ImpuestoInvenParameterReturnGeneral cargarCombosLoteForeignKeyImpuestoInven(String finalQueryGlobalEmpresa) throws Exception {
		ImpuestoInvenParameterReturnGeneral  impuestoinvenReturnGeneral =new ImpuestoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			impuestoinvenReturnGeneral =new ImpuestoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			impuestoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return impuestoinvenReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyImpuestoInvenWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoImpuestoLogic productoimpuestoLogic=new ProductoImpuestoLogic();
			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic=new DetalleImpuestoInvenLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyImpuestoInvenWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoImpuesto.class));
			classes.add(new Classe(DetalleImpuestoInven.class));
											
			

			productoimpuestoLogic.setConnexion(this.getConnexion());
			productoimpuestoLogic.setDatosCliente(this.datosCliente);
			productoimpuestoLogic.setIsConRefrescarForeignKeys(true);

			detalleimpuestoinvenLogic.setConnexion(this.getConnexion());
			detalleimpuestoinvenLogic.setDatosCliente(this.datosCliente);
			detalleimpuestoinvenLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ImpuestoInven impuestoinven:this.impuestoinvens) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoImpuestoConstantesFunciones.getClassesForeignKeysOfProductoImpuesto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoimpuestoLogic.setProductoImpuestos(impuestoinven.productoimpuestos);
				productoimpuestoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleImpuestoInvenConstantesFunciones.getClassesForeignKeysOfDetalleImpuestoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleimpuestoinvenLogic.setDetalleImpuestoInvens(impuestoinven.detalleimpuestoinvens);
				detalleimpuestoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ImpuestoInven impuestoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ImpuestoInvenLogicAdditional.updateImpuestoInvenToGet(impuestoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		impuestoinven.setEmpresa(impuestoinvenDataAccess.getEmpresa(connexion,impuestoinven));
		impuestoinven.setProductoImpuestos(impuestoinvenDataAccess.getProductoImpuestos(connexion,impuestoinven));
		impuestoinven.setDetalleImpuestoInvens(impuestoinvenDataAccess.getDetalleImpuestoInvens(connexion,impuestoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				impuestoinven.setEmpresa(impuestoinvenDataAccess.getEmpresa(connexion,impuestoinven));
				continue;
			}

			if(clas.clas.equals(ProductoImpuesto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				impuestoinven.setProductoImpuestos(impuestoinvenDataAccess.getProductoImpuestos(connexion,impuestoinven));

				if(this.isConDeep) {
					ProductoImpuestoLogic productoimpuestoLogic= new ProductoImpuestoLogic(this.connexion);
					productoimpuestoLogic.setProductoImpuestos(impuestoinven.getProductoImpuestos());
					ArrayList<Classe> classesLocal=ProductoImpuestoConstantesFunciones.getClassesForeignKeysOfProductoImpuesto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoimpuestoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(productoimpuestoLogic.getProductoImpuestos());
					impuestoinven.setProductoImpuestos(productoimpuestoLogic.getProductoImpuestos());
				}

				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				impuestoinven.setDetalleImpuestoInvens(impuestoinvenDataAccess.getDetalleImpuestoInvens(connexion,impuestoinven));

				if(this.isConDeep) {
					DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(this.connexion);
					detalleimpuestoinvenLogic.setDetalleImpuestoInvens(impuestoinven.getDetalleImpuestoInvens());
					ArrayList<Classe> classesLocal=DetalleImpuestoInvenConstantesFunciones.getClassesForeignKeysOfDetalleImpuestoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleimpuestoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(detalleimpuestoinvenLogic.getDetalleImpuestoInvens());
					impuestoinven.setDetalleImpuestoInvens(detalleimpuestoinvenLogic.getDetalleImpuestoInvens());
				}

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
			impuestoinven.setEmpresa(impuestoinvenDataAccess.getEmpresa(connexion,impuestoinven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoImpuesto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoImpuesto.class));
			impuestoinven.setProductoImpuestos(impuestoinvenDataAccess.getProductoImpuestos(connexion,impuestoinven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleImpuestoInven.class));
			impuestoinven.setDetalleImpuestoInvens(impuestoinvenDataAccess.getDetalleImpuestoInvens(connexion,impuestoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		impuestoinven.setEmpresa(impuestoinvenDataAccess.getEmpresa(connexion,impuestoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(impuestoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		impuestoinven.setProductoImpuestos(impuestoinvenDataAccess.getProductoImpuestos(connexion,impuestoinven));

		for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
			ProductoImpuestoLogic productoimpuestoLogic= new ProductoImpuestoLogic(connexion);
			productoimpuestoLogic.deepLoad(productoimpuesto,isDeep,deepLoadType,clases);
		}

		impuestoinven.setDetalleImpuestoInvens(impuestoinvenDataAccess.getDetalleImpuestoInvens(connexion,impuestoinven));

		for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
			detalleimpuestoinvenLogic.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				impuestoinven.setEmpresa(impuestoinvenDataAccess.getEmpresa(connexion,impuestoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(impuestoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoImpuesto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				impuestoinven.setProductoImpuestos(impuestoinvenDataAccess.getProductoImpuestos(connexion,impuestoinven));

				for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
					ProductoImpuestoLogic productoimpuestoLogic= new ProductoImpuestoLogic(connexion);
					productoimpuestoLogic.deepLoad(productoimpuesto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				impuestoinven.setDetalleImpuestoInvens(impuestoinvenDataAccess.getDetalleImpuestoInvens(connexion,impuestoinven));

				for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
					DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
					detalleimpuestoinvenLogic.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}
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
			impuestoinven.setEmpresa(impuestoinvenDataAccess.getEmpresa(connexion,impuestoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(impuestoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoImpuesto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoImpuesto.class));
			impuestoinven.setProductoImpuestos(impuestoinvenDataAccess.getProductoImpuestos(connexion,impuestoinven));

			for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
				ProductoImpuestoLogic productoimpuestoLogic= new ProductoImpuestoLogic(connexion);
				productoimpuestoLogic.deepLoad(productoimpuesto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleImpuestoInven.class));
			impuestoinven.setDetalleImpuestoInvens(impuestoinvenDataAccess.getDetalleImpuestoInvens(connexion,impuestoinven));

			for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
				DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
				detalleimpuestoinvenLogic.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ImpuestoInven impuestoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ImpuestoInvenLogicAdditional.updateImpuestoInvenToSave(impuestoinven,this.arrDatoGeneral);
			
ImpuestoInvenDataAccess.save(impuestoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(impuestoinven.getEmpresa(),connexion);

		for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
			productoimpuesto.setid_impuesto_inven(impuestoinven.getId());
			ProductoImpuestoDataAccess.save(productoimpuesto,connexion);
		}

		for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
			detalleimpuestoinven.setid_impuesto_inven(impuestoinven.getId());
			DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(impuestoinven.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoImpuesto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
					productoimpuesto.setid_impuesto_inven(impuestoinven.getId());
					ProductoImpuestoDataAccess.save(productoimpuesto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
					detalleimpuestoinven.setid_impuesto_inven(impuestoinven.getId());
					DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(impuestoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(impuestoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
			ProductoImpuestoLogic productoimpuestoLogic= new ProductoImpuestoLogic(connexion);
			productoimpuesto.setid_impuesto_inven(impuestoinven.getId());
			ProductoImpuestoDataAccess.save(productoimpuesto,connexion);
			productoimpuestoLogic.deepSave(productoimpuesto,isDeep,deepLoadType,clases);
		}

		for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
			detalleimpuestoinven.setid_impuesto_inven(impuestoinven.getId());
			DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
			detalleimpuestoinvenLogic.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(impuestoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(impuestoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoImpuesto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoImpuesto productoimpuesto:impuestoinven.getProductoImpuestos()) {
					ProductoImpuestoLogic productoimpuestoLogic= new ProductoImpuestoLogic(connexion);
					productoimpuesto.setid_impuesto_inven(impuestoinven.getId());
					ProductoImpuestoDataAccess.save(productoimpuesto,connexion);
					productoimpuestoLogic.deepSave(productoimpuesto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleImpuestoInven detalleimpuestoinven:impuestoinven.getDetalleImpuestoInvens()) {
					DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
					detalleimpuestoinven.setid_impuesto_inven(impuestoinven.getId());
					DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
					detalleimpuestoinvenLogic.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(ImpuestoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(impuestoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(impuestoinven);
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
			this.deepLoad(this.impuestoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ImpuestoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(impuestoinvens!=null) {
				for(ImpuestoInven impuestoinven:impuestoinvens) {
					this.deepLoad(impuestoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(impuestoinvens);
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
			if(impuestoinvens!=null) {
				for(ImpuestoInven impuestoinven:impuestoinvens) {
					this.deepLoad(impuestoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(impuestoinvens);
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
			this.getNewConnexionToDeep(ImpuestoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(impuestoinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ImpuestoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(impuestoinvens!=null) {
				for(ImpuestoInven impuestoinven:impuestoinvens) {
					this.deepSave(impuestoinven,isDeep,deepLoadType,clases);
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
			if(impuestoinvens!=null) {
				for(ImpuestoInven impuestoinven:impuestoinvens) {
					this.deepSave(impuestoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getImpuestoInvensBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ImpuestoInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImpuestoInvensBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ImpuestoInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImpuestoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ImpuestoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImpuestoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ImpuestoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			impuestoinvens=impuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImpuestoInvenPorIdEmpresaPorNombreWithConnection(Long id_empresa,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ImpuestoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ImpuestoInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			impuestoinven=impuestoinvenDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImpuestoInvenPorIdEmpresaPorNombre(Long id_empresa,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ImpuestoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ImpuestoInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			impuestoinven=impuestoinvenDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.impuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoInven(this.impuestoinven);
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
			if(ImpuestoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ImpuestoInven impuestoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ImpuestoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(impuestoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoInvenDataAccess.TABLENAME, impuestoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ImpuestoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ImpuestoInvenLogic.registrarAuditoriaDetallesImpuestoInven(connexion,impuestoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(impuestoinven.getIsDeleted()) {
					/*if(!impuestoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ImpuestoInvenDataAccess.TABLENAME, impuestoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ImpuestoInvenLogic.registrarAuditoriaDetallesImpuestoInven(connexion,impuestoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoInvenDataAccess.TABLENAME, impuestoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(impuestoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoInvenDataAccess.TABLENAME, impuestoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ImpuestoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ImpuestoInvenLogic.registrarAuditoriaDetallesImpuestoInven(connexion,impuestoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesImpuestoInven(Connexion connexion,ImpuestoInven impuestoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(impuestoinven.getIsNew()||!impuestoinven.getid_empresa().equals(impuestoinven.getImpuestoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestoinven.getImpuestoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=impuestoinven.getImpuestoInvenOriginal().getid_empresa().toString();
				}
				if(impuestoinven.getid_empresa()!=null)
				{
					strValorNuevo=impuestoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(impuestoinven.getIsNew()||!impuestoinven.getnombre().equals(impuestoinven.getImpuestoInvenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestoinven.getImpuestoInvenOriginal().getnombre()!=null)
				{
					strValorActual=impuestoinven.getImpuestoInvenOriginal().getnombre();
				}
				if(impuestoinven.getnombre()!=null)
				{
					strValorNuevo=impuestoinven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoInvenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveImpuestoInvenRelacionesWithConnection(ImpuestoInven impuestoinven,List<ProductoImpuesto> productoimpuestos,List<DetalleImpuestoInven> detalleimpuestoinvens) throws Exception {

		if(!impuestoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveImpuestoInvenRelacionesBase(impuestoinven,productoimpuestos,detalleimpuestoinvens,true);
		}
	}

	public void saveImpuestoInvenRelaciones(ImpuestoInven impuestoinven,List<ProductoImpuesto> productoimpuestos,List<DetalleImpuestoInven> detalleimpuestoinvens)throws Exception {

		if(!impuestoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveImpuestoInvenRelacionesBase(impuestoinven,productoimpuestos,detalleimpuestoinvens,false);
		}
	}

	public void saveImpuestoInvenRelacionesBase(ImpuestoInven impuestoinven,List<ProductoImpuesto> productoimpuestos,List<DetalleImpuestoInven> detalleimpuestoinvens,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ImpuestoInven-saveRelacionesWithConnection");}
	
			impuestoinven.setProductoImpuestos(productoimpuestos);
			impuestoinven.setDetalleImpuestoInvens(detalleimpuestoinvens);

			this.setImpuestoInven(impuestoinven);

			if(ImpuestoInvenLogicAdditional.validarSaveRelaciones(impuestoinven,this)) {

				ImpuestoInvenLogicAdditional.updateRelacionesToSave(impuestoinven,this);

				if((impuestoinven.getIsNew()||impuestoinven.getIsChanged())&&!impuestoinven.getIsDeleted()) {
					this.saveImpuestoInven();
					this.saveImpuestoInvenRelacionesDetalles(productoimpuestos,detalleimpuestoinvens);

				} else if(impuestoinven.getIsDeleted()) {
					this.saveImpuestoInvenRelacionesDetalles(productoimpuestos,detalleimpuestoinvens);
					this.saveImpuestoInven();
				}

				ImpuestoInvenLogicAdditional.updateRelacionesToSaveAfter(impuestoinven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoImpuestoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoImpuestos(productoimpuestos,true,true);
			DetalleImpuestoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleImpuestoInvens(detalleimpuestoinvens,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveImpuestoInvenRelacionesDetalles(List<ProductoImpuesto> productoimpuestos,List<DetalleImpuestoInven> detalleimpuestoinvens)throws Exception {
		try {
	

			Long idImpuestoInvenActual=this.getImpuestoInven().getId();

			ProductoImpuestoLogic productoimpuestoLogic_Desde_ImpuestoInven=new ProductoImpuestoLogic();
			productoimpuestoLogic_Desde_ImpuestoInven.setProductoImpuestos(productoimpuestos);

			productoimpuestoLogic_Desde_ImpuestoInven.setConnexion(this.getConnexion());
			productoimpuestoLogic_Desde_ImpuestoInven.setDatosCliente(this.datosCliente);

			for(ProductoImpuesto productoimpuesto_Desde_ImpuestoInven:productoimpuestoLogic_Desde_ImpuestoInven.getProductoImpuestos()) {
				productoimpuesto_Desde_ImpuestoInven.setid_impuesto_inven(idImpuestoInvenActual);
			}

			productoimpuestoLogic_Desde_ImpuestoInven.saveProductoImpuestos();

			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic_Desde_ImpuestoInven=new DetalleImpuestoInvenLogic();
			detalleimpuestoinvenLogic_Desde_ImpuestoInven.setDetalleImpuestoInvens(detalleimpuestoinvens);

			detalleimpuestoinvenLogic_Desde_ImpuestoInven.setConnexion(this.getConnexion());
			detalleimpuestoinvenLogic_Desde_ImpuestoInven.setDatosCliente(this.datosCliente);

			for(DetalleImpuestoInven detalleimpuestoinven_Desde_ImpuestoInven:detalleimpuestoinvenLogic_Desde_ImpuestoInven.getDetalleImpuestoInvens()) {
				detalleimpuestoinven_Desde_ImpuestoInven.setid_impuesto_inven(idImpuestoInvenActual);
			}

			detalleimpuestoinvenLogic_Desde_ImpuestoInven.saveDetalleImpuestoInvens();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ImpuestoInvenConstantesFunciones.getClassesForeignKeysOfImpuestoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ImpuestoInvenConstantesFunciones.getClassesRelationshipsOfImpuestoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
