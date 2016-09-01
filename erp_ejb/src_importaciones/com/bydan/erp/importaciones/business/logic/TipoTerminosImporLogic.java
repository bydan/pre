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
import com.bydan.erp.importaciones.util.TipoTerminosImporConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoTerminosImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoTerminosImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.TipoTerminosImpor;
//import com.bydan.erp.importaciones.business.logic.TipoTerminosImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoTerminosImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoTerminosImporLogic.class);
	
	protected TipoTerminosImporDataAccess tipoterminosimporDataAccess; 	
	protected TipoTerminosImpor tipoterminosimpor;
	protected List<TipoTerminosImpor> tipoterminosimpors;
	protected Object tipoterminosimporObject;	
	protected List<Object> tipoterminosimporsObject;
	
	public static ClassValidator<TipoTerminosImpor> tipoterminosimporValidator = new ClassValidator<TipoTerminosImpor>(TipoTerminosImpor.class);	
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
	
	
	
	
	public  TipoTerminosImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoterminosimporDataAccess = new TipoTerminosImporDataAccess();
			
			this.tipoterminosimpors= new ArrayList<TipoTerminosImpor>();
			this.tipoterminosimpor= new TipoTerminosImpor();
			
			this.tipoterminosimporObject=new Object();
			this.tipoterminosimporsObject=new ArrayList<Object>();
				
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
			
			this.tipoterminosimporDataAccess.setConnexionType(this.connexionType);
			this.tipoterminosimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoTerminosImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoterminosimporDataAccess = new TipoTerminosImporDataAccess();
			this.tipoterminosimpors= new ArrayList<TipoTerminosImpor>();
			this.tipoterminosimpor= new TipoTerminosImpor();
			this.tipoterminosimporObject=new Object();
			this.tipoterminosimporsObject=new ArrayList<Object>();
			
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
			
			this.tipoterminosimporDataAccess.setConnexionType(this.connexionType);
			this.tipoterminosimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoTerminosImpor getTipoTerminosImpor() throws Exception {	
		//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToGet(tipoterminosimpor,this.datosCliente,this.arrDatoGeneral);
		//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToGet(tipoterminosimpor,this.arrDatoGeneral);
		
		return tipoterminosimpor;
	}
		
	public void setTipoTerminosImpor(TipoTerminosImpor newTipoTerminosImpor) {
		this.tipoterminosimpor = newTipoTerminosImpor;
	}
	
	public TipoTerminosImporDataAccess getTipoTerminosImporDataAccess() {
		return tipoterminosimporDataAccess;
	}
	
	public void setTipoTerminosImporDataAccess(TipoTerminosImporDataAccess newtipoterminosimporDataAccess) {
		this.tipoterminosimporDataAccess = newtipoterminosimporDataAccess;
	}
	
	public List<TipoTerminosImpor> getTipoTerminosImpors() throws Exception {		
		this.quitarTipoTerminosImporsNulos();
		
		//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToGets(tipoterminosimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoTerminosImpor tipoterminosimporLocal: tipoterminosimpors ) {
			//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToGet(tipoterminosimporLocal,this.arrDatoGeneral);
		}
		
		return tipoterminosimpors;
	}
	
	public void setTipoTerminosImpors(List<TipoTerminosImpor> newTipoTerminosImpors) {
		this.tipoterminosimpors = newTipoTerminosImpors;
	}
	
	public Object getTipoTerminosImporObject() {	
		this.tipoterminosimporObject=this.tipoterminosimporDataAccess.getEntityObject();
		return this.tipoterminosimporObject;
	}
		
	public void setTipoTerminosImporObject(Object newTipoTerminosImporObject) {
		this.tipoterminosimporObject = newTipoTerminosImporObject;
	}
	
	public List<Object> getTipoTerminosImporsObject() {		
		this.tipoterminosimporsObject=this.tipoterminosimporDataAccess.getEntitiesObject();
		return this.tipoterminosimporsObject;
	}
		
	public void setTipoTerminosImporsObject(List<Object> newTipoTerminosImporsObject) {
		this.tipoterminosimporsObject = newTipoTerminosImporsObject;
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
		
		if(this.tipoterminosimporDataAccess!=null) {
			this.tipoterminosimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoterminosimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoterminosimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoterminosimpor = new  TipoTerminosImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoterminosimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
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
		tipoterminosimpor = new  TipoTerminosImpor();
		  		  
        try {
			
			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoterminosimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoterminosimpor = new  TipoTerminosImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoterminosimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
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
		tipoterminosimpor = new  TipoTerminosImpor();
		  		  
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
		tipoterminosimpor = new  TipoTerminosImpor();
		  		  
        try {
			
			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoterminosimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoterminosimpor = new  TipoTerminosImpor();
		  		  
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
		tipoterminosimpor = new  TipoTerminosImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoterminosimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoterminosimpor = new  TipoTerminosImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoterminosimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoterminosimpor = new  TipoTerminosImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoterminosimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoterminosimpor = new  TipoTerminosImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoterminosimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoterminosimpor = new  TipoTerminosImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoterminosimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoterminosimpor = new  TipoTerminosImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoterminosimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
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
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		  		  
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
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		  		  
        try {			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		  		  
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
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
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
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		  		  
        try {
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
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
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
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
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoterminosimpor = new  TipoTerminosImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
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
		tipoterminosimpor = new  TipoTerminosImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoTerminosImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-getTodosTipoTerminosImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
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
	
	public  void  getTodosTipoTerminosImpors(String sFinalQuery,Pagination pagination)throws Exception {
		tipoterminosimpors = new  ArrayList<TipoTerminosImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoterminosimpors=tipoterminosimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTerminosImpor(tipoterminosimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoTerminosImpor(TipoTerminosImpor tipoterminosimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoterminosimpor.getIsNew() || tipoterminosimpor.getIsChanged()) { 
			this.invalidValues = tipoterminosimporValidator.getInvalidValues(tipoterminosimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoterminosimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoTerminosImpor(List<TipoTerminosImpor> TipoTerminosImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoTerminosImpor tipoterminosimporLocal:tipoterminosimpors) {				
			estaValidadoObjeto=this.validarGuardarTipoTerminosImpor(tipoterminosimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoTerminosImpor(List<TipoTerminosImpor> TipoTerminosImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTerminosImpor(tipoterminosimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoTerminosImpor(TipoTerminosImpor TipoTerminosImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTerminosImpor(tipoterminosimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoTerminosImpor tipoterminosimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoterminosimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoTerminosImporConstantesFunciones.getTipoTerminosImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoterminosimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoTerminosImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoTerminosImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoTerminosImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-saveTipoTerminosImporWithConnection");connexion.begin();			
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSave(this.tipoterminosimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToSave(this.tipoterminosimpor,this.arrDatoGeneral);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoterminosimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoTerminosImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTerminosImpor(this.tipoterminosimpor)) {
				TipoTerminosImporDataAccess.save(this.tipoterminosimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoterminosimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSaveAfter(this.tipoterminosimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTerminosImpor();
			
			connexion.commit();			
			
			if(this.tipoterminosimpor.getIsDeleted()) {
				this.tipoterminosimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoTerminosImpor()throws Exception {	
		try {	
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSave(this.tipoterminosimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToSave(this.tipoterminosimpor,this.arrDatoGeneral);
			
			TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoterminosimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTerminosImpor(this.tipoterminosimpor)) {			
				TipoTerminosImporDataAccess.save(this.tipoterminosimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoterminosimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSaveAfter(this.tipoterminosimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoterminosimpor.getIsDeleted()) {
				this.tipoterminosimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoTerminosImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-saveTipoTerminosImporsWithConnection");connexion.begin();			
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSaves(tipoterminosimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoTerminosImpors();
			
			Boolean validadoTodosTipoTerminosImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTerminosImpor tipoterminosimporLocal:tipoterminosimpors) {		
				if(tipoterminosimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToSave(tipoterminosimporLocal,this.arrDatoGeneral);
	        	
				TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoterminosimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTerminosImpor(tipoterminosimporLocal)) {
					TipoTerminosImporDataAccess.save(tipoterminosimporLocal, connexion);				
				} else {
					validadoTodosTipoTerminosImpor=false;
				}
			}
			
			if(!validadoTodosTipoTerminosImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSavesAfter(tipoterminosimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTerminosImpors();
			
			connexion.commit();		
			
			this.quitarTipoTerminosImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoTerminosImpors()throws Exception {				
		 try {	
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSaves(tipoterminosimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoTerminosImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTerminosImpor tipoterminosimporLocal:tipoterminosimpors) {				
				if(tipoterminosimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToSave(tipoterminosimporLocal,this.arrDatoGeneral);
	        	
				TipoTerminosImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoterminosimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTerminosImpor(tipoterminosimporLocal)) {				
					TipoTerminosImporDataAccess.save(tipoterminosimporLocal, connexion);				
				} else {
					validadoTodosTipoTerminosImpor=false;
				}
			}
			
			if(!validadoTodosTipoTerminosImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoTerminosImporLogicAdditional.checkTipoTerminosImporToSavesAfter(tipoterminosimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoTerminosImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTerminosImporParameterReturnGeneral procesarAccionTipoTerminosImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTerminosImpor> tipoterminosimpors,TipoTerminosImporParameterReturnGeneral tipoterminosimporParameterGeneral)throws Exception {
		 try {	
			TipoTerminosImporParameterReturnGeneral tipoterminosimporReturnGeneral=new TipoTerminosImporParameterReturnGeneral();
	
			
			return tipoterminosimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTerminosImporParameterReturnGeneral procesarAccionTipoTerminosImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTerminosImpor> tipoterminosimpors,TipoTerminosImporParameterReturnGeneral tipoterminosimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-procesarAccionTipoTerminosImporsWithConnection");connexion.begin();			
			
			TipoTerminosImporParameterReturnGeneral tipoterminosimporReturnGeneral=new TipoTerminosImporParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoterminosimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTerminosImporParameterReturnGeneral procesarEventosTipoTerminosImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTerminosImpor> tipoterminosimpors,TipoTerminosImpor tipoterminosimpor,TipoTerminosImporParameterReturnGeneral tipoterminosimporParameterGeneral,Boolean isEsNuevoTipoTerminosImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoTerminosImporParameterReturnGeneral tipoterminosimporReturnGeneral=new TipoTerminosImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoterminosimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoterminosimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoTerminosImporParameterReturnGeneral procesarEventosTipoTerminosImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTerminosImpor> tipoterminosimpors,TipoTerminosImpor tipoterminosimpor,TipoTerminosImporParameterReturnGeneral tipoterminosimporParameterGeneral,Boolean isEsNuevoTipoTerminosImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-procesarEventosTipoTerminosImporsWithConnection");connexion.begin();			
			
			TipoTerminosImporParameterReturnGeneral tipoterminosimporReturnGeneral=new TipoTerminosImporParameterReturnGeneral();
	
			tipoterminosimporReturnGeneral.setTipoTerminosImpor(tipoterminosimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoterminosimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoterminosimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTerminosImporParameterReturnGeneral procesarImportacionTipoTerminosImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoTerminosImporParameterReturnGeneral tipoterminosimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTerminosImpor.class.getSimpleName()+"-procesarImportacionTipoTerminosImporsWithConnection");connexion.begin();			
			
			TipoTerminosImporParameterReturnGeneral tipoterminosimporReturnGeneral=new TipoTerminosImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoterminosimpors=new ArrayList<TipoTerminosImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoterminosimpor=new TipoTerminosImpor();
				
				
				if(conColumnasBase) {this.tipoterminosimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoterminosimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoterminosimpor.setcodigo(arrColumnas[iColumn++]);
				this.tipoterminosimpor.setnombre(arrColumnas[iColumn++]);
				
				this.tipoterminosimpors.add(this.tipoterminosimpor);
			}
			
			this.saveTipoTerminosImpors();
			
			this.connexion.commit();
			
			tipoterminosimporReturnGeneral.setConRetornoEstaProcesado(true);
			tipoterminosimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoterminosimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoTerminosImporsEliminados() throws Exception {				
		
		List<TipoTerminosImpor> tipoterminosimporsAux= new ArrayList<TipoTerminosImpor>();
		
		for(TipoTerminosImpor tipoterminosimpor:tipoterminosimpors) {
			if(!tipoterminosimpor.getIsDeleted()) {
				tipoterminosimporsAux.add(tipoterminosimpor);
			}
		}
		
		tipoterminosimpors=tipoterminosimporsAux;
	}
	
	public void quitarTipoTerminosImporsNulos() throws Exception {				
		
		List<TipoTerminosImpor> tipoterminosimporsAux= new ArrayList<TipoTerminosImpor>();
		
		for(TipoTerminosImpor tipoterminosimpor : this.tipoterminosimpors) {
			if(tipoterminosimpor==null) {
				tipoterminosimporsAux.add(tipoterminosimpor);
			}
		}
		
		//this.tipoterminosimpors=tipoterminosimporsAux;
		
		this.tipoterminosimpors.removeAll(tipoterminosimporsAux);
	}
	
	public void getSetVersionRowTipoTerminosImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoterminosimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoterminosimpor.getIsDeleted() || (tipoterminosimpor.getIsChanged()&&!tipoterminosimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoterminosimporDataAccess.getSetVersionRowTipoTerminosImpor(connexion,tipoterminosimpor.getId());
				
				if(!tipoterminosimpor.getVersionRow().equals(timestamp)) {	
					tipoterminosimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoterminosimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoTerminosImpor()throws Exception {	
		
		if(tipoterminosimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoterminosimpor.getIsDeleted() || (tipoterminosimpor.getIsChanged()&&!tipoterminosimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoterminosimporDataAccess.getSetVersionRowTipoTerminosImpor(connexion,tipoterminosimpor.getId());
			
			try {							
				if(!tipoterminosimpor.getVersionRow().equals(timestamp)) {	
					tipoterminosimpor.setVersionRow(timestamp);
				}
				
				tipoterminosimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoTerminosImporsWithConnection()throws Exception {	
		if(tipoterminosimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoTerminosImpor tipoterminosimporAux:tipoterminosimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoterminosimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoterminosimporAux.getIsDeleted() || (tipoterminosimporAux.getIsChanged()&&!tipoterminosimporAux.getIsNew())) {
						
						timestamp=tipoterminosimporDataAccess.getSetVersionRowTipoTerminosImpor(connexion,tipoterminosimporAux.getId());
						
						if(!tipoterminosimpor.getVersionRow().equals(timestamp)) {	
							tipoterminosimporAux.setVersionRow(timestamp);
						}
								
						tipoterminosimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoTerminosImpors()throws Exception {	
		if(tipoterminosimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoTerminosImpor tipoterminosimporAux:tipoterminosimpors) {
					if(tipoterminosimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoterminosimporAux.getIsDeleted() || (tipoterminosimporAux.getIsChanged()&&!tipoterminosimporAux.getIsNew())) {
						
						timestamp=tipoterminosimporDataAccess.getSetVersionRowTipoTerminosImpor(connexion,tipoterminosimporAux.getId());
						
						if(!tipoterminosimporAux.getVersionRow().equals(timestamp)) {	
							tipoterminosimporAux.setVersionRow(timestamp);
						}
						
													
						tipoterminosimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoTerminosImpor tipoterminosimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoTerminosImporLogicAdditional.updateTipoTerminosImporToGet(tipoterminosimpor,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoTerminosImpor tipoterminosimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTerminosImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoterminosimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(tipoterminosimpor);
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
			this.deepLoad(this.tipoterminosimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(this.tipoterminosimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTerminosImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoterminosimpors!=null) {
				for(TipoTerminosImpor tipoterminosimpor:tipoterminosimpors) {
					this.deepLoad(tipoterminosimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(tipoterminosimpors);
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
			if(tipoterminosimpors!=null) {
				for(TipoTerminosImpor tipoterminosimpor:tipoterminosimpors) {
					this.deepLoad(tipoterminosimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoTerminosImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoTerminosImpor(tipoterminosimpors);
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
			if(TipoTerminosImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTerminosImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoTerminosImpor tipoterminosimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTerminosImporConstantesFunciones.ISCONAUDITORIA) {
				if(tipoterminosimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTerminosImporDataAccess.TABLENAME, tipoterminosimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTerminosImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTerminosImporLogic.registrarAuditoriaDetallesTipoTerminosImpor(connexion,tipoterminosimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoterminosimpor.getIsDeleted()) {
					/*if(!tipoterminosimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoTerminosImporDataAccess.TABLENAME, tipoterminosimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoTerminosImporLogic.registrarAuditoriaDetallesTipoTerminosImpor(connexion,tipoterminosimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTerminosImporDataAccess.TABLENAME, tipoterminosimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoterminosimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTerminosImporDataAccess.TABLENAME, tipoterminosimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTerminosImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTerminosImporLogic.registrarAuditoriaDetallesTipoTerminosImpor(connexion,tipoterminosimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoTerminosImpor(Connexion connexion,TipoTerminosImpor tipoterminosimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoterminosimpor.getIsNew()||!tipoterminosimpor.getcodigo().equals(tipoterminosimpor.getTipoTerminosImporOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoterminosimpor.getTipoTerminosImporOriginal().getcodigo()!=null)
				{
					strValorActual=tipoterminosimpor.getTipoTerminosImporOriginal().getcodigo();
				}
				if(tipoterminosimpor.getcodigo()!=null)
				{
					strValorNuevo=tipoterminosimpor.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTerminosImporConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoterminosimpor.getIsNew()||!tipoterminosimpor.getnombre().equals(tipoterminosimpor.getTipoTerminosImporOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoterminosimpor.getTipoTerminosImporOriginal().getnombre()!=null)
				{
					strValorActual=tipoterminosimpor.getTipoTerminosImporOriginal().getnombre();
				}
				if(tipoterminosimpor.getnombre()!=null)
				{
					strValorNuevo=tipoterminosimpor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTerminosImporConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTerminosImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTerminosImporConstantesFunciones.getClassesForeignKeysOfTipoTerminosImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTerminosImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTerminosImporConstantesFunciones.getClassesRelationshipsOfTipoTerminosImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
