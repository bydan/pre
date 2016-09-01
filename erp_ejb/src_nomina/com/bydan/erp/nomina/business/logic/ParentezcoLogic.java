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
import com.bydan.erp.nomina.util.ParentezcoConstantesFunciones;
import com.bydan.erp.nomina.util.ParentezcoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ParentezcoParameterGeneral;
import com.bydan.erp.nomina.business.entity.Parentezco;
import com.bydan.erp.nomina.business.logic.ParentezcoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParentezcoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParentezcoLogic.class);
	
	protected ParentezcoDataAccess parentezcoDataAccess; 	
	protected Parentezco parentezco;
	protected List<Parentezco> parentezcos;
	protected Object parentezcoObject;	
	protected List<Object> parentezcosObject;
	
	public static ClassValidator<Parentezco> parentezcoValidator = new ClassValidator<Parentezco>(Parentezco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParentezcoLogicAdditional parentezcoLogicAdditional=null;
	
	public ParentezcoLogicAdditional getParentezcoLogicAdditional() {
		return this.parentezcoLogicAdditional;
	}
	
	public void setParentezcoLogicAdditional(ParentezcoLogicAdditional parentezcoLogicAdditional) {
		try {
			this.parentezcoLogicAdditional=parentezcoLogicAdditional;
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
	
	
	
	
	public  ParentezcoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parentezcoDataAccess = new ParentezcoDataAccess();
			
			this.parentezcos= new ArrayList<Parentezco>();
			this.parentezco= new Parentezco();
			
			this.parentezcoObject=new Object();
			this.parentezcosObject=new ArrayList<Object>();
				
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
			
			this.parentezcoDataAccess.setConnexionType(this.connexionType);
			this.parentezcoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParentezcoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parentezcoDataAccess = new ParentezcoDataAccess();
			this.parentezcos= new ArrayList<Parentezco>();
			this.parentezco= new Parentezco();
			this.parentezcoObject=new Object();
			this.parentezcosObject=new ArrayList<Object>();
			
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
			
			this.parentezcoDataAccess.setConnexionType(this.connexionType);
			this.parentezcoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Parentezco getParentezco() throws Exception {	
		ParentezcoLogicAdditional.checkParentezcoToGet(parentezco,this.datosCliente,this.arrDatoGeneral);
		ParentezcoLogicAdditional.updateParentezcoToGet(parentezco,this.arrDatoGeneral);
		
		return parentezco;
	}
		
	public void setParentezco(Parentezco newParentezco) {
		this.parentezco = newParentezco;
	}
	
	public ParentezcoDataAccess getParentezcoDataAccess() {
		return parentezcoDataAccess;
	}
	
	public void setParentezcoDataAccess(ParentezcoDataAccess newparentezcoDataAccess) {
		this.parentezcoDataAccess = newparentezcoDataAccess;
	}
	
	public List<Parentezco> getParentezcos() throws Exception {		
		this.quitarParentezcosNulos();
		
		ParentezcoLogicAdditional.checkParentezcoToGets(parentezcos,this.datosCliente,this.arrDatoGeneral);
		
		for (Parentezco parentezcoLocal: parentezcos ) {
			ParentezcoLogicAdditional.updateParentezcoToGet(parentezcoLocal,this.arrDatoGeneral);
		}
		
		return parentezcos;
	}
	
	public void setParentezcos(List<Parentezco> newParentezcos) {
		this.parentezcos = newParentezcos;
	}
	
	public Object getParentezcoObject() {	
		this.parentezcoObject=this.parentezcoDataAccess.getEntityObject();
		return this.parentezcoObject;
	}
		
	public void setParentezcoObject(Object newParentezcoObject) {
		this.parentezcoObject = newParentezcoObject;
	}
	
	public List<Object> getParentezcosObject() {		
		this.parentezcosObject=this.parentezcoDataAccess.getEntitiesObject();
		return this.parentezcosObject;
	}
		
	public void setParentezcosObject(List<Object> newParentezcosObject) {
		this.parentezcosObject = newParentezcosObject;
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
		
		if(this.parentezcoDataAccess!=null) {
			this.parentezcoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parentezcoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parentezcoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parentezco = new  Parentezco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parentezco=parentezcoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parentezco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
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
		parentezco = new  Parentezco();
		  		  
        try {
			
			parentezco=parentezcoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parentezco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parentezco = new  Parentezco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parentezco=parentezcoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parentezco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
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
		parentezco = new  Parentezco();
		  		  
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
		parentezco = new  Parentezco();
		  		  
        try {
			
			parentezco=parentezcoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parentezco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parentezco = new  Parentezco();
		  		  
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
		parentezco = new  Parentezco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parentezcoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parentezco = new  Parentezco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parentezcoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parentezco = new  Parentezco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parentezcoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parentezco = new  Parentezco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parentezcoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parentezco = new  Parentezco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parentezcoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parentezco = new  Parentezco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parentezcoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parentezcos = new  ArrayList<Parentezco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
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
		parentezcos = new  ArrayList<Parentezco>();
		  		  
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
		parentezcos = new  ArrayList<Parentezco>();
		  		  
        try {			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parentezcos = new  ArrayList<Parentezco>();
		  		  
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
		parentezcos = new  ArrayList<Parentezco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
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
		parentezcos = new  ArrayList<Parentezco>();
		  		  
        try {
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
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
		parentezcos = new  ArrayList<Parentezco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
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
		parentezcos = new  ArrayList<Parentezco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parentezco = new  Parentezco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezco=parentezcoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParentezco(parentezco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
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
		parentezco = new  Parentezco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezco=parentezcoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParentezco(parentezco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parentezcos = new  ArrayList<Parentezco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
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
		parentezcos = new  ArrayList<Parentezco>();
		  		  
        try {
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParentezcosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parentezcos = new  ArrayList<Parentezco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-getTodosParentezcosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
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
	
	public  void  getTodosParentezcos(String sFinalQuery,Pagination pagination)throws Exception {
		parentezcos = new  ArrayList<Parentezco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parentezcos=parentezcoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParentezco(parentezcos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezcos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParentezco(Parentezco parentezco) throws Exception {
		Boolean estaValidado=false;
		
		if(parentezco.getIsNew() || parentezco.getIsChanged()) { 
			this.invalidValues = parentezcoValidator.getInvalidValues(parentezco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parentezco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParentezco(List<Parentezco> Parentezcos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Parentezco parentezcoLocal:parentezcos) {				
			estaValidadoObjeto=this.validarGuardarParentezco(parentezcoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParentezco(List<Parentezco> Parentezcos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParentezco(parentezcos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParentezco(Parentezco Parentezco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParentezco(parentezco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Parentezco parentezco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parentezco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParentezcoConstantesFunciones.getParentezcoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parentezco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParentezcoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParentezcoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParentezcoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-saveParentezcoWithConnection");connexion.begin();			
			
			ParentezcoLogicAdditional.checkParentezcoToSave(this.parentezco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParentezcoLogicAdditional.updateParentezcoToSave(this.parentezco,this.arrDatoGeneral);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parentezco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParentezco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParentezco(this.parentezco)) {
				ParentezcoDataAccess.save(this.parentezco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parentezco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParentezcoLogicAdditional.checkParentezcoToSaveAfter(this.parentezco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParentezco();
			
			connexion.commit();			
			
			if(this.parentezco.getIsDeleted()) {
				this.parentezco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParentezco()throws Exception {	
		try {	
			
			ParentezcoLogicAdditional.checkParentezcoToSave(this.parentezco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParentezcoLogicAdditional.updateParentezcoToSave(this.parentezco,this.arrDatoGeneral);
			
			ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parentezco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParentezco(this.parentezco)) {			
				ParentezcoDataAccess.save(this.parentezco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parentezco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParentezcoLogicAdditional.checkParentezcoToSaveAfter(this.parentezco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parentezco.getIsDeleted()) {
				this.parentezco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParentezcosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-saveParentezcosWithConnection");connexion.begin();			
			
			ParentezcoLogicAdditional.checkParentezcoToSaves(parentezcos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParentezcos();
			
			Boolean validadoTodosParentezco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Parentezco parentezcoLocal:parentezcos) {		
				if(parentezcoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParentezcoLogicAdditional.updateParentezcoToSave(parentezcoLocal,this.arrDatoGeneral);
	        	
				ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parentezcoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParentezco(parentezcoLocal)) {
					ParentezcoDataAccess.save(parentezcoLocal, connexion);				
				} else {
					validadoTodosParentezco=false;
				}
			}
			
			if(!validadoTodosParentezco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParentezcoLogicAdditional.checkParentezcoToSavesAfter(parentezcos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParentezcos();
			
			connexion.commit();		
			
			this.quitarParentezcosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParentezcos()throws Exception {				
		 try {	
			ParentezcoLogicAdditional.checkParentezcoToSaves(parentezcos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParentezco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Parentezco parentezcoLocal:parentezcos) {				
				if(parentezcoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParentezcoLogicAdditional.updateParentezcoToSave(parentezcoLocal,this.arrDatoGeneral);
	        	
				ParentezcoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parentezcoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParentezco(parentezcoLocal)) {				
					ParentezcoDataAccess.save(parentezcoLocal, connexion);				
				} else {
					validadoTodosParentezco=false;
				}
			}
			
			if(!validadoTodosParentezco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParentezcoLogicAdditional.checkParentezcoToSavesAfter(parentezcos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParentezcosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParentezcoParameterReturnGeneral procesarAccionParentezcos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Parentezco> parentezcos,ParentezcoParameterReturnGeneral parentezcoParameterGeneral)throws Exception {
		 try {	
			ParentezcoParameterReturnGeneral parentezcoReturnGeneral=new ParentezcoParameterReturnGeneral();
	
			ParentezcoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parentezcos,parentezcoParameterGeneral,parentezcoReturnGeneral);
			
			return parentezcoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParentezcoParameterReturnGeneral procesarAccionParentezcosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Parentezco> parentezcos,ParentezcoParameterReturnGeneral parentezcoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-procesarAccionParentezcosWithConnection");connexion.begin();			
			
			ParentezcoParameterReturnGeneral parentezcoReturnGeneral=new ParentezcoParameterReturnGeneral();
	
			ParentezcoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parentezcos,parentezcoParameterGeneral,parentezcoReturnGeneral);
			
			this.connexion.commit();
			
			return parentezcoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParentezcoParameterReturnGeneral procesarEventosParentezcos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Parentezco> parentezcos,Parentezco parentezco,ParentezcoParameterReturnGeneral parentezcoParameterGeneral,Boolean isEsNuevoParentezco,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParentezcoParameterReturnGeneral parentezcoReturnGeneral=new ParentezcoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parentezcoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParentezcoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parentezcos,parentezco,parentezcoParameterGeneral,parentezcoReturnGeneral,isEsNuevoParentezco,clases);
			
			return parentezcoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParentezcoParameterReturnGeneral procesarEventosParentezcosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Parentezco> parentezcos,Parentezco parentezco,ParentezcoParameterReturnGeneral parentezcoParameterGeneral,Boolean isEsNuevoParentezco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-procesarEventosParentezcosWithConnection");connexion.begin();			
			
			ParentezcoParameterReturnGeneral parentezcoReturnGeneral=new ParentezcoParameterReturnGeneral();
	
			parentezcoReturnGeneral.setParentezco(parentezco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parentezcoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParentezcoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parentezcos,parentezco,parentezcoParameterGeneral,parentezcoReturnGeneral,isEsNuevoParentezco,clases);
			
			this.connexion.commit();
			
			return parentezcoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParentezcoParameterReturnGeneral procesarImportacionParentezcosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParentezcoParameterReturnGeneral parentezcoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-procesarImportacionParentezcosWithConnection");connexion.begin();			
			
			ParentezcoParameterReturnGeneral parentezcoReturnGeneral=new ParentezcoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parentezcos=new ArrayList<Parentezco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parentezco=new Parentezco();
				
				
				if(conColumnasBase) {this.parentezco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parentezco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parentezco.setcodigo(arrColumnas[iColumn++]);
				this.parentezco.setnombre(arrColumnas[iColumn++]);
				
				this.parentezcos.add(this.parentezco);
			}
			
			this.saveParentezcos();
			
			this.connexion.commit();
			
			parentezcoReturnGeneral.setConRetornoEstaProcesado(true);
			parentezcoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parentezcoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParentezcosEliminados() throws Exception {				
		
		List<Parentezco> parentezcosAux= new ArrayList<Parentezco>();
		
		for(Parentezco parentezco:parentezcos) {
			if(!parentezco.getIsDeleted()) {
				parentezcosAux.add(parentezco);
			}
		}
		
		parentezcos=parentezcosAux;
	}
	
	public void quitarParentezcosNulos() throws Exception {				
		
		List<Parentezco> parentezcosAux= new ArrayList<Parentezco>();
		
		for(Parentezco parentezco : this.parentezcos) {
			if(parentezco==null) {
				parentezcosAux.add(parentezco);
			}
		}
		
		//this.parentezcos=parentezcosAux;
		
		this.parentezcos.removeAll(parentezcosAux);
	}
	
	public void getSetVersionRowParentezcoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parentezco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parentezco.getIsDeleted() || (parentezco.getIsChanged()&&!parentezco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parentezcoDataAccess.getSetVersionRowParentezco(connexion,parentezco.getId());
				
				if(!parentezco.getVersionRow().equals(timestamp)) {	
					parentezco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parentezco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParentezco()throws Exception {	
		
		if(parentezco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parentezco.getIsDeleted() || (parentezco.getIsChanged()&&!parentezco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parentezcoDataAccess.getSetVersionRowParentezco(connexion,parentezco.getId());
			
			try {							
				if(!parentezco.getVersionRow().equals(timestamp)) {	
					parentezco.setVersionRow(timestamp);
				}
				
				parentezco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParentezcosWithConnection()throws Exception {	
		if(parentezcos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Parentezco parentezcoAux:parentezcos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parentezcoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parentezcoAux.getIsDeleted() || (parentezcoAux.getIsChanged()&&!parentezcoAux.getIsNew())) {
						
						timestamp=parentezcoDataAccess.getSetVersionRowParentezco(connexion,parentezcoAux.getId());
						
						if(!parentezco.getVersionRow().equals(timestamp)) {	
							parentezcoAux.setVersionRow(timestamp);
						}
								
						parentezcoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParentezcos()throws Exception {	
		if(parentezcos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Parentezco parentezcoAux:parentezcos) {
					if(parentezcoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parentezcoAux.getIsDeleted() || (parentezcoAux.getIsChanged()&&!parentezcoAux.getIsNew())) {
						
						timestamp=parentezcoDataAccess.getSetVersionRowParentezco(connexion,parentezcoAux.getId());
						
						if(!parentezcoAux.getVersionRow().equals(timestamp)) {	
							parentezcoAux.setVersionRow(timestamp);
						}
						
													
						parentezcoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyParentezcoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ReferenciaLogic referenciaLogic=new ReferenciaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parentezco.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyParentezcoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Referencia.class));
											
			

			referenciaLogic.setConnexion(this.getConnexion());
			referenciaLogic.setDatosCliente(this.datosCliente);
			referenciaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Parentezco parentezco:this.parentezcos) {
				

				classes=new ArrayList<Classe>();
				classes=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciaLogic.setReferencias(parentezco.referencias);
				referenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Parentezco parentezco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParentezcoLogicAdditional.updateParentezcoToGet(parentezco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parentezco.setReferencias(parentezcoDataAccess.getReferencias(connexion,parentezco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parentezco.setReferencias(parentezcoDataAccess.getReferencias(connexion,parentezco));

				if(this.isConDeep) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(this.connexion);
					referenciaLogic.setReferencias(parentezco.getReferencias());
					ArrayList<Classe> classesLocal=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(referenciaLogic.getReferencias());
					parentezco.setReferencias(referenciaLogic.getReferencias());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Referencia.class));
			parentezco.setReferencias(parentezcoDataAccess.getReferencias(connexion,parentezco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		parentezco.setReferencias(parentezcoDataAccess.getReferencias(connexion,parentezco));

		for(Referencia referencia:parentezco.getReferencias()) {
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parentezco.setReferencias(parentezcoDataAccess.getReferencias(connexion,parentezco));

				for(Referencia referencia:parentezco.getReferencias()) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
					referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Referencia.class));
			parentezco.setReferencias(parentezcoDataAccess.getReferencias(connexion,parentezco));

			for(Referencia referencia:parentezco.getReferencias()) {
				ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
				referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Parentezco parentezco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParentezcoLogicAdditional.updateParentezcoToSave(parentezco,this.arrDatoGeneral);
			
ParentezcoDataAccess.save(parentezco, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Referencia referencia:parentezco.getReferencias()) {
			referencia.setid_parentezco(parentezco.getId());
			ReferenciaDataAccess.save(referencia,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Referencia referencia:parentezco.getReferencias()) {
					referencia.setid_parentezco(parentezco.getId());
					ReferenciaDataAccess.save(referencia,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Referencia referencia:parentezco.getReferencias()) {
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referencia.setid_parentezco(parentezco.getId());
			ReferenciaDataAccess.save(referencia,connexion);
			referenciaLogic.deepSave(referencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Referencia referencia:parentezco.getReferencias()) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
					referencia.setid_parentezco(parentezco.getId());
					ReferenciaDataAccess.save(referencia,connexion);
					referenciaLogic.deepSave(referencia,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Parentezco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parentezco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(parentezco);
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
			this.deepLoad(this.parentezco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(this.parentezco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Parentezco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parentezcos!=null) {
				for(Parentezco parentezco:parentezcos) {
					this.deepLoad(parentezco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(parentezcos);
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
			if(parentezcos!=null) {
				for(Parentezco parentezco:parentezcos) {
					this.deepLoad(parentezco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParentezcoConstantesFunciones.refrescarForeignKeysDescripcionesParentezco(parentezcos);
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
			this.getNewConnexionToDeep(Parentezco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parentezco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Parentezco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parentezcos!=null) {
				for(Parentezco parentezco:parentezcos) {
					this.deepSave(parentezco,isDeep,deepLoadType,clases);
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
			if(parentezcos!=null) {
				for(Parentezco parentezco:parentezcos) {
					this.deepSave(parentezco,isDeep,deepLoadType,clases);
				}		
			}
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
			if(ParentezcoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParentezcoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Parentezco parentezco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParentezcoConstantesFunciones.ISCONAUDITORIA) {
				if(parentezco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParentezcoDataAccess.TABLENAME, parentezco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParentezcoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParentezcoLogic.registrarAuditoriaDetallesParentezco(connexion,parentezco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parentezco.getIsDeleted()) {
					/*if(!parentezco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParentezcoDataAccess.TABLENAME, parentezco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParentezcoLogic.registrarAuditoriaDetallesParentezco(connexion,parentezco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParentezcoDataAccess.TABLENAME, parentezco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parentezco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParentezcoDataAccess.TABLENAME, parentezco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParentezcoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParentezcoLogic.registrarAuditoriaDetallesParentezco(connexion,parentezco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParentezco(Connexion connexion,Parentezco parentezco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parentezco.getIsNew()||!parentezco.getcodigo().equals(parentezco.getParentezcoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parentezco.getParentezcoOriginal().getcodigo()!=null)
				{
					strValorActual=parentezco.getParentezcoOriginal().getcodigo();
				}
				if(parentezco.getcodigo()!=null)
				{
					strValorNuevo=parentezco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParentezcoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(parentezco.getIsNew()||!parentezco.getnombre().equals(parentezco.getParentezcoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parentezco.getParentezcoOriginal().getnombre()!=null)
				{
					strValorActual=parentezco.getParentezcoOriginal().getnombre();
				}
				if(parentezco.getnombre()!=null)
				{
					strValorNuevo=parentezco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParentezcoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParentezcoRelacionesWithConnection(Parentezco parentezco,List<Referencia> referencias) throws Exception {

		if(!parentezco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParentezcoRelacionesBase(parentezco,referencias,true);
		}
	}

	public void saveParentezcoRelaciones(Parentezco parentezco,List<Referencia> referencias)throws Exception {

		if(!parentezco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParentezcoRelacionesBase(parentezco,referencias,false);
		}
	}

	public void saveParentezcoRelacionesBase(Parentezco parentezco,List<Referencia> referencias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Parentezco-saveRelacionesWithConnection");}
	
			parentezco.setReferencias(referencias);

			this.setParentezco(parentezco);

			if(ParentezcoLogicAdditional.validarSaveRelaciones(parentezco,this)) {

				ParentezcoLogicAdditional.updateRelacionesToSave(parentezco,this);

				if((parentezco.getIsNew()||parentezco.getIsChanged())&&!parentezco.getIsDeleted()) {
					this.saveParentezco();
					this.saveParentezcoRelacionesDetalles(referencias);

				} else if(parentezco.getIsDeleted()) {
					this.saveParentezcoRelacionesDetalles(referencias);
					this.saveParentezco();
				}

				ParentezcoLogicAdditional.updateRelacionesToSaveAfter(parentezco,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ReferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresReferencias(referencias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveParentezcoRelacionesDetalles(List<Referencia> referencias)throws Exception {
		try {
	

			Long idParentezcoActual=this.getParentezco().getId();

			ReferenciaLogic referenciaLogic_Desde_Parentezco=new ReferenciaLogic();
			referenciaLogic_Desde_Parentezco.setReferencias(referencias);

			referenciaLogic_Desde_Parentezco.setConnexion(this.getConnexion());
			referenciaLogic_Desde_Parentezco.setDatosCliente(this.datosCliente);

			for(Referencia referencia_Desde_Parentezco:referenciaLogic_Desde_Parentezco.getReferencias()) {
				referencia_Desde_Parentezco.setid_parentezco(idParentezcoActual);

				referenciaLogic_Desde_Parentezco.setReferencia(referencia_Desde_Parentezco);
				referenciaLogic_Desde_Parentezco.saveReferencia();

				Long idReferenciaActual=referencia_Desde_Parentezco.getId();

				TelefonoReferenciaLogic telefonoreferenciaLogic_Desde_Referencia=new TelefonoReferenciaLogic();

				if(referencia_Desde_Parentezco.getTelefonoReferencias()==null){
					referencia_Desde_Parentezco.setTelefonoReferencias(new ArrayList<TelefonoReferencia>());
				}

				telefonoreferenciaLogic_Desde_Referencia.setTelefonoReferencias(referencia_Desde_Parentezco.getTelefonoReferencias());

				telefonoreferenciaLogic_Desde_Referencia.setConnexion(this.getConnexion());
				telefonoreferenciaLogic_Desde_Referencia.setDatosCliente(this.datosCliente);

				for(TelefonoReferencia telefonoreferencia_Desde_Referencia:telefonoreferenciaLogic_Desde_Referencia.getTelefonoReferencias()) {
					telefonoreferencia_Desde_Referencia.setid_referencia(idReferenciaActual);
				}

				telefonoreferenciaLogic_Desde_Referencia.saveTelefonoReferencias();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParentezco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParentezcoConstantesFunciones.getClassesForeignKeysOfParentezco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParentezco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParentezcoConstantesFunciones.getClassesRelationshipsOfParentezco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
