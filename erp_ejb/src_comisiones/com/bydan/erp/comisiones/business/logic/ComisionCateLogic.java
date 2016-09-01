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
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.ComisionCateConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionCateParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionCateParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionCate;
import com.bydan.erp.comisiones.business.logic.ComisionCateLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ComisionCateLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionCateLogic.class);
	
	protected ComisionCateDataAccess comisioncateDataAccess; 	
	protected ComisionCate comisioncate;
	protected List<ComisionCate> comisioncates;
	protected Object comisioncateObject;	
	protected List<Object> comisioncatesObject;
	
	public static ClassValidator<ComisionCate> comisioncateValidator = new ClassValidator<ComisionCate>(ComisionCate.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionCateLogicAdditional comisioncateLogicAdditional=null;
	
	public ComisionCateLogicAdditional getComisionCateLogicAdditional() {
		return this.comisioncateLogicAdditional;
	}
	
	public void setComisionCateLogicAdditional(ComisionCateLogicAdditional comisioncateLogicAdditional) {
		try {
			this.comisioncateLogicAdditional=comisioncateLogicAdditional;
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
	
	
	
	
	public  ComisionCateLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisioncateDataAccess = new ComisionCateDataAccess();
			
			this.comisioncates= new ArrayList<ComisionCate>();
			this.comisioncate= new ComisionCate();
			
			this.comisioncateObject=new Object();
			this.comisioncatesObject=new ArrayList<Object>();
				
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
			
			this.comisioncateDataAccess.setConnexionType(this.connexionType);
			this.comisioncateDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionCateLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisioncateDataAccess = new ComisionCateDataAccess();
			this.comisioncates= new ArrayList<ComisionCate>();
			this.comisioncate= new ComisionCate();
			this.comisioncateObject=new Object();
			this.comisioncatesObject=new ArrayList<Object>();
			
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
			
			this.comisioncateDataAccess.setConnexionType(this.connexionType);
			this.comisioncateDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionCate getComisionCate() throws Exception {	
		ComisionCateLogicAdditional.checkComisionCateToGet(comisioncate,this.datosCliente,this.arrDatoGeneral);
		ComisionCateLogicAdditional.updateComisionCateToGet(comisioncate,this.arrDatoGeneral);
		
		return comisioncate;
	}
		
	public void setComisionCate(ComisionCate newComisionCate) {
		this.comisioncate = newComisionCate;
	}
	
	public ComisionCateDataAccess getComisionCateDataAccess() {
		return comisioncateDataAccess;
	}
	
	public void setComisionCateDataAccess(ComisionCateDataAccess newcomisioncateDataAccess) {
		this.comisioncateDataAccess = newcomisioncateDataAccess;
	}
	
	public List<ComisionCate> getComisionCates() throws Exception {		
		this.quitarComisionCatesNulos();
		
		ComisionCateLogicAdditional.checkComisionCateToGets(comisioncates,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionCate comisioncateLocal: comisioncates ) {
			ComisionCateLogicAdditional.updateComisionCateToGet(comisioncateLocal,this.arrDatoGeneral);
		}
		
		return comisioncates;
	}
	
	public void setComisionCates(List<ComisionCate> newComisionCates) {
		this.comisioncates = newComisionCates;
	}
	
	public Object getComisionCateObject() {	
		this.comisioncateObject=this.comisioncateDataAccess.getEntityObject();
		return this.comisioncateObject;
	}
		
	public void setComisionCateObject(Object newComisionCateObject) {
		this.comisioncateObject = newComisionCateObject;
	}
	
	public List<Object> getComisionCatesObject() {		
		this.comisioncatesObject=this.comisioncateDataAccess.getEntitiesObject();
		return this.comisioncatesObject;
	}
		
	public void setComisionCatesObject(List<Object> newComisionCatesObject) {
		this.comisioncatesObject = newComisionCatesObject;
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
		
		if(this.comisioncateDataAccess!=null) {
			this.comisioncateDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisioncateDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			comisioncateDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisioncate = new  ComisionCate();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisioncate=comisioncateDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisioncate,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
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
		comisioncate = new  ComisionCate();
		  		  
        try {
			
			comisioncate=comisioncateDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisioncate,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisioncate = new  ComisionCate();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisioncate=comisioncateDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisioncate,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
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
		comisioncate = new  ComisionCate();
		  		  
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
		comisioncate = new  ComisionCate();
		  		  
        try {
			
			comisioncate=comisioncateDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisioncate,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisioncate = new  ComisionCate();
		  		  
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
		comisioncate = new  ComisionCate();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisioncateDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisioncate = new  ComisionCate();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisioncateDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisioncate = new  ComisionCate();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisioncateDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisioncate = new  ComisionCate();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisioncateDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisioncate = new  ComisionCate();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisioncateDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisioncate = new  ComisionCate();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisioncateDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
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
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
        try {			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
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
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
        try {
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
		comisioncates = new  ArrayList<ComisionCate>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
		comisioncates = new  ArrayList<ComisionCate>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisioncate = new  ComisionCate();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncate=comisioncateDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncate);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
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
		comisioncate = new  ComisionCate();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncate=comisioncateDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncate);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
		comisioncates = new  ArrayList<ComisionCate>();
		  		  
        try {
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionCatesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisioncates = new  ArrayList<ComisionCate>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getTodosComisionCatesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
	
	public  void  getTodosComisionCates(String sFinalQuery,Pagination pagination)throws Exception {
		comisioncates = new  ArrayList<ComisionCate>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionCate(comisioncates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionCate(ComisionCate comisioncate) throws Exception {
		Boolean estaValidado=false;
		
		if(comisioncate.getIsNew() || comisioncate.getIsChanged()) { 
			this.invalidValues = comisioncateValidator.getInvalidValues(comisioncate);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisioncate);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionCate(List<ComisionCate> ComisionCates) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionCate comisioncateLocal:comisioncates) {				
			estaValidadoObjeto=this.validarGuardarComisionCate(comisioncateLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionCate(List<ComisionCate> ComisionCates) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionCate(comisioncates)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionCate(ComisionCate ComisionCate) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionCate(comisioncate)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionCate comisioncate) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisioncate.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionCateConstantesFunciones.getComisionCateLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisioncate","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionCateConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionCateConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionCateWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-saveComisionCateWithConnection");connexion.begin();			
			
			ComisionCateLogicAdditional.checkComisionCateToSave(this.comisioncate,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionCateLogicAdditional.updateComisionCateToSave(this.comisioncate,this.arrDatoGeneral);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisioncate,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionCate();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionCate(this.comisioncate)) {
				ComisionCateDataAccess.save(this.comisioncate, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisioncate,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionCateLogicAdditional.checkComisionCateToSaveAfter(this.comisioncate,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionCate();
			
			connexion.commit();			
			
			if(this.comisioncate.getIsDeleted()) {
				this.comisioncate=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionCate()throws Exception {	
		try {	
			
			ComisionCateLogicAdditional.checkComisionCateToSave(this.comisioncate,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionCateLogicAdditional.updateComisionCateToSave(this.comisioncate,this.arrDatoGeneral);
			
			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisioncate,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionCate(this.comisioncate)) {			
				ComisionCateDataAccess.save(this.comisioncate, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisioncate,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionCateLogicAdditional.checkComisionCateToSaveAfter(this.comisioncate,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisioncate.getIsDeleted()) {
				this.comisioncate=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionCatesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-saveComisionCatesWithConnection");connexion.begin();			
			
			ComisionCateLogicAdditional.checkComisionCateToSaves(comisioncates,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionCates();
			
			Boolean validadoTodosComisionCate=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionCate comisioncateLocal:comisioncates) {		
				if(comisioncateLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionCateLogicAdditional.updateComisionCateToSave(comisioncateLocal,this.arrDatoGeneral);
	        	
				ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisioncateLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionCate(comisioncateLocal)) {
					ComisionCateDataAccess.save(comisioncateLocal, connexion);				
				} else {
					validadoTodosComisionCate=false;
				}
			}
			
			if(!validadoTodosComisionCate) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionCateLogicAdditional.checkComisionCateToSavesAfter(comisioncates,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionCates();
			
			connexion.commit();		
			
			this.quitarComisionCatesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionCates()throws Exception {				
		 try {	
			ComisionCateLogicAdditional.checkComisionCateToSaves(comisioncates,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionCate=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionCate comisioncateLocal:comisioncates) {				
				if(comisioncateLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionCateLogicAdditional.updateComisionCateToSave(comisioncateLocal,this.arrDatoGeneral);
	        	
				ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisioncateLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionCate(comisioncateLocal)) {				
					ComisionCateDataAccess.save(comisioncateLocal, connexion);				
				} else {
					validadoTodosComisionCate=false;
				}
			}
			
			if(!validadoTodosComisionCate) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionCateLogicAdditional.checkComisionCateToSavesAfter(comisioncates,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionCatesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionCateParameterReturnGeneral procesarAccionComisionCates(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionCate> comisioncates,ComisionCateParameterReturnGeneral comisioncateParameterGeneral)throws Exception {
		 try {	
			ComisionCateParameterReturnGeneral comisioncateReturnGeneral=new ComisionCateParameterReturnGeneral();
	
			ComisionCateLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisioncates,comisioncateParameterGeneral,comisioncateReturnGeneral);
			
			return comisioncateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionCateParameterReturnGeneral procesarAccionComisionCatesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionCate> comisioncates,ComisionCateParameterReturnGeneral comisioncateParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-procesarAccionComisionCatesWithConnection");connexion.begin();			
			
			ComisionCateParameterReturnGeneral comisioncateReturnGeneral=new ComisionCateParameterReturnGeneral();
	
			ComisionCateLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisioncates,comisioncateParameterGeneral,comisioncateReturnGeneral);
			
			this.connexion.commit();
			
			return comisioncateReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionCateParameterReturnGeneral procesarEventosComisionCates(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionCate> comisioncates,ComisionCate comisioncate,ComisionCateParameterReturnGeneral comisioncateParameterGeneral,Boolean isEsNuevoComisionCate,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionCateParameterReturnGeneral comisioncateReturnGeneral=new ComisionCateParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisioncateReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionCateLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisioncates,comisioncate,comisioncateParameterGeneral,comisioncateReturnGeneral,isEsNuevoComisionCate,clases);
			
			return comisioncateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionCateParameterReturnGeneral procesarEventosComisionCatesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionCate> comisioncates,ComisionCate comisioncate,ComisionCateParameterReturnGeneral comisioncateParameterGeneral,Boolean isEsNuevoComisionCate,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-procesarEventosComisionCatesWithConnection");connexion.begin();			
			
			ComisionCateParameterReturnGeneral comisioncateReturnGeneral=new ComisionCateParameterReturnGeneral();
	
			comisioncateReturnGeneral.setComisionCate(comisioncate);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisioncateReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionCateLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisioncates,comisioncate,comisioncateParameterGeneral,comisioncateReturnGeneral,isEsNuevoComisionCate,clases);
			
			this.connexion.commit();
			
			return comisioncateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionCateParameterReturnGeneral procesarImportacionComisionCatesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionCateParameterReturnGeneral comisioncateParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-procesarImportacionComisionCatesWithConnection");connexion.begin();			
			
			ComisionCateParameterReturnGeneral comisioncateReturnGeneral=new ComisionCateParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisioncates=new ArrayList<ComisionCate>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisioncate=new ComisionCate();
				
				
				if(conColumnasBase) {this.comisioncate.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisioncate.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisioncate.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisioncate.setdescripcion(arrColumnas[iColumn++]);
				
				this.comisioncates.add(this.comisioncate);
			}
			
			this.saveComisionCates();
			
			this.connexion.commit();
			
			comisioncateReturnGeneral.setConRetornoEstaProcesado(true);
			comisioncateReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisioncateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionCatesEliminados() throws Exception {				
		
		List<ComisionCate> comisioncatesAux= new ArrayList<ComisionCate>();
		
		for(ComisionCate comisioncate:comisioncates) {
			if(!comisioncate.getIsDeleted()) {
				comisioncatesAux.add(comisioncate);
			}
		}
		
		comisioncates=comisioncatesAux;
	}
	
	public void quitarComisionCatesNulos() throws Exception {				
		
		List<ComisionCate> comisioncatesAux= new ArrayList<ComisionCate>();
		
		for(ComisionCate comisioncate : this.comisioncates) {
			if(comisioncate==null) {
				comisioncatesAux.add(comisioncate);
			}
		}
		
		//this.comisioncates=comisioncatesAux;
		
		this.comisioncates.removeAll(comisioncatesAux);
	}
	
	public void getSetVersionRowComisionCateWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisioncate.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisioncate.getIsDeleted() || (comisioncate.getIsChanged()&&!comisioncate.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisioncateDataAccess.getSetVersionRowComisionCate(connexion,comisioncate.getId());
				
				if(!comisioncate.getVersionRow().equals(timestamp)) {	
					comisioncate.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisioncate.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionCate()throws Exception {	
		
		if(comisioncate.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisioncate.getIsDeleted() || (comisioncate.getIsChanged()&&!comisioncate.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisioncateDataAccess.getSetVersionRowComisionCate(connexion,comisioncate.getId());
			
			try {							
				if(!comisioncate.getVersionRow().equals(timestamp)) {	
					comisioncate.setVersionRow(timestamp);
				}
				
				comisioncate.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionCatesWithConnection()throws Exception {	
		if(comisioncates!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionCate comisioncateAux:comisioncates) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisioncateAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisioncateAux.getIsDeleted() || (comisioncateAux.getIsChanged()&&!comisioncateAux.getIsNew())) {
						
						timestamp=comisioncateDataAccess.getSetVersionRowComisionCate(connexion,comisioncateAux.getId());
						
						if(!comisioncate.getVersionRow().equals(timestamp)) {	
							comisioncateAux.setVersionRow(timestamp);
						}
								
						comisioncateAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowComisionCates()throws Exception {	
		if(comisioncates!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionCate comisioncateAux:comisioncates) {
					if(comisioncateAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisioncateAux.getIsDeleted() || (comisioncateAux.getIsChanged()&&!comisioncateAux.getIsNew())) {
						
						timestamp=comisioncateDataAccess.getSetVersionRowComisionCate(connexion,comisioncateAux.getId());
						
						if(!comisioncateAux.getVersionRow().equals(timestamp)) {	
							comisioncateAux.setVersionRow(timestamp);
						}
						
													
						comisioncateAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionCateParameterReturnGeneral cargarCombosLoteForeignKeyComisionCateWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionCateParameterReturnGeneral  comisioncateReturnGeneral =new ComisionCateParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionCateWithConnection");connexion.begin();
			
			comisioncateReturnGeneral =new ComisionCateParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisioncateReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisioncateReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisioncateReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisioncateReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			comisioncateReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			comisioncateReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisioncateReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisioncateReturnGeneral;
	}
	
	public ComisionCateParameterReturnGeneral cargarCombosLoteForeignKeyComisionCate(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionCateParameterReturnGeneral  comisioncateReturnGeneral =new ComisionCateParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisioncateReturnGeneral =new ComisionCateParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisioncateReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisioncateReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisioncateReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisioncateReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			comisioncateReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			comisioncateReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisioncateReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisioncateReturnGeneral;
	}
	
	
	public void deepLoad(ComisionCate comisioncate,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionCateLogicAdditional.updateComisionCateToGet(comisioncate,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisioncate.setEmpresa(comisioncateDataAccess.getEmpresa(connexion,comisioncate));
		comisioncate.setComisionConfig(comisioncateDataAccess.getComisionConfig(connexion,comisioncate));
		comisioncate.setVendedor(comisioncateDataAccess.getVendedor(connexion,comisioncate));
		comisioncate.setLinea(comisioncateDataAccess.getLinea(connexion,comisioncate));
		comisioncate.setLineaGrupo(comisioncateDataAccess.getLineaGrupo(connexion,comisioncate));
		comisioncate.setLineaCategoria(comisioncateDataAccess.getLineaCategoria(connexion,comisioncate));
		comisioncate.setEstadoComision(comisioncateDataAccess.getEstadoComision(connexion,comisioncate));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisioncate.setEmpresa(comisioncateDataAccess.getEmpresa(connexion,comisioncate));
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisioncate.setComisionConfig(comisioncateDataAccess.getComisionConfig(connexion,comisioncate));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisioncate.setVendedor(comisioncateDataAccess.getVendedor(connexion,comisioncate));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisioncate.setLinea(comisioncateDataAccess.getLinea(connexion,comisioncate));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisioncate.setLineaGrupo(comisioncateDataAccess.getLineaGrupo(connexion,comisioncate));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisioncate.setLineaCategoria(comisioncateDataAccess.getLineaCategoria(connexion,comisioncate));
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisioncate.setEstadoComision(comisioncateDataAccess.getEstadoComision(connexion,comisioncate));
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
			comisioncate.setEmpresa(comisioncateDataAccess.getEmpresa(connexion,comisioncate));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setComisionConfig(comisioncateDataAccess.getComisionConfig(connexion,comisioncate));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setVendedor(comisioncateDataAccess.getVendedor(connexion,comisioncate));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setLinea(comisioncateDataAccess.getLinea(connexion,comisioncate));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setLineaGrupo(comisioncateDataAccess.getLineaGrupo(connexion,comisioncate));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setLineaCategoria(comisioncateDataAccess.getLineaCategoria(connexion,comisioncate));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setEstadoComision(comisioncateDataAccess.getEstadoComision(connexion,comisioncate));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisioncate.setEmpresa(comisioncateDataAccess.getEmpresa(connexion,comisioncate));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisioncate.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisioncate.setComisionConfig(comisioncateDataAccess.getComisionConfig(connexion,comisioncate));
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisioncate.getComisionConfig(),isDeep,deepLoadType,clases);
				
		comisioncate.setVendedor(comisioncateDataAccess.getVendedor(connexion,comisioncate));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisioncate.getVendedor(),isDeep,deepLoadType,clases);
				
		comisioncate.setLinea(comisioncateDataAccess.getLinea(connexion,comisioncate));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisioncate.getLinea(),isDeep,deepLoadType,clases);
				
		comisioncate.setLineaGrupo(comisioncateDataAccess.getLineaGrupo(connexion,comisioncate));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(comisioncate.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		comisioncate.setLineaCategoria(comisioncateDataAccess.getLineaCategoria(connexion,comisioncate));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(comisioncate.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		comisioncate.setEstadoComision(comisioncateDataAccess.getEstadoComision(connexion,comisioncate));
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisioncate.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisioncate.setEmpresa(comisioncateDataAccess.getEmpresa(connexion,comisioncate));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisioncate.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisioncate.setComisionConfig(comisioncateDataAccess.getComisionConfig(connexion,comisioncate));
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepLoad(comisioncate.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisioncate.setVendedor(comisioncateDataAccess.getVendedor(connexion,comisioncate));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(comisioncate.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisioncate.setLinea(comisioncateDataAccess.getLinea(connexion,comisioncate));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisioncate.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisioncate.setLineaGrupo(comisioncateDataAccess.getLineaGrupo(connexion,comisioncate));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisioncate.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisioncate.setLineaCategoria(comisioncateDataAccess.getLineaCategoria(connexion,comisioncate));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisioncate.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisioncate.setEstadoComision(comisioncateDataAccess.getEstadoComision(connexion,comisioncate));
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepLoad(comisioncate.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			comisioncate.setEmpresa(comisioncateDataAccess.getEmpresa(connexion,comisioncate));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisioncate.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setComisionConfig(comisioncateDataAccess.getComisionConfig(connexion,comisioncate));
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisioncate.getComisionConfig(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setVendedor(comisioncateDataAccess.getVendedor(connexion,comisioncate));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(comisioncate.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setLinea(comisioncateDataAccess.getLinea(connexion,comisioncate));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisioncate.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setLineaGrupo(comisioncateDataAccess.getLineaGrupo(connexion,comisioncate));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisioncate.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setLineaCategoria(comisioncateDataAccess.getLineaCategoria(connexion,comisioncate));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisioncate.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisioncate.setEstadoComision(comisioncateDataAccess.getEstadoComision(connexion,comisioncate));
			EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
			estadocomisionLogic.deepLoad(comisioncate.getEstadoComision(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionCate comisioncate,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionCateLogicAdditional.updateComisionCateToSave(comisioncate,this.arrDatoGeneral);
			
ComisionCateDataAccess.save(comisioncate, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisioncate.getEmpresa(),connexion);

		ComisionConfigDataAccess.save(comisioncate.getComisionConfig(),connexion);

		VendedorDataAccess.save(comisioncate.getVendedor(),connexion);

		LineaDataAccess.save(comisioncate.getLinea(),connexion);

		LineaDataAccess.save(comisioncate.getLineaGrupo(),connexion);

		LineaDataAccess.save(comisioncate.getLineaCategoria(),connexion);

		EstadoComisionDataAccess.save(comisioncate.getEstadoComision(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisioncate.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisioncate.getComisionConfig(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisioncate.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisioncate.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisioncate.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisioncate.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisioncate.getEstadoComision(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisioncate.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisioncate.getEmpresa(),isDeep,deepLoadType,clases);
				

		ComisionConfigDataAccess.save(comisioncate.getComisionConfig(),connexion);
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisioncate.getComisionConfig(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(comisioncate.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisioncate.getVendedor(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisioncate.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisioncate.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisioncate.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(comisioncate.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisioncate.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(comisioncate.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		EstadoComisionDataAccess.save(comisioncate.getEstadoComision(),connexion);
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisioncate.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisioncate.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisioncate.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisioncate.getComisionConfig(),connexion);
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepSave(comisioncate.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisioncate.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(comisioncate.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisioncate.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisioncate.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisioncate.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisioncate.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisioncate.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisioncate.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisioncate.getEstadoComision(),connexion);
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepSave(comisioncate.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ComisionCate.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisioncate,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(comisioncate);
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
			this.deepLoad(this.comisioncate,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncate);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionCate.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisioncates!=null) {
				for(ComisionCate comisioncate:comisioncates) {
					this.deepLoad(comisioncate,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(comisioncates);
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
			if(comisioncates!=null) {
				for(ComisionCate comisioncate:comisioncates) {
					this.deepLoad(comisioncate,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(comisioncates);
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
			this.getNewConnexionToDeep(ComisionCate.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisioncate,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ComisionCate.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisioncates!=null) {
				for(ComisionCate comisioncate:comisioncates) {
					this.deepSave(comisioncate,isDeep,deepLoadType,clases);
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
			if(comisioncates!=null) {
				for(ComisionCate comisioncate:comisioncates) {
					this.deepSave(comisioncate,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionCatesFK_IdComisionConfigWithConnection(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionCateConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdComisionConfig(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionCateConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionCatesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionCateConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionCateConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionCatesFK_IdEstadoComisionWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionCateConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdEstadoComision(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionCateConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionCatesFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionCateConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionCateConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionCatesFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,ComisionCateConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,ComisionCateConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionCatesFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ComisionCateConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ComisionCateConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionCatesFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionCate.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionCateConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionCatesFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionCateConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionCateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(this.comisioncates);
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
			if(ComisionCateConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionCateDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionCate comisioncate,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionCateConstantesFunciones.ISCONAUDITORIA) {
				if(comisioncate.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionCateDataAccess.TABLENAME, comisioncate.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionCateConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionCateLogic.registrarAuditoriaDetallesComisionCate(connexion,comisioncate,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisioncate.getIsDeleted()) {
					/*if(!comisioncate.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionCateDataAccess.TABLENAME, comisioncate.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionCateLogic.registrarAuditoriaDetallesComisionCate(connexion,comisioncate,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionCateDataAccess.TABLENAME, comisioncate.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisioncate.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionCateDataAccess.TABLENAME, comisioncate.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionCateConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionCateLogic.registrarAuditoriaDetallesComisionCate(connexion,comisioncate,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionCate(Connexion connexion,ComisionCate comisioncate)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisioncate.getIsNew()||!comisioncate.getid_empresa().equals(comisioncate.getComisionCateOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_empresa()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_empresa().toString();
				}
				if(comisioncate.getid_empresa()!=null)
				{
					strValorNuevo=comisioncate.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getid_comision_config().equals(comisioncate.getComisionCateOriginal().getid_comision_config()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_comision_config()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_comision_config().toString();
				}
				if(comisioncate.getid_comision_config()!=null)
				{
					strValorNuevo=comisioncate.getid_comision_config().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDCOMISIONCONFIG,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getid_vendedor().equals(comisioncate.getComisionCateOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_vendedor()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_vendedor().toString();
				}
				if(comisioncate.getid_vendedor()!=null)
				{
					strValorNuevo=comisioncate.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getid_linea().equals(comisioncate.getComisionCateOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_linea()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_linea().toString();
				}
				if(comisioncate.getid_linea()!=null)
				{
					strValorNuevo=comisioncate.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getid_linea_grupo().equals(comisioncate.getComisionCateOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_linea_grupo().toString();
				}
				if(comisioncate.getid_linea_grupo()!=null)
				{
					strValorNuevo=comisioncate.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getid_linea_categoria().equals(comisioncate.getComisionCateOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_linea_categoria().toString();
				}
				if(comisioncate.getid_linea_categoria()!=null)
				{
					strValorNuevo=comisioncate.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getid_estado_comision().equals(comisioncate.getComisionCateOriginal().getid_estado_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getid_estado_comision()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getid_estado_comision().toString();
				}
				if(comisioncate.getid_estado_comision()!=null)
				{
					strValorNuevo=comisioncate.getid_estado_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.IDESTADOCOMISION,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getporcentaje().equals(comisioncate.getComisionCateOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getporcentaje()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getporcentaje().toString();
				}
				if(comisioncate.getporcentaje()!=null)
				{
					strValorNuevo=comisioncate.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(comisioncate.getIsNew()||!comisioncate.getdescripcion().equals(comisioncate.getComisionCateOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisioncate.getComisionCateOriginal().getdescripcion()!=null)
				{
					strValorActual=comisioncate.getComisionCateOriginal().getdescripcion();
				}
				if(comisioncate.getdescripcion()!=null)
				{
					strValorNuevo=comisioncate.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionCateConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionCateRelacionesWithConnection(ComisionCate comisioncate) throws Exception {

		if(!comisioncate.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionCateRelacionesBase(comisioncate,true);
		}
	}

	public void saveComisionCateRelaciones(ComisionCate comisioncate)throws Exception {

		if(!comisioncate.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionCateRelacionesBase(comisioncate,false);
		}
	}

	public void saveComisionCateRelacionesBase(ComisionCate comisioncate,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionCate-saveRelacionesWithConnection");}
	

			this.setComisionCate(comisioncate);

			if(ComisionCateLogicAdditional.validarSaveRelaciones(comisioncate,this)) {

				ComisionCateLogicAdditional.updateRelacionesToSave(comisioncate,this);

				if((comisioncate.getIsNew()||comisioncate.getIsChanged())&&!comisioncate.getIsDeleted()) {
					this.saveComisionCate();
					this.saveComisionCateRelacionesDetalles();

				} else if(comisioncate.getIsDeleted()) {
					this.saveComisionCateRelacionesDetalles();
					this.saveComisionCate();
				}

				ComisionCateLogicAdditional.updateRelacionesToSaveAfter(comisioncate,this);

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
	
	
	private void saveComisionCateRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionCate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionCate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionCateConstantesFunciones.getClassesRelationshipsOfComisionCate(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
