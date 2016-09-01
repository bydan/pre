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
import com.bydan.erp.nomina.util.TipoGeneroConstantesFunciones;
import com.bydan.erp.nomina.util.TipoGeneroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoGeneroParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoGenero;
//import com.bydan.erp.nomina.business.logic.TipoGeneroLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGeneroLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGeneroLogic.class);
	
	protected TipoGeneroDataAccess tipogeneroDataAccess; 	
	protected TipoGenero tipogenero;
	protected List<TipoGenero> tipogeneros;
	protected Object tipogeneroObject;	
	protected List<Object> tipogenerosObject;
	
	public static ClassValidator<TipoGenero> tipogeneroValidator = new ClassValidator<TipoGenero>(TipoGenero.class);	
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
	
	
	
	
	public  TipoGeneroLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogeneroDataAccess = new TipoGeneroDataAccess();
			
			this.tipogeneros= new ArrayList<TipoGenero>();
			this.tipogenero= new TipoGenero();
			
			this.tipogeneroObject=new Object();
			this.tipogenerosObject=new ArrayList<Object>();
				
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
			
			this.tipogeneroDataAccess.setConnexionType(this.connexionType);
			this.tipogeneroDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGeneroLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogeneroDataAccess = new TipoGeneroDataAccess();
			this.tipogeneros= new ArrayList<TipoGenero>();
			this.tipogenero= new TipoGenero();
			this.tipogeneroObject=new Object();
			this.tipogenerosObject=new ArrayList<Object>();
			
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
			
			this.tipogeneroDataAccess.setConnexionType(this.connexionType);
			this.tipogeneroDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGenero getTipoGenero() throws Exception {	
		//TipoGeneroLogicAdditional.checkTipoGeneroToGet(tipogenero,this.datosCliente,this.arrDatoGeneral);
		//TipoGeneroLogicAdditional.updateTipoGeneroToGet(tipogenero,this.arrDatoGeneral);
		
		return tipogenero;
	}
		
	public void setTipoGenero(TipoGenero newTipoGenero) {
		this.tipogenero = newTipoGenero;
	}
	
	public TipoGeneroDataAccess getTipoGeneroDataAccess() {
		return tipogeneroDataAccess;
	}
	
	public void setTipoGeneroDataAccess(TipoGeneroDataAccess newtipogeneroDataAccess) {
		this.tipogeneroDataAccess = newtipogeneroDataAccess;
	}
	
	public List<TipoGenero> getTipoGeneros() throws Exception {		
		this.quitarTipoGenerosNulos();
		
		//TipoGeneroLogicAdditional.checkTipoGeneroToGets(tipogeneros,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGenero tipogeneroLocal: tipogeneros ) {
			//TipoGeneroLogicAdditional.updateTipoGeneroToGet(tipogeneroLocal,this.arrDatoGeneral);
		}
		
		return tipogeneros;
	}
	
	public void setTipoGeneros(List<TipoGenero> newTipoGeneros) {
		this.tipogeneros = newTipoGeneros;
	}
	
	public Object getTipoGeneroObject() {	
		this.tipogeneroObject=this.tipogeneroDataAccess.getEntityObject();
		return this.tipogeneroObject;
	}
		
	public void setTipoGeneroObject(Object newTipoGeneroObject) {
		this.tipogeneroObject = newTipoGeneroObject;
	}
	
	public List<Object> getTipoGenerosObject() {		
		this.tipogenerosObject=this.tipogeneroDataAccess.getEntitiesObject();
		return this.tipogenerosObject;
	}
		
	public void setTipoGenerosObject(List<Object> newTipoGenerosObject) {
		this.tipogenerosObject = newTipoGenerosObject;
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
		
		if(this.tipogeneroDataAccess!=null) {
			this.tipogeneroDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogeneroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogeneroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogenero = new  TipoGenero();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogenero=tipogeneroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogenero,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
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
		tipogenero = new  TipoGenero();
		  		  
        try {
			
			tipogenero=tipogeneroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogenero,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogenero = new  TipoGenero();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogenero=tipogeneroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogenero,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
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
		tipogenero = new  TipoGenero();
		  		  
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
		tipogenero = new  TipoGenero();
		  		  
        try {
			
			tipogenero=tipogeneroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogenero,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogenero = new  TipoGenero();
		  		  
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
		tipogenero = new  TipoGenero();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogeneroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogenero = new  TipoGenero();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogeneroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogenero = new  TipoGenero();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogeneroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogenero = new  TipoGenero();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogeneroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogenero = new  TipoGenero();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogeneroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogenero = new  TipoGenero();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogeneroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogeneros = new  ArrayList<TipoGenero>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
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
		tipogeneros = new  ArrayList<TipoGenero>();
		  		  
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
		tipogeneros = new  ArrayList<TipoGenero>();
		  		  
        try {			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogeneros = new  ArrayList<TipoGenero>();
		  		  
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
		tipogeneros = new  ArrayList<TipoGenero>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
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
		tipogeneros = new  ArrayList<TipoGenero>();
		  		  
        try {
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
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
		tipogeneros = new  ArrayList<TipoGenero>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
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
		tipogeneros = new  ArrayList<TipoGenero>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogenero = new  TipoGenero();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogenero=tipogeneroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogenero);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
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
		tipogenero = new  TipoGenero();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogenero=tipogeneroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGenero(tipogenero);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoGenerosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogeneros = new  ArrayList<TipoGenero>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-getTodosTipoGenerosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
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
	
	public  void  getTodosTipoGeneros(String sFinalQuery,Pagination pagination)throws Exception {
		tipogeneros = new  ArrayList<TipoGenero>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogeneros=tipogeneroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGenero(tipogeneros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogeneros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGenero(TipoGenero tipogenero) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogenero.getIsNew() || tipogenero.getIsChanged()) { 
			this.invalidValues = tipogeneroValidator.getInvalidValues(tipogenero);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogenero);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGenero(List<TipoGenero> TipoGeneros) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGenero tipogeneroLocal:tipogeneros) {				
			estaValidadoObjeto=this.validarGuardarTipoGenero(tipogeneroLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGenero(List<TipoGenero> TipoGeneros) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGenero(tipogeneros)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGenero(TipoGenero TipoGenero) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGenero(tipogenero)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGenero tipogenero) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogenero.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGeneroConstantesFunciones.getTipoGeneroLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogenero","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGeneroConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGeneroConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGeneroWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-saveTipoGeneroWithConnection");connexion.begin();			
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSave(this.tipogenero,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGeneroLogicAdditional.updateTipoGeneroToSave(this.tipogenero,this.arrDatoGeneral);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogenero,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGenero();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGenero(this.tipogenero)) {
				TipoGeneroDataAccess.save(this.tipogenero, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogenero,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSaveAfter(this.tipogenero,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGenero();
			
			connexion.commit();			
			
			if(this.tipogenero.getIsDeleted()) {
				this.tipogenero=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGenero()throws Exception {	
		try {	
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSave(this.tipogenero,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGeneroLogicAdditional.updateTipoGeneroToSave(this.tipogenero,this.arrDatoGeneral);
			
			TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogenero,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGenero(this.tipogenero)) {			
				TipoGeneroDataAccess.save(this.tipogenero, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogenero,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSaveAfter(this.tipogenero,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogenero.getIsDeleted()) {
				this.tipogenero=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGenerosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-saveTipoGenerosWithConnection");connexion.begin();			
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSaves(tipogeneros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGeneros();
			
			Boolean validadoTodosTipoGenero=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGenero tipogeneroLocal:tipogeneros) {		
				if(tipogeneroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGeneroLogicAdditional.updateTipoGeneroToSave(tipogeneroLocal,this.arrDatoGeneral);
	        	
				TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogeneroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGenero(tipogeneroLocal)) {
					TipoGeneroDataAccess.save(tipogeneroLocal, connexion);				
				} else {
					validadoTodosTipoGenero=false;
				}
			}
			
			if(!validadoTodosTipoGenero) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSavesAfter(tipogeneros,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGeneros();
			
			connexion.commit();		
			
			this.quitarTipoGenerosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGeneros()throws Exception {				
		 try {	
			//TipoGeneroLogicAdditional.checkTipoGeneroToSaves(tipogeneros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGenero=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGenero tipogeneroLocal:tipogeneros) {				
				if(tipogeneroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGeneroLogicAdditional.updateTipoGeneroToSave(tipogeneroLocal,this.arrDatoGeneral);
	        	
				TipoGeneroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogeneroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGenero(tipogeneroLocal)) {				
					TipoGeneroDataAccess.save(tipogeneroLocal, connexion);				
				} else {
					validadoTodosTipoGenero=false;
				}
			}
			
			if(!validadoTodosTipoGenero) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGeneroLogicAdditional.checkTipoGeneroToSavesAfter(tipogeneros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGenerosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGeneroParameterReturnGeneral procesarAccionTipoGeneros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGenero> tipogeneros,TipoGeneroParameterReturnGeneral tipogeneroParameterGeneral)throws Exception {
		 try {	
			TipoGeneroParameterReturnGeneral tipogeneroReturnGeneral=new TipoGeneroParameterReturnGeneral();
	
			
			return tipogeneroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGeneroParameterReturnGeneral procesarAccionTipoGenerosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGenero> tipogeneros,TipoGeneroParameterReturnGeneral tipogeneroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-procesarAccionTipoGenerosWithConnection");connexion.begin();			
			
			TipoGeneroParameterReturnGeneral tipogeneroReturnGeneral=new TipoGeneroParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipogeneroReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGeneroParameterReturnGeneral procesarEventosTipoGeneros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGenero> tipogeneros,TipoGenero tipogenero,TipoGeneroParameterReturnGeneral tipogeneroParameterGeneral,Boolean isEsNuevoTipoGenero,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGeneroParameterReturnGeneral tipogeneroReturnGeneral=new TipoGeneroParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogeneroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipogeneroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGeneroParameterReturnGeneral procesarEventosTipoGenerosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGenero> tipogeneros,TipoGenero tipogenero,TipoGeneroParameterReturnGeneral tipogeneroParameterGeneral,Boolean isEsNuevoTipoGenero,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-procesarEventosTipoGenerosWithConnection");connexion.begin();			
			
			TipoGeneroParameterReturnGeneral tipogeneroReturnGeneral=new TipoGeneroParameterReturnGeneral();
	
			tipogeneroReturnGeneral.setTipoGenero(tipogenero);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogeneroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipogeneroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGeneroParameterReturnGeneral procesarImportacionTipoGenerosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGeneroParameterReturnGeneral tipogeneroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-procesarImportacionTipoGenerosWithConnection");connexion.begin();			
			
			TipoGeneroParameterReturnGeneral tipogeneroReturnGeneral=new TipoGeneroParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogeneros=new ArrayList<TipoGenero>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogenero=new TipoGenero();
				
				
				if(conColumnasBase) {this.tipogenero.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogenero.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogenero.setcodigo(arrColumnas[iColumn++]);
				this.tipogenero.setnombre(arrColumnas[iColumn++]);
				
				this.tipogeneros.add(this.tipogenero);
			}
			
			this.saveTipoGeneros();
			
			this.connexion.commit();
			
			tipogeneroReturnGeneral.setConRetornoEstaProcesado(true);
			tipogeneroReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogeneroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGenerosEliminados() throws Exception {				
		
		List<TipoGenero> tipogenerosAux= new ArrayList<TipoGenero>();
		
		for(TipoGenero tipogenero:tipogeneros) {
			if(!tipogenero.getIsDeleted()) {
				tipogenerosAux.add(tipogenero);
			}
		}
		
		tipogeneros=tipogenerosAux;
	}
	
	public void quitarTipoGenerosNulos() throws Exception {				
		
		List<TipoGenero> tipogenerosAux= new ArrayList<TipoGenero>();
		
		for(TipoGenero tipogenero : this.tipogeneros) {
			if(tipogenero==null) {
				tipogenerosAux.add(tipogenero);
			}
		}
		
		//this.tipogeneros=tipogenerosAux;
		
		this.tipogeneros.removeAll(tipogenerosAux);
	}
	
	public void getSetVersionRowTipoGeneroWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogenero.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogenero.getIsDeleted() || (tipogenero.getIsChanged()&&!tipogenero.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogeneroDataAccess.getSetVersionRowTipoGenero(connexion,tipogenero.getId());
				
				if(!tipogenero.getVersionRow().equals(timestamp)) {	
					tipogenero.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogenero.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGenero()throws Exception {	
		
		if(tipogenero.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogenero.getIsDeleted() || (tipogenero.getIsChanged()&&!tipogenero.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogeneroDataAccess.getSetVersionRowTipoGenero(connexion,tipogenero.getId());
			
			try {							
				if(!tipogenero.getVersionRow().equals(timestamp)) {	
					tipogenero.setVersionRow(timestamp);
				}
				
				tipogenero.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGenerosWithConnection()throws Exception {	
		if(tipogeneros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGenero tipogeneroAux:tipogeneros) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogeneroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogeneroAux.getIsDeleted() || (tipogeneroAux.getIsChanged()&&!tipogeneroAux.getIsNew())) {
						
						timestamp=tipogeneroDataAccess.getSetVersionRowTipoGenero(connexion,tipogeneroAux.getId());
						
						if(!tipogenero.getVersionRow().equals(timestamp)) {	
							tipogeneroAux.setVersionRow(timestamp);
						}
								
						tipogeneroAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGeneros()throws Exception {	
		if(tipogeneros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGenero tipogeneroAux:tipogeneros) {
					if(tipogeneroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogeneroAux.getIsDeleted() || (tipogeneroAux.getIsChanged()&&!tipogeneroAux.getIsNew())) {
						
						timestamp=tipogeneroDataAccess.getSetVersionRowTipoGenero(connexion,tipogeneroAux.getId());
						
						if(!tipogeneroAux.getVersionRow().equals(timestamp)) {	
							tipogeneroAux.setVersionRow(timestamp);
						}
						
													
						tipogeneroAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoGeneroWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			CargaFamiliar_NMLogic cargafamiliar_nmLogic=new CargaFamiliar_NMLogic();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
			CargaFamiliarLogic cargafamiliarLogic=new CargaFamiliarLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGenero.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoGeneroWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(CargaFamiliar_NM.class));
			classes.add(new Classe(SubCliente.class));
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
			classes.add(new Classe(CargaFamiliar.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			cargafamiliar_nmLogic.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic.setDatosCliente(this.datosCliente);
			cargafamiliar_nmLogic.setIsConRefrescarForeignKeys(true);

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);

			cargafamiliarLogic.setConnexion(this.getConnexion());
			cargafamiliarLogic.setDatosCliente(this.datosCliente);
			cargafamiliarLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoGenero tipogenero:this.tipogeneros) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(tipogenero.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliar_nmLogic.setCargaFamiliar_NMs(tipogenero.cargafamiliar_nms);
				cargafamiliar_nmLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(tipogenero.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(tipogenero.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(tipogenero.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliarLogic.setCargaFamiliars(tipogenero.cargafamiliars);
				cargafamiliarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoGenero tipogenero,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoGeneroLogicAdditional.updateTipoGeneroToGet(tipogenero,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogenero.setClientes(tipogeneroDataAccess.getClientes(connexion,tipogenero));
		tipogenero.setCargaFamiliar_NMs(tipogeneroDataAccess.getCargaFamiliar_NMs(connexion,tipogenero));
		tipogenero.setSubClientes(tipogeneroDataAccess.getSubClientes(connexion,tipogenero));
		tipogenero.setEmpleados(tipogeneroDataAccess.getEmpleados(connexion,tipogenero));
		tipogenero.setParametroCarteraDefectos(tipogeneroDataAccess.getParametroCarteraDefectos(connexion,tipogenero));
		tipogenero.setCargaFamiliars(tipogeneroDataAccess.getCargaFamiliars(connexion,tipogenero));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setClientes(tipogeneroDataAccess.getClientes(connexion,tipogenero));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(tipogenero.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					tipogenero.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setCargaFamiliar_NMs(tipogeneroDataAccess.getCargaFamiliar_NMs(connexion,tipogenero));

				if(this.isConDeep) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(this.connexion);
					cargafamiliar_nmLogic.setCargaFamiliar_NMs(tipogenero.getCargaFamiliar_NMs());
					ArrayList<Classe> classesLocal=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliar_nmLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
					tipogenero.setCargaFamiliar_NMs(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setSubClientes(tipogeneroDataAccess.getSubClientes(connexion,tipogenero));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(tipogenero.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					tipogenero.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setEmpleados(tipogeneroDataAccess.getEmpleados(connexion,tipogenero));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(tipogenero.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					tipogenero.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setParametroCarteraDefectos(tipogeneroDataAccess.getParametroCarteraDefectos(connexion,tipogenero));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(tipogenero.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					tipogenero.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setCargaFamiliars(tipogeneroDataAccess.getCargaFamiliars(connexion,tipogenero));

				if(this.isConDeep) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(this.connexion);
					cargafamiliarLogic.setCargaFamiliars(tipogenero.getCargaFamiliars());
					ArrayList<Classe> classesLocal=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliarLogic.getCargaFamiliars());
					tipogenero.setCargaFamiliars(cargafamiliarLogic.getCargaFamiliars());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipogenero.setClientes(tipogeneroDataAccess.getClientes(connexion,tipogenero));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			tipogenero.setCargaFamiliar_NMs(tipogeneroDataAccess.getCargaFamiliar_NMs(connexion,tipogenero));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			tipogenero.setSubClientes(tipogeneroDataAccess.getSubClientes(connexion,tipogenero));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipogenero.setEmpleados(tipogeneroDataAccess.getEmpleados(connexion,tipogenero));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipogenero.setParametroCarteraDefectos(tipogeneroDataAccess.getParametroCarteraDefectos(connexion,tipogenero));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			tipogenero.setCargaFamiliars(tipogeneroDataAccess.getCargaFamiliars(connexion,tipogenero));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipogenero.setClientes(tipogeneroDataAccess.getClientes(connexion,tipogenero));

		for(Cliente cliente:tipogenero.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		tipogenero.setCargaFamiliar_NMs(tipogeneroDataAccess.getCargaFamiliar_NMs(connexion,tipogenero));

		for(CargaFamiliar_NM cargafamiliar_nm:tipogenero.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		tipogenero.setSubClientes(tipogeneroDataAccess.getSubClientes(connexion,tipogenero));

		for(SubCliente subcliente:tipogenero.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		tipogenero.setEmpleados(tipogeneroDataAccess.getEmpleados(connexion,tipogenero));

		for(Empleado empleado:tipogenero.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		tipogenero.setParametroCarteraDefectos(tipogeneroDataAccess.getParametroCarteraDefectos(connexion,tipogenero));

		for(ParametroCarteraDefecto parametrocarteradefecto:tipogenero.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}

		tipogenero.setCargaFamiliars(tipogeneroDataAccess.getCargaFamiliars(connexion,tipogenero));

		for(CargaFamiliar cargafamiliar:tipogenero.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setClientes(tipogeneroDataAccess.getClientes(connexion,tipogenero));

				for(Cliente cliente:tipogenero.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setCargaFamiliar_NMs(tipogeneroDataAccess.getCargaFamiliar_NMs(connexion,tipogenero));

				for(CargaFamiliar_NM cargafamiliar_nm:tipogenero.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setSubClientes(tipogeneroDataAccess.getSubClientes(connexion,tipogenero));

				for(SubCliente subcliente:tipogenero.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setEmpleados(tipogeneroDataAccess.getEmpleados(connexion,tipogenero));

				for(Empleado empleado:tipogenero.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setParametroCarteraDefectos(tipogeneroDataAccess.getParametroCarteraDefectos(connexion,tipogenero));

				for(ParametroCarteraDefecto parametrocarteradefecto:tipogenero.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogenero.setCargaFamiliars(tipogeneroDataAccess.getCargaFamiliars(connexion,tipogenero));

				for(CargaFamiliar cargafamiliar:tipogenero.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipogenero.setClientes(tipogeneroDataAccess.getClientes(connexion,tipogenero));

			for(Cliente cliente:tipogenero.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			tipogenero.setCargaFamiliar_NMs(tipogeneroDataAccess.getCargaFamiliar_NMs(connexion,tipogenero));

			for(CargaFamiliar_NM cargafamiliar_nm:tipogenero.getCargaFamiliar_NMs()) {
				CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
				cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			tipogenero.setSubClientes(tipogeneroDataAccess.getSubClientes(connexion,tipogenero));

			for(SubCliente subcliente:tipogenero.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipogenero.setEmpleados(tipogeneroDataAccess.getEmpleados(connexion,tipogenero));

			for(Empleado empleado:tipogenero.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipogenero.setParametroCarteraDefectos(tipogeneroDataAccess.getParametroCarteraDefectos(connexion,tipogenero));

			for(ParametroCarteraDefecto parametrocarteradefecto:tipogenero.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			tipogenero.setCargaFamiliars(tipogeneroDataAccess.getCargaFamiliars(connexion,tipogenero));

			for(CargaFamiliar cargafamiliar:tipogenero.getCargaFamiliars()) {
				CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
				cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGenero tipogenero,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGenero.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogenero,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(tipogenero);
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
			this.deepLoad(this.tipogenero,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(this.tipogenero);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGenero.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogeneros!=null) {
				for(TipoGenero tipogenero:tipogeneros) {
					this.deepLoad(tipogenero,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(tipogeneros);
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
			if(tipogeneros!=null) {
				for(TipoGenero tipogenero:tipogeneros) {
					this.deepLoad(tipogenero,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGeneroConstantesFunciones.refrescarForeignKeysDescripcionesTipoGenero(tipogeneros);
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
			if(TipoGeneroConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGeneroDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGenero tipogenero,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGeneroConstantesFunciones.ISCONAUDITORIA) {
				if(tipogenero.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGeneroDataAccess.TABLENAME, tipogenero.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGeneroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGeneroLogic.registrarAuditoriaDetallesTipoGenero(connexion,tipogenero,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogenero.getIsDeleted()) {
					/*if(!tipogenero.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGeneroDataAccess.TABLENAME, tipogenero.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGeneroLogic.registrarAuditoriaDetallesTipoGenero(connexion,tipogenero,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGeneroDataAccess.TABLENAME, tipogenero.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogenero.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGeneroDataAccess.TABLENAME, tipogenero.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGeneroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGeneroLogic.registrarAuditoriaDetallesTipoGenero(connexion,tipogenero,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGenero(Connexion connexion,TipoGenero tipogenero)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogenero.getIsNew()||!tipogenero.getcodigo().equals(tipogenero.getTipoGeneroOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogenero.getTipoGeneroOriginal().getcodigo()!=null)
				{
					strValorActual=tipogenero.getTipoGeneroOriginal().getcodigo();
				}
				if(tipogenero.getcodigo()!=null)
				{
					strValorNuevo=tipogenero.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGeneroConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipogenero.getIsNew()||!tipogenero.getnombre().equals(tipogenero.getTipoGeneroOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogenero.getTipoGeneroOriginal().getnombre()!=null)
				{
					strValorActual=tipogenero.getTipoGeneroOriginal().getnombre();
				}
				if(tipogenero.getnombre()!=null)
				{
					strValorNuevo=tipogenero.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGeneroConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGenero(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGeneroConstantesFunciones.getClassesForeignKeysOfTipoGenero(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGenero(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGeneroConstantesFunciones.getClassesRelationshipsOfTipoGenero(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
