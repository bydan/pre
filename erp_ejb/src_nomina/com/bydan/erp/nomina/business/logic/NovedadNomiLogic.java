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
import com.bydan.erp.nomina.util.NovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.NovedadNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.NovedadNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.NovedadNomi;
import com.bydan.erp.nomina.business.logic.NovedadNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class NovedadNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NovedadNomiLogic.class);
	
	protected NovedadNomiDataAccess novedadnomiDataAccess; 	
	protected NovedadNomi novedadnomi;
	protected List<NovedadNomi> novedadnomis;
	protected Object novedadnomiObject;	
	protected List<Object> novedadnomisObject;
	
	public static ClassValidator<NovedadNomi> novedadnomiValidator = new ClassValidator<NovedadNomi>(NovedadNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NovedadNomiLogicAdditional novedadnomiLogicAdditional=null;
	
	public NovedadNomiLogicAdditional getNovedadNomiLogicAdditional() {
		return this.novedadnomiLogicAdditional;
	}
	
	public void setNovedadNomiLogicAdditional(NovedadNomiLogicAdditional novedadnomiLogicAdditional) {
		try {
			this.novedadnomiLogicAdditional=novedadnomiLogicAdditional;
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
	
	
	
	
	public  NovedadNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.novedadnomiDataAccess = new NovedadNomiDataAccess();
			
			this.novedadnomis= new ArrayList<NovedadNomi>();
			this.novedadnomi= new NovedadNomi();
			
			this.novedadnomiObject=new Object();
			this.novedadnomisObject=new ArrayList<Object>();
				
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
			
			this.novedadnomiDataAccess.setConnexionType(this.connexionType);
			this.novedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NovedadNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.novedadnomiDataAccess = new NovedadNomiDataAccess();
			this.novedadnomis= new ArrayList<NovedadNomi>();
			this.novedadnomi= new NovedadNomi();
			this.novedadnomiObject=new Object();
			this.novedadnomisObject=new ArrayList<Object>();
			
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
			
			this.novedadnomiDataAccess.setConnexionType(this.connexionType);
			this.novedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NovedadNomi getNovedadNomi() throws Exception {	
		NovedadNomiLogicAdditional.checkNovedadNomiToGet(novedadnomi,this.datosCliente,this.arrDatoGeneral);
		NovedadNomiLogicAdditional.updateNovedadNomiToGet(novedadnomi,this.arrDatoGeneral);
		
		return novedadnomi;
	}
		
	public void setNovedadNomi(NovedadNomi newNovedadNomi) {
		this.novedadnomi = newNovedadNomi;
	}
	
	public NovedadNomiDataAccess getNovedadNomiDataAccess() {
		return novedadnomiDataAccess;
	}
	
	public void setNovedadNomiDataAccess(NovedadNomiDataAccess newnovedadnomiDataAccess) {
		this.novedadnomiDataAccess = newnovedadnomiDataAccess;
	}
	
	public List<NovedadNomi> getNovedadNomis() throws Exception {		
		this.quitarNovedadNomisNulos();
		
		NovedadNomiLogicAdditional.checkNovedadNomiToGets(novedadnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (NovedadNomi novedadnomiLocal: novedadnomis ) {
			NovedadNomiLogicAdditional.updateNovedadNomiToGet(novedadnomiLocal,this.arrDatoGeneral);
		}
		
		return novedadnomis;
	}
	
	public void setNovedadNomis(List<NovedadNomi> newNovedadNomis) {
		this.novedadnomis = newNovedadNomis;
	}
	
	public Object getNovedadNomiObject() {	
		this.novedadnomiObject=this.novedadnomiDataAccess.getEntityObject();
		return this.novedadnomiObject;
	}
		
	public void setNovedadNomiObject(Object newNovedadNomiObject) {
		this.novedadnomiObject = newNovedadNomiObject;
	}
	
	public List<Object> getNovedadNomisObject() {		
		this.novedadnomisObject=this.novedadnomiDataAccess.getEntitiesObject();
		return this.novedadnomisObject;
	}
		
	public void setNovedadNomisObject(List<Object> newNovedadNomisObject) {
		this.novedadnomisObject = newNovedadNomisObject;
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
		
		if(this.novedadnomiDataAccess!=null) {
			this.novedadnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			novedadnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			novedadnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		novedadnomi = new  NovedadNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			novedadnomi=novedadnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
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
		novedadnomi = new  NovedadNomi();
		  		  
        try {
			
			novedadnomi=novedadnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		novedadnomi = new  NovedadNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			novedadnomi=novedadnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
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
		novedadnomi = new  NovedadNomi();
		  		  
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
		novedadnomi = new  NovedadNomi();
		  		  
        try {
			
			novedadnomi=novedadnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		novedadnomi = new  NovedadNomi();
		  		  
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
		novedadnomi = new  NovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =novedadnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadnomi = new  NovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=novedadnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		novedadnomi = new  NovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =novedadnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadnomi = new  NovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=novedadnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		novedadnomi = new  NovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =novedadnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadnomi = new  NovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=novedadnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
        try {			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
        try {
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		novedadnomi = new  NovedadNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomi=novedadnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
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
		novedadnomi = new  NovedadNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomi=novedadnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
		novedadnomis = new  ArrayList<NovedadNomi>();
		  		  
        try {
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNovedadNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		novedadnomis = new  ArrayList<NovedadNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getTodosNovedadNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
	
	public  void  getTodosNovedadNomis(String sFinalQuery,Pagination pagination)throws Exception {
		novedadnomis = new  ArrayList<NovedadNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNovedadNomi(novedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNovedadNomi(NovedadNomi novedadnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(novedadnomi.getIsNew() || novedadnomi.getIsChanged()) { 
			this.invalidValues = novedadnomiValidator.getInvalidValues(novedadnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(novedadnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNovedadNomi(List<NovedadNomi> NovedadNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NovedadNomi novedadnomiLocal:novedadnomis) {				
			estaValidadoObjeto=this.validarGuardarNovedadNomi(novedadnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNovedadNomi(List<NovedadNomi> NovedadNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNovedadNomi(novedadnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNovedadNomi(NovedadNomi NovedadNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNovedadNomi(novedadnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NovedadNomi novedadnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+novedadnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NovedadNomiConstantesFunciones.getNovedadNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"novedadnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NovedadNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NovedadNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNovedadNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-saveNovedadNomiWithConnection");connexion.begin();			
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSave(this.novedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NovedadNomiLogicAdditional.updateNovedadNomiToSave(this.novedadnomi,this.arrDatoGeneral);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.novedadnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNovedadNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNovedadNomi(this.novedadnomi)) {
				NovedadNomiDataAccess.save(this.novedadnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.novedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSaveAfter(this.novedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNovedadNomi();
			
			connexion.commit();			
			
			if(this.novedadnomi.getIsDeleted()) {
				this.novedadnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNovedadNomi()throws Exception {	
		try {	
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSave(this.novedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NovedadNomiLogicAdditional.updateNovedadNomiToSave(this.novedadnomi,this.arrDatoGeneral);
			
			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.novedadnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNovedadNomi(this.novedadnomi)) {			
				NovedadNomiDataAccess.save(this.novedadnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.novedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSaveAfter(this.novedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.novedadnomi.getIsDeleted()) {
				this.novedadnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNovedadNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-saveNovedadNomisWithConnection");connexion.begin();			
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSaves(novedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNovedadNomis();
			
			Boolean validadoTodosNovedadNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NovedadNomi novedadnomiLocal:novedadnomis) {		
				if(novedadnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NovedadNomiLogicAdditional.updateNovedadNomiToSave(novedadnomiLocal,this.arrDatoGeneral);
	        	
				NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),novedadnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNovedadNomi(novedadnomiLocal)) {
					NovedadNomiDataAccess.save(novedadnomiLocal, connexion);				
				} else {
					validadoTodosNovedadNomi=false;
				}
			}
			
			if(!validadoTodosNovedadNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSavesAfter(novedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNovedadNomis();
			
			connexion.commit();		
			
			this.quitarNovedadNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNovedadNomis()throws Exception {				
		 try {	
			NovedadNomiLogicAdditional.checkNovedadNomiToSaves(novedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNovedadNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NovedadNomi novedadnomiLocal:novedadnomis) {				
				if(novedadnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NovedadNomiLogicAdditional.updateNovedadNomiToSave(novedadnomiLocal,this.arrDatoGeneral);
	        	
				NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),novedadnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNovedadNomi(novedadnomiLocal)) {				
					NovedadNomiDataAccess.save(novedadnomiLocal, connexion);				
				} else {
					validadoTodosNovedadNomi=false;
				}
			}
			
			if(!validadoTodosNovedadNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NovedadNomiLogicAdditional.checkNovedadNomiToSavesAfter(novedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNovedadNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NovedadNomiParameterReturnGeneral procesarAccionNovedadNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NovedadNomi> novedadnomis,NovedadNomiParameterReturnGeneral novedadnomiParameterGeneral)throws Exception {
		 try {	
			NovedadNomiParameterReturnGeneral novedadnomiReturnGeneral=new NovedadNomiParameterReturnGeneral();
	
			NovedadNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,novedadnomis,novedadnomiParameterGeneral,novedadnomiReturnGeneral);
			
			return novedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NovedadNomiParameterReturnGeneral procesarAccionNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NovedadNomi> novedadnomis,NovedadNomiParameterReturnGeneral novedadnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-procesarAccionNovedadNomisWithConnection");connexion.begin();			
			
			NovedadNomiParameterReturnGeneral novedadnomiReturnGeneral=new NovedadNomiParameterReturnGeneral();
	
			NovedadNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,novedadnomis,novedadnomiParameterGeneral,novedadnomiReturnGeneral);
			
			this.connexion.commit();
			
			return novedadnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NovedadNomiParameterReturnGeneral procesarEventosNovedadNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NovedadNomi> novedadnomis,NovedadNomi novedadnomi,NovedadNomiParameterReturnGeneral novedadnomiParameterGeneral,Boolean isEsNuevoNovedadNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			NovedadNomiParameterReturnGeneral novedadnomiReturnGeneral=new NovedadNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				novedadnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NovedadNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,novedadnomis,novedadnomi,novedadnomiParameterGeneral,novedadnomiReturnGeneral,isEsNuevoNovedadNomi,clases);
			
			return novedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NovedadNomiParameterReturnGeneral procesarEventosNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NovedadNomi> novedadnomis,NovedadNomi novedadnomi,NovedadNomiParameterReturnGeneral novedadnomiParameterGeneral,Boolean isEsNuevoNovedadNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-procesarEventosNovedadNomisWithConnection");connexion.begin();			
			
			NovedadNomiParameterReturnGeneral novedadnomiReturnGeneral=new NovedadNomiParameterReturnGeneral();
	
			novedadnomiReturnGeneral.setNovedadNomi(novedadnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				novedadnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NovedadNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,novedadnomis,novedadnomi,novedadnomiParameterGeneral,novedadnomiReturnGeneral,isEsNuevoNovedadNomi,clases);
			
			this.connexion.commit();
			
			return novedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NovedadNomiParameterReturnGeneral procesarImportacionNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NovedadNomiParameterReturnGeneral novedadnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-procesarImportacionNovedadNomisWithConnection");connexion.begin();			
			
			NovedadNomiParameterReturnGeneral novedadnomiReturnGeneral=new NovedadNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.novedadnomis=new ArrayList<NovedadNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.novedadnomi=new NovedadNomi();
				
				
				if(conColumnasBase) {this.novedadnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.novedadnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.novedadnomi.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.novedadnomi.setnumero_hora(Integer.parseInt(arrColumnas[iColumn++]));
				this.novedadnomi.setnumero_minuto(Integer.parseInt(arrColumnas[iColumn++]));
				this.novedadnomi.setnumero_jornada_trabajo(Integer.parseInt(arrColumnas[iColumn++]));
				this.novedadnomi.setanio_vacacion(Integer.parseInt(arrColumnas[iColumn++]));
			this.novedadnomi.setdescripcion(arrColumnas[iColumn++]);
				
				this.novedadnomis.add(this.novedadnomi);
			}
			
			this.saveNovedadNomis();
			
			this.connexion.commit();
			
			novedadnomiReturnGeneral.setConRetornoEstaProcesado(true);
			novedadnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return novedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNovedadNomisEliminados() throws Exception {				
		
		List<NovedadNomi> novedadnomisAux= new ArrayList<NovedadNomi>();
		
		for(NovedadNomi novedadnomi:novedadnomis) {
			if(!novedadnomi.getIsDeleted()) {
				novedadnomisAux.add(novedadnomi);
			}
		}
		
		novedadnomis=novedadnomisAux;
	}
	
	public void quitarNovedadNomisNulos() throws Exception {				
		
		List<NovedadNomi> novedadnomisAux= new ArrayList<NovedadNomi>();
		
		for(NovedadNomi novedadnomi : this.novedadnomis) {
			if(novedadnomi==null) {
				novedadnomisAux.add(novedadnomi);
			}
		}
		
		//this.novedadnomis=novedadnomisAux;
		
		this.novedadnomis.removeAll(novedadnomisAux);
	}
	
	public void getSetVersionRowNovedadNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(novedadnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((novedadnomi.getIsDeleted() || (novedadnomi.getIsChanged()&&!novedadnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=novedadnomiDataAccess.getSetVersionRowNovedadNomi(connexion,novedadnomi.getId());
				
				if(!novedadnomi.getVersionRow().equals(timestamp)) {	
					novedadnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				novedadnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNovedadNomi()throws Exception {	
		
		if(novedadnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((novedadnomi.getIsDeleted() || (novedadnomi.getIsChanged()&&!novedadnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=novedadnomiDataAccess.getSetVersionRowNovedadNomi(connexion,novedadnomi.getId());
			
			try {							
				if(!novedadnomi.getVersionRow().equals(timestamp)) {	
					novedadnomi.setVersionRow(timestamp);
				}
				
				novedadnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNovedadNomisWithConnection()throws Exception {	
		if(novedadnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NovedadNomi novedadnomiAux:novedadnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(novedadnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(novedadnomiAux.getIsDeleted() || (novedadnomiAux.getIsChanged()&&!novedadnomiAux.getIsNew())) {
						
						timestamp=novedadnomiDataAccess.getSetVersionRowNovedadNomi(connexion,novedadnomiAux.getId());
						
						if(!novedadnomi.getVersionRow().equals(timestamp)) {	
							novedadnomiAux.setVersionRow(timestamp);
						}
								
						novedadnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNovedadNomis()throws Exception {	
		if(novedadnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NovedadNomi novedadnomiAux:novedadnomis) {
					if(novedadnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(novedadnomiAux.getIsDeleted() || (novedadnomiAux.getIsChanged()&&!novedadnomiAux.getIsNew())) {
						
						timestamp=novedadnomiDataAccess.getSetVersionRowNovedadNomi(connexion,novedadnomiAux.getId());
						
						if(!novedadnomiAux.getVersionRow().equals(timestamp)) {	
							novedadnomiAux.setVersionRow(timestamp);
						}
						
													
						novedadnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NovedadNomiParameterReturnGeneral cargarCombosLoteForeignKeyNovedadNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoAutoriza,String finalQueryGlobalTipoNovedadNomi,String finalQueryGlobalEstadoNovedadNomi) throws Exception {
		NovedadNomiParameterReturnGeneral  novedadnomiReturnGeneral =new NovedadNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyNovedadNomiWithConnection");connexion.begin();
			
			novedadnomiReturnGeneral =new NovedadNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			novedadnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			novedadnomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoautorizasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoautorizaLogic=new EmpleadoLogic();
			empleadoautorizaLogic.setConnexion(this.connexion);
			empleadoautorizaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoAutoriza.equals("NONE")) {
				empleadoautorizaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoAutoriza,new Pagination());
				empleadoautorizasForeignKey=empleadoautorizaLogic.getEmpleados();
			}

			novedadnomiReturnGeneral.setempleadoautorizasForeignKey(empleadoautorizasForeignKey);


			List<TipoNovedadNomi> tiponovedadnomisForeignKey=new ArrayList<TipoNovedadNomi>();
			TipoNovedadNomiLogic tiponovedadnomiLogic=new TipoNovedadNomiLogic();
			tiponovedadnomiLogic.setConnexion(this.connexion);
			tiponovedadnomiLogic.getTipoNovedadNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNovedadNomi.equals("NONE")) {
				tiponovedadnomiLogic.getTodosTipoNovedadNomis(finalQueryGlobalTipoNovedadNomi,new Pagination());
				tiponovedadnomisForeignKey=tiponovedadnomiLogic.getTipoNovedadNomis();
			}

			novedadnomiReturnGeneral.settiponovedadnomisForeignKey(tiponovedadnomisForeignKey);


			List<EstadoNovedadNomi> estadonovedadnomisForeignKey=new ArrayList<EstadoNovedadNomi>();
			EstadoNovedadNomiLogic estadonovedadnomiLogic=new EstadoNovedadNomiLogic();
			estadonovedadnomiLogic.setConnexion(this.connexion);
			estadonovedadnomiLogic.getEstadoNovedadNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNovedadNomi.equals("NONE")) {
				estadonovedadnomiLogic.getTodosEstadoNovedadNomis(finalQueryGlobalEstadoNovedadNomi,new Pagination());
				estadonovedadnomisForeignKey=estadonovedadnomiLogic.getEstadoNovedadNomis();
			}

			novedadnomiReturnGeneral.setestadonovedadnomisForeignKey(estadonovedadnomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return novedadnomiReturnGeneral;
	}
	
	public NovedadNomiParameterReturnGeneral cargarCombosLoteForeignKeyNovedadNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoAutoriza,String finalQueryGlobalTipoNovedadNomi,String finalQueryGlobalEstadoNovedadNomi) throws Exception {
		NovedadNomiParameterReturnGeneral  novedadnomiReturnGeneral =new NovedadNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			novedadnomiReturnGeneral =new NovedadNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			novedadnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			novedadnomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoautorizasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoautorizaLogic=new EmpleadoLogic();
			empleadoautorizaLogic.setConnexion(this.connexion);
			empleadoautorizaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoAutoriza.equals("NONE")) {
				empleadoautorizaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoAutoriza,new Pagination());
				empleadoautorizasForeignKey=empleadoautorizaLogic.getEmpleados();
			}

			novedadnomiReturnGeneral.setempleadoautorizasForeignKey(empleadoautorizasForeignKey);


			List<TipoNovedadNomi> tiponovedadnomisForeignKey=new ArrayList<TipoNovedadNomi>();
			TipoNovedadNomiLogic tiponovedadnomiLogic=new TipoNovedadNomiLogic();
			tiponovedadnomiLogic.setConnexion(this.connexion);
			tiponovedadnomiLogic.getTipoNovedadNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNovedadNomi.equals("NONE")) {
				tiponovedadnomiLogic.getTodosTipoNovedadNomis(finalQueryGlobalTipoNovedadNomi,new Pagination());
				tiponovedadnomisForeignKey=tiponovedadnomiLogic.getTipoNovedadNomis();
			}

			novedadnomiReturnGeneral.settiponovedadnomisForeignKey(tiponovedadnomisForeignKey);


			List<EstadoNovedadNomi> estadonovedadnomisForeignKey=new ArrayList<EstadoNovedadNomi>();
			EstadoNovedadNomiLogic estadonovedadnomiLogic=new EstadoNovedadNomiLogic();
			estadonovedadnomiLogic.setConnexion(this.connexion);
			estadonovedadnomiLogic.getEstadoNovedadNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNovedadNomi.equals("NONE")) {
				estadonovedadnomiLogic.getTodosEstadoNovedadNomis(finalQueryGlobalEstadoNovedadNomi,new Pagination());
				estadonovedadnomisForeignKey=estadonovedadnomiLogic.getEstadoNovedadNomis();
			}

			novedadnomiReturnGeneral.setestadonovedadnomisForeignKey(estadonovedadnomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return novedadnomiReturnGeneral;
	}
	
	
	public void deepLoad(NovedadNomi novedadnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NovedadNomiLogicAdditional.updateNovedadNomiToGet(novedadnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		novedadnomi.setEmpresa(novedadnomiDataAccess.getEmpresa(connexion,novedadnomi));
		novedadnomi.setEmpleado(novedadnomiDataAccess.getEmpleado(connexion,novedadnomi));
		novedadnomi.setEmpleadoAutoriza(novedadnomiDataAccess.getEmpleadoAutoriza(connexion,novedadnomi));
		novedadnomi.setTipoNovedadNomi(novedadnomiDataAccess.getTipoNovedadNomi(connexion,novedadnomi));
		novedadnomi.setEstadoNovedadNomi(novedadnomiDataAccess.getEstadoNovedadNomi(connexion,novedadnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				novedadnomi.setEmpresa(novedadnomiDataAccess.getEmpresa(connexion,novedadnomi));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				novedadnomi.setEmpleado(novedadnomiDataAccess.getEmpleado(connexion,novedadnomi));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				novedadnomi.setEmpleadoAutoriza(novedadnomiDataAccess.getEmpleadoAutoriza(connexion,novedadnomi));
				continue;
			}

			if(clas.clas.equals(TipoNovedadNomi.class)) {
				novedadnomi.setTipoNovedadNomi(novedadnomiDataAccess.getTipoNovedadNomi(connexion,novedadnomi));
				continue;
			}

			if(clas.clas.equals(EstadoNovedadNomi.class)) {
				novedadnomi.setEstadoNovedadNomi(novedadnomiDataAccess.getEstadoNovedadNomi(connexion,novedadnomi));
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
			novedadnomi.setEmpresa(novedadnomiDataAccess.getEmpresa(connexion,novedadnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setEmpleado(novedadnomiDataAccess.getEmpleado(connexion,novedadnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setEmpleadoAutoriza(novedadnomiDataAccess.getEmpleadoAutoriza(connexion,novedadnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNovedadNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setTipoNovedadNomi(novedadnomiDataAccess.getTipoNovedadNomi(connexion,novedadnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNovedadNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setEstadoNovedadNomi(novedadnomiDataAccess.getEstadoNovedadNomi(connexion,novedadnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		novedadnomi.setEmpresa(novedadnomiDataAccess.getEmpresa(connexion,novedadnomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(novedadnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		novedadnomi.setEmpleado(novedadnomiDataAccess.getEmpleado(connexion,novedadnomi));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(novedadnomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		novedadnomi.setEmpleadoAutoriza(novedadnomiDataAccess.getEmpleadoAutoriza(connexion,novedadnomi));
		EmpleadoLogic empleadoautorizaLogic= new EmpleadoLogic(connexion);
		empleadoautorizaLogic.deepLoad(novedadnomi.getEmpleadoAutoriza(),isDeep,deepLoadType,clases);
				
		novedadnomi.setTipoNovedadNomi(novedadnomiDataAccess.getTipoNovedadNomi(connexion,novedadnomi));
		TipoNovedadNomiLogic tiponovedadnomiLogic= new TipoNovedadNomiLogic(connexion);
		tiponovedadnomiLogic.deepLoad(novedadnomi.getTipoNovedadNomi(),isDeep,deepLoadType,clases);
				
		novedadnomi.setEstadoNovedadNomi(novedadnomiDataAccess.getEstadoNovedadNomi(connexion,novedadnomi));
		EstadoNovedadNomiLogic estadonovedadnomiLogic= new EstadoNovedadNomiLogic(connexion);
		estadonovedadnomiLogic.deepLoad(novedadnomi.getEstadoNovedadNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				novedadnomi.setEmpresa(novedadnomiDataAccess.getEmpresa(connexion,novedadnomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(novedadnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				novedadnomi.setEmpleado(novedadnomiDataAccess.getEmpleado(connexion,novedadnomi));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(novedadnomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				novedadnomi.setEmpleadoAutoriza(novedadnomiDataAccess.getEmpleadoAutoriza(connexion,novedadnomi));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(novedadnomi.getEmpleadoAutoriza(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNovedadNomi.class)) {
				novedadnomi.setTipoNovedadNomi(novedadnomiDataAccess.getTipoNovedadNomi(connexion,novedadnomi));
				TipoNovedadNomiLogic tiponovedadnomiLogic= new TipoNovedadNomiLogic(connexion);
				tiponovedadnomiLogic.deepLoad(novedadnomi.getTipoNovedadNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNovedadNomi.class)) {
				novedadnomi.setEstadoNovedadNomi(novedadnomiDataAccess.getEstadoNovedadNomi(connexion,novedadnomi));
				EstadoNovedadNomiLogic estadonovedadnomiLogic= new EstadoNovedadNomiLogic(connexion);
				estadonovedadnomiLogic.deepLoad(novedadnomi.getEstadoNovedadNomi(),isDeep,deepLoadType,clases);				
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
			novedadnomi.setEmpresa(novedadnomiDataAccess.getEmpresa(connexion,novedadnomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(novedadnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setEmpleado(novedadnomiDataAccess.getEmpleado(connexion,novedadnomi));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(novedadnomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setEmpleadoAutoriza(novedadnomiDataAccess.getEmpleadoAutoriza(connexion,novedadnomi));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(novedadnomi.getEmpleadoAutoriza(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNovedadNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setTipoNovedadNomi(novedadnomiDataAccess.getTipoNovedadNomi(connexion,novedadnomi));
			TipoNovedadNomiLogic tiponovedadnomiLogic= new TipoNovedadNomiLogic(connexion);
			tiponovedadnomiLogic.deepLoad(novedadnomi.getTipoNovedadNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNovedadNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadnomi.setEstadoNovedadNomi(novedadnomiDataAccess.getEstadoNovedadNomi(connexion,novedadnomi));
			EstadoNovedadNomiLogic estadonovedadnomiLogic= new EstadoNovedadNomiLogic(connexion);
			estadonovedadnomiLogic.deepLoad(novedadnomi.getEstadoNovedadNomi(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NovedadNomi novedadnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NovedadNomiLogicAdditional.updateNovedadNomiToSave(novedadnomi,this.arrDatoGeneral);
			
NovedadNomiDataAccess.save(novedadnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(novedadnomi.getEmpresa(),connexion);

		EmpleadoDataAccess.save(novedadnomi.getEmpleado(),connexion);

		EmpleadoDataAccess.save(novedadnomi.getEmpleadoAutoriza(),connexion);

		TipoNovedadNomiDataAccess.save(novedadnomi.getTipoNovedadNomi(),connexion);

		EstadoNovedadNomiDataAccess.save(novedadnomi.getEstadoNovedadNomi(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(novedadnomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(novedadnomi.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(novedadnomi.getEmpleadoAutoriza(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoNovedadNomi.class)) {
				TipoNovedadNomiDataAccess.save(novedadnomi.getTipoNovedadNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoNovedadNomi.class)) {
				EstadoNovedadNomiDataAccess.save(novedadnomi.getEstadoNovedadNomi(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(novedadnomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(novedadnomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(novedadnomi.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(novedadnomi.getEmpleado(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(novedadnomi.getEmpleadoAutoriza(),connexion);
		EmpleadoLogic empleadoautorizaLogic= new EmpleadoLogic(connexion);
		empleadoautorizaLogic.deepLoad(novedadnomi.getEmpleadoAutoriza(),isDeep,deepLoadType,clases);
				

		TipoNovedadNomiDataAccess.save(novedadnomi.getTipoNovedadNomi(),connexion);
		TipoNovedadNomiLogic tiponovedadnomiLogic= new TipoNovedadNomiLogic(connexion);
		tiponovedadnomiLogic.deepLoad(novedadnomi.getTipoNovedadNomi(),isDeep,deepLoadType,clases);
				

		EstadoNovedadNomiDataAccess.save(novedadnomi.getEstadoNovedadNomi(),connexion);
		EstadoNovedadNomiLogic estadonovedadnomiLogic= new EstadoNovedadNomiLogic(connexion);
		estadonovedadnomiLogic.deepLoad(novedadnomi.getEstadoNovedadNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(novedadnomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(novedadnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(novedadnomi.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(novedadnomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(novedadnomi.getEmpleadoAutoriza(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(novedadnomi.getEmpleadoAutoriza(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNovedadNomi.class)) {
				TipoNovedadNomiDataAccess.save(novedadnomi.getTipoNovedadNomi(),connexion);
				TipoNovedadNomiLogic tiponovedadnomiLogic= new TipoNovedadNomiLogic(connexion);
				tiponovedadnomiLogic.deepSave(novedadnomi.getTipoNovedadNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNovedadNomi.class)) {
				EstadoNovedadNomiDataAccess.save(novedadnomi.getEstadoNovedadNomi(),connexion);
				EstadoNovedadNomiLogic estadonovedadnomiLogic= new EstadoNovedadNomiLogic(connexion);
				estadonovedadnomiLogic.deepSave(novedadnomi.getEstadoNovedadNomi(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(NovedadNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(novedadnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(novedadnomi);
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
			this.deepLoad(this.novedadnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NovedadNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(novedadnomis!=null) {
				for(NovedadNomi novedadnomi:novedadnomis) {
					this.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(novedadnomis);
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
			if(novedadnomis!=null) {
				for(NovedadNomi novedadnomi:novedadnomis) {
					this.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(novedadnomis);
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
			this.getNewConnexionToDeep(NovedadNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(novedadnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NovedadNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(novedadnomis!=null) {
				for(NovedadNomi novedadnomi:novedadnomis) {
					this.deepSave(novedadnomi,isDeep,deepLoadType,clases);
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
			if(novedadnomis!=null) {
				for(NovedadNomi novedadnomi:novedadnomis) {
					this.deepSave(novedadnomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNovedadNomisFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,NovedadNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadNomisFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,NovedadNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadNomisFK_IdEmpleadoAutorizaWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_autoriza)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoAutoriza= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoAutoriza.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_autoriza,NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoAutoriza);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoAutoriza","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadNomisFK_IdEmpleadoAutoriza(String sFinalQuery,Pagination pagination,Long id_empleado_autoriza)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoAutoriza= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoAutoriza.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_autoriza,NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoAutoriza);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoAutoriza","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NovedadNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NovedadNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadNomisFK_IdEstadoNovedadNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_novedad_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNovedadNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNovedadNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_novedad_nomi,NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNovedadNomi);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNovedadNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadNomisFK_IdEstadoNovedadNomi(String sFinalQuery,Pagination pagination,Long id_estado_novedad_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNovedadNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNovedadNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_novedad_nomi,NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNovedadNomi);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNovedadNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadNomisFK_IdTipoNovedadNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_novedad_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNovedadNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNovedadNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_novedad_nomi,NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNovedadNomi);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNovedadNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadNomisFK_IdTipoNovedadNomi(String sFinalQuery,Pagination pagination,Long id_tipo_novedad_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNovedadNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNovedadNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_novedad_nomi,NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNovedadNomi);

			NovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNovedadNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(this.novedadnomis);
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
			if(NovedadNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NovedadNomi novedadnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NovedadNomiConstantesFunciones.ISCONAUDITORIA) {
				if(novedadnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadNomiDataAccess.TABLENAME, novedadnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NovedadNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NovedadNomiLogic.registrarAuditoriaDetallesNovedadNomi(connexion,novedadnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(novedadnomi.getIsDeleted()) {
					/*if(!novedadnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NovedadNomiDataAccess.TABLENAME, novedadnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NovedadNomiLogic.registrarAuditoriaDetallesNovedadNomi(connexion,novedadnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadNomiDataAccess.TABLENAME, novedadnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(novedadnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadNomiDataAccess.TABLENAME, novedadnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NovedadNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NovedadNomiLogic.registrarAuditoriaDetallesNovedadNomi(connexion,novedadnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNovedadNomi(Connexion connexion,NovedadNomi novedadnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(novedadnomi.getIsNew()||!novedadnomi.getid_empresa().equals(novedadnomi.getNovedadNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getid_empresa().toString();
				}
				if(novedadnomi.getid_empresa()!=null)
				{
					strValorNuevo=novedadnomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getid_empleado().equals(novedadnomi.getNovedadNomiOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getid_empleado()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getid_empleado().toString();
				}
				if(novedadnomi.getid_empleado()!=null)
				{
					strValorNuevo=novedadnomi.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getid_empleado_autoriza().equals(novedadnomi.getNovedadNomiOriginal().getid_empleado_autoriza()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getid_empleado_autoriza()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getid_empleado_autoriza().toString();
				}
				if(novedadnomi.getid_empleado_autoriza()!=null)
				{
					strValorNuevo=novedadnomi.getid_empleado_autoriza().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getid_tipo_novedad_nomi().equals(novedadnomi.getNovedadNomiOriginal().getid_tipo_novedad_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getid_tipo_novedad_nomi()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getid_tipo_novedad_nomi().toString();
				}
				if(novedadnomi.getid_tipo_novedad_nomi()!=null)
				{
					strValorNuevo=novedadnomi.getid_tipo_novedad_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getid_estado_novedad_nomi().equals(novedadnomi.getNovedadNomiOriginal().getid_estado_novedad_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getid_estado_novedad_nomi()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getid_estado_novedad_nomi().toString();
				}
				if(novedadnomi.getid_estado_novedad_nomi()!=null)
				{
					strValorNuevo=novedadnomi.getid_estado_novedad_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getfecha().equals(novedadnomi.getNovedadNomiOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getfecha()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getfecha().toString();
				}
				if(novedadnomi.getfecha()!=null)
				{
					strValorNuevo=novedadnomi.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getnumero_hora().equals(novedadnomi.getNovedadNomiOriginal().getnumero_hora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getnumero_hora()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getnumero_hora().toString();
				}
				if(novedadnomi.getnumero_hora()!=null)
				{
					strValorNuevo=novedadnomi.getnumero_hora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.NUMEROHORA,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getnumero_minuto().equals(novedadnomi.getNovedadNomiOriginal().getnumero_minuto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getnumero_minuto()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getnumero_minuto().toString();
				}
				if(novedadnomi.getnumero_minuto()!=null)
				{
					strValorNuevo=novedadnomi.getnumero_minuto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.NUMEROMINUTO,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getnumero_jornada_trabajo().equals(novedadnomi.getNovedadNomiOriginal().getnumero_jornada_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getnumero_jornada_trabajo()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getnumero_jornada_trabajo().toString();
				}
				if(novedadnomi.getnumero_jornada_trabajo()!=null)
				{
					strValorNuevo=novedadnomi.getnumero_jornada_trabajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getanio_vacacion().equals(novedadnomi.getNovedadNomiOriginal().getanio_vacacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getanio_vacacion()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getanio_vacacion().toString();
				}
				if(novedadnomi.getanio_vacacion()!=null)
				{
					strValorNuevo=novedadnomi.getanio_vacacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.ANIOVACACION,strValorActual,strValorNuevo);
			}	
			
			if(novedadnomi.getIsNew()||!novedadnomi.getdescripcion().equals(novedadnomi.getNovedadNomiOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadnomi.getNovedadNomiOriginal().getdescripcion()!=null)
				{
					strValorActual=novedadnomi.getNovedadNomiOriginal().getdescripcion();
				}
				if(novedadnomi.getdescripcion()!=null)
				{
					strValorNuevo=novedadnomi.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadNomiConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNovedadNomiRelacionesWithConnection(NovedadNomi novedadnomi) throws Exception {

		if(!novedadnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNovedadNomiRelacionesBase(novedadnomi,true);
		}
	}

	public void saveNovedadNomiRelaciones(NovedadNomi novedadnomi)throws Exception {

		if(!novedadnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNovedadNomiRelacionesBase(novedadnomi,false);
		}
	}

	public void saveNovedadNomiRelacionesBase(NovedadNomi novedadnomi,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NovedadNomi-saveRelacionesWithConnection");}
	

			this.setNovedadNomi(novedadnomi);

			if(NovedadNomiLogicAdditional.validarSaveRelaciones(novedadnomi,this)) {

				NovedadNomiLogicAdditional.updateRelacionesToSave(novedadnomi,this);

				if((novedadnomi.getIsNew()||novedadnomi.getIsChanged())&&!novedadnomi.getIsDeleted()) {
					this.saveNovedadNomi();
					this.saveNovedadNomiRelacionesDetalles();

				} else if(novedadnomi.getIsDeleted()) {
					this.saveNovedadNomiRelacionesDetalles();
					this.saveNovedadNomi();
				}

				NovedadNomiLogicAdditional.updateRelacionesToSaveAfter(novedadnomi,this);

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
	
	
	private void saveNovedadNomiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NovedadNomiConstantesFunciones.getClassesRelationshipsOfNovedadNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
