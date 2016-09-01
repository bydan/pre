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
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.importaciones.util.ParametroImporConstantesFunciones;
import com.bydan.erp.importaciones.util.ParametroImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ParametroImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.ParametroImpor;
import com.bydan.erp.importaciones.business.logic.ParametroImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroImporLogic.class);
	
	protected ParametroImporDataAccess parametroimporDataAccess; 	
	protected ParametroImpor parametroimpor;
	protected List<ParametroImpor> parametroimpors;
	protected Object parametroimporObject;	
	protected List<Object> parametroimporsObject;
	
	public static ClassValidator<ParametroImpor> parametroimporValidator = new ClassValidator<ParametroImpor>(ParametroImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroImporLogicAdditional parametroimporLogicAdditional=null;
	
	public ParametroImporLogicAdditional getParametroImporLogicAdditional() {
		return this.parametroimporLogicAdditional;
	}
	
	public void setParametroImporLogicAdditional(ParametroImporLogicAdditional parametroimporLogicAdditional) {
		try {
			this.parametroimporLogicAdditional=parametroimporLogicAdditional;
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
	
	
	
	
	public  ParametroImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroimporDataAccess = new ParametroImporDataAccess();
			
			this.parametroimpors= new ArrayList<ParametroImpor>();
			this.parametroimpor= new ParametroImpor();
			
			this.parametroimporObject=new Object();
			this.parametroimporsObject=new ArrayList<Object>();
				
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
			
			this.parametroimporDataAccess.setConnexionType(this.connexionType);
			this.parametroimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroimporDataAccess = new ParametroImporDataAccess();
			this.parametroimpors= new ArrayList<ParametroImpor>();
			this.parametroimpor= new ParametroImpor();
			this.parametroimporObject=new Object();
			this.parametroimporsObject=new ArrayList<Object>();
			
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
			
			this.parametroimporDataAccess.setConnexionType(this.connexionType);
			this.parametroimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroImpor getParametroImpor() throws Exception {	
		ParametroImporLogicAdditional.checkParametroImporToGet(parametroimpor,this.datosCliente,this.arrDatoGeneral);
		ParametroImporLogicAdditional.updateParametroImporToGet(parametroimpor,this.arrDatoGeneral);
		
		return parametroimpor;
	}
		
	public void setParametroImpor(ParametroImpor newParametroImpor) {
		this.parametroimpor = newParametroImpor;
	}
	
	public ParametroImporDataAccess getParametroImporDataAccess() {
		return parametroimporDataAccess;
	}
	
	public void setParametroImporDataAccess(ParametroImporDataAccess newparametroimporDataAccess) {
		this.parametroimporDataAccess = newparametroimporDataAccess;
	}
	
	public List<ParametroImpor> getParametroImpors() throws Exception {		
		this.quitarParametroImporsNulos();
		
		ParametroImporLogicAdditional.checkParametroImporToGets(parametroimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroImpor parametroimporLocal: parametroimpors ) {
			ParametroImporLogicAdditional.updateParametroImporToGet(parametroimporLocal,this.arrDatoGeneral);
		}
		
		return parametroimpors;
	}
	
	public void setParametroImpors(List<ParametroImpor> newParametroImpors) {
		this.parametroimpors = newParametroImpors;
	}
	
	public Object getParametroImporObject() {	
		this.parametroimporObject=this.parametroimporDataAccess.getEntityObject();
		return this.parametroimporObject;
	}
		
	public void setParametroImporObject(Object newParametroImporObject) {
		this.parametroimporObject = newParametroImporObject;
	}
	
	public List<Object> getParametroImporsObject() {		
		this.parametroimporsObject=this.parametroimporDataAccess.getEntitiesObject();
		return this.parametroimporsObject;
	}
		
	public void setParametroImporsObject(List<Object> newParametroImporsObject) {
		this.parametroimporsObject = newParametroImporsObject;
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
		
		if(this.parametroimporDataAccess!=null) {
			this.parametroimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroimpor = new  ParametroImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroimpor=parametroimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
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
		parametroimpor = new  ParametroImpor();
		  		  
        try {
			
			parametroimpor=parametroimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroimpor = new  ParametroImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroimpor=parametroimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
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
		parametroimpor = new  ParametroImpor();
		  		  
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
		parametroimpor = new  ParametroImpor();
		  		  
        try {
			
			parametroimpor=parametroimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroimpor = new  ParametroImpor();
		  		  
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
		parametroimpor = new  ParametroImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroimpor = new  ParametroImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroimpor = new  ParametroImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroimpor = new  ParametroImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroimpor = new  ParametroImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroimpor = new  ParametroImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
        try {			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
        try {
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroimpor = new  ParametroImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpor=parametroimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
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
		parametroimpor = new  ParametroImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpor=parametroimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
		parametroimpors = new  ArrayList<ParametroImpor>();
		  		  
        try {
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroimpors = new  ArrayList<ParametroImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getTodosParametroImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
	
	public  void  getTodosParametroImpors(String sFinalQuery,Pagination pagination)throws Exception {
		parametroimpors = new  ArrayList<ParametroImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroImpor(parametroimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroImpor(ParametroImpor parametroimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroimpor.getIsNew() || parametroimpor.getIsChanged()) { 
			this.invalidValues = parametroimporValidator.getInvalidValues(parametroimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroImpor(List<ParametroImpor> ParametroImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroImpor parametroimporLocal:parametroimpors) {				
			estaValidadoObjeto=this.validarGuardarParametroImpor(parametroimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroImpor(List<ParametroImpor> ParametroImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroImpor(parametroimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroImpor(ParametroImpor ParametroImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroImpor(parametroimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroImpor parametroimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroImporConstantesFunciones.getParametroImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-saveParametroImporWithConnection");connexion.begin();			
			
			ParametroImporLogicAdditional.checkParametroImporToSave(this.parametroimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroImporLogicAdditional.updateParametroImporToSave(this.parametroimpor,this.arrDatoGeneral);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroImpor(this.parametroimpor)) {
				ParametroImporDataAccess.save(this.parametroimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroImporLogicAdditional.checkParametroImporToSaveAfter(this.parametroimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroImpor();
			
			connexion.commit();			
			
			if(this.parametroimpor.getIsDeleted()) {
				this.parametroimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroImpor()throws Exception {	
		try {	
			
			ParametroImporLogicAdditional.checkParametroImporToSave(this.parametroimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroImporLogicAdditional.updateParametroImporToSave(this.parametroimpor,this.arrDatoGeneral);
			
			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroImpor(this.parametroimpor)) {			
				ParametroImporDataAccess.save(this.parametroimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroImporLogicAdditional.checkParametroImporToSaveAfter(this.parametroimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroimpor.getIsDeleted()) {
				this.parametroimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-saveParametroImporsWithConnection");connexion.begin();			
			
			ParametroImporLogicAdditional.checkParametroImporToSaves(parametroimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroImpors();
			
			Boolean validadoTodosParametroImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroImpor parametroimporLocal:parametroimpors) {		
				if(parametroimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroImporLogicAdditional.updateParametroImporToSave(parametroimporLocal,this.arrDatoGeneral);
	        	
				ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroImpor(parametroimporLocal)) {
					ParametroImporDataAccess.save(parametroimporLocal, connexion);				
				} else {
					validadoTodosParametroImpor=false;
				}
			}
			
			if(!validadoTodosParametroImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroImporLogicAdditional.checkParametroImporToSavesAfter(parametroimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroImpors();
			
			connexion.commit();		
			
			this.quitarParametroImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroImpors()throws Exception {				
		 try {	
			ParametroImporLogicAdditional.checkParametroImporToSaves(parametroimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroImpor parametroimporLocal:parametroimpors) {				
				if(parametroimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroImporLogicAdditional.updateParametroImporToSave(parametroimporLocal,this.arrDatoGeneral);
	        	
				ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroImpor(parametroimporLocal)) {				
					ParametroImporDataAccess.save(parametroimporLocal, connexion);				
				} else {
					validadoTodosParametroImpor=false;
				}
			}
			
			if(!validadoTodosParametroImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroImporLogicAdditional.checkParametroImporToSavesAfter(parametroimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroImporParameterReturnGeneral procesarAccionParametroImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroImpor> parametroimpors,ParametroImporParameterReturnGeneral parametroimporParameterGeneral)throws Exception {
		 try {	
			ParametroImporParameterReturnGeneral parametroimporReturnGeneral=new ParametroImporParameterReturnGeneral();
	
			ParametroImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroimpors,parametroimporParameterGeneral,parametroimporReturnGeneral);
			
			return parametroimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroImporParameterReturnGeneral procesarAccionParametroImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroImpor> parametroimpors,ParametroImporParameterReturnGeneral parametroimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-procesarAccionParametroImporsWithConnection");connexion.begin();			
			
			ParametroImporParameterReturnGeneral parametroimporReturnGeneral=new ParametroImporParameterReturnGeneral();
	
			ParametroImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroimpors,parametroimporParameterGeneral,parametroimporReturnGeneral);
			
			this.connexion.commit();
			
			return parametroimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroImporParameterReturnGeneral procesarEventosParametroImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroImpor> parametroimpors,ParametroImpor parametroimpor,ParametroImporParameterReturnGeneral parametroimporParameterGeneral,Boolean isEsNuevoParametroImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroImporParameterReturnGeneral parametroimporReturnGeneral=new ParametroImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroimpors,parametroimpor,parametroimporParameterGeneral,parametroimporReturnGeneral,isEsNuevoParametroImpor,clases);
			
			return parametroimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroImporParameterReturnGeneral procesarEventosParametroImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroImpor> parametroimpors,ParametroImpor parametroimpor,ParametroImporParameterReturnGeneral parametroimporParameterGeneral,Boolean isEsNuevoParametroImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-procesarEventosParametroImporsWithConnection");connexion.begin();			
			
			ParametroImporParameterReturnGeneral parametroimporReturnGeneral=new ParametroImporParameterReturnGeneral();
	
			parametroimporReturnGeneral.setParametroImpor(parametroimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroimpors,parametroimpor,parametroimporParameterGeneral,parametroimporReturnGeneral,isEsNuevoParametroImpor,clases);
			
			this.connexion.commit();
			
			return parametroimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroImporParameterReturnGeneral procesarImportacionParametroImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroImporParameterReturnGeneral parametroimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-procesarImportacionParametroImporsWithConnection");connexion.begin();			
			
			ParametroImporParameterReturnGeneral parametroimporReturnGeneral=new ParametroImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroimpors=new ArrayList<ParametroImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroimpor=new ParametroImpor();
				
				
				if(conColumnasBase) {this.parametroimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametroimpor.setdias_llega_bodega(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroimpor.setporcentaje_seguro(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametroimpor.setfodin(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametroimpor.setcorpei(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametroimpor.setcon_secuencial(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroimpor.setsecuencial(arrColumnas[iColumn++]);
				this.parametroimpor.setcon_peso_precio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroimpor.setcon_lote(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroimpor.setcon_unidad(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroimpor.setcon_conversion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametroimpors.add(this.parametroimpor);
			}
			
			this.saveParametroImpors();
			
			this.connexion.commit();
			
			parametroimporReturnGeneral.setConRetornoEstaProcesado(true);
			parametroimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroImporsEliminados() throws Exception {				
		
		List<ParametroImpor> parametroimporsAux= new ArrayList<ParametroImpor>();
		
		for(ParametroImpor parametroimpor:parametroimpors) {
			if(!parametroimpor.getIsDeleted()) {
				parametroimporsAux.add(parametroimpor);
			}
		}
		
		parametroimpors=parametroimporsAux;
	}
	
	public void quitarParametroImporsNulos() throws Exception {				
		
		List<ParametroImpor> parametroimporsAux= new ArrayList<ParametroImpor>();
		
		for(ParametroImpor parametroimpor : this.parametroimpors) {
			if(parametroimpor==null) {
				parametroimporsAux.add(parametroimpor);
			}
		}
		
		//this.parametroimpors=parametroimporsAux;
		
		this.parametroimpors.removeAll(parametroimporsAux);
	}
	
	public void getSetVersionRowParametroImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroimpor.getIsDeleted() || (parametroimpor.getIsChanged()&&!parametroimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroimporDataAccess.getSetVersionRowParametroImpor(connexion,parametroimpor.getId());
				
				if(!parametroimpor.getVersionRow().equals(timestamp)) {	
					parametroimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroImpor()throws Exception {	
		
		if(parametroimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroimpor.getIsDeleted() || (parametroimpor.getIsChanged()&&!parametroimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroimporDataAccess.getSetVersionRowParametroImpor(connexion,parametroimpor.getId());
			
			try {							
				if(!parametroimpor.getVersionRow().equals(timestamp)) {	
					parametroimpor.setVersionRow(timestamp);
				}
				
				parametroimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroImporsWithConnection()throws Exception {	
		if(parametroimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroImpor parametroimporAux:parametroimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroimporAux.getIsDeleted() || (parametroimporAux.getIsChanged()&&!parametroimporAux.getIsNew())) {
						
						timestamp=parametroimporDataAccess.getSetVersionRowParametroImpor(connexion,parametroimporAux.getId());
						
						if(!parametroimpor.getVersionRow().equals(timestamp)) {	
							parametroimporAux.setVersionRow(timestamp);
						}
								
						parametroimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroImpors()throws Exception {	
		if(parametroimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroImpor parametroimporAux:parametroimpors) {
					if(parametroimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroimporAux.getIsDeleted() || (parametroimporAux.getIsChanged()&&!parametroimporAux.getIsNew())) {
						
						timestamp=parametroimporDataAccess.getSetVersionRowParametroImpor(connexion,parametroimporAux.getId());
						
						if(!parametroimporAux.getVersionRow().equals(timestamp)) {	
							parametroimporAux.setVersionRow(timestamp);
						}
						
													
						parametroimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroImporParameterReturnGeneral cargarCombosLoteForeignKeyParametroImporWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalPais,String finalQueryGlobalBodega,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContable,String finalQueryGlobalTransaccionOrdenCompra,String finalQueryGlobalTransaccionIngreso,String finalQueryGlobalFormatoOrdenCompra,String finalQueryGlobalFormatoIngreso,String finalQueryGlobalFormatoPedido,String finalQueryGlobalFormatoLiquidacion) throws Exception {
		ParametroImporParameterReturnGeneral  parametroimporReturnGeneral =new ParametroImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroImporWithConnection");connexion.begin();
			
			parametroimporReturnGeneral =new ParametroImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			parametroimporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametroimporReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			parametroimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			parametroimporReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Transaccion> transaccionordencomprasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionordencompraLogic=new TransaccionLogic();
			transaccionordencompraLogic.setConnexion(this.connexion);
			transaccionordencompraLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionOrdenCompra.equals("NONE")) {
				transaccionordencompraLogic.getTodosTransaccions(finalQueryGlobalTransaccionOrdenCompra,new Pagination());
				transaccionordencomprasForeignKey=transaccionordencompraLogic.getTransaccions();
			}

			parametroimporReturnGeneral.settransaccionordencomprasForeignKey(transaccionordencomprasForeignKey);


			List<Transaccion> transaccioningresosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioningresoLogic=new TransaccionLogic();
			transaccioningresoLogic.setConnexion(this.connexion);
			transaccioningresoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionIngreso.equals("NONE")) {
				transaccioningresoLogic.getTodosTransaccions(finalQueryGlobalTransaccionIngreso,new Pagination());
				transaccioningresosForeignKey=transaccioningresoLogic.getTransaccions();
			}

			parametroimporReturnGeneral.settransaccioningresosForeignKey(transaccioningresosForeignKey);


			List<Formato> formatoordencomprasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoordencompraLogic=new FormatoLogic();
			formatoordencompraLogic.setConnexion(this.connexion);
			formatoordencompraLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoOrdenCompra.equals("NONE")) {
				formatoordencompraLogic.getTodosFormatos(finalQueryGlobalFormatoOrdenCompra,new Pagination());
				formatoordencomprasForeignKey=formatoordencompraLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatoordencomprasForeignKey(formatoordencomprasForeignKey);


			List<Formato> formatoingresosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoingresoLogic=new FormatoLogic();
			formatoingresoLogic.setConnexion(this.connexion);
			formatoingresoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoIngreso.equals("NONE")) {
				formatoingresoLogic.getTodosFormatos(finalQueryGlobalFormatoIngreso,new Pagination());
				formatoingresosForeignKey=formatoingresoLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatoingresosForeignKey(formatoingresosForeignKey);


			List<Formato> formatopedidosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatopedidoLogic=new FormatoLogic();
			formatopedidoLogic.setConnexion(this.connexion);
			formatopedidoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoPedido.equals("NONE")) {
				formatopedidoLogic.getTodosFormatos(finalQueryGlobalFormatoPedido,new Pagination());
				formatopedidosForeignKey=formatopedidoLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatopedidosForeignKey(formatopedidosForeignKey);


			List<Formato> formatoliquidacionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoliquidacionLogic=new FormatoLogic();
			formatoliquidacionLogic.setConnexion(this.connexion);
			formatoliquidacionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoLiquidacion.equals("NONE")) {
				formatoliquidacionLogic.getTodosFormatos(finalQueryGlobalFormatoLiquidacion,new Pagination());
				formatoliquidacionsForeignKey=formatoliquidacionLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatoliquidacionsForeignKey(formatoliquidacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroimporReturnGeneral;
	}
	
	public ParametroImporParameterReturnGeneral cargarCombosLoteForeignKeyParametroImpor(String finalQueryGlobalEmpresa,String finalQueryGlobalPais,String finalQueryGlobalBodega,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContable,String finalQueryGlobalTransaccionOrdenCompra,String finalQueryGlobalTransaccionIngreso,String finalQueryGlobalFormatoOrdenCompra,String finalQueryGlobalFormatoIngreso,String finalQueryGlobalFormatoPedido,String finalQueryGlobalFormatoLiquidacion) throws Exception {
		ParametroImporParameterReturnGeneral  parametroimporReturnGeneral =new ParametroImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroimporReturnGeneral =new ParametroImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			parametroimporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametroimporReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			parametroimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			parametroimporReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Transaccion> transaccionordencomprasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionordencompraLogic=new TransaccionLogic();
			transaccionordencompraLogic.setConnexion(this.connexion);
			transaccionordencompraLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionOrdenCompra.equals("NONE")) {
				transaccionordencompraLogic.getTodosTransaccions(finalQueryGlobalTransaccionOrdenCompra,new Pagination());
				transaccionordencomprasForeignKey=transaccionordencompraLogic.getTransaccions();
			}

			parametroimporReturnGeneral.settransaccionordencomprasForeignKey(transaccionordencomprasForeignKey);


			List<Transaccion> transaccioningresosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioningresoLogic=new TransaccionLogic();
			transaccioningresoLogic.setConnexion(this.connexion);
			transaccioningresoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionIngreso.equals("NONE")) {
				transaccioningresoLogic.getTodosTransaccions(finalQueryGlobalTransaccionIngreso,new Pagination());
				transaccioningresosForeignKey=transaccioningresoLogic.getTransaccions();
			}

			parametroimporReturnGeneral.settransaccioningresosForeignKey(transaccioningresosForeignKey);


			List<Formato> formatoordencomprasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoordencompraLogic=new FormatoLogic();
			formatoordencompraLogic.setConnexion(this.connexion);
			formatoordencompraLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoOrdenCompra.equals("NONE")) {
				formatoordencompraLogic.getTodosFormatos(finalQueryGlobalFormatoOrdenCompra,new Pagination());
				formatoordencomprasForeignKey=formatoordencompraLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatoordencomprasForeignKey(formatoordencomprasForeignKey);


			List<Formato> formatoingresosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoingresoLogic=new FormatoLogic();
			formatoingresoLogic.setConnexion(this.connexion);
			formatoingresoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoIngreso.equals("NONE")) {
				formatoingresoLogic.getTodosFormatos(finalQueryGlobalFormatoIngreso,new Pagination());
				formatoingresosForeignKey=formatoingresoLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatoingresosForeignKey(formatoingresosForeignKey);


			List<Formato> formatopedidosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatopedidoLogic=new FormatoLogic();
			formatopedidoLogic.setConnexion(this.connexion);
			formatopedidoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoPedido.equals("NONE")) {
				formatopedidoLogic.getTodosFormatos(finalQueryGlobalFormatoPedido,new Pagination());
				formatopedidosForeignKey=formatopedidoLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatopedidosForeignKey(formatopedidosForeignKey);


			List<Formato> formatoliquidacionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoliquidacionLogic=new FormatoLogic();
			formatoliquidacionLogic.setConnexion(this.connexion);
			formatoliquidacionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoLiquidacion.equals("NONE")) {
				formatoliquidacionLogic.getTodosFormatos(finalQueryGlobalFormatoLiquidacion,new Pagination());
				formatoliquidacionsForeignKey=formatoliquidacionLogic.getFormatos();
			}

			parametroimporReturnGeneral.setformatoliquidacionsForeignKey(formatoliquidacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroimporReturnGeneral;
	}
	
	
	public void deepLoad(ParametroImpor parametroimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroImporLogicAdditional.updateParametroImporToGet(parametroimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroimpor.setEmpresa(parametroimporDataAccess.getEmpresa(connexion,parametroimpor));
		parametroimpor.setPais(parametroimporDataAccess.getPais(connexion,parametroimpor));
		parametroimpor.setBodega(parametroimporDataAccess.getBodega(connexion,parametroimpor));
		parametroimpor.setCentroCosto(parametroimporDataAccess.getCentroCosto(connexion,parametroimpor));
		parametroimpor.setCuentaContable(parametroimporDataAccess.getCuentaContable(connexion,parametroimpor));
		parametroimpor.setTransaccionOrdenCompra(parametroimporDataAccess.getTransaccionOrdenCompra(connexion,parametroimpor));
		parametroimpor.setTransaccionIngreso(parametroimporDataAccess.getTransaccionIngreso(connexion,parametroimpor));
		parametroimpor.setFormatoOrdenCompra(parametroimporDataAccess.getFormatoOrdenCompra(connexion,parametroimpor));
		parametroimpor.setFormatoIngreso(parametroimporDataAccess.getFormatoIngreso(connexion,parametroimpor));
		parametroimpor.setFormatoPedido(parametroimporDataAccess.getFormatoPedido(connexion,parametroimpor));
		parametroimpor.setFormatoLiquidacion(parametroimporDataAccess.getFormatoLiquidacion(connexion,parametroimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroimpor.setEmpresa(parametroimporDataAccess.getEmpresa(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametroimpor.setPais(parametroimporDataAccess.getPais(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametroimpor.setBodega(parametroimporDataAccess.getBodega(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				parametroimpor.setCentroCosto(parametroimporDataAccess.getCentroCosto(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroimpor.setCuentaContable(parametroimporDataAccess.getCuentaContable(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroimpor.setTransaccionOrdenCompra(parametroimporDataAccess.getTransaccionOrdenCompra(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroimpor.setTransaccionIngreso(parametroimporDataAccess.getTransaccionIngreso(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoOrdenCompra(parametroimporDataAccess.getFormatoOrdenCompra(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoIngreso(parametroimporDataAccess.getFormatoIngreso(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoPedido(parametroimporDataAccess.getFormatoPedido(connexion,parametroimpor));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoLiquidacion(parametroimporDataAccess.getFormatoLiquidacion(connexion,parametroimpor));
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
			parametroimpor.setEmpresa(parametroimporDataAccess.getEmpresa(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setPais(parametroimporDataAccess.getPais(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setBodega(parametroimporDataAccess.getBodega(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setCentroCosto(parametroimporDataAccess.getCentroCosto(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setCuentaContable(parametroimporDataAccess.getCuentaContable(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setTransaccionOrdenCompra(parametroimporDataAccess.getTransaccionOrdenCompra(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setTransaccionIngreso(parametroimporDataAccess.getTransaccionIngreso(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoOrdenCompra(parametroimporDataAccess.getFormatoOrdenCompra(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoIngreso(parametroimporDataAccess.getFormatoIngreso(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoPedido(parametroimporDataAccess.getFormatoPedido(connexion,parametroimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoLiquidacion(parametroimporDataAccess.getFormatoLiquidacion(connexion,parametroimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroimpor.setEmpresa(parametroimporDataAccess.getEmpresa(connexion,parametroimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametroimpor.setPais(parametroimporDataAccess.getPais(connexion,parametroimpor));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(parametroimpor.getPais(),isDeep,deepLoadType,clases);
				
		parametroimpor.setBodega(parametroimporDataAccess.getBodega(connexion,parametroimpor));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametroimpor.getBodega(),isDeep,deepLoadType,clases);
				
		parametroimpor.setCentroCosto(parametroimporDataAccess.getCentroCosto(connexion,parametroimpor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(parametroimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		parametroimpor.setCuentaContable(parametroimporDataAccess.getCuentaContable(connexion,parametroimpor));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(parametroimpor.getCuentaContable(),isDeep,deepLoadType,clases);
				
		parametroimpor.setTransaccionOrdenCompra(parametroimporDataAccess.getTransaccionOrdenCompra(connexion,parametroimpor));
		TransaccionLogic transaccionordencompraLogic= new TransaccionLogic(connexion);
		transaccionordencompraLogic.deepLoad(parametroimpor.getTransaccionOrdenCompra(),isDeep,deepLoadType,clases);
				
		parametroimpor.setTransaccionIngreso(parametroimporDataAccess.getTransaccionIngreso(connexion,parametroimpor));
		TransaccionLogic transaccioningresoLogic= new TransaccionLogic(connexion);
		transaccioningresoLogic.deepLoad(parametroimpor.getTransaccionIngreso(),isDeep,deepLoadType,clases);
				
		parametroimpor.setFormatoOrdenCompra(parametroimporDataAccess.getFormatoOrdenCompra(connexion,parametroimpor));
		FormatoLogic formatoordencompraLogic= new FormatoLogic(connexion);
		formatoordencompraLogic.deepLoad(parametroimpor.getFormatoOrdenCompra(),isDeep,deepLoadType,clases);
				
		parametroimpor.setFormatoIngreso(parametroimporDataAccess.getFormatoIngreso(connexion,parametroimpor));
		FormatoLogic formatoingresoLogic= new FormatoLogic(connexion);
		formatoingresoLogic.deepLoad(parametroimpor.getFormatoIngreso(),isDeep,deepLoadType,clases);
				
		parametroimpor.setFormatoPedido(parametroimporDataAccess.getFormatoPedido(connexion,parametroimpor));
		FormatoLogic formatopedidoLogic= new FormatoLogic(connexion);
		formatopedidoLogic.deepLoad(parametroimpor.getFormatoPedido(),isDeep,deepLoadType,clases);
				
		parametroimpor.setFormatoLiquidacion(parametroimporDataAccess.getFormatoLiquidacion(connexion,parametroimpor));
		FormatoLogic formatoliquidacionLogic= new FormatoLogic(connexion);
		formatoliquidacionLogic.deepLoad(parametroimpor.getFormatoLiquidacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroimpor.setEmpresa(parametroimporDataAccess.getEmpresa(connexion,parametroimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametroimpor.setPais(parametroimporDataAccess.getPais(connexion,parametroimpor));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(parametroimpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametroimpor.setBodega(parametroimporDataAccess.getBodega(connexion,parametroimpor));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametroimpor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				parametroimpor.setCentroCosto(parametroimporDataAccess.getCentroCosto(connexion,parametroimpor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(parametroimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroimpor.setCuentaContable(parametroimporDataAccess.getCuentaContable(connexion,parametroimpor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroimpor.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroimpor.setTransaccionOrdenCompra(parametroimporDataAccess.getTransaccionOrdenCompra(connexion,parametroimpor));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametroimpor.getTransaccionOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroimpor.setTransaccionIngreso(parametroimporDataAccess.getTransaccionIngreso(connexion,parametroimpor));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametroimpor.getTransaccionIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoOrdenCompra(parametroimporDataAccess.getFormatoOrdenCompra(connexion,parametroimpor));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametroimpor.getFormatoOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoIngreso(parametroimporDataAccess.getFormatoIngreso(connexion,parametroimpor));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametroimpor.getFormatoIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoPedido(parametroimporDataAccess.getFormatoPedido(connexion,parametroimpor));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametroimpor.getFormatoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametroimpor.setFormatoLiquidacion(parametroimporDataAccess.getFormatoLiquidacion(connexion,parametroimpor));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametroimpor.getFormatoLiquidacion(),isDeep,deepLoadType,clases);				
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
			parametroimpor.setEmpresa(parametroimporDataAccess.getEmpresa(connexion,parametroimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setPais(parametroimporDataAccess.getPais(connexion,parametroimpor));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(parametroimpor.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setBodega(parametroimporDataAccess.getBodega(connexion,parametroimpor));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametroimpor.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setCentroCosto(parametroimporDataAccess.getCentroCosto(connexion,parametroimpor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(parametroimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setCuentaContable(parametroimporDataAccess.getCuentaContable(connexion,parametroimpor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroimpor.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setTransaccionOrdenCompra(parametroimporDataAccess.getTransaccionOrdenCompra(connexion,parametroimpor));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametroimpor.getTransaccionOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setTransaccionIngreso(parametroimporDataAccess.getTransaccionIngreso(connexion,parametroimpor));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametroimpor.getTransaccionIngreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoOrdenCompra(parametroimporDataAccess.getFormatoOrdenCompra(connexion,parametroimpor));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametroimpor.getFormatoOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoIngreso(parametroimporDataAccess.getFormatoIngreso(connexion,parametroimpor));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametroimpor.getFormatoIngreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoPedido(parametroimporDataAccess.getFormatoPedido(connexion,parametroimpor));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametroimpor.getFormatoPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroimpor.setFormatoLiquidacion(parametroimporDataAccess.getFormatoLiquidacion(connexion,parametroimpor));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametroimpor.getFormatoLiquidacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroImpor parametroimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroImporLogicAdditional.updateParametroImporToSave(parametroimpor,this.arrDatoGeneral);
			
ParametroImporDataAccess.save(parametroimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroimpor.getEmpresa(),connexion);

		PaisDataAccess.save(parametroimpor.getPais(),connexion);

		BodegaDataAccess.save(parametroimpor.getBodega(),connexion);

		CentroCostoDataAccess.save(parametroimpor.getCentroCosto(),connexion);

		CuentaContableDataAccess.save(parametroimpor.getCuentaContable(),connexion);

		TransaccionDataAccess.save(parametroimpor.getTransaccionOrdenCompra(),connexion);

		TransaccionDataAccess.save(parametroimpor.getTransaccionIngreso(),connexion);

		FormatoDataAccess.save(parametroimpor.getFormatoOrdenCompra(),connexion);

		FormatoDataAccess.save(parametroimpor.getFormatoIngreso(),connexion);

		FormatoDataAccess.save(parametroimpor.getFormatoPedido(),connexion);

		FormatoDataAccess.save(parametroimpor.getFormatoLiquidacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametroimpor.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametroimpor.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(parametroimpor.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroimpor.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroimpor.getTransaccionOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroimpor.getTransaccionIngreso(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoIngreso(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoLiquidacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(parametroimpor.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(parametroimpor.getPais(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametroimpor.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametroimpor.getBodega(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(parametroimpor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(parametroimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroimpor.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(parametroimpor.getCuentaContable(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametroimpor.getTransaccionOrdenCompra(),connexion);
		TransaccionLogic transaccionordencompraLogic= new TransaccionLogic(connexion);
		transaccionordencompraLogic.deepLoad(parametroimpor.getTransaccionOrdenCompra(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametroimpor.getTransaccionIngreso(),connexion);
		TransaccionLogic transaccioningresoLogic= new TransaccionLogic(connexion);
		transaccioningresoLogic.deepLoad(parametroimpor.getTransaccionIngreso(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametroimpor.getFormatoOrdenCompra(),connexion);
		FormatoLogic formatoordencompraLogic= new FormatoLogic(connexion);
		formatoordencompraLogic.deepLoad(parametroimpor.getFormatoOrdenCompra(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametroimpor.getFormatoIngreso(),connexion);
		FormatoLogic formatoingresoLogic= new FormatoLogic(connexion);
		formatoingresoLogic.deepLoad(parametroimpor.getFormatoIngreso(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametroimpor.getFormatoPedido(),connexion);
		FormatoLogic formatopedidoLogic= new FormatoLogic(connexion);
		formatopedidoLogic.deepLoad(parametroimpor.getFormatoPedido(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametroimpor.getFormatoLiquidacion(),connexion);
		FormatoLogic formatoliquidacionLogic= new FormatoLogic(connexion);
		formatoliquidacionLogic.deepLoad(parametroimpor.getFormatoLiquidacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametroimpor.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(parametroimpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametroimpor.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametroimpor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(parametroimpor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(parametroimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroimpor.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroimpor.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroimpor.getTransaccionOrdenCompra(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametroimpor.getTransaccionOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroimpor.getTransaccionIngreso(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametroimpor.getTransaccionIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoOrdenCompra(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametroimpor.getFormatoOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoIngreso(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametroimpor.getFormatoIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoPedido(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametroimpor.getFormatoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametroimpor.getFormatoLiquidacion(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametroimpor.getFormatoLiquidacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(parametroimpor);
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
			this.deepLoad(this.parametroimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroimpors!=null) {
				for(ParametroImpor parametroimpor:parametroimpors) {
					this.deepLoad(parametroimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(parametroimpors);
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
			if(parametroimpors!=null) {
				for(ParametroImpor parametroimpor:parametroimpors) {
					this.deepLoad(parametroimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(parametroimpors);
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
			this.getNewConnexionToDeep(ParametroImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametroimpors!=null) {
				for(ParametroImpor parametroimpor:parametroimpors) {
					this.deepSave(parametroimpor,isDeep,deepLoadType,clases);
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
			if(parametroimpors!=null) {
				for(ParametroImpor parametroimpor:parametroimpors) {
					this.deepSave(parametroimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroImporsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroImporConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroImporConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ParametroImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ParametroImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ParametroImporConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ParametroImporConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdFormatoIngresoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_ingreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_ingreso,ParametroImporConstantesFunciones.IDFORMATOINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoIngreso);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdFormatoIngreso(String sFinalQuery,Pagination pagination,Long id_formato_ingreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_ingreso,ParametroImporConstantesFunciones.IDFORMATOINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoIngreso);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdFormatoLiquacionWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_liquidacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoLiquidacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoLiquidacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_liquidacion,ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoLiquidacion);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoLiquacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdFormatoLiquacion(String sFinalQuery,Pagination pagination,Long id_formato_liquidacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoLiquidacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoLiquidacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_liquidacion,ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoLiquidacion);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoLiquacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdFormatoOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_orden_compra,ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoOrdenCompra);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdFormatoOrdenCompra(String sFinalQuery,Pagination pagination,Long id_formato_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_orden_compra,ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoOrdenCompra);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdFormatoPedoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_pedido,ParametroImporConstantesFunciones.IDFORMATOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoPedido);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoPedo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdFormatoPedo(String sFinalQuery,Pagination pagination,Long id_formato_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_pedido,ParametroImporConstantesFunciones.IDFORMATOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoPedido);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoPedo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ParametroImporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ParametroImporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdTransaccionIngresoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_ingreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_ingreso,ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionIngreso);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdTransaccionIngreso(String sFinalQuery,Pagination pagination,Long id_transaccion_ingreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_ingreso,ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionIngreso);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroImporsFK_IdTransaccionOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_orden_compra,ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionOrdenCompra);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroImporsFK_IdTransaccionOrdenCompra(String sFinalQuery,Pagination pagination,Long id_transaccion_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_orden_compra,ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionOrdenCompra);

			ParametroImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroImporConstantesFunciones.refrescarForeignKeysDescripcionesParametroImpor(this.parametroimpors);
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
			if(ParametroImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroImpor parametroimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroImporConstantesFunciones.ISCONAUDITORIA) {
				if(parametroimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroImporDataAccess.TABLENAME, parametroimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroImporLogic.registrarAuditoriaDetallesParametroImpor(connexion,parametroimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroimpor.getIsDeleted()) {
					/*if(!parametroimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroImporDataAccess.TABLENAME, parametroimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroImporLogic.registrarAuditoriaDetallesParametroImpor(connexion,parametroimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroImporDataAccess.TABLENAME, parametroimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroImporDataAccess.TABLENAME, parametroimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroImporLogic.registrarAuditoriaDetallesParametroImpor(connexion,parametroimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroImpor(Connexion connexion,ParametroImpor parametroimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_empresa().equals(parametroimpor.getParametroImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_empresa().toString();
				}
				if(parametroimpor.getid_empresa()!=null)
				{
					strValorNuevo=parametroimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_pais().equals(parametroimpor.getParametroImporOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_pais()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_pais().toString();
				}
				if(parametroimpor.getid_pais()!=null)
				{
					strValorNuevo=parametroimpor.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_bodega().equals(parametroimpor.getParametroImporOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_bodega()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_bodega().toString();
				}
				if(parametroimpor.getid_bodega()!=null)
				{
					strValorNuevo=parametroimpor.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_centro_costo().equals(parametroimpor.getParametroImporOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_centro_costo()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_centro_costo().toString();
				}
				if(parametroimpor.getid_centro_costo()!=null)
				{
					strValorNuevo=parametroimpor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_cuenta_contable().equals(parametroimpor.getParametroImporOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_cuenta_contable().toString();
				}
				if(parametroimpor.getid_cuenta_contable()!=null)
				{
					strValorNuevo=parametroimpor.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_transaccion_orden_compra().equals(parametroimpor.getParametroImporOriginal().getid_transaccion_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_transaccion_orden_compra()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_transaccion_orden_compra().toString();
				}
				if(parametroimpor.getid_transaccion_orden_compra()!=null)
				{
					strValorNuevo=parametroimpor.getid_transaccion_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_transaccion_ingreso().equals(parametroimpor.getParametroImporOriginal().getid_transaccion_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_transaccion_ingreso()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_transaccion_ingreso().toString();
				}
				if(parametroimpor.getid_transaccion_ingreso()!=null)
				{
					strValorNuevo=parametroimpor.getid_transaccion_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_formato_orden_compra().equals(parametroimpor.getParametroImporOriginal().getid_formato_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_formato_orden_compra()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_formato_orden_compra().toString();
				}
				if(parametroimpor.getid_formato_orden_compra()!=null)
				{
					strValorNuevo=parametroimpor.getid_formato_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_formato_ingreso().equals(parametroimpor.getParametroImporOriginal().getid_formato_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_formato_ingreso()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_formato_ingreso().toString();
				}
				if(parametroimpor.getid_formato_ingreso()!=null)
				{
					strValorNuevo=parametroimpor.getid_formato_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDFORMATOINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_formato_pedido().equals(parametroimpor.getParametroImporOriginal().getid_formato_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_formato_pedido()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_formato_pedido().toString();
				}
				if(parametroimpor.getid_formato_pedido()!=null)
				{
					strValorNuevo=parametroimpor.getid_formato_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDFORMATOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getid_formato_liquidacion().equals(parametroimpor.getParametroImporOriginal().getid_formato_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getid_formato_liquidacion()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getid_formato_liquidacion().toString();
				}
				if(parametroimpor.getid_formato_liquidacion()!=null)
				{
					strValorNuevo=parametroimpor.getid_formato_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getdias_llega_bodega().equals(parametroimpor.getParametroImporOriginal().getdias_llega_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getdias_llega_bodega()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getdias_llega_bodega().toString();
				}
				if(parametroimpor.getdias_llega_bodega()!=null)
				{
					strValorNuevo=parametroimpor.getdias_llega_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.DIASLLEGABODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getporcentaje_seguro().equals(parametroimpor.getParametroImporOriginal().getporcentaje_seguro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getporcentaje_seguro()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getporcentaje_seguro().toString();
				}
				if(parametroimpor.getporcentaje_seguro()!=null)
				{
					strValorNuevo=parametroimpor.getporcentaje_seguro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.PORCENTAJESEGURO,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getfodin().equals(parametroimpor.getParametroImporOriginal().getfodin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getfodin()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getfodin().toString();
				}
				if(parametroimpor.getfodin()!=null)
				{
					strValorNuevo=parametroimpor.getfodin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.FODIN,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getcorpei().equals(parametroimpor.getParametroImporOriginal().getcorpei()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getcorpei()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getcorpei().toString();
				}
				if(parametroimpor.getcorpei()!=null)
				{
					strValorNuevo=parametroimpor.getcorpei().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.CORPEI,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getcon_secuencial().equals(parametroimpor.getParametroImporOriginal().getcon_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getcon_secuencial()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getcon_secuencial().toString();
				}
				if(parametroimpor.getcon_secuencial()!=null)
				{
					strValorNuevo=parametroimpor.getcon_secuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.CONSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getsecuencial().equals(parametroimpor.getParametroImporOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getsecuencial()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getsecuencial();
				}
				if(parametroimpor.getsecuencial()!=null)
				{
					strValorNuevo=parametroimpor.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getcon_peso_precio().equals(parametroimpor.getParametroImporOriginal().getcon_peso_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getcon_peso_precio()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getcon_peso_precio().toString();
				}
				if(parametroimpor.getcon_peso_precio()!=null)
				{
					strValorNuevo=parametroimpor.getcon_peso_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.CONPESOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getcon_lote().equals(parametroimpor.getParametroImporOriginal().getcon_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getcon_lote()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getcon_lote().toString();
				}
				if(parametroimpor.getcon_lote()!=null)
				{
					strValorNuevo=parametroimpor.getcon_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.CONLOTE,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getcon_unidad().equals(parametroimpor.getParametroImporOriginal().getcon_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getcon_unidad()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getcon_unidad().toString();
				}
				if(parametroimpor.getcon_unidad()!=null)
				{
					strValorNuevo=parametroimpor.getcon_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.CONUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametroimpor.getIsNew()||!parametroimpor.getcon_conversion().equals(parametroimpor.getParametroImporOriginal().getcon_conversion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroimpor.getParametroImporOriginal().getcon_conversion()!=null)
				{
					strValorActual=parametroimpor.getParametroImporOriginal().getcon_conversion().toString();
				}
				if(parametroimpor.getcon_conversion()!=null)
				{
					strValorNuevo=parametroimpor.getcon_conversion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroImporConstantesFunciones.CONCONVERSION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroImporRelacionesWithConnection(ParametroImpor parametroimpor) throws Exception {

		if(!parametroimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroImporRelacionesBase(parametroimpor,true);
		}
	}

	public void saveParametroImporRelaciones(ParametroImpor parametroimpor)throws Exception {

		if(!parametroimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroImporRelacionesBase(parametroimpor,false);
		}
	}

	public void saveParametroImporRelacionesBase(ParametroImpor parametroimpor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroImpor-saveRelacionesWithConnection");}
	

			this.setParametroImpor(parametroimpor);

			if(ParametroImporLogicAdditional.validarSaveRelaciones(parametroimpor,this)) {

				ParametroImporLogicAdditional.updateRelacionesToSave(parametroimpor,this);

				if((parametroimpor.getIsNew()||parametroimpor.getIsChanged())&&!parametroimpor.getIsDeleted()) {
					this.saveParametroImpor();
					this.saveParametroImporRelacionesDetalles();

				} else if(parametroimpor.getIsDeleted()) {
					this.saveParametroImporRelacionesDetalles();
					this.saveParametroImpor();
				}

				ParametroImporLogicAdditional.updateRelacionesToSaveAfter(parametroimpor,this);

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
	
	
	private void saveParametroImporRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroImporConstantesFunciones.getClassesForeignKeysOfParametroImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroImporConstantesFunciones.getClassesRelationshipsOfParametroImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
