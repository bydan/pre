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
import com.bydan.erp.inventario.util.TransferenciaConstantesFunciones;
import com.bydan.erp.inventario.util.TransferenciaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TransferenciaParameterGeneral;
import com.bydan.erp.inventario.business.entity.Transferencia;
import com.bydan.erp.inventario.business.logic.TransferenciaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransferenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransferenciaLogic.class);
	
	protected TransferenciaDataAccess transferenciaDataAccess; 	
	protected Transferencia transferencia;
	protected List<Transferencia> transferencias;
	protected Object transferenciaObject;	
	protected List<Object> transferenciasObject;
	
	public static ClassValidator<Transferencia> transferenciaValidator = new ClassValidator<Transferencia>(Transferencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransferenciaLogicAdditional transferenciaLogicAdditional=null;
	
	public TransferenciaLogicAdditional getTransferenciaLogicAdditional() {
		return this.transferenciaLogicAdditional;
	}
	
	public void setTransferenciaLogicAdditional(TransferenciaLogicAdditional transferenciaLogicAdditional) {
		try {
			this.transferenciaLogicAdditional=transferenciaLogicAdditional;
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
	
	
	
	
	public  TransferenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transferenciaDataAccess = new TransferenciaDataAccess();
			
			this.transferencias= new ArrayList<Transferencia>();
			this.transferencia= new Transferencia();
			
			this.transferenciaObject=new Object();
			this.transferenciasObject=new ArrayList<Object>();
				
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
			
			this.transferenciaDataAccess.setConnexionType(this.connexionType);
			this.transferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransferenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transferenciaDataAccess = new TransferenciaDataAccess();
			this.transferencias= new ArrayList<Transferencia>();
			this.transferencia= new Transferencia();
			this.transferenciaObject=new Object();
			this.transferenciasObject=new ArrayList<Object>();
			
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
			
			this.transferenciaDataAccess.setConnexionType(this.connexionType);
			this.transferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Transferencia getTransferencia() throws Exception {	
		TransferenciaLogicAdditional.checkTransferenciaToGet(transferencia,this.datosCliente,this.arrDatoGeneral);
		TransferenciaLogicAdditional.updateTransferenciaToGet(transferencia,this.arrDatoGeneral);
		
		return transferencia;
	}
		
	public void setTransferencia(Transferencia newTransferencia) {
		this.transferencia = newTransferencia;
	}
	
	public TransferenciaDataAccess getTransferenciaDataAccess() {
		return transferenciaDataAccess;
	}
	
	public void setTransferenciaDataAccess(TransferenciaDataAccess newtransferenciaDataAccess) {
		this.transferenciaDataAccess = newtransferenciaDataAccess;
	}
	
	public List<Transferencia> getTransferencias() throws Exception {		
		this.quitarTransferenciasNulos();
		
		TransferenciaLogicAdditional.checkTransferenciaToGets(transferencias,this.datosCliente,this.arrDatoGeneral);
		
		for (Transferencia transferenciaLocal: transferencias ) {
			TransferenciaLogicAdditional.updateTransferenciaToGet(transferenciaLocal,this.arrDatoGeneral);
		}
		
		return transferencias;
	}
	
	public void setTransferencias(List<Transferencia> newTransferencias) {
		this.transferencias = newTransferencias;
	}
	
	public Object getTransferenciaObject() {	
		this.transferenciaObject=this.transferenciaDataAccess.getEntityObject();
		return this.transferenciaObject;
	}
		
	public void setTransferenciaObject(Object newTransferenciaObject) {
		this.transferenciaObject = newTransferenciaObject;
	}
	
	public List<Object> getTransferenciasObject() {		
		this.transferenciasObject=this.transferenciaDataAccess.getEntitiesObject();
		return this.transferenciasObject;
	}
		
	public void setTransferenciasObject(List<Object> newTransferenciasObject) {
		this.transferenciasObject = newTransferenciasObject;
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
		
		if(this.transferenciaDataAccess!=null) {
			this.transferenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transferencia = new  Transferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transferencia=transferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
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
		transferencia = new  Transferencia();
		  		  
        try {
			
			transferencia=transferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transferencia = new  Transferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transferencia=transferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
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
		transferencia = new  Transferencia();
		  		  
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
		transferencia = new  Transferencia();
		  		  
        try {
			
			transferencia=transferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transferencia = new  Transferencia();
		  		  
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
		transferencia = new  Transferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transferencia = new  Transferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transferencia = new  Transferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transferencia = new  Transferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transferencia = new  Transferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transferencia = new  Transferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transferencias = new  ArrayList<Transferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
		transferencias = new  ArrayList<Transferencia>();
		  		  
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
		transferencias = new  ArrayList<Transferencia>();
		  		  
        try {			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transferencias = new  ArrayList<Transferencia>();
		  		  
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
		transferencias = new  ArrayList<Transferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
		transferencias = new  ArrayList<Transferencia>();
		  		  
        try {
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
		transferencias = new  ArrayList<Transferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
		transferencias = new  ArrayList<Transferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transferencia = new  Transferencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencia=transferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
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
		transferencia = new  Transferencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencia=transferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transferencias = new  ArrayList<Transferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
		transferencias = new  ArrayList<Transferencia>();
		  		  
        try {
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransferenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transferencias = new  ArrayList<Transferencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getTodosTransferenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
	
	public  void  getTodosTransferencias(String sFinalQuery,Pagination pagination)throws Exception {
		transferencias = new  ArrayList<Transferencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransferencia(transferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransferencia(Transferencia transferencia) throws Exception {
		Boolean estaValidado=false;
		
		if(transferencia.getIsNew() || transferencia.getIsChanged()) { 
			this.invalidValues = transferenciaValidator.getInvalidValues(transferencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transferencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransferencia(List<Transferencia> Transferencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Transferencia transferenciaLocal:transferencias) {				
			estaValidadoObjeto=this.validarGuardarTransferencia(transferenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransferencia(List<Transferencia> Transferencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransferencia(transferencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransferencia(Transferencia Transferencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransferencia(transferencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Transferencia transferencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transferencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransferenciaConstantesFunciones.getTransferenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transferencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransferenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-saveTransferenciaWithConnection");connexion.begin();			
			
			TransferenciaLogicAdditional.checkTransferenciaToSave(this.transferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransferenciaLogicAdditional.updateTransferenciaToSave(this.transferencia,this.arrDatoGeneral);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransferencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransferencia(this.transferencia)) {
				TransferenciaDataAccess.save(this.transferencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransferenciaLogicAdditional.checkTransferenciaToSaveAfter(this.transferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransferencia();
			
			connexion.commit();			
			
			if(this.transferencia.getIsDeleted()) {
				this.transferencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransferencia()throws Exception {	
		try {	
			
			TransferenciaLogicAdditional.checkTransferenciaToSave(this.transferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransferenciaLogicAdditional.updateTransferenciaToSave(this.transferencia,this.arrDatoGeneral);
			
			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransferencia(this.transferencia)) {			
				TransferenciaDataAccess.save(this.transferencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransferenciaLogicAdditional.checkTransferenciaToSaveAfter(this.transferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transferencia.getIsDeleted()) {
				this.transferencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransferenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-saveTransferenciasWithConnection");connexion.begin();			
			
			TransferenciaLogicAdditional.checkTransferenciaToSaves(transferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransferencias();
			
			Boolean validadoTodosTransferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Transferencia transferenciaLocal:transferencias) {		
				if(transferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransferenciaLogicAdditional.updateTransferenciaToSave(transferenciaLocal,this.arrDatoGeneral);
	        	
				TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransferencia(transferenciaLocal)) {
					TransferenciaDataAccess.save(transferenciaLocal, connexion);				
				} else {
					validadoTodosTransferencia=false;
				}
			}
			
			if(!validadoTodosTransferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransferenciaLogicAdditional.checkTransferenciaToSavesAfter(transferencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransferencias();
			
			connexion.commit();		
			
			this.quitarTransferenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransferencias()throws Exception {				
		 try {	
			TransferenciaLogicAdditional.checkTransferenciaToSaves(transferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Transferencia transferenciaLocal:transferencias) {				
				if(transferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransferenciaLogicAdditional.updateTransferenciaToSave(transferenciaLocal,this.arrDatoGeneral);
	        	
				TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransferencia(transferenciaLocal)) {				
					TransferenciaDataAccess.save(transferenciaLocal, connexion);				
				} else {
					validadoTodosTransferencia=false;
				}
			}
			
			if(!validadoTodosTransferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransferenciaLogicAdditional.checkTransferenciaToSavesAfter(transferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransferenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransferenciaParameterReturnGeneral procesarAccionTransferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Transferencia> transferencias,TransferenciaParameterReturnGeneral transferenciaParameterGeneral)throws Exception {
		 try {	
			TransferenciaParameterReturnGeneral transferenciaReturnGeneral=new TransferenciaParameterReturnGeneral();
	
			TransferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transferencias,transferenciaParameterGeneral,transferenciaReturnGeneral);
			
			return transferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransferenciaParameterReturnGeneral procesarAccionTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Transferencia> transferencias,TransferenciaParameterReturnGeneral transferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-procesarAccionTransferenciasWithConnection");connexion.begin();			
			
			TransferenciaParameterReturnGeneral transferenciaReturnGeneral=new TransferenciaParameterReturnGeneral();
	
			TransferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transferencias,transferenciaParameterGeneral,transferenciaReturnGeneral);
			
			this.connexion.commit();
			
			return transferenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransferenciaParameterReturnGeneral procesarEventosTransferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Transferencia> transferencias,Transferencia transferencia,TransferenciaParameterReturnGeneral transferenciaParameterGeneral,Boolean isEsNuevoTransferencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransferenciaParameterReturnGeneral transferenciaReturnGeneral=new TransferenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transferencias,transferencia,transferenciaParameterGeneral,transferenciaReturnGeneral,isEsNuevoTransferencia,clases);
			
			return transferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransferenciaParameterReturnGeneral procesarEventosTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Transferencia> transferencias,Transferencia transferencia,TransferenciaParameterReturnGeneral transferenciaParameterGeneral,Boolean isEsNuevoTransferencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-procesarEventosTransferenciasWithConnection");connexion.begin();			
			
			TransferenciaParameterReturnGeneral transferenciaReturnGeneral=new TransferenciaParameterReturnGeneral();
	
			transferenciaReturnGeneral.setTransferencia(transferencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transferencias,transferencia,transferenciaParameterGeneral,transferenciaReturnGeneral,isEsNuevoTransferencia,clases);
			
			this.connexion.commit();
			
			return transferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransferenciaParameterReturnGeneral procesarImportacionTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransferenciaParameterReturnGeneral transferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-procesarImportacionTransferenciasWithConnection");connexion.begin();			
			
			TransferenciaParameterReturnGeneral transferenciaReturnGeneral=new TransferenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transferencias=new ArrayList<Transferencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transferencia=new Transferencia();
				
				
				if(conColumnasBase) {this.transferencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transferencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transferencia.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.transferencia.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.transferencia.setnumero_secuencial(arrColumnas[iColumn++]);
				this.transferencia.setdescripcion(arrColumnas[iColumn++]);
				this.transferencia.setporcentaje_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setvalor_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setstock(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.settotal_otro(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setnumero_items(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.setretencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.transferencia.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.transferencias.add(this.transferencia);
			}
			
			this.saveTransferencias();
			
			this.connexion.commit();
			
			transferenciaReturnGeneral.setConRetornoEstaProcesado(true);
			transferenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransferenciasEliminados() throws Exception {				
		
		List<Transferencia> transferenciasAux= new ArrayList<Transferencia>();
		
		for(Transferencia transferencia:transferencias) {
			if(!transferencia.getIsDeleted()) {
				transferenciasAux.add(transferencia);
			}
		}
		
		transferencias=transferenciasAux;
	}
	
	public void quitarTransferenciasNulos() throws Exception {				
		
		List<Transferencia> transferenciasAux= new ArrayList<Transferencia>();
		
		for(Transferencia transferencia : this.transferencias) {
			if(transferencia==null) {
				transferenciasAux.add(transferencia);
			}
		}
		
		//this.transferencias=transferenciasAux;
		
		this.transferencias.removeAll(transferenciasAux);
	}
	
	public void getSetVersionRowTransferenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transferencia.getIsDeleted() || (transferencia.getIsChanged()&&!transferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transferenciaDataAccess.getSetVersionRowTransferencia(connexion,transferencia.getId());
				
				if(!transferencia.getVersionRow().equals(timestamp)) {	
					transferencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransferencia()throws Exception {	
		
		if(transferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transferencia.getIsDeleted() || (transferencia.getIsChanged()&&!transferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transferenciaDataAccess.getSetVersionRowTransferencia(connexion,transferencia.getId());
			
			try {							
				if(!transferencia.getVersionRow().equals(timestamp)) {	
					transferencia.setVersionRow(timestamp);
				}
				
				transferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransferenciasWithConnection()throws Exception {	
		if(transferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Transferencia transferenciaAux:transferencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transferenciaAux.getIsDeleted() || (transferenciaAux.getIsChanged()&&!transferenciaAux.getIsNew())) {
						
						timestamp=transferenciaDataAccess.getSetVersionRowTransferencia(connexion,transferenciaAux.getId());
						
						if(!transferencia.getVersionRow().equals(timestamp)) {	
							transferenciaAux.setVersionRow(timestamp);
						}
								
						transferenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransferencias()throws Exception {	
		if(transferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Transferencia transferenciaAux:transferencias) {
					if(transferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transferenciaAux.getIsDeleted() || (transferenciaAux.getIsChanged()&&!transferenciaAux.getIsNew())) {
						
						timestamp=transferenciaDataAccess.getSetVersionRowTransferencia(connexion,transferenciaAux.getId());
						
						if(!transferenciaAux.getVersionRow().equals(timestamp)) {	
							transferenciaAux.setVersionRow(timestamp);
						}
						
													
						transferenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TransferenciaParameterReturnGeneral cargarCombosLoteForeignKeyTransferenciaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoInventario,String finalQueryGlobalFormato,String finalQueryGlobalTransportista,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable) throws Exception {
		TransferenciaParameterReturnGeneral  transferenciaReturnGeneral =new TransferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyTransferenciaWithConnection");connexion.begin();
			
			transferenciaReturnGeneral =new TransferenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transferenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			transferenciaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transferenciaReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			transferenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			transferenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			transferenciaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			transferenciaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			transferenciaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			transferenciaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			transferenciaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoInventario> estadoinventariosForeignKey=new ArrayList<EstadoInventario>();
			EstadoInventarioLogic estadoinventarioLogic=new EstadoInventarioLogic();
			estadoinventarioLogic.setConnexion(this.connexion);
			estadoinventarioLogic.getEstadoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoInventario.equals("NONE")) {
				estadoinventarioLogic.getTodosEstadoInventarios(finalQueryGlobalEstadoInventario,new Pagination());
				estadoinventariosForeignKey=estadoinventarioLogic.getEstadoInventarios();
			}

			transferenciaReturnGeneral.setestadoinventariosForeignKey(estadoinventariosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			transferenciaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			transferenciaReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			transferenciaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			transferenciaReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			transferenciaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return transferenciaReturnGeneral;
	}
	
	public TransferenciaParameterReturnGeneral cargarCombosLoteForeignKeyTransferencia(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoInventario,String finalQueryGlobalFormato,String finalQueryGlobalTransportista,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable) throws Exception {
		TransferenciaParameterReturnGeneral  transferenciaReturnGeneral =new TransferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			transferenciaReturnGeneral =new TransferenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transferenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			transferenciaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transferenciaReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			transferenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			transferenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			transferenciaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			transferenciaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			transferenciaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			transferenciaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			transferenciaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoInventario> estadoinventariosForeignKey=new ArrayList<EstadoInventario>();
			EstadoInventarioLogic estadoinventarioLogic=new EstadoInventarioLogic();
			estadoinventarioLogic.setConnexion(this.connexion);
			estadoinventarioLogic.getEstadoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoInventario.equals("NONE")) {
				estadoinventarioLogic.getTodosEstadoInventarios(finalQueryGlobalEstadoInventario,new Pagination());
				estadoinventariosForeignKey=estadoinventarioLogic.getEstadoInventarios();
			}

			transferenciaReturnGeneral.setestadoinventariosForeignKey(estadoinventariosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			transferenciaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			transferenciaReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			transferenciaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			transferenciaReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			transferenciaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return transferenciaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTransferenciaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleTransferenciaLogic detalletransferenciaLogic=new DetalleTransferenciaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTransferenciaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleTransferencia.class));
											
			

			detalletransferenciaLogic.setConnexion(this.getConnexion());
			detalletransferenciaLogic.setDatosCliente(this.datosCliente);
			detalletransferenciaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Transferencia transferencia:this.transferencias) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalletransferenciaLogic.setDetalleTransferencias(transferencia.detalletransferencias);
				detalletransferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Transferencia transferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransferenciaLogicAdditional.updateTransferenciaToGet(transferencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transferencia.setEmpresa(transferenciaDataAccess.getEmpresa(connexion,transferencia));
		transferencia.setSucursal(transferenciaDataAccess.getSucursal(connexion,transferencia));
		transferencia.setModulo(transferenciaDataAccess.getModulo(connexion,transferencia));
		transferencia.setEjercicio(transferenciaDataAccess.getEjercicio(connexion,transferencia));
		transferencia.setPeriodo(transferenciaDataAccess.getPeriodo(connexion,transferencia));
		transferencia.setAnio(transferenciaDataAccess.getAnio(connexion,transferencia));
		transferencia.setMes(transferenciaDataAccess.getMes(connexion,transferencia));
		transferencia.setUsuario(transferenciaDataAccess.getUsuario(connexion,transferencia));
		transferencia.setMoneda(transferenciaDataAccess.getMoneda(connexion,transferencia));
		transferencia.setTipoCambio(transferenciaDataAccess.getTipoCambio(connexion,transferencia));
		transferencia.setEstadoInventario(transferenciaDataAccess.getEstadoInventario(connexion,transferencia));
		transferencia.setFormato(transferenciaDataAccess.getFormato(connexion,transferencia));
		transferencia.setTransportista(transferenciaDataAccess.getTransportista(connexion,transferencia));
		transferencia.setEmpleado(transferenciaDataAccess.getEmpleado(connexion,transferencia));
		transferencia.setTipoTransaccionModulo(transferenciaDataAccess.getTipoTransaccionModulo(connexion,transferencia));
		transferencia.setAsientoContable(transferenciaDataAccess.getAsientoContable(connexion,transferencia));
		transferencia.setDetalleTransferencias(transferenciaDataAccess.getDetalleTransferencias(connexion,transferencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transferencia.setEmpresa(transferenciaDataAccess.getEmpresa(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				transferencia.setSucursal(transferenciaDataAccess.getSucursal(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transferencia.setModulo(transferenciaDataAccess.getModulo(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				transferencia.setEjercicio(transferenciaDataAccess.getEjercicio(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				transferencia.setPeriodo(transferenciaDataAccess.getPeriodo(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				transferencia.setAnio(transferenciaDataAccess.getAnio(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				transferencia.setMes(transferenciaDataAccess.getMes(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				transferencia.setUsuario(transferenciaDataAccess.getUsuario(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				transferencia.setMoneda(transferenciaDataAccess.getMoneda(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				transferencia.setTipoCambio(transferenciaDataAccess.getTipoCambio(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				transferencia.setEstadoInventario(transferenciaDataAccess.getEstadoInventario(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				transferencia.setFormato(transferenciaDataAccess.getFormato(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				transferencia.setTransportista(transferenciaDataAccess.getTransportista(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				transferencia.setEmpleado(transferenciaDataAccess.getEmpleado(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				transferencia.setTipoTransaccionModulo(transferenciaDataAccess.getTipoTransaccionModulo(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				transferencia.setAsientoContable(transferenciaDataAccess.getAsientoContable(connexion,transferencia));
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				transferencia.setDetalleTransferencias(transferenciaDataAccess.getDetalleTransferencias(connexion,transferencia));

				if(this.isConDeep) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(this.connexion);
					detalletransferenciaLogic.setDetalleTransferencias(transferencia.getDetalleTransferencias());
					ArrayList<Classe> classesLocal=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalletransferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(detalletransferenciaLogic.getDetalleTransferencias());
					transferencia.setDetalleTransferencias(detalletransferenciaLogic.getDetalleTransferencias());
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
			transferencia.setEmpresa(transferenciaDataAccess.getEmpresa(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setSucursal(transferenciaDataAccess.getSucursal(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setModulo(transferenciaDataAccess.getModulo(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setEjercicio(transferenciaDataAccess.getEjercicio(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setPeriodo(transferenciaDataAccess.getPeriodo(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setAnio(transferenciaDataAccess.getAnio(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setMes(transferenciaDataAccess.getMes(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setUsuario(transferenciaDataAccess.getUsuario(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setMoneda(transferenciaDataAccess.getMoneda(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setTipoCambio(transferenciaDataAccess.getTipoCambio(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setEstadoInventario(transferenciaDataAccess.getEstadoInventario(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setFormato(transferenciaDataAccess.getFormato(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setTransportista(transferenciaDataAccess.getTransportista(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setEmpleado(transferenciaDataAccess.getEmpleado(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setTipoTransaccionModulo(transferenciaDataAccess.getTipoTransaccionModulo(connexion,transferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setAsientoContable(transferenciaDataAccess.getAsientoContable(connexion,transferencia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTransferencia.class));
			transferencia.setDetalleTransferencias(transferenciaDataAccess.getDetalleTransferencias(connexion,transferencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transferencia.setEmpresa(transferenciaDataAccess.getEmpresa(connexion,transferencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transferencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		transferencia.setSucursal(transferenciaDataAccess.getSucursal(connexion,transferencia));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transferencia.getSucursal(),isDeep,deepLoadType,clases);
				
		transferencia.setModulo(transferenciaDataAccess.getModulo(connexion,transferencia));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transferencia.getModulo(),isDeep,deepLoadType,clases);
				
		transferencia.setEjercicio(transferenciaDataAccess.getEjercicio(connexion,transferencia));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(transferencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		transferencia.setPeriodo(transferenciaDataAccess.getPeriodo(connexion,transferencia));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(transferencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		transferencia.setAnio(transferenciaDataAccess.getAnio(connexion,transferencia));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(transferencia.getAnio(),isDeep,deepLoadType,clases);
				
		transferencia.setMes(transferenciaDataAccess.getMes(connexion,transferencia));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(transferencia.getMes(),isDeep,deepLoadType,clases);
				
		transferencia.setUsuario(transferenciaDataAccess.getUsuario(connexion,transferencia));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(transferencia.getUsuario(),isDeep,deepLoadType,clases);
				
		transferencia.setMoneda(transferenciaDataAccess.getMoneda(connexion,transferencia));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(transferencia.getMoneda(),isDeep,deepLoadType,clases);
				
		transferencia.setTipoCambio(transferenciaDataAccess.getTipoCambio(connexion,transferencia));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(transferencia.getTipoCambio(),isDeep,deepLoadType,clases);
				
		transferencia.setEstadoInventario(transferenciaDataAccess.getEstadoInventario(connexion,transferencia));
		EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
		estadoinventarioLogic.deepLoad(transferencia.getEstadoInventario(),isDeep,deepLoadType,clases);
				
		transferencia.setFormato(transferenciaDataAccess.getFormato(connexion,transferencia));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(transferencia.getFormato(),isDeep,deepLoadType,clases);
				
		transferencia.setTransportista(transferenciaDataAccess.getTransportista(connexion,transferencia));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(transferencia.getTransportista(),isDeep,deepLoadType,clases);
				
		transferencia.setEmpleado(transferenciaDataAccess.getEmpleado(connexion,transferencia));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(transferencia.getEmpleado(),isDeep,deepLoadType,clases);
				
		transferencia.setTipoTransaccionModulo(transferenciaDataAccess.getTipoTransaccionModulo(connexion,transferencia));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(transferencia.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		transferencia.setAsientoContable(transferenciaDataAccess.getAsientoContable(connexion,transferencia));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(transferencia.getAsientoContable(),isDeep,deepLoadType,clases);
				

		transferencia.setDetalleTransferencias(transferenciaDataAccess.getDetalleTransferencias(connexion,transferencia));

		for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
			DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
			detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transferencia.setEmpresa(transferenciaDataAccess.getEmpresa(connexion,transferencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transferencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				transferencia.setSucursal(transferenciaDataAccess.getSucursal(connexion,transferencia));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(transferencia.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transferencia.setModulo(transferenciaDataAccess.getModulo(connexion,transferencia));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(transferencia.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				transferencia.setEjercicio(transferenciaDataAccess.getEjercicio(connexion,transferencia));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(transferencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				transferencia.setPeriodo(transferenciaDataAccess.getPeriodo(connexion,transferencia));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(transferencia.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				transferencia.setAnio(transferenciaDataAccess.getAnio(connexion,transferencia));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(transferencia.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				transferencia.setMes(transferenciaDataAccess.getMes(connexion,transferencia));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(transferencia.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				transferencia.setUsuario(transferenciaDataAccess.getUsuario(connexion,transferencia));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(transferencia.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				transferencia.setMoneda(transferenciaDataAccess.getMoneda(connexion,transferencia));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(transferencia.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				transferencia.setTipoCambio(transferenciaDataAccess.getTipoCambio(connexion,transferencia));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(transferencia.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				transferencia.setEstadoInventario(transferenciaDataAccess.getEstadoInventario(connexion,transferencia));
				EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
				estadoinventarioLogic.deepLoad(transferencia.getEstadoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				transferencia.setFormato(transferenciaDataAccess.getFormato(connexion,transferencia));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(transferencia.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				transferencia.setTransportista(transferenciaDataAccess.getTransportista(connexion,transferencia));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(transferencia.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				transferencia.setEmpleado(transferenciaDataAccess.getEmpleado(connexion,transferencia));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(transferencia.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				transferencia.setTipoTransaccionModulo(transferenciaDataAccess.getTipoTransaccionModulo(connexion,transferencia));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(transferencia.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				transferencia.setAsientoContable(transferenciaDataAccess.getAsientoContable(connexion,transferencia));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(transferencia.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				transferencia.setDetalleTransferencias(transferenciaDataAccess.getDetalleTransferencias(connexion,transferencia));

				for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
					detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
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
			transferencia.setEmpresa(transferenciaDataAccess.getEmpresa(connexion,transferencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transferencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setSucursal(transferenciaDataAccess.getSucursal(connexion,transferencia));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(transferencia.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setModulo(transferenciaDataAccess.getModulo(connexion,transferencia));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(transferencia.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setEjercicio(transferenciaDataAccess.getEjercicio(connexion,transferencia));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(transferencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setPeriodo(transferenciaDataAccess.getPeriodo(connexion,transferencia));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(transferencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setAnio(transferenciaDataAccess.getAnio(connexion,transferencia));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(transferencia.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setMes(transferenciaDataAccess.getMes(connexion,transferencia));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(transferencia.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setUsuario(transferenciaDataAccess.getUsuario(connexion,transferencia));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(transferencia.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setMoneda(transferenciaDataAccess.getMoneda(connexion,transferencia));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(transferencia.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setTipoCambio(transferenciaDataAccess.getTipoCambio(connexion,transferencia));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(transferencia.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setEstadoInventario(transferenciaDataAccess.getEstadoInventario(connexion,transferencia));
			EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
			estadoinventarioLogic.deepLoad(transferencia.getEstadoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setFormato(transferenciaDataAccess.getFormato(connexion,transferencia));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(transferencia.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setTransportista(transferenciaDataAccess.getTransportista(connexion,transferencia));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(transferencia.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setEmpleado(transferenciaDataAccess.getEmpleado(connexion,transferencia));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(transferencia.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setTipoTransaccionModulo(transferenciaDataAccess.getTipoTransaccionModulo(connexion,transferencia));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(transferencia.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferencia.setAsientoContable(transferenciaDataAccess.getAsientoContable(connexion,transferencia));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(transferencia.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTransferencia.class));
			transferencia.setDetalleTransferencias(transferenciaDataAccess.getDetalleTransferencias(connexion,transferencia));

			for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
				DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
				detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Transferencia transferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransferenciaLogicAdditional.updateTransferenciaToSave(transferencia,this.arrDatoGeneral);
			
TransferenciaDataAccess.save(transferencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transferencia.getEmpresa(),connexion);

		SucursalDataAccess.save(transferencia.getSucursal(),connexion);

		ModuloDataAccess.save(transferencia.getModulo(),connexion);

		EjercicioDataAccess.save(transferencia.getEjercicio(),connexion);

		PeriodoDataAccess.save(transferencia.getPeriodo(),connexion);

		AnioDataAccess.save(transferencia.getAnio(),connexion);

		MesDataAccess.save(transferencia.getMes(),connexion);

		UsuarioDataAccess.save(transferencia.getUsuario(),connexion);

		MonedaDataAccess.save(transferencia.getMoneda(),connexion);

		TipoCambioDataAccess.save(transferencia.getTipoCambio(),connexion);

		EstadoInventarioDataAccess.save(transferencia.getEstadoInventario(),connexion);

		FormatoDataAccess.save(transferencia.getFormato(),connexion);

		TransportistaDataAccess.save(transferencia.getTransportista(),connexion);

		EmpleadoDataAccess.save(transferencia.getEmpleado(),connexion);

		TipoTransaccionModuloDataAccess.save(transferencia.getTipoTransaccionModulo(),connexion);

		AsientoContableDataAccess.save(transferencia.getAsientoContable(),connexion);

		for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
			detalletransferencia.setid_transferencia(transferencia.getId());
			DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transferencia.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(transferencia.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transferencia.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(transferencia.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(transferencia.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(transferencia.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(transferencia.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(transferencia.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(transferencia.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(transferencia.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				EstadoInventarioDataAccess.save(transferencia.getEstadoInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(transferencia.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(transferencia.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(transferencia.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(transferencia.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(transferencia.getAsientoContable(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
					detalletransferencia.setid_transferencia(transferencia.getId());
					DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transferencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transferencia.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(transferencia.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transferencia.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(transferencia.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transferencia.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(transferencia.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(transferencia.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(transferencia.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(transferencia.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(transferencia.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(transferencia.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(transferencia.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(transferencia.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(transferencia.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(transferencia.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(transferencia.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(transferencia.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(transferencia.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(transferencia.getTipoCambio(),isDeep,deepLoadType,clases);
				

		EstadoInventarioDataAccess.save(transferencia.getEstadoInventario(),connexion);
		EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
		estadoinventarioLogic.deepLoad(transferencia.getEstadoInventario(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(transferencia.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(transferencia.getFormato(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(transferencia.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(transferencia.getTransportista(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(transferencia.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(transferencia.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(transferencia.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(transferencia.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(transferencia.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(transferencia.getAsientoContable(),isDeep,deepLoadType,clases);
				

		for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
			DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
			detalletransferencia.setid_transferencia(transferencia.getId());
			DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
			detalletransferenciaLogic.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transferencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(transferencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(transferencia.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(transferencia.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transferencia.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(transferencia.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(transferencia.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(transferencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(transferencia.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(transferencia.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(transferencia.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(transferencia.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(transferencia.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(transferencia.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(transferencia.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(transferencia.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(transferencia.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(transferencia.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(transferencia.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(transferencia.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				EstadoInventarioDataAccess.save(transferencia.getEstadoInventario(),connexion);
				EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
				estadoinventarioLogic.deepSave(transferencia.getEstadoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(transferencia.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(transferencia.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(transferencia.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(transferencia.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(transferencia.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(transferencia.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(transferencia.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(transferencia.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(transferencia.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(transferencia.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTransferencia detalletransferencia:transferencia.getDetalleTransferencias()) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
					detalletransferencia.setid_transferencia(transferencia.getId());
					DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
					detalletransferenciaLogic.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Transferencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(transferencia);
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
			this.deepLoad(this.transferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Transferencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transferencias!=null) {
				for(Transferencia transferencia:transferencias) {
					this.deepLoad(transferencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(transferencias);
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
			if(transferencias!=null) {
				for(Transferencia transferencia:transferencias) {
					this.deepLoad(transferencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(transferencias);
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
			this.getNewConnexionToDeep(Transferencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transferencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Transferencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transferencias!=null) {
				for(Transferencia transferencia:transferencias) {
					this.deepSave(transferencia,isDeep,deepLoadType,clases);
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
			if(transferencias!=null) {
				for(Transferencia transferencia:transferencias) {
					this.deepSave(transferencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransferenciasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,TransferenciaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,TransferenciaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,TransferenciaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,TransferenciaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,TransferenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,TransferenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,TransferenciaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,TransferenciaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransferenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransferenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdEstadoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_inventario,TransferenciaConstantesFunciones.IDESTADOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoInventario);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdEstadoInventario(String sFinalQuery,Pagination pagination,Long id_estado_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_inventario,TransferenciaConstantesFunciones.IDESTADOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoInventario);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,TransferenciaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,TransferenciaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,TransferenciaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,TransferenciaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransferenciaConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransferenciaConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,TransferenciaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,TransferenciaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,TransferenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,TransferenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransferenciaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransferenciaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,TransferenciaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,TransferenciaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,TransferenciaConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,TransferenciaConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransferenciasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,TransferenciaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransferenciasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,TransferenciaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			TransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(this.transferencias);
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
			if(TransferenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransferenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Transferencia transferencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransferenciaConstantesFunciones.ISCONAUDITORIA) {
				if(transferencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransferenciaDataAccess.TABLENAME, transferencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransferenciaLogic.registrarAuditoriaDetallesTransferencia(connexion,transferencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transferencia.getIsDeleted()) {
					/*if(!transferencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransferenciaDataAccess.TABLENAME, transferencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransferenciaLogic.registrarAuditoriaDetallesTransferencia(connexion,transferencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransferenciaDataAccess.TABLENAME, transferencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transferencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransferenciaDataAccess.TABLENAME, transferencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransferenciaLogic.registrarAuditoriaDetallesTransferencia(connexion,transferencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransferencia(Connexion connexion,Transferencia transferencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transferencia.getIsNew()||!transferencia.getid_empresa().equals(transferencia.getTransferenciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_empresa()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_empresa().toString();
				}
				if(transferencia.getid_empresa()!=null)
				{
					strValorNuevo=transferencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_sucursal().equals(transferencia.getTransferenciaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_sucursal()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_sucursal().toString();
				}
				if(transferencia.getid_sucursal()!=null)
				{
					strValorNuevo=transferencia.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_modulo().equals(transferencia.getTransferenciaOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_modulo()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_modulo().toString();
				}
				if(transferencia.getid_modulo()!=null)
				{
					strValorNuevo=transferencia.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_ejercicio().equals(transferencia.getTransferenciaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_ejercicio().toString();
				}
				if(transferencia.getid_ejercicio()!=null)
				{
					strValorNuevo=transferencia.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_periodo().equals(transferencia.getTransferenciaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_periodo()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_periodo().toString();
				}
				if(transferencia.getid_periodo()!=null)
				{
					strValorNuevo=transferencia.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_anio().equals(transferencia.getTransferenciaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_anio()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_anio().toString();
				}
				if(transferencia.getid_anio()!=null)
				{
					strValorNuevo=transferencia.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_mes().equals(transferencia.getTransferenciaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_mes()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_mes().toString();
				}
				if(transferencia.getid_mes()!=null)
				{
					strValorNuevo=transferencia.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_usuario().equals(transferencia.getTransferenciaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_usuario()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_usuario().toString();
				}
				if(transferencia.getid_usuario()!=null)
				{
					strValorNuevo=transferencia.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getfecha_emision().equals(transferencia.getTransferenciaOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getfecha_emision()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getfecha_emision().toString();
				}
				if(transferencia.getfecha_emision()!=null)
				{
					strValorNuevo=transferencia.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getfecha_entrega().equals(transferencia.getTransferenciaOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getfecha_entrega()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getfecha_entrega().toString();
				}
				if(transferencia.getfecha_entrega()!=null)
				{
					strValorNuevo=transferencia.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getnumero_secuencial().equals(transferencia.getTransferenciaOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getnumero_secuencial();
				}
				if(transferencia.getnumero_secuencial()!=null)
				{
					strValorNuevo=transferencia.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_moneda().equals(transferencia.getTransferenciaOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_moneda()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_moneda().toString();
				}
				if(transferencia.getid_moneda()!=null)
				{
					strValorNuevo=transferencia.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_tipo_cambio().equals(transferencia.getTransferenciaOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_tipo_cambio().toString();
				}
				if(transferencia.getid_tipo_cambio()!=null)
				{
					strValorNuevo=transferencia.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_estado_inventario().equals(transferencia.getTransferenciaOriginal().getid_estado_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_estado_inventario()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_estado_inventario().toString();
				}
				if(transferencia.getid_estado_inventario()!=null)
				{
					strValorNuevo=transferencia.getid_estado_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDESTADOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_formato().equals(transferencia.getTransferenciaOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_formato()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_formato().toString();
				}
				if(transferencia.getid_formato()!=null)
				{
					strValorNuevo=transferencia.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_transportista().equals(transferencia.getTransferenciaOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_transportista()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_transportista().toString();
				}
				if(transferencia.getid_transportista()!=null)
				{
					strValorNuevo=transferencia.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_empleado().equals(transferencia.getTransferenciaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_empleado()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_empleado().toString();
				}
				if(transferencia.getid_empleado()!=null)
				{
					strValorNuevo=transferencia.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getdescripcion().equals(transferencia.getTransferenciaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getdescripcion()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getdescripcion();
				}
				if(transferencia.getdescripcion()!=null)
				{
					strValorNuevo=transferencia.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getporcentaje_descuento().equals(transferencia.getTransferenciaOriginal().getporcentaje_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getporcentaje_descuento()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getporcentaje_descuento().toString();
				}
				if(transferencia.getporcentaje_descuento()!=null)
				{
					strValorNuevo=transferencia.getporcentaje_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getsuman().equals(transferencia.getTransferenciaOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getsuman()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getsuman().toString();
				}
				if(transferencia.getsuman()!=null)
				{
					strValorNuevo=transferencia.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getice().equals(transferencia.getTransferenciaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getice()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getice().toString();
				}
				if(transferencia.getice()!=null)
				{
					strValorNuevo=transferencia.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getvalor_descuento().equals(transferencia.getTransferenciaOriginal().getvalor_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getvalor_descuento()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getvalor_descuento().toString();
				}
				if(transferencia.getvalor_descuento()!=null)
				{
					strValorNuevo=transferencia.getvalor_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.VALORDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.gettotal_descuento().equals(transferencia.getTransferenciaOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().gettotal_descuento()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().gettotal_descuento().toString();
				}
				if(transferencia.gettotal_descuento()!=null)
				{
					strValorNuevo=transferencia.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getiva().equals(transferencia.getTransferenciaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getiva()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getiva().toString();
				}
				if(transferencia.getiva()!=null)
				{
					strValorNuevo=transferencia.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getstock().equals(transferencia.getTransferenciaOriginal().getstock()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getstock()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getstock().toString();
				}
				if(transferencia.getstock()!=null)
				{
					strValorNuevo=transferencia.getstock().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.STOCK,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getsub_total().equals(transferencia.getTransferenciaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getsub_total()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getsub_total().toString();
				}
				if(transferencia.getsub_total()!=null)
				{
					strValorNuevo=transferencia.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.gettotal_otro().equals(transferencia.getTransferenciaOriginal().gettotal_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().gettotal_otro()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().gettotal_otro().toString();
				}
				if(transferencia.gettotal_otro()!=null)
				{
					strValorNuevo=transferencia.gettotal_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.TOTALOTRO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getultimo_costo().equals(transferencia.getTransferenciaOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getultimo_costo()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getultimo_costo().toString();
				}
				if(transferencia.getultimo_costo()!=null)
				{
					strValorNuevo=transferencia.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getnumero_items().equals(transferencia.getTransferenciaOriginal().getnumero_items()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getnumero_items()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getnumero_items().toString();
				}
				if(transferencia.getnumero_items()!=null)
				{
					strValorNuevo=transferencia.getnumero_items().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.NUMEROITEMS,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getretencion().equals(transferencia.getTransferenciaOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getretencion()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getretencion().toString();
				}
				if(transferencia.getretencion()!=null)
				{
					strValorNuevo=transferencia.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.gettotal().equals(transferencia.getTransferenciaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().gettotal()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().gettotal().toString();
				}
				if(transferencia.gettotal()!=null)
				{
					strValorNuevo=transferencia.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getflete().equals(transferencia.getTransferenciaOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getflete()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getflete().toString();
				}
				if(transferencia.getflete()!=null)
				{
					strValorNuevo=transferencia.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getimpuesto().equals(transferencia.getTransferenciaOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getimpuesto()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getimpuesto().toString();
				}
				if(transferencia.getimpuesto()!=null)
				{
					strValorNuevo=transferencia.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_tipo_transaccion_modulo().equals(transferencia.getTransferenciaOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(transferencia.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=transferencia.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getid_asiento_contable().equals(transferencia.getTransferenciaOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getid_asiento_contable().toString();
				}
				if(transferencia.getid_asiento_contable()!=null)
				{
					strValorNuevo=transferencia.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getnumero_comprobante().equals(transferencia.getTransferenciaOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getnumero_comprobante();
				}
				if(transferencia.getnumero_comprobante()!=null)
				{
					strValorNuevo=transferencia.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(transferencia.getIsNew()||!transferencia.getfecha().equals(transferencia.getTransferenciaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transferencia.getTransferenciaOriginal().getfecha()!=null)
				{
					strValorActual=transferencia.getTransferenciaOriginal().getfecha().toString();
				}
				if(transferencia.getfecha()!=null)
				{
					strValorNuevo=transferencia.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransferenciaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransferenciaRelacionesWithConnection(Transferencia transferencia,List<DetalleTransferencia> detalletransferencias) throws Exception {

		if(!transferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransferenciaRelacionesBase(transferencia,detalletransferencias,true);
		}
	}

	public void saveTransferenciaRelaciones(Transferencia transferencia,List<DetalleTransferencia> detalletransferencias)throws Exception {

		if(!transferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransferenciaRelacionesBase(transferencia,detalletransferencias,false);
		}
	}

	public void saveTransferenciaRelacionesBase(Transferencia transferencia,List<DetalleTransferencia> detalletransferencias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Transferencia-saveRelacionesWithConnection");}
	
			transferencia.setDetalleTransferencias(detalletransferencias);

			this.setTransferencia(transferencia);

			if(TransferenciaLogicAdditional.validarSaveRelaciones(transferencia,this)) {

				TransferenciaLogicAdditional.updateRelacionesToSave(transferencia,this);

				if((transferencia.getIsNew()||transferencia.getIsChanged())&&!transferencia.getIsDeleted()) {
					this.saveTransferencia();
					this.saveTransferenciaRelacionesDetalles(detalletransferencias);

				} else if(transferencia.getIsDeleted()) {
					this.saveTransferenciaRelacionesDetalles(detalletransferencias);
					this.saveTransferencia();
				}

				TransferenciaLogicAdditional.updateRelacionesToSaveAfter(transferencia,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleTransferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleTransferencias(detalletransferencias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTransferenciaRelacionesDetalles(List<DetalleTransferencia> detalletransferencias)throws Exception {
		try {
	

			Long idTransferenciaActual=this.getTransferencia().getId();

			DetalleTransferenciaLogic detalletransferenciaLogic_Desde_Transferencia=new DetalleTransferenciaLogic();
			detalletransferenciaLogic_Desde_Transferencia.setDetalleTransferencias(detalletransferencias);

			detalletransferenciaLogic_Desde_Transferencia.setConnexion(this.getConnexion());
			detalletransferenciaLogic_Desde_Transferencia.setDatosCliente(this.datosCliente);

			for(DetalleTransferencia detalletransferencia_Desde_Transferencia:detalletransferenciaLogic_Desde_Transferencia.getDetalleTransferencias()) {
				detalletransferencia_Desde_Transferencia.setid_transferencia(idTransferenciaActual);
			}

			detalletransferenciaLogic_Desde_Transferencia.saveDetalleTransferencias();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransferenciaConstantesFunciones.getClassesForeignKeysOfTransferencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransferenciaConstantesFunciones.getClassesRelationshipsOfTransferencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
