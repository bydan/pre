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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.LunaSistemaSolarConstantesFunciones;
import com.bydan.erp.seguridad.util.LunaSistemaSolarParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.LunaSistemaSolarParameterGeneral;
import com.bydan.erp.seguridad.business.entity.LunaSistemaSolar;
import com.bydan.erp.seguridad.business.logic.LunaSistemaSolarLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class LunaSistemaSolarLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LunaSistemaSolarLogic.class);
	
	protected LunaSistemaSolarDataAccess lunasistemasolarDataAccess; 	
	protected LunaSistemaSolar lunasistemasolar;
	protected List<LunaSistemaSolar> lunasistemasolars;
	protected Object lunasistemasolarObject;	
	protected List<Object> lunasistemasolarsObject;
	
	public static ClassValidator<LunaSistemaSolar> lunasistemasolarValidator = new ClassValidator<LunaSistemaSolar>(LunaSistemaSolar.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LunaSistemaSolarLogicAdditional lunasistemasolarLogicAdditional=null;
	
	public LunaSistemaSolarLogicAdditional getLunaSistemaSolarLogicAdditional() {
		return this.lunasistemasolarLogicAdditional;
	}
	
	public void setLunaSistemaSolarLogicAdditional(LunaSistemaSolarLogicAdditional lunasistemasolarLogicAdditional) {
		try {
			this.lunasistemasolarLogicAdditional=lunasistemasolarLogicAdditional;
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
	
	
	
	
	public  LunaSistemaSolarLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.lunasistemasolarDataAccess = new LunaSistemaSolarDataAccess();
			
			this.lunasistemasolars= new ArrayList<LunaSistemaSolar>();
			this.lunasistemasolar= new LunaSistemaSolar();
			
			this.lunasistemasolarObject=new Object();
			this.lunasistemasolarsObject=new ArrayList<Object>();
				
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
			
			this.lunasistemasolarDataAccess.setConnexionType(this.connexionType);
			this.lunasistemasolarDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LunaSistemaSolarLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.lunasistemasolarDataAccess = new LunaSistemaSolarDataAccess();
			this.lunasistemasolars= new ArrayList<LunaSistemaSolar>();
			this.lunasistemasolar= new LunaSistemaSolar();
			this.lunasistemasolarObject=new Object();
			this.lunasistemasolarsObject=new ArrayList<Object>();
			
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
			
			this.lunasistemasolarDataAccess.setConnexionType(this.connexionType);
			this.lunasistemasolarDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LunaSistemaSolar getLunaSistemaSolar() throws Exception {	
		LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToGet(lunasistemasolar,this.datosCliente,this.arrDatoGeneral);
		LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToGet(lunasistemasolar,this.arrDatoGeneral);
		
		return lunasistemasolar;
	}
		
	public void setLunaSistemaSolar(LunaSistemaSolar newLunaSistemaSolar) {
		this.lunasistemasolar = newLunaSistemaSolar;
	}
	
	public LunaSistemaSolarDataAccess getLunaSistemaSolarDataAccess() {
		return lunasistemasolarDataAccess;
	}
	
	public void setLunaSistemaSolarDataAccess(LunaSistemaSolarDataAccess newlunasistemasolarDataAccess) {
		this.lunasistemasolarDataAccess = newlunasistemasolarDataAccess;
	}
	
	public List<LunaSistemaSolar> getLunaSistemaSolars() throws Exception {		
		this.quitarLunaSistemaSolarsNulos();
		
		LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToGets(lunasistemasolars,this.datosCliente,this.arrDatoGeneral);
		
		for (LunaSistemaSolar lunasistemasolarLocal: lunasistemasolars ) {
			LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToGet(lunasistemasolarLocal,this.arrDatoGeneral);
		}
		
		return lunasistemasolars;
	}
	
	public void setLunaSistemaSolars(List<LunaSistemaSolar> newLunaSistemaSolars) {
		this.lunasistemasolars = newLunaSistemaSolars;
	}
	
	public Object getLunaSistemaSolarObject() {	
		this.lunasistemasolarObject=this.lunasistemasolarDataAccess.getEntityObject();
		return this.lunasistemasolarObject;
	}
		
	public void setLunaSistemaSolarObject(Object newLunaSistemaSolarObject) {
		this.lunasistemasolarObject = newLunaSistemaSolarObject;
	}
	
	public List<Object> getLunaSistemaSolarsObject() {		
		this.lunasistemasolarsObject=this.lunasistemasolarDataAccess.getEntitiesObject();
		return this.lunasistemasolarsObject;
	}
		
	public void setLunaSistemaSolarsObject(List<Object> newLunaSistemaSolarsObject) {
		this.lunasistemasolarsObject = newLunaSistemaSolarsObject;
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
		
		if(this.lunasistemasolarDataAccess!=null) {
			this.lunasistemasolarDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			lunasistemasolarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			lunasistemasolarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		lunasistemasolar = new  LunaSistemaSolar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lunasistemasolar=lunasistemasolarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lunasistemasolar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
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
		lunasistemasolar = new  LunaSistemaSolar();
		  		  
        try {
			
			lunasistemasolar=lunasistemasolarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lunasistemasolar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		lunasistemasolar = new  LunaSistemaSolar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lunasistemasolar=lunasistemasolarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lunasistemasolar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
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
		lunasistemasolar = new  LunaSistemaSolar();
		  		  
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
		lunasistemasolar = new  LunaSistemaSolar();
		  		  
        try {
			
			lunasistemasolar=lunasistemasolarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lunasistemasolar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		lunasistemasolar = new  LunaSistemaSolar();
		  		  
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
		lunasistemasolar = new  LunaSistemaSolar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =lunasistemasolarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lunasistemasolar = new  LunaSistemaSolar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=lunasistemasolarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lunasistemasolar = new  LunaSistemaSolar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =lunasistemasolarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lunasistemasolar = new  LunaSistemaSolar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=lunasistemasolarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lunasistemasolar = new  LunaSistemaSolar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =lunasistemasolarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lunasistemasolar = new  LunaSistemaSolar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=lunasistemasolarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
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
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		  		  
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
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		  		  
        try {			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		  		  
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
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
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
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		  		  
        try {
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
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
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
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
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lunasistemasolar = new  LunaSistemaSolar();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolar=lunasistemasolarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
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
		lunasistemasolar = new  LunaSistemaSolar();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolar=lunasistemasolarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosLunaSistemaSolarsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getTodosLunaSistemaSolarsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
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
	
	public  void  getTodosLunaSistemaSolars(String sFinalQuery,Pagination pagination)throws Exception {
		lunasistemasolars = new  ArrayList<LunaSistemaSolar>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLunaSistemaSolar(lunasistemasolars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLunaSistemaSolar(LunaSistemaSolar lunasistemasolar) throws Exception {
		Boolean estaValidado=false;
		
		if(lunasistemasolar.getIsNew() || lunasistemasolar.getIsChanged()) { 
			this.invalidValues = lunasistemasolarValidator.getInvalidValues(lunasistemasolar);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(lunasistemasolar);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLunaSistemaSolar(List<LunaSistemaSolar> LunaSistemaSolars) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LunaSistemaSolar lunasistemasolarLocal:lunasistemasolars) {				
			estaValidadoObjeto=this.validarGuardarLunaSistemaSolar(lunasistemasolarLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLunaSistemaSolar(List<LunaSistemaSolar> LunaSistemaSolars) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLunaSistemaSolar(lunasistemasolars)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLunaSistemaSolar(LunaSistemaSolar LunaSistemaSolar) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLunaSistemaSolar(lunasistemasolar)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LunaSistemaSolar lunasistemasolar) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+lunasistemasolar.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LunaSistemaSolarConstantesFunciones.getLunaSistemaSolarLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"lunasistemasolar","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LunaSistemaSolarConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LunaSistemaSolarConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLunaSistemaSolarWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-saveLunaSistemaSolarWithConnection");connexion.begin();			
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSave(this.lunasistemasolar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToSave(this.lunasistemasolar,this.arrDatoGeneral);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lunasistemasolar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLunaSistemaSolar();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLunaSistemaSolar(this.lunasistemasolar)) {
				LunaSistemaSolarDataAccess.save(this.lunasistemasolar, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.lunasistemasolar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSaveAfter(this.lunasistemasolar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLunaSistemaSolar();
			
			connexion.commit();			
			
			if(this.lunasistemasolar.getIsDeleted()) {
				this.lunasistemasolar=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLunaSistemaSolar()throws Exception {	
		try {	
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSave(this.lunasistemasolar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToSave(this.lunasistemasolar,this.arrDatoGeneral);
			
			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lunasistemasolar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLunaSistemaSolar(this.lunasistemasolar)) {			
				LunaSistemaSolarDataAccess.save(this.lunasistemasolar, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.lunasistemasolar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSaveAfter(this.lunasistemasolar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.lunasistemasolar.getIsDeleted()) {
				this.lunasistemasolar=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLunaSistemaSolarsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-saveLunaSistemaSolarsWithConnection");connexion.begin();			
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSaves(lunasistemasolars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLunaSistemaSolars();
			
			Boolean validadoTodosLunaSistemaSolar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LunaSistemaSolar lunasistemasolarLocal:lunasistemasolars) {		
				if(lunasistemasolarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToSave(lunasistemasolarLocal,this.arrDatoGeneral);
	        	
				LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lunasistemasolarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLunaSistemaSolar(lunasistemasolarLocal)) {
					LunaSistemaSolarDataAccess.save(lunasistemasolarLocal, connexion);				
				} else {
					validadoTodosLunaSistemaSolar=false;
				}
			}
			
			if(!validadoTodosLunaSistemaSolar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSavesAfter(lunasistemasolars,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLunaSistemaSolars();
			
			connexion.commit();		
			
			this.quitarLunaSistemaSolarsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLunaSistemaSolars()throws Exception {				
		 try {	
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSaves(lunasistemasolars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLunaSistemaSolar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LunaSistemaSolar lunasistemasolarLocal:lunasistemasolars) {				
				if(lunasistemasolarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToSave(lunasistemasolarLocal,this.arrDatoGeneral);
	        	
				LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lunasistemasolarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLunaSistemaSolar(lunasistemasolarLocal)) {				
					LunaSistemaSolarDataAccess.save(lunasistemasolarLocal, connexion);				
				} else {
					validadoTodosLunaSistemaSolar=false;
				}
			}
			
			if(!validadoTodosLunaSistemaSolar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LunaSistemaSolarLogicAdditional.checkLunaSistemaSolarToSavesAfter(lunasistemasolars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLunaSistemaSolarsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LunaSistemaSolarParameterReturnGeneral procesarAccionLunaSistemaSolars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LunaSistemaSolar> lunasistemasolars,LunaSistemaSolarParameterReturnGeneral lunasistemasolarParameterGeneral)throws Exception {
		 try {	
			LunaSistemaSolarParameterReturnGeneral lunasistemasolarReturnGeneral=new LunaSistemaSolarParameterReturnGeneral();
	
			LunaSistemaSolarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lunasistemasolars,lunasistemasolarParameterGeneral,lunasistemasolarReturnGeneral);
			
			return lunasistemasolarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LunaSistemaSolarParameterReturnGeneral procesarAccionLunaSistemaSolarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LunaSistemaSolar> lunasistemasolars,LunaSistemaSolarParameterReturnGeneral lunasistemasolarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-procesarAccionLunaSistemaSolarsWithConnection");connexion.begin();			
			
			LunaSistemaSolarParameterReturnGeneral lunasistemasolarReturnGeneral=new LunaSistemaSolarParameterReturnGeneral();
	
			LunaSistemaSolarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lunasistemasolars,lunasistemasolarParameterGeneral,lunasistemasolarReturnGeneral);
			
			this.connexion.commit();
			
			return lunasistemasolarReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LunaSistemaSolarParameterReturnGeneral procesarEventosLunaSistemaSolars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LunaSistemaSolar> lunasistemasolars,LunaSistemaSolar lunasistemasolar,LunaSistemaSolarParameterReturnGeneral lunasistemasolarParameterGeneral,Boolean isEsNuevoLunaSistemaSolar,ArrayList<Classe> clases)throws Exception {
		 try {	
			LunaSistemaSolarParameterReturnGeneral lunasistemasolarReturnGeneral=new LunaSistemaSolarParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lunasistemasolarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LunaSistemaSolarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lunasistemasolars,lunasistemasolar,lunasistemasolarParameterGeneral,lunasistemasolarReturnGeneral,isEsNuevoLunaSistemaSolar,clases);
			
			return lunasistemasolarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LunaSistemaSolarParameterReturnGeneral procesarEventosLunaSistemaSolarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LunaSistemaSolar> lunasistemasolars,LunaSistemaSolar lunasistemasolar,LunaSistemaSolarParameterReturnGeneral lunasistemasolarParameterGeneral,Boolean isEsNuevoLunaSistemaSolar,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-procesarEventosLunaSistemaSolarsWithConnection");connexion.begin();			
			
			LunaSistemaSolarParameterReturnGeneral lunasistemasolarReturnGeneral=new LunaSistemaSolarParameterReturnGeneral();
	
			lunasistemasolarReturnGeneral.setLunaSistemaSolar(lunasistemasolar);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lunasistemasolarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LunaSistemaSolarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lunasistemasolars,lunasistemasolar,lunasistemasolarParameterGeneral,lunasistemasolarReturnGeneral,isEsNuevoLunaSistemaSolar,clases);
			
			this.connexion.commit();
			
			return lunasistemasolarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LunaSistemaSolarParameterReturnGeneral procesarImportacionLunaSistemaSolarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LunaSistemaSolarParameterReturnGeneral lunasistemasolarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-procesarImportacionLunaSistemaSolarsWithConnection");connexion.begin();			
			
			LunaSistemaSolarParameterReturnGeneral lunasistemasolarReturnGeneral=new LunaSistemaSolarParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.lunasistemasolars=new ArrayList<LunaSistemaSolar>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.lunasistemasolar=new LunaSistemaSolar();
				
				
				if(conColumnasBase) {this.lunasistemasolar.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.lunasistemasolar.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.lunasistemasolar.setcodigo(arrColumnas[iColumn++]);
				this.lunasistemasolar.setnombre(arrColumnas[iColumn++]);
				this.lunasistemasolar.setdescripcion(arrColumnas[iColumn++]);
				
				this.lunasistemasolars.add(this.lunasistemasolar);
			}
			
			this.saveLunaSistemaSolars();
			
			this.connexion.commit();
			
			lunasistemasolarReturnGeneral.setConRetornoEstaProcesado(true);
			lunasistemasolarReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return lunasistemasolarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLunaSistemaSolarsEliminados() throws Exception {				
		
		List<LunaSistemaSolar> lunasistemasolarsAux= new ArrayList<LunaSistemaSolar>();
		
		for(LunaSistemaSolar lunasistemasolar:lunasistemasolars) {
			if(!lunasistemasolar.getIsDeleted()) {
				lunasistemasolarsAux.add(lunasistemasolar);
			}
		}
		
		lunasistemasolars=lunasistemasolarsAux;
	}
	
	public void quitarLunaSistemaSolarsNulos() throws Exception {				
		
		List<LunaSistemaSolar> lunasistemasolarsAux= new ArrayList<LunaSistemaSolar>();
		
		for(LunaSistemaSolar lunasistemasolar : this.lunasistemasolars) {
			if(lunasistemasolar==null) {
				lunasistemasolarsAux.add(lunasistemasolar);
			}
		}
		
		//this.lunasistemasolars=lunasistemasolarsAux;
		
		this.lunasistemasolars.removeAll(lunasistemasolarsAux);
	}
	
	public void getSetVersionRowLunaSistemaSolarWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(lunasistemasolar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((lunasistemasolar.getIsDeleted() || (lunasistemasolar.getIsChanged()&&!lunasistemasolar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=lunasistemasolarDataAccess.getSetVersionRowLunaSistemaSolar(connexion,lunasistemasolar.getId());
				
				if(!lunasistemasolar.getVersionRow().equals(timestamp)) {	
					lunasistemasolar.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				lunasistemasolar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLunaSistemaSolar()throws Exception {	
		
		if(lunasistemasolar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((lunasistemasolar.getIsDeleted() || (lunasistemasolar.getIsChanged()&&!lunasistemasolar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=lunasistemasolarDataAccess.getSetVersionRowLunaSistemaSolar(connexion,lunasistemasolar.getId());
			
			try {							
				if(!lunasistemasolar.getVersionRow().equals(timestamp)) {	
					lunasistemasolar.setVersionRow(timestamp);
				}
				
				lunasistemasolar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLunaSistemaSolarsWithConnection()throws Exception {	
		if(lunasistemasolars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LunaSistemaSolar lunasistemasolarAux:lunasistemasolars) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(lunasistemasolarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lunasistemasolarAux.getIsDeleted() || (lunasistemasolarAux.getIsChanged()&&!lunasistemasolarAux.getIsNew())) {
						
						timestamp=lunasistemasolarDataAccess.getSetVersionRowLunaSistemaSolar(connexion,lunasistemasolarAux.getId());
						
						if(!lunasistemasolar.getVersionRow().equals(timestamp)) {	
							lunasistemasolarAux.setVersionRow(timestamp);
						}
								
						lunasistemasolarAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLunaSistemaSolars()throws Exception {	
		if(lunasistemasolars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LunaSistemaSolar lunasistemasolarAux:lunasistemasolars) {
					if(lunasistemasolarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lunasistemasolarAux.getIsDeleted() || (lunasistemasolarAux.getIsChanged()&&!lunasistemasolarAux.getIsNew())) {
						
						timestamp=lunasistemasolarDataAccess.getSetVersionRowLunaSistemaSolar(connexion,lunasistemasolarAux.getId());
						
						if(!lunasistemasolarAux.getVersionRow().equals(timestamp)) {	
							lunasistemasolarAux.setVersionRow(timestamp);
						}
						
													
						lunasistemasolarAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LunaSistemaSolarParameterReturnGeneral cargarCombosLoteForeignKeyLunaSistemaSolarWithConnection(String finalQueryGlobalTipoValoracion) throws Exception {
		LunaSistemaSolarParameterReturnGeneral  lunasistemasolarReturnGeneral =new LunaSistemaSolarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-cargarCombosLoteForeignKeyLunaSistemaSolarWithConnection");connexion.begin();
			
			lunasistemasolarReturnGeneral =new LunaSistemaSolarParameterReturnGeneral();
			
			

			List<TipoValoracion> tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
			TipoValoracionLogic tipovaloracionLogic=new TipoValoracionLogic();
			tipovaloracionLogic.setConnexion(this.connexion);
			tipovaloracionLogic.getTipoValoracionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValoracion.equals("NONE")) {
				tipovaloracionLogic.getTodosTipoValoracions(finalQueryGlobalTipoValoracion,new Pagination());
				tipovaloracionsForeignKey=tipovaloracionLogic.getTipoValoracions();
			}

			lunasistemasolarReturnGeneral.settipovaloracionsForeignKey(tipovaloracionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return lunasistemasolarReturnGeneral;
	}
	
	public LunaSistemaSolarParameterReturnGeneral cargarCombosLoteForeignKeyLunaSistemaSolar(String finalQueryGlobalTipoValoracion) throws Exception {
		LunaSistemaSolarParameterReturnGeneral  lunasistemasolarReturnGeneral =new LunaSistemaSolarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			lunasistemasolarReturnGeneral =new LunaSistemaSolarParameterReturnGeneral();
			
			

			List<TipoValoracion> tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
			TipoValoracionLogic tipovaloracionLogic=new TipoValoracionLogic();
			tipovaloracionLogic.setConnexion(this.connexion);
			tipovaloracionLogic.getTipoValoracionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValoracion.equals("NONE")) {
				tipovaloracionLogic.getTodosTipoValoracions(finalQueryGlobalTipoValoracion,new Pagination());
				tipovaloracionsForeignKey=tipovaloracionLogic.getTipoValoracions();
			}

			lunasistemasolarReturnGeneral.settipovaloracionsForeignKey(tipovaloracionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return lunasistemasolarReturnGeneral;
	}
	
	
	public void deepLoad(LunaSistemaSolar lunasistemasolar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LunaSistemaSolarLogicAdditional.updateLunaSistemaSolarToGet(lunasistemasolar,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lunasistemasolar.setTipoValoracion(lunasistemasolarDataAccess.getTipoValoracion(connexion,lunasistemasolar));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				lunasistemasolar.setTipoValoracion(lunasistemasolarDataAccess.getTipoValoracion(connexion,lunasistemasolar));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lunasistemasolar.setTipoValoracion(lunasistemasolarDataAccess.getTipoValoracion(connexion,lunasistemasolar));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lunasistemasolar.setTipoValoracion(lunasistemasolarDataAccess.getTipoValoracion(connexion,lunasistemasolar));
		TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
		tipovaloracionLogic.deepLoad(lunasistemasolar.getTipoValoracion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				lunasistemasolar.setTipoValoracion(lunasistemasolarDataAccess.getTipoValoracion(connexion,lunasistemasolar));
				TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
				tipovaloracionLogic.deepLoad(lunasistemasolar.getTipoValoracion(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lunasistemasolar.setTipoValoracion(lunasistemasolarDataAccess.getTipoValoracion(connexion,lunasistemasolar));
			TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
			tipovaloracionLogic.deepLoad(lunasistemasolar.getTipoValoracion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LunaSistemaSolar lunasistemasolar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LunaSistemaSolar.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(lunasistemasolar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(lunasistemasolar);
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
			this.deepLoad(this.lunasistemasolar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LunaSistemaSolar.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(lunasistemasolars!=null) {
				for(LunaSistemaSolar lunasistemasolar:lunasistemasolars) {
					this.deepLoad(lunasistemasolar,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(lunasistemasolars);
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
			if(lunasistemasolars!=null) {
				for(LunaSistemaSolar lunasistemasolar:lunasistemasolars) {
					this.deepLoad(lunasistemasolar,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(lunasistemasolars);
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
	
	
	public void getLunaSistemaSolarsFK_IdTipoValoracionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_valoracion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LunaSistemaSolar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValoracion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValoracion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valoracion,LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValoracion);

			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValoracion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLunaSistemaSolarsFK_IdTipoValoracion(String sFinalQuery,Pagination pagination,Long id_tipo_valoracion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValoracion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValoracion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valoracion,LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValoracion);

			LunaSistemaSolarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValoracion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lunasistemasolars=lunasistemasolarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(this.lunasistemasolars);
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
			if(LunaSistemaSolarConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LunaSistemaSolarDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LunaSistemaSolar lunasistemasolar,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LunaSistemaSolarConstantesFunciones.ISCONAUDITORIA) {
				if(lunasistemasolar.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LunaSistemaSolarDataAccess.TABLENAME, lunasistemasolar.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LunaSistemaSolarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LunaSistemaSolarLogic.registrarAuditoriaDetallesLunaSistemaSolar(connexion,lunasistemasolar,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(lunasistemasolar.getIsDeleted()) {
					/*if(!lunasistemasolar.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LunaSistemaSolarDataAccess.TABLENAME, lunasistemasolar.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LunaSistemaSolarLogic.registrarAuditoriaDetallesLunaSistemaSolar(connexion,lunasistemasolar,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LunaSistemaSolarDataAccess.TABLENAME, lunasistemasolar.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(lunasistemasolar.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LunaSistemaSolarDataAccess.TABLENAME, lunasistemasolar.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LunaSistemaSolarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LunaSistemaSolarLogic.registrarAuditoriaDetallesLunaSistemaSolar(connexion,lunasistemasolar,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLunaSistemaSolar(Connexion connexion,LunaSistemaSolar lunasistemasolar)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(lunasistemasolar.getIsNew()||!lunasistemasolar.getid_tipo_valoracion().equals(lunasistemasolar.getLunaSistemaSolarOriginal().getid_tipo_valoracion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lunasistemasolar.getLunaSistemaSolarOriginal().getid_tipo_valoracion()!=null)
				{
					strValorActual=lunasistemasolar.getLunaSistemaSolarOriginal().getid_tipo_valoracion().toString();
				}
				if(lunasistemasolar.getid_tipo_valoracion()!=null)
				{
					strValorNuevo=lunasistemasolar.getid_tipo_valoracion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION,strValorActual,strValorNuevo);
			}	
			
			if(lunasistemasolar.getIsNew()||!lunasistemasolar.getcodigo().equals(lunasistemasolar.getLunaSistemaSolarOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lunasistemasolar.getLunaSistemaSolarOriginal().getcodigo()!=null)
				{
					strValorActual=lunasistemasolar.getLunaSistemaSolarOriginal().getcodigo();
				}
				if(lunasistemasolar.getcodigo()!=null)
				{
					strValorNuevo=lunasistemasolar.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LunaSistemaSolarConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(lunasistemasolar.getIsNew()||!lunasistemasolar.getnombre().equals(lunasistemasolar.getLunaSistemaSolarOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lunasistemasolar.getLunaSistemaSolarOriginal().getnombre()!=null)
				{
					strValorActual=lunasistemasolar.getLunaSistemaSolarOriginal().getnombre();
				}
				if(lunasistemasolar.getnombre()!=null)
				{
					strValorNuevo=lunasistemasolar.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LunaSistemaSolarConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(lunasistemasolar.getIsNew()||!lunasistemasolar.getdescripcion().equals(lunasistemasolar.getLunaSistemaSolarOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lunasistemasolar.getLunaSistemaSolarOriginal().getdescripcion()!=null)
				{
					strValorActual=lunasistemasolar.getLunaSistemaSolarOriginal().getdescripcion();
				}
				if(lunasistemasolar.getdescripcion()!=null)
				{
					strValorNuevo=lunasistemasolar.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LunaSistemaSolarConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLunaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LunaSistemaSolarConstantesFunciones.getClassesForeignKeysOfLunaSistemaSolar(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLunaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LunaSistemaSolarConstantesFunciones.getClassesRelationshipsOfLunaSistemaSolar(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
