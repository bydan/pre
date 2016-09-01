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
import com.bydan.erp.contabilidad.util.TipoTransaccionModuloConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoTransaccionModuloParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoTransaccionModuloParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoTransaccionModulo;
import com.bydan.erp.contabilidad.business.logic.TipoTransaccionModuloLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.sris.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoTransaccionModuloLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoTransaccionModuloLogic.class);
	
	protected TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess; 	
	protected TipoTransaccionModulo tipotransaccionmodulo;
	protected List<TipoTransaccionModulo> tipotransaccionmodulos;
	protected Object tipotransaccionmoduloObject;	
	protected List<Object> tipotransaccionmodulosObject;
	
	public static ClassValidator<TipoTransaccionModulo> tipotransaccionmoduloValidator = new ClassValidator<TipoTransaccionModulo>(TipoTransaccionModulo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoTransaccionModuloLogicAdditional tipotransaccionmoduloLogicAdditional=null;
	
	public TipoTransaccionModuloLogicAdditional getTipoTransaccionModuloLogicAdditional() {
		return this.tipotransaccionmoduloLogicAdditional;
	}
	
	public void setTipoTransaccionModuloLogicAdditional(TipoTransaccionModuloLogicAdditional tipotransaccionmoduloLogicAdditional) {
		try {
			this.tipotransaccionmoduloLogicAdditional=tipotransaccionmoduloLogicAdditional;
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
	
	
	
	
	public  TipoTransaccionModuloLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipotransaccionmoduloDataAccess = new TipoTransaccionModuloDataAccess();
			
			this.tipotransaccionmodulos= new ArrayList<TipoTransaccionModulo>();
			this.tipotransaccionmodulo= new TipoTransaccionModulo();
			
			this.tipotransaccionmoduloObject=new Object();
			this.tipotransaccionmodulosObject=new ArrayList<Object>();
				
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
			
			this.tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			this.tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoTransaccionModuloLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipotransaccionmoduloDataAccess = new TipoTransaccionModuloDataAccess();
			this.tipotransaccionmodulos= new ArrayList<TipoTransaccionModulo>();
			this.tipotransaccionmodulo= new TipoTransaccionModulo();
			this.tipotransaccionmoduloObject=new Object();
			this.tipotransaccionmodulosObject=new ArrayList<Object>();
			
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
			
			this.tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			this.tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoTransaccionModulo getTipoTransaccionModulo() throws Exception {	
		TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToGet(tipotransaccionmodulo,this.datosCliente,this.arrDatoGeneral);
		TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToGet(tipotransaccionmodulo,this.arrDatoGeneral);
		
		return tipotransaccionmodulo;
	}
		
	public void setTipoTransaccionModulo(TipoTransaccionModulo newTipoTransaccionModulo) {
		this.tipotransaccionmodulo = newTipoTransaccionModulo;
	}
	
	public TipoTransaccionModuloDataAccess getTipoTransaccionModuloDataAccess() {
		return tipotransaccionmoduloDataAccess;
	}
	
	public void setTipoTransaccionModuloDataAccess(TipoTransaccionModuloDataAccess newtipotransaccionmoduloDataAccess) {
		this.tipotransaccionmoduloDataAccess = newtipotransaccionmoduloDataAccess;
	}
	
	public List<TipoTransaccionModulo> getTipoTransaccionModulos() throws Exception {		
		this.quitarTipoTransaccionModulosNulos();
		
		TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToGets(tipotransaccionmodulos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoTransaccionModulo tipotransaccionmoduloLocal: tipotransaccionmodulos ) {
			TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToGet(tipotransaccionmoduloLocal,this.arrDatoGeneral);
		}
		
		return tipotransaccionmodulos;
	}
	
	public void setTipoTransaccionModulos(List<TipoTransaccionModulo> newTipoTransaccionModulos) {
		this.tipotransaccionmodulos = newTipoTransaccionModulos;
	}
	
	public Object getTipoTransaccionModuloObject() {	
		this.tipotransaccionmoduloObject=this.tipotransaccionmoduloDataAccess.getEntityObject();
		return this.tipotransaccionmoduloObject;
	}
		
	public void setTipoTransaccionModuloObject(Object newTipoTransaccionModuloObject) {
		this.tipotransaccionmoduloObject = newTipoTransaccionModuloObject;
	}
	
	public List<Object> getTipoTransaccionModulosObject() {		
		this.tipotransaccionmodulosObject=this.tipotransaccionmoduloDataAccess.getEntitiesObject();
		return this.tipotransaccionmodulosObject;
	}
		
	public void setTipoTransaccionModulosObject(List<Object> newTipoTransaccionModulosObject) {
		this.tipotransaccionmodulosObject = newTipoTransaccionModulosObject;
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
		
		if(this.tipotransaccionmoduloDataAccess!=null) {
			this.tipotransaccionmoduloDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipotransaccionmoduloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipotransaccionmoduloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  		  
        try {
			
			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  		  
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  		  
        try {
			
			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  		  
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipotransaccionmoduloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipotransaccionmoduloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipotransaccionmoduloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipotransaccionmoduloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipotransaccionmoduloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipotransaccionmoduloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
        try {			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
        try {
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
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
		tipotransaccionmodulo = new  TipoTransaccionModulo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
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
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		  		  
        try {
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoTransaccionModulosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getTodosTipoTransaccionModulosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
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
	
	public  void  getTodosTipoTransaccionModulos(String sFinalQuery,Pagination pagination)throws Exception {
		tipotransaccionmodulos = new  ArrayList<TipoTransaccionModulo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTransaccionModulo(tipotransaccionmodulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipotransaccionmodulo.getIsNew() || tipotransaccionmodulo.getIsChanged()) { 
			this.invalidValues = tipotransaccionmoduloValidator.getInvalidValues(tipotransaccionmodulo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipotransaccionmodulo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoTransaccionModulo(List<TipoTransaccionModulo> TipoTransaccionModulos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoTransaccionModulo tipotransaccionmoduloLocal:tipotransaccionmodulos) {				
			estaValidadoObjeto=this.validarGuardarTipoTransaccionModulo(tipotransaccionmoduloLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoTransaccionModulo(List<TipoTransaccionModulo> TipoTransaccionModulos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTransaccionModulo(tipotransaccionmodulos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoTransaccionModulo(TipoTransaccionModulo TipoTransaccionModulo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTransaccionModulo(tipotransaccionmodulo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoTransaccionModulo tipotransaccionmodulo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipotransaccionmodulo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipotransaccionmodulo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoTransaccionModuloConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoTransaccionModuloConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoTransaccionModuloWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-saveTipoTransaccionModuloWithConnection");connexion.begin();			
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSave(this.tipotransaccionmodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToSave(this.tipotransaccionmodulo,this.arrDatoGeneral);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotransaccionmodulo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoTransaccionModulo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTransaccionModulo(this.tipotransaccionmodulo)) {
				TipoTransaccionModuloDataAccess.save(this.tipotransaccionmodulo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSaveAfter(this.tipotransaccionmodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTransaccionModulo();
			
			connexion.commit();			
			
			if(this.tipotransaccionmodulo.getIsDeleted()) {
				this.tipotransaccionmodulo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoTransaccionModulo()throws Exception {	
		try {	
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSave(this.tipotransaccionmodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToSave(this.tipotransaccionmodulo,this.arrDatoGeneral);
			
			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotransaccionmodulo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTransaccionModulo(this.tipotransaccionmodulo)) {			
				TipoTransaccionModuloDataAccess.save(this.tipotransaccionmodulo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSaveAfter(this.tipotransaccionmodulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipotransaccionmodulo.getIsDeleted()) {
				this.tipotransaccionmodulo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoTransaccionModulosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-saveTipoTransaccionModulosWithConnection");connexion.begin();			
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSaves(tipotransaccionmodulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoTransaccionModulos();
			
			Boolean validadoTodosTipoTransaccionModulo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTransaccionModulo tipotransaccionmoduloLocal:tipotransaccionmodulos) {		
				if(tipotransaccionmoduloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToSave(tipotransaccionmoduloLocal,this.arrDatoGeneral);
	        	
				TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotransaccionmoduloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTransaccionModulo(tipotransaccionmoduloLocal)) {
					TipoTransaccionModuloDataAccess.save(tipotransaccionmoduloLocal, connexion);				
				} else {
					validadoTodosTipoTransaccionModulo=false;
				}
			}
			
			if(!validadoTodosTipoTransaccionModulo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSavesAfter(tipotransaccionmodulos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTransaccionModulos();
			
			connexion.commit();		
			
			this.quitarTipoTransaccionModulosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoTransaccionModulos()throws Exception {				
		 try {	
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSaves(tipotransaccionmodulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoTransaccionModulo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTransaccionModulo tipotransaccionmoduloLocal:tipotransaccionmodulos) {				
				if(tipotransaccionmoduloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToSave(tipotransaccionmoduloLocal,this.arrDatoGeneral);
	        	
				TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotransaccionmoduloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTransaccionModulo(tipotransaccionmoduloLocal)) {				
					TipoTransaccionModuloDataAccess.save(tipotransaccionmoduloLocal, connexion);				
				} else {
					validadoTodosTipoTransaccionModulo=false;
				}
			}
			
			if(!validadoTodosTipoTransaccionModulo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoTransaccionModuloLogicAdditional.checkTipoTransaccionModuloToSavesAfter(tipotransaccionmodulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoTransaccionModulosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTransaccionModuloParameterReturnGeneral procesarAccionTipoTransaccionModulos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTransaccionModulo> tipotransaccionmodulos,TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloParameterGeneral)throws Exception {
		 try {	
			TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloReturnGeneral=new TipoTransaccionModuloParameterReturnGeneral();
	
			TipoTransaccionModuloLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipotransaccionmodulos,tipotransaccionmoduloParameterGeneral,tipotransaccionmoduloReturnGeneral);
			
			return tipotransaccionmoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTransaccionModuloParameterReturnGeneral procesarAccionTipoTransaccionModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTransaccionModulo> tipotransaccionmodulos,TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-procesarAccionTipoTransaccionModulosWithConnection");connexion.begin();			
			
			TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloReturnGeneral=new TipoTransaccionModuloParameterReturnGeneral();
	
			TipoTransaccionModuloLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipotransaccionmodulos,tipotransaccionmoduloParameterGeneral,tipotransaccionmoduloReturnGeneral);
			
			this.connexion.commit();
			
			return tipotransaccionmoduloReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTransaccionModuloParameterReturnGeneral procesarEventosTipoTransaccionModulos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTransaccionModulo> tipotransaccionmodulos,TipoTransaccionModulo tipotransaccionmodulo,TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloParameterGeneral,Boolean isEsNuevoTipoTransaccionModulo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloReturnGeneral=new TipoTransaccionModuloParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotransaccionmoduloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoTransaccionModuloLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipotransaccionmodulos,tipotransaccionmodulo,tipotransaccionmoduloParameterGeneral,tipotransaccionmoduloReturnGeneral,isEsNuevoTipoTransaccionModulo,clases);
			
			return tipotransaccionmoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoTransaccionModuloParameterReturnGeneral procesarEventosTipoTransaccionModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTransaccionModulo> tipotransaccionmodulos,TipoTransaccionModulo tipotransaccionmodulo,TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloParameterGeneral,Boolean isEsNuevoTipoTransaccionModulo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-procesarEventosTipoTransaccionModulosWithConnection");connexion.begin();			
			
			TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloReturnGeneral=new TipoTransaccionModuloParameterReturnGeneral();
	
			tipotransaccionmoduloReturnGeneral.setTipoTransaccionModulo(tipotransaccionmodulo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotransaccionmoduloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoTransaccionModuloLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipotransaccionmodulos,tipotransaccionmodulo,tipotransaccionmoduloParameterGeneral,tipotransaccionmoduloReturnGeneral,isEsNuevoTipoTransaccionModulo,clases);
			
			this.connexion.commit();
			
			return tipotransaccionmoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTransaccionModuloParameterReturnGeneral procesarImportacionTipoTransaccionModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-procesarImportacionTipoTransaccionModulosWithConnection");connexion.begin();			
			
			TipoTransaccionModuloParameterReturnGeneral tipotransaccionmoduloReturnGeneral=new TipoTransaccionModuloParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipotransaccionmodulos=new ArrayList<TipoTransaccionModulo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipotransaccionmodulo=new TipoTransaccionModulo();
				
				
				if(conColumnasBase) {this.tipotransaccionmodulo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipotransaccionmodulo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipotransaccionmodulo.setnombre(arrColumnas[iColumn++]);
				this.tipotransaccionmodulo.setsiglas(arrColumnas[iColumn++]);
				
				this.tipotransaccionmodulos.add(this.tipotransaccionmodulo);
			}
			
			this.saveTipoTransaccionModulos();
			
			this.connexion.commit();
			
			tipotransaccionmoduloReturnGeneral.setConRetornoEstaProcesado(true);
			tipotransaccionmoduloReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipotransaccionmoduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoTransaccionModulosEliminados() throws Exception {				
		
		List<TipoTransaccionModulo> tipotransaccionmodulosAux= new ArrayList<TipoTransaccionModulo>();
		
		for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos) {
			if(!tipotransaccionmodulo.getIsDeleted()) {
				tipotransaccionmodulosAux.add(tipotransaccionmodulo);
			}
		}
		
		tipotransaccionmodulos=tipotransaccionmodulosAux;
	}
	
	public void quitarTipoTransaccionModulosNulos() throws Exception {				
		
		List<TipoTransaccionModulo> tipotransaccionmodulosAux= new ArrayList<TipoTransaccionModulo>();
		
		for(TipoTransaccionModulo tipotransaccionmodulo : this.tipotransaccionmodulos) {
			if(tipotransaccionmodulo==null) {
				tipotransaccionmodulosAux.add(tipotransaccionmodulo);
			}
		}
		
		//this.tipotransaccionmodulos=tipotransaccionmodulosAux;
		
		this.tipotransaccionmodulos.removeAll(tipotransaccionmodulosAux);
	}
	
	public void getSetVersionRowTipoTransaccionModuloWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipotransaccionmodulo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipotransaccionmodulo.getIsDeleted() || (tipotransaccionmodulo.getIsChanged()&&!tipotransaccionmodulo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipotransaccionmoduloDataAccess.getSetVersionRowTipoTransaccionModulo(connexion,tipotransaccionmodulo.getId());
				
				if(!tipotransaccionmodulo.getVersionRow().equals(timestamp)) {	
					tipotransaccionmodulo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipotransaccionmodulo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoTransaccionModulo()throws Exception {	
		
		if(tipotransaccionmodulo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipotransaccionmodulo.getIsDeleted() || (tipotransaccionmodulo.getIsChanged()&&!tipotransaccionmodulo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipotransaccionmoduloDataAccess.getSetVersionRowTipoTransaccionModulo(connexion,tipotransaccionmodulo.getId());
			
			try {							
				if(!tipotransaccionmodulo.getVersionRow().equals(timestamp)) {	
					tipotransaccionmodulo.setVersionRow(timestamp);
				}
				
				tipotransaccionmodulo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoTransaccionModulosWithConnection()throws Exception {	
		if(tipotransaccionmodulos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoTransaccionModulo tipotransaccionmoduloAux:tipotransaccionmodulos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipotransaccionmoduloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotransaccionmoduloAux.getIsDeleted() || (tipotransaccionmoduloAux.getIsChanged()&&!tipotransaccionmoduloAux.getIsNew())) {
						
						timestamp=tipotransaccionmoduloDataAccess.getSetVersionRowTipoTransaccionModulo(connexion,tipotransaccionmoduloAux.getId());
						
						if(!tipotransaccionmodulo.getVersionRow().equals(timestamp)) {	
							tipotransaccionmoduloAux.setVersionRow(timestamp);
						}
								
						tipotransaccionmoduloAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoTransaccionModulos()throws Exception {	
		if(tipotransaccionmodulos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoTransaccionModulo tipotransaccionmoduloAux:tipotransaccionmodulos) {
					if(tipotransaccionmoduloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotransaccionmoduloAux.getIsDeleted() || (tipotransaccionmoduloAux.getIsChanged()&&!tipotransaccionmoduloAux.getIsNew())) {
						
						timestamp=tipotransaccionmoduloDataAccess.getSetVersionRowTipoTransaccionModulo(connexion,tipotransaccionmoduloAux.getId());
						
						if(!tipotransaccionmoduloAux.getVersionRow().equals(timestamp)) {	
							tipotransaccionmoduloAux.setVersionRow(timestamp);
						}
						
													
						tipotransaccionmoduloAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoTransaccionModuloParameterReturnGeneral cargarCombosLoteForeignKeyTipoTransaccionModuloWithConnection(String finalQueryGlobalModulo) throws Exception {
		TipoTransaccionModuloParameterReturnGeneral  tipotransaccionmoduloReturnGeneral =new TipoTransaccionModuloParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoTransaccionModuloWithConnection");connexion.begin();
			
			tipotransaccionmoduloReturnGeneral =new TipoTransaccionModuloParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipotransaccionmoduloReturnGeneral.setmodulosForeignKey(modulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipotransaccionmoduloReturnGeneral;
	}
	
	public TipoTransaccionModuloParameterReturnGeneral cargarCombosLoteForeignKeyTipoTransaccionModulo(String finalQueryGlobalModulo) throws Exception {
		TipoTransaccionModuloParameterReturnGeneral  tipotransaccionmoduloReturnGeneral =new TipoTransaccionModuloParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipotransaccionmoduloReturnGeneral =new TipoTransaccionModuloParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipotransaccionmoduloReturnGeneral.setmodulosForeignKey(modulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipotransaccionmoduloReturnGeneral;
	}
	
	
	public void deepLoad(TipoTransaccionModulo tipotransaccionmodulo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToGet(tipotransaccionmodulo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipotransaccionmodulo.setModulo(tipotransaccionmoduloDataAccess.getModulo(connexion,tipotransaccionmodulo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				tipotransaccionmodulo.setModulo(tipotransaccionmoduloDataAccess.getModulo(connexion,tipotransaccionmodulo));
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
			tipotransaccionmodulo.setModulo(tipotransaccionmoduloDataAccess.getModulo(connexion,tipotransaccionmodulo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipotransaccionmodulo.setModulo(tipotransaccionmoduloDataAccess.getModulo(connexion,tipotransaccionmodulo));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipotransaccionmodulo.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				tipotransaccionmodulo.setModulo(tipotransaccionmoduloDataAccess.getModulo(connexion,tipotransaccionmodulo));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(tipotransaccionmodulo.getModulo(),isDeep,deepLoadType,clases);				
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
			tipotransaccionmodulo.setModulo(tipotransaccionmoduloDataAccess.getModulo(connexion,tipotransaccionmodulo));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(tipotransaccionmodulo.getModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoTransaccionModulo tipotransaccionmodulo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoTransaccionModuloLogicAdditional.updateTipoTransaccionModuloToSave(tipotransaccionmodulo,this.arrDatoGeneral);
			
TipoTransaccionModuloDataAccess.save(tipotransaccionmodulo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(tipotransaccionmodulo.getModulo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipotransaccionmodulo.getModulo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(tipotransaccionmodulo.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipotransaccionmodulo.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipotransaccionmodulo.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(tipotransaccionmodulo.getModulo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoTransaccionModulo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipotransaccionmodulo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(tipotransaccionmodulo);
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
			this.deepLoad(this.tipotransaccionmodulo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTransaccionModulo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipotransaccionmodulos!=null) {
				for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos) {
					this.deepLoad(tipotransaccionmodulo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(tipotransaccionmodulos);
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
			if(tipotransaccionmodulos!=null) {
				for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos) {
					this.deepLoad(tipotransaccionmodulo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(tipotransaccionmodulos);
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
			this.getNewConnexionToDeep(TipoTransaccionModulo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipotransaccionmodulo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoTransaccionModulo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipotransaccionmodulos!=null) {
				for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos) {
					this.deepSave(tipotransaccionmodulo,isDeep,deepLoadType,clases);
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
			if(tipotransaccionmodulos!=null) {
				for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos) {
					this.deepSave(tipotransaccionmodulo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoTransaccionModulosBusquedaPorIdModuloPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoTransaccionModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTransaccionModulosBusquedaPorIdModuloPorNombre(String sFinalQuery,Pagination pagination,Long id_modulo,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoTransaccionModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTransaccionModulosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoTransaccionModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTransaccionModulosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoTransaccionModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTransaccionModulosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTransaccionModulosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoTransaccionModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotransaccionmodulos=tipotransaccionmoduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTransaccionModuloPorIdModuloPorNombreWithConnection(Long id_modulo,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoTransaccionModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTransaccionModuloPorIdModuloPorNombre(Long id_modulo,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoTransaccionModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTransaccionModuloPorIdPorIdModuloWithConnection(Long id,Long id_modulo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTransaccionModulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoTransaccionModuloConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTransaccionModuloPorIdPorIdModulo(Long id,Long id_modulo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoTransaccionModuloConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoTransaccionModuloConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipotransaccionmodulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoTransaccionModuloConstantesFunciones.refrescarForeignKeysDescripcionesTipoTransaccionModulo(this.tipotransaccionmodulo);
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
			if(TipoTransaccionModuloConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTransaccionModuloDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoTransaccionModulo tipotransaccionmodulo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTransaccionModuloConstantesFunciones.ISCONAUDITORIA) {
				if(tipotransaccionmodulo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTransaccionModuloDataAccess.TABLENAME, tipotransaccionmodulo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTransaccionModuloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTransaccionModuloLogic.registrarAuditoriaDetallesTipoTransaccionModulo(connexion,tipotransaccionmodulo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipotransaccionmodulo.getIsDeleted()) {
					/*if(!tipotransaccionmodulo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoTransaccionModuloDataAccess.TABLENAME, tipotransaccionmodulo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoTransaccionModuloLogic.registrarAuditoriaDetallesTipoTransaccionModulo(connexion,tipotransaccionmodulo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTransaccionModuloDataAccess.TABLENAME, tipotransaccionmodulo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipotransaccionmodulo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTransaccionModuloDataAccess.TABLENAME, tipotransaccionmodulo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTransaccionModuloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTransaccionModuloLogic.registrarAuditoriaDetallesTipoTransaccionModulo(connexion,tipotransaccionmodulo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoTransaccionModulo(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipotransaccionmodulo.getIsNew()||!tipotransaccionmodulo.getid_modulo().equals(tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getid_modulo()!=null)
				{
					strValorActual=tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getid_modulo().toString();
				}
				if(tipotransaccionmodulo.getid_modulo()!=null)
				{
					strValorNuevo=tipotransaccionmodulo.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTransaccionModuloConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipotransaccionmodulo.getIsNew()||!tipotransaccionmodulo.getnombre().equals(tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getnombre()!=null)
				{
					strValorActual=tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getnombre();
				}
				if(tipotransaccionmodulo.getnombre()!=null)
				{
					strValorNuevo=tipotransaccionmodulo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTransaccionModuloConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipotransaccionmodulo.getIsNew()||!tipotransaccionmodulo.getsiglas().equals(tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getsiglas()!=null)
				{
					strValorActual=tipotransaccionmodulo.getTipoTransaccionModuloOriginal().getsiglas();
				}
				if(tipotransaccionmodulo.getsiglas()!=null)
				{
					strValorNuevo=tipotransaccionmodulo.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTransaccionModuloConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoTransaccionModuloRelacionesWithConnection(TipoTransaccionModulo tipotransaccionmodulo) throws Exception {

		if(!tipotransaccionmodulo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoTransaccionModuloRelacionesBase(tipotransaccionmodulo,true);
		}
	}

	public void saveTipoTransaccionModuloRelaciones(TipoTransaccionModulo tipotransaccionmodulo)throws Exception {

		if(!tipotransaccionmodulo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoTransaccionModuloRelacionesBase(tipotransaccionmodulo,false);
		}
	}

	public void saveTipoTransaccionModuloRelacionesBase(TipoTransaccionModulo tipotransaccionmodulo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoTransaccionModulo-saveRelacionesWithConnection");}
	

			this.setTipoTransaccionModulo(tipotransaccionmodulo);

				if((tipotransaccionmodulo.getIsNew()||tipotransaccionmodulo.getIsChanged())&&!tipotransaccionmodulo.getIsDeleted()) {
					this.saveTipoTransaccionModulo();
					this.saveTipoTransaccionModuloRelacionesDetalles();

				} else if(tipotransaccionmodulo.getIsDeleted()) {
					this.saveTipoTransaccionModuloRelacionesDetalles();
					this.saveTipoTransaccionModulo();
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
	
	
	private void saveTipoTransaccionModuloRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTransaccionModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTransaccionModuloConstantesFunciones.getClassesForeignKeysOfTipoTransaccionModulo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTransaccionModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTransaccionModuloConstantesFunciones.getClassesRelationshipsOfTipoTransaccionModulo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
