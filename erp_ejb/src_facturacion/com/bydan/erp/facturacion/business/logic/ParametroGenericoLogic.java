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
import com.bydan.erp.facturacion.util.ParametroGenericoConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroGenericoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroGenericoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroGenerico;
import com.bydan.erp.facturacion.business.logic.ParametroGenericoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroGenericoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroGenericoLogic.class);
	
	protected ParametroGenericoDataAccess parametrogenericoDataAccess; 	
	protected ParametroGenerico parametrogenerico;
	protected List<ParametroGenerico> parametrogenericos;
	protected Object parametrogenericoObject;	
	protected List<Object> parametrogenericosObject;
	
	public static ClassValidator<ParametroGenerico> parametrogenericoValidator = new ClassValidator<ParametroGenerico>(ParametroGenerico.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroGenericoLogicAdditional parametrogenericoLogicAdditional=null;
	
	public ParametroGenericoLogicAdditional getParametroGenericoLogicAdditional() {
		return this.parametrogenericoLogicAdditional;
	}
	
	public void setParametroGenericoLogicAdditional(ParametroGenericoLogicAdditional parametrogenericoLogicAdditional) {
		try {
			this.parametrogenericoLogicAdditional=parametrogenericoLogicAdditional;
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
	
	
	
	
	public  ParametroGenericoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrogenericoDataAccess = new ParametroGenericoDataAccess();
			
			this.parametrogenericos= new ArrayList<ParametroGenerico>();
			this.parametrogenerico= new ParametroGenerico();
			
			this.parametrogenericoObject=new Object();
			this.parametrogenericosObject=new ArrayList<Object>();
				
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
			
			this.parametrogenericoDataAccess.setConnexionType(this.connexionType);
			this.parametrogenericoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroGenericoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrogenericoDataAccess = new ParametroGenericoDataAccess();
			this.parametrogenericos= new ArrayList<ParametroGenerico>();
			this.parametrogenerico= new ParametroGenerico();
			this.parametrogenericoObject=new Object();
			this.parametrogenericosObject=new ArrayList<Object>();
			
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
			
			this.parametrogenericoDataAccess.setConnexionType(this.connexionType);
			this.parametrogenericoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroGenerico getParametroGenerico() throws Exception {	
		ParametroGenericoLogicAdditional.checkParametroGenericoToGet(parametrogenerico,this.datosCliente,this.arrDatoGeneral);
		ParametroGenericoLogicAdditional.updateParametroGenericoToGet(parametrogenerico,this.arrDatoGeneral);
		
		return parametrogenerico;
	}
		
	public void setParametroGenerico(ParametroGenerico newParametroGenerico) {
		this.parametrogenerico = newParametroGenerico;
	}
	
	public ParametroGenericoDataAccess getParametroGenericoDataAccess() {
		return parametrogenericoDataAccess;
	}
	
	public void setParametroGenericoDataAccess(ParametroGenericoDataAccess newparametrogenericoDataAccess) {
		this.parametrogenericoDataAccess = newparametrogenericoDataAccess;
	}
	
	public List<ParametroGenerico> getParametroGenericos() throws Exception {		
		this.quitarParametroGenericosNulos();
		
		ParametroGenericoLogicAdditional.checkParametroGenericoToGets(parametrogenericos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroGenerico parametrogenericoLocal: parametrogenericos ) {
			ParametroGenericoLogicAdditional.updateParametroGenericoToGet(parametrogenericoLocal,this.arrDatoGeneral);
		}
		
		return parametrogenericos;
	}
	
	public void setParametroGenericos(List<ParametroGenerico> newParametroGenericos) {
		this.parametrogenericos = newParametroGenericos;
	}
	
	public Object getParametroGenericoObject() {	
		this.parametrogenericoObject=this.parametrogenericoDataAccess.getEntityObject();
		return this.parametrogenericoObject;
	}
		
	public void setParametroGenericoObject(Object newParametroGenericoObject) {
		this.parametrogenericoObject = newParametroGenericoObject;
	}
	
	public List<Object> getParametroGenericosObject() {		
		this.parametrogenericosObject=this.parametrogenericoDataAccess.getEntitiesObject();
		return this.parametrogenericosObject;
	}
		
	public void setParametroGenericosObject(List<Object> newParametroGenericosObject) {
		this.parametrogenericosObject = newParametroGenericosObject;
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
		
		if(this.parametrogenericoDataAccess!=null) {
			this.parametrogenericoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrogenericoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrogenericoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrogenerico = new  ParametroGenerico();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogenerico=parametrogenericoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogenerico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
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
		parametrogenerico = new  ParametroGenerico();
		  		  
        try {
			
			parametrogenerico=parametrogenericoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogenerico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrogenerico = new  ParametroGenerico();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogenerico=parametrogenericoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogenerico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
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
		parametrogenerico = new  ParametroGenerico();
		  		  
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
		parametrogenerico = new  ParametroGenerico();
		  		  
        try {
			
			parametrogenerico=parametrogenericoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogenerico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrogenerico = new  ParametroGenerico();
		  		  
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
		parametrogenerico = new  ParametroGenerico();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrogenericoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogenerico = new  ParametroGenerico();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrogenericoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogenerico = new  ParametroGenerico();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrogenericoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogenerico = new  ParametroGenerico();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrogenericoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogenerico = new  ParametroGenerico();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrogenericoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogenerico = new  ParametroGenerico();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrogenericoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
        try {			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
        try {
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrogenerico = new  ParametroGenerico();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerico=parametrogenericoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenerico);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
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
		parametrogenerico = new  ParametroGenerico();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerico=parametrogenericoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenerico);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		  		  
        try {
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroGenericosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getTodosParametroGenericosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
	
	public  void  getTodosParametroGenericos(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogenericos = new  ArrayList<ParametroGenerico>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGenerico(parametrogenericos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroGenerico(ParametroGenerico parametrogenerico) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrogenerico.getIsNew() || parametrogenerico.getIsChanged()) { 
			this.invalidValues = parametrogenericoValidator.getInvalidValues(parametrogenerico);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrogenerico);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroGenerico(List<ParametroGenerico> ParametroGenericos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroGenerico parametrogenericoLocal:parametrogenericos) {				
			estaValidadoObjeto=this.validarGuardarParametroGenerico(parametrogenericoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroGenerico(List<ParametroGenerico> ParametroGenericos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGenerico(parametrogenericos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroGenerico(ParametroGenerico ParametroGenerico) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGenerico(parametrogenerico)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroGenerico parametrogenerico) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrogenerico.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroGenericoConstantesFunciones.getParametroGenericoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrogenerico","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroGenericoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroGenericoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroGenericoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-saveParametroGenericoWithConnection");connexion.begin();			
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSave(this.parametrogenerico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGenericoLogicAdditional.updateParametroGenericoToSave(this.parametrogenerico,this.arrDatoGeneral);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogenerico,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroGenerico();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGenerico(this.parametrogenerico)) {
				ParametroGenericoDataAccess.save(this.parametrogenerico, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrogenerico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSaveAfter(this.parametrogenerico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGenerico();
			
			connexion.commit();			
			
			if(this.parametrogenerico.getIsDeleted()) {
				this.parametrogenerico=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroGenerico()throws Exception {	
		try {	
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSave(this.parametrogenerico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGenericoLogicAdditional.updateParametroGenericoToSave(this.parametrogenerico,this.arrDatoGeneral);
			
			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogenerico,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGenerico(this.parametrogenerico)) {			
				ParametroGenericoDataAccess.save(this.parametrogenerico, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrogenerico,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSaveAfter(this.parametrogenerico,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrogenerico.getIsDeleted()) {
				this.parametrogenerico=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroGenericosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-saveParametroGenericosWithConnection");connexion.begin();			
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSaves(parametrogenericos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroGenericos();
			
			Boolean validadoTodosParametroGenerico=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGenerico parametrogenericoLocal:parametrogenericos) {		
				if(parametrogenericoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGenericoLogicAdditional.updateParametroGenericoToSave(parametrogenericoLocal,this.arrDatoGeneral);
	        	
				ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogenericoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGenerico(parametrogenericoLocal)) {
					ParametroGenericoDataAccess.save(parametrogenericoLocal, connexion);				
				} else {
					validadoTodosParametroGenerico=false;
				}
			}
			
			if(!validadoTodosParametroGenerico) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSavesAfter(parametrogenericos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGenericos();
			
			connexion.commit();		
			
			this.quitarParametroGenericosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroGenericos()throws Exception {				
		 try {	
			ParametroGenericoLogicAdditional.checkParametroGenericoToSaves(parametrogenericos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroGenerico=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGenerico parametrogenericoLocal:parametrogenericos) {				
				if(parametrogenericoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGenericoLogicAdditional.updateParametroGenericoToSave(parametrogenericoLocal,this.arrDatoGeneral);
	        	
				ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogenericoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGenerico(parametrogenericoLocal)) {				
					ParametroGenericoDataAccess.save(parametrogenericoLocal, connexion);				
				} else {
					validadoTodosParametroGenerico=false;
				}
			}
			
			if(!validadoTodosParametroGenerico) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGenericoLogicAdditional.checkParametroGenericoToSavesAfter(parametrogenericos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroGenericosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGenericoParameterReturnGeneral procesarAccionParametroGenericos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGenerico> parametrogenericos,ParametroGenericoParameterReturnGeneral parametrogenericoParameterGeneral)throws Exception {
		 try {	
			ParametroGenericoParameterReturnGeneral parametrogenericoReturnGeneral=new ParametroGenericoParameterReturnGeneral();
	
			ParametroGenericoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogenericos,parametrogenericoParameterGeneral,parametrogenericoReturnGeneral);
			
			return parametrogenericoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGenericoParameterReturnGeneral procesarAccionParametroGenericosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGenerico> parametrogenericos,ParametroGenericoParameterReturnGeneral parametrogenericoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-procesarAccionParametroGenericosWithConnection");connexion.begin();			
			
			ParametroGenericoParameterReturnGeneral parametrogenericoReturnGeneral=new ParametroGenericoParameterReturnGeneral();
	
			ParametroGenericoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogenericos,parametrogenericoParameterGeneral,parametrogenericoReturnGeneral);
			
			this.connexion.commit();
			
			return parametrogenericoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGenericoParameterReturnGeneral procesarEventosParametroGenericos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGenerico> parametrogenericos,ParametroGenerico parametrogenerico,ParametroGenericoParameterReturnGeneral parametrogenericoParameterGeneral,Boolean isEsNuevoParametroGenerico,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroGenericoParameterReturnGeneral parametrogenericoReturnGeneral=new ParametroGenericoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogenericoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGenericoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogenericos,parametrogenerico,parametrogenericoParameterGeneral,parametrogenericoReturnGeneral,isEsNuevoParametroGenerico,clases);
			
			return parametrogenericoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroGenericoParameterReturnGeneral procesarEventosParametroGenericosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGenerico> parametrogenericos,ParametroGenerico parametrogenerico,ParametroGenericoParameterReturnGeneral parametrogenericoParameterGeneral,Boolean isEsNuevoParametroGenerico,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-procesarEventosParametroGenericosWithConnection");connexion.begin();			
			
			ParametroGenericoParameterReturnGeneral parametrogenericoReturnGeneral=new ParametroGenericoParameterReturnGeneral();
	
			parametrogenericoReturnGeneral.setParametroGenerico(parametrogenerico);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogenericoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGenericoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogenericos,parametrogenerico,parametrogenericoParameterGeneral,parametrogenericoReturnGeneral,isEsNuevoParametroGenerico,clases);
			
			this.connexion.commit();
			
			return parametrogenericoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGenericoParameterReturnGeneral procesarImportacionParametroGenericosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroGenericoParameterReturnGeneral parametrogenericoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-procesarImportacionParametroGenericosWithConnection");connexion.begin();			
			
			ParametroGenericoParameterReturnGeneral parametrogenericoReturnGeneral=new ParametroGenericoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrogenericos=new ArrayList<ParametroGenerico>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrogenerico=new ParametroGenerico();
				
				
				if(conColumnasBase) {this.parametrogenerico.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrogenerico.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrogenerico.setsecuencial(arrColumnas[iColumn++]);
				this.parametrogenerico.setcodigo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrogenericos.add(this.parametrogenerico);
			}
			
			this.saveParametroGenericos();
			
			this.connexion.commit();
			
			parametrogenericoReturnGeneral.setConRetornoEstaProcesado(true);
			parametrogenericoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrogenericoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroGenericosEliminados() throws Exception {				
		
		List<ParametroGenerico> parametrogenericosAux= new ArrayList<ParametroGenerico>();
		
		for(ParametroGenerico parametrogenerico:parametrogenericos) {
			if(!parametrogenerico.getIsDeleted()) {
				parametrogenericosAux.add(parametrogenerico);
			}
		}
		
		parametrogenericos=parametrogenericosAux;
	}
	
	public void quitarParametroGenericosNulos() throws Exception {				
		
		List<ParametroGenerico> parametrogenericosAux= new ArrayList<ParametroGenerico>();
		
		for(ParametroGenerico parametrogenerico : this.parametrogenericos) {
			if(parametrogenerico==null) {
				parametrogenericosAux.add(parametrogenerico);
			}
		}
		
		//this.parametrogenericos=parametrogenericosAux;
		
		this.parametrogenericos.removeAll(parametrogenericosAux);
	}
	
	public void getSetVersionRowParametroGenericoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrogenerico.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrogenerico.getIsDeleted() || (parametrogenerico.getIsChanged()&&!parametrogenerico.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrogenericoDataAccess.getSetVersionRowParametroGenerico(connexion,parametrogenerico.getId());
				
				if(!parametrogenerico.getVersionRow().equals(timestamp)) {	
					parametrogenerico.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrogenerico.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroGenerico()throws Exception {	
		
		if(parametrogenerico.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrogenerico.getIsDeleted() || (parametrogenerico.getIsChanged()&&!parametrogenerico.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrogenericoDataAccess.getSetVersionRowParametroGenerico(connexion,parametrogenerico.getId());
			
			try {							
				if(!parametrogenerico.getVersionRow().equals(timestamp)) {	
					parametrogenerico.setVersionRow(timestamp);
				}
				
				parametrogenerico.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroGenericosWithConnection()throws Exception {	
		if(parametrogenericos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroGenerico parametrogenericoAux:parametrogenericos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrogenericoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogenericoAux.getIsDeleted() || (parametrogenericoAux.getIsChanged()&&!parametrogenericoAux.getIsNew())) {
						
						timestamp=parametrogenericoDataAccess.getSetVersionRowParametroGenerico(connexion,parametrogenericoAux.getId());
						
						if(!parametrogenerico.getVersionRow().equals(timestamp)) {	
							parametrogenericoAux.setVersionRow(timestamp);
						}
								
						parametrogenericoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroGenericos()throws Exception {	
		if(parametrogenericos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroGenerico parametrogenericoAux:parametrogenericos) {
					if(parametrogenericoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogenericoAux.getIsDeleted() || (parametrogenericoAux.getIsChanged()&&!parametrogenericoAux.getIsNew())) {
						
						timestamp=parametrogenericoDataAccess.getSetVersionRowParametroGenerico(connexion,parametrogenericoAux.getId());
						
						if(!parametrogenericoAux.getVersionRow().equals(timestamp)) {	
							parametrogenericoAux.setVersionRow(timestamp);
						}
						
													
						parametrogenericoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroGenericoParameterReturnGeneral cargarCombosLoteForeignKeyParametroGenericoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalTransaccionRecibo,String finalQueryGlobalBodega,String finalQueryGlobalServicio,String finalQueryGlobalFormato,String finalQueryGlobalFormatoRecibo) throws Exception {
		ParametroGenericoParameterReturnGeneral  parametrogenericoReturnGeneral =new ParametroGenericoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroGenericoWithConnection");connexion.begin();
			
			parametrogenericoReturnGeneral =new ParametroGenericoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrogenericoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrogenericoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			parametrogenericoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			parametrogenericoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Transaccion> transaccionrecibosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionreciboLogic=new TransaccionLogic();
			transaccionreciboLogic.setConnexion(this.connexion);
			transaccionreciboLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionRecibo.equals("NONE")) {
				transaccionreciboLogic.getTodosTransaccions(finalQueryGlobalTransaccionRecibo,new Pagination());
				transaccionrecibosForeignKey=transaccionreciboLogic.getTransaccions();
			}

			parametrogenericoReturnGeneral.settransaccionrecibosForeignKey(transaccionrecibosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrogenericoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Servicio> serviciosForeignKey=new ArrayList<Servicio>();
			ServicioLogic servicioLogic=new ServicioLogic();
			servicioLogic.setConnexion(this.connexion);
			servicioLogic.getServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalServicio.equals("NONE")) {
				servicioLogic.getTodosServicios(finalQueryGlobalServicio,new Pagination());
				serviciosForeignKey=servicioLogic.getServicios();
			}

			parametrogenericoReturnGeneral.setserviciosForeignKey(serviciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			parametrogenericoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Formato> formatorecibosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoreciboLogic=new FormatoLogic();
			formatoreciboLogic.setConnexion(this.connexion);
			formatoreciboLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoRecibo.equals("NONE")) {
				formatoreciboLogic.getTodosFormatos(finalQueryGlobalFormatoRecibo,new Pagination());
				formatorecibosForeignKey=formatoreciboLogic.getFormatos();
			}

			parametrogenericoReturnGeneral.setformatorecibosForeignKey(formatorecibosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrogenericoReturnGeneral;
	}
	
	public ParametroGenericoParameterReturnGeneral cargarCombosLoteForeignKeyParametroGenerico(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalTransaccionRecibo,String finalQueryGlobalBodega,String finalQueryGlobalServicio,String finalQueryGlobalFormato,String finalQueryGlobalFormatoRecibo) throws Exception {
		ParametroGenericoParameterReturnGeneral  parametrogenericoReturnGeneral =new ParametroGenericoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrogenericoReturnGeneral =new ParametroGenericoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrogenericoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrogenericoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			parametrogenericoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			parametrogenericoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Transaccion> transaccionrecibosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionreciboLogic=new TransaccionLogic();
			transaccionreciboLogic.setConnexion(this.connexion);
			transaccionreciboLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionRecibo.equals("NONE")) {
				transaccionreciboLogic.getTodosTransaccions(finalQueryGlobalTransaccionRecibo,new Pagination());
				transaccionrecibosForeignKey=transaccionreciboLogic.getTransaccions();
			}

			parametrogenericoReturnGeneral.settransaccionrecibosForeignKey(transaccionrecibosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrogenericoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Servicio> serviciosForeignKey=new ArrayList<Servicio>();
			ServicioLogic servicioLogic=new ServicioLogic();
			servicioLogic.setConnexion(this.connexion);
			servicioLogic.getServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalServicio.equals("NONE")) {
				servicioLogic.getTodosServicios(finalQueryGlobalServicio,new Pagination());
				serviciosForeignKey=servicioLogic.getServicios();
			}

			parametrogenericoReturnGeneral.setserviciosForeignKey(serviciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			parametrogenericoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Formato> formatorecibosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoreciboLogic=new FormatoLogic();
			formatoreciboLogic.setConnexion(this.connexion);
			formatoreciboLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoRecibo.equals("NONE")) {
				formatoreciboLogic.getTodosFormatos(finalQueryGlobalFormatoRecibo,new Pagination());
				formatorecibosForeignKey=formatoreciboLogic.getFormatos();
			}

			parametrogenericoReturnGeneral.setformatorecibosForeignKey(formatorecibosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrogenericoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroGenerico parametrogenerico,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroGenericoLogicAdditional.updateParametroGenericoToGet(parametrogenerico,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrogenerico.setEmpresa(parametrogenericoDataAccess.getEmpresa(connexion,parametrogenerico));
		parametrogenerico.setSucursal(parametrogenericoDataAccess.getSucursal(connexion,parametrogenerico));
		parametrogenerico.setModulo(parametrogenericoDataAccess.getModulo(connexion,parametrogenerico));
		parametrogenerico.setTransaccion(parametrogenericoDataAccess.getTransaccion(connexion,parametrogenerico));
		parametrogenerico.setTransaccionRecibo(parametrogenericoDataAccess.getTransaccionRecibo(connexion,parametrogenerico));
		parametrogenerico.setBodega(parametrogenericoDataAccess.getBodega(connexion,parametrogenerico));
		parametrogenerico.setServicio(parametrogenericoDataAccess.getServicio(connexion,parametrogenerico));
		parametrogenerico.setFormato(parametrogenericoDataAccess.getFormato(connexion,parametrogenerico));
		parametrogenerico.setFormatoRecibo(parametrogenericoDataAccess.getFormatoRecibo(connexion,parametrogenerico));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrogenerico.setEmpresa(parametrogenericoDataAccess.getEmpresa(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrogenerico.setSucursal(parametrogenericoDataAccess.getSucursal(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				parametrogenerico.setModulo(parametrogenericoDataAccess.getModulo(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrogenerico.setTransaccion(parametrogenericoDataAccess.getTransaccion(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrogenerico.setTransaccionRecibo(parametrogenericoDataAccess.getTransaccionRecibo(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrogenerico.setBodega(parametrogenericoDataAccess.getBodega(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Servicio.class)) {
				parametrogenerico.setServicio(parametrogenericoDataAccess.getServicio(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrogenerico.setFormato(parametrogenericoDataAccess.getFormato(connexion,parametrogenerico));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrogenerico.setFormatoRecibo(parametrogenericoDataAccess.getFormatoRecibo(connexion,parametrogenerico));
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
			parametrogenerico.setEmpresa(parametrogenericoDataAccess.getEmpresa(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setSucursal(parametrogenericoDataAccess.getSucursal(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setModulo(parametrogenericoDataAccess.getModulo(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setTransaccion(parametrogenericoDataAccess.getTransaccion(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setTransaccionRecibo(parametrogenericoDataAccess.getTransaccionRecibo(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setBodega(parametrogenericoDataAccess.getBodega(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Servicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setServicio(parametrogenericoDataAccess.getServicio(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setFormato(parametrogenericoDataAccess.getFormato(connexion,parametrogenerico));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setFormatoRecibo(parametrogenericoDataAccess.getFormatoRecibo(connexion,parametrogenerico));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrogenerico.setEmpresa(parametrogenericoDataAccess.getEmpresa(connexion,parametrogenerico));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrogenerico.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setSucursal(parametrogenericoDataAccess.getSucursal(connexion,parametrogenerico));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrogenerico.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setModulo(parametrogenericoDataAccess.getModulo(connexion,parametrogenerico));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(parametrogenerico.getModulo(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setTransaccion(parametrogenericoDataAccess.getTransaccion(connexion,parametrogenerico));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(parametrogenerico.getTransaccion(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setTransaccionRecibo(parametrogenericoDataAccess.getTransaccionRecibo(connexion,parametrogenerico));
		TransaccionLogic transaccionreciboLogic= new TransaccionLogic(connexion);
		transaccionreciboLogic.deepLoad(parametrogenerico.getTransaccionRecibo(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setBodega(parametrogenericoDataAccess.getBodega(connexion,parametrogenerico));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrogenerico.getBodega(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setServicio(parametrogenericoDataAccess.getServicio(connexion,parametrogenerico));
		ServicioLogic servicioLogic= new ServicioLogic(connexion);
		servicioLogic.deepLoad(parametrogenerico.getServicio(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setFormato(parametrogenericoDataAccess.getFormato(connexion,parametrogenerico));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(parametrogenerico.getFormato(),isDeep,deepLoadType,clases);
				
		parametrogenerico.setFormatoRecibo(parametrogenericoDataAccess.getFormatoRecibo(connexion,parametrogenerico));
		FormatoLogic formatoreciboLogic= new FormatoLogic(connexion);
		formatoreciboLogic.deepLoad(parametrogenerico.getFormatoRecibo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrogenerico.setEmpresa(parametrogenericoDataAccess.getEmpresa(connexion,parametrogenerico));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrogenerico.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrogenerico.setSucursal(parametrogenericoDataAccess.getSucursal(connexion,parametrogenerico));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrogenerico.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				parametrogenerico.setModulo(parametrogenericoDataAccess.getModulo(connexion,parametrogenerico));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(parametrogenerico.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrogenerico.setTransaccion(parametrogenericoDataAccess.getTransaccion(connexion,parametrogenerico));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrogenerico.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrogenerico.setTransaccionRecibo(parametrogenericoDataAccess.getTransaccionRecibo(connexion,parametrogenerico));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrogenerico.getTransaccionRecibo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrogenerico.setBodega(parametrogenericoDataAccess.getBodega(connexion,parametrogenerico));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrogenerico.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Servicio.class)) {
				parametrogenerico.setServicio(parametrogenericoDataAccess.getServicio(connexion,parametrogenerico));
				ServicioLogic servicioLogic= new ServicioLogic(connexion);
				servicioLogic.deepLoad(parametrogenerico.getServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrogenerico.setFormato(parametrogenericoDataAccess.getFormato(connexion,parametrogenerico));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrogenerico.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrogenerico.setFormatoRecibo(parametrogenericoDataAccess.getFormatoRecibo(connexion,parametrogenerico));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrogenerico.getFormatoRecibo(),isDeep,deepLoadType,clases);				
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
			parametrogenerico.setEmpresa(parametrogenericoDataAccess.getEmpresa(connexion,parametrogenerico));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrogenerico.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setSucursal(parametrogenericoDataAccess.getSucursal(connexion,parametrogenerico));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrogenerico.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setModulo(parametrogenericoDataAccess.getModulo(connexion,parametrogenerico));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(parametrogenerico.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setTransaccion(parametrogenericoDataAccess.getTransaccion(connexion,parametrogenerico));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrogenerico.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setTransaccionRecibo(parametrogenericoDataAccess.getTransaccionRecibo(connexion,parametrogenerico));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrogenerico.getTransaccionRecibo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setBodega(parametrogenericoDataAccess.getBodega(connexion,parametrogenerico));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrogenerico.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Servicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setServicio(parametrogenericoDataAccess.getServicio(connexion,parametrogenerico));
			ServicioLogic servicioLogic= new ServicioLogic(connexion);
			servicioLogic.deepLoad(parametrogenerico.getServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setFormato(parametrogenericoDataAccess.getFormato(connexion,parametrogenerico));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrogenerico.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogenerico.setFormatoRecibo(parametrogenericoDataAccess.getFormatoRecibo(connexion,parametrogenerico));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrogenerico.getFormatoRecibo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroGenerico parametrogenerico,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroGenericoLogicAdditional.updateParametroGenericoToSave(parametrogenerico,this.arrDatoGeneral);
			
ParametroGenericoDataAccess.save(parametrogenerico, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrogenerico.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrogenerico.getSucursal(),connexion);

		ModuloDataAccess.save(parametrogenerico.getModulo(),connexion);

		TransaccionDataAccess.save(parametrogenerico.getTransaccion(),connexion);

		TransaccionDataAccess.save(parametrogenerico.getTransaccionRecibo(),connexion);

		BodegaDataAccess.save(parametrogenerico.getBodega(),connexion);

		ServicioDataAccess.save(parametrogenerico.getServicio(),connexion);

		FormatoDataAccess.save(parametrogenerico.getFormato(),connexion);

		FormatoDataAccess.save(parametrogenerico.getFormatoRecibo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrogenerico.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrogenerico.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(parametrogenerico.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrogenerico.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrogenerico.getTransaccionRecibo(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrogenerico.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Servicio.class)) {
				ServicioDataAccess.save(parametrogenerico.getServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrogenerico.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrogenerico.getFormatoRecibo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrogenerico.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrogenerico.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrogenerico.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrogenerico.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(parametrogenerico.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(parametrogenerico.getModulo(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrogenerico.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(parametrogenerico.getTransaccion(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrogenerico.getTransaccionRecibo(),connexion);
		TransaccionLogic transaccionreciboLogic= new TransaccionLogic(connexion);
		transaccionreciboLogic.deepLoad(parametrogenerico.getTransaccionRecibo(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrogenerico.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrogenerico.getBodega(),isDeep,deepLoadType,clases);
				

		ServicioDataAccess.save(parametrogenerico.getServicio(),connexion);
		ServicioLogic servicioLogic= new ServicioLogic(connexion);
		servicioLogic.deepLoad(parametrogenerico.getServicio(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrogenerico.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(parametrogenerico.getFormato(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrogenerico.getFormatoRecibo(),connexion);
		FormatoLogic formatoreciboLogic= new FormatoLogic(connexion);
		formatoreciboLogic.deepLoad(parametrogenerico.getFormatoRecibo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrogenerico.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrogenerico.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrogenerico.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrogenerico.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(parametrogenerico.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(parametrogenerico.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrogenerico.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrogenerico.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrogenerico.getTransaccionRecibo(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrogenerico.getTransaccionRecibo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrogenerico.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrogenerico.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Servicio.class)) {
				ServicioDataAccess.save(parametrogenerico.getServicio(),connexion);
				ServicioLogic servicioLogic= new ServicioLogic(connexion);
				servicioLogic.deepSave(parametrogenerico.getServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrogenerico.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrogenerico.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrogenerico.getFormatoRecibo(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrogenerico.getFormatoRecibo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroGenerico.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrogenerico,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(parametrogenerico);
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
			this.deepLoad(this.parametrogenerico,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenerico);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroGenerico.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrogenericos!=null) {
				for(ParametroGenerico parametrogenerico:parametrogenericos) {
					this.deepLoad(parametrogenerico,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(parametrogenericos);
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
			if(parametrogenericos!=null) {
				for(ParametroGenerico parametrogenerico:parametrogenericos) {
					this.deepLoad(parametrogenerico,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(parametrogenericos);
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
			this.getNewConnexionToDeep(ParametroGenerico.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrogenerico,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroGenerico.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrogenericos!=null) {
				for(ParametroGenerico parametrogenerico:parametrogenericos) {
					this.deepSave(parametrogenerico,isDeep,deepLoadType,clases);
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
			if(parametrogenericos!=null) {
				for(ParametroGenerico parametrogenerico:parametrogenericos) {
					this.deepSave(parametrogenerico,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroGenericosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroGenericoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroGenericoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGenericoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGenericoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ParametroGenericoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ParametroGenericoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdFormatoReciboWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_recibo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoRecibo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoRecibo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_recibo,ParametroGenericoConstantesFunciones.IDFORMATORECIBO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoRecibo);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoRecibo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdFormatoRecibo(String sFinalQuery,Pagination pagination,Long id_formato_recibo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoRecibo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoRecibo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_recibo,ParametroGenericoConstantesFunciones.IDFORMATORECIBO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoRecibo);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoRecibo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ParametroGenericoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ParametroGenericoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_servicio,ParametroGenericoConstantesFunciones.IDSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidServicio);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdServicio(String sFinalQuery,Pagination pagination,Long id_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_servicio,ParametroGenericoConstantesFunciones.IDSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidServicio);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroGenericoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroGenericoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,ParametroGenericoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,ParametroGenericoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGenericosFK_IdTransaccionReciboWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_recibo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGenerico.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionRecibo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionRecibo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_recibo,ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionRecibo);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionRecibo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGenericosFK_IdTransaccionRecibo(String sFinalQuery,Pagination pagination,Long id_transaccion_recibo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionRecibo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionRecibo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_recibo,ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionRecibo);

			ParametroGenericoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionRecibo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGenericoConstantesFunciones.refrescarForeignKeysDescripcionesParametroGenerico(this.parametrogenericos);
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
			if(ParametroGenericoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGenericoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroGenerico parametrogenerico,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroGenericoConstantesFunciones.ISCONAUDITORIA) {
				if(parametrogenerico.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGenericoDataAccess.TABLENAME, parametrogenerico.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGenericoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGenericoLogic.registrarAuditoriaDetallesParametroGenerico(connexion,parametrogenerico,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrogenerico.getIsDeleted()) {
					/*if(!parametrogenerico.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroGenericoDataAccess.TABLENAME, parametrogenerico.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroGenericoLogic.registrarAuditoriaDetallesParametroGenerico(connexion,parametrogenerico,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGenericoDataAccess.TABLENAME, parametrogenerico.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrogenerico.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGenericoDataAccess.TABLENAME, parametrogenerico.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGenericoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGenericoLogic.registrarAuditoriaDetallesParametroGenerico(connexion,parametrogenerico,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroGenerico(Connexion connexion,ParametroGenerico parametrogenerico)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_empresa().equals(parametrogenerico.getParametroGenericoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_empresa().toString();
				}
				if(parametrogenerico.getid_empresa()!=null)
				{
					strValorNuevo=parametrogenerico.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_sucursal().equals(parametrogenerico.getParametroGenericoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_sucursal().toString();
				}
				if(parametrogenerico.getid_sucursal()!=null)
				{
					strValorNuevo=parametrogenerico.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_modulo().equals(parametrogenerico.getParametroGenericoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_modulo()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_modulo().toString();
				}
				if(parametrogenerico.getid_modulo()!=null)
				{
					strValorNuevo=parametrogenerico.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getsecuencial().equals(parametrogenerico.getParametroGenericoOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getsecuencial()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getsecuencial();
				}
				if(parametrogenerico.getsecuencial()!=null)
				{
					strValorNuevo=parametrogenerico.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getcodigo().equals(parametrogenerico.getParametroGenericoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getcodigo()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getcodigo().toString();
				}
				if(parametrogenerico.getcodigo()!=null)
				{
					strValorNuevo=parametrogenerico.getcodigo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_transaccion().equals(parametrogenerico.getParametroGenericoOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_transaccion()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_transaccion().toString();
				}
				if(parametrogenerico.getid_transaccion()!=null)
				{
					strValorNuevo=parametrogenerico.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_transaccion_recibo().equals(parametrogenerico.getParametroGenericoOriginal().getid_transaccion_recibo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_transaccion_recibo()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_transaccion_recibo().toString();
				}
				if(parametrogenerico.getid_transaccion_recibo()!=null)
				{
					strValorNuevo=parametrogenerico.getid_transaccion_recibo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_bodega().equals(parametrogenerico.getParametroGenericoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_bodega()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_bodega().toString();
				}
				if(parametrogenerico.getid_bodega()!=null)
				{
					strValorNuevo=parametrogenerico.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_servicio().equals(parametrogenerico.getParametroGenericoOriginal().getid_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_servicio()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_servicio().toString();
				}
				if(parametrogenerico.getid_servicio()!=null)
				{
					strValorNuevo=parametrogenerico.getid_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_formato().equals(parametrogenerico.getParametroGenericoOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_formato()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_formato().toString();
				}
				if(parametrogenerico.getid_formato()!=null)
				{
					strValorNuevo=parametrogenerico.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogenerico.getIsNew()||!parametrogenerico.getid_formato_recibo().equals(parametrogenerico.getParametroGenericoOriginal().getid_formato_recibo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogenerico.getParametroGenericoOriginal().getid_formato_recibo()!=null)
				{
					strValorActual=parametrogenerico.getParametroGenericoOriginal().getid_formato_recibo().toString();
				}
				if(parametrogenerico.getid_formato_recibo()!=null)
				{
					strValorNuevo=parametrogenerico.getid_formato_recibo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGenericoConstantesFunciones.IDFORMATORECIBO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroGenericoRelacionesWithConnection(ParametroGenerico parametrogenerico) throws Exception {

		if(!parametrogenerico.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGenericoRelacionesBase(parametrogenerico,true);
		}
	}

	public void saveParametroGenericoRelaciones(ParametroGenerico parametrogenerico)throws Exception {

		if(!parametrogenerico.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGenericoRelacionesBase(parametrogenerico,false);
		}
	}

	public void saveParametroGenericoRelacionesBase(ParametroGenerico parametrogenerico,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroGenerico-saveRelacionesWithConnection");}
	

			this.setParametroGenerico(parametrogenerico);

			if(ParametroGenericoLogicAdditional.validarSaveRelaciones(parametrogenerico,this)) {

				ParametroGenericoLogicAdditional.updateRelacionesToSave(parametrogenerico,this);

				if((parametrogenerico.getIsNew()||parametrogenerico.getIsChanged())&&!parametrogenerico.getIsDeleted()) {
					this.saveParametroGenerico();
					this.saveParametroGenericoRelacionesDetalles();

				} else if(parametrogenerico.getIsDeleted()) {
					this.saveParametroGenericoRelacionesDetalles();
					this.saveParametroGenerico();
				}

				ParametroGenericoLogicAdditional.updateRelacionesToSaveAfter(parametrogenerico,this);

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
	
	
	private void saveParametroGenericoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGenerico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGenericoConstantesFunciones.getClassesForeignKeysOfParametroGenerico(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGenerico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGenericoConstantesFunciones.getClassesRelationshipsOfParametroGenerico(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
