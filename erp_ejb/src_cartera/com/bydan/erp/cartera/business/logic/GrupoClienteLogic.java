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
import com.bydan.erp.cartera.util.GrupoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.GrupoClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.GrupoClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.GrupoCliente;
import com.bydan.erp.cartera.business.logic.GrupoClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
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
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
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
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
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
public class GrupoClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GrupoClienteLogic.class);
	
	protected GrupoClienteDataAccess grupoclienteDataAccess; 	
	protected GrupoCliente grupocliente;
	protected List<GrupoCliente> grupoclientes;
	protected Object grupoclienteObject;	
	protected List<Object> grupoclientesObject;
	
	public static ClassValidator<GrupoCliente> grupoclienteValidator = new ClassValidator<GrupoCliente>(GrupoCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GrupoClienteLogicAdditional grupoclienteLogicAdditional=null;
	
	public GrupoClienteLogicAdditional getGrupoClienteLogicAdditional() {
		return this.grupoclienteLogicAdditional;
	}
	
	public void setGrupoClienteLogicAdditional(GrupoClienteLogicAdditional grupoclienteLogicAdditional) {
		try {
			this.grupoclienteLogicAdditional=grupoclienteLogicAdditional;
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
	
	
	
	
	public  GrupoClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.grupoclienteDataAccess = new GrupoClienteDataAccess();
			
			this.grupoclientes= new ArrayList<GrupoCliente>();
			this.grupocliente= new GrupoCliente();
			
			this.grupoclienteObject=new Object();
			this.grupoclientesObject=new ArrayList<Object>();
				
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
			
			this.grupoclienteDataAccess.setConnexionType(this.connexionType);
			this.grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GrupoClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.grupoclienteDataAccess = new GrupoClienteDataAccess();
			this.grupoclientes= new ArrayList<GrupoCliente>();
			this.grupocliente= new GrupoCliente();
			this.grupoclienteObject=new Object();
			this.grupoclientesObject=new ArrayList<Object>();
			
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
			
			this.grupoclienteDataAccess.setConnexionType(this.connexionType);
			this.grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GrupoCliente getGrupoCliente() throws Exception {	
		GrupoClienteLogicAdditional.checkGrupoClienteToGet(grupocliente,this.datosCliente,this.arrDatoGeneral);
		GrupoClienteLogicAdditional.updateGrupoClienteToGet(grupocliente,this.arrDatoGeneral);
		
		return grupocliente;
	}
		
	public void setGrupoCliente(GrupoCliente newGrupoCliente) {
		this.grupocliente = newGrupoCliente;
	}
	
	public GrupoClienteDataAccess getGrupoClienteDataAccess() {
		return grupoclienteDataAccess;
	}
	
	public void setGrupoClienteDataAccess(GrupoClienteDataAccess newgrupoclienteDataAccess) {
		this.grupoclienteDataAccess = newgrupoclienteDataAccess;
	}
	
	public List<GrupoCliente> getGrupoClientes() throws Exception {		
		this.quitarGrupoClientesNulos();
		
		GrupoClienteLogicAdditional.checkGrupoClienteToGets(grupoclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (GrupoCliente grupoclienteLocal: grupoclientes ) {
			GrupoClienteLogicAdditional.updateGrupoClienteToGet(grupoclienteLocal,this.arrDatoGeneral);
		}
		
		return grupoclientes;
	}
	
	public void setGrupoClientes(List<GrupoCliente> newGrupoClientes) {
		this.grupoclientes = newGrupoClientes;
	}
	
	public Object getGrupoClienteObject() {	
		this.grupoclienteObject=this.grupoclienteDataAccess.getEntityObject();
		return this.grupoclienteObject;
	}
		
	public void setGrupoClienteObject(Object newGrupoClienteObject) {
		this.grupoclienteObject = newGrupoClienteObject;
	}
	
	public List<Object> getGrupoClientesObject() {		
		this.grupoclientesObject=this.grupoclienteDataAccess.getEntitiesObject();
		return this.grupoclientesObject;
	}
		
	public void setGrupoClientesObject(List<Object> newGrupoClientesObject) {
		this.grupoclientesObject = newGrupoClientesObject;
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
		
		if(this.grupoclienteDataAccess!=null) {
			this.grupoclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			grupoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			grupoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		grupocliente = new  GrupoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupocliente=grupoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
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
		grupocliente = new  GrupoCliente();
		  		  
        try {
			
			grupocliente=grupoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		grupocliente = new  GrupoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupocliente=grupoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
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
		grupocliente = new  GrupoCliente();
		  		  
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
		grupocliente = new  GrupoCliente();
		  		  
        try {
			
			grupocliente=grupoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		grupocliente = new  GrupoCliente();
		  		  
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
		grupocliente = new  GrupoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =grupoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupocliente = new  GrupoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=grupoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupocliente = new  GrupoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =grupoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupocliente = new  GrupoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=grupoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupocliente = new  GrupoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =grupoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupocliente = new  GrupoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=grupoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
        try {			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
        try {
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		grupocliente = new  GrupoCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocliente=grupoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
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
		grupocliente = new  GrupoCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupocliente=grupoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
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
		grupoclientes = new  ArrayList<GrupoCliente>();
		  		  
        try {
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGrupoClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		grupoclientes = new  ArrayList<GrupoCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getTodosGrupoClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
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
	
	public  void  getTodosGrupoClientes(String sFinalQuery,Pagination pagination)throws Exception {
		grupoclientes = new  ArrayList<GrupoCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoCliente(grupoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGrupoCliente(GrupoCliente grupocliente) throws Exception {
		Boolean estaValidado=false;
		
		if(grupocliente.getIsNew() || grupocliente.getIsChanged()) { 
			this.invalidValues = grupoclienteValidator.getInvalidValues(grupocliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(grupocliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGrupoCliente(List<GrupoCliente> GrupoClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GrupoCliente grupoclienteLocal:grupoclientes) {				
			estaValidadoObjeto=this.validarGuardarGrupoCliente(grupoclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGrupoCliente(List<GrupoCliente> GrupoClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoCliente(grupoclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGrupoCliente(GrupoCliente GrupoCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoCliente(grupocliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GrupoCliente grupocliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+grupocliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GrupoClienteConstantesFunciones.getGrupoClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"grupocliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GrupoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GrupoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGrupoClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-saveGrupoClienteWithConnection");connexion.begin();			
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSave(this.grupocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoClienteLogicAdditional.updateGrupoClienteToSave(this.grupocliente,this.arrDatoGeneral);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGrupoCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoCliente(this.grupocliente)) {
				GrupoClienteDataAccess.save(this.grupocliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSaveAfter(this.grupocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoCliente();
			
			connexion.commit();			
			
			if(this.grupocliente.getIsDeleted()) {
				this.grupocliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGrupoCliente()throws Exception {	
		try {	
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSave(this.grupocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoClienteLogicAdditional.updateGrupoClienteToSave(this.grupocliente,this.arrDatoGeneral);
			
			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoCliente(this.grupocliente)) {			
				GrupoClienteDataAccess.save(this.grupocliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSaveAfter(this.grupocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.grupocliente.getIsDeleted()) {
				this.grupocliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGrupoClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-saveGrupoClientesWithConnection");connexion.begin();			
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSaves(grupoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGrupoClientes();
			
			Boolean validadoTodosGrupoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoCliente grupoclienteLocal:grupoclientes) {		
				if(grupoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoClienteLogicAdditional.updateGrupoClienteToSave(grupoclienteLocal,this.arrDatoGeneral);
	        	
				GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoCliente(grupoclienteLocal)) {
					GrupoClienteDataAccess.save(grupoclienteLocal, connexion);				
				} else {
					validadoTodosGrupoCliente=false;
				}
			}
			
			if(!validadoTodosGrupoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSavesAfter(grupoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoClientes();
			
			connexion.commit();		
			
			this.quitarGrupoClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGrupoClientes()throws Exception {				
		 try {	
			GrupoClienteLogicAdditional.checkGrupoClienteToSaves(grupoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGrupoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoCliente grupoclienteLocal:grupoclientes) {				
				if(grupoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoClienteLogicAdditional.updateGrupoClienteToSave(grupoclienteLocal,this.arrDatoGeneral);
	        	
				GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoCliente(grupoclienteLocal)) {				
					GrupoClienteDataAccess.save(grupoclienteLocal, connexion);				
				} else {
					validadoTodosGrupoCliente=false;
				}
			}
			
			if(!validadoTodosGrupoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoClienteLogicAdditional.checkGrupoClienteToSavesAfter(grupoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGrupoClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoClienteParameterReturnGeneral procesarAccionGrupoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoCliente> grupoclientes,GrupoClienteParameterReturnGeneral grupoclienteParameterGeneral)throws Exception {
		 try {	
			GrupoClienteParameterReturnGeneral grupoclienteReturnGeneral=new GrupoClienteParameterReturnGeneral();
	
			GrupoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupoclientes,grupoclienteParameterGeneral,grupoclienteReturnGeneral);
			
			return grupoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoClienteParameterReturnGeneral procesarAccionGrupoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoCliente> grupoclientes,GrupoClienteParameterReturnGeneral grupoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-procesarAccionGrupoClientesWithConnection");connexion.begin();			
			
			GrupoClienteParameterReturnGeneral grupoclienteReturnGeneral=new GrupoClienteParameterReturnGeneral();
	
			GrupoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupoclientes,grupoclienteParameterGeneral,grupoclienteReturnGeneral);
			
			this.connexion.commit();
			
			return grupoclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoClienteParameterReturnGeneral procesarEventosGrupoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoCliente> grupoclientes,GrupoCliente grupocliente,GrupoClienteParameterReturnGeneral grupoclienteParameterGeneral,Boolean isEsNuevoGrupoCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			GrupoClienteParameterReturnGeneral grupoclienteReturnGeneral=new GrupoClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupoclientes,grupocliente,grupoclienteParameterGeneral,grupoclienteReturnGeneral,isEsNuevoGrupoCliente,clases);
			
			return grupoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GrupoClienteParameterReturnGeneral procesarEventosGrupoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoCliente> grupoclientes,GrupoCliente grupocliente,GrupoClienteParameterReturnGeneral grupoclienteParameterGeneral,Boolean isEsNuevoGrupoCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-procesarEventosGrupoClientesWithConnection");connexion.begin();			
			
			GrupoClienteParameterReturnGeneral grupoclienteReturnGeneral=new GrupoClienteParameterReturnGeneral();
	
			grupoclienteReturnGeneral.setGrupoCliente(grupocliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupoclientes,grupocliente,grupoclienteParameterGeneral,grupoclienteReturnGeneral,isEsNuevoGrupoCliente,clases);
			
			this.connexion.commit();
			
			return grupoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoClienteParameterReturnGeneral procesarImportacionGrupoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GrupoClienteParameterReturnGeneral grupoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-procesarImportacionGrupoClientesWithConnection");connexion.begin();			
			
			GrupoClienteParameterReturnGeneral grupoclienteReturnGeneral=new GrupoClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.grupoclientes=new ArrayList<GrupoCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.grupocliente=new GrupoCliente();
				
				
				if(conColumnasBase) {this.grupocliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.grupocliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.grupocliente.setcodigo(arrColumnas[iColumn++]);
				this.grupocliente.setnombre(arrColumnas[iColumn++]);
				this.grupocliente.setsiglas(arrColumnas[iColumn++]);
				this.grupocliente.setsecuencial(arrColumnas[iColumn++]);
			this.grupocliente.setdescripcion(arrColumnas[iColumn++]);
				this.grupocliente.setes_prove(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.grupoclientes.add(this.grupocliente);
			}
			
			this.saveGrupoClientes();
			
			this.connexion.commit();
			
			grupoclienteReturnGeneral.setConRetornoEstaProcesado(true);
			grupoclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return grupoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGrupoClientesEliminados() throws Exception {				
		
		List<GrupoCliente> grupoclientesAux= new ArrayList<GrupoCliente>();
		
		for(GrupoCliente grupocliente:grupoclientes) {
			if(!grupocliente.getIsDeleted()) {
				grupoclientesAux.add(grupocliente);
			}
		}
		
		grupoclientes=grupoclientesAux;
	}
	
	public void quitarGrupoClientesNulos() throws Exception {				
		
		List<GrupoCliente> grupoclientesAux= new ArrayList<GrupoCliente>();
		
		for(GrupoCliente grupocliente : this.grupoclientes) {
			if(grupocliente==null) {
				grupoclientesAux.add(grupocliente);
			}
		}
		
		//this.grupoclientes=grupoclientesAux;
		
		this.grupoclientes.removeAll(grupoclientesAux);
	}
	
	public void getSetVersionRowGrupoClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(grupocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((grupocliente.getIsDeleted() || (grupocliente.getIsChanged()&&!grupocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=grupoclienteDataAccess.getSetVersionRowGrupoCliente(connexion,grupocliente.getId());
				
				if(!grupocliente.getVersionRow().equals(timestamp)) {	
					grupocliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				grupocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGrupoCliente()throws Exception {	
		
		if(grupocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((grupocliente.getIsDeleted() || (grupocliente.getIsChanged()&&!grupocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=grupoclienteDataAccess.getSetVersionRowGrupoCliente(connexion,grupocliente.getId());
			
			try {							
				if(!grupocliente.getVersionRow().equals(timestamp)) {	
					grupocliente.setVersionRow(timestamp);
				}
				
				grupocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGrupoClientesWithConnection()throws Exception {	
		if(grupoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GrupoCliente grupoclienteAux:grupoclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(grupoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoclienteAux.getIsDeleted() || (grupoclienteAux.getIsChanged()&&!grupoclienteAux.getIsNew())) {
						
						timestamp=grupoclienteDataAccess.getSetVersionRowGrupoCliente(connexion,grupoclienteAux.getId());
						
						if(!grupocliente.getVersionRow().equals(timestamp)) {	
							grupoclienteAux.setVersionRow(timestamp);
						}
								
						grupoclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGrupoClientes()throws Exception {	
		if(grupoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GrupoCliente grupoclienteAux:grupoclientes) {
					if(grupoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoclienteAux.getIsDeleted() || (grupoclienteAux.getIsChanged()&&!grupoclienteAux.getIsNew())) {
						
						timestamp=grupoclienteDataAccess.getSetVersionRowGrupoCliente(connexion,grupoclienteAux.getId());
						
						if(!grupoclienteAux.getVersionRow().equals(timestamp)) {	
							grupoclienteAux.setVersionRow(timestamp);
						}
						
													
						grupoclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GrupoClienteParameterReturnGeneral cargarCombosLoteForeignKeyGrupoClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroCosto) throws Exception {
		GrupoClienteParameterReturnGeneral  grupoclienteReturnGeneral =new GrupoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyGrupoClienteWithConnection");connexion.begin();
			
			grupoclienteReturnGeneral =new GrupoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			grupoclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			grupoclienteReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			grupoclienteReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return grupoclienteReturnGeneral;
	}
	
	public GrupoClienteParameterReturnGeneral cargarCombosLoteForeignKeyGrupoCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroCosto) throws Exception {
		GrupoClienteParameterReturnGeneral  grupoclienteReturnGeneral =new GrupoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			grupoclienteReturnGeneral =new GrupoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			grupoclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			grupoclienteReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			grupoclienteReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return grupoclienteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGrupoClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic=new GrupoClienteFormaPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGrupoClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(GrupoClienteFormaPago.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			grupoclienteformapagoLogic.setConnexion(this.getConnexion());
			grupoclienteformapagoLogic.setDatosCliente(this.datosCliente);
			grupoclienteformapagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GrupoCliente grupocliente:this.grupoclientes) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(grupocliente.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GrupoClienteFormaPagoConstantesFunciones.getClassesForeignKeysOfGrupoClienteFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				grupoclienteformapagoLogic.setGrupoClienteFormaPagos(grupocliente.grupoclienteformapagos);
				grupoclienteformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GrupoCliente grupocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GrupoClienteLogicAdditional.updateGrupoClienteToGet(grupocliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupocliente.setEmpresa(grupoclienteDataAccess.getEmpresa(connexion,grupocliente));
		grupocliente.setModulo(grupoclienteDataAccess.getModulo(connexion,grupocliente));
		grupocliente.setCuentaContable(grupoclienteDataAccess.getCuentaContable(connexion,grupocliente));
		grupocliente.setCentroCosto(grupoclienteDataAccess.getCentroCosto(connexion,grupocliente));
		grupocliente.setClientes(grupoclienteDataAccess.getClientes(connexion,grupocliente));
		grupocliente.setGrupoClienteFormaPagos(grupoclienteDataAccess.getGrupoClienteFormaPagos(connexion,grupocliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupocliente.setEmpresa(grupoclienteDataAccess.getEmpresa(connexion,grupocliente));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				grupocliente.setModulo(grupoclienteDataAccess.getModulo(connexion,grupocliente));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupocliente.setCuentaContable(grupoclienteDataAccess.getCuentaContable(connexion,grupocliente));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				grupocliente.setCentroCosto(grupoclienteDataAccess.getCentroCosto(connexion,grupocliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupocliente.setClientes(grupoclienteDataAccess.getClientes(connexion,grupocliente));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(grupocliente.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					grupocliente.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupocliente.setGrupoClienteFormaPagos(grupoclienteDataAccess.getGrupoClienteFormaPagos(connexion,grupocliente));

				if(this.isConDeep) {
					GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(this.connexion);
					grupoclienteformapagoLogic.setGrupoClienteFormaPagos(grupocliente.getGrupoClienteFormaPagos());
					ArrayList<Classe> classesLocal=GrupoClienteFormaPagoConstantesFunciones.getClassesForeignKeysOfGrupoClienteFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					grupoclienteformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(grupoclienteformapagoLogic.getGrupoClienteFormaPagos());
					grupocliente.setGrupoClienteFormaPagos(grupoclienteformapagoLogic.getGrupoClienteFormaPagos());
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
			grupocliente.setEmpresa(grupoclienteDataAccess.getEmpresa(connexion,grupocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocliente.setModulo(grupoclienteDataAccess.getModulo(connexion,grupocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocliente.setCuentaContable(grupoclienteDataAccess.getCuentaContable(connexion,grupocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocliente.setCentroCosto(grupoclienteDataAccess.getCentroCosto(connexion,grupocliente));
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
			grupocliente.setClientes(grupoclienteDataAccess.getClientes(connexion,grupocliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GrupoClienteFormaPago.class));
			grupocliente.setGrupoClienteFormaPagos(grupoclienteDataAccess.getGrupoClienteFormaPagos(connexion,grupocliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupocliente.setEmpresa(grupoclienteDataAccess.getEmpresa(connexion,grupocliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		grupocliente.setModulo(grupoclienteDataAccess.getModulo(connexion,grupocliente));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(grupocliente.getModulo(),isDeep,deepLoadType,clases);
				
		grupocliente.setCuentaContable(grupoclienteDataAccess.getCuentaContable(connexion,grupocliente));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(grupocliente.getCuentaContable(),isDeep,deepLoadType,clases);
				
		grupocliente.setCentroCosto(grupoclienteDataAccess.getCentroCosto(connexion,grupocliente));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(grupocliente.getCentroCosto(),isDeep,deepLoadType,clases);
				

		grupocliente.setClientes(grupoclienteDataAccess.getClientes(connexion,grupocliente));

		for(Cliente cliente:grupocliente.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		grupocliente.setGrupoClienteFormaPagos(grupoclienteDataAccess.getGrupoClienteFormaPagos(connexion,grupocliente));

		for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
			grupoclienteformapagoLogic.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupocliente.setEmpresa(grupoclienteDataAccess.getEmpresa(connexion,grupocliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(grupocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				grupocliente.setModulo(grupoclienteDataAccess.getModulo(connexion,grupocliente));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(grupocliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupocliente.setCuentaContable(grupoclienteDataAccess.getCuentaContable(connexion,grupocliente));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupocliente.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				grupocliente.setCentroCosto(grupoclienteDataAccess.getCentroCosto(connexion,grupocliente));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(grupocliente.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupocliente.setClientes(grupoclienteDataAccess.getClientes(connexion,grupocliente));

				for(Cliente cliente:grupocliente.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupocliente.setGrupoClienteFormaPagos(grupoclienteDataAccess.getGrupoClienteFormaPagos(connexion,grupocliente));

				for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
					GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
					grupoclienteformapagoLogic.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
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
			grupocliente.setEmpresa(grupoclienteDataAccess.getEmpresa(connexion,grupocliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(grupocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocliente.setModulo(grupoclienteDataAccess.getModulo(connexion,grupocliente));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(grupocliente.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocliente.setCuentaContable(grupoclienteDataAccess.getCuentaContable(connexion,grupocliente));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupocliente.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupocliente.setCentroCosto(grupoclienteDataAccess.getCentroCosto(connexion,grupocliente));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(grupocliente.getCentroCosto(),isDeep,deepLoadType,clases);
				
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
			grupocliente.setClientes(grupoclienteDataAccess.getClientes(connexion,grupocliente));

			for(Cliente cliente:grupocliente.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GrupoClienteFormaPago.class));
			grupocliente.setGrupoClienteFormaPagos(grupoclienteDataAccess.getGrupoClienteFormaPagos(connexion,grupocliente));

			for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
				GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
				grupoclienteformapagoLogic.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GrupoCliente grupocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GrupoClienteLogicAdditional.updateGrupoClienteToSave(grupocliente,this.arrDatoGeneral);
			
GrupoClienteDataAccess.save(grupocliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupocliente.getEmpresa(),connexion);

		ModuloDataAccess.save(grupocliente.getModulo(),connexion);

		CuentaContableDataAccess.save(grupocliente.getCuentaContable(),connexion);

		CentroCostoDataAccess.save(grupocliente.getCentroCosto(),connexion);

		for(Cliente cliente:grupocliente.getClientes()) {
			cliente.setid_grupo_cliente(grupocliente.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
			grupoclienteformapago.setid_grupo_cliente(grupocliente.getId());
			GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupocliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(grupocliente.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupocliente.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(grupocliente.getCentroCosto(),connexion);
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:grupocliente.getClientes()) {
					cliente.setid_grupo_cliente(grupocliente.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
					grupoclienteformapago.setid_grupo_cliente(grupocliente.getId());
					GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupocliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupocliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(grupocliente.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(grupocliente.getModulo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupocliente.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(grupocliente.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(grupocliente.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(grupocliente.getCentroCosto(),isDeep,deepLoadType,clases);
				

		for(Cliente cliente:grupocliente.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_grupo_cliente(grupocliente.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
			grupoclienteformapago.setid_grupo_cliente(grupocliente.getId());
			GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
			grupoclienteformapagoLogic.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupocliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(grupocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(grupocliente.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(grupocliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupocliente.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupocliente.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(grupocliente.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(grupocliente.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:grupocliente.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_grupo_cliente(grupocliente.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GrupoClienteFormaPago grupoclienteformapago:grupocliente.getGrupoClienteFormaPagos()) {
					GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
					grupoclienteformapago.setid_grupo_cliente(grupocliente.getId());
					GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
					grupoclienteformapagoLogic.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(GrupoCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(grupocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(grupocliente);
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
			this.deepLoad(this.grupocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(grupoclientes!=null) {
				for(GrupoCliente grupocliente:grupoclientes) {
					this.deepLoad(grupocliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(grupoclientes);
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
			if(grupoclientes!=null) {
				for(GrupoCliente grupocliente:grupoclientes) {
					this.deepLoad(grupocliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(grupoclientes);
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
			this.getNewConnexionToDeep(GrupoCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(grupocliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GrupoCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(grupoclientes!=null) {
				for(GrupoCliente grupocliente:grupoclientes) {
					this.deepSave(grupocliente,isDeep,deepLoadType,clases);
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
			if(grupoclientes!=null) {
				for(GrupoCliente grupocliente:grupoclientes) {
					this.deepSave(grupocliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGrupoClientesBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",GrupoClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",GrupoClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientesBusquedaPorSiglasWithConnection(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",GrupoClienteConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesBusquedaPorSiglas(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",GrupoClienteConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientesFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,GrupoClienteConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,GrupoClienteConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,GrupoClienteConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,GrupoClienteConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			GrupoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClientePorEmpresaPorCodigoWithConnection(Long id_empresa,String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,GrupoClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClientePorEmpresaPorCodigo(Long id_empresa,String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,GrupoClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.grupocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				GrupoClienteConstantesFunciones.refrescarForeignKeysDescripcionesGrupoCliente(this.grupocliente);
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
			if(GrupoClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GrupoCliente grupocliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GrupoClienteConstantesFunciones.ISCONAUDITORIA) {
				if(grupocliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteDataAccess.TABLENAME, grupocliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoClienteLogic.registrarAuditoriaDetallesGrupoCliente(connexion,grupocliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(grupocliente.getIsDeleted()) {
					/*if(!grupocliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GrupoClienteDataAccess.TABLENAME, grupocliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GrupoClienteLogic.registrarAuditoriaDetallesGrupoCliente(connexion,grupocliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteDataAccess.TABLENAME, grupocliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(grupocliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteDataAccess.TABLENAME, grupocliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoClienteLogic.registrarAuditoriaDetallesGrupoCliente(connexion,grupocliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGrupoCliente(Connexion connexion,GrupoCliente grupocliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(grupocliente.getIsNew()||!grupocliente.getid_empresa().equals(grupocliente.getGrupoClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getid_empresa().toString();
				}
				if(grupocliente.getid_empresa()!=null)
				{
					strValorNuevo=grupocliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getid_modulo().equals(grupocliente.getGrupoClienteOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getid_modulo()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getid_modulo().toString();
				}
				if(grupocliente.getid_modulo()!=null)
				{
					strValorNuevo=grupocliente.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getcodigo().equals(grupocliente.getGrupoClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getcodigo()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getcodigo();
				}
				if(grupocliente.getcodigo()!=null)
				{
					strValorNuevo=grupocliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getnombre().equals(grupocliente.getGrupoClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getnombre()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getnombre();
				}
				if(grupocliente.getnombre()!=null)
				{
					strValorNuevo=grupocliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getsiglas().equals(grupocliente.getGrupoClienteOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getsiglas()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getsiglas();
				}
				if(grupocliente.getsiglas()!=null)
				{
					strValorNuevo=grupocliente.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getsecuencial().equals(grupocliente.getGrupoClienteOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getsecuencial()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getsecuencial();
				}
				if(grupocliente.getsecuencial()!=null)
				{
					strValorNuevo=grupocliente.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getdescripcion().equals(grupocliente.getGrupoClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getdescripcion();
				}
				if(grupocliente.getdescripcion()!=null)
				{
					strValorNuevo=grupocliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getes_prove().equals(grupocliente.getGrupoClienteOriginal().getes_prove()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getes_prove()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getes_prove().toString();
				}
				if(grupocliente.getes_prove()!=null)
				{
					strValorNuevo=grupocliente.getes_prove().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.ESPROVE,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getid_cuenta_contable().equals(grupocliente.getGrupoClienteOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getid_cuenta_contable().toString();
				}
				if(grupocliente.getid_cuenta_contable()!=null)
				{
					strValorNuevo=grupocliente.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(grupocliente.getIsNew()||!grupocliente.getid_centro_costo().equals(grupocliente.getGrupoClienteOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupocliente.getGrupoClienteOriginal().getid_centro_costo()!=null)
				{
					strValorActual=grupocliente.getGrupoClienteOriginal().getid_centro_costo().toString();
				}
				if(grupocliente.getid_centro_costo()!=null)
				{
					strValorNuevo=grupocliente.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGrupoClienteRelacionesWithConnection(GrupoCliente grupocliente,List<Cliente> clientes,List<GrupoClienteFormaPago> grupoclienteformapagos) throws Exception {

		if(!grupocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoClienteRelacionesBase(grupocliente,clientes,grupoclienteformapagos,true);
		}
	}

	public void saveGrupoClienteRelaciones(GrupoCliente grupocliente,List<Cliente> clientes,List<GrupoClienteFormaPago> grupoclienteformapagos)throws Exception {

		if(!grupocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoClienteRelacionesBase(grupocliente,clientes,grupoclienteformapagos,false);
		}
	}

	public void saveGrupoClienteRelacionesBase(GrupoCliente grupocliente,List<Cliente> clientes,List<GrupoClienteFormaPago> grupoclienteformapagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GrupoCliente-saveRelacionesWithConnection");}
	
			grupocliente.setClientes(clientes);
			grupocliente.setGrupoClienteFormaPagos(grupoclienteformapagos);

			this.setGrupoCliente(grupocliente);

			if(GrupoClienteLogicAdditional.validarSaveRelaciones(grupocliente,this)) {

				GrupoClienteLogicAdditional.updateRelacionesToSave(grupocliente,this);

				if((grupocliente.getIsNew()||grupocliente.getIsChanged())&&!grupocliente.getIsDeleted()) {
					this.saveGrupoCliente();
					this.saveGrupoClienteRelacionesDetalles(clientes,grupoclienteformapagos);

				} else if(grupocliente.getIsDeleted()) {
					this.saveGrupoClienteRelacionesDetalles(clientes,grupoclienteformapagos);
					this.saveGrupoCliente();
				}

				GrupoClienteLogicAdditional.updateRelacionesToSaveAfter(grupocliente,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			GrupoClienteFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresGrupoClienteFormaPagos(grupoclienteformapagos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveGrupoClienteRelacionesDetalles(List<Cliente> clientes,List<GrupoClienteFormaPago> grupoclienteformapagos)throws Exception {
		try {
	

			Long idGrupoClienteActual=this.getGrupoCliente().getId();

			ClienteLogic clienteLogic_Desde_GrupoCliente=new ClienteLogic();
			clienteLogic_Desde_GrupoCliente.setClientes(clientes);

			clienteLogic_Desde_GrupoCliente.setConnexion(this.getConnexion());
			clienteLogic_Desde_GrupoCliente.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_GrupoCliente:clienteLogic_Desde_GrupoCliente.getClientes()) {
				cliente_Desde_GrupoCliente.setid_grupo_cliente(idGrupoClienteActual);

				clienteLogic_Desde_GrupoCliente.setCliente(cliente_Desde_GrupoCliente);
				clienteLogic_Desde_GrupoCliente.saveCliente();
			}


			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic_Desde_GrupoCliente=new GrupoClienteFormaPagoLogic();
			grupoclienteformapagoLogic_Desde_GrupoCliente.setGrupoClienteFormaPagos(grupoclienteformapagos);

			grupoclienteformapagoLogic_Desde_GrupoCliente.setConnexion(this.getConnexion());
			grupoclienteformapagoLogic_Desde_GrupoCliente.setDatosCliente(this.datosCliente);

			for(GrupoClienteFormaPago grupoclienteformapago_Desde_GrupoCliente:grupoclienteformapagoLogic_Desde_GrupoCliente.getGrupoClienteFormaPagos()) {
				grupoclienteformapago_Desde_GrupoCliente.setid_grupo_cliente(idGrupoClienteActual);
			}

			grupoclienteformapagoLogic_Desde_GrupoCliente.saveGrupoClienteFormaPagos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoClienteConstantesFunciones.getClassesForeignKeysOfGrupoCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoClienteConstantesFunciones.getClassesRelationshipsOfGrupoCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
