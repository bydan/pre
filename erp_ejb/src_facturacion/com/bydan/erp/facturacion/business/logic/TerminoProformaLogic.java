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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.TerminoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.TerminoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TerminoProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TerminoProforma;
import com.bydan.erp.facturacion.business.logic.TerminoProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

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
public class TerminoProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TerminoProformaLogic.class);
	
	protected TerminoProformaDataAccess terminoproformaDataAccess; 	
	protected TerminoProforma terminoproforma;
	protected List<TerminoProforma> terminoproformas;
	protected Object terminoproformaObject;	
	protected List<Object> terminoproformasObject;
	
	public static ClassValidator<TerminoProforma> terminoproformaValidator = new ClassValidator<TerminoProforma>(TerminoProforma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TerminoProformaLogicAdditional terminoproformaLogicAdditional=null;
	
	public TerminoProformaLogicAdditional getTerminoProformaLogicAdditional() {
		return this.terminoproformaLogicAdditional;
	}
	
	public void setTerminoProformaLogicAdditional(TerminoProformaLogicAdditional terminoproformaLogicAdditional) {
		try {
			this.terminoproformaLogicAdditional=terminoproformaLogicAdditional;
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
	
	
	
	
	public  TerminoProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.terminoproformaDataAccess = new TerminoProformaDataAccess();
			
			this.terminoproformas= new ArrayList<TerminoProforma>();
			this.terminoproforma= new TerminoProforma();
			
			this.terminoproformaObject=new Object();
			this.terminoproformasObject=new ArrayList<Object>();
				
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
			
			this.terminoproformaDataAccess.setConnexionType(this.connexionType);
			this.terminoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TerminoProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.terminoproformaDataAccess = new TerminoProformaDataAccess();
			this.terminoproformas= new ArrayList<TerminoProforma>();
			this.terminoproforma= new TerminoProforma();
			this.terminoproformaObject=new Object();
			this.terminoproformasObject=new ArrayList<Object>();
			
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
			
			this.terminoproformaDataAccess.setConnexionType(this.connexionType);
			this.terminoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TerminoProforma getTerminoProforma() throws Exception {	
		TerminoProformaLogicAdditional.checkTerminoProformaToGet(terminoproforma,this.datosCliente,this.arrDatoGeneral);
		TerminoProformaLogicAdditional.updateTerminoProformaToGet(terminoproforma,this.arrDatoGeneral);
		
		return terminoproforma;
	}
		
	public void setTerminoProforma(TerminoProforma newTerminoProforma) {
		this.terminoproforma = newTerminoProforma;
	}
	
	public TerminoProformaDataAccess getTerminoProformaDataAccess() {
		return terminoproformaDataAccess;
	}
	
	public void setTerminoProformaDataAccess(TerminoProformaDataAccess newterminoproformaDataAccess) {
		this.terminoproformaDataAccess = newterminoproformaDataAccess;
	}
	
	public List<TerminoProforma> getTerminoProformas() throws Exception {		
		this.quitarTerminoProformasNulos();
		
		TerminoProformaLogicAdditional.checkTerminoProformaToGets(terminoproformas,this.datosCliente,this.arrDatoGeneral);
		
		for (TerminoProforma terminoproformaLocal: terminoproformas ) {
			TerminoProformaLogicAdditional.updateTerminoProformaToGet(terminoproformaLocal,this.arrDatoGeneral);
		}
		
		return terminoproformas;
	}
	
	public void setTerminoProformas(List<TerminoProforma> newTerminoProformas) {
		this.terminoproformas = newTerminoProformas;
	}
	
	public Object getTerminoProformaObject() {	
		this.terminoproformaObject=this.terminoproformaDataAccess.getEntityObject();
		return this.terminoproformaObject;
	}
		
	public void setTerminoProformaObject(Object newTerminoProformaObject) {
		this.terminoproformaObject = newTerminoProformaObject;
	}
	
	public List<Object> getTerminoProformasObject() {		
		this.terminoproformasObject=this.terminoproformaDataAccess.getEntitiesObject();
		return this.terminoproformasObject;
	}
		
	public void setTerminoProformasObject(List<Object> newTerminoProformasObject) {
		this.terminoproformasObject = newTerminoProformasObject;
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
		
		if(this.terminoproformaDataAccess!=null) {
			this.terminoproformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			terminoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			terminoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		terminoproforma = new  TerminoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			terminoproforma=terminoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.terminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
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
		terminoproforma = new  TerminoProforma();
		  		  
        try {
			
			terminoproforma=terminoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.terminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		terminoproforma = new  TerminoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			terminoproforma=terminoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.terminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
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
		terminoproforma = new  TerminoProforma();
		  		  
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
		terminoproforma = new  TerminoProforma();
		  		  
        try {
			
			terminoproforma=terminoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.terminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		terminoproforma = new  TerminoProforma();
		  		  
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
		terminoproforma = new  TerminoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =terminoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		terminoproforma = new  TerminoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=terminoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		terminoproforma = new  TerminoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =terminoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		terminoproforma = new  TerminoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=terminoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		terminoproforma = new  TerminoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =terminoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		terminoproforma = new  TerminoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=terminoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
        try {			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
        try {
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		terminoproforma = new  TerminoProforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproforma=terminoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
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
		terminoproforma = new  TerminoProforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproforma=terminoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
		terminoproformas = new  ArrayList<TerminoProforma>();
		  		  
        try {
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTerminoProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		terminoproformas = new  ArrayList<TerminoProforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getTodosTerminoProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
	
	public  void  getTodosTerminoProformas(String sFinalQuery,Pagination pagination)throws Exception {
		terminoproformas = new  ArrayList<TerminoProforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTerminoProforma(terminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTerminoProforma(TerminoProforma terminoproforma) throws Exception {
		Boolean estaValidado=false;
		
		if(terminoproforma.getIsNew() || terminoproforma.getIsChanged()) { 
			this.invalidValues = terminoproformaValidator.getInvalidValues(terminoproforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(terminoproforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTerminoProforma(List<TerminoProforma> TerminoProformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TerminoProforma terminoproformaLocal:terminoproformas) {				
			estaValidadoObjeto=this.validarGuardarTerminoProforma(terminoproformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTerminoProforma(List<TerminoProforma> TerminoProformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTerminoProforma(terminoproformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTerminoProforma(TerminoProforma TerminoProforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTerminoProforma(terminoproforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TerminoProforma terminoproforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+terminoproforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TerminoProformaConstantesFunciones.getTerminoProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"terminoproforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TerminoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TerminoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTerminoProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-saveTerminoProformaWithConnection");connexion.begin();			
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSave(this.terminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TerminoProformaLogicAdditional.updateTerminoProformaToSave(this.terminoproforma,this.arrDatoGeneral);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.terminoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTerminoProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTerminoProforma(this.terminoproforma)) {
				TerminoProformaDataAccess.save(this.terminoproforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.terminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSaveAfter(this.terminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTerminoProforma();
			
			connexion.commit();			
			
			if(this.terminoproforma.getIsDeleted()) {
				this.terminoproforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTerminoProforma()throws Exception {	
		try {	
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSave(this.terminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TerminoProformaLogicAdditional.updateTerminoProformaToSave(this.terminoproforma,this.arrDatoGeneral);
			
			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.terminoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTerminoProforma(this.terminoproforma)) {			
				TerminoProformaDataAccess.save(this.terminoproforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.terminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSaveAfter(this.terminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.terminoproforma.getIsDeleted()) {
				this.terminoproforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTerminoProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-saveTerminoProformasWithConnection");connexion.begin();			
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSaves(terminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTerminoProformas();
			
			Boolean validadoTodosTerminoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TerminoProforma terminoproformaLocal:terminoproformas) {		
				if(terminoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TerminoProformaLogicAdditional.updateTerminoProformaToSave(terminoproformaLocal,this.arrDatoGeneral);
	        	
				TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),terminoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTerminoProforma(terminoproformaLocal)) {
					TerminoProformaDataAccess.save(terminoproformaLocal, connexion);				
				} else {
					validadoTodosTerminoProforma=false;
				}
			}
			
			if(!validadoTodosTerminoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSavesAfter(terminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTerminoProformas();
			
			connexion.commit();		
			
			this.quitarTerminoProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTerminoProformas()throws Exception {				
		 try {	
			TerminoProformaLogicAdditional.checkTerminoProformaToSaves(terminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTerminoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TerminoProforma terminoproformaLocal:terminoproformas) {				
				if(terminoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TerminoProformaLogicAdditional.updateTerminoProformaToSave(terminoproformaLocal,this.arrDatoGeneral);
	        	
				TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),terminoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTerminoProforma(terminoproformaLocal)) {				
					TerminoProformaDataAccess.save(terminoproformaLocal, connexion);				
				} else {
					validadoTodosTerminoProforma=false;
				}
			}
			
			if(!validadoTodosTerminoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TerminoProformaLogicAdditional.checkTerminoProformaToSavesAfter(terminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTerminoProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TerminoProformaParameterReturnGeneral procesarAccionTerminoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TerminoProforma> terminoproformas,TerminoProformaParameterReturnGeneral terminoproformaParameterGeneral)throws Exception {
		 try {	
			TerminoProformaParameterReturnGeneral terminoproformaReturnGeneral=new TerminoProformaParameterReturnGeneral();
	
			TerminoProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,terminoproformas,terminoproformaParameterGeneral,terminoproformaReturnGeneral);
			
			return terminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TerminoProformaParameterReturnGeneral procesarAccionTerminoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TerminoProforma> terminoproformas,TerminoProformaParameterReturnGeneral terminoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-procesarAccionTerminoProformasWithConnection");connexion.begin();			
			
			TerminoProformaParameterReturnGeneral terminoproformaReturnGeneral=new TerminoProformaParameterReturnGeneral();
	
			TerminoProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,terminoproformas,terminoproformaParameterGeneral,terminoproformaReturnGeneral);
			
			this.connexion.commit();
			
			return terminoproformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TerminoProformaParameterReturnGeneral procesarEventosTerminoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TerminoProforma> terminoproformas,TerminoProforma terminoproforma,TerminoProformaParameterReturnGeneral terminoproformaParameterGeneral,Boolean isEsNuevoTerminoProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			TerminoProformaParameterReturnGeneral terminoproformaReturnGeneral=new TerminoProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				terminoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TerminoProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,terminoproformas,terminoproforma,terminoproformaParameterGeneral,terminoproformaReturnGeneral,isEsNuevoTerminoProforma,clases);
			
			return terminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TerminoProformaParameterReturnGeneral procesarEventosTerminoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TerminoProforma> terminoproformas,TerminoProforma terminoproforma,TerminoProformaParameterReturnGeneral terminoproformaParameterGeneral,Boolean isEsNuevoTerminoProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-procesarEventosTerminoProformasWithConnection");connexion.begin();			
			
			TerminoProformaParameterReturnGeneral terminoproformaReturnGeneral=new TerminoProformaParameterReturnGeneral();
	
			terminoproformaReturnGeneral.setTerminoProforma(terminoproforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				terminoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TerminoProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,terminoproformas,terminoproforma,terminoproformaParameterGeneral,terminoproformaReturnGeneral,isEsNuevoTerminoProforma,clases);
			
			this.connexion.commit();
			
			return terminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TerminoProformaParameterReturnGeneral procesarImportacionTerminoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TerminoProformaParameterReturnGeneral terminoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-procesarImportacionTerminoProformasWithConnection");connexion.begin();			
			
			TerminoProformaParameterReturnGeneral terminoproformaReturnGeneral=new TerminoProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.terminoproformas=new ArrayList<TerminoProforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.terminoproforma=new TerminoProforma();
				
				
				if(conColumnasBase) {this.terminoproforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.terminoproforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.terminoproforma.setatencion(arrColumnas[iColumn++]);
				this.terminoproforma.setregistro_sanitario(arrColumnas[iColumn++]);
			this.terminoproforma.setreferencia(arrColumnas[iColumn++]);
			this.terminoproforma.setdescripcion(arrColumnas[iColumn++]);
			this.terminoproforma.setdescripcion2(arrColumnas[iColumn++]);
				this.terminoproforma.setmarca(arrColumnas[iColumn++]);
				this.terminoproforma.setorigen(arrColumnas[iColumn++]);
				this.terminoproforma.setgarantia_tecnica(arrColumnas[iColumn++]);
				this.terminoproforma.setfecha_pago(arrColumnas[iColumn++]);
				this.terminoproforma.setfecha_entrega(arrColumnas[iColumn++]);
			this.terminoproforma.setadjunto(arrColumnas[iColumn++]);
				this.terminoproforma.setresponsable(arrColumnas[iColumn++]);
				this.terminoproforma.setcargo(arrColumnas[iColumn++]);
				
				this.terminoproformas.add(this.terminoproforma);
			}
			
			this.saveTerminoProformas();
			
			this.connexion.commit();
			
			terminoproformaReturnGeneral.setConRetornoEstaProcesado(true);
			terminoproformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return terminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTerminoProformasEliminados() throws Exception {				
		
		List<TerminoProforma> terminoproformasAux= new ArrayList<TerminoProforma>();
		
		for(TerminoProforma terminoproforma:terminoproformas) {
			if(!terminoproforma.getIsDeleted()) {
				terminoproformasAux.add(terminoproforma);
			}
		}
		
		terminoproformas=terminoproformasAux;
	}
	
	public void quitarTerminoProformasNulos() throws Exception {				
		
		List<TerminoProforma> terminoproformasAux= new ArrayList<TerminoProforma>();
		
		for(TerminoProforma terminoproforma : this.terminoproformas) {
			if(terminoproforma==null) {
				terminoproformasAux.add(terminoproforma);
			}
		}
		
		//this.terminoproformas=terminoproformasAux;
		
		this.terminoproformas.removeAll(terminoproformasAux);
	}
	
	public void getSetVersionRowTerminoProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(terminoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((terminoproforma.getIsDeleted() || (terminoproforma.getIsChanged()&&!terminoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=terminoproformaDataAccess.getSetVersionRowTerminoProforma(connexion,terminoproforma.getId());
				
				if(!terminoproforma.getVersionRow().equals(timestamp)) {	
					terminoproforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				terminoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTerminoProforma()throws Exception {	
		
		if(terminoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((terminoproforma.getIsDeleted() || (terminoproforma.getIsChanged()&&!terminoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=terminoproformaDataAccess.getSetVersionRowTerminoProforma(connexion,terminoproforma.getId());
			
			try {							
				if(!terminoproforma.getVersionRow().equals(timestamp)) {	
					terminoproforma.setVersionRow(timestamp);
				}
				
				terminoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTerminoProformasWithConnection()throws Exception {	
		if(terminoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TerminoProforma terminoproformaAux:terminoproformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(terminoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(terminoproformaAux.getIsDeleted() || (terminoproformaAux.getIsChanged()&&!terminoproformaAux.getIsNew())) {
						
						timestamp=terminoproformaDataAccess.getSetVersionRowTerminoProforma(connexion,terminoproformaAux.getId());
						
						if(!terminoproforma.getVersionRow().equals(timestamp)) {	
							terminoproformaAux.setVersionRow(timestamp);
						}
								
						terminoproformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTerminoProformas()throws Exception {	
		if(terminoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TerminoProforma terminoproformaAux:terminoproformas) {
					if(terminoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(terminoproformaAux.getIsDeleted() || (terminoproformaAux.getIsChanged()&&!terminoproformaAux.getIsNew())) {
						
						timestamp=terminoproformaDataAccess.getSetVersionRowTerminoProforma(connexion,terminoproformaAux.getId());
						
						if(!terminoproformaAux.getVersionRow().equals(timestamp)) {	
							terminoproformaAux.setVersionRow(timestamp);
						}
						
													
						terminoproformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TerminoProformaParameterReturnGeneral cargarCombosLoteForeignKeyTerminoProformaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalMoneda,String finalQueryGlobalProforma) throws Exception {
		TerminoProformaParameterReturnGeneral  terminoproformaReturnGeneral =new TerminoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-cargarCombosLoteForeignKeyTerminoProformaWithConnection");connexion.begin();
			
			terminoproformaReturnGeneral =new TerminoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			terminoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			terminoproformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			terminoproformaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Proforma> proformasForeignKey=new ArrayList<Proforma>();
			ProformaLogic proformaLogic=new ProformaLogic();
			proformaLogic.setConnexion(this.connexion);
			proformaLogic.getProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProforma.equals("NONE")) {
				proformaLogic.getTodosProformas(finalQueryGlobalProforma,new Pagination());
				proformasForeignKey=proformaLogic.getProformas();
			}

			terminoproformaReturnGeneral.setproformasForeignKey(proformasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return terminoproformaReturnGeneral;
	}
	
	public TerminoProformaParameterReturnGeneral cargarCombosLoteForeignKeyTerminoProforma(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalMoneda,String finalQueryGlobalProforma) throws Exception {
		TerminoProformaParameterReturnGeneral  terminoproformaReturnGeneral =new TerminoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			terminoproformaReturnGeneral =new TerminoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			terminoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			terminoproformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			terminoproformaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Proforma> proformasForeignKey=new ArrayList<Proforma>();
			ProformaLogic proformaLogic=new ProformaLogic();
			proformaLogic.setConnexion(this.connexion);
			proformaLogic.getProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProforma.equals("NONE")) {
				proformaLogic.getTodosProformas(finalQueryGlobalProforma,new Pagination());
				proformasForeignKey=proformaLogic.getProformas();
			}

			terminoproformaReturnGeneral.setproformasForeignKey(proformasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return terminoproformaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTerminoProformaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleTerminoProformaLogic detalleterminoproformaLogic=new DetalleTerminoProformaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTerminoProformaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleTerminoProforma.class));
											
			

			detalleterminoproformaLogic.setConnexion(this.getConnexion());
			detalleterminoproformaLogic.setDatosCliente(this.datosCliente);
			detalleterminoproformaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TerminoProforma terminoproforma:this.terminoproformas) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleTerminoProformaConstantesFunciones.getClassesForeignKeysOfDetalleTerminoProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleterminoproformaLogic.setDetalleTerminoProformas(terminoproforma.detalleterminoproformas);
				detalleterminoproformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TerminoProforma terminoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TerminoProformaLogicAdditional.updateTerminoProformaToGet(terminoproforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		terminoproforma.setEmpresa(terminoproformaDataAccess.getEmpresa(connexion,terminoproforma));
		terminoproforma.setSucursal(terminoproformaDataAccess.getSucursal(connexion,terminoproforma));
		terminoproforma.setMoneda(terminoproformaDataAccess.getMoneda(connexion,terminoproforma));
		terminoproforma.setProforma(terminoproformaDataAccess.getProforma(connexion,terminoproforma));
		terminoproforma.setDetalleTerminoProformas(terminoproformaDataAccess.getDetalleTerminoProformas(connexion,terminoproforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				terminoproforma.setEmpresa(terminoproformaDataAccess.getEmpresa(connexion,terminoproforma));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				terminoproforma.setSucursal(terminoproformaDataAccess.getSucursal(connexion,terminoproforma));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				terminoproforma.setMoneda(terminoproformaDataAccess.getMoneda(connexion,terminoproforma));
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				terminoproforma.setProforma(terminoproformaDataAccess.getProforma(connexion,terminoproforma));
				continue;
			}

			if(clas.clas.equals(DetalleTerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				terminoproforma.setDetalleTerminoProformas(terminoproformaDataAccess.getDetalleTerminoProformas(connexion,terminoproforma));

				if(this.isConDeep) {
					DetalleTerminoProformaLogic detalleterminoproformaLogic= new DetalleTerminoProformaLogic(this.connexion);
					detalleterminoproformaLogic.setDetalleTerminoProformas(terminoproforma.getDetalleTerminoProformas());
					ArrayList<Classe> classesLocal=DetalleTerminoProformaConstantesFunciones.getClassesForeignKeysOfDetalleTerminoProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleterminoproformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(detalleterminoproformaLogic.getDetalleTerminoProformas());
					terminoproforma.setDetalleTerminoProformas(detalleterminoproformaLogic.getDetalleTerminoProformas());
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
			terminoproforma.setEmpresa(terminoproformaDataAccess.getEmpresa(connexion,terminoproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			terminoproforma.setSucursal(terminoproformaDataAccess.getSucursal(connexion,terminoproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			terminoproforma.setMoneda(terminoproformaDataAccess.getMoneda(connexion,terminoproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			terminoproforma.setProforma(terminoproformaDataAccess.getProforma(connexion,terminoproforma));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTerminoProforma.class));
			terminoproforma.setDetalleTerminoProformas(terminoproformaDataAccess.getDetalleTerminoProformas(connexion,terminoproforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		terminoproforma.setEmpresa(terminoproformaDataAccess.getEmpresa(connexion,terminoproforma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(terminoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		terminoproforma.setSucursal(terminoproformaDataAccess.getSucursal(connexion,terminoproforma));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(terminoproforma.getSucursal(),isDeep,deepLoadType,clases);
				
		terminoproforma.setMoneda(terminoproformaDataAccess.getMoneda(connexion,terminoproforma));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(terminoproforma.getMoneda(),isDeep,deepLoadType,clases);
				
		terminoproforma.setProforma(terminoproformaDataAccess.getProforma(connexion,terminoproforma));
		ProformaLogic proformaLogic= new ProformaLogic(connexion);
		proformaLogic.deepLoad(terminoproforma.getProforma(),isDeep,deepLoadType,clases);
				

		terminoproforma.setDetalleTerminoProformas(terminoproformaDataAccess.getDetalleTerminoProformas(connexion,terminoproforma));

		for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
			DetalleTerminoProformaLogic detalleterminoproformaLogic= new DetalleTerminoProformaLogic(connexion);
			detalleterminoproformaLogic.deepLoad(detalleterminoproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				terminoproforma.setEmpresa(terminoproformaDataAccess.getEmpresa(connexion,terminoproforma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(terminoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				terminoproforma.setSucursal(terminoproformaDataAccess.getSucursal(connexion,terminoproforma));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(terminoproforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				terminoproforma.setMoneda(terminoproformaDataAccess.getMoneda(connexion,terminoproforma));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(terminoproforma.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				terminoproforma.setProforma(terminoproformaDataAccess.getProforma(connexion,terminoproforma));
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(terminoproforma.getProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleTerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				terminoproforma.setDetalleTerminoProformas(terminoproformaDataAccess.getDetalleTerminoProformas(connexion,terminoproforma));

				for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
					DetalleTerminoProformaLogic detalleterminoproformaLogic= new DetalleTerminoProformaLogic(connexion);
					detalleterminoproformaLogic.deepLoad(detalleterminoproforma,isDeep,deepLoadType,clases);
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
			terminoproforma.setEmpresa(terminoproformaDataAccess.getEmpresa(connexion,terminoproforma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(terminoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			terminoproforma.setSucursal(terminoproformaDataAccess.getSucursal(connexion,terminoproforma));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(terminoproforma.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			terminoproforma.setMoneda(terminoproformaDataAccess.getMoneda(connexion,terminoproforma));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(terminoproforma.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			terminoproforma.setProforma(terminoproformaDataAccess.getProforma(connexion,terminoproforma));
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(terminoproforma.getProforma(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTerminoProforma.class));
			terminoproforma.setDetalleTerminoProformas(terminoproformaDataAccess.getDetalleTerminoProformas(connexion,terminoproforma));

			for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
				DetalleTerminoProformaLogic detalleterminoproformaLogic= new DetalleTerminoProformaLogic(connexion);
				detalleterminoproformaLogic.deepLoad(detalleterminoproforma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TerminoProforma terminoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TerminoProformaLogicAdditional.updateTerminoProformaToSave(terminoproforma,this.arrDatoGeneral);
			
TerminoProformaDataAccess.save(terminoproforma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(terminoproforma.getEmpresa(),connexion);

		SucursalDataAccess.save(terminoproforma.getSucursal(),connexion);

		MonedaDataAccess.save(terminoproforma.getMoneda(),connexion);

		ProformaDataAccess.save(terminoproforma.getProforma(),connexion);

		for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
			detalleterminoproforma.setid_termino_proforma(terminoproforma.getId());
			DetalleTerminoProformaDataAccess.save(detalleterminoproforma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(terminoproforma.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(terminoproforma.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(terminoproforma.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				ProformaDataAccess.save(terminoproforma.getProforma(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleTerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
					detalleterminoproforma.setid_termino_proforma(terminoproforma.getId());
					DetalleTerminoProformaDataAccess.save(detalleterminoproforma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(terminoproforma.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(terminoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(terminoproforma.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(terminoproforma.getSucursal(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(terminoproforma.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(terminoproforma.getMoneda(),isDeep,deepLoadType,clases);
				

		ProformaDataAccess.save(terminoproforma.getProforma(),connexion);
		ProformaLogic proformaLogic= new ProformaLogic(connexion);
		proformaLogic.deepLoad(terminoproforma.getProforma(),isDeep,deepLoadType,clases);
				

		for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
			DetalleTerminoProformaLogic detalleterminoproformaLogic= new DetalleTerminoProformaLogic(connexion);
			detalleterminoproforma.setid_termino_proforma(terminoproforma.getId());
			DetalleTerminoProformaDataAccess.save(detalleterminoproforma,connexion);
			detalleterminoproformaLogic.deepSave(detalleterminoproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(terminoproforma.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(terminoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(terminoproforma.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(terminoproforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(terminoproforma.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(terminoproforma.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				ProformaDataAccess.save(terminoproforma.getProforma(),connexion);
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepSave(terminoproforma.getProforma(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleTerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTerminoProforma detalleterminoproforma:terminoproforma.getDetalleTerminoProformas()) {
					DetalleTerminoProformaLogic detalleterminoproformaLogic= new DetalleTerminoProformaLogic(connexion);
					detalleterminoproforma.setid_termino_proforma(terminoproforma.getId());
					DetalleTerminoProformaDataAccess.save(detalleterminoproforma,connexion);
					detalleterminoproformaLogic.deepSave(detalleterminoproforma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TerminoProforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(terminoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(terminoproforma);
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
			this.deepLoad(this.terminoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TerminoProforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(terminoproformas!=null) {
				for(TerminoProforma terminoproforma:terminoproformas) {
					this.deepLoad(terminoproforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(terminoproformas);
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
			if(terminoproformas!=null) {
				for(TerminoProforma terminoproforma:terminoproformas) {
					this.deepLoad(terminoproforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(terminoproformas);
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
			this.getNewConnexionToDeep(TerminoProforma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(terminoproforma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TerminoProforma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(terminoproformas!=null) {
				for(TerminoProforma terminoproforma:terminoproformas) {
					this.deepSave(terminoproforma,isDeep,deepLoadType,clases);
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
			if(terminoproformas!=null) {
				for(TerminoProforma terminoproforma:terminoproformas) {
					this.deepSave(terminoproforma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTerminoProformasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TerminoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTerminoProformasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TerminoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTerminoProformasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,TerminoProformaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTerminoProformasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,TerminoProformaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTerminoProformasFK_IdProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_proforma,TerminoProformaConstantesFunciones.IDPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProforma);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTerminoProformasFK_IdProforma(String sFinalQuery,Pagination pagination,Long id_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_proforma,TerminoProformaConstantesFunciones.IDPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProforma);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTerminoProformasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TerminoProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTerminoProformasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TerminoProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(this.terminoproformas);
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
			if(TerminoProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TerminoProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TerminoProforma terminoproforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TerminoProformaConstantesFunciones.ISCONAUDITORIA) {
				if(terminoproforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TerminoProformaDataAccess.TABLENAME, terminoproforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TerminoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TerminoProformaLogic.registrarAuditoriaDetallesTerminoProforma(connexion,terminoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(terminoproforma.getIsDeleted()) {
					/*if(!terminoproforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TerminoProformaDataAccess.TABLENAME, terminoproforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TerminoProformaLogic.registrarAuditoriaDetallesTerminoProforma(connexion,terminoproforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TerminoProformaDataAccess.TABLENAME, terminoproforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(terminoproforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TerminoProformaDataAccess.TABLENAME, terminoproforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TerminoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TerminoProformaLogic.registrarAuditoriaDetallesTerminoProforma(connexion,terminoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTerminoProforma(Connexion connexion,TerminoProforma terminoproforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(terminoproforma.getIsNew()||!terminoproforma.getid_empresa().equals(terminoproforma.getTerminoProformaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getid_empresa()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getid_empresa().toString();
				}
				if(terminoproforma.getid_empresa()!=null)
				{
					strValorNuevo=terminoproforma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getid_sucursal().equals(terminoproforma.getTerminoProformaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getid_sucursal()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getid_sucursal().toString();
				}
				if(terminoproforma.getid_sucursal()!=null)
				{
					strValorNuevo=terminoproforma.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getid_moneda().equals(terminoproforma.getTerminoProformaOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getid_moneda()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getid_moneda().toString();
				}
				if(terminoproforma.getid_moneda()!=null)
				{
					strValorNuevo=terminoproforma.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getid_proforma().equals(terminoproforma.getTerminoProformaOriginal().getid_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getid_proforma()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getid_proforma().toString();
				}
				if(terminoproforma.getid_proforma()!=null)
				{
					strValorNuevo=terminoproforma.getid_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.IDPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getatencion().equals(terminoproforma.getTerminoProformaOriginal().getatencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getatencion()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getatencion();
				}
				if(terminoproforma.getatencion()!=null)
				{
					strValorNuevo=terminoproforma.getatencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.ATENCION,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getregistro_sanitario().equals(terminoproforma.getTerminoProformaOriginal().getregistro_sanitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getregistro_sanitario()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getregistro_sanitario();
				}
				if(terminoproforma.getregistro_sanitario()!=null)
				{
					strValorNuevo=terminoproforma.getregistro_sanitario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.REGISTROSANITARIO,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getreferencia().equals(terminoproforma.getTerminoProformaOriginal().getreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getreferencia()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getreferencia();
				}
				if(terminoproforma.getreferencia()!=null)
				{
					strValorNuevo=terminoproforma.getreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.REFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getdescripcion().equals(terminoproforma.getTerminoProformaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getdescripcion()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getdescripcion();
				}
				if(terminoproforma.getdescripcion()!=null)
				{
					strValorNuevo=terminoproforma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getdescripcion2().equals(terminoproforma.getTerminoProformaOriginal().getdescripcion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getdescripcion2()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getdescripcion2();
				}
				if(terminoproforma.getdescripcion2()!=null)
				{
					strValorNuevo=terminoproforma.getdescripcion2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.DESCRIPCION2,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getmarca().equals(terminoproforma.getTerminoProformaOriginal().getmarca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getmarca()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getmarca();
				}
				if(terminoproforma.getmarca()!=null)
				{
					strValorNuevo=terminoproforma.getmarca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.MARCA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getorigen().equals(terminoproforma.getTerminoProformaOriginal().getorigen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getorigen()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getorigen();
				}
				if(terminoproforma.getorigen()!=null)
				{
					strValorNuevo=terminoproforma.getorigen() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.ORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getgarantia_tecnica().equals(terminoproforma.getTerminoProformaOriginal().getgarantia_tecnica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getgarantia_tecnica()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getgarantia_tecnica();
				}
				if(terminoproforma.getgarantia_tecnica()!=null)
				{
					strValorNuevo=terminoproforma.getgarantia_tecnica() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.GARANTIATECNICA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getfecha_pago().equals(terminoproforma.getTerminoProformaOriginal().getfecha_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getfecha_pago()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getfecha_pago();
				}
				if(terminoproforma.getfecha_pago()!=null)
				{
					strValorNuevo=terminoproforma.getfecha_pago() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.FECHAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getfecha_entrega().equals(terminoproforma.getTerminoProformaOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getfecha_entrega()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getfecha_entrega();
				}
				if(terminoproforma.getfecha_entrega()!=null)
				{
					strValorNuevo=terminoproforma.getfecha_entrega() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getadjunto().equals(terminoproforma.getTerminoProformaOriginal().getadjunto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getadjunto()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getadjunto();
				}
				if(terminoproforma.getadjunto()!=null)
				{
					strValorNuevo=terminoproforma.getadjunto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.ADJUNTO,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getresponsable().equals(terminoproforma.getTerminoProformaOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getresponsable()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getresponsable();
				}
				if(terminoproforma.getresponsable()!=null)
				{
					strValorNuevo=terminoproforma.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(terminoproforma.getIsNew()||!terminoproforma.getcargo().equals(terminoproforma.getTerminoProformaOriginal().getcargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(terminoproforma.getTerminoProformaOriginal().getcargo()!=null)
				{
					strValorActual=terminoproforma.getTerminoProformaOriginal().getcargo();
				}
				if(terminoproforma.getcargo()!=null)
				{
					strValorNuevo=terminoproforma.getcargo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TerminoProformaConstantesFunciones.CARGO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTerminoProformaRelacionesWithConnection(TerminoProforma terminoproforma,List<DetalleTerminoProforma> detalleterminoproformas) throws Exception {

		if(!terminoproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTerminoProformaRelacionesBase(terminoproforma,detalleterminoproformas,true);
		}
	}

	public void saveTerminoProformaRelaciones(TerminoProforma terminoproforma,List<DetalleTerminoProforma> detalleterminoproformas)throws Exception {

		if(!terminoproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTerminoProformaRelacionesBase(terminoproforma,detalleterminoproformas,false);
		}
	}

	public void saveTerminoProformaRelacionesBase(TerminoProforma terminoproforma,List<DetalleTerminoProforma> detalleterminoproformas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TerminoProforma-saveRelacionesWithConnection");}
	
			terminoproforma.setDetalleTerminoProformas(detalleterminoproformas);

			this.setTerminoProforma(terminoproforma);

			if(TerminoProformaLogicAdditional.validarSaveRelaciones(terminoproforma,this)) {

				TerminoProformaLogicAdditional.updateRelacionesToSave(terminoproforma,this);

				if((terminoproforma.getIsNew()||terminoproforma.getIsChanged())&&!terminoproforma.getIsDeleted()) {
					this.saveTerminoProforma();
					this.saveTerminoProformaRelacionesDetalles(detalleterminoproformas);

				} else if(terminoproforma.getIsDeleted()) {
					this.saveTerminoProformaRelacionesDetalles(detalleterminoproformas);
					this.saveTerminoProforma();
				}

				TerminoProformaLogicAdditional.updateRelacionesToSaveAfter(terminoproforma,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleTerminoProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleTerminoProformas(detalleterminoproformas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTerminoProformaRelacionesDetalles(List<DetalleTerminoProforma> detalleterminoproformas)throws Exception {
		try {
	

			Long idTerminoProformaActual=this.getTerminoProforma().getId();

			DetalleTerminoProformaLogic detalleterminoproformaLogic_Desde_TerminoProforma=new DetalleTerminoProformaLogic();
			detalleterminoproformaLogic_Desde_TerminoProforma.setDetalleTerminoProformas(detalleterminoproformas);

			detalleterminoproformaLogic_Desde_TerminoProforma.setConnexion(this.getConnexion());
			detalleterminoproformaLogic_Desde_TerminoProforma.setDatosCliente(this.datosCliente);

			for(DetalleTerminoProforma detalleterminoproforma_Desde_TerminoProforma:detalleterminoproformaLogic_Desde_TerminoProforma.getDetalleTerminoProformas()) {
				detalleterminoproforma_Desde_TerminoProforma.setid_termino_proforma(idTerminoProformaActual);
			}

			detalleterminoproformaLogic_Desde_TerminoProforma.saveDetalleTerminoProformas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TerminoProformaConstantesFunciones.getClassesForeignKeysOfTerminoProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TerminoProformaConstantesFunciones.getClassesRelationshipsOfTerminoProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
