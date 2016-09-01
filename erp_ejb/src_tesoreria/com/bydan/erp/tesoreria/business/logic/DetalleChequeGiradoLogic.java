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
import com.bydan.erp.tesoreria.util.DetalleChequeGiradoConstantesFunciones;
import com.bydan.erp.tesoreria.util.DetalleChequeGiradoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.DetalleChequeGiradoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.DetalleChequeGirado;
import com.bydan.erp.tesoreria.business.logic.DetalleChequeGiradoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleChequeGiradoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleChequeGiradoLogic.class);
	
	protected DetalleChequeGiradoDataAccess detallechequegiradoDataAccess; 	
	protected DetalleChequeGirado detallechequegirado;
	protected List<DetalleChequeGirado> detallechequegirados;
	protected Object detallechequegiradoObject;	
	protected List<Object> detallechequegiradosObject;
	
	public static ClassValidator<DetalleChequeGirado> detallechequegiradoValidator = new ClassValidator<DetalleChequeGirado>(DetalleChequeGirado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleChequeGiradoLogicAdditional detallechequegiradoLogicAdditional=null;
	
	public DetalleChequeGiradoLogicAdditional getDetalleChequeGiradoLogicAdditional() {
		return this.detallechequegiradoLogicAdditional;
	}
	
	public void setDetalleChequeGiradoLogicAdditional(DetalleChequeGiradoLogicAdditional detallechequegiradoLogicAdditional) {
		try {
			this.detallechequegiradoLogicAdditional=detallechequegiradoLogicAdditional;
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
	
	
	
	
	public  DetalleChequeGiradoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallechequegiradoDataAccess = new DetalleChequeGiradoDataAccess();
			
			this.detallechequegirados= new ArrayList<DetalleChequeGirado>();
			this.detallechequegirado= new DetalleChequeGirado();
			
			this.detallechequegiradoObject=new Object();
			this.detallechequegiradosObject=new ArrayList<Object>();
				
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
			
			this.detallechequegiradoDataAccess.setConnexionType(this.connexionType);
			this.detallechequegiradoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleChequeGiradoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallechequegiradoDataAccess = new DetalleChequeGiradoDataAccess();
			this.detallechequegirados= new ArrayList<DetalleChequeGirado>();
			this.detallechequegirado= new DetalleChequeGirado();
			this.detallechequegiradoObject=new Object();
			this.detallechequegiradosObject=new ArrayList<Object>();
			
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
			
			this.detallechequegiradoDataAccess.setConnexionType(this.connexionType);
			this.detallechequegiradoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleChequeGirado getDetalleChequeGirado() throws Exception {	
		DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToGet(detallechequegirado,this.datosCliente,this.arrDatoGeneral);
		DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToGet(detallechequegirado,this.arrDatoGeneral);
		
		return detallechequegirado;
	}
		
	public void setDetalleChequeGirado(DetalleChequeGirado newDetalleChequeGirado) {
		this.detallechequegirado = newDetalleChequeGirado;
	}
	
	public DetalleChequeGiradoDataAccess getDetalleChequeGiradoDataAccess() {
		return detallechequegiradoDataAccess;
	}
	
	public void setDetalleChequeGiradoDataAccess(DetalleChequeGiradoDataAccess newdetallechequegiradoDataAccess) {
		this.detallechequegiradoDataAccess = newdetallechequegiradoDataAccess;
	}
	
	public List<DetalleChequeGirado> getDetalleChequeGirados() throws Exception {		
		this.quitarDetalleChequeGiradosNulos();
		
		DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToGets(detallechequegirados,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleChequeGirado detallechequegiradoLocal: detallechequegirados ) {
			DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToGet(detallechequegiradoLocal,this.arrDatoGeneral);
		}
		
		return detallechequegirados;
	}
	
	public void setDetalleChequeGirados(List<DetalleChequeGirado> newDetalleChequeGirados) {
		this.detallechequegirados = newDetalleChequeGirados;
	}
	
	public Object getDetalleChequeGiradoObject() {	
		this.detallechequegiradoObject=this.detallechequegiradoDataAccess.getEntityObject();
		return this.detallechequegiradoObject;
	}
		
	public void setDetalleChequeGiradoObject(Object newDetalleChequeGiradoObject) {
		this.detallechequegiradoObject = newDetalleChequeGiradoObject;
	}
	
	public List<Object> getDetalleChequeGiradosObject() {		
		this.detallechequegiradosObject=this.detallechequegiradoDataAccess.getEntitiesObject();
		return this.detallechequegiradosObject;
	}
		
	public void setDetalleChequeGiradosObject(List<Object> newDetalleChequeGiradosObject) {
		this.detallechequegiradosObject = newDetalleChequeGiradosObject;
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
		
		if(this.detallechequegiradoDataAccess!=null) {
			this.detallechequegiradoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallechequegiradoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallechequegiradoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallechequegirado = new  DetalleChequeGirado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallechequegirado=detallechequegiradoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallechequegirado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
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
		detallechequegirado = new  DetalleChequeGirado();
		  		  
        try {
			
			detallechequegirado=detallechequegiradoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallechequegirado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallechequegirado = new  DetalleChequeGirado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallechequegirado=detallechequegiradoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallechequegirado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
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
		detallechequegirado = new  DetalleChequeGirado();
		  		  
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
		detallechequegirado = new  DetalleChequeGirado();
		  		  
        try {
			
			detallechequegirado=detallechequegiradoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallechequegirado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallechequegirado = new  DetalleChequeGirado();
		  		  
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
		detallechequegirado = new  DetalleChequeGirado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallechequegiradoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallechequegirado = new  DetalleChequeGirado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallechequegiradoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallechequegirado = new  DetalleChequeGirado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallechequegiradoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallechequegirado = new  DetalleChequeGirado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallechequegiradoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallechequegirado = new  DetalleChequeGirado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallechequegiradoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallechequegirado = new  DetalleChequeGirado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallechequegiradoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
        try {			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
        try {
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallechequegirado = new  DetalleChequeGirado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirado=detallechequegiradoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
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
		detallechequegirado = new  DetalleChequeGirado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirado=detallechequegiradoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		  		  
        try {
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleChequeGiradosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getTodosDetalleChequeGiradosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
	
	public  void  getTodosDetalleChequeGirados(String sFinalQuery,Pagination pagination)throws Exception {
		detallechequegirados = new  ArrayList<DetalleChequeGirado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleChequeGirado(detallechequegirados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleChequeGirado(DetalleChequeGirado detallechequegirado) throws Exception {
		Boolean estaValidado=false;
		
		if(detallechequegirado.getIsNew() || detallechequegirado.getIsChanged()) { 
			this.invalidValues = detallechequegiradoValidator.getInvalidValues(detallechequegirado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallechequegirado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleChequeGirado(List<DetalleChequeGirado> DetalleChequeGirados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleChequeGirado detallechequegiradoLocal:detallechequegirados) {				
			estaValidadoObjeto=this.validarGuardarDetalleChequeGirado(detallechequegiradoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleChequeGirado(List<DetalleChequeGirado> DetalleChequeGirados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleChequeGirado(detallechequegirados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleChequeGirado(DetalleChequeGirado DetalleChequeGirado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleChequeGirado(detallechequegirado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleChequeGirado detallechequegirado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallechequegirado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleChequeGiradoConstantesFunciones.getDetalleChequeGiradoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallechequegirado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleChequeGiradoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleChequeGiradoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleChequeGiradoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-saveDetalleChequeGiradoWithConnection");connexion.begin();			
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSave(this.detallechequegirado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToSave(this.detallechequegirado,this.arrDatoGeneral);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallechequegirado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleChequeGirado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleChequeGirado(this.detallechequegirado)) {
				DetalleChequeGiradoDataAccess.save(this.detallechequegirado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallechequegirado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSaveAfter(this.detallechequegirado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleChequeGirado();
			
			connexion.commit();			
			
			if(this.detallechequegirado.getIsDeleted()) {
				this.detallechequegirado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleChequeGirado()throws Exception {	
		try {	
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSave(this.detallechequegirado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToSave(this.detallechequegirado,this.arrDatoGeneral);
			
			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallechequegirado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleChequeGirado(this.detallechequegirado)) {			
				DetalleChequeGiradoDataAccess.save(this.detallechequegirado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallechequegirado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSaveAfter(this.detallechequegirado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallechequegirado.getIsDeleted()) {
				this.detallechequegirado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleChequeGiradosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-saveDetalleChequeGiradosWithConnection");connexion.begin();			
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSaves(detallechequegirados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleChequeGirados();
			
			Boolean validadoTodosDetalleChequeGirado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleChequeGirado detallechequegiradoLocal:detallechequegirados) {		
				if(detallechequegiradoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToSave(detallechequegiradoLocal,this.arrDatoGeneral);
	        	
				DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallechequegiradoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleChequeGirado(detallechequegiradoLocal)) {
					DetalleChequeGiradoDataAccess.save(detallechequegiradoLocal, connexion);				
				} else {
					validadoTodosDetalleChequeGirado=false;
				}
			}
			
			if(!validadoTodosDetalleChequeGirado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSavesAfter(detallechequegirados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleChequeGirados();
			
			connexion.commit();		
			
			this.quitarDetalleChequeGiradosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleChequeGirados()throws Exception {				
		 try {	
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSaves(detallechequegirados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleChequeGirado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleChequeGirado detallechequegiradoLocal:detallechequegirados) {				
				if(detallechequegiradoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToSave(detallechequegiradoLocal,this.arrDatoGeneral);
	        	
				DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallechequegiradoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleChequeGirado(detallechequegiradoLocal)) {				
					DetalleChequeGiradoDataAccess.save(detallechequegiradoLocal, connexion);				
				} else {
					validadoTodosDetalleChequeGirado=false;
				}
			}
			
			if(!validadoTodosDetalleChequeGirado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleChequeGiradoLogicAdditional.checkDetalleChequeGiradoToSavesAfter(detallechequegirados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleChequeGiradosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleChequeGiradoParameterReturnGeneral procesarAccionDetalleChequeGirados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleChequeGirado> detallechequegirados,DetalleChequeGiradoParameterReturnGeneral detallechequegiradoParameterGeneral)throws Exception {
		 try {	
			DetalleChequeGiradoParameterReturnGeneral detallechequegiradoReturnGeneral=new DetalleChequeGiradoParameterReturnGeneral();
	
			DetalleChequeGiradoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallechequegirados,detallechequegiradoParameterGeneral,detallechequegiradoReturnGeneral);
			
			return detallechequegiradoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleChequeGiradoParameterReturnGeneral procesarAccionDetalleChequeGiradosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleChequeGirado> detallechequegirados,DetalleChequeGiradoParameterReturnGeneral detallechequegiradoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-procesarAccionDetalleChequeGiradosWithConnection");connexion.begin();			
			
			DetalleChequeGiradoParameterReturnGeneral detallechequegiradoReturnGeneral=new DetalleChequeGiradoParameterReturnGeneral();
	
			DetalleChequeGiradoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallechequegirados,detallechequegiradoParameterGeneral,detallechequegiradoReturnGeneral);
			
			this.connexion.commit();
			
			return detallechequegiradoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleChequeGiradoParameterReturnGeneral procesarEventosDetalleChequeGirados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleChequeGirado> detallechequegirados,DetalleChequeGirado detallechequegirado,DetalleChequeGiradoParameterReturnGeneral detallechequegiradoParameterGeneral,Boolean isEsNuevoDetalleChequeGirado,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleChequeGiradoParameterReturnGeneral detallechequegiradoReturnGeneral=new DetalleChequeGiradoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallechequegiradoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleChequeGiradoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallechequegirados,detallechequegirado,detallechequegiradoParameterGeneral,detallechequegiradoReturnGeneral,isEsNuevoDetalleChequeGirado,clases);
			
			return detallechequegiradoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleChequeGiradoParameterReturnGeneral procesarEventosDetalleChequeGiradosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleChequeGirado> detallechequegirados,DetalleChequeGirado detallechequegirado,DetalleChequeGiradoParameterReturnGeneral detallechequegiradoParameterGeneral,Boolean isEsNuevoDetalleChequeGirado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-procesarEventosDetalleChequeGiradosWithConnection");connexion.begin();			
			
			DetalleChequeGiradoParameterReturnGeneral detallechequegiradoReturnGeneral=new DetalleChequeGiradoParameterReturnGeneral();
	
			detallechequegiradoReturnGeneral.setDetalleChequeGirado(detallechequegirado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallechequegiradoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleChequeGiradoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallechequegirados,detallechequegirado,detallechequegiradoParameterGeneral,detallechequegiradoReturnGeneral,isEsNuevoDetalleChequeGirado,clases);
			
			this.connexion.commit();
			
			return detallechequegiradoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleChequeGiradoParameterReturnGeneral procesarImportacionDetalleChequeGiradosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleChequeGiradoParameterReturnGeneral detallechequegiradoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-procesarImportacionDetalleChequeGiradosWithConnection");connexion.begin();			
			
			DetalleChequeGiradoParameterReturnGeneral detallechequegiradoReturnGeneral=new DetalleChequeGiradoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallechequegirados=new ArrayList<DetalleChequeGirado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallechequegirado=new DetalleChequeGirado();
				
				
				if(conColumnasBase) {this.detallechequegirado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallechequegirado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallechequegirado.setnumero_cheque(arrColumnas[iColumn++]);
				this.detallechequegirado.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallechequegirado.setcuenta(arrColumnas[iColumn++]);
				this.detallechequegirado.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detallechequegirado.setcon(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detallechequegirado.setbeneficiario(arrColumnas[iColumn++]);
				this.detallechequegirado.setcodigo(arrColumnas[iColumn++]);
				this.detallechequegirado.setnombre_banco(arrColumnas[iColumn++]);
				
				this.detallechequegirados.add(this.detallechequegirado);
			}
			
			this.saveDetalleChequeGirados();
			
			this.connexion.commit();
			
			detallechequegiradoReturnGeneral.setConRetornoEstaProcesado(true);
			detallechequegiradoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallechequegiradoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleChequeGiradosEliminados() throws Exception {				
		
		List<DetalleChequeGirado> detallechequegiradosAux= new ArrayList<DetalleChequeGirado>();
		
		for(DetalleChequeGirado detallechequegirado:detallechequegirados) {
			if(!detallechequegirado.getIsDeleted()) {
				detallechequegiradosAux.add(detallechequegirado);
			}
		}
		
		detallechequegirados=detallechequegiradosAux;
	}
	
	public void quitarDetalleChequeGiradosNulos() throws Exception {				
		
		List<DetalleChequeGirado> detallechequegiradosAux= new ArrayList<DetalleChequeGirado>();
		
		for(DetalleChequeGirado detallechequegirado : this.detallechequegirados) {
			if(detallechequegirado==null) {
				detallechequegiradosAux.add(detallechequegirado);
			}
		}
		
		//this.detallechequegirados=detallechequegiradosAux;
		
		this.detallechequegirados.removeAll(detallechequegiradosAux);
	}
	
	public void getSetVersionRowDetalleChequeGiradoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallechequegirado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallechequegirado.getIsDeleted() || (detallechequegirado.getIsChanged()&&!detallechequegirado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallechequegiradoDataAccess.getSetVersionRowDetalleChequeGirado(connexion,detallechequegirado.getId());
				
				if(!detallechequegirado.getVersionRow().equals(timestamp)) {	
					detallechequegirado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallechequegirado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleChequeGirado()throws Exception {	
		
		if(detallechequegirado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallechequegirado.getIsDeleted() || (detallechequegirado.getIsChanged()&&!detallechequegirado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallechequegiradoDataAccess.getSetVersionRowDetalleChequeGirado(connexion,detallechequegirado.getId());
			
			try {							
				if(!detallechequegirado.getVersionRow().equals(timestamp)) {	
					detallechequegirado.setVersionRow(timestamp);
				}
				
				detallechequegirado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleChequeGiradosWithConnection()throws Exception {	
		if(detallechequegirados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleChequeGirado detallechequegiradoAux:detallechequegirados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallechequegiradoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallechequegiradoAux.getIsDeleted() || (detallechequegiradoAux.getIsChanged()&&!detallechequegiradoAux.getIsNew())) {
						
						timestamp=detallechequegiradoDataAccess.getSetVersionRowDetalleChequeGirado(connexion,detallechequegiradoAux.getId());
						
						if(!detallechequegirado.getVersionRow().equals(timestamp)) {	
							detallechequegiradoAux.setVersionRow(timestamp);
						}
								
						detallechequegiradoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleChequeGirados()throws Exception {	
		if(detallechequegirados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleChequeGirado detallechequegiradoAux:detallechequegirados) {
					if(detallechequegiradoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallechequegiradoAux.getIsDeleted() || (detallechequegiradoAux.getIsChanged()&&!detallechequegiradoAux.getIsNew())) {
						
						timestamp=detallechequegiradoDataAccess.getSetVersionRowDetalleChequeGirado(connexion,detallechequegiradoAux.getId());
						
						if(!detallechequegiradoAux.getVersionRow().equals(timestamp)) {	
							detallechequegiradoAux.setVersionRow(timestamp);
						}
						
													
						detallechequegiradoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleChequeGiradoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleChequeGiradoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAsientoContable,String finalQueryGlobalEmpleado,String finalQueryGlobalCuentaBanco,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleChequeGiradoParameterReturnGeneral  detallechequegiradoReturnGeneral =new DetalleChequeGiradoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleChequeGiradoWithConnection");connexion.begin();
			
			detallechequegiradoReturnGeneral =new DetalleChequeGiradoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallechequegiradoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallechequegiradoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallechequegiradoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallechequegiradoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detallechequegiradoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			detallechequegiradoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			detallechequegiradoReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallechequegiradoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallechequegiradoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallechequegiradoReturnGeneral;
	}
	
	public DetalleChequeGiradoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleChequeGirado(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAsientoContable,String finalQueryGlobalEmpleado,String finalQueryGlobalCuentaBanco,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleChequeGiradoParameterReturnGeneral  detallechequegiradoReturnGeneral =new DetalleChequeGiradoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallechequegiradoReturnGeneral =new DetalleChequeGiradoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallechequegiradoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallechequegiradoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallechequegiradoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallechequegiradoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detallechequegiradoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			detallechequegiradoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			detallechequegiradoReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallechequegiradoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallechequegiradoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallechequegiradoReturnGeneral;
	}
	
	
	public void deepLoad(DetalleChequeGirado detallechequegirado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToGet(detallechequegirado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallechequegirado.setEmpresa(detallechequegiradoDataAccess.getEmpresa(connexion,detallechequegirado));
		detallechequegirado.setSucursal(detallechequegiradoDataAccess.getSucursal(connexion,detallechequegirado));
		detallechequegirado.setEjercicio(detallechequegiradoDataAccess.getEjercicio(connexion,detallechequegirado));
		detallechequegirado.setPeriodo(detallechequegiradoDataAccess.getPeriodo(connexion,detallechequegirado));
		detallechequegirado.setAsientoContable(detallechequegiradoDataAccess.getAsientoContable(connexion,detallechequegirado));
		detallechequegirado.setEmpleado(detallechequegiradoDataAccess.getEmpleado(connexion,detallechequegirado));
		detallechequegirado.setCuentaBanco(detallechequegiradoDataAccess.getCuentaBanco(connexion,detallechequegirado));
		detallechequegirado.setAnio(detallechequegiradoDataAccess.getAnio(connexion,detallechequegirado));
		detallechequegirado.setMes(detallechequegiradoDataAccess.getMes(connexion,detallechequegirado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallechequegirado.setEmpresa(detallechequegiradoDataAccess.getEmpresa(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallechequegirado.setSucursal(detallechequegiradoDataAccess.getSucursal(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallechequegirado.setEjercicio(detallechequegiradoDataAccess.getEjercicio(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallechequegirado.setPeriodo(detallechequegiradoDataAccess.getPeriodo(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detallechequegirado.setAsientoContable(detallechequegiradoDataAccess.getAsientoContable(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				detallechequegirado.setEmpleado(detallechequegiradoDataAccess.getEmpleado(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				detallechequegirado.setCuentaBanco(detallechequegiradoDataAccess.getCuentaBanco(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallechequegirado.setAnio(detallechequegiradoDataAccess.getAnio(connexion,detallechequegirado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallechequegirado.setMes(detallechequegiradoDataAccess.getMes(connexion,detallechequegirado));
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
			detallechequegirado.setEmpresa(detallechequegiradoDataAccess.getEmpresa(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setSucursal(detallechequegiradoDataAccess.getSucursal(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setEjercicio(detallechequegiradoDataAccess.getEjercicio(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setPeriodo(detallechequegiradoDataAccess.getPeriodo(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setAsientoContable(detallechequegiradoDataAccess.getAsientoContable(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setEmpleado(detallechequegiradoDataAccess.getEmpleado(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setCuentaBanco(detallechequegiradoDataAccess.getCuentaBanco(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setAnio(detallechequegiradoDataAccess.getAnio(connexion,detallechequegirado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setMes(detallechequegiradoDataAccess.getMes(connexion,detallechequegirado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallechequegirado.setEmpresa(detallechequegiradoDataAccess.getEmpresa(connexion,detallechequegirado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallechequegirado.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setSucursal(detallechequegiradoDataAccess.getSucursal(connexion,detallechequegirado));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallechequegirado.getSucursal(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setEjercicio(detallechequegiradoDataAccess.getEjercicio(connexion,detallechequegirado));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallechequegirado.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setPeriodo(detallechequegiradoDataAccess.getPeriodo(connexion,detallechequegirado));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallechequegirado.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setAsientoContable(detallechequegiradoDataAccess.getAsientoContable(connexion,detallechequegirado));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detallechequegirado.getAsientoContable(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setEmpleado(detallechequegiradoDataAccess.getEmpleado(connexion,detallechequegirado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(detallechequegirado.getEmpleado(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setCuentaBanco(detallechequegiradoDataAccess.getCuentaBanco(connexion,detallechequegirado));
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(detallechequegirado.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setAnio(detallechequegiradoDataAccess.getAnio(connexion,detallechequegirado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallechequegirado.getAnio(),isDeep,deepLoadType,clases);
				
		detallechequegirado.setMes(detallechequegiradoDataAccess.getMes(connexion,detallechequegirado));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallechequegirado.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallechequegirado.setEmpresa(detallechequegiradoDataAccess.getEmpresa(connexion,detallechequegirado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallechequegirado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallechequegirado.setSucursal(detallechequegiradoDataAccess.getSucursal(connexion,detallechequegirado));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallechequegirado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallechequegirado.setEjercicio(detallechequegiradoDataAccess.getEjercicio(connexion,detallechequegirado));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallechequegirado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallechequegirado.setPeriodo(detallechequegiradoDataAccess.getPeriodo(connexion,detallechequegirado));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallechequegirado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detallechequegirado.setAsientoContable(detallechequegiradoDataAccess.getAsientoContable(connexion,detallechequegirado));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(detallechequegirado.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				detallechequegirado.setEmpleado(detallechequegiradoDataAccess.getEmpleado(connexion,detallechequegirado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(detallechequegirado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				detallechequegirado.setCuentaBanco(detallechequegiradoDataAccess.getCuentaBanco(connexion,detallechequegirado));
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepLoad(detallechequegirado.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallechequegirado.setAnio(detallechequegiradoDataAccess.getAnio(connexion,detallechequegirado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallechequegirado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallechequegirado.setMes(detallechequegiradoDataAccess.getMes(connexion,detallechequegirado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallechequegirado.getMes(),isDeep,deepLoadType,clases);				
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
			detallechequegirado.setEmpresa(detallechequegiradoDataAccess.getEmpresa(connexion,detallechequegirado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallechequegirado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setSucursal(detallechequegiradoDataAccess.getSucursal(connexion,detallechequegirado));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallechequegirado.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setEjercicio(detallechequegiradoDataAccess.getEjercicio(connexion,detallechequegirado));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallechequegirado.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setPeriodo(detallechequegiradoDataAccess.getPeriodo(connexion,detallechequegirado));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallechequegirado.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setAsientoContable(detallechequegiradoDataAccess.getAsientoContable(connexion,detallechequegirado));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(detallechequegirado.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setEmpleado(detallechequegiradoDataAccess.getEmpleado(connexion,detallechequegirado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(detallechequegirado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setCuentaBanco(detallechequegiradoDataAccess.getCuentaBanco(connexion,detallechequegirado));
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabancoLogic.deepLoad(detallechequegirado.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setAnio(detallechequegiradoDataAccess.getAnio(connexion,detallechequegirado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallechequegirado.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallechequegirado.setMes(detallechequegiradoDataAccess.getMes(connexion,detallechequegirado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallechequegirado.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleChequeGirado detallechequegirado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleChequeGiradoLogicAdditional.updateDetalleChequeGiradoToSave(detallechequegirado,this.arrDatoGeneral);
			
DetalleChequeGiradoDataAccess.save(detallechequegirado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallechequegirado.getEmpresa(),connexion);

		SucursalDataAccess.save(detallechequegirado.getSucursal(),connexion);

		EjercicioDataAccess.save(detallechequegirado.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallechequegirado.getPeriodo(),connexion);

		AsientoContableDataAccess.save(detallechequegirado.getAsientoContable(),connexion);

		EmpleadoDataAccess.save(detallechequegirado.getEmpleado(),connexion);

		CuentaBancoDataAccess.save(detallechequegirado.getCuentaBanco(),connexion);

		AnioDataAccess.save(detallechequegirado.getAnio(),connexion);

		MesDataAccess.save(detallechequegirado.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallechequegirado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallechequegirado.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallechequegirado.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallechequegirado.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detallechequegirado.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(detallechequegirado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(detallechequegirado.getCuentaBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallechequegirado.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallechequegirado.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallechequegirado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallechequegirado.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallechequegirado.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallechequegirado.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallechequegirado.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallechequegirado.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallechequegirado.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallechequegirado.getPeriodo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(detallechequegirado.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detallechequegirado.getAsientoContable(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(detallechequegirado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(detallechequegirado.getEmpleado(),isDeep,deepLoadType,clases);
				

		CuentaBancoDataAccess.save(detallechequegirado.getCuentaBanco(),connexion);
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(detallechequegirado.getCuentaBanco(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallechequegirado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallechequegirado.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallechequegirado.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallechequegirado.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallechequegirado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallechequegirado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallechequegirado.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallechequegirado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallechequegirado.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallechequegirado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallechequegirado.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallechequegirado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detallechequegirado.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(detallechequegirado.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(detallechequegirado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(detallechequegirado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(detallechequegirado.getCuentaBanco(),connexion);
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepSave(detallechequegirado.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallechequegirado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallechequegirado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallechequegirado.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallechequegirado.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleChequeGirado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallechequegirado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(detallechequegirado);
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
			this.deepLoad(this.detallechequegirado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleChequeGirado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallechequegirados!=null) {
				for(DetalleChequeGirado detallechequegirado:detallechequegirados) {
					this.deepLoad(detallechequegirado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(detallechequegirados);
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
			if(detallechequegirados!=null) {
				for(DetalleChequeGirado detallechequegirado:detallechequegirados) {
					this.deepLoad(detallechequegirado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(detallechequegirados);
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
			this.getNewConnexionToDeep(DetalleChequeGirado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallechequegirado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleChequeGirado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallechequegirados!=null) {
				for(DetalleChequeGirado detallechequegirado:detallechequegirados) {
					this.deepSave(detallechequegirado,isDeep,deepLoadType,clases);
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
			if(detallechequegirados!=null) {
				for(DetalleChequeGirado detallechequegirado:detallechequegirados) {
					this.deepSave(detallechequegirado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleChequeGiradosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleChequeGiradoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleChequeGiradoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdCuentaBanco(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleChequeGiradoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleChequeGiradoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DetalleChequeGiradoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DetalleChequeGiradoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleChequeGiradoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleChequeGiradoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleChequeGiradoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleChequeGiradoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleChequeGiradoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleChequeGiradoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleChequeGiradosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleChequeGirado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleChequeGiradoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleChequeGiradosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleChequeGiradoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleChequeGiradoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(this.detallechequegirados);
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
			if(DetalleChequeGiradoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleChequeGiradoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleChequeGirado detallechequegirado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleChequeGiradoConstantesFunciones.ISCONAUDITORIA) {
				if(detallechequegirado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleChequeGiradoDataAccess.TABLENAME, detallechequegirado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleChequeGiradoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleChequeGiradoLogic.registrarAuditoriaDetallesDetalleChequeGirado(connexion,detallechequegirado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallechequegirado.getIsDeleted()) {
					/*if(!detallechequegirado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleChequeGiradoDataAccess.TABLENAME, detallechequegirado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleChequeGiradoLogic.registrarAuditoriaDetallesDetalleChequeGirado(connexion,detallechequegirado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleChequeGiradoDataAccess.TABLENAME, detallechequegirado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallechequegirado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleChequeGiradoDataAccess.TABLENAME, detallechequegirado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleChequeGiradoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleChequeGiradoLogic.registrarAuditoriaDetallesDetalleChequeGirado(connexion,detallechequegirado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleChequeGirado(Connexion connexion,DetalleChequeGirado detallechequegirado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_empresa().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_empresa()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_empresa().toString();
				}
				if(detallechequegirado.getid_empresa()!=null)
				{
					strValorNuevo=detallechequegirado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_sucursal().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_sucursal().toString();
				}
				if(detallechequegirado.getid_sucursal()!=null)
				{
					strValorNuevo=detallechequegirado.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_ejercicio().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_ejercicio().toString();
				}
				if(detallechequegirado.getid_ejercicio()!=null)
				{
					strValorNuevo=detallechequegirado.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_periodo().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_periodo()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_periodo().toString();
				}
				if(detallechequegirado.getid_periodo()!=null)
				{
					strValorNuevo=detallechequegirado.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_asiento_contable().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_asiento_contable().toString();
				}
				if(detallechequegirado.getid_asiento_contable()!=null)
				{
					strValorNuevo=detallechequegirado.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_empleado().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_empleado()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_empleado().toString();
				}
				if(detallechequegirado.getid_empleado()!=null)
				{
					strValorNuevo=detallechequegirado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_cuenta_banco().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_cuenta_banco()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_cuenta_banco().toString();
				}
				if(detallechequegirado.getid_cuenta_banco()!=null)
				{
					strValorNuevo=detallechequegirado.getid_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getnumero_cheque().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getnumero_cheque()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getnumero_cheque();
				}
				if(detallechequegirado.getnumero_cheque()!=null)
				{
					strValorNuevo=detallechequegirado.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getvalor().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getvalor()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getvalor().toString();
				}
				if(detallechequegirado.getvalor()!=null)
				{
					strValorNuevo=detallechequegirado.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getcuenta().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getcuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getcuenta()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getcuenta();
				}
				if(detallechequegirado.getcuenta()!=null)
				{
					strValorNuevo=detallechequegirado.getcuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.CUENTA,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getfecha().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getfecha()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getfecha().toString();
				}
				if(detallechequegirado.getfecha()!=null)
				{
					strValorNuevo=detallechequegirado.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getcon().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getcon()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getcon()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getcon().toString();
				}
				if(detallechequegirado.getcon()!=null)
				{
					strValorNuevo=detallechequegirado.getcon().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.CON,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getbeneficiario().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getbeneficiario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getbeneficiario()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getbeneficiario();
				}
				if(detallechequegirado.getbeneficiario()!=null)
				{
					strValorNuevo=detallechequegirado.getbeneficiario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.BENEFICIARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getcodigo().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getcodigo()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getcodigo();
				}
				if(detallechequegirado.getcodigo()!=null)
				{
					strValorNuevo=detallechequegirado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getnombre_banco().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getnombre_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getnombre_banco()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getnombre_banco();
				}
				if(detallechequegirado.getnombre_banco()!=null)
				{
					strValorNuevo=detallechequegirado.getnombre_banco() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.NOMBREBANCO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_anio().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_anio()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_anio().toString();
				}
				if(detallechequegirado.getid_anio()!=null)
				{
					strValorNuevo=detallechequegirado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallechequegirado.getIsNew()||!detallechequegirado.getid_mes().equals(detallechequegirado.getDetalleChequeGiradoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallechequegirado.getDetalleChequeGiradoOriginal().getid_mes()!=null)
				{
					strValorActual=detallechequegirado.getDetalleChequeGiradoOriginal().getid_mes().toString();
				}
				if(detallechequegirado.getid_mes()!=null)
				{
					strValorNuevo=detallechequegirado.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleChequeGiradoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleChequeGiradoRelacionesWithConnection(DetalleChequeGirado detallechequegirado) throws Exception {

		if(!detallechequegirado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleChequeGiradoRelacionesBase(detallechequegirado,true);
		}
	}

	public void saveDetalleChequeGiradoRelaciones(DetalleChequeGirado detallechequegirado)throws Exception {

		if(!detallechequegirado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleChequeGiradoRelacionesBase(detallechequegirado,false);
		}
	}

	public void saveDetalleChequeGiradoRelacionesBase(DetalleChequeGirado detallechequegirado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleChequeGirado-saveRelacionesWithConnection");}
	

			this.setDetalleChequeGirado(detallechequegirado);

			if(DetalleChequeGiradoLogicAdditional.validarSaveRelaciones(detallechequegirado,this)) {

				DetalleChequeGiradoLogicAdditional.updateRelacionesToSave(detallechequegirado,this);

				if((detallechequegirado.getIsNew()||detallechequegirado.getIsChanged())&&!detallechequegirado.getIsDeleted()) {
					this.saveDetalleChequeGirado();
					this.saveDetalleChequeGiradoRelacionesDetalles();

				} else if(detallechequegirado.getIsDeleted()) {
					this.saveDetalleChequeGiradoRelacionesDetalles();
					this.saveDetalleChequeGirado();
				}

				DetalleChequeGiradoLogicAdditional.updateRelacionesToSaveAfter(detallechequegirado,this);

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
	
	
	private void saveDetalleChequeGiradoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleChequeGirado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleChequeGiradoConstantesFunciones.getClassesForeignKeysOfDetalleChequeGirado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleChequeGirado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleChequeGiradoConstantesFunciones.getClassesRelationshipsOfDetalleChequeGirado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
