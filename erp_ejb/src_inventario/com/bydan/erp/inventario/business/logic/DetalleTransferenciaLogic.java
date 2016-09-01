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
import com.bydan.erp.inventario.util.DetalleTransferenciaConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleTransferenciaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleTransferenciaParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleTransferencia;
import com.bydan.erp.inventario.business.logic.DetalleTransferenciaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

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
public class DetalleTransferenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleTransferenciaLogic.class);
	
	protected DetalleTransferenciaDataAccess detalletransferenciaDataAccess; 	
	protected DetalleTransferencia detalletransferencia;
	protected List<DetalleTransferencia> detalletransferencias;
	protected Object detalletransferenciaObject;	
	protected List<Object> detalletransferenciasObject;
	
	public static ClassValidator<DetalleTransferencia> detalletransferenciaValidator = new ClassValidator<DetalleTransferencia>(DetalleTransferencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleTransferenciaLogicAdditional detalletransferenciaLogicAdditional=null;
	
	public DetalleTransferenciaLogicAdditional getDetalleTransferenciaLogicAdditional() {
		return this.detalletransferenciaLogicAdditional;
	}
	
	public void setDetalleTransferenciaLogicAdditional(DetalleTransferenciaLogicAdditional detalletransferenciaLogicAdditional) {
		try {
			this.detalletransferenciaLogicAdditional=detalletransferenciaLogicAdditional;
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
	
	
	
	
	public  DetalleTransferenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalletransferenciaDataAccess = new DetalleTransferenciaDataAccess();
			
			this.detalletransferencias= new ArrayList<DetalleTransferencia>();
			this.detalletransferencia= new DetalleTransferencia();
			
			this.detalletransferenciaObject=new Object();
			this.detalletransferenciasObject=new ArrayList<Object>();
				
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
			
			this.detalletransferenciaDataAccess.setConnexionType(this.connexionType);
			this.detalletransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleTransferenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalletransferenciaDataAccess = new DetalleTransferenciaDataAccess();
			this.detalletransferencias= new ArrayList<DetalleTransferencia>();
			this.detalletransferencia= new DetalleTransferencia();
			this.detalletransferenciaObject=new Object();
			this.detalletransferenciasObject=new ArrayList<Object>();
			
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
			
			this.detalletransferenciaDataAccess.setConnexionType(this.connexionType);
			this.detalletransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleTransferencia getDetalleTransferencia() throws Exception {	
		DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToGet(detalletransferencia,this.datosCliente,this.arrDatoGeneral);
		DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToGet(detalletransferencia,this.arrDatoGeneral);
		
		return detalletransferencia;
	}
		
	public void setDetalleTransferencia(DetalleTransferencia newDetalleTransferencia) {
		this.detalletransferencia = newDetalleTransferencia;
	}
	
	public DetalleTransferenciaDataAccess getDetalleTransferenciaDataAccess() {
		return detalletransferenciaDataAccess;
	}
	
	public void setDetalleTransferenciaDataAccess(DetalleTransferenciaDataAccess newdetalletransferenciaDataAccess) {
		this.detalletransferenciaDataAccess = newdetalletransferenciaDataAccess;
	}
	
	public List<DetalleTransferencia> getDetalleTransferencias() throws Exception {		
		this.quitarDetalleTransferenciasNulos();
		
		DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToGets(detalletransferencias,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleTransferencia detalletransferenciaLocal: detalletransferencias ) {
			DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToGet(detalletransferenciaLocal,this.arrDatoGeneral);
		}
		
		return detalletransferencias;
	}
	
	public void setDetalleTransferencias(List<DetalleTransferencia> newDetalleTransferencias) {
		this.detalletransferencias = newDetalleTransferencias;
	}
	
	public Object getDetalleTransferenciaObject() {	
		this.detalletransferenciaObject=this.detalletransferenciaDataAccess.getEntityObject();
		return this.detalletransferenciaObject;
	}
		
	public void setDetalleTransferenciaObject(Object newDetalleTransferenciaObject) {
		this.detalletransferenciaObject = newDetalleTransferenciaObject;
	}
	
	public List<Object> getDetalleTransferenciasObject() {		
		this.detalletransferenciasObject=this.detalletransferenciaDataAccess.getEntitiesObject();
		return this.detalletransferenciasObject;
	}
		
	public void setDetalleTransferenciasObject(List<Object> newDetalleTransferenciasObject) {
		this.detalletransferenciasObject = newDetalleTransferenciasObject;
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
		
		if(this.detalletransferenciaDataAccess!=null) {
			this.detalletransferenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalletransferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalletransferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalletransferencia = new  DetalleTransferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalletransferencia=detalletransferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
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
		detalletransferencia = new  DetalleTransferencia();
		  		  
        try {
			
			detalletransferencia=detalletransferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalletransferencia = new  DetalleTransferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalletransferencia=detalletransferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
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
		detalletransferencia = new  DetalleTransferencia();
		  		  
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
		detalletransferencia = new  DetalleTransferencia();
		  		  
        try {
			
			detalletransferencia=detalletransferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalletransferencia = new  DetalleTransferencia();
		  		  
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
		detalletransferencia = new  DetalleTransferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalletransferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalletransferencia = new  DetalleTransferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalletransferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalletransferencia = new  DetalleTransferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalletransferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalletransferencia = new  DetalleTransferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalletransferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalletransferencia = new  DetalleTransferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalletransferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalletransferencia = new  DetalleTransferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalletransferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
        try {			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
        try {
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalletransferencia = new  DetalleTransferencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencia=detalletransferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
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
		detalletransferencia = new  DetalleTransferencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencia=detalletransferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		  		  
        try {
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleTransferenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getTodosDetalleTransferenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
	
	public  void  getTodosDetalleTransferencias(String sFinalQuery,Pagination pagination)throws Exception {
		detalletransferencias = new  ArrayList<DetalleTransferencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleTransferencia(detalletransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleTransferencia(DetalleTransferencia detalletransferencia) throws Exception {
		Boolean estaValidado=false;
		
		if(detalletransferencia.getIsNew() || detalletransferencia.getIsChanged()) { 
			this.invalidValues = detalletransferenciaValidator.getInvalidValues(detalletransferencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalletransferencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleTransferencia(List<DetalleTransferencia> DetalleTransferencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleTransferencia detalletransferenciaLocal:detalletransferencias) {				
			estaValidadoObjeto=this.validarGuardarDetalleTransferencia(detalletransferenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleTransferencia(List<DetalleTransferencia> DetalleTransferencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleTransferencia(detalletransferencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleTransferencia(DetalleTransferencia DetalleTransferencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleTransferencia(detalletransferencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleTransferencia detalletransferencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalletransferencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleTransferenciaConstantesFunciones.getDetalleTransferenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalletransferencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleTransferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleTransferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleTransferenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-saveDetalleTransferenciaWithConnection");connexion.begin();			
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSave(this.detalletransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToSave(this.detalletransferencia,this.arrDatoGeneral);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalletransferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleTransferencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleTransferencia(this.detalletransferencia)) {
				DetalleTransferenciaDataAccess.save(this.detalletransferencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalletransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSaveAfter(this.detalletransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleTransferencia();
			
			connexion.commit();			
			
			if(this.detalletransferencia.getIsDeleted()) {
				this.detalletransferencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleTransferencia()throws Exception {	
		try {	
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSave(this.detalletransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToSave(this.detalletransferencia,this.arrDatoGeneral);
			
			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalletransferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleTransferencia(this.detalletransferencia)) {			
				DetalleTransferenciaDataAccess.save(this.detalletransferencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalletransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSaveAfter(this.detalletransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalletransferencia.getIsDeleted()) {
				this.detalletransferencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleTransferenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-saveDetalleTransferenciasWithConnection");connexion.begin();			
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSaves(detalletransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleTransferencias();
			
			Boolean validadoTodosDetalleTransferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleTransferencia detalletransferenciaLocal:detalletransferencias) {		
				if(detalletransferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToSave(detalletransferenciaLocal,this.arrDatoGeneral);
	        	
				DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalletransferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleTransferencia(detalletransferenciaLocal)) {
					DetalleTransferenciaDataAccess.save(detalletransferenciaLocal, connexion);				
				} else {
					validadoTodosDetalleTransferencia=false;
				}
			}
			
			if(!validadoTodosDetalleTransferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSavesAfter(detalletransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleTransferencias();
			
			connexion.commit();		
			
			this.quitarDetalleTransferenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleTransferencias()throws Exception {				
		 try {	
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSaves(detalletransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleTransferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleTransferencia detalletransferenciaLocal:detalletransferencias) {				
				if(detalletransferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToSave(detalletransferenciaLocal,this.arrDatoGeneral);
	        	
				DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalletransferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleTransferencia(detalletransferenciaLocal)) {				
					DetalleTransferenciaDataAccess.save(detalletransferenciaLocal, connexion);				
				} else {
					validadoTodosDetalleTransferencia=false;
				}
			}
			
			if(!validadoTodosDetalleTransferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleTransferenciaLogicAdditional.checkDetalleTransferenciaToSavesAfter(detalletransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleTransferenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleTransferenciaParameterReturnGeneral procesarAccionDetalleTransferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleTransferencia> detalletransferencias,DetalleTransferenciaParameterReturnGeneral detalletransferenciaParameterGeneral)throws Exception {
		 try {	
			DetalleTransferenciaParameterReturnGeneral detalletransferenciaReturnGeneral=new DetalleTransferenciaParameterReturnGeneral();
	
			DetalleTransferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalletransferencias,detalletransferenciaParameterGeneral,detalletransferenciaReturnGeneral);
			
			return detalletransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleTransferenciaParameterReturnGeneral procesarAccionDetalleTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleTransferencia> detalletransferencias,DetalleTransferenciaParameterReturnGeneral detalletransferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-procesarAccionDetalleTransferenciasWithConnection");connexion.begin();			
			
			DetalleTransferenciaParameterReturnGeneral detalletransferenciaReturnGeneral=new DetalleTransferenciaParameterReturnGeneral();
	
			DetalleTransferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalletransferencias,detalletransferenciaParameterGeneral,detalletransferenciaReturnGeneral);
			
			this.connexion.commit();
			
			return detalletransferenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleTransferenciaParameterReturnGeneral procesarEventosDetalleTransferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleTransferencia> detalletransferencias,DetalleTransferencia detalletransferencia,DetalleTransferenciaParameterReturnGeneral detalletransferenciaParameterGeneral,Boolean isEsNuevoDetalleTransferencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleTransferenciaParameterReturnGeneral detalletransferenciaReturnGeneral=new DetalleTransferenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalletransferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleTransferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalletransferencias,detalletransferencia,detalletransferenciaParameterGeneral,detalletransferenciaReturnGeneral,isEsNuevoDetalleTransferencia,clases);
			
			return detalletransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleTransferenciaParameterReturnGeneral procesarEventosDetalleTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleTransferencia> detalletransferencias,DetalleTransferencia detalletransferencia,DetalleTransferenciaParameterReturnGeneral detalletransferenciaParameterGeneral,Boolean isEsNuevoDetalleTransferencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-procesarEventosDetalleTransferenciasWithConnection");connexion.begin();			
			
			DetalleTransferenciaParameterReturnGeneral detalletransferenciaReturnGeneral=new DetalleTransferenciaParameterReturnGeneral();
	
			detalletransferenciaReturnGeneral.setDetalleTransferencia(detalletransferencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalletransferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleTransferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalletransferencias,detalletransferencia,detalletransferenciaParameterGeneral,detalletransferenciaReturnGeneral,isEsNuevoDetalleTransferencia,clases);
			
			this.connexion.commit();
			
			return detalletransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleTransferenciaParameterReturnGeneral procesarImportacionDetalleTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleTransferenciaParameterReturnGeneral detalletransferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-procesarImportacionDetalleTransferenciasWithConnection");connexion.begin();			
			
			DetalleTransferenciaParameterReturnGeneral detalletransferenciaReturnGeneral=new DetalleTransferenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalletransferencias=new ArrayList<DetalleTransferencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalletransferencia=new DetalleTransferencia();
				
				
				if(conColumnasBase) {this.detalletransferencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalletransferencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalletransferencia.setdescripcion(arrColumnas[iColumn++]);
				this.detalletransferencia.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalletransferencia.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalletransferencia.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalletransferencia.setdisponible(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalletransferencia.setlote(arrColumnas[iColumn++]);
				this.detalletransferencia.setfecha_elaboracion_lote(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalletransferencia.setfecha_caducidad_lote(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.detalletransferencias.add(this.detalletransferencia);
			}
			
			this.saveDetalleTransferencias();
			
			this.connexion.commit();
			
			detalletransferenciaReturnGeneral.setConRetornoEstaProcesado(true);
			detalletransferenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalletransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleTransferenciasEliminados() throws Exception {				
		
		List<DetalleTransferencia> detalletransferenciasAux= new ArrayList<DetalleTransferencia>();
		
		for(DetalleTransferencia detalletransferencia:detalletransferencias) {
			if(!detalletransferencia.getIsDeleted()) {
				detalletransferenciasAux.add(detalletransferencia);
			}
		}
		
		detalletransferencias=detalletransferenciasAux;
	}
	
	public void quitarDetalleTransferenciasNulos() throws Exception {				
		
		List<DetalleTransferencia> detalletransferenciasAux= new ArrayList<DetalleTransferencia>();
		
		for(DetalleTransferencia detalletransferencia : this.detalletransferencias) {
			if(detalletransferencia==null) {
				detalletransferenciasAux.add(detalletransferencia);
			}
		}
		
		//this.detalletransferencias=detalletransferenciasAux;
		
		this.detalletransferencias.removeAll(detalletransferenciasAux);
	}
	
	public void getSetVersionRowDetalleTransferenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalletransferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalletransferencia.getIsDeleted() || (detalletransferencia.getIsChanged()&&!detalletransferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalletransferenciaDataAccess.getSetVersionRowDetalleTransferencia(connexion,detalletransferencia.getId());
				
				if(!detalletransferencia.getVersionRow().equals(timestamp)) {	
					detalletransferencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalletransferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleTransferencia()throws Exception {	
		
		if(detalletransferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalletransferencia.getIsDeleted() || (detalletransferencia.getIsChanged()&&!detalletransferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalletransferenciaDataAccess.getSetVersionRowDetalleTransferencia(connexion,detalletransferencia.getId());
			
			try {							
				if(!detalletransferencia.getVersionRow().equals(timestamp)) {	
					detalletransferencia.setVersionRow(timestamp);
				}
				
				detalletransferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleTransferenciasWithConnection()throws Exception {	
		if(detalletransferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleTransferencia detalletransferenciaAux:detalletransferencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalletransferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalletransferenciaAux.getIsDeleted() || (detalletransferenciaAux.getIsChanged()&&!detalletransferenciaAux.getIsNew())) {
						
						timestamp=detalletransferenciaDataAccess.getSetVersionRowDetalleTransferencia(connexion,detalletransferenciaAux.getId());
						
						if(!detalletransferencia.getVersionRow().equals(timestamp)) {	
							detalletransferenciaAux.setVersionRow(timestamp);
						}
								
						detalletransferenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleTransferencias()throws Exception {	
		if(detalletransferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleTransferencia detalletransferenciaAux:detalletransferencias) {
					if(detalletransferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalletransferenciaAux.getIsDeleted() || (detalletransferenciaAux.getIsChanged()&&!detalletransferenciaAux.getIsNew())) {
						
						timestamp=detalletransferenciaDataAccess.getSetVersionRowDetalleTransferencia(connexion,detalletransferenciaAux.getId());
						
						if(!detalletransferenciaAux.getVersionRow().equals(timestamp)) {	
							detalletransferenciaAux.setVersionRow(timestamp);
						}
						
													
						detalletransferenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleTransferenciaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleTransferenciaWithConnection(String finalQueryGlobalTransferencia,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalBodegaEnviar,String finalQueryGlobalNovedadProducto,String finalQueryGlobalEstadoDetalleInventario) throws Exception {
		DetalleTransferenciaParameterReturnGeneral  detalletransferenciaReturnGeneral =new DetalleTransferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleTransferenciaWithConnection");connexion.begin();
			
			detalletransferenciaReturnGeneral =new DetalleTransferenciaParameterReturnGeneral();
			
			

			List<Transferencia> transferenciasForeignKey=new ArrayList<Transferencia>();
			TransferenciaLogic transferenciaLogic=new TransferenciaLogic();
			transferenciaLogic.setConnexion(this.connexion);
			transferenciaLogic.getTransferenciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransferencia.equals("NONE")) {
				transferenciaLogic.getTodosTransferencias(finalQueryGlobalTransferencia,new Pagination());
				transferenciasForeignKey=transferenciaLogic.getTransferencias();
			}

			detalletransferenciaReturnGeneral.settransferenciasForeignKey(transferenciasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalletransferenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalletransferenciaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalletransferenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalletransferenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalletransferenciaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalletransferenciaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalletransferenciaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalletransferenciaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalletransferenciaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Bodega> bodegaenviarsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaenviarLogic=new BodegaLogic();
			bodegaenviarLogic.setConnexion(this.connexion);
			bodegaenviarLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaEnviar.equals("NONE")) {
				bodegaenviarLogic.getTodosBodegas(finalQueryGlobalBodegaEnviar,new Pagination());
				bodegaenviarsForeignKey=bodegaenviarLogic.getBodegas();
			}

			detalletransferenciaReturnGeneral.setbodegaenviarsForeignKey(bodegaenviarsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detalletransferenciaReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<EstadoDetalleInventario> estadodetalleinventariosForeignKey=new ArrayList<EstadoDetalleInventario>();
			EstadoDetalleInventarioLogic estadodetalleinventarioLogic=new EstadoDetalleInventarioLogic();
			estadodetalleinventarioLogic.setConnexion(this.connexion);
			estadodetalleinventarioLogic.getEstadoDetalleInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleInventario.equals("NONE")) {
				estadodetalleinventarioLogic.getTodosEstadoDetalleInventarios(finalQueryGlobalEstadoDetalleInventario,new Pagination());
				estadodetalleinventariosForeignKey=estadodetalleinventarioLogic.getEstadoDetalleInventarios();
			}

			detalletransferenciaReturnGeneral.setestadodetalleinventariosForeignKey(estadodetalleinventariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalletransferenciaReturnGeneral;
	}
	
	public DetalleTransferenciaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleTransferencia(String finalQueryGlobalTransferencia,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalBodegaEnviar,String finalQueryGlobalNovedadProducto,String finalQueryGlobalEstadoDetalleInventario) throws Exception {
		DetalleTransferenciaParameterReturnGeneral  detalletransferenciaReturnGeneral =new DetalleTransferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalletransferenciaReturnGeneral =new DetalleTransferenciaParameterReturnGeneral();
			
			

			List<Transferencia> transferenciasForeignKey=new ArrayList<Transferencia>();
			TransferenciaLogic transferenciaLogic=new TransferenciaLogic();
			transferenciaLogic.setConnexion(this.connexion);
			transferenciaLogic.getTransferenciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransferencia.equals("NONE")) {
				transferenciaLogic.getTodosTransferencias(finalQueryGlobalTransferencia,new Pagination());
				transferenciasForeignKey=transferenciaLogic.getTransferencias();
			}

			detalletransferenciaReturnGeneral.settransferenciasForeignKey(transferenciasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalletransferenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalletransferenciaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalletransferenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalletransferenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalletransferenciaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalletransferenciaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalletransferenciaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalletransferenciaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalletransferenciaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Bodega> bodegaenviarsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaenviarLogic=new BodegaLogic();
			bodegaenviarLogic.setConnexion(this.connexion);
			bodegaenviarLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaEnviar.equals("NONE")) {
				bodegaenviarLogic.getTodosBodegas(finalQueryGlobalBodegaEnviar,new Pagination());
				bodegaenviarsForeignKey=bodegaenviarLogic.getBodegas();
			}

			detalletransferenciaReturnGeneral.setbodegaenviarsForeignKey(bodegaenviarsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detalletransferenciaReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<EstadoDetalleInventario> estadodetalleinventariosForeignKey=new ArrayList<EstadoDetalleInventario>();
			EstadoDetalleInventarioLogic estadodetalleinventarioLogic=new EstadoDetalleInventarioLogic();
			estadodetalleinventarioLogic.setConnexion(this.connexion);
			estadodetalleinventarioLogic.getEstadoDetalleInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleInventario.equals("NONE")) {
				estadodetalleinventarioLogic.getTodosEstadoDetalleInventarios(finalQueryGlobalEstadoDetalleInventario,new Pagination());
				estadodetalleinventariosForeignKey=estadodetalleinventarioLogic.getEstadoDetalleInventarios();
			}

			detalletransferenciaReturnGeneral.setestadodetalleinventariosForeignKey(estadodetalleinventariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalletransferenciaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleTransferencia detalletransferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToGet(detalletransferencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalletransferencia.setTransferencia(detalletransferenciaDataAccess.getTransferencia(connexion,detalletransferencia));
		detalletransferencia.setEmpresa(detalletransferenciaDataAccess.getEmpresa(connexion,detalletransferencia));
		detalletransferencia.setSucursal(detalletransferenciaDataAccess.getSucursal(connexion,detalletransferencia));
		detalletransferencia.setEjercicio(detalletransferenciaDataAccess.getEjercicio(connexion,detalletransferencia));
		detalletransferencia.setPeriodo(detalletransferenciaDataAccess.getPeriodo(connexion,detalletransferencia));
		detalletransferencia.setAnio(detalletransferenciaDataAccess.getAnio(connexion,detalletransferencia));
		detalletransferencia.setMes(detalletransferenciaDataAccess.getMes(connexion,detalletransferencia));
		detalletransferencia.setBodega(detalletransferenciaDataAccess.getBodega(connexion,detalletransferencia));
		detalletransferencia.setProducto(detalletransferenciaDataAccess.getProducto(connexion,detalletransferencia));
		detalletransferencia.setUnidad(detalletransferenciaDataAccess.getUnidad(connexion,detalletransferencia));
		detalletransferencia.setBodegaEnviar(detalletransferenciaDataAccess.getBodegaEnviar(connexion,detalletransferencia));
		detalletransferencia.setNovedadProducto(detalletransferenciaDataAccess.getNovedadProducto(connexion,detalletransferencia));
		detalletransferencia.setEstadoDetalleInventario(detalletransferenciaDataAccess.getEstadoDetalleInventario(connexion,detalletransferencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)) {
				detalletransferencia.setTransferencia(detalletransferenciaDataAccess.getTransferencia(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalletransferencia.setEmpresa(detalletransferenciaDataAccess.getEmpresa(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalletransferencia.setSucursal(detalletransferenciaDataAccess.getSucursal(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalletransferencia.setEjercicio(detalletransferenciaDataAccess.getEjercicio(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalletransferencia.setPeriodo(detalletransferenciaDataAccess.getPeriodo(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalletransferencia.setAnio(detalletransferenciaDataAccess.getAnio(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalletransferencia.setMes(detalletransferenciaDataAccess.getMes(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalletransferencia.setBodega(detalletransferenciaDataAccess.getBodega(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalletransferencia.setProducto(detalletransferenciaDataAccess.getProducto(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalletransferencia.setUnidad(detalletransferenciaDataAccess.getUnidad(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalletransferencia.setBodegaEnviar(detalletransferenciaDataAccess.getBodegaEnviar(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detalletransferencia.setNovedadProducto(detalletransferenciaDataAccess.getNovedadProducto(connexion,detalletransferencia));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				detalletransferencia.setEstadoDetalleInventario(detalletransferenciaDataAccess.getEstadoDetalleInventario(connexion,detalletransferencia));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setTransferencia(detalletransferenciaDataAccess.getTransferencia(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setEmpresa(detalletransferenciaDataAccess.getEmpresa(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setSucursal(detalletransferenciaDataAccess.getSucursal(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setEjercicio(detalletransferenciaDataAccess.getEjercicio(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setPeriodo(detalletransferenciaDataAccess.getPeriodo(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setAnio(detalletransferenciaDataAccess.getAnio(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setMes(detalletransferenciaDataAccess.getMes(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setBodega(detalletransferenciaDataAccess.getBodega(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setProducto(detalletransferenciaDataAccess.getProducto(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setUnidad(detalletransferenciaDataAccess.getUnidad(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setBodegaEnviar(detalletransferenciaDataAccess.getBodegaEnviar(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setNovedadProducto(detalletransferenciaDataAccess.getNovedadProducto(connexion,detalletransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setEstadoDetalleInventario(detalletransferenciaDataAccess.getEstadoDetalleInventario(connexion,detalletransferencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalletransferencia.setTransferencia(detalletransferenciaDataAccess.getTransferencia(connexion,detalletransferencia));
		TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
		transferenciaLogic.deepLoad(detalletransferencia.getTransferencia(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setEmpresa(detalletransferenciaDataAccess.getEmpresa(connexion,detalletransferencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalletransferencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setSucursal(detalletransferenciaDataAccess.getSucursal(connexion,detalletransferencia));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalletransferencia.getSucursal(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setEjercicio(detalletransferenciaDataAccess.getEjercicio(connexion,detalletransferencia));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalletransferencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setPeriodo(detalletransferenciaDataAccess.getPeriodo(connexion,detalletransferencia));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalletransferencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setAnio(detalletransferenciaDataAccess.getAnio(connexion,detalletransferencia));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalletransferencia.getAnio(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setMes(detalletransferenciaDataAccess.getMes(connexion,detalletransferencia));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalletransferencia.getMes(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setBodega(detalletransferenciaDataAccess.getBodega(connexion,detalletransferencia));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalletransferencia.getBodega(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setProducto(detalletransferenciaDataAccess.getProducto(connexion,detalletransferencia));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalletransferencia.getProducto(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setUnidad(detalletransferenciaDataAccess.getUnidad(connexion,detalletransferencia));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalletransferencia.getUnidad(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setBodegaEnviar(detalletransferenciaDataAccess.getBodegaEnviar(connexion,detalletransferencia));
		BodegaLogic bodegaenviarLogic= new BodegaLogic(connexion);
		bodegaenviarLogic.deepLoad(detalletransferencia.getBodegaEnviar(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setNovedadProducto(detalletransferenciaDataAccess.getNovedadProducto(connexion,detalletransferencia));
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detalletransferencia.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		detalletransferencia.setEstadoDetalleInventario(detalletransferenciaDataAccess.getEstadoDetalleInventario(connexion,detalletransferencia));
		EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
		estadodetalleinventarioLogic.deepLoad(detalletransferencia.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)) {
				detalletransferencia.setTransferencia(detalletransferenciaDataAccess.getTransferencia(connexion,detalletransferencia));
				TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
				transferenciaLogic.deepLoad(detalletransferencia.getTransferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalletransferencia.setEmpresa(detalletransferenciaDataAccess.getEmpresa(connexion,detalletransferencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalletransferencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalletransferencia.setSucursal(detalletransferenciaDataAccess.getSucursal(connexion,detalletransferencia));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalletransferencia.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalletransferencia.setEjercicio(detalletransferenciaDataAccess.getEjercicio(connexion,detalletransferencia));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalletransferencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalletransferencia.setPeriodo(detalletransferenciaDataAccess.getPeriodo(connexion,detalletransferencia));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalletransferencia.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalletransferencia.setAnio(detalletransferenciaDataAccess.getAnio(connexion,detalletransferencia));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalletransferencia.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalletransferencia.setMes(detalletransferenciaDataAccess.getMes(connexion,detalletransferencia));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalletransferencia.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalletransferencia.setBodega(detalletransferenciaDataAccess.getBodega(connexion,detalletransferencia));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalletransferencia.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalletransferencia.setProducto(detalletransferenciaDataAccess.getProducto(connexion,detalletransferencia));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalletransferencia.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalletransferencia.setUnidad(detalletransferenciaDataAccess.getUnidad(connexion,detalletransferencia));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalletransferencia.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalletransferencia.setBodegaEnviar(detalletransferenciaDataAccess.getBodegaEnviar(connexion,detalletransferencia));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalletransferencia.getBodegaEnviar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detalletransferencia.setNovedadProducto(detalletransferenciaDataAccess.getNovedadProducto(connexion,detalletransferencia));
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepLoad(detalletransferencia.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				detalletransferencia.setEstadoDetalleInventario(detalletransferenciaDataAccess.getEstadoDetalleInventario(connexion,detalletransferencia));
				EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
				estadodetalleinventarioLogic.deepLoad(detalletransferencia.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setTransferencia(detalletransferenciaDataAccess.getTransferencia(connexion,detalletransferencia));
			TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
			transferenciaLogic.deepLoad(detalletransferencia.getTransferencia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setEmpresa(detalletransferenciaDataAccess.getEmpresa(connexion,detalletransferencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalletransferencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setSucursal(detalletransferenciaDataAccess.getSucursal(connexion,detalletransferencia));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalletransferencia.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setEjercicio(detalletransferenciaDataAccess.getEjercicio(connexion,detalletransferencia));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalletransferencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setPeriodo(detalletransferenciaDataAccess.getPeriodo(connexion,detalletransferencia));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalletransferencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setAnio(detalletransferenciaDataAccess.getAnio(connexion,detalletransferencia));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalletransferencia.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setMes(detalletransferenciaDataAccess.getMes(connexion,detalletransferencia));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalletransferencia.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setBodega(detalletransferenciaDataAccess.getBodega(connexion,detalletransferencia));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalletransferencia.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setProducto(detalletransferenciaDataAccess.getProducto(connexion,detalletransferencia));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalletransferencia.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setUnidad(detalletransferenciaDataAccess.getUnidad(connexion,detalletransferencia));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalletransferencia.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setBodegaEnviar(detalletransferenciaDataAccess.getBodegaEnviar(connexion,detalletransferencia));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalletransferencia.getBodegaEnviar(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setNovedadProducto(detalletransferenciaDataAccess.getNovedadProducto(connexion,detalletransferencia));
			NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
			novedadproductoLogic.deepLoad(detalletransferencia.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletransferencia.setEstadoDetalleInventario(detalletransferenciaDataAccess.getEstadoDetalleInventario(connexion,detalletransferencia));
			EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
			estadodetalleinventarioLogic.deepLoad(detalletransferencia.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleTransferencia detalletransferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleTransferenciaLogicAdditional.updateDetalleTransferenciaToSave(detalletransferencia,this.arrDatoGeneral);
			
DetalleTransferenciaDataAccess.save(detalletransferencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TransferenciaDataAccess.save(detalletransferencia.getTransferencia(),connexion);

		EmpresaDataAccess.save(detalletransferencia.getEmpresa(),connexion);

		SucursalDataAccess.save(detalletransferencia.getSucursal(),connexion);

		EjercicioDataAccess.save(detalletransferencia.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalletransferencia.getPeriodo(),connexion);

		AnioDataAccess.save(detalletransferencia.getAnio(),connexion);

		MesDataAccess.save(detalletransferencia.getMes(),connexion);

		BodegaDataAccess.save(detalletransferencia.getBodega(),connexion);

		ProductoDataAccess.save(detalletransferencia.getProducto(),connexion);

		UnidadDataAccess.save(detalletransferencia.getUnidad(),connexion);

		BodegaDataAccess.save(detalletransferencia.getBodegaEnviar(),connexion);

		NovedadProductoDataAccess.save(detalletransferencia.getNovedadProducto(),connexion);

		EstadoDetalleInventarioDataAccess.save(detalletransferencia.getEstadoDetalleInventario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)) {
				TransferenciaDataAccess.save(detalletransferencia.getTransferencia(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalletransferencia.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalletransferencia.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalletransferencia.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalletransferencia.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalletransferencia.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalletransferencia.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalletransferencia.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalletransferencia.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalletransferencia.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalletransferencia.getBodegaEnviar(),connexion);
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detalletransferencia.getNovedadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				EstadoDetalleInventarioDataAccess.save(detalletransferencia.getEstadoDetalleInventario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TransferenciaDataAccess.save(detalletransferencia.getTransferencia(),connexion);
		TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
		transferenciaLogic.deepLoad(detalletransferencia.getTransferencia(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalletransferencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalletransferencia.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalletransferencia.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalletransferencia.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalletransferencia.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalletransferencia.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalletransferencia.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalletransferencia.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalletransferencia.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalletransferencia.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalletransferencia.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalletransferencia.getMes(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalletransferencia.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalletransferencia.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalletransferencia.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalletransferencia.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalletransferencia.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalletransferencia.getUnidad(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalletransferencia.getBodegaEnviar(),connexion);
		BodegaLogic bodegaenviarLogic= new BodegaLogic(connexion);
		bodegaenviarLogic.deepLoad(detalletransferencia.getBodegaEnviar(),isDeep,deepLoadType,clases);
				

		NovedadProductoDataAccess.save(detalletransferencia.getNovedadProducto(),connexion);
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detalletransferencia.getNovedadProducto(),isDeep,deepLoadType,clases);
				

		EstadoDetalleInventarioDataAccess.save(detalletransferencia.getEstadoDetalleInventario(),connexion);
		EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
		estadodetalleinventarioLogic.deepLoad(detalletransferencia.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)) {
				TransferenciaDataAccess.save(detalletransferencia.getTransferencia(),connexion);
				TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
				transferenciaLogic.deepSave(detalletransferencia.getTransferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalletransferencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalletransferencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalletransferencia.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalletransferencia.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalletransferencia.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalletransferencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalletransferencia.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalletransferencia.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalletransferencia.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalletransferencia.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalletransferencia.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalletransferencia.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalletransferencia.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalletransferencia.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalletransferencia.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalletransferencia.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalletransferencia.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalletransferencia.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalletransferencia.getBodegaEnviar(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalletransferencia.getBodegaEnviar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detalletransferencia.getNovedadProducto(),connexion);
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepSave(detalletransferencia.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				EstadoDetalleInventarioDataAccess.save(detalletransferencia.getEstadoDetalleInventario(),connexion);
				EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
				estadodetalleinventarioLogic.deepSave(detalletransferencia.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleTransferencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(detalletransferencia);
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
			this.deepLoad(this.detalletransferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleTransferencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalletransferencias!=null) {
				for(DetalleTransferencia detalletransferencia:detalletransferencias) {
					this.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(detalletransferencias);
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
			if(detalletransferencias!=null) {
				for(DetalleTransferencia detalletransferencia:detalletransferencias) {
					this.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(detalletransferencias);
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
			this.getNewConnexionToDeep(DetalleTransferencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalletransferencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleTransferencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalletransferencias!=null) {
				for(DetalleTransferencia detalletransferencia:detalletransferencias) {
					this.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
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
			if(detalletransferencias!=null) {
				for(DetalleTransferencia detalletransferencia:detalletransferencias) {
					this.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleTransferenciasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleTransferenciaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleTransferenciaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleTransferenciaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleTransferenciaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdBodegaEnviarWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_enviar)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaEnviar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaEnviar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_enviar,DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaEnviar);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaEnviar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdBodegaEnviar(String sFinalQuery,Pagination pagination,Long id_bodega_enviar)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaEnviar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaEnviar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_enviar,DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaEnviar);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaEnviar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleTransferenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleTransferenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleTransferenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleTransferenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdEstadoDetalleInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_inventario,DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleInventario);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdEstadoDetalleInventario(String sFinalQuery,Pagination pagination,Long id_estado_detalle_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_inventario,DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleInventario);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleTransferenciaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleTransferenciaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdNovedadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdNovedadProducto(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleTransferenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleTransferenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleTransferenciaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleTransferenciaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleTransferenciaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleTransferenciaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdTransferenciaWithConnection(String sFinalQuery,Pagination pagination,Long id_transferencia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transferencia,DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransferencia);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdTransferencia(String sFinalQuery,Pagination pagination,Long id_transferencia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transferencia,DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransferencia);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTransferenciasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleTransferenciaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTransferenciasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleTransferenciaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(this.detalletransferencias);
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
			if(DetalleTransferenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTransferenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleTransferencia detalletransferencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleTransferenciaConstantesFunciones.ISCONAUDITORIA) {
				if(detalletransferencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTransferenciaDataAccess.TABLENAME, detalletransferencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleTransferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleTransferenciaLogic.registrarAuditoriaDetallesDetalleTransferencia(connexion,detalletransferencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalletransferencia.getIsDeleted()) {
					/*if(!detalletransferencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleTransferenciaDataAccess.TABLENAME, detalletransferencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleTransferenciaLogic.registrarAuditoriaDetallesDetalleTransferencia(connexion,detalletransferencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTransferenciaDataAccess.TABLENAME, detalletransferencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalletransferencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTransferenciaDataAccess.TABLENAME, detalletransferencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleTransferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleTransferenciaLogic.registrarAuditoriaDetallesDetalleTransferencia(connexion,detalletransferencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleTransferencia(Connexion connexion,DetalleTransferencia detalletransferencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_transferencia().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_transferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_transferencia()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_transferencia().toString();
				}
				if(detalletransferencia.getid_transferencia()!=null)
				{
					strValorNuevo=detalletransferencia.getid_transferencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_empresa().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_empresa()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_empresa().toString();
				}
				if(detalletransferencia.getid_empresa()!=null)
				{
					strValorNuevo=detalletransferencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_sucursal().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_sucursal().toString();
				}
				if(detalletransferencia.getid_sucursal()!=null)
				{
					strValorNuevo=detalletransferencia.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_ejercicio().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_ejercicio().toString();
				}
				if(detalletransferencia.getid_ejercicio()!=null)
				{
					strValorNuevo=detalletransferencia.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_periodo().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_periodo()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_periodo().toString();
				}
				if(detalletransferencia.getid_periodo()!=null)
				{
					strValorNuevo=detalletransferencia.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_anio().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_anio()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_anio().toString();
				}
				if(detalletransferencia.getid_anio()!=null)
				{
					strValorNuevo=detalletransferencia.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_mes().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_mes()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_mes().toString();
				}
				if(detalletransferencia.getid_mes()!=null)
				{
					strValorNuevo=detalletransferencia.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_bodega().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_bodega()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_bodega().toString();
				}
				if(detalletransferencia.getid_bodega()!=null)
				{
					strValorNuevo=detalletransferencia.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_producto().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_producto()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_producto().toString();
				}
				if(detalletransferencia.getid_producto()!=null)
				{
					strValorNuevo=detalletransferencia.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_unidad().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_unidad()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_unidad().toString();
				}
				if(detalletransferencia.getid_unidad()!=null)
				{
					strValorNuevo=detalletransferencia.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_bodega_enviar().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_bodega_enviar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_bodega_enviar()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_bodega_enviar().toString();
				}
				if(detalletransferencia.getid_bodega_enviar()!=null)
				{
					strValorNuevo=detalletransferencia.getid_bodega_enviar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getdescripcion().equals(detalletransferencia.getDetalleTransferenciaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getdescripcion()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getdescripcion();
				}
				if(detalletransferencia.getdescripcion()!=null)
				{
					strValorNuevo=detalletransferencia.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_novedad_producto().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_novedad_producto()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_novedad_producto().toString();
				}
				if(detalletransferencia.getid_novedad_producto()!=null)
				{
					strValorNuevo=detalletransferencia.getid_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getid_estado_detalle_inventario().equals(detalletransferencia.getDetalleTransferenciaOriginal().getid_estado_detalle_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getid_estado_detalle_inventario()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getid_estado_detalle_inventario().toString();
				}
				if(detalletransferencia.getid_estado_detalle_inventario()!=null)
				{
					strValorNuevo=detalletransferencia.getid_estado_detalle_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getcantidad().equals(detalletransferencia.getDetalleTransferenciaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getcantidad()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getcantidad().toString();
				}
				if(detalletransferencia.getcantidad()!=null)
				{
					strValorNuevo=detalletransferencia.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getdescuento().equals(detalletransferencia.getDetalleTransferenciaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getdescuento()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getdescuento().toString();
				}
				if(detalletransferencia.getdescuento()!=null)
				{
					strValorNuevo=detalletransferencia.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getcosto_unitario().equals(detalletransferencia.getDetalleTransferenciaOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getcosto_unitario().toString();
				}
				if(detalletransferencia.getcosto_unitario()!=null)
				{
					strValorNuevo=detalletransferencia.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getcosto_total().equals(detalletransferencia.getDetalleTransferenciaOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getcosto_total()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getcosto_total().toString();
				}
				if(detalletransferencia.getcosto_total()!=null)
				{
					strValorNuevo=detalletransferencia.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getdisponible().equals(detalletransferencia.getDetalleTransferenciaOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getdisponible()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getdisponible().toString();
				}
				if(detalletransferencia.getdisponible()!=null)
				{
					strValorNuevo=detalletransferencia.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getlote().equals(detalletransferencia.getDetalleTransferenciaOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getlote()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getlote();
				}
				if(detalletransferencia.getlote()!=null)
				{
					strValorNuevo=detalletransferencia.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getfecha_elaboracion_lote().equals(detalletransferencia.getDetalleTransferenciaOriginal().getfecha_elaboracion_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getfecha_elaboracion_lote()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getfecha_elaboracion_lote().toString();
				}
				if(detalletransferencia.getfecha_elaboracion_lote()!=null)
				{
					strValorNuevo=detalletransferencia.getfecha_elaboracion_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getfecha_caducidad_lote().equals(detalletransferencia.getDetalleTransferenciaOriginal().getfecha_caducidad_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getfecha_caducidad_lote()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getfecha_caducidad_lote().toString();
				}
				if(detalletransferencia.getfecha_caducidad_lote()!=null)
				{
					strValorNuevo=detalletransferencia.getfecha_caducidad_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getnumero_comprobante().equals(detalletransferencia.getDetalleTransferenciaOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getnumero_comprobante();
				}
				if(detalletransferencia.getnumero_comprobante()!=null)
				{
					strValorNuevo=detalletransferencia.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detalletransferencia.getIsNew()||!detalletransferencia.getlote_cliente().equals(detalletransferencia.getDetalleTransferenciaOriginal().getlote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletransferencia.getDetalleTransferenciaOriginal().getlote_cliente()!=null)
				{
					strValorActual=detalletransferencia.getDetalleTransferenciaOriginal().getlote_cliente();
				}
				if(detalletransferencia.getlote_cliente()!=null)
				{
					strValorNuevo=detalletransferencia.getlote_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTransferenciaConstantesFunciones.LOTECLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleTransferenciaRelacionesWithConnection(DetalleTransferencia detalletransferencia) throws Exception {

		if(!detalletransferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleTransferenciaRelacionesBase(detalletransferencia,true);
		}
	}

	public void saveDetalleTransferenciaRelaciones(DetalleTransferencia detalletransferencia)throws Exception {

		if(!detalletransferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleTransferenciaRelacionesBase(detalletransferencia,false);
		}
	}

	public void saveDetalleTransferenciaRelacionesBase(DetalleTransferencia detalletransferencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleTransferencia-saveRelacionesWithConnection");}
	

			this.setDetalleTransferencia(detalletransferencia);

			if(DetalleTransferenciaLogicAdditional.validarSaveRelaciones(detalletransferencia,this)) {

				DetalleTransferenciaLogicAdditional.updateRelacionesToSave(detalletransferencia,this);

				if((detalletransferencia.getIsNew()||detalletransferencia.getIsChanged())&&!detalletransferencia.getIsDeleted()) {
					this.saveDetalleTransferencia();
					this.saveDetalleTransferenciaRelacionesDetalles();

				} else if(detalletransferencia.getIsDeleted()) {
					this.saveDetalleTransferenciaRelacionesDetalles();
					this.saveDetalleTransferencia();
				}

				DetalleTransferenciaLogicAdditional.updateRelacionesToSaveAfter(detalletransferencia,this);

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
	
	
	private void saveDetalleTransferenciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleTransferenciaConstantesFunciones.getClassesRelationshipsOfDetalleTransferencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
