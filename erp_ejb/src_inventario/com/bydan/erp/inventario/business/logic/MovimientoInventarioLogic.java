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
import com.bydan.erp.inventario.util.MovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.MovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MovimientoInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.MovimientoInventario;
import com.bydan.erp.inventario.business.logic.MovimientoInventarioLogicAdditional;
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
public class MovimientoInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MovimientoInventarioLogic.class);
	
	protected MovimientoInventarioDataAccess movimientoinventarioDataAccess; 	
	protected MovimientoInventario movimientoinventario;
	protected List<MovimientoInventario> movimientoinventarios;
	protected Object movimientoinventarioObject;	
	protected List<Object> movimientoinventariosObject;
	
	public static ClassValidator<MovimientoInventario> movimientoinventarioValidator = new ClassValidator<MovimientoInventario>(MovimientoInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=null;
	
	public MovimientoInventarioLogicAdditional getMovimientoInventarioLogicAdditional() {
		return this.movimientoinventarioLogicAdditional;
	}
	
	public void setMovimientoInventarioLogicAdditional(MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional) {
		try {
			this.movimientoinventarioLogicAdditional=movimientoinventarioLogicAdditional;
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
	
	
	
	
	public  MovimientoInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.movimientoinventarioDataAccess = new MovimientoInventarioDataAccess();
			
			this.movimientoinventarios= new ArrayList<MovimientoInventario>();
			this.movimientoinventario= new MovimientoInventario();
			
			this.movimientoinventarioObject=new Object();
			this.movimientoinventariosObject=new ArrayList<Object>();
				
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
			
			this.movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MovimientoInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.movimientoinventarioDataAccess = new MovimientoInventarioDataAccess();
			this.movimientoinventarios= new ArrayList<MovimientoInventario>();
			this.movimientoinventario= new MovimientoInventario();
			this.movimientoinventarioObject=new Object();
			this.movimientoinventariosObject=new ArrayList<Object>();
			
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
			
			this.movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MovimientoInventario getMovimientoInventario() throws Exception {	
		MovimientoInventarioLogicAdditional.checkMovimientoInventarioToGet(movimientoinventario,this.datosCliente,this.arrDatoGeneral);
		MovimientoInventarioLogicAdditional.updateMovimientoInventarioToGet(movimientoinventario,this.arrDatoGeneral);
		
		return movimientoinventario;
	}
		
	public void setMovimientoInventario(MovimientoInventario newMovimientoInventario) {
		this.movimientoinventario = newMovimientoInventario;
	}
	
	public MovimientoInventarioDataAccess getMovimientoInventarioDataAccess() {
		return movimientoinventarioDataAccess;
	}
	
	public void setMovimientoInventarioDataAccess(MovimientoInventarioDataAccess newmovimientoinventarioDataAccess) {
		this.movimientoinventarioDataAccess = newmovimientoinventarioDataAccess;
	}
	
	public List<MovimientoInventario> getMovimientoInventarios() throws Exception {		
		this.quitarMovimientoInventariosNulos();
		
		MovimientoInventarioLogicAdditional.checkMovimientoInventarioToGets(movimientoinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (MovimientoInventario movimientoinventarioLocal: movimientoinventarios ) {
			MovimientoInventarioLogicAdditional.updateMovimientoInventarioToGet(movimientoinventarioLocal,this.arrDatoGeneral);
		}
		
		return movimientoinventarios;
	}
	
	public void setMovimientoInventarios(List<MovimientoInventario> newMovimientoInventarios) {
		this.movimientoinventarios = newMovimientoInventarios;
	}
	
	public Object getMovimientoInventarioObject() {	
		this.movimientoinventarioObject=this.movimientoinventarioDataAccess.getEntityObject();
		return this.movimientoinventarioObject;
	}
		
	public void setMovimientoInventarioObject(Object newMovimientoInventarioObject) {
		this.movimientoinventarioObject = newMovimientoInventarioObject;
	}
	
	public List<Object> getMovimientoInventariosObject() {		
		this.movimientoinventariosObject=this.movimientoinventarioDataAccess.getEntitiesObject();
		return this.movimientoinventariosObject;
	}
		
	public void setMovimientoInventariosObject(List<Object> newMovimientoInventariosObject) {
		this.movimientoinventariosObject = newMovimientoInventariosObject;
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
		
		if(this.movimientoinventarioDataAccess!=null) {
			this.movimientoinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			movimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			movimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		movimientoinventario = new  MovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
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
		movimientoinventario = new  MovimientoInventario();
		  		  
        try {
			
			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		movimientoinventario = new  MovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
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
		movimientoinventario = new  MovimientoInventario();
		  		  
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
		movimientoinventario = new  MovimientoInventario();
		  		  
        try {
			
			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		movimientoinventario = new  MovimientoInventario();
		  		  
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
		movimientoinventario = new  MovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =movimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		movimientoinventario = new  MovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=movimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		movimientoinventario = new  MovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =movimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		movimientoinventario = new  MovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=movimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		movimientoinventario = new  MovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =movimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		movimientoinventario = new  MovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=movimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
        try {			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
        try {
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		movimientoinventario = new  MovimientoInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
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
		movimientoinventario = new  MovimientoInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		  		  
        try {
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMovimientoInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getTodosMovimientoInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
	
	public  void  getTodosMovimientoInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		movimientoinventarios = new  ArrayList<MovimientoInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMovimientoInventario(movimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMovimientoInventario(MovimientoInventario movimientoinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(movimientoinventario.getIsNew() || movimientoinventario.getIsChanged()) { 
			this.invalidValues = movimientoinventarioValidator.getInvalidValues(movimientoinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(movimientoinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMovimientoInventario(List<MovimientoInventario> MovimientoInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MovimientoInventario movimientoinventarioLocal:movimientoinventarios) {				
			estaValidadoObjeto=this.validarGuardarMovimientoInventario(movimientoinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMovimientoInventario(List<MovimientoInventario> MovimientoInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMovimientoInventario(movimientoinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMovimientoInventario(MovimientoInventario MovimientoInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMovimientoInventario(movimientoinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MovimientoInventario movimientoinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+movimientoinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MovimientoInventarioConstantesFunciones.getMovimientoInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"movimientoinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMovimientoInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-saveMovimientoInventarioWithConnection");connexion.begin();			
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSave(this.movimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MovimientoInventarioLogicAdditional.updateMovimientoInventarioToSave(this.movimientoinventario,this.arrDatoGeneral);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.movimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMovimientoInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMovimientoInventario(this.movimientoinventario)) {
				MovimientoInventarioDataAccess.save(this.movimientoinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.movimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSaveAfter(this.movimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMovimientoInventario();
			
			connexion.commit();			
			
			if(this.movimientoinventario.getIsDeleted()) {
				this.movimientoinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMovimientoInventario()throws Exception {	
		try {	
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSave(this.movimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MovimientoInventarioLogicAdditional.updateMovimientoInventarioToSave(this.movimientoinventario,this.arrDatoGeneral);
			
			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.movimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMovimientoInventario(this.movimientoinventario)) {			
				MovimientoInventarioDataAccess.save(this.movimientoinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.movimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSaveAfter(this.movimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.movimientoinventario.getIsDeleted()) {
				this.movimientoinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMovimientoInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-saveMovimientoInventariosWithConnection");connexion.begin();			
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSaves(movimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMovimientoInventarios();
			
			Boolean validadoTodosMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MovimientoInventario movimientoinventarioLocal:movimientoinventarios) {		
				if(movimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MovimientoInventarioLogicAdditional.updateMovimientoInventarioToSave(movimientoinventarioLocal,this.arrDatoGeneral);
	        	
				MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),movimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMovimientoInventario(movimientoinventarioLocal)) {
					MovimientoInventarioDataAccess.save(movimientoinventarioLocal, connexion);				
				} else {
					validadoTodosMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSavesAfter(movimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMovimientoInventarios();
			
			connexion.commit();		
			
			this.quitarMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMovimientoInventarios()throws Exception {				
		 try {	
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSaves(movimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MovimientoInventario movimientoinventarioLocal:movimientoinventarios) {				
				if(movimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MovimientoInventarioLogicAdditional.updateMovimientoInventarioToSave(movimientoinventarioLocal,this.arrDatoGeneral);
	        	
				MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),movimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMovimientoInventario(movimientoinventarioLocal)) {				
					MovimientoInventarioDataAccess.save(movimientoinventarioLocal, connexion);				
				} else {
					validadoTodosMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MovimientoInventarioLogicAdditional.checkMovimientoInventarioToSavesAfter(movimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MovimientoInventarioParameterReturnGeneral procesarAccionMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientoInventario> movimientoinventarios,MovimientoInventarioParameterReturnGeneral movimientoinventarioParameterGeneral)throws Exception {
		 try {	
			MovimientoInventarioParameterReturnGeneral movimientoinventarioReturnGeneral=new MovimientoInventarioParameterReturnGeneral();
	
			MovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientoinventarios,movimientoinventarioParameterGeneral,movimientoinventarioReturnGeneral);
			
			return movimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MovimientoInventarioParameterReturnGeneral procesarAccionMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientoInventario> movimientoinventarios,MovimientoInventarioParameterReturnGeneral movimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-procesarAccionMovimientoInventariosWithConnection");connexion.begin();			
			
			MovimientoInventarioParameterReturnGeneral movimientoinventarioReturnGeneral=new MovimientoInventarioParameterReturnGeneral();
	
			MovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientoinventarios,movimientoinventarioParameterGeneral,movimientoinventarioReturnGeneral);
			
			this.connexion.commit();
			
			return movimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MovimientoInventarioParameterReturnGeneral procesarEventosMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MovimientoInventario> movimientoinventarios,MovimientoInventario movimientoinventario,MovimientoInventarioParameterReturnGeneral movimientoinventarioParameterGeneral,Boolean isEsNuevoMovimientoInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			MovimientoInventarioParameterReturnGeneral movimientoinventarioReturnGeneral=new MovimientoInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				movimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,movimientoinventarios,movimientoinventario,movimientoinventarioParameterGeneral,movimientoinventarioReturnGeneral,isEsNuevoMovimientoInventario,clases);
			
			return movimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MovimientoInventarioParameterReturnGeneral procesarEventosMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MovimientoInventario> movimientoinventarios,MovimientoInventario movimientoinventario,MovimientoInventarioParameterReturnGeneral movimientoinventarioParameterGeneral,Boolean isEsNuevoMovimientoInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-procesarEventosMovimientoInventariosWithConnection");connexion.begin();			
			
			MovimientoInventarioParameterReturnGeneral movimientoinventarioReturnGeneral=new MovimientoInventarioParameterReturnGeneral();
	
			movimientoinventarioReturnGeneral.setMovimientoInventario(movimientoinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				movimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,movimientoinventarios,movimientoinventario,movimientoinventarioParameterGeneral,movimientoinventarioReturnGeneral,isEsNuevoMovimientoInventario,clases);
			
			this.connexion.commit();
			
			return movimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MovimientoInventarioParameterReturnGeneral procesarImportacionMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MovimientoInventarioParameterReturnGeneral movimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-procesarImportacionMovimientoInventariosWithConnection");connexion.begin();			
			
			MovimientoInventarioParameterReturnGeneral movimientoinventarioReturnGeneral=new MovimientoInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.movimientoinventarios=new ArrayList<MovimientoInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.movimientoinventario=new MovimientoInventario();
				
				
				if(conColumnasBase) {this.movimientoinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.movimientoinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.movimientoinventario.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.movimientoinventario.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.movimientoinventario.setnumero_secuencial(arrColumnas[iColumn++]);
				this.movimientoinventario.setdescripcion(arrColumnas[iColumn++]);
				this.movimientoinventario.setporcentaje_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setvalor_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setstock(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.settotal_otro(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.setnumero_items(Integer.parseInt(arrColumnas[iColumn++]));
				this.movimientoinventario.setretencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoinventario.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.movimientoinventarios.add(this.movimientoinventario);
			}
			
			this.saveMovimientoInventarios();
			
			this.connexion.commit();
			
			movimientoinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			movimientoinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return movimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMovimientoInventariosEliminados() throws Exception {				
		
		List<MovimientoInventario> movimientoinventariosAux= new ArrayList<MovimientoInventario>();
		
		for(MovimientoInventario movimientoinventario:movimientoinventarios) {
			if(!movimientoinventario.getIsDeleted()) {
				movimientoinventariosAux.add(movimientoinventario);
			}
		}
		
		movimientoinventarios=movimientoinventariosAux;
	}
	
	public void quitarMovimientoInventariosNulos() throws Exception {				
		
		List<MovimientoInventario> movimientoinventariosAux= new ArrayList<MovimientoInventario>();
		
		for(MovimientoInventario movimientoinventario : this.movimientoinventarios) {
			if(movimientoinventario==null) {
				movimientoinventariosAux.add(movimientoinventario);
			}
		}
		
		//this.movimientoinventarios=movimientoinventariosAux;
		
		this.movimientoinventarios.removeAll(movimientoinventariosAux);
	}
	
	public void getSetVersionRowMovimientoInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(movimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((movimientoinventario.getIsDeleted() || (movimientoinventario.getIsChanged()&&!movimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=movimientoinventarioDataAccess.getSetVersionRowMovimientoInventario(connexion,movimientoinventario.getId());
				
				if(!movimientoinventario.getVersionRow().equals(timestamp)) {	
					movimientoinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				movimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMovimientoInventario()throws Exception {	
		
		if(movimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((movimientoinventario.getIsDeleted() || (movimientoinventario.getIsChanged()&&!movimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=movimientoinventarioDataAccess.getSetVersionRowMovimientoInventario(connexion,movimientoinventario.getId());
			
			try {							
				if(!movimientoinventario.getVersionRow().equals(timestamp)) {	
					movimientoinventario.setVersionRow(timestamp);
				}
				
				movimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMovimientoInventariosWithConnection()throws Exception {	
		if(movimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MovimientoInventario movimientoinventarioAux:movimientoinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(movimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(movimientoinventarioAux.getIsDeleted() || (movimientoinventarioAux.getIsChanged()&&!movimientoinventarioAux.getIsNew())) {
						
						timestamp=movimientoinventarioDataAccess.getSetVersionRowMovimientoInventario(connexion,movimientoinventarioAux.getId());
						
						if(!movimientoinventario.getVersionRow().equals(timestamp)) {	
							movimientoinventarioAux.setVersionRow(timestamp);
						}
								
						movimientoinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMovimientoInventarios()throws Exception {	
		if(movimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MovimientoInventario movimientoinventarioAux:movimientoinventarios) {
					if(movimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(movimientoinventarioAux.getIsDeleted() || (movimientoinventarioAux.getIsChanged()&&!movimientoinventarioAux.getIsNew())) {
						
						timestamp=movimientoinventarioDataAccess.getSetVersionRowMovimientoInventario(connexion,movimientoinventarioAux.getId());
						
						if(!movimientoinventarioAux.getVersionRow().equals(timestamp)) {	
							movimientoinventarioAux.setVersionRow(timestamp);
						}
						
													
						movimientoinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MovimientoInventarioParameterReturnGeneral cargarCombosLoteForeignKeyMovimientoInventarioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalTransaccion,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoMovimientoInventario,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalFactura,String finalQueryGlobalGuiaRemision,String finalQueryGlobalTransportista,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalCompra,String finalQueryGlobalAsientoContable) throws Exception {
		MovimientoInventarioParameterReturnGeneral  movimientoinventarioReturnGeneral =new MovimientoInventarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-cargarCombosLoteForeignKeyMovimientoInventarioWithConnection");connexion.begin();
			
			movimientoinventarioReturnGeneral =new MovimientoInventarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			movimientoinventarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			movimientoinventarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			movimientoinventarioReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			movimientoinventarioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			movimientoinventarioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			movimientoinventarioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			movimientoinventarioReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			movimientoinventarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			movimientoinventarioReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			movimientoinventarioReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			movimientoinventarioReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoMovimientoInventario> estadomovimientoinventariosForeignKey=new ArrayList<EstadoMovimientoInventario>();
			EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic=new EstadoMovimientoInventarioLogic();
			estadomovimientoinventarioLogic.setConnexion(this.connexion);
			estadomovimientoinventarioLogic.getEstadoMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoMovimientoInventario.equals("NONE")) {
				estadomovimientoinventarioLogic.getTodosEstadoMovimientoInventarios(finalQueryGlobalEstadoMovimientoInventario,new Pagination());
				estadomovimientoinventariosForeignKey=estadomovimientoinventarioLogic.getEstadoMovimientoInventarios();
			}

			movimientoinventarioReturnGeneral.setestadomovimientoinventariosForeignKey(estadomovimientoinventariosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			movimientoinventarioReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			movimientoinventarioReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			movimientoinventarioReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<GuiaRemision> guiaremisionsForeignKey=new ArrayList<GuiaRemision>();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			guiaremisionLogic.setConnexion(this.connexion);
			guiaremisionLogic.getGuiaRemisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGuiaRemision.equals("NONE")) {
				guiaremisionLogic.getTodosGuiaRemisions(finalQueryGlobalGuiaRemision,new Pagination());
				guiaremisionsForeignKey=guiaremisionLogic.getGuiaRemisions();
			}

			movimientoinventarioReturnGeneral.setguiaremisionsForeignKey(guiaremisionsForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			movimientoinventarioReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			movimientoinventarioReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			movimientoinventarioReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			movimientoinventarioReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return movimientoinventarioReturnGeneral;
	}
	
	public MovimientoInventarioParameterReturnGeneral cargarCombosLoteForeignKeyMovimientoInventario(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalTransaccion,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoMovimientoInventario,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalFactura,String finalQueryGlobalGuiaRemision,String finalQueryGlobalTransportista,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalCompra,String finalQueryGlobalAsientoContable) throws Exception {
		MovimientoInventarioParameterReturnGeneral  movimientoinventarioReturnGeneral =new MovimientoInventarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			movimientoinventarioReturnGeneral =new MovimientoInventarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			movimientoinventarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			movimientoinventarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			movimientoinventarioReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			movimientoinventarioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			movimientoinventarioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			movimientoinventarioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			movimientoinventarioReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			movimientoinventarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			movimientoinventarioReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			movimientoinventarioReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			movimientoinventarioReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoMovimientoInventario> estadomovimientoinventariosForeignKey=new ArrayList<EstadoMovimientoInventario>();
			EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic=new EstadoMovimientoInventarioLogic();
			estadomovimientoinventarioLogic.setConnexion(this.connexion);
			estadomovimientoinventarioLogic.getEstadoMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoMovimientoInventario.equals("NONE")) {
				estadomovimientoinventarioLogic.getTodosEstadoMovimientoInventarios(finalQueryGlobalEstadoMovimientoInventario,new Pagination());
				estadomovimientoinventariosForeignKey=estadomovimientoinventarioLogic.getEstadoMovimientoInventarios();
			}

			movimientoinventarioReturnGeneral.setestadomovimientoinventariosForeignKey(estadomovimientoinventariosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			movimientoinventarioReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			movimientoinventarioReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			movimientoinventarioReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<GuiaRemision> guiaremisionsForeignKey=new ArrayList<GuiaRemision>();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			guiaremisionLogic.setConnexion(this.connexion);
			guiaremisionLogic.getGuiaRemisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGuiaRemision.equals("NONE")) {
				guiaremisionLogic.getTodosGuiaRemisions(finalQueryGlobalGuiaRemision,new Pagination());
				guiaremisionsForeignKey=guiaremisionLogic.getGuiaRemisions();
			}

			movimientoinventarioReturnGeneral.setguiaremisionsForeignKey(guiaremisionsForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			movimientoinventarioReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			movimientoinventarioReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			movimientoinventarioReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			movimientoinventarioReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return movimientoinventarioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyMovimientoInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyMovimientoInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleMovimientoInventario.class));
											
			

			detallemovimientoinventarioLogic.setConnexion(this.getConnexion());
			detallemovimientoinventarioLogic.setDatosCliente(this.datosCliente);
			detallemovimientoinventarioLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(MovimientoInventario movimientoinventario:this.movimientoinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(movimientoinventario.detallemovimientoinventarios);
				detallemovimientoinventarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(MovimientoInventario movimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MovimientoInventarioLogicAdditional.updateMovimientoInventarioToGet(movimientoinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientoinventario.setEmpresa(movimientoinventarioDataAccess.getEmpresa(connexion,movimientoinventario));
		movimientoinventario.setSucursal(movimientoinventarioDataAccess.getSucursal(connexion,movimientoinventario));
		movimientoinventario.setModulo(movimientoinventarioDataAccess.getModulo(connexion,movimientoinventario));
		movimientoinventario.setEjercicio(movimientoinventarioDataAccess.getEjercicio(connexion,movimientoinventario));
		movimientoinventario.setPeriodo(movimientoinventarioDataAccess.getPeriodo(connexion,movimientoinventario));
		movimientoinventario.setAnio(movimientoinventarioDataAccess.getAnio(connexion,movimientoinventario));
		movimientoinventario.setMes(movimientoinventarioDataAccess.getMes(connexion,movimientoinventario));
		movimientoinventario.setUsuario(movimientoinventarioDataAccess.getUsuario(connexion,movimientoinventario));
		movimientoinventario.setTransaccion(movimientoinventarioDataAccess.getTransaccion(connexion,movimientoinventario));
		movimientoinventario.setMoneda(movimientoinventarioDataAccess.getMoneda(connexion,movimientoinventario));
		movimientoinventario.setTipoCambio(movimientoinventarioDataAccess.getTipoCambio(connexion,movimientoinventario));
		movimientoinventario.setEstadoMovimientoInventario(movimientoinventarioDataAccess.getEstadoMovimientoInventario(connexion,movimientoinventario));
		movimientoinventario.setEmpleado(movimientoinventarioDataAccess.getEmpleado(connexion,movimientoinventario));
		movimientoinventario.setFormato(movimientoinventarioDataAccess.getFormato(connexion,movimientoinventario));
		movimientoinventario.setFactura(movimientoinventarioDataAccess.getFactura(connexion,movimientoinventario));
		movimientoinventario.setGuiaRemision(movimientoinventarioDataAccess.getGuiaRemision(connexion,movimientoinventario));
		movimientoinventario.setTransportista(movimientoinventarioDataAccess.getTransportista(connexion,movimientoinventario));
		movimientoinventario.setTipoTransaccionModulo(movimientoinventarioDataAccess.getTipoTransaccionModulo(connexion,movimientoinventario));
		movimientoinventario.setCompra(movimientoinventarioDataAccess.getCompra(connexion,movimientoinventario));
		movimientoinventario.setAsientoContable(movimientoinventarioDataAccess.getAsientoContable(connexion,movimientoinventario));
		movimientoinventario.setDetalleMovimientoInventarios(movimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,movimientoinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientoinventario.setEmpresa(movimientoinventarioDataAccess.getEmpresa(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoinventario.setSucursal(movimientoinventarioDataAccess.getSucursal(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				movimientoinventario.setModulo(movimientoinventarioDataAccess.getModulo(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				movimientoinventario.setEjercicio(movimientoinventarioDataAccess.getEjercicio(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				movimientoinventario.setPeriodo(movimientoinventarioDataAccess.getPeriodo(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				movimientoinventario.setAnio(movimientoinventarioDataAccess.getAnio(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				movimientoinventario.setMes(movimientoinventarioDataAccess.getMes(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				movimientoinventario.setUsuario(movimientoinventarioDataAccess.getUsuario(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				movimientoinventario.setTransaccion(movimientoinventarioDataAccess.getTransaccion(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				movimientoinventario.setMoneda(movimientoinventarioDataAccess.getMoneda(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				movimientoinventario.setTipoCambio(movimientoinventarioDataAccess.getTipoCambio(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(EstadoMovimientoInventario.class)) {
				movimientoinventario.setEstadoMovimientoInventario(movimientoinventarioDataAccess.getEstadoMovimientoInventario(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				movimientoinventario.setEmpleado(movimientoinventarioDataAccess.getEmpleado(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				movimientoinventario.setFormato(movimientoinventarioDataAccess.getFormato(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				movimientoinventario.setFactura(movimientoinventarioDataAccess.getFactura(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				movimientoinventario.setGuiaRemision(movimientoinventarioDataAccess.getGuiaRemision(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				movimientoinventario.setTransportista(movimientoinventarioDataAccess.getTransportista(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				movimientoinventario.setTipoTransaccionModulo(movimientoinventarioDataAccess.getTipoTransaccionModulo(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				movimientoinventario.setCompra(movimientoinventarioDataAccess.getCompra(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				movimientoinventario.setAsientoContable(movimientoinventarioDataAccess.getAsientoContable(connexion,movimientoinventario));
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				movimientoinventario.setDetalleMovimientoInventarios(movimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,movimientoinventario));

				if(this.isConDeep) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(this.connexion);
					detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(movimientoinventario.getDetalleMovimientoInventarios());
					ArrayList<Classe> classesLocal=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemovimientoinventarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
					movimientoinventario.setDetalleMovimientoInventarios(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
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
			movimientoinventario.setEmpresa(movimientoinventarioDataAccess.getEmpresa(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setSucursal(movimientoinventarioDataAccess.getSucursal(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setModulo(movimientoinventarioDataAccess.getModulo(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setEjercicio(movimientoinventarioDataAccess.getEjercicio(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setPeriodo(movimientoinventarioDataAccess.getPeriodo(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setAnio(movimientoinventarioDataAccess.getAnio(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setMes(movimientoinventarioDataAccess.getMes(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setUsuario(movimientoinventarioDataAccess.getUsuario(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTransaccion(movimientoinventarioDataAccess.getTransaccion(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setMoneda(movimientoinventarioDataAccess.getMoneda(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTipoCambio(movimientoinventarioDataAccess.getTipoCambio(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setEstadoMovimientoInventario(movimientoinventarioDataAccess.getEstadoMovimientoInventario(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setEmpleado(movimientoinventarioDataAccess.getEmpleado(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setFormato(movimientoinventarioDataAccess.getFormato(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setFactura(movimientoinventarioDataAccess.getFactura(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setGuiaRemision(movimientoinventarioDataAccess.getGuiaRemision(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTransportista(movimientoinventarioDataAccess.getTransportista(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTipoTransaccionModulo(movimientoinventarioDataAccess.getTipoTransaccionModulo(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setCompra(movimientoinventarioDataAccess.getCompra(connexion,movimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setAsientoContable(movimientoinventarioDataAccess.getAsientoContable(connexion,movimientoinventario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			movimientoinventario.setDetalleMovimientoInventarios(movimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,movimientoinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientoinventario.setEmpresa(movimientoinventarioDataAccess.getEmpresa(connexion,movimientoinventario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(movimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setSucursal(movimientoinventarioDataAccess.getSucursal(connexion,movimientoinventario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(movimientoinventario.getSucursal(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setModulo(movimientoinventarioDataAccess.getModulo(connexion,movimientoinventario));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(movimientoinventario.getModulo(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setEjercicio(movimientoinventarioDataAccess.getEjercicio(connexion,movimientoinventario));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(movimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setPeriodo(movimientoinventarioDataAccess.getPeriodo(connexion,movimientoinventario));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(movimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setAnio(movimientoinventarioDataAccess.getAnio(connexion,movimientoinventario));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(movimientoinventario.getAnio(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setMes(movimientoinventarioDataAccess.getMes(connexion,movimientoinventario));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(movimientoinventario.getMes(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setUsuario(movimientoinventarioDataAccess.getUsuario(connexion,movimientoinventario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(movimientoinventario.getUsuario(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setTransaccion(movimientoinventarioDataAccess.getTransaccion(connexion,movimientoinventario));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(movimientoinventario.getTransaccion(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setMoneda(movimientoinventarioDataAccess.getMoneda(connexion,movimientoinventario));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(movimientoinventario.getMoneda(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setTipoCambio(movimientoinventarioDataAccess.getTipoCambio(connexion,movimientoinventario));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(movimientoinventario.getTipoCambio(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setEstadoMovimientoInventario(movimientoinventarioDataAccess.getEstadoMovimientoInventario(connexion,movimientoinventario));
		EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic= new EstadoMovimientoInventarioLogic(connexion);
		estadomovimientoinventarioLogic.deepLoad(movimientoinventario.getEstadoMovimientoInventario(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setEmpleado(movimientoinventarioDataAccess.getEmpleado(connexion,movimientoinventario));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(movimientoinventario.getEmpleado(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setFormato(movimientoinventarioDataAccess.getFormato(connexion,movimientoinventario));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(movimientoinventario.getFormato(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setFactura(movimientoinventarioDataAccess.getFactura(connexion,movimientoinventario));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(movimientoinventario.getFactura(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setGuiaRemision(movimientoinventarioDataAccess.getGuiaRemision(connexion,movimientoinventario));
		GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
		guiaremisionLogic.deepLoad(movimientoinventario.getGuiaRemision(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setTransportista(movimientoinventarioDataAccess.getTransportista(connexion,movimientoinventario));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(movimientoinventario.getTransportista(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setTipoTransaccionModulo(movimientoinventarioDataAccess.getTipoTransaccionModulo(connexion,movimientoinventario));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(movimientoinventario.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setCompra(movimientoinventarioDataAccess.getCompra(connexion,movimientoinventario));
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(movimientoinventario.getCompra(),isDeep,deepLoadType,clases);
				
		movimientoinventario.setAsientoContable(movimientoinventarioDataAccess.getAsientoContable(connexion,movimientoinventario));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(movimientoinventario.getAsientoContable(),isDeep,deepLoadType,clases);
				

		movimientoinventario.setDetalleMovimientoInventarios(movimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,movimientoinventario));

		for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientoinventario.setEmpresa(movimientoinventarioDataAccess.getEmpresa(connexion,movimientoinventario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(movimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoinventario.setSucursal(movimientoinventarioDataAccess.getSucursal(connexion,movimientoinventario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(movimientoinventario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				movimientoinventario.setModulo(movimientoinventarioDataAccess.getModulo(connexion,movimientoinventario));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(movimientoinventario.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				movimientoinventario.setEjercicio(movimientoinventarioDataAccess.getEjercicio(connexion,movimientoinventario));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(movimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				movimientoinventario.setPeriodo(movimientoinventarioDataAccess.getPeriodo(connexion,movimientoinventario));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(movimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				movimientoinventario.setAnio(movimientoinventarioDataAccess.getAnio(connexion,movimientoinventario));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(movimientoinventario.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				movimientoinventario.setMes(movimientoinventarioDataAccess.getMes(connexion,movimientoinventario));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(movimientoinventario.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				movimientoinventario.setUsuario(movimientoinventarioDataAccess.getUsuario(connexion,movimientoinventario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(movimientoinventario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				movimientoinventario.setTransaccion(movimientoinventarioDataAccess.getTransaccion(connexion,movimientoinventario));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(movimientoinventario.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				movimientoinventario.setMoneda(movimientoinventarioDataAccess.getMoneda(connexion,movimientoinventario));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(movimientoinventario.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				movimientoinventario.setTipoCambio(movimientoinventarioDataAccess.getTipoCambio(connexion,movimientoinventario));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(movimientoinventario.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoMovimientoInventario.class)) {
				movimientoinventario.setEstadoMovimientoInventario(movimientoinventarioDataAccess.getEstadoMovimientoInventario(connexion,movimientoinventario));
				EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic= new EstadoMovimientoInventarioLogic(connexion);
				estadomovimientoinventarioLogic.deepLoad(movimientoinventario.getEstadoMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				movimientoinventario.setEmpleado(movimientoinventarioDataAccess.getEmpleado(connexion,movimientoinventario));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(movimientoinventario.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				movimientoinventario.setFormato(movimientoinventarioDataAccess.getFormato(connexion,movimientoinventario));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(movimientoinventario.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				movimientoinventario.setFactura(movimientoinventarioDataAccess.getFactura(connexion,movimientoinventario));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(movimientoinventario.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				movimientoinventario.setGuiaRemision(movimientoinventarioDataAccess.getGuiaRemision(connexion,movimientoinventario));
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepLoad(movimientoinventario.getGuiaRemision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				movimientoinventario.setTransportista(movimientoinventarioDataAccess.getTransportista(connexion,movimientoinventario));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(movimientoinventario.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				movimientoinventario.setTipoTransaccionModulo(movimientoinventarioDataAccess.getTipoTransaccionModulo(connexion,movimientoinventario));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(movimientoinventario.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				movimientoinventario.setCompra(movimientoinventarioDataAccess.getCompra(connexion,movimientoinventario));
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepLoad(movimientoinventario.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				movimientoinventario.setAsientoContable(movimientoinventarioDataAccess.getAsientoContable(connexion,movimientoinventario));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(movimientoinventario.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				movimientoinventario.setDetalleMovimientoInventarios(movimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,movimientoinventario));

				for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
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
			movimientoinventario.setEmpresa(movimientoinventarioDataAccess.getEmpresa(connexion,movimientoinventario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(movimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setSucursal(movimientoinventarioDataAccess.getSucursal(connexion,movimientoinventario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(movimientoinventario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setModulo(movimientoinventarioDataAccess.getModulo(connexion,movimientoinventario));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(movimientoinventario.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setEjercicio(movimientoinventarioDataAccess.getEjercicio(connexion,movimientoinventario));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(movimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setPeriodo(movimientoinventarioDataAccess.getPeriodo(connexion,movimientoinventario));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(movimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setAnio(movimientoinventarioDataAccess.getAnio(connexion,movimientoinventario));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(movimientoinventario.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setMes(movimientoinventarioDataAccess.getMes(connexion,movimientoinventario));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(movimientoinventario.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setUsuario(movimientoinventarioDataAccess.getUsuario(connexion,movimientoinventario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(movimientoinventario.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTransaccion(movimientoinventarioDataAccess.getTransaccion(connexion,movimientoinventario));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(movimientoinventario.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setMoneda(movimientoinventarioDataAccess.getMoneda(connexion,movimientoinventario));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(movimientoinventario.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTipoCambio(movimientoinventarioDataAccess.getTipoCambio(connexion,movimientoinventario));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(movimientoinventario.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setEstadoMovimientoInventario(movimientoinventarioDataAccess.getEstadoMovimientoInventario(connexion,movimientoinventario));
			EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic= new EstadoMovimientoInventarioLogic(connexion);
			estadomovimientoinventarioLogic.deepLoad(movimientoinventario.getEstadoMovimientoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setEmpleado(movimientoinventarioDataAccess.getEmpleado(connexion,movimientoinventario));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(movimientoinventario.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setFormato(movimientoinventarioDataAccess.getFormato(connexion,movimientoinventario));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(movimientoinventario.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setFactura(movimientoinventarioDataAccess.getFactura(connexion,movimientoinventario));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(movimientoinventario.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setGuiaRemision(movimientoinventarioDataAccess.getGuiaRemision(connexion,movimientoinventario));
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremisionLogic.deepLoad(movimientoinventario.getGuiaRemision(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTransportista(movimientoinventarioDataAccess.getTransportista(connexion,movimientoinventario));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(movimientoinventario.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setTipoTransaccionModulo(movimientoinventarioDataAccess.getTipoTransaccionModulo(connexion,movimientoinventario));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(movimientoinventario.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setCompra(movimientoinventarioDataAccess.getCompra(connexion,movimientoinventario));
			CompraLogic compraLogic= new CompraLogic(connexion);
			compraLogic.deepLoad(movimientoinventario.getCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoinventario.setAsientoContable(movimientoinventarioDataAccess.getAsientoContable(connexion,movimientoinventario));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(movimientoinventario.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			movimientoinventario.setDetalleMovimientoInventarios(movimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,movimientoinventario));

			for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
				detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(MovimientoInventario movimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MovimientoInventarioLogicAdditional.updateMovimientoInventarioToSave(movimientoinventario,this.arrDatoGeneral);
			
MovimientoInventarioDataAccess.save(movimientoinventario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(movimientoinventario.getEmpresa(),connexion);

		SucursalDataAccess.save(movimientoinventario.getSucursal(),connexion);

		ModuloDataAccess.save(movimientoinventario.getModulo(),connexion);

		EjercicioDataAccess.save(movimientoinventario.getEjercicio(),connexion);

		PeriodoDataAccess.save(movimientoinventario.getPeriodo(),connexion);

		AnioDataAccess.save(movimientoinventario.getAnio(),connexion);

		MesDataAccess.save(movimientoinventario.getMes(),connexion);

		UsuarioDataAccess.save(movimientoinventario.getUsuario(),connexion);

		TransaccionDataAccess.save(movimientoinventario.getTransaccion(),connexion);

		MonedaDataAccess.save(movimientoinventario.getMoneda(),connexion);

		TipoCambioDataAccess.save(movimientoinventario.getTipoCambio(),connexion);

		EstadoMovimientoInventarioDataAccess.save(movimientoinventario.getEstadoMovimientoInventario(),connexion);

		EmpleadoDataAccess.save(movimientoinventario.getEmpleado(),connexion);

		FormatoDataAccess.save(movimientoinventario.getFormato(),connexion);

		FacturaDataAccess.save(movimientoinventario.getFactura(),connexion);

		GuiaRemisionDataAccess.save(movimientoinventario.getGuiaRemision(),connexion);

		TransportistaDataAccess.save(movimientoinventario.getTransportista(),connexion);

		TipoTransaccionModuloDataAccess.save(movimientoinventario.getTipoTransaccionModulo(),connexion);

		CompraDataAccess.save(movimientoinventario.getCompra(),connexion);

		AsientoContableDataAccess.save(movimientoinventario.getAsientoContable(),connexion);

		for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
			detallemovimientoinventario.setid_movimiento_inventario(movimientoinventario.getId());
			DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoinventario.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoinventario.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(movimientoinventario.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(movimientoinventario.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(movimientoinventario.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(movimientoinventario.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(movimientoinventario.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(movimientoinventario.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(movimientoinventario.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(movimientoinventario.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(movimientoinventario.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoMovimientoInventario.class)) {
				EstadoMovimientoInventarioDataAccess.save(movimientoinventario.getEstadoMovimientoInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(movimientoinventario.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(movimientoinventario.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(movimientoinventario.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				GuiaRemisionDataAccess.save(movimientoinventario.getGuiaRemision(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(movimientoinventario.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(movimientoinventario.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(movimientoinventario.getCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(movimientoinventario.getAsientoContable(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
					detallemovimientoinventario.setid_movimiento_inventario(movimientoinventario.getId());
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(movimientoinventario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(movimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(movimientoinventario.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(movimientoinventario.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(movimientoinventario.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(movimientoinventario.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(movimientoinventario.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(movimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(movimientoinventario.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(movimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(movimientoinventario.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(movimientoinventario.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(movimientoinventario.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(movimientoinventario.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(movimientoinventario.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(movimientoinventario.getUsuario(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(movimientoinventario.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(movimientoinventario.getTransaccion(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(movimientoinventario.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(movimientoinventario.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(movimientoinventario.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(movimientoinventario.getTipoCambio(),isDeep,deepLoadType,clases);
				

		EstadoMovimientoInventarioDataAccess.save(movimientoinventario.getEstadoMovimientoInventario(),connexion);
		EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic= new EstadoMovimientoInventarioLogic(connexion);
		estadomovimientoinventarioLogic.deepLoad(movimientoinventario.getEstadoMovimientoInventario(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(movimientoinventario.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(movimientoinventario.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(movimientoinventario.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(movimientoinventario.getFormato(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(movimientoinventario.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(movimientoinventario.getFactura(),isDeep,deepLoadType,clases);
				

		GuiaRemisionDataAccess.save(movimientoinventario.getGuiaRemision(),connexion);
		GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
		guiaremisionLogic.deepLoad(movimientoinventario.getGuiaRemision(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(movimientoinventario.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(movimientoinventario.getTransportista(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(movimientoinventario.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(movimientoinventario.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		CompraDataAccess.save(movimientoinventario.getCompra(),connexion);
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(movimientoinventario.getCompra(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(movimientoinventario.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(movimientoinventario.getAsientoContable(),isDeep,deepLoadType,clases);
				

		for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventario.setid_movimiento_inventario(movimientoinventario.getId());
			DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
			detallemovimientoinventarioLogic.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoinventario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(movimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoinventario.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(movimientoinventario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(movimientoinventario.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(movimientoinventario.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(movimientoinventario.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(movimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(movimientoinventario.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(movimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(movimientoinventario.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(movimientoinventario.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(movimientoinventario.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(movimientoinventario.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(movimientoinventario.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(movimientoinventario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(movimientoinventario.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(movimientoinventario.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(movimientoinventario.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(movimientoinventario.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(movimientoinventario.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(movimientoinventario.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoMovimientoInventario.class)) {
				EstadoMovimientoInventarioDataAccess.save(movimientoinventario.getEstadoMovimientoInventario(),connexion);
				EstadoMovimientoInventarioLogic estadomovimientoinventarioLogic= new EstadoMovimientoInventarioLogic(connexion);
				estadomovimientoinventarioLogic.deepSave(movimientoinventario.getEstadoMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(movimientoinventario.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(movimientoinventario.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(movimientoinventario.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(movimientoinventario.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(movimientoinventario.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(movimientoinventario.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				GuiaRemisionDataAccess.save(movimientoinventario.getGuiaRemision(),connexion);
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepSave(movimientoinventario.getGuiaRemision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(movimientoinventario.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(movimientoinventario.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(movimientoinventario.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(movimientoinventario.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(movimientoinventario.getCompra(),connexion);
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepSave(movimientoinventario.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(movimientoinventario.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(movimientoinventario.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMovimientoInventario detallemovimientoinventario:movimientoinventario.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventario.setid_movimiento_inventario(movimientoinventario.getId());
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
					detallemovimientoinventarioLogic.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(MovimientoInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(movimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(movimientoinventario);
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
			this.deepLoad(this.movimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MovimientoInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(movimientoinventarios!=null) {
				for(MovimientoInventario movimientoinventario:movimientoinventarios) {
					this.deepLoad(movimientoinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(movimientoinventarios);
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
			if(movimientoinventarios!=null) {
				for(MovimientoInventario movimientoinventario:movimientoinventarios) {
					this.deepLoad(movimientoinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(movimientoinventarios);
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
			this.getNewConnexionToDeep(MovimientoInventario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(movimientoinventario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(MovimientoInventario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(movimientoinventarios!=null) {
				for(MovimientoInventario movimientoinventario:movimientoinventarios) {
					this.deepSave(movimientoinventario,isDeep,deepLoadType,clases);
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
			if(movimientoinventarios!=null) {
				for(MovimientoInventario movimientoinventario:movimientoinventarios) {
					this.deepSave(movimientoinventario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMovimientoInventariosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,MovimientoInventarioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,MovimientoInventarioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,MovimientoInventarioConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdCompra(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,MovimientoInventarioConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,MovimientoInventarioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,MovimientoInventarioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,MovimientoInventarioConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,MovimientoInventarioConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MovimientoInventarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MovimientoInventarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdEstadoMovimientoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_movimiento_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_movimiento_inventario,MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoMovimientoInventario);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdEstadoMovimientoInventario(String sFinalQuery,Pagination pagination,Long id_estado_movimiento_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_movimiento_inventario,MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoMovimientoInventario);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,MovimientoInventarioConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,MovimientoInventarioConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,MovimientoInventarioConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,MovimientoInventarioConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdGuiaRemisionWithConnection(String sFinalQuery,Pagination pagination,Long id_guia_remision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGuiaRemision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGuiaRemision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_guia_remision,MovimientoInventarioConstantesFunciones.IDGUIAREMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGuiaRemision);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGuiaRemision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdGuiaRemision(String sFinalQuery,Pagination pagination,Long id_guia_remision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGuiaRemision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGuiaRemision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_guia_remision,MovimientoInventarioConstantesFunciones.IDGUIAREMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGuiaRemision);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGuiaRemision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,MovimientoInventarioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,MovimientoInventarioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,MovimientoInventarioConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,MovimientoInventarioConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,MovimientoInventarioConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,MovimientoInventarioConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,MovimientoInventarioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,MovimientoInventarioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MovimientoInventarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MovimientoInventarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,MovimientoInventarioConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,MovimientoInventarioConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoInventariosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,MovimientoInventarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoInventariosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,MovimientoInventarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			MovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoInventario(this.movimientoinventarios);
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
			if(MovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MovimientoInventario movimientoinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(movimientoinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoInventarioDataAccess.TABLENAME, movimientoinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MovimientoInventarioLogic.registrarAuditoriaDetallesMovimientoInventario(connexion,movimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(movimientoinventario.getIsDeleted()) {
					/*if(!movimientoinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MovimientoInventarioDataAccess.TABLENAME, movimientoinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MovimientoInventarioLogic.registrarAuditoriaDetallesMovimientoInventario(connexion,movimientoinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoInventarioDataAccess.TABLENAME, movimientoinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(movimientoinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoInventarioDataAccess.TABLENAME, movimientoinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MovimientoInventarioLogic.registrarAuditoriaDetallesMovimientoInventario(connexion,movimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMovimientoInventario(Connexion connexion,MovimientoInventario movimientoinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_empresa().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_empresa()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_empresa().toString();
				}
				if(movimientoinventario.getid_empresa()!=null)
				{
					strValorNuevo=movimientoinventario.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_sucursal().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_sucursal()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_sucursal().toString();
				}
				if(movimientoinventario.getid_sucursal()!=null)
				{
					strValorNuevo=movimientoinventario.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_modulo().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_modulo()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_modulo().toString();
				}
				if(movimientoinventario.getid_modulo()!=null)
				{
					strValorNuevo=movimientoinventario.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_ejercicio().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_ejercicio()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_ejercicio().toString();
				}
				if(movimientoinventario.getid_ejercicio()!=null)
				{
					strValorNuevo=movimientoinventario.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_periodo().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_periodo()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_periodo().toString();
				}
				if(movimientoinventario.getid_periodo()!=null)
				{
					strValorNuevo=movimientoinventario.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_anio().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_anio()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_anio().toString();
				}
				if(movimientoinventario.getid_anio()!=null)
				{
					strValorNuevo=movimientoinventario.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_mes().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_mes()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_mes().toString();
				}
				if(movimientoinventario.getid_mes()!=null)
				{
					strValorNuevo=movimientoinventario.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_usuario().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_usuario()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_usuario().toString();
				}
				if(movimientoinventario.getid_usuario()!=null)
				{
					strValorNuevo=movimientoinventario.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_transaccion().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_transaccion()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_transaccion().toString();
				}
				if(movimientoinventario.getid_transaccion()!=null)
				{
					strValorNuevo=movimientoinventario.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getfecha_emision().equals(movimientoinventario.getMovimientoInventarioOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getfecha_emision()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getfecha_emision().toString();
				}
				if(movimientoinventario.getfecha_emision()!=null)
				{
					strValorNuevo=movimientoinventario.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getfecha_entrega().equals(movimientoinventario.getMovimientoInventarioOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getfecha_entrega()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getfecha_entrega().toString();
				}
				if(movimientoinventario.getfecha_entrega()!=null)
				{
					strValorNuevo=movimientoinventario.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getnumero_secuencial().equals(movimientoinventario.getMovimientoInventarioOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getnumero_secuencial();
				}
				if(movimientoinventario.getnumero_secuencial()!=null)
				{
					strValorNuevo=movimientoinventario.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_moneda().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_moneda()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_moneda().toString();
				}
				if(movimientoinventario.getid_moneda()!=null)
				{
					strValorNuevo=movimientoinventario.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_tipo_cambio().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_tipo_cambio().toString();
				}
				if(movimientoinventario.getid_tipo_cambio()!=null)
				{
					strValorNuevo=movimientoinventario.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_estado_movimiento_inventario().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_estado_movimiento_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_estado_movimiento_inventario()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_estado_movimiento_inventario().toString();
				}
				if(movimientoinventario.getid_estado_movimiento_inventario()!=null)
				{
					strValorNuevo=movimientoinventario.getid_estado_movimiento_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_empleado().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_empleado()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_empleado().toString();
				}
				if(movimientoinventario.getid_empleado()!=null)
				{
					strValorNuevo=movimientoinventario.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_formato().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_formato()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_formato().toString();
				}
				if(movimientoinventario.getid_formato()!=null)
				{
					strValorNuevo=movimientoinventario.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_factura().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_factura()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_factura().toString();
				}
				if(movimientoinventario.getid_factura()!=null)
				{
					strValorNuevo=movimientoinventario.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getnumero_factura().equals(movimientoinventario.getMovimientoInventarioOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getnumero_factura()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getnumero_factura();
				}
				if(movimientoinventario.getnumero_factura()!=null)
				{
					strValorNuevo=movimientoinventario.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_guia_remision().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_guia_remision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_guia_remision()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_guia_remision().toString();
				}
				if(movimientoinventario.getid_guia_remision()!=null)
				{
					strValorNuevo=movimientoinventario.getid_guia_remision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDGUIAREMISION,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_transportista().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_transportista()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_transportista().toString();
				}
				if(movimientoinventario.getid_transportista()!=null)
				{
					strValorNuevo=movimientoinventario.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getdescripcion().equals(movimientoinventario.getMovimientoInventarioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getdescripcion()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getdescripcion();
				}
				if(movimientoinventario.getdescripcion()!=null)
				{
					strValorNuevo=movimientoinventario.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getporcentaje_descuento().equals(movimientoinventario.getMovimientoInventarioOriginal().getporcentaje_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getporcentaje_descuento()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getporcentaje_descuento().toString();
				}
				if(movimientoinventario.getporcentaje_descuento()!=null)
				{
					strValorNuevo=movimientoinventario.getporcentaje_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getsuman().equals(movimientoinventario.getMovimientoInventarioOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getsuman()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getsuman().toString();
				}
				if(movimientoinventario.getsuman()!=null)
				{
					strValorNuevo=movimientoinventario.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getice().equals(movimientoinventario.getMovimientoInventarioOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getice()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getice().toString();
				}
				if(movimientoinventario.getice()!=null)
				{
					strValorNuevo=movimientoinventario.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getvalor_descuento().equals(movimientoinventario.getMovimientoInventarioOriginal().getvalor_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getvalor_descuento()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getvalor_descuento().toString();
				}
				if(movimientoinventario.getvalor_descuento()!=null)
				{
					strValorNuevo=movimientoinventario.getvalor_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.VALORDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.gettotal_descuento().equals(movimientoinventario.getMovimientoInventarioOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().gettotal_descuento()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().gettotal_descuento().toString();
				}
				if(movimientoinventario.gettotal_descuento()!=null)
				{
					strValorNuevo=movimientoinventario.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getiva().equals(movimientoinventario.getMovimientoInventarioOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getiva()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getiva().toString();
				}
				if(movimientoinventario.getiva()!=null)
				{
					strValorNuevo=movimientoinventario.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getstock().equals(movimientoinventario.getMovimientoInventarioOriginal().getstock()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getstock()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getstock().toString();
				}
				if(movimientoinventario.getstock()!=null)
				{
					strValorNuevo=movimientoinventario.getstock().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.STOCK,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getsub_total().equals(movimientoinventario.getMovimientoInventarioOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getsub_total()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getsub_total().toString();
				}
				if(movimientoinventario.getsub_total()!=null)
				{
					strValorNuevo=movimientoinventario.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.gettotal_otro().equals(movimientoinventario.getMovimientoInventarioOriginal().gettotal_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().gettotal_otro()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().gettotal_otro().toString();
				}
				if(movimientoinventario.gettotal_otro()!=null)
				{
					strValorNuevo=movimientoinventario.gettotal_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.TOTALOTRO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getultimo_costo().equals(movimientoinventario.getMovimientoInventarioOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getultimo_costo()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getultimo_costo().toString();
				}
				if(movimientoinventario.getultimo_costo()!=null)
				{
					strValorNuevo=movimientoinventario.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getnumero_items().equals(movimientoinventario.getMovimientoInventarioOriginal().getnumero_items()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getnumero_items()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getnumero_items().toString();
				}
				if(movimientoinventario.getnumero_items()!=null)
				{
					strValorNuevo=movimientoinventario.getnumero_items().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.NUMEROITEMS,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getretencion().equals(movimientoinventario.getMovimientoInventarioOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getretencion()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getretencion().toString();
				}
				if(movimientoinventario.getretencion()!=null)
				{
					strValorNuevo=movimientoinventario.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.gettotal().equals(movimientoinventario.getMovimientoInventarioOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().gettotal()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().gettotal().toString();
				}
				if(movimientoinventario.gettotal()!=null)
				{
					strValorNuevo=movimientoinventario.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getflete().equals(movimientoinventario.getMovimientoInventarioOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getflete()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getflete().toString();
				}
				if(movimientoinventario.getflete()!=null)
				{
					strValorNuevo=movimientoinventario.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getimpuesto().equals(movimientoinventario.getMovimientoInventarioOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getimpuesto()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getimpuesto().toString();
				}
				if(movimientoinventario.getimpuesto()!=null)
				{
					strValorNuevo=movimientoinventario.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_tipo_transaccion_modulo().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(movimientoinventario.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=movimientoinventario.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_compra().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_compra()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_compra().toString();
				}
				if(movimientoinventario.getid_compra()!=null)
				{
					strValorNuevo=movimientoinventario.getid_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getid_asiento_contable().equals(movimientoinventario.getMovimientoInventarioOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getid_asiento_contable().toString();
				}
				if(movimientoinventario.getid_asiento_contable()!=null)
				{
					strValorNuevo=movimientoinventario.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getgenerico_id().equals(movimientoinventario.getMovimientoInventarioOriginal().getgenerico_id()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getgenerico_id()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getgenerico_id().toString();
				}
				if(movimientoinventario.getgenerico_id()!=null)
				{
					strValorNuevo=movimientoinventario.getgenerico_id().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.GENERICOID,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.gettipo_id().equals(movimientoinventario.getMovimientoInventarioOriginal().gettipo_id()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().gettipo_id()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().gettipo_id();
				}
				if(movimientoinventario.gettipo_id()!=null)
				{
					strValorNuevo=movimientoinventario.gettipo_id() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.TIPOID,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getnumero_comprobante().equals(movimientoinventario.getMovimientoInventarioOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getnumero_comprobante();
				}
				if(movimientoinventario.getnumero_comprobante()!=null)
				{
					strValorNuevo=movimientoinventario.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(movimientoinventario.getIsNew()||!movimientoinventario.getfecha().equals(movimientoinventario.getMovimientoInventarioOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoinventario.getMovimientoInventarioOriginal().getfecha()!=null)
				{
					strValorActual=movimientoinventario.getMovimientoInventarioOriginal().getfecha().toString();
				}
				if(movimientoinventario.getfecha()!=null)
				{
					strValorNuevo=movimientoinventario.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoInventarioConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMovimientoInventarioRelacionesWithConnection(MovimientoInventario movimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios) throws Exception {

		if(!movimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMovimientoInventarioRelacionesBase(movimientoinventario,detallemovimientoinventarios,true);
		}
	}

	public void saveMovimientoInventarioRelaciones(MovimientoInventario movimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception {

		if(!movimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMovimientoInventarioRelacionesBase(movimientoinventario,detallemovimientoinventarios,false);
		}
	}

	public void saveMovimientoInventarioRelacionesBase(MovimientoInventario movimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MovimientoInventario-saveRelacionesWithConnection");}
	
			movimientoinventario.setDetalleMovimientoInventarios(detallemovimientoinventarios);

			this.setMovimientoInventario(movimientoinventario);

			if(MovimientoInventarioLogicAdditional.validarSaveRelaciones(movimientoinventario,this)) {

				MovimientoInventarioLogicAdditional.updateRelacionesToSave(movimientoinventario,this);

				if((movimientoinventario.getIsNew()||movimientoinventario.getIsChanged())&&!movimientoinventario.getIsDeleted()) {
					this.saveMovimientoInventario();
					this.saveMovimientoInventarioRelacionesDetalles(detallemovimientoinventarios);

				} else if(movimientoinventario.getIsDeleted()) {
					this.saveMovimientoInventarioRelacionesDetalles(detallemovimientoinventarios);
					this.saveMovimientoInventario();
				}

				MovimientoInventarioLogicAdditional.updateRelacionesToSaveAfter(movimientoinventario,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleMovimientoInventarioConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMovimientoInventarios(detallemovimientoinventarios,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveMovimientoInventarioRelacionesDetalles(List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception {
		try {
	

			Long idMovimientoInventarioActual=this.getMovimientoInventario().getId();

			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic_Desde_MovimientoInventario=new DetalleMovimientoInventarioLogic();
			detallemovimientoinventarioLogic_Desde_MovimientoInventario.setDetalleMovimientoInventarios(detallemovimientoinventarios);

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


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MovimientoInventarioConstantesFunciones.getClassesForeignKeysOfMovimientoInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MovimientoInventarioConstantesFunciones.getClassesRelationshipsOfMovimientoInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
