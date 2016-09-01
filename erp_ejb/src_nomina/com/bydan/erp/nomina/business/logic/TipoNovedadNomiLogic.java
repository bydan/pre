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
import com.bydan.erp.nomina.util.TipoNovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoNovedadNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoNovedadNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoNovedadNomi;
import com.bydan.erp.nomina.business.logic.TipoNovedadNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoNovedadNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoNovedadNomiLogic.class);
	
	protected TipoNovedadNomiDataAccess tiponovedadnomiDataAccess; 	
	protected TipoNovedadNomi tiponovedadnomi;
	protected List<TipoNovedadNomi> tiponovedadnomis;
	protected Object tiponovedadnomiObject;	
	protected List<Object> tiponovedadnomisObject;
	
	public static ClassValidator<TipoNovedadNomi> tiponovedadnomiValidator = new ClassValidator<TipoNovedadNomi>(TipoNovedadNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoNovedadNomiLogicAdditional tiponovedadnomiLogicAdditional=null;
	
	public TipoNovedadNomiLogicAdditional getTipoNovedadNomiLogicAdditional() {
		return this.tiponovedadnomiLogicAdditional;
	}
	
	public void setTipoNovedadNomiLogicAdditional(TipoNovedadNomiLogicAdditional tiponovedadnomiLogicAdditional) {
		try {
			this.tiponovedadnomiLogicAdditional=tiponovedadnomiLogicAdditional;
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
	
	
	
	
	public  TipoNovedadNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiponovedadnomiDataAccess = new TipoNovedadNomiDataAccess();
			
			this.tiponovedadnomis= new ArrayList<TipoNovedadNomi>();
			this.tiponovedadnomi= new TipoNovedadNomi();
			
			this.tiponovedadnomiObject=new Object();
			this.tiponovedadnomisObject=new ArrayList<Object>();
				
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
			
			this.tiponovedadnomiDataAccess.setConnexionType(this.connexionType);
			this.tiponovedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoNovedadNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiponovedadnomiDataAccess = new TipoNovedadNomiDataAccess();
			this.tiponovedadnomis= new ArrayList<TipoNovedadNomi>();
			this.tiponovedadnomi= new TipoNovedadNomi();
			this.tiponovedadnomiObject=new Object();
			this.tiponovedadnomisObject=new ArrayList<Object>();
			
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
			
			this.tiponovedadnomiDataAccess.setConnexionType(this.connexionType);
			this.tiponovedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoNovedadNomi getTipoNovedadNomi() throws Exception {	
		TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToGet(tiponovedadnomi,this.datosCliente,this.arrDatoGeneral);
		TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToGet(tiponovedadnomi,this.arrDatoGeneral);
		
		return tiponovedadnomi;
	}
		
	public void setTipoNovedadNomi(TipoNovedadNomi newTipoNovedadNomi) {
		this.tiponovedadnomi = newTipoNovedadNomi;
	}
	
	public TipoNovedadNomiDataAccess getTipoNovedadNomiDataAccess() {
		return tiponovedadnomiDataAccess;
	}
	
	public void setTipoNovedadNomiDataAccess(TipoNovedadNomiDataAccess newtiponovedadnomiDataAccess) {
		this.tiponovedadnomiDataAccess = newtiponovedadnomiDataAccess;
	}
	
	public List<TipoNovedadNomi> getTipoNovedadNomis() throws Exception {		
		this.quitarTipoNovedadNomisNulos();
		
		TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToGets(tiponovedadnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoNovedadNomi tiponovedadnomiLocal: tiponovedadnomis ) {
			TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToGet(tiponovedadnomiLocal,this.arrDatoGeneral);
		}
		
		return tiponovedadnomis;
	}
	
	public void setTipoNovedadNomis(List<TipoNovedadNomi> newTipoNovedadNomis) {
		this.tiponovedadnomis = newTipoNovedadNomis;
	}
	
	public Object getTipoNovedadNomiObject() {	
		this.tiponovedadnomiObject=this.tiponovedadnomiDataAccess.getEntityObject();
		return this.tiponovedadnomiObject;
	}
		
	public void setTipoNovedadNomiObject(Object newTipoNovedadNomiObject) {
		this.tiponovedadnomiObject = newTipoNovedadNomiObject;
	}
	
	public List<Object> getTipoNovedadNomisObject() {		
		this.tiponovedadnomisObject=this.tiponovedadnomiDataAccess.getEntitiesObject();
		return this.tiponovedadnomisObject;
	}
		
	public void setTipoNovedadNomisObject(List<Object> newTipoNovedadNomisObject) {
		this.tiponovedadnomisObject = newTipoNovedadNomisObject;
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
		
		if(this.tiponovedadnomiDataAccess!=null) {
			this.tiponovedadnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiponovedadnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiponovedadnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiponovedadnomi = new  TipoNovedadNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
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
		tiponovedadnomi = new  TipoNovedadNomi();
		  		  
        try {
			
			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiponovedadnomi = new  TipoNovedadNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
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
		tiponovedadnomi = new  TipoNovedadNomi();
		  		  
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
		tiponovedadnomi = new  TipoNovedadNomi();
		  		  
        try {
			
			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiponovedadnomi = new  TipoNovedadNomi();
		  		  
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
		tiponovedadnomi = new  TipoNovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiponovedadnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponovedadnomi = new  TipoNovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiponovedadnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponovedadnomi = new  TipoNovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiponovedadnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponovedadnomi = new  TipoNovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiponovedadnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponovedadnomi = new  TipoNovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiponovedadnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponovedadnomi = new  TipoNovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiponovedadnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
        try {			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
        try {
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiponovedadnomi = new  TipoNovedadNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
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
		tiponovedadnomi = new  TipoNovedadNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
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
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		  		  
        try {
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoNovedadNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-getTodosTipoNovedadNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
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
	
	public  void  getTodosTipoNovedadNomis(String sFinalQuery,Pagination pagination)throws Exception {
		tiponovedadnomis = new  ArrayList<TipoNovedadNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponovedadnomis=tiponovedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNovedadNomi(tiponovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(tiponovedadnomi.getIsNew() || tiponovedadnomi.getIsChanged()) { 
			this.invalidValues = tiponovedadnomiValidator.getInvalidValues(tiponovedadnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiponovedadnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoNovedadNomi(List<TipoNovedadNomi> TipoNovedadNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoNovedadNomi tiponovedadnomiLocal:tiponovedadnomis) {				
			estaValidadoObjeto=this.validarGuardarTipoNovedadNomi(tiponovedadnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoNovedadNomi(List<TipoNovedadNomi> TipoNovedadNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNovedadNomi(tiponovedadnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoNovedadNomi(TipoNovedadNomi TipoNovedadNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNovedadNomi(tiponovedadnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoNovedadNomi tiponovedadnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiponovedadnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoNovedadNomiConstantesFunciones.getTipoNovedadNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiponovedadnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoNovedadNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoNovedadNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoNovedadNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-saveTipoNovedadNomiWithConnection");connexion.begin();			
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSave(this.tiponovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToSave(this.tiponovedadnomi,this.arrDatoGeneral);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponovedadnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoNovedadNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNovedadNomi(this.tiponovedadnomi)) {
				TipoNovedadNomiDataAccess.save(this.tiponovedadnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiponovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSaveAfter(this.tiponovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNovedadNomi();
			
			connexion.commit();			
			
			if(this.tiponovedadnomi.getIsDeleted()) {
				this.tiponovedadnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoNovedadNomi()throws Exception {	
		try {	
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSave(this.tiponovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToSave(this.tiponovedadnomi,this.arrDatoGeneral);
			
			TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponovedadnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNovedadNomi(this.tiponovedadnomi)) {			
				TipoNovedadNomiDataAccess.save(this.tiponovedadnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiponovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSaveAfter(this.tiponovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiponovedadnomi.getIsDeleted()) {
				this.tiponovedadnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoNovedadNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-saveTipoNovedadNomisWithConnection");connexion.begin();			
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSaves(tiponovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoNovedadNomis();
			
			Boolean validadoTodosTipoNovedadNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNovedadNomi tiponovedadnomiLocal:tiponovedadnomis) {		
				if(tiponovedadnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToSave(tiponovedadnomiLocal,this.arrDatoGeneral);
	        	
				TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponovedadnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNovedadNomi(tiponovedadnomiLocal)) {
					TipoNovedadNomiDataAccess.save(tiponovedadnomiLocal, connexion);				
				} else {
					validadoTodosTipoNovedadNomi=false;
				}
			}
			
			if(!validadoTodosTipoNovedadNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSavesAfter(tiponovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNovedadNomis();
			
			connexion.commit();		
			
			this.quitarTipoNovedadNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoNovedadNomis()throws Exception {				
		 try {	
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSaves(tiponovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoNovedadNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNovedadNomi tiponovedadnomiLocal:tiponovedadnomis) {				
				if(tiponovedadnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToSave(tiponovedadnomiLocal,this.arrDatoGeneral);
	        	
				TipoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponovedadnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNovedadNomi(tiponovedadnomiLocal)) {				
					TipoNovedadNomiDataAccess.save(tiponovedadnomiLocal, connexion);				
				} else {
					validadoTodosTipoNovedadNomi=false;
				}
			}
			
			if(!validadoTodosTipoNovedadNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNovedadNomiLogicAdditional.checkTipoNovedadNomiToSavesAfter(tiponovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoNovedadNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNovedadNomiParameterReturnGeneral procesarAccionTipoNovedadNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNovedadNomi> tiponovedadnomis,TipoNovedadNomiParameterReturnGeneral tiponovedadnomiParameterGeneral)throws Exception {
		 try {	
			TipoNovedadNomiParameterReturnGeneral tiponovedadnomiReturnGeneral=new TipoNovedadNomiParameterReturnGeneral();
	
			TipoNovedadNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponovedadnomis,tiponovedadnomiParameterGeneral,tiponovedadnomiReturnGeneral);
			
			return tiponovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNovedadNomiParameterReturnGeneral procesarAccionTipoNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNovedadNomi> tiponovedadnomis,TipoNovedadNomiParameterReturnGeneral tiponovedadnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-procesarAccionTipoNovedadNomisWithConnection");connexion.begin();			
			
			TipoNovedadNomiParameterReturnGeneral tiponovedadnomiReturnGeneral=new TipoNovedadNomiParameterReturnGeneral();
	
			TipoNovedadNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponovedadnomis,tiponovedadnomiParameterGeneral,tiponovedadnomiReturnGeneral);
			
			this.connexion.commit();
			
			return tiponovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNovedadNomiParameterReturnGeneral procesarEventosTipoNovedadNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNovedadNomi> tiponovedadnomis,TipoNovedadNomi tiponovedadnomi,TipoNovedadNomiParameterReturnGeneral tiponovedadnomiParameterGeneral,Boolean isEsNuevoTipoNovedadNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoNovedadNomiParameterReturnGeneral tiponovedadnomiReturnGeneral=new TipoNovedadNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponovedadnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNovedadNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponovedadnomis,tiponovedadnomi,tiponovedadnomiParameterGeneral,tiponovedadnomiReturnGeneral,isEsNuevoTipoNovedadNomi,clases);
			
			return tiponovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoNovedadNomiParameterReturnGeneral procesarEventosTipoNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNovedadNomi> tiponovedadnomis,TipoNovedadNomi tiponovedadnomi,TipoNovedadNomiParameterReturnGeneral tiponovedadnomiParameterGeneral,Boolean isEsNuevoTipoNovedadNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-procesarEventosTipoNovedadNomisWithConnection");connexion.begin();			
			
			TipoNovedadNomiParameterReturnGeneral tiponovedadnomiReturnGeneral=new TipoNovedadNomiParameterReturnGeneral();
	
			tiponovedadnomiReturnGeneral.setTipoNovedadNomi(tiponovedadnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponovedadnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNovedadNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponovedadnomis,tiponovedadnomi,tiponovedadnomiParameterGeneral,tiponovedadnomiReturnGeneral,isEsNuevoTipoNovedadNomi,clases);
			
			this.connexion.commit();
			
			return tiponovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNovedadNomiParameterReturnGeneral procesarImportacionTipoNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoNovedadNomiParameterReturnGeneral tiponovedadnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-procesarImportacionTipoNovedadNomisWithConnection");connexion.begin();			
			
			TipoNovedadNomiParameterReturnGeneral tiponovedadnomiReturnGeneral=new TipoNovedadNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiponovedadnomis=new ArrayList<TipoNovedadNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiponovedadnomi=new TipoNovedadNomi();
				
				
				if(conColumnasBase) {this.tiponovedadnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiponovedadnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiponovedadnomi.setcodigo(arrColumnas[iColumn++]);
				this.tiponovedadnomi.setnombre(arrColumnas[iColumn++]);
				
				this.tiponovedadnomis.add(this.tiponovedadnomi);
			}
			
			this.saveTipoNovedadNomis();
			
			this.connexion.commit();
			
			tiponovedadnomiReturnGeneral.setConRetornoEstaProcesado(true);
			tiponovedadnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiponovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoNovedadNomisEliminados() throws Exception {				
		
		List<TipoNovedadNomi> tiponovedadnomisAux= new ArrayList<TipoNovedadNomi>();
		
		for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis) {
			if(!tiponovedadnomi.getIsDeleted()) {
				tiponovedadnomisAux.add(tiponovedadnomi);
			}
		}
		
		tiponovedadnomis=tiponovedadnomisAux;
	}
	
	public void quitarTipoNovedadNomisNulos() throws Exception {				
		
		List<TipoNovedadNomi> tiponovedadnomisAux= new ArrayList<TipoNovedadNomi>();
		
		for(TipoNovedadNomi tiponovedadnomi : this.tiponovedadnomis) {
			if(tiponovedadnomi==null) {
				tiponovedadnomisAux.add(tiponovedadnomi);
			}
		}
		
		//this.tiponovedadnomis=tiponovedadnomisAux;
		
		this.tiponovedadnomis.removeAll(tiponovedadnomisAux);
	}
	
	public void getSetVersionRowTipoNovedadNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiponovedadnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiponovedadnomi.getIsDeleted() || (tiponovedadnomi.getIsChanged()&&!tiponovedadnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiponovedadnomiDataAccess.getSetVersionRowTipoNovedadNomi(connexion,tiponovedadnomi.getId());
				
				if(!tiponovedadnomi.getVersionRow().equals(timestamp)) {	
					tiponovedadnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiponovedadnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoNovedadNomi()throws Exception {	
		
		if(tiponovedadnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiponovedadnomi.getIsDeleted() || (tiponovedadnomi.getIsChanged()&&!tiponovedadnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiponovedadnomiDataAccess.getSetVersionRowTipoNovedadNomi(connexion,tiponovedadnomi.getId());
			
			try {							
				if(!tiponovedadnomi.getVersionRow().equals(timestamp)) {	
					tiponovedadnomi.setVersionRow(timestamp);
				}
				
				tiponovedadnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoNovedadNomisWithConnection()throws Exception {	
		if(tiponovedadnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoNovedadNomi tiponovedadnomiAux:tiponovedadnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiponovedadnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponovedadnomiAux.getIsDeleted() || (tiponovedadnomiAux.getIsChanged()&&!tiponovedadnomiAux.getIsNew())) {
						
						timestamp=tiponovedadnomiDataAccess.getSetVersionRowTipoNovedadNomi(connexion,tiponovedadnomiAux.getId());
						
						if(!tiponovedadnomi.getVersionRow().equals(timestamp)) {	
							tiponovedadnomiAux.setVersionRow(timestamp);
						}
								
						tiponovedadnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoNovedadNomis()throws Exception {	
		if(tiponovedadnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoNovedadNomi tiponovedadnomiAux:tiponovedadnomis) {
					if(tiponovedadnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponovedadnomiAux.getIsDeleted() || (tiponovedadnomiAux.getIsChanged()&&!tiponovedadnomiAux.getIsNew())) {
						
						timestamp=tiponovedadnomiDataAccess.getSetVersionRowTipoNovedadNomi(connexion,tiponovedadnomiAux.getId());
						
						if(!tiponovedadnomiAux.getVersionRow().equals(timestamp)) {	
							tiponovedadnomiAux.setVersionRow(timestamp);
						}
						
													
						tiponovedadnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoNovedadNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NovedadNomiLogic novedadnomiLogic=new NovedadNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNovedadNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoNovedadNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NovedadNomi.class));
											
			

			novedadnomiLogic.setConnexion(this.getConnexion());
			novedadnomiLogic.setDatosCliente(this.datosCliente);
			novedadnomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoNovedadNomi tiponovedadnomi:this.tiponovedadnomis) {
				

				classes=new ArrayList<Classe>();
				classes=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadnomiLogic.setNovedadNomis(tiponovedadnomi.novedadnomis);
				novedadnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoNovedadNomi tiponovedadnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToGet(tiponovedadnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiponovedadnomi.setNovedadNomis(tiponovedadnomiDataAccess.getNovedadNomis(connexion,tiponovedadnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponovedadnomi.setNovedadNomis(tiponovedadnomiDataAccess.getNovedadNomis(connexion,tiponovedadnomi));

				if(this.isConDeep) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(this.connexion);
					novedadnomiLogic.setNovedadNomis(tiponovedadnomi.getNovedadNomis());
					ArrayList<Classe> classesLocal=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(novedadnomiLogic.getNovedadNomis());
					tiponovedadnomi.setNovedadNomis(novedadnomiLogic.getNovedadNomis());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadNomi.class));
			tiponovedadnomi.setNovedadNomis(tiponovedadnomiDataAccess.getNovedadNomis(connexion,tiponovedadnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiponovedadnomi.setNovedadNomis(tiponovedadnomiDataAccess.getNovedadNomis(connexion,tiponovedadnomi));

		for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
			NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
			novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponovedadnomi.setNovedadNomis(tiponovedadnomiDataAccess.getNovedadNomis(connexion,tiponovedadnomi));

				for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
					novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadNomi.class));
			tiponovedadnomi.setNovedadNomis(tiponovedadnomiDataAccess.getNovedadNomis(connexion,tiponovedadnomi));

			for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
				NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
				novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoNovedadNomi tiponovedadnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoNovedadNomiLogicAdditional.updateTipoNovedadNomiToSave(tiponovedadnomi,this.arrDatoGeneral);
			
TipoNovedadNomiDataAccess.save(tiponovedadnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
			novedadnomi.setid_tipo_novedad_nomi(tiponovedadnomi.getId());
			NovedadNomiDataAccess.save(novedadnomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
					novedadnomi.setid_tipo_novedad_nomi(tiponovedadnomi.getId());
					NovedadNomiDataAccess.save(novedadnomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
			NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
			novedadnomi.setid_tipo_novedad_nomi(tiponovedadnomi.getId());
			NovedadNomiDataAccess.save(novedadnomi,connexion);
			novedadnomiLogic.deepSave(novedadnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadNomi novedadnomi:tiponovedadnomi.getNovedadNomis()) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
					novedadnomi.setid_tipo_novedad_nomi(tiponovedadnomi.getId());
					NovedadNomiDataAccess.save(novedadnomi,connexion);
					novedadnomiLogic.deepSave(novedadnomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoNovedadNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiponovedadnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(tiponovedadnomi);
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
			this.deepLoad(this.tiponovedadnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(this.tiponovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoNovedadNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiponovedadnomis!=null) {
				for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis) {
					this.deepLoad(tiponovedadnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(tiponovedadnomis);
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
			if(tiponovedadnomis!=null) {
				for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis) {
					this.deepLoad(tiponovedadnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoNovedadNomi(tiponovedadnomis);
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
			this.getNewConnexionToDeep(TipoNovedadNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiponovedadnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoNovedadNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiponovedadnomis!=null) {
				for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis) {
					this.deepSave(tiponovedadnomi,isDeep,deepLoadType,clases);
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
			if(tiponovedadnomis!=null) {
				for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis) {
					this.deepSave(tiponovedadnomi,isDeep,deepLoadType,clases);
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
			if(TipoNovedadNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNovedadNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoNovedadNomi tiponovedadnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoNovedadNomiConstantesFunciones.ISCONAUDITORIA) {
				if(tiponovedadnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNovedadNomiDataAccess.TABLENAME, tiponovedadnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNovedadNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNovedadNomiLogic.registrarAuditoriaDetallesTipoNovedadNomi(connexion,tiponovedadnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiponovedadnomi.getIsDeleted()) {
					/*if(!tiponovedadnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoNovedadNomiDataAccess.TABLENAME, tiponovedadnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoNovedadNomiLogic.registrarAuditoriaDetallesTipoNovedadNomi(connexion,tiponovedadnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNovedadNomiDataAccess.TABLENAME, tiponovedadnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiponovedadnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNovedadNomiDataAccess.TABLENAME, tiponovedadnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNovedadNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNovedadNomiLogic.registrarAuditoriaDetallesTipoNovedadNomi(connexion,tiponovedadnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoNovedadNomi(Connexion connexion,TipoNovedadNomi tiponovedadnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiponovedadnomi.getIsNew()||!tiponovedadnomi.getcodigo().equals(tiponovedadnomi.getTipoNovedadNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponovedadnomi.getTipoNovedadNomiOriginal().getcodigo()!=null)
				{
					strValorActual=tiponovedadnomi.getTipoNovedadNomiOriginal().getcodigo();
				}
				if(tiponovedadnomi.getcodigo()!=null)
				{
					strValorNuevo=tiponovedadnomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNovedadNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiponovedadnomi.getIsNew()||!tiponovedadnomi.getnombre().equals(tiponovedadnomi.getTipoNovedadNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponovedadnomi.getTipoNovedadNomiOriginal().getnombre()!=null)
				{
					strValorActual=tiponovedadnomi.getTipoNovedadNomiOriginal().getnombre();
				}
				if(tiponovedadnomi.getnombre()!=null)
				{
					strValorNuevo=tiponovedadnomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNovedadNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoNovedadNomiRelacionesWithConnection(TipoNovedadNomi tiponovedadnomi,List<NovedadNomi> novedadnomis) throws Exception {

		if(!tiponovedadnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNovedadNomiRelacionesBase(tiponovedadnomi,novedadnomis,true);
		}
	}

	public void saveTipoNovedadNomiRelaciones(TipoNovedadNomi tiponovedadnomi,List<NovedadNomi> novedadnomis)throws Exception {

		if(!tiponovedadnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNovedadNomiRelacionesBase(tiponovedadnomi,novedadnomis,false);
		}
	}

	public void saveTipoNovedadNomiRelacionesBase(TipoNovedadNomi tiponovedadnomi,List<NovedadNomi> novedadnomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoNovedadNomi-saveRelacionesWithConnection");}
	
			tiponovedadnomi.setNovedadNomis(novedadnomis);

			this.setTipoNovedadNomi(tiponovedadnomi);

				if((tiponovedadnomi.getIsNew()||tiponovedadnomi.getIsChanged())&&!tiponovedadnomi.getIsDeleted()) {
					this.saveTipoNovedadNomi();
					this.saveTipoNovedadNomiRelacionesDetalles(novedadnomis);

				} else if(tiponovedadnomi.getIsDeleted()) {
					this.saveTipoNovedadNomiRelacionesDetalles(novedadnomis);
					this.saveTipoNovedadNomi();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			NovedadNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedadNomis(novedadnomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoNovedadNomiRelacionesDetalles(List<NovedadNomi> novedadnomis)throws Exception {
		try {
	

			Long idTipoNovedadNomiActual=this.getTipoNovedadNomi().getId();

			NovedadNomiLogic novedadnomiLogic_Desde_TipoNovedadNomi=new NovedadNomiLogic();
			novedadnomiLogic_Desde_TipoNovedadNomi.setNovedadNomis(novedadnomis);

			novedadnomiLogic_Desde_TipoNovedadNomi.setConnexion(this.getConnexion());
			novedadnomiLogic_Desde_TipoNovedadNomi.setDatosCliente(this.datosCliente);

			for(NovedadNomi novedadnomi_Desde_TipoNovedadNomi:novedadnomiLogic_Desde_TipoNovedadNomi.getNovedadNomis()) {
				novedadnomi_Desde_TipoNovedadNomi.setid_tipo_novedad_nomi(idTipoNovedadNomiActual);
			}

			novedadnomiLogic_Desde_TipoNovedadNomi.saveNovedadNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNovedadNomiConstantesFunciones.getClassesForeignKeysOfTipoNovedadNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNovedadNomiConstantesFunciones.getClassesRelationshipsOfTipoNovedadNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
