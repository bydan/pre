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
import com.bydan.erp.nomina.util.EstadoSolicitudNomiConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoSolicitudNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoSolicitudNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoSolicitudNomi;
import com.bydan.erp.nomina.business.logic.EstadoSolicitudNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoSolicitudNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoSolicitudNomiLogic.class);
	
	protected EstadoSolicitudNomiDataAccess estadosolicitudnomiDataAccess; 	
	protected EstadoSolicitudNomi estadosolicitudnomi;
	protected List<EstadoSolicitudNomi> estadosolicitudnomis;
	protected Object estadosolicitudnomiObject;	
	protected List<Object> estadosolicitudnomisObject;
	
	public static ClassValidator<EstadoSolicitudNomi> estadosolicitudnomiValidator = new ClassValidator<EstadoSolicitudNomi>(EstadoSolicitudNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoSolicitudNomiLogicAdditional estadosolicitudnomiLogicAdditional=null;
	
	public EstadoSolicitudNomiLogicAdditional getEstadoSolicitudNomiLogicAdditional() {
		return this.estadosolicitudnomiLogicAdditional;
	}
	
	public void setEstadoSolicitudNomiLogicAdditional(EstadoSolicitudNomiLogicAdditional estadosolicitudnomiLogicAdditional) {
		try {
			this.estadosolicitudnomiLogicAdditional=estadosolicitudnomiLogicAdditional;
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
	
	
	
	
	public  EstadoSolicitudNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadosolicitudnomiDataAccess = new EstadoSolicitudNomiDataAccess();
			
			this.estadosolicitudnomis= new ArrayList<EstadoSolicitudNomi>();
			this.estadosolicitudnomi= new EstadoSolicitudNomi();
			
			this.estadosolicitudnomiObject=new Object();
			this.estadosolicitudnomisObject=new ArrayList<Object>();
				
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
			
			this.estadosolicitudnomiDataAccess.setConnexionType(this.connexionType);
			this.estadosolicitudnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoSolicitudNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadosolicitudnomiDataAccess = new EstadoSolicitudNomiDataAccess();
			this.estadosolicitudnomis= new ArrayList<EstadoSolicitudNomi>();
			this.estadosolicitudnomi= new EstadoSolicitudNomi();
			this.estadosolicitudnomiObject=new Object();
			this.estadosolicitudnomisObject=new ArrayList<Object>();
			
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
			
			this.estadosolicitudnomiDataAccess.setConnexionType(this.connexionType);
			this.estadosolicitudnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoSolicitudNomi getEstadoSolicitudNomi() throws Exception {	
		EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToGet(estadosolicitudnomi,this.datosCliente,this.arrDatoGeneral);
		EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToGet(estadosolicitudnomi,this.arrDatoGeneral);
		
		return estadosolicitudnomi;
	}
		
	public void setEstadoSolicitudNomi(EstadoSolicitudNomi newEstadoSolicitudNomi) {
		this.estadosolicitudnomi = newEstadoSolicitudNomi;
	}
	
	public EstadoSolicitudNomiDataAccess getEstadoSolicitudNomiDataAccess() {
		return estadosolicitudnomiDataAccess;
	}
	
	public void setEstadoSolicitudNomiDataAccess(EstadoSolicitudNomiDataAccess newestadosolicitudnomiDataAccess) {
		this.estadosolicitudnomiDataAccess = newestadosolicitudnomiDataAccess;
	}
	
	public List<EstadoSolicitudNomi> getEstadoSolicitudNomis() throws Exception {		
		this.quitarEstadoSolicitudNomisNulos();
		
		EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToGets(estadosolicitudnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoSolicitudNomi estadosolicitudnomiLocal: estadosolicitudnomis ) {
			EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToGet(estadosolicitudnomiLocal,this.arrDatoGeneral);
		}
		
		return estadosolicitudnomis;
	}
	
	public void setEstadoSolicitudNomis(List<EstadoSolicitudNomi> newEstadoSolicitudNomis) {
		this.estadosolicitudnomis = newEstadoSolicitudNomis;
	}
	
	public Object getEstadoSolicitudNomiObject() {	
		this.estadosolicitudnomiObject=this.estadosolicitudnomiDataAccess.getEntityObject();
		return this.estadosolicitudnomiObject;
	}
		
	public void setEstadoSolicitudNomiObject(Object newEstadoSolicitudNomiObject) {
		this.estadosolicitudnomiObject = newEstadoSolicitudNomiObject;
	}
	
	public List<Object> getEstadoSolicitudNomisObject() {		
		this.estadosolicitudnomisObject=this.estadosolicitudnomiDataAccess.getEntitiesObject();
		return this.estadosolicitudnomisObject;
	}
		
	public void setEstadoSolicitudNomisObject(List<Object> newEstadoSolicitudNomisObject) {
		this.estadosolicitudnomisObject = newEstadoSolicitudNomisObject;
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
		
		if(this.estadosolicitudnomiDataAccess!=null) {
			this.estadosolicitudnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadosolicitudnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadosolicitudnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadosolicitudnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  		  
        try {
			
			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadosolicitudnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadosolicitudnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  		  
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  		  
        try {
			
			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadosolicitudnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  		  
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadosolicitudnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadosolicitudnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadosolicitudnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadosolicitudnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadosolicitudnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadosolicitudnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
        try {			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
        try {
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
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
		estadosolicitudnomi = new  EstadoSolicitudNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
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
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		  		  
        try {
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoSolicitudNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-getTodosEstadoSolicitudNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
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
	
	public  void  getTodosEstadoSolicitudNomis(String sFinalQuery,Pagination pagination)throws Exception {
		estadosolicitudnomis = new  ArrayList<EstadoSolicitudNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosolicitudnomis=estadosolicitudnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoSolicitudNomi(estadosolicitudnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(estadosolicitudnomi.getIsNew() || estadosolicitudnomi.getIsChanged()) { 
			this.invalidValues = estadosolicitudnomiValidator.getInvalidValues(estadosolicitudnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadosolicitudnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoSolicitudNomi(List<EstadoSolicitudNomi> EstadoSolicitudNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoSolicitudNomi estadosolicitudnomiLocal:estadosolicitudnomis) {				
			estaValidadoObjeto=this.validarGuardarEstadoSolicitudNomi(estadosolicitudnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoSolicitudNomi(List<EstadoSolicitudNomi> EstadoSolicitudNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoSolicitudNomi(estadosolicitudnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoSolicitudNomi(EstadoSolicitudNomi EstadoSolicitudNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoSolicitudNomi(estadosolicitudnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoSolicitudNomi estadosolicitudnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadosolicitudnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadosolicitudnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoSolicitudNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoSolicitudNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoSolicitudNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-saveEstadoSolicitudNomiWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSave(this.estadosolicitudnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToSave(this.estadosolicitudnomi,this.arrDatoGeneral);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadosolicitudnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoSolicitudNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoSolicitudNomi(this.estadosolicitudnomi)) {
				EstadoSolicitudNomiDataAccess.save(this.estadosolicitudnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadosolicitudnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSaveAfter(this.estadosolicitudnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoSolicitudNomi();
			
			connexion.commit();			
			
			if(this.estadosolicitudnomi.getIsDeleted()) {
				this.estadosolicitudnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoSolicitudNomi()throws Exception {	
		try {	
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSave(this.estadosolicitudnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToSave(this.estadosolicitudnomi,this.arrDatoGeneral);
			
			EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadosolicitudnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoSolicitudNomi(this.estadosolicitudnomi)) {			
				EstadoSolicitudNomiDataAccess.save(this.estadosolicitudnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadosolicitudnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSaveAfter(this.estadosolicitudnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadosolicitudnomi.getIsDeleted()) {
				this.estadosolicitudnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoSolicitudNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-saveEstadoSolicitudNomisWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSaves(estadosolicitudnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoSolicitudNomis();
			
			Boolean validadoTodosEstadoSolicitudNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoSolicitudNomi estadosolicitudnomiLocal:estadosolicitudnomis) {		
				if(estadosolicitudnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToSave(estadosolicitudnomiLocal,this.arrDatoGeneral);
	        	
				EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadosolicitudnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoSolicitudNomi(estadosolicitudnomiLocal)) {
					EstadoSolicitudNomiDataAccess.save(estadosolicitudnomiLocal, connexion);				
				} else {
					validadoTodosEstadoSolicitudNomi=false;
				}
			}
			
			if(!validadoTodosEstadoSolicitudNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSavesAfter(estadosolicitudnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoSolicitudNomis();
			
			connexion.commit();		
			
			this.quitarEstadoSolicitudNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoSolicitudNomis()throws Exception {				
		 try {	
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSaves(estadosolicitudnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoSolicitudNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoSolicitudNomi estadosolicitudnomiLocal:estadosolicitudnomis) {				
				if(estadosolicitudnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToSave(estadosolicitudnomiLocal,this.arrDatoGeneral);
	        	
				EstadoSolicitudNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadosolicitudnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoSolicitudNomi(estadosolicitudnomiLocal)) {				
					EstadoSolicitudNomiDataAccess.save(estadosolicitudnomiLocal, connexion);				
				} else {
					validadoTodosEstadoSolicitudNomi=false;
				}
			}
			
			if(!validadoTodosEstadoSolicitudNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoSolicitudNomiLogicAdditional.checkEstadoSolicitudNomiToSavesAfter(estadosolicitudnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoSolicitudNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoSolicitudNomiParameterReturnGeneral procesarAccionEstadoSolicitudNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoSolicitudNomi> estadosolicitudnomis,EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiParameterGeneral)throws Exception {
		 try {	
			EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiReturnGeneral=new EstadoSolicitudNomiParameterReturnGeneral();
	
			EstadoSolicitudNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadosolicitudnomis,estadosolicitudnomiParameterGeneral,estadosolicitudnomiReturnGeneral);
			
			return estadosolicitudnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoSolicitudNomiParameterReturnGeneral procesarAccionEstadoSolicitudNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoSolicitudNomi> estadosolicitudnomis,EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-procesarAccionEstadoSolicitudNomisWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiReturnGeneral=new EstadoSolicitudNomiParameterReturnGeneral();
	
			EstadoSolicitudNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadosolicitudnomis,estadosolicitudnomiParameterGeneral,estadosolicitudnomiReturnGeneral);
			
			this.connexion.commit();
			
			return estadosolicitudnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoSolicitudNomiParameterReturnGeneral procesarEventosEstadoSolicitudNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoSolicitudNomi> estadosolicitudnomis,EstadoSolicitudNomi estadosolicitudnomi,EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiParameterGeneral,Boolean isEsNuevoEstadoSolicitudNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiReturnGeneral=new EstadoSolicitudNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadosolicitudnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoSolicitudNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadosolicitudnomis,estadosolicitudnomi,estadosolicitudnomiParameterGeneral,estadosolicitudnomiReturnGeneral,isEsNuevoEstadoSolicitudNomi,clases);
			
			return estadosolicitudnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoSolicitudNomiParameterReturnGeneral procesarEventosEstadoSolicitudNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoSolicitudNomi> estadosolicitudnomis,EstadoSolicitudNomi estadosolicitudnomi,EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiParameterGeneral,Boolean isEsNuevoEstadoSolicitudNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-procesarEventosEstadoSolicitudNomisWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiReturnGeneral=new EstadoSolicitudNomiParameterReturnGeneral();
	
			estadosolicitudnomiReturnGeneral.setEstadoSolicitudNomi(estadosolicitudnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadosolicitudnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoSolicitudNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadosolicitudnomis,estadosolicitudnomi,estadosolicitudnomiParameterGeneral,estadosolicitudnomiReturnGeneral,isEsNuevoEstadoSolicitudNomi,clases);
			
			this.connexion.commit();
			
			return estadosolicitudnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoSolicitudNomiParameterReturnGeneral procesarImportacionEstadoSolicitudNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-procesarImportacionEstadoSolicitudNomisWithConnection");connexion.begin();			
			
			EstadoSolicitudNomiParameterReturnGeneral estadosolicitudnomiReturnGeneral=new EstadoSolicitudNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadosolicitudnomis=new ArrayList<EstadoSolicitudNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadosolicitudnomi=new EstadoSolicitudNomi();
				
				
				if(conColumnasBase) {this.estadosolicitudnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadosolicitudnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadosolicitudnomi.setcodigo(arrColumnas[iColumn++]);
				this.estadosolicitudnomi.setnombre(arrColumnas[iColumn++]);
				
				this.estadosolicitudnomis.add(this.estadosolicitudnomi);
			}
			
			this.saveEstadoSolicitudNomis();
			
			this.connexion.commit();
			
			estadosolicitudnomiReturnGeneral.setConRetornoEstaProcesado(true);
			estadosolicitudnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadosolicitudnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoSolicitudNomisEliminados() throws Exception {				
		
		List<EstadoSolicitudNomi> estadosolicitudnomisAux= new ArrayList<EstadoSolicitudNomi>();
		
		for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis) {
			if(!estadosolicitudnomi.getIsDeleted()) {
				estadosolicitudnomisAux.add(estadosolicitudnomi);
			}
		}
		
		estadosolicitudnomis=estadosolicitudnomisAux;
	}
	
	public void quitarEstadoSolicitudNomisNulos() throws Exception {				
		
		List<EstadoSolicitudNomi> estadosolicitudnomisAux= new ArrayList<EstadoSolicitudNomi>();
		
		for(EstadoSolicitudNomi estadosolicitudnomi : this.estadosolicitudnomis) {
			if(estadosolicitudnomi==null) {
				estadosolicitudnomisAux.add(estadosolicitudnomi);
			}
		}
		
		//this.estadosolicitudnomis=estadosolicitudnomisAux;
		
		this.estadosolicitudnomis.removeAll(estadosolicitudnomisAux);
	}
	
	public void getSetVersionRowEstadoSolicitudNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadosolicitudnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadosolicitudnomi.getIsDeleted() || (estadosolicitudnomi.getIsChanged()&&!estadosolicitudnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadosolicitudnomiDataAccess.getSetVersionRowEstadoSolicitudNomi(connexion,estadosolicitudnomi.getId());
				
				if(!estadosolicitudnomi.getVersionRow().equals(timestamp)) {	
					estadosolicitudnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadosolicitudnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoSolicitudNomi()throws Exception {	
		
		if(estadosolicitudnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadosolicitudnomi.getIsDeleted() || (estadosolicitudnomi.getIsChanged()&&!estadosolicitudnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadosolicitudnomiDataAccess.getSetVersionRowEstadoSolicitudNomi(connexion,estadosolicitudnomi.getId());
			
			try {							
				if(!estadosolicitudnomi.getVersionRow().equals(timestamp)) {	
					estadosolicitudnomi.setVersionRow(timestamp);
				}
				
				estadosolicitudnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoSolicitudNomisWithConnection()throws Exception {	
		if(estadosolicitudnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoSolicitudNomi estadosolicitudnomiAux:estadosolicitudnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadosolicitudnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadosolicitudnomiAux.getIsDeleted() || (estadosolicitudnomiAux.getIsChanged()&&!estadosolicitudnomiAux.getIsNew())) {
						
						timestamp=estadosolicitudnomiDataAccess.getSetVersionRowEstadoSolicitudNomi(connexion,estadosolicitudnomiAux.getId());
						
						if(!estadosolicitudnomi.getVersionRow().equals(timestamp)) {	
							estadosolicitudnomiAux.setVersionRow(timestamp);
						}
								
						estadosolicitudnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoSolicitudNomis()throws Exception {	
		if(estadosolicitudnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoSolicitudNomi estadosolicitudnomiAux:estadosolicitudnomis) {
					if(estadosolicitudnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadosolicitudnomiAux.getIsDeleted() || (estadosolicitudnomiAux.getIsChanged()&&!estadosolicitudnomiAux.getIsNew())) {
						
						timestamp=estadosolicitudnomiDataAccess.getSetVersionRowEstadoSolicitudNomi(connexion,estadosolicitudnomiAux.getId());
						
						if(!estadosolicitudnomiAux.getVersionRow().equals(timestamp)) {	
							estadosolicitudnomiAux.setVersionRow(timestamp);
						}
						
													
						estadosolicitudnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoSolicitudNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			SolicitudReemplazoLogic solicitudreemplazoLogic=new SolicitudReemplazoLogic();
			SolicitudHoraExtraLogic solicitudhoraextraLogic=new SolicitudHoraExtraLogic();
			SolicitudVacacionLogic solicitudvacacionLogic=new SolicitudVacacionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoSolicitudNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoSolicitudNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(SolicitudReemplazo.class));
			classes.add(new Classe(SolicitudHoraExtra.class));
			classes.add(new Classe(SolicitudVacacion.class));
											
			

			solicitudreemplazoLogic.setConnexion(this.getConnexion());
			solicitudreemplazoLogic.setDatosCliente(this.datosCliente);
			solicitudreemplazoLogic.setIsConRefrescarForeignKeys(true);

			solicitudhoraextraLogic.setConnexion(this.getConnexion());
			solicitudhoraextraLogic.setDatosCliente(this.datosCliente);
			solicitudhoraextraLogic.setIsConRefrescarForeignKeys(true);

			solicitudvacacionLogic.setConnexion(this.getConnexion());
			solicitudvacacionLogic.setDatosCliente(this.datosCliente);
			solicitudvacacionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoSolicitudNomi estadosolicitudnomi:this.estadosolicitudnomis) {
				

				classes=new ArrayList<Classe>();
				classes=SolicitudReemplazoConstantesFunciones.getClassesForeignKeysOfSolicitudReemplazo(new ArrayList<Classe>(),DeepLoadType.NONE);

				solicitudreemplazoLogic.setSolicitudReemplazos(estadosolicitudnomi.solicitudreemplazos);
				solicitudreemplazoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SolicitudHoraExtraConstantesFunciones.getClassesForeignKeysOfSolicitudHoraExtra(new ArrayList<Classe>(),DeepLoadType.NONE);

				solicitudhoraextraLogic.setSolicitudHoraExtras(estadosolicitudnomi.solicitudhoraextras);
				solicitudhoraextraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SolicitudVacacionConstantesFunciones.getClassesForeignKeysOfSolicitudVacacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				solicitudvacacionLogic.setSolicitudVacacions(estadosolicitudnomi.solicitudvacacions);
				solicitudvacacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoSolicitudNomi estadosolicitudnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToGet(estadosolicitudnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadosolicitudnomi.setSolicitudReemplazos(estadosolicitudnomiDataAccess.getSolicitudReemplazos(connexion,estadosolicitudnomi));
		estadosolicitudnomi.setSolicitudHoraExtras(estadosolicitudnomiDataAccess.getSolicitudHoraExtras(connexion,estadosolicitudnomi));
		estadosolicitudnomi.setSolicitudVacacions(estadosolicitudnomiDataAccess.getSolicitudVacacions(connexion,estadosolicitudnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadosolicitudnomi.setSolicitudReemplazos(estadosolicitudnomiDataAccess.getSolicitudReemplazos(connexion,estadosolicitudnomi));

				if(this.isConDeep) {
					SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(this.connexion);
					solicitudreemplazoLogic.setSolicitudReemplazos(estadosolicitudnomi.getSolicitudReemplazos());
					ArrayList<Classe> classesLocal=SolicitudReemplazoConstantesFunciones.getClassesForeignKeysOfSolicitudReemplazo(new ArrayList<Classe>(),DeepLoadType.NONE);
					solicitudreemplazoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(solicitudreemplazoLogic.getSolicitudReemplazos());
					estadosolicitudnomi.setSolicitudReemplazos(solicitudreemplazoLogic.getSolicitudReemplazos());
				}

				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadosolicitudnomi.setSolicitudHoraExtras(estadosolicitudnomiDataAccess.getSolicitudHoraExtras(connexion,estadosolicitudnomi));

				if(this.isConDeep) {
					SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(this.connexion);
					solicitudhoraextraLogic.setSolicitudHoraExtras(estadosolicitudnomi.getSolicitudHoraExtras());
					ArrayList<Classe> classesLocal=SolicitudHoraExtraConstantesFunciones.getClassesForeignKeysOfSolicitudHoraExtra(new ArrayList<Classe>(),DeepLoadType.NONE);
					solicitudhoraextraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(solicitudhoraextraLogic.getSolicitudHoraExtras());
					estadosolicitudnomi.setSolicitudHoraExtras(solicitudhoraextraLogic.getSolicitudHoraExtras());
				}

				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadosolicitudnomi.setSolicitudVacacions(estadosolicitudnomiDataAccess.getSolicitudVacacions(connexion,estadosolicitudnomi));

				if(this.isConDeep) {
					SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(this.connexion);
					solicitudvacacionLogic.setSolicitudVacacions(estadosolicitudnomi.getSolicitudVacacions());
					ArrayList<Classe> classesLocal=SolicitudVacacionConstantesFunciones.getClassesForeignKeysOfSolicitudVacacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					solicitudvacacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(solicitudvacacionLogic.getSolicitudVacacions());
					estadosolicitudnomi.setSolicitudVacacions(solicitudvacacionLogic.getSolicitudVacacions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudReemplazo.class));
			estadosolicitudnomi.setSolicitudReemplazos(estadosolicitudnomiDataAccess.getSolicitudReemplazos(connexion,estadosolicitudnomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudHoraExtra.class));
			estadosolicitudnomi.setSolicitudHoraExtras(estadosolicitudnomiDataAccess.getSolicitudHoraExtras(connexion,estadosolicitudnomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudVacacion.class));
			estadosolicitudnomi.setSolicitudVacacions(estadosolicitudnomiDataAccess.getSolicitudVacacions(connexion,estadosolicitudnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadosolicitudnomi.setSolicitudReemplazos(estadosolicitudnomiDataAccess.getSolicitudReemplazos(connexion,estadosolicitudnomi));

		for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
			SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
			solicitudreemplazoLogic.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
		}

		estadosolicitudnomi.setSolicitudHoraExtras(estadosolicitudnomiDataAccess.getSolicitudHoraExtras(connexion,estadosolicitudnomi));

		for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
			SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
			solicitudhoraextraLogic.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
		}

		estadosolicitudnomi.setSolicitudVacacions(estadosolicitudnomiDataAccess.getSolicitudVacacions(connexion,estadosolicitudnomi));

		for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
			SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
			solicitudvacacionLogic.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadosolicitudnomi.setSolicitudReemplazos(estadosolicitudnomiDataAccess.getSolicitudReemplazos(connexion,estadosolicitudnomi));

				for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
					SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
					solicitudreemplazoLogic.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadosolicitudnomi.setSolicitudHoraExtras(estadosolicitudnomiDataAccess.getSolicitudHoraExtras(connexion,estadosolicitudnomi));

				for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
					SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
					solicitudhoraextraLogic.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadosolicitudnomi.setSolicitudVacacions(estadosolicitudnomiDataAccess.getSolicitudVacacions(connexion,estadosolicitudnomi));

				for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
					SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
					solicitudvacacionLogic.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudReemplazo.class));
			estadosolicitudnomi.setSolicitudReemplazos(estadosolicitudnomiDataAccess.getSolicitudReemplazos(connexion,estadosolicitudnomi));

			for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
				SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
				solicitudreemplazoLogic.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudHoraExtra.class));
			estadosolicitudnomi.setSolicitudHoraExtras(estadosolicitudnomiDataAccess.getSolicitudHoraExtras(connexion,estadosolicitudnomi));

			for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
				SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
				solicitudhoraextraLogic.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudVacacion.class));
			estadosolicitudnomi.setSolicitudVacacions(estadosolicitudnomiDataAccess.getSolicitudVacacions(connexion,estadosolicitudnomi));

			for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
				SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
				solicitudvacacionLogic.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoSolicitudNomi estadosolicitudnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoSolicitudNomiLogicAdditional.updateEstadoSolicitudNomiToSave(estadosolicitudnomi,this.arrDatoGeneral);
			
EstadoSolicitudNomiDataAccess.save(estadosolicitudnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
			solicitudreemplazo.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
			SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
		}

		for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
			solicitudhoraextra.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
			SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
		}

		for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
			solicitudvacacion.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
			SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
					solicitudreemplazo.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
					SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
					solicitudhoraextra.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
					SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
					solicitudvacacion.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
					SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
			SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
			solicitudreemplazo.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
			SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
			solicitudreemplazoLogic.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);
		}

		for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
			SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
			solicitudhoraextra.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
			SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
			solicitudhoraextraLogic.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);
		}

		for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
			SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
			solicitudvacacion.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
			SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
			solicitudvacacionLogic.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudReemplazo solicitudreemplazo:estadosolicitudnomi.getSolicitudReemplazos()) {
					SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
					solicitudreemplazo.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
					SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
					solicitudreemplazoLogic.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudHoraExtra solicitudhoraextra:estadosolicitudnomi.getSolicitudHoraExtras()) {
					SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
					solicitudhoraextra.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
					SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
					solicitudhoraextraLogic.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudVacacion solicitudvacacion:estadosolicitudnomi.getSolicitudVacacions()) {
					SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
					solicitudvacacion.setid_estado_solicitud_nomi(estadosolicitudnomi.getId());
					SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
					solicitudvacacionLogic.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoSolicitudNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadosolicitudnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(estadosolicitudnomi);
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
			this.deepLoad(this.estadosolicitudnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(this.estadosolicitudnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoSolicitudNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadosolicitudnomis!=null) {
				for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis) {
					this.deepLoad(estadosolicitudnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(estadosolicitudnomis);
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
			if(estadosolicitudnomis!=null) {
				for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis) {
					this.deepLoad(estadosolicitudnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoSolicitudNomiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoSolicitudNomi(estadosolicitudnomis);
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
			this.getNewConnexionToDeep(EstadoSolicitudNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadosolicitudnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoSolicitudNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadosolicitudnomis!=null) {
				for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis) {
					this.deepSave(estadosolicitudnomi,isDeep,deepLoadType,clases);
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
			if(estadosolicitudnomis!=null) {
				for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis) {
					this.deepSave(estadosolicitudnomi,isDeep,deepLoadType,clases);
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
			if(EstadoSolicitudNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoSolicitudNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoSolicitudNomi estadosolicitudnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoSolicitudNomiConstantesFunciones.ISCONAUDITORIA) {
				if(estadosolicitudnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoSolicitudNomiDataAccess.TABLENAME, estadosolicitudnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoSolicitudNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoSolicitudNomiLogic.registrarAuditoriaDetallesEstadoSolicitudNomi(connexion,estadosolicitudnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadosolicitudnomi.getIsDeleted()) {
					/*if(!estadosolicitudnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoSolicitudNomiDataAccess.TABLENAME, estadosolicitudnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoSolicitudNomiLogic.registrarAuditoriaDetallesEstadoSolicitudNomi(connexion,estadosolicitudnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoSolicitudNomiDataAccess.TABLENAME, estadosolicitudnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadosolicitudnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoSolicitudNomiDataAccess.TABLENAME, estadosolicitudnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoSolicitudNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoSolicitudNomiLogic.registrarAuditoriaDetallesEstadoSolicitudNomi(connexion,estadosolicitudnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoSolicitudNomi(Connexion connexion,EstadoSolicitudNomi estadosolicitudnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadosolicitudnomi.getIsNew()||!estadosolicitudnomi.getcodigo().equals(estadosolicitudnomi.getEstadoSolicitudNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadosolicitudnomi.getEstadoSolicitudNomiOriginal().getcodigo()!=null)
				{
					strValorActual=estadosolicitudnomi.getEstadoSolicitudNomiOriginal().getcodigo();
				}
				if(estadosolicitudnomi.getcodigo()!=null)
				{
					strValorNuevo=estadosolicitudnomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoSolicitudNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadosolicitudnomi.getIsNew()||!estadosolicitudnomi.getnombre().equals(estadosolicitudnomi.getEstadoSolicitudNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadosolicitudnomi.getEstadoSolicitudNomiOriginal().getnombre()!=null)
				{
					strValorActual=estadosolicitudnomi.getEstadoSolicitudNomiOriginal().getnombre();
				}
				if(estadosolicitudnomi.getnombre()!=null)
				{
					strValorNuevo=estadosolicitudnomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoSolicitudNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoSolicitudNomiRelacionesWithConnection(EstadoSolicitudNomi estadosolicitudnomi,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<SolicitudVacacion> solicitudvacacions) throws Exception {

		if(!estadosolicitudnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoSolicitudNomiRelacionesBase(estadosolicitudnomi,solicitudreemplazos,solicitudhoraextras,solicitudvacacions,true);
		}
	}

	public void saveEstadoSolicitudNomiRelaciones(EstadoSolicitudNomi estadosolicitudnomi,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<SolicitudVacacion> solicitudvacacions)throws Exception {

		if(!estadosolicitudnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoSolicitudNomiRelacionesBase(estadosolicitudnomi,solicitudreemplazos,solicitudhoraextras,solicitudvacacions,false);
		}
	}

	public void saveEstadoSolicitudNomiRelacionesBase(EstadoSolicitudNomi estadosolicitudnomi,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<SolicitudVacacion> solicitudvacacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoSolicitudNomi-saveRelacionesWithConnection");}
	
			estadosolicitudnomi.setSolicitudReemplazos(solicitudreemplazos);
			estadosolicitudnomi.setSolicitudHoraExtras(solicitudhoraextras);
			estadosolicitudnomi.setSolicitudVacacions(solicitudvacacions);

			this.setEstadoSolicitudNomi(estadosolicitudnomi);

				if((estadosolicitudnomi.getIsNew()||estadosolicitudnomi.getIsChanged())&&!estadosolicitudnomi.getIsDeleted()) {
					this.saveEstadoSolicitudNomi();
					this.saveEstadoSolicitudNomiRelacionesDetalles(solicitudreemplazos,solicitudhoraextras,solicitudvacacions);

				} else if(estadosolicitudnomi.getIsDeleted()) {
					this.saveEstadoSolicitudNomiRelacionesDetalles(solicitudreemplazos,solicitudhoraextras,solicitudvacacions);
					this.saveEstadoSolicitudNomi();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			SolicitudReemplazoConstantesFunciones.InicializarGeneralEntityAuxiliaresSolicitudReemplazos(solicitudreemplazos,true,true);
			SolicitudHoraExtraConstantesFunciones.InicializarGeneralEntityAuxiliaresSolicitudHoraExtras(solicitudhoraextras,true,true);
			SolicitudVacacionConstantesFunciones.InicializarGeneralEntityAuxiliaresSolicitudVacacions(solicitudvacacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoSolicitudNomiRelacionesDetalles(List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<SolicitudVacacion> solicitudvacacions)throws Exception {
		try {
	

			Long idEstadoSolicitudNomiActual=this.getEstadoSolicitudNomi().getId();

			SolicitudReemplazoLogic solicitudreemplazoLogic_Desde_EstadoSolicitudNomi=new SolicitudReemplazoLogic();
			solicitudreemplazoLogic_Desde_EstadoSolicitudNomi.setSolicitudReemplazos(solicitudreemplazos);

			solicitudreemplazoLogic_Desde_EstadoSolicitudNomi.setConnexion(this.getConnexion());
			solicitudreemplazoLogic_Desde_EstadoSolicitudNomi.setDatosCliente(this.datosCliente);

			for(SolicitudReemplazo solicitudreemplazo_Desde_EstadoSolicitudNomi:solicitudreemplazoLogic_Desde_EstadoSolicitudNomi.getSolicitudReemplazos()) {
				solicitudreemplazo_Desde_EstadoSolicitudNomi.setid_estado_solicitud_nomi(idEstadoSolicitudNomiActual);
			}

			solicitudreemplazoLogic_Desde_EstadoSolicitudNomi.saveSolicitudReemplazos();

			SolicitudHoraExtraLogic solicitudhoraextraLogic_Desde_EstadoSolicitudNomi=new SolicitudHoraExtraLogic();
			solicitudhoraextraLogic_Desde_EstadoSolicitudNomi.setSolicitudHoraExtras(solicitudhoraextras);

			solicitudhoraextraLogic_Desde_EstadoSolicitudNomi.setConnexion(this.getConnexion());
			solicitudhoraextraLogic_Desde_EstadoSolicitudNomi.setDatosCliente(this.datosCliente);

			for(SolicitudHoraExtra solicitudhoraextra_Desde_EstadoSolicitudNomi:solicitudhoraextraLogic_Desde_EstadoSolicitudNomi.getSolicitudHoraExtras()) {
				solicitudhoraextra_Desde_EstadoSolicitudNomi.setid_estado_solicitud_nomi(idEstadoSolicitudNomiActual);
			}

			solicitudhoraextraLogic_Desde_EstadoSolicitudNomi.saveSolicitudHoraExtras();

			SolicitudVacacionLogic solicitudvacacionLogic_Desde_EstadoSolicitudNomi=new SolicitudVacacionLogic();
			solicitudvacacionLogic_Desde_EstadoSolicitudNomi.setSolicitudVacacions(solicitudvacacions);

			solicitudvacacionLogic_Desde_EstadoSolicitudNomi.setConnexion(this.getConnexion());
			solicitudvacacionLogic_Desde_EstadoSolicitudNomi.setDatosCliente(this.datosCliente);

			for(SolicitudVacacion solicitudvacacion_Desde_EstadoSolicitudNomi:solicitudvacacionLogic_Desde_EstadoSolicitudNomi.getSolicitudVacacions()) {
				solicitudvacacion_Desde_EstadoSolicitudNomi.setid_estado_solicitud_nomi(idEstadoSolicitudNomiActual);
			}

			solicitudvacacionLogic_Desde_EstadoSolicitudNomi.saveSolicitudVacacions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoSolicitudNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoSolicitudNomiConstantesFunciones.getClassesForeignKeysOfEstadoSolicitudNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoSolicitudNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoSolicitudNomiConstantesFunciones.getClassesRelationshipsOfEstadoSolicitudNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
