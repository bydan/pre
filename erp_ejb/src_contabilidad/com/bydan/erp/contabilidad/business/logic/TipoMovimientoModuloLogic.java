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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TipoMovimientoModuloConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoMovimientoModuloParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoMovimientoModuloParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoMovimientoModulo;
import com.bydan.erp.contabilidad.business.logic.TipoMovimientoModuloLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoMovimientoModuloLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoMovimientoModuloLogic.class);
	
	protected TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess; 	
	protected TipoMovimientoModulo tipomovimientomodulo;
	protected List<TipoMovimientoModulo> tipomovimientomodulos;
	protected Object tipomovimientomoduloObject;	
	protected List<Object> tipomovimientomodulosObject;
	
	public static ClassValidator<TipoMovimientoModulo> tipomovimientomoduloValidator = new ClassValidator<TipoMovimientoModulo>(TipoMovimientoModulo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoMovimientoModuloLogicAdditional tipomovimientomoduloLogicAdditional=null;
	
	public TipoMovimientoModuloLogicAdditional getTipoMovimientoModuloLogicAdditional() {
		return this.tipomovimientomoduloLogicAdditional;
	}
	
	public void setTipoMovimientoModuloLogicAdditional(TipoMovimientoModuloLogicAdditional tipomovimientomoduloLogicAdditional) {
		try {
			this.tipomovimientomoduloLogicAdditional=tipomovimientomoduloLogicAdditional;
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
	
	
	
	
	public  TipoMovimientoModuloLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomovimientomoduloDataAccess = new TipoMovimientoModuloDataAccess();
			
			this.tipomovimientomodulos= new ArrayList<TipoMovimientoModulo>();
			this.tipomovimientomodulo= new TipoMovimientoModulo();
			
			this.tipomovimientomoduloObject=new Object();
			this.tipomovimientomodulosObject=new ArrayList<Object>();
				
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
			
			this.tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			this.tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoMovimientoModuloLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomovimientomoduloDataAccess = new TipoMovimientoModuloDataAccess();
			this.tipomovimientomodulos= new ArrayList<TipoMovimientoModulo>();
			this.tipomovimientomodulo= new TipoMovimientoModulo();
			this.tipomovimientomoduloObject=new Object();
			this.tipomovimientomodulosObject=new ArrayList<Object>();
			
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
			
			this.tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			this.tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoMovimientoModulo getTipoMovimientoModulo() throws Exception {	
		TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToGet(tipomovimientomodulo,this.datosCliente,this.arrDatoGeneral);
		TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToGet(tipomovimientomodulo,this.arrDatoGeneral);
		
		return tipomovimientomodulo;
	}
		
	public void setTipoMovimientoModulo(TipoMovimientoModulo newTipoMovimientoModulo) {
		this.tipomovimientomodulo = newTipoMovimientoModulo;
	}
	
	public TipoMovimientoModuloDataAccess getTipoMovimientoModuloDataAccess() {
		return tipomovimientomoduloDataAccess;
	}
	
	public void setTipoMovimientoModuloDataAccess(TipoMovimientoModuloDataAccess newtipomovimientomoduloDataAccess) {
		this.tipomovimientomoduloDataAccess = newtipomovimientomoduloDataAccess;
	}
	
	public List<TipoMovimientoModulo> getTipoMovimientoModulos() throws Exception {		
		this.quitarTipoMovimientoModulosNulos();
		
		TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToGets(tipomovimientomodulos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoMovimientoModulo tipomovimientomoduloLocal: tipomovimientomodulos ) {
			TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToGet(tipomovimientomoduloLocal,this.arrDatoGeneral);
		}
		
		return tipomovimientomodulos;
	}
	
	public void setTipoMovimientoModulos(List<TipoMovimientoModulo> newTipoMovimientoModulos) {
		this.tipomovimientomodulos = newTipoMovimientoModulos;
	}
	
	public Object getTipoMovimientoModuloObject() {	
		this.tipomovimientomoduloObject=this.tipomovimientomoduloDataAccess.getEntityObject();
		return this.tipomovimientomoduloObject;
	}
		
	public void setTipoMovimientoModuloObject(Object newTipoMovimientoModuloObject) {
		this.tipomovimientomoduloObject = newTipoMovimientoModuloObject;
	}
	
	public List<Object> getTipoMovimientoModulosObject() {		
		this.tipomovimientomodulosObject=this.tipomovimientomoduloDataAccess.getEntitiesObject();
		return this.tipomovimientomodulosObject;
	}
		
	public void setTipoMovimientoModulosObject(List<Object> newTipoMovimientoModulosObject) {
		this.tipomovimientomodulosObject = newTipoMovimientoModulosObject;
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
		
		if(this.tipomovimientomoduloDataAccess!=null) {
			this.tipomovimientomoduloDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomovimientomoduloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomovimientomoduloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  		  
        try {
			
			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  		  
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  		  
        try {
			
			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  		  
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomovimientomoduloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomovimientomoduloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomovimientomoduloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomovimientomoduloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomovimientomodulo = new  TipoMovimientoModulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomovimientomoduloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomovimientomoduloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
        try {			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
        try {
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomovimientomodulo = new  TipoMovimientoModulo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
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
		tipomovimientomodulo = new  TipoMovimientoModulo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
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
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		  		  
        try {
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoMovimientoModulosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getTodosTipoMovimientoModulosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
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
	
	public  void  getTodosTipoMovimientoModulos(String sFinalQuery,Pagination pagination)throws Exception {
		tipomovimientomodulos = new  ArrayList<TipoMovimientoModulo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMovimientoModulo(tipomovimientomodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomovimientomodulo.getIsNew() || tipomovimientomodulo.getIsChanged()) { 
			this.invalidValues = tipomovimientomoduloValidator.getInvalidValues(tipomovimientomodulo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomovimientomodulo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoMovimientoModulo(List<TipoMovimientoModulo> TipoMovimientoModulos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoMovimientoModulo tipomovimientomoduloLocal:tipomovimientomodulos) {				
			estaValidadoObjeto=this.validarGuardarTipoMovimientoModulo(tipomovimientomoduloLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoMovimientoModulo(List<TipoMovimientoModulo> TipoMovimientoModulos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMovimientoModulo(tipomovimientomodulos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoMovimientoModulo(TipoMovimientoModulo TipoMovimientoModulo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMovimientoModulo(tipomovimientomodulo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoMovimientoModulo tipomovimientomodulo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomovimientomodulo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomovimientomodulo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoMovimientoModuloConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoMovimientoModuloConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoMovimientoModuloWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-saveTipoMovimientoModuloWithConnection");connexion.begin();			
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSave(this.tipomovimientomodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToSave(this.tipomovimientomodulo,this.arrDatoGeneral);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomovimientomodulo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoMovimientoModulo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMovimientoModulo(this.tipomovimientomodulo)) {
				TipoMovimientoModuloDataAccess.save(this.tipomovimientomodulo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSaveAfter(this.tipomovimientomodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMovimientoModulo();
			
			connexion.commit();			
			
			if(this.tipomovimientomodulo.getIsDeleted()) {
				this.tipomovimientomodulo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoMovimientoModulo()throws Exception {	
		try {	
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSave(this.tipomovimientomodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToSave(this.tipomovimientomodulo,this.arrDatoGeneral);
			
			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomovimientomodulo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMovimientoModulo(this.tipomovimientomodulo)) {			
				TipoMovimientoModuloDataAccess.save(this.tipomovimientomodulo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSaveAfter(this.tipomovimientomodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomovimientomodulo.getIsDeleted()) {
				this.tipomovimientomodulo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoMovimientoModulosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-saveTipoMovimientoModulosWithConnection");connexion.begin();			
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSaves(tipomovimientomodulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoMovimientoModulos();
			
			Boolean validadoTodosTipoMovimientoModulo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMovimientoModulo tipomovimientomoduloLocal:tipomovimientomodulos) {		
				if(tipomovimientomoduloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToSave(tipomovimientomoduloLocal,this.arrDatoGeneral);
	        	
				TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomovimientomoduloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMovimientoModulo(tipomovimientomoduloLocal)) {
					TipoMovimientoModuloDataAccess.save(tipomovimientomoduloLocal, connexion);				
				} else {
					validadoTodosTipoMovimientoModulo=false;
				}
			}
			
			if(!validadoTodosTipoMovimientoModulo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSavesAfter(tipomovimientomodulos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMovimientoModulos();
			
			connexion.commit();		
			
			this.quitarTipoMovimientoModulosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoMovimientoModulos()throws Exception {				
		 try {	
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSaves(tipomovimientomodulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoMovimientoModulo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMovimientoModulo tipomovimientomoduloLocal:tipomovimientomodulos) {				
				if(tipomovimientomoduloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToSave(tipomovimientomoduloLocal,this.arrDatoGeneral);
	        	
				TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomovimientomoduloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMovimientoModulo(tipomovimientomoduloLocal)) {				
					TipoMovimientoModuloDataAccess.save(tipomovimientomoduloLocal, connexion);				
				} else {
					validadoTodosTipoMovimientoModulo=false;
				}
			}
			
			if(!validadoTodosTipoMovimientoModulo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMovimientoModuloLogicAdditional.checkTipoMovimientoModuloToSavesAfter(tipomovimientomodulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoMovimientoModulosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMovimientoModuloParameterReturnGeneral procesarAccionTipoMovimientoModulos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMovimientoModulo> tipomovimientomodulos,TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloParameterGeneral)throws Exception {
		 try {	
			TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloReturnGeneral=new TipoMovimientoModuloParameterReturnGeneral();
	
			TipoMovimientoModuloLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomovimientomodulos,tipomovimientomoduloParameterGeneral,tipomovimientomoduloReturnGeneral);
			
			return tipomovimientomoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMovimientoModuloParameterReturnGeneral procesarAccionTipoMovimientoModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMovimientoModulo> tipomovimientomodulos,TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-procesarAccionTipoMovimientoModulosWithConnection");connexion.begin();			
			
			TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloReturnGeneral=new TipoMovimientoModuloParameterReturnGeneral();
	
			TipoMovimientoModuloLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomovimientomodulos,tipomovimientomoduloParameterGeneral,tipomovimientomoduloReturnGeneral);
			
			this.connexion.commit();
			
			return tipomovimientomoduloReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMovimientoModuloParameterReturnGeneral procesarEventosTipoMovimientoModulos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMovimientoModulo> tipomovimientomodulos,TipoMovimientoModulo tipomovimientomodulo,TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloParameterGeneral,Boolean isEsNuevoTipoMovimientoModulo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloReturnGeneral=new TipoMovimientoModuloParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomovimientomoduloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMovimientoModuloLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomovimientomodulos,tipomovimientomodulo,tipomovimientomoduloParameterGeneral,tipomovimientomoduloReturnGeneral,isEsNuevoTipoMovimientoModulo,clases);
			
			return tipomovimientomoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoMovimientoModuloParameterReturnGeneral procesarEventosTipoMovimientoModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMovimientoModulo> tipomovimientomodulos,TipoMovimientoModulo tipomovimientomodulo,TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloParameterGeneral,Boolean isEsNuevoTipoMovimientoModulo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-procesarEventosTipoMovimientoModulosWithConnection");connexion.begin();			
			
			TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloReturnGeneral=new TipoMovimientoModuloParameterReturnGeneral();
	
			tipomovimientomoduloReturnGeneral.setTipoMovimientoModulo(tipomovimientomodulo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomovimientomoduloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMovimientoModuloLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomovimientomodulos,tipomovimientomodulo,tipomovimientomoduloParameterGeneral,tipomovimientomoduloReturnGeneral,isEsNuevoTipoMovimientoModulo,clases);
			
			this.connexion.commit();
			
			return tipomovimientomoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMovimientoModuloParameterReturnGeneral procesarImportacionTipoMovimientoModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-procesarImportacionTipoMovimientoModulosWithConnection");connexion.begin();			
			
			TipoMovimientoModuloParameterReturnGeneral tipomovimientomoduloReturnGeneral=new TipoMovimientoModuloParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomovimientomodulos=new ArrayList<TipoMovimientoModulo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomovimientomodulo=new TipoMovimientoModulo();
				
				
				if(conColumnasBase) {this.tipomovimientomodulo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomovimientomodulo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomovimientomodulo.setcodigo(arrColumnas[iColumn++]);
				this.tipomovimientomodulo.setnombre(arrColumnas[iColumn++]);
				
				this.tipomovimientomodulos.add(this.tipomovimientomodulo);
			}
			
			this.saveTipoMovimientoModulos();
			
			this.connexion.commit();
			
			tipomovimientomoduloReturnGeneral.setConRetornoEstaProcesado(true);
			tipomovimientomoduloReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomovimientomoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoMovimientoModulosEliminados() throws Exception {				
		
		List<TipoMovimientoModulo> tipomovimientomodulosAux= new ArrayList<TipoMovimientoModulo>();
		
		for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos) {
			if(!tipomovimientomodulo.getIsDeleted()) {
				tipomovimientomodulosAux.add(tipomovimientomodulo);
			}
		}
		
		tipomovimientomodulos=tipomovimientomodulosAux;
	}
	
	public void quitarTipoMovimientoModulosNulos() throws Exception {				
		
		List<TipoMovimientoModulo> tipomovimientomodulosAux= new ArrayList<TipoMovimientoModulo>();
		
		for(TipoMovimientoModulo tipomovimientomodulo : this.tipomovimientomodulos) {
			if(tipomovimientomodulo==null) {
				tipomovimientomodulosAux.add(tipomovimientomodulo);
			}
		}
		
		//this.tipomovimientomodulos=tipomovimientomodulosAux;
		
		this.tipomovimientomodulos.removeAll(tipomovimientomodulosAux);
	}
	
	public void getSetVersionRowTipoMovimientoModuloWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomovimientomodulo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomovimientomodulo.getIsDeleted() || (tipomovimientomodulo.getIsChanged()&&!tipomovimientomodulo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomovimientomoduloDataAccess.getSetVersionRowTipoMovimientoModulo(connexion,tipomovimientomodulo.getId());
				
				if(!tipomovimientomodulo.getVersionRow().equals(timestamp)) {	
					tipomovimientomodulo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomovimientomodulo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoMovimientoModulo()throws Exception {	
		
		if(tipomovimientomodulo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomovimientomodulo.getIsDeleted() || (tipomovimientomodulo.getIsChanged()&&!tipomovimientomodulo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomovimientomoduloDataAccess.getSetVersionRowTipoMovimientoModulo(connexion,tipomovimientomodulo.getId());
			
			try {							
				if(!tipomovimientomodulo.getVersionRow().equals(timestamp)) {	
					tipomovimientomodulo.setVersionRow(timestamp);
				}
				
				tipomovimientomodulo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoMovimientoModulosWithConnection()throws Exception {	
		if(tipomovimientomodulos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoMovimientoModulo tipomovimientomoduloAux:tipomovimientomodulos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomovimientomoduloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomovimientomoduloAux.getIsDeleted() || (tipomovimientomoduloAux.getIsChanged()&&!tipomovimientomoduloAux.getIsNew())) {
						
						timestamp=tipomovimientomoduloDataAccess.getSetVersionRowTipoMovimientoModulo(connexion,tipomovimientomoduloAux.getId());
						
						if(!tipomovimientomodulo.getVersionRow().equals(timestamp)) {	
							tipomovimientomoduloAux.setVersionRow(timestamp);
						}
								
						tipomovimientomoduloAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoMovimientoModulos()throws Exception {	
		if(tipomovimientomodulos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoMovimientoModulo tipomovimientomoduloAux:tipomovimientomodulos) {
					if(tipomovimientomoduloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomovimientomoduloAux.getIsDeleted() || (tipomovimientomoduloAux.getIsChanged()&&!tipomovimientomoduloAux.getIsNew())) {
						
						timestamp=tipomovimientomoduloDataAccess.getSetVersionRowTipoMovimientoModulo(connexion,tipomovimientomoduloAux.getId());
						
						if(!tipomovimientomoduloAux.getVersionRow().equals(timestamp)) {	
							tipomovimientomoduloAux.setVersionRow(timestamp);
						}
						
													
						tipomovimientomoduloAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoMovimientoModuloParameterReturnGeneral cargarCombosLoteForeignKeyTipoMovimientoModuloWithConnection(String finalQueryGlobalModulo) throws Exception {
		TipoMovimientoModuloParameterReturnGeneral  tipomovimientomoduloReturnGeneral =new TipoMovimientoModuloParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoMovimientoModuloWithConnection");connexion.begin();
			
			tipomovimientomoduloReturnGeneral =new TipoMovimientoModuloParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipomovimientomoduloReturnGeneral.setmodulosForeignKey(modulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipomovimientomoduloReturnGeneral;
	}
	
	public TipoMovimientoModuloParameterReturnGeneral cargarCombosLoteForeignKeyTipoMovimientoModulo(String finalQueryGlobalModulo) throws Exception {
		TipoMovimientoModuloParameterReturnGeneral  tipomovimientomoduloReturnGeneral =new TipoMovimientoModuloParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipomovimientomoduloReturnGeneral =new TipoMovimientoModuloParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipomovimientomoduloReturnGeneral.setmodulosForeignKey(modulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipomovimientomoduloReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoMovimientoModuloWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroCompraLogic parametrocompraLogic=new ParametroCompraLogic();
			FacturaProveedorServicioLogic facturaproveedorservicioLogic=new FacturaProveedorServicioLogic();
			SecuencialLogic secuencialLogic=new SecuencialLogic();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoMovimientoModuloWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroCompra.class));
			classes.add(new Classe(FacturaProveedorServicio.class));
			classes.add(new Classe(Secuencial.class));
			classes.add(new Classe(TipoDocumento.class));
											
			

			parametrocompraLogic.setConnexion(this.getConnexion());
			parametrocompraLogic.setDatosCliente(this.datosCliente);
			parametrocompraLogic.setIsConRefrescarForeignKeys(true);

			facturaproveedorservicioLogic.setConnexion(this.getConnexion());
			facturaproveedorservicioLogic.setDatosCliente(this.datosCliente);
			facturaproveedorservicioLogic.setIsConRefrescarForeignKeys(true);

			secuencialLogic.setConnexion(this.getConnexion());
			secuencialLogic.setDatosCliente(this.datosCliente);
			secuencialLogic.setIsConRefrescarForeignKeys(true);

			tipodocumentoLogic.setConnexion(this.getConnexion());
			tipodocumentoLogic.setDatosCliente(this.datosCliente);
			tipodocumentoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoMovimientoModulo tipomovimientomodulo:this.tipomovimientomodulos) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroCompraConstantesFunciones.getClassesForeignKeysOfParametroCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocompraLogic.setParametroCompras(tipomovimientomodulo.parametrocompras);
				parametrocompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaProveedorServicioConstantesFunciones.getClassesForeignKeysOfFacturaProveedorServicio(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaproveedorservicioLogic.setFacturaProveedorServicios(tipomovimientomodulo.facturaproveedorservicios);
				facturaproveedorservicioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SecuencialConstantesFunciones.getClassesForeignKeysOfSecuencial(new ArrayList<Classe>(),DeepLoadType.NONE);

				secuencialLogic.setSecuencials(tipomovimientomodulo.secuencials);
				secuencialLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TipoDocumentoConstantesFunciones.getClassesForeignKeysOfTipoDocumento(new ArrayList<Classe>(),DeepLoadType.NONE);

				tipodocumentoLogic.setTipoDocumentos(tipomovimientomodulo.tipodocumentos);
				tipodocumentoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoMovimientoModulo tipomovimientomodulo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToGet(tipomovimientomodulo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomovimientomodulo.setModulo(tipomovimientomoduloDataAccess.getModulo(connexion,tipomovimientomodulo));
		tipomovimientomodulo.setParametroCompras(tipomovimientomoduloDataAccess.getParametroCompras(connexion,tipomovimientomodulo));
		tipomovimientomodulo.setFacturaProveedorServicios(tipomovimientomoduloDataAccess.getFacturaProveedorServicios(connexion,tipomovimientomodulo));
		tipomovimientomodulo.setSecuencials(tipomovimientomoduloDataAccess.getSecuencials(connexion,tipomovimientomodulo));
		tipomovimientomodulo.setTipoDocumentos(tipomovimientomoduloDataAccess.getTipoDocumentos(connexion,tipomovimientomodulo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				tipomovimientomodulo.setModulo(tipomovimientomoduloDataAccess.getModulo(connexion,tipomovimientomodulo));
				continue;
			}

			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setParametroCompras(tipomovimientomoduloDataAccess.getParametroCompras(connexion,tipomovimientomodulo));

				if(this.isConDeep) {
					ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(this.connexion);
					parametrocompraLogic.setParametroCompras(tipomovimientomodulo.getParametroCompras());
					ArrayList<Classe> classesLocal=ParametroCompraConstantesFunciones.getClassesForeignKeysOfParametroCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(parametrocompraLogic.getParametroCompras());
					tipomovimientomodulo.setParametroCompras(parametrocompraLogic.getParametroCompras());
				}

				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setFacturaProveedorServicios(tipomovimientomoduloDataAccess.getFacturaProveedorServicios(connexion,tipomovimientomodulo));

				if(this.isConDeep) {
					FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(this.connexion);
					facturaproveedorservicioLogic.setFacturaProveedorServicios(tipomovimientomodulo.getFacturaProveedorServicios());
					ArrayList<Classe> classesLocal=FacturaProveedorServicioConstantesFunciones.getClassesForeignKeysOfFacturaProveedorServicio(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaproveedorservicioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(facturaproveedorservicioLogic.getFacturaProveedorServicios());
					tipomovimientomodulo.setFacturaProveedorServicios(facturaproveedorservicioLogic.getFacturaProveedorServicios());
				}

				continue;
			}

			if(clas.clas.equals(Secuencial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setSecuencials(tipomovimientomoduloDataAccess.getSecuencials(connexion,tipomovimientomodulo));

				if(this.isConDeep) {
					SecuencialLogic secuencialLogic= new SecuencialLogic(this.connexion);
					secuencialLogic.setSecuencials(tipomovimientomodulo.getSecuencials());
					ArrayList<Classe> classesLocal=SecuencialConstantesFunciones.getClassesForeignKeysOfSecuencial(new ArrayList<Classe>(),DeepLoadType.NONE);
					secuencialLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(secuencialLogic.getSecuencials());
					tipomovimientomodulo.setSecuencials(secuencialLogic.getSecuencials());
				}

				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setTipoDocumentos(tipomovimientomoduloDataAccess.getTipoDocumentos(connexion,tipomovimientomodulo));

				if(this.isConDeep) {
					TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(this.connexion);
					tipodocumentoLogic.setTipoDocumentos(tipomovimientomodulo.getTipoDocumentos());
					ArrayList<Classe> classesLocal=TipoDocumentoConstantesFunciones.getClassesForeignKeysOfTipoDocumento(new ArrayList<Classe>(),DeepLoadType.NONE);
					tipodocumentoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(tipodocumentoLogic.getTipoDocumentos());
					tipomovimientomodulo.setTipoDocumentos(tipodocumentoLogic.getTipoDocumentos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomovimientomodulo.setModulo(tipomovimientomoduloDataAccess.getModulo(connexion,tipomovimientomodulo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCompra.class));
			tipomovimientomodulo.setParametroCompras(tipomovimientomoduloDataAccess.getParametroCompras(connexion,tipomovimientomodulo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaProveedorServicio.class));
			tipomovimientomodulo.setFacturaProveedorServicios(tipomovimientomoduloDataAccess.getFacturaProveedorServicios(connexion,tipomovimientomodulo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Secuencial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Secuencial.class));
			tipomovimientomodulo.setSecuencials(tipomovimientomoduloDataAccess.getSecuencials(connexion,tipomovimientomodulo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoDocumento.class));
			tipomovimientomodulo.setTipoDocumentos(tipomovimientomoduloDataAccess.getTipoDocumentos(connexion,tipomovimientomodulo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomovimientomodulo.setModulo(tipomovimientomoduloDataAccess.getModulo(connexion,tipomovimientomodulo));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipomovimientomodulo.getModulo(),isDeep,deepLoadType,clases);
				

		tipomovimientomodulo.setParametroCompras(tipomovimientomoduloDataAccess.getParametroCompras(connexion,tipomovimientomodulo));

		for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
			ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
			parametrocompraLogic.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
		}

		tipomovimientomodulo.setFacturaProveedorServicios(tipomovimientomoduloDataAccess.getFacturaProveedorServicios(connexion,tipomovimientomodulo));

		for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
			FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
			facturaproveedorservicioLogic.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
		}

		tipomovimientomodulo.setSecuencials(tipomovimientomoduloDataAccess.getSecuencials(connexion,tipomovimientomodulo));

		for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
			SecuencialLogic secuencialLogic= new SecuencialLogic(connexion);
			secuencialLogic.deepLoad(secuencial,isDeep,deepLoadType,clases);
		}

		tipomovimientomodulo.setTipoDocumentos(tipomovimientomoduloDataAccess.getTipoDocumentos(connexion,tipomovimientomodulo));

		for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(tipodocumento,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				tipomovimientomodulo.setModulo(tipomovimientomoduloDataAccess.getModulo(connexion,tipomovimientomodulo));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(tipomovimientomodulo.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setParametroCompras(tipomovimientomoduloDataAccess.getParametroCompras(connexion,tipomovimientomodulo));

				for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
					ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
					parametrocompraLogic.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setFacturaProveedorServicios(tipomovimientomoduloDataAccess.getFacturaProveedorServicios(connexion,tipomovimientomodulo));

				for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
					FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
					facturaproveedorservicioLogic.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Secuencial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setSecuencials(tipomovimientomoduloDataAccess.getSecuencials(connexion,tipomovimientomodulo));

				for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
					SecuencialLogic secuencialLogic= new SecuencialLogic(connexion);
					secuencialLogic.deepLoad(secuencial,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovimientomodulo.setTipoDocumentos(tipomovimientomoduloDataAccess.getTipoDocumentos(connexion,tipomovimientomodulo));

				for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
					TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
					tipodocumentoLogic.deepLoad(tipodocumento,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomovimientomodulo.setModulo(tipomovimientomoduloDataAccess.getModulo(connexion,tipomovimientomodulo));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(tipomovimientomodulo.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCompra.class));
			tipomovimientomodulo.setParametroCompras(tipomovimientomoduloDataAccess.getParametroCompras(connexion,tipomovimientomodulo));

			for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
				ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
				parametrocompraLogic.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaProveedorServicio.class));
			tipomovimientomodulo.setFacturaProveedorServicios(tipomovimientomoduloDataAccess.getFacturaProveedorServicios(connexion,tipomovimientomodulo));

			for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
				FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
				facturaproveedorservicioLogic.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Secuencial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Secuencial.class));
			tipomovimientomodulo.setSecuencials(tipomovimientomoduloDataAccess.getSecuencials(connexion,tipomovimientomodulo));

			for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
				SecuencialLogic secuencialLogic= new SecuencialLogic(connexion);
				secuencialLogic.deepLoad(secuencial,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoDocumento.class));
			tipomovimientomodulo.setTipoDocumentos(tipomovimientomoduloDataAccess.getTipoDocumentos(connexion,tipomovimientomodulo));

			for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(tipodocumento,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoMovimientoModulo tipomovimientomodulo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoMovimientoModuloLogicAdditional.updateTipoMovimientoModuloToSave(tipomovimientomodulo,this.arrDatoGeneral);
			
TipoMovimientoModuloDataAccess.save(tipomovimientomodulo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(tipomovimientomodulo.getModulo(),connexion);

		for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
			parametrocompra.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			ParametroCompraDataAccess.save(parametrocompra,connexion);
		}

		for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
			facturaproveedorservicio.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
		}

		for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
			secuencial.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			SecuencialDataAccess.save(secuencial,connexion);
		}

		for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
			tipodocumento.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			TipoDocumentoDataAccess.save(tipodocumento,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipomovimientomodulo.getModulo(),connexion);
				continue;
			}


			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
					parametrocompra.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					ParametroCompraDataAccess.save(parametrocompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
					facturaproveedorservicio.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Secuencial.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
					secuencial.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					SecuencialDataAccess.save(secuencial,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
					tipodocumento.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					TipoDocumentoDataAccess.save(tipodocumento,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(tipomovimientomodulo.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipomovimientomodulo.getModulo(),isDeep,deepLoadType,clases);
				

		for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
			ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
			parametrocompra.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			ParametroCompraDataAccess.save(parametrocompra,connexion);
			parametrocompraLogic.deepSave(parametrocompra,isDeep,deepLoadType,clases);
		}

		for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
			FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
			facturaproveedorservicio.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
			facturaproveedorservicioLogic.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);
		}

		for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
			SecuencialLogic secuencialLogic= new SecuencialLogic(connexion);
			secuencial.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			SecuencialDataAccess.save(secuencial,connexion);
			secuencialLogic.deepSave(secuencial,isDeep,deepLoadType,clases);
		}

		for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumento.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
			TipoDocumentoDataAccess.save(tipodocumento,connexion);
			tipodocumentoLogic.deepSave(tipodocumento,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipomovimientomodulo.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(tipomovimientomodulo.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCompra parametrocompra:tipomovimientomodulo.getParametroCompras()) {
					ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
					parametrocompra.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					ParametroCompraDataAccess.save(parametrocompra,connexion);
					parametrocompraLogic.deepSave(parametrocompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaProveedorServicio facturaproveedorservicio:tipomovimientomodulo.getFacturaProveedorServicios()) {
					FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
					facturaproveedorservicio.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
					facturaproveedorservicioLogic.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Secuencial.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Secuencial secuencial:tipomovimientomodulo.getSecuencials()) {
					SecuencialLogic secuencialLogic= new SecuencialLogic(connexion);
					secuencial.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					SecuencialDataAccess.save(secuencial,connexion);
					secuencialLogic.deepSave(secuencial,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoDocumento tipodocumento:tipomovimientomodulo.getTipoDocumentos()) {
					TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
					tipodocumento.setid_tipo_movimiento_modulo(tipomovimientomodulo.getId());
					TipoDocumentoDataAccess.save(tipodocumento,connexion);
					tipodocumentoLogic.deepSave(tipodocumento,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoMovimientoModulo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomovimientomodulo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(tipomovimientomodulo);
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
			this.deepLoad(this.tipomovimientomodulo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMovimientoModulo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomovimientomodulos!=null) {
				for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos) {
					this.deepLoad(tipomovimientomodulo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(tipomovimientomodulos);
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
			if(tipomovimientomodulos!=null) {
				for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos) {
					this.deepLoad(tipomovimientomodulo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(tipomovimientomodulos);
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
			this.getNewConnexionToDeep(TipoMovimientoModulo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipomovimientomodulo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoMovimientoModulo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipomovimientomodulos!=null) {
				for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos) {
					this.deepSave(tipomovimientomodulo,isDeep,deepLoadType,clases);
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
			if(tipomovimientomodulos!=null) {
				for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos) {
					this.deepSave(tipomovimientomodulo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoMovimientoModulosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoMovimientoModuloConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMovimientoModulosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoMovimientoModuloConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMovimientoModulosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoMovimientoModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMovimientoModulosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoMovimientoModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMovimientoModulosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoMovimientoModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMovimientoModulosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoMovimientoModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoMovimientoModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimientomodulos=tipomovimientomoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMovimientoModuloPorIdModuloPorCodigoWithConnection(Long id_modulo,String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimientoModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoMovimientoModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TipoMovimientoModuloConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMovimientoModuloPorIdModuloPorCodigo(Long id_modulo,String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoMovimientoModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TipoMovimientoModuloConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipomovimientomodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoMovimientoModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimientoModulo(this.tipomovimientomodulo);
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
			if(TipoMovimientoModuloConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimientoModuloDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoMovimientoModulo tipomovimientomodulo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoMovimientoModuloConstantesFunciones.ISCONAUDITORIA) {
				if(tipomovimientomodulo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimientoModuloDataAccess.TABLENAME, tipomovimientomodulo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMovimientoModuloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMovimientoModuloLogic.registrarAuditoriaDetallesTipoMovimientoModulo(connexion,tipomovimientomodulo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomovimientomodulo.getIsDeleted()) {
					/*if(!tipomovimientomodulo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoMovimientoModuloDataAccess.TABLENAME, tipomovimientomodulo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoMovimientoModuloLogic.registrarAuditoriaDetallesTipoMovimientoModulo(connexion,tipomovimientomodulo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimientoModuloDataAccess.TABLENAME, tipomovimientomodulo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomovimientomodulo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimientoModuloDataAccess.TABLENAME, tipomovimientomodulo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMovimientoModuloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMovimientoModuloLogic.registrarAuditoriaDetallesTipoMovimientoModulo(connexion,tipomovimientomodulo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoMovimientoModulo(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomovimientomodulo.getIsNew()||!tipomovimientomodulo.getid_modulo().equals(tipomovimientomodulo.getTipoMovimientoModuloOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovimientomodulo.getTipoMovimientoModuloOriginal().getid_modulo()!=null)
				{
					strValorActual=tipomovimientomodulo.getTipoMovimientoModuloOriginal().getid_modulo().toString();
				}
				if(tipomovimientomodulo.getid_modulo()!=null)
				{
					strValorNuevo=tipomovimientomodulo.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMovimientoModuloConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipomovimientomodulo.getIsNew()||!tipomovimientomodulo.getcodigo().equals(tipomovimientomodulo.getTipoMovimientoModuloOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovimientomodulo.getTipoMovimientoModuloOriginal().getcodigo()!=null)
				{
					strValorActual=tipomovimientomodulo.getTipoMovimientoModuloOriginal().getcodigo();
				}
				if(tipomovimientomodulo.getcodigo()!=null)
				{
					strValorNuevo=tipomovimientomodulo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMovimientoModuloConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipomovimientomodulo.getIsNew()||!tipomovimientomodulo.getnombre().equals(tipomovimientomodulo.getTipoMovimientoModuloOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovimientomodulo.getTipoMovimientoModuloOriginal().getnombre()!=null)
				{
					strValorActual=tipomovimientomodulo.getTipoMovimientoModuloOriginal().getnombre();
				}
				if(tipomovimientomodulo.getnombre()!=null)
				{
					strValorNuevo=tipomovimientomodulo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMovimientoModuloConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoMovimientoModuloRelacionesWithConnection(TipoMovimientoModulo tipomovimientomodulo,List<ParametroCompra> parametrocompras,List<FacturaProveedorServicio> facturaproveedorservicios,List<Secuencial> secuencials,List<TipoDocumento> tipodocumentos) throws Exception {

		if(!tipomovimientomodulo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMovimientoModuloRelacionesBase(tipomovimientomodulo,parametrocompras,facturaproveedorservicios,secuencials,tipodocumentos,true);
		}
	}

	public void saveTipoMovimientoModuloRelaciones(TipoMovimientoModulo tipomovimientomodulo,List<ParametroCompra> parametrocompras,List<FacturaProveedorServicio> facturaproveedorservicios,List<Secuencial> secuencials,List<TipoDocumento> tipodocumentos)throws Exception {

		if(!tipomovimientomodulo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMovimientoModuloRelacionesBase(tipomovimientomodulo,parametrocompras,facturaproveedorservicios,secuencials,tipodocumentos,false);
		}
	}

	public void saveTipoMovimientoModuloRelacionesBase(TipoMovimientoModulo tipomovimientomodulo,List<ParametroCompra> parametrocompras,List<FacturaProveedorServicio> facturaproveedorservicios,List<Secuencial> secuencials,List<TipoDocumento> tipodocumentos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoMovimientoModulo-saveRelacionesWithConnection");}
	
			tipomovimientomodulo.setParametroCompras(parametrocompras);
			tipomovimientomodulo.setFacturaProveedorServicios(facturaproveedorservicios);
			tipomovimientomodulo.setSecuencials(secuencials);
			tipomovimientomodulo.setTipoDocumentos(tipodocumentos);

			this.setTipoMovimientoModulo(tipomovimientomodulo);

				if((tipomovimientomodulo.getIsNew()||tipomovimientomodulo.getIsChanged())&&!tipomovimientomodulo.getIsDeleted()) {
					this.saveTipoMovimientoModulo();
					this.saveTipoMovimientoModuloRelacionesDetalles(parametrocompras,facturaproveedorservicios,secuencials,tipodocumentos);

				} else if(tipomovimientomodulo.getIsDeleted()) {
					this.saveTipoMovimientoModuloRelacionesDetalles(parametrocompras,facturaproveedorservicios,secuencials,tipodocumentos);
					this.saveTipoMovimientoModulo();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ParametroCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCompras(parametrocompras,true,true);
			FacturaProveedorServicioConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaProveedorServicios(facturaproveedorservicios,true,true);
			SecuencialConstantesFunciones.InicializarGeneralEntityAuxiliaresSecuencials(secuencials,true,true);
			TipoDocumentoConstantesFunciones.InicializarGeneralEntityAuxiliaresTipoDocumentos(tipodocumentos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoMovimientoModuloRelacionesDetalles(List<ParametroCompra> parametrocompras,List<FacturaProveedorServicio> facturaproveedorservicios,List<Secuencial> secuencials,List<TipoDocumento> tipodocumentos)throws Exception {
		try {
	

			Long idTipoMovimientoModuloActual=this.getTipoMovimientoModulo().getId();

			ParametroCompraLogic parametrocompraLogic_Desde_TipoMovimientoModulo=new ParametroCompraLogic();
			parametrocompraLogic_Desde_TipoMovimientoModulo.setParametroCompras(parametrocompras);

			parametrocompraLogic_Desde_TipoMovimientoModulo.setConnexion(this.getConnexion());
			parametrocompraLogic_Desde_TipoMovimientoModulo.setDatosCliente(this.datosCliente);

			for(ParametroCompra parametrocompra_Desde_TipoMovimientoModulo:parametrocompraLogic_Desde_TipoMovimientoModulo.getParametroCompras()) {
				parametrocompra_Desde_TipoMovimientoModulo.setid_tipo_movimiento_modulo(idTipoMovimientoModuloActual);
			}

			parametrocompraLogic_Desde_TipoMovimientoModulo.saveParametroCompras();

			FacturaProveedorServicioLogic facturaproveedorservicioLogic_Desde_TipoMovimientoModulo=new FacturaProveedorServicioLogic();
			facturaproveedorservicioLogic_Desde_TipoMovimientoModulo.setFacturaProveedorServicios(facturaproveedorservicios);

			facturaproveedorservicioLogic_Desde_TipoMovimientoModulo.setConnexion(this.getConnexion());
			facturaproveedorservicioLogic_Desde_TipoMovimientoModulo.setDatosCliente(this.datosCliente);

			for(FacturaProveedorServicio facturaproveedorservicio_Desde_TipoMovimientoModulo:facturaproveedorservicioLogic_Desde_TipoMovimientoModulo.getFacturaProveedorServicios()) {
				facturaproveedorservicio_Desde_TipoMovimientoModulo.setid_tipo_movimiento_modulo(idTipoMovimientoModuloActual);
			}

			facturaproveedorservicioLogic_Desde_TipoMovimientoModulo.saveFacturaProveedorServicios();

			SecuencialLogic secuencialLogic_Desde_TipoMovimientoModulo=new SecuencialLogic();
			secuencialLogic_Desde_TipoMovimientoModulo.setSecuencials(secuencials);

			secuencialLogic_Desde_TipoMovimientoModulo.setConnexion(this.getConnexion());
			secuencialLogic_Desde_TipoMovimientoModulo.setDatosCliente(this.datosCliente);

			for(Secuencial secuencial_Desde_TipoMovimientoModulo:secuencialLogic_Desde_TipoMovimientoModulo.getSecuencials()) {
				secuencial_Desde_TipoMovimientoModulo.setid_tipo_movimiento_modulo(idTipoMovimientoModuloActual);
			}

			secuencialLogic_Desde_TipoMovimientoModulo.saveSecuencials();

			TipoDocumentoLogic tipodocumentoLogic_Desde_TipoMovimientoModulo=new TipoDocumentoLogic();
			tipodocumentoLogic_Desde_TipoMovimientoModulo.setTipoDocumentos(tipodocumentos);

			tipodocumentoLogic_Desde_TipoMovimientoModulo.setConnexion(this.getConnexion());
			tipodocumentoLogic_Desde_TipoMovimientoModulo.setDatosCliente(this.datosCliente);

			for(TipoDocumento tipodocumento_Desde_TipoMovimientoModulo:tipodocumentoLogic_Desde_TipoMovimientoModulo.getTipoDocumentos()) {
				tipodocumento_Desde_TipoMovimientoModulo.setid_tipo_movimiento_modulo(idTipoMovimientoModuloActual);
			}

			tipodocumentoLogic_Desde_TipoMovimientoModulo.saveTipoDocumentos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMovimientoModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMovimientoModuloConstantesFunciones.getClassesForeignKeysOfTipoMovimientoModulo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimientoModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMovimientoModuloConstantesFunciones.getClassesRelationshipsOfTipoMovimientoModulo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
