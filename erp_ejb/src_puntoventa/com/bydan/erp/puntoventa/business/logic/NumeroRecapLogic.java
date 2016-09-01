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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.NumeroRecapConstantesFunciones;
import com.bydan.erp.puntoventa.util.NumeroRecapParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.NumeroRecapParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.NumeroRecap;
import com.bydan.erp.puntoventa.business.logic.NumeroRecapLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class NumeroRecapLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NumeroRecapLogic.class);
	
	protected NumeroRecapDataAccess numerorecapDataAccess; 	
	protected NumeroRecap numerorecap;
	protected List<NumeroRecap> numerorecaps;
	protected Object numerorecapObject;	
	protected List<Object> numerorecapsObject;
	
	public static ClassValidator<NumeroRecap> numerorecapValidator = new ClassValidator<NumeroRecap>(NumeroRecap.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NumeroRecapLogicAdditional numerorecapLogicAdditional=null;
	
	public NumeroRecapLogicAdditional getNumeroRecapLogicAdditional() {
		return this.numerorecapLogicAdditional;
	}
	
	public void setNumeroRecapLogicAdditional(NumeroRecapLogicAdditional numerorecapLogicAdditional) {
		try {
			this.numerorecapLogicAdditional=numerorecapLogicAdditional;
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
	
	
	
	
	public  NumeroRecapLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.numerorecapDataAccess = new NumeroRecapDataAccess();
			
			this.numerorecaps= new ArrayList<NumeroRecap>();
			this.numerorecap= new NumeroRecap();
			
			this.numerorecapObject=new Object();
			this.numerorecapsObject=new ArrayList<Object>();
				
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
			
			this.numerorecapDataAccess.setConnexionType(this.connexionType);
			this.numerorecapDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NumeroRecapLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.numerorecapDataAccess = new NumeroRecapDataAccess();
			this.numerorecaps= new ArrayList<NumeroRecap>();
			this.numerorecap= new NumeroRecap();
			this.numerorecapObject=new Object();
			this.numerorecapsObject=new ArrayList<Object>();
			
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
			
			this.numerorecapDataAccess.setConnexionType(this.connexionType);
			this.numerorecapDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NumeroRecap getNumeroRecap() throws Exception {	
		NumeroRecapLogicAdditional.checkNumeroRecapToGet(numerorecap,this.datosCliente,this.arrDatoGeneral);
		NumeroRecapLogicAdditional.updateNumeroRecapToGet(numerorecap,this.arrDatoGeneral);
		
		return numerorecap;
	}
		
	public void setNumeroRecap(NumeroRecap newNumeroRecap) {
		this.numerorecap = newNumeroRecap;
	}
	
	public NumeroRecapDataAccess getNumeroRecapDataAccess() {
		return numerorecapDataAccess;
	}
	
	public void setNumeroRecapDataAccess(NumeroRecapDataAccess newnumerorecapDataAccess) {
		this.numerorecapDataAccess = newnumerorecapDataAccess;
	}
	
	public List<NumeroRecap> getNumeroRecaps() throws Exception {		
		this.quitarNumeroRecapsNulos();
		
		NumeroRecapLogicAdditional.checkNumeroRecapToGets(numerorecaps,this.datosCliente,this.arrDatoGeneral);
		
		for (NumeroRecap numerorecapLocal: numerorecaps ) {
			NumeroRecapLogicAdditional.updateNumeroRecapToGet(numerorecapLocal,this.arrDatoGeneral);
		}
		
		return numerorecaps;
	}
	
	public void setNumeroRecaps(List<NumeroRecap> newNumeroRecaps) {
		this.numerorecaps = newNumeroRecaps;
	}
	
	public Object getNumeroRecapObject() {	
		this.numerorecapObject=this.numerorecapDataAccess.getEntityObject();
		return this.numerorecapObject;
	}
		
	public void setNumeroRecapObject(Object newNumeroRecapObject) {
		this.numerorecapObject = newNumeroRecapObject;
	}
	
	public List<Object> getNumeroRecapsObject() {		
		this.numerorecapsObject=this.numerorecapDataAccess.getEntitiesObject();
		return this.numerorecapsObject;
	}
		
	public void setNumeroRecapsObject(List<Object> newNumeroRecapsObject) {
		this.numerorecapsObject = newNumeroRecapsObject;
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
		
		if(this.numerorecapDataAccess!=null) {
			this.numerorecapDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			numerorecapDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			numerorecapDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		numerorecap = new  NumeroRecap();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			numerorecap=numerorecapDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numerorecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
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
		numerorecap = new  NumeroRecap();
		  		  
        try {
			
			numerorecap=numerorecapDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numerorecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		numerorecap = new  NumeroRecap();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			numerorecap=numerorecapDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numerorecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
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
		numerorecap = new  NumeroRecap();
		  		  
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
		numerorecap = new  NumeroRecap();
		  		  
        try {
			
			numerorecap=numerorecapDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numerorecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		numerorecap = new  NumeroRecap();
		  		  
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
		numerorecap = new  NumeroRecap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =numerorecapDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		numerorecap = new  NumeroRecap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=numerorecapDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		numerorecap = new  NumeroRecap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =numerorecapDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		numerorecap = new  NumeroRecap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=numerorecapDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		numerorecap = new  NumeroRecap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =numerorecapDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		numerorecap = new  NumeroRecap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=numerorecapDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
        try {			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
        try {
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		numerorecap = new  NumeroRecap();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecap=numerorecapDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecap);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
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
		numerorecap = new  NumeroRecap();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecap=numerorecapDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecap);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
		numerorecaps = new  ArrayList<NumeroRecap>();
		  		  
        try {
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNumeroRecapsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		numerorecaps = new  ArrayList<NumeroRecap>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getTodosNumeroRecapsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
	
	public  void  getTodosNumeroRecaps(String sFinalQuery,Pagination pagination)throws Exception {
		numerorecaps = new  ArrayList<NumeroRecap>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNumeroRecap(numerorecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNumeroRecap(NumeroRecap numerorecap) throws Exception {
		Boolean estaValidado=false;
		
		if(numerorecap.getIsNew() || numerorecap.getIsChanged()) { 
			this.invalidValues = numerorecapValidator.getInvalidValues(numerorecap);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(numerorecap);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNumeroRecap(List<NumeroRecap> NumeroRecaps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NumeroRecap numerorecapLocal:numerorecaps) {				
			estaValidadoObjeto=this.validarGuardarNumeroRecap(numerorecapLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNumeroRecap(List<NumeroRecap> NumeroRecaps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNumeroRecap(numerorecaps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNumeroRecap(NumeroRecap NumeroRecap) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNumeroRecap(numerorecap)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NumeroRecap numerorecap) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+numerorecap.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NumeroRecapConstantesFunciones.getNumeroRecapLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"numerorecap","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NumeroRecapConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NumeroRecapConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNumeroRecapWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-saveNumeroRecapWithConnection");connexion.begin();			
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSave(this.numerorecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NumeroRecapLogicAdditional.updateNumeroRecapToSave(this.numerorecap,this.arrDatoGeneral);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.numerorecap,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNumeroRecap();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNumeroRecap(this.numerorecap)) {
				NumeroRecapDataAccess.save(this.numerorecap, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.numerorecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSaveAfter(this.numerorecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNumeroRecap();
			
			connexion.commit();			
			
			if(this.numerorecap.getIsDeleted()) {
				this.numerorecap=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNumeroRecap()throws Exception {	
		try {	
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSave(this.numerorecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NumeroRecapLogicAdditional.updateNumeroRecapToSave(this.numerorecap,this.arrDatoGeneral);
			
			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.numerorecap,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNumeroRecap(this.numerorecap)) {			
				NumeroRecapDataAccess.save(this.numerorecap, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.numerorecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSaveAfter(this.numerorecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.numerorecap.getIsDeleted()) {
				this.numerorecap=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNumeroRecapsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-saveNumeroRecapsWithConnection");connexion.begin();			
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSaves(numerorecaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNumeroRecaps();
			
			Boolean validadoTodosNumeroRecap=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NumeroRecap numerorecapLocal:numerorecaps) {		
				if(numerorecapLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NumeroRecapLogicAdditional.updateNumeroRecapToSave(numerorecapLocal,this.arrDatoGeneral);
	        	
				NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),numerorecapLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNumeroRecap(numerorecapLocal)) {
					NumeroRecapDataAccess.save(numerorecapLocal, connexion);				
				} else {
					validadoTodosNumeroRecap=false;
				}
			}
			
			if(!validadoTodosNumeroRecap) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSavesAfter(numerorecaps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNumeroRecaps();
			
			connexion.commit();		
			
			this.quitarNumeroRecapsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNumeroRecaps()throws Exception {				
		 try {	
			NumeroRecapLogicAdditional.checkNumeroRecapToSaves(numerorecaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNumeroRecap=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NumeroRecap numerorecapLocal:numerorecaps) {				
				if(numerorecapLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NumeroRecapLogicAdditional.updateNumeroRecapToSave(numerorecapLocal,this.arrDatoGeneral);
	        	
				NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),numerorecapLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNumeroRecap(numerorecapLocal)) {				
					NumeroRecapDataAccess.save(numerorecapLocal, connexion);				
				} else {
					validadoTodosNumeroRecap=false;
				}
			}
			
			if(!validadoTodosNumeroRecap) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NumeroRecapLogicAdditional.checkNumeroRecapToSavesAfter(numerorecaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNumeroRecapsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NumeroRecapParameterReturnGeneral procesarAccionNumeroRecaps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NumeroRecap> numerorecaps,NumeroRecapParameterReturnGeneral numerorecapParameterGeneral)throws Exception {
		 try {	
			NumeroRecapParameterReturnGeneral numerorecapReturnGeneral=new NumeroRecapParameterReturnGeneral();
	
			NumeroRecapLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,numerorecaps,numerorecapParameterGeneral,numerorecapReturnGeneral);
			
			return numerorecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NumeroRecapParameterReturnGeneral procesarAccionNumeroRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NumeroRecap> numerorecaps,NumeroRecapParameterReturnGeneral numerorecapParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-procesarAccionNumeroRecapsWithConnection");connexion.begin();			
			
			NumeroRecapParameterReturnGeneral numerorecapReturnGeneral=new NumeroRecapParameterReturnGeneral();
	
			NumeroRecapLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,numerorecaps,numerorecapParameterGeneral,numerorecapReturnGeneral);
			
			this.connexion.commit();
			
			return numerorecapReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NumeroRecapParameterReturnGeneral procesarEventosNumeroRecaps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NumeroRecap> numerorecaps,NumeroRecap numerorecap,NumeroRecapParameterReturnGeneral numerorecapParameterGeneral,Boolean isEsNuevoNumeroRecap,ArrayList<Classe> clases)throws Exception {
		 try {	
			NumeroRecapParameterReturnGeneral numerorecapReturnGeneral=new NumeroRecapParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				numerorecapReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NumeroRecapLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,numerorecaps,numerorecap,numerorecapParameterGeneral,numerorecapReturnGeneral,isEsNuevoNumeroRecap,clases);
			
			return numerorecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NumeroRecapParameterReturnGeneral procesarEventosNumeroRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NumeroRecap> numerorecaps,NumeroRecap numerorecap,NumeroRecapParameterReturnGeneral numerorecapParameterGeneral,Boolean isEsNuevoNumeroRecap,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-procesarEventosNumeroRecapsWithConnection");connexion.begin();			
			
			NumeroRecapParameterReturnGeneral numerorecapReturnGeneral=new NumeroRecapParameterReturnGeneral();
	
			numerorecapReturnGeneral.setNumeroRecap(numerorecap);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				numerorecapReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NumeroRecapLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,numerorecaps,numerorecap,numerorecapParameterGeneral,numerorecapReturnGeneral,isEsNuevoNumeroRecap,clases);
			
			this.connexion.commit();
			
			return numerorecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NumeroRecapParameterReturnGeneral procesarImportacionNumeroRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NumeroRecapParameterReturnGeneral numerorecapParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-procesarImportacionNumeroRecapsWithConnection");connexion.begin();			
			
			NumeroRecapParameterReturnGeneral numerorecapReturnGeneral=new NumeroRecapParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.numerorecaps=new ArrayList<NumeroRecap>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.numerorecap=new NumeroRecap();
				
				
				if(conColumnasBase) {this.numerorecap.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.numerorecap.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.numerorecap.setnumero_recap(arrColumnas[iColumn++]);
				this.numerorecap.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.numerorecaps.add(this.numerorecap);
			}
			
			this.saveNumeroRecaps();
			
			this.connexion.commit();
			
			numerorecapReturnGeneral.setConRetornoEstaProcesado(true);
			numerorecapReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return numerorecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNumeroRecapsEliminados() throws Exception {				
		
		List<NumeroRecap> numerorecapsAux= new ArrayList<NumeroRecap>();
		
		for(NumeroRecap numerorecap:numerorecaps) {
			if(!numerorecap.getIsDeleted()) {
				numerorecapsAux.add(numerorecap);
			}
		}
		
		numerorecaps=numerorecapsAux;
	}
	
	public void quitarNumeroRecapsNulos() throws Exception {				
		
		List<NumeroRecap> numerorecapsAux= new ArrayList<NumeroRecap>();
		
		for(NumeroRecap numerorecap : this.numerorecaps) {
			if(numerorecap==null) {
				numerorecapsAux.add(numerorecap);
			}
		}
		
		//this.numerorecaps=numerorecapsAux;
		
		this.numerorecaps.removeAll(numerorecapsAux);
	}
	
	public void getSetVersionRowNumeroRecapWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(numerorecap.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((numerorecap.getIsDeleted() || (numerorecap.getIsChanged()&&!numerorecap.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=numerorecapDataAccess.getSetVersionRowNumeroRecap(connexion,numerorecap.getId());
				
				if(!numerorecap.getVersionRow().equals(timestamp)) {	
					numerorecap.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				numerorecap.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNumeroRecap()throws Exception {	
		
		if(numerorecap.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((numerorecap.getIsDeleted() || (numerorecap.getIsChanged()&&!numerorecap.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=numerorecapDataAccess.getSetVersionRowNumeroRecap(connexion,numerorecap.getId());
			
			try {							
				if(!numerorecap.getVersionRow().equals(timestamp)) {	
					numerorecap.setVersionRow(timestamp);
				}
				
				numerorecap.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNumeroRecapsWithConnection()throws Exception {	
		if(numerorecaps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NumeroRecap numerorecapAux:numerorecaps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(numerorecapAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(numerorecapAux.getIsDeleted() || (numerorecapAux.getIsChanged()&&!numerorecapAux.getIsNew())) {
						
						timestamp=numerorecapDataAccess.getSetVersionRowNumeroRecap(connexion,numerorecapAux.getId());
						
						if(!numerorecap.getVersionRow().equals(timestamp)) {	
							numerorecapAux.setVersionRow(timestamp);
						}
								
						numerorecapAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNumeroRecaps()throws Exception {	
		if(numerorecaps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NumeroRecap numerorecapAux:numerorecaps) {
					if(numerorecapAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(numerorecapAux.getIsDeleted() || (numerorecapAux.getIsChanged()&&!numerorecapAux.getIsNew())) {
						
						timestamp=numerorecapDataAccess.getSetVersionRowNumeroRecap(connexion,numerorecapAux.getId());
						
						if(!numerorecapAux.getVersionRow().equals(timestamp)) {	
							numerorecapAux.setVersionRow(timestamp);
						}
						
													
						numerorecapAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NumeroRecapParameterReturnGeneral cargarCombosLoteForeignKeyNumeroRecapWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalConexion) throws Exception {
		NumeroRecapParameterReturnGeneral  numerorecapReturnGeneral =new NumeroRecapParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-cargarCombosLoteForeignKeyNumeroRecapWithConnection");connexion.begin();
			
			numerorecapReturnGeneral =new NumeroRecapParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			numerorecapReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			numerorecapReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Conexion> conexionsForeignKey=new ArrayList<Conexion>();
			ConexionLogic conexionLogic=new ConexionLogic();
			conexionLogic.setConnexion(this.connexion);
			conexionLogic.getConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConexion.equals("NONE")) {
				conexionLogic.getTodosConexions(finalQueryGlobalConexion,new Pagination());
				conexionsForeignKey=conexionLogic.getConexions();
			}

			numerorecapReturnGeneral.setconexionsForeignKey(conexionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return numerorecapReturnGeneral;
	}
	
	public NumeroRecapParameterReturnGeneral cargarCombosLoteForeignKeyNumeroRecap(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalConexion) throws Exception {
		NumeroRecapParameterReturnGeneral  numerorecapReturnGeneral =new NumeroRecapParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			numerorecapReturnGeneral =new NumeroRecapParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			numerorecapReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			numerorecapReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Conexion> conexionsForeignKey=new ArrayList<Conexion>();
			ConexionLogic conexionLogic=new ConexionLogic();
			conexionLogic.setConnexion(this.connexion);
			conexionLogic.getConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConexion.equals("NONE")) {
				conexionLogic.getTodosConexions(finalQueryGlobalConexion,new Pagination());
				conexionsForeignKey=conexionLogic.getConexions();
			}

			numerorecapReturnGeneral.setconexionsForeignKey(conexionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return numerorecapReturnGeneral;
	}
	
	
	public void deepLoad(NumeroRecap numerorecap,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NumeroRecapLogicAdditional.updateNumeroRecapToGet(numerorecap,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		numerorecap.setEmpresa(numerorecapDataAccess.getEmpresa(connexion,numerorecap));
		numerorecap.setSucursal(numerorecapDataAccess.getSucursal(connexion,numerorecap));
		numerorecap.setConexion(numerorecapDataAccess.getConexion(connexion,numerorecap));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				numerorecap.setEmpresa(numerorecapDataAccess.getEmpresa(connexion,numerorecap));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				numerorecap.setSucursal(numerorecapDataAccess.getSucursal(connexion,numerorecap));
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				numerorecap.setConexion(numerorecapDataAccess.getConexion(connexion,numerorecap));
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
			numerorecap.setEmpresa(numerorecapDataAccess.getEmpresa(connexion,numerorecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numerorecap.setSucursal(numerorecapDataAccess.getSucursal(connexion,numerorecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Conexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numerorecap.setConexion(numerorecapDataAccess.getConexion(connexion,numerorecap));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		numerorecap.setEmpresa(numerorecapDataAccess.getEmpresa(connexion,numerorecap));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(numerorecap.getEmpresa(),isDeep,deepLoadType,clases);
				
		numerorecap.setSucursal(numerorecapDataAccess.getSucursal(connexion,numerorecap));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(numerorecap.getSucursal(),isDeep,deepLoadType,clases);
				
		numerorecap.setConexion(numerorecapDataAccess.getConexion(connexion,numerorecap));
		ConexionLogic conexionLogic= new ConexionLogic(connexion);
		conexionLogic.deepLoad(numerorecap.getConexion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				numerorecap.setEmpresa(numerorecapDataAccess.getEmpresa(connexion,numerorecap));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(numerorecap.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				numerorecap.setSucursal(numerorecapDataAccess.getSucursal(connexion,numerorecap));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(numerorecap.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				numerorecap.setConexion(numerorecapDataAccess.getConexion(connexion,numerorecap));
				ConexionLogic conexionLogic= new ConexionLogic(connexion);
				conexionLogic.deepLoad(numerorecap.getConexion(),isDeep,deepLoadType,clases);				
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
			numerorecap.setEmpresa(numerorecapDataAccess.getEmpresa(connexion,numerorecap));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(numerorecap.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numerorecap.setSucursal(numerorecapDataAccess.getSucursal(connexion,numerorecap));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(numerorecap.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Conexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numerorecap.setConexion(numerorecapDataAccess.getConexion(connexion,numerorecap));
			ConexionLogic conexionLogic= new ConexionLogic(connexion);
			conexionLogic.deepLoad(numerorecap.getConexion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NumeroRecap numerorecap,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NumeroRecapLogicAdditional.updateNumeroRecapToSave(numerorecap,this.arrDatoGeneral);
			
NumeroRecapDataAccess.save(numerorecap, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(numerorecap.getEmpresa(),connexion);

		SucursalDataAccess.save(numerorecap.getSucursal(),connexion);

		ConexionDataAccess.save(numerorecap.getConexion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(numerorecap.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(numerorecap.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				ConexionDataAccess.save(numerorecap.getConexion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(numerorecap.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(numerorecap.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(numerorecap.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(numerorecap.getSucursal(),isDeep,deepLoadType,clases);
				

		ConexionDataAccess.save(numerorecap.getConexion(),connexion);
		ConexionLogic conexionLogic= new ConexionLogic(connexion);
		conexionLogic.deepLoad(numerorecap.getConexion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(numerorecap.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(numerorecap.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(numerorecap.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(numerorecap.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				ConexionDataAccess.save(numerorecap.getConexion(),connexion);
				ConexionLogic conexionLogic= new ConexionLogic(connexion);
				conexionLogic.deepSave(numerorecap.getConexion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(NumeroRecap.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(numerorecap,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(numerorecap);
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
			this.deepLoad(this.numerorecap,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NumeroRecap.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(numerorecaps!=null) {
				for(NumeroRecap numerorecap:numerorecaps) {
					this.deepLoad(numerorecap,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(numerorecaps);
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
			if(numerorecaps!=null) {
				for(NumeroRecap numerorecap:numerorecaps) {
					this.deepLoad(numerorecap,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(numerorecaps);
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
			this.getNewConnexionToDeep(NumeroRecap.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(numerorecap,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NumeroRecap.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(numerorecaps!=null) {
				for(NumeroRecap numerorecap:numerorecaps) {
					this.deepSave(numerorecap,isDeep,deepLoadType,clases);
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
			if(numerorecaps!=null) {
				for(NumeroRecap numerorecap:numerorecaps) {
					this.deepSave(numerorecap,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNumeroRecapsFK_IdConexionWithConnection(String sFinalQuery,Pagination pagination,Long id_conexion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_conexion,NumeroRecapConstantesFunciones.IDCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConexion);

			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroRecapsFK_IdConexion(String sFinalQuery,Pagination pagination,Long id_conexion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_conexion,NumeroRecapConstantesFunciones.IDCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConexion);

			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNumeroRecapsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NumeroRecapConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroRecapsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NumeroRecapConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNumeroRecapsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NumeroRecapConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroRecapsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NumeroRecapConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NumeroRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(this.numerorecaps);
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
			if(NumeroRecapConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroRecapDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NumeroRecap numerorecap,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NumeroRecapConstantesFunciones.ISCONAUDITORIA) {
				if(numerorecap.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroRecapDataAccess.TABLENAME, numerorecap.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NumeroRecapConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NumeroRecapLogic.registrarAuditoriaDetallesNumeroRecap(connexion,numerorecap,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(numerorecap.getIsDeleted()) {
					/*if(!numerorecap.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NumeroRecapDataAccess.TABLENAME, numerorecap.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NumeroRecapLogic.registrarAuditoriaDetallesNumeroRecap(connexion,numerorecap,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroRecapDataAccess.TABLENAME, numerorecap.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(numerorecap.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroRecapDataAccess.TABLENAME, numerorecap.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NumeroRecapConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NumeroRecapLogic.registrarAuditoriaDetallesNumeroRecap(connexion,numerorecap,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNumeroRecap(Connexion connexion,NumeroRecap numerorecap)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(numerorecap.getIsNew()||!numerorecap.getid_empresa().equals(numerorecap.getNumeroRecapOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numerorecap.getNumeroRecapOriginal().getid_empresa()!=null)
				{
					strValorActual=numerorecap.getNumeroRecapOriginal().getid_empresa().toString();
				}
				if(numerorecap.getid_empresa()!=null)
				{
					strValorNuevo=numerorecap.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroRecapConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(numerorecap.getIsNew()||!numerorecap.getid_sucursal().equals(numerorecap.getNumeroRecapOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numerorecap.getNumeroRecapOriginal().getid_sucursal()!=null)
				{
					strValorActual=numerorecap.getNumeroRecapOriginal().getid_sucursal().toString();
				}
				if(numerorecap.getid_sucursal()!=null)
				{
					strValorNuevo=numerorecap.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroRecapConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(numerorecap.getIsNew()||!numerorecap.getid_conexion().equals(numerorecap.getNumeroRecapOriginal().getid_conexion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numerorecap.getNumeroRecapOriginal().getid_conexion()!=null)
				{
					strValorActual=numerorecap.getNumeroRecapOriginal().getid_conexion().toString();
				}
				if(numerorecap.getid_conexion()!=null)
				{
					strValorNuevo=numerorecap.getid_conexion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroRecapConstantesFunciones.IDCONEXION,strValorActual,strValorNuevo);
			}	
			
			if(numerorecap.getIsNew()||!numerorecap.getnumero_recap().equals(numerorecap.getNumeroRecapOriginal().getnumero_recap()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numerorecap.getNumeroRecapOriginal().getnumero_recap()!=null)
				{
					strValorActual=numerorecap.getNumeroRecapOriginal().getnumero_recap();
				}
				if(numerorecap.getnumero_recap()!=null)
				{
					strValorNuevo=numerorecap.getnumero_recap() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroRecapConstantesFunciones.NUMERORECAP,strValorActual,strValorNuevo);
			}	
			
			if(numerorecap.getIsNew()||!numerorecap.getfecha().equals(numerorecap.getNumeroRecapOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numerorecap.getNumeroRecapOriginal().getfecha()!=null)
				{
					strValorActual=numerorecap.getNumeroRecapOriginal().getfecha().toString();
				}
				if(numerorecap.getfecha()!=null)
				{
					strValorNuevo=numerorecap.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroRecapConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNumeroRecapRelacionesWithConnection(NumeroRecap numerorecap) throws Exception {

		if(!numerorecap.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNumeroRecapRelacionesBase(numerorecap,true);
		}
	}

	public void saveNumeroRecapRelaciones(NumeroRecap numerorecap)throws Exception {

		if(!numerorecap.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNumeroRecapRelacionesBase(numerorecap,false);
		}
	}

	public void saveNumeroRecapRelacionesBase(NumeroRecap numerorecap,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NumeroRecap-saveRelacionesWithConnection");}
	

			this.setNumeroRecap(numerorecap);

			if(NumeroRecapLogicAdditional.validarSaveRelaciones(numerorecap,this)) {

				NumeroRecapLogicAdditional.updateRelacionesToSave(numerorecap,this);

				if((numerorecap.getIsNew()||numerorecap.getIsChanged())&&!numerorecap.getIsDeleted()) {
					this.saveNumeroRecap();
					this.saveNumeroRecapRelacionesDetalles();

				} else if(numerorecap.getIsDeleted()) {
					this.saveNumeroRecapRelacionesDetalles();
					this.saveNumeroRecap();
				}

				NumeroRecapLogicAdditional.updateRelacionesToSaveAfter(numerorecap,this);

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
	
	
	private void saveNumeroRecapRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNumeroRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NumeroRecapConstantesFunciones.getClassesForeignKeysOfNumeroRecap(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNumeroRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NumeroRecapConstantesFunciones.getClassesRelationshipsOfNumeroRecap(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
