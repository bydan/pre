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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.ParametroFactuPrincipalConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuPrincipalParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuPrincipalParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroFactuPrincipal;
import com.bydan.erp.facturacion.business.logic.ParametroFactuPrincipalLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFactuPrincipalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFactuPrincipalLogic.class);
	
	protected ParametroFactuPrincipalDataAccess parametrofactuprincipalDataAccess; 	
	protected ParametroFactuPrincipal parametrofactuprincipal;
	protected List<ParametroFactuPrincipal> parametrofactuprincipals;
	protected Object parametrofactuprincipalObject;	
	protected List<Object> parametrofactuprincipalsObject;
	
	public static ClassValidator<ParametroFactuPrincipal> parametrofactuprincipalValidator = new ClassValidator<ParametroFactuPrincipal>(ParametroFactuPrincipal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFactuPrincipalLogicAdditional parametrofactuprincipalLogicAdditional=null;
	
	public ParametroFactuPrincipalLogicAdditional getParametroFactuPrincipalLogicAdditional() {
		return this.parametrofactuprincipalLogicAdditional;
	}
	
	public void setParametroFactuPrincipalLogicAdditional(ParametroFactuPrincipalLogicAdditional parametrofactuprincipalLogicAdditional) {
		try {
			this.parametrofactuprincipalLogicAdditional=parametrofactuprincipalLogicAdditional;
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
	
	
	
	
	public  ParametroFactuPrincipalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofactuprincipalDataAccess = new ParametroFactuPrincipalDataAccess();
			
			this.parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();
			this.parametrofactuprincipal= new ParametroFactuPrincipal();
			
			this.parametrofactuprincipalObject=new Object();
			this.parametrofactuprincipalsObject=new ArrayList<Object>();
				
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
			
			this.parametrofactuprincipalDataAccess.setConnexionType(this.connexionType);
			this.parametrofactuprincipalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFactuPrincipalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofactuprincipalDataAccess = new ParametroFactuPrincipalDataAccess();
			this.parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();
			this.parametrofactuprincipal= new ParametroFactuPrincipal();
			this.parametrofactuprincipalObject=new Object();
			this.parametrofactuprincipalsObject=new ArrayList<Object>();
			
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
			
			this.parametrofactuprincipalDataAccess.setConnexionType(this.connexionType);
			this.parametrofactuprincipalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFactuPrincipal getParametroFactuPrincipal() throws Exception {	
		ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToGet(parametrofactuprincipal,this.datosCliente,this.arrDatoGeneral);
		ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToGet(parametrofactuprincipal,this.arrDatoGeneral);
		
		return parametrofactuprincipal;
	}
		
	public void setParametroFactuPrincipal(ParametroFactuPrincipal newParametroFactuPrincipal) {
		this.parametrofactuprincipal = newParametroFactuPrincipal;
	}
	
	public ParametroFactuPrincipalDataAccess getParametroFactuPrincipalDataAccess() {
		return parametrofactuprincipalDataAccess;
	}
	
	public void setParametroFactuPrincipalDataAccess(ParametroFactuPrincipalDataAccess newparametrofactuprincipalDataAccess) {
		this.parametrofactuprincipalDataAccess = newparametrofactuprincipalDataAccess;
	}
	
	public List<ParametroFactuPrincipal> getParametroFactuPrincipals() throws Exception {		
		this.quitarParametroFactuPrincipalsNulos();
		
		ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToGets(parametrofactuprincipals,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFactuPrincipal parametrofactuprincipalLocal: parametrofactuprincipals ) {
			ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToGet(parametrofactuprincipalLocal,this.arrDatoGeneral);
		}
		
		return parametrofactuprincipals;
	}
	
	public void setParametroFactuPrincipals(List<ParametroFactuPrincipal> newParametroFactuPrincipals) {
		this.parametrofactuprincipals = newParametroFactuPrincipals;
	}
	
	public Object getParametroFactuPrincipalObject() {	
		this.parametrofactuprincipalObject=this.parametrofactuprincipalDataAccess.getEntityObject();
		return this.parametrofactuprincipalObject;
	}
		
	public void setParametroFactuPrincipalObject(Object newParametroFactuPrincipalObject) {
		this.parametrofactuprincipalObject = newParametroFactuPrincipalObject;
	}
	
	public List<Object> getParametroFactuPrincipalsObject() {		
		this.parametrofactuprincipalsObject=this.parametrofactuprincipalDataAccess.getEntitiesObject();
		return this.parametrofactuprincipalsObject;
	}
		
	public void setParametroFactuPrincipalsObject(List<Object> newParametroFactuPrincipalsObject) {
		this.parametrofactuprincipalsObject = newParametroFactuPrincipalsObject;
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
		
		if(this.parametrofactuprincipalDataAccess!=null) {
			this.parametrofactuprincipalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofactuprincipalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofactuprincipalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactuprincipal=parametrofactuprincipalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuprincipal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  		  
        try {
			
			parametrofactuprincipal=parametrofactuprincipalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuprincipal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactuprincipal=parametrofactuprincipalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuprincipal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  		  
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  		  
        try {
			
			parametrofactuprincipal=parametrofactuprincipalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuprincipal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  		  
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofactuprincipalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofactuprincipalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofactuprincipalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofactuprincipalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofactuprincipalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofactuprincipalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
        try {			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
        try {
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipal=parametrofactuprincipalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
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
		parametrofactuprincipal = new  ParametroFactuPrincipal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipal=parametrofactuprincipalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		  		  
        try {
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFactuPrincipalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getTodosParametroFactuPrincipalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
	
	public  void  getTodosParametroFactuPrincipals(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactuprincipals = new  ArrayList<ParametroFactuPrincipal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuPrincipal(parametrofactuprincipals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofactuprincipal.getIsNew() || parametrofactuprincipal.getIsChanged()) { 
			this.invalidValues = parametrofactuprincipalValidator.getInvalidValues(parametrofactuprincipal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofactuprincipal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFactuPrincipal(List<ParametroFactuPrincipal> ParametroFactuPrincipals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFactuPrincipal parametrofactuprincipalLocal:parametrofactuprincipals) {				
			estaValidadoObjeto=this.validarGuardarParametroFactuPrincipal(parametrofactuprincipalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFactuPrincipal(List<ParametroFactuPrincipal> ParametroFactuPrincipals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuPrincipal(parametrofactuprincipals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFactuPrincipal(ParametroFactuPrincipal ParametroFactuPrincipal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuPrincipal(parametrofactuprincipal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofactuprincipal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFactuPrincipalConstantesFunciones.getParametroFactuPrincipalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofactuprincipal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFactuPrincipalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFactuPrincipalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFactuPrincipalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-saveParametroFactuPrincipalWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSave(this.parametrofactuprincipal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToSave(this.parametrofactuprincipal,this.arrDatoGeneral);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactuprincipal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuPrincipal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuPrincipal(this.parametrofactuprincipal)) {
				ParametroFactuPrincipalDataAccess.save(this.parametrofactuprincipal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofactuprincipal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSaveAfter(this.parametrofactuprincipal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuPrincipal();
			
			connexion.commit();			
			
			if(this.parametrofactuprincipal.getIsDeleted()) {
				this.parametrofactuprincipal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFactuPrincipal()throws Exception {	
		try {	
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSave(this.parametrofactuprincipal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToSave(this.parametrofactuprincipal,this.arrDatoGeneral);
			
			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactuprincipal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuPrincipal(this.parametrofactuprincipal)) {			
				ParametroFactuPrincipalDataAccess.save(this.parametrofactuprincipal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofactuprincipal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSaveAfter(this.parametrofactuprincipal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofactuprincipal.getIsDeleted()) {
				this.parametrofactuprincipal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFactuPrincipalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-saveParametroFactuPrincipalsWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSaves(parametrofactuprincipals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuPrincipals();
			
			Boolean validadoTodosParametroFactuPrincipal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuPrincipal parametrofactuprincipalLocal:parametrofactuprincipals) {		
				if(parametrofactuprincipalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToSave(parametrofactuprincipalLocal,this.arrDatoGeneral);
	        	
				ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactuprincipalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuPrincipal(parametrofactuprincipalLocal)) {
					ParametroFactuPrincipalDataAccess.save(parametrofactuprincipalLocal, connexion);				
				} else {
					validadoTodosParametroFactuPrincipal=false;
				}
			}
			
			if(!validadoTodosParametroFactuPrincipal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSavesAfter(parametrofactuprincipals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuPrincipals();
			
			connexion.commit();		
			
			this.quitarParametroFactuPrincipalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFactuPrincipals()throws Exception {				
		 try {	
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSaves(parametrofactuprincipals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFactuPrincipal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuPrincipal parametrofactuprincipalLocal:parametrofactuprincipals) {				
				if(parametrofactuprincipalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToSave(parametrofactuprincipalLocal,this.arrDatoGeneral);
	        	
				ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactuprincipalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuPrincipal(parametrofactuprincipalLocal)) {				
					ParametroFactuPrincipalDataAccess.save(parametrofactuprincipalLocal, connexion);				
				} else {
					validadoTodosParametroFactuPrincipal=false;
				}
			}
			
			if(!validadoTodosParametroFactuPrincipal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuPrincipalLogicAdditional.checkParametroFactuPrincipalToSavesAfter(parametrofactuprincipals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFactuPrincipalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuPrincipalParameterReturnGeneral procesarAccionParametroFactuPrincipals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuPrincipal> parametrofactuprincipals,ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalParameterGeneral)throws Exception {
		 try {	
			ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalReturnGeneral=new ParametroFactuPrincipalParameterReturnGeneral();
	
			ParametroFactuPrincipalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactuprincipals,parametrofactuprincipalParameterGeneral,parametrofactuprincipalReturnGeneral);
			
			return parametrofactuprincipalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuPrincipalParameterReturnGeneral procesarAccionParametroFactuPrincipalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuPrincipal> parametrofactuprincipals,ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-procesarAccionParametroFactuPrincipalsWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalReturnGeneral=new ParametroFactuPrincipalParameterReturnGeneral();
	
			ParametroFactuPrincipalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactuprincipals,parametrofactuprincipalParameterGeneral,parametrofactuprincipalReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofactuprincipalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuPrincipalParameterReturnGeneral procesarEventosParametroFactuPrincipals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuPrincipal> parametrofactuprincipals,ParametroFactuPrincipal parametrofactuprincipal,ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalParameterGeneral,Boolean isEsNuevoParametroFactuPrincipal,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalReturnGeneral=new ParametroFactuPrincipalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactuprincipalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuPrincipalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactuprincipals,parametrofactuprincipal,parametrofactuprincipalParameterGeneral,parametrofactuprincipalReturnGeneral,isEsNuevoParametroFactuPrincipal,clases);
			
			return parametrofactuprincipalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFactuPrincipalParameterReturnGeneral procesarEventosParametroFactuPrincipalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuPrincipal> parametrofactuprincipals,ParametroFactuPrincipal parametrofactuprincipal,ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalParameterGeneral,Boolean isEsNuevoParametroFactuPrincipal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-procesarEventosParametroFactuPrincipalsWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalReturnGeneral=new ParametroFactuPrincipalParameterReturnGeneral();
	
			parametrofactuprincipalReturnGeneral.setParametroFactuPrincipal(parametrofactuprincipal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactuprincipalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuPrincipalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactuprincipals,parametrofactuprincipal,parametrofactuprincipalParameterGeneral,parametrofactuprincipalReturnGeneral,isEsNuevoParametroFactuPrincipal,clases);
			
			this.connexion.commit();
			
			return parametrofactuprincipalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuPrincipalParameterReturnGeneral procesarImportacionParametroFactuPrincipalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-procesarImportacionParametroFactuPrincipalsWithConnection");connexion.begin();			
			
			ParametroFactuPrincipalParameterReturnGeneral parametrofactuprincipalReturnGeneral=new ParametroFactuPrincipalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofactuprincipals=new ArrayList<ParametroFactuPrincipal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofactuprincipal=new ParametroFactuPrincipal();
				
				
				if(conColumnasBase) {this.parametrofactuprincipal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofactuprincipal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrofactuprincipal.seten_linea(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_cuenta_tipo_cliente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_cliente_impuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_impresion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_secuencial_usuario(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_secuencial_editable(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_precio_por_cliente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_modificar_precio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_modificar_servicio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_cambiar_unidad(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setnumero_decimales_unidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_activar_serie(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_activar_lote(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_activar_multi_empresa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_centro_costos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_unidades(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_cupo_disponible(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_forma_pago(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_envio_mail(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_autorizar_proforma(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_bloqueo_pedido(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_control_anticipo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_factura_auto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_grabar_valor_cero(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setcon_agregar_item(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setnumero_copias(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactuprincipal.setleyenda(arrColumnas[iColumn++]);
				this.parametrofactuprincipal.setcon_sin_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrofactuprincipals.add(this.parametrofactuprincipal);
			}
			
			this.saveParametroFactuPrincipals();
			
			this.connexion.commit();
			
			parametrofactuprincipalReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofactuprincipalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofactuprincipalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFactuPrincipalsEliminados() throws Exception {				
		
		List<ParametroFactuPrincipal> parametrofactuprincipalsAux= new ArrayList<ParametroFactuPrincipal>();
		
		for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals) {
			if(!parametrofactuprincipal.getIsDeleted()) {
				parametrofactuprincipalsAux.add(parametrofactuprincipal);
			}
		}
		
		parametrofactuprincipals=parametrofactuprincipalsAux;
	}
	
	public void quitarParametroFactuPrincipalsNulos() throws Exception {				
		
		List<ParametroFactuPrincipal> parametrofactuprincipalsAux= new ArrayList<ParametroFactuPrincipal>();
		
		for(ParametroFactuPrincipal parametrofactuprincipal : this.parametrofactuprincipals) {
			if(parametrofactuprincipal==null) {
				parametrofactuprincipalsAux.add(parametrofactuprincipal);
			}
		}
		
		//this.parametrofactuprincipals=parametrofactuprincipalsAux;
		
		this.parametrofactuprincipals.removeAll(parametrofactuprincipalsAux);
	}
	
	public void getSetVersionRowParametroFactuPrincipalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofactuprincipal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofactuprincipal.getIsDeleted() || (parametrofactuprincipal.getIsChanged()&&!parametrofactuprincipal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofactuprincipalDataAccess.getSetVersionRowParametroFactuPrincipal(connexion,parametrofactuprincipal.getId());
				
				if(!parametrofactuprincipal.getVersionRow().equals(timestamp)) {	
					parametrofactuprincipal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofactuprincipal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFactuPrincipal()throws Exception {	
		
		if(parametrofactuprincipal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofactuprincipal.getIsDeleted() || (parametrofactuprincipal.getIsChanged()&&!parametrofactuprincipal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofactuprincipalDataAccess.getSetVersionRowParametroFactuPrincipal(connexion,parametrofactuprincipal.getId());
			
			try {							
				if(!parametrofactuprincipal.getVersionRow().equals(timestamp)) {	
					parametrofactuprincipal.setVersionRow(timestamp);
				}
				
				parametrofactuprincipal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFactuPrincipalsWithConnection()throws Exception {	
		if(parametrofactuprincipals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFactuPrincipal parametrofactuprincipalAux:parametrofactuprincipals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofactuprincipalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactuprincipalAux.getIsDeleted() || (parametrofactuprincipalAux.getIsChanged()&&!parametrofactuprincipalAux.getIsNew())) {
						
						timestamp=parametrofactuprincipalDataAccess.getSetVersionRowParametroFactuPrincipal(connexion,parametrofactuprincipalAux.getId());
						
						if(!parametrofactuprincipal.getVersionRow().equals(timestamp)) {	
							parametrofactuprincipalAux.setVersionRow(timestamp);
						}
								
						parametrofactuprincipalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFactuPrincipals()throws Exception {	
		if(parametrofactuprincipals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFactuPrincipal parametrofactuprincipalAux:parametrofactuprincipals) {
					if(parametrofactuprincipalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactuprincipalAux.getIsDeleted() || (parametrofactuprincipalAux.getIsChanged()&&!parametrofactuprincipalAux.getIsNew())) {
						
						timestamp=parametrofactuprincipalDataAccess.getSetVersionRowParametroFactuPrincipal(connexion,parametrofactuprincipalAux.getId());
						
						if(!parametrofactuprincipalAux.getVersionRow().equals(timestamp)) {	
							parametrofactuprincipalAux.setVersionRow(timestamp);
						}
						
													
						parametrofactuprincipalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFactuPrincipalParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuPrincipalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoParamFactuDescuento,String finalQueryGlobalTipoParamFactuListadoCliente,String finalQueryGlobalTipoParamFactuSecuenciaTrabajo,String finalQueryGlobalTipoDocumentoFactura,String finalQueryGlobalTipoDocumentoNotaCredito,String finalQueryGlobalTipoDocumentoNotaDebito,String finalQueryGlobalLibroContable,String finalQueryGlobalMoneda,String finalQueryGlobalFormato,String finalQueryGlobalCuentaContableFleteVenta,String finalQueryGlobalCuentaContableOtroCargo,String finalQueryGlobalCuentaContableFinan,String finalQueryGlobalCuentaContableBoni,String finalQueryGlobalCuentaContableBoniDevol,String finalQueryGlobalCuentaContableIce) throws Exception {
		ParametroFactuPrincipalParameterReturnGeneral  parametrofactuprincipalReturnGeneral =new ParametroFactuPrincipalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFactuPrincipalWithConnection");connexion.begin();
			
			parametrofactuprincipalReturnGeneral =new ParametroFactuPrincipalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactuprincipalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactuprincipalReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoParamFactuDescuento> tipoparamfactudescuentosForeignKey=new ArrayList<TipoParamFactuDescuento>();
			TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic=new TipoParamFactuDescuentoLogic();
			tipoparamfactudescuentoLogic.setConnexion(this.connexion);
			tipoparamfactudescuentoLogic.getTipoParamFactuDescuentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuDescuento.equals("NONE")) {
				tipoparamfactudescuentoLogic.getTodosTipoParamFactuDescuentos(finalQueryGlobalTipoParamFactuDescuento,new Pagination());
				tipoparamfactudescuentosForeignKey=tipoparamfactudescuentoLogic.getTipoParamFactuDescuentos();
			}

			parametrofactuprincipalReturnGeneral.settipoparamfactudescuentosForeignKey(tipoparamfactudescuentosForeignKey);


			List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesForeignKey=new ArrayList<TipoParamFactuListadoCliente>();
			TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic=new TipoParamFactuListadoClienteLogic();
			tipoparamfactulistadoclienteLogic.setConnexion(this.connexion);
			tipoparamfactulistadoclienteLogic.getTipoParamFactuListadoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuListadoCliente.equals("NONE")) {
				tipoparamfactulistadoclienteLogic.getTodosTipoParamFactuListadoClientes(finalQueryGlobalTipoParamFactuListadoCliente,new Pagination());
				tipoparamfactulistadoclientesForeignKey=tipoparamfactulistadoclienteLogic.getTipoParamFactuListadoClientes();
			}

			parametrofactuprincipalReturnGeneral.settipoparamfactulistadoclientesForeignKey(tipoparamfactulistadoclientesForeignKey);


			List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosForeignKey=new ArrayList<TipoParamFactuSecuenciaTrabajo>();
			TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic=new TipoParamFactuSecuenciaTrabajoLogic();
			tipoparamfactusecuenciatrabajoLogic.setConnexion(this.connexion);
			tipoparamfactusecuenciatrabajoLogic.getTipoParamFactuSecuenciaTrabajoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuSecuenciaTrabajo.equals("NONE")) {
				tipoparamfactusecuenciatrabajoLogic.getTodosTipoParamFactuSecuenciaTrabajos(finalQueryGlobalTipoParamFactuSecuenciaTrabajo,new Pagination());
				tipoparamfactusecuenciatrabajosForeignKey=tipoparamfactusecuenciatrabajoLogic.getTipoParamFactuSecuenciaTrabajos();
			}

			parametrofactuprincipalReturnGeneral.settipoparamfactusecuenciatrabajosForeignKey(tipoparamfactusecuenciatrabajosForeignKey);


			List<TipoDocumento> tipodocumentofacturasForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentofacturaLogic=new TipoDocumentoLogic();
			tipodocumentofacturaLogic.setConnexion(this.connexion);
			tipodocumentofacturaLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoFactura.equals("NONE")) {
				tipodocumentofacturaLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoFactura,new Pagination());
				tipodocumentofacturasForeignKey=tipodocumentofacturaLogic.getTipoDocumentos();
			}

			parametrofactuprincipalReturnGeneral.settipodocumentofacturasForeignKey(tipodocumentofacturasForeignKey);


			List<TipoDocumento> tipodocumentonotacreditosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotacreditoLogic=new TipoDocumentoLogic();
			tipodocumentonotacreditoLogic.setConnexion(this.connexion);
			tipodocumentonotacreditoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaCredito.equals("NONE")) {
				tipodocumentonotacreditoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaCredito,new Pagination());
				tipodocumentonotacreditosForeignKey=tipodocumentonotacreditoLogic.getTipoDocumentos();
			}

			parametrofactuprincipalReturnGeneral.settipodocumentonotacreditosForeignKey(tipodocumentonotacreditosForeignKey);


			List<TipoDocumento> tipodocumentonotadebitosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotadebitoLogic=new TipoDocumentoLogic();
			tipodocumentonotadebitoLogic.setConnexion(this.connexion);
			tipodocumentonotadebitoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaDebito.equals("NONE")) {
				tipodocumentonotadebitoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaDebito,new Pagination());
				tipodocumentonotadebitosForeignKey=tipodocumentonotadebitoLogic.getTipoDocumentos();
			}

			parametrofactuprincipalReturnGeneral.settipodocumentonotadebitosForeignKey(tipodocumentonotadebitosForeignKey);


			List<LibroContable> librocontablesForeignKey=new ArrayList<LibroContable>();
			LibroContableLogic librocontableLogic=new LibroContableLogic();
			librocontableLogic.setConnexion(this.connexion);
			librocontableLogic.getLibroContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLibroContable.equals("NONE")) {
				librocontableLogic.getTodosLibroContables(finalQueryGlobalLibroContable,new Pagination());
				librocontablesForeignKey=librocontableLogic.getLibroContables();
			}

			parametrofactuprincipalReturnGeneral.setlibrocontablesForeignKey(librocontablesForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrofactuprincipalReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			parametrofactuprincipalReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<CuentaContable> cuentacontablefleteventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefleteventaLogic=new CuentaContableLogic();
			cuentacontablefleteventaLogic.setConnexion(this.connexion);
			cuentacontablefleteventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFleteVenta.equals("NONE")) {
				cuentacontablefleteventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFleteVenta,new Pagination());
				cuentacontablefleteventasForeignKey=cuentacontablefleteventaLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablefleteventasForeignKey(cuentacontablefleteventasForeignKey);


			List<CuentaContable> cuentacontableotrocargosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableotrocargoLogic=new CuentaContableLogic();
			cuentacontableotrocargoLogic.setConnexion(this.connexion);
			cuentacontableotrocargoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableOtroCargo.equals("NONE")) {
				cuentacontableotrocargoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableOtroCargo,new Pagination());
				cuentacontableotrocargosForeignKey=cuentacontableotrocargoLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontableotrocargosForeignKey(cuentacontableotrocargosForeignKey);


			List<CuentaContable> cuentacontablefinansForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefinanLogic=new CuentaContableLogic();
			cuentacontablefinanLogic.setConnexion(this.connexion);
			cuentacontablefinanLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFinan.equals("NONE")) {
				cuentacontablefinanLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFinan,new Pagination());
				cuentacontablefinansForeignKey=cuentacontablefinanLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablefinansForeignKey(cuentacontablefinansForeignKey);


			List<CuentaContable> cuentacontablebonisForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableboniLogic=new CuentaContableLogic();
			cuentacontableboniLogic.setConnexion(this.connexion);
			cuentacontableboniLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBoni.equals("NONE")) {
				cuentacontableboniLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBoni,new Pagination());
				cuentacontablebonisForeignKey=cuentacontableboniLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablebonisForeignKey(cuentacontablebonisForeignKey);


			List<CuentaContable> cuentacontablebonidevolsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonidevolLogic=new CuentaContableLogic();
			cuentacontablebonidevolLogic.setConnexion(this.connexion);
			cuentacontablebonidevolLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBoniDevol.equals("NONE")) {
				cuentacontablebonidevolLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBoniDevol,new Pagination());
				cuentacontablebonidevolsForeignKey=cuentacontablebonidevolLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablebonidevolsForeignKey(cuentacontablebonidevolsForeignKey);


			List<CuentaContable> cuentacontableicesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableiceLogic=new CuentaContableLogic();
			cuentacontableiceLogic.setConnexion(this.connexion);
			cuentacontableiceLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIce.equals("NONE")) {
				cuentacontableiceLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIce,new Pagination());
				cuentacontableicesForeignKey=cuentacontableiceLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontableicesForeignKey(cuentacontableicesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrofactuprincipalReturnGeneral;
	}
	
	public ParametroFactuPrincipalParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuPrincipal(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoParamFactuDescuento,String finalQueryGlobalTipoParamFactuListadoCliente,String finalQueryGlobalTipoParamFactuSecuenciaTrabajo,String finalQueryGlobalTipoDocumentoFactura,String finalQueryGlobalTipoDocumentoNotaCredito,String finalQueryGlobalTipoDocumentoNotaDebito,String finalQueryGlobalLibroContable,String finalQueryGlobalMoneda,String finalQueryGlobalFormato,String finalQueryGlobalCuentaContableFleteVenta,String finalQueryGlobalCuentaContableOtroCargo,String finalQueryGlobalCuentaContableFinan,String finalQueryGlobalCuentaContableBoni,String finalQueryGlobalCuentaContableBoniDevol,String finalQueryGlobalCuentaContableIce) throws Exception {
		ParametroFactuPrincipalParameterReturnGeneral  parametrofactuprincipalReturnGeneral =new ParametroFactuPrincipalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrofactuprincipalReturnGeneral =new ParametroFactuPrincipalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactuprincipalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactuprincipalReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoParamFactuDescuento> tipoparamfactudescuentosForeignKey=new ArrayList<TipoParamFactuDescuento>();
			TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic=new TipoParamFactuDescuentoLogic();
			tipoparamfactudescuentoLogic.setConnexion(this.connexion);
			tipoparamfactudescuentoLogic.getTipoParamFactuDescuentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuDescuento.equals("NONE")) {
				tipoparamfactudescuentoLogic.getTodosTipoParamFactuDescuentos(finalQueryGlobalTipoParamFactuDescuento,new Pagination());
				tipoparamfactudescuentosForeignKey=tipoparamfactudescuentoLogic.getTipoParamFactuDescuentos();
			}

			parametrofactuprincipalReturnGeneral.settipoparamfactudescuentosForeignKey(tipoparamfactudescuentosForeignKey);


			List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesForeignKey=new ArrayList<TipoParamFactuListadoCliente>();
			TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic=new TipoParamFactuListadoClienteLogic();
			tipoparamfactulistadoclienteLogic.setConnexion(this.connexion);
			tipoparamfactulistadoclienteLogic.getTipoParamFactuListadoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuListadoCliente.equals("NONE")) {
				tipoparamfactulistadoclienteLogic.getTodosTipoParamFactuListadoClientes(finalQueryGlobalTipoParamFactuListadoCliente,new Pagination());
				tipoparamfactulistadoclientesForeignKey=tipoparamfactulistadoclienteLogic.getTipoParamFactuListadoClientes();
			}

			parametrofactuprincipalReturnGeneral.settipoparamfactulistadoclientesForeignKey(tipoparamfactulistadoclientesForeignKey);


			List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosForeignKey=new ArrayList<TipoParamFactuSecuenciaTrabajo>();
			TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic=new TipoParamFactuSecuenciaTrabajoLogic();
			tipoparamfactusecuenciatrabajoLogic.setConnexion(this.connexion);
			tipoparamfactusecuenciatrabajoLogic.getTipoParamFactuSecuenciaTrabajoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuSecuenciaTrabajo.equals("NONE")) {
				tipoparamfactusecuenciatrabajoLogic.getTodosTipoParamFactuSecuenciaTrabajos(finalQueryGlobalTipoParamFactuSecuenciaTrabajo,new Pagination());
				tipoparamfactusecuenciatrabajosForeignKey=tipoparamfactusecuenciatrabajoLogic.getTipoParamFactuSecuenciaTrabajos();
			}

			parametrofactuprincipalReturnGeneral.settipoparamfactusecuenciatrabajosForeignKey(tipoparamfactusecuenciatrabajosForeignKey);


			List<TipoDocumento> tipodocumentofacturasForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentofacturaLogic=new TipoDocumentoLogic();
			tipodocumentofacturaLogic.setConnexion(this.connexion);
			tipodocumentofacturaLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoFactura.equals("NONE")) {
				tipodocumentofacturaLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoFactura,new Pagination());
				tipodocumentofacturasForeignKey=tipodocumentofacturaLogic.getTipoDocumentos();
			}

			parametrofactuprincipalReturnGeneral.settipodocumentofacturasForeignKey(tipodocumentofacturasForeignKey);


			List<TipoDocumento> tipodocumentonotacreditosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotacreditoLogic=new TipoDocumentoLogic();
			tipodocumentonotacreditoLogic.setConnexion(this.connexion);
			tipodocumentonotacreditoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaCredito.equals("NONE")) {
				tipodocumentonotacreditoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaCredito,new Pagination());
				tipodocumentonotacreditosForeignKey=tipodocumentonotacreditoLogic.getTipoDocumentos();
			}

			parametrofactuprincipalReturnGeneral.settipodocumentonotacreditosForeignKey(tipodocumentonotacreditosForeignKey);


			List<TipoDocumento> tipodocumentonotadebitosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotadebitoLogic=new TipoDocumentoLogic();
			tipodocumentonotadebitoLogic.setConnexion(this.connexion);
			tipodocumentonotadebitoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaDebito.equals("NONE")) {
				tipodocumentonotadebitoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaDebito,new Pagination());
				tipodocumentonotadebitosForeignKey=tipodocumentonotadebitoLogic.getTipoDocumentos();
			}

			parametrofactuprincipalReturnGeneral.settipodocumentonotadebitosForeignKey(tipodocumentonotadebitosForeignKey);


			List<LibroContable> librocontablesForeignKey=new ArrayList<LibroContable>();
			LibroContableLogic librocontableLogic=new LibroContableLogic();
			librocontableLogic.setConnexion(this.connexion);
			librocontableLogic.getLibroContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLibroContable.equals("NONE")) {
				librocontableLogic.getTodosLibroContables(finalQueryGlobalLibroContable,new Pagination());
				librocontablesForeignKey=librocontableLogic.getLibroContables();
			}

			parametrofactuprincipalReturnGeneral.setlibrocontablesForeignKey(librocontablesForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrofactuprincipalReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			parametrofactuprincipalReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<CuentaContable> cuentacontablefleteventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefleteventaLogic=new CuentaContableLogic();
			cuentacontablefleteventaLogic.setConnexion(this.connexion);
			cuentacontablefleteventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFleteVenta.equals("NONE")) {
				cuentacontablefleteventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFleteVenta,new Pagination());
				cuentacontablefleteventasForeignKey=cuentacontablefleteventaLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablefleteventasForeignKey(cuentacontablefleteventasForeignKey);


			List<CuentaContable> cuentacontableotrocargosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableotrocargoLogic=new CuentaContableLogic();
			cuentacontableotrocargoLogic.setConnexion(this.connexion);
			cuentacontableotrocargoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableOtroCargo.equals("NONE")) {
				cuentacontableotrocargoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableOtroCargo,new Pagination());
				cuentacontableotrocargosForeignKey=cuentacontableotrocargoLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontableotrocargosForeignKey(cuentacontableotrocargosForeignKey);


			List<CuentaContable> cuentacontablefinansForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefinanLogic=new CuentaContableLogic();
			cuentacontablefinanLogic.setConnexion(this.connexion);
			cuentacontablefinanLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFinan.equals("NONE")) {
				cuentacontablefinanLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFinan,new Pagination());
				cuentacontablefinansForeignKey=cuentacontablefinanLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablefinansForeignKey(cuentacontablefinansForeignKey);


			List<CuentaContable> cuentacontablebonisForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableboniLogic=new CuentaContableLogic();
			cuentacontableboniLogic.setConnexion(this.connexion);
			cuentacontableboniLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBoni.equals("NONE")) {
				cuentacontableboniLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBoni,new Pagination());
				cuentacontablebonisForeignKey=cuentacontableboniLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablebonisForeignKey(cuentacontablebonisForeignKey);


			List<CuentaContable> cuentacontablebonidevolsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonidevolLogic=new CuentaContableLogic();
			cuentacontablebonidevolLogic.setConnexion(this.connexion);
			cuentacontablebonidevolLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBoniDevol.equals("NONE")) {
				cuentacontablebonidevolLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBoniDevol,new Pagination());
				cuentacontablebonidevolsForeignKey=cuentacontablebonidevolLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontablebonidevolsForeignKey(cuentacontablebonidevolsForeignKey);


			List<CuentaContable> cuentacontableicesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableiceLogic=new CuentaContableLogic();
			cuentacontableiceLogic.setConnexion(this.connexion);
			cuentacontableiceLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIce.equals("NONE")) {
				cuentacontableiceLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIce,new Pagination());
				cuentacontableicesForeignKey=cuentacontableiceLogic.getCuentaContables();
			}

			parametrofactuprincipalReturnGeneral.setcuentacontableicesForeignKey(cuentacontableicesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrofactuprincipalReturnGeneral;
	}
	
	
	public void deepLoad(ParametroFactuPrincipal parametrofactuprincipal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToGet(parametrofactuprincipal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactuprincipal.setEmpresa(parametrofactuprincipalDataAccess.getEmpresa(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setSucursal(parametrofactuprincipalDataAccess.getSucursal(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setTipoParamFactuDescuento(parametrofactuprincipalDataAccess.getTipoParamFactuDescuento(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setTipoParamFactuListadoCliente(parametrofactuprincipalDataAccess.getTipoParamFactuListadoCliente(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setTipoParamFactuSecuenciaTrabajo(parametrofactuprincipalDataAccess.getTipoParamFactuSecuenciaTrabajo(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setTipoDocumentoFactura(parametrofactuprincipalDataAccess.getTipoDocumentoFactura(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setTipoDocumentoNotaCredito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaCredito(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setTipoDocumentoNotaDebito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaDebito(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setLibroContable(parametrofactuprincipalDataAccess.getLibroContable(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setMoneda(parametrofactuprincipalDataAccess.getMoneda(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setFormato(parametrofactuprincipalDataAccess.getFormato(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setCuentaContableFleteVenta(parametrofactuprincipalDataAccess.getCuentaContableFleteVenta(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setCuentaContableOtroCargo(parametrofactuprincipalDataAccess.getCuentaContableOtroCargo(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setCuentaContableFinan(parametrofactuprincipalDataAccess.getCuentaContableFinan(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setCuentaContableBoni(parametrofactuprincipalDataAccess.getCuentaContableBoni(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setCuentaContableBoniDevol(parametrofactuprincipalDataAccess.getCuentaContableBoniDevol(connexion,parametrofactuprincipal));
		parametrofactuprincipal.setCuentaContableIce(parametrofactuprincipalDataAccess.getCuentaContableIce(connexion,parametrofactuprincipal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactuprincipal.setEmpresa(parametrofactuprincipalDataAccess.getEmpresa(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuprincipal.setSucursal(parametrofactuprincipalDataAccess.getSucursal(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(TipoParamFactuDescuento.class)) {
				parametrofactuprincipal.setTipoParamFactuDescuento(parametrofactuprincipalDataAccess.getTipoParamFactuDescuento(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
				parametrofactuprincipal.setTipoParamFactuListadoCliente(parametrofactuprincipalDataAccess.getTipoParamFactuListadoCliente(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
				parametrofactuprincipal.setTipoParamFactuSecuenciaTrabajo(parametrofactuprincipalDataAccess.getTipoParamFactuSecuenciaTrabajo(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrofactuprincipal.setTipoDocumentoFactura(parametrofactuprincipalDataAccess.getTipoDocumentoFactura(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrofactuprincipal.setTipoDocumentoNotaCredito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaCredito(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrofactuprincipal.setTipoDocumentoNotaDebito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaDebito(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				parametrofactuprincipal.setLibroContable(parametrofactuprincipalDataAccess.getLibroContable(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametrofactuprincipal.setMoneda(parametrofactuprincipalDataAccess.getMoneda(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactuprincipal.setFormato(parametrofactuprincipalDataAccess.getFormato(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableFleteVenta(parametrofactuprincipalDataAccess.getCuentaContableFleteVenta(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableOtroCargo(parametrofactuprincipalDataAccess.getCuentaContableOtroCargo(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableFinan(parametrofactuprincipalDataAccess.getCuentaContableFinan(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableBoni(parametrofactuprincipalDataAccess.getCuentaContableBoni(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableBoniDevol(parametrofactuprincipalDataAccess.getCuentaContableBoniDevol(connexion,parametrofactuprincipal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableIce(parametrofactuprincipalDataAccess.getCuentaContableIce(connexion,parametrofactuprincipal));
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
			parametrofactuprincipal.setEmpresa(parametrofactuprincipalDataAccess.getEmpresa(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setSucursal(parametrofactuprincipalDataAccess.getSucursal(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuDescuento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoParamFactuDescuento(parametrofactuprincipalDataAccess.getTipoParamFactuDescuento(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoParamFactuListadoCliente(parametrofactuprincipalDataAccess.getTipoParamFactuListadoCliente(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoParamFactuSecuenciaTrabajo(parametrofactuprincipalDataAccess.getTipoParamFactuSecuenciaTrabajo(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoDocumentoFactura(parametrofactuprincipalDataAccess.getTipoDocumentoFactura(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoDocumentoNotaCredito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaCredito(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoDocumentoNotaDebito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaDebito(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LibroContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setLibroContable(parametrofactuprincipalDataAccess.getLibroContable(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setMoneda(parametrofactuprincipalDataAccess.getMoneda(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setFormato(parametrofactuprincipalDataAccess.getFormato(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableFleteVenta(parametrofactuprincipalDataAccess.getCuentaContableFleteVenta(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableOtroCargo(parametrofactuprincipalDataAccess.getCuentaContableOtroCargo(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableFinan(parametrofactuprincipalDataAccess.getCuentaContableFinan(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableBoni(parametrofactuprincipalDataAccess.getCuentaContableBoni(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableBoniDevol(parametrofactuprincipalDataAccess.getCuentaContableBoniDevol(connexion,parametrofactuprincipal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableIce(parametrofactuprincipalDataAccess.getCuentaContableIce(connexion,parametrofactuprincipal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactuprincipal.setEmpresa(parametrofactuprincipalDataAccess.getEmpresa(connexion,parametrofactuprincipal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactuprincipal.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setSucursal(parametrofactuprincipalDataAccess.getSucursal(connexion,parametrofactuprincipal));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactuprincipal.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setTipoParamFactuDescuento(parametrofactuprincipalDataAccess.getTipoParamFactuDescuento(connexion,parametrofactuprincipal));
		TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic= new TipoParamFactuDescuentoLogic(connexion);
		tipoparamfactudescuentoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuDescuento(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setTipoParamFactuListadoCliente(parametrofactuprincipalDataAccess.getTipoParamFactuListadoCliente(connexion,parametrofactuprincipal));
		TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic= new TipoParamFactuListadoClienteLogic(connexion);
		tipoparamfactulistadoclienteLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuListadoCliente(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setTipoParamFactuSecuenciaTrabajo(parametrofactuprincipalDataAccess.getTipoParamFactuSecuenciaTrabajo(connexion,parametrofactuprincipal));
		TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic= new TipoParamFactuSecuenciaTrabajoLogic(connexion);
		tipoparamfactusecuenciatrabajoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setTipoDocumentoFactura(parametrofactuprincipalDataAccess.getTipoDocumentoFactura(connexion,parametrofactuprincipal));
		TipoDocumentoLogic tipodocumentofacturaLogic= new TipoDocumentoLogic(connexion);
		tipodocumentofacturaLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setTipoDocumentoNotaCredito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaCredito(connexion,parametrofactuprincipal));
		TipoDocumentoLogic tipodocumentonotacreditoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotacreditoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setTipoDocumentoNotaDebito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaDebito(connexion,parametrofactuprincipal));
		TipoDocumentoLogic tipodocumentonotadebitoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotadebitoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaDebito(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setLibroContable(parametrofactuprincipalDataAccess.getLibroContable(connexion,parametrofactuprincipal));
		LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
		librocontableLogic.deepLoad(parametrofactuprincipal.getLibroContable(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setMoneda(parametrofactuprincipalDataAccess.getMoneda(connexion,parametrofactuprincipal));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametrofactuprincipal.getMoneda(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setFormato(parametrofactuprincipalDataAccess.getFormato(connexion,parametrofactuprincipal));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(parametrofactuprincipal.getFormato(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setCuentaContableFleteVenta(parametrofactuprincipalDataAccess.getCuentaContableFleteVenta(connexion,parametrofactuprincipal));
		CuentaContableLogic cuentacontablefleteventaLogic= new CuentaContableLogic(connexion);
		cuentacontablefleteventaLogic.deepLoad(parametrofactuprincipal.getCuentaContableFleteVenta(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setCuentaContableOtroCargo(parametrofactuprincipalDataAccess.getCuentaContableOtroCargo(connexion,parametrofactuprincipal));
		CuentaContableLogic cuentacontableotrocargoLogic= new CuentaContableLogic(connexion);
		cuentacontableotrocargoLogic.deepLoad(parametrofactuprincipal.getCuentaContableOtroCargo(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setCuentaContableFinan(parametrofactuprincipalDataAccess.getCuentaContableFinan(connexion,parametrofactuprincipal));
		CuentaContableLogic cuentacontablefinanLogic= new CuentaContableLogic(connexion);
		cuentacontablefinanLogic.deepLoad(parametrofactuprincipal.getCuentaContableFinan(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setCuentaContableBoni(parametrofactuprincipalDataAccess.getCuentaContableBoni(connexion,parametrofactuprincipal));
		CuentaContableLogic cuentacontableboniLogic= new CuentaContableLogic(connexion);
		cuentacontableboniLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoni(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setCuentaContableBoniDevol(parametrofactuprincipalDataAccess.getCuentaContableBoniDevol(connexion,parametrofactuprincipal));
		CuentaContableLogic cuentacontablebonidevolLogic= new CuentaContableLogic(connexion);
		cuentacontablebonidevolLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoniDevol(),isDeep,deepLoadType,clases);
				
		parametrofactuprincipal.setCuentaContableIce(parametrofactuprincipalDataAccess.getCuentaContableIce(connexion,parametrofactuprincipal));
		CuentaContableLogic cuentacontableiceLogic= new CuentaContableLogic(connexion);
		cuentacontableiceLogic.deepLoad(parametrofactuprincipal.getCuentaContableIce(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactuprincipal.setEmpresa(parametrofactuprincipalDataAccess.getEmpresa(connexion,parametrofactuprincipal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactuprincipal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuprincipal.setSucursal(parametrofactuprincipalDataAccess.getSucursal(connexion,parametrofactuprincipal));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactuprincipal.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuDescuento.class)) {
				parametrofactuprincipal.setTipoParamFactuDescuento(parametrofactuprincipalDataAccess.getTipoParamFactuDescuento(connexion,parametrofactuprincipal));
				TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic= new TipoParamFactuDescuentoLogic(connexion);
				tipoparamfactudescuentoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
				parametrofactuprincipal.setTipoParamFactuListadoCliente(parametrofactuprincipalDataAccess.getTipoParamFactuListadoCliente(connexion,parametrofactuprincipal));
				TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic= new TipoParamFactuListadoClienteLogic(connexion);
				tipoparamfactulistadoclienteLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuListadoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
				parametrofactuprincipal.setTipoParamFactuSecuenciaTrabajo(parametrofactuprincipalDataAccess.getTipoParamFactuSecuenciaTrabajo(connexion,parametrofactuprincipal));
				TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic= new TipoParamFactuSecuenciaTrabajoLogic(connexion);
				tipoparamfactusecuenciatrabajoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrofactuprincipal.setTipoDocumentoFactura(parametrofactuprincipalDataAccess.getTipoDocumentoFactura(connexion,parametrofactuprincipal));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrofactuprincipal.setTipoDocumentoNotaCredito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaCredito(connexion,parametrofactuprincipal));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrofactuprincipal.setTipoDocumentoNotaDebito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaDebito(connexion,parametrofactuprincipal));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				parametrofactuprincipal.setLibroContable(parametrofactuprincipalDataAccess.getLibroContable(connexion,parametrofactuprincipal));
				LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
				librocontableLogic.deepLoad(parametrofactuprincipal.getLibroContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametrofactuprincipal.setMoneda(parametrofactuprincipalDataAccess.getMoneda(connexion,parametrofactuprincipal));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(parametrofactuprincipal.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactuprincipal.setFormato(parametrofactuprincipalDataAccess.getFormato(connexion,parametrofactuprincipal));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactuprincipal.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableFleteVenta(parametrofactuprincipalDataAccess.getCuentaContableFleteVenta(connexion,parametrofactuprincipal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableFleteVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableOtroCargo(parametrofactuprincipalDataAccess.getCuentaContableOtroCargo(connexion,parametrofactuprincipal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableOtroCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableFinan(parametrofactuprincipalDataAccess.getCuentaContableFinan(connexion,parametrofactuprincipal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableFinan(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableBoni(parametrofactuprincipalDataAccess.getCuentaContableBoni(connexion,parametrofactuprincipal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoni(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableBoniDevol(parametrofactuprincipalDataAccess.getCuentaContableBoniDevol(connexion,parametrofactuprincipal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoniDevol(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactuprincipal.setCuentaContableIce(parametrofactuprincipalDataAccess.getCuentaContableIce(connexion,parametrofactuprincipal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableIce(),isDeep,deepLoadType,clases);				
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
			parametrofactuprincipal.setEmpresa(parametrofactuprincipalDataAccess.getEmpresa(connexion,parametrofactuprincipal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactuprincipal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setSucursal(parametrofactuprincipalDataAccess.getSucursal(connexion,parametrofactuprincipal));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactuprincipal.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuDescuento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoParamFactuDescuento(parametrofactuprincipalDataAccess.getTipoParamFactuDescuento(connexion,parametrofactuprincipal));
			TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic= new TipoParamFactuDescuentoLogic(connexion);
			tipoparamfactudescuentoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoParamFactuListadoCliente(parametrofactuprincipalDataAccess.getTipoParamFactuListadoCliente(connexion,parametrofactuprincipal));
			TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic= new TipoParamFactuListadoClienteLogic(connexion);
			tipoparamfactulistadoclienteLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuListadoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoParamFactuSecuenciaTrabajo(parametrofactuprincipalDataAccess.getTipoParamFactuSecuenciaTrabajo(connexion,parametrofactuprincipal));
			TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic= new TipoParamFactuSecuenciaTrabajoLogic(connexion);
			tipoparamfactusecuenciatrabajoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoDocumentoFactura(parametrofactuprincipalDataAccess.getTipoDocumentoFactura(connexion,parametrofactuprincipal));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoDocumentoNotaCredito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaCredito(connexion,parametrofactuprincipal));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setTipoDocumentoNotaDebito(parametrofactuprincipalDataAccess.getTipoDocumentoNotaDebito(connexion,parametrofactuprincipal));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(LibroContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setLibroContable(parametrofactuprincipalDataAccess.getLibroContable(connexion,parametrofactuprincipal));
			LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
			librocontableLogic.deepLoad(parametrofactuprincipal.getLibroContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setMoneda(parametrofactuprincipalDataAccess.getMoneda(connexion,parametrofactuprincipal));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(parametrofactuprincipal.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setFormato(parametrofactuprincipalDataAccess.getFormato(connexion,parametrofactuprincipal));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactuprincipal.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableFleteVenta(parametrofactuprincipalDataAccess.getCuentaContableFleteVenta(connexion,parametrofactuprincipal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableFleteVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableOtroCargo(parametrofactuprincipalDataAccess.getCuentaContableOtroCargo(connexion,parametrofactuprincipal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableOtroCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableFinan(parametrofactuprincipalDataAccess.getCuentaContableFinan(connexion,parametrofactuprincipal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableFinan(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableBoni(parametrofactuprincipalDataAccess.getCuentaContableBoni(connexion,parametrofactuprincipal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoni(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableBoniDevol(parametrofactuprincipalDataAccess.getCuentaContableBoniDevol(connexion,parametrofactuprincipal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoniDevol(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuprincipal.setCuentaContableIce(parametrofactuprincipalDataAccess.getCuentaContableIce(connexion,parametrofactuprincipal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactuprincipal.getCuentaContableIce(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFactuPrincipal parametrofactuprincipal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFactuPrincipalLogicAdditional.updateParametroFactuPrincipalToSave(parametrofactuprincipal,this.arrDatoGeneral);
			
ParametroFactuPrincipalDataAccess.save(parametrofactuprincipal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactuprincipal.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrofactuprincipal.getSucursal(),connexion);

		TipoParamFactuDescuentoDataAccess.save(parametrofactuprincipal.getTipoParamFactuDescuento(),connexion);

		TipoParamFactuListadoClienteDataAccess.save(parametrofactuprincipal.getTipoParamFactuListadoCliente(),connexion);

		TipoParamFactuSecuenciaTrabajoDataAccess.save(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),connexion);

		TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoFactura(),connexion);

		TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaCredito(),connexion);

		TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaDebito(),connexion);

		LibroContableDataAccess.save(parametrofactuprincipal.getLibroContable(),connexion);

		MonedaDataAccess.save(parametrofactuprincipal.getMoneda(),connexion);

		FormatoDataAccess.save(parametrofactuprincipal.getFormato(),connexion);

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFleteVenta(),connexion);

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableOtroCargo(),connexion);

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFinan(),connexion);

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoni(),connexion);

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoniDevol(),connexion);

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableIce(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuprincipal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuprincipal.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoParamFactuDescuento.class)) {
				TipoParamFactuDescuentoDataAccess.save(parametrofactuprincipal.getTipoParamFactuDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
				TipoParamFactuListadoClienteDataAccess.save(parametrofactuprincipal.getTipoParamFactuListadoCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
				TipoParamFactuSecuenciaTrabajoDataAccess.save(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				LibroContableDataAccess.save(parametrofactuprincipal.getLibroContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametrofactuprincipal.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactuprincipal.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFleteVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableOtroCargo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFinan(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoni(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoniDevol(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableIce(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactuprincipal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactuprincipal.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactuprincipal.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactuprincipal.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoParamFactuDescuentoDataAccess.save(parametrofactuprincipal.getTipoParamFactuDescuento(),connexion);
		TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic= new TipoParamFactuDescuentoLogic(connexion);
		tipoparamfactudescuentoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuDescuento(),isDeep,deepLoadType,clases);
				

		TipoParamFactuListadoClienteDataAccess.save(parametrofactuprincipal.getTipoParamFactuListadoCliente(),connexion);
		TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic= new TipoParamFactuListadoClienteLogic(connexion);
		tipoparamfactulistadoclienteLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuListadoCliente(),isDeep,deepLoadType,clases);
				

		TipoParamFactuSecuenciaTrabajoDataAccess.save(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),connexion);
		TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic= new TipoParamFactuSecuenciaTrabajoLogic(connexion);
		tipoparamfactusecuenciatrabajoLogic.deepLoad(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoFactura(),connexion);
		TipoDocumentoLogic tipodocumentofacturaLogic= new TipoDocumentoLogic(connexion);
		tipodocumentofacturaLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaCredito(),connexion);
		TipoDocumentoLogic tipodocumentonotacreditoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotacreditoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaDebito(),connexion);
		TipoDocumentoLogic tipodocumentonotadebitoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotadebitoLogic.deepLoad(parametrofactuprincipal.getTipoDocumentoNotaDebito(),isDeep,deepLoadType,clases);
				

		LibroContableDataAccess.save(parametrofactuprincipal.getLibroContable(),connexion);
		LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
		librocontableLogic.deepLoad(parametrofactuprincipal.getLibroContable(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(parametrofactuprincipal.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametrofactuprincipal.getMoneda(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactuprincipal.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(parametrofactuprincipal.getFormato(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFleteVenta(),connexion);
		CuentaContableLogic cuentacontablefleteventaLogic= new CuentaContableLogic(connexion);
		cuentacontablefleteventaLogic.deepLoad(parametrofactuprincipal.getCuentaContableFleteVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableOtroCargo(),connexion);
		CuentaContableLogic cuentacontableotrocargoLogic= new CuentaContableLogic(connexion);
		cuentacontableotrocargoLogic.deepLoad(parametrofactuprincipal.getCuentaContableOtroCargo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFinan(),connexion);
		CuentaContableLogic cuentacontablefinanLogic= new CuentaContableLogic(connexion);
		cuentacontablefinanLogic.deepLoad(parametrofactuprincipal.getCuentaContableFinan(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoni(),connexion);
		CuentaContableLogic cuentacontableboniLogic= new CuentaContableLogic(connexion);
		cuentacontableboniLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoni(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoniDevol(),connexion);
		CuentaContableLogic cuentacontablebonidevolLogic= new CuentaContableLogic(connexion);
		cuentacontablebonidevolLogic.deepLoad(parametrofactuprincipal.getCuentaContableBoniDevol(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableIce(),connexion);
		CuentaContableLogic cuentacontableiceLogic= new CuentaContableLogic(connexion);
		cuentacontableiceLogic.deepLoad(parametrofactuprincipal.getCuentaContableIce(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuprincipal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactuprincipal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuprincipal.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactuprincipal.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuDescuento.class)) {
				TipoParamFactuDescuentoDataAccess.save(parametrofactuprincipal.getTipoParamFactuDescuento(),connexion);
				TipoParamFactuDescuentoLogic tipoparamfactudescuentoLogic= new TipoParamFactuDescuentoLogic(connexion);
				tipoparamfactudescuentoLogic.deepSave(parametrofactuprincipal.getTipoParamFactuDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
				TipoParamFactuListadoClienteDataAccess.save(parametrofactuprincipal.getTipoParamFactuListadoCliente(),connexion);
				TipoParamFactuListadoClienteLogic tipoparamfactulistadoclienteLogic= new TipoParamFactuListadoClienteLogic(connexion);
				tipoparamfactulistadoclienteLogic.deepSave(parametrofactuprincipal.getTipoParamFactuListadoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
				TipoParamFactuSecuenciaTrabajoDataAccess.save(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),connexion);
				TipoParamFactuSecuenciaTrabajoLogic tipoparamfactusecuenciatrabajoLogic= new TipoParamFactuSecuenciaTrabajoLogic(connexion);
				tipoparamfactusecuenciatrabajoLogic.deepSave(parametrofactuprincipal.getTipoParamFactuSecuenciaTrabajo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoFactura(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(parametrofactuprincipal.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaCredito(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(parametrofactuprincipal.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrofactuprincipal.getTipoDocumentoNotaDebito(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(parametrofactuprincipal.getTipoDocumentoNotaDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				LibroContableDataAccess.save(parametrofactuprincipal.getLibroContable(),connexion);
				LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
				librocontableLogic.deepSave(parametrofactuprincipal.getLibroContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametrofactuprincipal.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(parametrofactuprincipal.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactuprincipal.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactuprincipal.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFleteVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactuprincipal.getCuentaContableFleteVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableOtroCargo(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactuprincipal.getCuentaContableOtroCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableFinan(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactuprincipal.getCuentaContableFinan(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoni(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactuprincipal.getCuentaContableBoni(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableBoniDevol(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactuprincipal.getCuentaContableBoniDevol(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactuprincipal.getCuentaContableIce(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactuprincipal.getCuentaContableIce(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroFactuPrincipal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofactuprincipal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(parametrofactuprincipal);
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
			this.deepLoad(this.parametrofactuprincipal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFactuPrincipal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofactuprincipals!=null) {
				for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals) {
					this.deepLoad(parametrofactuprincipal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(parametrofactuprincipals);
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
			if(parametrofactuprincipals!=null) {
				for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals) {
					this.deepLoad(parametrofactuprincipal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(parametrofactuprincipals);
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
			this.getNewConnexionToDeep(ParametroFactuPrincipal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofactuprincipal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFactuPrincipal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofactuprincipals!=null) {
				for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals) {
					this.deepSave(parametrofactuprincipal,isDeep,deepLoadType,clases);
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
			if(parametrofactuprincipals!=null) {
				for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals) {
					this.deepSave(parametrofactuprincipal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFactuPrincipalsFK_IdCuentaContableBoniWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_boni)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBoni= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBoni.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_boni,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBoni);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBoni","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableBoni(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_boni)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBoni= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBoni.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_boni,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBoni);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBoni","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableBoniDevolWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_boni_devol)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBoniDevol= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBoniDevol.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_boni_devol,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBoniDevol);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBoniDevol","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableBoniDevol(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_boni_devol)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBoniDevol= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBoniDevol.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_boni_devol,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBoniDevol);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBoniDevol","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableFinanWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_finan)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFinan= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFinan.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_finan,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFinan);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFinan","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableFinan(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_finan)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFinan= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFinan.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_finan,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFinan);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFinan","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableFleteVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_flete_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFleteVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFleteVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_flete_venta,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFleteVenta);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFleteVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableFleteVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_flete_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFleteVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFleteVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_flete_venta,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFleteVenta);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFleteVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableIceWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ice)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIce= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIce.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ice,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIce);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIce","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableIce(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ice)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIce= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIce.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ice,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIce);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIce","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableOtroCargoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_otro_cargo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableOtroCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableOtroCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_otro_cargo,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableOtroCargo);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableOtroCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdCuentaContableOtroCargo(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_otro_cargo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableOtroCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableOtroCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_otro_cargo,ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableOtroCargo);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableOtroCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuPrincipalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuPrincipalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ParametroFactuPrincipalConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ParametroFactuPrincipalConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdLibroContableWithConnection(String sFinalQuery,Pagination pagination,Long id_libro_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLibroContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLibroContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_libro_contable,ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLibroContable);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLibroContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdLibroContable(String sFinalQuery,Pagination pagination,Long id_libro_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLibroContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLibroContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_libro_contable,ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLibroContable);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLibroContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroFactuPrincipalConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroFactuPrincipalConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoDocumentoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_factura,ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoFactura);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoDocumentoFactura(String sFinalQuery,Pagination pagination,Long id_tipo_documento_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_factura,ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoFactura);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoDocumentoNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_credito,ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaCredito);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoDocumentoNotaCredito(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_credito,ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaCredito);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoDocumentoNotaDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_debito,ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaDebito);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoDocumentoNotaDebito(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_debito,ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaDebito);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoParamFactuDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_descuento,ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuDescuento);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoParamFactuDescuento(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_descuento,ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuDescuento);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoParamFactuListadoClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_listado_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuListadoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuListadoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_listado_cliente,ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuListadoCliente);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuListadoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoParamFactuListadoCliente(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_listado_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuListadoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuListadoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_listado_cliente,ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuListadoCliente);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuListadoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoParamFactuSecuenciaTrabajoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_secuencia_trabajo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuPrincipal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuSecuenciaTrabajo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuSecuenciaTrabajo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_secuencia_trabajo,ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuSecuenciaTrabajo);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuSecuenciaTrabajo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuPrincipalsFK_IdTipoParamFactuSecuenciaTrabajo(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_secuencia_trabajo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuSecuenciaTrabajo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuSecuenciaTrabajo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_secuencia_trabajo,ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuSecuenciaTrabajo);

			ParametroFactuPrincipalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuSecuenciaTrabajo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(this.parametrofactuprincipals);
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
			if(ParametroFactuPrincipalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuPrincipalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFactuPrincipal parametrofactuprincipal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFactuPrincipalConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofactuprincipal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuPrincipalDataAccess.TABLENAME, parametrofactuprincipal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuPrincipalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuPrincipalLogic.registrarAuditoriaDetallesParametroFactuPrincipal(connexion,parametrofactuprincipal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofactuprincipal.getIsDeleted()) {
					/*if(!parametrofactuprincipal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFactuPrincipalDataAccess.TABLENAME, parametrofactuprincipal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFactuPrincipalLogic.registrarAuditoriaDetallesParametroFactuPrincipal(connexion,parametrofactuprincipal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuPrincipalDataAccess.TABLENAME, parametrofactuprincipal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofactuprincipal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuPrincipalDataAccess.TABLENAME, parametrofactuprincipal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuPrincipalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuPrincipalLogic.registrarAuditoriaDetallesParametroFactuPrincipal(connexion,parametrofactuprincipal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFactuPrincipal(Connexion connexion,ParametroFactuPrincipal parametrofactuprincipal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_empresa().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_empresa().toString();
				}
				if(parametrofactuprincipal.getid_empresa()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_sucursal().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_sucursal().toString();
				}
				if(parametrofactuprincipal.getid_sucursal()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_tipo_param_factu_descuento().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_descuento()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_descuento().toString();
				}
				if(parametrofactuprincipal.getid_tipo_param_factu_descuento()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_tipo_param_factu_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_tipo_param_factu_listado_cliente().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_listado_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_listado_cliente()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_listado_cliente().toString();
				}
				if(parametrofactuprincipal.getid_tipo_param_factu_listado_cliente()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_tipo_param_factu_listado_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_secuencia_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_secuencia_trabajo()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_param_factu_secuencia_trabajo().toString();
				}
				if(parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_tipo_documento_factura().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_factura()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_factura().toString();
				}
				if(parametrofactuprincipal.getid_tipo_documento_factura()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_tipo_documento_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_tipo_documento_nota_credito().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_nota_credito()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_nota_credito().toString();
				}
				if(parametrofactuprincipal.getid_tipo_documento_nota_credito()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_tipo_documento_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_tipo_documento_nota_debito().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_nota_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_nota_debito()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_tipo_documento_nota_debito().toString();
				}
				if(parametrofactuprincipal.getid_tipo_documento_nota_debito()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_tipo_documento_nota_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.geten_linea().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().geten_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().geten_linea()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().geten_linea().toString();
				}
				if(parametrofactuprincipal.geten_linea()!=null)
				{
					strValorNuevo=parametrofactuprincipal.geten_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.ENLINEA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_cuenta_tipo_cliente().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cuenta_tipo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cuenta_tipo_cliente()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cuenta_tipo_cliente().toString();
				}
				if(parametrofactuprincipal.getcon_cuenta_tipo_cliente()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_cuenta_tipo_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_cliente_impuesto().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cliente_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cliente_impuesto()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cliente_impuesto().toString();
				}
				if(parametrofactuprincipal.getcon_cliente_impuesto()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_cliente_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_libro_contable().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_libro_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_libro_contable()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_libro_contable().toString();
				}
				if(parametrofactuprincipal.getid_libro_contable()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_libro_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_moneda().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_moneda()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_moneda().toString();
				}
				if(parametrofactuprincipal.getid_moneda()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_impresion().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_impresion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_impresion()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_impresion().toString();
				}
				if(parametrofactuprincipal.getcon_impresion()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_impresion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONIMPRESION,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_formato().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_formato()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_formato().toString();
				}
				if(parametrofactuprincipal.getid_formato()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_secuencial_usuario().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_secuencial_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_secuencial_usuario()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_secuencial_usuario().toString();
				}
				if(parametrofactuprincipal.getcon_secuencial_usuario()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_secuencial_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_secuencial_editable().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_secuencial_editable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_secuencial_editable()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_secuencial_editable().toString();
				}
				if(parametrofactuprincipal.getcon_secuencial_editable()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_secuencial_editable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_precio_por_cliente().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_precio_por_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_precio_por_cliente()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_precio_por_cliente().toString();
				}
				if(parametrofactuprincipal.getcon_precio_por_cliente()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_precio_por_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_modificar_precio().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_modificar_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_modificar_precio()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_modificar_precio().toString();
				}
				if(parametrofactuprincipal.getcon_modificar_precio()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_modificar_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_modificar_servicio().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_modificar_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_modificar_servicio()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_modificar_servicio().toString();
				}
				if(parametrofactuprincipal.getcon_modificar_servicio()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_modificar_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_cambiar_unidad().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cambiar_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cambiar_unidad()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cambiar_unidad().toString();
				}
				if(parametrofactuprincipal.getcon_cambiar_unidad()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_cambiar_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getnumero_decimales_unidad().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getnumero_decimales_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getnumero_decimales_unidad()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getnumero_decimales_unidad().toString();
				}
				if(parametrofactuprincipal.getnumero_decimales_unidad()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getnumero_decimales_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_activar_serie().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_serie()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_serie().toString();
				}
				if(parametrofactuprincipal.getcon_activar_serie()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_activar_serie().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_activar_lote().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_lote()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_lote().toString();
				}
				if(parametrofactuprincipal.getcon_activar_lote()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_activar_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_activar_multi_empresa().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_multi_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_multi_empresa()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_activar_multi_empresa().toString();
				}
				if(parametrofactuprincipal.getcon_activar_multi_empresa()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_activar_multi_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_centro_costos().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_centro_costos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_centro_costos()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_centro_costos().toString();
				}
				if(parametrofactuprincipal.getcon_centro_costos()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_centro_costos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_unidades().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_unidades()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_unidades()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_unidades().toString();
				}
				if(parametrofactuprincipal.getcon_unidades()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_unidades().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONUNIDADES,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_cupo_disponible().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cupo_disponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cupo_disponible()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_cupo_disponible().toString();
				}
				if(parametrofactuprincipal.getcon_cupo_disponible()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_cupo_disponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_forma_pago().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_forma_pago()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_forma_pago().toString();
				}
				if(parametrofactuprincipal.getcon_forma_pago()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_envio_mail().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_envio_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_envio_mail()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_envio_mail().toString();
				}
				if(parametrofactuprincipal.getcon_envio_mail()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_envio_mail().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_autorizar_proforma().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_autorizar_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_autorizar_proforma()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_autorizar_proforma().toString();
				}
				if(parametrofactuprincipal.getcon_autorizar_proforma()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_autorizar_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_bloqueo_pedido().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_bloqueo_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_bloqueo_pedido()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_bloqueo_pedido().toString();
				}
				if(parametrofactuprincipal.getcon_bloqueo_pedido()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_bloqueo_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_control_anticipo().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_control_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_control_anticipo()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_control_anticipo().toString();
				}
				if(parametrofactuprincipal.getcon_control_anticipo()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_control_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_factura_auto().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_factura_auto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_factura_auto()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_factura_auto().toString();
				}
				if(parametrofactuprincipal.getcon_factura_auto()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_factura_auto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_grabar_valor_cero().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_grabar_valor_cero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_grabar_valor_cero()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_grabar_valor_cero().toString();
				}
				if(parametrofactuprincipal.getcon_grabar_valor_cero()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_grabar_valor_cero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_agregar_item().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_agregar_item()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_agregar_item()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_agregar_item().toString();
				}
				if(parametrofactuprincipal.getcon_agregar_item()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_agregar_item().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getnumero_copias().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getnumero_copias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getnumero_copias()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getnumero_copias().toString();
				}
				if(parametrofactuprincipal.getnumero_copias()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getnumero_copias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getleyenda().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getleyenda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getleyenda()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getleyenda();
				}
				if(parametrofactuprincipal.getleyenda()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getleyenda() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.LEYENDA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getcon_sin_factura().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_sin_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_sin_factura()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getcon_sin_factura().toString();
				}
				if(parametrofactuprincipal.getcon_sin_factura()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getcon_sin_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_cuenta_contable_flete_venta().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_flete_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_flete_venta()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_flete_venta().toString();
				}
				if(parametrofactuprincipal.getid_cuenta_contable_flete_venta()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_cuenta_contable_flete_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_cuenta_contable_otro_cargo().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_otro_cargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_otro_cargo()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_otro_cargo().toString();
				}
				if(parametrofactuprincipal.getid_cuenta_contable_otro_cargo()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_cuenta_contable_otro_cargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_cuenta_contable_finan().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_finan()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_finan()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_finan().toString();
				}
				if(parametrofactuprincipal.getid_cuenta_contable_finan()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_cuenta_contable_finan().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_cuenta_contable_boni().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_boni()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_boni()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_boni().toString();
				}
				if(parametrofactuprincipal.getid_cuenta_contable_boni()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_cuenta_contable_boni().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_cuenta_contable_boni_devol().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_boni_devol()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_boni_devol()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_boni_devol().toString();
				}
				if(parametrofactuprincipal.getid_cuenta_contable_boni_devol()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_cuenta_contable_boni_devol().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuprincipal.getIsNew()||!parametrofactuprincipal.getid_cuenta_contable_ice().equals(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_ice()!=null)
				{
					strValorActual=parametrofactuprincipal.getParametroFactuPrincipalOriginal().getid_cuenta_contable_ice().toString();
				}
				if(parametrofactuprincipal.getid_cuenta_contable_ice()!=null)
				{
					strValorNuevo=parametrofactuprincipal.getid_cuenta_contable_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFactuPrincipalRelacionesWithConnection(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {

		if(!parametrofactuprincipal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuPrincipalRelacionesBase(parametrofactuprincipal,true);
		}
	}

	public void saveParametroFactuPrincipalRelaciones(ParametroFactuPrincipal parametrofactuprincipal)throws Exception {

		if(!parametrofactuprincipal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuPrincipalRelacionesBase(parametrofactuprincipal,false);
		}
	}

	public void saveParametroFactuPrincipalRelacionesBase(ParametroFactuPrincipal parametrofactuprincipal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFactuPrincipal-saveRelacionesWithConnection");}
	

			this.setParametroFactuPrincipal(parametrofactuprincipal);

			if(ParametroFactuPrincipalLogicAdditional.validarSaveRelaciones(parametrofactuprincipal,this)) {

				ParametroFactuPrincipalLogicAdditional.updateRelacionesToSave(parametrofactuprincipal,this);

				if((parametrofactuprincipal.getIsNew()||parametrofactuprincipal.getIsChanged())&&!parametrofactuprincipal.getIsDeleted()) {
					this.saveParametroFactuPrincipal();
					this.saveParametroFactuPrincipalRelacionesDetalles();

				} else if(parametrofactuprincipal.getIsDeleted()) {
					this.saveParametroFactuPrincipalRelacionesDetalles();
					this.saveParametroFactuPrincipal();
				}

				ParametroFactuPrincipalLogicAdditional.updateRelacionesToSaveAfter(parametrofactuprincipal,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
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
	
	
	private void saveParametroFactuPrincipalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuPrincipal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuPrincipalConstantesFunciones.getClassesForeignKeysOfParametroFactuPrincipal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuPrincipal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuPrincipalConstantesFunciones.getClassesRelationshipsOfParametroFactuPrincipal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
