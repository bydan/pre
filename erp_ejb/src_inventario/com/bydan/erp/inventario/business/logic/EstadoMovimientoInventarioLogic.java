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
import com.bydan.erp.inventario.util.EstadoMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoMovimientoInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoMovimientoInventario;
import com.bydan.erp.inventario.business.logic.EstadoMovimientoInventarioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoMovimientoInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoMovimientoInventarioLogic.class);
	
	protected EstadoMovimientoInventarioDataAccess estadomovimientoinventarioDataAccess; 	
	protected EstadoMovimientoInventario estadomovimientoinventario;
	protected List<EstadoMovimientoInventario> estadomovimientoinventarios;
	protected Object estadomovimientoinventarioObject;	
	protected List<Object> estadomovimientoinventariosObject;
	
	public static ClassValidator<EstadoMovimientoInventario> estadomovimientoinventarioValidator = new ClassValidator<EstadoMovimientoInventario>(EstadoMovimientoInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoMovimientoInventarioLogicAdditional estadomovimientoinventarioLogicAdditional=null;
	
	public EstadoMovimientoInventarioLogicAdditional getEstadoMovimientoInventarioLogicAdditional() {
		return this.estadomovimientoinventarioLogicAdditional;
	}
	
	public void setEstadoMovimientoInventarioLogicAdditional(EstadoMovimientoInventarioLogicAdditional estadomovimientoinventarioLogicAdditional) {
		try {
			this.estadomovimientoinventarioLogicAdditional=estadomovimientoinventarioLogicAdditional;
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
	
	
	
	
	public  EstadoMovimientoInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadomovimientoinventarioDataAccess = new EstadoMovimientoInventarioDataAccess();
			
			this.estadomovimientoinventarios= new ArrayList<EstadoMovimientoInventario>();
			this.estadomovimientoinventario= new EstadoMovimientoInventario();
			
			this.estadomovimientoinventarioObject=new Object();
			this.estadomovimientoinventariosObject=new ArrayList<Object>();
				
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
			
			this.estadomovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadomovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoMovimientoInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadomovimientoinventarioDataAccess = new EstadoMovimientoInventarioDataAccess();
			this.estadomovimientoinventarios= new ArrayList<EstadoMovimientoInventario>();
			this.estadomovimientoinventario= new EstadoMovimientoInventario();
			this.estadomovimientoinventarioObject=new Object();
			this.estadomovimientoinventariosObject=new ArrayList<Object>();
			
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
			
			this.estadomovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadomovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoMovimientoInventario getEstadoMovimientoInventario() throws Exception {	
		EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToGet(estadomovimientoinventario,this.datosCliente,this.arrDatoGeneral);
		EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToGet(estadomovimientoinventario,this.arrDatoGeneral);
		
		return estadomovimientoinventario;
	}
		
	public void setEstadoMovimientoInventario(EstadoMovimientoInventario newEstadoMovimientoInventario) {
		this.estadomovimientoinventario = newEstadoMovimientoInventario;
	}
	
	public EstadoMovimientoInventarioDataAccess getEstadoMovimientoInventarioDataAccess() {
		return estadomovimientoinventarioDataAccess;
	}
	
	public void setEstadoMovimientoInventarioDataAccess(EstadoMovimientoInventarioDataAccess newestadomovimientoinventarioDataAccess) {
		this.estadomovimientoinventarioDataAccess = newestadomovimientoinventarioDataAccess;
	}
	
	public List<EstadoMovimientoInventario> getEstadoMovimientoInventarios() throws Exception {		
		this.quitarEstadoMovimientoInventariosNulos();
		
		EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToGets(estadomovimientoinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoMovimientoInventario estadomovimientoinventarioLocal: estadomovimientoinventarios ) {
			EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToGet(estadomovimientoinventarioLocal,this.arrDatoGeneral);
		}
		
		return estadomovimientoinventarios;
	}
	
	public void setEstadoMovimientoInventarios(List<EstadoMovimientoInventario> newEstadoMovimientoInventarios) {
		this.estadomovimientoinventarios = newEstadoMovimientoInventarios;
	}
	
	public Object getEstadoMovimientoInventarioObject() {	
		this.estadomovimientoinventarioObject=this.estadomovimientoinventarioDataAccess.getEntityObject();
		return this.estadomovimientoinventarioObject;
	}
		
	public void setEstadoMovimientoInventarioObject(Object newEstadoMovimientoInventarioObject) {
		this.estadomovimientoinventarioObject = newEstadoMovimientoInventarioObject;
	}
	
	public List<Object> getEstadoMovimientoInventariosObject() {		
		this.estadomovimientoinventariosObject=this.estadomovimientoinventarioDataAccess.getEntitiesObject();
		return this.estadomovimientoinventariosObject;
	}
		
	public void setEstadoMovimientoInventariosObject(List<Object> newEstadoMovimientoInventariosObject) {
		this.estadomovimientoinventariosObject = newEstadoMovimientoInventariosObject;
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
		
		if(this.estadomovimientoinventarioDataAccess!=null) {
			this.estadomovimientoinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadomovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadomovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadomovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  		  
        try {
			
			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadomovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadomovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  		  
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  		  
        try {
			
			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadomovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  		  
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadomovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadomovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadomovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadomovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadomovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadomovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
        try {			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
        try {
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
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
		estadomovimientoinventario = new  EstadoMovimientoInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
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
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		  		  
        try {
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoMovimientoInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-getTodosEstadoMovimientoInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
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
	
	public  void  getTodosEstadoMovimientoInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		estadomovimientoinventarios = new  ArrayList<EstadoMovimientoInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadomovimientoinventarios=estadomovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoMovimientoInventario(estadomovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(estadomovimientoinventario.getIsNew() || estadomovimientoinventario.getIsChanged()) { 
			this.invalidValues = estadomovimientoinventarioValidator.getInvalidValues(estadomovimientoinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadomovimientoinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoMovimientoInventario(List<EstadoMovimientoInventario> EstadoMovimientoInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoMovimientoInventario estadomovimientoinventarioLocal:estadomovimientoinventarios) {				
			estaValidadoObjeto=this.validarGuardarEstadoMovimientoInventario(estadomovimientoinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoMovimientoInventario(List<EstadoMovimientoInventario> EstadoMovimientoInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoMovimientoInventario(estadomovimientoinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoMovimientoInventario(EstadoMovimientoInventario EstadoMovimientoInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoMovimientoInventario(estadomovimientoinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoMovimientoInventario estadomovimientoinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadomovimientoinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoMovimientoInventarioConstantesFunciones.getEstadoMovimientoInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadomovimientoinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoMovimientoInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-saveEstadoMovimientoInventarioWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSave(this.estadomovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToSave(this.estadomovimientoinventario,this.arrDatoGeneral);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadomovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoMovimientoInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoMovimientoInventario(this.estadomovimientoinventario)) {
				EstadoMovimientoInventarioDataAccess.save(this.estadomovimientoinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadomovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSaveAfter(this.estadomovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoMovimientoInventario();
			
			connexion.commit();			
			
			if(this.estadomovimientoinventario.getIsDeleted()) {
				this.estadomovimientoinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoMovimientoInventario()throws Exception {	
		try {	
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSave(this.estadomovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToSave(this.estadomovimientoinventario,this.arrDatoGeneral);
			
			EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadomovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoMovimientoInventario(this.estadomovimientoinventario)) {			
				EstadoMovimientoInventarioDataAccess.save(this.estadomovimientoinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadomovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSaveAfter(this.estadomovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadomovimientoinventario.getIsDeleted()) {
				this.estadomovimientoinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoMovimientoInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-saveEstadoMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSaves(estadomovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoMovimientoInventarios();
			
			Boolean validadoTodosEstadoMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoMovimientoInventario estadomovimientoinventarioLocal:estadomovimientoinventarios) {		
				if(estadomovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToSave(estadomovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadomovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoMovimientoInventario(estadomovimientoinventarioLocal)) {
					EstadoMovimientoInventarioDataAccess.save(estadomovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosEstadoMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSavesAfter(estadomovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoMovimientoInventarios();
			
			connexion.commit();		
			
			this.quitarEstadoMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoMovimientoInventarios()throws Exception {				
		 try {	
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSaves(estadomovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoMovimientoInventario estadomovimientoinventarioLocal:estadomovimientoinventarios) {				
				if(estadomovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToSave(estadomovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadomovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoMovimientoInventario(estadomovimientoinventarioLocal)) {				
					EstadoMovimientoInventarioDataAccess.save(estadomovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosEstadoMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoMovimientoInventarioLogicAdditional.checkEstadoMovimientoInventarioToSavesAfter(estadomovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoMovimientoInventarioParameterReturnGeneral procesarAccionEstadoMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoMovimientoInventario> estadomovimientoinventarios,EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioParameterGeneral)throws Exception {
		 try {	
			EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioReturnGeneral=new EstadoMovimientoInventarioParameterReturnGeneral();
	
			EstadoMovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadomovimientoinventarios,estadomovimientoinventarioParameterGeneral,estadomovimientoinventarioReturnGeneral);
			
			return estadomovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoMovimientoInventarioParameterReturnGeneral procesarAccionEstadoMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoMovimientoInventario> estadomovimientoinventarios,EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-procesarAccionEstadoMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioReturnGeneral=new EstadoMovimientoInventarioParameterReturnGeneral();
	
			EstadoMovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadomovimientoinventarios,estadomovimientoinventarioParameterGeneral,estadomovimientoinventarioReturnGeneral);
			
			this.connexion.commit();
			
			return estadomovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoMovimientoInventarioParameterReturnGeneral procesarEventosEstadoMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoMovimientoInventario> estadomovimientoinventarios,EstadoMovimientoInventario estadomovimientoinventario,EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioParameterGeneral,Boolean isEsNuevoEstadoMovimientoInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioReturnGeneral=new EstadoMovimientoInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadomovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoMovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadomovimientoinventarios,estadomovimientoinventario,estadomovimientoinventarioParameterGeneral,estadomovimientoinventarioReturnGeneral,isEsNuevoEstadoMovimientoInventario,clases);
			
			return estadomovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoMovimientoInventarioParameterReturnGeneral procesarEventosEstadoMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoMovimientoInventario> estadomovimientoinventarios,EstadoMovimientoInventario estadomovimientoinventario,EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioParameterGeneral,Boolean isEsNuevoEstadoMovimientoInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-procesarEventosEstadoMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioReturnGeneral=new EstadoMovimientoInventarioParameterReturnGeneral();
	
			estadomovimientoinventarioReturnGeneral.setEstadoMovimientoInventario(estadomovimientoinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadomovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoMovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadomovimientoinventarios,estadomovimientoinventario,estadomovimientoinventarioParameterGeneral,estadomovimientoinventarioReturnGeneral,isEsNuevoEstadoMovimientoInventario,clases);
			
			this.connexion.commit();
			
			return estadomovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoMovimientoInventarioParameterReturnGeneral procesarImportacionEstadoMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-procesarImportacionEstadoMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoMovimientoInventarioParameterReturnGeneral estadomovimientoinventarioReturnGeneral=new EstadoMovimientoInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadomovimientoinventarios=new ArrayList<EstadoMovimientoInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadomovimientoinventario=new EstadoMovimientoInventario();
				
				
				if(conColumnasBase) {this.estadomovimientoinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadomovimientoinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadomovimientoinventario.setcodigo(arrColumnas[iColumn++]);
				this.estadomovimientoinventario.setnombre(arrColumnas[iColumn++]);
				
				this.estadomovimientoinventarios.add(this.estadomovimientoinventario);
			}
			
			this.saveEstadoMovimientoInventarios();
			
			this.connexion.commit();
			
			estadomovimientoinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			estadomovimientoinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadomovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoMovimientoInventariosEliminados() throws Exception {				
		
		List<EstadoMovimientoInventario> estadomovimientoinventariosAux= new ArrayList<EstadoMovimientoInventario>();
		
		for(EstadoMovimientoInventario estadomovimientoinventario:estadomovimientoinventarios) {
			if(!estadomovimientoinventario.getIsDeleted()) {
				estadomovimientoinventariosAux.add(estadomovimientoinventario);
			}
		}
		
		estadomovimientoinventarios=estadomovimientoinventariosAux;
	}
	
	public void quitarEstadoMovimientoInventariosNulos() throws Exception {				
		
		List<EstadoMovimientoInventario> estadomovimientoinventariosAux= new ArrayList<EstadoMovimientoInventario>();
		
		for(EstadoMovimientoInventario estadomovimientoinventario : this.estadomovimientoinventarios) {
			if(estadomovimientoinventario==null) {
				estadomovimientoinventariosAux.add(estadomovimientoinventario);
			}
		}
		
		//this.estadomovimientoinventarios=estadomovimientoinventariosAux;
		
		this.estadomovimientoinventarios.removeAll(estadomovimientoinventariosAux);
	}
	
	public void getSetVersionRowEstadoMovimientoInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadomovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadomovimientoinventario.getIsDeleted() || (estadomovimientoinventario.getIsChanged()&&!estadomovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadomovimientoinventarioDataAccess.getSetVersionRowEstadoMovimientoInventario(connexion,estadomovimientoinventario.getId());
				
				if(!estadomovimientoinventario.getVersionRow().equals(timestamp)) {	
					estadomovimientoinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadomovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoMovimientoInventario()throws Exception {	
		
		if(estadomovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadomovimientoinventario.getIsDeleted() || (estadomovimientoinventario.getIsChanged()&&!estadomovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadomovimientoinventarioDataAccess.getSetVersionRowEstadoMovimientoInventario(connexion,estadomovimientoinventario.getId());
			
			try {							
				if(!estadomovimientoinventario.getVersionRow().equals(timestamp)) {	
					estadomovimientoinventario.setVersionRow(timestamp);
				}
				
				estadomovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoMovimientoInventariosWithConnection()throws Exception {	
		if(estadomovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoMovimientoInventario estadomovimientoinventarioAux:estadomovimientoinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadomovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadomovimientoinventarioAux.getIsDeleted() || (estadomovimientoinventarioAux.getIsChanged()&&!estadomovimientoinventarioAux.getIsNew())) {
						
						timestamp=estadomovimientoinventarioDataAccess.getSetVersionRowEstadoMovimientoInventario(connexion,estadomovimientoinventarioAux.getId());
						
						if(!estadomovimientoinventario.getVersionRow().equals(timestamp)) {	
							estadomovimientoinventarioAux.setVersionRow(timestamp);
						}
								
						estadomovimientoinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoMovimientoInventarios()throws Exception {	
		if(estadomovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoMovimientoInventario estadomovimientoinventarioAux:estadomovimientoinventarios) {
					if(estadomovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadomovimientoinventarioAux.getIsDeleted() || (estadomovimientoinventarioAux.getIsChanged()&&!estadomovimientoinventarioAux.getIsNew())) {
						
						timestamp=estadomovimientoinventarioDataAccess.getSetVersionRowEstadoMovimientoInventario(connexion,estadomovimientoinventarioAux.getId());
						
						if(!estadomovimientoinventarioAux.getVersionRow().equals(timestamp)) {	
							estadomovimientoinventarioAux.setVersionRow(timestamp);
						}
						
													
						estadomovimientoinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoMovimientoInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			MovimientoInventarioLogic movimientoinventarioLogic=new MovimientoInventarioLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoMovimientoInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoMovimientoInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(MovimientoInventario.class));
											
			

			movimientoinventarioLogic.setConnexion(this.getConnexion());
			movimientoinventarioLogic.setDatosCliente(this.datosCliente);
			movimientoinventarioLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoMovimientoInventario estadomovimientoinventario:this.estadomovimientoinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=MovimientoInventarioConstantesFunciones.getClassesForeignKeysOfMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);

				movimientoinventarioLogic.setMovimientoInventarios(estadomovimientoinventario.movimientoinventarios);
				movimientoinventarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoMovimientoInventario estadomovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToGet(estadomovimientoinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadomovimientoinventario.setMovimientoInventarios(estadomovimientoinventarioDataAccess.getMovimientoInventarios(connexion,estadomovimientoinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadomovimientoinventario.setMovimientoInventarios(estadomovimientoinventarioDataAccess.getMovimientoInventarios(connexion,estadomovimientoinventario));

				if(this.isConDeep) {
					MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(this.connexion);
					movimientoinventarioLogic.setMovimientoInventarios(estadomovimientoinventario.getMovimientoInventarios());
					ArrayList<Classe> classesLocal=MovimientoInventarioConstantesFunciones.getClassesForeignKeysOfMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
					movimientoinventarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(movimientoinventarioLogic.getMovimientoInventarios());
					estadomovimientoinventario.setMovimientoInventarios(movimientoinventarioLogic.getMovimientoInventarios());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MovimientoInventario.class));
			estadomovimientoinventario.setMovimientoInventarios(estadomovimientoinventarioDataAccess.getMovimientoInventarios(connexion,estadomovimientoinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadomovimientoinventario.setMovimientoInventarios(estadomovimientoinventarioDataAccess.getMovimientoInventarios(connexion,estadomovimientoinventario));

		for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
			MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
			movimientoinventarioLogic.deepLoad(movimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadomovimientoinventario.setMovimientoInventarios(estadomovimientoinventarioDataAccess.getMovimientoInventarios(connexion,estadomovimientoinventario));

				for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
					MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
					movimientoinventarioLogic.deepLoad(movimientoinventario,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MovimientoInventario.class));
			estadomovimientoinventario.setMovimientoInventarios(estadomovimientoinventarioDataAccess.getMovimientoInventarios(connexion,estadomovimientoinventario));

			for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
				MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
				movimientoinventarioLogic.deepLoad(movimientoinventario,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoMovimientoInventario estadomovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoMovimientoInventarioLogicAdditional.updateEstadoMovimientoInventarioToSave(estadomovimientoinventario,this.arrDatoGeneral);
			
EstadoMovimientoInventarioDataAccess.save(estadomovimientoinventario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
			movimientoinventario.setid_estado_movimiento_inventario(estadomovimientoinventario.getId());
			MovimientoInventarioDataAccess.save(movimientoinventario,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(MovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
					movimientoinventario.setid_estado_movimiento_inventario(estadomovimientoinventario.getId());
					MovimientoInventarioDataAccess.save(movimientoinventario,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
			MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
			movimientoinventario.setid_estado_movimiento_inventario(estadomovimientoinventario.getId());
			MovimientoInventarioDataAccess.save(movimientoinventario,connexion);
			movimientoinventarioLogic.deepSave(movimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(MovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MovimientoInventario movimientoinventario:estadomovimientoinventario.getMovimientoInventarios()) {
					MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
					movimientoinventario.setid_estado_movimiento_inventario(estadomovimientoinventario.getId());
					MovimientoInventarioDataAccess.save(movimientoinventario,connexion);
					movimientoinventarioLogic.deepSave(movimientoinventario,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoMovimientoInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadomovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(estadomovimientoinventario);
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
			this.deepLoad(this.estadomovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(this.estadomovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoMovimientoInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadomovimientoinventarios!=null) {
				for(EstadoMovimientoInventario estadomovimientoinventario:estadomovimientoinventarios) {
					this.deepLoad(estadomovimientoinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(estadomovimientoinventarios);
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
			if(estadomovimientoinventarios!=null) {
				for(EstadoMovimientoInventario estadomovimientoinventario:estadomovimientoinventarios) {
					this.deepLoad(estadomovimientoinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoMovimientoInventario(estadomovimientoinventarios);
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
			this.getNewConnexionToDeep(EstadoMovimientoInventario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadomovimientoinventario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoMovimientoInventario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadomovimientoinventarios!=null) {
				for(EstadoMovimientoInventario estadomovimientoinventario:estadomovimientoinventarios) {
					this.deepSave(estadomovimientoinventario,isDeep,deepLoadType,clases);
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
			if(estadomovimientoinventarios!=null) {
				for(EstadoMovimientoInventario estadomovimientoinventario:estadomovimientoinventarios) {
					this.deepSave(estadomovimientoinventario,isDeep,deepLoadType,clases);
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
			if(EstadoMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoMovimientoInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoMovimientoInventario estadomovimientoinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(estadomovimientoinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoMovimientoInventarioDataAccess.TABLENAME, estadomovimientoinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoMovimientoInventarioLogic.registrarAuditoriaDetallesEstadoMovimientoInventario(connexion,estadomovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadomovimientoinventario.getIsDeleted()) {
					/*if(!estadomovimientoinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoMovimientoInventarioDataAccess.TABLENAME, estadomovimientoinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoMovimientoInventarioLogic.registrarAuditoriaDetallesEstadoMovimientoInventario(connexion,estadomovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoMovimientoInventarioDataAccess.TABLENAME, estadomovimientoinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadomovimientoinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoMovimientoInventarioDataAccess.TABLENAME, estadomovimientoinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoMovimientoInventarioLogic.registrarAuditoriaDetallesEstadoMovimientoInventario(connexion,estadomovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoMovimientoInventario(Connexion connexion,EstadoMovimientoInventario estadomovimientoinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadomovimientoinventario.getIsNew()||!estadomovimientoinventario.getcodigo().equals(estadomovimientoinventario.getEstadoMovimientoInventarioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadomovimientoinventario.getEstadoMovimientoInventarioOriginal().getcodigo()!=null)
				{
					strValorActual=estadomovimientoinventario.getEstadoMovimientoInventarioOriginal().getcodigo();
				}
				if(estadomovimientoinventario.getcodigo()!=null)
				{
					strValorNuevo=estadomovimientoinventario.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoMovimientoInventarioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadomovimientoinventario.getIsNew()||!estadomovimientoinventario.getnombre().equals(estadomovimientoinventario.getEstadoMovimientoInventarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadomovimientoinventario.getEstadoMovimientoInventarioOriginal().getnombre()!=null)
				{
					strValorActual=estadomovimientoinventario.getEstadoMovimientoInventarioOriginal().getnombre();
				}
				if(estadomovimientoinventario.getnombre()!=null)
				{
					strValorNuevo=estadomovimientoinventario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoMovimientoInventarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoMovimientoInventarioRelacionesWithConnection(EstadoMovimientoInventario estadomovimientoinventario,List<MovimientoInventario> movimientoinventarios) throws Exception {

		if(!estadomovimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoMovimientoInventarioRelacionesBase(estadomovimientoinventario,movimientoinventarios,true);
		}
	}

	public void saveEstadoMovimientoInventarioRelaciones(EstadoMovimientoInventario estadomovimientoinventario,List<MovimientoInventario> movimientoinventarios)throws Exception {

		if(!estadomovimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoMovimientoInventarioRelacionesBase(estadomovimientoinventario,movimientoinventarios,false);
		}
	}

	public void saveEstadoMovimientoInventarioRelacionesBase(EstadoMovimientoInventario estadomovimientoinventario,List<MovimientoInventario> movimientoinventarios,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoMovimientoInventario-saveRelacionesWithConnection");}
	
			estadomovimientoinventario.setMovimientoInventarios(movimientoinventarios);

			this.setEstadoMovimientoInventario(estadomovimientoinventario);

				if((estadomovimientoinventario.getIsNew()||estadomovimientoinventario.getIsChanged())&&!estadomovimientoinventario.getIsDeleted()) {
					this.saveEstadoMovimientoInventario();
					this.saveEstadoMovimientoInventarioRelacionesDetalles(movimientoinventarios);

				} else if(estadomovimientoinventario.getIsDeleted()) {
					this.saveEstadoMovimientoInventarioRelacionesDetalles(movimientoinventarios);
					this.saveEstadoMovimientoInventario();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			MovimientoInventarioConstantesFunciones.InicializarGeneralEntityAuxiliaresMovimientoInventarios(movimientoinventarios,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoMovimientoInventarioRelacionesDetalles(List<MovimientoInventario> movimientoinventarios)throws Exception {
		try {
	

			Long idEstadoMovimientoInventarioActual=this.getEstadoMovimientoInventario().getId();

			MovimientoInventarioLogic movimientoinventarioLogic_Desde_EstadoMovimientoInventario=new MovimientoInventarioLogic();
			movimientoinventarioLogic_Desde_EstadoMovimientoInventario.setMovimientoInventarios(movimientoinventarios);

			movimientoinventarioLogic_Desde_EstadoMovimientoInventario.setConnexion(this.getConnexion());
			movimientoinventarioLogic_Desde_EstadoMovimientoInventario.setDatosCliente(this.datosCliente);

			for(MovimientoInventario movimientoinventario_Desde_EstadoMovimientoInventario:movimientoinventarioLogic_Desde_EstadoMovimientoInventario.getMovimientoInventarios()) {
				movimientoinventario_Desde_EstadoMovimientoInventario.setid_estado_movimiento_inventario(idEstadoMovimientoInventarioActual);

				movimientoinventarioLogic_Desde_EstadoMovimientoInventario.setMovimientoInventario(movimientoinventario_Desde_EstadoMovimientoInventario);
				movimientoinventarioLogic_Desde_EstadoMovimientoInventario.saveMovimientoInventario();

				Long idMovimientoInventarioActual=movimientoinventario_Desde_EstadoMovimientoInventario.getId();

				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic_Desde_MovimientoInventario=new DetalleMovimientoInventarioLogic();

				if(movimientoinventario_Desde_EstadoMovimientoInventario.getDetalleMovimientoInventarios()==null){
					movimientoinventario_Desde_EstadoMovimientoInventario.setDetalleMovimientoInventarios(new ArrayList<DetalleMovimientoInventario>());
				}

				detallemovimientoinventarioLogic_Desde_MovimientoInventario.setDetalleMovimientoInventarios(movimientoinventario_Desde_EstadoMovimientoInventario.getDetalleMovimientoInventarios());

				detallemovimientoinventarioLogic_Desde_MovimientoInventario.setConnexion(this.getConnexion());
				detallemovimientoinventarioLogic_Desde_MovimientoInventario.setDatosCliente(this.datosCliente);

				for(DetalleMovimientoInventario detallemovimientoinventario_Desde_MovimientoInventario:detallemovimientoinventarioLogic_Desde_MovimientoInventario.getDetalleMovimientoInventarios()) {
					detallemovimientoinventario_Desde_MovimientoInventario.setid_movimiento_inventario(idMovimientoInventarioActual);

					detallemovimientoinventarioLogic_Desde_MovimientoInventario.setDetalleMovimientoInventario(detallemovimientoinventario_Desde_MovimientoInventario);
					detallemovimientoinventarioLogic_Desde_MovimientoInventario.saveDetalleMovimientoInventario();

					Long idDetalleMovimientoInventarioActual=detallemovimientoinventario_Desde_MovimientoInventario.getId();

					NovedadSeguimientoLogic novedadseguimientoLogic_Desde_DetalleMovimientoInventario=new NovedadSeguimientoLogic();

					if(detallemovimientoinventario_Desde_MovimientoInventario.getNovedadSeguimientos()==null){
						detallemovimientoinventario_Desde_MovimientoInventario.setNovedadSeguimientos(new ArrayList<NovedadSeguimiento>());
					}

					novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setNovedadSeguimientos(detallemovimientoinventario_Desde_MovimientoInventario.getNovedadSeguimientos());

					novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setConnexion(this.getConnexion());
					novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setDatosCliente(this.datosCliente);

					for(NovedadSeguimiento novedadseguimiento_Desde_DetalleMovimientoInventario:novedadseguimientoLogic_Desde_DetalleMovimientoInventario.getNovedadSeguimientos()) {
						novedadseguimiento_Desde_DetalleMovimientoInventario.setid_detalle_movimiento_inventario(idDetalleMovimientoInventarioActual);
					}

					novedadseguimientoLogic_Desde_DetalleMovimientoInventario.saveNovedadSeguimientos();
				}

			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfEstadoMovimientoInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfEstadoMovimientoInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
