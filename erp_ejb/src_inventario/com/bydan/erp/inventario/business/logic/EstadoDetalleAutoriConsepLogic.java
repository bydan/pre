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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoDetalleAutoriConsep;
//import com.bydan.erp.inventario.business.logic.EstadoDetalleAutoriConsepLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoDetalleAutoriConsepLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetalleAutoriConsepLogic.class);
	
	protected EstadoDetalleAutoriConsepDataAccess estadodetalleautoriconsepDataAccess; 	
	protected EstadoDetalleAutoriConsep estadodetalleautoriconsep;
	protected List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps;
	protected Object estadodetalleautoriconsepObject;	
	protected List<Object> estadodetalleautoriconsepsObject;
	
	public static ClassValidator<EstadoDetalleAutoriConsep> estadodetalleautoriconsepValidator = new ClassValidator<EstadoDetalleAutoriConsep>(EstadoDetalleAutoriConsep.class);	
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
	
	
	
	
	public  EstadoDetalleAutoriConsepLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetalleautoriconsepDataAccess = new EstadoDetalleAutoriConsepDataAccess();
			
			this.estadodetalleautoriconseps= new ArrayList<EstadoDetalleAutoriConsep>();
			this.estadodetalleautoriconsep= new EstadoDetalleAutoriConsep();
			
			this.estadodetalleautoriconsepObject=new Object();
			this.estadodetalleautoriconsepsObject=new ArrayList<Object>();
				
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
			
			this.estadodetalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetalleAutoriConsepLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetalleautoriconsepDataAccess = new EstadoDetalleAutoriConsepDataAccess();
			this.estadodetalleautoriconseps= new ArrayList<EstadoDetalleAutoriConsep>();
			this.estadodetalleautoriconsep= new EstadoDetalleAutoriConsep();
			this.estadodetalleautoriconsepObject=new Object();
			this.estadodetalleautoriconsepsObject=new ArrayList<Object>();
			
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
			
			this.estadodetalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetalleAutoriConsep getEstadoDetalleAutoriConsep() throws Exception {	
		//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToGet(estadodetalleautoriconsep,this.datosCliente,this.arrDatoGeneral);
		//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToGet(estadodetalleautoriconsep,this.arrDatoGeneral);
		
		return estadodetalleautoriconsep;
	}
		
	public void setEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep newEstadoDetalleAutoriConsep) {
		this.estadodetalleautoriconsep = newEstadoDetalleAutoriConsep;
	}
	
	public EstadoDetalleAutoriConsepDataAccess getEstadoDetalleAutoriConsepDataAccess() {
		return estadodetalleautoriconsepDataAccess;
	}
	
	public void setEstadoDetalleAutoriConsepDataAccess(EstadoDetalleAutoriConsepDataAccess newestadodetalleautoriconsepDataAccess) {
		this.estadodetalleautoriconsepDataAccess = newestadodetalleautoriconsepDataAccess;
	}
	
	public List<EstadoDetalleAutoriConsep> getEstadoDetalleAutoriConseps() throws Exception {		
		this.quitarEstadoDetalleAutoriConsepsNulos();
		
		//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToGets(estadodetalleautoriconseps,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetalleAutoriConsep estadodetalleautoriconsepLocal: estadodetalleautoriconseps ) {
			//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToGet(estadodetalleautoriconsepLocal,this.arrDatoGeneral);
		}
		
		return estadodetalleautoriconseps;
	}
	
	public void setEstadoDetalleAutoriConseps(List<EstadoDetalleAutoriConsep> newEstadoDetalleAutoriConseps) {
		this.estadodetalleautoriconseps = newEstadoDetalleAutoriConseps;
	}
	
	public Object getEstadoDetalleAutoriConsepObject() {	
		this.estadodetalleautoriconsepObject=this.estadodetalleautoriconsepDataAccess.getEntityObject();
		return this.estadodetalleautoriconsepObject;
	}
		
	public void setEstadoDetalleAutoriConsepObject(Object newEstadoDetalleAutoriConsepObject) {
		this.estadodetalleautoriconsepObject = newEstadoDetalleAutoriConsepObject;
	}
	
	public List<Object> getEstadoDetalleAutoriConsepsObject() {		
		this.estadodetalleautoriconsepsObject=this.estadodetalleautoriconsepDataAccess.getEntitiesObject();
		return this.estadodetalleautoriconsepsObject;
	}
		
	public void setEstadoDetalleAutoriConsepsObject(List<Object> newEstadoDetalleAutoriConsepsObject) {
		this.estadodetalleautoriconsepsObject = newEstadoDetalleAutoriConsepsObject;
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
		
		if(this.estadodetalleautoriconsepDataAccess!=null) {
			this.estadodetalleautoriconsepDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetalleautoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetalleautoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  		  
        try {
			
			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  		  
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  		  
        try {
			
			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  		  
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetalleautoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetalleautoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetalleautoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetalleautoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetalleautoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetalleautoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
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
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		  		  
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
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		  		  
        try {			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		  		  
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
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
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
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		  		  
        try {
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
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
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
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
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
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
		estadodetalleautoriconsep = new  EstadoDetalleAutoriConsep();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoDetalleAutoriConsepsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-getTodosEstadoDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
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
	
	public  void  getTodosEstadoDetalleAutoriConseps(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleautoriconseps = new  ArrayList<EstadoDetalleAutoriConsep>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleautoriconseps=estadodetalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetalleautoriconsep.getIsNew() || estadodetalleautoriconsep.getIsChanged()) { 
			this.invalidValues = estadodetalleautoriconsepValidator.getInvalidValues(estadodetalleautoriconsep);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetalleautoriconsep);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetalleAutoriConsep(List<EstadoDetalleAutoriConsep> EstadoDetalleAutoriConseps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsepLocal:estadodetalleautoriconseps) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetalleAutoriConsep(estadodetalleautoriconsepLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetalleAutoriConsep(List<EstadoDetalleAutoriConsep> EstadoDetalleAutoriConseps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleAutoriConsep(estadodetalleautoriconseps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep EstadoDetalleAutoriConsep) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleAutoriConsep(estadodetalleautoriconsep)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetalleAutoriConsep estadodetalleautoriconsep) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetalleautoriconsep.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetalleAutoriConsepConstantesFunciones.getEstadoDetalleAutoriConsepLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetalleautoriconsep","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetalleAutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetalleAutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetalleAutoriConsepWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-saveEstadoDetalleAutoriConsepWithConnection");connexion.begin();			
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSave(this.estadodetalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToSave(this.estadodetalleautoriconsep,this.arrDatoGeneral);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleautoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleAutoriConsep();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep)) {
				EstadoDetalleAutoriConsepDataAccess.save(this.estadodetalleautoriconsep, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSaveAfter(this.estadodetalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleAutoriConsep();
			
			connexion.commit();			
			
			if(this.estadodetalleautoriconsep.getIsDeleted()) {
				this.estadodetalleautoriconsep=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetalleAutoriConsep()throws Exception {	
		try {	
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSave(this.estadodetalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToSave(this.estadodetalleautoriconsep,this.arrDatoGeneral);
			
			EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleautoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep)) {			
				EstadoDetalleAutoriConsepDataAccess.save(this.estadodetalleautoriconsep, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSaveAfter(this.estadodetalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetalleautoriconsep.getIsDeleted()) {
				this.estadodetalleautoriconsep=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetalleAutoriConsepsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-saveEstadoDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSaves(estadodetalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleAutoriConseps();
			
			Boolean validadoTodosEstadoDetalleAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleAutoriConsep estadodetalleautoriconsepLocal:estadodetalleautoriconseps) {		
				if(estadodetalleautoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToSave(estadodetalleautoriconsepLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleautoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleAutoriConsep(estadodetalleautoriconsepLocal)) {
					EstadoDetalleAutoriConsepDataAccess.save(estadodetalleautoriconsepLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleAutoriConsep=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSavesAfter(estadodetalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleAutoriConseps();
			
			connexion.commit();		
			
			this.quitarEstadoDetalleAutoriConsepsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetalleAutoriConseps()throws Exception {				
		 try {	
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSaves(estadodetalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetalleAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleAutoriConsep estadodetalleautoriconsepLocal:estadodetalleautoriconseps) {				
				if(estadodetalleautoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToSave(estadodetalleautoriconsepLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleautoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleAutoriConsep(estadodetalleautoriconsepLocal)) {				
					EstadoDetalleAutoriConsepDataAccess.save(estadodetalleautoriconsepLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleAutoriConsep=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoDetalleAutoriConsepLogicAdditional.checkEstadoDetalleAutoriConsepToSavesAfter(estadodetalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetalleAutoriConsepsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleAutoriConsepParameterReturnGeneral procesarAccionEstadoDetalleAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepParameterGeneral)throws Exception {
		 try {	
			EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepReturnGeneral=new EstadoDetalleAutoriConsepParameterReturnGeneral();
	
			
			return estadodetalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleAutoriConsepParameterReturnGeneral procesarAccionEstadoDetalleAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-procesarAccionEstadoDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepReturnGeneral=new EstadoDetalleAutoriConsepParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadodetalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleAutoriConsepParameterReturnGeneral procesarEventosEstadoDetalleAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,EstadoDetalleAutoriConsep estadodetalleautoriconsep,EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepParameterGeneral,Boolean isEsNuevoEstadoDetalleAutoriConsep,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepReturnGeneral=new EstadoDetalleAutoriConsepParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleautoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadodetalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetalleAutoriConsepParameterReturnGeneral procesarEventosEstadoDetalleAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,EstadoDetalleAutoriConsep estadodetalleautoriconsep,EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepParameterGeneral,Boolean isEsNuevoEstadoDetalleAutoriConsep,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-procesarEventosEstadoDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepReturnGeneral=new EstadoDetalleAutoriConsepParameterReturnGeneral();
	
			estadodetalleautoriconsepReturnGeneral.setEstadoDetalleAutoriConsep(estadodetalleautoriconsep);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleautoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadodetalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleAutoriConsepParameterReturnGeneral procesarImportacionEstadoDetalleAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleAutoriConsep.class.getSimpleName()+"-procesarImportacionEstadoDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			EstadoDetalleAutoriConsepParameterReturnGeneral estadodetalleautoriconsepReturnGeneral=new EstadoDetalleAutoriConsepParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetalleautoriconseps=new ArrayList<EstadoDetalleAutoriConsep>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetalleautoriconsep=new EstadoDetalleAutoriConsep();
				
				
				if(conColumnasBase) {this.estadodetalleautoriconsep.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetalleautoriconsep.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetalleautoriconsep.setcodigo(arrColumnas[iColumn++]);
				this.estadodetalleautoriconsep.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetalleautoriconseps.add(this.estadodetalleautoriconsep);
			}
			
			this.saveEstadoDetalleAutoriConseps();
			
			this.connexion.commit();
			
			estadodetalleautoriconsepReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetalleautoriconsepReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetalleAutoriConsepsEliminados() throws Exception {				
		
		List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsAux= new ArrayList<EstadoDetalleAutoriConsep>();
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep:estadodetalleautoriconseps) {
			if(!estadodetalleautoriconsep.getIsDeleted()) {
				estadodetalleautoriconsepsAux.add(estadodetalleautoriconsep);
			}
		}
		
		estadodetalleautoriconseps=estadodetalleautoriconsepsAux;
	}
	
	public void quitarEstadoDetalleAutoriConsepsNulos() throws Exception {				
		
		List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsAux= new ArrayList<EstadoDetalleAutoriConsep>();
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep : this.estadodetalleautoriconseps) {
			if(estadodetalleautoriconsep==null) {
				estadodetalleautoriconsepsAux.add(estadodetalleautoriconsep);
			}
		}
		
		//this.estadodetalleautoriconseps=estadodetalleautoriconsepsAux;
		
		this.estadodetalleautoriconseps.removeAll(estadodetalleautoriconsepsAux);
	}
	
	public void getSetVersionRowEstadoDetalleAutoriConsepWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetalleautoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetalleautoriconsep.getIsDeleted() || (estadodetalleautoriconsep.getIsChanged()&&!estadodetalleautoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetalleautoriconsepDataAccess.getSetVersionRowEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsep.getId());
				
				if(!estadodetalleautoriconsep.getVersionRow().equals(timestamp)) {	
					estadodetalleautoriconsep.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetalleautoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetalleAutoriConsep()throws Exception {	
		
		if(estadodetalleautoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetalleautoriconsep.getIsDeleted() || (estadodetalleautoriconsep.getIsChanged()&&!estadodetalleautoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetalleautoriconsepDataAccess.getSetVersionRowEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsep.getId());
			
			try {							
				if(!estadodetalleautoriconsep.getVersionRow().equals(timestamp)) {	
					estadodetalleautoriconsep.setVersionRow(timestamp);
				}
				
				estadodetalleautoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetalleAutoriConsepsWithConnection()throws Exception {	
		if(estadodetalleautoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux:estadodetalleautoriconseps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetalleautoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleautoriconsepAux.getIsDeleted() || (estadodetalleautoriconsepAux.getIsChanged()&&!estadodetalleautoriconsepAux.getIsNew())) {
						
						timestamp=estadodetalleautoriconsepDataAccess.getSetVersionRowEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsepAux.getId());
						
						if(!estadodetalleautoriconsep.getVersionRow().equals(timestamp)) {	
							estadodetalleautoriconsepAux.setVersionRow(timestamp);
						}
								
						estadodetalleautoriconsepAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetalleAutoriConseps()throws Exception {	
		if(estadodetalleautoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux:estadodetalleautoriconseps) {
					if(estadodetalleautoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleautoriconsepAux.getIsDeleted() || (estadodetalleautoriconsepAux.getIsChanged()&&!estadodetalleautoriconsepAux.getIsNew())) {
						
						timestamp=estadodetalleautoriconsepDataAccess.getSetVersionRowEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsepAux.getId());
						
						if(!estadodetalleautoriconsepAux.getVersionRow().equals(timestamp)) {	
							estadodetalleautoriconsepAux.setVersionRow(timestamp);
						}
						
													
						estadodetalleautoriconsepAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(EstadoDetalleAutoriConsep estadodetalleautoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoDetalleAutoriConsepLogicAdditional.updateEstadoDetalleAutoriConsepToGet(estadodetalleautoriconsep,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetalleAutoriConsep estadodetalleautoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleAutoriConsep.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetalleautoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(estadodetalleautoriconsep);
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
			this.deepLoad(this.estadodetalleautoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(this.estadodetalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleAutoriConsep.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetalleautoriconseps!=null) {
				for(EstadoDetalleAutoriConsep estadodetalleautoriconsep:estadodetalleautoriconseps) {
					this.deepLoad(estadodetalleautoriconsep,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
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
			if(estadodetalleautoriconseps!=null) {
				for(EstadoDetalleAutoriConsep estadodetalleautoriconsep:estadodetalleautoriconseps) {
					this.deepLoad(estadodetalleautoriconsep,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(estadodetalleautoriconseps);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleAutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleAutoriConsepDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetalleAutoriConsep estadodetalleautoriconsep,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleAutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetalleautoriconsep.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleAutoriConsepDataAccess.TABLENAME, estadodetalleautoriconsep.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleAutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleAutoriConsepLogic.registrarAuditoriaDetallesEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetalleautoriconsep.getIsDeleted()) {
					/*if(!estadodetalleautoriconsep.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetalleAutoriConsepDataAccess.TABLENAME, estadodetalleautoriconsep.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetalleAutoriConsepLogic.registrarAuditoriaDetallesEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsep,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleAutoriConsepDataAccess.TABLENAME, estadodetalleautoriconsep.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetalleautoriconsep.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleAutoriConsepDataAccess.TABLENAME, estadodetalleautoriconsep.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleAutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleAutoriConsepLogic.registrarAuditoriaDetallesEstadoDetalleAutoriConsep(connexion,estadodetalleautoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetalleAutoriConsep(Connexion connexion,EstadoDetalleAutoriConsep estadodetalleautoriconsep)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetalleautoriconsep.getIsNew()||!estadodetalleautoriconsep.getcodigo().equals(estadodetalleautoriconsep.getEstadoDetalleAutoriConsepOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleautoriconsep.getEstadoDetalleAutoriConsepOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetalleautoriconsep.getEstadoDetalleAutoriConsepOriginal().getcodigo();
				}
				if(estadodetalleautoriconsep.getcodigo()!=null)
				{
					strValorNuevo=estadodetalleautoriconsep.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleAutoriConsepConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetalleautoriconsep.getIsNew()||!estadodetalleautoriconsep.getnombre().equals(estadodetalleautoriconsep.getEstadoDetalleAutoriConsepOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleautoriconsep.getEstadoDetalleAutoriConsepOriginal().getnombre()!=null)
				{
					strValorActual=estadodetalleautoriconsep.getEstadoDetalleAutoriConsepOriginal().getnombre();
				}
				if(estadodetalleautoriconsep.getnombre()!=null)
				{
					strValorNuevo=estadodetalleautoriconsep.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleAutoriConsepConstantesFunciones.getClassesForeignKeysOfEstadoDetalleAutoriConsep(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleAutoriConsepConstantesFunciones.getClassesRelationshipsOfEstadoDetalleAutoriConsep(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
