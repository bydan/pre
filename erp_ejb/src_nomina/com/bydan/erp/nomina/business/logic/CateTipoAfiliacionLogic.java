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
import com.bydan.erp.nomina.util.CateTipoAfiliacionConstantesFunciones;
import com.bydan.erp.nomina.util.CateTipoAfiliacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CateTipoAfiliacionParameterGeneral;
import com.bydan.erp.nomina.business.entity.CateTipoAfiliacion;
import com.bydan.erp.nomina.business.logic.CateTipoAfiliacionLogicAdditional;
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
public class CateTipoAfiliacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CateTipoAfiliacionLogic.class);
	
	protected CateTipoAfiliacionDataAccess catetipoafiliacionDataAccess; 	
	protected CateTipoAfiliacion catetipoafiliacion;
	protected List<CateTipoAfiliacion> catetipoafiliacions;
	protected Object catetipoafiliacionObject;	
	protected List<Object> catetipoafiliacionsObject;
	
	public static ClassValidator<CateTipoAfiliacion> catetipoafiliacionValidator = new ClassValidator<CateTipoAfiliacion>(CateTipoAfiliacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CateTipoAfiliacionLogicAdditional catetipoafiliacionLogicAdditional=null;
	
	public CateTipoAfiliacionLogicAdditional getCateTipoAfiliacionLogicAdditional() {
		return this.catetipoafiliacionLogicAdditional;
	}
	
	public void setCateTipoAfiliacionLogicAdditional(CateTipoAfiliacionLogicAdditional catetipoafiliacionLogicAdditional) {
		try {
			this.catetipoafiliacionLogicAdditional=catetipoafiliacionLogicAdditional;
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
	
	
	
	
	public  CateTipoAfiliacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.catetipoafiliacionDataAccess = new CateTipoAfiliacionDataAccess();
			
			this.catetipoafiliacions= new ArrayList<CateTipoAfiliacion>();
			this.catetipoafiliacion= new CateTipoAfiliacion();
			
			this.catetipoafiliacionObject=new Object();
			this.catetipoafiliacionsObject=new ArrayList<Object>();
				
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
			
			this.catetipoafiliacionDataAccess.setConnexionType(this.connexionType);
			this.catetipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CateTipoAfiliacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.catetipoafiliacionDataAccess = new CateTipoAfiliacionDataAccess();
			this.catetipoafiliacions= new ArrayList<CateTipoAfiliacion>();
			this.catetipoafiliacion= new CateTipoAfiliacion();
			this.catetipoafiliacionObject=new Object();
			this.catetipoafiliacionsObject=new ArrayList<Object>();
			
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
			
			this.catetipoafiliacionDataAccess.setConnexionType(this.connexionType);
			this.catetipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CateTipoAfiliacion getCateTipoAfiliacion() throws Exception {	
		CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToGet(catetipoafiliacion,this.datosCliente,this.arrDatoGeneral);
		CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToGet(catetipoafiliacion,this.arrDatoGeneral);
		
		return catetipoafiliacion;
	}
		
	public void setCateTipoAfiliacion(CateTipoAfiliacion newCateTipoAfiliacion) {
		this.catetipoafiliacion = newCateTipoAfiliacion;
	}
	
	public CateTipoAfiliacionDataAccess getCateTipoAfiliacionDataAccess() {
		return catetipoafiliacionDataAccess;
	}
	
	public void setCateTipoAfiliacionDataAccess(CateTipoAfiliacionDataAccess newcatetipoafiliacionDataAccess) {
		this.catetipoafiliacionDataAccess = newcatetipoafiliacionDataAccess;
	}
	
	public List<CateTipoAfiliacion> getCateTipoAfiliacions() throws Exception {		
		this.quitarCateTipoAfiliacionsNulos();
		
		CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToGets(catetipoafiliacions,this.datosCliente,this.arrDatoGeneral);
		
		for (CateTipoAfiliacion catetipoafiliacionLocal: catetipoafiliacions ) {
			CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToGet(catetipoafiliacionLocal,this.arrDatoGeneral);
		}
		
		return catetipoafiliacions;
	}
	
	public void setCateTipoAfiliacions(List<CateTipoAfiliacion> newCateTipoAfiliacions) {
		this.catetipoafiliacions = newCateTipoAfiliacions;
	}
	
	public Object getCateTipoAfiliacionObject() {	
		this.catetipoafiliacionObject=this.catetipoafiliacionDataAccess.getEntityObject();
		return this.catetipoafiliacionObject;
	}
		
	public void setCateTipoAfiliacionObject(Object newCateTipoAfiliacionObject) {
		this.catetipoafiliacionObject = newCateTipoAfiliacionObject;
	}
	
	public List<Object> getCateTipoAfiliacionsObject() {		
		this.catetipoafiliacionsObject=this.catetipoafiliacionDataAccess.getEntitiesObject();
		return this.catetipoafiliacionsObject;
	}
		
	public void setCateTipoAfiliacionsObject(List<Object> newCateTipoAfiliacionsObject) {
		this.catetipoafiliacionsObject = newCateTipoAfiliacionsObject;
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
		
		if(this.catetipoafiliacionDataAccess!=null) {
			this.catetipoafiliacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			catetipoafiliacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			catetipoafiliacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		catetipoafiliacion = new  CateTipoAfiliacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.catetipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		  		  
        try {
			
			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.catetipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		catetipoafiliacion = new  CateTipoAfiliacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.catetipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		  		  
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		  		  
        try {
			
			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.catetipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		catetipoafiliacion = new  CateTipoAfiliacion();
		  		  
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =catetipoafiliacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=catetipoafiliacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		catetipoafiliacion = new  CateTipoAfiliacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =catetipoafiliacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=catetipoafiliacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		catetipoafiliacion = new  CateTipoAfiliacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =catetipoafiliacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=catetipoafiliacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
        try {			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
        try {
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		catetipoafiliacion = new  CateTipoAfiliacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
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
		catetipoafiliacion = new  CateTipoAfiliacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
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
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		  		  
        try {
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCateTipoAfiliacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-getTodosCateTipoAfiliacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
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
	
	public  void  getTodosCateTipoAfiliacions(String sFinalQuery,Pagination pagination)throws Exception {
		catetipoafiliacions = new  ArrayList<CateTipoAfiliacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			catetipoafiliacions=catetipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCateTipoAfiliacion(catetipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion) throws Exception {
		Boolean estaValidado=false;
		
		if(catetipoafiliacion.getIsNew() || catetipoafiliacion.getIsChanged()) { 
			this.invalidValues = catetipoafiliacionValidator.getInvalidValues(catetipoafiliacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(catetipoafiliacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCateTipoAfiliacion(List<CateTipoAfiliacion> CateTipoAfiliacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CateTipoAfiliacion catetipoafiliacionLocal:catetipoafiliacions) {				
			estaValidadoObjeto=this.validarGuardarCateTipoAfiliacion(catetipoafiliacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCateTipoAfiliacion(List<CateTipoAfiliacion> CateTipoAfiliacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCateTipoAfiliacion(catetipoafiliacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCateTipoAfiliacion(CateTipoAfiliacion CateTipoAfiliacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCateTipoAfiliacion(catetipoafiliacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CateTipoAfiliacion catetipoafiliacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+catetipoafiliacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"catetipoafiliacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CateTipoAfiliacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CateTipoAfiliacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCateTipoAfiliacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-saveCateTipoAfiliacionWithConnection");connexion.begin();			
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSave(this.catetipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToSave(this.catetipoafiliacion,this.arrDatoGeneral);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.catetipoafiliacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCateTipoAfiliacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCateTipoAfiliacion(this.catetipoafiliacion)) {
				CateTipoAfiliacionDataAccess.save(this.catetipoafiliacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.catetipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSaveAfter(this.catetipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCateTipoAfiliacion();
			
			connexion.commit();			
			
			if(this.catetipoafiliacion.getIsDeleted()) {
				this.catetipoafiliacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCateTipoAfiliacion()throws Exception {	
		try {	
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSave(this.catetipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToSave(this.catetipoafiliacion,this.arrDatoGeneral);
			
			CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.catetipoafiliacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCateTipoAfiliacion(this.catetipoafiliacion)) {			
				CateTipoAfiliacionDataAccess.save(this.catetipoafiliacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.catetipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSaveAfter(this.catetipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.catetipoafiliacion.getIsDeleted()) {
				this.catetipoafiliacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCateTipoAfiliacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-saveCateTipoAfiliacionsWithConnection");connexion.begin();			
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSaves(catetipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCateTipoAfiliacions();
			
			Boolean validadoTodosCateTipoAfiliacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CateTipoAfiliacion catetipoafiliacionLocal:catetipoafiliacions) {		
				if(catetipoafiliacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToSave(catetipoafiliacionLocal,this.arrDatoGeneral);
	        	
				CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),catetipoafiliacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCateTipoAfiliacion(catetipoafiliacionLocal)) {
					CateTipoAfiliacionDataAccess.save(catetipoafiliacionLocal, connexion);				
				} else {
					validadoTodosCateTipoAfiliacion=false;
				}
			}
			
			if(!validadoTodosCateTipoAfiliacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSavesAfter(catetipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCateTipoAfiliacions();
			
			connexion.commit();		
			
			this.quitarCateTipoAfiliacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCateTipoAfiliacions()throws Exception {				
		 try {	
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSaves(catetipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCateTipoAfiliacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CateTipoAfiliacion catetipoafiliacionLocal:catetipoafiliacions) {				
				if(catetipoafiliacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToSave(catetipoafiliacionLocal,this.arrDatoGeneral);
	        	
				CateTipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),catetipoafiliacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCateTipoAfiliacion(catetipoafiliacionLocal)) {				
					CateTipoAfiliacionDataAccess.save(catetipoafiliacionLocal, connexion);				
				} else {
					validadoTodosCateTipoAfiliacion=false;
				}
			}
			
			if(!validadoTodosCateTipoAfiliacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CateTipoAfiliacionLogicAdditional.checkCateTipoAfiliacionToSavesAfter(catetipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCateTipoAfiliacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CateTipoAfiliacionParameterReturnGeneral procesarAccionCateTipoAfiliacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CateTipoAfiliacion> catetipoafiliacions,CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionParameterGeneral)throws Exception {
		 try {	
			CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionReturnGeneral=new CateTipoAfiliacionParameterReturnGeneral();
	
			CateTipoAfiliacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,catetipoafiliacions,catetipoafiliacionParameterGeneral,catetipoafiliacionReturnGeneral);
			
			return catetipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CateTipoAfiliacionParameterReturnGeneral procesarAccionCateTipoAfiliacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CateTipoAfiliacion> catetipoafiliacions,CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-procesarAccionCateTipoAfiliacionsWithConnection");connexion.begin();			
			
			CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionReturnGeneral=new CateTipoAfiliacionParameterReturnGeneral();
	
			CateTipoAfiliacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,catetipoafiliacions,catetipoafiliacionParameterGeneral,catetipoafiliacionReturnGeneral);
			
			this.connexion.commit();
			
			return catetipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CateTipoAfiliacionParameterReturnGeneral procesarEventosCateTipoAfiliacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CateTipoAfiliacion> catetipoafiliacions,CateTipoAfiliacion catetipoafiliacion,CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionParameterGeneral,Boolean isEsNuevoCateTipoAfiliacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionReturnGeneral=new CateTipoAfiliacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				catetipoafiliacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CateTipoAfiliacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,catetipoafiliacions,catetipoafiliacion,catetipoafiliacionParameterGeneral,catetipoafiliacionReturnGeneral,isEsNuevoCateTipoAfiliacion,clases);
			
			return catetipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CateTipoAfiliacionParameterReturnGeneral procesarEventosCateTipoAfiliacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CateTipoAfiliacion> catetipoafiliacions,CateTipoAfiliacion catetipoafiliacion,CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionParameterGeneral,Boolean isEsNuevoCateTipoAfiliacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-procesarEventosCateTipoAfiliacionsWithConnection");connexion.begin();			
			
			CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionReturnGeneral=new CateTipoAfiliacionParameterReturnGeneral();
	
			catetipoafiliacionReturnGeneral.setCateTipoAfiliacion(catetipoafiliacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				catetipoafiliacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CateTipoAfiliacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,catetipoafiliacions,catetipoafiliacion,catetipoafiliacionParameterGeneral,catetipoafiliacionReturnGeneral,isEsNuevoCateTipoAfiliacion,clases);
			
			this.connexion.commit();
			
			return catetipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CateTipoAfiliacionParameterReturnGeneral procesarImportacionCateTipoAfiliacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-procesarImportacionCateTipoAfiliacionsWithConnection");connexion.begin();			
			
			CateTipoAfiliacionParameterReturnGeneral catetipoafiliacionReturnGeneral=new CateTipoAfiliacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.catetipoafiliacions=new ArrayList<CateTipoAfiliacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.catetipoafiliacion=new CateTipoAfiliacion();
				
				
				if(conColumnasBase) {this.catetipoafiliacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.catetipoafiliacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.catetipoafiliacion.setcodigo(arrColumnas[iColumn++]);
				this.catetipoafiliacion.setnombre(arrColumnas[iColumn++]);
				this.catetipoafiliacion.setes_defecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.catetipoafiliacions.add(this.catetipoafiliacion);
			}
			
			this.saveCateTipoAfiliacions();
			
			this.connexion.commit();
			
			catetipoafiliacionReturnGeneral.setConRetornoEstaProcesado(true);
			catetipoafiliacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return catetipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCateTipoAfiliacionsEliminados() throws Exception {				
		
		List<CateTipoAfiliacion> catetipoafiliacionsAux= new ArrayList<CateTipoAfiliacion>();
		
		for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions) {
			if(!catetipoafiliacion.getIsDeleted()) {
				catetipoafiliacionsAux.add(catetipoafiliacion);
			}
		}
		
		catetipoafiliacions=catetipoafiliacionsAux;
	}
	
	public void quitarCateTipoAfiliacionsNulos() throws Exception {				
		
		List<CateTipoAfiliacion> catetipoafiliacionsAux= new ArrayList<CateTipoAfiliacion>();
		
		for(CateTipoAfiliacion catetipoafiliacion : this.catetipoafiliacions) {
			if(catetipoafiliacion==null) {
				catetipoafiliacionsAux.add(catetipoafiliacion);
			}
		}
		
		//this.catetipoafiliacions=catetipoafiliacionsAux;
		
		this.catetipoafiliacions.removeAll(catetipoafiliacionsAux);
	}
	
	public void getSetVersionRowCateTipoAfiliacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(catetipoafiliacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((catetipoafiliacion.getIsDeleted() || (catetipoafiliacion.getIsChanged()&&!catetipoafiliacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=catetipoafiliacionDataAccess.getSetVersionRowCateTipoAfiliacion(connexion,catetipoafiliacion.getId());
				
				if(!catetipoafiliacion.getVersionRow().equals(timestamp)) {	
					catetipoafiliacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				catetipoafiliacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCateTipoAfiliacion()throws Exception {	
		
		if(catetipoafiliacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((catetipoafiliacion.getIsDeleted() || (catetipoafiliacion.getIsChanged()&&!catetipoafiliacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=catetipoafiliacionDataAccess.getSetVersionRowCateTipoAfiliacion(connexion,catetipoafiliacion.getId());
			
			try {							
				if(!catetipoafiliacion.getVersionRow().equals(timestamp)) {	
					catetipoafiliacion.setVersionRow(timestamp);
				}
				
				catetipoafiliacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCateTipoAfiliacionsWithConnection()throws Exception {	
		if(catetipoafiliacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CateTipoAfiliacion catetipoafiliacionAux:catetipoafiliacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(catetipoafiliacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(catetipoafiliacionAux.getIsDeleted() || (catetipoafiliacionAux.getIsChanged()&&!catetipoafiliacionAux.getIsNew())) {
						
						timestamp=catetipoafiliacionDataAccess.getSetVersionRowCateTipoAfiliacion(connexion,catetipoafiliacionAux.getId());
						
						if(!catetipoafiliacion.getVersionRow().equals(timestamp)) {	
							catetipoafiliacionAux.setVersionRow(timestamp);
						}
								
						catetipoafiliacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCateTipoAfiliacions()throws Exception {	
		if(catetipoafiliacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CateTipoAfiliacion catetipoafiliacionAux:catetipoafiliacions) {
					if(catetipoafiliacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(catetipoafiliacionAux.getIsDeleted() || (catetipoafiliacionAux.getIsChanged()&&!catetipoafiliacionAux.getIsNew())) {
						
						timestamp=catetipoafiliacionDataAccess.getSetVersionRowCateTipoAfiliacion(connexion,catetipoafiliacionAux.getId());
						
						if(!catetipoafiliacionAux.getVersionRow().equals(timestamp)) {	
							catetipoafiliacionAux.setVersionRow(timestamp);
						}
						
													
						catetipoafiliacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyCateTipoAfiliacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			TipoAfiliacionLogic tipoafiliacionLogic=new TipoAfiliacionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CateTipoAfiliacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCateTipoAfiliacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(TipoAfiliacion.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			tipoafiliacionLogic.setConnexion(this.getConnexion());
			tipoafiliacionLogic.setDatosCliente(this.datosCliente);
			tipoafiliacionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CateTipoAfiliacion catetipoafiliacion:this.catetipoafiliacions) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(catetipoafiliacion.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TipoAfiliacionConstantesFunciones.getClassesForeignKeysOfTipoAfiliacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				tipoafiliacionLogic.setTipoAfiliacions(catetipoafiliacion.tipoafiliacions);
				tipoafiliacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CateTipoAfiliacion catetipoafiliacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToGet(catetipoafiliacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		catetipoafiliacion.setClientes(catetipoafiliacionDataAccess.getClientes(connexion,catetipoafiliacion));
		catetipoafiliacion.setTipoAfiliacions(catetipoafiliacionDataAccess.getTipoAfiliacions(connexion,catetipoafiliacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				catetipoafiliacion.setClientes(catetipoafiliacionDataAccess.getClientes(connexion,catetipoafiliacion));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(catetipoafiliacion.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					catetipoafiliacion.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(TipoAfiliacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				catetipoafiliacion.setTipoAfiliacions(catetipoafiliacionDataAccess.getTipoAfiliacions(connexion,catetipoafiliacion));

				if(this.isConDeep) {
					TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(this.connexion);
					tipoafiliacionLogic.setTipoAfiliacions(catetipoafiliacion.getTipoAfiliacions());
					ArrayList<Classe> classesLocal=TipoAfiliacionConstantesFunciones.getClassesForeignKeysOfTipoAfiliacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					tipoafiliacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(tipoafiliacionLogic.getTipoAfiliacions());
					catetipoafiliacion.setTipoAfiliacions(tipoafiliacionLogic.getTipoAfiliacions());
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
			catetipoafiliacion.setClientes(catetipoafiliacionDataAccess.getClientes(connexion,catetipoafiliacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAfiliacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoAfiliacion.class));
			catetipoafiliacion.setTipoAfiliacions(catetipoafiliacionDataAccess.getTipoAfiliacions(connexion,catetipoafiliacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		catetipoafiliacion.setClientes(catetipoafiliacionDataAccess.getClientes(connexion,catetipoafiliacion));

		for(Cliente cliente:catetipoafiliacion.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		catetipoafiliacion.setTipoAfiliacions(catetipoafiliacionDataAccess.getTipoAfiliacions(connexion,catetipoafiliacion));

		for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
			TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
			tipoafiliacionLogic.deepLoad(tipoafiliacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				catetipoafiliacion.setClientes(catetipoafiliacionDataAccess.getClientes(connexion,catetipoafiliacion));

				for(Cliente cliente:catetipoafiliacion.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoAfiliacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				catetipoafiliacion.setTipoAfiliacions(catetipoafiliacionDataAccess.getTipoAfiliacions(connexion,catetipoafiliacion));

				for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
					TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
					tipoafiliacionLogic.deepLoad(tipoafiliacion,isDeep,deepLoadType,clases);
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
			catetipoafiliacion.setClientes(catetipoafiliacionDataAccess.getClientes(connexion,catetipoafiliacion));

			for(Cliente cliente:catetipoafiliacion.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAfiliacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoAfiliacion.class));
			catetipoafiliacion.setTipoAfiliacions(catetipoafiliacionDataAccess.getTipoAfiliacions(connexion,catetipoafiliacion));

			for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
				TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
				tipoafiliacionLogic.deepLoad(tipoafiliacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CateTipoAfiliacion catetipoafiliacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CateTipoAfiliacionLogicAdditional.updateCateTipoAfiliacionToSave(catetipoafiliacion,this.arrDatoGeneral);
			
CateTipoAfiliacionDataAccess.save(catetipoafiliacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:catetipoafiliacion.getClientes()) {
			cliente.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
			tipoafiliacion.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
			TipoAfiliacionDataAccess.save(tipoafiliacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:catetipoafiliacion.getClientes()) {
					cliente.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TipoAfiliacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
					tipoafiliacion.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
					TipoAfiliacionDataAccess.save(tipoafiliacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:catetipoafiliacion.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
			TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
			tipoafiliacion.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
			TipoAfiliacionDataAccess.save(tipoafiliacion,connexion);
			tipoafiliacionLogic.deepSave(tipoafiliacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:catetipoafiliacion.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoAfiliacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoAfiliacion tipoafiliacion:catetipoafiliacion.getTipoAfiliacions()) {
					TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
					tipoafiliacion.setid_cate_tipo_afiliacion(catetipoafiliacion.getId());
					TipoAfiliacionDataAccess.save(tipoafiliacion,connexion);
					tipoafiliacionLogic.deepSave(tipoafiliacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CateTipoAfiliacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(catetipoafiliacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(catetipoafiliacion);
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
			this.deepLoad(this.catetipoafiliacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(this.catetipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CateTipoAfiliacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(catetipoafiliacions!=null) {
				for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions) {
					this.deepLoad(catetipoafiliacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(catetipoafiliacions);
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
			if(catetipoafiliacions!=null) {
				for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions) {
					this.deepLoad(catetipoafiliacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CateTipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesCateTipoAfiliacion(catetipoafiliacions);
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
			this.getNewConnexionToDeep(CateTipoAfiliacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(catetipoafiliacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CateTipoAfiliacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(catetipoafiliacions!=null) {
				for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions) {
					this.deepSave(catetipoafiliacion,isDeep,deepLoadType,clases);
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
			if(catetipoafiliacions!=null) {
				for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions) {
					this.deepSave(catetipoafiliacion,isDeep,deepLoadType,clases);
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
			if(CateTipoAfiliacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CateTipoAfiliacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CateTipoAfiliacion catetipoafiliacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CateTipoAfiliacionConstantesFunciones.ISCONAUDITORIA) {
				if(catetipoafiliacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CateTipoAfiliacionDataAccess.TABLENAME, catetipoafiliacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CateTipoAfiliacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CateTipoAfiliacionLogic.registrarAuditoriaDetallesCateTipoAfiliacion(connexion,catetipoafiliacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(catetipoafiliacion.getIsDeleted()) {
					/*if(!catetipoafiliacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CateTipoAfiliacionDataAccess.TABLENAME, catetipoafiliacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CateTipoAfiliacionLogic.registrarAuditoriaDetallesCateTipoAfiliacion(connexion,catetipoafiliacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CateTipoAfiliacionDataAccess.TABLENAME, catetipoafiliacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(catetipoafiliacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CateTipoAfiliacionDataAccess.TABLENAME, catetipoafiliacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CateTipoAfiliacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CateTipoAfiliacionLogic.registrarAuditoriaDetallesCateTipoAfiliacion(connexion,catetipoafiliacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCateTipoAfiliacion(Connexion connexion,CateTipoAfiliacion catetipoafiliacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(catetipoafiliacion.getIsNew()||!catetipoafiliacion.getcodigo().equals(catetipoafiliacion.getCateTipoAfiliacionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(catetipoafiliacion.getCateTipoAfiliacionOriginal().getcodigo()!=null)
				{
					strValorActual=catetipoafiliacion.getCateTipoAfiliacionOriginal().getcodigo();
				}
				if(catetipoafiliacion.getcodigo()!=null)
				{
					strValorNuevo=catetipoafiliacion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CateTipoAfiliacionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(catetipoafiliacion.getIsNew()||!catetipoafiliacion.getnombre().equals(catetipoafiliacion.getCateTipoAfiliacionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(catetipoafiliacion.getCateTipoAfiliacionOriginal().getnombre()!=null)
				{
					strValorActual=catetipoafiliacion.getCateTipoAfiliacionOriginal().getnombre();
				}
				if(catetipoafiliacion.getnombre()!=null)
				{
					strValorNuevo=catetipoafiliacion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CateTipoAfiliacionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(catetipoafiliacion.getIsNew()||!catetipoafiliacion.getes_defecto().equals(catetipoafiliacion.getCateTipoAfiliacionOriginal().getes_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(catetipoafiliacion.getCateTipoAfiliacionOriginal().getes_defecto()!=null)
				{
					strValorActual=catetipoafiliacion.getCateTipoAfiliacionOriginal().getes_defecto().toString();
				}
				if(catetipoafiliacion.getes_defecto()!=null)
				{
					strValorNuevo=catetipoafiliacion.getes_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CateTipoAfiliacionConstantesFunciones.ESDEFECTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCateTipoAfiliacionRelacionesWithConnection(CateTipoAfiliacion catetipoafiliacion,List<Cliente> clientes,List<TipoAfiliacion> tipoafiliacions) throws Exception {

		if(!catetipoafiliacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCateTipoAfiliacionRelacionesBase(catetipoafiliacion,clientes,tipoafiliacions,true);
		}
	}

	public void saveCateTipoAfiliacionRelaciones(CateTipoAfiliacion catetipoafiliacion,List<Cliente> clientes,List<TipoAfiliacion> tipoafiliacions)throws Exception {

		if(!catetipoafiliacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCateTipoAfiliacionRelacionesBase(catetipoafiliacion,clientes,tipoafiliacions,false);
		}
	}

	public void saveCateTipoAfiliacionRelacionesBase(CateTipoAfiliacion catetipoafiliacion,List<Cliente> clientes,List<TipoAfiliacion> tipoafiliacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CateTipoAfiliacion-saveRelacionesWithConnection");}
	
			catetipoafiliacion.setClientes(clientes);
			catetipoafiliacion.setTipoAfiliacions(tipoafiliacions);

			this.setCateTipoAfiliacion(catetipoafiliacion);

				if((catetipoafiliacion.getIsNew()||catetipoafiliacion.getIsChanged())&&!catetipoafiliacion.getIsDeleted()) {
					this.saveCateTipoAfiliacion();
					this.saveCateTipoAfiliacionRelacionesDetalles(clientes,tipoafiliacions);

				} else if(catetipoafiliacion.getIsDeleted()) {
					this.saveCateTipoAfiliacionRelacionesDetalles(clientes,tipoafiliacions);
					this.saveCateTipoAfiliacion();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			TipoAfiliacionConstantesFunciones.InicializarGeneralEntityAuxiliaresTipoAfiliacions(tipoafiliacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCateTipoAfiliacionRelacionesDetalles(List<Cliente> clientes,List<TipoAfiliacion> tipoafiliacions)throws Exception {
		try {
	

			Long idCateTipoAfiliacionActual=this.getCateTipoAfiliacion().getId();

			ClienteLogic clienteLogic_Desde_CateTipoAfiliacion=new ClienteLogic();
			clienteLogic_Desde_CateTipoAfiliacion.setClientes(clientes);

			clienteLogic_Desde_CateTipoAfiliacion.setConnexion(this.getConnexion());
			clienteLogic_Desde_CateTipoAfiliacion.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_CateTipoAfiliacion:clienteLogic_Desde_CateTipoAfiliacion.getClientes()) {
				cliente_Desde_CateTipoAfiliacion.setid_cate_tipo_afiliacion(idCateTipoAfiliacionActual);

				clienteLogic_Desde_CateTipoAfiliacion.setCliente(cliente_Desde_CateTipoAfiliacion);
				clienteLogic_Desde_CateTipoAfiliacion.saveCliente();
			}


			TipoAfiliacionLogic tipoafiliacionLogic_Desde_CateTipoAfiliacion=new TipoAfiliacionLogic();
			tipoafiliacionLogic_Desde_CateTipoAfiliacion.setTipoAfiliacions(tipoafiliacions);

			tipoafiliacionLogic_Desde_CateTipoAfiliacion.setConnexion(this.getConnexion());
			tipoafiliacionLogic_Desde_CateTipoAfiliacion.setDatosCliente(this.datosCliente);

			for(TipoAfiliacion tipoafiliacion_Desde_CateTipoAfiliacion:tipoafiliacionLogic_Desde_CateTipoAfiliacion.getTipoAfiliacions()) {
				tipoafiliacion_Desde_CateTipoAfiliacion.setid_cate_tipo_afiliacion(idCateTipoAfiliacionActual);

				tipoafiliacionLogic_Desde_CateTipoAfiliacion.setTipoAfiliacion(tipoafiliacion_Desde_CateTipoAfiliacion);
				tipoafiliacionLogic_Desde_CateTipoAfiliacion.saveTipoAfiliacion();

				Long idTipoAfiliacionActual=tipoafiliacion_Desde_CateTipoAfiliacion.getId();

				DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_TipoAfiliacion=new DatoGeneralEmpleadoLogic();

				if(tipoafiliacion_Desde_CateTipoAfiliacion.getDatoGeneralEmpleados()==null){
					tipoafiliacion_Desde_CateTipoAfiliacion.setDatoGeneralEmpleados(new ArrayList<DatoGeneralEmpleado>());
				}

				datogeneralempleadoLogic_Desde_TipoAfiliacion.setDatoGeneralEmpleados(tipoafiliacion_Desde_CateTipoAfiliacion.getDatoGeneralEmpleados());

				datogeneralempleadoLogic_Desde_TipoAfiliacion.setConnexion(this.getConnexion());
				datogeneralempleadoLogic_Desde_TipoAfiliacion.setDatosCliente(this.datosCliente);

				for(DatoGeneralEmpleado datogeneralempleado_Desde_TipoAfiliacion:datogeneralempleadoLogic_Desde_TipoAfiliacion.getDatoGeneralEmpleados()) {
					datogeneralempleado_Desde_TipoAfiliacion.setid_tipo_afiliacion(idTipoAfiliacionActual);
				}

				datogeneralempleadoLogic_Desde_TipoAfiliacion.saveDatoGeneralEmpleados();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCateTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CateTipoAfiliacionConstantesFunciones.getClassesForeignKeysOfCateTipoAfiliacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCateTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CateTipoAfiliacionConstantesFunciones.getClassesRelationshipsOfCateTipoAfiliacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
