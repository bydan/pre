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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.EstadoRegistroFormaPagoBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.EstadoRegistroFormaPagoBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.EstadoRegistroFormaPagoBancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.EstadoRegistroFormaPagoBanco;
//import com.bydan.erp.tesoreria.business.logic.EstadoRegistroFormaPagoBancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoRegistroFormaPagoBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoRegistroFormaPagoBancoLogic.class);
	
	protected EstadoRegistroFormaPagoBancoDataAccess estadoregistroformapagobancoDataAccess; 	
	protected EstadoRegistroFormaPagoBanco estadoregistroformapagobanco;
	protected List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos;
	protected Object estadoregistroformapagobancoObject;	
	protected List<Object> estadoregistroformapagobancosObject;
	
	public static ClassValidator<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancoValidator = new ClassValidator<EstadoRegistroFormaPagoBanco>(EstadoRegistroFormaPagoBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoRegistroFormaPagoBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoregistroformapagobancoDataAccess = new EstadoRegistroFormaPagoBancoDataAccess();
			
			this.estadoregistroformapagobancos= new ArrayList<EstadoRegistroFormaPagoBanco>();
			this.estadoregistroformapagobanco= new EstadoRegistroFormaPagoBanco();
			
			this.estadoregistroformapagobancoObject=new Object();
			this.estadoregistroformapagobancosObject=new ArrayList<Object>();
				
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
			
			this.estadoregistroformapagobancoDataAccess.setConnexionType(this.connexionType);
			this.estadoregistroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoRegistroFormaPagoBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoregistroformapagobancoDataAccess = new EstadoRegistroFormaPagoBancoDataAccess();
			this.estadoregistroformapagobancos= new ArrayList<EstadoRegistroFormaPagoBanco>();
			this.estadoregistroformapagobanco= new EstadoRegistroFormaPagoBanco();
			this.estadoregistroformapagobancoObject=new Object();
			this.estadoregistroformapagobancosObject=new ArrayList<Object>();
			
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
			
			this.estadoregistroformapagobancoDataAccess.setConnexionType(this.connexionType);
			this.estadoregistroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoRegistroFormaPagoBanco getEstadoRegistroFormaPagoBanco() throws Exception {	
		//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToGet(estadoregistroformapagobanco,this.datosCliente,this.arrDatoGeneral);
		//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToGet(estadoregistroformapagobanco,this.arrDatoGeneral);
		
		return estadoregistroformapagobanco;
	}
		
	public void setEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco newEstadoRegistroFormaPagoBanco) {
		this.estadoregistroformapagobanco = newEstadoRegistroFormaPagoBanco;
	}
	
	public EstadoRegistroFormaPagoBancoDataAccess getEstadoRegistroFormaPagoBancoDataAccess() {
		return estadoregistroformapagobancoDataAccess;
	}
	
	public void setEstadoRegistroFormaPagoBancoDataAccess(EstadoRegistroFormaPagoBancoDataAccess newestadoregistroformapagobancoDataAccess) {
		this.estadoregistroformapagobancoDataAccess = newestadoregistroformapagobancoDataAccess;
	}
	
	public List<EstadoRegistroFormaPagoBanco> getEstadoRegistroFormaPagoBancos() throws Exception {		
		this.quitarEstadoRegistroFormaPagoBancosNulos();
		
		//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToGets(estadoregistroformapagobancos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoRegistroFormaPagoBanco estadoregistroformapagobancoLocal: estadoregistroformapagobancos ) {
			//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToGet(estadoregistroformapagobancoLocal,this.arrDatoGeneral);
		}
		
		return estadoregistroformapagobancos;
	}
	
	public void setEstadoRegistroFormaPagoBancos(List<EstadoRegistroFormaPagoBanco> newEstadoRegistroFormaPagoBancos) {
		this.estadoregistroformapagobancos = newEstadoRegistroFormaPagoBancos;
	}
	
	public Object getEstadoRegistroFormaPagoBancoObject() {	
		this.estadoregistroformapagobancoObject=this.estadoregistroformapagobancoDataAccess.getEntityObject();
		return this.estadoregistroformapagobancoObject;
	}
		
	public void setEstadoRegistroFormaPagoBancoObject(Object newEstadoRegistroFormaPagoBancoObject) {
		this.estadoregistroformapagobancoObject = newEstadoRegistroFormaPagoBancoObject;
	}
	
	public List<Object> getEstadoRegistroFormaPagoBancosObject() {		
		this.estadoregistroformapagobancosObject=this.estadoregistroformapagobancoDataAccess.getEntitiesObject();
		return this.estadoregistroformapagobancosObject;
	}
		
	public void setEstadoRegistroFormaPagoBancosObject(List<Object> newEstadoRegistroFormaPagoBancosObject) {
		this.estadoregistroformapagobancosObject = newEstadoRegistroFormaPagoBancosObject;
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
		
		if(this.estadoregistroformapagobancoDataAccess!=null) {
			this.estadoregistroformapagobancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoregistroformapagobancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoregistroformapagobancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoregistroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  		  
        try {
			
			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoregistroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoregistroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  		  
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  		  
        try {
			
			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoregistroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  		  
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoregistroformapagobancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoregistroformapagobancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoregistroformapagobancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoregistroformapagobancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoregistroformapagobancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoregistroformapagobancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
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
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		  		  
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
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		  		  
        try {			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		  		  
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
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
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
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		  		  
        try {
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
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
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
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
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
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
		estadoregistroformapagobanco = new  EstadoRegistroFormaPagoBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoRegistroFormaPagoBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-getTodosEstadoRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
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
	
	public  void  getTodosEstadoRegistroFormaPagoBancos(String sFinalQuery,Pagination pagination)throws Exception {
		estadoregistroformapagobancos = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoregistroformapagobancos=estadoregistroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoregistroformapagobanco.getIsNew() || estadoregistroformapagobanco.getIsChanged()) { 
			this.invalidValues = estadoregistroformapagobancoValidator.getInvalidValues(estadoregistroformapagobanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoregistroformapagobanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoRegistroFormaPagoBanco(List<EstadoRegistroFormaPagoBanco> EstadoRegistroFormaPagoBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoLocal:estadoregistroformapagobancos) {				
			estaValidadoObjeto=this.validarGuardarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoRegistroFormaPagoBanco(List<EstadoRegistroFormaPagoBanco> EstadoRegistroFormaPagoBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco EstadoRegistroFormaPagoBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRegistroFormaPagoBanco(estadoregistroformapagobanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoregistroformapagobanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoRegistroFormaPagoBancoConstantesFunciones.getEstadoRegistroFormaPagoBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoregistroformapagobanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoRegistroFormaPagoBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoRegistroFormaPagoBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoRegistroFormaPagoBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-saveEstadoRegistroFormaPagoBancoWithConnection");connexion.begin();			
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSave(this.estadoregistroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToSave(this.estadoregistroformapagobanco,this.arrDatoGeneral);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoregistroformapagobanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRegistroFormaPagoBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco)) {
				EstadoRegistroFormaPagoBancoDataAccess.save(this.estadoregistroformapagobanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoregistroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSaveAfter(this.estadoregistroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRegistroFormaPagoBanco();
			
			connexion.commit();			
			
			if(this.estadoregistroformapagobanco.getIsDeleted()) {
				this.estadoregistroformapagobanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoRegistroFormaPagoBanco()throws Exception {	
		try {	
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSave(this.estadoregistroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToSave(this.estadoregistroformapagobanco,this.arrDatoGeneral);
			
			EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoregistroformapagobanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco)) {			
				EstadoRegistroFormaPagoBancoDataAccess.save(this.estadoregistroformapagobanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoregistroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSaveAfter(this.estadoregistroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoregistroformapagobanco.getIsDeleted()) {
				this.estadoregistroformapagobanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoRegistroFormaPagoBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-saveEstadoRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSaves(estadoregistroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRegistroFormaPagoBancos();
			
			Boolean validadoTodosEstadoRegistroFormaPagoBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoLocal:estadoregistroformapagobancos) {		
				if(estadoregistroformapagobancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToSave(estadoregistroformapagobancoLocal,this.arrDatoGeneral);
	        	
				EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoregistroformapagobancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancoLocal)) {
					EstadoRegistroFormaPagoBancoDataAccess.save(estadoregistroformapagobancoLocal, connexion);				
				} else {
					validadoTodosEstadoRegistroFormaPagoBanco=false;
				}
			}
			
			if(!validadoTodosEstadoRegistroFormaPagoBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSavesAfter(estadoregistroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRegistroFormaPagoBancos();
			
			connexion.commit();		
			
			this.quitarEstadoRegistroFormaPagoBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoRegistroFormaPagoBancos()throws Exception {				
		 try {	
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSaves(estadoregistroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoRegistroFormaPagoBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoLocal:estadoregistroformapagobancos) {				
				if(estadoregistroformapagobancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToSave(estadoregistroformapagobancoLocal,this.arrDatoGeneral);
	        	
				EstadoRegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoregistroformapagobancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRegistroFormaPagoBanco(estadoregistroformapagobancoLocal)) {				
					EstadoRegistroFormaPagoBancoDataAccess.save(estadoregistroformapagobancoLocal, connexion);				
				} else {
					validadoTodosEstadoRegistroFormaPagoBanco=false;
				}
			}
			
			if(!validadoTodosEstadoRegistroFormaPagoBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoRegistroFormaPagoBancoLogicAdditional.checkEstadoRegistroFormaPagoBancoToSavesAfter(estadoregistroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoRegistroFormaPagoBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRegistroFormaPagoBancoParameterReturnGeneral procesarAccionEstadoRegistroFormaPagoBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoParameterGeneral)throws Exception {
		 try {	
			EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoReturnGeneral=new EstadoRegistroFormaPagoBancoParameterReturnGeneral();
	
			
			return estadoregistroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRegistroFormaPagoBancoParameterReturnGeneral procesarAccionEstadoRegistroFormaPagoBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-procesarAccionEstadoRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoReturnGeneral=new EstadoRegistroFormaPagoBancoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoregistroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRegistroFormaPagoBancoParameterReturnGeneral procesarEventosEstadoRegistroFormaPagoBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoParameterGeneral,Boolean isEsNuevoEstadoRegistroFormaPagoBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoReturnGeneral=new EstadoRegistroFormaPagoBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoregistroformapagobancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoregistroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoRegistroFormaPagoBancoParameterReturnGeneral procesarEventosEstadoRegistroFormaPagoBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoParameterGeneral,Boolean isEsNuevoEstadoRegistroFormaPagoBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-procesarEventosEstadoRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoReturnGeneral=new EstadoRegistroFormaPagoBancoParameterReturnGeneral();
	
			estadoregistroformapagobancoReturnGeneral.setEstadoRegistroFormaPagoBanco(estadoregistroformapagobanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoregistroformapagobancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoregistroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRegistroFormaPagoBancoParameterReturnGeneral procesarImportacionEstadoRegistroFormaPagoBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-procesarImportacionEstadoRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			EstadoRegistroFormaPagoBancoParameterReturnGeneral estadoregistroformapagobancoReturnGeneral=new EstadoRegistroFormaPagoBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoregistroformapagobancos=new ArrayList<EstadoRegistroFormaPagoBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoregistroformapagobanco=new EstadoRegistroFormaPagoBanco();
				
				
				if(conColumnasBase) {this.estadoregistroformapagobanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoregistroformapagobanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoregistroformapagobanco.setcodigo(arrColumnas[iColumn++]);
				this.estadoregistroformapagobanco.setnombre(arrColumnas[iColumn++]);
				
				this.estadoregistroformapagobancos.add(this.estadoregistroformapagobanco);
			}
			
			this.saveEstadoRegistroFormaPagoBancos();
			
			this.connexion.commit();
			
			estadoregistroformapagobancoReturnGeneral.setConRetornoEstaProcesado(true);
			estadoregistroformapagobancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoregistroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoRegistroFormaPagoBancosEliminados() throws Exception {				
		
		List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancosAux= new ArrayList<EstadoRegistroFormaPagoBanco>();
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:estadoregistroformapagobancos) {
			if(!estadoregistroformapagobanco.getIsDeleted()) {
				estadoregistroformapagobancosAux.add(estadoregistroformapagobanco);
			}
		}
		
		estadoregistroformapagobancos=estadoregistroformapagobancosAux;
	}
	
	public void quitarEstadoRegistroFormaPagoBancosNulos() throws Exception {				
		
		List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancosAux= new ArrayList<EstadoRegistroFormaPagoBanco>();
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco : this.estadoregistroformapagobancos) {
			if(estadoregistroformapagobanco==null) {
				estadoregistroformapagobancosAux.add(estadoregistroformapagobanco);
			}
		}
		
		//this.estadoregistroformapagobancos=estadoregistroformapagobancosAux;
		
		this.estadoregistroformapagobancos.removeAll(estadoregistroformapagobancosAux);
	}
	
	public void getSetVersionRowEstadoRegistroFormaPagoBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoregistroformapagobanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoregistroformapagobanco.getIsDeleted() || (estadoregistroformapagobanco.getIsChanged()&&!estadoregistroformapagobanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoregistroformapagobancoDataAccess.getSetVersionRowEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobanco.getId());
				
				if(!estadoregistroformapagobanco.getVersionRow().equals(timestamp)) {	
					estadoregistroformapagobanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoregistroformapagobanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoRegistroFormaPagoBanco()throws Exception {	
		
		if(estadoregistroformapagobanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoregistroformapagobanco.getIsDeleted() || (estadoregistroformapagobanco.getIsChanged()&&!estadoregistroformapagobanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoregistroformapagobancoDataAccess.getSetVersionRowEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobanco.getId());
			
			try {							
				if(!estadoregistroformapagobanco.getVersionRow().equals(timestamp)) {	
					estadoregistroformapagobanco.setVersionRow(timestamp);
				}
				
				estadoregistroformapagobanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoRegistroFormaPagoBancosWithConnection()throws Exception {	
		if(estadoregistroformapagobancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux:estadoregistroformapagobancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoregistroformapagobancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoregistroformapagobancoAux.getIsDeleted() || (estadoregistroformapagobancoAux.getIsChanged()&&!estadoregistroformapagobancoAux.getIsNew())) {
						
						timestamp=estadoregistroformapagobancoDataAccess.getSetVersionRowEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobancoAux.getId());
						
						if(!estadoregistroformapagobanco.getVersionRow().equals(timestamp)) {	
							estadoregistroformapagobancoAux.setVersionRow(timestamp);
						}
								
						estadoregistroformapagobancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoRegistroFormaPagoBancos()throws Exception {	
		if(estadoregistroformapagobancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux:estadoregistroformapagobancos) {
					if(estadoregistroformapagobancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoregistroformapagobancoAux.getIsDeleted() || (estadoregistroformapagobancoAux.getIsChanged()&&!estadoregistroformapagobancoAux.getIsNew())) {
						
						timestamp=estadoregistroformapagobancoDataAccess.getSetVersionRowEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobancoAux.getId());
						
						if(!estadoregistroformapagobancoAux.getVersionRow().equals(timestamp)) {	
							estadoregistroformapagobancoAux.setVersionRow(timestamp);
						}
						
													
						estadoregistroformapagobancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoRegistroFormaPagoBancoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RegistroFormaPagoBancoLogic registroformapagobancoLogic=new RegistroFormaPagoBancoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoRegistroFormaPagoBancoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RegistroFormaPagoBanco.class));
											
			

			registroformapagobancoLogic.setConnexion(this.getConnexion());
			registroformapagobancoLogic.setDatosCliente(this.datosCliente);
			registroformapagobancoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:this.estadoregistroformapagobancos) {
				

				classes=new ArrayList<Classe>();
				classes=RegistroFormaPagoBancoConstantesFunciones.getClassesForeignKeysOfRegistroFormaPagoBanco(new ArrayList<Classe>(),DeepLoadType.NONE);

				registroformapagobancoLogic.setRegistroFormaPagoBancos(estadoregistroformapagobanco.registroformapagobancos);
				registroformapagobancoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoRegistroFormaPagoBancoLogicAdditional.updateEstadoRegistroFormaPagoBancoToGet(estadoregistroformapagobanco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoregistroformapagobanco.setRegistroFormaPagoBancos(estadoregistroformapagobancoDataAccess.getRegistroFormaPagoBancos(connexion,estadoregistroformapagobanco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoregistroformapagobanco.setRegistroFormaPagoBancos(estadoregistroformapagobancoDataAccess.getRegistroFormaPagoBancos(connexion,estadoregistroformapagobanco));

				if(this.isConDeep) {
					RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(this.connexion);
					registroformapagobancoLogic.setRegistroFormaPagoBancos(estadoregistroformapagobanco.getRegistroFormaPagoBancos());
					ArrayList<Classe> classesLocal=RegistroFormaPagoBancoConstantesFunciones.getClassesForeignKeysOfRegistroFormaPagoBanco(new ArrayList<Classe>(),DeepLoadType.NONE);
					registroformapagobancoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(registroformapagobancoLogic.getRegistroFormaPagoBancos());
					estadoregistroformapagobanco.setRegistroFormaPagoBancos(registroformapagobancoLogic.getRegistroFormaPagoBancos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RegistroFormaPagoBanco.class));
			estadoregistroformapagobanco.setRegistroFormaPagoBancos(estadoregistroformapagobancoDataAccess.getRegistroFormaPagoBancos(connexion,estadoregistroformapagobanco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoregistroformapagobanco.setRegistroFormaPagoBancos(estadoregistroformapagobancoDataAccess.getRegistroFormaPagoBancos(connexion,estadoregistroformapagobanco));

		for(RegistroFormaPagoBanco registroformapagobanco:estadoregistroformapagobanco.getRegistroFormaPagoBancos()) {
			RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
			registroformapagobancoLogic.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoregistroformapagobanco.setRegistroFormaPagoBancos(estadoregistroformapagobancoDataAccess.getRegistroFormaPagoBancos(connexion,estadoregistroformapagobanco));

				for(RegistroFormaPagoBanco registroformapagobanco:estadoregistroformapagobanco.getRegistroFormaPagoBancos()) {
					RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
					registroformapagobancoLogic.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RegistroFormaPagoBanco.class));
			estadoregistroformapagobanco.setRegistroFormaPagoBancos(estadoregistroformapagobancoDataAccess.getRegistroFormaPagoBancos(connexion,estadoregistroformapagobanco));

			for(RegistroFormaPagoBanco registroformapagobanco:estadoregistroformapagobanco.getRegistroFormaPagoBancos()) {
				RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
				registroformapagobancoLogic.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoregistroformapagobanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(estadoregistroformapagobanco);
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
			this.deepLoad(this.estadoregistroformapagobanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(this.estadoregistroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoRegistroFormaPagoBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoregistroformapagobancos!=null) {
				for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:estadoregistroformapagobancos) {
					this.deepLoad(estadoregistroformapagobanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
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
			if(estadoregistroformapagobancos!=null) {
				for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:estadoregistroformapagobancos) {
					this.deepLoad(estadoregistroformapagobanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoRegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(estadoregistroformapagobancos);
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
			if(EstadoRegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoRegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIA) {
				if(estadoregistroformapagobanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME, estadoregistroformapagobanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRegistroFormaPagoBancoLogic.registrarAuditoriaDetallesEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoregistroformapagobanco.getIsDeleted()) {
					/*if(!estadoregistroformapagobanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME, estadoregistroformapagobanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoRegistroFormaPagoBancoLogic.registrarAuditoriaDetallesEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME, estadoregistroformapagobanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoregistroformapagobanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME, estadoregistroformapagobanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRegistroFormaPagoBancoLogic.registrarAuditoriaDetallesEstadoRegistroFormaPagoBanco(connexion,estadoregistroformapagobanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoRegistroFormaPagoBanco(Connexion connexion,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoregistroformapagobanco.getIsNew()||!estadoregistroformapagobanco.getcodigo().equals(estadoregistroformapagobanco.getEstadoRegistroFormaPagoBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoregistroformapagobanco.getEstadoRegistroFormaPagoBancoOriginal().getcodigo()!=null)
				{
					strValorActual=estadoregistroformapagobanco.getEstadoRegistroFormaPagoBancoOriginal().getcodigo();
				}
				if(estadoregistroformapagobanco.getcodigo()!=null)
				{
					strValorNuevo=estadoregistroformapagobanco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoregistroformapagobanco.getIsNew()||!estadoregistroformapagobanco.getnombre().equals(estadoregistroformapagobanco.getEstadoRegistroFormaPagoBancoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoregistroformapagobanco.getEstadoRegistroFormaPagoBancoOriginal().getnombre()!=null)
				{
					strValorActual=estadoregistroformapagobanco.getEstadoRegistroFormaPagoBancoOriginal().getnombre();
				}
				if(estadoregistroformapagobanco.getnombre()!=null)
				{
					strValorNuevo=estadoregistroformapagobanco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRegistroFormaPagoBancoConstantesFunciones.getClassesForeignKeysOfEstadoRegistroFormaPagoBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRegistroFormaPagoBancoConstantesFunciones.getClassesRelationshipsOfEstadoRegistroFormaPagoBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
