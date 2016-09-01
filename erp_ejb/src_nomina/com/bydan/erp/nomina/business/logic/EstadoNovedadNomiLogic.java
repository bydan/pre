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
import com.bydan.erp.nomina.util.EstadoNovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoNovedadNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoNovedadNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoNovedadNomi;
import com.bydan.erp.nomina.business.logic.EstadoNovedadNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoNovedadNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoNovedadNomiLogic.class);
	
	protected EstadoNovedadNomiDataAccess estadonovedadnomiDataAccess; 	
	protected EstadoNovedadNomi estadonovedadnomi;
	protected List<EstadoNovedadNomi> estadonovedadnomis;
	protected Object estadonovedadnomiObject;	
	protected List<Object> estadonovedadnomisObject;
	
	public static ClassValidator<EstadoNovedadNomi> estadonovedadnomiValidator = new ClassValidator<EstadoNovedadNomi>(EstadoNovedadNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoNovedadNomiLogicAdditional estadonovedadnomiLogicAdditional=null;
	
	public EstadoNovedadNomiLogicAdditional getEstadoNovedadNomiLogicAdditional() {
		return this.estadonovedadnomiLogicAdditional;
	}
	
	public void setEstadoNovedadNomiLogicAdditional(EstadoNovedadNomiLogicAdditional estadonovedadnomiLogicAdditional) {
		try {
			this.estadonovedadnomiLogicAdditional=estadonovedadnomiLogicAdditional;
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
	
	
	
	
	public  EstadoNovedadNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadonovedadnomiDataAccess = new EstadoNovedadNomiDataAccess();
			
			this.estadonovedadnomis= new ArrayList<EstadoNovedadNomi>();
			this.estadonovedadnomi= new EstadoNovedadNomi();
			
			this.estadonovedadnomiObject=new Object();
			this.estadonovedadnomisObject=new ArrayList<Object>();
				
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
			
			this.estadonovedadnomiDataAccess.setConnexionType(this.connexionType);
			this.estadonovedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoNovedadNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadonovedadnomiDataAccess = new EstadoNovedadNomiDataAccess();
			this.estadonovedadnomis= new ArrayList<EstadoNovedadNomi>();
			this.estadonovedadnomi= new EstadoNovedadNomi();
			this.estadonovedadnomiObject=new Object();
			this.estadonovedadnomisObject=new ArrayList<Object>();
			
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
			
			this.estadonovedadnomiDataAccess.setConnexionType(this.connexionType);
			this.estadonovedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoNovedadNomi getEstadoNovedadNomi() throws Exception {	
		EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToGet(estadonovedadnomi,this.datosCliente,this.arrDatoGeneral);
		EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToGet(estadonovedadnomi,this.arrDatoGeneral);
		
		return estadonovedadnomi;
	}
		
	public void setEstadoNovedadNomi(EstadoNovedadNomi newEstadoNovedadNomi) {
		this.estadonovedadnomi = newEstadoNovedadNomi;
	}
	
	public EstadoNovedadNomiDataAccess getEstadoNovedadNomiDataAccess() {
		return estadonovedadnomiDataAccess;
	}
	
	public void setEstadoNovedadNomiDataAccess(EstadoNovedadNomiDataAccess newestadonovedadnomiDataAccess) {
		this.estadonovedadnomiDataAccess = newestadonovedadnomiDataAccess;
	}
	
	public List<EstadoNovedadNomi> getEstadoNovedadNomis() throws Exception {		
		this.quitarEstadoNovedadNomisNulos();
		
		EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToGets(estadonovedadnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoNovedadNomi estadonovedadnomiLocal: estadonovedadnomis ) {
			EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToGet(estadonovedadnomiLocal,this.arrDatoGeneral);
		}
		
		return estadonovedadnomis;
	}
	
	public void setEstadoNovedadNomis(List<EstadoNovedadNomi> newEstadoNovedadNomis) {
		this.estadonovedadnomis = newEstadoNovedadNomis;
	}
	
	public Object getEstadoNovedadNomiObject() {	
		this.estadonovedadnomiObject=this.estadonovedadnomiDataAccess.getEntityObject();
		return this.estadonovedadnomiObject;
	}
		
	public void setEstadoNovedadNomiObject(Object newEstadoNovedadNomiObject) {
		this.estadonovedadnomiObject = newEstadoNovedadNomiObject;
	}
	
	public List<Object> getEstadoNovedadNomisObject() {		
		this.estadonovedadnomisObject=this.estadonovedadnomiDataAccess.getEntitiesObject();
		return this.estadonovedadnomisObject;
	}
		
	public void setEstadoNovedadNomisObject(List<Object> newEstadoNovedadNomisObject) {
		this.estadonovedadnomisObject = newEstadoNovedadNomisObject;
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
		
		if(this.estadonovedadnomiDataAccess!=null) {
			this.estadonovedadnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadonovedadnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadonovedadnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadonovedadnomi = new  EstadoNovedadNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		  		  
        try {
			
			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadonovedadnomi = new  EstadoNovedadNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		  		  
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		  		  
        try {
			
			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadonovedadnomi = new  EstadoNovedadNomi();
		  		  
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadonovedadnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadonovedadnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadonovedadnomi = new  EstadoNovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadonovedadnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadonovedadnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadonovedadnomi = new  EstadoNovedadNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadonovedadnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadonovedadnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
        try {			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
        try {
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadonovedadnomi = new  EstadoNovedadNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
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
		estadonovedadnomi = new  EstadoNovedadNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
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
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		  		  
        try {
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoNovedadNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-getTodosEstadoNovedadNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
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
	
	public  void  getTodosEstadoNovedadNomis(String sFinalQuery,Pagination pagination)throws Exception {
		estadonovedadnomis = new  ArrayList<EstadoNovedadNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadnomis=estadonovedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoNovedadNomi(estadonovedadnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(estadonovedadnomi.getIsNew() || estadonovedadnomi.getIsChanged()) { 
			this.invalidValues = estadonovedadnomiValidator.getInvalidValues(estadonovedadnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadonovedadnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoNovedadNomi(List<EstadoNovedadNomi> EstadoNovedadNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoNovedadNomi estadonovedadnomiLocal:estadonovedadnomis) {				
			estaValidadoObjeto=this.validarGuardarEstadoNovedadNomi(estadonovedadnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoNovedadNomi(List<EstadoNovedadNomi> EstadoNovedadNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoNovedadNomi(estadonovedadnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoNovedadNomi(EstadoNovedadNomi EstadoNovedadNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoNovedadNomi(estadonovedadnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoNovedadNomi estadonovedadnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadonovedadnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoNovedadNomiConstantesFunciones.getEstadoNovedadNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadonovedadnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoNovedadNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoNovedadNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoNovedadNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-saveEstadoNovedadNomiWithConnection");connexion.begin();			
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSave(this.estadonovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToSave(this.estadonovedadnomi,this.arrDatoGeneral);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadonovedadnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoNovedadNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoNovedadNomi(this.estadonovedadnomi)) {
				EstadoNovedadNomiDataAccess.save(this.estadonovedadnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadonovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSaveAfter(this.estadonovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoNovedadNomi();
			
			connexion.commit();			
			
			if(this.estadonovedadnomi.getIsDeleted()) {
				this.estadonovedadnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoNovedadNomi()throws Exception {	
		try {	
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSave(this.estadonovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToSave(this.estadonovedadnomi,this.arrDatoGeneral);
			
			EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadonovedadnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoNovedadNomi(this.estadonovedadnomi)) {			
				EstadoNovedadNomiDataAccess.save(this.estadonovedadnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadonovedadnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSaveAfter(this.estadonovedadnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadonovedadnomi.getIsDeleted()) {
				this.estadonovedadnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoNovedadNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-saveEstadoNovedadNomisWithConnection");connexion.begin();			
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSaves(estadonovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoNovedadNomis();
			
			Boolean validadoTodosEstadoNovedadNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoNovedadNomi estadonovedadnomiLocal:estadonovedadnomis) {		
				if(estadonovedadnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToSave(estadonovedadnomiLocal,this.arrDatoGeneral);
	        	
				EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadonovedadnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoNovedadNomi(estadonovedadnomiLocal)) {
					EstadoNovedadNomiDataAccess.save(estadonovedadnomiLocal, connexion);				
				} else {
					validadoTodosEstadoNovedadNomi=false;
				}
			}
			
			if(!validadoTodosEstadoNovedadNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSavesAfter(estadonovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoNovedadNomis();
			
			connexion.commit();		
			
			this.quitarEstadoNovedadNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoNovedadNomis()throws Exception {				
		 try {	
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSaves(estadonovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoNovedadNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoNovedadNomi estadonovedadnomiLocal:estadonovedadnomis) {				
				if(estadonovedadnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToSave(estadonovedadnomiLocal,this.arrDatoGeneral);
	        	
				EstadoNovedadNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadonovedadnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoNovedadNomi(estadonovedadnomiLocal)) {				
					EstadoNovedadNomiDataAccess.save(estadonovedadnomiLocal, connexion);				
				} else {
					validadoTodosEstadoNovedadNomi=false;
				}
			}
			
			if(!validadoTodosEstadoNovedadNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoNovedadNomiLogicAdditional.checkEstadoNovedadNomiToSavesAfter(estadonovedadnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoNovedadNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoNovedadNomiParameterReturnGeneral procesarAccionEstadoNovedadNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoNovedadNomi> estadonovedadnomis,EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiParameterGeneral)throws Exception {
		 try {	
			EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiReturnGeneral=new EstadoNovedadNomiParameterReturnGeneral();
	
			EstadoNovedadNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadonovedadnomis,estadonovedadnomiParameterGeneral,estadonovedadnomiReturnGeneral);
			
			return estadonovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoNovedadNomiParameterReturnGeneral procesarAccionEstadoNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoNovedadNomi> estadonovedadnomis,EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-procesarAccionEstadoNovedadNomisWithConnection");connexion.begin();			
			
			EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiReturnGeneral=new EstadoNovedadNomiParameterReturnGeneral();
	
			EstadoNovedadNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadonovedadnomis,estadonovedadnomiParameterGeneral,estadonovedadnomiReturnGeneral);
			
			this.connexion.commit();
			
			return estadonovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoNovedadNomiParameterReturnGeneral procesarEventosEstadoNovedadNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoNovedadNomi> estadonovedadnomis,EstadoNovedadNomi estadonovedadnomi,EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiParameterGeneral,Boolean isEsNuevoEstadoNovedadNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiReturnGeneral=new EstadoNovedadNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadonovedadnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoNovedadNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadonovedadnomis,estadonovedadnomi,estadonovedadnomiParameterGeneral,estadonovedadnomiReturnGeneral,isEsNuevoEstadoNovedadNomi,clases);
			
			return estadonovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoNovedadNomiParameterReturnGeneral procesarEventosEstadoNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoNovedadNomi> estadonovedadnomis,EstadoNovedadNomi estadonovedadnomi,EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiParameterGeneral,Boolean isEsNuevoEstadoNovedadNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-procesarEventosEstadoNovedadNomisWithConnection");connexion.begin();			
			
			EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiReturnGeneral=new EstadoNovedadNomiParameterReturnGeneral();
	
			estadonovedadnomiReturnGeneral.setEstadoNovedadNomi(estadonovedadnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadonovedadnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoNovedadNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadonovedadnomis,estadonovedadnomi,estadonovedadnomiParameterGeneral,estadonovedadnomiReturnGeneral,isEsNuevoEstadoNovedadNomi,clases);
			
			this.connexion.commit();
			
			return estadonovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoNovedadNomiParameterReturnGeneral procesarImportacionEstadoNovedadNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-procesarImportacionEstadoNovedadNomisWithConnection");connexion.begin();			
			
			EstadoNovedadNomiParameterReturnGeneral estadonovedadnomiReturnGeneral=new EstadoNovedadNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadonovedadnomis=new ArrayList<EstadoNovedadNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadonovedadnomi=new EstadoNovedadNomi();
				
				
				if(conColumnasBase) {this.estadonovedadnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadonovedadnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadonovedadnomi.setcodigo(arrColumnas[iColumn++]);
				this.estadonovedadnomi.setnombre(arrColumnas[iColumn++]);
				
				this.estadonovedadnomis.add(this.estadonovedadnomi);
			}
			
			this.saveEstadoNovedadNomis();
			
			this.connexion.commit();
			
			estadonovedadnomiReturnGeneral.setConRetornoEstaProcesado(true);
			estadonovedadnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadonovedadnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoNovedadNomisEliminados() throws Exception {				
		
		List<EstadoNovedadNomi> estadonovedadnomisAux= new ArrayList<EstadoNovedadNomi>();
		
		for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis) {
			if(!estadonovedadnomi.getIsDeleted()) {
				estadonovedadnomisAux.add(estadonovedadnomi);
			}
		}
		
		estadonovedadnomis=estadonovedadnomisAux;
	}
	
	public void quitarEstadoNovedadNomisNulos() throws Exception {				
		
		List<EstadoNovedadNomi> estadonovedadnomisAux= new ArrayList<EstadoNovedadNomi>();
		
		for(EstadoNovedadNomi estadonovedadnomi : this.estadonovedadnomis) {
			if(estadonovedadnomi==null) {
				estadonovedadnomisAux.add(estadonovedadnomi);
			}
		}
		
		//this.estadonovedadnomis=estadonovedadnomisAux;
		
		this.estadonovedadnomis.removeAll(estadonovedadnomisAux);
	}
	
	public void getSetVersionRowEstadoNovedadNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadonovedadnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadonovedadnomi.getIsDeleted() || (estadonovedadnomi.getIsChanged()&&!estadonovedadnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadonovedadnomiDataAccess.getSetVersionRowEstadoNovedadNomi(connexion,estadonovedadnomi.getId());
				
				if(!estadonovedadnomi.getVersionRow().equals(timestamp)) {	
					estadonovedadnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadonovedadnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoNovedadNomi()throws Exception {	
		
		if(estadonovedadnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadonovedadnomi.getIsDeleted() || (estadonovedadnomi.getIsChanged()&&!estadonovedadnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadonovedadnomiDataAccess.getSetVersionRowEstadoNovedadNomi(connexion,estadonovedadnomi.getId());
			
			try {							
				if(!estadonovedadnomi.getVersionRow().equals(timestamp)) {	
					estadonovedadnomi.setVersionRow(timestamp);
				}
				
				estadonovedadnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoNovedadNomisWithConnection()throws Exception {	
		if(estadonovedadnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoNovedadNomi estadonovedadnomiAux:estadonovedadnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadonovedadnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadonovedadnomiAux.getIsDeleted() || (estadonovedadnomiAux.getIsChanged()&&!estadonovedadnomiAux.getIsNew())) {
						
						timestamp=estadonovedadnomiDataAccess.getSetVersionRowEstadoNovedadNomi(connexion,estadonovedadnomiAux.getId());
						
						if(!estadonovedadnomi.getVersionRow().equals(timestamp)) {	
							estadonovedadnomiAux.setVersionRow(timestamp);
						}
								
						estadonovedadnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoNovedadNomis()throws Exception {	
		if(estadonovedadnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoNovedadNomi estadonovedadnomiAux:estadonovedadnomis) {
					if(estadonovedadnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadonovedadnomiAux.getIsDeleted() || (estadonovedadnomiAux.getIsChanged()&&!estadonovedadnomiAux.getIsNew())) {
						
						timestamp=estadonovedadnomiDataAccess.getSetVersionRowEstadoNovedadNomi(connexion,estadonovedadnomiAux.getId());
						
						if(!estadonovedadnomiAux.getVersionRow().equals(timestamp)) {	
							estadonovedadnomiAux.setVersionRow(timestamp);
						}
						
													
						estadonovedadnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoNovedadNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NovedadNomiLogic novedadnomiLogic=new NovedadNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoNovedadNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NovedadNomi.class));
											
			

			novedadnomiLogic.setConnexion(this.getConnexion());
			novedadnomiLogic.setDatosCliente(this.datosCliente);
			novedadnomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoNovedadNomi estadonovedadnomi:this.estadonovedadnomis) {
				

				classes=new ArrayList<Classe>();
				classes=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadnomiLogic.setNovedadNomis(estadonovedadnomi.novedadnomis);
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
	
	public void deepLoad(EstadoNovedadNomi estadonovedadnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToGet(estadonovedadnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadonovedadnomi.setNovedadNomis(estadonovedadnomiDataAccess.getNovedadNomis(connexion,estadonovedadnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadonovedadnomi.setNovedadNomis(estadonovedadnomiDataAccess.getNovedadNomis(connexion,estadonovedadnomi));

				if(this.isConDeep) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(this.connexion);
					novedadnomiLogic.setNovedadNomis(estadonovedadnomi.getNovedadNomis());
					ArrayList<Classe> classesLocal=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(novedadnomiLogic.getNovedadNomis());
					estadonovedadnomi.setNovedadNomis(novedadnomiLogic.getNovedadNomis());
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
			estadonovedadnomi.setNovedadNomis(estadonovedadnomiDataAccess.getNovedadNomis(connexion,estadonovedadnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadonovedadnomi.setNovedadNomis(estadonovedadnomiDataAccess.getNovedadNomis(connexion,estadonovedadnomi));

		for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
			NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
			novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadonovedadnomi.setNovedadNomis(estadonovedadnomiDataAccess.getNovedadNomis(connexion,estadonovedadnomi));

				for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
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
			estadonovedadnomi.setNovedadNomis(estadonovedadnomiDataAccess.getNovedadNomis(connexion,estadonovedadnomi));

			for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
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
	
	public void deepSave(EstadoNovedadNomi estadonovedadnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoNovedadNomiLogicAdditional.updateEstadoNovedadNomiToSave(estadonovedadnomi,this.arrDatoGeneral);
			
EstadoNovedadNomiDataAccess.save(estadonovedadnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
			novedadnomi.setid_estado_novedad_nomi(estadonovedadnomi.getId());
			NovedadNomiDataAccess.save(novedadnomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
					novedadnomi.setid_estado_novedad_nomi(estadonovedadnomi.getId());
					NovedadNomiDataAccess.save(novedadnomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
			NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
			novedadnomi.setid_estado_novedad_nomi(estadonovedadnomi.getId());
			NovedadNomiDataAccess.save(novedadnomi,connexion);
			novedadnomiLogic.deepSave(novedadnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadNomi novedadnomi:estadonovedadnomi.getNovedadNomis()) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
					novedadnomi.setid_estado_novedad_nomi(estadonovedadnomi.getId());
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
			this.getNewConnexionToDeep(EstadoNovedadNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadonovedadnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(estadonovedadnomi);
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
			this.deepLoad(this.estadonovedadnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(this.estadonovedadnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoNovedadNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadonovedadnomis!=null) {
				for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis) {
					this.deepLoad(estadonovedadnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(estadonovedadnomis);
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
			if(estadonovedadnomis!=null) {
				for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis) {
					this.deepLoad(estadonovedadnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoNovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadNomi(estadonovedadnomis);
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
			this.getNewConnexionToDeep(EstadoNovedadNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadonovedadnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoNovedadNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadonovedadnomis!=null) {
				for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis) {
					this.deepSave(estadonovedadnomi,isDeep,deepLoadType,clases);
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
			if(estadonovedadnomis!=null) {
				for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis) {
					this.deepSave(estadonovedadnomi,isDeep,deepLoadType,clases);
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
			if(EstadoNovedadNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoNovedadNomi estadonovedadnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoNovedadNomiConstantesFunciones.ISCONAUDITORIA) {
				if(estadonovedadnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadNomiDataAccess.TABLENAME, estadonovedadnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoNovedadNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoNovedadNomiLogic.registrarAuditoriaDetallesEstadoNovedadNomi(connexion,estadonovedadnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadonovedadnomi.getIsDeleted()) {
					/*if(!estadonovedadnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoNovedadNomiDataAccess.TABLENAME, estadonovedadnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoNovedadNomiLogic.registrarAuditoriaDetallesEstadoNovedadNomi(connexion,estadonovedadnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadNomiDataAccess.TABLENAME, estadonovedadnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadonovedadnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadNomiDataAccess.TABLENAME, estadonovedadnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoNovedadNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoNovedadNomiLogic.registrarAuditoriaDetallesEstadoNovedadNomi(connexion,estadonovedadnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoNovedadNomi(Connexion connexion,EstadoNovedadNomi estadonovedadnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadonovedadnomi.getIsNew()||!estadonovedadnomi.getcodigo().equals(estadonovedadnomi.getEstadoNovedadNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadonovedadnomi.getEstadoNovedadNomiOriginal().getcodigo()!=null)
				{
					strValorActual=estadonovedadnomi.getEstadoNovedadNomiOriginal().getcodigo();
				}
				if(estadonovedadnomi.getcodigo()!=null)
				{
					strValorNuevo=estadonovedadnomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoNovedadNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadonovedadnomi.getIsNew()||!estadonovedadnomi.getnombre().equals(estadonovedadnomi.getEstadoNovedadNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadonovedadnomi.getEstadoNovedadNomiOriginal().getnombre()!=null)
				{
					strValorActual=estadonovedadnomi.getEstadoNovedadNomiOriginal().getnombre();
				}
				if(estadonovedadnomi.getnombre()!=null)
				{
					strValorNuevo=estadonovedadnomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoNovedadNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoNovedadNomiRelacionesWithConnection(EstadoNovedadNomi estadonovedadnomi,List<NovedadNomi> novedadnomis) throws Exception {

		if(!estadonovedadnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoNovedadNomiRelacionesBase(estadonovedadnomi,novedadnomis,true);
		}
	}

	public void saveEstadoNovedadNomiRelaciones(EstadoNovedadNomi estadonovedadnomi,List<NovedadNomi> novedadnomis)throws Exception {

		if(!estadonovedadnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoNovedadNomiRelacionesBase(estadonovedadnomi,novedadnomis,false);
		}
	}

	public void saveEstadoNovedadNomiRelacionesBase(EstadoNovedadNomi estadonovedadnomi,List<NovedadNomi> novedadnomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoNovedadNomi-saveRelacionesWithConnection");}
	
			estadonovedadnomi.setNovedadNomis(novedadnomis);

			this.setEstadoNovedadNomi(estadonovedadnomi);

				if((estadonovedadnomi.getIsNew()||estadonovedadnomi.getIsChanged())&&!estadonovedadnomi.getIsDeleted()) {
					this.saveEstadoNovedadNomi();
					this.saveEstadoNovedadNomiRelacionesDetalles(novedadnomis);

				} else if(estadonovedadnomi.getIsDeleted()) {
					this.saveEstadoNovedadNomiRelacionesDetalles(novedadnomis);
					this.saveEstadoNovedadNomi();
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
	
	
	private void saveEstadoNovedadNomiRelacionesDetalles(List<NovedadNomi> novedadnomis)throws Exception {
		try {
	

			Long idEstadoNovedadNomiActual=this.getEstadoNovedadNomi().getId();

			NovedadNomiLogic novedadnomiLogic_Desde_EstadoNovedadNomi=new NovedadNomiLogic();
			novedadnomiLogic_Desde_EstadoNovedadNomi.setNovedadNomis(novedadnomis);

			novedadnomiLogic_Desde_EstadoNovedadNomi.setConnexion(this.getConnexion());
			novedadnomiLogic_Desde_EstadoNovedadNomi.setDatosCliente(this.datosCliente);

			for(NovedadNomi novedadnomi_Desde_EstadoNovedadNomi:novedadnomiLogic_Desde_EstadoNovedadNomi.getNovedadNomis()) {
				novedadnomi_Desde_EstadoNovedadNomi.setid_estado_novedad_nomi(idEstadoNovedadNomiActual);
			}

			novedadnomiLogic_Desde_EstadoNovedadNomi.saveNovedadNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoNovedadNomiConstantesFunciones.getClassesForeignKeysOfEstadoNovedadNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoNovedadNomiConstantesFunciones.getClassesRelationshipsOfEstadoNovedadNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
