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
import com.bydan.erp.cartera.util.RutaTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.RutaTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RutaTransporteParameterGeneral;
import com.bydan.erp.cartera.business.entity.RutaTransporte;
import com.bydan.erp.cartera.business.logic.RutaTransporteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class RutaTransporteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RutaTransporteLogic.class);
	
	protected RutaTransporteDataAccess rutatransporteDataAccess; 	
	protected RutaTransporte rutatransporte;
	protected List<RutaTransporte> rutatransportes;
	protected Object rutatransporteObject;	
	protected List<Object> rutatransportesObject;
	
	public static ClassValidator<RutaTransporte> rutatransporteValidator = new ClassValidator<RutaTransporte>(RutaTransporte.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RutaTransporteLogicAdditional rutatransporteLogicAdditional=null;
	
	public RutaTransporteLogicAdditional getRutaTransporteLogicAdditional() {
		return this.rutatransporteLogicAdditional;
	}
	
	public void setRutaTransporteLogicAdditional(RutaTransporteLogicAdditional rutatransporteLogicAdditional) {
		try {
			this.rutatransporteLogicAdditional=rutatransporteLogicAdditional;
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
	
	
	
	
	public  RutaTransporteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rutatransporteDataAccess = new RutaTransporteDataAccess();
			
			this.rutatransportes= new ArrayList<RutaTransporte>();
			this.rutatransporte= new RutaTransporte();
			
			this.rutatransporteObject=new Object();
			this.rutatransportesObject=new ArrayList<Object>();
				
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
			
			this.rutatransporteDataAccess.setConnexionType(this.connexionType);
			this.rutatransporteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RutaTransporteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rutatransporteDataAccess = new RutaTransporteDataAccess();
			this.rutatransportes= new ArrayList<RutaTransporte>();
			this.rutatransporte= new RutaTransporte();
			this.rutatransporteObject=new Object();
			this.rutatransportesObject=new ArrayList<Object>();
			
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
			
			this.rutatransporteDataAccess.setConnexionType(this.connexionType);
			this.rutatransporteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RutaTransporte getRutaTransporte() throws Exception {	
		RutaTransporteLogicAdditional.checkRutaTransporteToGet(rutatransporte,this.datosCliente,this.arrDatoGeneral);
		RutaTransporteLogicAdditional.updateRutaTransporteToGet(rutatransporte,this.arrDatoGeneral);
		
		return rutatransporte;
	}
		
	public void setRutaTransporte(RutaTransporte newRutaTransporte) {
		this.rutatransporte = newRutaTransporte;
	}
	
	public RutaTransporteDataAccess getRutaTransporteDataAccess() {
		return rutatransporteDataAccess;
	}
	
	public void setRutaTransporteDataAccess(RutaTransporteDataAccess newrutatransporteDataAccess) {
		this.rutatransporteDataAccess = newrutatransporteDataAccess;
	}
	
	public List<RutaTransporte> getRutaTransportes() throws Exception {		
		this.quitarRutaTransportesNulos();
		
		RutaTransporteLogicAdditional.checkRutaTransporteToGets(rutatransportes,this.datosCliente,this.arrDatoGeneral);
		
		for (RutaTransporte rutatransporteLocal: rutatransportes ) {
			RutaTransporteLogicAdditional.updateRutaTransporteToGet(rutatransporteLocal,this.arrDatoGeneral);
		}
		
		return rutatransportes;
	}
	
	public void setRutaTransportes(List<RutaTransporte> newRutaTransportes) {
		this.rutatransportes = newRutaTransportes;
	}
	
	public Object getRutaTransporteObject() {	
		this.rutatransporteObject=this.rutatransporteDataAccess.getEntityObject();
		return this.rutatransporteObject;
	}
		
	public void setRutaTransporteObject(Object newRutaTransporteObject) {
		this.rutatransporteObject = newRutaTransporteObject;
	}
	
	public List<Object> getRutaTransportesObject() {		
		this.rutatransportesObject=this.rutatransporteDataAccess.getEntitiesObject();
		return this.rutatransportesObject;
	}
		
	public void setRutaTransportesObject(List<Object> newRutaTransportesObject) {
		this.rutatransportesObject = newRutaTransportesObject;
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
		
		if(this.rutatransporteDataAccess!=null) {
			this.rutatransporteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rutatransporteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rutatransporteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rutatransporte = new  RutaTransporte();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rutatransporte=rutatransporteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rutatransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
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
		rutatransporte = new  RutaTransporte();
		  		  
        try {
			
			rutatransporte=rutatransporteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rutatransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rutatransporte = new  RutaTransporte();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rutatransporte=rutatransporteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rutatransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
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
		rutatransporte = new  RutaTransporte();
		  		  
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
		rutatransporte = new  RutaTransporte();
		  		  
        try {
			
			rutatransporte=rutatransporteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rutatransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rutatransporte = new  RutaTransporte();
		  		  
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
		rutatransporte = new  RutaTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rutatransporteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rutatransporte = new  RutaTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rutatransporteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rutatransporte = new  RutaTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rutatransporteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rutatransporte = new  RutaTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rutatransporteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rutatransporte = new  RutaTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rutatransporteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rutatransporte = new  RutaTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rutatransporteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
        try {			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
        try {
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rutatransporte = new  RutaTransporte();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransporte=rutatransporteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransporte);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
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
		rutatransporte = new  RutaTransporte();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransporte=rutatransporteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransporte);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
		rutatransportes = new  ArrayList<RutaTransporte>();
		  		  
        try {
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRutaTransportesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rutatransportes = new  ArrayList<RutaTransporte>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getTodosRutaTransportesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
	
	public  void  getTodosRutaTransportes(String sFinalQuery,Pagination pagination)throws Exception {
		rutatransportes = new  ArrayList<RutaTransporte>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRutaTransporte(rutatransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRutaTransporte(RutaTransporte rutatransporte) throws Exception {
		Boolean estaValidado=false;
		
		if(rutatransporte.getIsNew() || rutatransporte.getIsChanged()) { 
			this.invalidValues = rutatransporteValidator.getInvalidValues(rutatransporte);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rutatransporte);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRutaTransporte(List<RutaTransporte> RutaTransportes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RutaTransporte rutatransporteLocal:rutatransportes) {				
			estaValidadoObjeto=this.validarGuardarRutaTransporte(rutatransporteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRutaTransporte(List<RutaTransporte> RutaTransportes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRutaTransporte(rutatransportes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRutaTransporte(RutaTransporte RutaTransporte) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRutaTransporte(rutatransporte)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RutaTransporte rutatransporte) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rutatransporte.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RutaTransporteConstantesFunciones.getRutaTransporteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rutatransporte","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RutaTransporteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RutaTransporteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRutaTransporteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-saveRutaTransporteWithConnection");connexion.begin();			
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSave(this.rutatransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RutaTransporteLogicAdditional.updateRutaTransporteToSave(this.rutatransporte,this.arrDatoGeneral);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rutatransporte,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRutaTransporte();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRutaTransporte(this.rutatransporte)) {
				RutaTransporteDataAccess.save(this.rutatransporte, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rutatransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSaveAfter(this.rutatransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRutaTransporte();
			
			connexion.commit();			
			
			if(this.rutatransporte.getIsDeleted()) {
				this.rutatransporte=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRutaTransporte()throws Exception {	
		try {	
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSave(this.rutatransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RutaTransporteLogicAdditional.updateRutaTransporteToSave(this.rutatransporte,this.arrDatoGeneral);
			
			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rutatransporte,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRutaTransporte(this.rutatransporte)) {			
				RutaTransporteDataAccess.save(this.rutatransporte, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rutatransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSaveAfter(this.rutatransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rutatransporte.getIsDeleted()) {
				this.rutatransporte=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRutaTransportesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-saveRutaTransportesWithConnection");connexion.begin();			
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSaves(rutatransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRutaTransportes();
			
			Boolean validadoTodosRutaTransporte=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RutaTransporte rutatransporteLocal:rutatransportes) {		
				if(rutatransporteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RutaTransporteLogicAdditional.updateRutaTransporteToSave(rutatransporteLocal,this.arrDatoGeneral);
	        	
				RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rutatransporteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRutaTransporte(rutatransporteLocal)) {
					RutaTransporteDataAccess.save(rutatransporteLocal, connexion);				
				} else {
					validadoTodosRutaTransporte=false;
				}
			}
			
			if(!validadoTodosRutaTransporte) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSavesAfter(rutatransportes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRutaTransportes();
			
			connexion.commit();		
			
			this.quitarRutaTransportesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRutaTransportes()throws Exception {				
		 try {	
			RutaTransporteLogicAdditional.checkRutaTransporteToSaves(rutatransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRutaTransporte=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RutaTransporte rutatransporteLocal:rutatransportes) {				
				if(rutatransporteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RutaTransporteLogicAdditional.updateRutaTransporteToSave(rutatransporteLocal,this.arrDatoGeneral);
	        	
				RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rutatransporteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRutaTransporte(rutatransporteLocal)) {				
					RutaTransporteDataAccess.save(rutatransporteLocal, connexion);				
				} else {
					validadoTodosRutaTransporte=false;
				}
			}
			
			if(!validadoTodosRutaTransporte) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RutaTransporteLogicAdditional.checkRutaTransporteToSavesAfter(rutatransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRutaTransportesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RutaTransporteParameterReturnGeneral procesarAccionRutaTransportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RutaTransporte> rutatransportes,RutaTransporteParameterReturnGeneral rutatransporteParameterGeneral)throws Exception {
		 try {	
			RutaTransporteParameterReturnGeneral rutatransporteReturnGeneral=new RutaTransporteParameterReturnGeneral();
	
			RutaTransporteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rutatransportes,rutatransporteParameterGeneral,rutatransporteReturnGeneral);
			
			return rutatransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RutaTransporteParameterReturnGeneral procesarAccionRutaTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RutaTransporte> rutatransportes,RutaTransporteParameterReturnGeneral rutatransporteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-procesarAccionRutaTransportesWithConnection");connexion.begin();			
			
			RutaTransporteParameterReturnGeneral rutatransporteReturnGeneral=new RutaTransporteParameterReturnGeneral();
	
			RutaTransporteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rutatransportes,rutatransporteParameterGeneral,rutatransporteReturnGeneral);
			
			this.connexion.commit();
			
			return rutatransporteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RutaTransporteParameterReturnGeneral procesarEventosRutaTransportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RutaTransporte> rutatransportes,RutaTransporte rutatransporte,RutaTransporteParameterReturnGeneral rutatransporteParameterGeneral,Boolean isEsNuevoRutaTransporte,ArrayList<Classe> clases)throws Exception {
		 try {	
			RutaTransporteParameterReturnGeneral rutatransporteReturnGeneral=new RutaTransporteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rutatransporteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RutaTransporteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rutatransportes,rutatransporte,rutatransporteParameterGeneral,rutatransporteReturnGeneral,isEsNuevoRutaTransporte,clases);
			
			return rutatransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RutaTransporteParameterReturnGeneral procesarEventosRutaTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RutaTransporte> rutatransportes,RutaTransporte rutatransporte,RutaTransporteParameterReturnGeneral rutatransporteParameterGeneral,Boolean isEsNuevoRutaTransporte,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-procesarEventosRutaTransportesWithConnection");connexion.begin();			
			
			RutaTransporteParameterReturnGeneral rutatransporteReturnGeneral=new RutaTransporteParameterReturnGeneral();
	
			rutatransporteReturnGeneral.setRutaTransporte(rutatransporte);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rutatransporteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RutaTransporteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rutatransportes,rutatransporte,rutatransporteParameterGeneral,rutatransporteReturnGeneral,isEsNuevoRutaTransporte,clases);
			
			this.connexion.commit();
			
			return rutatransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RutaTransporteParameterReturnGeneral procesarImportacionRutaTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RutaTransporteParameterReturnGeneral rutatransporteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-procesarImportacionRutaTransportesWithConnection");connexion.begin();			
			
			RutaTransporteParameterReturnGeneral rutatransporteReturnGeneral=new RutaTransporteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rutatransportes=new ArrayList<RutaTransporte>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rutatransporte=new RutaTransporte();
				
				
				if(conColumnasBase) {this.rutatransporte.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rutatransporte.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rutatransporte.setnombre(arrColumnas[iColumn++]);
				this.rutatransporte.setorigen(arrColumnas[iColumn++]);
				this.rutatransporte.setdestino(arrColumnas[iColumn++]);
				this.rutatransporte.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.rutatransportes.add(this.rutatransporte);
			}
			
			this.saveRutaTransportes();
			
			this.connexion.commit();
			
			rutatransporteReturnGeneral.setConRetornoEstaProcesado(true);
			rutatransporteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rutatransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRutaTransportesEliminados() throws Exception {				
		
		List<RutaTransporte> rutatransportesAux= new ArrayList<RutaTransporte>();
		
		for(RutaTransporte rutatransporte:rutatransportes) {
			if(!rutatransporte.getIsDeleted()) {
				rutatransportesAux.add(rutatransporte);
			}
		}
		
		rutatransportes=rutatransportesAux;
	}
	
	public void quitarRutaTransportesNulos() throws Exception {				
		
		List<RutaTransporte> rutatransportesAux= new ArrayList<RutaTransporte>();
		
		for(RutaTransporte rutatransporte : this.rutatransportes) {
			if(rutatransporte==null) {
				rutatransportesAux.add(rutatransporte);
			}
		}
		
		//this.rutatransportes=rutatransportesAux;
		
		this.rutatransportes.removeAll(rutatransportesAux);
	}
	
	public void getSetVersionRowRutaTransporteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rutatransporte.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rutatransporte.getIsDeleted() || (rutatransporte.getIsChanged()&&!rutatransporte.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rutatransporteDataAccess.getSetVersionRowRutaTransporte(connexion,rutatransporte.getId());
				
				if(!rutatransporte.getVersionRow().equals(timestamp)) {	
					rutatransporte.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rutatransporte.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRutaTransporte()throws Exception {	
		
		if(rutatransporte.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rutatransporte.getIsDeleted() || (rutatransporte.getIsChanged()&&!rutatransporte.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rutatransporteDataAccess.getSetVersionRowRutaTransporte(connexion,rutatransporte.getId());
			
			try {							
				if(!rutatransporte.getVersionRow().equals(timestamp)) {	
					rutatransporte.setVersionRow(timestamp);
				}
				
				rutatransporte.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRutaTransportesWithConnection()throws Exception {	
		if(rutatransportes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RutaTransporte rutatransporteAux:rutatransportes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rutatransporteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rutatransporteAux.getIsDeleted() || (rutatransporteAux.getIsChanged()&&!rutatransporteAux.getIsNew())) {
						
						timestamp=rutatransporteDataAccess.getSetVersionRowRutaTransporte(connexion,rutatransporteAux.getId());
						
						if(!rutatransporte.getVersionRow().equals(timestamp)) {	
							rutatransporteAux.setVersionRow(timestamp);
						}
								
						rutatransporteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRutaTransportes()throws Exception {	
		if(rutatransportes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RutaTransporte rutatransporteAux:rutatransportes) {
					if(rutatransporteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rutatransporteAux.getIsDeleted() || (rutatransporteAux.getIsChanged()&&!rutatransporteAux.getIsNew())) {
						
						timestamp=rutatransporteDataAccess.getSetVersionRowRutaTransporte(connexion,rutatransporteAux.getId());
						
						if(!rutatransporteAux.getVersionRow().equals(timestamp)) {	
							rutatransporteAux.setVersionRow(timestamp);
						}
						
													
						rutatransporteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RutaTransporteParameterReturnGeneral cargarCombosLoteForeignKeyRutaTransporteWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		RutaTransporteParameterReturnGeneral  rutatransporteReturnGeneral =new RutaTransporteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-cargarCombosLoteForeignKeyRutaTransporteWithConnection");connexion.begin();
			
			rutatransporteReturnGeneral =new RutaTransporteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rutatransporteReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rutatransporteReturnGeneral;
	}
	
	public RutaTransporteParameterReturnGeneral cargarCombosLoteForeignKeyRutaTransporte(String finalQueryGlobalEmpresa) throws Exception {
		RutaTransporteParameterReturnGeneral  rutatransporteReturnGeneral =new RutaTransporteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rutatransporteReturnGeneral =new RutaTransporteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rutatransporteReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rutatransporteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRutaTransporteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProformaLogic proformaLogic=new ProformaLogic();
			PedidoLogic pedidoLogic=new PedidoLogic();
			ServicioTransporteLogic serviciotransporteLogic=new ServicioTransporteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRutaTransporteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Proforma.class));
			classes.add(new Classe(Pedido.class));
			classes.add(new Classe(ServicioTransporte.class));
											
			

			proformaLogic.setConnexion(this.getConnexion());
			proformaLogic.setDatosCliente(this.datosCliente);
			proformaLogic.setIsConRefrescarForeignKeys(true);

			pedidoLogic.setConnexion(this.getConnexion());
			pedidoLogic.setDatosCliente(this.datosCliente);
			pedidoLogic.setIsConRefrescarForeignKeys(true);

			serviciotransporteLogic.setConnexion(this.getConnexion());
			serviciotransporteLogic.setDatosCliente(this.datosCliente);
			serviciotransporteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(RutaTransporte rutatransporte:this.rutatransportes) {
				

				classes=new ArrayList<Classe>();
				classes=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				proformaLogic.setProformas(rutatransporte.proformas);
				proformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoLogic.setPedidos(rutatransporte.pedidos);
				pedidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);

				serviciotransporteLogic.setServicioTransportes(rutatransporte.serviciotransportes);
				serviciotransporteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(RutaTransporte rutatransporte,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RutaTransporteLogicAdditional.updateRutaTransporteToGet(rutatransporte,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rutatransporte.setEmpresa(rutatransporteDataAccess.getEmpresa(connexion,rutatransporte));
		rutatransporte.setProformas(rutatransporteDataAccess.getProformas(connexion,rutatransporte));
		rutatransporte.setPedidos(rutatransporteDataAccess.getPedidos(connexion,rutatransporte));
		rutatransporte.setServicioTransportes(rutatransporteDataAccess.getServicioTransportes(connexion,rutatransporte));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rutatransporte.setEmpresa(rutatransporteDataAccess.getEmpresa(connexion,rutatransporte));
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rutatransporte.setProformas(rutatransporteDataAccess.getProformas(connexion,rutatransporte));

				if(this.isConDeep) {
					ProformaLogic proformaLogic= new ProformaLogic(this.connexion);
					proformaLogic.setProformas(rutatransporte.getProformas());
					ArrayList<Classe> classesLocal=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					proformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformaLogic.getProformas());
					rutatransporte.setProformas(proformaLogic.getProformas());
				}

				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rutatransporte.setPedidos(rutatransporteDataAccess.getPedidos(connexion,rutatransporte));

				if(this.isConDeep) {
					PedidoLogic pedidoLogic= new PedidoLogic(this.connexion);
					pedidoLogic.setPedidos(rutatransporte.getPedidos());
					ArrayList<Classe> classesLocal=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedidoLogic.getPedidos());
					rutatransporte.setPedidos(pedidoLogic.getPedidos());
				}

				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rutatransporte.setServicioTransportes(rutatransporteDataAccess.getServicioTransportes(connexion,rutatransporte));

				if(this.isConDeep) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(this.connexion);
					serviciotransporteLogic.setServicioTransportes(rutatransporte.getServicioTransportes());
					ArrayList<Classe> classesLocal=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);
					serviciotransporteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(serviciotransporteLogic.getServicioTransportes());
					rutatransporte.setServicioTransportes(serviciotransporteLogic.getServicioTransportes());
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
			rutatransporte.setEmpresa(rutatransporteDataAccess.getEmpresa(connexion,rutatransporte));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			rutatransporte.setProformas(rutatransporteDataAccess.getProformas(connexion,rutatransporte));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			rutatransporte.setPedidos(rutatransporteDataAccess.getPedidos(connexion,rutatransporte));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioTransporte.class));
			rutatransporte.setServicioTransportes(rutatransporteDataAccess.getServicioTransportes(connexion,rutatransporte));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rutatransporte.setEmpresa(rutatransporteDataAccess.getEmpresa(connexion,rutatransporte));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rutatransporte.getEmpresa(),isDeep,deepLoadType,clases);
				

		rutatransporte.setProformas(rutatransporteDataAccess.getProformas(connexion,rutatransporte));

		for(Proforma proforma:rutatransporte.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
		}

		rutatransporte.setPedidos(rutatransporteDataAccess.getPedidos(connexion,rutatransporte));

		for(Pedido pedido:rutatransporte.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
		}

		rutatransporte.setServicioTransportes(rutatransporteDataAccess.getServicioTransportes(connexion,rutatransporte));

		for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rutatransporte.setEmpresa(rutatransporteDataAccess.getEmpresa(connexion,rutatransporte));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rutatransporte.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rutatransporte.setProformas(rutatransporteDataAccess.getProformas(connexion,rutatransporte));

				for(Proforma proforma:rutatransporte.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rutatransporte.setPedidos(rutatransporteDataAccess.getPedidos(connexion,rutatransporte));

				for(Pedido pedido:rutatransporte.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rutatransporte.setServicioTransportes(rutatransporteDataAccess.getServicioTransportes(connexion,rutatransporte));

				for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
					serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
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
			rutatransporte.setEmpresa(rutatransporteDataAccess.getEmpresa(connexion,rutatransporte));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rutatransporte.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			rutatransporte.setProformas(rutatransporteDataAccess.getProformas(connexion,rutatransporte));

			for(Proforma proforma:rutatransporte.getProformas()) {
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			rutatransporte.setPedidos(rutatransporteDataAccess.getPedidos(connexion,rutatransporte));

			for(Pedido pedido:rutatransporte.getPedidos()) {
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioTransporte.class));
			rutatransporte.setServicioTransportes(rutatransporteDataAccess.getServicioTransportes(connexion,rutatransporte));

			for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
				ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
				serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RutaTransporte rutatransporte,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RutaTransporteLogicAdditional.updateRutaTransporteToSave(rutatransporte,this.arrDatoGeneral);
			
RutaTransporteDataAccess.save(rutatransporte, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rutatransporte.getEmpresa(),connexion);

		for(Proforma proforma:rutatransporte.getProformas()) {
			proforma.setid_ruta_transporte(rutatransporte.getId());
			ProformaDataAccess.save(proforma,connexion);
		}

		for(Pedido pedido:rutatransporte.getPedidos()) {
			pedido.setid_ruta_transporte(rutatransporte.getId());
			PedidoDataAccess.save(pedido,connexion);
		}

		for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
			serviciotransporte.setid_ruta_transporte(rutatransporte.getId());
			ServicioTransporteDataAccess.save(serviciotransporte,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rutatransporte.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:rutatransporte.getProformas()) {
					proforma.setid_ruta_transporte(rutatransporte.getId());
					ProformaDataAccess.save(proforma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:rutatransporte.getPedidos()) {
					pedido.setid_ruta_transporte(rutatransporte.getId());
					PedidoDataAccess.save(pedido,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
					serviciotransporte.setid_ruta_transporte(rutatransporte.getId());
					ServicioTransporteDataAccess.save(serviciotransporte,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rutatransporte.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rutatransporte.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Proforma proforma:rutatransporte.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proforma.setid_ruta_transporte(rutatransporte.getId());
			ProformaDataAccess.save(proforma,connexion);
			proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
		}

		for(Pedido pedido:rutatransporte.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedido.setid_ruta_transporte(rutatransporte.getId());
			PedidoDataAccess.save(pedido,connexion);
			pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
		}

		for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporte.setid_ruta_transporte(rutatransporte.getId());
			ServicioTransporteDataAccess.save(serviciotransporte,connexion);
			serviciotransporteLogic.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rutatransporte.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rutatransporte.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:rutatransporte.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proforma.setid_ruta_transporte(rutatransporte.getId());
					ProformaDataAccess.save(proforma,connexion);
					proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:rutatransporte.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedido.setid_ruta_transporte(rutatransporte.getId());
					PedidoDataAccess.save(pedido,connexion);
					pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioTransporte serviciotransporte:rutatransporte.getServicioTransportes()) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
					serviciotransporte.setid_ruta_transporte(rutatransporte.getId());
					ServicioTransporteDataAccess.save(serviciotransporte,connexion);
					serviciotransporteLogic.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(RutaTransporte.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rutatransporte,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(rutatransporte);
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
			this.deepLoad(this.rutatransporte,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RutaTransporte.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rutatransportes!=null) {
				for(RutaTransporte rutatransporte:rutatransportes) {
					this.deepLoad(rutatransporte,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(rutatransportes);
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
			if(rutatransportes!=null) {
				for(RutaTransporte rutatransporte:rutatransportes) {
					this.deepLoad(rutatransporte,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(rutatransportes);
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
			this.getNewConnexionToDeep(RutaTransporte.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rutatransporte,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RutaTransporte.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rutatransportes!=null) {
				for(RutaTransporte rutatransporte:rutatransportes) {
					this.deepSave(rutatransporte,isDeep,deepLoadType,clases);
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
			if(rutatransportes!=null) {
				for(RutaTransporte rutatransporte:rutatransportes) {
					this.deepSave(rutatransporte,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRutaTransportesBusquedaPorDestinoWithConnection(String sFinalQuery,Pagination pagination,String destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralDestino.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+destino+"%",RutaTransporteConstantesFunciones.DESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralDestino);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutaTransportesBusquedaPorDestino(String sFinalQuery,Pagination pagination,String destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralDestino.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+destino+"%",RutaTransporteConstantesFunciones.DESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralDestino);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutaTransportesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",RutaTransporteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutaTransportesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",RutaTransporteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutaTransportesBusquedaPorOrigenWithConnection(String sFinalQuery,Pagination pagination,String origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralOrigen.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+origen+"%",RutaTransporteConstantesFunciones.ORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralOrigen);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutaTransportesBusquedaPorOrigen(String sFinalQuery,Pagination pagination,String origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralOrigen.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+origen+"%",RutaTransporteConstantesFunciones.ORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralOrigen);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRutaTransportesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RutaTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RutaTransporteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRutaTransportesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RutaTransporteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RutaTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rutatransportes=rutatransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RutaTransporteConstantesFunciones.refrescarForeignKeysDescripcionesRutaTransporte(this.rutatransportes);
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
			if(RutaTransporteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaTransporteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RutaTransporte rutatransporte,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RutaTransporteConstantesFunciones.ISCONAUDITORIA) {
				if(rutatransporte.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaTransporteDataAccess.TABLENAME, rutatransporte.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RutaTransporteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RutaTransporteLogic.registrarAuditoriaDetallesRutaTransporte(connexion,rutatransporte,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rutatransporte.getIsDeleted()) {
					/*if(!rutatransporte.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RutaTransporteDataAccess.TABLENAME, rutatransporte.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RutaTransporteLogic.registrarAuditoriaDetallesRutaTransporte(connexion,rutatransporte,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaTransporteDataAccess.TABLENAME, rutatransporte.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rutatransporte.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RutaTransporteDataAccess.TABLENAME, rutatransporte.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RutaTransporteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RutaTransporteLogic.registrarAuditoriaDetallesRutaTransporte(connexion,rutatransporte,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRutaTransporte(Connexion connexion,RutaTransporte rutatransporte)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rutatransporte.getIsNew()||!rutatransporte.getid_empresa().equals(rutatransporte.getRutaTransporteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rutatransporte.getRutaTransporteOriginal().getid_empresa()!=null)
				{
					strValorActual=rutatransporte.getRutaTransporteOriginal().getid_empresa().toString();
				}
				if(rutatransporte.getid_empresa()!=null)
				{
					strValorNuevo=rutatransporte.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaTransporteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rutatransporte.getIsNew()||!rutatransporte.getnombre().equals(rutatransporte.getRutaTransporteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rutatransporte.getRutaTransporteOriginal().getnombre()!=null)
				{
					strValorActual=rutatransporte.getRutaTransporteOriginal().getnombre();
				}
				if(rutatransporte.getnombre()!=null)
				{
					strValorNuevo=rutatransporte.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaTransporteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(rutatransporte.getIsNew()||!rutatransporte.getorigen().equals(rutatransporte.getRutaTransporteOriginal().getorigen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rutatransporte.getRutaTransporteOriginal().getorigen()!=null)
				{
					strValorActual=rutatransporte.getRutaTransporteOriginal().getorigen();
				}
				if(rutatransporte.getorigen()!=null)
				{
					strValorNuevo=rutatransporte.getorigen() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaTransporteConstantesFunciones.ORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(rutatransporte.getIsNew()||!rutatransporte.getdestino().equals(rutatransporte.getRutaTransporteOriginal().getdestino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rutatransporte.getRutaTransporteOriginal().getdestino()!=null)
				{
					strValorActual=rutatransporte.getRutaTransporteOriginal().getdestino();
				}
				if(rutatransporte.getdestino()!=null)
				{
					strValorNuevo=rutatransporte.getdestino() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaTransporteConstantesFunciones.DESTINO,strValorActual,strValorNuevo);
			}	
			
			if(rutatransporte.getIsNew()||!rutatransporte.getprecio().equals(rutatransporte.getRutaTransporteOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rutatransporte.getRutaTransporteOriginal().getprecio()!=null)
				{
					strValorActual=rutatransporte.getRutaTransporteOriginal().getprecio().toString();
				}
				if(rutatransporte.getprecio()!=null)
				{
					strValorNuevo=rutatransporte.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RutaTransporteConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRutaTransporteRelacionesWithConnection(RutaTransporte rutatransporte,List<Proforma> proformas,List<Pedido> pedidos,List<ServicioTransporte> serviciotransportes) throws Exception {

		if(!rutatransporte.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRutaTransporteRelacionesBase(rutatransporte,proformas,pedidos,serviciotransportes,true);
		}
	}

	public void saveRutaTransporteRelaciones(RutaTransporte rutatransporte,List<Proforma> proformas,List<Pedido> pedidos,List<ServicioTransporte> serviciotransportes)throws Exception {

		if(!rutatransporte.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRutaTransporteRelacionesBase(rutatransporte,proformas,pedidos,serviciotransportes,false);
		}
	}

	public void saveRutaTransporteRelacionesBase(RutaTransporte rutatransporte,List<Proforma> proformas,List<Pedido> pedidos,List<ServicioTransporte> serviciotransportes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RutaTransporte-saveRelacionesWithConnection");}
	
			rutatransporte.setProformas(proformas);
			rutatransporte.setPedidos(pedidos);
			rutatransporte.setServicioTransportes(serviciotransportes);

			this.setRutaTransporte(rutatransporte);

			if(RutaTransporteLogicAdditional.validarSaveRelaciones(rutatransporte,this)) {

				RutaTransporteLogicAdditional.updateRelacionesToSave(rutatransporte,this);

				if((rutatransporte.getIsNew()||rutatransporte.getIsChanged())&&!rutatransporte.getIsDeleted()) {
					this.saveRutaTransporte();
					this.saveRutaTransporteRelacionesDetalles(proformas,pedidos,serviciotransportes);

				} else if(rutatransporte.getIsDeleted()) {
					this.saveRutaTransporteRelacionesDetalles(proformas,pedidos,serviciotransportes);
					this.saveRutaTransporte();
				}

				RutaTransporteLogicAdditional.updateRelacionesToSaveAfter(rutatransporte,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresProformas(proformas,true,true);
			PedidoConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidos(pedidos,true,true);
			ServicioTransporteConstantesFunciones.InicializarGeneralEntityAuxiliaresServicioTransportes(serviciotransportes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRutaTransporteRelacionesDetalles(List<Proforma> proformas,List<Pedido> pedidos,List<ServicioTransporte> serviciotransportes)throws Exception {
		try {
	

			Long idRutaTransporteActual=this.getRutaTransporte().getId();

			ProformaLogic proformaLogic_Desde_RutaTransporte=new ProformaLogic();
			proformaLogic_Desde_RutaTransporte.setProformas(proformas);

			proformaLogic_Desde_RutaTransporte.setConnexion(this.getConnexion());
			proformaLogic_Desde_RutaTransporte.setDatosCliente(this.datosCliente);

			for(Proforma proforma_Desde_RutaTransporte:proformaLogic_Desde_RutaTransporte.getProformas()) {
				proforma_Desde_RutaTransporte.setid_ruta_transporte(idRutaTransporteActual);

				proformaLogic_Desde_RutaTransporte.setProforma(proforma_Desde_RutaTransporte);
				proformaLogic_Desde_RutaTransporte.saveProforma();

				Long idProformaActual=proforma_Desde_RutaTransporte.getId();

				TerminoProformaLogic terminoproformaLogic_Desde_Proforma=new TerminoProformaLogic();

				if(proforma_Desde_RutaTransporte.getTerminoProformas()==null){
					proforma_Desde_RutaTransporte.setTerminoProformas(new ArrayList<TerminoProforma>());
				}

				terminoproformaLogic_Desde_Proforma.setTerminoProformas(proforma_Desde_RutaTransporte.getTerminoProformas());

				terminoproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				terminoproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(TerminoProforma terminoproforma_Desde_Proforma:terminoproformaLogic_Desde_Proforma.getTerminoProformas()) {
					terminoproforma_Desde_Proforma.setid_proforma(idProformaActual);

					terminoproformaLogic_Desde_Proforma.setTerminoProforma(terminoproforma_Desde_Proforma);
					terminoproformaLogic_Desde_Proforma.saveTerminoProforma();

					Long idTerminoProformaActual=terminoproforma_Desde_Proforma.getId();

					DetalleTerminoProformaLogic detalleterminoproformaLogic_Desde_TerminoProforma=new DetalleTerminoProformaLogic();

					if(terminoproforma_Desde_Proforma.getDetalleTerminoProformas()==null){
						terminoproforma_Desde_Proforma.setDetalleTerminoProformas(new ArrayList<DetalleTerminoProforma>());
					}

					detalleterminoproformaLogic_Desde_TerminoProforma.setDetalleTerminoProformas(terminoproforma_Desde_Proforma.getDetalleTerminoProformas());

					detalleterminoproformaLogic_Desde_TerminoProforma.setConnexion(this.getConnexion());
					detalleterminoproformaLogic_Desde_TerminoProforma.setDatosCliente(this.datosCliente);

					for(DetalleTerminoProforma detalleterminoproforma_Desde_TerminoProforma:detalleterminoproformaLogic_Desde_TerminoProforma.getDetalleTerminoProformas()) {
						detalleterminoproforma_Desde_TerminoProforma.setid_termino_proforma(idTerminoProformaActual);
					}

					detalleterminoproformaLogic_Desde_TerminoProforma.saveDetalleTerminoProformas();
				}


				DetalleProformaLogic detalleproformaLogic_Desde_Proforma=new DetalleProformaLogic();

				if(proforma_Desde_RutaTransporte.getDetalleProformas()==null){
					proforma_Desde_RutaTransporte.setDetalleProformas(new ArrayList<DetalleProforma>());
				}

				detalleproformaLogic_Desde_Proforma.setDetalleProformas(proforma_Desde_RutaTransporte.getDetalleProformas());

				detalleproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				detalleproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(DetalleProforma detalleproforma_Desde_Proforma:detalleproformaLogic_Desde_Proforma.getDetalleProformas()) {
					detalleproforma_Desde_Proforma.setid_proforma(idProformaActual);
				}

				detalleproformaLogic_Desde_Proforma.saveDetalleProformas();
			}


			PedidoLogic pedidoLogic_Desde_RutaTransporte=new PedidoLogic();
			pedidoLogic_Desde_RutaTransporte.setPedidos(pedidos);

			pedidoLogic_Desde_RutaTransporte.setConnexion(this.getConnexion());
			pedidoLogic_Desde_RutaTransporte.setDatosCliente(this.datosCliente);

			for(Pedido pedido_Desde_RutaTransporte:pedidoLogic_Desde_RutaTransporte.getPedidos()) {
				pedido_Desde_RutaTransporte.setid_ruta_transporte(idRutaTransporteActual);

				pedidoLogic_Desde_RutaTransporte.setPedido(pedido_Desde_RutaTransporte);
				pedidoLogic_Desde_RutaTransporte.savePedido();

				Long idPedidoActual=pedido_Desde_RutaTransporte.getId();

				DetallePedidoLogic detallepedidoLogic_Desde_Pedido=new DetallePedidoLogic();

				if(pedido_Desde_RutaTransporte.getDetallePedidos()==null){
					pedido_Desde_RutaTransporte.setDetallePedidos(new ArrayList<DetallePedido>());
				}

				detallepedidoLogic_Desde_Pedido.setDetallePedidos(pedido_Desde_RutaTransporte.getDetallePedidos());

				detallepedidoLogic_Desde_Pedido.setConnexion(this.getConnexion());
				detallepedidoLogic_Desde_Pedido.setDatosCliente(this.datosCliente);

				for(DetallePedido detallepedido_Desde_Pedido:detallepedidoLogic_Desde_Pedido.getDetallePedidos()) {
					detallepedido_Desde_Pedido.setid_pedido(idPedidoActual);
				}

				detallepedidoLogic_Desde_Pedido.saveDetallePedidos();
			}


			ServicioTransporteLogic serviciotransporteLogic_Desde_RutaTransporte=new ServicioTransporteLogic();
			serviciotransporteLogic_Desde_RutaTransporte.setServicioTransportes(serviciotransportes);

			serviciotransporteLogic_Desde_RutaTransporte.setConnexion(this.getConnexion());
			serviciotransporteLogic_Desde_RutaTransporte.setDatosCliente(this.datosCliente);

			for(ServicioTransporte serviciotransporte_Desde_RutaTransporte:serviciotransporteLogic_Desde_RutaTransporte.getServicioTransportes()) {
				serviciotransporte_Desde_RutaTransporte.setid_ruta_transporte(idRutaTransporteActual);

				serviciotransporteLogic_Desde_RutaTransporte.setServicioTransporte(serviciotransporte_Desde_RutaTransporte);
				serviciotransporteLogic_Desde_RutaTransporte.saveServicioTransporte();

				Long idServicioTransporteActual=serviciotransporte_Desde_RutaTransporte.getId();

				DetalleServicioTransporteLogic detalleserviciotransporteLogic_Desde_ServicioTransporte=new DetalleServicioTransporteLogic();

				if(serviciotransporte_Desde_RutaTransporte.getDetalleServicioTransportes()==null){
					serviciotransporte_Desde_RutaTransporte.setDetalleServicioTransportes(new ArrayList<DetalleServicioTransporte>());
				}

				detalleserviciotransporteLogic_Desde_ServicioTransporte.setDetalleServicioTransportes(serviciotransporte_Desde_RutaTransporte.getDetalleServicioTransportes());

				detalleserviciotransporteLogic_Desde_ServicioTransporte.setConnexion(this.getConnexion());
				detalleserviciotransporteLogic_Desde_ServicioTransporte.setDatosCliente(this.datosCliente);

				for(DetalleServicioTransporte detalleserviciotransporte_Desde_ServicioTransporte:detalleserviciotransporteLogic_Desde_ServicioTransporte.getDetalleServicioTransportes()) {
					detalleserviciotransporte_Desde_ServicioTransporte.setid_servicio_transporte(idServicioTransporteActual);
				}

				detalleserviciotransporteLogic_Desde_ServicioTransporte.saveDetalleServicioTransportes();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRutaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RutaTransporteConstantesFunciones.getClassesForeignKeysOfRutaTransporte(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRutaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RutaTransporteConstantesFunciones.getClassesRelationshipsOfRutaTransporte(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
