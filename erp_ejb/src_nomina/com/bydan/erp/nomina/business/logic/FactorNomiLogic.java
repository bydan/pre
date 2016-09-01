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
import com.bydan.erp.nomina.util.FactorNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FactorNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FactorNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.FactorNomi;
import com.bydan.erp.nomina.business.logic.FactorNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FactorNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FactorNomiLogic.class);
	
	protected FactorNomiDataAccess factornomiDataAccess; 	
	protected FactorNomi factornomi;
	protected List<FactorNomi> factornomis;
	protected Object factornomiObject;	
	protected List<Object> factornomisObject;
	
	public static ClassValidator<FactorNomi> factornomiValidator = new ClassValidator<FactorNomi>(FactorNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FactorNomiLogicAdditional factornomiLogicAdditional=null;
	
	public FactorNomiLogicAdditional getFactorNomiLogicAdditional() {
		return this.factornomiLogicAdditional;
	}
	
	public void setFactorNomiLogicAdditional(FactorNomiLogicAdditional factornomiLogicAdditional) {
		try {
			this.factornomiLogicAdditional=factornomiLogicAdditional;
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
	
	
	
	
	public  FactorNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.factornomiDataAccess = new FactorNomiDataAccess();
			
			this.factornomis= new ArrayList<FactorNomi>();
			this.factornomi= new FactorNomi();
			
			this.factornomiObject=new Object();
			this.factornomisObject=new ArrayList<Object>();
				
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
			
			this.factornomiDataAccess.setConnexionType(this.connexionType);
			this.factornomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FactorNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.factornomiDataAccess = new FactorNomiDataAccess();
			this.factornomis= new ArrayList<FactorNomi>();
			this.factornomi= new FactorNomi();
			this.factornomiObject=new Object();
			this.factornomisObject=new ArrayList<Object>();
			
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
			
			this.factornomiDataAccess.setConnexionType(this.connexionType);
			this.factornomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FactorNomi getFactorNomi() throws Exception {	
		FactorNomiLogicAdditional.checkFactorNomiToGet(factornomi,this.datosCliente,this.arrDatoGeneral);
		FactorNomiLogicAdditional.updateFactorNomiToGet(factornomi,this.arrDatoGeneral);
		
		return factornomi;
	}
		
	public void setFactorNomi(FactorNomi newFactorNomi) {
		this.factornomi = newFactorNomi;
	}
	
	public FactorNomiDataAccess getFactorNomiDataAccess() {
		return factornomiDataAccess;
	}
	
	public void setFactorNomiDataAccess(FactorNomiDataAccess newfactornomiDataAccess) {
		this.factornomiDataAccess = newfactornomiDataAccess;
	}
	
	public List<FactorNomi> getFactorNomis() throws Exception {		
		this.quitarFactorNomisNulos();
		
		FactorNomiLogicAdditional.checkFactorNomiToGets(factornomis,this.datosCliente,this.arrDatoGeneral);
		
		for (FactorNomi factornomiLocal: factornomis ) {
			FactorNomiLogicAdditional.updateFactorNomiToGet(factornomiLocal,this.arrDatoGeneral);
		}
		
		return factornomis;
	}
	
	public void setFactorNomis(List<FactorNomi> newFactorNomis) {
		this.factornomis = newFactorNomis;
	}
	
	public Object getFactorNomiObject() {	
		this.factornomiObject=this.factornomiDataAccess.getEntityObject();
		return this.factornomiObject;
	}
		
	public void setFactorNomiObject(Object newFactorNomiObject) {
		this.factornomiObject = newFactorNomiObject;
	}
	
	public List<Object> getFactorNomisObject() {		
		this.factornomisObject=this.factornomiDataAccess.getEntitiesObject();
		return this.factornomisObject;
	}
		
	public void setFactorNomisObject(List<Object> newFactorNomisObject) {
		this.factornomisObject = newFactorNomisObject;
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
		
		if(this.factornomiDataAccess!=null) {
			this.factornomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			factornomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			factornomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		factornomi = new  FactorNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			factornomi=factornomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
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
		factornomi = new  FactorNomi();
		  		  
        try {
			
			factornomi=factornomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		factornomi = new  FactorNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			factornomi=factornomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
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
		factornomi = new  FactorNomi();
		  		  
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
		factornomi = new  FactorNomi();
		  		  
        try {
			
			factornomi=factornomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		factornomi = new  FactorNomi();
		  		  
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
		factornomi = new  FactorNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =factornomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		factornomi = new  FactorNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=factornomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		factornomi = new  FactorNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =factornomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		factornomi = new  FactorNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=factornomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		factornomi = new  FactorNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =factornomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		factornomi = new  FactorNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=factornomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		factornomis = new  ArrayList<FactorNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
		factornomis = new  ArrayList<FactorNomi>();
		  		  
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
		factornomis = new  ArrayList<FactorNomi>();
		  		  
        try {			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		factornomis = new  ArrayList<FactorNomi>();
		  		  
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
		factornomis = new  ArrayList<FactorNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
		factornomis = new  ArrayList<FactorNomi>();
		  		  
        try {
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
		factornomis = new  ArrayList<FactorNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
		factornomis = new  ArrayList<FactorNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		factornomi = new  FactorNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomi=factornomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
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
		factornomi = new  FactorNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomi=factornomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		factornomis = new  ArrayList<FactorNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
		factornomis = new  ArrayList<FactorNomi>();
		  		  
        try {
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFactorNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		factornomis = new  ArrayList<FactorNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getTodosFactorNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
	
	public  void  getTodosFactorNomis(String sFinalQuery,Pagination pagination)throws Exception {
		factornomis = new  ArrayList<FactorNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factornomis=factornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFactorNomi(factornomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFactorNomi(FactorNomi factornomi) throws Exception {
		Boolean estaValidado=false;
		
		if(factornomi.getIsNew() || factornomi.getIsChanged()) { 
			this.invalidValues = factornomiValidator.getInvalidValues(factornomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(factornomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFactorNomi(List<FactorNomi> FactorNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FactorNomi factornomiLocal:factornomis) {				
			estaValidadoObjeto=this.validarGuardarFactorNomi(factornomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFactorNomi(List<FactorNomi> FactorNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFactorNomi(factornomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFactorNomi(FactorNomi FactorNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFactorNomi(factornomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FactorNomi factornomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+factornomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FactorNomiConstantesFunciones.getFactorNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"factornomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FactorNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FactorNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFactorNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-saveFactorNomiWithConnection");connexion.begin();			
			
			FactorNomiLogicAdditional.checkFactorNomiToSave(this.factornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FactorNomiLogicAdditional.updateFactorNomiToSave(this.factornomi,this.arrDatoGeneral);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.factornomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFactorNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFactorNomi(this.factornomi)) {
				FactorNomiDataAccess.save(this.factornomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.factornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FactorNomiLogicAdditional.checkFactorNomiToSaveAfter(this.factornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFactorNomi();
			
			connexion.commit();			
			
			if(this.factornomi.getIsDeleted()) {
				this.factornomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFactorNomi()throws Exception {	
		try {	
			
			FactorNomiLogicAdditional.checkFactorNomiToSave(this.factornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FactorNomiLogicAdditional.updateFactorNomiToSave(this.factornomi,this.arrDatoGeneral);
			
			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.factornomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFactorNomi(this.factornomi)) {			
				FactorNomiDataAccess.save(this.factornomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.factornomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FactorNomiLogicAdditional.checkFactorNomiToSaveAfter(this.factornomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.factornomi.getIsDeleted()) {
				this.factornomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFactorNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-saveFactorNomisWithConnection");connexion.begin();			
			
			FactorNomiLogicAdditional.checkFactorNomiToSaves(factornomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFactorNomis();
			
			Boolean validadoTodosFactorNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FactorNomi factornomiLocal:factornomis) {		
				if(factornomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FactorNomiLogicAdditional.updateFactorNomiToSave(factornomiLocal,this.arrDatoGeneral);
	        	
				FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),factornomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFactorNomi(factornomiLocal)) {
					FactorNomiDataAccess.save(factornomiLocal, connexion);				
				} else {
					validadoTodosFactorNomi=false;
				}
			}
			
			if(!validadoTodosFactorNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FactorNomiLogicAdditional.checkFactorNomiToSavesAfter(factornomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFactorNomis();
			
			connexion.commit();		
			
			this.quitarFactorNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFactorNomis()throws Exception {				
		 try {	
			FactorNomiLogicAdditional.checkFactorNomiToSaves(factornomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFactorNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FactorNomi factornomiLocal:factornomis) {				
				if(factornomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FactorNomiLogicAdditional.updateFactorNomiToSave(factornomiLocal,this.arrDatoGeneral);
	        	
				FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),factornomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFactorNomi(factornomiLocal)) {				
					FactorNomiDataAccess.save(factornomiLocal, connexion);				
				} else {
					validadoTodosFactorNomi=false;
				}
			}
			
			if(!validadoTodosFactorNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FactorNomiLogicAdditional.checkFactorNomiToSavesAfter(factornomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFactorNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FactorNomiParameterReturnGeneral procesarAccionFactorNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FactorNomi> factornomis,FactorNomiParameterReturnGeneral factornomiParameterGeneral)throws Exception {
		 try {	
			FactorNomiParameterReturnGeneral factornomiReturnGeneral=new FactorNomiParameterReturnGeneral();
	
			FactorNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,factornomis,factornomiParameterGeneral,factornomiReturnGeneral);
			
			return factornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FactorNomiParameterReturnGeneral procesarAccionFactorNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FactorNomi> factornomis,FactorNomiParameterReturnGeneral factornomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-procesarAccionFactorNomisWithConnection");connexion.begin();			
			
			FactorNomiParameterReturnGeneral factornomiReturnGeneral=new FactorNomiParameterReturnGeneral();
	
			FactorNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,factornomis,factornomiParameterGeneral,factornomiReturnGeneral);
			
			this.connexion.commit();
			
			return factornomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FactorNomiParameterReturnGeneral procesarEventosFactorNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FactorNomi> factornomis,FactorNomi factornomi,FactorNomiParameterReturnGeneral factornomiParameterGeneral,Boolean isEsNuevoFactorNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			FactorNomiParameterReturnGeneral factornomiReturnGeneral=new FactorNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				factornomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FactorNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,factornomis,factornomi,factornomiParameterGeneral,factornomiReturnGeneral,isEsNuevoFactorNomi,clases);
			
			return factornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FactorNomiParameterReturnGeneral procesarEventosFactorNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FactorNomi> factornomis,FactorNomi factornomi,FactorNomiParameterReturnGeneral factornomiParameterGeneral,Boolean isEsNuevoFactorNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-procesarEventosFactorNomisWithConnection");connexion.begin();			
			
			FactorNomiParameterReturnGeneral factornomiReturnGeneral=new FactorNomiParameterReturnGeneral();
	
			factornomiReturnGeneral.setFactorNomi(factornomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				factornomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FactorNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,factornomis,factornomi,factornomiParameterGeneral,factornomiReturnGeneral,isEsNuevoFactorNomi,clases);
			
			this.connexion.commit();
			
			return factornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FactorNomiParameterReturnGeneral procesarImportacionFactorNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FactorNomiParameterReturnGeneral factornomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-procesarImportacionFactorNomisWithConnection");connexion.begin();			
			
			FactorNomiParameterReturnGeneral factornomiReturnGeneral=new FactorNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.factornomis=new ArrayList<FactorNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.factornomi=new FactorNomi();
				
				
				if(conColumnasBase) {this.factornomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.factornomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.factornomi.setnombre(arrColumnas[iColumn++]);
				
				this.factornomis.add(this.factornomi);
			}
			
			this.saveFactorNomis();
			
			this.connexion.commit();
			
			factornomiReturnGeneral.setConRetornoEstaProcesado(true);
			factornomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return factornomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFactorNomisEliminados() throws Exception {				
		
		List<FactorNomi> factornomisAux= new ArrayList<FactorNomi>();
		
		for(FactorNomi factornomi:factornomis) {
			if(!factornomi.getIsDeleted()) {
				factornomisAux.add(factornomi);
			}
		}
		
		factornomis=factornomisAux;
	}
	
	public void quitarFactorNomisNulos() throws Exception {				
		
		List<FactorNomi> factornomisAux= new ArrayList<FactorNomi>();
		
		for(FactorNomi factornomi : this.factornomis) {
			if(factornomi==null) {
				factornomisAux.add(factornomi);
			}
		}
		
		//this.factornomis=factornomisAux;
		
		this.factornomis.removeAll(factornomisAux);
	}
	
	public void getSetVersionRowFactorNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(factornomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((factornomi.getIsDeleted() || (factornomi.getIsChanged()&&!factornomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=factornomiDataAccess.getSetVersionRowFactorNomi(connexion,factornomi.getId());
				
				if(!factornomi.getVersionRow().equals(timestamp)) {	
					factornomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				factornomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFactorNomi()throws Exception {	
		
		if(factornomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((factornomi.getIsDeleted() || (factornomi.getIsChanged()&&!factornomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=factornomiDataAccess.getSetVersionRowFactorNomi(connexion,factornomi.getId());
			
			try {							
				if(!factornomi.getVersionRow().equals(timestamp)) {	
					factornomi.setVersionRow(timestamp);
				}
				
				factornomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFactorNomisWithConnection()throws Exception {	
		if(factornomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FactorNomi factornomiAux:factornomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(factornomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(factornomiAux.getIsDeleted() || (factornomiAux.getIsChanged()&&!factornomiAux.getIsNew())) {
						
						timestamp=factornomiDataAccess.getSetVersionRowFactorNomi(connexion,factornomiAux.getId());
						
						if(!factornomi.getVersionRow().equals(timestamp)) {	
							factornomiAux.setVersionRow(timestamp);
						}
								
						factornomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFactorNomis()throws Exception {	
		if(factornomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FactorNomi factornomiAux:factornomis) {
					if(factornomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(factornomiAux.getIsDeleted() || (factornomiAux.getIsChanged()&&!factornomiAux.getIsNew())) {
						
						timestamp=factornomiDataAccess.getSetVersionRowFactorNomi(connexion,factornomiAux.getId());
						
						if(!factornomiAux.getVersionRow().equals(timestamp)) {	
							factornomiAux.setVersionRow(timestamp);
						}
						
													
						factornomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FactorNomiParameterReturnGeneral cargarCombosLoteForeignKeyFactorNomiWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		FactorNomiParameterReturnGeneral  factornomiReturnGeneral =new FactorNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyFactorNomiWithConnection");connexion.begin();
			
			factornomiReturnGeneral =new FactorNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			factornomiReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return factornomiReturnGeneral;
	}
	
	public FactorNomiParameterReturnGeneral cargarCombosLoteForeignKeyFactorNomi(String finalQueryGlobalEmpresa) throws Exception {
		FactorNomiParameterReturnGeneral  factornomiReturnGeneral =new FactorNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			factornomiReturnGeneral =new FactorNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			factornomiReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return factornomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFactorNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic=new FormatoNomiFactorNomiLogic();
			PreguntaNomiLogic preguntanomiLogic=new PreguntaNomiLogic();
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic=new FormatoNomiPreguntaNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFactorNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormatoNomiFactorNomi.class));
			classes.add(new Classe(PreguntaNomi.class));
			classes.add(new Classe(FormatoNomiPreguntaNomi.class));
											
			

			formatonomifactornomiLogic.setConnexion(this.getConnexion());
			formatonomifactornomiLogic.setDatosCliente(this.datosCliente);
			formatonomifactornomiLogic.setIsConRefrescarForeignKeys(true);

			preguntanomiLogic.setConnexion(this.getConnexion());
			preguntanomiLogic.setDatosCliente(this.datosCliente);
			preguntanomiLogic.setIsConRefrescarForeignKeys(true);

			formatonomipreguntanomiLogic.setConnexion(this.getConnexion());
			formatonomipreguntanomiLogic.setDatosCliente(this.datosCliente);
			formatonomipreguntanomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FactorNomi factornomi:this.factornomis) {
				

				classes=new ArrayList<Classe>();
				classes=FormatoNomiFactorNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiFactorNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomifactornomiLogic.setFormatoNomiFactorNomis(factornomi.formatonomifactornomis);
				formatonomifactornomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PreguntaNomiConstantesFunciones.getClassesForeignKeysOfPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				preguntanomiLogic.setPreguntaNomis(factornomi.preguntanomis);
				preguntanomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomipreguntanomiLogic.setFormatoNomiPreguntaNomis(factornomi.formatonomipreguntanomis);
				formatonomipreguntanomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FactorNomi factornomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FactorNomiLogicAdditional.updateFactorNomiToGet(factornomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		factornomi.setEmpresa(factornomiDataAccess.getEmpresa(connexion,factornomi));
		factornomi.setFormatoNomiFactorNomis(factornomiDataAccess.getFormatoNomiFactorNomis(connexion,factornomi));
		factornomi.setPreguntaNomis(factornomiDataAccess.getPreguntaNomis(connexion,factornomi));
		factornomi.setFormatoNomiPreguntaNomis(factornomiDataAccess.getFormatoNomiPreguntaNomis(connexion,factornomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				factornomi.setEmpresa(factornomiDataAccess.getEmpresa(connexion,factornomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factornomi.setFormatoNomiFactorNomis(factornomiDataAccess.getFormatoNomiFactorNomis(connexion,factornomi));

				if(this.isConDeep) {
					FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(this.connexion);
					formatonomifactornomiLogic.setFormatoNomiFactorNomis(factornomi.getFormatoNomiFactorNomis());
					ArrayList<Classe> classesLocal=FormatoNomiFactorNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiFactorNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomifactornomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiFactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(formatonomifactornomiLogic.getFormatoNomiFactorNomis());
					factornomi.setFormatoNomiFactorNomis(formatonomifactornomiLogic.getFormatoNomiFactorNomis());
				}

				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factornomi.setPreguntaNomis(factornomiDataAccess.getPreguntaNomis(connexion,factornomi));

				if(this.isConDeep) {
					PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(this.connexion);
					preguntanomiLogic.setPreguntaNomis(factornomi.getPreguntaNomis());
					ArrayList<Classe> classesLocal=PreguntaNomiConstantesFunciones.getClassesForeignKeysOfPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					preguntanomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(preguntanomiLogic.getPreguntaNomis());
					factornomi.setPreguntaNomis(preguntanomiLogic.getPreguntaNomis());
				}

				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factornomi.setFormatoNomiPreguntaNomis(factornomiDataAccess.getFormatoNomiPreguntaNomis(connexion,factornomi));

				if(this.isConDeep) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(this.connexion);
					formatonomipreguntanomiLogic.setFormatoNomiPreguntaNomis(factornomi.getFormatoNomiPreguntaNomis());
					ArrayList<Classe> classesLocal=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomipreguntanomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis());
					factornomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis());
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
			factornomi.setEmpresa(factornomiDataAccess.getEmpresa(connexion,factornomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiFactorNomi.class));
			factornomi.setFormatoNomiFactorNomis(factornomiDataAccess.getFormatoNomiFactorNomis(connexion,factornomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PreguntaNomi.class));
			factornomi.setPreguntaNomis(factornomiDataAccess.getPreguntaNomis(connexion,factornomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiPreguntaNomi.class));
			factornomi.setFormatoNomiPreguntaNomis(factornomiDataAccess.getFormatoNomiPreguntaNomis(connexion,factornomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		factornomi.setEmpresa(factornomiDataAccess.getEmpresa(connexion,factornomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(factornomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		factornomi.setFormatoNomiFactorNomis(factornomiDataAccess.getFormatoNomiFactorNomis(connexion,factornomi));

		for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
			formatonomifactornomiLogic.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
		}

		factornomi.setPreguntaNomis(factornomiDataAccess.getPreguntaNomis(connexion,factornomi));

		for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
			PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
			preguntanomiLogic.deepLoad(preguntanomi,isDeep,deepLoadType,clases);
		}

		factornomi.setFormatoNomiPreguntaNomis(factornomiDataAccess.getFormatoNomiPreguntaNomis(connexion,factornomi));

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				factornomi.setEmpresa(factornomiDataAccess.getEmpresa(connexion,factornomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(factornomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factornomi.setFormatoNomiFactorNomis(factornomiDataAccess.getFormatoNomiFactorNomis(connexion,factornomi));

				for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
					FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
					formatonomifactornomiLogic.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factornomi.setPreguntaNomis(factornomiDataAccess.getPreguntaNomis(connexion,factornomi));

				for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
					PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
					preguntanomiLogic.deepLoad(preguntanomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factornomi.setFormatoNomiPreguntaNomis(factornomiDataAccess.getFormatoNomiPreguntaNomis(connexion,factornomi));

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
					formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
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
			factornomi.setEmpresa(factornomiDataAccess.getEmpresa(connexion,factornomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(factornomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiFactorNomi.class));
			factornomi.setFormatoNomiFactorNomis(factornomiDataAccess.getFormatoNomiFactorNomis(connexion,factornomi));

			for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
				FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
				formatonomifactornomiLogic.deepLoad(formatonomifactornomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PreguntaNomi.class));
			factornomi.setPreguntaNomis(factornomiDataAccess.getPreguntaNomis(connexion,factornomi));

			for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
				PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
				preguntanomiLogic.deepLoad(preguntanomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiPreguntaNomi.class));
			factornomi.setFormatoNomiPreguntaNomis(factornomiDataAccess.getFormatoNomiPreguntaNomis(connexion,factornomi));

			for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FactorNomi factornomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FactorNomiLogicAdditional.updateFactorNomiToSave(factornomi,this.arrDatoGeneral);
			
FactorNomiDataAccess.save(factornomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(factornomi.getEmpresa(),connexion);

		for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
			formatonomifactornomi.setid_factor_nomi(factornomi.getId());
			FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
		}

		for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
			preguntanomi.setid_factor_nomi(factornomi.getId());
			PreguntaNomiDataAccess.save(preguntanomi,connexion);
		}

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
			formatonomipreguntanomi.setid_factor_nomi(factornomi.getId());
			FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(factornomi.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
					formatonomifactornomi.setid_factor_nomi(factornomi.getId());
					FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
					preguntanomi.setid_factor_nomi(factornomi.getId());
					PreguntaNomiDataAccess.save(preguntanomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
					formatonomipreguntanomi.setid_factor_nomi(factornomi.getId());
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(factornomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(factornomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
			formatonomifactornomi.setid_factor_nomi(factornomi.getId());
			FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
			formatonomifactornomiLogic.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);
		}

		for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
			PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
			preguntanomi.setid_factor_nomi(factornomi.getId());
			PreguntaNomiDataAccess.save(preguntanomi,connexion);
			preguntanomiLogic.deepSave(preguntanomi,isDeep,deepLoadType,clases);
		}

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomi.setid_factor_nomi(factornomi.getId());
			FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
			formatonomipreguntanomiLogic.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(factornomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(factornomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormatoNomiFactorNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiFactorNomi formatonomifactornomi:factornomi.getFormatoNomiFactorNomis()) {
					FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
					formatonomifactornomi.setid_factor_nomi(factornomi.getId());
					FormatoNomiFactorNomiDataAccess.save(formatonomifactornomi,connexion);
					formatonomifactornomiLogic.deepSave(formatonomifactornomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PreguntaNomi preguntanomi:factornomi.getPreguntaNomis()) {
					PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
					preguntanomi.setid_factor_nomi(factornomi.getId());
					PreguntaNomiDataAccess.save(preguntanomi,connexion);
					preguntanomiLogic.deepSave(preguntanomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:factornomi.getFormatoNomiPreguntaNomis()) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
					formatonomipreguntanomi.setid_factor_nomi(factornomi.getId());
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
					formatonomipreguntanomiLogic.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FactorNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(factornomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(factornomi);
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
			this.deepLoad(this.factornomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FactorNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(factornomis!=null) {
				for(FactorNomi factornomi:factornomis) {
					this.deepLoad(factornomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(factornomis);
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
			if(factornomis!=null) {
				for(FactorNomi factornomi:factornomis) {
					this.deepLoad(factornomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(factornomis);
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
			this.getNewConnexionToDeep(FactorNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(factornomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FactorNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(factornomis!=null) {
				for(FactorNomi factornomi:factornomis) {
					this.deepSave(factornomi,isDeep,deepLoadType,clases);
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
			if(factornomis!=null) {
				for(FactorNomi factornomi:factornomis) {
					this.deepSave(factornomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFactorNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FactorNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FactorNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			factornomis=factornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFactorNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FactorNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FactorNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			factornomis=factornomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FactorNomiConstantesFunciones.refrescarForeignKeysDescripcionesFactorNomi(this.factornomis);
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
			if(FactorNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FactorNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FactorNomi factornomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FactorNomiConstantesFunciones.ISCONAUDITORIA) {
				if(factornomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FactorNomiDataAccess.TABLENAME, factornomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FactorNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FactorNomiLogic.registrarAuditoriaDetallesFactorNomi(connexion,factornomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(factornomi.getIsDeleted()) {
					/*if(!factornomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FactorNomiDataAccess.TABLENAME, factornomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FactorNomiLogic.registrarAuditoriaDetallesFactorNomi(connexion,factornomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FactorNomiDataAccess.TABLENAME, factornomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(factornomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FactorNomiDataAccess.TABLENAME, factornomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FactorNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FactorNomiLogic.registrarAuditoriaDetallesFactorNomi(connexion,factornomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFactorNomi(Connexion connexion,FactorNomi factornomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(factornomi.getIsNew()||!factornomi.getid_empresa().equals(factornomi.getFactorNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factornomi.getFactorNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=factornomi.getFactorNomiOriginal().getid_empresa().toString();
				}
				if(factornomi.getid_empresa()!=null)
				{
					strValorNuevo=factornomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FactorNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(factornomi.getIsNew()||!factornomi.getnombre().equals(factornomi.getFactorNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factornomi.getFactorNomiOriginal().getnombre()!=null)
				{
					strValorActual=factornomi.getFactorNomiOriginal().getnombre();
				}
				if(factornomi.getnombre()!=null)
				{
					strValorNuevo=factornomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FactorNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFactorNomiRelacionesWithConnection(FactorNomi factornomi,List<FormatoNomiFactorNomi> formatonomifactornomis,List<PreguntaNomi> preguntanomis,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis) throws Exception {

		if(!factornomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFactorNomiRelacionesBase(factornomi,formatonomifactornomis,preguntanomis,formatonomipreguntanomis,true);
		}
	}

	public void saveFactorNomiRelaciones(FactorNomi factornomi,List<FormatoNomiFactorNomi> formatonomifactornomis,List<PreguntaNomi> preguntanomis,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis)throws Exception {

		if(!factornomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFactorNomiRelacionesBase(factornomi,formatonomifactornomis,preguntanomis,formatonomipreguntanomis,false);
		}
	}

	public void saveFactorNomiRelacionesBase(FactorNomi factornomi,List<FormatoNomiFactorNomi> formatonomifactornomis,List<PreguntaNomi> preguntanomis,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FactorNomi-saveRelacionesWithConnection");}
	
			factornomi.setFormatoNomiFactorNomis(formatonomifactornomis);
			factornomi.setPreguntaNomis(preguntanomis);
			factornomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomis);

			this.setFactorNomi(factornomi);

			if(FactorNomiLogicAdditional.validarSaveRelaciones(factornomi,this)) {

				FactorNomiLogicAdditional.updateRelacionesToSave(factornomi,this);

				if((factornomi.getIsNew()||factornomi.getIsChanged())&&!factornomi.getIsDeleted()) {
					this.saveFactorNomi();
					this.saveFactorNomiRelacionesDetalles(formatonomifactornomis,preguntanomis,formatonomipreguntanomis);

				} else if(factornomi.getIsDeleted()) {
					this.saveFactorNomiRelacionesDetalles(formatonomifactornomis,preguntanomis,formatonomipreguntanomis);
					this.saveFactorNomi();
				}

				FactorNomiLogicAdditional.updateRelacionesToSaveAfter(factornomi,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormatoNomiFactorNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresFormatoNomiFactorNomis(formatonomifactornomis,true,true);
			PreguntaNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresPreguntaNomis(preguntanomis,true,true);
			FormatoNomiPreguntaNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresFormatoNomiPreguntaNomis(formatonomipreguntanomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFactorNomiRelacionesDetalles(List<FormatoNomiFactorNomi> formatonomifactornomis,List<PreguntaNomi> preguntanomis,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis)throws Exception {
		try {
	

			Long idFactorNomiActual=this.getFactorNomi().getId();

			FormatoNomiFactorNomiLogic formatonomifactornomiLogic_Desde_FactorNomi=new FormatoNomiFactorNomiLogic();
			formatonomifactornomiLogic_Desde_FactorNomi.setFormatoNomiFactorNomis(formatonomifactornomis);

			formatonomifactornomiLogic_Desde_FactorNomi.setConnexion(this.getConnexion());
			formatonomifactornomiLogic_Desde_FactorNomi.setDatosCliente(this.datosCliente);

			for(FormatoNomiFactorNomi formatonomifactornomi_Desde_FactorNomi:formatonomifactornomiLogic_Desde_FactorNomi.getFormatoNomiFactorNomis()) {
				formatonomifactornomi_Desde_FactorNomi.setid_factor_nomi(idFactorNomiActual);

				formatonomifactornomiLogic_Desde_FactorNomi.setFormatoNomiFactorNomi(formatonomifactornomi_Desde_FactorNomi);
				formatonomifactornomiLogic_Desde_FactorNomi.saveFormatoNomiFactorNomi();

				Long idFormatoNomiFactorNomiActual=formatonomifactornomi_Desde_FactorNomi.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiFactorNomi=new CalificacionEmpleadoLogic();

				if(formatonomifactornomi_Desde_FactorNomi.getCalificacionEmpleados()==null){
					formatonomifactornomi_Desde_FactorNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setCalificacionEmpleados(formatonomifactornomi_Desde_FactorNomi.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiFactorNomi:calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.getCalificacionEmpleados()) {
					calificacionempleado_Desde_FormatoNomiFactorNomi.setid_formato_nomi_factor_nomi(idFormatoNomiFactorNomiActual);
				}

				calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.saveCalificacionEmpleados();
			}


			PreguntaNomiLogic preguntanomiLogic_Desde_FactorNomi=new PreguntaNomiLogic();
			preguntanomiLogic_Desde_FactorNomi.setPreguntaNomis(preguntanomis);

			preguntanomiLogic_Desde_FactorNomi.setConnexion(this.getConnexion());
			preguntanomiLogic_Desde_FactorNomi.setDatosCliente(this.datosCliente);

			for(PreguntaNomi preguntanomi_Desde_FactorNomi:preguntanomiLogic_Desde_FactorNomi.getPreguntaNomis()) {
				preguntanomi_Desde_FactorNomi.setid_factor_nomi(idFactorNomiActual);

				preguntanomiLogic_Desde_FactorNomi.setPreguntaNomi(preguntanomi_Desde_FactorNomi);
				preguntanomiLogic_Desde_FactorNomi.savePreguntaNomi();

				Long idPreguntaNomiActual=preguntanomi_Desde_FactorNomi.getId();

				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic_Desde_PreguntaNomi=new FormatoNomiPreguntaNomiLogic();

				if(preguntanomi_Desde_FactorNomi.getFormatoNomiPreguntaNomis()==null){
					preguntanomi_Desde_FactorNomi.setFormatoNomiPreguntaNomis(new ArrayList<FormatoNomiPreguntaNomi>());
				}

				formatonomipreguntanomiLogic_Desde_PreguntaNomi.setFormatoNomiPreguntaNomis(preguntanomi_Desde_FactorNomi.getFormatoNomiPreguntaNomis());

				formatonomipreguntanomiLogic_Desde_PreguntaNomi.setConnexion(this.getConnexion());
				formatonomipreguntanomiLogic_Desde_PreguntaNomi.setDatosCliente(this.datosCliente);

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi_Desde_PreguntaNomi:formatonomipreguntanomiLogic_Desde_PreguntaNomi.getFormatoNomiPreguntaNomis()) {
					formatonomipreguntanomi_Desde_PreguntaNomi.setid_pregunta_nomi(idPreguntaNomiActual);

					formatonomipreguntanomiLogic_Desde_PreguntaNomi.setFormatoNomiPreguntaNomi(formatonomipreguntanomi_Desde_PreguntaNomi);
					formatonomipreguntanomiLogic_Desde_PreguntaNomi.saveFormatoNomiPreguntaNomi();

					Long idFormatoNomiPreguntaNomiActual=formatonomipreguntanomi_Desde_PreguntaNomi.getId();

					CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi=new CalificacionEmpleadoLogic();

					if(formatonomipreguntanomi_Desde_PreguntaNomi.getCalificacionEmpleados()==null){
						formatonomipreguntanomi_Desde_PreguntaNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
					}

					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setCalificacionEmpleados(formatonomipreguntanomi_Desde_PreguntaNomi.getCalificacionEmpleados());

					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setConnexion(this.getConnexion());
					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setDatosCliente(this.datosCliente);

					for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiPreguntaNomi:calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.getCalificacionEmpleados()) {
						calificacionempleado_Desde_FormatoNomiPreguntaNomi.setid_formato_nomi_pregunta_nomi(idFormatoNomiPreguntaNomiActual);
					}

					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.saveCalificacionEmpleados();
				}


				DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic_Desde_PreguntaNomi=new DetalleEvaluacionNomiLogic();

				if(preguntanomi_Desde_FactorNomi.getDetalleEvaluacionNomis()==null){
					preguntanomi_Desde_FactorNomi.setDetalleEvaluacionNomis(new ArrayList<DetalleEvaluacionNomi>());
				}

				detalleevaluacionnomiLogic_Desde_PreguntaNomi.setDetalleEvaluacionNomis(preguntanomi_Desde_FactorNomi.getDetalleEvaluacionNomis());

				detalleevaluacionnomiLogic_Desde_PreguntaNomi.setConnexion(this.getConnexion());
				detalleevaluacionnomiLogic_Desde_PreguntaNomi.setDatosCliente(this.datosCliente);

				for(DetalleEvaluacionNomi detalleevaluacionnomi_Desde_PreguntaNomi:detalleevaluacionnomiLogic_Desde_PreguntaNomi.getDetalleEvaluacionNomis()) {
					detalleevaluacionnomi_Desde_PreguntaNomi.setid_pregunta_nomi(idPreguntaNomiActual);
				}

				detalleevaluacionnomiLogic_Desde_PreguntaNomi.saveDetalleEvaluacionNomis();
			}


			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic_Desde_FactorNomi=new FormatoNomiPreguntaNomiLogic();
			formatonomipreguntanomiLogic_Desde_FactorNomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomis);

			formatonomipreguntanomiLogic_Desde_FactorNomi.setConnexion(this.getConnexion());
			formatonomipreguntanomiLogic_Desde_FactorNomi.setDatosCliente(this.datosCliente);

			for(FormatoNomiPreguntaNomi formatonomipreguntanomi_Desde_FactorNomi:formatonomipreguntanomiLogic_Desde_FactorNomi.getFormatoNomiPreguntaNomis()) {
				formatonomipreguntanomi_Desde_FactorNomi.setid_factor_nomi(idFactorNomiActual);

				formatonomipreguntanomiLogic_Desde_FactorNomi.setFormatoNomiPreguntaNomi(formatonomipreguntanomi_Desde_FactorNomi);
				formatonomipreguntanomiLogic_Desde_FactorNomi.saveFormatoNomiPreguntaNomi();

				Long idFormatoNomiPreguntaNomiActual=formatonomipreguntanomi_Desde_FactorNomi.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi=new CalificacionEmpleadoLogic();

				if(formatonomipreguntanomi_Desde_FactorNomi.getCalificacionEmpleados()==null){
					formatonomipreguntanomi_Desde_FactorNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setCalificacionEmpleados(formatonomipreguntanomi_Desde_FactorNomi.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiPreguntaNomi:calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.getCalificacionEmpleados()) {
					calificacionempleado_Desde_FormatoNomiPreguntaNomi.setid_formato_nomi_pregunta_nomi(idFormatoNomiPreguntaNomiActual);
				}

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.saveCalificacionEmpleados();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FactorNomiConstantesFunciones.getClassesForeignKeysOfFactorNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FactorNomiConstantesFunciones.getClassesRelationshipsOfFactorNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
