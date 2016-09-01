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
import com.bydan.erp.nomina.util.ConstanteNomiConstantesFunciones;
import com.bydan.erp.nomina.util.ConstanteNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ConstanteNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.ConstanteNomi;
//import com.bydan.erp.nomina.business.logic.ConstanteNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConstanteNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConstanteNomiLogic.class);
	
	protected ConstanteNomiDataAccess constantenomiDataAccess; 	
	protected ConstanteNomi constantenomi;
	protected List<ConstanteNomi> constantenomis;
	protected Object constantenomiObject;	
	protected List<Object> constantenomisObject;
	
	public static ClassValidator<ConstanteNomi> constantenomiValidator = new ClassValidator<ConstanteNomi>(ConstanteNomi.class);	
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
	
	
	
	
	public  ConstanteNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.constantenomiDataAccess = new ConstanteNomiDataAccess();
			
			this.constantenomis= new ArrayList<ConstanteNomi>();
			this.constantenomi= new ConstanteNomi();
			
			this.constantenomiObject=new Object();
			this.constantenomisObject=new ArrayList<Object>();
				
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
			
			this.constantenomiDataAccess.setConnexionType(this.connexionType);
			this.constantenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConstanteNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.constantenomiDataAccess = new ConstanteNomiDataAccess();
			this.constantenomis= new ArrayList<ConstanteNomi>();
			this.constantenomi= new ConstanteNomi();
			this.constantenomiObject=new Object();
			this.constantenomisObject=new ArrayList<Object>();
			
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
			
			this.constantenomiDataAccess.setConnexionType(this.connexionType);
			this.constantenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConstanteNomi getConstanteNomi() throws Exception {	
		//ConstanteNomiLogicAdditional.checkConstanteNomiToGet(constantenomi,this.datosCliente,this.arrDatoGeneral);
		//ConstanteNomiLogicAdditional.updateConstanteNomiToGet(constantenomi,this.arrDatoGeneral);
		
		return constantenomi;
	}
		
	public void setConstanteNomi(ConstanteNomi newConstanteNomi) {
		this.constantenomi = newConstanteNomi;
	}
	
	public ConstanteNomiDataAccess getConstanteNomiDataAccess() {
		return constantenomiDataAccess;
	}
	
	public void setConstanteNomiDataAccess(ConstanteNomiDataAccess newconstantenomiDataAccess) {
		this.constantenomiDataAccess = newconstantenomiDataAccess;
	}
	
	public List<ConstanteNomi> getConstanteNomis() throws Exception {		
		this.quitarConstanteNomisNulos();
		
		//ConstanteNomiLogicAdditional.checkConstanteNomiToGets(constantenomis,this.datosCliente,this.arrDatoGeneral);
		
		for (ConstanteNomi constantenomiLocal: constantenomis ) {
			//ConstanteNomiLogicAdditional.updateConstanteNomiToGet(constantenomiLocal,this.arrDatoGeneral);
		}
		
		return constantenomis;
	}
	
	public void setConstanteNomis(List<ConstanteNomi> newConstanteNomis) {
		this.constantenomis = newConstanteNomis;
	}
	
	public Object getConstanteNomiObject() {	
		this.constantenomiObject=this.constantenomiDataAccess.getEntityObject();
		return this.constantenomiObject;
	}
		
	public void setConstanteNomiObject(Object newConstanteNomiObject) {
		this.constantenomiObject = newConstanteNomiObject;
	}
	
	public List<Object> getConstanteNomisObject() {		
		this.constantenomisObject=this.constantenomiDataAccess.getEntitiesObject();
		return this.constantenomisObject;
	}
		
	public void setConstanteNomisObject(List<Object> newConstanteNomisObject) {
		this.constantenomisObject = newConstanteNomisObject;
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
		
		if(this.constantenomiDataAccess!=null) {
			this.constantenomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			constantenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			constantenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		constantenomi = new  ConstanteNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			constantenomi=constantenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.constantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
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
		constantenomi = new  ConstanteNomi();
		  		  
        try {
			
			constantenomi=constantenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.constantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		constantenomi = new  ConstanteNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			constantenomi=constantenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.constantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
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
		constantenomi = new  ConstanteNomi();
		  		  
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
		constantenomi = new  ConstanteNomi();
		  		  
        try {
			
			constantenomi=constantenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.constantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		constantenomi = new  ConstanteNomi();
		  		  
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
		constantenomi = new  ConstanteNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =constantenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		constantenomi = new  ConstanteNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=constantenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		constantenomi = new  ConstanteNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =constantenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		constantenomi = new  ConstanteNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=constantenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		constantenomi = new  ConstanteNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =constantenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		constantenomi = new  ConstanteNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=constantenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		constantenomis = new  ArrayList<ConstanteNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
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
		constantenomis = new  ArrayList<ConstanteNomi>();
		  		  
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
		constantenomis = new  ArrayList<ConstanteNomi>();
		  		  
        try {			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		constantenomis = new  ArrayList<ConstanteNomi>();
		  		  
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
		constantenomis = new  ArrayList<ConstanteNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
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
		constantenomis = new  ArrayList<ConstanteNomi>();
		  		  
        try {
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
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
		constantenomis = new  ArrayList<ConstanteNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
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
		constantenomis = new  ArrayList<ConstanteNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		constantenomi = new  ConstanteNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomi=constantenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
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
		constantenomi = new  ConstanteNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomi=constantenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConstanteNomi(constantenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosConstanteNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		constantenomis = new  ArrayList<ConstanteNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getTodosConstanteNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
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
	
	public  void  getTodosConstanteNomis(String sFinalQuery,Pagination pagination)throws Exception {
		constantenomis = new  ArrayList<ConstanteNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			constantenomis=constantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConstanteNomi(constantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConstanteNomi(ConstanteNomi constantenomi) throws Exception {
		Boolean estaValidado=false;
		
		if(constantenomi.getIsNew() || constantenomi.getIsChanged()) { 
			this.invalidValues = constantenomiValidator.getInvalidValues(constantenomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(constantenomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConstanteNomi(List<ConstanteNomi> ConstanteNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ConstanteNomi constantenomiLocal:constantenomis) {				
			estaValidadoObjeto=this.validarGuardarConstanteNomi(constantenomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConstanteNomi(List<ConstanteNomi> ConstanteNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConstanteNomi(constantenomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConstanteNomi(ConstanteNomi ConstanteNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConstanteNomi(constantenomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ConstanteNomi constantenomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+constantenomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConstanteNomiConstantesFunciones.getConstanteNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"constantenomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConstanteNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConstanteNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConstanteNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-saveConstanteNomiWithConnection");connexion.begin();			
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSave(this.constantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//ConstanteNomiLogicAdditional.updateConstanteNomiToSave(this.constantenomi,this.arrDatoGeneral);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.constantenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConstanteNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConstanteNomi(this.constantenomi)) {
				ConstanteNomiDataAccess.save(this.constantenomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.constantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSaveAfter(this.constantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConstanteNomi();
			
			connexion.commit();			
			
			if(this.constantenomi.getIsDeleted()) {
				this.constantenomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConstanteNomi()throws Exception {	
		try {	
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSave(this.constantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//ConstanteNomiLogicAdditional.updateConstanteNomiToSave(this.constantenomi,this.arrDatoGeneral);
			
			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.constantenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConstanteNomi(this.constantenomi)) {			
				ConstanteNomiDataAccess.save(this.constantenomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.constantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSaveAfter(this.constantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.constantenomi.getIsDeleted()) {
				this.constantenomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConstanteNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-saveConstanteNomisWithConnection");connexion.begin();			
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSaves(constantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConstanteNomis();
			
			Boolean validadoTodosConstanteNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConstanteNomi constantenomiLocal:constantenomis) {		
				if(constantenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//ConstanteNomiLogicAdditional.updateConstanteNomiToSave(constantenomiLocal,this.arrDatoGeneral);
	        	
				ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),constantenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConstanteNomi(constantenomiLocal)) {
					ConstanteNomiDataAccess.save(constantenomiLocal, connexion);				
				} else {
					validadoTodosConstanteNomi=false;
				}
			}
			
			if(!validadoTodosConstanteNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSavesAfter(constantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConstanteNomis();
			
			connexion.commit();		
			
			this.quitarConstanteNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConstanteNomis()throws Exception {				
		 try {	
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSaves(constantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConstanteNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConstanteNomi constantenomiLocal:constantenomis) {				
				if(constantenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//ConstanteNomiLogicAdditional.updateConstanteNomiToSave(constantenomiLocal,this.arrDatoGeneral);
	        	
				ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),constantenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConstanteNomi(constantenomiLocal)) {				
					ConstanteNomiDataAccess.save(constantenomiLocal, connexion);				
				} else {
					validadoTodosConstanteNomi=false;
				}
			}
			
			if(!validadoTodosConstanteNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//ConstanteNomiLogicAdditional.checkConstanteNomiToSavesAfter(constantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConstanteNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConstanteNomiParameterReturnGeneral procesarAccionConstanteNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConstanteNomi> constantenomis,ConstanteNomiParameterReturnGeneral constantenomiParameterGeneral)throws Exception {
		 try {	
			ConstanteNomiParameterReturnGeneral constantenomiReturnGeneral=new ConstanteNomiParameterReturnGeneral();
	
			
			return constantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConstanteNomiParameterReturnGeneral procesarAccionConstanteNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConstanteNomi> constantenomis,ConstanteNomiParameterReturnGeneral constantenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-procesarAccionConstanteNomisWithConnection");connexion.begin();			
			
			ConstanteNomiParameterReturnGeneral constantenomiReturnGeneral=new ConstanteNomiParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return constantenomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConstanteNomiParameterReturnGeneral procesarEventosConstanteNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConstanteNomi> constantenomis,ConstanteNomi constantenomi,ConstanteNomiParameterReturnGeneral constantenomiParameterGeneral,Boolean isEsNuevoConstanteNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConstanteNomiParameterReturnGeneral constantenomiReturnGeneral=new ConstanteNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				constantenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return constantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConstanteNomiParameterReturnGeneral procesarEventosConstanteNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConstanteNomi> constantenomis,ConstanteNomi constantenomi,ConstanteNomiParameterReturnGeneral constantenomiParameterGeneral,Boolean isEsNuevoConstanteNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-procesarEventosConstanteNomisWithConnection");connexion.begin();			
			
			ConstanteNomiParameterReturnGeneral constantenomiReturnGeneral=new ConstanteNomiParameterReturnGeneral();
	
			constantenomiReturnGeneral.setConstanteNomi(constantenomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				constantenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return constantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConstanteNomiParameterReturnGeneral procesarImportacionConstanteNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConstanteNomiParameterReturnGeneral constantenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-procesarImportacionConstanteNomisWithConnection");connexion.begin();			
			
			ConstanteNomiParameterReturnGeneral constantenomiReturnGeneral=new ConstanteNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.constantenomis=new ArrayList<ConstanteNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.constantenomi=new ConstanteNomi();
				
				
				if(conColumnasBase) {this.constantenomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.constantenomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.constantenomi.setnombre(arrColumnas[iColumn++]);
				this.constantenomi.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.constantenomi.setes_para_pregunta(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.constantenomis.add(this.constantenomi);
			}
			
			this.saveConstanteNomis();
			
			this.connexion.commit();
			
			constantenomiReturnGeneral.setConRetornoEstaProcesado(true);
			constantenomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return constantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConstanteNomisEliminados() throws Exception {				
		
		List<ConstanteNomi> constantenomisAux= new ArrayList<ConstanteNomi>();
		
		for(ConstanteNomi constantenomi:constantenomis) {
			if(!constantenomi.getIsDeleted()) {
				constantenomisAux.add(constantenomi);
			}
		}
		
		constantenomis=constantenomisAux;
	}
	
	public void quitarConstanteNomisNulos() throws Exception {				
		
		List<ConstanteNomi> constantenomisAux= new ArrayList<ConstanteNomi>();
		
		for(ConstanteNomi constantenomi : this.constantenomis) {
			if(constantenomi==null) {
				constantenomisAux.add(constantenomi);
			}
		}
		
		//this.constantenomis=constantenomisAux;
		
		this.constantenomis.removeAll(constantenomisAux);
	}
	
	public void getSetVersionRowConstanteNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(constantenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((constantenomi.getIsDeleted() || (constantenomi.getIsChanged()&&!constantenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=constantenomiDataAccess.getSetVersionRowConstanteNomi(connexion,constantenomi.getId());
				
				if(!constantenomi.getVersionRow().equals(timestamp)) {	
					constantenomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				constantenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConstanteNomi()throws Exception {	
		
		if(constantenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((constantenomi.getIsDeleted() || (constantenomi.getIsChanged()&&!constantenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=constantenomiDataAccess.getSetVersionRowConstanteNomi(connexion,constantenomi.getId());
			
			try {							
				if(!constantenomi.getVersionRow().equals(timestamp)) {	
					constantenomi.setVersionRow(timestamp);
				}
				
				constantenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConstanteNomisWithConnection()throws Exception {	
		if(constantenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ConstanteNomi constantenomiAux:constantenomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(constantenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(constantenomiAux.getIsDeleted() || (constantenomiAux.getIsChanged()&&!constantenomiAux.getIsNew())) {
						
						timestamp=constantenomiDataAccess.getSetVersionRowConstanteNomi(connexion,constantenomiAux.getId());
						
						if(!constantenomi.getVersionRow().equals(timestamp)) {	
							constantenomiAux.setVersionRow(timestamp);
						}
								
						constantenomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConstanteNomis()throws Exception {	
		if(constantenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ConstanteNomi constantenomiAux:constantenomis) {
					if(constantenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(constantenomiAux.getIsDeleted() || (constantenomiAux.getIsChanged()&&!constantenomiAux.getIsNew())) {
						
						timestamp=constantenomiDataAccess.getSetVersionRowConstanteNomi(connexion,constantenomiAux.getId());
						
						if(!constantenomiAux.getVersionRow().equals(timestamp)) {	
							constantenomiAux.setVersionRow(timestamp);
						}
						
													
						constantenomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConstanteNomiParameterReturnGeneral cargarCombosLoteForeignKeyConstanteNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoConstanteNomi) throws Exception {
		ConstanteNomiParameterReturnGeneral  constantenomiReturnGeneral =new ConstanteNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyConstanteNomiWithConnection");connexion.begin();
			
			constantenomiReturnGeneral =new ConstanteNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			constantenomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoConstanteNomi> tipoconstantenomisForeignKey=new ArrayList<TipoConstanteNomi>();
			TipoConstanteNomiLogic tipoconstantenomiLogic=new TipoConstanteNomiLogic();
			tipoconstantenomiLogic.setConnexion(this.connexion);
			tipoconstantenomiLogic.getTipoConstanteNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoConstanteNomi.equals("NONE")) {
				tipoconstantenomiLogic.getTodosTipoConstanteNomis(finalQueryGlobalTipoConstanteNomi,new Pagination());
				tipoconstantenomisForeignKey=tipoconstantenomiLogic.getTipoConstanteNomis();
			}

			constantenomiReturnGeneral.settipoconstantenomisForeignKey(tipoconstantenomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return constantenomiReturnGeneral;
	}
	
	public ConstanteNomiParameterReturnGeneral cargarCombosLoteForeignKeyConstanteNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoConstanteNomi) throws Exception {
		ConstanteNomiParameterReturnGeneral  constantenomiReturnGeneral =new ConstanteNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			constantenomiReturnGeneral =new ConstanteNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			constantenomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoConstanteNomi> tipoconstantenomisForeignKey=new ArrayList<TipoConstanteNomi>();
			TipoConstanteNomiLogic tipoconstantenomiLogic=new TipoConstanteNomiLogic();
			tipoconstantenomiLogic.setConnexion(this.connexion);
			tipoconstantenomiLogic.getTipoConstanteNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoConstanteNomi.equals("NONE")) {
				tipoconstantenomiLogic.getTodosTipoConstanteNomis(finalQueryGlobalTipoConstanteNomi,new Pagination());
				tipoconstantenomisForeignKey=tipoconstantenomiLogic.getTipoConstanteNomis();
			}

			constantenomiReturnGeneral.settipoconstantenomisForeignKey(tipoconstantenomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return constantenomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyConstanteNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoConstanteLogic empleadoconstanteLogic=new EmpleadoConstanteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyConstanteNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EmpleadoConstante.class));
											
			

			empleadoconstanteLogic.setConnexion(this.getConnexion());
			empleadoconstanteLogic.setDatosCliente(this.datosCliente);
			empleadoconstanteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ConstanteNomi constantenomi:this.constantenomis) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstanteConstantesFunciones.getClassesForeignKeysOfEmpleadoConstante(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoconstanteLogic.setEmpleadoConstantes(constantenomi.empleadoconstantes);
				empleadoconstanteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ConstanteNomi constantenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//ConstanteNomiLogicAdditional.updateConstanteNomiToGet(constantenomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		constantenomi.setEmpresa(constantenomiDataAccess.getEmpresa(connexion,constantenomi));
		constantenomi.setTipoConstanteNomi(constantenomiDataAccess.getTipoConstanteNomi(connexion,constantenomi));
		constantenomi.setEmpleadoConstantes(constantenomiDataAccess.getEmpleadoConstantes(connexion,constantenomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				constantenomi.setEmpresa(constantenomiDataAccess.getEmpresa(connexion,constantenomi));
				continue;
			}

			if(clas.clas.equals(TipoConstanteNomi.class)) {
				constantenomi.setTipoConstanteNomi(constantenomiDataAccess.getTipoConstanteNomi(connexion,constantenomi));
				continue;
			}

			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				constantenomi.setEmpleadoConstantes(constantenomiDataAccess.getEmpleadoConstantes(connexion,constantenomi));

				if(this.isConDeep) {
					EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(this.connexion);
					empleadoconstanteLogic.setEmpleadoConstantes(constantenomi.getEmpleadoConstantes());
					ArrayList<Classe> classesLocal=EmpleadoConstanteConstantesFunciones.getClassesForeignKeysOfEmpleadoConstante(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoconstanteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(empleadoconstanteLogic.getEmpleadoConstantes());
					constantenomi.setEmpleadoConstantes(empleadoconstanteLogic.getEmpleadoConstantes());
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
			constantenomi.setEmpresa(constantenomiDataAccess.getEmpresa(connexion,constantenomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConstanteNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			constantenomi.setTipoConstanteNomi(constantenomiDataAccess.getTipoConstanteNomi(connexion,constantenomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoConstante.class));
			constantenomi.setEmpleadoConstantes(constantenomiDataAccess.getEmpleadoConstantes(connexion,constantenomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		constantenomi.setEmpresa(constantenomiDataAccess.getEmpresa(connexion,constantenomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(constantenomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		constantenomi.setTipoConstanteNomi(constantenomiDataAccess.getTipoConstanteNomi(connexion,constantenomi));
		TipoConstanteNomiLogic tipoconstantenomiLogic= new TipoConstanteNomiLogic(connexion);
		tipoconstantenomiLogic.deepLoad(constantenomi.getTipoConstanteNomi(),isDeep,deepLoadType,clases);
				

		constantenomi.setEmpleadoConstantes(constantenomiDataAccess.getEmpleadoConstantes(connexion,constantenomi));

		for(EmpleadoConstante empleadoconstante:constantenomi.getEmpleadoConstantes()) {
			EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
			empleadoconstanteLogic.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				constantenomi.setEmpresa(constantenomiDataAccess.getEmpresa(connexion,constantenomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(constantenomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoConstanteNomi.class)) {
				constantenomi.setTipoConstanteNomi(constantenomiDataAccess.getTipoConstanteNomi(connexion,constantenomi));
				TipoConstanteNomiLogic tipoconstantenomiLogic= new TipoConstanteNomiLogic(connexion);
				tipoconstantenomiLogic.deepLoad(constantenomi.getTipoConstanteNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				constantenomi.setEmpleadoConstantes(constantenomiDataAccess.getEmpleadoConstantes(connexion,constantenomi));

				for(EmpleadoConstante empleadoconstante:constantenomi.getEmpleadoConstantes()) {
					EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
					empleadoconstanteLogic.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
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
			constantenomi.setEmpresa(constantenomiDataAccess.getEmpresa(connexion,constantenomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(constantenomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConstanteNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			constantenomi.setTipoConstanteNomi(constantenomiDataAccess.getTipoConstanteNomi(connexion,constantenomi));
			TipoConstanteNomiLogic tipoconstantenomiLogic= new TipoConstanteNomiLogic(connexion);
			tipoconstantenomiLogic.deepLoad(constantenomi.getTipoConstanteNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoConstante.class));
			constantenomi.setEmpleadoConstantes(constantenomiDataAccess.getEmpleadoConstantes(connexion,constantenomi));

			for(EmpleadoConstante empleadoconstante:constantenomi.getEmpleadoConstantes()) {
				EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
				empleadoconstanteLogic.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ConstanteNomi constantenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ConstanteNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(constantenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(constantenomi);
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
			this.deepLoad(this.constantenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ConstanteNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(constantenomis!=null) {
				for(ConstanteNomi constantenomi:constantenomis) {
					this.deepLoad(constantenomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(constantenomis);
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
			if(constantenomis!=null) {
				for(ConstanteNomi constantenomi:constantenomis) {
					this.deepLoad(constantenomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(constantenomis);
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
	
	
	public void getConstanteNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConstanteNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			constantenomis=constantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConstanteNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConstanteNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			constantenomis=constantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConstanteNomisFK_IdTipoConstanteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_constante_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConstanteNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoConstanteNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoConstanteNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_constante_nomi,ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoConstanteNomi);

			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoConstante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			constantenomis=constantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConstanteNomisFK_IdTipoConstante(String sFinalQuery,Pagination pagination,Long id_tipo_constante_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoConstanteNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoConstanteNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_constante_nomi,ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoConstanteNomi);

			ConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoConstante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			constantenomis=constantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(this.constantenomis);
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
			if(ConstanteNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConstanteNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ConstanteNomi constantenomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConstanteNomiConstantesFunciones.ISCONAUDITORIA) {
				if(constantenomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConstanteNomiDataAccess.TABLENAME, constantenomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConstanteNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConstanteNomiLogic.registrarAuditoriaDetallesConstanteNomi(connexion,constantenomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(constantenomi.getIsDeleted()) {
					/*if(!constantenomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConstanteNomiDataAccess.TABLENAME, constantenomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConstanteNomiLogic.registrarAuditoriaDetallesConstanteNomi(connexion,constantenomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConstanteNomiDataAccess.TABLENAME, constantenomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(constantenomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConstanteNomiDataAccess.TABLENAME, constantenomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConstanteNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConstanteNomiLogic.registrarAuditoriaDetallesConstanteNomi(connexion,constantenomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConstanteNomi(Connexion connexion,ConstanteNomi constantenomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(constantenomi.getIsNew()||!constantenomi.getid_empresa().equals(constantenomi.getConstanteNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(constantenomi.getConstanteNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=constantenomi.getConstanteNomiOriginal().getid_empresa().toString();
				}
				if(constantenomi.getid_empresa()!=null)
				{
					strValorNuevo=constantenomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConstanteNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(constantenomi.getIsNew()||!constantenomi.getid_tipo_constante_nomi().equals(constantenomi.getConstanteNomiOriginal().getid_tipo_constante_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(constantenomi.getConstanteNomiOriginal().getid_tipo_constante_nomi()!=null)
				{
					strValorActual=constantenomi.getConstanteNomiOriginal().getid_tipo_constante_nomi().toString();
				}
				if(constantenomi.getid_tipo_constante_nomi()!=null)
				{
					strValorNuevo=constantenomi.getid_tipo_constante_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI,strValorActual,strValorNuevo);
			}	
			
			if(constantenomi.getIsNew()||!constantenomi.getnombre().equals(constantenomi.getConstanteNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(constantenomi.getConstanteNomiOriginal().getnombre()!=null)
				{
					strValorActual=constantenomi.getConstanteNomiOriginal().getnombre();
				}
				if(constantenomi.getnombre()!=null)
				{
					strValorNuevo=constantenomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConstanteNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(constantenomi.getIsNew()||!constantenomi.getvalor().equals(constantenomi.getConstanteNomiOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(constantenomi.getConstanteNomiOriginal().getvalor()!=null)
				{
					strValorActual=constantenomi.getConstanteNomiOriginal().getvalor().toString();
				}
				if(constantenomi.getvalor()!=null)
				{
					strValorNuevo=constantenomi.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConstanteNomiConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(constantenomi.getIsNew()||!constantenomi.getes_para_pregunta().equals(constantenomi.getConstanteNomiOriginal().getes_para_pregunta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(constantenomi.getConstanteNomiOriginal().getes_para_pregunta()!=null)
				{
					strValorActual=constantenomi.getConstanteNomiOriginal().getes_para_pregunta().toString();
				}
				if(constantenomi.getes_para_pregunta()!=null)
				{
					strValorNuevo=constantenomi.getes_para_pregunta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConstanteNomiConstantesFunciones.ESPARAPREGUNTA,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConstanteNomiConstantesFunciones.getClassesForeignKeysOfConstanteNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConstanteNomiConstantesFunciones.getClassesRelationshipsOfConstanteNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
