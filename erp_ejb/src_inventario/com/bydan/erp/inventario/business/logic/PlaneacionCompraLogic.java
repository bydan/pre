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
import com.bydan.erp.inventario.util.PlaneacionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.PlaneacionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PlaneacionCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.PlaneacionCompra;
import com.bydan.erp.inventario.business.logic.PlaneacionCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class PlaneacionCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PlaneacionCompraLogic.class);
	
	protected PlaneacionCompraDataAccess planeacioncompraDataAccess; 	
	protected PlaneacionCompra planeacioncompra;
	protected List<PlaneacionCompra> planeacioncompras;
	protected Object planeacioncompraObject;	
	protected List<Object> planeacioncomprasObject;
	
	public static ClassValidator<PlaneacionCompra> planeacioncompraValidator = new ClassValidator<PlaneacionCompra>(PlaneacionCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PlaneacionCompraLogicAdditional planeacioncompraLogicAdditional=null;
	
	public PlaneacionCompraLogicAdditional getPlaneacionCompraLogicAdditional() {
		return this.planeacioncompraLogicAdditional;
	}
	
	public void setPlaneacionCompraLogicAdditional(PlaneacionCompraLogicAdditional planeacioncompraLogicAdditional) {
		try {
			this.planeacioncompraLogicAdditional=planeacioncompraLogicAdditional;
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
	
	
	
	
	public  PlaneacionCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.planeacioncompraDataAccess = new PlaneacionCompraDataAccess();
			
			this.planeacioncompras= new ArrayList<PlaneacionCompra>();
			this.planeacioncompra= new PlaneacionCompra();
			
			this.planeacioncompraObject=new Object();
			this.planeacioncomprasObject=new ArrayList<Object>();
				
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
			
			this.planeacioncompraDataAccess.setConnexionType(this.connexionType);
			this.planeacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PlaneacionCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.planeacioncompraDataAccess = new PlaneacionCompraDataAccess();
			this.planeacioncompras= new ArrayList<PlaneacionCompra>();
			this.planeacioncompra= new PlaneacionCompra();
			this.planeacioncompraObject=new Object();
			this.planeacioncomprasObject=new ArrayList<Object>();
			
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
			
			this.planeacioncompraDataAccess.setConnexionType(this.connexionType);
			this.planeacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PlaneacionCompra getPlaneacionCompra() throws Exception {	
		PlaneacionCompraLogicAdditional.checkPlaneacionCompraToGet(planeacioncompra,this.datosCliente,this.arrDatoGeneral);
		PlaneacionCompraLogicAdditional.updatePlaneacionCompraToGet(planeacioncompra,this.arrDatoGeneral);
		
		return planeacioncompra;
	}
		
	public void setPlaneacionCompra(PlaneacionCompra newPlaneacionCompra) {
		this.planeacioncompra = newPlaneacionCompra;
	}
	
	public PlaneacionCompraDataAccess getPlaneacionCompraDataAccess() {
		return planeacioncompraDataAccess;
	}
	
	public void setPlaneacionCompraDataAccess(PlaneacionCompraDataAccess newplaneacioncompraDataAccess) {
		this.planeacioncompraDataAccess = newplaneacioncompraDataAccess;
	}
	
	public List<PlaneacionCompra> getPlaneacionCompras() throws Exception {		
		this.quitarPlaneacionComprasNulos();
		
		PlaneacionCompraLogicAdditional.checkPlaneacionCompraToGets(planeacioncompras,this.datosCliente,this.arrDatoGeneral);
		
		for (PlaneacionCompra planeacioncompraLocal: planeacioncompras ) {
			PlaneacionCompraLogicAdditional.updatePlaneacionCompraToGet(planeacioncompraLocal,this.arrDatoGeneral);
		}
		
		return planeacioncompras;
	}
	
	public void setPlaneacionCompras(List<PlaneacionCompra> newPlaneacionCompras) {
		this.planeacioncompras = newPlaneacionCompras;
	}
	
	public Object getPlaneacionCompraObject() {	
		this.planeacioncompraObject=this.planeacioncompraDataAccess.getEntityObject();
		return this.planeacioncompraObject;
	}
		
	public void setPlaneacionCompraObject(Object newPlaneacionCompraObject) {
		this.planeacioncompraObject = newPlaneacionCompraObject;
	}
	
	public List<Object> getPlaneacionComprasObject() {		
		this.planeacioncomprasObject=this.planeacioncompraDataAccess.getEntitiesObject();
		return this.planeacioncomprasObject;
	}
		
	public void setPlaneacionComprasObject(List<Object> newPlaneacionComprasObject) {
		this.planeacioncomprasObject = newPlaneacionComprasObject;
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
		
		if(this.planeacioncompraDataAccess!=null) {
			this.planeacioncompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			planeacioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			planeacioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		planeacioncompra = new  PlaneacionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planeacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
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
		planeacioncompra = new  PlaneacionCompra();
		  		  
        try {
			
			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planeacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		planeacioncompra = new  PlaneacionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planeacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
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
		planeacioncompra = new  PlaneacionCompra();
		  		  
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
		planeacioncompra = new  PlaneacionCompra();
		  		  
        try {
			
			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planeacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		planeacioncompra = new  PlaneacionCompra();
		  		  
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
		planeacioncompra = new  PlaneacionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =planeacioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		planeacioncompra = new  PlaneacionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=planeacioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		planeacioncompra = new  PlaneacionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =planeacioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		planeacioncompra = new  PlaneacionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=planeacioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		planeacioncompra = new  PlaneacionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =planeacioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		planeacioncompra = new  PlaneacionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=planeacioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
        try {			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
        try {
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		planeacioncompra = new  PlaneacionCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
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
		planeacioncompra = new  PlaneacionCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		  		  
        try {
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPlaneacionComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getTodosPlaneacionComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
	
	public  void  getTodosPlaneacionCompras(String sFinalQuery,Pagination pagination)throws Exception {
		planeacioncompras = new  ArrayList<PlaneacionCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPlaneacionCompra(planeacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPlaneacionCompra(PlaneacionCompra planeacioncompra) throws Exception {
		Boolean estaValidado=false;
		
		if(planeacioncompra.getIsNew() || planeacioncompra.getIsChanged()) { 
			this.invalidValues = planeacioncompraValidator.getInvalidValues(planeacioncompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(planeacioncompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPlaneacionCompra(List<PlaneacionCompra> PlaneacionCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PlaneacionCompra planeacioncompraLocal:planeacioncompras) {				
			estaValidadoObjeto=this.validarGuardarPlaneacionCompra(planeacioncompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPlaneacionCompra(List<PlaneacionCompra> PlaneacionCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPlaneacionCompra(planeacioncompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPlaneacionCompra(PlaneacionCompra PlaneacionCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPlaneacionCompra(planeacioncompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PlaneacionCompra planeacioncompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+planeacioncompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PlaneacionCompraConstantesFunciones.getPlaneacionCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"planeacioncompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PlaneacionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PlaneacionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePlaneacionCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-savePlaneacionCompraWithConnection");connexion.begin();			
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSave(this.planeacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PlaneacionCompraLogicAdditional.updatePlaneacionCompraToSave(this.planeacioncompra,this.arrDatoGeneral);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.planeacioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPlaneacionCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPlaneacionCompra(this.planeacioncompra)) {
				PlaneacionCompraDataAccess.save(this.planeacioncompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.planeacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSaveAfter(this.planeacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPlaneacionCompra();
			
			connexion.commit();			
			
			if(this.planeacioncompra.getIsDeleted()) {
				this.planeacioncompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePlaneacionCompra()throws Exception {	
		try {	
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSave(this.planeacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PlaneacionCompraLogicAdditional.updatePlaneacionCompraToSave(this.planeacioncompra,this.arrDatoGeneral);
			
			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.planeacioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPlaneacionCompra(this.planeacioncompra)) {			
				PlaneacionCompraDataAccess.save(this.planeacioncompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.planeacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSaveAfter(this.planeacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.planeacioncompra.getIsDeleted()) {
				this.planeacioncompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePlaneacionComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-savePlaneacionComprasWithConnection");connexion.begin();			
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSaves(planeacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPlaneacionCompras();
			
			Boolean validadoTodosPlaneacionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PlaneacionCompra planeacioncompraLocal:planeacioncompras) {		
				if(planeacioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PlaneacionCompraLogicAdditional.updatePlaneacionCompraToSave(planeacioncompraLocal,this.arrDatoGeneral);
	        	
				PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),planeacioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPlaneacionCompra(planeacioncompraLocal)) {
					PlaneacionCompraDataAccess.save(planeacioncompraLocal, connexion);				
				} else {
					validadoTodosPlaneacionCompra=false;
				}
			}
			
			if(!validadoTodosPlaneacionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSavesAfter(planeacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPlaneacionCompras();
			
			connexion.commit();		
			
			this.quitarPlaneacionComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePlaneacionCompras()throws Exception {				
		 try {	
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSaves(planeacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPlaneacionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PlaneacionCompra planeacioncompraLocal:planeacioncompras) {				
				if(planeacioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PlaneacionCompraLogicAdditional.updatePlaneacionCompraToSave(planeacioncompraLocal,this.arrDatoGeneral);
	        	
				PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),planeacioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPlaneacionCompra(planeacioncompraLocal)) {				
					PlaneacionCompraDataAccess.save(planeacioncompraLocal, connexion);				
				} else {
					validadoTodosPlaneacionCompra=false;
				}
			}
			
			if(!validadoTodosPlaneacionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PlaneacionCompraLogicAdditional.checkPlaneacionCompraToSavesAfter(planeacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPlaneacionComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlaneacionCompraParameterReturnGeneral procesarAccionPlaneacionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlaneacionCompra> planeacioncompras,PlaneacionCompraParameterReturnGeneral planeacioncompraParameterGeneral)throws Exception {
		 try {	
			PlaneacionCompraParameterReturnGeneral planeacioncompraReturnGeneral=new PlaneacionCompraParameterReturnGeneral();
	
			PlaneacionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,planeacioncompras,planeacioncompraParameterGeneral,planeacioncompraReturnGeneral);
			
			return planeacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlaneacionCompraParameterReturnGeneral procesarAccionPlaneacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlaneacionCompra> planeacioncompras,PlaneacionCompraParameterReturnGeneral planeacioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-procesarAccionPlaneacionComprasWithConnection");connexion.begin();			
			
			PlaneacionCompraParameterReturnGeneral planeacioncompraReturnGeneral=new PlaneacionCompraParameterReturnGeneral();
	
			PlaneacionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,planeacioncompras,planeacioncompraParameterGeneral,planeacioncompraReturnGeneral);
			
			this.connexion.commit();
			
			return planeacioncompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PlaneacionCompraParameterReturnGeneral procesarEventosPlaneacionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PlaneacionCompra> planeacioncompras,PlaneacionCompra planeacioncompra,PlaneacionCompraParameterReturnGeneral planeacioncompraParameterGeneral,Boolean isEsNuevoPlaneacionCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			PlaneacionCompraParameterReturnGeneral planeacioncompraReturnGeneral=new PlaneacionCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				planeacioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PlaneacionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,planeacioncompras,planeacioncompra,planeacioncompraParameterGeneral,planeacioncompraReturnGeneral,isEsNuevoPlaneacionCompra,clases);
			
			return planeacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PlaneacionCompraParameterReturnGeneral procesarEventosPlaneacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PlaneacionCompra> planeacioncompras,PlaneacionCompra planeacioncompra,PlaneacionCompraParameterReturnGeneral planeacioncompraParameterGeneral,Boolean isEsNuevoPlaneacionCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-procesarEventosPlaneacionComprasWithConnection");connexion.begin();			
			
			PlaneacionCompraParameterReturnGeneral planeacioncompraReturnGeneral=new PlaneacionCompraParameterReturnGeneral();
	
			planeacioncompraReturnGeneral.setPlaneacionCompra(planeacioncompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				planeacioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PlaneacionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,planeacioncompras,planeacioncompra,planeacioncompraParameterGeneral,planeacioncompraReturnGeneral,isEsNuevoPlaneacionCompra,clases);
			
			this.connexion.commit();
			
			return planeacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PlaneacionCompraParameterReturnGeneral procesarImportacionPlaneacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PlaneacionCompraParameterReturnGeneral planeacioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-procesarImportacionPlaneacionComprasWithConnection");connexion.begin();			
			
			PlaneacionCompraParameterReturnGeneral planeacioncompraReturnGeneral=new PlaneacionCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.planeacioncompras=new ArrayList<PlaneacionCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.planeacioncompra=new PlaneacionCompra();
				
				
				if(conColumnasBase) {this.planeacioncompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.planeacioncompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.planeacioncompra.setnumero_pre_impreso(arrColumnas[iColumn++]);
				this.planeacioncompra.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.planeacioncompra.setnumero_meses(Integer.parseInt(arrColumnas[iColumn++]));
				this.planeacioncompra.setfecha_corte(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.planeacioncompra.setcodigo_pedido(arrColumnas[iColumn++]);
			this.planeacioncompra.setdescripcion1(arrColumnas[iColumn++]);
			this.planeacioncompra.setdescripcion2(arrColumnas[iColumn++]);
			this.planeacioncompra.setdescripcion3(arrColumnas[iColumn++]);
				
				this.planeacioncompras.add(this.planeacioncompra);
			}
			
			this.savePlaneacionCompras();
			
			this.connexion.commit();
			
			planeacioncompraReturnGeneral.setConRetornoEstaProcesado(true);
			planeacioncompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return planeacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPlaneacionComprasEliminados() throws Exception {				
		
		List<PlaneacionCompra> planeacioncomprasAux= new ArrayList<PlaneacionCompra>();
		
		for(PlaneacionCompra planeacioncompra:planeacioncompras) {
			if(!planeacioncompra.getIsDeleted()) {
				planeacioncomprasAux.add(planeacioncompra);
			}
		}
		
		planeacioncompras=planeacioncomprasAux;
	}
	
	public void quitarPlaneacionComprasNulos() throws Exception {				
		
		List<PlaneacionCompra> planeacioncomprasAux= new ArrayList<PlaneacionCompra>();
		
		for(PlaneacionCompra planeacioncompra : this.planeacioncompras) {
			if(planeacioncompra==null) {
				planeacioncomprasAux.add(planeacioncompra);
			}
		}
		
		//this.planeacioncompras=planeacioncomprasAux;
		
		this.planeacioncompras.removeAll(planeacioncomprasAux);
	}
	
	public void getSetVersionRowPlaneacionCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(planeacioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((planeacioncompra.getIsDeleted() || (planeacioncompra.getIsChanged()&&!planeacioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=planeacioncompraDataAccess.getSetVersionRowPlaneacionCompra(connexion,planeacioncompra.getId());
				
				if(!planeacioncompra.getVersionRow().equals(timestamp)) {	
					planeacioncompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				planeacioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPlaneacionCompra()throws Exception {	
		
		if(planeacioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((planeacioncompra.getIsDeleted() || (planeacioncompra.getIsChanged()&&!planeacioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=planeacioncompraDataAccess.getSetVersionRowPlaneacionCompra(connexion,planeacioncompra.getId());
			
			try {							
				if(!planeacioncompra.getVersionRow().equals(timestamp)) {	
					planeacioncompra.setVersionRow(timestamp);
				}
				
				planeacioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPlaneacionComprasWithConnection()throws Exception {	
		if(planeacioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PlaneacionCompra planeacioncompraAux:planeacioncompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(planeacioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(planeacioncompraAux.getIsDeleted() || (planeacioncompraAux.getIsChanged()&&!planeacioncompraAux.getIsNew())) {
						
						timestamp=planeacioncompraDataAccess.getSetVersionRowPlaneacionCompra(connexion,planeacioncompraAux.getId());
						
						if(!planeacioncompra.getVersionRow().equals(timestamp)) {	
							planeacioncompraAux.setVersionRow(timestamp);
						}
								
						planeacioncompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPlaneacionCompras()throws Exception {	
		if(planeacioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PlaneacionCompra planeacioncompraAux:planeacioncompras) {
					if(planeacioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(planeacioncompraAux.getIsDeleted() || (planeacioncompraAux.getIsChanged()&&!planeacioncompraAux.getIsNew())) {
						
						timestamp=planeacioncompraDataAccess.getSetVersionRowPlaneacionCompra(connexion,planeacioncompraAux.getId());
						
						if(!planeacioncompraAux.getVersionRow().equals(timestamp)) {	
							planeacioncompraAux.setVersionRow(timestamp);
						}
						
													
						planeacioncompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PlaneacionCompraParameterReturnGeneral cargarCombosLoteForeignKeyPlaneacionCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEmpleado,String finalQueryGlobalUsuario,String finalQueryGlobalFormato,String finalQueryGlobalMesInicio,String finalQueryGlobalMesFin) throws Exception {
		PlaneacionCompraParameterReturnGeneral  planeacioncompraReturnGeneral =new PlaneacionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyPlaneacionCompraWithConnection");connexion.begin();
			
			planeacioncompraReturnGeneral =new PlaneacionCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			planeacioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			planeacioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			planeacioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			planeacioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			planeacioncompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			planeacioncompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			planeacioncompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Mes> mesiniciosForeignKey=new ArrayList<Mes>();
			MesLogic mesinicioLogic=new MesLogic();
			mesinicioLogic.setConnexion(this.connexion);
			mesinicioLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesInicio.equals("NONE")) {
				mesinicioLogic.getTodosMess(finalQueryGlobalMesInicio,new Pagination());
				mesiniciosForeignKey=mesinicioLogic.getMess();
			}

			planeacioncompraReturnGeneral.setmesiniciosForeignKey(mesiniciosForeignKey);


			List<Mes> mesfinsForeignKey=new ArrayList<Mes>();
			MesLogic mesfinLogic=new MesLogic();
			mesfinLogic.setConnexion(this.connexion);
			mesfinLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesFin.equals("NONE")) {
				mesfinLogic.getTodosMess(finalQueryGlobalMesFin,new Pagination());
				mesfinsForeignKey=mesfinLogic.getMess();
			}

			planeacioncompraReturnGeneral.setmesfinsForeignKey(mesfinsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return planeacioncompraReturnGeneral;
	}
	
	public PlaneacionCompraParameterReturnGeneral cargarCombosLoteForeignKeyPlaneacionCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEmpleado,String finalQueryGlobalUsuario,String finalQueryGlobalFormato,String finalQueryGlobalMesInicio,String finalQueryGlobalMesFin) throws Exception {
		PlaneacionCompraParameterReturnGeneral  planeacioncompraReturnGeneral =new PlaneacionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			planeacioncompraReturnGeneral =new PlaneacionCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			planeacioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			planeacioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			planeacioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			planeacioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			planeacioncompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			planeacioncompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			planeacioncompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Mes> mesiniciosForeignKey=new ArrayList<Mes>();
			MesLogic mesinicioLogic=new MesLogic();
			mesinicioLogic.setConnexion(this.connexion);
			mesinicioLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesInicio.equals("NONE")) {
				mesinicioLogic.getTodosMess(finalQueryGlobalMesInicio,new Pagination());
				mesiniciosForeignKey=mesinicioLogic.getMess();
			}

			planeacioncompraReturnGeneral.setmesiniciosForeignKey(mesiniciosForeignKey);


			List<Mes> mesfinsForeignKey=new ArrayList<Mes>();
			MesLogic mesfinLogic=new MesLogic();
			mesfinLogic.setConnexion(this.connexion);
			mesfinLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesFin.equals("NONE")) {
				mesfinLogic.getTodosMess(finalQueryGlobalMesFin,new Pagination());
				mesfinsForeignKey=mesfinLogic.getMess();
			}

			planeacioncompraReturnGeneral.setmesfinsForeignKey(mesfinsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return planeacioncompraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPlaneacionCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic=new DetallePlaneacionCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPlaneacionCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetallePlaneacionCompra.class));
											
			

			detalleplaneacioncompraLogic.setConnexion(this.getConnexion());
			detalleplaneacioncompraLogic.setDatosCliente(this.datosCliente);
			detalleplaneacioncompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PlaneacionCompra planeacioncompra:this.planeacioncompras) {
				

				classes=new ArrayList<Classe>();
				classes=DetallePlaneacionCompraConstantesFunciones.getClassesForeignKeysOfDetallePlaneacionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleplaneacioncompraLogic.setDetallePlaneacionCompras(planeacioncompra.detalleplaneacioncompras);
				detalleplaneacioncompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PlaneacionCompra planeacioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PlaneacionCompraLogicAdditional.updatePlaneacionCompraToGet(planeacioncompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		planeacioncompra.setEmpresa(planeacioncompraDataAccess.getEmpresa(connexion,planeacioncompra));
		planeacioncompra.setSucursal(planeacioncompraDataAccess.getSucursal(connexion,planeacioncompra));
		planeacioncompra.setEjercicio(planeacioncompraDataAccess.getEjercicio(connexion,planeacioncompra));
		planeacioncompra.setPeriodo(planeacioncompraDataAccess.getPeriodo(connexion,planeacioncompra));
		planeacioncompra.setEmpleado(planeacioncompraDataAccess.getEmpleado(connexion,planeacioncompra));
		planeacioncompra.setUsuario(planeacioncompraDataAccess.getUsuario(connexion,planeacioncompra));
		planeacioncompra.setFormato(planeacioncompraDataAccess.getFormato(connexion,planeacioncompra));
		planeacioncompra.setMesInicio(planeacioncompraDataAccess.getMesInicio(connexion,planeacioncompra));
		planeacioncompra.setMesFin(planeacioncompraDataAccess.getMesFin(connexion,planeacioncompra));
		planeacioncompra.setDetallePlaneacionCompras(planeacioncompraDataAccess.getDetallePlaneacionCompras(connexion,planeacioncompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				planeacioncompra.setEmpresa(planeacioncompraDataAccess.getEmpresa(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				planeacioncompra.setSucursal(planeacioncompraDataAccess.getSucursal(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				planeacioncompra.setEjercicio(planeacioncompraDataAccess.getEjercicio(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				planeacioncompra.setPeriodo(planeacioncompraDataAccess.getPeriodo(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				planeacioncompra.setEmpleado(planeacioncompraDataAccess.getEmpleado(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				planeacioncompra.setUsuario(planeacioncompraDataAccess.getUsuario(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				planeacioncompra.setFormato(planeacioncompraDataAccess.getFormato(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				planeacioncompra.setMesInicio(planeacioncompraDataAccess.getMesInicio(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				planeacioncompra.setMesFin(planeacioncompraDataAccess.getMesFin(connexion,planeacioncompra));
				continue;
			}

			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				planeacioncompra.setDetallePlaneacionCompras(planeacioncompraDataAccess.getDetallePlaneacionCompras(connexion,planeacioncompra));

				if(this.isConDeep) {
					DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(this.connexion);
					detalleplaneacioncompraLogic.setDetallePlaneacionCompras(planeacioncompra.getDetallePlaneacionCompras());
					ArrayList<Classe> classesLocal=DetallePlaneacionCompraConstantesFunciones.getClassesForeignKeysOfDetallePlaneacionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleplaneacioncompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(detalleplaneacioncompraLogic.getDetallePlaneacionCompras());
					planeacioncompra.setDetallePlaneacionCompras(detalleplaneacioncompraLogic.getDetallePlaneacionCompras());
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
			planeacioncompra.setEmpresa(planeacioncompraDataAccess.getEmpresa(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setSucursal(planeacioncompraDataAccess.getSucursal(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setEjercicio(planeacioncompraDataAccess.getEjercicio(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setPeriodo(planeacioncompraDataAccess.getPeriodo(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setEmpleado(planeacioncompraDataAccess.getEmpleado(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setUsuario(planeacioncompraDataAccess.getUsuario(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setFormato(planeacioncompraDataAccess.getFormato(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setMesInicio(planeacioncompraDataAccess.getMesInicio(connexion,planeacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setMesFin(planeacioncompraDataAccess.getMesFin(connexion,planeacioncompra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePlaneacionCompra.class));
			planeacioncompra.setDetallePlaneacionCompras(planeacioncompraDataAccess.getDetallePlaneacionCompras(connexion,planeacioncompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		planeacioncompra.setEmpresa(planeacioncompraDataAccess.getEmpresa(connexion,planeacioncompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(planeacioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setSucursal(planeacioncompraDataAccess.getSucursal(connexion,planeacioncompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(planeacioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setEjercicio(planeacioncompraDataAccess.getEjercicio(connexion,planeacioncompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(planeacioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setPeriodo(planeacioncompraDataAccess.getPeriodo(connexion,planeacioncompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(planeacioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setEmpleado(planeacioncompraDataAccess.getEmpleado(connexion,planeacioncompra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(planeacioncompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setUsuario(planeacioncompraDataAccess.getUsuario(connexion,planeacioncompra));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(planeacioncompra.getUsuario(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setFormato(planeacioncompraDataAccess.getFormato(connexion,planeacioncompra));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(planeacioncompra.getFormato(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setMesInicio(planeacioncompraDataAccess.getMesInicio(connexion,planeacioncompra));
		MesLogic mesinicioLogic= new MesLogic(connexion);
		mesinicioLogic.deepLoad(planeacioncompra.getMesInicio(),isDeep,deepLoadType,clases);
				
		planeacioncompra.setMesFin(planeacioncompraDataAccess.getMesFin(connexion,planeacioncompra));
		MesLogic mesfinLogic= new MesLogic(connexion);
		mesfinLogic.deepLoad(planeacioncompra.getMesFin(),isDeep,deepLoadType,clases);
				

		planeacioncompra.setDetallePlaneacionCompras(planeacioncompraDataAccess.getDetallePlaneacionCompras(connexion,planeacioncompra));

		for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
			detalleplaneacioncompraLogic.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				planeacioncompra.setEmpresa(planeacioncompraDataAccess.getEmpresa(connexion,planeacioncompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(planeacioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				planeacioncompra.setSucursal(planeacioncompraDataAccess.getSucursal(connexion,planeacioncompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(planeacioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				planeacioncompra.setEjercicio(planeacioncompraDataAccess.getEjercicio(connexion,planeacioncompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(planeacioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				planeacioncompra.setPeriodo(planeacioncompraDataAccess.getPeriodo(connexion,planeacioncompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(planeacioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				planeacioncompra.setEmpleado(planeacioncompraDataAccess.getEmpleado(connexion,planeacioncompra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(planeacioncompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				planeacioncompra.setUsuario(planeacioncompraDataAccess.getUsuario(connexion,planeacioncompra));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(planeacioncompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				planeacioncompra.setFormato(planeacioncompraDataAccess.getFormato(connexion,planeacioncompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(planeacioncompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				planeacioncompra.setMesInicio(planeacioncompraDataAccess.getMesInicio(connexion,planeacioncompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(planeacioncompra.getMesInicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				planeacioncompra.setMesFin(planeacioncompraDataAccess.getMesFin(connexion,planeacioncompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(planeacioncompra.getMesFin(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				planeacioncompra.setDetallePlaneacionCompras(planeacioncompraDataAccess.getDetallePlaneacionCompras(connexion,planeacioncompra));

				for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
					DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
					detalleplaneacioncompraLogic.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
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
			planeacioncompra.setEmpresa(planeacioncompraDataAccess.getEmpresa(connexion,planeacioncompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(planeacioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setSucursal(planeacioncompraDataAccess.getSucursal(connexion,planeacioncompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(planeacioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setEjercicio(planeacioncompraDataAccess.getEjercicio(connexion,planeacioncompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(planeacioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setPeriodo(planeacioncompraDataAccess.getPeriodo(connexion,planeacioncompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(planeacioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setEmpleado(planeacioncompraDataAccess.getEmpleado(connexion,planeacioncompra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(planeacioncompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setUsuario(planeacioncompraDataAccess.getUsuario(connexion,planeacioncompra));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(planeacioncompra.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setFormato(planeacioncompraDataAccess.getFormato(connexion,planeacioncompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(planeacioncompra.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setMesInicio(planeacioncompraDataAccess.getMesInicio(connexion,planeacioncompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(planeacioncompra.getMesInicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacioncompra.setMesFin(planeacioncompraDataAccess.getMesFin(connexion,planeacioncompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(planeacioncompra.getMesFin(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePlaneacionCompra.class));
			planeacioncompra.setDetallePlaneacionCompras(planeacioncompraDataAccess.getDetallePlaneacionCompras(connexion,planeacioncompra));

			for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
				DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
				detalleplaneacioncompraLogic.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PlaneacionCompra planeacioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PlaneacionCompraLogicAdditional.updatePlaneacionCompraToSave(planeacioncompra,this.arrDatoGeneral);
			
PlaneacionCompraDataAccess.save(planeacioncompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(planeacioncompra.getEmpresa(),connexion);

		SucursalDataAccess.save(planeacioncompra.getSucursal(),connexion);

		EjercicioDataAccess.save(planeacioncompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(planeacioncompra.getPeriodo(),connexion);

		EmpleadoDataAccess.save(planeacioncompra.getEmpleado(),connexion);

		UsuarioDataAccess.save(planeacioncompra.getUsuario(),connexion);

		FormatoDataAccess.save(planeacioncompra.getFormato(),connexion);

		MesDataAccess.save(planeacioncompra.getMesInicio(),connexion);

		MesDataAccess.save(planeacioncompra.getMesFin(),connexion);

		for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
			detalleplaneacioncompra.setid_planeacion_compra(planeacioncompra.getId());
			DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(planeacioncompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(planeacioncompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(planeacioncompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(planeacioncompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(planeacioncompra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(planeacioncompra.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(planeacioncompra.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(planeacioncompra.getMesInicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(planeacioncompra.getMesFin(),connexion);
				continue;
			}


			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
					detalleplaneacioncompra.setid_planeacion_compra(planeacioncompra.getId());
					DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(planeacioncompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(planeacioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(planeacioncompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(planeacioncompra.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(planeacioncompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(planeacioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(planeacioncompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(planeacioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(planeacioncompra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(planeacioncompra.getEmpleado(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(planeacioncompra.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(planeacioncompra.getUsuario(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(planeacioncompra.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(planeacioncompra.getFormato(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(planeacioncompra.getMesInicio(),connexion);
		MesLogic mesinicioLogic= new MesLogic(connexion);
		mesinicioLogic.deepLoad(planeacioncompra.getMesInicio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(planeacioncompra.getMesFin(),connexion);
		MesLogic mesfinLogic= new MesLogic(connexion);
		mesfinLogic.deepLoad(planeacioncompra.getMesFin(),isDeep,deepLoadType,clases);
				

		for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
			detalleplaneacioncompra.setid_planeacion_compra(planeacioncompra.getId());
			DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
			detalleplaneacioncompraLogic.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(planeacioncompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(planeacioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(planeacioncompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(planeacioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(planeacioncompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(planeacioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(planeacioncompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(planeacioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(planeacioncompra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(planeacioncompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(planeacioncompra.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(planeacioncompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(planeacioncompra.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(planeacioncompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(planeacioncompra.getMesInicio(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(planeacioncompra.getMesInicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(planeacioncompra.getMesFin(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(planeacioncompra.getMesFin(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetallePlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePlaneacionCompra detalleplaneacioncompra:planeacioncompra.getDetallePlaneacionCompras()) {
					DetallePlaneacionCompraLogic detalleplaneacioncompraLogic= new DetallePlaneacionCompraLogic(connexion);
					detalleplaneacioncompra.setid_planeacion_compra(planeacioncompra.getId());
					DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra,connexion);
					detalleplaneacioncompraLogic.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PlaneacionCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(planeacioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(planeacioncompra);
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
			this.deepLoad(this.planeacioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PlaneacionCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(planeacioncompras!=null) {
				for(PlaneacionCompra planeacioncompra:planeacioncompras) {
					this.deepLoad(planeacioncompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(planeacioncompras);
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
			if(planeacioncompras!=null) {
				for(PlaneacionCompra planeacioncompra:planeacioncompras) {
					this.deepLoad(planeacioncompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(planeacioncompras);
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
			this.getNewConnexionToDeep(PlaneacionCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(planeacioncompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PlaneacionCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(planeacioncompras!=null) {
				for(PlaneacionCompra planeacioncompra:planeacioncompras) {
					this.deepSave(planeacioncompra,isDeep,deepLoadType,clases);
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
			if(planeacioncompras!=null) {
				for(PlaneacionCompra planeacioncompra:planeacioncompras) {
					this.deepSave(planeacioncompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPlaneacionComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PlaneacionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PlaneacionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PlaneacionCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PlaneacionCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlaneacionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlaneacionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PlaneacionCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PlaneacionCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdMesFinWithConnection(String sFinalQuery,Pagination pagination,Long id_mes_fin)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesFin.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_fin,PlaneacionCompraConstantesFunciones.IDMESFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesFin);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdMesFin(String sFinalQuery,Pagination pagination,Long id_mes_fin)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesFin.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_fin,PlaneacionCompraConstantesFunciones.IDMESFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesFin);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdMesInicioWithConnection(String sFinalQuery,Pagination pagination,Long id_mes_inicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesInicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesInicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_inicio,PlaneacionCompraConstantesFunciones.IDMESINICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesInicio);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesInicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdMesInicio(String sFinalQuery,Pagination pagination,Long id_mes_inicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesInicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesInicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_inicio,PlaneacionCompraConstantesFunciones.IDMESINICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesInicio);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesInicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PlaneacionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PlaneacionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PlaneacionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PlaneacionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaneacionComprasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PlaneacionCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaneacionComprasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PlaneacionCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(this.planeacioncompras);
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
			if(PlaneacionCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaneacionCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PlaneacionCompra planeacioncompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PlaneacionCompraConstantesFunciones.ISCONAUDITORIA) {
				if(planeacioncompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaneacionCompraDataAccess.TABLENAME, planeacioncompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PlaneacionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PlaneacionCompraLogic.registrarAuditoriaDetallesPlaneacionCompra(connexion,planeacioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(planeacioncompra.getIsDeleted()) {
					/*if(!planeacioncompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PlaneacionCompraDataAccess.TABLENAME, planeacioncompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PlaneacionCompraLogic.registrarAuditoriaDetallesPlaneacionCompra(connexion,planeacioncompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaneacionCompraDataAccess.TABLENAME, planeacioncompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(planeacioncompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaneacionCompraDataAccess.TABLENAME, planeacioncompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PlaneacionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PlaneacionCompraLogic.registrarAuditoriaDetallesPlaneacionCompra(connexion,planeacioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPlaneacionCompra(Connexion connexion,PlaneacionCompra planeacioncompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_empresa().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_empresa().toString();
				}
				if(planeacioncompra.getid_empresa()!=null)
				{
					strValorNuevo=planeacioncompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_sucursal().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_sucursal().toString();
				}
				if(planeacioncompra.getid_sucursal()!=null)
				{
					strValorNuevo=planeacioncompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_ejercicio().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_ejercicio().toString();
				}
				if(planeacioncompra.getid_ejercicio()!=null)
				{
					strValorNuevo=planeacioncompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_periodo().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_periodo().toString();
				}
				if(planeacioncompra.getid_periodo()!=null)
				{
					strValorNuevo=planeacioncompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_empleado().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_empleado()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_empleado().toString();
				}
				if(planeacioncompra.getid_empleado()!=null)
				{
					strValorNuevo=planeacioncompra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_usuario().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_usuario()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_usuario().toString();
				}
				if(planeacioncompra.getid_usuario()!=null)
				{
					strValorNuevo=planeacioncompra.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_formato().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_formato()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_formato().toString();
				}
				if(planeacioncompra.getid_formato()!=null)
				{
					strValorNuevo=planeacioncompra.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getnumero_pre_impreso().equals(planeacioncompra.getPlaneacionCompraOriginal().getnumero_pre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getnumero_pre_impreso()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getnumero_pre_impreso();
				}
				if(planeacioncompra.getnumero_pre_impreso()!=null)
				{
					strValorNuevo=planeacioncompra.getnumero_pre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getfecha().equals(planeacioncompra.getPlaneacionCompraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getfecha()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getfecha().toString();
				}
				if(planeacioncompra.getfecha()!=null)
				{
					strValorNuevo=planeacioncompra.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_mes_inicio().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_mes_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_mes_inicio()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_mes_inicio().toString();
				}
				if(planeacioncompra.getid_mes_inicio()!=null)
				{
					strValorNuevo=planeacioncompra.getid_mes_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDMESINICIO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getid_mes_fin().equals(planeacioncompra.getPlaneacionCompraOriginal().getid_mes_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getid_mes_fin()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getid_mes_fin().toString();
				}
				if(planeacioncompra.getid_mes_fin()!=null)
				{
					strValorNuevo=planeacioncompra.getid_mes_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.IDMESFIN,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getnumero_meses().equals(planeacioncompra.getPlaneacionCompraOriginal().getnumero_meses()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getnumero_meses()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getnumero_meses().toString();
				}
				if(planeacioncompra.getnumero_meses()!=null)
				{
					strValorNuevo=planeacioncompra.getnumero_meses().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.NUMEROMESES,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getfecha_corte().equals(planeacioncompra.getPlaneacionCompraOriginal().getfecha_corte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getfecha_corte()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getfecha_corte().toString();
				}
				if(planeacioncompra.getfecha_corte()!=null)
				{
					strValorNuevo=planeacioncompra.getfecha_corte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.FECHACORTE,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getcodigo_pedido().equals(planeacioncompra.getPlaneacionCompraOriginal().getcodigo_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getcodigo_pedido()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getcodigo_pedido();
				}
				if(planeacioncompra.getcodigo_pedido()!=null)
				{
					strValorNuevo=planeacioncompra.getcodigo_pedido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.CODIGOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getdescripcion1().equals(planeacioncompra.getPlaneacionCompraOriginal().getdescripcion1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getdescripcion1()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getdescripcion1();
				}
				if(planeacioncompra.getdescripcion1()!=null)
				{
					strValorNuevo=planeacioncompra.getdescripcion1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.DESCRIPCION1,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getdescripcion2().equals(planeacioncompra.getPlaneacionCompraOriginal().getdescripcion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getdescripcion2()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getdescripcion2();
				}
				if(planeacioncompra.getdescripcion2()!=null)
				{
					strValorNuevo=planeacioncompra.getdescripcion2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.DESCRIPCION2,strValorActual,strValorNuevo);
			}	
			
			if(planeacioncompra.getIsNew()||!planeacioncompra.getdescripcion3().equals(planeacioncompra.getPlaneacionCompraOriginal().getdescripcion3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planeacioncompra.getPlaneacionCompraOriginal().getdescripcion3()!=null)
				{
					strValorActual=planeacioncompra.getPlaneacionCompraOriginal().getdescripcion3();
				}
				if(planeacioncompra.getdescripcion3()!=null)
				{
					strValorNuevo=planeacioncompra.getdescripcion3() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaneacionCompraConstantesFunciones.DESCRIPCION3,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePlaneacionCompraRelacionesWithConnection(PlaneacionCompra planeacioncompra,List<DetallePlaneacionCompra> detalleplaneacioncompras) throws Exception {

		if(!planeacioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePlaneacionCompraRelacionesBase(planeacioncompra,detalleplaneacioncompras,true);
		}
	}

	public void savePlaneacionCompraRelaciones(PlaneacionCompra planeacioncompra,List<DetallePlaneacionCompra> detalleplaneacioncompras)throws Exception {

		if(!planeacioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePlaneacionCompraRelacionesBase(planeacioncompra,detalleplaneacioncompras,false);
		}
	}

	public void savePlaneacionCompraRelacionesBase(PlaneacionCompra planeacioncompra,List<DetallePlaneacionCompra> detalleplaneacioncompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PlaneacionCompra-saveRelacionesWithConnection");}
	
			planeacioncompra.setDetallePlaneacionCompras(detalleplaneacioncompras);

			this.setPlaneacionCompra(planeacioncompra);

			if(PlaneacionCompraLogicAdditional.validarSaveRelaciones(planeacioncompra,this)) {

				PlaneacionCompraLogicAdditional.updateRelacionesToSave(planeacioncompra,this);

				if((planeacioncompra.getIsNew()||planeacioncompra.getIsChanged())&&!planeacioncompra.getIsDeleted()) {
					this.savePlaneacionCompra();
					this.savePlaneacionCompraRelacionesDetalles(detalleplaneacioncompras);

				} else if(planeacioncompra.getIsDeleted()) {
					this.savePlaneacionCompraRelacionesDetalles(detalleplaneacioncompras);
					this.savePlaneacionCompra();
				}

				PlaneacionCompraLogicAdditional.updateRelacionesToSaveAfter(planeacioncompra,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetallePlaneacionCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePlaneacionCompras(detalleplaneacioncompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePlaneacionCompraRelacionesDetalles(List<DetallePlaneacionCompra> detalleplaneacioncompras)throws Exception {
		try {
	

			Long idPlaneacionCompraActual=this.getPlaneacionCompra().getId();

			DetallePlaneacionCompraLogic detalleplaneacioncompraLogic_Desde_PlaneacionCompra=new DetallePlaneacionCompraLogic();
			detalleplaneacioncompraLogic_Desde_PlaneacionCompra.setDetallePlaneacionCompras(detalleplaneacioncompras);

			detalleplaneacioncompraLogic_Desde_PlaneacionCompra.setConnexion(this.getConnexion());
			detalleplaneacioncompraLogic_Desde_PlaneacionCompra.setDatosCliente(this.datosCliente);

			for(DetallePlaneacionCompra detalleplaneacioncompra_Desde_PlaneacionCompra:detalleplaneacioncompraLogic_Desde_PlaneacionCompra.getDetallePlaneacionCompras()) {
				detalleplaneacioncompra_Desde_PlaneacionCompra.setid_planeacion_compra(idPlaneacionCompraActual);
			}

			detalleplaneacioncompraLogic_Desde_PlaneacionCompra.saveDetallePlaneacionCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PlaneacionCompraConstantesFunciones.getClassesForeignKeysOfPlaneacionCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PlaneacionCompraConstantesFunciones.getClassesRelationshipsOfPlaneacionCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
