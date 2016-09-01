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
import com.bydan.erp.inventario.util.EstadoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoInventario;
import com.bydan.erp.inventario.business.logic.EstadoInventarioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoInventarioLogic.class);
	
	protected EstadoInventarioDataAccess estadoinventarioDataAccess; 	
	protected EstadoInventario estadoinventario;
	protected List<EstadoInventario> estadoinventarios;
	protected Object estadoinventarioObject;	
	protected List<Object> estadoinventariosObject;
	
	public static ClassValidator<EstadoInventario> estadoinventarioValidator = new ClassValidator<EstadoInventario>(EstadoInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoInventarioLogicAdditional estadoinventarioLogicAdditional=null;
	
	public EstadoInventarioLogicAdditional getEstadoInventarioLogicAdditional() {
		return this.estadoinventarioLogicAdditional;
	}
	
	public void setEstadoInventarioLogicAdditional(EstadoInventarioLogicAdditional estadoinventarioLogicAdditional) {
		try {
			this.estadoinventarioLogicAdditional=estadoinventarioLogicAdditional;
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
	
	
	
	
	public  EstadoInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoinventarioDataAccess = new EstadoInventarioDataAccess();
			
			this.estadoinventarios= new ArrayList<EstadoInventario>();
			this.estadoinventario= new EstadoInventario();
			
			this.estadoinventarioObject=new Object();
			this.estadoinventariosObject=new ArrayList<Object>();
				
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
			
			this.estadoinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoinventarioDataAccess = new EstadoInventarioDataAccess();
			this.estadoinventarios= new ArrayList<EstadoInventario>();
			this.estadoinventario= new EstadoInventario();
			this.estadoinventarioObject=new Object();
			this.estadoinventariosObject=new ArrayList<Object>();
			
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
			
			this.estadoinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoInventario getEstadoInventario() throws Exception {	
		EstadoInventarioLogicAdditional.checkEstadoInventarioToGet(estadoinventario,this.datosCliente,this.arrDatoGeneral);
		EstadoInventarioLogicAdditional.updateEstadoInventarioToGet(estadoinventario,this.arrDatoGeneral);
		
		return estadoinventario;
	}
		
	public void setEstadoInventario(EstadoInventario newEstadoInventario) {
		this.estadoinventario = newEstadoInventario;
	}
	
	public EstadoInventarioDataAccess getEstadoInventarioDataAccess() {
		return estadoinventarioDataAccess;
	}
	
	public void setEstadoInventarioDataAccess(EstadoInventarioDataAccess newestadoinventarioDataAccess) {
		this.estadoinventarioDataAccess = newestadoinventarioDataAccess;
	}
	
	public List<EstadoInventario> getEstadoInventarios() throws Exception {		
		this.quitarEstadoInventariosNulos();
		
		EstadoInventarioLogicAdditional.checkEstadoInventarioToGets(estadoinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoInventario estadoinventarioLocal: estadoinventarios ) {
			EstadoInventarioLogicAdditional.updateEstadoInventarioToGet(estadoinventarioLocal,this.arrDatoGeneral);
		}
		
		return estadoinventarios;
	}
	
	public void setEstadoInventarios(List<EstadoInventario> newEstadoInventarios) {
		this.estadoinventarios = newEstadoInventarios;
	}
	
	public Object getEstadoInventarioObject() {	
		this.estadoinventarioObject=this.estadoinventarioDataAccess.getEntityObject();
		return this.estadoinventarioObject;
	}
		
	public void setEstadoInventarioObject(Object newEstadoInventarioObject) {
		this.estadoinventarioObject = newEstadoInventarioObject;
	}
	
	public List<Object> getEstadoInventariosObject() {		
		this.estadoinventariosObject=this.estadoinventarioDataAccess.getEntitiesObject();
		return this.estadoinventariosObject;
	}
		
	public void setEstadoInventariosObject(List<Object> newEstadoInventariosObject) {
		this.estadoinventariosObject = newEstadoInventariosObject;
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
		
		if(this.estadoinventarioDataAccess!=null) {
			this.estadoinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoinventario = new  EstadoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoinventario=estadoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
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
		estadoinventario = new  EstadoInventario();
		  		  
        try {
			
			estadoinventario=estadoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoinventario = new  EstadoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoinventario=estadoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
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
		estadoinventario = new  EstadoInventario();
		  		  
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
		estadoinventario = new  EstadoInventario();
		  		  
        try {
			
			estadoinventario=estadoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoinventario = new  EstadoInventario();
		  		  
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
		estadoinventario = new  EstadoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoinventario = new  EstadoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoinventario = new  EstadoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoinventario = new  EstadoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoinventario = new  EstadoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoinventario = new  EstadoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
        try {			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
        try {
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoinventario = new  EstadoInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventario=estadoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
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
		estadoinventario = new  EstadoInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventario=estadoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
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
		estadoinventarios = new  ArrayList<EstadoInventario>();
		  		  
        try {
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoinventarios = new  ArrayList<EstadoInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-getTodosEstadoInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
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
	
	public  void  getTodosEstadoInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		estadoinventarios = new  ArrayList<EstadoInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoinventarios=estadoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoInventario(estadoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoInventario(EstadoInventario estadoinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoinventario.getIsNew() || estadoinventario.getIsChanged()) { 
			this.invalidValues = estadoinventarioValidator.getInvalidValues(estadoinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoInventario(List<EstadoInventario> EstadoInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoInventario estadoinventarioLocal:estadoinventarios) {				
			estaValidadoObjeto=this.validarGuardarEstadoInventario(estadoinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoInventario(List<EstadoInventario> EstadoInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoInventario(estadoinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoInventario(EstadoInventario EstadoInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoInventario(estadoinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoInventario estadoinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoInventarioConstantesFunciones.getEstadoInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-saveEstadoInventarioWithConnection");connexion.begin();			
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSave(this.estadoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoInventarioLogicAdditional.updateEstadoInventarioToSave(this.estadoinventario,this.arrDatoGeneral);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoInventario(this.estadoinventario)) {
				EstadoInventarioDataAccess.save(this.estadoinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSaveAfter(this.estadoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoInventario();
			
			connexion.commit();			
			
			if(this.estadoinventario.getIsDeleted()) {
				this.estadoinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoInventario()throws Exception {	
		try {	
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSave(this.estadoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoInventarioLogicAdditional.updateEstadoInventarioToSave(this.estadoinventario,this.arrDatoGeneral);
			
			EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoInventario(this.estadoinventario)) {			
				EstadoInventarioDataAccess.save(this.estadoinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSaveAfter(this.estadoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoinventario.getIsDeleted()) {
				this.estadoinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-saveEstadoInventariosWithConnection");connexion.begin();			
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSaves(estadoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoInventarios();
			
			Boolean validadoTodosEstadoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoInventario estadoinventarioLocal:estadoinventarios) {		
				if(estadoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoInventarioLogicAdditional.updateEstadoInventarioToSave(estadoinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoInventario(estadoinventarioLocal)) {
					EstadoInventarioDataAccess.save(estadoinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoInventario=false;
				}
			}
			
			if(!validadoTodosEstadoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSavesAfter(estadoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoInventarios();
			
			connexion.commit();		
			
			this.quitarEstadoInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoInventarios()throws Exception {				
		 try {	
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSaves(estadoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoInventario estadoinventarioLocal:estadoinventarios) {				
				if(estadoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoInventarioLogicAdditional.updateEstadoInventarioToSave(estadoinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoInventario(estadoinventarioLocal)) {				
					EstadoInventarioDataAccess.save(estadoinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoInventario=false;
				}
			}
			
			if(!validadoTodosEstadoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoInventarioLogicAdditional.checkEstadoInventarioToSavesAfter(estadoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoInventarioParameterReturnGeneral procesarAccionEstadoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoInventario> estadoinventarios,EstadoInventarioParameterReturnGeneral estadoinventarioParameterGeneral)throws Exception {
		 try {	
			EstadoInventarioParameterReturnGeneral estadoinventarioReturnGeneral=new EstadoInventarioParameterReturnGeneral();
	
			EstadoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoinventarios,estadoinventarioParameterGeneral,estadoinventarioReturnGeneral);
			
			return estadoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoInventarioParameterReturnGeneral procesarAccionEstadoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoInventario> estadoinventarios,EstadoInventarioParameterReturnGeneral estadoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-procesarAccionEstadoInventariosWithConnection");connexion.begin();			
			
			EstadoInventarioParameterReturnGeneral estadoinventarioReturnGeneral=new EstadoInventarioParameterReturnGeneral();
	
			EstadoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoinventarios,estadoinventarioParameterGeneral,estadoinventarioReturnGeneral);
			
			this.connexion.commit();
			
			return estadoinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoInventarioParameterReturnGeneral procesarEventosEstadoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoInventario> estadoinventarios,EstadoInventario estadoinventario,EstadoInventarioParameterReturnGeneral estadoinventarioParameterGeneral,Boolean isEsNuevoEstadoInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoInventarioParameterReturnGeneral estadoinventarioReturnGeneral=new EstadoInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoinventarios,estadoinventario,estadoinventarioParameterGeneral,estadoinventarioReturnGeneral,isEsNuevoEstadoInventario,clases);
			
			return estadoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoInventarioParameterReturnGeneral procesarEventosEstadoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoInventario> estadoinventarios,EstadoInventario estadoinventario,EstadoInventarioParameterReturnGeneral estadoinventarioParameterGeneral,Boolean isEsNuevoEstadoInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-procesarEventosEstadoInventariosWithConnection");connexion.begin();			
			
			EstadoInventarioParameterReturnGeneral estadoinventarioReturnGeneral=new EstadoInventarioParameterReturnGeneral();
	
			estadoinventarioReturnGeneral.setEstadoInventario(estadoinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoinventarios,estadoinventario,estadoinventarioParameterGeneral,estadoinventarioReturnGeneral,isEsNuevoEstadoInventario,clases);
			
			this.connexion.commit();
			
			return estadoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoInventarioParameterReturnGeneral procesarImportacionEstadoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoInventarioParameterReturnGeneral estadoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-procesarImportacionEstadoInventariosWithConnection");connexion.begin();			
			
			EstadoInventarioParameterReturnGeneral estadoinventarioReturnGeneral=new EstadoInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoinventarios=new ArrayList<EstadoInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoinventario=new EstadoInventario();
				
				
				if(conColumnasBase) {this.estadoinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoinventario.setcodigo(arrColumnas[iColumn++]);
				this.estadoinventario.setnombre(arrColumnas[iColumn++]);
				
				this.estadoinventarios.add(this.estadoinventario);
			}
			
			this.saveEstadoInventarios();
			
			this.connexion.commit();
			
			estadoinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			estadoinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoInventariosEliminados() throws Exception {				
		
		List<EstadoInventario> estadoinventariosAux= new ArrayList<EstadoInventario>();
		
		for(EstadoInventario estadoinventario:estadoinventarios) {
			if(!estadoinventario.getIsDeleted()) {
				estadoinventariosAux.add(estadoinventario);
			}
		}
		
		estadoinventarios=estadoinventariosAux;
	}
	
	public void quitarEstadoInventariosNulos() throws Exception {				
		
		List<EstadoInventario> estadoinventariosAux= new ArrayList<EstadoInventario>();
		
		for(EstadoInventario estadoinventario : this.estadoinventarios) {
			if(estadoinventario==null) {
				estadoinventariosAux.add(estadoinventario);
			}
		}
		
		//this.estadoinventarios=estadoinventariosAux;
		
		this.estadoinventarios.removeAll(estadoinventariosAux);
	}
	
	public void getSetVersionRowEstadoInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoinventario.getIsDeleted() || (estadoinventario.getIsChanged()&&!estadoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoinventarioDataAccess.getSetVersionRowEstadoInventario(connexion,estadoinventario.getId());
				
				if(!estadoinventario.getVersionRow().equals(timestamp)) {	
					estadoinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoInventario()throws Exception {	
		
		if(estadoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoinventario.getIsDeleted() || (estadoinventario.getIsChanged()&&!estadoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoinventarioDataAccess.getSetVersionRowEstadoInventario(connexion,estadoinventario.getId());
			
			try {							
				if(!estadoinventario.getVersionRow().equals(timestamp)) {	
					estadoinventario.setVersionRow(timestamp);
				}
				
				estadoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoInventariosWithConnection()throws Exception {	
		if(estadoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoInventario estadoinventarioAux:estadoinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoinventarioAux.getIsDeleted() || (estadoinventarioAux.getIsChanged()&&!estadoinventarioAux.getIsNew())) {
						
						timestamp=estadoinventarioDataAccess.getSetVersionRowEstadoInventario(connexion,estadoinventarioAux.getId());
						
						if(!estadoinventario.getVersionRow().equals(timestamp)) {	
							estadoinventarioAux.setVersionRow(timestamp);
						}
								
						estadoinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoInventarios()throws Exception {	
		if(estadoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoInventario estadoinventarioAux:estadoinventarios) {
					if(estadoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoinventarioAux.getIsDeleted() || (estadoinventarioAux.getIsChanged()&&!estadoinventarioAux.getIsNew())) {
						
						timestamp=estadoinventarioDataAccess.getSetVersionRowEstadoInventario(connexion,estadoinventarioAux.getId());
						
						if(!estadoinventarioAux.getVersionRow().equals(timestamp)) {	
							estadoinventarioAux.setVersionRow(timestamp);
						}
						
													
						estadoinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransferenciaLogic transferenciaLogic=new TransferenciaLogic();
			CompraLogic compraLogic=new CompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Transferencia.class));
			classes.add(new Classe(Compra.class));
											
			

			transferenciaLogic.setConnexion(this.getConnexion());
			transferenciaLogic.setDatosCliente(this.datosCliente);
			transferenciaLogic.setIsConRefrescarForeignKeys(true);

			compraLogic.setConnexion(this.getConnexion());
			compraLogic.setDatosCliente(this.datosCliente);
			compraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoInventario estadoinventario:this.estadoinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=TransferenciaConstantesFunciones.getClassesForeignKeysOfTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				transferenciaLogic.setTransferencias(estadoinventario.transferencias);
				transferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CompraConstantesFunciones.getClassesForeignKeysOfCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				compraLogic.setCompras(estadoinventario.compras);
				compraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoInventario estadoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoInventarioLogicAdditional.updateEstadoInventarioToGet(estadoinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoinventario.setTransferencias(estadoinventarioDataAccess.getTransferencias(connexion,estadoinventario));
		estadoinventario.setCompras(estadoinventarioDataAccess.getCompras(connexion,estadoinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoinventario.setTransferencias(estadoinventarioDataAccess.getTransferencias(connexion,estadoinventario));

				if(this.isConDeep) {
					TransferenciaLogic transferenciaLogic= new TransferenciaLogic(this.connexion);
					transferenciaLogic.setTransferencias(estadoinventario.getTransferencias());
					ArrayList<Classe> classesLocal=TransferenciaConstantesFunciones.getClassesForeignKeysOfTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					transferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(transferenciaLogic.getTransferencias());
					estadoinventario.setTransferencias(transferenciaLogic.getTransferencias());
				}

				continue;
			}

			if(clas.clas.equals(Compra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoinventario.setCompras(estadoinventarioDataAccess.getCompras(connexion,estadoinventario));

				if(this.isConDeep) {
					CompraLogic compraLogic= new CompraLogic(this.connexion);
					compraLogic.setCompras(estadoinventario.getCompras());
					ArrayList<Classe> classesLocal=CompraConstantesFunciones.getClassesForeignKeysOfCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					compraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(compraLogic.getCompras());
					estadoinventario.setCompras(compraLogic.getCompras());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transferencia.class));
			estadoinventario.setTransferencias(estadoinventarioDataAccess.getTransferencias(connexion,estadoinventario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Compra.class));
			estadoinventario.setCompras(estadoinventarioDataAccess.getCompras(connexion,estadoinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoinventario.setTransferencias(estadoinventarioDataAccess.getTransferencias(connexion,estadoinventario));

		for(Transferencia transferencia:estadoinventario.getTransferencias()) {
			TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
			transferenciaLogic.deepLoad(transferencia,isDeep,deepLoadType,clases);
		}

		estadoinventario.setCompras(estadoinventarioDataAccess.getCompras(connexion,estadoinventario));

		for(Compra compra:estadoinventario.getCompras()) {
			CompraLogic compraLogic= new CompraLogic(connexion);
			compraLogic.deepLoad(compra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoinventario.setTransferencias(estadoinventarioDataAccess.getTransferencias(connexion,estadoinventario));

				for(Transferencia transferencia:estadoinventario.getTransferencias()) {
					TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
					transferenciaLogic.deepLoad(transferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Compra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoinventario.setCompras(estadoinventarioDataAccess.getCompras(connexion,estadoinventario));

				for(Compra compra:estadoinventario.getCompras()) {
					CompraLogic compraLogic= new CompraLogic(connexion);
					compraLogic.deepLoad(compra,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transferencia.class));
			estadoinventario.setTransferencias(estadoinventarioDataAccess.getTransferencias(connexion,estadoinventario));

			for(Transferencia transferencia:estadoinventario.getTransferencias()) {
				TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
				transferenciaLogic.deepLoad(transferencia,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Compra.class));
			estadoinventario.setCompras(estadoinventarioDataAccess.getCompras(connexion,estadoinventario));

			for(Compra compra:estadoinventario.getCompras()) {
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepLoad(compra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoInventario estadoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoInventarioLogicAdditional.updateEstadoInventarioToSave(estadoinventario,this.arrDatoGeneral);
			
EstadoInventarioDataAccess.save(estadoinventario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Transferencia transferencia:estadoinventario.getTransferencias()) {
			transferencia.setid_estado_inventario(estadoinventario.getId());
			TransferenciaDataAccess.save(transferencia,connexion);
		}

		for(Compra compra:estadoinventario.getCompras()) {
			compra.setid_estado_inventario(estadoinventario.getId());
			CompraDataAccess.save(compra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Transferencia transferencia:estadoinventario.getTransferencias()) {
					transferencia.setid_estado_inventario(estadoinventario.getId());
					TransferenciaDataAccess.save(transferencia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Compra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Compra compra:estadoinventario.getCompras()) {
					compra.setid_estado_inventario(estadoinventario.getId());
					CompraDataAccess.save(compra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Transferencia transferencia:estadoinventario.getTransferencias()) {
			TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
			transferencia.setid_estado_inventario(estadoinventario.getId());
			TransferenciaDataAccess.save(transferencia,connexion);
			transferenciaLogic.deepSave(transferencia,isDeep,deepLoadType,clases);
		}

		for(Compra compra:estadoinventario.getCompras()) {
			CompraLogic compraLogic= new CompraLogic(connexion);
			compra.setid_estado_inventario(estadoinventario.getId());
			CompraDataAccess.save(compra,connexion);
			compraLogic.deepSave(compra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Transferencia transferencia:estadoinventario.getTransferencias()) {
					TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
					transferencia.setid_estado_inventario(estadoinventario.getId());
					TransferenciaDataAccess.save(transferencia,connexion);
					transferenciaLogic.deepSave(transferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Compra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Compra compra:estadoinventario.getCompras()) {
					CompraLogic compraLogic= new CompraLogic(connexion);
					compra.setid_estado_inventario(estadoinventario.getId());
					CompraDataAccess.save(compra,connexion);
					compraLogic.deepSave(compra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(estadoinventario);
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
			this.deepLoad(this.estadoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(this.estadoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoinventarios!=null) {
				for(EstadoInventario estadoinventario:estadoinventarios) {
					this.deepLoad(estadoinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(estadoinventarios);
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
			if(estadoinventarios!=null) {
				for(EstadoInventario estadoinventario:estadoinventarios) {
					this.deepLoad(estadoinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoInventario(estadoinventarios);
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
			this.getNewConnexionToDeep(EstadoInventario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadoinventario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoInventario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadoinventarios!=null) {
				for(EstadoInventario estadoinventario:estadoinventarios) {
					this.deepSave(estadoinventario,isDeep,deepLoadType,clases);
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
			if(estadoinventarios!=null) {
				for(EstadoInventario estadoinventario:estadoinventarios) {
					this.deepSave(estadoinventario,isDeep,deepLoadType,clases);
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
			if(EstadoInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoInventario estadoinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(estadoinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoInventarioDataAccess.TABLENAME, estadoinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoInventarioLogic.registrarAuditoriaDetallesEstadoInventario(connexion,estadoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoinventario.getIsDeleted()) {
					/*if(!estadoinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoInventarioDataAccess.TABLENAME, estadoinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoInventarioLogic.registrarAuditoriaDetallesEstadoInventario(connexion,estadoinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoInventarioDataAccess.TABLENAME, estadoinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoInventarioDataAccess.TABLENAME, estadoinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoInventarioLogic.registrarAuditoriaDetallesEstadoInventario(connexion,estadoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoInventario(Connexion connexion,EstadoInventario estadoinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoinventario.getIsNew()||!estadoinventario.getcodigo().equals(estadoinventario.getEstadoInventarioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoinventario.getEstadoInventarioOriginal().getcodigo()!=null)
				{
					strValorActual=estadoinventario.getEstadoInventarioOriginal().getcodigo();
				}
				if(estadoinventario.getcodigo()!=null)
				{
					strValorNuevo=estadoinventario.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoInventarioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoinventario.getIsNew()||!estadoinventario.getnombre().equals(estadoinventario.getEstadoInventarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoinventario.getEstadoInventarioOriginal().getnombre()!=null)
				{
					strValorActual=estadoinventario.getEstadoInventarioOriginal().getnombre();
				}
				if(estadoinventario.getnombre()!=null)
				{
					strValorNuevo=estadoinventario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoInventarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoInventarioRelacionesWithConnection(EstadoInventario estadoinventario,List<Transferencia> transferencias,List<Compra> compras) throws Exception {

		if(!estadoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoInventarioRelacionesBase(estadoinventario,transferencias,compras,true);
		}
	}

	public void saveEstadoInventarioRelaciones(EstadoInventario estadoinventario,List<Transferencia> transferencias,List<Compra> compras)throws Exception {

		if(!estadoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoInventarioRelacionesBase(estadoinventario,transferencias,compras,false);
		}
	}

	public void saveEstadoInventarioRelacionesBase(EstadoInventario estadoinventario,List<Transferencia> transferencias,List<Compra> compras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoInventario-saveRelacionesWithConnection");}
	
			estadoinventario.setTransferencias(transferencias);
			estadoinventario.setCompras(compras);

			this.setEstadoInventario(estadoinventario);

				if((estadoinventario.getIsNew()||estadoinventario.getIsChanged())&&!estadoinventario.getIsDeleted()) {
					this.saveEstadoInventario();
					this.saveEstadoInventarioRelacionesDetalles(transferencias,compras);

				} else if(estadoinventario.getIsDeleted()) {
					this.saveEstadoInventarioRelacionesDetalles(transferencias,compras);
					this.saveEstadoInventario();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TransferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresTransferencias(transferencias,true,true);
			CompraConstantesFunciones.InicializarGeneralEntityAuxiliaresCompras(compras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoInventarioRelacionesDetalles(List<Transferencia> transferencias,List<Compra> compras)throws Exception {
		try {
	

			Long idEstadoInventarioActual=this.getEstadoInventario().getId();

			TransferenciaLogic transferenciaLogic_Desde_EstadoInventario=new TransferenciaLogic();
			transferenciaLogic_Desde_EstadoInventario.setTransferencias(transferencias);

			transferenciaLogic_Desde_EstadoInventario.setConnexion(this.getConnexion());
			transferenciaLogic_Desde_EstadoInventario.setDatosCliente(this.datosCliente);

			for(Transferencia transferencia_Desde_EstadoInventario:transferenciaLogic_Desde_EstadoInventario.getTransferencias()) {
				transferencia_Desde_EstadoInventario.setid_estado_inventario(idEstadoInventarioActual);

				transferenciaLogic_Desde_EstadoInventario.setTransferencia(transferencia_Desde_EstadoInventario);
				transferenciaLogic_Desde_EstadoInventario.saveTransferencia();

				Long idTransferenciaActual=transferencia_Desde_EstadoInventario.getId();

				DetalleTransferenciaLogic detalletransferenciaLogic_Desde_Transferencia=new DetalleTransferenciaLogic();

				if(transferencia_Desde_EstadoInventario.getDetalleTransferencias()==null){
					transferencia_Desde_EstadoInventario.setDetalleTransferencias(new ArrayList<DetalleTransferencia>());
				}

				detalletransferenciaLogic_Desde_Transferencia.setDetalleTransferencias(transferencia_Desde_EstadoInventario.getDetalleTransferencias());

				detalletransferenciaLogic_Desde_Transferencia.setConnexion(this.getConnexion());
				detalletransferenciaLogic_Desde_Transferencia.setDatosCliente(this.datosCliente);

				for(DetalleTransferencia detalletransferencia_Desde_Transferencia:detalletransferenciaLogic_Desde_Transferencia.getDetalleTransferencias()) {
					detalletransferencia_Desde_Transferencia.setid_transferencia(idTransferenciaActual);
				}

				detalletransferenciaLogic_Desde_Transferencia.saveDetalleTransferencias();
			}


			CompraLogic compraLogic_Desde_EstadoInventario=new CompraLogic();
			compraLogic_Desde_EstadoInventario.setCompras(compras);

			compraLogic_Desde_EstadoInventario.setConnexion(this.getConnexion());
			compraLogic_Desde_EstadoInventario.setDatosCliente(this.datosCliente);

			for(Compra compra_Desde_EstadoInventario:compraLogic_Desde_EstadoInventario.getCompras()) {
				compra_Desde_EstadoInventario.setid_estado_inventario(idEstadoInventarioActual);

				compraLogic_Desde_EstadoInventario.setCompra(compra_Desde_EstadoInventario);
				compraLogic_Desde_EstadoInventario.saveCompra();

				Long idCompraActual=compra_Desde_EstadoInventario.getId();

				RetencionInvenLogic retencioninvenLogic_Desde_Compra=new RetencionInvenLogic();

				if(compra_Desde_EstadoInventario.getRetencionInvens()==null){
					compra_Desde_EstadoInventario.setRetencionInvens(new ArrayList<RetencionInven>());
				}

				retencioninvenLogic_Desde_Compra.setRetencionInvens(compra_Desde_EstadoInventario.getRetencionInvens());

				retencioninvenLogic_Desde_Compra.setConnexion(this.getConnexion());
				retencioninvenLogic_Desde_Compra.setDatosCliente(this.datosCliente);

				for(RetencionInven retencioninven_Desde_Compra:retencioninvenLogic_Desde_Compra.getRetencionInvens()) {
					retencioninven_Desde_Compra.setid_compra(idCompraActual);
				}

				retencioninvenLogic_Desde_Compra.saveRetencionInvens();

				TransaccionLocalLogic transaccionlocalLogic_Desde_Compra=new TransaccionLocalLogic();

				if(compra_Desde_EstadoInventario.getTransaccionLocals()==null){
					compra_Desde_EstadoInventario.setTransaccionLocals(new ArrayList<TransaccionLocal>());
				}

				transaccionlocalLogic_Desde_Compra.setTransaccionLocals(compra_Desde_EstadoInventario.getTransaccionLocals());

				transaccionlocalLogic_Desde_Compra.setConnexion(this.getConnexion());
				transaccionlocalLogic_Desde_Compra.setDatosCliente(this.datosCliente);

				for(TransaccionLocal transaccionlocal_Desde_Compra:transaccionlocalLogic_Desde_Compra.getTransaccionLocals()) {
					transaccionlocal_Desde_Compra.setid_compra(idCompraActual);
				}

				transaccionlocalLogic_Desde_Compra.saveTransaccionLocals();

				FormaPagoInvenLogic formapagoinvenLogic_Desde_Compra=new FormaPagoInvenLogic();

				if(compra_Desde_EstadoInventario.getFormaPagoInvens()==null){
					compra_Desde_EstadoInventario.setFormaPagoInvens(new ArrayList<FormaPagoInven>());
				}

				formapagoinvenLogic_Desde_Compra.setFormaPagoInvens(compra_Desde_EstadoInventario.getFormaPagoInvens());

				formapagoinvenLogic_Desde_Compra.setConnexion(this.getConnexion());
				formapagoinvenLogic_Desde_Compra.setDatosCliente(this.datosCliente);

				for(FormaPagoInven formapagoinven_Desde_Compra:formapagoinvenLogic_Desde_Compra.getFormaPagoInvens()) {
					formapagoinven_Desde_Compra.setid_compra(idCompraActual);
				}

				formapagoinvenLogic_Desde_Compra.saveFormaPagoInvens();

				DetalleCompraLogic detallecompraLogic_Desde_Compra=new DetalleCompraLogic();

				if(compra_Desde_EstadoInventario.getDetalleCompras()==null){
					compra_Desde_EstadoInventario.setDetalleCompras(new ArrayList<DetalleCompra>());
				}

				detallecompraLogic_Desde_Compra.setDetalleCompras(compra_Desde_EstadoInventario.getDetalleCompras());

				detallecompraLogic_Desde_Compra.setConnexion(this.getConnexion());
				detallecompraLogic_Desde_Compra.setDatosCliente(this.datosCliente);

				for(DetalleCompra detallecompra_Desde_Compra:detallecompraLogic_Desde_Compra.getDetalleCompras()) {
					detallecompra_Desde_Compra.setid_compra(idCompraActual);
				}

				detallecompraLogic_Desde_Compra.saveDetalleCompras();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoInventarioConstantesFunciones.getClassesForeignKeysOfEstadoInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoInventarioConstantesFunciones.getClassesRelationshipsOfEstadoInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
