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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.RutaConstantesFunciones;
import com.bydan.erp.cartera.util.RutaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RutaParameterGeneral;
import com.bydan.erp.cartera.business.entity.Ruta;
import com.bydan.erp.cartera.business.logic.RutaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class RutaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RutaLogic.class);
	
	protected RutaDataAccess rutaDataAccess; 	
	protected Ruta ruta;
	protected List<Ruta> rutas;
	protected Object rutaObject;	
	protected List<Object> rutasObject;
	
	public static ClassValidator<Ruta> rutaValidator = new ClassValidator<Ruta>(Ruta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RutaLogicAdditional rutaLogicAdditional=null;
	
	public RutaLogicAdditional getRutaLogicAdditional() {
		return this.rutaLogicAdditional;
	}
	
	public void setRutaLogicAdditional(RutaLogicAdditional rutaLogicAdditional) {
		try {
			this.rutaLogicAdditional=rutaLogicAdditional;
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
	
	
	
	
	public  RutaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rutaDataAccess = new RutaDataAccess();
			
			this.rutas= new ArrayList<Ruta>();
			this.ruta= new Ruta();
			
			this.rutaObject=new Object();
			this.rutasObject=new ArrayList<Object>();
				
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
			
			this.rutaDataAccess.setConnexionType(this.connexionType);
			this.rutaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RutaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rutaDataAccess = new RutaDataAccess();
			this.rutas= new ArrayList<Ruta>();
			this.ruta= new Ruta();
			this.rutaObject=new Object();
			this.rutasObject=new ArrayList<Object>();
			
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
			
			this.rutaDataAccess.setConnexionType(this.connexionType);
			this.rutaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Ruta getRuta() throws Exception {	
		RutaLogicAdditional.checkRutaToGet(ruta,this.datosCliente,this.arrDatoGeneral);
		RutaLogicAdditional.updateRutaToGet(ruta,this.arrDatoGeneral);
		
		return ruta;
	}
		
	public void setRuta(Ruta newRuta) {
		this.ruta = newRuta;
	}
	
	public RutaDataAccess getRutaDataAccess() {
		return rutaDataAccess;
	}
	
	public void setRutaDataAccess(RutaDataAccess newrutaDataAccess) {
		this.rutaDataAccess = newrutaDataAccess;
	}
	
	public List<Ruta> getRutas() throws Exception {		
		this.quitarRutasNulos();
		
		RutaLogicAdditional.checkRutaToGets(rutas,this.datosCliente,this.arrDatoGeneral);
		
		for (Ruta rutaLocal: rutas ) {
			RutaLogicAdditional.updateRutaToGet(rutaLocal,this.arrDatoGeneral);
		}
		
		return rutas;
	}
	
	public void setRutas(List<Ruta> newRutas) {
		this.rutas = newRutas;
	}
	
	public Object getRutaObject() {	
		this.rutaObject=this.rutaDataAccess.getEntityObject();
		return this.rutaObject;
	}
		
	public void setRutaObject(Object newRutaObject) {
		this.rutaObject = newRutaObject;
	}
	
	public List<Object> getRutasObject() {		
		this.rutasObject=this.rutaDataAccess.getEntitiesObject();
		return this.rutasObject;
	}
		
	public void setRutasObject(List<Object> newRutasObject) {
		this.rutasObject = newRutasObject;
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
		
		if(this.rutaDataAccess!=null) {
			this.rutaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rutaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rutaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ruta = new  Ruta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ruta=rutaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ruta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
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
		ruta = new  Ruta();
		  		  
        try {
			
			ruta=rutaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ruta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ruta = new  Ruta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ruta=rutaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ruta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
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
		ruta = new  Ruta();
		  		  
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
		ruta = new  Ruta();
		  		  
        try {
			
			ruta=rutaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ruta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ruta = new  Ruta();
		  		  
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
		ruta = new  Ruta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rutaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ruta = new  Ruta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rutaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ruta = new  Ruta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rutaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ruta = new  Ruta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rutaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ruta = new  Ruta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rutaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ruta = new  Ruta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rutaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rutas = new  ArrayList<Ruta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
		rutas = new  ArrayList<Ruta>();
		  		  
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
		rutas = new  ArrayList<Ruta>();
		  		  
        try {			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rutas = new  ArrayList<Ruta>();
		  		  
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
		rutas = new  ArrayList<Ruta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
		rutas = new  ArrayList<Ruta>();
		  		  
        try {
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
		rutas = new  ArrayList<Ruta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
		rutas = new  ArrayList<Ruta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ruta = new  Ruta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ruta=rutaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRuta(ruta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
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
		ruta = new  Ruta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ruta=rutaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRuta(ruta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rutas = new  ArrayList<Ruta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
		rutas = new  ArrayList<Ruta>();
		  		  
        try {
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRutasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rutas = new  ArrayList<Ruta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getTodosRutasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
	
	public  void  getTodosRutas(String sFinalQuery,Pagination pagination)throws Exception {
		rutas = new  ArrayList<Ruta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRuta(rutas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRuta(Ruta ruta) throws Exception {
		Boolean estaValidado=false;
		
		if(ruta.getIsNew() || ruta.getIsChanged()) { 
			this.invalidValues = rutaValidator.getInvalidValues(ruta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ruta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRuta(List<Ruta> Rutas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Ruta rutaLocal:rutas) {				
			estaValidadoObjeto=this.validarGuardarRuta(rutaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRuta(List<Ruta> Rutas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRuta(rutas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRuta(Ruta Ruta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRuta(ruta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Ruta ruta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ruta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RutaConstantesFunciones.getRutaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ruta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RutaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RutaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRutaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-saveRutaWithConnection");connexion.begin();			
			
			RutaLogicAdditional.checkRutaToSave(this.ruta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RutaLogicAdditional.updateRutaToSave(this.ruta,this.arrDatoGeneral);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ruta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRuta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRuta(this.ruta)) {
				RutaDataAccess.save(this.ruta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ruta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RutaLogicAdditional.checkRutaToSaveAfter(this.ruta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRuta();
			
			connexion.commit();			
			
			if(this.ruta.getIsDeleted()) {
				this.ruta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRuta()throws Exception {	
		try {	
			
			RutaLogicAdditional.checkRutaToSave(this.ruta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RutaLogicAdditional.updateRutaToSave(this.ruta,this.arrDatoGeneral);
			
			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ruta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRuta(this.ruta)) {			
				RutaDataAccess.save(this.ruta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ruta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RutaLogicAdditional.checkRutaToSaveAfter(this.ruta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ruta.getIsDeleted()) {
				this.ruta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRutasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-saveRutasWithConnection");connexion.begin();			
			
			RutaLogicAdditional.checkRutaToSaves(rutas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRutas();
			
			Boolean validadoTodosRuta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Ruta rutaLocal:rutas) {		
				if(rutaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RutaLogicAdditional.updateRutaToSave(rutaLocal,this.arrDatoGeneral);
	        	
				RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rutaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRuta(rutaLocal)) {
					RutaDataAccess.save(rutaLocal, connexion);				
				} else {
					validadoTodosRuta=false;
				}
			}
			
			if(!validadoTodosRuta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RutaLogicAdditional.checkRutaToSavesAfter(rutas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRutas();
			
			connexion.commit();		
			
			this.quitarRutasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRutas()throws Exception {				
		 try {	
			RutaLogicAdditional.checkRutaToSaves(rutas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRuta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Ruta rutaLocal:rutas) {				
				if(rutaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RutaLogicAdditional.updateRutaToSave(rutaLocal,this.arrDatoGeneral);
	        	
				RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rutaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRuta(rutaLocal)) {				
					RutaDataAccess.save(rutaLocal, connexion);				
				} else {
					validadoTodosRuta=false;
				}
			}
			
			if(!validadoTodosRuta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RutaLogicAdditional.checkRutaToSavesAfter(rutas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRutasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RutaParameterReturnGeneral procesarAccionRutas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Ruta> rutas,RutaParameterReturnGeneral rutaParameterGeneral)throws Exception {
		 try {	
			RutaParameterReturnGeneral rutaReturnGeneral=new RutaParameterReturnGeneral();
	
			RutaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rutas,rutaParameterGeneral,rutaReturnGeneral);
			
			return rutaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RutaParameterReturnGeneral procesarAccionRutasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Ruta> rutas,RutaParameterReturnGeneral rutaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-procesarAccionRutasWithConnection");connexion.begin();			
			
			RutaParameterReturnGeneral rutaReturnGeneral=new RutaParameterReturnGeneral();
	
			RutaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rutas,rutaParameterGeneral,rutaReturnGeneral);
			
			this.connexion.commit();
			
			return rutaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RutaParameterReturnGeneral procesarEventosRutas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Ruta> rutas,Ruta ruta,RutaParameterReturnGeneral rutaParameterGeneral,Boolean isEsNuevoRuta,ArrayList<Classe> clases)throws Exception {
		 try {	
			RutaParameterReturnGeneral rutaReturnGeneral=new RutaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rutaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RutaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rutas,ruta,rutaParameterGeneral,rutaReturnGeneral,isEsNuevoRuta,clases);
			
			return rutaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RutaParameterReturnGeneral procesarEventosRutasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Ruta> rutas,Ruta ruta,RutaParameterReturnGeneral rutaParameterGeneral,Boolean isEsNuevoRuta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-procesarEventosRutasWithConnection");connexion.begin();			
			
			RutaParameterReturnGeneral rutaReturnGeneral=new RutaParameterReturnGeneral();
	
			rutaReturnGeneral.setRuta(ruta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rutaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RutaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rutas,ruta,rutaParameterGeneral,rutaReturnGeneral,isEsNuevoRuta,clases);
			
			this.connexion.commit();
			
			return rutaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RutaParameterReturnGeneral procesarImportacionRutasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RutaParameterReturnGeneral rutaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-procesarImportacionRutasWithConnection");connexion.begin();			
			
			RutaParameterReturnGeneral rutaReturnGeneral=new RutaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rutas=new ArrayList<Ruta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ruta=new Ruta();
				
				
				if(conColumnasBase) {this.ruta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ruta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ruta.setnombre(arrColumnas[iColumn++]);
				this.ruta.setorigen(arrColumnas[iColumn++]);
				this.ruta.setdestino(arrColumnas[iColumn++]);
				this.ruta.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
			this.ruta.setdireccion(arrColumnas[iColumn++]);
				
				this.rutas.add(this.ruta);
			}
			
			this.saveRutas();
			
			this.connexion.commit();
			
			rutaReturnGeneral.setConRetornoEstaProcesado(true);
			rutaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rutaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRutasEliminados() throws Exception {				
		
		List<Ruta> rutasAux= new ArrayList<Ruta>();
		
		for(Ruta ruta:rutas) {
			if(!ruta.getIsDeleted()) {
				rutasAux.add(ruta);
			}
		}
		
		rutas=rutasAux;
	}
	
	public void quitarRutasNulos() throws Exception {				
		
		List<Ruta> rutasAux= new ArrayList<Ruta>();
		
		for(Ruta ruta : this.rutas) {
			if(ruta==null) {
				rutasAux.add(ruta);
			}
		}
		
		//this.rutas=rutasAux;
		
		this.rutas.removeAll(rutasAux);
	}
	
	public void getSetVersionRowRutaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ruta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ruta.getIsDeleted() || (ruta.getIsChanged()&&!ruta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rutaDataAccess.getSetVersionRowRuta(connexion,ruta.getId());
				
				if(!ruta.getVersionRow().equals(timestamp)) {	
					ruta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ruta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRuta()throws Exception {	
		
		if(ruta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ruta.getIsDeleted() || (ruta.getIsChanged()&&!ruta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rutaDataAccess.getSetVersionRowRuta(connexion,ruta.getId());
			
			try {							
				if(!ruta.getVersionRow().equals(timestamp)) {	
					ruta.setVersionRow(timestamp);
				}
				
				ruta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRutasWithConnection()throws Exception {	
		if(rutas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Ruta rutaAux:rutas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rutaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rutaAux.getIsDeleted() || (rutaAux.getIsChanged()&&!rutaAux.getIsNew())) {
						
						timestamp=rutaDataAccess.getSetVersionRowRuta(connexion,rutaAux.getId());
						
						if(!ruta.getVersionRow().equals(timestamp)) {	
							rutaAux.setVersionRow(timestamp);
						}
								
						rutaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRutas()throws Exception {	
		if(rutas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Ruta rutaAux:rutas) {
					if(rutaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rutaAux.getIsDeleted() || (rutaAux.getIsChanged()&&!rutaAux.getIsNew())) {
						
						timestamp=rutaDataAccess.getSetVersionRowRuta(connexion,rutaAux.getId());
						
						if(!rutaAux.getVersionRow().equals(timestamp)) {	
							rutaAux.setVersionRow(timestamp);
						}
						
													
						rutaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RutaParameterReturnGeneral cargarCombosLoteForeignKeyRutaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalSectorOrigen,String finalQueryGlobalSectorDestino) throws Exception {
		RutaParameterReturnGeneral  rutaReturnGeneral =new RutaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-cargarCombosLoteForeignKeyRutaWithConnection");connexion.begin();
			
			rutaReturnGeneral =new RutaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rutaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			rutaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			rutaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Sector> sectororigensForeignKey=new ArrayList<Sector>();
			SectorLogic sectororigenLogic=new SectorLogic();
			sectororigenLogic.setConnexion(this.connexion);
			sectororigenLogic.getSectorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSectorOrigen.equals("NONE")) {
				sectororigenLogic.getTodosSectors(finalQueryGlobalSectorOrigen,new Pagination());
				sectororigensForeignKey=sectororigenLogic.getSectors();
			}

			rutaReturnGeneral.setsectororigensForeignKey(sectororigensForeignKey);


			List<Sector> sectordestinosForeignKey=new ArrayList<Sector>();
			SectorLogic sectordestinoLogic=new SectorLogic();
			sectordestinoLogic.setConnexion(this.connexion);
			sectordestinoLogic.getSectorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSectorDestino.equals("NONE")) {
				sectordestinoLogic.getTodosSectors(finalQueryGlobalSectorDestino,new Pagination());
				sectordestinosForeignKey=sectordestinoLogic.getSectors();
			}

			rutaReturnGeneral.setsectordestinosForeignKey(sectordestinosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rutaReturnGeneral;
	}
	
	public RutaParameterReturnGeneral cargarCombosLoteForeignKeyRuta(String finalQueryGlobalEmpresa,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalSectorOrigen,String finalQueryGlobalSectorDestino) throws Exception {
		RutaParameterReturnGeneral  rutaReturnGeneral =new RutaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rutaReturnGeneral =new RutaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rutaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			rutaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			rutaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Sector> sectororigensForeignKey=new ArrayList<Sector>();
			SectorLogic sectororigenLogic=new SectorLogic();
			sectororigenLogic.setConnexion(this.connexion);
			sectororigenLogic.getSectorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSectorOrigen.equals("NONE")) {
				sectororigenLogic.getTodosSectors(finalQueryGlobalSectorOrigen,new Pagination());
				sectororigensForeignKey=sectororigenLogic.getSectors();
			}

			rutaReturnGeneral.setsectororigensForeignKey(sectororigensForeignKey);


			List<Sector> sectordestinosForeignKey=new ArrayList<Sector>();
			SectorLogic sectordestinoLogic=new SectorLogic();
			sectordestinoLogic.setConnexion(this.connexion);
			sectordestinoLogic.getSectorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSectorDestino.equals("NONE")) {
				sectordestinoLogic.getTodosSectors(finalQueryGlobalSectorDestino,new Pagination());
				sectordestinosForeignKey=sectordestinoLogic.getSectors();
			}

			rutaReturnGeneral.setsectordestinosForeignKey(sectordestinosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rutaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRutaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRutaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Ruta ruta:this.rutas) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(ruta.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(ruta.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Ruta ruta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RutaLogicAdditional.updateRutaToGet(ruta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ruta.setEmpresa(rutaDataAccess.getEmpresa(connexion,ruta));
		ruta.setPais(rutaDataAccess.getPais(connexion,ruta));
		ruta.setCiudad(rutaDataAccess.getCiudad(connexion,ruta));
		ruta.setSectorOrigen(rutaDataAccess.getSectorOrigen(connexion,ruta));
		ruta.setSectorDestino(rutaDataAccess.getSectorDestino(connexion,ruta));
		ruta.setClientes(rutaDataAccess.getClientes(connexion,ruta));
		ruta.setParametroCarteraDefectos(rutaDataAccess.getParametroCarteraDefectos(connexion,ruta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ruta.setEmpresa(rutaDataAccess.getEmpresa(connexion,ruta));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				ruta.setPais(rutaDataAccess.getPais(connexion,ruta));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				ruta.setCiudad(rutaDataAccess.getCiudad(connexion,ruta));
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				ruta.setSectorOrigen(rutaDataAccess.getSectorOrigen(connexion,ruta));
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				ruta.setSectorDestino(rutaDataAccess.getSectorDestino(connexion,ruta));
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ruta.setClientes(rutaDataAccess.getClientes(connexion,ruta));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(ruta.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					ruta.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ruta.setParametroCarteraDefectos(rutaDataAccess.getParametroCarteraDefectos(connexion,ruta));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(ruta.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					ruta.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
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
			ruta.setEmpresa(rutaDataAccess.getEmpresa(connexion,ruta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setPais(rutaDataAccess.getPais(connexion,ruta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setCiudad(rutaDataAccess.getCiudad(connexion,ruta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sector.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setSectorOrigen(rutaDataAccess.getSectorOrigen(connexion,ruta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sector.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setSectorDestino(rutaDataAccess.getSectorDestino(connexion,ruta));
		}

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
			ruta.setClientes(rutaDataAccess.getClientes(connexion,ruta));
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
			ruta.setParametroCarteraDefectos(rutaDataAccess.getParametroCarteraDefectos(connexion,ruta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ruta.setEmpresa(rutaDataAccess.getEmpresa(connexion,ruta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ruta.getEmpresa(),isDeep,deepLoadType,clases);
				
		ruta.setPais(rutaDataAccess.getPais(connexion,ruta));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(ruta.getPais(),isDeep,deepLoadType,clases);
				
		ruta.setCiudad(rutaDataAccess.getCiudad(connexion,ruta));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(ruta.getCiudad(),isDeep,deepLoadType,clases);
				
		ruta.setSectorOrigen(rutaDataAccess.getSectorOrigen(connexion,ruta));
		SectorLogic sectororigenLogic= new SectorLogic(connexion);
		sectororigenLogic.deepLoad(ruta.getSectorOrigen(),isDeep,deepLoadType,clases);
				
		ruta.setSectorDestino(rutaDataAccess.getSectorDestino(connexion,ruta));
		SectorLogic sectordestinoLogic= new SectorLogic(connexion);
		sectordestinoLogic.deepLoad(ruta.getSectorDestino(),isDeep,deepLoadType,clases);
				

		ruta.setClientes(rutaDataAccess.getClientes(connexion,ruta));

		for(Cliente cliente:ruta.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		ruta.setParametroCarteraDefectos(rutaDataAccess.getParametroCarteraDefectos(connexion,ruta));

		for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ruta.setEmpresa(rutaDataAccess.getEmpresa(connexion,ruta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ruta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				ruta.setPais(rutaDataAccess.getPais(connexion,ruta));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(ruta.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				ruta.setCiudad(rutaDataAccess.getCiudad(connexion,ruta));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(ruta.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				ruta.setSectorOrigen(rutaDataAccess.getSectorOrigen(connexion,ruta));
				SectorLogic sectorLogic= new SectorLogic(connexion);
				sectorLogic.deepLoad(ruta.getSectorOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				ruta.setSectorDestino(rutaDataAccess.getSectorDestino(connexion,ruta));
				SectorLogic sectorLogic= new SectorLogic(connexion);
				sectorLogic.deepLoad(ruta.getSectorDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ruta.setClientes(rutaDataAccess.getClientes(connexion,ruta));

				for(Cliente cliente:ruta.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ruta.setParametroCarteraDefectos(rutaDataAccess.getParametroCarteraDefectos(connexion,ruta));

				for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			ruta.setEmpresa(rutaDataAccess.getEmpresa(connexion,ruta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ruta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setPais(rutaDataAccess.getPais(connexion,ruta));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(ruta.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setCiudad(rutaDataAccess.getCiudad(connexion,ruta));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(ruta.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sector.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setSectorOrigen(rutaDataAccess.getSectorOrigen(connexion,ruta));
			SectorLogic sectorLogic= new SectorLogic(connexion);
			sectorLogic.deepLoad(ruta.getSectorOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sector.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ruta.setSectorDestino(rutaDataAccess.getSectorDestino(connexion,ruta));
			SectorLogic sectorLogic= new SectorLogic(connexion);
			sectorLogic.deepLoad(ruta.getSectorDestino(),isDeep,deepLoadType,clases);
				
		}

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
			ruta.setClientes(rutaDataAccess.getClientes(connexion,ruta));

			for(Cliente cliente:ruta.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
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
			ruta.setParametroCarteraDefectos(rutaDataAccess.getParametroCarteraDefectos(connexion,ruta));

			for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Ruta ruta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RutaLogicAdditional.updateRutaToSave(ruta,this.arrDatoGeneral);
			
RutaDataAccess.save(ruta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ruta.getEmpresa(),connexion);

		PaisDataAccess.save(ruta.getPais(),connexion);

		CiudadDataAccess.save(ruta.getCiudad(),connexion);

		SectorDataAccess.save(ruta.getSectorOrigen(),connexion);

		SectorDataAccess.save(ruta.getSectorDestino(),connexion);

		for(Cliente cliente:ruta.getClientes()) {
			cliente.setid_ruta(ruta.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_ruta(ruta.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ruta.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(ruta.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(ruta.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				SectorDataAccess.save(ruta.getSectorOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				SectorDataAccess.save(ruta.getSectorDestino(),connexion);
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:ruta.getClientes()) {
					cliente.setid_ruta(ruta.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_ruta(ruta.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ruta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ruta.getEmpresa(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(ruta.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(ruta.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(ruta.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(ruta.getCiudad(),isDeep,deepLoadType,clases);
				

		SectorDataAccess.save(ruta.getSectorOrigen(),connexion);
		SectorLogic sectororigenLogic= new SectorLogic(connexion);
		sectororigenLogic.deepLoad(ruta.getSectorOrigen(),isDeep,deepLoadType,clases);
				

		SectorDataAccess.save(ruta.getSectorDestino(),connexion);
		SectorLogic sectordestinoLogic= new SectorLogic(connexion);
		sectordestinoLogic.deepLoad(ruta.getSectorDestino(),isDeep,deepLoadType,clases);
				

		for(Cliente cliente:ruta.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_ruta(ruta.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_ruta(ruta.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ruta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ruta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(ruta.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(ruta.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(ruta.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(ruta.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				SectorDataAccess.save(ruta.getSectorOrigen(),connexion);
				SectorLogic sectorLogic= new SectorLogic(connexion);
				sectorLogic.deepSave(ruta.getSectorOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				SectorDataAccess.save(ruta.getSectorDestino(),connexion);
				SectorLogic sectorLogic= new SectorLogic(connexion);
				sectorLogic.deepSave(ruta.getSectorDestino(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:ruta.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_ruta(ruta.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:ruta.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_ruta(ruta.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Ruta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ruta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(ruta);
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
			this.deepLoad(this.ruta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.ruta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Ruta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rutas!=null) {
				for(Ruta ruta:rutas) {
					this.deepLoad(ruta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(rutas);
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
			if(rutas!=null) {
				for(Ruta ruta:rutas) {
					this.deepLoad(ruta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(rutas);
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
			this.getNewConnexionToDeep(Ruta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ruta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Ruta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rutas!=null) {
				for(Ruta ruta:rutas) {
					this.deepSave(ruta,isDeep,deepLoadType,clases);
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
			if(rutas!=null) {
				for(Ruta ruta:rutas) {
					this.deepSave(ruta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRutasBusquedaPorDestinoWithConnection(String sFinalQuery,Pagination pagination,String destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralDestino.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+destino+"%",RutaConstantesFunciones.DESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralDestino);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasBusquedaPorDestino(String sFinalQuery,Pagination pagination,String destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralDestino.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+destino+"%",RutaConstantesFunciones.DESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralDestino);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",RutaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",RutaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasBusquedaPorOrigenWithConnection(String sFinalQuery,Pagination pagination,String origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralOrigen.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+origen+"%",RutaConstantesFunciones.ORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralOrigen);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasBusquedaPorOrigen(String sFinalQuery,Pagination pagination,String origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralOrigen.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+origen+"%",RutaConstantesFunciones.ORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralOrigen);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasBusquedaPorPrecioWithConnection(String sFinalQuery,Pagination pagination,Double precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralPrecio.setParameterSelectionGeneralEqual(ParameterType.DOUBLE,precio,RutaConstantesFunciones.PRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralPrecio);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasBusquedaPorPrecio(String sFinalQuery,Pagination pagination,Double precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralPrecio.setParameterSelectionGeneralEqual(ParameterType.DOUBLE,precio,RutaConstantesFunciones.PRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralPrecio);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,RutaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,RutaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RutaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RutaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RutaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RutaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasFK_IdSectorDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_sector_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSectorDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSectorDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sector_destino,RutaConstantesFunciones.IDSECTORDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSectorDestino);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSectorDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasFK_IdSectorDestino(String sFinalQuery,Pagination pagination,Long id_sector_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSectorDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSectorDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sector_destino,RutaConstantesFunciones.IDSECTORDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSectorDestino);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSectorDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutasFK_IdSectorOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_sector_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ruta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSectorOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSectorOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sector_origen,RutaConstantesFunciones.IDSECTORORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSectorOrigen);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSectorOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutasFK_IdSectorOrigen(String sFinalQuery,Pagination pagination,Long id_sector_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSectorOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSectorOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sector_origen,RutaConstantesFunciones.IDSECTORORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSectorOrigen);

			RutaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSectorOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutas=rutaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(this.rutas);
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
			if(RutaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Ruta ruta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RutaConstantesFunciones.ISCONAUDITORIA) {
				if(ruta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaDataAccess.TABLENAME, ruta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RutaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RutaLogic.registrarAuditoriaDetallesRuta(connexion,ruta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ruta.getIsDeleted()) {
					/*if(!ruta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RutaDataAccess.TABLENAME, ruta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RutaLogic.registrarAuditoriaDetallesRuta(connexion,ruta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaDataAccess.TABLENAME, ruta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ruta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaDataAccess.TABLENAME, ruta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RutaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RutaLogic.registrarAuditoriaDetallesRuta(connexion,ruta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRuta(Connexion connexion,Ruta ruta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ruta.getIsNew()||!ruta.getid_empresa().equals(ruta.getRutaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getid_empresa()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getid_empresa().toString();
				}
				if(ruta.getid_empresa()!=null)
				{
					strValorNuevo=ruta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getid_pais().equals(ruta.getRutaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getid_pais()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getid_pais().toString();
				}
				if(ruta.getid_pais()!=null)
				{
					strValorNuevo=ruta.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getid_ciudad().equals(ruta.getRutaOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getid_ciudad()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getid_ciudad().toString();
				}
				if(ruta.getid_ciudad()!=null)
				{
					strValorNuevo=ruta.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getid_sector_origen().equals(ruta.getRutaOriginal().getid_sector_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getid_sector_origen()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getid_sector_origen().toString();
				}
				if(ruta.getid_sector_origen()!=null)
				{
					strValorNuevo=ruta.getid_sector_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.IDSECTORORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getid_sector_destino().equals(ruta.getRutaOriginal().getid_sector_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getid_sector_destino()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getid_sector_destino().toString();
				}
				if(ruta.getid_sector_destino()!=null)
				{
					strValorNuevo=ruta.getid_sector_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.IDSECTORDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getnombre().equals(ruta.getRutaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getnombre()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getnombre();
				}
				if(ruta.getnombre()!=null)
				{
					strValorNuevo=ruta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getorigen().equals(ruta.getRutaOriginal().getorigen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getorigen()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getorigen();
				}
				if(ruta.getorigen()!=null)
				{
					strValorNuevo=ruta.getorigen() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.ORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getdestino().equals(ruta.getRutaOriginal().getdestino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getdestino()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getdestino();
				}
				if(ruta.getdestino()!=null)
				{
					strValorNuevo=ruta.getdestino() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.DESTINO,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getprecio().equals(ruta.getRutaOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getprecio()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getprecio().toString();
				}
				if(ruta.getprecio()!=null)
				{
					strValorNuevo=ruta.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(ruta.getIsNew()||!ruta.getdireccion().equals(ruta.getRutaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ruta.getRutaOriginal().getdireccion()!=null)
				{
					strValorActual=ruta.getRutaOriginal().getdireccion();
				}
				if(ruta.getdireccion()!=null)
				{
					strValorNuevo=ruta.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRutaRelacionesWithConnection(Ruta ruta,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!ruta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRutaRelacionesBase(ruta,clientes,parametrocarteradefectos,true);
		}
	}

	public void saveRutaRelaciones(Ruta ruta,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!ruta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRutaRelacionesBase(ruta,clientes,parametrocarteradefectos,false);
		}
	}

	public void saveRutaRelacionesBase(Ruta ruta,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Ruta-saveRelacionesWithConnection");}
	
			ruta.setClientes(clientes);
			ruta.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setRuta(ruta);

			if(RutaLogicAdditional.validarSaveRelaciones(ruta,this)) {

				RutaLogicAdditional.updateRelacionesToSave(ruta,this);

				if((ruta.getIsNew()||ruta.getIsChanged())&&!ruta.getIsDeleted()) {
					this.saveRuta();
					this.saveRutaRelacionesDetalles(clientes,parametrocarteradefectos);

				} else if(ruta.getIsDeleted()) {
					this.saveRutaRelacionesDetalles(clientes,parametrocarteradefectos);
					this.saveRuta();
				}

				RutaLogicAdditional.updateRelacionesToSaveAfter(ruta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRutaRelacionesDetalles(List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idRutaActual=this.getRuta().getId();

			ClienteLogic clienteLogic_Desde_Ruta=new ClienteLogic();
			clienteLogic_Desde_Ruta.setClientes(clientes);

			clienteLogic_Desde_Ruta.setConnexion(this.getConnexion());
			clienteLogic_Desde_Ruta.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_Ruta:clienteLogic_Desde_Ruta.getClientes()) {
				cliente_Desde_Ruta.setid_ruta(idRutaActual);

				clienteLogic_Desde_Ruta.setCliente(cliente_Desde_Ruta);
				clienteLogic_Desde_Ruta.saveCliente();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_Ruta=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_Ruta.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_Ruta.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_Ruta.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_Ruta:parametrocarteradefectoLogic_Desde_Ruta.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_Ruta.setid_ruta(idRutaActual);
			}

			parametrocarteradefectoLogic_Desde_Ruta.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRuta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RutaConstantesFunciones.getClassesForeignKeysOfRuta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRuta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RutaConstantesFunciones.getClassesRelationshipsOfRuta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
