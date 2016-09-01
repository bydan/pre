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
import com.bydan.erp.nomina.util.VariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.VariableNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VariableNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.VariableNomi;
import com.bydan.erp.nomina.business.logic.VariableNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class VariableNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VariableNomiLogic.class);
	
	protected VariableNomiDataAccess variablenomiDataAccess; 	
	protected VariableNomi variablenomi;
	protected List<VariableNomi> variablenomis;
	protected Object variablenomiObject;	
	protected List<Object> variablenomisObject;
	
	public static ClassValidator<VariableNomi> variablenomiValidator = new ClassValidator<VariableNomi>(VariableNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VariableNomiLogicAdditional variablenomiLogicAdditional=null;
	
	public VariableNomiLogicAdditional getVariableNomiLogicAdditional() {
		return this.variablenomiLogicAdditional;
	}
	
	public void setVariableNomiLogicAdditional(VariableNomiLogicAdditional variablenomiLogicAdditional) {
		try {
			this.variablenomiLogicAdditional=variablenomiLogicAdditional;
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
	
	
	
	
	public  VariableNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.variablenomiDataAccess = new VariableNomiDataAccess();
			
			this.variablenomis= new ArrayList<VariableNomi>();
			this.variablenomi= new VariableNomi();
			
			this.variablenomiObject=new Object();
			this.variablenomisObject=new ArrayList<Object>();
				
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
			
			this.variablenomiDataAccess.setConnexionType(this.connexionType);
			this.variablenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VariableNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.variablenomiDataAccess = new VariableNomiDataAccess();
			this.variablenomis= new ArrayList<VariableNomi>();
			this.variablenomi= new VariableNomi();
			this.variablenomiObject=new Object();
			this.variablenomisObject=new ArrayList<Object>();
			
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
			
			this.variablenomiDataAccess.setConnexionType(this.connexionType);
			this.variablenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VariableNomi getVariableNomi() throws Exception {	
		VariableNomiLogicAdditional.checkVariableNomiToGet(variablenomi,this.datosCliente,this.arrDatoGeneral);
		VariableNomiLogicAdditional.updateVariableNomiToGet(variablenomi,this.arrDatoGeneral);
		
		return variablenomi;
	}
		
	public void setVariableNomi(VariableNomi newVariableNomi) {
		this.variablenomi = newVariableNomi;
	}
	
	public VariableNomiDataAccess getVariableNomiDataAccess() {
		return variablenomiDataAccess;
	}
	
	public void setVariableNomiDataAccess(VariableNomiDataAccess newvariablenomiDataAccess) {
		this.variablenomiDataAccess = newvariablenomiDataAccess;
	}
	
	public List<VariableNomi> getVariableNomis() throws Exception {		
		this.quitarVariableNomisNulos();
		
		VariableNomiLogicAdditional.checkVariableNomiToGets(variablenomis,this.datosCliente,this.arrDatoGeneral);
		
		for (VariableNomi variablenomiLocal: variablenomis ) {
			VariableNomiLogicAdditional.updateVariableNomiToGet(variablenomiLocal,this.arrDatoGeneral);
		}
		
		return variablenomis;
	}
	
	public void setVariableNomis(List<VariableNomi> newVariableNomis) {
		this.variablenomis = newVariableNomis;
	}
	
	public Object getVariableNomiObject() {	
		this.variablenomiObject=this.variablenomiDataAccess.getEntityObject();
		return this.variablenomiObject;
	}
		
	public void setVariableNomiObject(Object newVariableNomiObject) {
		this.variablenomiObject = newVariableNomiObject;
	}
	
	public List<Object> getVariableNomisObject() {		
		this.variablenomisObject=this.variablenomiDataAccess.getEntitiesObject();
		return this.variablenomisObject;
	}
		
	public void setVariableNomisObject(List<Object> newVariableNomisObject) {
		this.variablenomisObject = newVariableNomisObject;
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
		
		if(this.variablenomiDataAccess!=null) {
			this.variablenomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			variablenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			variablenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		variablenomi = new  VariableNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			variablenomi=variablenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.variablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
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
		variablenomi = new  VariableNomi();
		  		  
        try {
			
			variablenomi=variablenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.variablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		variablenomi = new  VariableNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			variablenomi=variablenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.variablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
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
		variablenomi = new  VariableNomi();
		  		  
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
		variablenomi = new  VariableNomi();
		  		  
        try {
			
			variablenomi=variablenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.variablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		variablenomi = new  VariableNomi();
		  		  
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
		variablenomi = new  VariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =variablenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		variablenomi = new  VariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=variablenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		variablenomi = new  VariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =variablenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		variablenomi = new  VariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=variablenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		variablenomi = new  VariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =variablenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		variablenomi = new  VariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=variablenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
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
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
        try {			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
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
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
        try {
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
		variablenomis = new  ArrayList<VariableNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
		variablenomis = new  ArrayList<VariableNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		variablenomi = new  VariableNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomi=variablenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
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
		variablenomi = new  VariableNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomi=variablenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
		variablenomis = new  ArrayList<VariableNomi>();
		  		  
        try {
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVariableNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		variablenomis = new  ArrayList<VariableNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getTodosVariableNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
	
	public  void  getTodosVariableNomis(String sFinalQuery,Pagination pagination)throws Exception {
		variablenomis = new  ArrayList<VariableNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVariableNomi(variablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVariableNomi(VariableNomi variablenomi) throws Exception {
		Boolean estaValidado=false;
		
		if(variablenomi.getIsNew() || variablenomi.getIsChanged()) { 
			this.invalidValues = variablenomiValidator.getInvalidValues(variablenomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(variablenomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVariableNomi(List<VariableNomi> VariableNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(VariableNomi variablenomiLocal:variablenomis) {				
			estaValidadoObjeto=this.validarGuardarVariableNomi(variablenomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVariableNomi(List<VariableNomi> VariableNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVariableNomi(variablenomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVariableNomi(VariableNomi VariableNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVariableNomi(variablenomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(VariableNomi variablenomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+variablenomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VariableNomiConstantesFunciones.getVariableNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"variablenomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VariableNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VariableNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVariableNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-saveVariableNomiWithConnection");connexion.begin();			
			
			VariableNomiLogicAdditional.checkVariableNomiToSave(this.variablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VariableNomiLogicAdditional.updateVariableNomiToSave(this.variablenomi,this.arrDatoGeneral);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.variablenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVariableNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVariableNomi(this.variablenomi)) {
				VariableNomiDataAccess.save(this.variablenomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.variablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VariableNomiLogicAdditional.checkVariableNomiToSaveAfter(this.variablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVariableNomi();
			
			connexion.commit();			
			
			if(this.variablenomi.getIsDeleted()) {
				this.variablenomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVariableNomi()throws Exception {	
		try {	
			
			VariableNomiLogicAdditional.checkVariableNomiToSave(this.variablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VariableNomiLogicAdditional.updateVariableNomiToSave(this.variablenomi,this.arrDatoGeneral);
			
			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.variablenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVariableNomi(this.variablenomi)) {			
				VariableNomiDataAccess.save(this.variablenomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.variablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VariableNomiLogicAdditional.checkVariableNomiToSaveAfter(this.variablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.variablenomi.getIsDeleted()) {
				this.variablenomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVariableNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-saveVariableNomisWithConnection");connexion.begin();			
			
			VariableNomiLogicAdditional.checkVariableNomiToSaves(variablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVariableNomis();
			
			Boolean validadoTodosVariableNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VariableNomi variablenomiLocal:variablenomis) {		
				if(variablenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VariableNomiLogicAdditional.updateVariableNomiToSave(variablenomiLocal,this.arrDatoGeneral);
	        	
				VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),variablenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVariableNomi(variablenomiLocal)) {
					VariableNomiDataAccess.save(variablenomiLocal, connexion);				
				} else {
					validadoTodosVariableNomi=false;
				}
			}
			
			if(!validadoTodosVariableNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VariableNomiLogicAdditional.checkVariableNomiToSavesAfter(variablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVariableNomis();
			
			connexion.commit();		
			
			this.quitarVariableNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVariableNomis()throws Exception {				
		 try {	
			VariableNomiLogicAdditional.checkVariableNomiToSaves(variablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVariableNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VariableNomi variablenomiLocal:variablenomis) {				
				if(variablenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VariableNomiLogicAdditional.updateVariableNomiToSave(variablenomiLocal,this.arrDatoGeneral);
	        	
				VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),variablenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVariableNomi(variablenomiLocal)) {				
					VariableNomiDataAccess.save(variablenomiLocal, connexion);				
				} else {
					validadoTodosVariableNomi=false;
				}
			}
			
			if(!validadoTodosVariableNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VariableNomiLogicAdditional.checkVariableNomiToSavesAfter(variablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVariableNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VariableNomiParameterReturnGeneral procesarAccionVariableNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VariableNomi> variablenomis,VariableNomiParameterReturnGeneral variablenomiParameterGeneral)throws Exception {
		 try {	
			VariableNomiParameterReturnGeneral variablenomiReturnGeneral=new VariableNomiParameterReturnGeneral();
	
			VariableNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,variablenomis,variablenomiParameterGeneral,variablenomiReturnGeneral);
			
			return variablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VariableNomiParameterReturnGeneral procesarAccionVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VariableNomi> variablenomis,VariableNomiParameterReturnGeneral variablenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-procesarAccionVariableNomisWithConnection");connexion.begin();			
			
			VariableNomiParameterReturnGeneral variablenomiReturnGeneral=new VariableNomiParameterReturnGeneral();
	
			VariableNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,variablenomis,variablenomiParameterGeneral,variablenomiReturnGeneral);
			
			this.connexion.commit();
			
			return variablenomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VariableNomiParameterReturnGeneral procesarEventosVariableNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VariableNomi> variablenomis,VariableNomi variablenomi,VariableNomiParameterReturnGeneral variablenomiParameterGeneral,Boolean isEsNuevoVariableNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			VariableNomiParameterReturnGeneral variablenomiReturnGeneral=new VariableNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				variablenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VariableNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,variablenomis,variablenomi,variablenomiParameterGeneral,variablenomiReturnGeneral,isEsNuevoVariableNomi,clases);
			
			return variablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VariableNomiParameterReturnGeneral procesarEventosVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VariableNomi> variablenomis,VariableNomi variablenomi,VariableNomiParameterReturnGeneral variablenomiParameterGeneral,Boolean isEsNuevoVariableNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-procesarEventosVariableNomisWithConnection");connexion.begin();			
			
			VariableNomiParameterReturnGeneral variablenomiReturnGeneral=new VariableNomiParameterReturnGeneral();
	
			variablenomiReturnGeneral.setVariableNomi(variablenomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				variablenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VariableNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,variablenomis,variablenomi,variablenomiParameterGeneral,variablenomiReturnGeneral,isEsNuevoVariableNomi,clases);
			
			this.connexion.commit();
			
			return variablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VariableNomiParameterReturnGeneral procesarImportacionVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VariableNomiParameterReturnGeneral variablenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-procesarImportacionVariableNomisWithConnection");connexion.begin();			
			
			VariableNomiParameterReturnGeneral variablenomiReturnGeneral=new VariableNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.variablenomis=new ArrayList<VariableNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.variablenomi=new VariableNomi();
				
				
				if(conColumnasBase) {this.variablenomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.variablenomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.variablenomi.setcodigo(arrColumnas[iColumn++]);
				this.variablenomi.setnombre(arrColumnas[iColumn++]);
				this.variablenomi.setsql1(arrColumnas[iColumn++]);
				this.variablenomi.setsql2(arrColumnas[iColumn++]);
				this.variablenomi.setsql3(arrColumnas[iColumn++]);
				this.variablenomi.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.variablenomis.add(this.variablenomi);
			}
			
			this.saveVariableNomis();
			
			this.connexion.commit();
			
			variablenomiReturnGeneral.setConRetornoEstaProcesado(true);
			variablenomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return variablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVariableNomisEliminados() throws Exception {				
		
		List<VariableNomi> variablenomisAux= new ArrayList<VariableNomi>();
		
		for(VariableNomi variablenomi:variablenomis) {
			if(!variablenomi.getIsDeleted()) {
				variablenomisAux.add(variablenomi);
			}
		}
		
		variablenomis=variablenomisAux;
	}
	
	public void quitarVariableNomisNulos() throws Exception {				
		
		List<VariableNomi> variablenomisAux= new ArrayList<VariableNomi>();
		
		for(VariableNomi variablenomi : this.variablenomis) {
			if(variablenomi==null) {
				variablenomisAux.add(variablenomi);
			}
		}
		
		//this.variablenomis=variablenomisAux;
		
		this.variablenomis.removeAll(variablenomisAux);
	}
	
	public void getSetVersionRowVariableNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(variablenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((variablenomi.getIsDeleted() || (variablenomi.getIsChanged()&&!variablenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=variablenomiDataAccess.getSetVersionRowVariableNomi(connexion,variablenomi.getId());
				
				if(!variablenomi.getVersionRow().equals(timestamp)) {	
					variablenomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				variablenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVariableNomi()throws Exception {	
		
		if(variablenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((variablenomi.getIsDeleted() || (variablenomi.getIsChanged()&&!variablenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=variablenomiDataAccess.getSetVersionRowVariableNomi(connexion,variablenomi.getId());
			
			try {							
				if(!variablenomi.getVersionRow().equals(timestamp)) {	
					variablenomi.setVersionRow(timestamp);
				}
				
				variablenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVariableNomisWithConnection()throws Exception {	
		if(variablenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(VariableNomi variablenomiAux:variablenomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(variablenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(variablenomiAux.getIsDeleted() || (variablenomiAux.getIsChanged()&&!variablenomiAux.getIsNew())) {
						
						timestamp=variablenomiDataAccess.getSetVersionRowVariableNomi(connexion,variablenomiAux.getId());
						
						if(!variablenomi.getVersionRow().equals(timestamp)) {	
							variablenomiAux.setVersionRow(timestamp);
						}
								
						variablenomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVariableNomis()throws Exception {	
		if(variablenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(VariableNomi variablenomiAux:variablenomis) {
					if(variablenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(variablenomiAux.getIsDeleted() || (variablenomiAux.getIsChanged()&&!variablenomiAux.getIsNew())) {
						
						timestamp=variablenomiDataAccess.getSetVersionRowVariableNomi(connexion,variablenomiAux.getId());
						
						if(!variablenomiAux.getVersionRow().equals(timestamp)) {	
							variablenomiAux.setVersionRow(timestamp);
						}
						
													
						variablenomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VariableNomiParameterReturnGeneral cargarCombosLoteForeignKeyVariableNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoVariableNomi,String finalQueryGlobalTipoValorVariableNomi) throws Exception {
		VariableNomiParameterReturnGeneral  variablenomiReturnGeneral =new VariableNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyVariableNomiWithConnection");connexion.begin();
			
			variablenomiReturnGeneral =new VariableNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			variablenomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			variablenomiReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoVariableNomi> tipovariablenomisForeignKey=new ArrayList<TipoVariableNomi>();
			TipoVariableNomiLogic tipovariablenomiLogic=new TipoVariableNomiLogic();
			tipovariablenomiLogic.setConnexion(this.connexion);
			tipovariablenomiLogic.getTipoVariableNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVariableNomi.equals("NONE")) {
				tipovariablenomiLogic.getTodosTipoVariableNomis(finalQueryGlobalTipoVariableNomi,new Pagination());
				tipovariablenomisForeignKey=tipovariablenomiLogic.getTipoVariableNomis();
			}

			variablenomiReturnGeneral.settipovariablenomisForeignKey(tipovariablenomisForeignKey);


			List<TipoValorVariableNomi> tipovalorvariablenomisForeignKey=new ArrayList<TipoValorVariableNomi>();
			TipoValorVariableNomiLogic tipovalorvariablenomiLogic=new TipoValorVariableNomiLogic();
			tipovalorvariablenomiLogic.setConnexion(this.connexion);
			tipovalorvariablenomiLogic.getTipoValorVariableNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValorVariableNomi.equals("NONE")) {
				tipovalorvariablenomiLogic.getTodosTipoValorVariableNomis(finalQueryGlobalTipoValorVariableNomi,new Pagination());
				tipovalorvariablenomisForeignKey=tipovalorvariablenomiLogic.getTipoValorVariableNomis();
			}

			variablenomiReturnGeneral.settipovalorvariablenomisForeignKey(tipovalorvariablenomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return variablenomiReturnGeneral;
	}
	
	public VariableNomiParameterReturnGeneral cargarCombosLoteForeignKeyVariableNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoVariableNomi,String finalQueryGlobalTipoValorVariableNomi) throws Exception {
		VariableNomiParameterReturnGeneral  variablenomiReturnGeneral =new VariableNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			variablenomiReturnGeneral =new VariableNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			variablenomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			variablenomiReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoVariableNomi> tipovariablenomisForeignKey=new ArrayList<TipoVariableNomi>();
			TipoVariableNomiLogic tipovariablenomiLogic=new TipoVariableNomiLogic();
			tipovariablenomiLogic.setConnexion(this.connexion);
			tipovariablenomiLogic.getTipoVariableNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVariableNomi.equals("NONE")) {
				tipovariablenomiLogic.getTodosTipoVariableNomis(finalQueryGlobalTipoVariableNomi,new Pagination());
				tipovariablenomisForeignKey=tipovariablenomiLogic.getTipoVariableNomis();
			}

			variablenomiReturnGeneral.settipovariablenomisForeignKey(tipovariablenomisForeignKey);


			List<TipoValorVariableNomi> tipovalorvariablenomisForeignKey=new ArrayList<TipoValorVariableNomi>();
			TipoValorVariableNomiLogic tipovalorvariablenomiLogic=new TipoValorVariableNomiLogic();
			tipovalorvariablenomiLogic.setConnexion(this.connexion);
			tipovalorvariablenomiLogic.getTipoValorVariableNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValorVariableNomi.equals("NONE")) {
				tipovalorvariablenomiLogic.getTodosTipoValorVariableNomis(finalQueryGlobalTipoValorVariableNomi,new Pagination());
				tipovalorvariablenomisForeignKey=tipovalorvariablenomiLogic.getTipoValorVariableNomis();
			}

			variablenomiReturnGeneral.settipovalorvariablenomisForeignKey(tipovalorvariablenomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return variablenomiReturnGeneral;
	}
	
	
	public void deepLoad(VariableNomi variablenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VariableNomiLogicAdditional.updateVariableNomiToGet(variablenomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		variablenomi.setEmpresa(variablenomiDataAccess.getEmpresa(connexion,variablenomi));
		variablenomi.setModulo(variablenomiDataAccess.getModulo(connexion,variablenomi));
		variablenomi.setTipoVariableNomi(variablenomiDataAccess.getTipoVariableNomi(connexion,variablenomi));
		variablenomi.setTipoValorVariableNomi(variablenomiDataAccess.getTipoValorVariableNomi(connexion,variablenomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				variablenomi.setEmpresa(variablenomiDataAccess.getEmpresa(connexion,variablenomi));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				variablenomi.setModulo(variablenomiDataAccess.getModulo(connexion,variablenomi));
				continue;
			}

			if(clas.clas.equals(TipoVariableNomi.class)) {
				variablenomi.setTipoVariableNomi(variablenomiDataAccess.getTipoVariableNomi(connexion,variablenomi));
				continue;
			}

			if(clas.clas.equals(TipoValorVariableNomi.class)) {
				variablenomi.setTipoValorVariableNomi(variablenomiDataAccess.getTipoValorVariableNomi(connexion,variablenomi));
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
			variablenomi.setEmpresa(variablenomiDataAccess.getEmpresa(connexion,variablenomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			variablenomi.setModulo(variablenomiDataAccess.getModulo(connexion,variablenomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVariableNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			variablenomi.setTipoVariableNomi(variablenomiDataAccess.getTipoVariableNomi(connexion,variablenomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValorVariableNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			variablenomi.setTipoValorVariableNomi(variablenomiDataAccess.getTipoValorVariableNomi(connexion,variablenomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		variablenomi.setEmpresa(variablenomiDataAccess.getEmpresa(connexion,variablenomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(variablenomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		variablenomi.setModulo(variablenomiDataAccess.getModulo(connexion,variablenomi));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(variablenomi.getModulo(),isDeep,deepLoadType,clases);
				
		variablenomi.setTipoVariableNomi(variablenomiDataAccess.getTipoVariableNomi(connexion,variablenomi));
		TipoVariableNomiLogic tipovariablenomiLogic= new TipoVariableNomiLogic(connexion);
		tipovariablenomiLogic.deepLoad(variablenomi.getTipoVariableNomi(),isDeep,deepLoadType,clases);
				
		variablenomi.setTipoValorVariableNomi(variablenomiDataAccess.getTipoValorVariableNomi(connexion,variablenomi));
		TipoValorVariableNomiLogic tipovalorvariablenomiLogic= new TipoValorVariableNomiLogic(connexion);
		tipovalorvariablenomiLogic.deepLoad(variablenomi.getTipoValorVariableNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				variablenomi.setEmpresa(variablenomiDataAccess.getEmpresa(connexion,variablenomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(variablenomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				variablenomi.setModulo(variablenomiDataAccess.getModulo(connexion,variablenomi));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(variablenomi.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVariableNomi.class)) {
				variablenomi.setTipoVariableNomi(variablenomiDataAccess.getTipoVariableNomi(connexion,variablenomi));
				TipoVariableNomiLogic tipovariablenomiLogic= new TipoVariableNomiLogic(connexion);
				tipovariablenomiLogic.deepLoad(variablenomi.getTipoVariableNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoValorVariableNomi.class)) {
				variablenomi.setTipoValorVariableNomi(variablenomiDataAccess.getTipoValorVariableNomi(connexion,variablenomi));
				TipoValorVariableNomiLogic tipovalorvariablenomiLogic= new TipoValorVariableNomiLogic(connexion);
				tipovalorvariablenomiLogic.deepLoad(variablenomi.getTipoValorVariableNomi(),isDeep,deepLoadType,clases);				
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
			variablenomi.setEmpresa(variablenomiDataAccess.getEmpresa(connexion,variablenomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(variablenomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			variablenomi.setModulo(variablenomiDataAccess.getModulo(connexion,variablenomi));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(variablenomi.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVariableNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			variablenomi.setTipoVariableNomi(variablenomiDataAccess.getTipoVariableNomi(connexion,variablenomi));
			TipoVariableNomiLogic tipovariablenomiLogic= new TipoVariableNomiLogic(connexion);
			tipovariablenomiLogic.deepLoad(variablenomi.getTipoVariableNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValorVariableNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			variablenomi.setTipoValorVariableNomi(variablenomiDataAccess.getTipoValorVariableNomi(connexion,variablenomi));
			TipoValorVariableNomiLogic tipovalorvariablenomiLogic= new TipoValorVariableNomiLogic(connexion);
			tipovalorvariablenomiLogic.deepLoad(variablenomi.getTipoValorVariableNomi(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(VariableNomi variablenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VariableNomiLogicAdditional.updateVariableNomiToSave(variablenomi,this.arrDatoGeneral);
			
VariableNomiDataAccess.save(variablenomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(variablenomi.getEmpresa(),connexion);

		ModuloDataAccess.save(variablenomi.getModulo(),connexion);

		TipoVariableNomiDataAccess.save(variablenomi.getTipoVariableNomi(),connexion);

		TipoValorVariableNomiDataAccess.save(variablenomi.getTipoValorVariableNomi(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(variablenomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(variablenomi.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoVariableNomi.class)) {
				TipoVariableNomiDataAccess.save(variablenomi.getTipoVariableNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoValorVariableNomi.class)) {
				TipoValorVariableNomiDataAccess.save(variablenomi.getTipoValorVariableNomi(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(variablenomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(variablenomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(variablenomi.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(variablenomi.getModulo(),isDeep,deepLoadType,clases);
				

		TipoVariableNomiDataAccess.save(variablenomi.getTipoVariableNomi(),connexion);
		TipoVariableNomiLogic tipovariablenomiLogic= new TipoVariableNomiLogic(connexion);
		tipovariablenomiLogic.deepLoad(variablenomi.getTipoVariableNomi(),isDeep,deepLoadType,clases);
				

		TipoValorVariableNomiDataAccess.save(variablenomi.getTipoValorVariableNomi(),connexion);
		TipoValorVariableNomiLogic tipovalorvariablenomiLogic= new TipoValorVariableNomiLogic(connexion);
		tipovalorvariablenomiLogic.deepLoad(variablenomi.getTipoValorVariableNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(variablenomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(variablenomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(variablenomi.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(variablenomi.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVariableNomi.class)) {
				TipoVariableNomiDataAccess.save(variablenomi.getTipoVariableNomi(),connexion);
				TipoVariableNomiLogic tipovariablenomiLogic= new TipoVariableNomiLogic(connexion);
				tipovariablenomiLogic.deepSave(variablenomi.getTipoVariableNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoValorVariableNomi.class)) {
				TipoValorVariableNomiDataAccess.save(variablenomi.getTipoValorVariableNomi(),connexion);
				TipoValorVariableNomiLogic tipovalorvariablenomiLogic= new TipoValorVariableNomiLogic(connexion);
				tipovalorvariablenomiLogic.deepSave(variablenomi.getTipoValorVariableNomi(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(VariableNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(variablenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(variablenomi);
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
			this.deepLoad(this.variablenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VariableNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(variablenomis!=null) {
				for(VariableNomi variablenomi:variablenomis) {
					this.deepLoad(variablenomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(variablenomis);
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
			if(variablenomis!=null) {
				for(VariableNomi variablenomi:variablenomis) {
					this.deepLoad(variablenomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(variablenomis);
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
			this.getNewConnexionToDeep(VariableNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(variablenomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(VariableNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(variablenomis!=null) {
				for(VariableNomi variablenomi:variablenomis) {
					this.deepSave(variablenomi,isDeep,deepLoadType,clases);
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
			if(variablenomis!=null) {
				for(VariableNomi variablenomi:variablenomis) {
					this.deepSave(variablenomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVariableNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VariableNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVariableNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VariableNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVariableNomisFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,VariableNomiConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVariableNomisFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,VariableNomiConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVariableNomisFK_IdTipoValorVariableNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_valor_variable_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValorVariableNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValorVariableNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valor_variable_nomi,VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValorVariableNomi);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValorVariableNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVariableNomisFK_IdTipoValorVariableNomi(String sFinalQuery,Pagination pagination,Long id_tipo_valor_variable_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValorVariableNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValorVariableNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valor_variable_nomi,VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValorVariableNomi);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValorVariableNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVariableNomisFK_IdTipoVariableNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_variable_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VariableNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVariableNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVariableNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_variable_nomi,VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVariableNomi);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoVariableNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVariableNomisFK_IdTipoVariableNomi(String sFinalQuery,Pagination pagination,Long id_tipo_variable_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVariableNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVariableNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_variable_nomi,VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVariableNomi);

			VariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoVariableNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(this.variablenomis);
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
			if(VariableNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VariableNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,VariableNomi variablenomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VariableNomiConstantesFunciones.ISCONAUDITORIA) {
				if(variablenomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VariableNomiDataAccess.TABLENAME, variablenomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VariableNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VariableNomiLogic.registrarAuditoriaDetallesVariableNomi(connexion,variablenomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(variablenomi.getIsDeleted()) {
					/*if(!variablenomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VariableNomiDataAccess.TABLENAME, variablenomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VariableNomiLogic.registrarAuditoriaDetallesVariableNomi(connexion,variablenomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VariableNomiDataAccess.TABLENAME, variablenomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(variablenomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VariableNomiDataAccess.TABLENAME, variablenomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VariableNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VariableNomiLogic.registrarAuditoriaDetallesVariableNomi(connexion,variablenomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVariableNomi(Connexion connexion,VariableNomi variablenomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(variablenomi.getIsNew()||!variablenomi.getid_empresa().equals(variablenomi.getVariableNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getid_empresa().toString();
				}
				if(variablenomi.getid_empresa()!=null)
				{
					strValorNuevo=variablenomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getid_modulo().equals(variablenomi.getVariableNomiOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getid_modulo()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getid_modulo().toString();
				}
				if(variablenomi.getid_modulo()!=null)
				{
					strValorNuevo=variablenomi.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getid_tipo_variable_nomi().equals(variablenomi.getVariableNomiOriginal().getid_tipo_variable_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getid_tipo_variable_nomi()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getid_tipo_variable_nomi().toString();
				}
				if(variablenomi.getid_tipo_variable_nomi()!=null)
				{
					strValorNuevo=variablenomi.getid_tipo_variable_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getid_tipo_valor_variable_nomi().equals(variablenomi.getVariableNomiOriginal().getid_tipo_valor_variable_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getid_tipo_valor_variable_nomi()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getid_tipo_valor_variable_nomi().toString();
				}
				if(variablenomi.getid_tipo_valor_variable_nomi()!=null)
				{
					strValorNuevo=variablenomi.getid_tipo_valor_variable_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getcodigo().equals(variablenomi.getVariableNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getcodigo()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getcodigo();
				}
				if(variablenomi.getcodigo()!=null)
				{
					strValorNuevo=variablenomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getnombre().equals(variablenomi.getVariableNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getnombre()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getnombre();
				}
				if(variablenomi.getnombre()!=null)
				{
					strValorNuevo=variablenomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getsql1().equals(variablenomi.getVariableNomiOriginal().getsql1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getsql1()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getsql1();
				}
				if(variablenomi.getsql1()!=null)
				{
					strValorNuevo=variablenomi.getsql1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.SQL1,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getsql2().equals(variablenomi.getVariableNomiOriginal().getsql2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getsql2()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getsql2();
				}
				if(variablenomi.getsql2()!=null)
				{
					strValorNuevo=variablenomi.getsql2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.SQL2,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getsql3().equals(variablenomi.getVariableNomiOriginal().getsql3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getsql3()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getsql3();
				}
				if(variablenomi.getsql3()!=null)
				{
					strValorNuevo=variablenomi.getsql3() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.SQL3,strValorActual,strValorNuevo);
			}	
			
			if(variablenomi.getIsNew()||!variablenomi.getvalor().equals(variablenomi.getVariableNomiOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(variablenomi.getVariableNomiOriginal().getvalor()!=null)
				{
					strValorActual=variablenomi.getVariableNomiOriginal().getvalor().toString();
				}
				if(variablenomi.getvalor()!=null)
				{
					strValorNuevo=variablenomi.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VariableNomiConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVariableNomiRelacionesWithConnection(VariableNomi variablenomi) throws Exception {

		if(!variablenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVariableNomiRelacionesBase(variablenomi,true);
		}
	}

	public void saveVariableNomiRelaciones(VariableNomi variablenomi)throws Exception {

		if(!variablenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVariableNomiRelacionesBase(variablenomi,false);
		}
	}

	public void saveVariableNomiRelacionesBase(VariableNomi variablenomi,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("VariableNomi-saveRelacionesWithConnection");}
	

			this.setVariableNomi(variablenomi);

			if(VariableNomiLogicAdditional.validarSaveRelaciones(variablenomi,this)) {

				VariableNomiLogicAdditional.updateRelacionesToSave(variablenomi,this);

				if((variablenomi.getIsNew()||variablenomi.getIsChanged())&&!variablenomi.getIsDeleted()) {
					this.saveVariableNomi();
					this.saveVariableNomiRelacionesDetalles();

				} else if(variablenomi.getIsDeleted()) {
					this.saveVariableNomiRelacionesDetalles();
					this.saveVariableNomi();
				}

				VariableNomiLogicAdditional.updateRelacionesToSaveAfter(variablenomi,this);

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
	
	
	private void saveVariableNomiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VariableNomiConstantesFunciones.getClassesForeignKeysOfVariableNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VariableNomiConstantesFunciones.getClassesRelationshipsOfVariableNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
